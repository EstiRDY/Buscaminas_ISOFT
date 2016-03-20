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
	//private int columna;
	//private int fila;
	MouseEvent e;
	
	public Casilla(String text, Icon icon) {
		super();
		/*setChanged();
		notifyObservers();*/
		
	}

	public void addListener(InvalidationListener listener) {// TODO Auto-generated method stub
	
	}

	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	/*public void setPosicion()
	{
		this.fila = Juego.getFila(this);
		this.columna = Juego.getColumna(this);
	}*/

	public void pulsar(MouseEvent e){//Si no ha sido pulsadaIzq
		if (e.getButton()== MouseEvent.BUTTON1 && Casilla.this.esPulsableIzq == true )
		{	
			//Si no tiene icono
			if(Casilla.this.getIcon()== null)
			{
			if (Casilla.this.minasAlrededor > 0) {
					Casilla.this.setText(String.valueOf(minasAlrededor));
					//Casilla.this.setPosicion();
					//System.out.println(Casilla.this.fila);
			 } 
			
			else {
				Casilla.this.setText(""); //CAMBIOS
				/*Casilla.this.setPosicion();
				for(int i=0; i<this.fila;i++)
				{ for(int c =0; c<this.columna;c++){
					this.pulsar(e);
					}
				}*/
				
			}
			 
			Casilla.this.setBackground(Color.white);
			//Casilla.this.setFont(font);
			Casilla.this.esPulsableIzq = false;
			Casilla.this.esPulsableDer = false;	
			}
	 		//Si tiene mina	
			if(Casilla.this.estaMinada){System.out.println("TieneMina"); 
			//tiene que acabar el juego!!!! 
			}
			}
			
		
		//Pulsar derecho
		if (e.getButton() == MouseEvent.BUTTON3 && Casilla.this.esPulsableDer == true)
		{
			if(Casilla.this.getIcon()==null){
			ImageIcon bandera = new ImageIcon("img/bandera.jpg");
			Casilla.this.setIcon(bandera);
			Casilla.this.esPulsableIzq = false;
			}
			
			else
			{
				Casilla.this.setIcon(null);
				Casilla.this.esPulsableIzq = true;
			}
		}}
	
	private class Controlador implements MouseListener{

	
		public void mouseClicked(MouseEvent e) { Casilla.this.pulsar(e);}

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
	