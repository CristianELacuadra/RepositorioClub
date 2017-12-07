package ar.com.ProyectoClub.AVista;

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


public class PantallaNuevoAlquiler extends JDialog implements ActionListener,KeyListener {
	public JTextField txtDni;
	private ControllerCoordinador miCoordinador;
	public JLabel lblFechaDeReserva;
	public JLabel lblHoraDeReserva;
	public JLabel lblCantidadDeHoras;
	public JLabel lblInmuebleAlquilar;
	public JLabel lblPrecioTotal;
	public JDateChooser dateFechaReserva;
	public JTextField ResuPrecioTotal;
	public JButton btnAceptar;
	public JButton btnCancelar;
	public JButton btnLimpiar;
	public JLabel lblCodSocio;
	public JLabel lblNewLabel;
	public JPanel panelTitulo;
	public JCheckBox chcAlquilerPagado;
	public JButton btnBuscarPersona;
	public JLabel label;
	public JScrollPane scrollPane;
 	public JTextArea textArea;
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
	
	
	
	
	public PantallaNuevoAlquiler(PantallaAlquilerPrincipal vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setBackground(UIManager.getColor("Button.light"));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				limpiar();
				setVisible(false);
			}
		});
		
		//setResizable(false);
		setTitle("NUEVO ALQUILER");
		initComponents();
		setBounds(100, 100, 540, 718);

	}
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
		//dateFechaReserva.
		
		}
	
	
	public void cargardatos(){
		alqui.setNroalquiler(null);
		alqui.setPersonas(pers);// revisar validacion de persona
		alqui.setInmuebles(inm);// revisar validacion de inmueble
		alqui.setFechaactual( new Date()); //directamente del sistema
			
			}
	
	public void initComponents(){
		miCoordinador=new ControllerCoordinador();
		dateFechaReserva = new JDateChooser();
		dateFechaReserva.setBounds(186, 235, 182, 20);
		
		btnAceptar = new JButton("Guardar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/aceptar.png")));
		btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		//btnAceptar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/apply.png")));
		btnAceptar.setBounds(433, 281, 81, 51);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/cancel.png")));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setBounds(431, 343, 83, 51);
		
		lblNewLabel = new JLabel("*Precio con descuento por Socio de %");
		lblNewLabel.setBounds(186, 518, 184, 14);
		lblNewLabel.setVisible(false);
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(10, 11, 504, 35);
		panelTitulo.setBackground(new Color(0, 191, 255));
		panelTitulo.setBorder(UIManager.getBorder("ComboBox.border"));
		
		chcAlquilerPagado = new JCheckBox("PAGAR POR COMPLETO");
		chcAlquilerPagado.setBounds(374, 451, 141, 23);
		chcAlquilerPagado.setToolTipText("Seleccionar cuando se pagar\u00E1 en el momento");
		
		btnBuscarPersona = new JButton("Buscar");
		btnBuscarPersona.setBounds(363, 77, 118, 33);
		btnBuscarPersona.setHorizontalAlignment(SwingConstants.LEFT);
	//	btnBuscarPersona.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));


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
		
		lblCodSocio = new JLabel("DNI  DE LA PERSONA");
		lblCodSocio.setBounds(74, 60, 102, 14);
		getContentPane().add(lblCodSocio);
		lblPrecioTotal = new JLabel("PRECIO TOTAL: $");
		lblPrecioTotal.setBounds(87, 419, 86, 14);
		getContentPane().add(lblPrecioTotal);
		
		ResuPrecioTotal = new JTextField();
		ResuPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		ResuPrecioTotal.setBounds(186, 416, 182, 20);
		ResuPrecioTotal.setBackground(new Color(204, 204, 204));
		ResuPrecioTotal.setBorder(UIManager.getBorder("ComboBox.border"));
		ResuPrecioTotal.setEditable(false);
		getContentPane().add(ResuPrecioTotal);
		
		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDni.setBounds(186, 57, 167, 20);
		txtDni.setColumns(10);
		getContentPane().add(txtDni);
		
		label = new JLabel("OBSERVACIONES:");
		label.setBounds(85, 574, 88, 14);
		getContentPane().add(label);
		getContentPane().add(dateFechaReserva);
		getContentPane().add(chcAlquilerPagado);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnAceptar);
		getContentPane().add(lblNewLabel);
		getContentPane().add(btnBuscarPersona);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 568, 271, 113);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el inmueble"}));
		comboBox.setBounds(186, 195, 182, 20);
		getContentPane().add(comboBox);
		
		txtApe = new JTextField();
		txtApe.setHorizontalAlignment(SwingConstants.RIGHT);
		txtApe.setBounds(186, 83, 167, 20);
		getContentPane().add(txtApe);
		txtApe.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNom.setBounds(186, 114, 167, 20);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO  DE LA PERSONA");
		lblNewLabel_2.setBounds(44, 86, 132, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNombreDeLa = new JLabel("NOMBRE DE LA PERSONA");
		lblNombreDeLa.setBounds(53, 117, 123, 14);
		getContentPane().add(lblNombreDeLa);
		
		JSpinner txtHoraR = new JSpinner();
		txtHoraR.setModel(new SpinnerNumberModel(6, 6, 23, 1));
		txtHoraR.setBounds(186, 268, 182, 20);
		getContentPane().add(txtHoraR);
		
		JSpinner textCantidadHoras = new JSpinner();
		textCantidadHoras.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		textCantidadHoras.setBounds(186, 296, 182, 20);
		getContentPane().add(textCantidadHoras);
	
		txtHoraR.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// Ponemos el valor del JSpinner en el JTextField
				Integer.parseInt(txtHoraR.getValue().toString());
				textCantidadHoras.setModel(new SpinnerNumberModel(1, 1,(30-Integer.parseInt(txtHoraR.getValue().toString())),1));			
		//los alquileres empiezan desde las 6 hasta las 23
				//todos los alquileres tienen como maximo hasta las 6 del otro dia
				//esta funcion determina el numero maximo de horas para alquilar, 
				//falta completar cuando es un dia con alquileres ya cargados
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("SE\u00D1A");
		lblNewLabel_3.setBounds(146, 388, 26, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u00BFCUANTO VA A PAGAR?");
		lblNewLabel_4.setBounds(58, 455, 115, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MONTO FALTANTE");
		lblNewLabel_5.setBounds(83, 490, 90, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtSen = new JTextField();
		txtSen.setBackground(new Color(204, 204, 204));
		txtSen.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSen.setEditable(false);
		txtSen.setBounds(186, 385, 182, 20);
		getContentPane().add(txtSen);
		txtSen.setColumns(102);
		
		txtMontoApagar = new JTextField();
		txtMontoApagar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoApagar.setBounds(186, 452, 182, 20);
		getContentPane().add(txtMontoApagar);
		txtMontoApagar.setColumns(10);
		
		txtMontoFaltante = new JTextField();
		txtMontoFaltante.setBackground(new Color(204, 204, 204));
		txtMontoFaltante.setEditable(false);
		txtMontoFaltante.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMontoFaltante.setBounds(186, 487, 182, 20);
		getContentPane().add(txtMontoFaltante);
		txtMontoFaltante.setColumns(10);
		
		lSolucionBusqueda = new JLabel("NO ENCONTRADO");
		lSolucionBusqueda.setVisible(false);
		lSolucionBusqueda.setBounds(365, 132, 88, 14);
		getContentPane().add(lSolucionBusqueda);
		
		btnLimpiar = new JButton("Limpiar Campos");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLimpiar.setHorizontalAlignment(SwingConstants.RIGHT);
		btnLimpiar.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png")));
		btnLimpiar.setBounds(390, 195, 129, 77);
		getContentPane().add(btnLimpiar);
		
		comboResult = new JComboBox();
		comboResult.setVisible(false);
		comboResult.setBounds(63, 142, 290, 20);
		getContentPane().add(comboResult);
		
		comboResult.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ed) {
				// TODO Auto-generated method stub
				if(ed.getStateChange()== ItemEvent.DESELECTED){
					
				}
					
			}	
					
		});
		
		
		
		
		
		
	/*	
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ed) {
				// TODO Auto-generated method stub
				if(ed.getStateChange()== ItemEvent.DESELECTED){
					for (Map.Entry<Integer, String> entry : mapInmueble.entrySet()){
						if(comboBox.getSelectedItem().equals(entry.getValue())){
							auxIdInm=entry.getKey();
							inm=miCoordinador.BuscarInmueble(auxIdInm);
							textArea.setText(inm.getNombre());
							//if((pers!=null)&&(inm!=null)&&(textCantidadHoras.getText()!=null)){
							//	ResuPrecioTotal.setText(String.valueOf(CalcularPrecioTotal(Integer.parseInt(textCantidadHoras.getText().toString()),pers,inm)));
						
							
							}
					}
					
					}
				}
				
				
			}});
		*/
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
		
		btnBuscarPersona.addActionListener(this);
		btnAceptar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
			
	}

	public void cargarComboBoxDeBusquedaDePersonas(java.util.List<Personas> listaPersonas2){
		comboResult.removeAllItems();
		mapPersona.clear();
		comboBox.addItem("Seleccione una persona");
		for (Personas _per: listaPersonas2){
			comboResult.addItem(_per.getApellido()+" "+_per.getNombre());
			mapPersona.put(_per.getDni(), _per.getApellido()+" "+_per.getNombre());
			
			
		}
		
		
		
		
	}
	
	
	public void cargarCombo(){
		comboBox.removeAllItems();
		mapInmueble.clear();
		comboBox.addItem("Seleccione el inmueble");
		for (Inmuebles _inm :miCoordinador.ListarInmueblesAlquiler()){
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
		 
		 inm=null;//miCoordinador.CrearInmueble();
		 pers=miCoordinador.CrearPersona();
		// alqui=null;//miCoordinador.CrearAlquiler();
		 alqui=miCoordinador.CrearAlquiler();
		 lblNewLabel.setVisible(false);
		 chcAlquilerPagado.setSelected(false);
		 dateFechaReserva.setDate(null);
		 txtDni.setText(null);
		 */
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
	
	
@SuppressWarnings("deprecation")
public void cargarDatos(){
	alqui=miCoordinador.CrearAlquiler();
	//alqui.setNroAlquiler(Integer.parseInt(txtNroAlquiler.getText().toString()));
	if((pers!=null)&&(inm!=null)&&(dateFechaReserva.getDate()!=null)&&(textCantidadHoras.getText()!=null)){
		alqui.setInmuebles(inm);
		alqui.setPersonas(pers);
		Date fecha=new Date();
	
		alqui.setFechaActual(fecha);
		alqui.setHoraActual(fecha);
	
		alqui.setFechaReserva(dateFechaReserva.getDate());
		fecha.setHours(Integer.parseInt(comboHoraR.getSelectedItem().toString())); 
		alqui.setHoraReserva(fecha);
		alqui.setCantidadHora(Integer.parseInt(textCantidadHoras.getText().toString()));
	
		alqui.setObservaciones(textArea.getText());
		alqui.setPagoAlquiler(chcAlquilerPagado.isSelected());
		alqui.setActivo(true);
		alqui.setPrecioTotal(this.CalcularPrecioTotal(Integer.parseInt(textCantidadHoras.getText().toString()),pers,inm));
	}
	
}

public float CalcularPrecioTotal(Integer al, Personas per,Inmuebles in ){
	float tot=in.getPrecioHora()*al;
	lblNewLabel.setVisible(false);   no sirven yaaaaaa
	if((per.isEssocio()==true)&&(per.getEstado()!="MOROSO")){
		tot= tot*((100-per.getCategoria().getDescuento())/100);
		lblNewLabel.setText("*Precio con descuento por Socio de % "+ per.getCategoria().getDescuento());
		lblNewLabel.setVisible(true);
	}
	return tot;
}


public boolean personaHabilitadaParaAlquiler(Personas per){
	if(per.isHabilitado()&&(per!=null)){
		return true;
	}else{
		miCoordinador.mensajes("Esta persona no esta habilitada para Alquilar", 3);
		pers=null;
		return false;
	
	
	}
}



	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnBuscarPersona){
				if(!(txtDni.getText().isEmpty()||(!txtApe.getText().isEmpty())||(!txtNom.getText().isEmpty()))){
					
					pers=miCoordinador.BuscarPersona(Integer.parseInt(txtDni.getText()));
						
					
					
				}else{
					if((!txtApe.getText().isEmpty())||(!txtNom.getText().isEmpty())){
						listaPersonas = new ArrayList<Personas>();
						listaPersonas.clear();
						listaPersonas=miCoordinador.filtrarPersonaPor(txtNom.getText().toString(), txtApe.getText().toString());
						if(!listaPersonas.equals(null))
							cargarComboBoxDeBusquedaDePersonas(listaPersonas);		
								
						
					}
					
				}
				//Personas pers=miCoordinador.CrearPersona();
				//miCoordinado
				if((pers==null)||(pers.isHabilitado()==false)){
					JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA O NO NO ESTA HABILITADA", "RESULTADO DE BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);
				}else {JOptionPane.showMessageDialog(null, "SE ENCONTRO A LA PERSONA", "RESULTADO DE BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);}
			}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		try{
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
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "REINTENTE LA OPERACION", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}
		if(e.getSource()==btnCancelar){
			this.dispose();
		}
	}
	
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	
}

	
		
		
		
		
			
	