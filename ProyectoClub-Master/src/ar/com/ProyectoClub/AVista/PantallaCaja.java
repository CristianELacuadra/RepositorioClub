package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

public class PantallaCaja extends JFrame {

	private JPanel contentPane;
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	
	public PantallaCaja(){
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}
