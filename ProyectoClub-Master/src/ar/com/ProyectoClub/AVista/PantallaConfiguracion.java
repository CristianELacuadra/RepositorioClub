package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;

public class PantallaConfiguracion extends JDialog implements  ActionListener {

	private final JPanel contentPanel = new JPanel();
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JButton btnCancel;
	public JButton btnBackup;
	public JButton btnRestaurar;
	public JButton btnIr;
	
	public PantallaConfiguracion(Principal vtnprincipal,boolean activo) {
		super(vtnprincipal,activo);
		initComponents();
	}
	

	private void initComponents() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaConfiguracion.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setTitle("Sistema Club Avenida Ejercito - Configuraciones");
		setBounds(100, 100, 450, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 59, 424, 329);
		contentPanel.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Administracion DB", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(70, 43, 256, 29);
		label_4.setText("Administracion de BD");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel_3.add(label_4);
		
		btnRestaurar = new JButton();
		btnRestaurar.setBounds(48, 176, 105, 23);
		btnRestaurar.setText("Restaurar");
		panel_3.add(btnRestaurar);
		
		btnBackup = new JButton();
		btnBackup.setText("BackUp");
		btnBackup.setBounds(230, 176, 116, 23);
		panel_3.add(btnBackup);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("");
		tabbedPane.addTab("Configuracion Categoria", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblAdministracionCategorias = new JLabel();
		lblAdministracionCategorias.setBounds(10, 59, 399, 45);
		lblAdministracionCategorias.setText("Administracion Categorias");
		lblAdministracionCategorias.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_4.add(lblAdministracionCategorias);
		
		btnIr = new JButton();
		btnIr.setText("Ir");
		btnIr.setBounds(329, 75, 51, 23);
		panel_4.add(btnIr);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(PantallaConfiguracion.class.getResource("/ar/com/ProyectoClub/AVista/icon/configuration_250.png")));
		lblNewLabel.setBounds(323, 11, 106, 70);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Configuraciones");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 183, 37);
		contentPanel.add(lblNewLabel_1);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(337, 393, 87, 23);
		contentPanel.add(btnCancel);
		btnCancel.addActionListener(this);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		btnBackup.addActionListener(this);
		btnRestaurar.addActionListener(this);
		btnIr.addActionListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnCancel){
				miCoordinador.CerraConfiguracion();
			}
			
			if(e.getSource()==btnBackup){
				RespaldarBD copiasegura=new RespaldarBD(this, true);
		        copiasegura.setVisible(true);
			}
			
			if(e.getSource()==btnRestaurar){
				RestaurarBD restore= new RestaurarBD(this, true);
		        restore.setVisible(true);
			}
			if(e.getSource()==btnIr){
				miCoordinador.MostarVentanaConfCategoria(PantallaConfiguracionCategoria.tablaCategoria);
			}
		}		
		catch (Exception ex) {
			java.util.logging.Logger.getLogger(PantallaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
}
