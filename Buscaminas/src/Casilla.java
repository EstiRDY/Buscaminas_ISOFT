import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.Icon;
import javax.swing.JButton;



public class Casilla extends JButton
{
	
	private Controlador controlador;
	public boolean tieneMina = false;
	public boolean descubierta = false;
	public int contenido;
	
	public Casilla(String text, Icon icon)
	{
		super(); //Constructor de JButton
		//Versi�n anterior: constructor sin params.
	}
	
	public int[][] getPosicion()
	{ 
		return null ;
	}
	

	
	
	private class Controlador implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
		            System.out.println("Click con el bot�n izdo");
			       Casilla.this.setVisible(false); //descubrir casilla
		          //if casilla es no descubierta ya, se puede hacer click. Si no, no!!!
			 }
			 if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
		            System.out.println("Click con el bot�n dcho"); }// NO FUNCIONA
		     
		
		}
}

	public ActionListener getControlador() {
		if (controlador == null)
		{
			controlador = new Controlador();
		}
		return controlador;
		
	}
}

