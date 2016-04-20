package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;


/**
 * Controla el fichero XML para el ranking de jugadores y puntuaciones.
 * Es Singleton.
 *
 */
public class ControladorXML {
	
	private static ControladorXML mControladorXML = new ControladorXML();
	private String RUTA_RANKING = "files/ranking.xml";
	
	private ControladorXML(){}
	public static ControladorXML getControladorXML(){return mControladorXML;}
	
	
	/** 
	 *  Carga un fichero XML.  
	 */
	private Document cargarFichero(String rutaRanking) throws JDOMException, IOException
	{
		SAXBuilder saxbuilder = new SAXBuilder();
		File fichRanking = new File(rutaRanking);
		return (Document) saxbuilder.build(fichRanking);
	}

	
}//fin class
