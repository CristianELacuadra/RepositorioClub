
package ar.com.ProyectoClub.AVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	private app.bolivia.swing.JCTextField buscar;
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
	public static JButton btnCuotas;
	public JPanel panelSNS;
	public ButtonGroup GrupoSNS;
	public static JRadioButton checkApe;
	public JRadioButton chckNom;
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
		botonBaja = new javax.swing.JButton();
		botonBaja.setEnabled(false);
		limpiar = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		buscar = new app.bolivia.swing.JCTextField();
		buscar.setToolTipText("Ingrese Nombre o Apellido segun el filtro que haya seleccionado");
		buscar.setBounds(20, 40, 205, 32);
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
		btnBaja.setToolTipText("Inhabilitar");
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
		
		btnCuotas= new JButton();
		btnCuotas.setName("btnCuotas");
		btnCuotas.setToolTipText("Ver Cuotas Socio");
		btnCuotas.setText("");
		btnCuotas.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\Vercuotas.png"));
		btnCuotas.setEnabled(false);
		
		GrupoSNS=new ButtonGroup();
		

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
		
		JButton btnControlCuotas = new JButton();
		btnControlCuotas.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnControlCuotas.setText("Control Morosos");
		btnControlCuotas.setHorizontalTextPosition(SwingConstants.CENTER);
		btnControlCuotas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnControlCuotas.setContentAreaFilled(false);
		btnControlCuotas.setBorderPainted(false);
		btnControlCuotas.setBorder(null);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addComponent(registrar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(botonBaja)
					.addGap(18)
					.addComponent(botonAlta, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(limpiar)
					.addGap(18)
					.addComponent(btnControlCuotas)
					.addGap(858))
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(registrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(botonBaja, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
						.addComponent(botonAlta, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(limpiar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnControlCuotas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
		);
		jPanel3Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {botonBaja, limpiar});
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
        buscar.setPlaceholder("Ingrese Nombre o Apellido ");
        buscar.addActionListener(this);

		jPanel4.add(buscar);

		codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		codigoL1.setIcon(
				new ImageIcon(PantallaPrincipalPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/PanelEntrada.png"))); // NOI18N
		jPanel4.add(codigoL1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1433, Short.MAX_VALUE)
						.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 808, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addGap(51))
		);
		checkApe= new JRadioButton();
		checkApe.setSelected(true);
		chckNom=new JRadioButton();
		
		panelSNS = new JPanel();
		jPanel4.add(panelSNS);
		panelSNS.setBounds(435, 11, 244, 95);
		panelSNS.setBackground(Color.WHITE);
		panelSNS.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"Seleccione un metodo de busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		panelSNS.setLayout(null);
		
		checkApe.setText("APELLIDO");
		checkApe.setBackground(Color.WHITE);
		checkApe.setBounds(19, 22, 109, 23);
		GrupoSNS.add(checkApe);
		panelSNS.add(checkApe);
		
		chckNom.setText("NOMBRE");
		chckNom.setBackground(Color.WHITE);
		chckNom.setBounds(19, 53, 109, 23);
		GrupoSNS.add(chckNom);
		panelSNS.add(chckNom);
		
		JButton btnDfs = new JButton();
		btnDfs.setVerticalTextPosition(SwingConstants.TOP);
		btnDfs.setHorizontalAlignment(SwingConstants.LEFT);
		btnDfs.setIcon(null);
		btnDfs.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDfs.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDfs.setContentAreaFilled(false);
		btnDfs.setBorderPainted(false);
		btnDfs.setBorder(null);
		btnDfs.setBounds(270, 40, 75, 32);
		jPanel4.add(btnDfs);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 1362, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.PREFERRED_SIZE, 705, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
		registrar.addActionListener(this);
		limpiar.addActionListener(this);
	}
	
	private void limpiaCampos() {
		 if (tablaPersona.getSelectedRow() > -1) 
			 tablaPersona.removeRowSelectionInterval(tablaPersona.getSelectedRow(), tablaPersona.getSelectedRow());
		buscar.setText("");
	}
	
	public void LimpiarTabla(){
		DefaultTableModel tb = (DefaultTableModel) tablaPersona.getModel();
		int a = tablaPersona.getRowCount()-1;
		for (int i = a; i >= 0; i--) {           
			tb.removeRow(tb.getRowCount()-1);
		} 
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
					int dni = (Integer) tablaPersona.getValueAt(fila, 8);				
                    //detalles 
					if (boton.getName().equals("btnDetalle")){
						miCoordinador.LimpiarDetallePersona();
						miCoordinador.MostrarVentanaDetallesInhabilitar(dni);
						
					}
					if (boton.getName().equals("btnCuotas")){
						miCoordinador.mostrarVentanaCobranza(dni ,PantallaCobranzaCuota.jtDatosCuota);
						//miCoordinador.MostrarVentanaDetallesInhabilitar(dni);
					}
					//Baja
					if(boton.getName().equals("btnBaja"))
					{
						if (JOptionPane.showConfirmDialog(this, "�Desea inhabilitar la persona", "Sistema Club Avenida Ejercito", JOptionPane.YES_NO_OPTION, 0,
								new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) 
						{
							//dar de baja
							miCoordinador.InhabilitarPersona(dni);
							miCoordinador.CargarGrilla(tablaPersona);

						}
					}
					if(boton.getName().equals("btnHabilitado"))
					{
						if (JOptionPane.showConfirmDialog(this, "�Seguro que desea Habilitar esta Persona?", "Categorias", JOptionPane.YES_NO_OPTION, 0,
	        					new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) {
							//dar de baja
							miCoordinador.HabilitarPersona(dni);
							miCoordinador.CargarGrilla(tablaPersona);

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
		try{
			if (e.getSource() == registrar) {
				miCoordinador.mostrarFormularioPersona();
			}
			if (e.getSource() == limpiar) {
				this.limpiaCampos();
			}
			if(e.getSource()==buscar){
                 this.BusquedaPersona();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"�ERROR!"+e.toString(),"Atencion", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void BusquedaPersona() {
		if(!buscar.getText().isEmpty())
		{
			LimpiarTabla();
			String nom=new String();
			String ape=new String();
			if(chckNom.isSelected()){
				nom = buscar.getText().trim();
				ape = "";
			}
			else{
				if(checkApe.isSelected()){
					nom = "";
					ape = buscar.getText().trim();
				}
			}
			miCoordinador.ObtenerPersonaNomApe(nom,ape);
		}
		else
			miCoordinador.CargarGrilla(tablaPersona);
	}
}
