package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class VentanaAcceso extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblIntroduceTuNombre;
	private JTextField nombre;
	private JLabel lblEligeNivelDe;
	private JButton btnAceptar;
	private JRadioButton facil;
	private JRadioButton intermedio;
	private JRadioButton dificil;
	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAcceso frame = new VentanaAcceso();
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
	public VentanaAcceso() {
		initialize();
	}
	private void initialize() {
		setTitle("Buscaminas: usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{90, 185, 0};
			gbl_panel.rowHeights = new int[]{14, 20, 0, 0, 35, 14, 23, 23, 23, 35, 23, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblIntroduceTuNombre = new GridBagConstraints();
			gbc_lblIntroduceTuNombre.insets = new Insets(0, 0, 5, 0);
			gbc_lblIntroduceTuNombre.gridx = 1;
			gbc_lblIntroduceTuNombre.gridy = 2;
			panel.add(getLblIntroduceTuNombre(), gbc_lblIntroduceTuNombre);
			GridBagConstraints gbc_nombre = new GridBagConstraints();
			gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_nombre.insets = new Insets(0, 0, 5, 0);
			gbc_nombre.gridx = 1;
			gbc_nombre.gridy = 3;
			panel.add(getNombre(), gbc_nombre);
			GridBagConstraints gbc_lblEligeNivelDe = new GridBagConstraints();
			gbc_lblEligeNivelDe.insets = new Insets(0, 0, 5, 0);
			gbc_lblEligeNivelDe.gridx = 1;
			gbc_lblEligeNivelDe.gridy = 5;
			panel.add(getLblEligeNivelDe(), gbc_lblEligeNivelDe);
			GridBagConstraints gbc_facil = new GridBagConstraints();
			gbc_facil.anchor = GridBagConstraints.WEST;
			gbc_facil.insets = new Insets(0, 0, 5, 0);
			gbc_facil.gridx = 1;
			gbc_facil.gridy = 6;
			panel.add(getFacil(), gbc_facil);
			GridBagConstraints gbc_intermedio = new GridBagConstraints();
			gbc_intermedio.anchor = GridBagConstraints.SOUTHWEST;
			gbc_intermedio.insets = new Insets(0, 0, 5, 0);
			gbc_intermedio.gridx = 1;
			gbc_intermedio.gridy = 7;
			panel.add(getIntermedio(), gbc_intermedio);
			GridBagConstraints gbc_dificil = new GridBagConstraints();
			gbc_dificil.anchor = GridBagConstraints.NORTHWEST;
			gbc_dificil.insets = new Insets(0, 0, 5, 0);
			gbc_dificil.gridx = 1;
			gbc_dificil.gridy = 8;
			panel.add(getDificil(), gbc_dificil);
			GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
			gbc_btnAceptar.gridx = 1;
			gbc_btnAceptar.gridy = 10;
			panel.add(getBtnAceptar(), gbc_btnAceptar);
		}
		return panel;
	}
	private JLabel getLblIntroduceTuNombre() {
		if (lblIntroduceTuNombre == null) {
			lblIntroduceTuNombre = new JLabel("Introduce tu nombre:");
		}
		return lblIntroduceTuNombre;
	}
	
	//TEXTFIELD NOMBREUSUARIO
	private JTextField getNombre() {
		if (nombre == null) 
		{
			nombre = new JTextField();
			nombre.setColumns(10);
		}
		else 
		{
			nombre.setText("desconocido");
		}
		//System.out.println(nombre.getText());
		return nombre;
	}
	private JLabel getLblEligeNivelDe() {
		if (lblEligeNivelDe == null) {
			lblEligeNivelDe = new JLabel("Elige nivel de juego:");
		}
		return lblEligeNivelDe;
	}
	
	
	//BOTÓN ACEPTAR
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (buttonGroup.getSelection()== null)
						JOptionPane.showMessageDialog(null, "Selecciona una dificultad!");
					else
					{		 	
					
					 VentanaMinas juego = new VentanaMinas();
					 juego.setVisible(true);
					 VentanaAcceso.this.setVisible(false);
				}
				}}
			);
		}
		return btnAceptar;
	}
	
	//BUTTONGROUP
	private JRadioButton getFacil() {
		if (facil == null) {
			facil = new JRadioButton("F\u00E1cil");
			buttonGroup.add(facil);
		}
		return facil;
	}
	private JRadioButton getIntermedio() {
		if (intermedio == null) {
			intermedio = new JRadioButton("Intermedio");
			buttonGroup.add(intermedio);
		}
		return intermedio;
	}
	private JRadioButton getDificil() {
		if (dificil == null) {
			dificil = new JRadioButton("Dif\u00EDcil");
			buttonGroup.add(dificil);
		}
		return dificil;
	}
}//FIN CLASS
