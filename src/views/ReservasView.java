package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import jdbc.controller.ReservasController;
import jdbc.modelo.Reserva;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;



@SuppressWarnings("serial")
public class ReservasView extends JFrame {
	
//	ATRIBUTOS

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser txtFechaE;
	public static JDateChooser txtFechaS;
	public static JComboBox<Format> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel lblNewLabel_3; 
	private JLabel labelAtras;
	private ReservasController reservasController;

	/**
	 * Launch the application.
	 */
	
//	MÉTODOS
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				EJECUTAR
				try {
					ReservasView frame = new ReservasView();
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
	
//	CREAR VISTA RESERVAS
	public ReservasView() {
//		INICIALIZAR
		super("Reserva");
		this.reservasController = new ReservasController();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/calendario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(143, 188, 143));
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(51, 102, 51));
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(new Color(51, 102, 51));
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(new Color(51, 102, 51));
		separator_1_3.setBackground(new Color(51, 102, 51));
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(51, 102, 51));
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(new Color(51, 102, 51));
		panel.add(separator_1_1);
		
		txtFechaE = new JDateChooser();
		txtFechaE.getCalendarButton().setSelectedIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/calendario.png")));
		txtFechaE.getCalendarButton().setBackground(new Color(51, 102, 51));
		txtFechaE.getCalendarButton().setFont(new Font("Georgia", Font.PLAIN, 12));
		txtFechaE.setBounds(68, 161, 289, 35);
		txtFechaE.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaE.setBackground(new Color(240, 255, 240));
		txtFechaE.setBorder(null);
		txtFechaE.setDateFormatString("yyyy-MM-dd");
		txtFechaE.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel.add(txtFechaE);
		
		lblNewLabel_3 = new JLabel("$");
		lblNewLabel_3.setBounds(68, 332, 17, 25);
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Georgia", Font.BOLD, 17));
		lblNewLabel_3.setEnabled(false);
		panel.add(lblNewLabel_3);
		
		JLabel lblCheckIn = new JLabel("Fecha de check-in");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Fecha de check-out");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		txtFechaS = new JDateChooser();
		txtFechaS.getCalendarButton().setSelectedIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/calendario.png")));
		txtFechaS.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaS.setBounds(68, 246, 289, 35);
		txtFechaS.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaS.setBackground(new Color(240, 255, 240));
		txtFechaS.setFont(new Font("Georgia", Font.PLAIN, 18));
		txtFechaS.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calcularValor(txtFechaE,txtFechaS);				
			}
		});
		txtFechaS.setDateFormatString("yyyy-MM-dd");
		txtFechaS.getCalendarButton().setBackground(new Color(51, 102, 51));
		txtFechaS.setBorder(null);
		panel.add(txtFechaS);
		
	
		
		txtValor = new JTextField();
		txtValor.setBackground(new Color(240, 255, 240));
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(82, 328, 58, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Georgia", Font.BOLD, 17));
		txtValor.setBorder(null);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor de la reserva");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel.add(lblValor);
		
		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(new Color(240, 255, 240));
		txtFormaPago.setBorder(null);
		txtFormaPago.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Efectivo"}));
		panel.add(txtFormaPago);
		
		JLabel lblFormaPago = new JLabel("Forma de pago");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Georgia", Font.PLAIN, 18));
		panel.add(lblFormaPago);
		
		JLabel lblTitulo = new JLabel("Sistema de reservas");
		lblTitulo.setBounds(109, 60, 219, 42);
		lblTitulo.setForeground(new Color(51, 102, 51));
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(51, 102, 51));
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel Logo = new JLabel("");
		panel_1.add(Logo);
		Logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/logo-bonsai__100_-removebg-preview.png")));
		
		JLabel ImagenFondo = new JLabel("");
		panel_1.add(ImagenFondo);
		ImagenFondo.setBackground(Color.WHITE);
		ImagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/registro_reserva.jpg")));
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.WHITE);
				labelExit.setForeground(Color.BLACK);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(254, 255, 220));
			     labelExit.setForeground(Color.BLACK);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(51, 102, 51));
		panel_1.add(btnexit);
		
		labelExit = new JLabel("");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Georgia", Font.PLAIN, 18));
		
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
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(51,102,51));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(240,255,240));
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("");
		labelAtras.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Georgia", Font.PLAIN, 23));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(51, 102, 51));
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(new Color(51, 102, 51));
		panel.add(separator_1);
		
		JPanel btnsiguiente = new JPanel();
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ReservasView.txtFechaE.getDate() != null && ReservasView.txtFechaS.getDate() != null) {	
//					LLAMADA A MÉTODO 
					guardarReserva();									
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}						
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(new Color(51, 102, 51));
		btnsiguiente.setBounds(238, 493, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Georgia", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);
		btnsiguiente.add(lblSiguiente);
	}

//	CONVERSIÓN DE FECHAS A TIPO STRING
//	GUARDAR RESERVA
	private void guardarReserva() {	
		try {
			String fechaE = ((JTextField)txtFechaE.getDateEditor().getUiComponent()).getText();
			String fechaS = ((JTextField)txtFechaS.getDateEditor().getUiComponent()).getText();	
//			DATE.VALUEOF CONVIERTE EL STRING A UN TIPO JAVA SQL DATE. GETSELECTEDITEM PARA EL DESPLEGABLE. TODO QUEDA EN STRING
			Reserva reserva = new Reserva(java.sql.Date.valueOf(fechaE), java.sql.Date.valueOf(fechaS), ReservasView.txtValor.getText(), ReservasView.txtFormaPago.getSelectedItem().toString());
			reservasController.guardar(reserva);
			
			RegistroHuesped huesped = new RegistroHuesped(reserva.getId());
			huesped.setVisible(true);
			dispose();
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(contentPane, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
//	CALCULAR COSTO DE LA RESERVA
	private void calcularValor(JDateChooser fechaE,JDateChooser fechaS) {		
		if(fechaE.getDate() != null && fechaS.getDate() !=null) {
			Calendar inicio = fechaE.getCalendar();
			Calendar fin = fechaS.getCalendar();
			int dias = -1; // Usamos -1 para contar a partir del dia siguiente
			int diaria = 35;
			int valor;
			
			while(inicio.before(fin)||inicio.equals(fin)) {
				dias++;
				inicio.add(Calendar.DATE,1); //dias a ser aumentados
			}
			valor = dias * diaria;
			txtValor.setText("" + valor);
		}
	}
	
	
	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
