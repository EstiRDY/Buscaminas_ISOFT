package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Vista.VentanaMinas;
import modelo.Juego;

public class ControladorJuegoTest {

	@Test
	public void testGetInstance() {
		assertNotNull(Juego.getInstance(0));
		assertNotNull(Juego.getInstance(1));
		assertNotNull(Juego.getInstance(2));
		assertNotNull(Juego.getInstance(3));
		}
	
	@Test
	public void testControladorJuego() {
		VentanaMinas ventanaMinas = new VentanaMinas(1);
		assertNotNull(Juego.getInstance(0).addControlador(ventanaMinas));
	}

	@Test
	public void testGetCasillas(){
		assertNotNull(Juego.getInstance(3).getCasillas());
	}

}
