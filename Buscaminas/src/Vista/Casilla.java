package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Casilla extends JLabel
{
	
	private Controlador controlador;
	public boolean tieneMina = false;
	public boolean descubierta = false;
	public int contenido;
	
	
	public Casilla(String string, Icon icon)
	{
		super();
		
	}
	
	 /*private static ImageIcon createImageIcon(String path, 
		     String description) throws MalformedURLException {
		 	 URL oracle = new URL("http://universocelular.com/wp-content/uploads/2011/08/android-buscaminas.png");
		     java.net.URL imgURL = oracle;
		      
		      if (imgURL != null) { 
		         return new ImageIcon(imgURL, description);
		      } else {            
		         System.err.println("Couldn't find file: " + path);
		         return null;
		      }
		   }   */
	 
	private class Controlador implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
		            System.out.println("Click con el bot�n izdo");
		            if (Casilla.this.tieneMina==true) {System.out.println("fin del juego");}
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

