
package ar.com.ProyectoClub.AVista;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

/**
 *
 * @author Lacuadra
 */
public class PantallaNuevoSocios extends javax.swing.JFrame {

	public javax.swing.JButton btnEditar;
	public javax.swing.JButton btnEliminar;
	public javax.swing.JButton btnGEdit;
	public javax.swing.JButton btnListar;
	public javax.swing.JButton btnRegistrar;
	public javax.swing.JButton btnSalir;
	private javax.swing.JLabel jlabelDNI;
	private javax.swing.JLabel jlabelApell;
	private javax.swing.JLabel jlabelNom;
	private javax.swing.JLabel jlabelNac;
	private javax.swing.JLabel jlabelDomi;
	private javax.swing.JScrollPane jScrollSocios;
	public javax.swing.JTextField jTextField1;
	public com.toedter.calendar.JDateChooser jdFechaNac;
	public javax.swing.JTable jtableDatos;
	public javax.swing.JTextField txtApellidos;
	public javax.swing.JTextField txtBusqueda;
	public javax.swing.JTextField txtDni;
	public javax.swing.JTextField txtLugar;
	public javax.swing.JTextField txtNombres;
	private JPanel panel;
	private JPanel panel_1;
	public JTextField textTelefono;
	public JTextField textMatri;
	public JTextField textSexo;
	public JTextField textNaci;
	public JTextField textEstadoC;
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_1;
	public JComboBox combocategoria;
	public JLabel lblNroSocio;


	public PantallaNuevoSocios() {
		setAutoRequestFocus(false);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaNuevoSocios.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		initComponents();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

	private void initComponents() {
		btnEditar = new javax.swing.JButton();
		btnEliminar = new javax.swing.JButton();
		btnGEdit = new javax.swing.JButton();
		btnListar = new javax.swing.JButton();
		btnRegistrar = new javax.swing.JButton();
		jlabelDNI = new javax.swing.JLabel();
		jlabelApell = new javax.swing.JLabel();
		jlabelNom = new javax.swing.JLabel();
		jlabelNac = new javax.swing.JLabel();
		jlabelDomi = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jdFechaNac = new com.toedter.calendar.JDateChooser();
		textTelefono = new JTextField();
		textMatri = new JTextField();
		textSexo = new JTextField();
		textNaci = new JTextField();
		textEstadoC = new JTextField();
		lblNroSocio=new JLabel();
		combocategoria=new JComboBox();
		btnSalir= new JButton();

		jTextField1.setText("jTextField1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		if (jtableDatos.getColumnModel().getColumnCount() > 0) {
			jtableDatos.getColumnModel().getColumn(0).setResizable(false);
			jtableDatos.getColumnModel().getColumn(1).setResizable(false);
			jtableDatos.getColumnModel().getColumn(2).setResizable(false);
			jtableDatos.getColumnModel().getColumn(3).setResizable(false);
			jtableDatos.getColumnModel().getColumn(4).setResizable(false);
			jtableDatos.getColumnModel().getColumn(5).setResizable(false);
			jtableDatos.getColumnModel().getColumn(6).setResizable(false);
			jtableDatos.getColumnModel().getColumn(7).setResizable(false);
			jtableDatos.getColumnModel().getColumn(8).setResizable(false);
			jtableDatos.getColumnModel().getColumn(9).setResizable(false);
			jtableDatos.getColumnModel().getColumn(10).setResizable(false);
			jtableDatos.getColumnModel().getColumn(11).setResizable(false);
		}

		panel = new JPanel();

		panel_1 = new JPanel();

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 825, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
						.addContainerGap())
				);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);

		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		jScrollSocios = new javax.swing.JScrollPane();
		scrollPane.setViewportView(jScrollSocios);
		jtableDatos = new javax.swing.JTable();


		jtableDatos.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null, null,null,null,null,null,null,null},
					{null, null, null, null, null,null,null,null,null,null,null},
					{null, null, null, null, null,null,null,null,null,null,null}
				},
				new String [] {
						"DNI", "APELLIDO", "NOMBRES", "FECHA N.", "DOMICILIO","TELEFONO","MATRICULA","SEXO","NACIONALIDAD","ESTADO C.","FECHA INGRE","CATEGORIA"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false,false,false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});

		jtableDatos.getTableHeader().setReorderingAllowed(false);
		
		jScrollSocios.setViewportView(jtableDatos);
		panel.setLayout(null);

		jlabelDNI.setBounds(70, 30, 18, 14);
		panel.add(jlabelDNI);

		jlabelDNI.setText("DNI");
		txtDni = new javax.swing.JTextField();
		txtDni.setBounds(106, 27, 127, 20);
		panel.add(txtDni);

		btnRegistrar.setBounds(657, 5, 142, 23);
		panel.add(btnRegistrar);

		btnRegistrar.setText("REGISTRAR");

		jlabelApell.setBounds(40, 61, 48, 14);
		panel.add(jlabelApell);

		jlabelApell.setText("APELLIDO");
		txtApellidos = new javax.swing.JTextField();
		txtApellidos.setBounds(106, 58, 127, 20);
		panel.add(txtApellidos);

		btnEditar.setBounds(639, 57, 88, 23);
		panel.add(btnEditar);

		btnEditar.setText("EDITAR");

		btnGEdit.setBounds(737, 57, 62, 23);
		panel.add(btnGEdit);

		btnGEdit.setText("OK");
		btnGEdit.setEnabled(false);

		jlabelNom.setBounds(40, 92, 48, 14);
		panel.add(jlabelNom);

		jlabelNom.setText("NOMBRES");
		txtNombres = new javax.swing.JTextField();
		txtNombres.setBounds(106, 89, 127, 20);
		panel.add(txtNombres);

		jlabelNac.setBounds(40, 126, 47, 14);
		panel.add(jlabelNac);

		jlabelNac.setText("FECHA N.");

		jdFechaNac.setBounds(106, 120, 95, 20);
		panel.add(jdFechaNac);

		btnEliminar.setBounds(639, 106, 81, 23);
		panel.add(btnEliminar);

		btnEliminar.setText("ELIMINAR");

		btnListar.setBounds(732, 106, 67, 23);
		panel.add(btnListar);

		btnListar.setText("LISTAR");
		txtBusqueda = new javax.swing.JTextField();
		txtBusqueda.setBounds(639, 180, 120, 20);
		panel.add(txtBusqueda);

		txtBusqueda.setForeground(new java.awt.Color(0, 0, 204));

		jlabelDomi.setBounds(34, 154, 62, 14);
		panel.add(jlabelDomi);

		jlabelDomi.setText("DOMICILIO");
		txtLugar = new javax.swing.JTextField();
		txtLugar.setBounds(106, 151, 209, 20);
		panel.add(txtLugar);

		btnSalir.setText("VOLVER");
		btnSalir.setBounds(718, 379, 81, 23);
		panel.add(btnSalir);

		JLabel lblTelefono = new JLabel();
		lblTelefono.setText("TELEFONO");
		lblTelefono.setBounds(40, 183, 62, 14);
		panel.add(lblTelefono);

		JLabel lblNSocio = new JLabel();
		lblNSocio.setName("");
		lblNSocio.setText("N SOCIO");
		lblNSocio.setBounds(40, 5, 62, 14);
		panel.add(lblNSocio);
		
		textTelefono.setBounds(106, 180, 127, 20);

		panel.add(textTelefono);

		JLabel lblMatricula = new JLabel();
		lblMatricula.setText("MATRICULA");
		lblMatricula.setBounds(26, 214, 62, 14);
		panel.add(lblMatricula);

		textMatri.setBounds(106, 211, 127, 20);
		panel.add(textMatri);

		JLabel lblSexo = new JLabel();
		lblSexo.setText("SEXO");
		lblSexo.setBounds(54, 245, 34, 14);
		panel.add(lblSexo);

		textSexo.setBounds(106, 242, 127, 20);
		panel.add(textSexo);
		
		textNaci.setBounds(106, 273, 127, 20);
		panel.add(textNaci);

		JLabel lblE = new JLabel();
		lblE.setText("NACIONALIDAD");
		lblE.setBounds(10, 276, 78, 14);
		panel.add(lblE);

        textEstadoC.setBounds(106, 304, 127, 20);
		panel.add(textEstadoC);

		JLabel lblEstadoCivil = new JLabel();
		lblEstadoCivil.setText("ESTADO CIVIL");
		lblEstadoCivil.setBounds(20, 307, 78, 14);
		panel.add(lblEstadoCivil);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 335, 95, 20);
		panel.add(dateChooser);

		JLabel lblFechaIngreso = new JLabel();
		lblFechaIngreso.setText("FECHA INGRESO");
		lblFechaIngreso.setBounds(10, 341, 86, 14);
		panel.add(lblFechaIngreso);

		combocategoria.setBounds(106, 380, 209, 20);
		panel.add(combocategoria);

		JLabel lblCategoria = new JLabel();
		lblCategoria.setText("CATEGORIA");
		lblCategoria.setBounds(26, 383, 62, 14);
		panel.add(lblCategoria);

		lblNroSocio.setText(".....");
		lblNroSocio.setEnabled(false);
		lblNroSocio.setBounds(108, 5, 46, 14);
		panel.add(lblNroSocio);
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PantallaNuevoSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PantallaNuevoSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PantallaNuevoSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PantallaNuevoSocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PantallaNuevoSocios().setVisible(true);
			}
		});
	}
}
