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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.toedter.calendar.JDateChooser;

public class PantallaConfiguracion extends JDialog implements  ActionListener {

	private final JPanel contentPanel = new JPanel();
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JButton btnCancel;
	public JButton btnBackup;
	public JButton btnRestaurar;
	public JButton btnIr;
	public JTextField txtEntero;
	public JTextField txtDecimal;
    private JButton btnGuardar;
	
	public PantallaConfiguracion(Principal vtnprincipal,boolean activo) {
		super(vtnprincipal,activo);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaConfiguracion.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoConfig.png")));
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
		
		btnGuardar=new JButton();
		btnGuardar.setText("Guardar");
		
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Precio Cuota", null, panel, null);
		
		txtEntero = new JTextField();
		txtEntero.setBounds(182, 33, 61, 20);
		panel.add(txtEntero);
		txtEntero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fijar Precio Cuota:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 33, 141, 17);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(329, 33, 16, 17);
		panel.add(label);
		
		txtDecimal = new JTextField();
		txtDecimal.setColumns(10);
		txtDecimal.setBounds(258, 33, 61, 20);
		panel.add(txtDecimal);
		
		JLabel label_1 = new JLabel(",");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(246, 33, 16, 17);
		panel.add(label_1);
		
		btnGuardar.setBounds(309, 253, 89, 23);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(this);
		
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
				Limpiar();
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
			
			if(e.getSource()==btnGuardar){
				this.GuardarConfiguracion();
			}
		}		
		catch (Exception ex) {
			java.util.logging.Logger.getLogger(PantallaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}


	private void Limpiar() {
		txtDecimal.setText(null);
		txtEntero.setText(null);
	}


	private void GuardarConfiguracion() {
		if(!txtEntero.getText().isEmpty()){
			String parEntera= txtEntero.getText();
			String parDecimal = !txtDecimal.getText().isEmpty() ?txtDecimal.getText() : "00";
			try {
				FileWriter permiteEscrito= new FileWriter("src/ar/com/ProyectoClub/Configuraciones/Archivo_Precio_Cuota.txt");
				String texto=parEntera.trim()+"."+parDecimal.trim();
				PrintWriter imprime= new PrintWriter(permiteEscrito);
				imprime.print(texto);
				permiteEscrito.close();
				JOptionPane.showMessageDialog(null,"El precio de la cuota se cargo corectamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
			} 
			catch (IOException e) {
				JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			JOptionPane.showMessageDialog(null,"Valor Entero Obligatorio","Advertencia",JOptionPane.ERROR_MESSAGE);
		
	}
}
