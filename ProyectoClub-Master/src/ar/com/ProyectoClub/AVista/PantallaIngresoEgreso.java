package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;

public class PantallaIngresoEgreso extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private static boolean EsIngreso;
	public JTextField TxtMonto;
	public JTextField txtTipo;
	public JDateChooser dateRegistracion;
	public JButton btnOK;
    public JButton btnCancel;
    public JTextPane txtDescrip;
    public JTextField txtMontoDec;
    public String MontoTotal;
    
    public static boolean isEsIngreso() {
		return EsIngreso;
	}
    
    public static void setEsIngreso(boolean esIngreso) {
		EsIngreso = esIngreso;
	}
	
	public PantallaIngresoEgreso(PantallaCaja miVentanaCaja,boolean activo){
		super(miVentanaCaja,activo); 
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\images (1)-iloveimg-resized.jpg"));
		setTitle("Sistema Club Avenida Ejercio-Ingreso\\Egreso de efectivo ");
		setType(Type.POPUP);
		setBounds(100, 100, 506, 445);
		initComponents(); 
	}
	
	private void initComponents(){	
		MontoTotal=new String();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtDescrip = new JTextPane();
			txtDescrip.setFont(new Font("Arial", Font.PLAIN, 14));
			txtDescrip.setBounds(10, 174, 251, 189);
			contentPanel.add(txtDescrip);
		}
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDescripcion.setBounds(10, 149, 89, 14);
		contentPanel.add(lblDescripcion);
		
		dateRegistracion = new JDateChooser();
		dateRegistracion.setBounds(10, 48, 129, 20);
		contentPanel.add(dateRegistracion);
		
		JLabel lblFecha = new JLabel("Fecha de registracion");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFecha.setBounds(10, 23, 147, 14);
		contentPanel.add(lblFecha);
		
		TxtMonto = new JTextField();
		TxtMonto.setFont(new Font("Arial", Font.PLAIN, 13));
		TxtMonto.setColumns(10);
		TxtMonto.setBounds(302, 173, 89, 20);
		contentPanel.add(TxtMonto);
		
		TxtMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numero=e.getKeyChar(); 
				if(Character.isLetter(numero)) { 
					getToolkit().beep(); 
					e.consume(); 
					JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMonto.setBounds(337, 149, 89, 14);
		contentPanel.add(lblMonto);
		
		JLabel label_1 = new JLabel("$");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(459, 176, 21, 14);
		contentPanel.add(label_1);
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Arial", Font.ITALIC, 14));
		txtTipo.setBackground(Color.RED);
		txtTipo.setEnabled(false);
		txtTipo.setEditable(false);
		txtTipo.setColumns(10);
		txtTipo.setBounds(222, 48, 159, 20);
		contentPanel.add(txtTipo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTipo.setBounds(283, 23, 44, 14);
		contentPanel.add(lblTipo);
		
		JLabel label = new JLabel("Tipo");
		label.setIcon(new ImageIcon(PantallaIngresoEgreso.class.getResource("/ar/com/ProyectoClub/AVista/icon/dollar_money_17872.png")));
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(419, 8, 61, 44);
		contentPanel.add(label);
		
		txtMontoDec = new JTextField();
		txtMontoDec.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMontoDec.setColumns(10);
		txtMontoDec.setBounds(401, 174, 45, 20);
		contentPanel.add(txtMontoDec);
		
		JLabel lblDsad = new JLabel(",");
		lblDsad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDsad.setBounds(391, 177, 13, 14);
		contentPanel.add(lblDsad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setBackground(new Color(95, 158, 160));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOK = new JButton("Aceptar");
				btnOK.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\apply-iloveimg-resized.png"));
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				btnCancel = new JButton("Cancelar");
				btnCancel.setIcon(new ImageIcon(PantallaIngresoEgreso.class.getResource("/ar/com/ProyectoClub/AVista/icon/Delete.png")));
				buttonPane.add(btnCancel);
			}
		}
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	private boolean ValidarDatosEntradas(){
		//para registrar necesita que los datos esten llenos
		if(dateRegistracion != null && !TxtMonto.getText().isEmpty() && !TxtMonto.getText().isEmpty()){
			if(!txtMontoDec.getText().isEmpty())
				MontoTotal=TxtMonto.getText()+"."+txtMontoDec.getText();
			else
				MontoTotal=TxtMonto.getText();
			return true;
		}
		else 
			return false;

	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	private void Limpiar(){
		txtDescrip.setText(null);
		TxtMonto.setText(null);
		txtMontoDec.setText(null);
		dateRegistracion.setDate(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()== btnOK){
				if(this.ValidarDatosEntradas()){
					Caja caja=miCoordinador.CrearRegistroCaja();
					caja.setDescripcion(txtDescrip.getText());
					caja.setFecha(dateRegistracion.getDate());
					caja.setHabilitar(true);
					caja.setMonto(Float.valueOf(MontoTotal));
					JOptionPane.showMessageDialog(null,"Los datos una ves ingresados no pueden ser modificados,solo pueden ser dado de baja","Advertencia",JOptionPane.WARNING_MESSAGE);
					int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el registro?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) { 
						miCoordinador.GuardarIngresoEgreso(caja);
						this.Limpiar();
					} 
					
				}
				else
					JOptionPane.showMessageDialog(null,"Los campos son obligatorio ","Informacion",JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource()==btnCancel){
				miCoordinador.CerrarVentanaIngEgre();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"No se pudo llevar acabo debido a la siguiente Excepcion: "+ex.toString(),"Club Avenida Ejercito ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
