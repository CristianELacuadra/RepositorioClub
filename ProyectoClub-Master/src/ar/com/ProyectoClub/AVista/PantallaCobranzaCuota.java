package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;


import javax.swing.*;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Canvas;

public class PantallaCobranzaCuota extends JDialog implements ActionListener {

	private ControllerCoordinador miCoordinador;
	private JPanel contentPane;
	public static JTextField txtNsocio;
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
	public JButton btnBuscar;
	public JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblCuotasImpagas; 
	private JScrollPane scrollPane; 
	public JTable jtDatosCuota;
	
	public PantallaCobranzaCuota(PantallaSocios vtnPantallaSocios,boolean b) {
		super(vtnPantallaSocios,b);
		setTitle("Sistema Control Socios-Club Avenida Ejercito");
		initComponents();	
	}

	
	private void initComponents() {
		txtNsocio = new JTextField();
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		JLabel lblNewLabel = new JLabel("N\u00BA Socio");
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
		btnBuscar = new JButton();
		panel_1 = new JPanel();
		lblNewLabel_1= new JLabel("FACTURACION DE CUOTAS");
		lblCuotasImpagas= new JLabel("CUOTAS");
		scrollPane= new JScrollPane();
		jtDatosCuota = new JTable();
		setBounds(100, 100, 1073, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(10, 55, 1037, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel.setBounds(10, 39, 55, 14);
		panel.add(lblNewLabel);
		
		txtNsocio.setBackground(Color.RED);
		txtNsocio.setEditable(false);
		txtNsocio.setBounds(61, 36, 55, 20);
		panel.add(txtNsocio);
		txtNsocio.setColumns(10);
		
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
		
		lblMatricula.setBounds(157, 39, 55, 14);
		panel.add(lblMatricula);
		
		txtMatri.setEditable(false);
		txtMatri.setColumns(10);
		txtMatri.setBackground(Color.RED);
		txtMatri.setBounds(222, 36, 106, 20);
		panel.add(txtMatri);
		
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBackground(Color.RED);
		txtTel.setBounds(456, 78, 162, 20);
		panel.add(txtTel);
		
		lblTelefono.setBounds(393, 78, 74, 14);
		panel.add(lblTelefono);
		
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Search.png"));
		btnBuscar.setBounds(970, 137, 57, 33);
		panel.add(btnBuscar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(660, 97, 284, 73);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblDesde = new JLabel("DESDE");
		lblDesde.setBounds(10, 45, 32, 14);
		panel_4.add(lblDesde);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(63, 42, 69, 20);
		panel_4.add(comboBox);
		
		JLabel lblHasta = new JLabel("HASTA");
		lblHasta.setBounds(159, 45, 33, 14);
		panel_4.add(lblHasta);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(206, 42, 68, 20);
		panel_4.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("Filltro Cuotas");
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(116, 0, 78, 14);
		panel_4.add(lblNewLabel_3);
		
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
		lblCuotasImpagas.setBounds(0, 11, 849, 21);
		panel_3.add(lblCuotasImpagas);
		
		scrollPane.setBounds(10, 43, 1017, 124);
		panel_3.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("DESCRIPCION:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 205, 101, 14);
		panel_3.add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(255, 248, 220));
		textPane.setBounds(110, 205, 264, 154);
		panel_3.add(textPane);
		
		//Panel cuotas
		jtDatosCuota.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "ID","MES EMISION", "AÑO EMISION", "FECHA PAGO", "IMPORTE"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false,false, false, false,false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		jtDatosCuota.getTableHeader().setReorderingAllowed(false);
		jtDatosCuota.getColumnModel().getColumn(0).setMaxWidth(60);
		scrollPane.setViewportView(jtDatosCuota);
        if (jtDatosCuota.getColumnModel().getColumnCount() > 0) {
        	jtDatosCuota.getColumnModel().getColumn(0).setResizable(false);
        	jtDatosCuota.getColumnModel().getColumn(1).setResizable(false);
        	jtDatosCuota.getColumnModel().getColumn(2).setResizable(false);
        	jtDatosCuota.getColumnModel().getColumn(3).setResizable(false);
        	jtDatosCuota.getColumnModel().getColumn(4).setResizable(false);
        }
        btnBuscar.addActionListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  if(e.getSource() == btnBuscar){
			  miCoordinador.mostrarVentanaBusquedaSNS();
		  }
		
	}
}
