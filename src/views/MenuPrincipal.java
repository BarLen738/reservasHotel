package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

//	ATRIBUTOS
	
	private JPanel contentPane;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	
//	MÉTODOS
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
//			EJECUTAR
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	
//	CREAR MENÚ PRINCIPAL
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/persona.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		
		Panel panel = new Panel();
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(0, 0, 910, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setBounds(-50, 0, 732, 501);
		imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/reception.png")));
		panel.add(imagenFondo);
		
		JLabel Logo = new JLabel("");
		Logo.setBounds(722, 80, 150, 156);
		Logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/logo-bonsai__150_-removebg-preview.png")));
		panel.add(Logo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 910, 37);
		panel_1.setBackground(new Color(51, 102, 51));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCopyR = new JLabel("Desarrollado por BarbarElla Codea© 2023");
		lblCopyR.setBounds(315, 11, 362, 19);
		lblCopyR.setForeground(new Color(240, 248, 255));
		lblCopyR.setFont(new Font("Georgia", Font.PLAIN, 16));
		panel_1.add(lblCopyR);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(new Color(240, 255, 240));
		panel.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(new Color(51,102,51));
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(new Color(240,255,240));
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("");
		labelExit.setBackground(new Color(240, 255, 240));
		labelExit.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/cerrar-24px.png")));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Georgia", Font.PLAIN, 18));
		
		JPanel btnLogin = new JPanel();
		btnLogin.setBounds(754, 300, 83, 70);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		panel.add(btnLogin);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/iniciar-sesion.png")));
		
		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setBounds(754, 265, 83, 24);
		lblTitulo.setBackground(SystemColor.window);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(51, 102, 51));
		lblTitulo.setFont(new Font("Georgia", Font.PLAIN, 20));
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
}
}
