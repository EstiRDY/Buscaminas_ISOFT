package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.ControladorTimer;
import Controlador.ControladorXML;

public class ControladorTimerTest {

	@Test
	public void testGetTimer() {
		assertNotNull(ControladorTimer.getControladorTimer());
	}
	
	@Test
	public void testCrearControlador() {
		ControladorTimer nuevo = new ControladorTimer();
	    assertNotNull(nuevo);
	}
	
	@Test
	public void testPausar(){
		try{
		ControladorTimer.getControladorTimer().pausar();
		}catch(Exception e){ System.out.println("error");}
	}
}
