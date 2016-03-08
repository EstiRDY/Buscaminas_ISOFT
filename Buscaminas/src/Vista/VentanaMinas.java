package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;


public class VentanaMinas extends JFrame implements Observer {

	
	private JPanel contentPane;
	
	
	
	
	//private Random aleatorio;
	
	public static JPanel panelminas;
	private JPanel menusuperior;
	private JButton buttonSmiley;
	
	public final static int nivel = 1;
	public final static int filas = 7;
	public final static int columnas = 10;
	public final static int numMinas = columnas*nivel;
	
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
		if (panelminas == null) {
			panelminas = new JPanel();
			panelminas.setLayout(new GridLayout(filas, columnas, 0, 0));
			
		}
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
					VentanaMinas nueva = new VentanaMinas();
					nueva.initialize();
					nueva.setVisible(true);
					VentanaMinas.this.setVisible(false);
//-------HACE COSAS RARAS!!!!!!!!!!! Duplica columnas			
					
				}
			});
		}
		return buttonSmiley;
	}
	
	
	//CONSTRUCTOR VENTANAMINAS
	public VentanaMinas() 
	{
	 initialize();
	}
	
	
	//INICIALIZAR VENTANA
	private void initialize() 
	{
		
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, columnas*40, filas*40);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 8, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelminas(), BorderLayout.CENTER);
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		
		//
		//this.ponerMinas(numMinas);
		//
		//this.asignarNumeros();
		//
		//
		
		
		
	} // fin inicializar
	
@Override
public void update(Observable Juego, Object arg) {
	// TODO Auto-generated method stub
	
}
	
	
	
	}
