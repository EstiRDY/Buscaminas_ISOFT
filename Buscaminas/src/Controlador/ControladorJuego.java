package Controlador;

import java.io.IOException;

import org.jdom2.JDOMException;

import Vista.PartidaGanada;
import Vista.PartidaPerdida;
import Vista.VentanaMinas;
import modelo.Ganador;
import modelo.Juego;


public class ControladorJuego  { 
	
	private Casilla[][]casillas;
	private static Juego juego;
	private static boolean evento = false;
	private static VentanaMinas vm;
	
	
	public static boolean isEvento() {
		return evento;
	}

	public ControladorJuego(Casilla[][] casillas, VentanaMinas ventanaMinas)
	{
		this.juego = juego.getInstance(0);
		this.casillas = casillas;
		this.vm=ventanaMinas;
	}

	public static boolean ganarPartida(Casilla[][]casillas, Juego juego) {

	    int casillasTotales = juego.filas*juego.columnas;
	    for (int f = 0; f < juego.filas; f++){
	        for (int c = 0; c < juego.columnas; c++){
	            if (casillas[f][c].descubierta==true){
	                casillasTotales--;}}}
	    
	    if (casillasTotales == juego.numMinas)
	        {
			 PartidaGanada bien = new PartidaGanada(vm);
			 bien.setVisible(true);
			ControladorTimer.pausar();
			Ganador actual = new Ganador(Juego.getInstance(0).nombreJugador,ControladorTimer.getControladorTimer().getTiempoFinal());
			ControladorXML mGestorFicherosXML = ControladorXML.getControladorXML();
			try {
				mGestorFicherosXML.actualizarRanking(actual.getNombre(),actual.getSegundos());

			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	 return evento = true;}
	    else
	        {return evento = false;}
	}
	
	
	public static void finJuego (Casilla casillas[][])
	{	
		for(int i=0;i<Juego.filas;i++){
		    for(int j=0;j<Juego.columnas;j++){ 	    	
		    	if(casillas[i][j].estaMinada==true&&casillas[i][j].esPulsableIzq==true)
		    	{
		    		casillas[i][j].esPulsableIzq=false;
		    		casillas[i][j].revelarMina();
		    	}

		    	casillas[i][j].esPulsableIzq=false;
		    	casillas[i][j].esPulsableDer=false;
		    }
		   }
		evento = true;
		ControladorTimer.pausar();
		PartidaPerdida mal = new PartidaPerdida();
		mal.setVisible(true);
	}


}
