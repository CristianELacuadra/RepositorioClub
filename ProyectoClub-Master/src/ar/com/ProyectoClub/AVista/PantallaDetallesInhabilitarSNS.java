package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PantallaDetallesInhabilitarSNS extends JDialog implements ActionListener{

	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private final JPanel contentPanel = new JPanel();
    public JTextPane textDetalle; 
    public JTextPane textPanelDetalleSocio;
    
	public PantallaDetallesInhabilitarSNS(PantallaBusquedaSNS vtnbusqueda,boolean b) {
		super(vtnbusqueda,b);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaDetallesInhabilitarSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		setTitle("Club Avenida Ejercito - Detalles");
		initComponents();	
	}
	
	
	private void initComponents() {
		textDetalle= new JTextPane();
		textDetalle.setFont(new Font("Calibri Light", Font.ITALIC, 17));
		textDetalle.setBackground(new Color(0, 153, 255));
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\logo.png"));
		setBounds(100, 100, 549, 428);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			textDetalle.setEditable(false);
			textDetalle.setBounds(0, 30, 254, 359);
			contentPanel.add(textDetalle);
		}
		
		textPanelDetalleSocio= new JTextPane();
		textPanelDetalleSocio.setFont(new Font("Calibri Light", Font.ITALIC, 17));
		textPanelDetalleSocio.setEditable(false);
		textPanelDetalleSocio.setBackground(new Color(0, 153, 255));
		textPanelDetalleSocio.setBounds(264, 30, 254, 359);
		contentPanel.add(textPanelDetalleSocio);
		
		JLabel lblDetallesGenericos = new JLabel("Detalles Genericos");
		lblDetallesGenericos.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDetallesGenericos.setBounds(61, 11, 145, 14);
		contentPanel.add(lblDetallesGenericos);
		
		JLabel lblDetallesSocio = new JLabel("Detalles Socio");
		lblDetallesSocio.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDetallesSocio.setBounds(326, 11, 145, 14);
		contentPanel.add(lblDetallesSocio);
	}
	
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		
	}
}
