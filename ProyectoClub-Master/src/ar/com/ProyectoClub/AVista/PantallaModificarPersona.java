package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

public class PantallaModificarPersona extends JDialog {

	private final JPanel panelLab = new JPanel();
	private JPanel panelTxt = new JPanel();
	private final JButton button = new JButton("Aceptar");
	private final JButton button_1 = new JButton("Cancelar");
	private final JLabel labNombre = new JLabel("Nombre");
	private final JLabel labApellido = new JLabel("Apellido");
	private final JLabel labDni = new JLabel("Dni");
	private final JLabel labTel = new JLabel("Telefono");
	private final JLabel labDom = new JLabel("Domicilio");
	private final JLabel labFechaN = new JLabel("Fecha de Nacimiento");
	private final JLabel labNacion = new JLabel("Nacionalidad");
	private final JLabel labEstadoC = new JLabel("Estado Civil");
	private final JLabel labMatricula = new JLabel("Matricula");
	private final JTextField txtNombre = new JTextField();
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JTextField textField_7 = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PantallaModificarPersona dialog = new PantallaModificarPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PantallaModificarPersona() {
		setTitle("Modificar");
		txtNombre.setColumns(10);
		setResizable(false);
		setBounds(100, 100, 630, 500);
		getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		panelLab.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelLab);
		panelLab.setLayout(new GridLayout(9, 1, 25, 10));
		labNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		labNombre.setAlignmentX(0.5f);
		
		panelLab.add(labNombre);
		labApellido.setHorizontalAlignment(SwingConstants.CENTER);
		labApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		labApellido.setAlignmentX(0.5f);
		
		panelLab.add(labApellido);
		labDni.setHorizontalAlignment(SwingConstants.CENTER);
		labDni.setFont(new Font("Tahoma", Font.BOLD, 13));
		labDni.setAlignmentX(0.5f);
		
		panelLab.add(labDni);
		labTel.setHorizontalAlignment(SwingConstants.CENTER);
		labTel.setFont(new Font("Tahoma", Font.BOLD, 13));
		labTel.setAlignmentX(0.5f);
		
		panelLab.add(labTel);
		labDom.setHorizontalAlignment(SwingConstants.CENTER);
		labDom.setFont(new Font("Tahoma", Font.BOLD, 13));
		labDom.setAlignmentX(0.5f);
		
		panelLab.add(labDom);
		labFechaN.setHorizontalAlignment(SwingConstants.CENTER);
		labFechaN.setFont(new Font("Tahoma", Font.BOLD, 13));
		labFechaN.setAlignmentX(0.5f);
		
		panelLab.add(labFechaN);
		labNacion.setHorizontalAlignment(SwingConstants.CENTER);
		labNacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		labNacion.setAlignmentX(0.5f);
		
		panelLab.add(labNacion);
		labEstadoC.setHorizontalAlignment(SwingConstants.CENTER);
		labEstadoC.setFont(new Font("Tahoma", Font.BOLD, 13));
		labEstadoC.setAlignmentX(0.5f);
		
		panelLab.add(labEstadoC);
		labMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		labMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		labMatricula.setAlignmentX(0.5f);
		
		panelLab.add(labMatricula);
		getContentPane().add(panelTxt);
		panelTxt.setLayout(new GridLayout(9, 1, 30, 20));
		
		panelTxt.add(txtNombre);
		textField.setColumns(10);
		
		panelTxt.add(textField);
		textField_1.setColumns(10);
		
		panelTxt.add(textField_1);
		textField_2.setColumns(10);
		
		panelTxt.add(textField_2);
		textField_3.setColumns(10);
		
		panelTxt.add(textField_3);
		textField_4.setColumns(10);
		
		panelTxt.add(textField_4);
		textField_5.setColumns(10);
		
		panelTxt.add(textField_5);
		textField_6.setColumns(10);
		
		panelTxt.add(textField_6);
		textField_7.setColumns(10);
		
		panelTxt.add(textField_7);
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane);
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
						.addGap(35)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(button_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
						.addGap(22))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(111)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGap(67)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(178, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

}
