package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.Toolkit;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Caja;
import ar.com.ProyectoClub.CModelo.CEntidades.Conceptos;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PantallaIngresoEgreso extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private static boolean EsIngreso;
	public JTextField TxtMonto;
	public JDateChooser dateRegistracion;
	public JButton btnOK;
    public JButton btnCancel;
    public JTextPane txtDescrip;
    public JTextField txtMontoDec;
    public String MontoTotal;
    public JComboBox comboTipo;
    public int UltimoIdConceptos;
    public Map<Integer, String> mapConceptos= new HashMap<Integer, String>();
	
	public PantallaIngresoEgreso(PantallaCaja miVentanaCaja,boolean activo){
		super(miVentanaCaja,activo); 
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaIngresoEgreso.class.getResource("/ar/com/ProyectoClub/AVista/icon/Caja.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\images (1)-iloveimg-resized.jpg"));
		setTitle("Sistema Club Avenida Ejercio-Ingreso\\Egreso de efectivo ");
		setType(Type.POPUP);
		setBounds(100, 100, 534, 445);
		initComponents(); 
	}
	
	private void initComponents(){	
		MontoTotal=new String();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtDescrip = new JTextPane();
			txtDescrip.setBackground(new Color(211, 211, 211));
			txtDescrip.setFont(new Font("Arial", Font.PLAIN, 14));
			txtDescrip.setBounds(10, 109, 251, 177);
			contentPanel.add(txtDescrip);
		}
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDescripcion.setBounds(10, 84, 89, 14);
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
		TxtMonto.setBounds(302, 109, 89, 20);
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
		lblMonto.setBounds(302, 84, 89, 14);
		contentPanel.add(lblMonto);
		
		JLabel label_1 = new JLabel("$");
		label_1.setFont(new Font("Arial", Font.PLAIN, 15));
		label_1.setBounds(457, 115, 21, 14);
		contentPanel.add(label_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTipo.setBounds(309, 23, 44, 14);
		contentPanel.add(lblTipo);
		
		txtMontoDec = new JTextField();
		txtMontoDec.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMontoDec.setColumns(10);
		txtMontoDec.setBounds(402, 109, 45, 20);
		contentPanel.add(txtMontoDec);
		
		JLabel lblDsad = new JLabel(",");
		lblDsad.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDsad.setBounds(392, 112, 13, 14);
		contentPanel.add(lblDsad);
		
		comboTipo = new JComboBox();
		comboTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ( e.getStateChange() == ItemEvent.DESELECTED )
				{
					for ( Map.Entry<Integer, String> entry : mapConceptos.entrySet() ){ //recorre las categorias
						String string=comboTipo.getSelectedItem().toString(); //obtengo el string cargado en el item
						String[] parte=string.split("-"); //separo en identificador y nombre
						if(parte[0].equals(entry.getValue())){ //Compara nombres
							 UltimoIdConceptos=entry.getKey();
						}

					}
				} 

			}
		});
		comboTipo.setBounds(213, 48, 265, 20);
		comboTipo.setBackground(new Color(240, 255, 240));
//		comboTipo.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				
//			}
//		});
		
		contentPanel.add(comboTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setBackground(new Color(95, 158, 160));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOK = new JButton("Aceptar");
				btnOK.setBounds(615, 11, 97, 91);
				btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/guardar.png")));
				btnOK.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnOK.setText("Guardar");
				btnOK.setHorizontalTextPosition(SwingConstants.CENTER);
				btnOK.setFont(new java.awt.Font("Tahoma", 1, 12));
				btnOK.setContentAreaFilled(false);
				btnOK.setBorderPainted(false);
				btnOK.setBorder(null);
				//btnOK.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\apply-iloveimg-resized.png"));
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				btnCancel = new JButton("Cancelar");
				btnCancel.setBounds(455, 10, 80, 92);
				btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/botoncancel.png")));
				btnCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnCancel.setText("Cancelar");
				btnCancel.setHorizontalTextPosition(SwingConstants.CENTER);
				btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCancel.setContentAreaFilled(false);
				btnCancel.setBorderPainted(false);
				btnCancel.setBorder(null);
				//btnCancel.setIcon(new ImageIcon(PantallaIngresoEgreso.class.getResource("/ar/com/ProyectoClub/AVista/icon/Delete.png")));
				buttonPane.add(btnCancel);
			}
		}
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	private boolean ValidarDatosEntradas(){
		//para registrar necesita que los datos esten llenos
		if(dateRegistracion != null && !TxtMonto.getText().isEmpty() && !TxtMonto.getText().isEmpty() && !comboTipo.getSelectedItem().equals("Seleccione el tipo de ingreso")){
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
		comboTipo.setSelectedItem("Seleccione el tipo de ingreso");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()== btnOK){
				if(this.ValidarDatosEntradas()){
					Caja caja=miCoordinador.CrearRegistroCaja(); //creo mi objeto caja
					Conceptos concepto=miCoordinador.CrearConcepto(); //creo mi objeto concepto
					concepto=miCoordinador.BuscarConcepto(UltimoIdConceptos); // Busco el concepto deacuedo al id seleccionado
					caja.setDescripcion(txtDescrip.getText());
					caja.setFecha(dateRegistracion.getDate());
					caja.setHabilitar(true);
					caja.setMonto(Float.valueOf(MontoTotal));
					caja.setConceptos(concepto);
					int opcion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el registro?", "Aviso", JOptionPane.YES_NO_OPTION);
					if (opcion == 0) {
						miCoordinador.GuardarRegistroCaja(caja);
						JOptionPane.showMessageDialog(null,"Se agrego el registro correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
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
