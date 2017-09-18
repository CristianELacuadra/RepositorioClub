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
	public JButton btnConsultar; 
	public JButton btnGenerar;
	public JButton btnCancel;
	public JDateChooser dateProxGeneracion;
	public JDateChooser dateUltGeneracion;
	public JButton btnBackup;
	public JButton btnRestaurar;
	
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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Configuracion Cuotas", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane_1.addTab("Genereacion Cuotas y Consulta", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 229, 394, 33);
		panel_2.setForeground(new Color(245, 222, 179));
		panel_1.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnConsultar= new JButton("Consultar");
		panel_2.add(btnConsultar);
		
		btnGenerar = new JButton("Generar Cuotas");
		panel_2.add(btnGenerar);
		
		JLabel label = new JLabel("Ultima Generacion");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(33, 45, 159, 31);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("dd/mm/aaaa");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(339, 54, 78, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Proxima Generacion");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(22, 122, 170, 33);
		panel_1.add(label_2);
		
		dateProxGeneracion = new JDateChooser();
		dateProxGeneracion.setEnabled(false);
		dateProxGeneracion.setToolTipText("Muestra fecha proxima generacion- no se puede editar");
		dateProxGeneracion.setBounds(200, 122, 129, 33);
		panel_1.add(dateProxGeneracion);
		
		JLabel label_3 = new JLabel("dd/mm/aaaa");
		label_3.setFont(new Font("Arial", Font.PLAIN, 12));
		label_3.setBounds(339, 132, 78, 14);
		panel_1.add(label_3);
		
		dateUltGeneracion = new JDateChooser();
		dateUltGeneracion.setEnabled(false);
		dateUltGeneracion.setToolTipText("Muestra la ultima fecha de generacion- No se puede eliminar");
		dateUltGeneracion.setBackground(Color.RED);
		dateUltGeneracion.setBounds(200, 45, 129, 31);
		panel_1.add(dateUltGeneracion);
		
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
		btnConsultar.addActionListener(this);
		btnGenerar.addActionListener(this);
		btnBackup.addActionListener(this);
		btnRestaurar.addActionListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnConsultar){
				miCoordinador.ConsultarUltimaGeneracionCuota();;
			}
			if(e.getSource()==btnGenerar){
				if(dateProxGeneracion.getDate()!=null){
					int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea generar las cuotas del mes proximo?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) { //The ISSUE is here
						miCoordinador.LanzarPrcesoUsuGeneracionCuota();
					} 
				}
				else{
					JOptionPane.showMessageDialog(null,"La fecha de proxima generacion se encuentra vacia","Error", JOptionPane.ERROR_MESSAGE);
				}

			}
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
		}		
		catch (Exception ex) {
			java.util.logging.Logger.getLogger(PantallaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
}
