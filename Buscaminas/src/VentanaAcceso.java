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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;

public class VentanaAcceso extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblIntroduceTuNombre;
	private JTextField nombre;
	private JLabel lblEligeNivelDe;
	private JButton btnAceptar;

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
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblIntroduceTuNombre = new GridBagConstraints();
			gbc_lblIntroduceTuNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblIntroduceTuNombre.gridx = 3;
			gbc_lblIntroduceTuNombre.gridy = 1;
			panel.add(getLblIntroduceTuNombre(), gbc_lblIntroduceTuNombre);
			GridBagConstraints gbc_nombre = new GridBagConstraints();
			gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_nombre.insets = new Insets(0, 0, 5, 5);
			gbc_nombre.gridx = 3;
			gbc_nombre.gridy = 2;
			panel.add(getNombre(), gbc_nombre);
			GridBagConstraints gbc_lblEligeNivelDe = new GridBagConstraints();
			gbc_lblEligeNivelDe.insets = new Insets(0, 0, 5, 5);
			gbc_lblEligeNivelDe.gridx = 3;
			gbc_lblEligeNivelDe.gridy = 4;
			panel.add(getLblEligeNivelDe(), gbc_lblEligeNivelDe);
			GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
			gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
			gbc_btnAceptar.gridx = 3;
			gbc_btnAceptar.gridy = 7;
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
		if (nombre == null) {
			nombre = new JTextField();
			nombre.setColumns(10);
		}
		return nombre;
	}
	private JLabel getLblEligeNivelDe() {
		if (lblEligeNivelDe == null) {
			lblEligeNivelDe = new JLabel("Elige nivel de juego: (1 a 3)");
		}
		return lblEligeNivelDe;
	}
	
	//BOTÓN ACEPTAR
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					VentanaMinas juego = new VentanaMinas();
					juego.setVisible(true);
					VentanaAcceso.this.setVisible(false);
				}
			});
		}
		return btnAceptar;
	}
}//FIN CLASS
