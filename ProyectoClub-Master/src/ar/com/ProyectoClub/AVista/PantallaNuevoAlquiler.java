package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

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
import java.util.Date;


public class PantallaNuevoAlquiler extends JDialog implements ActionListener,KeyListener {
	public JTextField textCantidadHoras;
	public JTextField txtSNS;
	public JTextField txtNombreInmueble;
	private ControllerCoordinador miCoordinador;
	public JLabel lblNumeroDeAlquiler;
	public JLabel lblFechaAlcual;
	public JLabel lblHoraActual;
	public JLabel lblFechaDeReserva;
	public JLabel lblHoraDeReserva;
	public JLabel lblCantidadDeHoras;
	public JLabel lblInmuebleAlquilar;
	public JLabel lblPrecioTotal;
	public JDateChooser dateFechaReserva;
	public JLabel ResuPrecioTotal;
	public JComboBox comboHoraR;
	public JButton btnAceptar;
	public JButton btnCancelar;
	public JLabel lblCodSocio;
	public JLabel lblNewLabel;
	public JPanel panelTitulo;
	public JCheckBox chcAlquilerPagado;
	public JButton btnBuscarPersona;
	public JTextField textHoraA;
	public JTextField textFechaActual;
	public JLabel label;
	public JScrollPane scrollPane;
 	public JTextArea textArea;
 	public Inmuebles inm;
 	public Personas pers;
 	public Alquiler alqui;
 	public JButton btnBuscarInmueble;
 	private JTextField txtNroAlquiler;

	
	
	public PantallaNuevoAlquiler(PantallaAlquiler vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setResizable(false);
		setTitle("NUEVO ALQUILER");
		initComponents();
		setBounds(100, 100, 614, 737);

	}
	
	public void initComponents(){
		
		dateFechaReserva = new JDateChooser();
		dateFechaReserva.setBounds(186, 295, 182, 20);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(434, 218, 119, 23);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(434, 252, 119, 23);
		
		lblNewLabel = new JLabel("*Precio con descuento por Socio de %");
		lblNewLabel.setBounds(378, 489, 184, 14);
		lblNewLabel.setVisible(false);
		
		panelTitulo = new JPanel();
		panelTitulo.setBounds(10, 11, 633, 35);
		panelTitulo.setBackground(Color.RED);
		panelTitulo.setBorder(UIManager.getBorder("ComboBox.border"));
		
		chcAlquilerPagado = new JCheckBox("ALQUILER PAGADO");
		chcAlquilerPagado.setBounds(9, 533, 119, 23);
		chcAlquilerPagado.setToolTipText("Seleccionar cuando se pagar\u00E1 en el momento");
		
		btnBuscarPersona = new JButton("Buscar");
		btnBuscarPersona.setBounds(374, 116, 93, 33);
		btnBuscarPersona.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarPersona.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRO DE NUEVO ALQUILER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelTitulo.add(lblNewLabel_1);
		getContentPane().setLayout(null);
		getContentPane().add(panelTitulo);
		lblNumeroDeAlquiler = new JLabel("NUMERO DE ALQUILER");
		lblNumeroDeAlquiler.setBounds(10, 65, 118, 14);
		getContentPane().add(lblNumeroDeAlquiler);
		lblInmuebleAlquilar = new JLabel("INMUEBLE A ALQUILAR");
		lblInmuebleAlquilar.setBounds(10, 443, 118, 14);
		getContentPane().add(lblInmuebleAlquilar);
		lblCantidadDeHoras = new JLabel("CANTIDAD DE HORAS ");
		lblCantidadDeHoras.setBounds(10, 397, 118, 14);
		getContentPane().add(lblCantidadDeHoras);
		lblHoraDeReserva = new JLabel("HORA DE RESERVA");
		lblHoraDeReserva.setBounds(10, 346, 118, 14);
		getContentPane().add(lblHoraDeReserva);
		lblFechaDeReserva = new JLabel("FECHA DE RESERVA");
		lblFechaDeReserva.setBounds(10, 295, 118, 14);
		getContentPane().add(lblFechaDeReserva);
		lblHoraActual = new JLabel("HORA ACTUAL");
		lblHoraActual.setBounds(10, 238, 118, 14);
		getContentPane().add(lblHoraActual);
		lblFechaAlcual = new JLabel("FECHA ACTUAL");
		lblFechaAlcual.setBounds(10, 188, 118, 14);
		getContentPane().add(lblFechaAlcual);
		
		lblCodSocio = new JLabel("DNI DEL SOCIO O NO-SOCIO");
		lblCodSocio.setBounds(10, 125, 166, 14);
		getContentPane().add(lblCodSocio);
		lblPrecioTotal = new JLabel("PRECIO TOTAL: $");
		lblPrecioTotal.setBounds(10, 489, 118, 14);
		getContentPane().add(lblPrecioTotal);
		
		ResuPrecioTotal = new JLabel("...");
		ResuPrecioTotal.setBounds(186, 487, 182, 20);
		ResuPrecioTotal.setBackground(UIManager.getColor("Table.sortIconLight"));
		ResuPrecioTotal.setBorder(UIManager.getBorder("ComboBox.border"));
		getContentPane().add(ResuPrecioTotal);
		
		txtSNS = new JTextField();
		txtSNS.setBounds(186, 122, 182, 20);
		txtSNS.setColumns(10);
		getContentPane().add(txtSNS);
		
		textCantidadHoras = new JTextField();
		textCantidadHoras.setBounds(186, 394, 182, 20);
		textCantidadHoras.setBackground(UIManager.getColor("TextField.background"));
		textCantidadHoras.setColumns(10);
		getContentPane().add(textCantidadHoras);
		comboHoraR = new JComboBox();
		comboHoraR.setModel(new DefaultComboBoxModel(new String[] {"6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboHoraR.setBounds(186, 343, 182, 20);
		getContentPane().add(comboHoraR);
		
		txtNombreInmueble = new JTextField();
		txtNombreInmueble.setEditable(false);
		txtNombreInmueble.setBounds(186, 440, 182, 20);
		txtNombreInmueble.setColumns(10);
		getContentPane().add(txtNombreInmueble);
		
		btnBuscarInmueble = new JButton("Buscar");
		btnBuscarInmueble.setBounds(374, 432, 93, 33);
		btnBuscarInmueble.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarInmueble.setIcon(new ImageIcon(PantallaNuevoAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		getContentPane().add(btnBuscarInmueble);
		
		textHoraA = new JTextField();
		textHoraA.setEditable(false);
		textHoraA.setBounds(186, 235, 182, 20);
		getContentPane().add(textHoraA);
		textHoraA.setColumns(10);
		
		textFechaActual = new JTextField();
		textFechaActual.setEditable(false);
		textFechaActual.setBounds(186, 185, 182, 20);
		getContentPane().add(textFechaActual);
		textFechaActual.setColumns(10);
		
		label = new JLabel("OBSERVACIONES:");
		label.setBounds(10, 612, 101, 14);
		getContentPane().add(label);
		getContentPane().add(dateFechaReserva);
		getContentPane().add(chcAlquilerPagado);
		getContentPane().add(btnCancelar);
		getContentPane().add(btnAceptar);
		getContentPane().add(lblNewLabel);
		getContentPane().add(btnBuscarPersona);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 585, 271, 113);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setAutoscrolls(false);
		scrollPane.setViewportView(textArea);
		
		txtNroAlquiler = new JTextField();
		txtNroAlquiler.setEditable(false);
		txtNroAlquiler.setBounds(186, 62, 182, 20);
		getContentPane().add(txtNroAlquiler);
		txtNroAlquiler.setColumns(10);
		
		btnBuscarPersona.addActionListener(this);
		btnBuscarInmueble.addActionListener(this);
		
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
public void cargarDatos(){
	alqui=miCoordinador.CrearAlquiler();
	alqui.setNroAlquiler(Integer.parseInt(txtNroAlquiler.getText().toString()));
	alqui.setInmuebles(inm);
	alqui.setPersonas(pers);
	Date fecha=new Date();
	
	alqui.setFechaActual(fecha); //Date.parse(textFechaActual.getText().toString()
	alqui.setHoraActual(fecha);
	
	alqui.setFechaReserva(dateFechaReserva.getDate());
	fecha.setHours(Integer.parseInt(comboHoraR.getSelectedItem().toString())); 
	alqui.setHoraReserva(fecha);
	alqui.setCantidadHora(Integer.parseInt(textCantidadHoras.getText().toString()));
	
	alqui.setObservaciones(textArea.getText());
	alqui.setPagoAlquiler(chcAlquilerPagado.isSelected());
	alqui.setActivo(true);
	alqui.setPrecioTotal(miCoordinador.CalcularPrecioTotal(alqui,pers));
	
	/*
	 	Date asd=new Date();
			asd.setHours(Integer.parseInt(horaReserva.getSelectedItem().toString())); 
	 
	 */
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnBuscarPersona){
				Personas pers=miCoordinador.CrearPersona();
				pers=miCoordinador.BuscarPersona(Integer.parseInt(txtSNS.getText()));
				if(pers==null){
					JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA", "RESULTADO DE BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
			if(e.getSource()==btnBuscarInmueble){
				Inmuebles inm=miCoordinador.CrearInmueble();
				inm=miCoordinador.BuscarInmueble(txtNombreInmueble.getText());
				if(inm==null){
					JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA", "RESULTADO DE BUSQUEDA",JOptionPane.INFORMATION_MESSAGE);
				}
				}
			
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA", "HA OCURRIDO UN ERROR",JOptionPane.ERROR_MESSAGE);
		}

		
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
