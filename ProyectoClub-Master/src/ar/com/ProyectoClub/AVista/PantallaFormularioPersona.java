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
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;

public class PantallaFormularioPersona extends JDialog implements ActionListener,KeyListener {

	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
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
	public JLabel lblTel;
	private JLabel lblMatri;
	private JLabel lblSexo; 
	private JLabel lblNaciona;
	private JLabel lblEstCivil; 
	public JDateChooser dateFechIngreso; 
	private JLabel lblFechingreso;
	private JLabel lblCate; 
	public JComboBox comboSexo; 
	public JComboBox comboCate;
	public JComboBox cmbEstadoCivil; 
	public Map<Integer, String> mapCategoria = new HashMap<Integer, String>();
	private boolean Essocio;
	public  JTextField txtDomNro;
	public JLabel lblNro;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel;
	public JButton btnVolver;
	public JButton btnRegistrar;
	public JButton btnLimpiar;

	public PantallaFormularioPersona(PantallaSocios vtnPantallaPersona,boolean b) {  
		super(vtnPantallaPersona,b);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaFormularioPersona.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
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
		contentPane.setBackground(new Color(255, 255, 255));
		panelTitulo= new JPanel();
		panelTitulo.setBounds(15, 15, 796, 31);
		panelTitulo.setBackground(new Color(0, 191, 255));
		lblTitulo = new JLabel();
		//setBounds(100, 100,1129, 978);
		//contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(255, 255, 255));
		panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATOS OBLIGATORIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		
		panel_2 = new JPanel();
		panel_2.setBackground(new java.awt.Color(255, 255, 255));
		panel_2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATOS OBLIGATORIOS SOCIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		panel_2.setLayout(null);
		lblMatri= new JLabel();
		lblMatri.setBounds(10, 27, 69, 14);
		panel_2.add(lblMatri);
		
		
		lblMatri.setText("MATRICULA");
		txtMatri = new JTextField();
		txtMatri.setBounds(108, 24, 103, 20);
		panel_2.add(txtMatri);
		lblSexo= new JLabel();
		lblSexo.setBounds(10, 65, 61, 14);
		panel_2.add(lblSexo);
		
		
		lblSexo.setText("SEXO");
		comboSexo= new JComboBox();
		comboSexo.setBounds(108, 65, 197, 20);
		panel_2.add(comboSexo);
		
		comboSexo.addItem("Seleccione un sexo");
		comboSexo.addItem("Masculino");
		comboSexo.addItem("Femenino");
		txtNacion = new JTextField();
		txtNacion.setBounds(108, 103, 197, 20);
		panel_2.add(txtNacion);
		lblNaciona= new JLabel();
		lblNaciona.setBounds(10, 103, 88, 14);
		panel_2.add(lblNaciona);
		
		
		lblNaciona.setText("NACIONALIDAD");
		lblEstCivil = new JLabel();
		lblEstCivil.setBounds(10, 217, 98, 14);
		panel_2.add(lblEstCivil);
		
		
		lblEstCivil.setText("ESTADO CIVIL");
		cmbEstadoCivil= new JComboBox();
		cmbEstadoCivil.setBounds(108, 217, 180, 20);
		panel_2.add(cmbEstadoCivil);
		
		
		cmbEstadoCivil.addItem("Seleccione un estado");
		cmbEstadoCivil.addItem("Casado/a");
		cmbEstadoCivil.addItem("Soltero/a");
		cmbEstadoCivil.addItem("Comprometido/a");
		cmbEstadoCivil.addItem("Divorciado/a");
		cmbEstadoCivil.addItem("Viudo/a");
		lblFechingreso = new JLabel();
		lblFechingreso.setBounds(10, 179, 88, 14);
		panel_2.add(lblFechingreso);
		
		
		lblFechingreso.setText("FECHA INGRESO");
		dateFechIngreso = new JDateChooser();
		dateFechIngreso.setBounds(108, 179, 129, 20);
		panel_2.add(dateFechIngreso);
		lblCate= new JLabel();
		lblCate.setBounds(10, 141, 69, 14);
		panel_2.add(lblCate);
		
		
		lblCate.setText("CATEGORIA");
		comboCate= new JComboBox();
		comboCate.setBounds(108, 141, 180, 20);
		panel_2.add(comboCate);
		comboCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		comboSexo.repaint();
		panel_1.setLayout(null);
		lblDni = new JLabel();
		lblDni.setBounds(10, 25, 18, 14);
		panel_1.add(lblDni);
		
		
		lblDni.setText("DNI");
		txtDni = new JTextField();
		txtDni.setBounds(101, 22, 173, 20);
		panel_1.add(txtDni);
		//
		lblApe = new JLabel();
		lblApe.setBounds(10, 60, 81, 14);
		panel_1.add(lblApe);
		
		
		lblApe.setText("APELLIDO");
		txtApe = new JTextField();
		txtApe.setBounds(101, 60, 176, 20);
		panel_1.add(txtApe);
		txtNom = new JTextField();
		txtNom.setBounds(101, 98, 176, 20);
		panel_1.add(txtNom);
		lblNom = new JLabel();
		lblNom.setBounds(10, 98, 70, 14);
		panel_1.add(lblNom);
		
		
		lblNom.setText("NOMBRES");
		lblFechNac = new JLabel();
		lblFechNac.setBounds(10, 212, 121, 14);
		panel_1.add(lblFechNac);
		
		
		lblFechNac.setText("FECHA NACIMIENTO");
		dateFechNac = new JDateChooser();
		dateFechNac.setBounds(126, 212, 95, 20);
		panel_1.add(dateFechNac);
		lblDom = new JLabel();
		lblDom.setBounds(10, 174, 81, 14);
		panel_1.add(lblDom);
		
		
		lblDom.setText("DOMICILIO");
		txtDom = new JTextField();
		txtDom.setBounds(97, 174, 190, 20);
		panel_1.add(txtDom);
		
		txtDomNro = new JTextField();
		txtDomNro.setBounds(329, 174, 51, 20);
		panel_1.add(txtDomNro);
		
		lblNro = new JLabel();
		lblNro.setBounds(297, 174, 22, 14);
		panel_1.add(lblNro);
		lblNro.setText("NRO");
		txtTel = new JTextField();
		txtTel.setBounds(101, 136, 173, 20);
		panel_1.add(txtTel);
		lblTel= new JLabel();
		lblTel.setBounds(10, 136, 81, 14);
		panel_1.add(lblTel);
		
		
		lblTel.setText("TELEFONO");
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
		
		lblTitulo.setText("REGISTRO PERSONAS");
		lblTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitulo.add(lblTitulo);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		btnRegistrar = new JButton();
		btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/guardar.png")));
		btnRegistrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegistrar.setText("Guardar");
		btnRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12));
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBorder(null);
		btnRegistrar.setBounds(579, 8, 97, 101);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		contentPane.setLayout(new MigLayout("", "[1083px]", "[31px][257px][251px][117px]"));
		contentPane.add(panelTitulo, "cell 0 0,growx,aligny top");
		contentPane.add(panel_1, "cell 0 1,grow");
		contentPane.add(panel_2, "cell 0 2,grow");
		contentPane.add(panel, "cell 0 3,grow");
		
		btnLimpiar = new JButton();
		btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png")));
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setBorder(null);
		btnLimpiar.setBounds(463, 11, 89, 95);
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);
		
		btnVolver = new JButton();
		btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/impo.png")));
		btnVolver.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVolver.setText("Cancelar");
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBorder(null);
		btnVolver.setBounds(341, 8, 97, 101);
		panel.add(btnVolver);
		
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
			//nuevapersona.setNroSocio(Integer.parseInt(lblIdSocio.getText()));
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
		//para salir del paso
		if(txtApe.getText().isEmpty() || txtDni.getText().isEmpty() || txtDom.getText().isEmpty() || txtDomNro.getText().isEmpty() || dateFechNac.getDate()==null || txtTel.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Algunos datos son obligatorios, ¡por favor verifique los mismos!","Error al verificar los datos",JOptionPane.ERROR_MESSAGE);
		}
		else{
			if(miCoordinador.ValidarDatosPersona(nuevapersona)){ 
				//if(txtApe.getText().isEmpty() || txtDni.getText().isEmpty() || txtNom.getText().isEmpty() || txtDomNro.getText().isEmpty() || txtMatri.getText()) 
				miCoordinador.GuardarSocioNosocio(nuevapersona, Essocio);
				this.limpiar();
				if(Essocio){
					//lblIdSocio.setText(miCoordinador.DevolverUltimoIdSocio().toString());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Algunos datos son obligatorios, ¡por favor verifique los mismos!","Error al verificar los datos",JOptionPane.ERROR_MESSAGE);
			}
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
