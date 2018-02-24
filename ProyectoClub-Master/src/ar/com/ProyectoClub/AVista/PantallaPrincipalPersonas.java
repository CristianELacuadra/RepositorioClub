
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
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;

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
import javax.swing.border.LineBorder;
import javax.swing.JLabel;

public class PantallaPrincipalPersonas extends JFrame implements ActionListener {

	private ControllerCoordinador miCoordinador; // objeto miCoordinador que
	private app.bolivia.swing.JCTextField buscar;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton limpiar;
	private JButton btnControlMorosos;
	private javax.swing.JButton registrar;
	public static javax.swing.JTable tablaPersona;
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
	private JButton btnCategorias;
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
		tablaPersona.getTableHeader().setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
        tablaPersona.setDefaultRenderer(Object.class, new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
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
		limpiar = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		buscar = new app.bolivia.swing.JCTextField();
		buscar.setToolTipText("Ingrese Nombre o Apellido segun el filtro que haya seleccionado");
		buscar.setBounds(80, 39, 281, 32);
		btnControlMorosos= new JButton();
		
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
		

		tablaPersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setTitle("PRINCIPAL PERSONAS");

		jPanel1.setBackground(new Color(211, 211, 211));

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

		limpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		limpiar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png"))); // NOI18N
		limpiar.setText("Limpiar");
		limpiar.setBorder(null);
		limpiar.setBorderPainted(false);
		limpiar.setContentAreaFilled(false);
		limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		limpiar.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png"))); // NOI18N
		limpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		limpiar.addActionListener(this);
		
		btnControlMorosos.setIcon(new ImageIcon(PantallaPrincipalPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/IcoMorosos.png")));
		btnControlMorosos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnControlMorosos.setText("Control Morosos");
		btnControlMorosos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnControlMorosos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnControlMorosos.setContentAreaFilled(false);
		btnControlMorosos.setBorderPainted(false);
		btnControlMorosos.setBorder(null);
		btnControlMorosos.addActionListener(this);
		
		btnCategorias = new JButton();
		btnCategorias.setIcon(new ImageIcon(PantallaPrincipalPersonas.class.getResource("/ar/com/ProyectoClub/AVista/icon/IcoCategorias.png")));
		btnCategorias.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCategorias.setText("Categorias");
		btnCategorias.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCategorias.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCategorias.setContentAreaFilled(false);
		btnCategorias.setBorderPainted(false);
		btnCategorias.setBorder(null);
		btnCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnCategorias.setRolloverIcon(
				new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/IcoCategorias2.png"))); // NOI18N
		btnCategorias.addActionListener(this);
		

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addComponent(registrar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(limpiar)
					.addGap(36)
					.addComponent(btnCategorias, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnControlMorosos)
					.addGap(1020))
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(registrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(limpiar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCategorias, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnControlMorosos, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		jPanel3.setLayout(jPanel3Layout);

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		jPanel4.setLayout(null);

		buscar.setBackground(Color.BLACK);
        buscar.setBorder(new LineBorder(new Color(0, 0, 0)));
        buscar.setForeground(Color.BLACK);
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new Color(0, 0, 0));
        buscar.setPlaceholder("Ingrese Nombre o Apellido ");
        buscar.addActionListener(this);

		jPanel4.add(buscar);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1472, Short.MAX_VALUE)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 808, GroupLayout.PREFERRED_SIZE)
						.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 1334, Short.MAX_VALUE))
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
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
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
		
		JLabel lblNewLabel = new JLabel("BUSCAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 38, 67, 32);
		jPanel4.add(lblNewLabel);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 1362, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.PREFERRED_SIZE, 705, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
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
					if (JOptionPane.showConfirmDialog(this, "¿Desea inhabilitar la persona", "Sistema Club Avenida Ejercito", JOptionPane.YES_NO_OPTION, 0,
							new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) 
					{
						//dar de baja
						miCoordinador.InhabilitarPersona(dni);
						miCoordinador.CargarGrilla(tablaPersona);

					}
				}
				if(boton.getName().equals("btnHabilitado"))
				{
					if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea Habilitar esta Persona?", "Categorias", JOptionPane.YES_NO_OPTION, 0,
							new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) {
						//dar de baja
						miCoordinador.HabilitarPersona(dni);
						miCoordinador.CargarGrilla(tablaPersona);

					}
				}
				if(boton.getName().equals("btnEditar")){
					PantallaFormularioPersona.TipoEntrada=false;
					miCoordinador.CargarDatosPersona(dni);
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
				PantallaFormularioPersona.TipoEntrada=true;
				miCoordinador.mostrarFormularioPersona();
			}
			if (e.getSource() == limpiar) {
				this.limpiaCampos();
			}
			if(e.getSource()==buscar){
                 this.BusquedaPersona();
			}
			if(e.getSource()==btnCategorias){
				miCoordinador.MostarVentanaConfCategoria(PantallaConfiguracionCategoria.tablaCategoria);  
			}
			if(e.getSource()==btnControlMorosos){
				miCoordinador.MostrarVentanaControlMorosos(PantallaControlMorosos.tablaDeudores);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"ERROR: "+ex.toString(),"Atencion", JOptionPane.ERROR_MESSAGE);
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
