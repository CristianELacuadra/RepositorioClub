package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class PantallaFormularioPersona extends JDialog implements ActionListener,KeyListener {

	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
	public JDesktopPane jCDesktopPane1; 
	public JPanel panelTitulo;
	public  JLabel lblTitulo;
	public JLabel lblDni;
	public JTextField txtDni;
	public JTextField txtApe;
	public JTextField txtNom;
	public JTextField txtDom;
	public JTextField txtTel;
	public JTextField txtMatri;
	public JTextField txtNacion;
    public JLabel lblApe;  
    public JLabel lblNom;
    public JLabel lblFechNac;
	public JDateChooser dateFechNac;
	public JLabel lblDom; 
	public JPanel panelDatosSocios; 
	public JLabel lblTel;
	private JLabel lblMatri;
	private JLabel lblSexo; 
	private JLabel lblNaciona;
	private JLabel lblEstCivil; 
	public JDateChooser dateFechIngreso; 
	private JLabel lblFechingreso;
	private JLabel lblCate; 
	public JComboBox comboSexo; 
	public JLabel lblIdSocio; 
	public JLabel lblNroSocio; 
	public JButton btnVolver; 
	public JButton btnRegistrar; 
	public JButton btnLimpiar;
	public JComboBox comboCate;
	public JComboBox cmbEstadoCivil; 
	public Map<Integer, String> mapCategoria = new HashMap<Integer, String>();
	private boolean Essocio;
	public  JTextField txtDomNro;
	public JLabel lblNro;

	public PantallaFormularioPersona(PantallaSocios vtnPantallaPersona,boolean b) {  
		super(vtnPantallaPersona,b);
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
			}
		});
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	private void initComponents(){
		//Instanciamos los componentes
		contentPane = new JPanel();
		jCDesktopPane1 = new JDesktopPane();
		jCDesktopPane1.setMaximumSize(new Dimension(10, 10));
		panelTitulo= new JPanel();
		lblDni = new JLabel();
		txtDni = new JTextField();
		//evento para que ingrese solo numeros al dni
		txtDni.addKeyListener(new KeyAdapter() {
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
		//
		lblApe = new JLabel();
		panelTitulo.setBackground(Color.RED);
		txtApe = new JTextField();
		lblNom = new JLabel();
		txtNom = new JTextField();
		lblFechNac = new JLabel();
		dateFechNac = new JDateChooser();
		lblDom = new JLabel();
		txtDom = new JTextField();
		txtTel = new JTextField();
		panelDatosSocios = new JPanel();
		lblTel= new JLabel();
		txtMatri = new JTextField();
		lblMatri= new JLabel();
		lblSexo= new JLabel();
		txtNacion = new JTextField();
		lblNaciona= new JLabel();
		lblEstCivil = new JLabel();
		dateFechIngreso = new JDateChooser();
		comboCate= new JComboBox();
		comboCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboSexo= new JComboBox();
		lblFechingreso = new JLabel();
		lblCate= new JLabel();
		lblTitulo = new JLabel();
		btnVolver = new JButton();
		btnVolver.setVerticalAlignment(SwingConstants.TOP);
		btnRegistrar = new JButton();
		btnLimpiar= new JButton();
		cmbEstadoCivil= new JComboBox();
		setBounds(100, 100, 957, 556);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		jCDesktopPane1.setBackground(Color.LIGHT_GRAY);
		
		

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTitulo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
				.addComponent(jCDesktopPane1, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(panelTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(jCDesktopPane1, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);
		
		
		lblDni.setText("DNI");
		lblDni.setBounds(10, 11, 43, 14);
		jCDesktopPane1.add(lblDni);
		
		
		txtDni.setBounds(101, 8, 173, 20);
		jCDesktopPane1.add(txtDni);
		
		
		lblApe.setText("APELLIDO");
		lblApe.setBounds(10, 55, 81, 14);
		jCDesktopPane1.add(lblApe);
		
		
		txtApe.setBounds(101, 52, 176, 20);
		jCDesktopPane1.add(txtApe);
		
		
		lblNom.setText("NOMBRES");
		lblNom.setBounds(10, 94, 81, 14);
		jCDesktopPane1.add(lblNom);
		
		
		txtNom.setBounds(101, 91, 176, 20);
		jCDesktopPane1.add(txtNom);
		
		
		lblFechNac.setText("FECHA N.");
		lblFechNac.setBounds(11, 134, 80, 14);
		jCDesktopPane1.add(lblFechNac);
		
		
		dateFechNac.setBounds(101, 128, 95, 20);
		jCDesktopPane1.add(dateFechNac);
		
		
		lblDom.setText("DOMICILIO");
		lblDom.setBounds(10, 168, 81, 14);
		jCDesktopPane1.add(lblDom);
		
		
		txtDom.setBounds(101, 165, 190, 20);
		jCDesktopPane1.add(txtDom);
		
		
		lblTel.setText("TELEFONO");
		lblTel.setBounds(10, 231, 81, 14);
		jCDesktopPane1.add(lblTel);
		
		
		txtTel.setBounds(101, 228, 173, 20);
		jCDesktopPane1.add(txtTel);
		
		
		panelDatosSocios.setBackground(Color.LIGHT_GRAY);
		panelDatosSocios.setLayout(null);
		panelDatosSocios.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDatosSocios.setBounds(377, 0, 419, 354);
		jCDesktopPane1.add(panelDatosSocios);
		
		
		txtMatri.setBounds(130, 62, 254, 20);
		panelDatosSocios.add(txtMatri);
		
		
		lblMatri.setText("MATRICULA");
		lblMatri.setBounds(25, 65, 85, 14);
		panelDatosSocios.add(lblMatri);
		
		
		lblSexo.setText("SEXO");
		lblSexo.setBounds(25, 107, 61, 14);
		panelDatosSocios.add(lblSexo);
		
		
		txtNacion.setBounds(130, 149, 239, 20);
		panelDatosSocios.add(txtNacion);
		
		
		lblNaciona.setText("NACIONALIDAD");
		lblNaciona.setBounds(25, 152, 110, 14);
		panelDatosSocios.add(lblNaciona);
		
		
		lblEstCivil.setText("ESTADO CIVIL");
		lblEstCivil.setBounds(25, 194, 98, 14);
		panelDatosSocios.add(lblEstCivil);
		
		
		dateFechIngreso.setBounds(132, 248, 129, 20);
		panelDatosSocios.add(dateFechIngreso);
		
		
		lblFechingreso.setText("FECHA INGRESO");
		lblFechingreso.setBounds(25, 254, 138, 14);
		panelDatosSocios.add(lblFechingreso);
		
		
		comboCate.setBounds(130, 293, 180, 20);
		panelDatosSocios.add(comboCate);
		
		
		lblCate.setText("CATEGORIA");
		lblCate.setBounds(25, 296, 69, 14);
		panelDatosSocios.add(lblCate);
		
		
		comboSexo.setBounds(130, 104, 197, 20);
		
		comboSexo.addItem("Seleccione un sexo");
		comboSexo.addItem("Masculino");
		comboSexo.addItem("Femenino");
		comboSexo.repaint();
		panelDatosSocios.add(comboSexo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 367, 43);
		panelDatosSocios.add(panel);
		lblNroSocio = new JLabel();
		panel.add(lblNroSocio);
		
		
		lblNroSocio.setText("SOCIO NRO");
		lblNroSocio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdSocio= new JLabel();
		panel.add(lblIdSocio);
		lblIdSocio.setForeground(Color.RED);
		lblIdSocio.setFont(new Font("Arial", Font.BOLD, 18));
		
		
		lblIdSocio.setText(".....");
		lblIdSocio.setEnabled(false);
		
		
		cmbEstadoCivil.addItem("Seleccione un estado");
		cmbEstadoCivil.addItem("Casado/a");
		cmbEstadoCivil.addItem("Soltero/a");
		cmbEstadoCivil.addItem("Comprometido/a");
		cmbEstadoCivil.addItem("Divorciado/a");
		cmbEstadoCivil.addItem("Viudo/a");
		cmbEstadoCivil.setBounds(130, 191, 180, 20);
		panelDatosSocios.add(cmbEstadoCivil);
		
		
		btnVolver.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Back.png"));
		btnVolver.setText("VOLVER");
		btnVolver.setBounds(10, 391, 117, 33);
		jCDesktopPane1.add(btnVolver);
		
		
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Load.png"));
		btnRegistrar.setText("REGISTRAR");
		btnRegistrar.setBounds(625, 391, 142, 33);
		jCDesktopPane1.add(btnRegistrar);
		
		
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\limpiar.png"));
		btnLimpiar.setText("LIMPIAR");
		btnLimpiar.setBounds(495, 391, 120, 32);
		jCDesktopPane1.add(btnLimpiar);
		
		lblNro = new JLabel();
		lblNro.setText("NRO");
		lblNro.setBounds(301, 168, 22, 14);
		jCDesktopPane1.add(lblNro);
		
		txtDomNro = new JTextField();
		txtDomNro.setBounds(328, 165, 51, 20);
		jCDesktopPane1.add(txtDomNro);
		
		lblTitulo.setText("REGISTRO PERSONAS");
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTitulo);
		
		this.Escuchando();
		pack();
		
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	private void CargaDatos(){
		Personas nuevapersona=miCoordinador.CrearPersona();
		int dni= (txtDni.getText().length()==0) ? 0: Integer.parseInt(txtDni.getText());
		nuevapersona.setDni(dni);
		nuevapersona.setNombre(txtNom.getText());
		nuevapersona.setApellido(txtApe.getText());
		nuevapersona.setFecNacimiento(dateFechNac.getDate());
		nuevapersona.setDomicilio(txtDom.getText());
		int domnro= (txtDomNro.getText().length()==0) ? 0: Integer.parseInt(txtDomNro.getText());
		nuevapersona.setDomNro(domnro);
		nuevapersona.setTelefono(txtTel.getText());
		if(Essocio){
			nuevapersona.setNroSocio(Integer.parseInt(lblIdSocio.getText()));
			int matricula= (txtMatri.getText().length()==0) ? 0: Integer.parseInt(txtMatri.getText());
			nuevapersona.setMatricula(matricula);
			String sexo= (comboSexo.getSelectedItem().toString().equals("Seleccione un sexo")) ? null: comboSexo.getSelectedItem().toString();
			nuevapersona.setSexo(comboSexo.getSelectedItem().toString());
			nuevapersona.setNacionalidad(txtNacion.getText());
			String estadoCivil= (cmbEstadoCivil.getSelectedItem().toString().equals("Seleccione un estado")) ? null: cmbEstadoCivil.getSelectedItem().toString();
			nuevapersona.setEstadoCivil(estadoCivil);
			nuevapersona.setFecNacimiento(dateFechNac.getDate());
			nuevapersona.setFechaIngreso(dateFechIngreso.getDate());
			nuevapersona.setEstado("Activo");
			Categoria nuevaCategoria=miCoordinador.CrearCategoria();
			nuevaCategoria=null;
			//mapCategoria viene cargado desde el controlador con los id y nombre de las categorias

			for ( Map.Entry<Integer, String> entry : mapCategoria.entrySet() ){ //recorre las categorias
				if(comboCate.getSelectedItem().equals(entry.getValue())){ //Compara nombres
					nuevaCategoria=miCoordinador.BuscarCategoria(entry.getKey()); //busca la categoria con el key del map 
					break;
				}

			}
			nuevapersona.setCategoria(nuevaCategoria);
		}
		if(miCoordinador.ValidarDatosPersona(nuevapersona)){ 
			//if(txtApe.getText().isEmpty() || txtDni.getText().isEmpty() || txtNom.getText().isEmpty() || txtDomNro.getText().isEmpty() || txtMatri.getText()) 
			miCoordinador.GuardarSocioNosocio(nuevapersona, Essocio);
			this.limpiar();
			if(Essocio){
			lblIdSocio.setText(miCoordinador.DevolverUltimoIdSocio().toString());
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Algunos datos son obligatorios, ¡por favor verifique los mismos!","Error al verificar los datos",JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public void setEssocio(boolean essocio) {
		Essocio = essocio;
	}
	public boolean isEssocio() {
		return Essocio;
	}
	
	//limpiar
	private void limpiar(){
		txtDni.setText(null);
		txtApe.setText(null);
		txtNom.setText(null);
		dateFechNac.setCalendar(null);
		txtDom.setText(null);
		txtTel.setText(null);
		txtMatri.setText(null);
		cmbEstadoCivil.setSelectedItem("Seleccione un estado");
		comboSexo.setSelectedItem("Seleccione un sexo");
		comboCate.setSelectedItem("Seleccione una categoria");
		txtNacion.setText(null);
		dateFechIngreso.setCalendar(null);
		txtDomNro.setText(null);
		
	}
	//escuchando al usuario
	private void Escuchando(){
		btnLimpiar.addActionListener(this);
		btnRegistrar.addActionListener(this);
		btnVolver.addActionListener(this);
		txtApe.addKeyListener(this);
		txtNom.addKeyListener(this);
		txtDni.addKeyListener(this);
		dateFechNac.addKeyListener(this);
		txtDom.addKeyListener(this);
		txtTel.addKeyListener(this);
	}
	
	

	//Eventos
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrar){
			this.CargaDatos();
		}
		if(e.getSource() == btnLimpiar){
			this.limpiar();
		}
		if(e.getSource() == btnVolver){
			this.limpiar();
			this.dispose();
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		try{
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				this.CargaDatos();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"ERROR,Contacte con el administrador" , ex.getMessage(), JOptionPane.WARNING_MESSAGE);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
