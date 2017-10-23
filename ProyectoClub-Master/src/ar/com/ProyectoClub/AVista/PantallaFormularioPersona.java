package ar.com.ProyectoClub.AVista;


import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Socios;

import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public JComboBox comboCate;
	public JComboBox cmbEstadoCivil; 
	public Map<Integer, String> mapCategoria = new HashMap<Integer, String>();
	private boolean Essocio;
	public  JTextField txtDomNro;
	private JPanel panelDatosObli;
	private JPanel panel_3;
	public JButton btnVolver;
	public JButton btnRegistrar;
	public JButton btnLimpiar;
	private ButtonGroup grupoSexo;
	private ButtonGroup grupoEssocio;
	private JPanel panel_5;
	private JLabel lblSocio;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbFemenino;
	private JRadioButton rdbMasculino;
	private JButton btnValidar;
	private JLabel lblEstado;
	private JPanel panel;
	private JTextField txtCateg;
	private JTextField txtEstdoCiv;
	

	public PantallaFormularioPersona(PantallaPrincipalPersonas vtnPantallaPersona,boolean b) {  
		super(vtnPantallaPersona,b);
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setType(Type.POPUP);
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
		lblEstado= new JLabel();
		lblEstado.setForeground(Color.RED);
		btnValidar= new JButton();
		rdbMasculino = new JRadioButton();
		rdbMasculino.setEnabled(false);
		rdbFemenino= new JRadioButton();
		rdbFemenino.setEnabled(false);
		grupoSexo=new ButtonGroup();
		grupoEssocio=new ButtonGroup();
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
		
		panelDatosObli = new JPanel();
		panelDatosObli.setBackground(new java.awt.Color(255, 255, 255));
		panelDatosObli.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATOS OBLIGATORIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		
		JPanel PanelDatosSocio = new JPanel();
		PanelDatosSocio.setBackground(new java.awt.Color(255, 255, 255));
		PanelDatosSocio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATOS OBLIGATORIOS SOCIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
		PanelDatosSocio.setLayout(null);
		lblMatri= new JLabel();
		lblMatri.setBounds(22, 27, 69, 14);
		PanelDatosSocio.add(lblMatri);
		
		lblMatri.setText("MATRICULA");
		txtMatri = new JTextField();
		txtMatri.setEditable(false);
		txtMatri.setEnabled(false);
		txtMatri.setBounds(98, 24, 103, 20);
		PanelDatosSocio.add(txtMatri);
		lblFechingreso = new JLabel();
		lblFechingreso.setBounds(22, 88, 95, 14);
		PanelDatosSocio.add(lblFechingreso);

		
		lblFechingreso.setText("FECHA INGRESO");
		dateFechIngreso = new JDateChooser();
		dateFechIngreso.setEnabled(false);
		dateFechIngreso.setBounds(128, 86, 138, 20);
		PanelDatosSocio.add(dateFechIngreso);
		lblCate= new JLabel();
		lblCate.setBounds(22, 61, 69, 14);
		PanelDatosSocio.add(lblCate);
		
		
		lblCate.setText("CATEGORIA");
		comboCate= new JComboBox();
		comboCate.setEnabled(false);
		comboCate.setBounds(234, 55, 211, 20);
		PanelDatosSocio.add(comboCate);
		comboCate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panelDatosObli.setLayout(null);
		lblDni = new JLabel();
		lblDni.setBounds(20, 25, 51, 14);
		panelDatosObli.add(lblDni);
		
		
		lblDni.setText("DNI");
		txtDni = new JTextField();
		txtDni.setBounds(83, 22, 251, 20);
		panelDatosObli.add(txtDni);
		//
		lblApe = new JLabel();
		lblApe.setBounds(20, 56, 81, 14);
		panelDatosObli.add(lblApe);
		
		
		lblApe.setText("APELLIDO");
		txtApe = new JTextField();
		txtApe.setEnabled(false);
		txtApe.setBounds(83, 53, 251, 20);
		panelDatosObli.add(txtApe);
		txtNom = new JTextField();
		txtNom.setEnabled(false);
		txtNom.setBounds(83, 81, 251, 20);
		panelDatosObli.add(txtNom);
		lblNom = new JLabel();
		lblNom.setBounds(20, 87, 70, 14);
		panelDatosObli.add(lblNom);
		
		
		lblNom.setText("NOMBRES");
		lblFechNac = new JLabel();
		lblFechNac.setBounds(20, 191, 129, 14);
		panelDatosObli.add(lblFechNac);
		
		
		lblFechNac.setText("FECHA NACIMIENTO");
		dateFechNac = new JDateChooser();
		dateFechNac.setEnabled(false);
		dateFechNac.setBounds(159, 191, 117, 20);
		panelDatosObli.add(dateFechNac);
		lblDom = new JLabel();
		lblDom.setBounds(20, 153, 81, 14);
		panelDatosObli.add(lblDom);
		
		
		lblDom.setText("DOMICILIO");
		txtDom = new JTextField();
		txtDom.setEnabled(false);
		txtDom.setBounds(83, 150, 251, 20);
		panelDatosObli.add(txtDom);
		
		txtDomNro = new JTextField();
		txtDomNro.setEnabled(false);
		txtDomNro.setBounds(388, 150, 51, 20);
		panelDatosObli.add(txtDomNro);
		txtTel = new JTextField();
		txtTel.setEnabled(false);
		txtTel.setBounds(83, 112, 251, 20);
		panelDatosObli.add(txtTel);
		lblTel= new JLabel();
		lblTel.setBounds(20, 116, 81, 14);
		panelDatosObli.add(lblTel);
		
		
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
		contentPane.setLayout(new MigLayout("", "[722.00px]", "[32.00px][25.00][399.00px][126.00px][27.00px]"));
		contentPane.add(panelTitulo, "cell 0 0,growx");
		
		
		contentPane.add(lblEstado, "cell 0 1");
		lblEstado.setText("   ESTADO:");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(panelDatosObli, "cell 0 2,grow");
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(20, 231, 364, 33);
		panelDatosObli.add(panel);
		panel.setLayout(null);
		lblSexo= new JLabel();
		lblSexo.setBounds(10, 9, 50, 14);
		panel.add(lblSexo);
		
		
		lblSexo.setText("SEXO");
		
		rdbFemenino.setText("FEMENINO");
		rdbFemenino.setBounds(84, 5, 85, 23);
		panel.add(rdbFemenino);
		rdbFemenino.setBackground(Color.WHITE);
		
		rdbMasculino.setText("MASCULINO");
		rdbMasculino.setBounds(174, 5, 109, 23);
		panel.add(rdbMasculino);
		rdbMasculino.setBackground(Color.WHITE);
		lblNaciona= new JLabel();
		lblNaciona.setBounds(20, 286, 88, 14);
		panelDatosObli.add(lblNaciona);
		grupoSexo.add(rdbMasculino);
		grupoSexo.add(rdbFemenino);
		
		lblNaciona.setText("NACIONALIDAD");
		txtNacion = new JTextField();
		txtNacion.setEnabled(false);
		txtNacion.setBounds(133, 283, 251, 20);
		panelDatosObli.add(txtNacion);
		lblEstCivil = new JLabel();
		lblEstCivil.setBounds(20, 319, 98, 14);
		panelDatosObli.add(lblEstCivil);
		
		
		lblEstCivil.setText("ESTADO CIVIL");
		cmbEstadoCivil= new JComboBox();
		cmbEstadoCivil.setEnabled(false);
		cmbEstadoCivil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!cmbEstadoCivil.getSelectedItem().equals("Seleccione un estado")){
					System.out.println("hola");
				}
					
			}
		});
		
		cmbEstadoCivil.setBounds(275, 316, 180, 20);
		panelDatosObli.add(cmbEstadoCivil);
		
		
		cmbEstadoCivil.addItem("Seleccione un estado");
		cmbEstadoCivil.addItem("Casado/a");
		cmbEstadoCivil.addItem("Soltero/a");
		cmbEstadoCivil.addItem("Comprometido/a");
		cmbEstadoCivil.addItem("Divorciado/a");
		cmbEstadoCivil.addItem("Viudo/a");
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(20, 358, 229, 33);
		panelDatosObli.add(panel_5);
		
		lblSocio = new JLabel();
		lblSocio.setText("SOCIO");
		lblSocio.setBounds(10, 9, 44, 14);
		panel_5.add(lblSocio);
		
		rdbtnSi = new JRadioButton("SI");
		rdbtnSi.setEnabled(false);
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotonesSocioHabilitado(true);
			}
		});
		rdbtnSi.setBackground(Color.WHITE);
		rdbtnSi.setBounds(70, 5, 53, 23);
		panel_5.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("NO");
		rdbtnNo.setEnabled(false);
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BotonesSocioHabilitado(false);
			}
		});
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(141, 5, 66, 23);
		panel_5.add(rdbtnNo);
		contentPane.add(PanelDatosSocio, "cell 0 3,grow");
		
		btnVolver = new JButton();
		btnVolver.setBounds(455, 10, 80, 92);
		PanelDatosSocio.add(btnVolver);
		btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/impo.png")));
		btnVolver.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVolver.setText("Cancelar");
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setContentAreaFilled(false);
		btnVolver.setBorderPainted(false);
		btnVolver.setBorder(null);
		
		btnLimpiar = new JButton();
		btnLimpiar.setBounds(534, 10, 89, 91);
		PanelDatosSocio.add(btnLimpiar);
		btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png")));
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setContentAreaFilled(false);
		btnLimpiar.setBorderPainted(false);
		btnLimpiar.setBorder(null);
		
		btnRegistrar = new JButton();
		btnRegistrar.setBounds(615, 11, 97, 91);
		PanelDatosSocio.add(btnRegistrar);
		btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/guardar.png")));
		btnRegistrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRegistrar.setText("Guardar");
		btnRegistrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12));
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBorder(null);
		
		txtCateg = new JTextField();
		txtCateg.setEditable(false);
		txtCateg.setBounds(98, 55, 126, 20);
		PanelDatosSocio.add(txtCateg);
		btnRegistrar.addActionListener(this);
		btnLimpiar.addActionListener(this);
		grupoEssocio.add(rdbtnNo);
		grupoEssocio.add(rdbtnSi);
				
		btnValidar.setIcon(new ImageIcon(PantallaFormularioPersona.class.getResource("/ar/com/ProyectoClub/AVista/icon/validar.png")));
		btnValidar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnValidar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnValidar.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnValidar.setContentAreaFilled(false);
		btnValidar.setBorderPainted(false);
		btnValidar.setBorder(null);
		btnValidar.setBounds(344, 22, 33, 22);
		panelDatosObli.add(btnValidar);
		
		JLabel lblPresioneElSiguiente = new JLabel();
		lblPresioneElSiguiente.setText("Presione el siguiente boton para validar");
		lblPresioneElSiguiente.setBounds(379, 25, 241, 14);
		panelDatosObli.add(lblPresioneElSiguiente);
		
		txtEstdoCiv = new JTextField();
		txtEstdoCiv.setEditable(false);
		txtEstdoCiv.setBounds(103, 316, 146, 20);
		panelDatosObli.add(txtEstdoCiv);
		
		JLabel lblNro = new JLabel();
		lblNro.setText("NRO");
		lblNro.setBounds(347, 153, 37, 14);
		panelDatosObli.add(lblNro);
		
		this.Escuchando();
		pack();
		
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	private void CargaYGuardarDatos(){
		Personas nuevapersona=miCoordinador.CrearPersona();
		int dni= (txtDni.getText().length()==0) ? 0: Integer.parseInt(txtDni.getText());
		nuevapersona.setDni(dni);
		nuevapersona.setNombre(txtNom.getText());
		nuevapersona.setApellido(txtApe.getText());
		nuevapersona.setFechanac(dateFechNac.getDate());
		nuevapersona.setDomicilio(txtDom.getText()+" N: "+txtDomNro.getText());
		nuevapersona.setTelefono(txtTel.getText());
		nuevapersona.setNacionalidad(txtNacion.getText());
		String estadoCivil= (cmbEstadoCivil.getSelectedItem().toString().equals("Seleccione un estado")) ? null: cmbEstadoCivil.getSelectedItem().toString();
		nuevapersona.setEstadocivil(estadoCivil);
		nuevapersona.setFechanac(dateFechNac.getDate());
		String sexo=new String();
		if(rdbMasculino.isSelected())
			sexo="M";
		if(rdbFemenino.isSelected())
			sexo="F";
		nuevapersona.setSexo(sexo);
		
		if(rdbtnSi.isSelected()){
			Socios socio= miCoordinador.CrearSocio();
			socio.setPersonas(nuevapersona);
			int matricula= (txtMatri.getText().length()==0) ? 0: Integer.parseInt(txtMatri.getText());
			socio.setMatricula(matricula);
			socio.setFechaingreso(dateFechIngreso.getDate());
			socio.setEstado("Activo");
			Categoria nuevaCategoria=miCoordinador.CrearCategoria();
			//mapCategoria viene cargado desde el controlador con los id y nombre de las categorias
			for ( Map.Entry<Integer, String> entry : mapCategoria.entrySet() ){ //recorre las categorias
				if(comboCate.getSelectedItem().equals(entry.getValue())){ //Compara nombres
					nuevaCategoria=miCoordinador.BuscarCategoria(entry.getKey()); //busca la categoria con el key del map 
					break;
				}
			}
			socio.setCategoria(nuevaCategoria);
			//llamo al metodo guardar socio
			this.limpiar();
		}
		else{
		//llamo al metodo guardar no socio(Persona)
			this.limpiar();
		}
	}


			
		
	public boolean ValidarDatos(){
		boolean retorno=false;
		if(txtApe.getText().isEmpty() || txtDni.getText().isEmpty() || txtDom.getText().isEmpty() || txtDomNro.getText().isEmpty() || dateFechNac.getDate()==null 
				|| txtTel.getText().isEmpty() || txtNacion.getText().isEmpty() || cmbEstadoCivil.getSelectedItem().toString().equals("Seleccione un estado") 
				|| dateFechNac.getDate() == null || (!rdbFemenino.isSelected() && !rdbMasculino.isSelected())){
			JOptionPane.showMessageDialog(null,"Algunos datos son obligatorios, ¡por favor verifique los mismos!","Error al verificar los datos",JOptionPane.ERROR_MESSAGE);
		}
		else{
			if(rdbtnSi.isSelected()){
				if(!txtMatri.getText().isEmpty() && !comboCate.getSelectedItem().equals(("SELECCIONE CATEGORIA")) && dateFechIngreso.getDate() != null)
					retorno=true; 
			}
			else
				retorno=true; 
		}
		return retorno;
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
		comboCate.setSelectedItem("Seleccione una categoria");
		txtNacion.setText(null);
		dateFechIngreso.setCalendar(null);
		txtDomNro.setText(null);
		
	}
	//escuchando al usuario
	private void Escuchando(){
		cmbEstadoCivil.addActionListener(this);
		rdbtnSi.addActionListener(this);
		rdbtnNo.addKeyListener(this);
		txtApe.addKeyListener(this);
		txtNom.addKeyListener(this);
		txtDni.addKeyListener(this);
		dateFechNac.addKeyListener(this);
		txtDom.addKeyListener(this);
		txtTel.addKeyListener(this);
		btnValidar.addActionListener(this);
	}
	
	

	//Eventos
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cmbEstadoCivil){
			if(cmbEstadoCivil.getSelectedItem().toString() != "Seleccione un estado")
				txtEstdoCiv.setText(cmbEstadoCivil.getSelectedItem().toString());
			else
				txtEstdoCiv.setText("");
		}
		
		if(e.getSource()==cmbEstadoCivil){
			if(cmbEstadoCivil.getSelectedItem().toString() != "Seleccione una categoria")
				txtCateg.setText(cmbEstadoCivil.getSelectedItem().toString());
			else
				txtCateg.setText("");
		}
		
		if(e.getSource() == btnRegistrar){
			if(ValidarDatos()){
				this.CargaYGuardarDatos();
			}

		}
		if(e.getSource()==btnValidar){
			this.ValidarDatosIngresados();
		}
		if(e.getSource() == btnLimpiar){
			this.limpiar();
		}
		if(e.getSource() == btnVolver){
			this.limpiar();
			this.dispose();

		}
	}

	private void BotonesSocioHabilitado(boolean valor) {
		
		txtMatri.setEnabled(valor);
		comboCate.setEnabled(valor);
		dateFechIngreso.setEnabled(valor);
		txtCateg.setEnabled(valor);
		
	}
	private void HabilitarBotonoes(boolean valor){

		txtApe.setEnabled(valor);
		txtDni.setEnabled(valor);
		txtDom.setEnabled(valor);
		txtDomNro.setEnabled(valor);
		txtMatri.setEnabled(valor);
		txtNacion.setEnabled(valor);
		txtNom.setEnabled(valor);
		txtTel.setEnabled(valor);
		rdbFemenino.setEnabled(valor);
		rdbMasculino.setEnabled(valor);
		cmbEstadoCivil.setEnabled(valor);
		txtMatri.setEnabled(valor);
		rdbtnNo.setEnabled(valor);
		rdbtnSi.setEnabled(valor);
		dateFechIngreso.setEnabled(valor);
		dateFechNac.setEnabled(valor);
		cmbEstadoCivil.setEnabled(valor);
		comboCate.setEnabled(valor);
	}

	private void ValidarDatosIngresados() {
		if(!txtDni.getText().isEmpty()){
			Personas persona=miCoordinador.CrearPersona();
			persona=miCoordinador.ValidarPersona(Integer.parseInt(txtDni.getText()));
			this.HabilitarBotonoes(true);
			if(persona != null){
				txtMatri.setEnabled(false); //No se puede moficar la matricula
				lblEstado.setText("ESTADO: PERSONA YA REGISTRADA");
				txtApe.setText(persona.getApellido());
				txtNom.setText(persona.getNombre());
				txtTel.setText(persona.getTelefono());
				//separo en 2 el domicilio
				String[] divisor = persona.getDomicilio().split("-");
				txtDom.setText(divisor[0]);
				txtDomNro.setText(divisor[1]);
				dateFechNac.setDate(persona.getFechanac());
				txtNacion.setText(persona.getNacionalidad());
				if(!persona.getSexo().equals("M"))
					rdbFemenino.setSelected(true); 
				else
					rdbMasculino.setSelected(true);
				txtEstdoCiv.setText(persona.getEstadocivil());
				//si es socio
				if(persona.isEssocio()){
					rdbtnSi.setSelected(true);
					txtMatri.setText(persona.getSocios().getMatricula().toString());
					dateFechIngreso.setDate(persona.getSocios().getFechaingreso());
					txtCateg.setText(persona.getSocios().getCategoria().getIdCategoria()+"-"+persona.getSocios().getCategoria().getNombre());

				}
				else
					rdbtnNo.setSelected(true);
				
			}
		}
		else
			JOptionPane.showMessageDialog(null,"El numero de documento es obligatorio","Error",JOptionPane.ERROR_MESSAGE);

	}
	//Depende si se cieere o si busca bloquea o no
	


	@Override
	public void keyPressed(KeyEvent e) {	
		try{
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				if(ValidarDatos())
					this.CargaYGuardarDatos();
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
