package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.DebugGraphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaNuevoSocio extends JDialog {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtDomicilio;
	private JTextField txtFechaN;
	private JTextField txtNacion;
	private JTextField txtEstadoC;
	private JTextField txtMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaNuevoSocio dialog = new PantallaNuevoSocio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PantallaNuevoSocio() {
		setTitle("Nueva Persona");
		setResizable(false);
		setBounds(300, 100, 600, 409);
		getContentPane().setLayout(null);
		
		JPanel panelLabel = new JPanel();
		panelLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelLabel.setBounds(0, 0, 200, 370);
		getContentPane().add(panelLabel);
		panelLabel.setLayout(null);
		
		JLabel labNombre = new JLabel("Nombre");
		labNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		labNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		labNombre.setBounds(10, 10, 180, 20);
		panelLabel.add(labNombre);
		
		JLabel labApellido = new JLabel("Apellido");
		labApellido.setAlignmentX(Component.CENTER_ALIGNMENT);
		labApellido.setHorizontalAlignment(SwingConstants.CENTER);
		labApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		labApellido.setBounds(10, 40, 180, 20);
		panelLabel.add(labApellido);
		
		JLabel labDni = new JLabel("Dni");
		labDni.setAlignmentX(Component.CENTER_ALIGNMENT);
		labDni.setHorizontalAlignment(SwingConstants.CENTER);
		labDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		labDni.setBounds(10, 70, 180, 20);
		panelLabel.add(labDni);
		
		JLabel labTelefono = new JLabel("Telefono");
		labTelefono.setAlignmentX(Component.CENTER_ALIGNMENT);
		labTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		labTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
		labTelefono.setBounds(10, 100, 180, 20);
		panelLabel.add(labTelefono);
		
		JLabel labDomicilio = new JLabel("Domicilio");
		labDomicilio.setAlignmentX(Component.CENTER_ALIGNMENT);
		labDomicilio.setHorizontalAlignment(SwingConstants.CENTER);
		labDomicilio.setFont(new Font("Tahoma", Font.BOLD, 13));
		labDomicilio.setBounds(10, 130, 180, 20);
		panelLabel.add(labDomicilio);
		
		JLabel labFechaN = new JLabel("Fecha de Nacimiento");
		labFechaN.setAlignmentX(Component.CENTER_ALIGNMENT);
		labFechaN.setHorizontalAlignment(SwingConstants.CENTER);
		labFechaN.setFont(new Font("Tahoma", Font.BOLD, 13));
		labFechaN.setBounds(10, 160, 180, 20);
		panelLabel.add(labFechaN);
		
		JLabel labTipo = new JLabel("Tipo");
		labTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labTipo.setHorizontalAlignment(SwingConstants.CENTER);
		labTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labTipo.setBounds(10, 190, 180, 20);
		panelLabel.add(labTipo);
		
		JLabel labSexo = new JLabel("Sexo");
		labSexo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labSexo.setHorizontalAlignment(SwingConstants.CENTER);
		labSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		labSexo.setBounds(10, 250, 180, 20);
		panelLabel.add(labSexo);
		
		JLabel labNacion = new JLabel("Nacionalidad");
		labNacion.setAlignmentX(Component.CENTER_ALIGNMENT);
		labNacion.setHorizontalAlignment(SwingConstants.CENTER);
		labNacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		labNacion.setBounds(10, 280, 180, 20);
		panelLabel.add(labNacion);
		
		JLabel labEstadoC = new JLabel("Estado Civil");
		labEstadoC.setAlignmentX(Component.CENTER_ALIGNMENT);
		labEstadoC.setHorizontalAlignment(SwingConstants.CENTER);
		labEstadoC.setFont(new Font("Tahoma", Font.BOLD, 13));
		labEstadoC.setBounds(10, 310, 180, 20);
		panelLabel.add(labEstadoC);
		
		JLabel labCategoriaS = new JLabel("Categoria de Socio");
		labCategoriaS.setAlignmentX(Component.CENTER_ALIGNMENT);
		labCategoriaS.setHorizontalAlignment(SwingConstants.CENTER);
		labCategoriaS.setFont(new Font("Tahoma", Font.BOLD, 13));
		labCategoriaS.setBounds(10, 220, 180, 20);
		panelLabel.add(labCategoriaS);
		
		JLabel labMatricula = new JLabel("Matricula");
		labMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
		labMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		labMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		labMatricula.setBounds(10, 340, 180, 20);
		panelLabel.add(labMatricula);
		
		JPanel panelTxt = new JPanel();
		panelTxt.setBounds(200, 0, 217, 371);
		getContentPane().add(panelTxt);
		panelTxt.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 10, 200, 20);
		panelTxt.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(10, 40, 200, 20);
		panelTxt.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setBounds(10, 70, 200, 20);
		panelTxt.add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(10, 100, 200, 20);
		panelTxt.add(txtTelefono);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(10, 130, 200, 20);
		panelTxt.add(txtDomicilio);
		
		txtFechaN = new JTextField();
		txtFechaN.setBounds(10, 160, 200, 20);
		panelTxt.add(txtFechaN);
		
		txtNacion = new JTextField();
		txtNacion.setBounds(10, 280, 200, 20);
		panelTxt.add(txtNacion);
		
		txtEstadoC = new JTextField();
		txtEstadoC.setBounds(10, 310, 200, 20);
		panelTxt.add(txtEstadoC);
	
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 340, 200, 20);
		panelTxt.add(txtMatricula);	
		
		JComboBox comTipo = new JComboBox();
		comTipo.setModel(new DefaultComboBoxModel(new String[] {"Socio", "No Socio"}));
		comTipo.setBounds(10, 190, 200, 20);
		panelTxt.add(comTipo);
		
		JComboBox comCategoriaS = new JComboBox();
		comCategoriaS.setBounds(10, 221, 200, 20);
		//comcomCategoriaS.setmModel();
		//aca va la funcion de para obtener las categorias de socios de la base de datos
		panelTxt.add(comCategoriaS);
		
		JComboBox comSex = new JComboBox();
		comSex.setModel(new DefaultComboBoxModel(new String[] {"Hombre", "Mujer"}));
		comSex.setBounds(10, 252, 200, 20);
		panelTxt.add(comSex);
		
		JButton bAceptar = new JButton("Aceptar");
		bAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//funcion aceptar 
			}
		});
		bAceptar.setBounds(427, 85, 147, 73);
		getContentPane().add(bAceptar);
		
		JButton bCancelar = new JButton("Cancelar");
		bCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		bCancelar.setBounds(427, 169, 147, 73);
		getContentPane().add(bCancelar);
		
		 comTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if("No Socio"==(String)comTipo.getSelectedItem())
				{
					comCategoriaS.setEnabled(false);
					comSex.setEnabled(false);
					txtNacion.setEnabled(false);
					txtEstadoC.setEnabled(false);
					txtMatricula.setEnabled(false);
					labSexo.setEnabled(false);
					 labNacion.setEnabled(false);
					 labEstadoC.setEnabled(false);
					 labCategoriaS.setEnabled(false);
					 labMatricula.setEnabled(false);
					
				}
				else{
					comCategoriaS.setEnabled(true);
					comSex.setEnabled(true);
					txtNacion.setEnabled(true);
					txtEstadoC.setEnabled(true);
					txtMatricula.setEnabled(true);
					labSexo.setEnabled(true);
					 labNacion.setEnabled(true);
					 labEstadoC.setEnabled(true);
					 labCategoriaS.setEnabled(true);
					 labMatricula.setEnabled(true);
					;}
			}
		});
		
		
	}
}
