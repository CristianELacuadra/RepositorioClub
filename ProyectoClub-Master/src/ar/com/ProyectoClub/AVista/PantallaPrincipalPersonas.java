
package ar.com.ProyectoClub.AVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.hibernate.criterion.Junction;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;

public class PantallaPrincipalPersonas extends JFrame implements ActionListener {

	private ControllerCoordinador miCoordinador; // objeto miCoordinador que
													// permite la relacion entre
													// esta clase y la clase
													// ControllerCoordinador
	private javax.swing.JButton actualizar;
	private app.bolivia.swing.JCTextField buscar;
	private javax.swing.JButton cargar;
	private javax.swing.JButton botonBaja;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton limpiar;
	private JButton botonAlta;
	private javax.swing.JButton registrar;
	public static javax.swing.JTable tablaPersona;
	private javax.swing.JLabel codigoL1;
	public static RowsRenderer resaltado;
	// botones de la tabla;
	public static JButton btnDetalles;
	public static JButton btnBaja;
	public static JButton btnHabiitado;
	public static JButton btnEditar;
	public JPanel panelSNS;
	public ButtonGroup GrupoSNS;
	public static JRadioButton checkTodos;
	public JRadioButton checkSocios;
	public JRadioButton checkNoSocio;

	public PantallaPrincipalPersonas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PantallaPrincipalPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				limpiaCampos();
				// miCoordinador.mostrarVentanaPrincipal();
			}
		});
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tablaPersona = new javax.swing.JTable();
		tablaPersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionesTabla(e);
			}
		});
		jPanel3 = new javax.swing.JPanel();
		registrar = new javax.swing.JButton();
		actualizar = new javax.swing.JButton();
		cargar = new javax.swing.JButton();
		botonBaja = new javax.swing.JButton();
		botonBaja.setEnabled(false);
		limpiar = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		buscar = new app.bolivia.swing.JCTextField();
		buscar.setBounds(20, 40, 180, 32);
		codigoL1 = new javax.swing.JLabel();
		codigoL1.setBounds(10, 30, 250, 52);
		botonAlta = new JButton();
		botonAlta.setEnabled(false);
		resaltado = new RowsRenderer(0);
		btnDetalles = new JButton();
		btnDetalles.setName("btnDetalle");
		btnDetalles.setToolTipText("Observar detalles");
		btnDetalles.setText("");
		btnDetalles.setIcon(new ImageIcon(
				"C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\icon-Detalles.png"));
		btnBaja = new JButton();
		btnBaja.setName("btnBaja");
		btnBaja.setToolTipText("Deshabilitar");
		btnBaja.setText("");
		btnBaja.setIcon(new ImageIcon(
				"C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\icon-Usuario.png"));
		btnBaja.setEnabled(false);
		btnHabiitado = new JButton();
		btnHabiitado.setName("btnHabilitado");
		btnHabiitado.setToolTipText("Habilitar");
		btnHabiitado.setText("");
		btnHabiitado.setIcon(new ImageIcon(
				"C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Ico-UsuHabilitado.png"));
		btnHabiitado.setEnabled(false);
		btnEditar = new JButton();
		btnEditar.setName("btnEditar");
		btnEditar.setToolTipText("Editar datos");
		btnEditar.setText("");
		btnEditar.setIcon(new ImageIcon(
				"C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\usuarioEditar.png"));
		GrupoSNS=new ButtonGroup();
		checkTodos= new JRadioButton();
		checkSocios=new JRadioButton();
		checkNoSocio=new JRadioButton();
		

		// setClosable(true);
		// setIconifiable(true);
		tablaPersona.getTableHeader()
				.setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		tablaPersona.setDefaultRenderer(Object.class,
				new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());

		tablaPersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setTitle("PRINCIPAL SOCIO-NO SOCIO ");

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		tablaPersona.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "DNI", "NOMBRE y APELLIDO", "TELEFONO", "DOMICILIO" }) {
			boolean[] canEdit = new boolean[] { false, false, false, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tablaPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		jScrollPane1.setViewportView(tablaPersona);

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

		registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		registrar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/regis1.png"))); // NOI18N
		registrar.setText("Registrar");
		registrar.setBorder(null);
		registrar.setBorderPainted(false);
		registrar.setContentAreaFilled(false);
		registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		registrar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/regis2.png"))); // NOI18N
		registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		registrar.addActionListener(this);

		actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		actualizar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/actualizar.png"))); // NOI18N
		actualizar.setText("Actualizar");
		actualizar.setBorder(null);
		actualizar.setBorderPainted(false);
		actualizar.setContentAreaFilled(false);
		actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		actualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		actualizar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/actualizar1.png"))); // NOI18N
		actualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		cargar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		cargar.setIcon(new ImageIcon(
				PantallaPrincipalPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/CargarDatos1.png"))); // NOI18N
		cargar.setText("Cargar grilla");
		cargar.setBorder(null);
		cargar.setBorderPainted(false);
		cargar.setContentAreaFilled(false);
		cargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		cargar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/CargarDatos2.png"))); // NOI18N
		cargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		botonBaja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		botonBaja.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/Baja1.png"))); // NOI18N
		botonBaja.setText("Bar de Baja");
		botonBaja.setBorder(null);
		botonBaja.setBorderPainted(false);
		botonBaja.setContentAreaFilled(false);
		botonBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		botonBaja.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/Baja2.png"))); // NOI18N
		botonBaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		limpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		limpiar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png"))); // NOI18N
		limpiar.setText("Limpiar Campos");
		limpiar.setBorder(null);
		limpiar.setBorderPainted(false);
		limpiar.setContentAreaFilled(false);
		limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		limpiar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png"))); // NOI18N
		limpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		botonAlta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		botonAlta.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/Alta1.png"))); // NOI18N
		botonAlta.setText("Dar de alta");
		botonAlta.setBorder(null);
		botonAlta.setBorderPainted(false);
		botonAlta.setContentAreaFilled(false);
		botonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		botonAlta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		botonAlta.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/Alta2.png"))); // NOI18N
		botonAlta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addComponent(registrar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(actualizar).addGap(10)
						.addComponent(cargar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(botonBaja)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(botonAlta, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(limpiar).addGap(797)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										jPanel3Layout.createParallelGroup(Alignment.TRAILING)
												.addComponent(botonBaja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														95, Short.MAX_VALUE)
												.addComponent(cargar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(Alignment.LEADING,
														jPanel3Layout.createParallelGroup(Alignment.LEADING, false)
																.addComponent(registrar, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(actualizar, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(limpiar, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(botonAlta, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		jPanel3Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] { actualizar, botonBaja, limpiar });
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		jPanel4.setLayout(null);

		buscar.setBackground(new java.awt.Color(34, 102, 145));
		buscar.setBorder(null);
		buscar.setForeground(new java.awt.Color(255, 255, 255));
		buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		buscar.setOpaque(false);
		buscar.setPhColor(new java.awt.Color(255, 255, 255));
		buscar.setPlaceholder("BUSCAR");

		jPanel4.add(buscar);

		codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		codigoL1.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/buscarL.png"))); // NOI18N
		jPanel4.add(codigoL1);
		
		panelSNS = new JPanel();
		panelSNS.setBounds(270, 11, 240, 87);
		panelSNS.setBackground(Color.WHITE);
		panelSNS.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Seleccione un metodo de busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		panelSNS.setLayout(null);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelSNS, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1433, Short.MAX_VALUE)
						.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSNS, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
					.addGap(51))
		);
		
		checkTodos.setText("Todos");
		checkTodos.setBackground(Color.WHITE);
		checkTodos.setBounds(19, 22, 109, 23);
		GrupoSNS.add(checkTodos);
		panelSNS.add(checkTodos);
		
		checkSocios.setText("Socios");
		checkSocios.setBackground(Color.WHITE);
		checkSocios.setBounds(19, 53, 109, 23);
		GrupoSNS.add(checkSocios);
		panelSNS.add(checkSocios);
		
		checkNoSocio.setText("Todos");
		checkNoSocio.setBackground(Color.WHITE);
		checkNoSocio.setBounds(19, 90, 109, 23);
		GrupoSNS.add(checkNoSocio);
		panelSNS.add(checkNoSocio);

		JPanel jPanel = new JPanel();
		jPanel.setBounds(270, 11, 240, 87);
		jPanel4.add(jPanel);
		jPanel.setBackground(Color.WHITE);
		jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"FILTRO BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		jPanel.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Numero documento");
		chckbxNewCheckBox
				.setFont(chckbxNewCheckBox.getFont().deriveFont(chckbxNewCheckBox.getFont().getStyle() | Font.BOLD));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(6, 20, 146, 23);
		jPanel.add(chckbxNewCheckBox);

		JCheckBox chckbxApellidoYNombre = new JCheckBox("Apellido y Nombre");
		chckbxApellidoYNombre.setFont(
				chckbxApellidoYNombre.getFont().deriveFont(chckbxApellidoYNombre.getFont().getStyle() | Font.BOLD));
		chckbxApellidoYNombre.setBackground(Color.WHITE);
		chckbxApellidoYNombre.setBounds(6, 46, 127, 23);
		jPanel.add(chckbxApellidoYNombre);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 1362, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.PREFERRED_SIZE, 705, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();

		cargar.addActionListener(this);
		registrar.addActionListener(this);
		limpiar.addActionListener(this);
	}

	public void limpiaCampos() {
		DefaultTableModel modelo = (DefaultTableModel) tablaPersona.getModel();
		int filas = tablaPersona.getRowCount();
		for (int i = 0; i < filas; i++) {
			modelo.removeRow(0);
		}
		buscar.setText("");
	}

	public void selecionaFila(String id) {
		for (int i = 0; i < tablaPersona.getRowCount(); i++) {
			if (id.equals(tablaPersona.getValueAt(i, 0))) {
				tablaPersona.setRowSelectionInterval(i, i);
				break;
			}
		}

	}

	/** AccionesTabla: Acciones que puede realizar la tabla mediante el evento mouseClicked
	 * @author Cristian Lacuadra
	 * @param e: evento mouseClicked
	 * @return void 
	 */
	private void AccionesTabla(MouseEvent e) {
		int columna = tablaPersona.getColumnModel().getColumnIndexAtX(e.getX());
		int fila = e.getY() / tablaPersona.getRowHeight();
		if (fila < tablaPersona.getRowCount() && fila >= 0 && columna < tablaPersona.getColumnCount() && columna >= 0) {
			Object value = tablaPersona.getValueAt(fila, columna);
			//botones
			if (value instanceof JButton)
			{

				((JButton) value).doClick();
				JButton boton = (JButton) value;
					int dni = (Integer) tablaPersona.getValueAt(fila, 6);				
                    //detalles 
					if (boton.getName().equals("btnDetalle"))
						miCoordinador.MostrarVentanaDetallesInhabilitar(dni);
					//Baja
					if(boton.getName().equals("btnBaja"))
					{
						if (JOptionPane.showConfirmDialog(this, "¿Desea inhabilitar la persona", "Sistema Club Avenida Ejercito", JOptionPane.YES_NO_OPTION, 0,
								new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) 
						{
							//dar de baja
							
							//actualizar

						}
				}
			}
			//CheckBox seleccionado
			if(value instanceof java.lang.Boolean){
				for (int i = 0; i < tablaPersona.getRowCount(); i++) {
					if(tablaPersona.getValueAt(i, 1).equals(true))
					{
						botonAlta.setEnabled(true);
						botonBaja.setEnabled(true);
						break;
					}
					else{
						botonAlta.setEnabled(false);
						botonBaja.setEnabled(false);
					}

				}
			}

		}
	}

	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cargar) {
			miCoordinador.CargarGrilla(tablaPersona);
		}
		if (e.getSource() == registrar) {
			miCoordinador.mostrarFormularioPersona(true);
		}
		if (e.getSource() == limpiar) {
			this.limpiaCampos();
		}
	}
}
