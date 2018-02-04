package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;


import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Cuota;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Toolkit;

public class PantallaCobranzaCuota extends JDialog implements ActionListener {

	private ControllerCoordinador miCoordinador;
	private JPanel contentPane;
	public static JTextField txtdni;
	public static JTextField txtNyA;
	public static JTextField txtCat;
	public static  JTextField txtDomi;
	public static JTextField txtMatri;
	public static JTextField txtTel;
	public JLabel lblDatosDelSocio;
	public JLabel lblNombre;
	private JLabel lblCategoria;
	private JLabel lblDireccion;
	private JLabel lblMatricula;
	private JLabel lblTelefono;
	public JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblCuotasImpagas; 
	private JScrollPane scrollPane; 
	public static JTable jtDatosCuota;
	public JTextField txttotal;
	public RowsRenderer resaltado;
	private List<Integer> IdCuotas;
	public JButton btnCobrar;
	public JTextField txtEstado;
	
	public PantallaCobranzaCuota(PantallaPrincipalPersonas vtnPantallaSocios,boolean b) {
		super(vtnPantallaSocios,b);
		//setBackground(SystemColor.window);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Limpiar();
				// miCoordinador.mostrarVentanaPrincipal();
			}
		});
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCobranzaCuota.class.getResource("/ar/com/ProyectoClub/AVista/icon/transaccion.png")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCobranzaCuota.class.getResource("/ar/com/ProyectoClub/AVista/icon/dollar_money_17872.png")));
		setTitle("Sistema Club Avenida Ejercito - Control de Cuotas");
		initComponents();	
	}

	
	private void initComponents() {
		IdCuotas=new ArrayList<Integer>();
		resaltado=new RowsRenderer(5);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		JLabel lblDni = new JLabel("N\u00BADocumento");
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtdni = new JTextField();
		txtNyA = new JTextField();
		txtCat = new JTextField();
		lblDatosDelSocio= new JLabel("DATOS DEL SOCIO");
		lblDatosDelSocio.setBounds(1, 1, 804, 21);
		lblNombre= new JLabel("Nombre y Apellido");
		lblCategoria = new JLabel("Categoria");
		lblDireccion= new JLabel("Domicilio");
		txtDomi = new JTextField();
		txtMatri = new JTextField();
		lblMatricula= new JLabel("Matricula");
		txtTel = new JTextField();
		lblTelefono= new JLabel("N\u00BA Telefono");
		panel_1 = new JPanel();
		lblNewLabel_1= new JLabel("FACTURACION DE CUOTAS");
		lblNewLabel_1.setBounds(0, 10, 815, 23);
		lblCuotasImpagas= new JLabel("CUOTAS IMPAGAS");
		scrollPane= new JScrollPane();
		jtDatosCuota = new JTable();
		
		jtDatosCuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionesTabla(e);
			}
		});
		
		setBounds(100, 100, 841, 691);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(10, 55, 805, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblDni.setBounds(44, 70, 83, 14);
		panel.add(lblDni);
		
		txtdni.setEditable(false);
		txtdni.setColumns(10);
		txtdni.setBackground(SystemColor.activeCaption);
		txtdni.setBounds(156, 67, 123, 20);
		panel.add(txtdni);
		
		panel_2.setBounds(0, 0, 805, 21);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblDatosDelSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelSocio.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblDatosDelSocio);
		
		lblNombre.setBounds(42, 103, 104, 14);
		panel.add(lblNombre);
		
		txtNyA.setEditable(false);
		txtNyA.setColumns(10);
		txtNyA.setBackground(SystemColor.activeCaption);
		txtNyA.setBounds(156, 100, 162, 20);
		panel.add(txtNyA);
		
		txtCat.setEditable(false);
		txtCat.setColumns(10);
		txtCat.setBackground(SystemColor.activeCaption);
		txtCat.setBounds(156, 165, 200, 20);
		panel.add(txtCat);
		
		lblCategoria.setBounds(44, 168, 55, 14);
		panel.add(lblCategoria);
		
		lblDireccion.setBounds(44, 134, 55, 14);
		panel.add(lblDireccion);
		
		txtDomi.setEditable(false);
		txtDomi.setColumns(10);
		txtDomi.setBackground(SystemColor.activeCaption);
		txtDomi.setBounds(156, 131, 380, 20);
		panel.add(txtDomi);
		
		lblMatricula.setBounds(44, 39, 55, 14);
		panel.add(lblMatricula);
		
		txtMatri.setEditable(false);
		txtMatri.setColumns(10);
		txtMatri.setBackground(SystemColor.activeCaption);
		txtMatri.setBounds(156, 36, 135, 20);
		panel.add(txtMatri);
		
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBackground(SystemColor.activeCaption);
		txtTel.setBounds(156, 196, 162, 20);
		panel.add(txtTel);
		
		lblTelefono.setBounds(44, 199, 74, 14);
		panel.add(lblTelefono);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBackground(SystemColor.activeCaption);
		txtEstado.setBounds(156, 227, 179, 20);
		panel.add(txtEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(44, 233, 55, 14);
		panel.add(lblEstado);
		
		panel_1.setBounds(0, 11, 815, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 326, 805, 319);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblCuotasImpagas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuotasImpagas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuotasImpagas.setBounds(10, 21, 729, 21);
		panel_3.add(lblCuotasImpagas);
		
		scrollPane.setBounds(10, 53, 882, 183);
		panel_3.add(scrollPane);
		
		//Panel cuotas
		jtDatosCuota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtDatosCuota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null},
                {null, null, null, null,null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
		
		jtDatosCuota.getTableHeader().setReorderingAllowed(false);
		jtDatosCuota.getColumnModel().getColumn(0).setMaxWidth(60);
		scrollPane.setViewportView(jtDatosCuota);
		
		txttotal = new JTextField();
		txttotal.setFont(new Font("Arial", Font.PLAIN, 16));
		txttotal.setBackground(SystemColor.activeCaption);
		txttotal.setEditable(false);
		txttotal.setBounds(531, 255, 233, 20);
		panel_3.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total importe a pagar :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(362, 258, 159, 17);
		panel_3.add(lblNewLabel_2);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(774, 258, 19, 17);
		panel_3.add(label);
		
		btnCobrar = new JButton("Cobrar Cuota");
		btnCobrar.setIcon(new ImageIcon(PantallaCobranzaCuota.class.getResource("/ar/com/ProyectoClub/AVista/icon/pagarCuota.png")));
		btnCobrar.setEnabled(false);
		//btnCobrar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Ingreso-Plata.png"));
		btnCobrar.setBounds(10, 247, 159, 31);
		panel_3.add(btnCobrar);
		
		JButton btnHistorial = new JButton("");
		btnHistorial.setIcon(new ImageIcon(PantallaCobranzaCuota.class.getResource("/ar/com/ProyectoClub/AVista/icon/historialCuota.png")));
		btnHistorial.setVerticalAlignment(SwingConstants.TOP);
		btnHistorial.setToolTipText("Ver Historial Cuotas");
		btnHistorial.setBounds(749, 21, 40, 31);
		panel_3.add(btnHistorial);
		btnCobrar.addActionListener(this);
	}
	
	private void AccionesTabla(MouseEvent e) {
		Float total,importe;
		int columna = jtDatosCuota.getColumnModel().getColumnIndexAtX(e.getX());
		int fila = e.getY() / jtDatosCuota.getRowHeight();
		try{
			if (fila < jtDatosCuota.getRowCount() && fila >= 0 && columna < jtDatosCuota.getColumnCount() && columna >= 0) {
				Object value = jtDatosCuota.getValueAt(fila, columna);
				if(value instanceof java.lang.Boolean){
					//tomo el ultimo total registrado
					total =Float.parseFloat(txttotal.getText());
					if(((java.lang.Boolean) value).booleanValue())//jtDatosCuota.getValueAt(i, 1).equals(true))
					{
						//tomo el ultimo total registrado
						//importe a sumar
						importe= (float) jtDatosCuota.getValueAt(fila, 4);
						total=total+importe;
					}
					else
					{
						//importe a sumar
						importe= (Float) jtDatosCuota.getValueAt(fila, 4);
						//Total
						total=total-importe;
					}
					txttotal.setText(String.valueOf(total));

					//Recorro las filas, si al menos uno esta marcado se habilita el boton
					for (int i = 0; i < jtDatosCuota.getRowCount(); i++) {
						if(jtDatosCuota.getValueAt(i, columna).equals(true)){
							btnCobrar.setEnabled(true);
							break;
						}
						else
							btnCobrar.setEnabled(false);
					}
				}

			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"ERROR: "+ex.toString(),"Atencion", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnCobrar){
				//miCoordinador.CobrarCuota(Integer.parseInt(txtdni.getText()),IdCuotas);
				List<Cuota> listaCuota=tomarDatosCuota();
				RegistrarPagoCuotas(listaCuota);
				JOptionPane.showMessageDialog(null,"Se registro el pago con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
				miCoordinador.CargarDatosCobranza(Integer.parseInt(txtdni.getText()), jtDatosCuota);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"No se puedo llevar a cabo la transaccion debido al siguiente error: "+ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void RegistrarPagoCuotas(List<Cuota> cuotas) {
		miCoordinador.RegistrarPagoCuotaSocio(cuotas);			
	}
	
	private void Limpiar(){
		txtCat.setText(null);
		txtdni.setText(null);
		txtDomi.setText(null);
		txtEstado.setText(null);
		txtMatri.setText(null);
		txtNyA.setText(null);
		txtTel.setText(null);
		txttotal.setText(null);
		btnCobrar.setEnabled(false);
		txttotal.setText(null);
		//limpio la tabla
		DefaultTableModel tb = (DefaultTableModel) jtDatosCuota.getModel();
		int a = jtDatosCuota.getRowCount()-1;
		for (int i = a; i >= 0; i--) {           
			tb.removeRow(tb.getRowCount()-1);
		} 
	}

	private List<Cuota> tomarDatosCuota() {
			List<Integer> IdsCuotas=new ArrayList<>();
			List<Cuota> cuotas= new ArrayList<>();
			for (int i = 0; i < jtDatosCuota.getRowCount(); i++) {
				if(jtDatosCuota.getValueAt(i, 1).equals(true))
					//Obtengo los id de cuota y lo agrego a mi lista
					IdsCuotas.add((Integer)jtDatosCuota.getValueAt(i,0));
			}
			//Traigo las cuotas del socio marcadas  
			for(Cuota cuota : miCoordinador.BuscarCuotas(IdsCuotas)){
				cuota.setFechapago(new Date());
				cuota.setDescripcion("Pago cuota Socio: "+cuota.getSocios().getDni());
				cuota.setEstado("Pago");
				cuotas.add(cuota);
			}
			if(!cuotas.isEmpty())
				return cuotas;
			return null;
	}
}