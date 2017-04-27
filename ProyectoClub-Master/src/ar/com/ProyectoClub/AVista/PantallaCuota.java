package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class PantallaCuota extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCuota frame = new PantallaCuota();
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
	public PantallaCuota() {
		setBounds(100, 100, 450, 300);

	}

}
