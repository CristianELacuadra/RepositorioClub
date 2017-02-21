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

public class PantallaNuevoSocio extends JDialog {

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
		setBounds(300, 100, 600, 500);
		getContentPane().setLayout(null);
		
		JPanel panelLabel = new JPanel();
		panelLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panelLabel.setBounds(0, 0, 200, 462);
		getContentPane().add(panelLabel);
		panelLabel.setLayout(null);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 10, 180, 20);
		panelLabel.add(label);
		
		JLabel label_1 = new JLabel("Apellido");
		label_1.setBounds(10, 40, 180, 20);
		panelLabel.add(label_1);
		
		JLabel label_2 = new JLabel("Dni");
		label_2.setBounds(10, 70, 180, 20);
		panelLabel.add(label_2);
		
		JLabel label_3 = new JLabel("Tel\u00E9fono");
		label_3.setBounds(10, 100, 180, 20);
		panelLabel.add(label_3);
		
		JLabel label_4 = new JLabel("Domicilio");
		label_4.setBounds(10, 130, 180, 20);
		panelLabel.add(label_4);
		
		JLabel label_5 = new JLabel("Fecha de Nacimiento");
		label_5.setBounds(10, 160, 180, 20);
		panelLabel.add(label_5);
		
		JLabel label_6 = new JLabel("Tipo");
		label_6.setBounds(10, 190, 180, 20);
		panelLabel.add(label_6);
		
		JLabel label_8 = new JLabel("Sexo");
		label_8.setBounds(10, 250, 180, 20);
		panelLabel.add(label_8);
		
		JLabel label_9 = new JLabel("Nacionalidad");
		label_9.setBounds(10, 280, 180, 20);
		panelLabel.add(label_9);
		
		JLabel label_10 = new JLabel("Estado Civil");
		label_10.setBounds(10, 310, 180, 20);
		panelLabel.add(label_10);
		
		JLabel label_11 = new JLabel("Categoria de Socio");
		label_11.setBounds(10, 220, 180, 20);
		panelLabel.add(label_11);
		
		JLabel label_7 = new JLabel("Matricula");
		label_7.setBounds(10, 340, 180, 20);
		panelLabel.add(label_7);
		
		JPanel panelTxt = new JPanel();
		panelTxt.setBounds(200, 0, 220, 462);
		getContentPane().add(panelTxt);

	}
}
