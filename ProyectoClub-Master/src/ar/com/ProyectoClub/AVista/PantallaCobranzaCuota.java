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
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	public PantallaCobranzaCuota(PantallaPrincipalPersonas vtnPantallaSocios,boolean b) {
		super(vtnPantallaSocios,b);
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
		lblCuotasImpagas= new JLabel("CUOTAS");
		scrollPane= new JScrollPane();
		jtDatosCuota = new JTable();
		
		jtDatosCuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionesTabla(e);
			}
		});
		
		setBounds(100, 100, 1073, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(10, 55, 1037, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblDni.setBounds(10, 81, 83, 14);
		panel.add(lblDni);
		
		txtdni.setEditable(false);
		txtdni.setColumns(10);
		txtdni.setBackground(Color.RED);
		txtdni.setBounds(89, 78, 123, 20);
		panel.add(txtdni);
		
		panel_2.setBounds(0, 0, 1037, 21);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblDatosDelSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelSocio.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblDatosDelSocio, BorderLayout.CENTER);
		
		lblNombre.setBounds(10, 119, 104, 14);
		panel.add(lblNombre);
		
		txtNyA.setEditable(false);
		txtNyA.setColumns(10);
		txtNyA.setBackground(Color.RED);
		txtNyA.setBounds(116, 116, 162, 20);
		panel.add(txtNyA);
		
		txtCat.setEditable(false);
		txtCat.setColumns(10);
		txtCat.setBackground(Color.RED);
		txtCat.setBounds(456, 36, 200, 20);
		panel.add(txtCat);
		
		lblCategoria.setBounds(393, 39, 74, 14);
		panel.add(lblCategoria);
		
		lblDireccion.setBounds(10, 156, 55, 14);
		panel.add(lblDireccion);
		
		txtDomi.setEditable(false);
		txtDomi.setColumns(10);
		txtDomi.setBackground(Color.RED);
		txtDomi.setBounds(64, 153, 380, 20);
		panel.add(txtDomi);
		
		lblMatricula.setBounds(30, 39, 55, 14);
		panel.add(lblMatricula);
		
		txtMatri.setEditable(false);
		txtMatri.setColumns(10);
		txtMatri.setBackground(Color.RED);
		txtMatri.setBounds(89, 36, 135, 20);
		panel.add(txtMatri);
		
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBackground(Color.RED);
		txtTel.setBounds(456, 78, 162, 20);
		panel.add(txtTel);
		
		lblTelefono.setBounds(393, 78, 74, 14);
		panel.add(lblTelefono);
		
		panel_1.setBounds(0, 11, 1047, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 247, 1037, 398);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblCuotasImpagas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuotasImpagas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCuotasImpagas.setBounds(73, 11, 849, 21);
		panel_3.add(lblCuotasImpagas);
		
		scrollPane.setBounds(10, 43, 1017, 275);
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
		txttotal.setBounds(734, 329, 233, 20);
		panel_3.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Total importe a pagar :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(574, 329, 159, 17);
		panel_3.add(lblNewLabel_2);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		label.setBounds(987, 332, 19, 17);
		panel_3.add(label);
		
		btnCobrar = new JButton("Cobrar Cuota");
		btnCobrar.setEnabled(false);
		//btnCobrar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Ingreso-Plata.png"));
		btnCobrar.setBounds(20, 329, 168, 31);
		panel_3.add(btnCobrar);
		btnCobrar.addActionListener(this);
	}
	
	private void AccionesTabla(MouseEvent e) {
		Float total,importe;
		int columna = jtDatosCuota.getColumnModel().getColumnIndexAtX(e.getX());
		int fila = e.getY() / jtDatosCuota.getRowHeight();
		if (fila < jtDatosCuota.getRowCount() && fila >= 0 && columna < jtDatosCuota.getColumnCount() && columna >= 0) {
			Object value = jtDatosCuota.getValueAt(fila, columna);
			if(value instanceof java.lang.Boolean){
				//tomo el ultimo total registrado
				total =Float.parseFloat(txttotal.getText());
				if(((java.lang.Boolean) value).booleanValue())//jtDatosCuota.getValueAt(i, 1).equals(true))
				{
					//tomo el ultimo total registrado
					//importe a sumar
					importe= (float) jtDatosCuota.getValueAt(fila, 5);
					total=total+importe;
				}
				else
				{
					//importe a sumar
					importe= (Float) jtDatosCuota.getValueAt(fila, 5);
					//Total
					total-=importe;
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