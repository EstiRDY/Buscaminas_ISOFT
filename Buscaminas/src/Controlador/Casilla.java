package Controlador;
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

		
		public void mouseClicked(MouseEvent e) {
			if (e.getButton()== MouseEvent.BUTTON1)
			{
				System.out.println("click izq");
				Casilla.this.setVisible(false);
			}
			
			if (e.getButton() == MouseEvent.BUTTON3)
			{
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
	