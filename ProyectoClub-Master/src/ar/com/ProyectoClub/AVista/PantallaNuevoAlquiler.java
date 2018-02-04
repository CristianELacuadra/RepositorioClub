package ar.com.ProyectoClub.AVista;

import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;

import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import javax.swing.border.BevelBorder;


public class PantallaNuevoAlquiler extends JDialog implements ActionListener,KeyListener {
	public JTextField txtDni;
	private ControllerCoordinador miCoordinador;
	public JLabel lblFechaDeReserva;
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
	public JLabel l;
	public JPanel panelTitulo;
	public JCheckBox chcAlquilerPagado;
	public JButton btnBuscarPersona;
	public JLabel label;
	public JScrollPane scrollPane;
 	public JTextArea txtObservaciones;
 	public Integer auxIdInm;
 	public Inmuebles inm;
 	public Personas pers;
 	public Alquiler alqui;
 	public Socios socio;
 	public JComboBox<String> comboBox;
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
	
	
	public PantallaNuevoAlquiler(PantallaAlquilerPrincipal vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				//limpiar();
				setVisible(false);
			}
		});
		
		//setResizable(false);
		setTitle("NUEVO ALQUILER");
		initComponents();
		setBounds(100, 100, 759, 718);

	}

	//TODO initComponents
	public void initComponents(){
		miCoordinador=new ControllerCoordinador();
		//dateFechaReserva = new JDateChooser();
	//	dateFechaReserva.setBounds(183, 235, 182, 20);
		
		btnAceptar = new JButton("Guardar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/aceptar.png")));
		btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		//btnAceptar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/apply.png")));
		btnAceptar.setBounds(513, 605, 81, 51);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/cancel.png")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setBounds(607, 605, 83, 51);
		
		l = new JLabel("*Precio con descuento por Socio de %");
		l.setBounds(186, 518, 184, 14);
		l.setVisible(false);
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(10, 11, 680, 35);
		panelTitulo.setBackground(new Color(0, 191, 255));
		panelTitulo.setBorder(UIManager.getBorder("ComboBox.border"));
		
		chcAlquilerPagado = new JCheckBox("PAGAR POR COMPLETO");
		chcAlquilerPagado.setBounds(334, 451, 141, 23);
		chcAlquilerPagado.setToolTipText("Seleccionar cuando se pagar\u00E1 en el momento");


		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE NUEVO ALQUILER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTitulo.add(lblNewLabel_1);
		getContentPane().setLayout(null);
		
		getContentPane().add(panelTitulo);
		lblInmuebleAlquilar = new JLabel("INMUEBLE A ALQUILAR");
		lblInmuebleAlquilar.setBounds(61, 198, 112, 14);
		getContentPane().add(lblInmuebleAlquilar);
		lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS ");
		lblCantidadDeHoras.setBounds(67, 299, 109, 14);
		getContentPane().add(lblCantidadDeHoras);
		lblHoraDeReserva = new JLabel("HORA DE RESERVA");
		lblHoraDeReserva.setBounds(80, 271, 93, 14);
		getContentPane().add(lblHoraDeReserva);
		lblFechaDeReserva = new JLabel("FECHA DE RESERVA");
		lblFechaDeReserva.setBounds(76, 241, 97, 14);
		getContentPane().add(lblFechaDeReserva);
		lblPrecioTotal = new JLabel("PRECIO TOTAL: $");
		lblPrecioTotal.setBounds(21, 419, 86, 14);
		getContentPane().add(lblPrecioTotal);
		
		ResuPrecioTotal = new JTextField();
		ResuPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		ResuPrecioTotal.setBounds(119, 416, 182, 20);
		ResuPrecioTotal.setBackground(new Color(204, 204, 204));
		ResuPrecioTotal.setBorder(UIManager.getBorder("ComboBox.border"));
		ResuPrecioTotal.setEditable(false);
		getContentPane().add(ResuPrecioTotal);
		
		label = new JLabel("OBSERVACIONES:");
		label.setBounds(21, 549, 88, 14);
		getContentPane().add(label);
	//	getContentPane().add(dateFechaReserva);
		getContentPane().add(chcAlquilerPagado);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnAceptar);
		getContentPane().add(l);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 543, 271, 113);
		getContentPane().add(scrollPane);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setLineWrap(true);
		scrollPane.setViewportView(txtObservaciones);
		
		comboBox = new JComboBox();
	
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el inmueble"}));
		comboBox.setBounds(186, 195, 182, 20);
		getContentPane().add(comboBox);
		
		txtHoraR = new JSpinner();
		txtHoraR.setModel(new SpinnerNumberModel(6, 6, 23, 1));
		txtHoraR.setBounds(186, 268, 182, 20);
		getContentPane().add(txtHoraR);
		
		txtCantidadHoras = new JSpinner();
		txtCantidadHoras.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		txtCantidadHoras.setBounds(186, 296, 182, 20);
		getContentPane().add(txtCantidadHoras);
	
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
		
		JLabel lblNewLabel_3 = new JLabel("SE\u00D1A");
		lblNewLabel_3.setBounds(36, 388, 26, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u00BFCUANTO VA A PAGAR?");
		lblNewLabel_4.setBounds(21, 455, 115, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MONTO FALTANTE");
		lblNewLabel_5.setBounds(21, 490, 90, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtSen = new JTextField();
		txtSen.setBackground(new Color(204, 204, 204));
		txtSen.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSen.setBounds(119, 385, 182, 20);
		getContentPane().add(txtSen);
		txtSen.setColumns(102);
		
		txtMontoApagar = new JTextField();
		txtMontoApagar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoApagar.setBounds(146, 452, 182, 20);
		getContentPane().add(txtMontoApagar);
		txtMontoApagar.setColumns(10);
		
		txtMontoFaltante = new JTextField();
		txtMontoFaltante.setBackground(new Color(204, 204, 204));
		txtMontoFaltante.setEditable(false);
		txtMontoFaltante.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoFaltante.setBounds(119, 487, 182, 20);
		getContentPane().add(txtMontoFaltante);
		txtMontoFaltante.setColumns(10);
		
		btnLimpiar = new JButton("Limpiar Campos");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnLimpiar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png")));
		btnLimpiar.setBounds(561, 491, 129, 103);
		getContentPane().add(btnLimpiar);
		
		panelPersona = new JPanel();
		panelPersona.setBounds(10, 60, 680, 124);
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		panelPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Datos de Personas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		btnBuscarPersona = new JButton("Buscar");
		btnBuscarPersona.setBounds(347, 19, 119, 59);
		panelPersona.add(btnBuscarPersona);
		btnBuscarPersona.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPersona.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscaF1.png")));
		
		lSolucionBusqueda = new JLabel("NO ENCONTRADO");
		lSolucionBusqueda.setBounds(476, 22, 88, 14);
		panelPersona.add(lSolucionBusqueda);
		
		txtDni = new JTextField();
		txtDni.setBounds(128, 95, 167, 20);
		panelPersona.add(txtDni);
		txtDni.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDni.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(170, 53, 167, 20);
		panelPersona.add(txtApe);
		txtApe.setHorizontalAlignment(SwingConstants.RIGHT);
		txtApe.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(170, 19, 167, 20);
		panelPersona.add(txtNom);
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setColumns(10);
		
		comboResult = new JComboBox();
		comboResult.setBounds(194, 95, 290, 20);
		panelPersona.add(comboResult);
		
		lblCodSocio = new JLabel("DNI  DE LA PERSONA");
		lblCodSocio.setBounds(10, 81, 102, 14);
		panelPersona.add(lblCodSocio);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO  DE LA PERSONA");
		lblNewLabel_2.setBounds(28, 56, 132, 14);
		panelPersona.add(lblNewLabel_2);
		
		JLabel lblNombreDeLa = new JLabel("NOMBRE DE LA PERSONA");
		lblNombreDeLa.setBounds(37, 22, 123, 14);
		panelPersona.add(lblNombreDeLa);
		
		calen = new JCalendar();
		calen.getDayChooser().setAlwaysFireDayProperty(true);
		calen.getYearChooser().setDayChooser(calen.getDayChooser());
		calen.getMonthChooser().setDayChooser(calen.getDayChooser());
		calen.getMonthChooser().setYearChooser(calen.getYearChooser());
//		calen.getYearChooser().setYear(2014);
//		calen.getYearChooser().setValue(2019);
		calen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		calen.setWeekOfYearVisible(false);
		
//		calen.setTodayButtonVisible(true);
		calen.setBounds(378, 195, 312, 238);

		
		calen.getDayChooser().addPropertyChangeListener(
				new java.beans.PropertyChangeListener() {
					@SuppressWarnings("deprecation")
					public void propertyChange(java.beans.PropertyChangeEvent evt) {
						 if (evt.getPropertyName().compareTo("day") == 0) {

							 java.util.List<Alquiler> listaAl=new ArrayList<Alquiler>();
	                       int a,m,d;
//	                       a=calen.getDate().getYear()+1900;
//	                       m=calen.getDate().getMonth();
//	                       d=calen.getDate().getDate();
//	                       
//	                       listaAl=  miCoordinador.ListarAlquilerPorDia(a,m ,d);

						 }
					
					}	
				}
		);
		
		calen.getYearChooser().addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						// TODO Auto-generated method stub
						if(evt.getPropertyName().compareTo("year")== 0){
							java.util.List<Alquiler> lis= new ArrayList<Alquiler>();
							int anio,mes;
							anio=calen.getYearChooser().getValue();
							mes=calen.getMonthChooser().getMonth();
							lis=miCoordinador.ListarAlquilerPormes(anio,mes );
							if(lis!=null){String qwe=new String();
							qwe=""+String.valueOf(calen.getYearChooser().getValue())
									+ " cantidad de alquileres: "
									+ String.valueOf(lis.size());
								miCoordinador.mensajes(qwe, 0);
						}
						}					
					}
				});
		calen.getMonthChooser().addPropertyChangeListener(
				new PropertyChangeListener(){
					public void propertyChange(PropertyChangeEvent evt) {
						if(evt.getPropertyName().compareTo("month")==0){
							java.util.List<Alquiler> lis= new ArrayList<Alquiler>();
							int anio,mes;
							anio=calen.getYearChooser().getValue();
							mes=calen.getMonthChooser().getMonth();
							lis=miCoordinador.ListarAlquilerPormes(anio,mes );
							if(lis!=null){
								//lis.get(0).getFechareserva().getDay();
							//if((lis.get(0).getFechareserva().getMonth()==mes)&&(lis.get(0).getFechareserva().getYear()==anio)){	
								for(int i=0;i<lis.size();i++){
//								Calendar cal= Calendar.getInstance();
								Component component[]=calen.getDayChooser().getDayPanel().getComponents();
//								  cal.set(Calendar.DAY_OF_MONTH,1);
//							         int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
								int ass=lis.get(i).getFechareserva().getDate();
							         component[ass].setBackground(Color.green);
//								miCoordinador.mensajes(String.valueOf(lis.size()), 0);
							
								}
								//}
							}
						}
					}
				}
				);

		getContentPane().add(calen);
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
							//agregar busqueda de socio y persona habilitada
							if(personaHabilitadaParaAlquiler(pers)){	
									txtApe.setText(pers.getApellido().toString());
									txtNom.setText(pers.getNombre().toString());
									lSolucionBusqueda.setText("LISTO");
							
							}
						}
						
					
					
					}
					
				}
				
			}
		});
		
		//TODO funcion de numeros solo
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
		lSolucionBusqueda.setVisible(false);
		btnBuscarPersona.addActionListener(this);
	 //TODO combobox accion inmuebles
	
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ed) {
				// TODO se esta ejecutando mal		
				if((comboBox.getSelectedIndex()!=-1)&&(ed.getStateChange() == ItemEvent.SELECTED)&&(ed.getItem().toString()!="Seleccione el inmueble"))
				{
					for (Map.Entry<Integer, String> entry : mapInmueble.entrySet())
					{
						if(entry.getValue().toString()==ed.getItem().toString())
						{
							inm=new Inmuebles();
							auxIdInm=entry.getKey();
							inm=miCoordinador.BuscarInmueble(auxIdInm);//no esta buscando
							txtSen.setText(Float.toString(inm.getSenial()));			
							
						}

					}
				}
				
			}
		});
		btnAceptar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnLimpiar.addActionListener(this);
		
	}
	//TODO final de init

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
		comboBox.removeAllItems();
		mapInmueble.clear();
		comboBox.addItem("Seleccione el inmueble");
		for (Inmuebles _inm :miCoordinador.ListarInmueblesAlquiler())
		{
			comboBox.addItem(_inm.getNombre());
			mapInmueble.put(_inm.getIdInmubles(), _inm.getNombre());
			//carga el combobox con los nombres de los inmuebles y usa un mapeo para
			//la puedo usar para mostrar los resultados de list usuarios cuando es mas de uno en un combobox con mapeo.
		}
		
		/*
	 	Date fecha=new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		 		 
		 SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
		 textHoraA.setText(formateador.format(fecha).toString());
		 	
		 */
	}
	
	
	//TODO funcion Limpiar
	public void limpiar(){
		txtDni.setText(null);
		txtApe.setText(null);
		txtNom.setText(null);
		txtSen.setText(null);
		txtMontoApagar.setText(null);
		txtMontoFaltante.setText(null);
		lSolucionBusqueda.setVisible(false);
		num=null;
		listaPersonas.clear();
		comboBox.removeAllItems();
		mapInmueble.clear();
		comboBox.addItem("Seleccione el inmueble");
		txtObservaciones.setText(null);
		calen.setDate(null);
		habilitarCampoPersona(true);				
		comboResult.setVisible(false);
		comboResult.removeAllItems();
		mapPersona.clear();
//		dateFechaReserva.setEnabled(false);
		//btnAceptar.setEnabled(false);

		}
										
	public Alquiler cargarDatos(Personas per, Inmuebles inm){
		try {
			Date auxr = new Date(0, 0, 0, 0, 0, 0);
			auxr = calen.getDate();//dateFechaReserva.getDate();
			int q = (int) txtHoraR.getValue();
			auxr.setHours(q);
			auxr.setMinutes(0);
			auxr.setSeconds(0);
			Date auxActual = new Date();
			auxActual.setSeconds(0);
			//		int q =au.getHours();
			//		//		az.get(Calendar.HOUR);
			//		aux.setText(Integer.valueOf(q).toString());//TODO funcion para mostrar en txt hora fecha
			Integer cantidadhoras = (Integer) txtCantidadHoras.getValue();
			float preciototal = CalcularPrecioTotal(per, inm, cantidadhoras);
			float montofaltante = preciototal - inm.getSenial();
			byte pagoalquiler = 0;
			byte activo = 1;
			String observaciones = txtObservaciones.getText().toString();
			alqui = new Alquiler();
			alqui.setPersonas(per);
			alqui.setInmuebles(inm);
			alqui.setFechaactual(auxActual);
			alqui.setFechareserva(auxr);
			alqui.setFechapagoalquiler(new Date(0, 0, 0, 0, 0, 0));
			alqui.setMontofaltante(montofaltante);
			alqui.setCantidadhoras(cantidadhoras);
			alqui.setPreciototal(preciototal);
			alqui.setPagoalquiler(pagoalquiler);
			alqui.setObservaciones(observaciones);
			alqui.setActivo(activo);
			return alqui;
		} catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR EN LA CARGA DE DATOS.", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
			return null;
		}
	
//		(inm, per, auxActual, 
//				auxr,
//				fechapagoalquiler, montofaltante, cantidadhoras, 
//				preciototal, pagoalquiler, observaciones, activo)

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
	
	
@SuppressWarnings("deprecation")
public void cargarDatos(){
	/*
	alqui=miCoordinador.CrearAlquiler();
	//alqui.setNroAlquiler(Integer.parseInt(txtNroAlquiler.getText().toString()));
	if((pers!=null)&&(inm!=null)&&(dateFechaReserva.getDate()!=null)&&(txtCantidadHoras.getText()!=null)){
		alqui.setInmuebles(inm);
		alqui.setPersonas(pers);
		Date fecha=new Date();
	
		alqui.setFechaActual(fecha);
		alqui.setHoraActual(fecha);
	
		alqui.setFechaReserva(dateFechaReserva.getDate());
		fecha.setHours(Integer.parseInt(comboHoraR.getSelectedItem().toString())); 
		alqui.setHoraReserva(fecha);
		alqui.setCantidadHora(Integer.parseInt(txtCantidadHoras.getText().toString()));
	
		alqui.setObservaciones(textArea.getText());
		alqui.setPagoAlquiler(chcAlquilerPagado.isSelected());
		alqui.setActivo(true);
		alqui.setPrecioTotal(this.CalcularPrecioTotal(Integer.parseInt(txtCantidadHoras.getText().toString()),pers,inm));
	}
	
	*/
}  

public float CalcularPrecioTotal( Personas per,Inmuebles in, Integer cantHoras ){
	float tot=0f;
	//tot=miCoordinador.CalcularPrecioTotal(per, in,cantHoras);
	tot=in.getPreciohora()*cantHoras;
	
	if((per.getSocios()!=null)&&(per.getSocios().getEstado()!="MOROSO")&&(per.isHabilitado()==true)&&(per.getSocios().isBaja()==false))
	{
		tot=tot*(1-((per.getSocios().getCategoria().getDescuento())/100));
	}
	
	
	/*tot=in.getPrecioHora()*al;
	lblNewLabel.setVisible(false); //  no sirven yaaaaaa
	if((per.isEssocio()==true)&&(per.getEstado()!="MOROSO")){
		tot= tot*((100-per.getCategoria().getDescuento())/100);
		lblNewLabel.setText("*Precio con descuento por Socio de % "+ per.getCategoria().getDescuento());
		lblNewLabel.setVisible(true);
	}*/
	return tot;
	
}


public boolean personaHabilitadaParaAlquiler(Personas per)
{//TODO funcion Persona habilitada para alquilar NOSE TIENE EN CUENTA BAJA DEL SOCIO
	//return miCoordinador.personaHabilitadaParaAlquiler(per);
	
	if((!per.isHabilitado())||((per.isHabilitado())&&(per.getSocios()!=null)&&(per.getSocios().getEstado().equals("MOROSO")))	)
		{
			miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 3);
			pers=miCoordinador.CrearPersona();
			//limpiar();
			return false;
		}  
	else{
			cargarCombo();
			habilitarCampoPersona(false);
			return true;
		}
	
	
//	if(per.isHabilitado())
//	{
//		if(per.getSocios()!=null)
//		{ 
//			if((per.getSocios().getEstado().equals("ACTIVO"))||(per.getSocios().getEstado().equals("DEUDOR"))||/*PARA ELIMINAR*/(per.getSocios().getEstado().equals("")))
//			{
//				cargarCombo();
//				habilitarCampoPersona(false);
//					return true;
//					
//			}else {		
//				miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 3);
//				pers=miCoordinador.CrearPersona();
//				//limpiar();
//				return false;}
//			
//			
//		}else
//		{
//			cargarCombo();
//			habilitarCampoPersona(false);
//			return true;
//			}
//
//		
//	}else {		
//		miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 3);
//		pers=miCoordinador.CrearPersona();
//		//limpiar();
//		return false;}
	
	
}




	private void habilitarCampoPersona(boolean b) {
	txtApe.setEditable(b);
	txtDni.setEditable(b);
	txtNom.setEditable(b);
	btnBuscarPersona.setEnabled(b);
	
}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			if(e.getSource()==btnBuscarPersona)
			{
				if((!txtDni.getText().isEmpty()))
				{
					pers=miCoordinador.BuscarPersona(Integer.parseInt(txtDni.getText()));
					if(personaHabilitadaParaAlquiler(pers))
					{ txtApe.setText(pers.getApellido().toString());
					txtNom.setText(pers.getNombre().toString());
					}
					
					
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
			
				
//				if((pers==null)||(pers.isHabilitado()==false))
//				{
//					JOptionPane.showMessageDialog(null,
//							"NO SE ENCUENTRA LA PERSONA O NO NO ESTA HABILITADA",
//							"RESULTADO DE BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);
//					}else 
//						{
//						JOptionPane.showMessageDialog(null, "SE ENCONTRO A LA PERSONA",
//						"	RESULTADO DE BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);
//						}
			}
			
			
		}catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		try{
			if(e.getSource()==btnAceptar)
			{
				if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "Desea Guardar el alquiler", 3)){
				Alquiler aux = cargarDatos( pers,inm);
				miCoordinador.GuardarAlquiler(aux);
				miCoordinador.mensajes("SE GUARDO CORRECTAMENTE", 3);
				this.limpiar();
//				this.dispose();
//				}
				
				}
				
				
				
				
				
			}
			//TODO codigo para probar alquiler
			
			
			
			
			
			
			/*
			if(e.getSource()==btnAceptar){
				
			
				if((pers==null)||(pers.isHabilitado()==false)){
					JOptionPane.showMessageDialog(null, "NO SE ELIGIO UNA PERSONA O NO NO ESTA HABILITADA", "NO SE REALIZO NINGUNA BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);
				}else {
					cargarDatos();
					miCoordinador.RegistrarNuevoAlquiler(alqui);
					JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE", "ALQUILER GUARDADO",JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					
				}
			}
			
			*/
		}catch(Exception e1){
			
			JOptionPane.showMessageDialog(null, "REINTENTE LA OPERACION: " + e1.getMessage(), "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		if(e.getSource()==btnCancelar){
			this.dispose();
		}
		
		if(e.getSource()==btnLimpiar){
			limpiar();
			
		}
		
		
		
	}
	
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}

	
		
		
		
		
			
	