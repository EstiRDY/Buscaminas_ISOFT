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
 * Controla el fichero XML para el ranking de jugadores y puntuaciones.
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
		File fichRanking = new File(rutaRanking);
		return (Document) saxbuilder.build(fichRanking);
	}

	/**
	 * guardar fichero
	 */

	private void guardarFichero(Document doc, String ruta) throws FileNotFoundException, IOException{
		XMLOutputter xmlout = new XMLOutputter(Format.getPrettyFormat());
		xmlout.output(doc, new FileOutputStream(RUTA_RANKING));
	}
	
	/**
	 * Carga el ranking del fichero XML y lo actualiza incluyendo a la lista el ganador actual
	 *
	 * @param usuario el nombre del usuario
	 * @param puntuacion la puntuacion del usuario
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public void actualizarRanking(String pUsuario, int pPuntuacion) throws JDOMException, IOException{
		
		if (pUsuario == null || pUsuario == "")
			throw new IllegalArgumentException();
	
		
			Document documentoXML = cargarFichero(RUTA_RANKING);
			List<Element> listaRanking = documentoXML.getRootElement().getChildren();
			int index=0;
			boolean listaModificada = false;
			//No entra en el IF con ">"
			if ( pPuntuacion < Integer.valueOf( (listaRanking.get(listaRanking.size()-1).getChild("puntuacion").getText()) ) )
			{	
				Iterator<Element> it = listaRanking.iterator();
				
				while (it.hasNext() && !listaModificada)
				{
					Element jugadorEnLaLista = it.next();
					
					if (pPuntuacion < Integer.valueOf(jugadorEnLaLista.getChild("puntuacion").getText()))
					{
						Element nuevoElemento = new Element("top");
						nuevoElemento.addContent(new Element("nombre").setText(pUsuario));
						nuevoElemento.addContent(new Element("puntuacion").setText(String.valueOf(pPuntuacion)));
						
						listaRanking.add(index, nuevoElemento);
						
						listaRanking.remove(listaRanking.size()-1); 
						//el Ranking es de 10 jugadores, si meto uno nuevo, la lista es de 11...
						//y debo borrar el ultimo de la lista
						listaModificada = true;
					}
					index++;
		
				}
				guardarFichero(documentoXML, RUTA_RANKING);
				System.out.println(pUsuario);
				System.out.println(pPuntuacion);
				
			}	
		} 	
	
	
	/**
	 * Genera la List<T> que forma parte de la estructura Ranking.XML
	 * 
	 * @param docRanking
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public ListaGanadores cargarRanking() throws JDOMException, IOException
	{
		Document docRanking = cargarFichero(RUTA_RANKING);
		List<Element> listaTuplasRanking = docRanking.getRootElement().getChildren(); //obtengo la lista de elementos
		ListaGanadores listaPos = new ListaGanadores(); //creo la lista
		
		//para cada objeto de la listaTuplaRanking...
		for ( Object listado :  listaTuplasRanking)
		{
			Element tupla = (Element) listado; //convierto el objeto a tipo Element			
			listaPos.add(tupla.getChildText("nombre"), 
				     Integer.parseInt(tupla.getChildText("puntuacion")));
		}
		
		return listaPos; //con la lista cargada en memoria, devuelvo la lista
	}
}//fin class
