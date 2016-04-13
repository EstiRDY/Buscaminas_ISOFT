package Controlador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.Juego;




public class Casilla extends JButton //extends Observable
{

	public boolean descubierta = false;
	public boolean estaMinada = false;
	private Controlador controlador; 
	public int minasAlrededor;
	public boolean esPulsableIzq = true;
	public boolean esPulsableDer = true;
	public boolean banderaPuesta = false;
	public int columna;
	public int fila;
	MouseEvent e;
	private ImageIcon bandera = new ImageIcon("img/bandera.jpg");
	private ImageIcon mina = new ImageIcon("img/mina2.jpg");

	public Casilla(String text, Icon icon) {
		super();
		/*setChanged();
		notifyObservers();*/
		
	}
	public int getColumna() {
		return this.columna;
	}

	public int getFila() {
		return this.fila;
	}
	


	public void pulsar(){
		//Si no tiene icono
		if(this.getIcon()== null && this.estaMinada == false)
			
		{
			if (minasAlrededor > 0) {
					setText(String.valueOf(minasAlrededor));	
			 } 
			
			else { //Minas alrededor = 0
				this.setText("");
				this.revelarAlrededor(this.fila, this.columna);
			}
			 
			this.setBackground(Color.white);
			//Casilla.this.setFont(font);
			this.esPulsableIzq = false;
			this.esPulsableDer = false;	
		}
		
 		//Si tiene icono mina	
		if(this.estaMinada){ 
			this.esPulsableIzq = false;
			this.esPulsableDer = false;
			this.setIcon(mina);
			Juego juego = Juego.getInstance(0);
			ControladorJuego ctrl = juego.addControlador();
			Casilla[][] matriz = juego.getCasillas(); //mirar
			System.out.println(ctrl); //correcto!
			ctrl.finJuego(matriz);
		}
		
	}
	
	
	public void revelarAlrededor(int pFila, int pColumna)
	{ 	Juego juego = Juego.getInstance(0);  //FUNCIONA con cualquier nivel!
		Casilla[][] matriz = juego.getCasillas();
		
		//Esto vale sólo para las casillas del medio y sólo cuando 
		//llaman a otras casillas del medio.
		for (int f = pFila-1; f <= pFila+1; f++){
	        for (int c = pColumna-1; c <= pColumna+1; c++){
	        	System.out.println("Fila: "+f+" y Columna: "+c);
	        	
	        	/*if (matriz[f][c].esPulsableIzq && !matriz[f][c].descubierta){
		        	matriz[f][c].pulsar(); 
		        	if (matriz[f][c].minasAlrededor==0){
		        	matriz[f][c].revelarAlrededor(f,c);
	        	}*/
	        	}
	        }
	    }
		

		
	
	private class Controlador implements MouseListener{

		
		public void mouseClicked(MouseEvent e) {//Si no ha sido pulsadaIzq
			if (e.getButton()== MouseEvent.BUTTON1 && Casilla.this.esPulsableIzq == true )
			{	
				Casilla.this.pulsar();
				}
				
			
			//Pulsar derecho
			if (e.getButton() == MouseEvent.BUTTON3 && Casilla.this.esPulsableDer == true)
			{
				
				if(Casilla.this.getIcon()== null){
				
				Casilla.this.setIcon(bandera);
				Casilla.this.esPulsableIzq = false;
				Casilla.this.banderaPuesta = true;
				}
				
				else
				{
					Casilla.this.setIcon(null);
					Casilla.this.esPulsableIzq = true;
					Casilla.this.banderaPuesta = false;
				}
			} }

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

			
		}//fin controlador
	
	public MouseListener getControlador(){
		if (controlador == null)
		{
			controlador = new Controlador();
		}
		return controlador;
	}
}
	