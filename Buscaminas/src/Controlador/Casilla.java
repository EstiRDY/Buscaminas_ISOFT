package Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Vista.VentanaMinas;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;



public class Casilla extends JButton //extends Observable
{

	public boolean descubierta = false;
	public boolean estaMinada = false;
	private Controlador controlador; 
	public int minasAlrededor;
	public boolean esPulsableIzq = true;
	public boolean esPulsableDer = true;
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
	public void addListener(InvalidationListener listener) {// TODO Auto-generated method stub
	
	}

	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}


	public void pulsar(){
		//Si no tiene icono
		if(this.getIcon()== null)
			System.out.println(this.fila);
		{
		if (minasAlrededor > 0) {
				setText(String.valueOf(minasAlrededor));	
		 } 
		
		else {
			this.setText("");
		}
		 
		this.setBackground(Color.white);
		//Casilla.this.setFont(font);
		this.esPulsableIzq = false;
		this.esPulsableDer = false;	
		}
 		//Si tiene mina	
		if(this.estaMinada){ 
			this.esPulsableIzq = false;
			this.esPulsableDer = false;
			this.setIcon(mina);
			//Juego.finJuego(casillas);
		}
		if(this.minasAlrededor==0){
			//Juego.revelarAlrededor(casillas, this);
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
				if(Casilla.this.getIcon()==null){
				
				Casilla.this.setIcon(bandera);
				Casilla.this.esPulsableIzq = false;
				}
				
				else
				{
					Casilla.this.setIcon(null);
					Casilla.this.esPulsableIzq = true;
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
	