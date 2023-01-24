package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import jdbc.controller.HuespedesController;
import jdbc.controller.ReservasController;
import jdbc.modelo.Huespedes;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {
	
//	ATRIBUTOS

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtNreserva;
	private JDateChooser txtFechaN;
	private JComboBox<Format> txtNacionalidad;
	private HuespedesController huespedesController;
	private ReservasController reservasController;
	private JLabel labelExit;
	private JLabel labelAtras;
	int xMouse, yMouse;
	int id;

	/**
	 * Launch the application.
	 */
	
//	MÉTODOS
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				EJECUTAR
				try {
					RegistroHuesped frame = new RegistroHuesped(0);
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

	
//	REGISTRAR HUÉSPED
	public RegistroHuesped(int idReserva) {
//		INICIALIZAR
		this.huespedesController = new HuespedesController();
		this.reservasController = new ReservasController();
		

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/disquete.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		
		JPanel header = new JPanel();
		header.setLayout(null);
		header.setBackground(new Color(240, 255, 240));
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(240,255,240));
				labelExit.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(new Color(51,102,51));
				labelExit.setForeground(Color.white);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(new Color(51, 102, 51));
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("");
		labelAtras.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Georgia", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtNombre.setBounds(560, 135, 285, 33);
		txtNombre.setBackground(new Color(240, 255, 240));
		txtNombre.setColumns(10);
		txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtApellido.setBounds(560, 204, 285, 33);
		txtApellido.setColumns(10);
		txtApellido.setBackground(new Color(240, 255, 240));
		txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtApellido);
		
		txtFechaN = new JDateChooser();
		txtFechaN.getCalendarButton().setSelectedIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/calendario.png")));
		txtFechaN.setBackground(new Color(240, 255, 240));
		txtFechaN.setBounds(560, 278, 285, 36);
		txtFechaN.getCalendarButton().setBackground(new Color(51, 102, 51));
		txtFechaN.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtFechaN);
		
		txtNacionalidad = new JComboBox();
		txtNacionalidad.setBounds(560, 350, 289, 36);
		txtNacionalidad.setBackground(new Color(240, 255, 240));
		txtNacionalidad.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"afgano-afgana", "alemán-alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"}));
		contentPane.add(txtNacionalidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(560, 110, 253, 14);
		lblNombre.setForeground(new Color(51, 102, 51));
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 18));
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(560, 179, 255, 21);
		lblApellido.setForeground(new Color(51, 102, 51));
		lblApellido.setFont(new Font("Georgia", Font.PLAIN, 18));
		contentPane.add(lblApellido);
		
		JLabel lblNacimiento = new JLabel("Fecha de nacimiento");
		lblNacimiento.setBounds(560, 256, 255, 14);
		lblNacimiento.setForeground(new Color(51, 102, 51));
		lblNacimiento.setFont(new Font("Georgia", Font.PLAIN, 18));
		contentPane.add(lblNacimiento);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(560, 326, 255, 14);
		lblNacionalidad.setForeground(new Color(51, 102, 51));
		lblNacionalidad.setFont(new Font("Georgia", Font.PLAIN, 18));
		contentPane.add(lblNacionalidad);
		
		JLabel lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(562, 406, 253, 14);
		lblTelefono.setForeground(SystemColor.textInactiveText);
		lblTelefono.setFont(new Font("Georgia", Font.PLAIN, 18));
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtTelefono.setBounds(560, 424, 285, 33);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(new Color(240, 255, 240));
		txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_4 = new JLabel("Registro huésped");
		lblNewLabel_4.setBounds(606, 55, 234, 42);
		lblNewLabel_4.setForeground(new Color(51, 102, 51));
		lblNewLabel_4.setFont(new Font("Georgia", Font.PLAIN, 23));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNreserva = new JLabel("Número de reserva");
		lblNreserva.setBounds(560, 474, 253, 14);
		lblNreserva.setForeground(SystemColor.textInactiveText);
		lblNreserva.setFont(new Font("Georgia", Font.PLAIN, 18));
		contentPane.add(lblNreserva);
		
		txtNreserva = new JTextField();
		
		txtNreserva.setFont(new Font("Georgia", Font.PLAIN, 16));
		txtNreserva.setBounds(560, 495, 285, 33);
		txtNreserva.setColumns(10);
		txtNreserva.setBackground(new Color(240, 255, 240));
		txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtNreserva.setEditable(false);
		System.out.println(idReserva);
		String id = String.valueOf(idReserva);
		txtNreserva.setText(id);
		contentPane.add(txtNreserva);
		
			
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(new Color(51, 102, 51));
		separator_1_2.setBackground(new Color(51, 102, 51));
		contentPane.add(separator_1_2);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(new Color(51, 102, 51));
		separator_1_2_1.setBackground(new Color(51, 102, 51));
		contentPane.add(separator_1_2_1);
		
		JSeparator separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(new Color(51, 102, 51));
		separator_1_2_2.setBackground(new Color(51, 102, 51));
		contentPane.add(separator_1_2_2);
		
		JSeparator separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(new Color(51, 102, 51));
		separator_1_2_4.setBackground(new Color(51, 102, 51));
		contentPane.add(separator_1_2_4);
		
		JSeparator separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(new Color(51, 102, 51));
		separator_1_2_5.setBackground(new Color(51, 102, 51));
		contentPane.add(separator_1_2_5);
		
		JPanel btnguardar = new JPanel();
		btnguardar.setBounds(723, 560, 122, 35);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				LLAMADA A MÉTODO
				guardarHuesped();
			}
		});
		btnguardar.setLayout(null);
		btnguardar.setBackground(new Color(51, 102, 51));
		contentPane.add(btnguardar);
		btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelGuardar = new JLabel("Guardar");
		labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		labelGuardar.setForeground(Color.WHITE);
		labelGuardar.setFont(new Font("Georgia", Font.PLAIN, 18));
		labelGuardar.setBounds(0, 0, 122, 35);
		btnguardar.add(labelGuardar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(51, 102, 51));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 121, 479, 502);
		panel.add(imagenFondo);
		imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/registro_huesped.png")));
		
		JLabel logo = new JLabel("");
		logo.setBounds(192, 27, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/logo-bonsai__100_-removebg-preview.png")));
		
		JPanel btnexit = new JPanel();
		btnexit.setBounds(857, 0, 53, 36);
		contentPane.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
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
		btnexit.setBackground(Color.white);
		
		labelExit = new JLabel("");
		labelExit.setBackground(new Color(143, 188, 143));
		labelExit.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/imagenes/cerrar-24px.png")));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Georgia", Font.PLAIN, 18));
	}
	
//	GUARDAR HUÉSPED
	private void guardarHuesped() {
		
			if (txtFechaN.getDate() != null && !txtNombre.equals("") && !txtApellido.equals("") && !txtTelefono.equals("")) {		
				String fechaN = ((JTextField)txtFechaN.getDateEditor().getUiComponent()).getText();	
				int nreserva = Integer.parseInt(txtNreserva.getText());
				Huespedes huespedes = new Huespedes(txtNombre.getText(), txtApellido.getText(),  java.sql.Date.valueOf(fechaN), txtNacionalidad.getSelectedItem().toString(),txtTelefono.getText(), nreserva);
				this.huespedesController.guardar(huespedes);
				Exito exito = new Exito();
				exito.setVisible(true);	
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Debes llenar todos los campos.");
			}									
	}
	
										
	}

