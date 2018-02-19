package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.border.BevelBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;


public class PantallaDetallesAlquiler extends JDialog {
	private final JPanel panelDetalle = new JPanel();
	private ControllerCoordinador miCoordinador;
	 public JTextPane texDetalle; 
	 private JPanel buttonPane;
	 public JButton bOk; 
	 private JPanel PanelTitulo;
	 private JLabel labTitulo;
	 
//	public static void main(String[] args) {
//		try {
//			PantallaDetallesAlquiler dialog = new PantallaDetallesAlquiler();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	public PantallaDetallesAlquiler(PantallaAlquilerPrincipal vtnAlPrincipal,boolean b) {
		super(vtnAlPrincipal, b);

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaDetallesAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		setTitle("Club Avenida Ejercito - Detalles");
		
		initComponents();

	}

	private void initComponents(){
		setBounds(100, 100, 400, 460);
		getContentPane().setLayout(new BorderLayout());
		panelDetalle.setBackground(Color.LIGHT_GRAY);
		panelDetalle.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelDetalle, BorderLayout.CENTER);
		panelDetalle.setLayout(new BorderLayout(0, 0));
		{
			PanelTitulo = new JPanel();
			PanelTitulo.setBackground(Color.LIGHT_GRAY);
			FlowLayout flowLayout = (FlowLayout) PanelTitulo.getLayout();
			flowLayout.setVgap(7);
			flowLayout.setHgap(20);
			panelDetalle.add(PanelTitulo, BorderLayout.NORTH);
			{
				labTitulo = new JLabel("DETALLES DEL ALQUILER");
				labTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
				PanelTitulo.add(labTitulo);
			}
		}
		{
			buttonPane = new JPanel();
			buttonPane.setVisible(false);
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				bOk = new JButton("OK");
				bOk.setVisible(false);
				bOk.setActionCommand("OK");
				buttonPane.add(bOk);
				getRootPane().setDefaultButton(bOk);
			}
		}
		{
			texDetalle= new JTextPane();
			texDetalle.setFont(new Font("Calibri Light", Font.ITALIC, 17));
			texDetalle.setBackground(new Color(250, 250, 210));
			panelDetalle.add(texDetalle,BorderLayout.CENTER);
		}
		
		
		

		
	}
	public void setCoordinador(ControllerCoordinador miCoordinador){
		this.miCoordinador= miCoordinador;
	}
	
}
