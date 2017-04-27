package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class PantallaNuevoInmueble extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaNuevoInmueble dialog = new PantallaNuevoInmueble();
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
	public PantallaNuevoInmueble() {
		setBounds(100, 100, 450, 300);

	}

}
