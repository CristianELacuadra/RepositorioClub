package ar.com.ProyectoClub.AVista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import net.miginfocom.swing.MigLayout;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;




@SuppressWarnings("serial")
public class PantallaSocios extends JFrame implements ActionListener,KeyListener {
	
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
	public static JTextField txtDom;
	private JLabel lblDomicilo;
	private JLabel lblNro_1;
	public static JTextField txtNroDom;
	public static JTextField txtNac;
	private JLabel lblNacionalidad;
	public JComboBox comboCate;
	public JTextField txtNombreCat;
	private JLabel lblCategoriasRegistradas;
	public static JComboBox comboEstadoCivil;
	public Map<Integer, String> mapCategoria = new HashMap<Integer, String>();
	public int UltimoIdCategoria;
	public JComboBox comboSexo;
	
	public PantallaSocios(Principal vtnPrincipal,boolean b) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
			}
		});
		setTitle("Sistema control de socios-CLUB AVENIDA EJERCITO");
		initComponents();	
	}
	
	private void initComponents(){
		UltimoIdCategoria=0;
		setBounds(100, 100, 745, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1362, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search_find_locate_1542.png")));
		lblNewLabel.setBounds(686, 11, 107, 101);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Busqueda de Socios");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(803, 11, 219, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblBuscarSocioPor = new JLabel("Buscar socio por su N\u00BA Documento");
		lblBuscarSocioPor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBuscarSocioPor.setBounds(803, 53, 219, 28);
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
		txtdni.setBounds(22, 71, 428, 26);
		panel.add(txtdni);
		txtdni.setColumns(10);
		
		btnBuscar= new JButton("Buscar");
		btnBuscar.setVerticalAlignment(SwingConstants.TOP);
		btnBuscar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		btnBuscar.setBounds(504, 68, 107, 27);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca N\u00BA Documento");
		lblNewLabel_2.setBounds(22, 46, 181, 14);
		panel.add(lblNewLabel_2);
		
		btnNewBusqueda = new JButton("Nueva Busqueda");
		btnNewBusqueda.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\undoarrow_undo_1534-iloveimg-resized.png"));
		btnNewBusqueda.setVerticalAlignment(SwingConstants.TOP);
		btnNewBusqueda.setBounds(22, 11, 225, 28);
		panel.add(btnNewBusqueda);
		
		btnVenBuscar= new JButton("");
		btnVenBuscar.setToolTipText("Buscar todos los socios registrados en la base de datos");
		btnVenBuscar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_search-iloveimg-resized.png"));
		btnVenBuscar.setVerticalAlignment(SwingConstants.TOP);
		btnVenBuscar.setBounds(1303, 108, 34, 28);
		panel.add(btnVenBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 140, 1362, 107);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnagregar= new JButton("");
		btnagregar.setToolTipText("Agregar un nuevo socio");
		btnagregar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/data_add3.png")));
		panel_1.add(btnagregar);
		
		btneliminar = new JButton("");
		btneliminar.setToolTipText("Inhabilitar un Socio");
		btneliminar.setEnabled(false);
		btneliminar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/data_delete.png")));
		panel_1.add(btneliminar);
		
		btnimprimir = new JButton("");
		btnimprimir.setEnabled(false);
		btnimprimir.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Print-iloveimg-resized.png"));
		panel_1.add(btnimprimir);
		
		btnCobranza = new JButton("");
		btnCobranza.setToolTipText("Cobrar cuota");
		btnCobranza.setEnabled(false);
		btnCobranza.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/sale.png")));
		panel_1.add(btnCobranza);
		
		btnVolver= new JButton("");
		btnVolver.setToolTipText("Volver");
		btnVolver.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\back_2-iloveimg-resized.png"));
		panel_1.add(btnVolver);
		
		btnEditar = new JButton("");
		btnEditar.setToolTipText("Editar datos del socio");
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(PantallaSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/data-modify2.png")));
		panel_1.add(btnEditar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 258, 1362, 402);
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
		txtMatri.setEditable(false);
		txtMatri.setColumns(10);
		txtMatri.setBounds(34, 182, 111, 20);
		panelInforSocio.add(txtMatri);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSexo.setBounds(561, 154, 53, 14);
		panelInforSocio.add(lblSexo);
		
		dateNac= new JDateChooser();
		dateNac.setBounds(491, 108, 123, 20);
		panelInforSocio.add(dateNac);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(491, 83, 123, 14);
		panelInforSocio.add(lblFechaDeNacimiento);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaDeIngreso.setBounds(672, 83, 102, 14);
		panelInforSocio.add(lblFechaDeIngreso);
		
		dateIngre = new JDateChooser();
		dateIngre.setBounds(670, 108, 123, 20);
		panelInforSocio.add(dateIngre);
		
		txtNro = new JTextField();
		txtNro.setEditable(false);
		txtNro.setColumns(10);
		txtNro.setBounds(491, 39, 63, 20);
		panelInforSocio.add(txtNro);
		
		JLabel lblNro = new JLabel("Nro Socio");
		lblNro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNro.setBounds(491, 14, 62, 14);
		panelInforSocio.add(lblNro);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(34, 39, 215, 20);
		panelInforSocio.add(txtNom);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefono.setBounds(956, 14, 102, 14);
		panelInforSocio.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(914, 39, 142, 20);
		panelInforSocio.add(txtTel);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEstadoCivil.setBounds(981, 154, 77, 14);
		panelInforSocio.add(lblEstadoCivil);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 287, 1347, 76);
		panelInforSocio.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Nombre");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(10, 11, 63, 14);
		panel_2.add(label);
		
		comboCate = new JComboBox();
		comboCate.setToolTipText("");
		comboCate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ( e.getStateChange() == ItemEvent.DESELECTED )
				{
					for ( Map.Entry<Integer, String> entry : mapCategoria.entrySet() ){ //recorre las categorias
						if(comboCate.getSelectedItem().equals(entry.getValue())){ //Compara nombres
							txtNombreCat.setText(entry.getValue());
							UltimoIdCategoria=entry.getKey();
						}

					}
				} 
			}
		});
		comboCate.setEditable(true);
		comboCate.setBounds(257, 45, 174, 20);
		panel_2.add(comboCate);
		
		txtNombreCat = new JTextField();
		txtNombreCat.setEditable(false);
		txtNombreCat.setColumns(10);
		txtNombreCat.setBounds(10, 45, 215, 20);
		panel_2.add(txtNombreCat);
		
		lblCategoriasRegistradas = new JLabel("Categorias registradas");
		lblCategoriasRegistradas.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCategoriasRegistradas.setBounds(257, 11, 136, 14);
		panel_2.add(lblCategoriasRegistradas);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCategoria.setBounds(0, 250, 102, 26);
		panelInforSocio.add(lblCategoria);
		
		comboEstadoCivil= new JComboBox();
		comboEstadoCivil.setEditable(true);
		comboEstadoCivil.setToolTipText("Seleccione un Estado Civil");
		comboEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un estado", "Casado/a", "Soltero/a", "Comprometido/a", "Divorciado/a", "Viudo/a"}));
		comboEstadoCivil.setBounds(870, 182, 255, 20);
		panelInforSocio.add(comboEstadoCivil);
		
		comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un Sexo", "Masculino", "Femenino"}));
		comboSexo.setToolTipText("");
		comboSexo.setEditable(true);
		comboSexo.setBounds(466, 182, 255, 20);
		panelInforSocio.add(comboSexo);
		
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
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Save-iloveimg-resized.png"));
		btnGuardar.setBounds(1242, 671, 110, 23);
		contentPane.add(btnGuardar);
		
		btnBuscar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnNewBusqueda.addActionListener(this);
		btnVenBuscar.addActionListener(this);
		btnagregar.addActionListener(this);
		btnCobranza.addActionListener(this);
		btneliminar.addActionListener(this);
		btnimprimir.addActionListener(this);
		btnVolver.addActionListener(this);
		btnEditar.addActionListener(this);
		comboCate.addActionListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	//Carga los datos del socio
	@SuppressWarnings("unchecked")
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
			comboSexo.setSelectedItem(persona.getSexo());
			txtNombreCat.setText(persona.getCategoria().getNombre());
			comboEstadoCivil.setSelectedItem(persona.getEstadoCivil());
			if(comboCate.getItemCount()>0){
				for(int i=0;i<comboCate.getItemCount();i++){
					comboCate.removeItemAt(i);
				}
			}
			
			comboCate.addItem("Seleccione una categoria");
			for(Categoria categoria : miCoordinador.ListarCategorias()){
				comboCate.addItem(categoria.getNombre()); //Cargo Categorias y sus id
				mapCategoria.put(categoria.getIdCategoria(), categoria.getNombre());
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
				txtApe.setEditable(true);
				txtNom.setEditable(true);
				txtTel.setEditable(true);
				dateIngre.setEnabled(false);
				dateNac.setEnabled(false);
				btnGuardar.setEnabled(true);
				comboSexo.setEnabled(true);
				txtDom.setEditable(true);
				txtNac.setEditable(true);
				txtNroDom.setEditable(true);
				comboCate.setEnabled(true);
				comboEstadoCivil.setEnabled(true);
			}
			if(e.getSource()==btnBuscar){
				if(!txtdni.getText().isEmpty()){
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
			}
			if(e.getSource()==btnagregar){
				miCoordinador.mostrarFormularioPersona(true);
			}
			if(e.getSource()==btnCobranza){
				Personas persona=miCoordinador.CrearPersona();
				persona=miCoordinador.BuscarPersona(Integer.parseInt(txtdni.getText()));
				miCoordinador.mostrarVentanaCobranza(persona,PantallaCobranzaCuota.jtDatosCuota);
			}
			if(e.getSource()==btnVolver){
				this.limpiar();
				dispose();
			}
			if(e.getSource()==btnGuardar){
				int opcion = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos del socio?", "Club Avenida Ejercito - Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) { //The ISSUE is here
					Personas persona=miCoordinador.CrearPersona(); //instanciamos una persona
					persona=this.ActualizarDatos(miCoordinador.BuscarPersona(Integer.parseInt(txtdni.getText())),miCoordinador.BuscarCategoria(UltimoIdCategoria));
					miCoordinador.GuardarPersonas(persona);
					JOptionPane.showMessageDialog(null,"Los datos se actualizaron correctamente","Club Avenida Ejercito - Informacion ",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if(e.getSource()==btnNewBusqueda){
				this.limpiar();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	private Personas ActualizarDatos(Personas persona,Categoria categoria){
		  Personas personaActualizada=miCoordinador.CrearPersona();
		  Categoria categoriaActualizada=miCoordinador.CrearCategoria();
		  personaActualizada=persona;
		  categoriaActualizada=categoria;
		  personaActualizada.setDni(Integer.parseInt(txtdni.getText()));
		  personaActualizada.setCategoria(categoriaActualizada);
		  personaActualizada.setApellido(txtApe.getText());
		  personaActualizada.setNombre(txtNom.getText());
		  personaActualizada.setTelefono(txtTel.getText());
		  personaActualizada.setDomicilio(txtDom.getText());
		  personaActualizada.setDomNro(Integer.parseInt(txtNroDom.getText()));
		  personaActualizada.setFecNacimiento(dateNac.getDate());
		  personaActualizada.setNroSocio(Integer.parseInt(txtNro.getText()));
		  personaActualizada.setMatricula(Integer.parseInt(txtMatri.getText()));
		  String sexo= (comboSexo.getSelectedItem().toString().equals("Seleccione un Sexo")) ? null: comboSexo.getSelectedItem().toString();
		  personaActualizada.setSexo(sexo);
		  personaActualizada.setNacionalidad(txtNac.getText());
		  personaActualizada.setMatricula(Integer.parseInt(txtMatri.getText()));
		  String estadoCivil= (comboEstadoCivil.getSelectedItem().toString().equals("Seleccione un estado")) ? null: comboEstadoCivil.getSelectedItem().toString();
		  personaActualizada.setEstadoCivil(estadoCivil);
		  personaActualizada.setFechaIngreso(dateIngre.getDate());
		  return personaActualizada;
	}
	
	private void limpiar(){
		//txtbox
		txtApe.setText(null);
		txtdni.setText(null);
		txtDom.setText(null);
		txtMatri.setText(null);
		txtNac.setText(null);
		txtNom.setText(null);
		txtNombreCat.setText(null);
		txtNro.setText(null);
		txtNroDom.setText(null);
		txtTel.setText(null);
		comboEstadoCivil.setSelectedItem("Seleccione un estado");
		comboSexo.setSelectedItem("Seleccione un Sexo");
		//txtbox editables
		txtdni.setEditable(true);
		txtNro.setEditable(false);
		txtMatri.setEditable(false);
		txtApe.setEditable(false);
		txtNom.setEditable(false);
		txtTel.setEditable(false);;
		dateIngre.setEnabled(false);
		dateNac.setEnabled(false);
		btnEditar.setEnabled(false);
		btneliminar.setEnabled(false);
		btnCobranza.setEnabled(false);
		btnimprimir.setEnabled(false);
		comboEstadoCivil.setEnabled(true);
		btnBuscar.setEnabled(true);
	    txtDom.setEditable(false);
		txtNroDom.setEditable(false);
		txtNac.setEditable(false);
	    comboCate.setEnabled(false);
	    comboEstadoCivil.setEnabled(false);
		
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
