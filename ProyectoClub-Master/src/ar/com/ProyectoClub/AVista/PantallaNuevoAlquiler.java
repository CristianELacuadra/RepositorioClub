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
	public boolean boolparaPagar;
	public Integer nroAlquiModificar;
	public float montoAnterior;
	
	public PantallaNuevoAlquiler(PantallaAlquilerPrincipal vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		setResizable(false);
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
		setBounds(50, 50, 920, 639);

	}

	public void initComponents(){
		miCoordinador=new ControllerCoordinador();
		boolparaPagar= false;
		panelTitulo = new JPanel();
		panelTitulo.setBounds(10, 11, 884, 35);
		panelTitulo.setBackground(new Color(250, 250, 210));
		panelTitulo.setBorder(UIManager.getBorder("ComboBox.border"));


		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE NUEVO ALQUILER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTitulo.add(lblNewLabel_1);
		getContentPane().setLayout(null);
		
		getContentPane().add(panelTitulo);
		
		panelPersona = new JPanel();
		panelPersona.setBounds(10, 60, 884, 124);
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		panelPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Datos de Personas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		btnBuscarPersona = new JButton("Buscar");
		btnBuscarPersona.setBounds(371, 22, 129, 59);
		panelPersona.add(btnBuscarPersona);
		btnBuscarPersona.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPersona.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscaF1.png")));
		
		lSolucionBusqueda = new JLabel("LISTO");
		lSolucionBusqueda.setBounds(565, 44, 88, 14);
		panelPersona.add(lSolucionBusqueda);
		
		txtDni = new JTextField();
		txtDni.setBackground(new Color(250, 250, 210));
		txtDni.setBounds(170, 16, 167, 20);
		panelPersona.add(txtDni);
		txtDni.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDni.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBackground(new Color(250, 250, 210));
		txtNom.setBounds(170, 41, 167, 20);
		panelPersona.add(txtNom);
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBackground(new Color(250, 250, 210));
		txtApe.setBounds(170, 66, 167, 20);
		panelPersona.add(txtApe);
		txtApe.setHorizontalAlignment(SwingConstants.RIGHT);
		txtApe.setColumns(10);
		
		
		
		comboResult = new JComboBox<String>();
		comboResult.setBackground(new Color(250, 250, 210));
		comboResult.setBounds(170, 93, 167, 20);
		panelPersona.add(comboResult);
		
		lblCodSocio = new JLabel("DNI");
	
		lblCodSocio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodSocio.setBounds(10, 16, 150, 20);
		panelPersona.add(lblCodSocio);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO");
		
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 66, 150, 20);
		panelPersona.add(lblNewLabel_2);
		
		JLabel lblNombreDeLa = new JLabel("NOMBRE");
	
		lblNombreDeLa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeLa.setBounds(10, 41, 150, 20);
		panelPersona.add(lblNombreDeLa);
		
		LabelSocioDes = new JLabel("*Precio con descuento por Socio");
		LabelSocioDes.setBounds(347, 96, 237, 14);
		panelPersona.add(LabelSocioDes);
		LabelSocioDes.setVisible(false);
		
		JPanel panelReserva = new JPanel();
		panelReserva.setBounds(10, 195, 884, 406);
		getContentPane().add(panelReserva);
		panelReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Datos de la Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		panelReserva.setLayout(null);
		lblInmuebleAlquilar = new JLabel("INMUEBLE A ALQUILAR");
		lblInmuebleAlquilar.setBounds(10, 25, 138, 20);
		panelReserva.add(lblInmuebleAlquilar);
		
		lblInmuebleAlquilar.setHorizontalAlignment(SwingConstants.RIGHT);
		
		comboInmuebles = new JComboBox<String>();
		comboInmuebles.setBackground(new Color(250, 250, 210));
		comboInmuebles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboInmuebles.setEnabled(false);
		comboInmuebles.setBounds(155, 25, 180, 20);
		panelReserva.add(comboInmuebles);
		
		
			comboInmuebles.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione el inmueble"}));
			lblHoraDeReserva = new JLabel("HORA DE RESERVA");
			lblHoraDeReserva.setBounds(10, 50, 138, 20);
			panelReserva.add(lblHoraDeReserva);
			
			lblHoraDeReserva.setHorizontalAlignment(SwingConstants.RIGHT);
			
			txtHoraR = new JSpinner();
			txtHoraR.setBackground(new Color(250, 250, 210));
			txtHoraR.setEnabled(false);
			txtHoraR.setBounds(155, 50, 180, 20);
			panelReserva.add(txtHoraR);
			txtHoraR.setModel(new SpinnerNumberModel(6, 6, 23, 1));
			
			txtCantidadHoras = new JSpinner();
			txtCantidadHoras.setBackground(new Color(250, 250, 210));
			txtCantidadHoras.setEnabled(false);
			
			
			txtCantidadHoras.setBounds(155, 75, 180, 20);
			panelReserva.add(txtCantidadHoras);
			txtCantidadHoras.setModel(new SpinnerNumberModel(1, 1, 24, 1));
			lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS ");
			lblCantidadDeHoras.setBounds(13, 75, 135, 20);
			panelReserva.add(lblCantidadDeHoras);
			
			lblCantidadDeHoras.setHorizontalAlignment(SwingConstants.RIGHT);
			
			JLabel lblNewLabel_3 = new JLabel("SE\u00D1A");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(10, 100, 138, 20);
			panelReserva.add(lblNewLabel_3);
			
			txtSen = new JTextField();
			txtSen.setDisabledTextColor(new Color(250, 250, 210));
			txtSen.setEnabled(false);
			txtSen.setEditable(false);
			txtSen.setBounds(155, 100, 180, 20);
			panelReserva.add(txtSen);
			txtSen.setBackground(new Color(204, 204, 204));
			txtSen.setHorizontalAlignment(SwingConstants.RIGHT);
			txtSen.setColumns(102);
			
			ResuPrecioTotal = new JTextField();
			ResuPrecioTotal.setDisabledTextColor(new Color(250, 250, 210));
			ResuPrecioTotal.setEnabled(false);
			ResuPrecioTotal.setBounds(155, 125, 180, 20);
			panelReserva.add(ResuPrecioTotal);
			ResuPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			ResuPrecioTotal.setBackground(new Color(204, 204, 204));
			ResuPrecioTotal.setBorder(UIManager.getBorder("ComboBox.border"));
			ResuPrecioTotal.setEditable(false);
			lblPrecioTotal = new JLabel("PRECIO TOTAL: $");
			lblPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrecioTotal.setBounds(10, 125, 138, 20);
			panelReserva.add(lblPrecioTotal);
			
			JLabel lblNewLabel_4 = new JLabel("\u00BFCUANTO VA A PAGAR?");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(10, 184, 138, 20);
			panelReserva.add(lblNewLabel_4);
			
			txtMontoApagar = new JTextField();
			txtMontoApagar.setDisabledTextColor(new Color(128, 128, 128));
			txtMontoApagar.setBackground(new Color(250, 250, 210));
			txtMontoApagar.setEnabled(false);
			txtMontoApagar.setBounds(155, 184, 180, 20);
			panelReserva.add(txtMontoApagar);
			txtMontoApagar.setHorizontalAlignment(SwingConstants.RIGHT);
			txtMontoApagar.setColumns(10);
			
			chcAlquilerPagado = new JCheckBox("PAGAR POR COMPLETO");

			chcAlquilerPagado.setEnabled(false);
			chcAlquilerPagado.setBounds(155, 150, 180, 23);
			panelReserva.add(chcAlquilerPagado);
			chcAlquilerPagado.setToolTipText("Seleccionar cuando se pagar\u00E1 en el momento");
			
			txtMontoFaltante = new JTextField();
			txtMontoFaltante.setDisabledTextColor(new Color(250, 250, 210));
			txtMontoFaltante.setEnabled(false);
			txtMontoFaltante.setBounds(155, 209, 180, 20);
			panelReserva.add(txtMontoFaltante);
			txtMontoFaltante.setBackground(new Color(204, 204, 204));
			txtMontoFaltante.setEditable(false);
			txtMontoFaltante.setHorizontalAlignment(SwingConstants.RIGHT);
			txtMontoFaltante.setColumns(10);
			
			JLabel lblNewLabel_5 = new JLabel("MONTO FALTANTE");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setBounds(10, 209, 138, 20);
			panelReserva.add(lblNewLabel_5);
			
			label = new JLabel("OBSERVACIONES:");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(10, 240, 138, 20);
			panelReserva.add(label);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 271, 325, 121);
			panelReserva.add(scrollPane);
			
			txtObservaciones = new JTextArea();
			txtObservaciones.setBackground(new Color(250, 250, 210));
			txtObservaciones.addKeyListener(this);
			
			txtObservaciones.setEnabled(false);
			txtObservaciones.setLineWrap(true);
			scrollPane.setViewportView(txtObservaciones);
									
			calen = new JCalendar();
			calen.getMonthChooser().getSpinner().setForeground(new Color(250, 250, 210));
			calen.getYearChooser().getSpinner().setForeground(new Color(250, 250, 210));
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
			btnAceptar.setBounds(605, 301, 90, 51);
			panelReserva.add(btnAceptar);
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAceptar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/aceptar.png")));
			btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(505, 301, 90, 51);
			panelReserva.add(btnCancelar);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnCancelar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/cancel.png")));
			btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
													
			panelAlquileresDia = new JPanel();
			panelAlquileresDia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, null));
			panelAlquileresDia.setBounds(664, 25, 210, 265);
			panelReserva.add(panelAlquileresDia);
			panelAlquileresDia.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			panelAlquileresDia.add(scrollPane_1, BorderLayout.CENTER);
			
			tableDia=new JTable();
			tableDia.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
			tableDia.getTableHeader().setReorderingAllowed(false);
			tableDia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			tableDia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane_1.setViewportView(tableDia);
			tableDia.setModel(new DefaultTableModel( new String [] {"inmueble","Desde","Hasta"},0){
				public boolean isCellEditable(int row,int colum){  
				return false;
				}
			});
			tableDia.setRowHeight(25);
			tableDia.setToolTipText("No hay Alquileres este Día");
			
				btnLimpiar = new JButton("Limpiar Campos");
				btnLimpiar.setBounds(345, 301, 150, 51);
				panelReserva.add(btnLimpiar);
				btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
				btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnLimpiar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar24x24.png")));
				
				
				
				btnLimpiar.addActionListener(this);
			tableDia.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					AccionesTablaDia(e);
				}
			});
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
							if((listaAl!=null)&&(comboInmuebles.getSelectedItem()!=null)){
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
									miCoordinador.mensajes("Esta persona no esta habilitada", 1);
								}
							}
						}
				}
			});
			
				//TODO combobox accion inmuebles			
	comboInmuebles.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ed) {
		
				try {
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
								txtCantidadHoras.setValue(1);
								if((pers.getDni()!=null)&&(inm.getIdInmubles()!=null)&&
										((oldAlqui==null))){
												/*||(inm.getIdInmubles()!=oldAlqui.getInmuebles().getIdInmubles())*/
												
									txtSen.setText(Float.toString(inm.getSenial()));
									
									ResuPrecioTotal.setText(Float.toString(CalcularPrecioTotal(pers, inm,(Integer) txtCantidadHoras.getValue())));
									if(txtMontoApagar.getText().isEmpty())
										txtMontoFaltante.setText(Float.toString(calcularMontoFaltante(Float.parseFloat(ResuPrecioTotal.getText()), 0)));
									else 
										txtMontoFaltante.setText(Float.toString(calcularMontoFaltante(Float.parseFloat(ResuPrecioTotal.getText()),Float.parseFloat(txtMontoApagar.getText()))));
								}
								
								
								Colorear.setNombreInmueble(inm.getNombre());
								Calendar hoyCreo= new GregorianCalendar();
								calen.setDate(hoyCreo.getTime());
								//COMPROBAR LA FUNCION DE CARGA DE TABLA Y COLOR
								// SI COLOREA POR INMUEBLE
							}

						}
					}else{
						//cuando se elige otra opcion
						Colorear.nullNombreInmuble();
//					inm=new Inmuebles();
						inm=null;
						Calendar hoyCreo= new GregorianCalendar();
						calen.setDate(hoyCreo.getTime());
						
						txtSen.setText(null);
						ResuPrecioTotal.setText(null);
						txtMontoApagar.setText(null);
						txtMontoFaltante.setText(null);
						txtObservaciones.setText(null);
						
						habilitarCamporReserva(false,false);
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		 

		
		txtHoraR.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Integer.parseInt(txtHoraR.getValue().toString());
				txtCantidadHoras.setModel(new SpinnerNumberModel(1, 1,(30-Integer.parseInt(txtHoraR.getValue().toString())),1));	
				txtCantidadHoras.setValue(1);
				//	if((pers.getDni()!=null)&&(inm.getIdInmubles()!=null)){// probando
				if((pers!=null)&&(inm!=null)){
						//&&((oldAlqui==null)/*||(oldAlqui.getCantidadhoras()!=(Integer) txtCantidadHoras.getValue())*///)
						
					ResuPrecioTotal.setText(Float.toString(CalcularPrecioTotal(pers, inm,(Integer) txtCantidadHoras.getValue())));
					if(txtMontoApagar.getText().isEmpty())
						txtMontoFaltante.setText(Float.toString(calcularMontoFaltante(Float.parseFloat(ResuPrecioTotal.getText()), 0)));
					else 
						txtMontoFaltante.setText(Float.toString(calcularMontoFaltante(Float.parseFloat(ResuPrecioTotal.getText()),Float.parseFloat(txtMontoApagar.getText()))));
				}
		//los alquileres empiezan desde las 6 hasta las 23
				//todos los alquileres tienen como maximo hasta las 6 del otro dia
				//esta funcion determina el numero maximo de horas para alquilar, 
				//falta completar cuando es un dia con alquileres ya cargados
			}
		});
		txtCantidadHoras.addChangeListener(new ChangeListener() {
			public void stateChanged (ChangeEvent e){
				if((pers!=null)&&(inm!=null)){
					/*
					 if((pers.getDni()!=null)
						&&(inm.getIdInmubles()!=null)){	
					 */
					//&&((oldAlqui==null)/*||(oldAlqui.getCantidadhoras()!=(Integer) txtCantidadHoras.getValue())*///)
						
					ResuPrecioTotal.setText(Float.toString(CalcularPrecioTotal(pers, inm,(Integer) txtCantidadHoras.getValue())));
					if(txtMontoApagar.getText().isEmpty())
						txtMontoFaltante.setText(Float.toString(calcularMontoFaltante(Float.parseFloat(ResuPrecioTotal.getText()), 0)));
					else 
						txtMontoFaltante.setText(Float.toString(calcularMontoFaltante(Float.parseFloat(ResuPrecioTotal.getText()),Float.parseFloat(txtMontoApagar.getText()))));
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
							if(((aux2-1)-aux1)>1){
								e.consume();
							}
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
			if((montoAnterior==0)&&(montoApagar<montoAnterior))
				montoApagar=montoAnterior;
			float montoFaltante=0;
			if(montoRestante>0){
				montoFaltante=montoRestante-montoApagar;
			}
			if(montoFaltante<0){
				montoFaltante=0;
				montoApagar=montoRestante-montoFaltante;
				txtMontoApagar.setText(Float.toString(montoApagar));
			}else{
						if((montoApagar<montoAnterior)&&(montoApagar>0))
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
		boolparaPagar= false;
		/**Panel de reserva**/

		calen.setEnabled(true);
		Calendar hoy= new GregorianCalendar();
		calen.setDate(hoy.getTime());
		comboInmuebles.removeAllItems();
		mapInmueble.clear();
		comboInmuebles.addItem("Seleccione el inmueble");
		comboInmuebles.setEnabled(false);
		txtHoraR.setValue(6);
		txtCantidadHoras.setValue(1);
		txtSen.setText(null);
		txtMontoApagar.setText(null);
		txtMontoApagar.setEditable(true);
		txtMontoFaltante.setText(null);
		chcAlquilerPagado.setSelected(false);
		ResuPrecioTotal.setText(null);
		num=null;
		txtObservaciones.setText(null);
		habilitarCamporReserva(false,false);
		
		
		DefaultTableModel dm=(DefaultTableModel) tableDia.getModel();
		int con=dm.getRowCount();
		for(int i=con-1;i>=0;i--){
			dm.removeRow(i);
		}
		
		tableDia.setModel(dm);
		oldAlqui=null;
		Colorear.nullNombreInmuble();
		nroAlquiModificar=null;
		montoAnterior=0;
		//btnAceptar.setEnabled(false);
		}
										

	
	public Alquiler cargarDatos(Personas per, Inmuebles inm){
		try {
			Alquiler auxAlqui;
			if(oldAlqui!=null){
				auxAlqui=oldAlqui;
				montoAnterior=oldAlqui.getMontofaltante();
			}else
				auxAlqui = miCoordinador.CrearAlquiler();

			if((per==null)||(inm==null)||(per.getDni()==null)||(inm.getIdInmubles()==null)){
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
			byte activo = 1;// alquiler activo / tambien paracomparaciones
			String observaciones = txtObservaciones.getText().toString();
			

			if((txtMontoApagar.getText().isEmpty())||(montofaltante==preciototal)){//para evitar valor nulo de ingreso de plata.//4
			return null;
			}else {
				
				if((oldAlqui==null)&&
						((preciototal-montofaltante)== 
						Float.parseFloat(txtMontoApagar.getText()))&&
						((Float.parseFloat(txtMontoApagar.getText()))<
						(Float.parseFloat(txtSen.getText())))
						){
					return null;
				}
					
			
					if((chcAlquilerPagado.isSelected())||
						((montofaltante==0)||(preciototal== Float.parseFloat(txtMontoApagar.getText())))){
					if((oldAlqui!=null)&&(oldAlqui.getPagoalquiler()==activo)){
						auxFechaPago=new GregorianCalendar();
						auxFechaPago.setTime(oldAlqui.getFechapagoalquiler());
						//para que no borre la fecha de pago cuando se modifica
					}else{
						auxFechaPago=new GregorianCalendar();
					auxFechaPago.set(Calendar.SECOND, 0);
					}
					pagoalquiler = 1;
				}else{
					auxFechaPago=new GregorianCalendar(0, 0, 0, 0, 0, 0);
					pagoalquiler = 0;
				}
				
				if(oldAlqui==null){
					auxAlqui.setPersonas(per);
					auxAlqui.setInmuebles(inm);
					auxAlqui.setFechaactual(auxActual);
				}				
					auxAlqui.setFechapagoalquiler(auxFechaPago.getTime());
					auxAlqui.setMontofaltante(montofaltante);
					auxAlqui.setPagoalquiler(pagoalquiler);
					if(boolparaPagar==false){
						auxAlqui.setFechareserva(fechaRese.getTime());
						auxAlqui.setCantidadhoras(cantidadhoras);
						auxAlqui.setPreciototal(preciototal);
						auxAlqui.setObservaciones(observaciones);
						auxAlqui.setActivo(activo);
					}
			
					return auxAlqui;
			}
			
		} catch(Exception e1)
		{	miCoordinador.mensajes("ERROR EN LA CARGA DE DATOS: "+ e1.getMessage(), 0);
//			JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN LA CARGA DE DATOS.", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	

	}
//TODO teclado
	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource()==txtObservaciones){
			try{
				{if (txtObservaciones.getText().length()>= 300)
				     e.consume();
				}
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error", 0);
				}
		}
	}
	
	


public float CalcularPrecioTotal( Personas per,Inmuebles in, Integer cantHoras ){
	
	try {
		float tot = 0f;;
		
		if ((per!=null)&&(in!=null)) {
		
			tot = in.getPreciohora() * cantHoras;
			Personas auxPersona = per;
			if ((nroAlquiModificar != null) && (oldAlqui != null)) {
				auxPersona = miCoordinador.BuscarPersona(oldAlqui.getPersonas()
						.getDni());
			}
			if ((auxPersona.getSocios() != null)
					&& (auxPersona.getSocios().getEstado() != "MOROSO")
					&& (auxPersona.isHabilitado() == true)
					&& (auxPersona.getSocios().isBaja() == false)) {
						LabelSocioDes.setVisible(true);
						tot = tot * (1 - ((auxPersona.getSocios().getCategoria().getDescuento()) / 100));
				txtSen.setText(Float.toString(in.getSenial()* (1 - ((auxPersona.getSocios().getCategoria()
								.getDescuento()) / 100))));
			}
		}else tot=-1;
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
			Integer	nHora=(int) txtHoraR.getValue();
			Integer nCantidad= (Integer) txtCantidadHoras.getValue();
			if(dm.getRowCount()!=0){
				boolean ban=true;

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
						return ban;// determina si hay un comflicto de horarios
					}
				}
				//ahora if de fecha actual y de reserva
				
				Calendar fechaReseAux= calen.getCalendar();
				fechaReseAux.set(Calendar.MINUTE, 0);
				fechaReseAux.set(Calendar.SECOND,0);
				fechaReseAux.set(Calendar.HOUR_OF_DAY,nHora);// le paso la hora de reserva
				
				Calendar auxCalendar = new GregorianCalendar();
				auxCalendar.set(Calendar.SECOND, 0);
				
				if(fechaReseAux.getTime().before(auxCalendar.getTime()))
					return ban=false;
				else
					return ban;
			}else{
				Calendar fechaReseAux= calen.getCalendar();
				fechaReseAux.set(Calendar.HOUR_OF_DAY,nHora);
				fechaReseAux.set(Calendar.MINUTE, 0);
				fechaReseAux.set(Calendar.SECOND,0);
				Calendar auxCalendar = new GregorianCalendar();
				auxCalendar.set(Calendar.SECOND, 0);
				if(fechaReseAux.before(auxCalendar))
					return false;
				else
					return true;
			} //no hay ningun alquiler ese dia de ese inmueble
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
						miCoordinador.mensajes("Esta persona no esta habilitada", 1);
					
					
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
					Alquiler aux = cargarDatos( pers,inm);
					if(aux!=null){
					
					if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "Desea Guardar el alquiler", 3)){//cambiar de lugar
							if(boolparaPagar==false)
								miCoordinador.GuardarAlquiler(aux);
							else
								miCoordinador.GuardarAlquiler(aux,montoAnterior);
							
							miCoordinador.mensajes("SE GUARDO CORRECTAMENTE", 1);
							this.limpiar();
							miCoordinador.recargarPanelAlquiler();
							this.dispose();
						}
					}else miCoordinador.mensajes("Faltan valores o el pago es menor que la seña", 0);
					
				}else{
				miCoordinador.mensajes("Las Fecha y/u Horas de reserva no son validas", 0);
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
					txtMontoFaltante.setText(ResuPrecioTotal.getText());
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

	public void cargarDatosAlquilerPagar(int nroAlqui) {
		try{
			limpiar();//limpiar todo para la carga
			nroAlquiModificar=nroAlqui;
			boolparaPagar=true;
			oldAlqui=miCoordinador.buscarAlquiler(nroAlquiModificar);
			this.pers=oldAlqui.getPersonas();
			this.inm=oldAlqui.getInmuebles();
			if(personaHabilitadaParaAlquiler(oldAlqui.getPersonas())){
				txtApe.setText(oldAlqui.getPersonas().getApellido());
				txtDni.setText(oldAlqui.getPersonas().getDni().toString());
				
				txtNom.setText(oldAlqui.getPersonas().getNombre());
				habilitarCampoPersona(false);
				
				if(oldAlqui.getInmuebles().isHabilitado()==true){
					comboInmuebles.removeAllItems();
					comboInmuebles.addItem(oldAlqui.getInmuebles().getNombre());

					comboInmuebles.setEditable(false);
					comboInmuebles.setEnabled(true);
					Colorear.setNombreInmueble(oldAlqui.getInmuebles().getNombre());
					Calendar auxfechaDeReserva = new GregorianCalendar();
					auxfechaDeReserva.setTime(oldAlqui.getFechareserva());
					
					calen.setEnabled(false);
					txtHoraR.setValue(auxfechaDeReserva.get(Calendar.HOUR_OF_DAY));
					calen.setDate(oldAlqui.getFechareserva());
					inm=oldAlqui.getInmuebles();
					pers=oldAlqui.getPersonas();
					txtCantidadHoras.setValue(oldAlqui.getCantidadhoras());
					txtSen.setText(Float.toString(oldAlqui.getInmuebles().getSenial()));
					ResuPrecioTotal.setText(Float.toString(oldAlqui.getPreciototal()));
					txtMontoApagar.setText(null);
					montoAnterior=0;// no se carga
					txtMontoFaltante.setText(Float.toString(oldAlqui.getMontofaltante()));
					txtObservaciones.setText(oldAlqui.getObservaciones());
					habilitarCamporReserva(false, true);
					txtMontoFaltante.setEnabled(true);
					chcAlquilerPagado.setEnabled(false);
					setVisible(true);
					
					
					
				}else
					miCoordinador.mensajes("El inmueble de este alquiler esta deshabilitado", 1);
			}else{
				miCoordinador.mensajes("Esta persona no esta habilitada", 1);
				
			}
	
	}catch(Exception e){
		miCoordinador.mensajes("Ocurrio un error: "+ e.getMessage(), 0);
		limpiar();
	}
	
	}

	public void cargarDatosAlquilerModificar(int nroAlqui) {

		try{
			limpiar();
			nroAlquiModificar=nroAlqui;
			oldAlqui=miCoordinador.buscarAlquiler(nroAlquiModificar);

			pers=oldAlqui.getPersonas();
			inm=oldAlqui.getInmuebles();
			if(personaHabilitadaParaAlquiler(oldAlqui.getPersonas()) )
			{
				txtApe.setText(oldAlqui.getPersonas().getApellido());
				txtDni.setText(oldAlqui.getPersonas().getDni().toString());
				
				txtNom.setText(oldAlqui.getPersonas().getNombre());
				habilitarCampoPersona(false);
				
				if(oldAlqui.getInmuebles().isHabilitado()==true){

					comboInmuebles.removeAllItems();
					comboInmuebles.addItem(oldAlqui.getInmuebles().getNombre());
					comboInmuebles.setEditable(false);
					comboInmuebles.setEnabled(true);
					
					
					Colorear.setNombreInmueble(oldAlqui.getInmuebles().getNombre());
					Calendar auxfechaDeReserva = new GregorianCalendar();
					auxfechaDeReserva.setTime(oldAlqui.getFechareserva());
					inm=oldAlqui.getInmuebles();
					pers=oldAlqui.getPersonas();
					txtHoraR.setValue(auxfechaDeReserva.get(Calendar.HOUR_OF_DAY));
					calen.setDate(oldAlqui.getFechareserva());
					
					txtCantidadHoras.setValue(oldAlqui.getCantidadhoras());
					txtSen.setText(Float.toString(oldAlqui.getInmuebles().getSenial()));
					ResuPrecioTotal.setText(Float.toString(oldAlqui.getPreciototal()));
					
				
					txtMontoApagar.setText(Float.toString(oldAlqui.getPreciototal()-oldAlqui.getMontofaltante()));
					montoAnterior=(oldAlqui.getPreciototal()-oldAlqui.getMontofaltante());
					txtMontoFaltante.setText(Float.toString(oldAlqui.getMontofaltante()));
					txtObservaciones.setText(oldAlqui.getObservaciones());
					habilitarCamporReserva(true,false);
					chcAlquilerPagado.setEnabled(false);
					setVisible(true);
					
				}else{
					miCoordinador.mensajes("El inmueble de este alquiler esta deshabilitado", 1);
				}
			}else{
				miCoordinador.mensajes("Esta persona no esta habilitada", 1);
				
			}
		}catch(Exception e){
			miCoordinador.mensajes("Ocurrio un error: "+ e.getMessage(), 0);
			limpiar();
		}
		
	
		
		
		
		
		
	}
}

	
		
		
		
		
			
	