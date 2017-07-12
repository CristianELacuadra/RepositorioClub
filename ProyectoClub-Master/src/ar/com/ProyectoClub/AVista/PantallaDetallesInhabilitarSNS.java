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
import java.awt.Color;
import java.awt.Font;

public class PantallaDetallesInhabilitarSNS extends JDialog implements ActionListener{
    
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private final JPanel contentPanel = new JPanel();
    public JTextPane textDetalle; 
    
	public PantallaDetallesInhabilitarSNS(PantallaBusquedaSNS vtnbusqueda,boolean b) {
		super(vtnbusqueda,b);
		setTitle("Club Avenida Ejercito - Detalles");
		initComponents();	
	}
	
	
	private void initComponents() {
		textDetalle= new JTextPane();
		textDetalle.setFont(new Font("Arial", Font.PLAIN, 15));
		textDetalle.setBackground(new Color(255, 248, 220));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\logo.png"));
		setBounds(100, 100, 435, 369);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			textDetalle.setEditable(false);
			textDetalle.setBounds(0, 0, 424, 330);
			contentPanel.add(textDetalle);
		}
	}
	
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		
	}

}
