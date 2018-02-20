package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRende;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Socios;

import java.awt.EventQueue;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import app.bolivia.swing.JCTextField;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import javax.swing.JRadioButton;

import java.awt.Cursor;
import java.awt.Color;
import java.awt.Component;
import java.awt.List;

import javax.swing.table.DefaultTableCellRenderer;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Date;

public class PantallaAlquilerPrincipal extends JFrame implements ActionListener,KeyListener,MouseListener{
	private ControllerCoordinador miCoordinador; 
	public JPanel contentPane;
	public app.bolivia.swing.JCTextField tFiltroBusI;
	public JTable tableAlq;
	public JTable tableInm;
	public JTextField tFiltroAlquiler;
	public Inmuebles inmuebleEnt;
	public Alquiler alquilerEnt;
	public Integer auxNum;
	
	//alquiler
	public JPanel panelAlquileres;
	public JButton btnIrInmueble;
	public JPanel panelOpcionesAlquileres;
	public JPanel panelTablaAlq;
	public JPanel panelBusquedaFiltro;
	public JScrollPane scrollPane_1;
	public JLabel labelFecha;
	public JLabel labBusqued;
	public JDateChooser dateDesde;
	public JLabel lblNewLabel_1;
	public JDateChooser dateHasta;
	public JLabel lblNewLabel_2;
	public ButtonGroup bg;
	public JRadioButton radioB4;
	public JRadioButton radioB2;
	public JRadioButton radioB3;
	public JButton bNuevoAlq;
	public JButton bLimpiar;
	public JButton btnBuscarFec;
	public JRadioButton radioFecAc;
	public JRadioButton radioFecRes;
	public ButtonGroup fechasGrup;
	
	//botones de tabla
	public JButton btnDet;
	public JButton btnMod;
	public JButton btnPag;
	public JButton btnEli;
		
	//inmueble
	public JPanel panelInmuebles;
	public JPanel  panelFiltro;
	public JPanel panelTablaInm;
	public JPanel panelRegInm;
	public JButton btnIrAlquileres;
	public JPanel panelOpcionInm ;
	public JToggleButton bRegistrarI;
	public JToggleButton bActualizarI;
	public JButton	bEliminarI;
	public JButton bRestaurarI;
	public JScrollPane scrollPane;
	public JLabel lNombreI;
	public JCTextField texInmNombre;
	public JLabel lDireccionI;
	public JCTextField texInmDireccion;
	public JLabel lPrecioHoraI;
	public JLabel lSeI;
	public JCTextField texInmPrecioHora ;
	public JCTextField texInmSe;
	public JLabel lDescripcionI;
	public JTextArea texInmDescrip;
	public JCheckBox checkB;
	public JButton bLimpiarCamposI;
	public boolean botCanhab;
	public static RowsRende rest;
	public JTextField texInmDireccionNum;
	private JScrollPane scrollPane_2;
	
	/**
	 * Create the frame.
	 */
	public PantallaAlquilerPrincipal() {
		setMinimumSize(new Dimension(900, 600));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		setTitle("ALQUILERES/INMUEBLES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		initComponents();



		//RecargarPanelAlquiler(); /// revisar /// poner la 
//github.com/CristianELacuadra/RepositorioClub.git
	}
	
	public void initComponents(){
		miCoordinador=new ControllerCoordinador();
		setBounds(50, 50, 930, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelAlquileres = new JPanel();
		panelAlquileres.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelAlquileres, "p1"); 
		
		
		panelOpcionesAlquileres = new JPanel();
		panelOpcionesAlquileres.setBackground(new Color(245, 245, 245));
		
		panelBusquedaFiltro = new JPanel();
		panelBusquedaFiltro.setBackground(new Color(255, 255, 255));
		panelBusquedaFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"BUSQUEDA Y FILTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		panelTablaAlq = new JPanel();
		
		GroupLayout gl_panelAlquileres = new GroupLayout(panelAlquileres);
		gl_panelAlquileres.setHorizontalGroup(
			gl_panelAlquileres.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelAlquileres.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAlquileres.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBusquedaFiltro, GroupLayout.PREFERRED_SIZE, 884, Short.MAX_VALUE)
						.addComponent(panelTablaAlq, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
						.addComponent(panelOpcionesAlquileres, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAlquileres.setVerticalGroup(
			gl_panelAlquileres.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlquileres.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelOpcionesAlquileres, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBusquedaFiltro, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTablaAlq, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addGap(28))
		);
		panelTablaAlq.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTablaAlq.add(scrollPane_1, BorderLayout.CENTER);
		
		tableAlq = new JTable();
		tableAlq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAlq.setAutoCreateRowSorter(true);
		tableAlq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tableAlq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableAlq.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Habilitado", "Pagado", "", "", "", "", "Nro de Alquiler", "Persona", "Inmueble", "Fecha de reserva", "Monto", "Fecha de Emisión"
			}
		));

//		tableAlq.getColumnModel().getColumn(0).setResizable(false);
//		tableAlq.getColumnModel().getColumn(5).setPreferredWidth(90);
//		tableAlq.getColumnModel().getColumn(5).setMinWidth(70);
//		tableAlq.getColumnModel().getColumn(5).setMaxWidth(110);
//		tableAlq.getColumnModel().getColumn(6).setPreferredWidth(89);
//		tableAlq.getColumnModel().getColumn(6).setMinWidth(30);
//		tableAlq.getColumnModel().getColumn(7).setPreferredWidth(96);
//		tableAlq.getColumnModel().getColumn(8).setPreferredWidth(120);
//		tableAlq.getColumnModel().getColumn(8).setMinWidth(60);
//		tableAlq.getColumnModel().getColumn(9).setPreferredWidth(96);
//		tableAlq.getColumnModel().getColumn(10).setPreferredWidth(99);
//		tableAlq.getColumnModel().getColumn(12).setPreferredWidth(90);
//		tableAlq.getColumnModel().getColumn(12).setMinWidth(80);
//		tableAlq.getColumnModel().getColumn(12).setMaxWidth(90);
//		tableAlq.getColumnModel().getColumn(13).setPreferredWidth(90);
//		tableAlq.getColumnModel().getColumn(13).setMinWidth(70);
//		tableAlq.getColumnModel().getColumn(13).setMaxWidth(110);
//				
		tableAlq.getTableHeader()
		.setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
//		tableAlq.setDefaultRenderer(Object.class,
//		new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());

		
		tableAlq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionesTablaAlquiler(e);
			}
		});

		
		scrollPane_1.setViewportView(tableAlq);
		
		
	/*	btnDet
		btnMod
		btnPag
		btnEli
		*/
		//det
		btnDet = new JButton();
		btnDet.setName("btnDet");
		btnDet.setToolTipText("Observar detalles");
		btnDet.setText("");
		btnDet.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/icon-Detalles.png")));
		
		//Mod
		btnMod = new JButton();
		btnMod.setName("btnMod");
		btnMod.setToolTipText("Modificar Alquiler");
		btnMod.setText("");
		btnMod.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/modific1.png")));
		
		//Pag
		btnPag = new JButton();
		btnPag.setName("btnPag");
		btnPag.setToolTipText("Pagar");
		btnPag.setText("");
		btnPag.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/precioL.png")));
		
				
		//Eli		
		btnEli = new JButton();
		btnEli.setName("btnEli");
		btnEli.setToolTipText("Eliminar");
		btnEli.setText("");
		btnEli.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/cancel1.png")));
		
		
		tFiltroAlquiler = new JTextField();
		tFiltroAlquiler.setBackground(new Color(250, 250, 210));
		tFiltroAlquiler.setBounds(531, 14, 303, 24);
		tFiltroAlquiler.setToolTipText("Buscar por Nombre o Apellido del cliente");
		tFiltroAlquiler.setColumns(10);
		
		labBusqued = new JLabel("BUSCAR EN EL LISTADO:");
		labBusqued.setHorizontalAlignment(SwingConstants.RIGHT);
		labBusqued.setBounds(358, 19, 155, 14);
		
		labelFecha = new JLabel("BUSCAR ENTRE LAS FECHAS");
		labelFecha.setBounds(6, 19, 212, 14);
		
		dateDesde = new JDateChooser();
		dateDesde.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateDesde.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		dateDesde.setBounds(6, 43, 95, 20);
		dateDesde.getCalendarButton().setToolTipText("DESDE");
		dateDesde.setToolTipText("DESDE");
		
		lblNewLabel_1 = new JLabel("Y");
		lblNewLabel_1.setBounds(111, 49, 14, 14);
		
		dateHasta = new JDateChooser();
		dateHasta.setBackground(new Color(250, 250, 210));
		dateHasta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateHasta.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		dateHasta.setBounds(132, 43, 87, 20);
		dateHasta.setToolTipText("HASTA");
		dateHasta.getCalendarButton().setToolTipText("HASTA");
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(313, 43, 0, 0);
		
		radioB4 = new JRadioButton("TODOS LOS ALQUILERES");
		radioB4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioB4.setBounds(531, 45, 200, 23);
		
		radioB2 = new JRadioButton("SOLO ALQUILERES PAGADOS");
		radioB2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioB2.setBounds(531, 97, 200, 23);
		
		radioB3 = new JRadioButton("SOLO ALQUILERES SE\u00D1ADOS");
		radioB3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioB3.setBounds(531, 71, 200, 23);
		
		bg =new ButtonGroup();
		bg.add(radioB4);
		bg.add(radioB2);
		bg.add(radioB3);
		radioB4.setSelected(true);
		
		fechasGrup= new ButtonGroup();
		radioFecAc= new JRadioButton("Fecha de Emisión");
		radioFecAc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioFecRes=new JRadioButton("Fecha de Reserva");
		radioFecRes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		radioFecAc.setBounds(6, 96, 134, 23);
		radioFecRes.setBounds(155, 96, 138, 23);
		
		fechasGrup.add(radioFecAc);
		fechasGrup.add(radioFecRes);
		radioFecAc.setSelected(true);
		
		btnBuscarFec = new JButton("");
		btnBuscarFec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarFec.setBounds(229, 19, 83, 59);
		btnBuscarFec.setToolTipText("BUSCAR POR FECHAS");
		btnBuscarFec.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscaF1.png")));
		panelBusquedaFiltro.setLayout(null);
		panelBusquedaFiltro.add(labBusqued);
		panelBusquedaFiltro.add(tFiltroAlquiler);
		panelBusquedaFiltro.add(lblNewLabel_2);
		panelBusquedaFiltro.add(dateDesde);
		panelBusquedaFiltro.add(lblNewLabel_1);
		panelBusquedaFiltro.add(dateHasta);
		panelBusquedaFiltro.add(labelFecha);
		panelBusquedaFiltro.add(btnBuscarFec);
		panelBusquedaFiltro.add(radioB4);
		panelBusquedaFiltro.add(radioB2);
		panelBusquedaFiltro.add(radioB3);
		panelBusquedaFiltro.add(radioFecAc);
		panelBusquedaFiltro.add(radioFecRes);
		panelAlquileres.setLayout(gl_panelAlquileres);
		
		panelOpcionesAlquileres.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"OPCIONES: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));//para agregar titulo en el recuadro de un panel
		panelOpcionesAlquileres.setLayout(null);
		
		// CardLayout de p1 == panel alquileres  // p2==panel inmuebles 
		//agregados dentro de contentPanel
		
		btnIrInmueble = new JButton("Ir a Inmuebles");
		btnIrInmueble.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIrInmueble.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIrInmueble.setBounds(10, 22, 120, 77);
		panelOpcionesAlquileres.add(btnIrInmueble);
		btnIrInmueble.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIrInmueble.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIrInmueble.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/gohome_action_ir_102351.png")));
		
			
		//acciones alquileres
		btnIrInmueble.addActionListener(this);
		
		bNuevoAlq = new JButton("NUEVO ALQUILER");
		bNuevoAlq.setFont(new Font("Tahoma", Font.BOLD, 11));
		bNuevoAlq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bNuevoAlq.setBounds(147, 22, 141, 77);
		bNuevoAlq.setHorizontalTextPosition(SwingConstants.CENTER);
		bNuevoAlq.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoAlquiler1.png")));
		bNuevoAlq.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelOpcionesAlquileres.add(bNuevoAlq);
		
		bLimpiar = new JButton("LIMPIAR CAMPOS");
		bLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bLimpiar.setBounds(305, 22, 142, 77);
		bLimpiar.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
		bLimpiar.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar22.png")));
		panelOpcionesAlquileres.add(bLimpiar);
		
		
		//
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		///inmuebles
		
		panelInmuebles = new JPanel();
		panelInmuebles.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelInmuebles, "p2");
		
		panelFiltro = new JPanel();
		panelFiltro.setBackground(Color.WHITE);
		panelFiltro.setLayout(null);
		panelFiltro.setBorder(UIManager.getBorder("ComboBox.border"));
	
		panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"FILTROS DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		
		panelTablaInm = new JPanel();
		panelTablaInm.setBorder(UIManager.getBorder("ComboBox.border"));
		panelTablaInm.setLayout(new BorderLayout(0, 0));
		
		panelRegInm = new JPanel();
		panelRegInm.setBackground(Color.WHITE);
		panelRegInm.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"REGISTRO/ DETALLES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));

		
		panelOpcionInm = new JPanel();
		panelOpcionInm.setToolTipText("Panel de opciones disponibles ");
		panelOpcionInm.setBorder(UIManager.getBorder("ComboBox.border"));
		panelOpcionInm.setBackground(Color.WHITE);
		panelOpcionInm.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelOpcionInm.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		
		bRegistrarI = new JToggleButton("Registrar");
		bRegistrarI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bRegistrarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/Newsupport.png")));
		bRegistrarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bRegistrarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bRegistrarI);
		
		bActualizarI = new JToggleButton("Modificar");
		bActualizarI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bActualizarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/actualizar.png")));
		bActualizarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bActualizarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bActualizarI);
		
		bEliminarI = new JButton("Deshabilitar");
		bEliminarI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bEliminarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/borrarT1.png")));
		bEliminarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bEliminarI);
		
		bRestaurarI = new JButton("Restaurar");
		bRestaurarI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bRestaurarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/borrar1.png")));
		bRestaurarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bRestaurarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bRestaurarI);
		
		btnIrAlquileres = new JButton("Ir a Alquileres");
		btnIrAlquileres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIrAlquileres.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIrAlquileres.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIrAlquileres.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoSalida32x32.png")));
		
		btnIrAlquileres.addActionListener(this);
		
		GroupLayout gl_panelInmuebles = new GroupLayout(panelInmuebles);
		gl_panelInmuebles.setHorizontalGroup(
			gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInmuebles.createSequentialGroup()
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelTablaInm, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
								.addGroup(gl_panelInmuebles.createSequentialGroup()
									.addComponent(panelOpcionInm, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panelFiltro, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
									.addGap(4))))
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addGap(8)
							.addComponent(btnIrAlquileres)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelRegInm, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
							.addGap(0)))
					.addContainerGap())
		);
		gl_panelInmuebles.setVerticalGroup(
			gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInmuebles.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
						.addComponent(panelRegInm, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIrAlquileres, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelFiltro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelOpcionInm, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTablaInm, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
		);
		
		scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelTablaInm.add(scrollPane, BorderLayout.CENTER);
		
		tableInm = new JTable();
		tableInm.setAutoCreateRowSorter(true);
		//da estilo a las filas y a la cabecera
		tableInm.getTableHeader()
				.setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
//		tableInm.setDefaultRenderer(Object.class,
//				new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());// garilla intercalada

		tableInm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tableInm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableInm.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tableInm.getTableHeader().setReorderingAllowed(false);
		
		scrollPane.setColumnHeaderView(tableInm);
		tableInm.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NUMERO DEL INMUEBLE", "NOMBRE", "PRECIO/HORA", "SE\u00D1A", "HABILITADO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Integer.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		}
		);
		tableInm.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableInm.getColumnModel().getColumn(0).setMinWidth(80);
		tableInm.getColumnModel().getColumn(1).setPreferredWidth(81);
		tableInm.getColumnModel().getColumn(1).setMinWidth(80);
		tableInm.getColumnModel().getColumn(2).setPreferredWidth(84);
		tableInm.getColumnModel().getColumn(2).setMinWidth(80);
		tableInm.getColumnModel().getColumn(3).setPreferredWidth(71);
		tableInm.getColumnModel().getColumn(3).setMinWidth(70);
		tableInm.getTableHeader().setReorderingAllowed(false);
		RowsRende rr= new RowsRende(4); // para determinar si esta borrado o no
		tableInm.setDefaultRenderer(Object.class, rr);
		scrollPane.setViewportView(tableInm);
		this.ocultarColumnaTable(4, true); // oculta columna Habilitado
		ocultarColumnaTable(0, true);//oculta id
		
		lNombreI = new JLabel("NOMBRE DEL INMUEBLE");
		lNombreI.setToolTipText("");
		
		texInmNombre = new JCTextField();
		texInmNombre.setBackground(new Color(250, 250, 210));
		texInmNombre.setDisabledTextColor(Color.RED);
		texInmNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		texInmNombre.setBounds(new Rectangle(0, 0, 180, 32));
		texInmNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tec) {
				//		tec.setKeyChar(miCoordinador.teclaMayus(tec));
				char aux= tec.getKeyChar();
				if(Character.isLowerCase(aux)){
					String cad=(""+aux).toUpperCase();
					aux=cad.charAt(0);
					tec.setKeyChar(aux);
					
				}
				
			}
		});
		texInmNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(miCoordinador.validarNombreInmueble(texInmNombre.getText(),inmuebleEnt.getIdInmubles()))
				{	miCoordinador.mensajes("¡Nombre Repetido o vacio! \n Elija otro", 0);
					texInmNombre.setText("");
					texInmNombre.requestFocus();
				}
				
			}
		});
		texInmNombre.setToolTipText("ej: cancha de futbol");
		texInmNombre.setColumns(10);
//		texInmNombre.
		
		lDireccionI = new JLabel("DIRECCIÓN");
		
		texInmDireccion = new JCTextField();
		texInmDireccion.setBackground(new Color(250, 250, 210));
		texInmDireccion.setDisabledTextColor(Color.RED);
		texInmDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		texInmDireccion.setToolTipText("Dirección del inmueble");
		texInmDireccion.setColumns(10);
		
		lPrecioHoraI = new JLabel("PRECIO POR HORA");
		
		lSeI = new JLabel("SE\u00D1A");
		
		texInmPrecioHora = new JCTextField();
		texInmPrecioHora.setBackground(new Color(250, 250, 210));
		texInmPrecioHora.setDisabledTextColor(Color.RED);
		texInmPrecioHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		texInmPrecioHora.setToolTipText("Precio por hora que que cuesta \n alquilar este inmueble");
		texInmPrecioHora.setColumns(10);
		
		
		texInmSe = new JCTextField();
		texInmSe.setBackground(new Color(250, 250, 210));
		texInmSe.setDisabledTextColor(Color.RED);
		texInmSe.setFont(new Font("Tahoma", Font.BOLD, 12));
		texInmSe.setToolTipText("en caso de no tener seña \n dejar vacio ");
		texInmSe.setColumns(10);
		
		lDescripcionI = new JLabel("DESCRIPCION");
		

		
		texInmDireccionNum = new JTextField();
		texInmDireccionNum.setBackground(new Color(250, 250, 210));
		texInmDireccionNum.setDisabledTextColor(Color.RED);
		texInmDireccionNum.setFont(new Font("Tahoma", Font.BOLD, 12));
		texInmDireccionNum.setColumns(2);
		texInmDireccionNum.setToolTipText("Numero de la direccion");
		
		JLabel lblNewLabel_4 = new JLabel("NUMERO");
		
		scrollPane_2 = new JScrollPane();
		GroupLayout gl_panelRegInm = new GroupLayout(panelRegInm);
		gl_panelRegInm.setHorizontalGroup(
			gl_panelRegInm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRegInm.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
								.addComponent(texInmDireccion, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(lDireccionI, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelRegInm.createSequentialGroup()
									.addComponent(texInmDireccionNum, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_panelRegInm.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(texInmNombre, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(lNombreI, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.TRAILING)
								.addComponent(texInmPrecioHora, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
								.addComponent(texInmSe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
								.addComponent(lSeI, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lPrecioHoraI, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(lDescripcionI, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(207))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panelRegInm.setVerticalGroup(
			gl_panelRegInm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRegInm.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPrecioHoraI)
						.addComponent(lDescripcionI)
						.addComponent(lNombreI))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
								.addComponent(texInmPrecioHora, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmNombre, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
								.addComponent(lDireccionI)
								.addComponent(lblNewLabel_4)
								.addComponent(lSeI))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
								.addComponent(texInmDireccion, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmSe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmDireccionNum, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		

								
		
		texInmDescrip = new  JTextArea();
		texInmDescrip.setBackground(new Color(250, 250, 210));
		texInmDescrip.setDisabledTextColor(Color.RED);
		texInmDescrip.setFont(new Font("Tahoma", Font.BOLD, 12));
		texInmDescrip.setLineWrap(true);
		texInmDescrip.setAutoscrolls(true);
		scrollPane_2.setViewportView(texInmDescrip);
	
		
		panelRegInm.setLayout(gl_panelRegInm);
		new app.bolivia.swing.JCTextField();
		
		tFiltroBusI = new app.bolivia.swing.JCTextField();
		tFiltroBusI.setSelectionColor(Color.LIGHT_GRAY);
		tFiltroBusI.setForeground(Color.WHITE);
		tFiltroBusI.setFont(new Font("Arial", tFiltroBusI.getFont().getStyle() & ~Font.ITALIC | Font.BOLD, tFiltroBusI.getFont().getSize()));
		tFiltroBusI.setPhColor(Color.BLACK);
		tFiltroBusI.setPlaceholder("BUSCAR");
		tFiltroBusI.setBackground(new Color(250, 250, 210));

		tFiltroBusI.setToolTipText("Filtra la Tabla por Nombre");
		tFiltroBusI.setBorder(UIManager.getBorder("Button.border"));
		tFiltroBusI.setBounds(10, 23, 238, 40);
		panelFiltro.add(tFiltroBusI);
		tFiltroBusI.setColumns(10);
		
		checkB = new JCheckBox("Incluir Inmuebles Inactivos");
		checkB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkB.setFont(new Font("Tahoma", Font.BOLD, 12));

		checkB.setBounds(10, 70, 238, 23);
		
		panelFiltro.add(checkB);
		
		
	
		bLimpiarCamposI = new JButton("Limpiar Campos");
		bLimpiarCamposI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bLimpiarCamposI.setHorizontalTextPosition(SwingConstants.CENTER);
		bLimpiarCamposI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLimpiarCamposI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png")));
		panelOpcionInm.add(bLimpiarCamposI);
		
		panelInmuebles.setLayout(gl_panelInmuebles);
		

		inmuebleEnt= new Inmuebles(); 
		alquilerEnt= new Alquiler(); 
		
		texInmNombre.setNextFocusableComponent(texInmDireccion);
		texInmDireccion.setNextFocusableComponent(texInmDireccionNum);
		texInmDireccionNum.setNextFocusableComponent(texInmPrecioHora);
		texInmPrecioHora.setNextFocusableComponent(texInmSe);
		texInmSe.setNextFocusableComponent(texInmDescrip);
		
		texInmPrecioHora.addKeyListener(this);
		texInmSe.addKeyListener(this);
		texInmDescrip.addKeyListener(this);
		texInmDireccionNum.addKeyListener(this);



		
		// acciones b inmueble
		bRegistrarI.addActionListener(this);
		bActualizarI.addActionListener(this);
		bEliminarI.addActionListener(this);
		bRestaurarI.addActionListener(this);
		bLimpiarCamposI.addActionListener(this);
		tFiltroBusI.addKeyListener(this);
		checkB.addActionListener(this);
		bLimpiar.addActionListener(this);
		bNuevoAlq.addActionListener(this);
		radioB4.addActionListener(this);
		radioB2.addActionListener(this);
		radioB3.addActionListener(this);
		tFiltroAlquiler.addKeyListener(this);
		btnBuscarFec.addActionListener(this);
		
		
		
		
	
		bActualizarI.setEnabled(false);
		bEliminarI.setEnabled(false);
		bRestaurarI.setEnabled(true);

		auxNum=null;
		
		
		tableInm.addMouseListener(
				new MouseAdapter(){
    		//para selecionar una fila
    		public void mouseClicked(MouseEvent e){
    			if(!botCanhab){
    			Integer _fila;
    		
    			auxNum=null;
    		
    			try{
    			_fila=tableInm.getSelectedRow();
    			if(_fila!= -1){
    				DefaultTableModel modelotabla=(DefaultTableModel) tableInm.getModel();
    				auxNum=(Integer) modelotabla.getValueAt(_fila, 0);
    				inmuebleEnt=miCoordinador.BuscarInmueble(auxNum);
    				miCoordinador.panelRegInmDesHabilitar();
    				cargarDatosInmueble(inmuebleEnt);
    				miCoordinador.habilitarBotonesInm(inmuebleEnt.isHabilitado());
    				
    			
    			}
    		
    			}catch(Exception ex){
    			miCoordinador.mensajes("Error: Al seleccionar una fila \nInténtelo nuevamente", 0);
//    			JOptionPane.showMessageDialog(null, "Error: Al seleccionar una fila \nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
    			}
    			
    		}
    			
    	}   	
    	}
	);
		
		
		
  }


		//TODO aca termina funcion initComponente
	
	public void cargarDatosInmueble(){
		
		inmuebleEnt.setNombre(texInmNombre.getText());
		inmuebleEnt.setPreciohora(Float.parseFloat(texInmPrecioHora.getText())  );//convertir a float
		inmuebleEnt.setSenial(Float.parseFloat(texInmSe.getText()));//convertir a float
		// (Integer.parseInt(textCantidadHoras.getText().toString()));
		inmuebleEnt.setDireccion(texInmDireccion.getText()+"-"+texInmDireccionNum.getText());
		inmuebleEnt.setDescripcion(texInmDescrip.getText());
	}
	
	public void cargarDatosInmueble(Inmuebles aux){
		if((!aux.getNombre().isEmpty())&&(!aux.getIdInmubles().toString().isEmpty())&&(!aux.getDireccion().isEmpty())){//no esta nullo
		inmuebleEnt=aux;
		texInmNombre.setText(aux.getNombre());	
		
		String[] parts= aux.getDireccion().split("-");

		texInmDireccion.setText(parts[0]);
		texInmDireccionNum.setText(parts[1]);
		
		texInmPrecioHora.setText(Float.toString(aux.getPreciohora()));
		texInmSe.setText(Float.toString(aux.getSenial()));
		texInmDescrip.setText(aux.getDescripcion());
		

		}
		
	}
	public void LimpiarTablaAlquileres(){
		DefaultTableModel tb = (DefaultTableModel) tableAlq.getModel();
		int a = tableAlq.getRowCount()-1;
		for (int i = a; i >= 0; i--) {           
			tb.removeRow(tb.getRowCount()-1);
		} 
	}
	
	public void RecargarPanelAlquiler(){
		try{
			LimpiarTablaAlquileres();
			miCoordinador.ListarAlquileres(tableAlq,miCoordinador.listaAlquileresTodos());
			radioB4.setSelected(true);
			radioFecAc.setSelected(true);
			dateDesde.setDate(null);
			dateHasta.setDate(null);
			tFiltroAlquiler.setText("");
			
		}catch(Exception ex){
			miCoordinador.mensajes("Error al recargar la pagina", 0);
		}
	}
	
	public void LimpiarTablaInmuebles(){
		try {
			DefaultTableModel dm = (DefaultTableModel) tableInm.getModel();
			 int rowCount = dm.getRowCount();
				 	for (int i = rowCount - 1; i >= 0; i--) {
				     dm.removeRow(i);
				 	}
			tableInm.setModel(dm);
		} catch (Exception e) {
			miCoordinador.mensajes("Error al recargar la pagina", 0);
		}
		
		
	}

	public void recargarPanelInmueble(){
		try{ 
				LimpiarTablaInmuebles();
				inmuebleEnt= new Inmuebles();
				miCoordinador.panelRegInmDesHabilitar();
				limpiarCampos();	
				cargarDatosListadoInmueble();
				miCoordinador.botonCancelarDeshabilitarInm();
				miCoordinador.deshabilitarBotonesInm();
				bRegistrarI.setSelected(false);
				bActualizarI.setSelected(false);
				bRegistrarI.setText("Registrar");
				bActualizarI.setText("Modificar");
				botCanhab=false;
				bRegistrarI.setEnabled(true);
				
				
			}catch(Exception ex){
				miCoordinador.mensajes("Error al recargar la pagina", 0);
		}
		
	}
	
	public void cargarDatosListadoInmueble(){// se activa en eventos de recarga de pagina, filtro  y checkB
		 miCoordinador.ListarInmuebles(tableInm, checkB.isSelected());

	}

	public void limpiarCampos(){
		miCoordinador.limpiarPanelRegInm();

	}

	/***evento accion***/
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== bRegistrarI ){
			try{	
				if(bRegistrarI.isSelected()){
					inmuebleEnt=miCoordinador.CrearInmueble();
					miCoordinador.limpiarPanelRegInm();
					miCoordinador.panelRegInmHabilitar();
					bRegistrarI.setText("Guardar");
					miCoordinador.botonCancelarHabilitarInm();
				}else{
					
					if(miCoordinador.validarPanelRegInm()){
						this.cargarDatosInmueble();
						if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "¿Estas seguro que deseas guardar?",3)){
							//cuadro de mensaje de advertencio con opciones YES/NO
							inmuebleEnt.setIdInmubles(null);
							miCoordinador.RegistrarInmueble(inmuebleEnt);	
								miCoordinador.mensajes("Se Guardo correctamente", 1);//mensaje se guardo correctamente
								miCoordinador.panelRegInmDesHabilitar();
								bRegistrarI.setText("Registrar");
								miCoordinador.botonCancelarDeshabilitarInm();
//								LimpiarTablaInmuebles();
//								cargarDatosListadoInmueble();
								recargarPanelInmueble();
						}
					}else{
						//mensaje de campos no completados o valores no validos
						bRegistrarI.setSelected(true);
						miCoordinador.mensajes("Campos no completados o valores no validos", 0);
						
					}
				}
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		if(e.getSource()== bActualizarI){
			try{
				if(bActualizarI.isSelected()&&(!auxNum.equals(null))){
					miCoordinador.panelRegInmHabilitar();
					bActualizarI.setText("Guardar");
					bRegistrarI.setEnabled(false);
					miCoordinador.botonCancelarHabilitarInm();
				}else{
					
				if(!miCoordinador.validarNombreInmueble(texInmNombre.getText(),inmuebleEnt.getIdInmubles())){
						if(miCoordinador.validarPanelRegInm()&&(inmuebleEnt.getIdInmubles().equals(auxNum))){
							this.cargarDatosInmueble();
							if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "¿Estas seguro que deseas guardar?",3)){
							//cuadro de mensaje de advertencio con opciones YES/NO
								miCoordinador.RegistrarInmueble(inmuebleEnt);	
								miCoordinador.mensajes("Se Guardo correctamente", 1);//mensaje se guardo correctamente
								miCoordinador.panelRegInmDesHabilitar();
								bActualizarI.setText("Modificar");
								miCoordinador.botonCancelarDeshabilitarInm();
								bRegistrarI.setEnabled(true);
//								LimpiarTablaInmuebles();
//								cargarDatosListadoInmueble();
								recargarPanelInmueble();
							}
						}else{
							//mensaje de campos no completados o valores no validos
							bActualizarI.setSelected(true);
							miCoordinador.mensajes("Campos no completados o valores no validos", 0);
		
					}
					}
				}
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		if(e.getSource()==bEliminarI){
			try{
				if(botCanhab){//variable para determinar cuando esta activo el boton cancelar
					//boton cancelar
					miCoordinador.botonCancelarInm();
					recargarPanelInmueble();
				}else
				//boton eliminar
					if(0==miCoordinador.mensajeOpciones("Pregunta", "¿Desea continuar?", 3)){
						miCoordinador.botonEliminarInm(inmuebleEnt);
						recargarPanelInmueble();
					}
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
			
			}
				}
		if(e.getSource()==bRestaurarI){
			try{
				if(0==miCoordinador.mensajeOpciones("Pregunta", "¿Desea continuar?", 3)){
				miCoordinador.botonRestaurarInm(inmuebleEnt);
				recargarPanelInmueble();
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
				}
		if(e.getSource()==bLimpiarCamposI){
			try{ 
				recargarPanelInmueble();
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				//JOptionPane.showMessageDialog(null, 0,
				//		"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
				}
				
		
		
		if(e.getSource()==btnIrAlquileres){
			try{
			CardLayout c= (CardLayout)(contentPane.getLayout());
			c.show(contentPane, "p1");
			this.RecargarPanelAlquiler();
			//cambiar al panel alquileres-
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
			}
				}
				
		
		
				//acciones alquileres
		if(e.getSource()==btnIrInmueble){
			try{
				
				CardLayout c= (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p2");
				checkB.setSelected(false);
				this.recargarPanelInmueble();
		
		
		
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
			}
				}
				
		
		if(e.getSource()==bLimpiar){
			try{
				this.RecargarPanelAlquiler();	
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
				}
		
		
		
		if(e.getSource()==bNuevoAlq){
			try{
				miCoordinador.mostrarVentanaNuevoAlquiler();
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
//				JOptionPane.showMessageDialog(null,"Ocurrio un error con el Boton",
//						, JOptionPane.ERROR_MESSAGE);
			}
			}
				 
		if(e.getSource()==checkB){
			try{ 
				this.LimpiarTablaInmuebles();
				cargarDatosListadoInmueble();
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		if(e.getSource()==radioB4){
			try{
				TableRowSorter<TableModel> Ordena = new TableRowSorter<TableModel>(tableAlq.getModel());
			tableAlq.setRowSorter(Ordena);
//				LimpiarTablaAlquileres();
//			miCoordinador.ListarAlquileres(tableAlq,miCoordinador.listaAlquileresTodos() );
			
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		
		if(e.getSource()==radioB3){
			try{ 
				TableRowSorter<TableModel> Ordena = new TableRowSorter<TableModel>(tableAlq.getModel());
			tableAlq.setRowSorter(Ordena);
			byte a=0;
			Ordena.setRowFilter(RowFilter.regexFilter( Byte.toString(a),1));
			
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		
		if(e.getSource()==radioB2){
			try{ 
				TableRowSorter<TableModel> Ordena = new TableRowSorter<TableModel>(tableAlq.getModel());
			tableAlq.setRowSorter(Ordena);
			byte a=1;
			Ordena.setRowFilter(RowFilter.regexFilter( Byte.toString(a),1));

				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		
		if(e.getSource()==btnBuscarFec){
			try{ 
			if((dateDesde.getDate()!=null)&&(dateHasta.getDate()!=null)&&(dateDesde.getDate().before(dateHasta.getDate()))){
				LimpiarTablaAlquileres();
				radioB4.setSelected(true);
				if(radioFecAc.isSelected())
					miCoordinador.ListarAlquileres(tableAlq,miCoordinador.BusquedaAlquilerXFechaActual(dateDesde.getDate(),dateHasta.getDate()) );
				else if(radioFecRes.isSelected())
					miCoordinador.ListarAlquileres(tableAlq, miCoordinador.BusquedaAlquilerXFechaReserva(dateDesde.getDate(),dateHasta.getDate()));

			}else miCoordinador.mensajes("Tienes que elegir las dos fechas", 0);
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
			
		}
	}
	
	
		 private void AccionesTablaAlquiler(MouseEvent e) {
		int columna = tableAlq.getColumnModel().getColumnIndexAtX(e.getX());
		int fila = e.getY() / tableAlq.getRowHeight();
		
		if (fila < tableAlq.getRowCount() && fila >= 0 && columna < tableAlq.getColumnCount() && columna >= 0) {
			Object value = tableAlq.getValueAt(fila, columna);
			//botones
			if (value instanceof JButton)
			{

				((JButton) value).doClick();
				JButton boton = (JButton) value;
					int nroAlqui = (Integer) tableAlq.getValueAt(fila, 6);				
                    //detalles 
					byte aux=1 		;	
					if (boton.getName().equals("btnDet")){
						
						miCoordinador.mostrarVentanaDetallesAlquiler(nroAlqui);
						}
						
             
		             if (boton.getName().equals("btnEli")){
		            	
		            	 byte a=1;
		            	 if(tableAlq.getValueAt(fila, 0).equals(a)){
			            	if(0==miCoordinador.mensajeOpciones("Sistema Club Avenida Ejercito", "¿Desea Eliminar Alquiler?", 3)){
			            		miCoordinador.eliminarAlquiler(nroAlqui);
			            	}
		            	 }
		             }
								
		             if( (boton.getName().equals("btnMod"))&&(tableAlq.getValueAt(fila, 0).equals(aux))){
		            	 if(0==miCoordinador.mensajeOpciones("Sistema Club Avenida Ejercito", "¿Desea Modificar el Alquiler?", 3))
		            		 miCoordinador.modificarAlquiler(nroAlqui);
		             

		             }
		            	 
		             
		             
		             if ((boton.getName().equals("btnPag"))&&(tableAlq.getValueAt(fila, 0).equals(aux))){
		            	 byte z=0;
		            	 if(tableAlq.getValueAt(fila, 1).equals(z)){
		            		 miCoordinador.pagarAlquiler(nroAlqui);
		            	 
		            	 } 
		             }
             
				}
		}	
	 }		

					

						
					
			
			
			

	 
	
	
	
	/***evento de mouse***/
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}

	
	//TODO evento teclado
	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO revisar si funciona
		if(e.getSource()==tFiltroBusI){
			try{
				TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(tableInm.getModel());
				tableInm.setRowSorter(elQueOrdena);
				elQueOrdena.setRowFilter(RowFilter.regexFilter(tFiltroBusI.getText(),1));

			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error en el filtrado", 0);
			}
		}
		
		if(e.getSource()==tFiltroAlquiler){
			try{
				TableRowSorter<TableModel> Ordena = new TableRowSorter<TableModel>(tableAlq.getModel());
				tableAlq.setRowSorter(Ordena);
				Ordena.setRowFilter(RowFilter.regexFilter(tFiltroAlquiler.getText(),7));
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error en el filtrado", 0);
			}
			
		}
		
		
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource()==texInmDescrip){
			try{
				{if (texInmDescrip.getText().length()>= 300)
				     e.consume();
				}
			
		
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error", 0);
				}
		}
		
		if(e.getSource()==texInmPrecioHora){
			try{
				char tecla=e.getKeyChar();
				if((Character.isDigit(tecla))||(tecla=='\b')||(tecla=='.')){//'\n'
					
					if(texInmPrecioHora.getText().indexOf(".")!=-1){
						int	aux1=texInmPrecioHora.getText().indexOf(".");
						int aux2=texInmPrecioHora.getText().length();
						if(((aux2-1)-aux1)>1)
							e.consume();
						}
				}else{
					getToolkit().beep(); 
					e.consume(); 
					miCoordinador.mensajes("El campo solo admite valores numericos", 0);
//					JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
					}
					
					
				
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error", 0);
				}
		}
	
		if(e.getSource()==texInmSe){
			try{
				char tecla=e.getKeyChar();
				if((Character.isDigit(tecla))||(tecla=='\b')||(tecla=='.')){ //'\n'
					
					if(texInmPrecioHora.getText().indexOf(".")!=-1){
						int	aux1=texInmPrecioHora.getText().indexOf(".");
						int aux2=texInmPrecioHora.getText().length();
							if(((aux2-1)-aux1)>1)
								e.consume();
					}
					
				}else{
					getToolkit().beep(); 
					e.consume();
					miCoordinador.mensajes("El campo solo admite valores numericos", 0);
//					JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
					}
		
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error", 0);
				}
			
			
		}
		
		if(e.getSource()==texInmDireccionNum){
			try{
				char tecla=e.getKeyChar();
				if((Character.isDigit(tecla))||(tecla=='\b')){
					//
				}else{
					getToolkit().beep(); 
					e.consume(); 
					miCoordinador.mensajes("El campo solo admite valores numericos", 0);
				}
				
				
				
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error", 0);
				}
		}
	
	
	}
	



	public void setCoordinador(ControllerCoordinador miCoordinador) {
		
		this.miCoordinador=miCoordinador;
	}
	
	public void ocultarColumnaTable(int numCol,Boolean tabInm){
	if(tabInm){//para tabla inmueble
	tableInm.getTableHeader().getColumnModel().getColumn(numCol).setMaxWidth(0);
	tableInm.getTableHeader().getColumnModel().getColumn(numCol).setMinWidth(0);
	tableInm.getColumnModel().getColumn(numCol).setMaxWidth(0);
	tableInm.getColumnModel().getColumn(numCol).setMinWidth(0);
	//deshabilita el tamaño
	
	tableInm.getColumnModel().getColumn(0).setResizable(false);
	
	}else{//para tabla alquileres
		tableAlq.getTableHeader().getColumnModel().getColumn(numCol).setMaxWidth(0);
		tableAlq.getTableHeader().getColumnModel().getColumn(numCol).setMinWidth(0);
		tableAlq.getColumnModel().getColumn(numCol).setMaxWidth(0);
		tableAlq.getColumnModel().getColumn(numCol).setMinWidth(0);
		
		tableAlq.getColumnModel().getColumn(0).setResizable(false);
		
	}
	}
}



