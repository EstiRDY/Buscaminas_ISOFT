package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jdom2.JDOMException;
import org.junit.Test;
import Controlador.ControladorXML;
import modelo.ListaGanadores;



public class ControladorXMLTest {

	@Test
	public void testHayControlador() {
		assertNotNull(ControladorXML.getControladorXML());
	}
	
	@Test
	public void testCargarRanking() {
		try {
			assertNotNull(ControladorXML.getControladorXML().cargarRanking());
		} catch (Exception e) { System.out.println("error");}
	}
	
	@Test
	public void testHayGanadores() {
		try {
			ListaGanadores listaNueva = new ListaGanadores();
			assertNotNull(listaNueva);
		} catch (Exception e) { System.out.println("error");}
	}
	
	@Test
	public void testActualizarRanking() {
		try {
			ControladorXML.getControladorXML().actualizarRanking("Prueba", 5);
		} catch (JDOMException e) { System.out.println("error"); }
		  catch (IOException e) { System.out.println("error"); 	}
	}
}
