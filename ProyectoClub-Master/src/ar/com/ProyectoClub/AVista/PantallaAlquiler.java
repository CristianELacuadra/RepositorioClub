package ar.com.ProyectoClub.AVista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class PantallaAlquiler extends JDialog implements ActionListener {
	public JPanel contentPane;
	public JPanel panel;
	public JLabel lblImagen; 
	public JPanel panelInmueble;
	public JButton btnAltaAlquiler;
	public JButton btnBuscarAlquiler;
	
	public JButton btnAltaInmueble;
	public JButton btnBuscarInmueble;
	private ControllerCoordinador miCoordinador;
	
		
	public PantallaAlquiler(Principal vtnPrincipal,boolean b) {
		super(vtnPrincipal,b);
		setBounds(new Rectangle(50, 50, 490, 553));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setResizable(false);
		setTitle("Alquileres e Inmuebles");
		
		initComponents();	
		
	}
	
	private void initComponents(){
	
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 486, 128);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		lblImagen = new JLabel("");
		//lblImagen.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		panel.add(lblImagen);
		
		JLabel lblSeleccioneUnaOperacion = new JLabel("SELECCIONE UNA OPERACION:");
		lblSeleccioneUnaOperacion.setForeground(Color.RED);
		lblSeleccioneUnaOperacion.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		panel.add(lblSeleccioneUnaOperacion);
		
		JPanel panelAlquiler = new JPanel();
		panelAlquiler.setBackground(Color.LIGHT_GRAY);
		panelAlquiler.setBorder(UIManager.getBorder("ComboBox.border"));
		panelAlquiler.setBounds(0, 164, 486, 98);
		getContentPane().add(panelAlquiler);
		panelAlquiler.setLayout(null);
		
		btnAltaAlquiler = new JButton("CREAR");
		btnAltaAlquiler.setBounds(41, 11, 157, 77);
		//btnAltaAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/edit_add_10261.png")));
		btnAltaAlquiler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAltaAlquiler.setToolTipText("REGISTRA UN NUEVO ALQUILER");
		panelAlquiler.add(btnAltaAlquiler);
		btnAltaAlquiler.addActionListener(this);
		
		btnBuscarAlquiler = new JButton("BUSCAR");
		btnBuscarAlquiler.setBounds(252, 11, 178, 77);
		//btnBuscarAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search_find_locate_1542.png")));
		btnBuscarAlquiler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBuscarAlquiler.setToolTipText("Buscar un alquiler");
		panelAlquiler.add(btnBuscarAlquiler);
		btnBuscarAlquiler.addActionListener(this);
		
		panelInmueble = new JPanel();
		panelInmueble.setBackground(Color.LIGHT_GRAY);
		panelInmueble.setBorder(UIManager.getBorder("ComboBox.border"));
		panelInmueble.setBounds(0, 396, 486, 176);
		getContentPane().add(panelInmueble);
		panelInmueble.setLayout(null);
		
		btnAltaInmueble = new JButton("REGISTRAR");
		btnAltaInmueble.setBounds(34, 11, 173, 88);
		//btnAltaInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoInmueble_Add.png")));
		btnAltaInmueble.setToolTipText("Registrar un nuevo inmueble");
		btnAltaInmueble.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInmueble.add(btnAltaInmueble);
		btnAltaInmueble.addActionListener(this);
		
		btnBuscarInmueble = new JButton("BUSCAR");
		btnBuscarInmueble.setBounds(248, 11, 186, 88);
		//btnBuscarInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoInmueble_buscar.png")));
		btnBuscarInmueble.setToolTipText("Buscar los inmuebles que esten registrados");
		panelInmueble.add(btnBuscarInmueble);
		btnBuscarInmueble.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Sobre Alquileres");
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel.setBounds(177, 128, 159, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobre Inmuebles");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel_1.setBounds(177, 354, 161, 37);
		getContentPane().add(lblNewLabel_1);
		
		

		
		
		
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	
		

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAltaAlquiler){
			miCoordinador.mostrarVentanaNuevoAlquiler();
		}
		
		if(e.getSource()==btnBuscarAlquiler){
			miCoordinador.mostrarVentanaBusquedaAlquiler();
		}
		
		
		if(e.getSource()==btnAltaInmueble){
			miCoordinador.mostrarVentanaNuevoInmueble();
		} 
		if(e.getSource()==btnBuscarInmueble){
			miCoordinador.mostrarVentanaBusquedaInmueble();
		}


	}
}
