package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import modelo.ListaGanadores;



/**
 * Controla el fichero XML para el ranking de jugadores y tiempos.
 * Es Singleton.
 *
 */

public class ControladorXML {
	
	private static ControladorXML mControladorXML = new ControladorXML();
	private String RUTA_RANKING = "ranking.xml";
	private ControladorXML(){}
	
	public static ControladorXML getControladorXML(){return mControladorXML;}
	
	
	/** 
	 *  Carga un fichero XML: el que contiene las puntuaciones anteriores (vacio al principio)
	 */
	private Document cargarFichero(String rutaRanking) throws JDOMException, IOException
	{
		SAXBuilder saxbuilder = new SAXBuilder();
		File rankingxml = new File(rutaRanking);
		return (Document) saxbuilder.build(rankingxml);
	}

	/**
	 * guardar fichero
	 */

	private void guardarFichero(Document rankingdoc, String ruta) throws FileNotFoundException, IOException{
		XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
		xmlout.output(rankingdoc, new FileOutputStream(RUTA_RANKING));
	}
	
	public ListaGanadores cargarRanking() throws JDOMException, IOException
	{
		Document docRanking = cargarFichero(RUTA_RANKING);
		List<Element> listaTodos = docRanking.getRootElement().getChildren(); 
		ListaGanadores listaGanadores = new ListaGanadores();
		for ( Object listado :  listaTodos)
		{
			Element usuario = (Element) listado;		
			listaGanadores.add(usuario.getChildText("nombre"), 
				     Integer.parseInt(usuario.getChildText("puntuacion")));
		}
		
		return listaGanadores; 
	}
	
	public void actualizarRanking(String pUsuario, int pPuntuacion) throws JDOMException, IOException{

			Document documentoXML = cargarFichero(RUTA_RANKING);
			List<Element> listaRanking = documentoXML.getRootElement().getChildren();
			int i=0;
			boolean mejor = false;
			
			if (pPuntuacion < Integer.valueOf( (listaRanking.get(listaRanking.size()-1).getChild("puntuacion").getText())))
			{	
				Iterator<Element> it = listaRanking.iterator();
				
				while (it.hasNext() && !mejor)
				{
					Element jugadorEnLaLista = it.next();
					//Si hace una puntuación mejor que las 10 que hay, entra en el ranking
					if (pPuntuacion < Integer.valueOf(jugadorEnLaLista.getChild("puntuacion").getText()))
					{
						Element nuevoGanador = new Element("top");
						nuevoGanador.addContent(new Element("nombre").setText(pUsuario));
						nuevoGanador.addContent(new Element("puntuacion").setText(String.valueOf(pPuntuacion)));
						
						listaRanking.add(i,nuevoGanador);
						
						listaRanking.remove(listaRanking.size()-1); 
						mejor = true;
					}
					i++;	
				}
				guardarFichero(documentoXML, RUTA_RANKING);
				System.out.println(pUsuario);
				System.out.println(pPuntuacion);
				
			}	
		} 	
	

}//fin class
