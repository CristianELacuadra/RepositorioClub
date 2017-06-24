package ar.com.ProyectoClub.AVista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;




@SuppressWarnings("serial")
public class PantallaPersonas extends JDialog implements ActionListener {
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
	public JPanel panel;
	public JLabel lblImagen; 
	public JLabel lblPersonas; 
	public JButton btnAlta;
	public JButton btnBaja;
	public JButton btnBuscar;
	public JButton btnModificacion; 
	public JRadioButton checkEsSocio; 
	
	public PantallaPersonas(Principal vtnPrincipal,boolean b) {
		super(vtnPrincipal,b);
		initComponents();	
	}
	
	private void initComponents(){
		panel= new JPanel(); 
		lblImagen = new JLabel();
		lblPersonas = new JLabel();
		btnAlta= new JButton();
		btnBaja=new JButton();
		btnBuscar = new JButton();
		btnModificacion= new JButton();
		checkEsSocio= new JRadioButton();
		setType(Type.UTILITY);
		setBounds(100, 100, 745, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(5, 5, 550, 128);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		
		lblImagen.setIcon(new ImageIcon(PantallaPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		panel.add(lblImagen);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("SELECCIONE UNA OPERACION");
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.RED);
		panel_1.add(lblNewLabel_1);
		
		lblPersonas.setText("PERSONAS");
		lblPersonas.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblPersonas.setBounds(248, 144, 157, 29);
		contentPane.add(lblPersonas);
		
		btnAlta.setText("ALTA");
		btnAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlta.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAlta.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_add.png"));
		btnAlta.setBounds(21, 168, 273, 144);
		contentPane.add(btnAlta);
		
		btnBaja.setText("BAJA");
		btnBaja.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_delete.png"));
		btnBaja.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBaja.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaja.setBounds(352, 172, 304, 144);
		contentPane.add(btnBaja);
		
		btnBuscar.setText("BUSCAR");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_search.png"));
		btnBuscar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setBounds(21, 382, 273, 144);
		contentPane.add(btnBuscar);
		
		btnModificacion.setText("MODIFICACION");
		btnModificacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificacion.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data-modify.png"));
		btnModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificacion.setBounds(353, 382, 303, 144);
		contentPane.add(btnModificacion);
		checkEsSocio.setText("....");
		checkEsSocio.setVisible(false);
		checkEsSocio.setBounds(561, 5, 43, 23);
		contentPane.add(checkEsSocio);
		
		//atentos a las acciones del usuario
		btnAlta.addActionListener(this);
		btnBaja.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnModificacion.addActionListener(this);
	}
	

	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAlta){
			if(checkEsSocio.isSelected()){
				//socio
				miCoordinador.mostrarFormularioPersona(true);
			}
			else{
				//No socio
				miCoordinador.mostrarFormularioPersona(false);
			}
			
		}
		if(e.getSource()==btnBaja){
			if(checkEsSocio.isSelected()){
				//socio
				miCoordinador.mostrarVentanaEliminarSNS(true);
			}
			else{
				//No socio
				miCoordinador.mostrarVentanaEliminarSNS(false);
			}
		}
		
	}
}
