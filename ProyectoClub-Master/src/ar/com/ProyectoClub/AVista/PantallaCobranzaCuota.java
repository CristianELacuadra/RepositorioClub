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
import java.util.Iterator;
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
	public static List<Cuota> listaCuota;
	public JButton btnHistorial;
	
	
	public PantallaCobranzaCuota() {
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		JLabel lblDni = new JLabel("N\u00BA DOCUMENTO");
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtdni = new JTextField();
		txtNyA = new JTextField();
		txtCat = new JTextField();
		lblDatosDelSocio= new JLabel("DATOS DEL SOCIO");
		lblDatosDelSocio.setBounds(1, 1, 804, 21);
		lblNombre= new JLabel("APELLIDO Y NOMBRE");
		lblCategoria = new JLabel("CATEGORIA");
		lblDireccion= new JLabel("DOMICILIO");
		txtDomi = new JTextField();
		txtMatri = new JTextField();
		lblMatricula= new JLabel("MATRICULA");
		txtTel = new JTextField();
		lblTelefono= new JLabel("N\u00BA TELEFONO");
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1= new JLabel("FACTURACION DE CUOTAS");
		lblNewLabel_1.setBounds(0, 10, 815, 23);
		lblCuotasImpagas= new JLabel("CUOTAS IMPAGAS");
		scrollPane= new JScrollPane();
		jtDatosCuota = new JTable();
		listaCuota=new ArrayList<Cuota>();
		
		jtDatosCuota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionesTabla(e);
			}
		});
		
		setBounds(100, 100, 841, 691);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(10, 55, 805, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblDni.setBounds(44, 70, 102, 14);
		panel.add(lblDni);
		
		txtdni.setEditable(false);
		txtdni.setColumns(10);
		txtdni.setBackground(new Color(250, 250, 210));
		txtdni.setBounds(183, 67, 123, 20);
		panel.add(txtdni);
		
		panel_2.setBounds(0, 0, 805, 21);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblDatosDelSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelSocio.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblDatosDelSocio);
		
		lblNombre.setBounds(42, 103, 123, 14);
		panel.add(lblNombre);
		
		txtNyA.setEditable(false);
		txtNyA.setColumns(10);
		txtNyA.setBackground(new Color(250, 250, 210));
		txtNyA.setBounds(183, 100, 162, 20);
		panel.add(txtNyA);
		
		txtCat.setEditable(false);
		txtCat.setColumns(10);
		txtCat.setBackground(new Color(250, 250, 210));
		txtCat.setBounds(183, 165, 200, 20);
		panel.add(txtCat);
		
		lblCategoria.setBounds(44, 168, 74, 14);
		panel.add(lblCategoria);
		
		lblDireccion.setBounds(44, 134, 74, 14);
		panel.add(lblDireccion);
		
		txtDomi.setEditable(false);
		txtDomi.setColumns(10);
		txtDomi.setBackground(new Color(250, 250, 210));
		txtDomi.setBounds(183, 134, 380, 20);
		panel.add(txtDomi);
		
		lblMatricula.setBounds(44, 39, 74, 14);
		panel.add(lblMatricula);
		
		txtMatri.setEditable(false);
		txtMatri.setColumns(10);
		txtMatri.setBackground(new Color(250, 250, 210));
		txtMatri.setBounds(183, 36, 135, 20);
		panel.add(txtMatri);
		
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBackground(new Color(250, 250, 210));
		txtTel.setBounds(183, 196, 162, 20);
		panel.add(txtTel);
		
		lblTelefono.setBounds(44, 199, 87, 14);
		panel.add(lblTelefono);
		
		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBackground(new Color(250, 250, 210));
		txtEstado.setBounds(183, 230, 179, 20);
		panel.add(txtEstado);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(44, 233, 55, 14);
		panel.add(lblEstado);
		
		panel_1.setBounds(0, 11, 815, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
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
		txttotal.setBackground(new Color(250, 250, 210));
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
		
		btnHistorial = new JButton("");
		btnHistorial.setIcon(new ImageIcon(PantallaCobranzaCuota.class.getResource("/ar/com/ProyectoClub/AVista/icon/historialCuota.png")));
		btnHistorial.setVerticalAlignment(SwingConstants.TOP);
		btnHistorial.setToolTipText("Ver Historial Cuotas");
		btnHistorial.setBounds(749, 21, 40, 31);
		panel_3.add(btnHistorial);
		btnCobrar.addActionListener(this);
		btnHistorial.addActionListener(this);
	}
	
	private void AccionesTabla(MouseEvent e) {
		if(!txtEstado.getText().isEmpty() && !txtEstado.getText().equals("MOROSO")){
			Float total,importe;
			int columna = jtDatosCuota.getColumnModel().getColumnIndexAtX(e.getX());
			int fila = e.getY() / jtDatosCuota.getRowHeight();
			try{
				if (fila < jtDatosCuota.getRowCount() && fila >= 0 && columna < jtDatosCuota.getColumnCount() && columna >= 0) {
					Object value = jtDatosCuota.getValueAt(fila, columna);
					if(value instanceof java.lang.Boolean){
						//tomo el ultimo total registrado
						total =Float.parseFloat(txttotal.getText());
						if(fila != 0){
							if(((java.lang.Boolean) value).booleanValue())//jtDatosCuota.getValueAt(i, 1).equals(true))
							{
								//importe a sumar
								importe= (float) jtDatosCuota.getValueAt(fila, 4);
								total=total+importe;							
								//	JOptionPane.showMessageDialog(null,"Debe saldar la deuda anterior","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
							}						
							else
							{
								//importe a Restar
								importe= (float) jtDatosCuota.getValueAt(fila, 4);
								//Total
								total=total-importe;
							}
							txttotal.setText(String.valueOf(total));
						}

						//Recorro las filas, si al menos uno esta marcado se habilita el boton
						for (int i = 0; i < jtDatosCuota.getRowCount(); i++) {
							if(jtDatosCuota.getValueAt(i, columna).equals(true)){
								btnCobrar.setEnabled(true);
								break;
							}
							else
								btnCobrar.setEnabled(false);
						}
						//if(val)
						//	btnCobrar.setEnabled(false);
					}

				}
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"ERROR: "+ex.toString(),"Atencion", JOptionPane.ERROR_MESSAGE);
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
				DefaultTableModel modelo=(DefaultTableModel) jtDatosCuota.getModel();
				int filas=jtDatosCuota.getRowCount();
				for (int i = 0;i<filas; i++) {
					Object value = jtDatosCuota.getValueAt(i,1);
					if(value instanceof java.lang.Boolean){
						if(!((java.lang.Boolean) value).booleanValue())//jtDatosCuota.getValueAt(i, 1).equals(true))
						{
							//Remove de la lista
							int idTabla= (int) jtDatosCuota.getValueAt(i,0);
							Iterator<Cuota> it = listaCuota.iterator();
							while (it.hasNext()) {
								Integer id = it.next().getIdCuota();
								if(idTabla == id)
									it.remove();
							}
						}
					}
					
				}
				if(!listaCuota.isEmpty())
					RegistrarPagoCuotas(listaCuota);
				JOptionPane.showMessageDialog(null,"Se registro el pago con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				//miCoordinador.CargarDatosCobranza(Integer.parseInt(txtdni.getText()), jtDatosCuota);
			}
			if(e.getSource()==btnHistorial){
				miCoordinador.MostrarPantallaHistorialCuota(Integer.parseInt(txtdni.getText()), PantallaHistCuota.tablaCuotas);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"No se puedo llevar a cabo la transaccion debido al siguiente error: "+ex.getMessage(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}


	private void RegistrarPagoCuotas(List<Cuota> cuotas) {
		try{
			if (JOptionPane.showConfirmDialog(this, "¿Desea confirmar el pago?", "Control cuotas socio", JOptionPane.YES_NO_OPTION, 0,
					new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) {
				miCoordinador.RegistrarPagoCuotaSocio(cuotas);
				miCoordinador.ActulizarListaMoroso();
				miCoordinador.CargarGrilla(PantallaPrincipalPersonas.tablaPersona);
				this.dispose();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"No se pudo llevar a cabo la transaccion, ERROR:"+ex.getCause(),"ERROR", JOptionPane.ERROR_MESSAGE);
		}
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

	
}