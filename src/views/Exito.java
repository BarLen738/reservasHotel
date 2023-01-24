package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Exito extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			LLAMADA AL MÉTODO
			Exito dialog = new Exito();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
//	MÉTODO CREAR CUADRO DE DIÁLOGO OK
	public Exito() {
		setFont(new Font("Georgia", Font.PLAIN, 12));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/Logo40.png")));
		setBounds(100, 100, 394, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 240, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/logo-bonsai__100_-removebg-preview.png")));
			lblNewLabel.setBounds(123, 11, 100, 100);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente");
			lblNewLabel_1.setForeground(new Color(51, 102, 51));
			lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 16));
			lblNewLabel_1.setBounds(27, 122, 322, 21);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ok");
				okButton.setFont(new Font("Georgia", Font.PLAIN, 11));
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
//						CERRAR LA VENTANA ACTUAL
						dispose();
						MenuUsuario usuario = new MenuUsuario(); 
						usuario.setVisible(true);
					}
				});
				okButton.setActionCommand("Ok");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Georgia", Font.PLAIN, 11));
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}
}
