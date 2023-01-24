package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

//	ATRIBUTOS
	
	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegistro;

	/**
	 * Launch the application.
	 */
	
	
//	MÉTODOS
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
//			EJECUTAR
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	
//	CREAR MENÚ USUARIO
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/Logo40.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(51, 102, 51));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(50, 58, 150, 150);
		panelMenu.add(logo);
		logo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/logo-bonsai__150_-removebg-preview.png")));
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(0, 51, 18));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(51, 102, 51));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(51, 102, 51));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelRegistro = new JLabel("Registro de reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegistro.setForeground(SystemColor.text);
		labelRegistro.setBounds(25, 11, 205, 34);
		labelRegistro.setFont(new Font("Georgia", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(labelRegistro);
		
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(0, 51, 18));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(51, 102, 51));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(0, 312, 257, 56);
		btnBuscar.setBackground(new Color(51, 102, 51));
		panelMenu.add(btnBuscar);
		btnBuscar.setLayout(null);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblBusquedaDeReservas = new JLabel("Búsqueda");
		lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblBusquedaDeReservas.setBounds(27, 11, 200, 34);
		lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusquedaDeReservas.setForeground(Color.WHITE);
		lblBusquedaDeReservas.setFont(new Font("Georgia", Font.PLAIN, 18));
		btnBuscar.add(lblBusquedaDeReservas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(new Color(240, 255, 240));
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
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
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("");
		labelExit.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/cerrar-24px.png")));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Georgia", Font.PLAIN, 18));
		
	    JPanel panelFecha = new JPanel();
	    panelFecha.setBackground(new Color(51, 102, 51));
	    panelFecha.setBounds(256, 84, 688, 121);
	    contentPane.add(panelFecha);
	    panelFecha.setLayout(null);
	    
	    JLabel lblTitulo = new JLabel("Sistema de reservas Hotel Bonsai");
	    lblTitulo.setBounds(180, 11, 356, 42);
	    panelFecha.add(lblTitulo);
	    lblTitulo.setForeground(Color.WHITE);
	    lblTitulo.setFont(new Font("Georgia", Font.PLAIN, 24));
	    
	    JLabel labelFecha = new JLabel("New label");
	    labelFecha.setBounds(35, 64, 294, 36);
	    panelFecha.add(labelFecha);
	    labelFecha.setForeground(Color.WHITE);
	    labelFecha.setFont(new Font("Georgia", Font.PLAIN, 33));
	    Date fechaActual = new Date(); //fecha y hora actual
	    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
	    labelFecha.setText("Hoy es " + fecha); //setear la representacion en cadena de la fecha
	    
	    JLabel lblBienvenido = new JLabel("Bienvenido");
	    lblBienvenido.setForeground(new Color(0, 0, 0));
	    lblBienvenido.setFont(new Font("Georgia", Font.BOLD, 24));
	    lblBienvenido.setBounds(302, 234, 147, 46);
	    contentPane.add(lblBienvenido);
	    
	    String textoDescripcion = "<html><body>Sistema de reserva del Hotel Bonsai. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel </body></html>";
	    JLabel labelDescripcion = new JLabel("<html><body>Sistema de reserva del \"Hotel Bonsai\". <br>Controle y administre de forma óptima y fácil el flujo de reservas y de huéspedes del hotel. </body></html>");
	    labelDescripcion.setFont(new Font("Georgia", Font.PLAIN, 17));
	   
	    labelDescripcion.setBounds(312, 291, 598, 66);
	    contentPane.add(labelDescripcion);
	    
	    String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
	    JLabel labelDescripcion_1 = new JLabel("<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes. Acceda a heramientas especiales para tareas específicas como: </body></html>");
	    labelDescripcion_1.setFont(new Font("Georgia", Font.PLAIN, 17));
	    labelDescripcion_1.setBounds(311, 345, 569, 88);
	    contentPane.add(labelDescripcion_1);
	    
	    JLabel lblDescripcion_3 = new JLabel("- Registro de reservas y huéspedes");
	    lblDescripcion_3.setFont(new Font("Georgia", Font.PLAIN, 17));
	    lblDescripcion_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblDescripcion_3);
	    
	    JLabel lblDescripcion_4 = new JLabel("- Edición de reservas y huéspedes existentes");
	    lblDescripcion_4.setFont(new Font("Georgia", Font.PLAIN, 17));
	    lblDescripcion_4.setBounds(312, 482, 355, 27);
	    contentPane.add(lblDescripcion_4);
	    
	    JLabel lblDescripcion_5 = new JLabel("- Eliminar todo tipo de registros");
	    lblDescripcion_5.setFont(new Font("Georgia", Font.PLAIN, 17));
	    lblDescripcion_5.setBounds(312, 520, 295, 27);
	    contentPane.add(lblDescripcion_5);
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
