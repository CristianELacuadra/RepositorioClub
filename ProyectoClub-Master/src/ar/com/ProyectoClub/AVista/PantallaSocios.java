package ar.com.ProyectoClub.AVista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.Panel;
import javax.swing.Icon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;




@SuppressWarnings("serial")
public class PantallaSocios extends JDialog implements ActionListener,KeyListener {
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
	public static JTextField txtdni;
	public  JTextField PantallaSocio;
	public static JTextField txtApe;
	public static JTextField txtMatri;
	public static JTextField txtNro;
	public static JTextField txtNom;
	public JButton btnagregar; 
	public JButton btneliminar;
	public JButton btnimprimir;
	public JButton btnCobranza;
	public JButton btnVolver;
	public static JDateChooser dateNac;
	public static JDateChooser dateIngre;
	public JButton btnBuscar; 
	public JButton btnNewBusqueda;
	public JButton btnVenBuscar;
	private JLabel lblTelefono;
	public static JTextField txtTel;
	public JButton btnEditar;
	public JButton btnGuardar;
	public static JRadioButton checkMasculino;
	public static JRadioButton checkFemenino;
	public JPanel panelSexo;
	public static JTextField txtDom;
	private JLabel lblDomicilo;
	private JLabel lblNro_1;
	public static JTextField txtNroDom;
	public static JTextField txtNac;
	private JLabel lblNacionalidad;
	private JLabel lblComprometidoa;
	public static JRadioButton checkcompro;
	private JLabel lblDivorciadoa;
	public static JRadioButton checkDivor;
	private JLabel lblViudoa;
	public static JRadioButton checkViudo;
	private JPanel comboNombre;
	private JLabel lblNombre;
	private JPanel panel_6;
	public static JTextField txtDesc;
	public static JTextField txtMonCate;
	public static JTextField txtNuevaCat;
	public static JTextPane txtNuevaDescrip;
	public static JTextField txtMontoNuevo;
	private JLabel lblMontoDeLa;
	private JLabel lblPesos;
	public static JTextField txtNuevoDescu;
	private JLabel lblDescuento_1;
	private JLabel label_1;
	public static JRadioButton checkCasado;
	public static JRadioButton checkSoltero;
	public static JTextPane txtDescrip;
	public static JComboBox comboCate; 
	public static JButton btnCambiar;
	
	public PantallaSocios(Principal vtnPrincipal,boolean b) {
		super(vtnPrincipal,b);
		setTitle("Sistema control de socios-CLUB AVENIDA EJERCITO");
		initComponents();	
	}
	
	private void initComponents(){
		setBounds(100, 100, 745, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 729, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search_find_locate_1542.png")));
		lblNewLabel.setBounds(356, 11, 107, 101);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Busqueda de Socios");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(500, 11, 219, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblBuscarSocioPor = new JLabel("Buscar socio por su N\u00BA Documento");
		lblBuscarSocioPor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBuscarSocioPor.setBounds(500, 52, 219, 28);
		panel.add(lblBuscarSocioPor);
		
		txtdni = new JTextField();
		txtdni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numero=e.getKeyChar(); 
				if(Character.isLetter(numero)) { 
					getToolkit().beep(); 
					e.consume(); 
					JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtdni.setToolTipText("Ingrese numero de documento a buscar");
		txtdni.setBounds(22, 71, 153, 26);
		panel.add(txtdni);
		txtdni.setColumns(10);
		
		btnBuscar= new JButton("Buscar");
		btnBuscar.setVerticalAlignment(SwingConstants.TOP);
		btnBuscar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		btnBuscar.setBounds(185, 71, 107, 27);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca N\u00BA Documento");
		lblNewLabel_2.setBounds(22, 46, 134, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblEjemplo = new JLabel("Ejemplo:1234");
		lblEjemplo.setForeground(Color.BLUE);
		lblEjemplo.setBounds(22, 108, 134, 14);
		panel.add(lblEjemplo);
		
		btnNewBusqueda = new JButton("Nueva Busqueda");
		btnNewBusqueda.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\undoarrow_undo_1534-iloveimg-resized.png"));
		btnNewBusqueda.setVerticalAlignment(SwingConstants.TOP);
		btnNewBusqueda.setBounds(22, 11, 153, 28);
		panel.add(btnNewBusqueda);
		
		btnVenBuscar= new JButton("");
		btnVenBuscar.setToolTipText("Buscar todos los socios registrados en la base de datos");
		btnVenBuscar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_search-iloveimg-resized.png"));
		btnVenBuscar.setVerticalAlignment(SwingConstants.TOP);
		btnVenBuscar.setBounds(685, 104, 34, 28);
		panel.add(btnVenBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 140, 729, 107);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnagregar= new JButton("");
		btnagregar.setToolTipText("Agregar un nuevo socio");
		btnagregar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/data_add3.png")));
		btnagregar.setBounds(143, 11, 97, 74);
		panel_1.add(btnagregar);
		
		btneliminar = new JButton("");
		btneliminar.setToolTipText("Inhabilitar un Socio");
		btneliminar.setEnabled(false);
		btneliminar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/data_delete.png")));
		btneliminar.setBounds(261, 11, 97, 74);
		panel_1.add(btneliminar);
		
		btnimprimir = new JButton("");
		btnimprimir.setEnabled(false);
		btnimprimir.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Print-iloveimg-resized.png"));
		btnimprimir.setBounds(384, 11, 97, 74);
		panel_1.add(btnimprimir);
		
		btnCobranza = new JButton("");
		btnCobranza.setToolTipText("Cobrar cuota");
		btnCobranza.setEnabled(false);
		btnCobranza.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/sale.png")));
		btnCobranza.setBounds(508, 11, 97, 74);
		panel_1.add(btnCobranza);
		
		btnVolver= new JButton("");
		btnVolver.setToolTipText("Volver");
		btnVolver.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\back_2-iloveimg-resized.png"));
		btnVolver.setBounds(622, 11, 97, 74);
		panel_1.add(btnVolver);
		
		btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar datos del socio");
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/data-modify2.png")));
		btnEditar.setBounds(22, 11, 91, 74);
		panel_1.add(btnEditar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 258, 729, 278);
		contentPane.add(tabbedPane);
		
		JPanel panelInforSocio = new JPanel();
		panelInforSocio.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Informacion Personal", null, panelInforSocio, null);
		panelInforSocio.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(34, 14, 63, 14);
		panelInforSocio.add(lblNewLabel_3);
		
		JLabel lblA = new JLabel("Apellidos");
		lblA.setFont(new Font("Arial", Font.PLAIN, 12));
		lblA.setBounds(34, 83, 63, 14);
		panelInforSocio.add(lblA);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		txtApe.setBounds(34, 108, 215, 20);
		panelInforSocio.add(txtApe);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMatricula.setBounds(34, 154, 63, 14);
		panelInforSocio.add(lblMatricula);
		
		txtMatri = new JTextField();
		txtMatri.setEnabled(false);
		txtMatri.setColumns(10);
		txtMatri.setBounds(34, 182, 111, 20);
		panelInforSocio.add(txtMatri);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(264, 154, 53, 14);
		panelInforSocio.add(lblSexo);
		
		dateNac= new JDateChooser();
		dateNac.setBounds(303, 108, 123, 20);
		panelInforSocio.add(dateNac);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(303, 83, 123, 14);
		panelInforSocio.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaDeIngreso.setBounds(474, 83, 102, 14);
		panelInforSocio.add(lblFechaDeIngreso);
		
		dateIngre = new JDateChooser();
		dateIngre.setBounds(455, 108, 123, 20);
		panelInforSocio.add(dateIngre);
		
		txtNro = new JTextField();
		txtNro.setEnabled(false);
		txtNro.setColumns(10);
		txtNro.setBounds(303, 39, 63, 20);
		panelInforSocio.add(txtNro);
		
		JLabel lblNro = new JLabel("Nro Socio");
		lblNro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNro.setBounds(304, 14, 62, 14);
		panelInforSocio.add(lblNro);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(34, 39, 215, 20);
		panelInforSocio.add(txtNom);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefono.setBounds(545, 14, 102, 14);
		panelInforSocio.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(545, 39, 142, 20);
		panelInforSocio.add(txtTel);
		
		panelSexo = new JPanel();
		panelSexo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelSexo.setBounds(183, 182, 222, 40);
		panelInforSocio.add(panelSexo);
		panelSexo.setLayout(null);
		
		JLabel lblMasculino = new JLabel("Masculino");
		lblMasculino.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMasculino.setBounds(10, 11, 56, 14);
		panelSexo.add(lblMasculino);
		
		checkMasculino= new JRadioButton("");
		checkMasculino.setEnabled(false);
		checkMasculino.setBounds(72, 7, 21, 23);
		panelSexo.add(checkMasculino);
		
		JLabel lblFemenino = new JLabel("Femenino");
		lblFemenino.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFemenino.setBounds(111, 12, 56, 14);
		panelSexo.add(lblFemenino);
		
		checkFemenino= new JRadioButton("");
		checkFemenino.setEnabled(false);
		checkFemenino.setBounds(173, 8, 21, 23);
		panelSexo.add(checkFemenino);
		
		JPanel panelEstCivil = new JPanel();
		panelEstCivil.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEstCivil.setBounds(455, 159, 243, 80);
		panelInforSocio.add(panelEstCivil);
		panelEstCivil.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCasado = new JLabel("Casado/a");
		lblCasado.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEstCivil.add(lblCasado);
		
		checkCasado= new JRadioButton("");
		checkCasado.setEnabled(false);
		panelEstCivil.add(checkCasado);
		
		JLabel lblSolteroa = new JLabel("Soltero/a");
		lblSolteroa.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEstCivil.add(lblSolteroa);
		
		checkSoltero = new JRadioButton("");
		checkSoltero.setEnabled(false);
		panelEstCivil.add(checkSoltero);
		
		lblComprometidoa = new JLabel("Comprometido/a");
		lblComprometidoa.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEstCivil.add(lblComprometidoa);
		
		checkcompro = new JRadioButton("");
		checkcompro.setEnabled(false);
		panelEstCivil.add(checkcompro);
		
		lblDivorciadoa = new JLabel("Divorciado/a");
		lblDivorciadoa.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEstCivil.add(lblDivorciadoa);
		
		checkDivor = new JRadioButton("");
		checkDivor.setEnabled(false);
		panelEstCivil.add(checkDivor);
		
		lblViudoa = new JLabel("Viudo/a");
		lblViudoa.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEstCivil.add(lblViudoa);
		
		checkViudo = new JRadioButton("");
		checkViudo.setEnabled(false);
		panelEstCivil.add(checkViudo);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstadoCivil.setBounds(528, 134, 77, 14);
		panelInforSocio.add(lblEstadoCivil);
		
		Panel panelDomi = new Panel();
		panelDomi.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Domicilio Nacionalidad", (Icon) null, panelDomi, null);
		panelDomi.setLayout(null);
		
		txtDom = new JTextField();
		txtDom.setBounds(10, 44, 250, 20);
		panelDomi.add(txtDom);
		txtDom.setColumns(10);
		
		lblDomicilo = new JLabel("Domicilo");
		lblDomicilo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDomicilo.setBounds(10, 23, 63, 14);
		panelDomi.add(lblDomicilo);
		
		lblNro_1 = new JLabel("Nro");
		lblNro_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNro_1.setBounds(305, 23, 63, 14);
		panelDomi.add(lblNro_1);
		
		txtNroDom = new JTextField();
		txtNroDom.setColumns(10);
		txtNroDom.setBounds(305, 44, 63, 20);
		panelDomi.add(txtNroDom);
		
		txtNac = new JTextField();
		txtNac.setColumns(10);
		txtNac.setBounds(10, 120, 250, 20);
		panelDomi.add(txtNac);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNacionalidad.setBounds(10, 95, 96, 14);
		panelDomi.add(lblNacionalidad);
		
		comboNombre = new JPanel();
		comboNombre.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Categoria Socio", null, comboNombre, null);
		comboNombre.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(28, 12, 63, 14);
		comboNombre.add(lblNombre);
		
		txtDescrip = new JTextPane();
		txtDescrip.setBounds(28, 108, 300, 115);
		comboNombre.add(txtDescrip);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescripcion.setBounds(28, 80, 83, 14);
		comboNombre.add(lblDescripcion);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(274, 37, 57, 20);
		comboNombre.add(txtDesc);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescuento.setBounds(274, 12, 74, 14);
		comboNombre.add(lblDescuento);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(341, 39, 18, 14);
		comboNombre.add(label);
		
		txtMonCate = new JTextField();
		txtMonCate.setColumns(10);
		txtMonCate.setBounds(414, 37, 83, 20);
		comboNombre.add(txtMonCate);
		
		JLabel lblMo = new JLabel("Monto Categoria");
		lblMo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMo.setBounds(414, 12, 98, 14);
		comboNombre.add(lblMo);
		
		comboCate= new JComboBox();
		comboCate.setBounds(28, 37, 174, 20);
		comboNombre.add(comboCate);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/Modify.png")));
		btnCambiar.setBounds(605, 216, 109, 23);
		comboNombre.add(btnCambiar);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Nueva Categoria", null, panel_6, null);
		panel_6.setLayout(null);
		
		txtNuevaCat = new JTextField();
		txtNuevaCat.setColumns(10);
		txtNuevaCat.setBounds(33, 43, 160, 20);
		panel_6.add(txtNuevaCat);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre_1.setBounds(33, 18, 74, 14);
		panel_6.add(lblNombre_1);
		
		JLabel lblDescripcion_1 = new JLabel("Descripcion");
		lblDescripcion_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescripcion_1.setBounds(33, 87, 87, 14);
		panel_6.add(lblDescripcion_1);
		
		txtNuevaDescrip = new JTextPane();
		txtNuevaDescrip.setBounds(33, 116, 212, 123);
		panel_6.add(txtNuevaDescrip);
		
		txtMontoNuevo = new JTextField();
		txtMontoNuevo.setColumns(10);
		txtMontoNuevo.setBounds(283, 43, 74, 20);
		panel_6.add(txtMontoNuevo);
		
		lblMontoDeLa = new JLabel("Monto de la categoria");
		lblMontoDeLa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMontoDeLa.setBounds(283, 19, 129, 14);
		panel_6.add(lblMontoDeLa);
		
		lblPesos = new JLabel("$");
		lblPesos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPesos.setBounds(363, 46, 27, 14);
		panel_6.add(lblPesos);
		
		txtNuevoDescu = new JTextField();
		txtNuevoDescu.setColumns(10);
		txtNuevoDescu.setBounds(454, 43, 74, 20);
		panel_6.add(txtNuevoDescu);
		
		lblDescuento_1 = new JLabel("Descuento");
		lblDescuento_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescuento_1.setBounds(454, 19, 129, 14);
		panel_6.add(lblDescuento_1);
		
		label_1 = new JLabel("%");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(538, 46, 27, 14);
		panel_6.add(label_1);
		
		JButton btnAddCateg = new JButton("");
		btnAddCateg.setToolTipText("Agregar categora");
		btnAddCateg.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\add_insert_plus_1588-iloveimg-resized.png"));
		btnAddCateg.setBounds(681, 206, 33, 33);
		panel_6.add(btnAddCateg);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Save-iloveimg-resized.png"));
		btnGuardar.setBounds(609, 540, 110, 23);
		contentPane.add(btnGuardar);
		
		btnBuscar.addActionListener(this);
		btnNewBusqueda.addActionListener(this);
		btnVenBuscar.addActionListener(this);
		btnagregar.addActionListener(this);
		btnCobranza.addActionListener(this);
		btneliminar.addActionListener(this);
		btnimprimir.addActionListener(this);
		btnVolver.addActionListener(this);
		btnEditar.addActionListener(this);
		btnCambiar.addActionListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	//Carga los datos del socio
	private void MostrarDatos(Personas persona){
		if(!persona.isEssocio()){
			JOptionPane.showMessageDialog(null,"La persona no se encuentra registrado como socio","Club Avenida Ejercito - Information ",JOptionPane.INFORMATION_MESSAGE);
			txtdni.setText(null);
		}
		else{
			txtNroDom.setText(persona.getDomNro().toString());
			txtDom.setText(persona.getDomicilio());
			txtApe.setText(persona.getApellido());
			txtNom.setText(persona.getNombre());
			txtNro.setText(persona.getNroSocio().toString());
			dateIngre.setDate(persona.getFechaIngreso());
			dateNac.setDate(persona.getFecNacimiento());
			txtTel.setText(persona.getTelefono());
			txtMatri.setText(persona.getMatricula().toString());
			txtNac.setText(persona.getNacionalidad());
			if(persona.getSexo().equals("Masculino")){
				checkMasculino.setSelected(true);
				checkFemenino.setSelected(false);
			}
			else{
				if(persona.getSexo().equals("Femenino")){
					checkMasculino.setSelected(false);
					checkFemenino.setSelected(true);
				}
			}
			switch (persona.getEstadoCivil()) {
			case "Casado/a":
				checkCasado.setSelected(true);
				checkSoltero.setSelected(false);
				checkcompro.setSelected(false);
				checkDivor.setSelected(false);
				checkViudo.setSelected(false);
				break;
			case "Soltero/a":
				checkCasado.setSelected(false);
				checkSoltero.setSelected(true);
				checkcompro.setSelected(false);
				checkDivor.setSelected(false);
				checkViudo.setSelected(false);
				break;
			case "Comprometido/a":
				checkCasado.setSelected(false);
				checkSoltero.setSelected(false);
				checkcompro.setSelected(true);
				checkDivor.setSelected(false);
				checkViudo.setSelected(false);
				break;
			case "Divorciado/a" :
				checkCasado.setSelected(false);
				checkSoltero.setSelected(false);
				checkcompro.setSelected(false);
				checkDivor.setSelected(true);
				checkViudo.setSelected(false);
				break;
			case "Viudo/a":
				checkCasado.setSelected(false);
				checkSoltero.setSelected(false);
				checkcompro.setSelected(false);
				checkDivor.setSelected(false);
				checkViudo.setSelected(true);
				break;
			}		
			miCoordinador.EnableBotonesVtnSocios(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnVenBuscar){
				miCoordinador.mostrarVentanaBusquedaSNS();
			}
			if(e.getSource()==btnEditar){
				txtApe.setEnabled(true);
				txtNom.setEnabled(true);
				txtTel.setEnabled(true);
				dateIngre.setEnabled(true);
				dateNac.setEnabled(true);
				btnGuardar.setEnabled(true);
				panelSexo.setEnabled(true);
				checkFemenino.setEnabled(true);
				checkMasculino.setEnabled(true);
			}
			if(e.getSource()==btnBuscar){
				Personas persona=miCoordinador.CrearPersona();
				persona=miCoordinador.BuscarPersona(Integer.parseInt(txtdni.getText()));
				if(persona==null){
					JOptionPane.showMessageDialog(null,"El Numero de documento ingresado no se encuentra registrado en nuestra base de datos","Club Avenida Ejercito - Information ",JOptionPane.INFORMATION_MESSAGE);
					txtdni.setText(null);
				}
				else{
					this.MostrarDatos(persona);
				}
			}
			if(e.getSource()==btnagregar){
				miCoordinador.mostrarFormularioPersona(true);
			}
			if(e.getSource()==btnCambiar){
				miCoordinador.MostrarPantallaCategorias(PantallaCategoriasTodas.jtdatos);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
