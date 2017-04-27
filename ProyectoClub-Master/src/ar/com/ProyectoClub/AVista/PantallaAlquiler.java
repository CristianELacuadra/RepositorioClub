package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class PantallaAlquiler extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAlquiler frame = new PantallaAlquiler();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaAlquiler() {
		setBounds(100, 100, 450, 300);

	}

}
