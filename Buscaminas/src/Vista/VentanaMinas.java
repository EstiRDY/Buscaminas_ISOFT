package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Casilla;
import Controlador.Juego;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;


public class VentanaMinas extends JFrame implements Observer {

	
	private JPanel contentPane;
	
	public static JPanel panelminas;
	private JPanel menusuperior;
	private JButton buttonSmiley;
	
	public static Juego juego =  new Juego(1);
	
	private static Casilla casillas[][] = new Casilla [juego.filas][juego.columnas];

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMinas frame = new VentanaMinas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//PANEL PRINCIPAL MINAS
	private JPanel getPanelminas() {
		//if (panelminas == null) {}
		panelminas = new JPanel();
		panelminas.setLayout(new GridLayout(juego.filas, juego.columnas, 0, 0));
		return panelminas;
	}
	
	
	//PANEL MENÚ SUPERIOR
	private JPanel getPanel_1() {
		if (menusuperior == null) {
			menusuperior = new JPanel();
			menusuperior.add(getButton());
		}
		return menusuperior;
	}
	
	//BOTÓN SMILEY REINICIO
	private JButton getButton() 
	{
		if (buttonSmiley == null) {
			buttonSmiley = new JButton(":)");
			buttonSmiley.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) 
				{	
					//Juego juegoNuevo = new Juego(1);
					VentanaMinas nueva = new VentanaMinas();
					nueva.setVisible(true);
					VentanaMinas.this.dispose();
						
				}
			});
		}
		return buttonSmiley;
	}
	
	

	public VentanaMinas() 
	{
	 initialize();
	}
	
	private void initialize() 
	{
		
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, juego.columnas*100, juego.filas*100);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 8, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelminas(), BorderLayout.CENTER);
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		
		
		for(int f = 0; f < juego.filas; f++){
			  for(int c = 0; c < juego.columnas; c++){
		         casillas[f][c]= new Casilla("num", null);		         
		         panelminas.add(casillas[f][c]);
		         //casillas[f][c].setBounds(f*10, c*10, 40, 40);
		         casillas[f][c].addMouseListener(casillas[f][c].getControlador());
		         
		        //System.out.println(c); 
		      }
		     // System.out.println(f);  
		 } // fin for
		juego.ponerMinas(juego.numMinas,casillas);
		juego.contarAlrededor(casillas);
	}// fin initialize
	
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}

	
	
	}
