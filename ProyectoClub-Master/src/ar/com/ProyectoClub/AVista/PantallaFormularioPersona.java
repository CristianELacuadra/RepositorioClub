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
import java.util.ArrayList;
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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
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
	public JRadioButton rdbtnSi;
	public JRadioButton rdbtnNo;
	public JRadioButton rdbFemenino;
	public JRadioButton rdbMasculino;
	private JButton btnValidar;
	private JLabel lblEstado;
	private JPanel panel;
	public JTextField txtEstdoCiv;
	public static boolean TipoEntrada;

	public PantallaFormularioPersona(PantallaPrincipalPersonas vtnPantallaPersona,boolean b) {  
		super(vtnPantallaPersona,b);
		setFont(new Font("Courier New", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaFormularioPersona.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
				miCoordinador.CargarGrilla(PantallaPrincipalPersonas. tablaPersona);
				HabilitarBotonoes(false);
				dispose();
			}
		});
		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	private void initComponents(){
		//Instanciamos los componentes
		lblEstado= new JLabel();
		lblEstado.setForeground(Color.BLACK);
		btnValidar= new JButton();
		rdbMasculino = new JRadioButton();
		rdbMasculino.setEnabled(false);
		rdbFemenino= new JRadioButton();
		rdbFemenino.setEnabled(false);
		grupoSexo=new ButtonGroup();
		grupoEssocio=new ButtonGroup();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		panelTitulo= new JPanel();
		panelTitulo.setBounds(15, 15, 796, 31);
		panelTitulo.setBackground(new Color(250, 250, 210));
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
		txtMatri.setBackground(new Color(250, 250, 210));
		txtMatri.setEnabled(false);
		txtMatri.setBounds(98, 24, 103, 20);
		PanelDatosSocio.add(txtMatri);
		lblFechingreso = new JLabel();
		lblFechingreso.setBounds(22, 88, 95, 14);
		PanelDatosSocio.add(lblFechingreso);

		
		lblFechingreso.setText("FECHA INGRESO");
		dateFechIngreso = new JDateChooser();
		dateFechIngreso.setBackground(new Color(250, 250, 210));
		dateFechIngreso.setEnabled(false);
		dateFechIngreso.setBounds(128, 86, 138, 20);
		PanelDatosSocio.add(dateFechIngreso);
		lblCate= new JLabel();
		lblCate.setBounds(22, 61, 69, 14);
		PanelDatosSocio.add(lblCate);
		
		
		lblCate.setText("CATEGORIA");
		comboCate= new JComboBox();
		comboCate.setBackground(new Color(250, 250, 210));
		comboCate.setEnabled(false);
		comboCate.setBounds(98, 55, 211, 20);
		
		PanelDatosSocio.add(comboCate);
		panelDatosObli.setLayout(null);
		lblDni = new JLabel();
		lblDni.setBounds(20, 25, 51, 14);
		panelDatosObli.add(lblDni);
		
		
		lblDni.setText("DNI");
		txtDni = new JTextField();
		txtDni.setBackground(new Color(250, 250, 210));
		txtDni.setBounds(83, 22, 251, 20);
		panelDatosObli.add(txtDni);
		//
		lblApe = new JLabel();
		lblApe.setBounds(20, 56, 81, 14);
		panelDatosObli.add(lblApe);
		
		
		lblApe.setText("APELLIDO");
		txtApe = new JTextField();
		txtApe.setBackground(new Color(250, 250, 210));
		txtApe.setEnabled(false);
		txtApe.setBounds(83, 53, 251, 20);
		panelDatosObli.add(txtApe);
		txtNom = new JTextField();
		txtNom.setBackground(new Color(250, 250, 210));
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
		dateFechNac.setBackground(new Color(250, 250, 210));
		dateFechNac.setEnabled(false);
		dateFechNac.setBounds(159, 191, 117, 20);
		panelDatosObli.add(dateFechNac);
		lblDom = new JLabel();
		lblDom.setBounds(20, 153, 81, 14);
		panelDatosObli.add(lblDom);
		
		
		lblDom.setText("DOMICILIO");
		txtDom = new JTextField();
		txtDom.setBackground(new Color(250, 250, 210));
		txtDom.setEnabled(false);
		txtDom.setBounds(83, 150, 251, 20);
		panelDatosObli.add(txtDom);
		
		txtDomNro = new JTextField();
		txtDomNro.setBackground(new Color(250, 250, 210));
		txtDomNro.setEnabled(false);
		txtDomNro.setBounds(388, 150, 51, 20);
		panelDatosObli.add(txtDomNro);
		txtTel = new JTextField();
		txtTel.setBackground(new Color(250, 250, 210));
		txtTel.addKeyListener(new KeyAdapter() {
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
		//lblEstado.setText("ESTADO:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
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
		txtNacion.setBackground(new Color(250, 250, 210));
		txtNacion.setEnabled(false);
		txtNacion.setBounds(133, 283, 251, 20);
		panelDatosObli.add(txtNacion);
		lblEstCivil = new JLabel();
		lblEstCivil.setBounds(20, 319, 98, 14);
		panelDatosObli.add(lblEstCivil);
		
		
		lblEstCivil.setText("ESTADO CIVIL");
		
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
		btnLimpiar.setIcon(new ImageIcon(PantallaFormularioPersona.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png")));
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
		btnRegistrar.addActionListener(this);
		btnLimpiar.addActionListener(this);
		btnVolver.addActionListener(this);
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
		
		JLabel lblNro = new JLabel();
		lblNro.setText("NRO");
		lblNro.setBounds(347, 153, 37, 14);
		panelDatosObli.add(lblNro);
		
		txtEstdoCiv = new JTextField();
		txtEstdoCiv.setBackground(new Color(250, 250, 210));
		txtEstdoCiv.setEnabled(false);
		txtEstdoCiv.setBounds(99, 316, 117, 20);
		panelDatosObli.add(txtEstdoCiv);
		
		this.Escuchando();
		pack();
		
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	private void CargaYGuardarDatos(){
		try{
		Personas nuevapersona=miCoordinador.CrearPersona();
		int dni= Integer.parseInt(txtDni.getText().replaceAll("\\s*$",""));
		Personas nueva=miCoordinador.BuscarPersona(dni);
		if (nueva != null)
			nuevapersona=nueva;
		if(nuevapersona.getSocios() != null && nuevapersona.getSocios().getEstado().equals("MOROSO"))
			throw new RuntimeException("Socio bloqueado por falta de pago");
		nuevapersona.setDni(dni);
		nuevapersona.setNombre(txtNom.getText());
		nuevapersona.setApellido(txtApe.getText());
		nuevapersona.setFechanac(dateFechNac.getDate());
		String domicilio=txtDom.getText()+"- "+txtDomNro.getText();
		nuevapersona.setDomicilio(domicilio.replaceAll("\\s",""));
		nuevapersona.setTelefono(txtTel.getText());
		nuevapersona.setNacionalidad(txtNacion.getText());
		String estadoCivil=txtEstdoCiv.getText(); 
		//(cmbEstadoCivil.getSelectedItem().toString().equals("Seleccione un estado")) ? null: cmbEstadoCivil.getSelectedItem().toString();
		nuevapersona.setEstadocivil(estadoCivil);
		String sexo=new String();
		if(rdbMasculino.isSelected())
			sexo="M";
		if(rdbFemenino.isSelected())
			sexo="F";
		nuevapersona.setSexo(sexo);
		nuevapersona.setHabilitado(true);
		if(rdbtnSi.isSelected()){
			//nuevapersona.setEssocio(true);
			Socios socio= miCoordinador.CrearSocio();
			Socios socioExistente= miCoordinador.BuscarSocio(dni);
			if(socioExistente != null)
				socio=socioExistente;
			//socio.setDni(nuevapersona.getDni());
			socio.setEstado("ACTIVO");
			socio.setFechaingreso(dateFechIngreso.getDate());
			socio.setBaja(false);
			socio.setMatricula(Integer.parseInt(txtMatri.getText()));
			Categoria nuevaCategoria=miCoordinador.CrearCategoria();
			nuevaCategoria= miCoordinador.BuscarCategoriaNombre(comboCate.getSelectedItem().toString()); //BuscarCategoria(Integer.parseInt(id[0]));
			socio.setCategoria(nuevaCategoria);
			socio.setPersonas(nuevapersona);
			nuevapersona.setSocios(socio);
			//mapCategoria viene cargado desde el controlador con los id y nombre de las categorias
			//for ( Map.Entry<Integer, String> entry : mapCategoria.entrySet() ){ //recorre las categorias
			//	if(comboCate.getSelectedItem().equals(entry.getValue())){ //Compara nombres
			//		nuevaCategoria=miCoordinador.BuscarCategoria(entry.getKey()); //busca la categoria con el key del map 
			//		break;
			//	}
			//	}		
		}
		if(rdbtnNo.isSelected()){
			if(nuevapersona.getSocios() != null)
				nuevapersona.getSocios().setBaja(true);
		}
		miCoordinador.GuardarPersona(nuevapersona,TipoEntrada);
		JOptionPane.showMessageDialog(null,"Persona registrada con exito","Mensaje",JOptionPane.INFORMATION_MESSAGE);
		limpiar();
		miCoordinador.CargarGrilla(PantallaPrincipalPersonas. tablaPersona);
		this.HabilitarBotonoes(false);
		dispose();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	


			
		
	public boolean ValidarDatos(){
		boolean retorno=false;
		if(!txtDni.getText().isEmpty() && !txtApe.getText().isEmpty() && !txtNom.getText().isEmpty() && !txtDom.getText().isEmpty() 
				   && !txtDomNro.getText().isEmpty() && !dateFechNac.getDate().equals(null) 
				   && !txtTel.getText().isEmpty() && !txtNacion.getText().isEmpty() && !txtEstdoCiv.getText().isEmpty()
			 	   && (!rdbFemenino.isSelected() || !rdbMasculino.isSelected()))
		{
			if(rdbtnSi.isSelected()){
				String txt; 
				txt=comboCate.getSelectedItem().toString(); 
				if(!txtMatri.getText().isEmpty() && (!txt.isEmpty() && txt.toString()!=null)  && !dateFechIngreso.getDate().equals(null))
					retorno=true; 
			}
			else
				retorno=true; 
		}
		else
			JOptionPane.showMessageDialog(null,"Algunos datos son obligatorios, �por favor verifique los mismos!","Error al verificar los datos",JOptionPane.ERROR_MESSAGE);
		
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
		txtDni.setEnabled(true);
		txtApe.setText(null);
		txtNom.setText(null);
		dateFechNac.setCalendar(null);
		txtDom.setText(null);
		txtTel.setText(null);
		txtMatri.setText(null);
		txtEstdoCiv.setText(null);
		comboCate.removeAllItems();
		txtNacion.setText(null);
		dateFechIngreso.setCalendar(null);
		txtDomNro.setText(null);
		lblEstado.setText(null);
		lblEstado.setForeground(Color.black);
		LimpiarCategoria();
	}
	private void LimpiarCategoria(){
		//Limpio
		comboCate.removeAllItems();
		//Obtengo los nombres de las categorias
		ArrayList<String> listaNombre = new ArrayList<String>();
		listaNombre=miCoordinador.ObtenerNombreCategorias();  
		comboCate.addItem("Seleccione una Categoria");
		for(int i=0; i<listaNombre.size(); i++){
			comboCate.addItem(listaNombre.get(i));
		}
	}
	//limpiar
	private void limpiar2(){
		txtApe.setText(null);
		txtNom.setText(null);
		dateFechNac.setCalendar(null);
		txtDom.setText(null);
		txtTel.setText(null);
		txtMatri.setText(null);
		txtEstdoCiv.setText(null);
		comboCate.setSelectedItem("Seleccione una categoria");
		txtNacion.setText(null);
		dateFechIngreso.setCalendar(null);
		txtDomNro.setText(null);
		lblEstado.setForeground(Color.black);
	}
	//escuchando al usuario
	private void Escuchando(){
		//comboCate.addActionListener(this);
		rdbtnSi.addActionListener(this);
		rdbtnNo.addKeyListener(this);
		txtApe.addKeyListener(this);
		txtNom.addKeyListener(this);
		txtDni.addKeyListener(this);
		dateFechNac.addKeyListener(this);
		txtDom.addKeyListener(this);
		//txtTel.addKeyListener(this);
		btnValidar.addActionListener(this);
		//comboCate.removeAllItems();
	}
	
	

	//Eventos
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegistrar){
			if(ValidarDatos()){
				this.CargaYGuardarDatos();
			}

		}
		//System.out.println("");
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
		txtEstdoCiv.setEnabled(valor);
		rdbtnNo.setEnabled(valor);
		rdbtnSi.setEnabled(valor);
		dateFechIngreso.setEnabled(valor);
		dateFechNac.setEnabled(valor);
		comboCate.setEnabled(valor);
	}

	private void ValidarDatosIngresados() {
		if(!txtDni.getText().isEmpty()){
			Personas persona=miCoordinador.CrearPersona();
			persona=miCoordinador.ValidarPersona(Integer.parseInt(txtDni.getText()));
			this.HabilitarBotonoes(true);
			if(persona != null){
				lblEstado.setText("REGISTRADA");
				//limpiar2();
				lblEstado.setForeground(Color.RED);
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
				if(persona.getSocios() != null && !persona.getSocios().isBaja() ){
					rdbtnSi.setSelected(true);
					BotonesSocioHabilitado(true);
					txtMatri.setText(persona.getSocios().getMatricula().toString());
					dateFechIngreso.setDate(persona.getSocios().getFechaingreso());
				}
				else{
					rdbtnNo.setSelected(true);
					BotonesSocioHabilitado(false);
				}
			}
			else
			{
				lblEstado.setText("NO REGISTRADA");
				lblEstado.setForeground(Color.GREEN);
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
