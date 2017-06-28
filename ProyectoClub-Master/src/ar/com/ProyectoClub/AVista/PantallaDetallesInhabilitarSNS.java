package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class PantallaDetallesInhabilitarSNS extends JDialog implements ActionListener{

	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private final JPanel contentPanel = new JPanel();
	public JButton btnEliminar;
    public JButton btnCancelar;
	public PantallaDetallesInhabilitarSNS(PantallaBusquedaSNS vtnbusqueda,boolean b) {
		super(vtnbusqueda,b);
		initComponents();	
	}
	
	
	private void initComponents() {
		btnEliminar= new JButton();
		btnCancelar = new JButton();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\logo.png"));
		setBounds(100, 100, 435, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane textPane = new JTextPane();
			textPane.setEditable(false);
			textPane.setBounds(0, 0, 424, 228);
			contentPanel.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				btnEliminar.setText("Eliminar");
				buttonPane.add(btnEliminar);
			}
			{
				btnCancelar.setText("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
