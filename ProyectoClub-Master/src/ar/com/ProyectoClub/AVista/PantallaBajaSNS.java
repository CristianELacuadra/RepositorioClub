package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaBajaSNS extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private ControllerCoordinador miCoordinador;
	public static JTextField txtNyA;
	public static JTextField txtDni;
	public static JTextField txtDom;
	public static  JTextField txtTel;
	public JButton btnbaja; 
	public JButton btncancelar; 
	public JRadioButton rdbtnNoSocio; 
	public JRadioButton rdbtnSocio; 
	public JButton btnbuscar;
	
	public PantallaBajaSNS(PantallaSocios vtnPantallasocios,boolean b) {
		super(vtnPantallasocios,b);
		initComponents();	
	}

	private void initComponents() {
		btnbaja= new JButton("BAJA");
		btnbaja.setIcon(new ImageIcon(PantallaBajaSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/down.png")));
		btncancelar= new JButton("Cancel");
		btncancelar.setIcon(new ImageIcon(PantallaBajaSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/Delete.png")));
		rdbtnNoSocio= new JRadioButton("NO SOCIO");
		rdbtnNoSocio.setEnabled(false);
		rdbtnSocio= new JRadioButton("SOCIO");
		rdbtnSocio.setEnabled(false);
		btnbuscar = new JButton("");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaBajaSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setBounds(100, 100, 493, 331);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNyA = new JTextField();
			txtNyA.setBackground(new Color(245, 255, 250));
			txtNyA.setEnabled(false);
			txtNyA.setBounds(168, 62, 299, 20);
			contentPanel.add(txtNyA);
			txtNyA.setColumns(10);
		}
		{
			
			btnbuscar.setIcon(new ImageIcon(PantallaBajaSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
			btnbuscar.setBounds(432, 202, 35, 28);
			contentPanel.add(btnbuscar);
		}
		
		JLabel lblNombreYApellido = new JLabel("DNI");
		lblNombreYApellido.setBounds(10, 13, 35, 14);
		contentPanel.add(lblNombreYApellido);
		
		JLabel label = new JLabel("NOMBRE Y APELLIDO");
		label.setBounds(10, 65, 148, 14);
		contentPanel.add(label);
		
		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.LEFT);
		txtDni.setFont(new Font("Arial Black", Font.PLAIN, 13));
		txtDni.setForeground(Color.BLACK);
		txtDni.setEnabled(false);
		txtDni.setColumns(10);
		txtDni.setBackground(new Color(245, 255, 250));
		txtDni.setBounds(55, 10, 146, 20);
		contentPanel.add(txtDni);
		
		txtDom = new JTextField();
		txtDom.setEnabled(false);
		txtDom.setColumns(10);
		txtDom.setBackground(new Color(245, 255, 250));
		txtDom.setBounds(74, 110, 375, 20);
		contentPanel.add(txtDom);
		
		JLabel lblDomicilio = new JLabel("DOMICILIO");
		lblDomicilio.setBounds(10, 113, 68, 14);
		contentPanel.add(lblDomicilio);
		
		
		rdbtnSocio.setBounds(10, 207, 90, 23);
		contentPanel.add(rdbtnSocio);
		
		
		rdbtnNoSocio.setBounds(132, 207, 90, 23);
		contentPanel.add(rdbtnNoSocio);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setBounds(10, 168, 68, 14);
		contentPanel.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setEnabled(false);
		txtTel.setColumns(10);
		txtTel.setBackground(new Color(245, 255, 250));
		txtTel.setBounds(74, 165, 375, 20);
		contentPanel.add(txtTel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnbaja.setActionCommand("OK");
				buttonPane.add(btnbaja);
				getRootPane().setDefaultButton(btnbaja);
			}
			{
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
		btnbuscar.addActionListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnbuscar){
			miCoordinador.mostrarVentanaBusquedaSNS();
		}
		
	}
}
