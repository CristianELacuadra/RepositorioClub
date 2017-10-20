package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;


import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCobranzaCuota.class.getResource("/ar/com/ProyectoClub/AVista/icon/dollar_money_17872.png")));
		setTitle("Sistema Club Avenida Ejercito - Control de Cuotas");
		initComponents();	
	}

	
	private void initComponents() {
		IdCuotas=new ArrayList<Integer>();
		resaltado=new RowsRenderer(5);
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
		panel_1 = new JPanel();
		lblNewLabel_1= new JLabel("FACTURACION DE CUOTAS");
		lblCuotasImpagas= new JLabel("CUOTAS");
		scrollPane= new JScrollPane();
		jtDatosCuota = new JTable();
		
		jtDatosCuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//tomamos fila,columna donde se hizo click


		        int column = jtDatosCuota.getColumnModel().getColumnIndexAtX(e.getX());
		        int row = e.getY()/jtDatosCuota.getRowHeight();
		        
				if(column==4){
					Object value = jtDatosCuota.getValueAt(row, column);
					if(value.equals(true)){
						Object valuefecha = jtDatosCuota.getValueAt(row, 2);
						if(valuefecha.equals("No Presenta Pagos")){
							IdCuotas.add((Integer) jtDatosCuota.getValueAt(row, 5));
							btnCobrar.setEnabled(true);
						}
						else{
							for(Integer i : IdCuotas){
								if(i==(Integer) jtDatosCuota.getValueAt(row, 5))
								IdCuotas.remove(i);
							}
							btnCobrar.setEnabled(false);
						}
					}
					else
						btnCobrar.setEnabled(false);
				}
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
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnCobrar){
				miCoordinador.CobrarCuota(Integer.parseInt(txtdni.getText()),IdCuotas);
				JOptionPane.showMessageDialog(null,"Se registro el pago con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"No se puedo llevar a cabo la transaccion debido al siguiente error: "+ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
