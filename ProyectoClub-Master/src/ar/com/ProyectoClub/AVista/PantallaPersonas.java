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
import javax.swing.JMenuBar;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;




@SuppressWarnings("serial")
public class PantallaPersonas extends JDialog implements ActionListener {
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JPanel contentPane;
	public JPanel panel;
	public JLabel lblImagen; 
	public JButton btnAlta;
	public JButton btnBaja;
	public JButton btnBuscar;
	public JButton btnModificacion; 
	public JRadioButton checkEsSocio; 
	private JPanel panel_3;
	public JButton btnCobranza;
	public JLabel lblCuotas;
	public JLabel lblPersonas; 
	
	public PantallaPersonas(Principal vtnPrincipal,boolean b) {
		super(vtnPrincipal,b);
		initComponents();	
	}
	
	private void initComponents(){
		panel= new JPanel(); 
		lblImagen = new JLabel();
		checkEsSocio= new JRadioButton();
		lblPersonas= new JLabel();
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
		checkEsSocio.setText("....");
		checkEsSocio.setVisible(false);
		checkEsSocio.setBounds(561, 5, 43, 23);
		contentPane.add(checkEsSocio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 185, 724, 169);
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		btnAlta= new JButton();
		panel_2.add(btnAlta);
		
		btnAlta.setText("ALTA");
		btnAlta.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlta.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAlta.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_add3.png"));
		btnBaja=new JButton();
		panel_2.add(btnBaja);
		
		btnBaja.setText("BAJA");
		btnBaja.setIcon(new ImageIcon(PantallaPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/data_delete.png")));
		btnBaja.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBaja.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar = new JButton();
		panel_2.add(btnBuscar);
		
		btnBuscar.setText("BUSCAR");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data_search.png"));
		btnBuscar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificacion= new JButton();
		panel_2.add(btnModificacion);
		
		btnModificacion.setText("MODIFICACION");
		btnModificacion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificacion.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\data-modify2.png"));
		btnModificacion.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblPersonas.setText("PEROSNAS");
		lblPersonas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblPersonas.setBounds(319, 160, 174, 14);
		contentPane.add(lblPersonas);
		
		panel_3 = new JPanel();
		panel_3.setBounds(5, 399, 724, 169);
		contentPane.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		btnCobranza = new JButton();
		btnCobranza.setIcon(new ImageIcon(PantallaPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/sale.png")));
		btnCobranza.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCobranza.setText("COBRANZA");
		btnCobranza.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(btnCobranza);
		
		lblCuotas = new JLabel("CUOTAS");
		lblCuotas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		lblCuotas.setBounds(319, 374, 174, 14);
		contentPane.add(lblCuotas);
		
		//atentos a las acciones del usuario
		btnModificacion.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnBaja.addActionListener(this);
		btnAlta.addActionListener(this);
		btnCobranza.addActionListener(this);
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
			miCoordinador.MostrarVentanaBajaSNS();
		}
		
		if(e.getSource() == btnCobranza){
			miCoordinador.mostrarVentanaCobranza();
		}
		
	}
}
