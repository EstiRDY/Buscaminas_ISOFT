package Vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.ControladorTimer;
import Controlador.ControladorXML;
import modelo.Ganador;
import modelo.ListaGanadores;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRanking extends JFrame{

	JFrame frame;
	JPanel panelRanking;
	
	public VentanaRanking()
	{
		initialize();
		
	}
	
	
	private void initialize() {
	
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension tamano = tk.getScreenSize();
		frame = new JFrame("Ranking Buscaminas");
		panelRanking = new JPanel();
		panelRanking.setLayout(new GridLayout(11, 2,0,0));
		panelRanking.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
		setTitle("Ranking Top 10");
		
		JButton btnCerrarRanking = new JButton("Volver a jugar");
		btnCerrarRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorTimer.getControladorTimer().setFreeze(false);
				ControladorTimer.getControladorTimer().setContador(-1);
				VentanaRanking.this.dispose();
			}
		});
		btnCerrarRanking.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCerrarRanking.setHorizontalTextPosition(SwingConstants.CENTER);
		getContentPane().add(btnCerrarRanking, BorderLayout.SOUTH);
		JLabel cabeceraNombre = new JLabel("Nombre"), cabeceraPuntuacion = new JLabel("Segundos");	
		panelRanking.add(cabeceraNombre,0);
		panelRanking.add(cabeceraPuntuacion,1);
		
		ListaGanadores xml;
		try {
			xml = ControladorXML.getControladorXML().cargarRanking();
			Iterator<Ganador> it = xml.getIterator();	
			while (it.hasNext())
			{
				Ganador ganador = it.next();
				JLabel lblNombre = new JLabel(ganador.getNombre());
				JLabel lblPuntuacion = new JLabel(String.valueOf(ganador.getSegundos()));
				panelRanking.add(lblNombre);
				panelRanking.add(lblPuntuacion);
			}
			
			
		} catch (Exception e) {}
		finally{
			getContentPane().add(panelRanking);
			setSize(250,400);
			setBounds(tamano.width/2-getWidth()/2, tamano.height/2-getHeight()/2, 250, 400);
			    
			setResizable(false);
			setVisible(true);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
		}
		
	}
	
}
