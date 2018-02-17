package ar.com.ProyectoClub.AVista;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import ar.com.ProyectoClub.AVista.ClasesRender.FechasCalendar;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Socios;

import com.mysql.fabric.xmlrpc.base.Array;
import com.toedter.calendar.JDateChooser;

import javax.swing.JDialog;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Calendar;

import javax.swing.SpinnerNumberModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.BevelBorder;

import java.awt.Rectangle;

import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class PantallaNuevoAlquiler extends JDialog implements ActionListener,KeyListener {
	public JTextField txtDni;
	private ControllerCoordinador miCoordinador;
	public JLabel lblHoraDeReserva;
	public JLabel lblCantidadDeHoras;
	public JLabel lblInmuebleAlquilar;
	public JLabel lblPrecioTotal;
	//public JDateChooser dateFechaReserva;
	public JTextField ResuPrecioTotal;
	public JButton btnAceptar;
	public JButton btnCancelar;
	public JButton btnLimpiar;
	public JLabel lblCodSocio;
	public JLabel LabelSocioDes;
	public JPanel panelTitulo;
	public JCheckBox chcAlquilerPagado;
	public JButton btnBuscarPersona;
	public JLabel label;
	public JScrollPane scrollPane;
 	public JTextArea txtObservaciones;
 	public Integer auxIdInm;
 	public Inmuebles inm;
 	public Personas pers;
 	public Alquiler alqui,oldAlqui;
 	public Socios socio;
 	public JComboBox<String> comboInmuebles;
 	public Map<Integer, String> mapInmueble = new HashMap<Integer, String>();
 	
 	public Integer num;
 	public JTextField txtApe;
 	public JTextField txtNom;
 	public JTextField txtSen;
 	public JTextField txtMontoApagar;
 	public JTextField txtMontoFaltante;
 	private JLabel lSolucionBusqueda;
	private java.util.List<Personas> listaPersonas;
	public JComboBox<String> comboResult;
	public Map<Integer, String> mapPersona = new HashMap <Integer,String>();
	public JSpinner txtHoraR;
	public JSpinner txtCantidadHoras;
	private JPanel panelPersona;
	public JCalendar calen;
	private JPanel panelAlquileresDia;
	private JScrollPane scrollPane_1;
	public JTable tableDia;
	public FechasCalendar Colorear;
	
	
	public PantallaNuevoAlquiler(PantallaAlquilerPrincipal vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
				miCoordinador.recargarPanelAlquiler();
				setVisible(false);
			}
		});
		
		//setResizable(false);
		setTitle("NUEVO ALQUILER");
		initComponents();
		setBounds(50, 50, 862, 718);

	}

	public void initComponents(){
		miCoordinador=new ControllerCoordinador();
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(10, 11, 814, 35);
		panelTitulo.setBackground(new Color(0, 191, 255));
		panelTitulo.setBorder(UIManager.getBorder("ComboBox.border"));


		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE NUEVO ALQUILER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTitulo.add(lblNewLabel_1);
		getContentPane().setLayout(null);
		
		getContentPane().add(panelTitulo);
		
		panelPersona = new JPanel();
		panelPersona.setBounds(10, 60, 680, 124);
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		panelPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Datos de Personas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		btnBuscarPersona = new JButton("Buscar");
		btnBuscarPersona.setBounds(347, 22, 129, 59);
		panelPersona.add(btnBuscarPersona);
		btnBuscarPersona.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPersona.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscaF1.png")));
		
		lSolucionBusqueda = new JLabel("LISTO");
		lSolucionBusqueda.setBounds(496, 44, 88, 14);
		panelPersona.add(lSolucionBusqueda);
		
		txtDni = new JTextField();
		txtDni.setBounds(170, 16, 167, 20);
		panelPersona.add(txtDni);
		txtDni.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDni.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(170, 41, 167, 20);
		panelPersona.add(txtNom);
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(170, 66, 167, 20);
		panelPersona.add(txtApe);
		txtApe.setHorizontalAlignment(SwingConstants.RIGHT);
		txtApe.setColumns(10);
		
		
		
		comboResult = new JComboBox<String>();
		comboResult.setBounds(170, 93, 167, 20);
		panelPersona.add(comboResult);
		
		lblCodSocio = new JLabel("DNI  DE LA PERSONA");
	
		lblCodSocio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodSocio.setBounds(10, 16, 150, 20);
		panelPersona.add(lblCodSocio);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO  DE LA PERSONA");
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 66, 150, 20);
		panelPersona.add(lblNewLabel_2);
		
		JLabel lblNombreDeLa = new JLabel("NOMBRE DE LA PERSONA");
	
		lblNombreDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeLa.setBounds(10, 41, 150, 20);
		panelPersona.add(lblNombreDeLa);
		
		LabelSocioDes = new JLabel("*Precio con descuento por Socio");
		LabelSocioDes.setBounds(347, 96, 184, 14);
		panelPersona.add(LabelSocioDes);
		LabelSocioDes.setVisible(false);
		
		JPanel panelReserva = new JPanel();
		panelReserva.setBounds(10, 195, 826, 461);
		getContentPane().add(panelReserva);
		panelReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Datos de la Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		panelReserva.setLayout(null);
		lblInmuebleAlquilar = new JLabel("INMUEBLE A ALQUILAR");
		lblInmuebleAlquilar.setBounds(10, 25, 125, 20);
		panelReserva.add(lblInmuebleAlquilar);
		
		lblInmuebleAlquilar.setHorizontalAlignment(SwingConstants.RIGHT);
		
		comboInmuebles = new JComboBox<String>();
		comboInmuebles.setEnabled(false);
		comboInmuebles.setBounds(155, 25, 180, 20);
		panelReserva.add(comboInmuebles);
		
			comboInmuebles.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione el inmueble"}));
			lblHoraDeReserva = new JLabel("HORA DE RESERVA");
			lblHoraDeReserva.setBounds(10, 50, 125, 20);
			panelReserva.add(lblHoraDeReserva);
			
			lblHoraDeReserva.setHorizontalAlignment(SwingConstants.RIGHT);
			
			txtHoraR = new JSpinner();
			txtHoraR.setEnabled(false);
			txtHoraR.setBounds(155, 50, 180, 20);
			panelReserva.add(txtHoraR);
			txtHoraR.setModel(new SpinnerNumberModel(6, 6, 23, 1));
			
			txtCantidadHoras = new JSpinner();
			txtCantidadHoras.setEnabled(false);
			
			
			txtCantidadHoras.setBounds(155, 75, 180, 20);
			panelReserva.add(txtCantidadHoras);
			txtCantidadHoras.setModel(new SpinnerNumberModel(1, 1, 24, 1));
			lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS ");
			lblCantidadDeHoras.setBounds(13, 75, 125, 20);
			panelReserva.add(lblCantidadDeHoras);
			
			lblCantidadDeHoras.setHorizontalAlignment(SwingConstants.RIGHT);
			
			JLabel lblNewLabel_3 = new JLabel("SE\u00D1A");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(10, 100, 125, 20);
			panelReserva.add(lblNewLabel_3);
			
			txtSen = new JTextField();
			txtSen.setEnabled(false);
			txtSen.setEditable(false);
			txtSen.setBounds(155, 100, 180, 20);
			panelReserva.add(txtSen);
			txtSen.setBackground(new Color(204, 204, 204));
			txtSen.setHorizontalAlignment(SwingConstants.RIGHT);
			txtSen.setColumns(102);
			
			ResuPrecioTotal = new JTextField();
			ResuPrecioTotal.setEnabled(false);
			ResuPrecioTotal.setBounds(155, 125, 180, 20);
			panelReserva.add(ResuPrecioTotal);
			ResuPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			ResuPrecioTotal.setBackground(new Color(204, 204, 204));
			ResuPrecioTotal.setBorder(UIManager.getBorder("ComboBox.border"));
			ResuPrecioTotal.setEditable(false);
			lblPrecioTotal = new JLabel("PRECIO TOTAL: $");
			lblPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrecioTotal.setBounds(10, 125, 125, 20);
			panelReserva.add(lblPrecioTotal);
			
			JLabel lblNewLabel_4 = new JLabel("\u00BFCUANTO VA A PAGAR?");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(10, 184, 125, 20);
			panelReserva.add(lblNewLabel_4);
			
			txtMontoApagar = new JTextField();
			txtMontoApagar.setEnabled(false);
			txtMontoApagar.setBounds(155, 184, 180, 20);
			panelReserva.add(txtMontoApagar);
			txtMontoApagar.setHorizontalAlignment(SwingConstants.RIGHT);
			txtMontoApagar.setColumns(10);
			
			chcAlquilerPagado = new JCheckBox("PAGAR POR COMPLETO");

			chcAlquilerPagado.setEnabled(false);
			chcAlquilerPagado.setBounds(155, 150, 145, 23);
			panelReserva.add(chcAlquilerPagado);
			chcAlquilerPagado.setToolTipText("Seleccionar cuando se pagar\u00E1 en el momento");
			
			txtMontoFaltante = new JTextField();
			txtMontoFaltante.setEnabled(false);
			txtMontoFaltante.setBounds(155, 209, 180, 20);
			panelReserva.add(txtMontoFaltante);
			txtMontoFaltante.setBackground(new Color(204, 204, 204));
			txtMontoFaltante.setEditable(false);
			txtMontoFaltante.setHorizontalAlignment(SwingConstants.RIGHT);
			txtMontoFaltante.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("MONTO FALTANTE");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setBounds(10, 209, 125, 20);
			panelReserva.add(lblNewLabel_5);
			
			label = new JLabel("OBSERVACIONES:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(10, 263, 88, 20);
			panelReserva.add(label);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 304, 271, 113);
			panelReserva.add(scrollPane);
			
			txtObservaciones = new JTextArea();
			txtObservaciones.setEnabled(false);
			txtObservaciones.setLineWrap(true);
			scrollPane.setViewportView(txtObservaciones);
									
			calen = new JCalendar();
			calen.setBounds(354, 25, 300, 265);
			panelReserva.add(calen);
			calen.getDayChooser().setAlwaysFireDayProperty(true);
			calen.getYearChooser().setDayChooser(calen.getDayChooser());
			calen.getMonthChooser().setDayChooser(calen.getDayChooser());
			calen.getMonthChooser().setYearChooser(calen.getYearChooser());
						
			calen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			calen.setWeekOfYearVisible(false);		
			calen.setTodayButtonVisible(true);
			Calendar min= new GregorianCalendar(2015, 1, 1);
			calen.setMinSelectableDate(min.getTime() );
			Colorear= new FechasCalendar();
			calen.getDayChooser().addDateEvaluator(Colorear);
										
			btnAceptar = new JButton("Guardar");
			btnAceptar.setBounds(354, 323, 90, 51);
			panelReserva.add(btnAceptar);
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAceptar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/aceptar.png")));
			btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(469, 323, 90, 51);
			panelReserva.add(btnCancelar);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCancelar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/cancel.png")));
			btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
													
			btnLimpiar = new JButton("Limpiar Campos");
			btnLimpiar.setBounds(591, 323, 129, 103);
			panelReserva.add(btnLimpiar);
			btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnLimpiar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnLimpiar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png")));
													
			panelAlquileresDia = new JPanel();
			panelAlquileresDia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
			panelAlquileresDia.setBounds(664, 25, 152, 265);
			panelReserva.add(panelAlquileresDia);
			panelAlquileresDia.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panelAlquileresDia.add(scrollPane_1, BorderLayout.CENTER);
			
			tableDia=new JTable();
			tableDia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tableDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			tableDia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_1.setViewportView(tableDia);
			tableDia.setModel(new DefaultTableModel( new String [] {"horarios","inmueble"},0){
				public boolean isCellEditable(int row,int colum){  
				return false;
				}
			});
			tableDia.setRowHeight(25);
			tableDia.setToolTipText("No hay Alquileres este Día");
			tableDia.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AccionesTablaDia(e);
				}
			});
			
			
			
			btnLimpiar.addActionListener(this);
			btnCancelar.addActionListener(this);
			btnAceptar.addActionListener(this);
			chcAlquilerPagado.addActionListener(this);
							
			calen.getDayChooser().addPropertyChangeListener(
				new java.beans.PropertyChangeListener() {
					@SuppressWarnings("deprecation")
					public void propertyChange(java.beans.PropertyChangeEvent evt) {
						 if (evt.getPropertyName().compareTo("day") == 0) {
							java.util.List<Alquiler> listaAl=new ArrayList<Alquiler>();
							Calendar lala= calen.getCalendar();
							
//							Integer anio=lala.get(Calendar.YEAR);
//							Integer mes = lala.get(Calendar.MONTH);
//							Integer dia=lala.get(Calendar.DAY_OF_MONTH);
//							miCoordinador.mensajes("año: "+anio+ ", mes: "+ mes +", Dia: " +dia ,1);

							listaAl=miCoordinador.ListarAlquilerPorDia(lala.get(Calendar.YEAR),lala.get(Calendar.MONTH)+1,lala.get(Calendar.DAY_OF_MONTH));
							if((listaAl!=null)){
								miCoordinador.CargarTablaAlquilerPorDia(tableDia,listaAl,comboInmuebles.getSelectedItem());
								}else {
									DefaultTableModel dm=(DefaultTableModel) tableDia.getModel();
									int con=dm.getRowCount();
									for(int i=con-1;i>=0;i--){
										dm.removeRow(i);
									}
									tableDia.setModel(dm);
								}
								
							}
										
						}	
					}
				);
			comboResult.setVisible(false);

			comboResult.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if((e.getStateChange() == ItemEvent.SELECTED)&&(e.getItem().toString()!= "Seleccione una persona"))
					{
						for(Map.Entry<Integer, String> ent :mapPersona.entrySet())
						{
							if(ent.getValue().toString().equals(e.getItem().toString() ))
							{
								pers= miCoordinador.CrearPersona();
								pers=miCoordinador.BuscarPersona(ent.getKey());
								
								if(personaHabilitadaParaAlquiler(pers)){	
										txtApe.setText(pers.getApellido().toString());
										txtNom.setText(pers.getNombre().toString());
										lSolucionBusqueda.setVisible(true);
										comboResult.setVisible(false);
										habilitarCampoPersona(false);
										comboInmuebles.setEnabled(true);
										
										
								}else 
									miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 2);
								}
							}
						}
				}
			});
			
				//TODO combobox accion inmuebles			
	comboInmuebles.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ed) {
				// TODO se esta ejecutando mal		
				
				if((comboInmuebles.getSelectedIndex()!=-1)&&(ed.getStateChange() == ItemEvent.SELECTED)&&(ed.getItem().toString()!="Seleccione el inmueble"))
				{
					for (Map.Entry<Integer, String> entry : mapInmueble.entrySet())
					{
						if(entry.getValue().toString()==ed.getItem().toString())
						{
							
							inm=new Inmuebles();
							auxIdInm=entry.getKey();
							inm=miCoordinador.BuscarInmueble(auxIdInm);
							habilitarCamporReserva(true,true);		
							txtHoraR.setValue(6);
							if((pers.getDni()!=null)&&(inm.getIdInmubles()!=null)&&
									((oldAlqui==null)||(inm.getIdInmubles()!=oldAlqui.getInmuebles().getIdInmubles()))){
								txtSen.setText(Float.toString(inm.getSenial()));
								ResuPrecioTotal.setText(Float.toString(CalcularPrecioTotal(pers, inm,(Integer) txtCantidadHoras.getValue())));
							}
							
							
							Colorear.setNombreInmueble(inm.getNombre());
							Calendar hoyCreo= new GregorianCalendar();
							calen.setDate(hoyCreo.getTime());
							//COMPROBAR LA FUNCION DE CARGA DE TABLA Y COLOR
							// SI COLOREA POR INMUEBLE
						}

					}
				}else{
					
					Colorear.nullNombreInmuble();
					inm=new Inmuebles();
					Calendar hoyCreo= new GregorianCalendar();
					calen.setDate(hoyCreo.getTime());
				}
				
			}
		});
		 

		
		txtHoraR.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// Ponemos el valor del JSpinner en el JTextField
				Integer.parseInt(txtHoraR.getValue().toString());
				txtCantidadHoras.setModel(new SpinnerNumberModel(1, 1,(30-Integer.parseInt(txtHoraR.getValue().toString())),1));			
		//los alquileres empiezan desde las 6 hasta las 23
				//todos los alquileres tienen como maximo hasta las 6 del otro dia
				//esta funcion determina el numero maximo de horas para alquilar, 
				//falta completar cuando es un dia con alquileres ya cargados
			}
		});
		txtCantidadHoras.addChangeListener(new ChangeListener() {
			public void stateChanged (ChangeEvent e){
				/*compara los valores que no esten en nulo, 
				y en caso de funcion modificar, no calcula el
				 jtexfield ResuTrecioTotal a 
				menos que cambie la cantidad de horas*/
				if((pers.getDni()!=null)
						&&(inm.getIdInmubles()!=null)
						&&((oldAlqui==null)||(oldAlqui.getCantidadhoras()!=(Integer) txtCantidadHoras.getValue()))
						){
					ResuPrecioTotal.setText(Float.toString(CalcularPrecioTotal(pers, inm,(Integer) txtCantidadHoras.getValue())));
				
				}
				
			}
		});

		
		
		
		//TODO funcion de numeros solo
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numero=e.getKeyChar(); 
				if((Character.isDigit(numero))||(numero=='\b')){
					if(txtDni.getText().length()>7)
						e.consume();// que no pase los 8 digitos
					
				}else{	getToolkit().beep(); 
					e.consume(); 
					JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txtMontoApagar.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){
				try {
					char tecla=e.getKeyChar();
					if((Character.isDigit(tecla))||(tecla=='\b')||(tecla=='.')){
						if(txtMontoApagar.getText().indexOf(".")!=-1){
							int	aux1=txtMontoApagar.getText().indexOf(".");
							int aux2=txtMontoApagar.getText().length();
							if(((aux2-1)-aux1)>1)
								e.consume();
						}
					}else{
						getToolkit().beep(); 
						e.consume(); 
						JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null,"Ocurrio un error en el teclado","ERROR",JOptionPane.ERROR_MESSAGE);
//					e1.printStackTrace();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				float precio = 0;
				if(oldAlqui==null)
					 precio=Float.parseFloat(ResuPrecioTotal.getText());	
				else{
					if(oldAlqui.getMontofaltante()!=0)
						precio=oldAlqui.getMontofaltante();
				}
				if(!txtMontoApagar.getText().isEmpty()){
					txtMontoFaltante.setText(Float.toString(calcularMontoFaltante
						(precio,Float.parseFloat(txtMontoApagar.getText()))));
				}else{
					txtMontoFaltante.setText(Float.toString(calcularMontoFaltante
							(precio	,0)));
				}
				 
			}
		});
		
		lSolucionBusqueda.setVisible(false);
		btnBuscarPersona.addActionListener(this);
		
	}
	//TODO final de init

	public float calcularMontoFaltante(float montoRestante,float montoApagar){
		try {// MontoRestante sirve para monto total o  monto faltante de oldalquiler
			float montoFaltante=0;
			if(montoRestante>0){
				montoFaltante=montoRestante-montoApagar;
			}
			if(montoFaltante<0){
				montoFaltante=0;
				montoApagar=montoRestante-montoFaltante;
				txtMontoApagar.setText(Float.toString(montoApagar));
			}
			
			
			
			return montoFaltante;
		} catch (Exception e) {
			miCoordinador.mensajes("Error de calculo: "+ e.getMessage(), 0);
			return montoRestante; 
		}
	}
	
	
	public void habilitarCamporReserva(boolean b,boolean monto_Apagar){
		txtHoraR.setEnabled(b);
		txtCantidadHoras.setEnabled(b);
		txtSen.setEnabled(b);
		ResuPrecioTotal.setEnabled(b);
		chcAlquilerPagado.setEnabled(b);
		txtMontoApagar.setEnabled(monto_Apagar);
		txtMontoFaltante.setEnabled(b);
		txtObservaciones.setEnabled(b);	
	}
	public void AccionesTablaDia(MouseEvent e){
		Integer fila,aux;
		try{
			fila=tableDia.getSelectedRow();
			if(fila!=-1){
				DefaultTableModel modelo=(DefaultTableModel) tableDia.getModel();
				aux=(Integer) modelo.getValueAt(fila, 3);
				//Alquiler AlquilerDetalle=miCoordinador.buscarAlquiler(aux);
				miCoordinador.mostrarVentanaDetallesAlquiler(aux);
				
			}
			
			
			
			
			
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Error: Al seleccionar una fila \nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void cargarComboBoxDeBusquedaDePersonas(java.util.List<Personas> listaPersonas2){
		comboResult.removeAllItems();
		mapPersona.clear();
		comboResult.addItem("Seleccione una persona");
		for (Personas _per: listaPersonas2){
			comboResult.addItem(_per.getApellido()+" "+_per.getNombre());
			mapPersona.put(_per.getDni(), _per.getApellido()+" "+_per.getNombre());		
		}	
		comboResult.setVisible(true);
	}
	
	
	public void cargarCombo(){
		comboInmuebles.removeAllItems();
		mapInmueble.clear();
		comboInmuebles.addItem("Seleccione el inmueble");
		for (Inmuebles _inm :miCoordinador.ListarInmueblesAlquiler())
		{
			comboInmuebles.addItem(_inm.getNombre());
			mapInmueble.put(_inm.getIdInmubles(), _inm.getNombre());
			//carga el combobox con los nombres de los inmuebles y usa un mapeo para
			//la puedo usar para mostrar los resultados de list usuarios cuando es mas de uno en un combobox con mapeo.
		}
	}
	
	
	//TODO funcion Limpiar
	public void limpiar(){
		/**panel de personas**/
		txtDni.setText(null);
		txtApe.setText(null);
		txtNom.setText(null);
		pers=null;
		habilitarCampoPersona(true);	
		lSolucionBusqueda.setVisible(false);
		comboResult.setVisible(false);
		comboResult.removeAllItems();
		mapPersona.clear();
		listaPersonas= new ArrayList<Personas>();
		LabelSocioDes.setVisible(false);
		
		/**Panel de reserva**/
		comboInmuebles.removeAllItems();
		mapInmueble.clear();
		comboInmuebles.addItem("Seleccione el inmueble");
		habilitarCamporReserva(false,false);
		txtHoraR.setValue(6);
		txtCantidadHoras.setValue(1);
		txtSen.setText(null);
		txtMontoApagar.setText(null);
		txtMontoApagar.setEditable(true);
		txtMontoFaltante.setText(null);
		chcAlquilerPagado.setSelected(false);
		num=null;
		txtObservaciones.setText(null);
		Calendar hoy= new GregorianCalendar();
		calen.setDate(hoy.getTime());
		DefaultTableModel dm=(DefaultTableModel) tableDia.getModel();
		int con=dm.getRowCount();
		for(int i=con-1;i>=0;i--){
			dm.removeRow(i);
		}
		tableDia.setModel(dm);
		oldAlqui=null;
		Colorear.nullNombreInmuble();
		
		/*Calendar calendario = new GregorianCalendar(2014,5,10);
		calendar.setDate(calendario.getTime());*/
		//		calen.setDate(null);
					

		//btnAceptar.setEnabled(false);

		}
										

	
	public Alquiler cargarDatos(Personas per, Inmuebles inm){
		try {
			
			if((per.getDni()==null)||(inm.getIdInmubles()==null)){
				limpiar();
				return null;//si algo falla en la carga de inmueble o persona
			}

			
			Calendar fechaRese= calen.getCalendar();
			fechaRese.set(Calendar.MINUTE, 0);
			fechaRese.set(Calendar.SECOND,0);
			fechaRese.set(Calendar.HOUR_OF_DAY,(int)txtHoraR.getValue());
			//agrega la hora de reserva
			
			Calendar auxCalendar = new GregorianCalendar();
			auxCalendar.set(Calendar.SECOND, 0);
			Date auxActual = auxCalendar.getTime();

			

			Calendar auxFechaPago;
			byte pagoalquiler;


			Integer cantidadhoras = (Integer) txtCantidadHoras.getValue();
			float preciototal = Float.parseFloat(ResuPrecioTotal.getText());
			float montofaltante = Float.parseFloat(txtMontoFaltante.getText());
			
			byte activo = 1;
			String observaciones = txtObservaciones.getText().toString();
		
			if((chcAlquilerPagado.isSelected())||
					((montofaltante==0)&&(preciototal== Float.parseFloat(txtMontoApagar.getText())))){
				auxFechaPago=new GregorianCalendar();
				auxFechaPago.set(Calendar.SECOND, 0);
				pagoalquiler = 1;
			}else{
				auxFechaPago=new GregorianCalendar(0, 0, 0, 0, 0, 0);
				pagoalquiler = 0;
			}
			Alquiler auxAlqui = miCoordinador.CrearAlquiler();//new Alquiler();
			if((oldAlqui!=null)&&(oldAlqui.getNroalquiler()!=null)){//es para update
				auxAlqui.setNroalquiler(oldAlqui.getNroalquiler());
				auxActual=oldAlqui.getFechaactual();
			}
			
			
			Date auxFechaRese = fechaRese.getTime();
			Date auxFechaP = auxFechaPago.getTime();
			
			auxAlqui.setPersonas(per);
			auxAlqui.setInmuebles(inm);
			auxAlqui.setFechaactual(auxActual);//auxCalendar.getTime();
			auxAlqui.setFechareserva(fechaRese.getTime());
			auxAlqui.setFechapagoalquiler(auxFechaPago.getTime());
			auxAlqui.setMontofaltante(montofaltante);
			auxAlqui.setCantidadhoras(cantidadhoras);
			auxAlqui.setPreciototal(preciototal);
			auxAlqui.setPagoalquiler(pagoalquiler);
			auxAlqui.setObservaciones(observaciones);
			auxAlqui.setActivo(activo);
			return auxAlqui;
		} catch(Exception e1)
		{	miCoordinador.mensajes("ERROR EN LA CARGA DE DATOS: "+ e1.getMessage(), 0);
//			JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN LA CARGA DE DATOS.", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	
public void cargarDatosAlquilerModificar(int nroAlqui){
//	oldAlqui

}  

public float CalcularPrecioTotal( Personas per,Inmuebles in, Integer cantHoras ){
	
	try {
		float tot=0f;
		tot=in.getPreciohora()*cantHoras;
		if((per.getSocios()!=null)&&(per.getSocios().getEstado()!="MOROSO")&&(per.isHabilitado()==true)&&(per.getSocios().isBaja()==false))
		{
			LabelSocioDes.setVisible(true);
			tot=tot*(1-((per.getSocios().getCategoria().getDescuento())/100));
		}

		return tot;
	} catch (Exception e) {
		miCoordinador.mensajes("Ocurrio un error: "+e.getMessage(), 0);
		return 0;
	}
	
}


public boolean personaHabilitadaParaAlquiler(Personas per)
{
	//return miCoordinador.personaHabilitadaParaAlquiler(per);
	
	if((!per.isHabilitado())||((per.isHabilitado())&&(per.getSocios()!=null)&&(per.getSocios().getEstado().equals("MOROSO")))	)
		{
			pers=miCoordinador.CrearPersona();
			//limpiar();
			return false;
		}  
	else{
			cargarCombo();
			habilitarCampoPersona(false);
			return true;
		}
}

	public void habilitarCampoPersona(boolean b) {
	txtApe.setEditable(b);
	txtDni.setEditable(b);
	txtNom.setEditable(b);
	btnBuscarPersona.setEnabled(b);
}

	public boolean horarioValido(){
		try {
			DefaultTableModel dm = (DefaultTableModel) tableDia.getModel();
			if(dm.getRowCount()!=0){
				boolean ban=true;
				Integer	nHora=(int) txtHoraR.getValue();
				Integer nCantidad= (Integer) txtCantidadHoras.getValue();
				for(int i=0;i<dm.getRowCount();i++){
					if((oldAlqui==null)||(dm.getValueAt(i, 3)!=oldAlqui.getNroalquiler())){
						String parts[]=dm.getValueAt(i, 1).toString().split(":");
						Integer horaReserva=Integer.parseInt(parts[0].toString());
						Integer cantidadHoras=Integer.parseInt(dm.getValueAt(i,4).toString());
						
						if((nHora>=6)&&(nHora<=23)&&(nHora<horaReserva)&&((nHora+nCantidad)<=horaReserva)){
							
						}else 
							if((nHora>=6)&&(nHora<=23)&&(nHora>=horaReserva+cantidadHoras))
								ban=true;
							else ban=false;	
					}
					if(!ban){
						return ban;
					}
					
				}
				return ban;
			}else return true;//no hay ningun alquiler ese dia de ese inmueble
		} catch (NumberFormatException e) {
			miCoordinador.mensajes("ocurrio un error en la carga"+ e.getMessage(), 0);
			return false;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			if(e.getSource()==btnBuscarPersona)
			{
				lSolucionBusqueda.setVisible(false);
				comboResult.setVisible(false);
				comboResult.removeAllItems();
				mapPersona.clear();
				if((!txtDni.getText().isEmpty()))
				{
					pers=miCoordinador.BuscarPersona(Integer.parseInt(txtDni.getText()));
					if(personaHabilitadaParaAlquiler(pers))
					{ txtApe.setText(pers.getApellido().toString());
					txtNom.setText(pers.getNombre().toString());
					habilitarCampoPersona(false);
					}else 
						miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 2);
					
					
				}else{
					if((!txtApe.getText().isEmpty())||(!txtNom.getText().isEmpty()))
					{
						listaPersonas = new ArrayList<Personas>();
						listaPersonas.clear();
						listaPersonas=miCoordinador.filtrarPersonaPor(txtNom.getText().toString(), txtApe.getText().toString());
						if(!listaPersonas.equals(null))
							cargarComboBoxDeBusquedaDePersonas(listaPersonas);		
								//TODO falta terminar y funcion seleccionar persona							
					}
					
				}

			}
			
			
		}catch(Exception e1)
		{
			txtApe.setText(null);
			txtNom.setText(null);
			txtDni.setText(null);
			miCoordinador.mensajes("NO SE ENCUENTRA LA PERSONA", 0);
//			JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		try{
			if(e.getSource()==btnAceptar)
			{
				if(horarioValido()){
					if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "Desea Guardar el alquiler", 3)){
						Alquiler aux = cargarDatos( pers,inm);
						if(aux!=null){
							miCoordinador.GuardarAlquiler(aux);
							miCoordinador.mensajes("SE GUARDO CORRECTAMENTE", 3);
							this.limpiar();
	//					this.dispose();
					
						}
					}
				}else{
				miCoordinador.mensajes("La hora de reserva Y/O la cantidad no son validas", 0);
				}
			
			}
			//TODO codigo para probar alquiler

		}catch(Exception e1){
			
			JOptionPane.showMessageDialog(null, "REINTENTE LA OPERACION: " + e1.getMessage(), "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		try {
			if(e.getSource()==btnCancelar){
				this.dispose();
			}
			
			if(e.getSource()==btnLimpiar){
				limpiar();
			}
			if(e.getSource()==chcAlquilerPagado){
				if(chcAlquilerPagado.isSelected()){
					txtMontoFaltante.setText(Float.toString(0.0f));
					txtMontoApagar.setText(ResuPrecioTotal.getText());
					txtMontoApagar.setEditable(false);
				}else{
					txtMontoFaltante.setText(null);
					txtMontoApagar.setText(null);
					txtMontoApagar.setEditable(true);
				}
					
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "REINTENTE LA OPERACION: " + e1.getMessage(), "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}

	
		
		
		
		
			
	