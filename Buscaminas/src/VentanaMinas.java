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
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;


public class VentanaMinas extends JFrame {

	
	private JPanel contentPane;
	private Controlador controlador;
	
	private final int nivel = 1;
	private final int filas = 7;
	private final int columnas = 10;
	private final int numMinas = columnas*nivel;
	
	//private Random aleatorio;
	public Casilla casillas[][] = new Casilla [filas][columnas];
	private JPanel panelminas;
	private JPanel menusuperior;
	private JButton buttonSmiley;
	
	
	
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
	
	//PANEL MEN� SUPERIOR
	private JPanel getPanel_1() {
		if (menusuperior == null) {
			menusuperior = new JPanel();
			menusuperior.add(getButton());
		}
		return menusuperior;
	}
	
	//BOT�N SMILEY REINICIO
	private JButton getButton() {
		if (buttonSmiley == null) {
			buttonSmiley = new JButton(":)");
			buttonSmiley.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					/*VentanaMinas nueva = new VentanaMinas();
					nueva.initialize();*/
					
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
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(8, 8, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelminas(), BorderLayout.CENTER);
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		
		//(FILAS, COLUMNAS, SEPARACION X, SEPARACION Y)
		
		//
		//this.ponerMinas(numMinas);
		//
		//this.asignarNumeros();
		//
		//  GENERAR TABLERO : 
		for(int f = 0; f < filas; f++){
		      for(int c = 0; c < columnas; c++){
		      
		         casillas[f][c]= new Casilla();
		         panelminas.add(casillas[f][c]);
		         casillas[f][c].setBounds(f*40,c*40,20,20); 
		         //Medidas de las casillas. A tocar en otro momento
		         casillas[f][c].addActionListener(getControlador());
		         
		      }
		}
		
		
	} // fin inicializar
	
	
	
	
	private Controlador getControlador()
	{
		if (controlador == null)
		{
			controlador = new Controlador();
		}
		return controlador;
	}
	
	
	
	private class Controlador implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
		            System.out.println("Click con el bot�n izdo");
			       //casillas[f][c].setVisible(false); DESCUBRIR CASILLA
		          //if casilla es no descubierta ya, se puede hacer click. Si no, no!!!
			 }
			 if ((e.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
		            System.out.println("Click con el bot�n dcho"); }// NO FUNCIONA
		     
		
		}

	private void asignarNumeros() {
		// TODO Auto-generated method stub
	
	}

	/*private void ponerMinas(int pMinas) {
        pMinas = this.numMinas;
        for ( int puestas = 0; puestas <= pMinas; puestas++) 
         //coger una casilla[i][j] random, if notienemina, ponermina
         {
        	Random i = new Random(); Random j = new Random();
        	int valorFila = i.nextInt(filas);  
        	int valorColumna = j.nextInt(columnas); 
        	
        	if(casillas[valorFila][valorColumna].tieneMina == false)
        	{
        		casillas[valorFila][valorColumna].tieneMina = true;
        	}
        	else 
        	{
        		i = new Random(); j = new Random();
        	}             
             System.out.println( puestas );
             /// Y UN DO-WHILE??? SI NO PONE MINA, GENERA ALEATORIO Y PARA AH�
             
           } 
    }*/

   private boolean ganarPartida() {
        int minasDescubiertas = 0;
        for (int f = 0; f < filas; f++){
            for (int c = 0; c < columnas; c++){
                if (casillas[f][c].descubierta){
                    minasDescubiertas++;}}}
        if (minasDescubiertas == numMinas)
            {return true;}
        else
            {return false;}
    }
	
	
	
	}
}
