package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PantallaDetallesAlquiler extends JDialog implements ActionListener,KeyListener {
	public JPanel panel;
	public JLabel label;
	public JPanel panel_1;
	public JLabel label_1;
	public JLabel label_2;
	public JLabel lblFecha;
	public JLabel lblHora;
	public JLabel label_5;
	public JLabel label_6;
	public JLabel label_7;
	public JLabel label_8;
	public JLabel label_9;
	public JLabel label_10;
	public JCheckBox checkAlquilerPagado;
	public JTextArea textArea;
	public JTextField txtNroAlquiler;
	public JTextField txtNroPersona;
	public JTextField txtFechaA;
	public JTextField txtHoraA;
	public JTextField txtCantidadHoras;
	public JTextField txtInmueble;
	public JTextField txtPrecioTotal;
	public JDateChooser fechaReserva;
	public JComboBox horaReserva;
	public JTextArea txtObservaciones;
	public JScrollPane scrollPane;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnPagar;
	public JButton btnVolver;
	private ControllerCoordinador miCoordinador;
	
	public PantallaDetallesAlquiler(javax.swing.JDialog vtn,boolean b,Integer opcion) {
		super(vtn,b);
		setResizable(false);
		setBounds(100, 100, 585, 653);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoInmueble.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		getContentPane().setLayout(null);
		initComponent(opcion);
		
	}

@SuppressWarnings("deprecation")
public void initComponent(Integer aux){
	panel = new JPanel();
	panel.setBorder(UIManager.getBorder("ComboBox.border"));
	panel.setBackground(Color.RED);
	panel.setBounds(10, 11, 559, 35);
	getContentPane().add(panel);
	
	label = new JLabel("");
	label.setFont(new Font("Tahoma", Font.PLAIN, 18));
	panel.add(label);
	
	panel_1 = new JPanel();
	panel_1.setBackground(Color.LIGHT_GRAY);
	panel_1.setBorder(UIManager.getBorder("ComboBox.border"));
	panel_1.setBounds(10, 57, 393, 568);
	getContentPane().add(panel_1);
	panel_1.setLayout(null);
	
	label_1 = new JLabel("NUMERO DE ALQUILER");
	label_1.setBounds(10, 11, 118, 14);
	panel_1.add(label_1);
	
	label_2 = new JLabel("NUMERO DEL SOCIO O NO-SOCIO");
	label_2.setBounds(10, 51, 166, 14);
	panel_1.add(label_2);
	
	lblFecha = new JLabel("FECHA");
	lblFecha.setBounds(10, 88, 118, 14);
	panel_1.add(lblFecha);
	
	lblHora = new JLabel("HORA");
	lblHora.setBounds(10, 128, 118, 14);
	panel_1.add(lblHora);
	
	label_5 = new JLabel("FECHA DE RESERVA");
	label_5.setBounds(10, 169, 118, 14);
	panel_1.add(label_5);
	
	label_6 = new JLabel("HORA DE RESERVA");
	label_6.setBounds(10, 214, 118, 14);
	panel_1.add(label_6);
	
	label_7 = new JLabel("CANTIDAD DE HORAS ");
	label_7.setBounds(10, 260, 118, 14);
	panel_1.add(label_7);
	
	label_8 = new JLabel("INMUEBLE A ALQUILAR");
	label_8.setBounds(10, 311, 118, 14);
	panel_1.add(label_8);
	
	label_9 = new JLabel("PRECIO TOTAL: $");
	label_9.setBounds(10, 394, 118, 14);
	panel_1.add(label_9);
	
	checkAlquilerPagado = new JCheckBox("ALQUILER PAGADO");
	checkAlquilerPagado.setEnabled(false);
	checkAlquilerPagado.setOpaque(false);
	checkAlquilerPagado.setToolTipText("Seleccionar cuando se pagar\u00E1 en el momento");
	checkAlquilerPagado.setBounds(10, 350, 119, 23);
	panel_1.add(checkAlquilerPagado);
	
	label_10 = new JLabel("OBSERVACIONES:");
	label_10.setBounds(10, 440, 101, 14);
	panel_1.add(label_10);
	
	txtNroAlquiler = new JTextField();
	txtNroAlquiler.setEditable(false);
	txtNroAlquiler.setBounds(203, 8, 180, 20);
	panel_1.add(txtNroAlquiler);
	txtNroAlquiler.setColumns(10);
	
	txtNroPersona = new JTextField();
	txtNroPersona.setEditable(false);
	txtNroPersona.setBounds(203, 48, 180, 20);
	panel_1.add(txtNroPersona);
	txtNroPersona.setColumns(10);
	
	txtFechaA = new JTextField();
	txtFechaA.setEditable(false);
	txtFechaA.setBounds(203, 85, 180, 20);
	panel_1.add(txtFechaA);
	txtFechaA.setColumns(10);
	
	txtHoraA = new JTextField();
	txtHoraA.setEditable(false);
	txtHoraA.setBounds(203, 125, 180, 20);
	panel_1.add(txtHoraA);
	txtHoraA.setColumns(10);
	
	fechaReserva = new JDateChooser();
	fechaReserva.setBounds(203, 163, 180, 20);
	panel_1.add(fechaReserva);
	
	 horaReserva = new JComboBox();
	 horaReserva.setModel(new DefaultComboBoxModel(new String[] {"6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
	
	horaReserva.setBounds(203, 214, 180, 20);
	panel_1.add(horaReserva);
	
	
	txtCantidadHoras = new JTextField();
	txtCantidadHoras.setBounds(203, 257, 180, 20);
	panel_1.add(txtCantidadHoras);
	txtCantidadHoras.setColumns(10);
	
	txtInmueble = new JTextField();
	txtInmueble.setEditable(false);
	txtInmueble.setBounds(203, 305, 180, 20);
	panel_1.add(txtInmueble);
	txtInmueble.setColumns(10);
	
	txtPrecioTotal = new JTextField();
	txtPrecioTotal.setEditable(false);
	txtPrecioTotal.setBounds(203, 391, 180, 20);
	panel_1.add(txtPrecioTotal);
	txtPrecioTotal.setColumns(10);
	
	 scrollPane = new JScrollPane();
	scrollPane.setBounds(112, 444, 271, 113);
	panel_1.add(scrollPane);
	
	txtObservaciones = new JTextArea();
	txtObservaciones.setLineWrap(true);
	txtObservaciones.setAutoscrolls(false);
	scrollPane.setViewportView(txtObservaciones);
	
	btnModificar = new JButton("GUARDAR CAMBIOS");
	btnModificar.setBounds(426, 78, 143, 42);
	getContentPane().add(btnModificar);
	btnModificar.setEnabled(false);
	btnModificar.setVisible(false);
	
	btnEliminar = new JButton("ELIMINAR");
	btnEliminar.setBounds(426, 131, 143, 42);
	getContentPane().add(btnEliminar);
	btnEliminar.setEnabled(false);
	btnEliminar.setVisible(false);
	
	btnPagar = new JButton("PAGAR");
	btnPagar.setBounds(426, 184, 143, 42);
	getContentPane().add(btnPagar);
	btnPagar.setEnabled(false);
	btnPagar.setVisible(false);
	
	btnVolver = new JButton("VOLVER");
	btnVolver.setBounds(426, 237, 143, 42);
	getContentPane().add(btnVolver);
	
	switch(aux){
	case 0 :
		btnModificar.setEnabled(false);
		btnModificar.setVisible(true);
		label.setText("MODIFICAR EL ALQUILER SELECCIONADO");
		break;
	case 1 :
		btnEliminar.setEnabled(false);
		btnEliminar.setVisible(true);
		label.setText("ELIMINAR EL ALQUILER SELECCIONADO");
		break;
	
	case 2 :
		btnPagar.setEnabled(false);
		btnPagar.setVisible(true);
		label.setText("PAGAR EL ALQUILER SELECCIONADO");
		break;
		
	default:
		JOptionPane.showMessageDialog(null, "ha ocurrido un error al generarse la ventana", null,JOptionPane.ERROR_MESSAGE );
		
	}
	btnModificar.addActionListener(this);
	btnEliminar.addActionListener(this);
	btnPagar.addActionListener(this);
	btnVolver.addActionListener(this);
	
	
}

public void cargarDatos(Alquiler a){
	txtNroAlquiler.setText(a.getNroAlquiler().toString());
	txtNroPersona.setText(a.getPersonas().getDni().toString());
	txtFechaA.setText(a.getFechaActual().toString());
	txtHoraA.setText(a.getHoraActual().toString());
	fechaReserva.setDate(a.getFechaReserva());
	horaReserva.setSelectedItem(a.getHoraReserva());
	txtCantidadHoras.setText(a.getCantidadHora().toString());
	txtPrecioTotal.setText(String.valueOf(a.getPrecioTotal()));
	checkAlquilerPagado.setSelected(a.isPagoAlquiler());
	txtObservaciones.setText(a.getObservaciones());
	
	
	
}

@SuppressWarnings("deprecation")
public Alquiler CargarModificar(Alquiler a){
	//la modificacion solo modifica la fecha de reserva, y observaciones de lo contrario seria otro alquiler.
	a.setFechaReserva(fechaReserva.getDate());
	a.setObservaciones(txtObservaciones.getText());
	
	Date asd=new Date();
	asd.setHours(Integer.parseInt(horaReserva.getSelectedItem().toString()));
	a.setHoraReserva(asd);
	return a;
	
	
}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnModificar)
		{
		//	miCoordinador.ModificarAlquiler();
			Date asd=new Date();
			asd.setHours(Integer.parseInt(horaReserva.getSelectedItem().toString()));
			
		}
		
		if(e.getSource()==btnEliminar)
		{
			//miCoordinador.EliminarAlquiler();
		}
		
		if(e.getSource()==btnPagar)
		{
		//	miCoordinador.PagarAlquiler();
		}
		
		if(e.getSource()==btnVolver)
		{
			this.dispose();
		}
		
		
		
		
	}

	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
