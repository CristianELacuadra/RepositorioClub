package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;
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

import java.awt.GridLayout;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Rectangle;

public class PantallaAlquiler extends JDialog implements ActionListener {
	public JPanel contentPane;
	public JPanel panel;
	public JLabel lblImagen; 
	public JPanel panelInmueble;
	public JButton btnAltaAlquiler;
	public JButton btnBajaAlquiler;
	public JButton btnBuscarAlquiler;
	public JButton btnModificacionAlquiler; 
	
	public JButton btnAltaInmueble;
	public JButton btnBuscarInmueble;
	public JButton btnModificarInmueble;
	public JButton btnBajaInmueble;
	public JButton btnRehabilitarInmueble;
	private ControllerCoordinador miCoordinador;
	public JButton btnPagarAlquiler;
	
	/*
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAlquiler dialog = new PantallaAlquiler();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	public PantallaAlquiler(Principal vtnPrincipal,boolean b) {
		super(vtnPrincipal,b);
		setBounds(new Rectangle(100, 100, 770, 600));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setResizable(false);
		setTitle("Alquileres e Inmuebles");
		
		initComponents();	
		
	}
	
	private void initComponents(){
	//	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 764, 128);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		panel.add(lblImagen);
		
		JLabel lblSeleccioneUnaOperacion = new JLabel("SELECCIONE UNA OPERACION:");
		lblSeleccioneUnaOperacion.setForeground(Color.RED);
		lblSeleccioneUnaOperacion.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		panel.add(lblSeleccioneUnaOperacion);
		
		JPanel panelAlquiler = new JPanel();
		panelAlquiler.setBackground(Color.LIGHT_GRAY);
		panelAlquiler.setBorder(UIManager.getBorder("ComboBox.border"));
		panelAlquiler.setBounds(0, 164, 764, 167);
		getContentPane().add(panelAlquiler);
		panelAlquiler.setLayout(null);
		
		btnAltaAlquiler = new JButton("CREAR");
		btnAltaAlquiler.setBounds(1, 1, 178, 77);
		btnAltaAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/edit_add_10261.png")));
		btnAltaAlquiler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAltaAlquiler.setToolTipText("REGISTRA UN NUEVO ALQUILER");
		panelAlquiler.add(btnAltaAlquiler);
		btnAltaAlquiler.addActionListener(this);
		
		btnBuscarAlquiler = new JButton("BUSCAR");
		btnBuscarAlquiler.setBounds(189, 1, 178, 77);
		btnBuscarAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search_find_locate_1542.png")));
		btnBuscarAlquiler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBuscarAlquiler.setToolTipText("Buscar un alquiler");
		panelAlquiler.add(btnBuscarAlquiler);
		btnBuscarAlquiler.addActionListener(this);
		
		btnModificacionAlquiler = new JButton("MODIFICAR");
		btnModificacionAlquiler.setBounds(388, 1, 178, 77);
		btnModificacionAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/Modify.png")));
		btnModificacionAlquiler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnModificacionAlquiler.setToolTipText("Modificar un alquiler");
		panelAlquiler.add(btnModificacionAlquiler);
		btnModificacionAlquiler.addActionListener(this);
		
		btnBajaAlquiler = new JButton("ELIMINAR");
		btnBajaAlquiler.setBounds(576, 1, 178, 77);
		btnBajaAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/remove_10189.png")));
		btnBajaAlquiler.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBajaAlquiler.setToolTipText("CANCELAR UN ALQUILER");
		panelAlquiler.add(btnBajaAlquiler);
		btnBajaAlquiler.addActionListener(this);
		
		btnPagarAlquiler = new JButton("PAGAR ALQUILER");
		btnPagarAlquiler.setBounds(1, 88, 206, 77);
		btnPagarAlquiler.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/sale.png")));
		panelAlquiler.add(btnPagarAlquiler);
		btnPagarAlquiler.addActionListener(this);
		
		panelInmueble = new JPanel();
		panelInmueble.setBackground(Color.LIGHT_GRAY);
		panelInmueble.setBorder(UIManager.getBorder("ComboBox.border"));
		panelInmueble.setBounds(0, 396, 764, 176);
		getContentPane().add(panelInmueble);
		panelInmueble.setLayout(new GridLayout(0, 4, 10, 10));
		
		btnAltaInmueble = new JButton("REGISTRAR");
		btnAltaInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoInmueble_Add.png")));
		btnAltaInmueble.setToolTipText("Registrar un nuevo inmueble");
		btnAltaInmueble.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelInmueble.add(btnAltaInmueble);
		btnAltaInmueble.addActionListener(this);
		
		btnBuscarInmueble = new JButton("BUSCAR");
		btnBuscarInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoInmueble_buscar.png")));
		btnBuscarInmueble.setToolTipText("Buscar los inmuebles que esten registrados");
		panelInmueble.add(btnBuscarInmueble);
		btnBuscarInmueble.addActionListener(this);
		
		btnModificarInmueble = new JButton("MODIFICAR");
		btnModificarInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoinmueble_modificar.png")));
		btnModificarInmueble.setToolTipText("Modificar un inmueble");
		panelInmueble.add(btnModificarInmueble);
		btnModificarInmueble.addActionListener(this);
		
		btnBajaInmueble = new JButton("DESHABILITAR");
		btnBajaInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoInmueble_baja.png")));
		btnBajaInmueble.setToolTipText("Eliminar un inmueble");
		panelInmueble.add(btnBajaInmueble);
		btnBajaInmueble.addActionListener(this);
		
		btnRehabilitarInmueble = new JButton("REHABILITAR");
		btnRehabilitarInmueble.setIcon(new ImageIcon(PantallaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoInmueble_Add.png")));
		btnRehabilitarInmueble.setToolTipText("Reabilitar un inmueble previamente deshhhabilitado");
		panelInmueble.add(btnRehabilitarInmueble);
		btnRehabilitarInmueble.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Sobre Alquileres");
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel.setBounds(254, 131, 159, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobre Inmuebles");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel_1.setBounds(252, 357, 161, 37);
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
		if(e.getSource()==btnBajaAlquiler){
			miCoordinador.mostrarVentanaBusquedaAlquiler();
		}
		
		if(e.getSource()==btnBuscarAlquiler){
			miCoordinador.mostrarVentanaBusquedaAlquiler();
		}
		
		if(e.getSource()==btnModificacionAlquiler){
			miCoordinador.mostrarVentanaBusquedaAlquiler();
		
		}
		if (e.getSource()==btnPagarAlquiler){
			miCoordinador.mostrarVentanaBusquedaAlquiler();
		}
		
		
		if(e.getSource()==btnAltaInmueble){
			miCoordinador.mostrarVentanaNuevoInmueble();
		} 
		if(e.getSource()==btnBuscarInmueble){
			miCoordinador.mostrarVentanaBusquedaInmueble();
		}
		
		if(e.getSource()==btnModificarInmueble){
			miCoordinador.mostrarVentanaBusquedaInmueble();
			//miCoordinador.mostrarVentanaModificarInmueble();
		}
		
		if(e.getSource()==btnBajaInmueble){
			miCoordinador.mostrarVentanaBusquedaInmueble();
			//miCoordinador.mostrarVentanaEliminarInmuelble();
		}
		if(e.getSource()==btnRehabilitarInmueble){
			miCoordinador.mostrarVentanaBusquedaInmueble();
			//miCoordinador.mostrarVentanaRehabilitarInmueble();
		}


	}
}
