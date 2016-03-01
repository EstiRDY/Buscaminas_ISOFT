import javax.swing.JButton;

public class Casilla extends JButton
{
	public boolean tieneMina = false;
	public boolean descubierta = false;
	public int contenido;
	
	public Casilla()
	{
		super(); //Constructor de JButton
	}
	
	public int[][] getPosicion()
	{ 
		return null ;
	}
}

