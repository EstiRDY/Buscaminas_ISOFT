package Controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import Vista.PartidaGanada;
import Vista.PartidaPerdida;
import Vista.VentanaAcceso;
import Vista.VentanaMinas;
import modelo.Juego;

public class ControladorJuego implements MouseListener { //y observer! 
	
	private Casilla[][]casillas;
	private static Juego juego;
	
	
	public ControladorJuego(Casilla[][] casillas)
	{
		this.juego = juego.getInstance(0);
		this.casillas = casillas;
	}

	public static boolean ganarPartida(Casilla[][]casillas, Juego juego) {

	    int casillasTotales = juego.filas*juego.columnas;
	    for (int f = 0; f < juego.filas; f++){
	        for (int c = 0; c < juego.columnas; c++){
	            if (casillas[f][c].esPulsableIzq == false){
	                casillasTotales--;}}}
	    if (casillasTotales == juego.numMinas)
	        {System.out.println("BIEEEEEEEEEEEEEEEEEEEEEN");
			 PartidaGanada bien = new PartidaGanada();
			 bien.setVisible(true);
	        
	    	return true;}
	    else
	        {return false;}
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
//Este cambio es importante y está bien
		    	casillas[i][j].esPulsableIzq=false;
		    	casillas[i][j].esPulsableDer=false;
		    }
		   }

		PartidaPerdida mal = new PartidaPerdida();
		mal.setVisible(true);
	}
	
	
	/*public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub	
	}*/

	public void mouseClicked(MouseEvent e) {
		if (e.getButton()== MouseEvent.BUTTON1 )
		{	ControladorJuego.this.ganarPartida(casillas,juego);
		    ControladorJuego.this.finJuego(casillas);
		    System.out.println("click");
		}
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Contador minas y contador banderas
	//Timer = puntuacion

}
