package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Juego;

import javax.swing.JLabel;

public class PartidaGanada extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static VentanaMinas vm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PartidaGanada dialog = new PartidaGanada(vm);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param vm 
	 */
	public PartidaGanada(VentanaMinas vm) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblHasGanadoLa = new JLabel("Has ganado la partida! BIEEEEEEEEEEEEEEEEEEEN!");
			contentPanel.add(lblHasGanadoLa);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				this.vm=vm;
				
				okButton.addMouseListener(new MouseAdapter() 
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{	
						if (e.getButton()== MouseEvent.BUTTON1)
					{		
							PartidaGanada.vm.dispose();
							VentanaMinas nueva = new VentanaMinas(Juego.nivel);					
							nueva.setVisible(true);
							PartidaGanada.this.dispose();
						}	
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
