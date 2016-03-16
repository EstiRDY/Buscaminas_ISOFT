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
	private int minasAlrededor;
	public boolean esPulsable = true;
	
	
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

	
	private class Controlador implements MouseListener{

		
		public void mouseClicked(MouseEvent e) { //Si no ha sido pulsadaIzq
			if (e.getButton()== MouseEvent.BUTTON1 && Casilla.this.esPulsable == true)
			{	//Si no tiene icono
				if(Casilla.this.getIcon()== null)
				{
				 if (Casilla.this.minasAlrededor > 0) {
						Casilla.this.setText(String.valueOf(minasAlrededor));
				 } 
				
				else {Casilla.this.setText("");	}
				 
				System.out.println("click izq");
				Casilla.this.setBackground(Color.white);
				//Casilla.this.setFont(font);
				Casilla.this.esPulsable = false;
					
				}
		 		//Si tiene mina	
				if(Casilla.this.estaMinada){System.out.println("TieneMina"); }
				}
				
			
			//Pulsar derecho
			if (e.getButton() == MouseEvent.BUTTON3)
			{
				if(Casilla.this.getIcon()==null){
					//Posteriormente meter imagen de la bandera
				Casilla.this.setIcon(new ImageIcon ("img/mina.jpg"));
				}
				else{
					Casilla.this.setIcon(null);
				}
				System.out.println("click dch");
				
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

			
		}//fin controlador
	
	public MouseListener getControlador(){
		if (controlador == null)
		{
			controlador = new Controlador();
		}
		return controlador;
	}
}
	