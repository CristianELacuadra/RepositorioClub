package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;

import javax.swing.JDialog;

public class PantallaNuevoAlquiler extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaNuevoAlquiler dialog = new PantallaNuevoAlquiler();
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
	public PantallaNuevoAlquiler() {
		setBounds(100, 100, 450, 300);

	}

}
