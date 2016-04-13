package Controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import modelo.Juego;

public class ControladorJuego implements MouseListener { //y observer! 
	
	private Casilla[][]casillas;
	private static Juego juego;
	
	
	public ControladorJuego(Casilla[][] casillas)
	{
		this.juego = juego.getInstance(0);
		this.casillas = casillas;
	}

	private boolean ganarPartida(Casilla[][]casillas, Juego juego) {

	    int casillasTotales = juego.filas*juego.columnas;
	    for (int f = 0; f < juego.filas; f++){
	        for (int c = 0; c < juego.columnas; c++){
	            if (casillas[f][c].descubierta == true){
	                casillasTotales--;}}}
	    if (casillasTotales == juego.numMinas)
	        {return true;}
	    else
	        {return false;}
	}
	
	
	public static void finJuego (Casilla casillas[][])
	{	//No es necesario "if está minada" porque solo lo invoca un click en una mina
		for(int i=0;i<Juego.filas;i++){
		    for(int j=0;j<Juego.columnas;j++){ 
		    	//el bucle lo hace bien,recorre todas las casillas
		    	if(casillas[i][j].estaMinada==true&&casillas[i][j].descubierta==false)
		    	{
		    		casillas[i][j].descubierta=true;
		    		//casillas[i][j].setBackground(Color.red); total no se ve...
		    		casillas[i][j].pulsar();
		    	}
		    }
		   }

		//System.out.println("game over :(");
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
