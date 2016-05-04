package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorTimer;
import modelo.Juego;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;


public class VentanaMinas extends JFrame implements Observer {

	
	private JPanel contentPane;
	private JPanel panelminas;
	private JPanel menusuperior;
	private JButton buttonSmiley;
	private static JLabel contadorMinas;
	private static JLabel temporizador;
	
	private static Juego juego;
	private static int nivel;
	
    private static ControladorTimer controlador =  ControladorTimer.getControladorTimer();
    
    private static ImageIcon bandera = new ImageIcon("img/bandera.jpg");
	private static ImageIcon mina = new ImageIcon("img/mina2.jpg");
    
    public static ImageIcon getBandera() {
		return bandera;
	}


    
	public static ImageIcon getMina() {
		return mina;
	}

	public static int getNivel() {
		return nivel;
	}

	private ImageIcon smiley = new ImageIcon("img/smiley.jpg");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMinas frame = new VentanaMinas(nivel);
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
		if (panelminas == null)
		{
			panelminas = new JPanel();
			//ESTO HAY QUE ARREGLAAAARLO!!
			panelminas.setLayout(new GridLayout(juego.filas, juego.columnas, 0, 0));
		}
		return panelminas;
	}
	
	
	//PANEL MENÚ SUPERIOR
	private JPanel getPanel_1() {
		if (menusuperior == null) {
			menusuperior = new JPanel();
			
			
			
			GridBagConstraints gbc_lblIntroduceTuNombre = new GridBagConstraints();
			gbc_lblIntroduceTuNombre.insets = new Insets(0, 0, 5, 0);
			gbc_lblIntroduceTuNombre.gridx = 1;
			gbc_lblIntroduceTuNombre.gridy = 2;
			
			menusuperior.add(getcontadorMinas(), gbc_lblIntroduceTuNombre);
			menusuperior.add(getButton());
			menusuperior.add(getTemporizador(), gbc_lblIntroduceTuNombre);
			
		}
		return menusuperior;
	}
	public static JLabel getTemporizador() {
		if (temporizador == null) {
			temporizador = new JLabel("Temporizador");

		}
		return temporizador;
	}



	public static JLabel getcontadorMinas() {
		if (contadorMinas == null) {
			contadorMinas = new JLabel("Minas");
			contadorMinas.setText(String.valueOf(Juego.getInstance(0).numMinas));
			Juego.getInstance(0).clickDerechos=Juego.getInstance(0).numMinas;
		}
		return contadorMinas;
	}
	
	//BOTÓN SMILEY REINICIO
	private JButton getButton() 
	{
		if (buttonSmiley == null) {
			buttonSmiley = new JButton("");
			//buttonSmiley.setBounds(10, 150, 50, 50);
			buttonSmiley.addMouseListener(new MouseAdapter() 
			{
				@Override
				public void mouseClicked(MouseEvent e) 
				{	
					if (e.getButton()== MouseEvent.BUTTON1)
				{	
						VentanaMinas nueva = new VentanaMinas(nivel);
						nueva.setVisible(true);
						VentanaMinas.this.dispose();
						//
						contadorMinas.setText(String.valueOf(Juego.getInstance(0).numMinas));
						Juego.getInstance(0).clickDerechos=Juego.getInstance(0).numMinas;
						//temporizador se pone a 0:
						ControladorTimer.getControladorTimer().setFreeze(false);
						ControladorTimer.getControladorTimer().setContador(-1);
						
						
						
					}	
				}
			});
		}
		buttonSmiley.setIcon(smiley);
		return buttonSmiley;
	}
	
	

	public VentanaMinas(int pNivel) 
	{
	 this.nivel=pNivel;
	 this.juego=juego.getInstance(pNivel);
	 this.juego.addControlador(VentanaMinas.this); 
	 initialize();
	controlador.addObserver(this);
	update(null,null);
	}
	
	private void initialize() 
	{
		
		setTitle("Buscaminas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, juego.columnas*50, juego.filas*50);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 8, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelminas(), BorderLayout.CENTER);
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		juego.hacerMatriz(panelminas);
		
		
	}// fin initialize
	
public void update(Observable o, Object arg) {	 
	getTemporizador().setText(String.valueOf(controlador.getContador()));
}
	
	}
