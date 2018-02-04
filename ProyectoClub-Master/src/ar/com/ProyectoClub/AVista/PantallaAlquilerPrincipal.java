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
	public JLabel lblNewLabel_3;
	public ButtonGroup bg;
	public JRadioButton radioB4;
	public JRadioButton radioB2;
	public JRadioButton radioB3;
	public JButton bNuevoAlq;
	public JButton bLimpiar;
	public JButton btnBuscarFec;
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
		
		// CardLayout de p1 == panel alquileres  // p2==panel inmuebles 
		//agregados dentro de contentPanel
		
		btnIrInmueble = new JButton("Ir a Inmuebles");
		btnIrInmueble.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIrInmueble.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIrInmueble.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/gohome_action_ir_102351.png")));
		
		
		panelOpcionesAlquileres = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelOpcionesAlquileres.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelOpcionesAlquileres.setBackground(Color.LIGHT_GRAY);
		
		panelBusquedaFiltro = new JPanel();
		panelBusquedaFiltro.setBackground(Color.LIGHT_GRAY);
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
						.addGroup(gl_panelAlquileres.createSequentialGroup()
							.addComponent(panelOpcionesAlquileres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 518, Short.MAX_VALUE)
							.addComponent(btnIrInmueble))
						.addComponent(panelTablaAlq, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelAlquileres.setVerticalGroup(
			gl_panelAlquileres.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlquileres.createSequentialGroup()
					.addGroup(gl_panelAlquileres.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAlquileres.createSequentialGroup()
							.addGap(21)
							.addComponent(btnIrInmueble))
						.addGroup(gl_panelAlquileres.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelOpcionesAlquileres, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBusquedaFiltro, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTablaAlq, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addGap(28))
		);
		panelTablaAlq.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panelTablaAlq.add(scrollPane_1, BorderLayout.CENTER);
		
		tableAlq = new JTable();
		tableAlq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAlq.setAutoCreateRowSorter(true);
		tableAlq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		tableAlq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableAlq.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Habilitado", "Pagado", "", "", "", "", "Nro de Alquiler", "Persona", "Inmueble", "Fecha de reserva", "Monto", "Fecha de Emicion"
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
		tFiltroAlquiler.setToolTipText("Buscar por Nombre o Apellido del cliente");
		tFiltroAlquiler.setColumns(10);
		
		labBusqued = new JLabel("BUSCAR EN EL LISTADO:");
		
		labelFecha = new JLabel("BUSCAR ENTRE LAS FECHAS");
		
		dateDesde = new JDateChooser();
		dateDesde.getCalendarButton().setToolTipText("DESDE");
		dateDesde.setToolTipText("DESDE");
		
		lblNewLabel_1 = new JLabel("Y");
		lblNewLabel_1.setVisible(false);
		
		dateHasta = new JDateChooser();
		dateHasta.setToolTipText("HASTA");
		dateHasta.getCalendarButton().setToolTipText("HASTA");
		
		lblNewLabel_2 = new JLabel("");
		
		//
		
		
		lblNewLabel_3 = new JLabel("TIPO DE BUSQUEDA:");
		
		radioB4 = new JRadioButton("TODOS LOS ALQUILERES");
		
		radioB2 = new JRadioButton("SOLO ALQUILERES PAGADOS");
		
		radioB3 = new JRadioButton("SOLO ALQUILERES SE\u00D1ADOS");
		
		bg =new ButtonGroup();
		bg.add(radioB4);
		bg.add(radioB2);
		bg.add(radioB3);
		radioB4.setSelected(true);
		
		btnBuscarFec = new JButton("");
		btnBuscarFec.setToolTipText("BUSCAR POR FECHAS");
		btnBuscarFec.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscaF1.png")));
		
		
		
		GroupLayout gl_panelBusquedaFiltro = new GroupLayout(panelBusquedaFiltro);
		gl_panelBusquedaFiltro.setHorizontalGroup(
			gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
					.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
						.addComponent(labBusqued)
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addComponent(tFiltroAlquiler, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
									.addComponent(dateDesde, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(dateHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(labelFecha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscarFec)))
					.addGap(53)
					.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
							.addGap(264))
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radioB4)
							.addGap(18)
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
								.addComponent(radioB3)
								.addComponent(radioB2))
							.addGap(165))))
		);
		gl_panelBusquedaFiltro.setVerticalGroup(
			gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.BASELINE)
						.addComponent(labBusqued)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.BASELINE)
								.addComponent(tFiltroAlquiler, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
									.addGap(18)
									.addComponent(labelFecha)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(dateHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(dateDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnBuscarFec))))
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.BASELINE)
								.addComponent(radioB2)
								.addComponent(radioB4))
							.addGap(18)
							.addComponent(radioB3)))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		panelBusquedaFiltro.setLayout(gl_panelBusquedaFiltro);
		panelAlquileres.setLayout(gl_panelAlquileres);
		
		panelOpcionesAlquileres.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"OPCIONES DE ALQUILERES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));//para agregar titulo en el recuadro de un panel
		
		bNuevoAlq = new JButton("NUEVO ALQUILER");
		bNuevoAlq.setHorizontalTextPosition(SwingConstants.CENTER);
		bNuevoAlq.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoAlquiler1.png")));
		bNuevoAlq.setVerticalTextPosition(SwingConstants.BOTTOM);
		panelOpcionesAlquileres.add(bNuevoAlq);
		
		bLimpiar = new JButton("LIMPIAR CAMPOS");
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
		panelFiltro.setBackground(Color.LIGHT_GRAY);
		panelFiltro.setLayout(null);
		panelFiltro.setBorder(UIManager.getBorder("ComboBox.border"));
	
		panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"FILTROS DE BUSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		
		panelTablaInm = new JPanel();
		panelTablaInm.setBorder(UIManager.getBorder("ComboBox.border"));
		panelTablaInm.setLayout(new BorderLayout(0, 0));
		
		panelRegInm = new JPanel();
		panelRegInm.setBackground(Color.LIGHT_GRAY);
		panelRegInm.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"REGISTRO/ DETALLES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		btnIrAlquileres = new JButton("Ir a Alquileres");
		btnIrAlquileres.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIrAlquileres.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIrAlquileres.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoSalida32x32.png")));

		
		panelOpcionInm = new JPanel();
		panelOpcionInm.setToolTipText("Panel de opciones disponibles ");
		panelOpcionInm.setBorder(UIManager.getBorder("ComboBox.border"));
		panelOpcionInm.setBackground(Color.LIGHT_GRAY);
		panelOpcionInm.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelOpcionInm.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
				"OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
	javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
		
		
		bRegistrarI = new JToggleButton("Registrar");
		bRegistrarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/Newsupport.png")));
		bRegistrarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bRegistrarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bRegistrarI);
		
		bActualizarI = new JToggleButton("Modificar");
		bActualizarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/actualizar.png")));
		bActualizarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bActualizarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bActualizarI);
		
		bEliminarI = new JButton("Eliminar");
		bEliminarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/borrarT1.png")));
		bEliminarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bEliminarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bEliminarI);
		
		bRestaurarI = new JButton("Restaurar");
		bRestaurarI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/borrar1.png")));
		bRestaurarI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bRestaurarI.setHorizontalTextPosition(SwingConstants.CENTER);
		panelOpcionInm.add(bRestaurarI);
		
		GroupLayout gl_panelInmuebles = new GroupLayout(panelInmuebles);
		gl_panelInmuebles.setHorizontalGroup(
			gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInmuebles.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTablaInm, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addGap(2)
							.addComponent(panelRegInm, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIrAlquileres, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addComponent(panelOpcionInm, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelFiltro, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelInmuebles.setVerticalGroup(
			gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInmuebles.createSequentialGroup()
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addGap(19)
							.addComponent(btnIrAlquileres))
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelRegInm, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addGap(0)
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(panelOpcionInm, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addGap(5)
							.addComponent(panelFiltro, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelTablaInm, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
		);
		
		scrollPane = new JScrollPane();
		panelTablaInm.add(scrollPane, BorderLayout.CENTER);
		
		tableInm = new JTable();
		tableInm.setAutoCreateRowSorter(true);
		//da estilo a las filas y a la cabecera
		tableInm.getTableHeader()
				.setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		tableInm.setDefaultRenderer(Object.class,
				new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());// garilla intercalada

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
		){
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Float.class, Float.class, Object.class
				};
			public boolean isCellEditable(int row, int column){
				return false;
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
		texInmNombre.setBounds(new Rectangle(0, 0, 180, 32));
		texInmNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent tec) {
		//TODO
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
		texInmNombre.setBackground(new Color(70, 130, 180));
//		texInmNombre.
		
		lDireccionI = new JLabel("DIRECCIÓN");
		
		texInmDireccion = new JCTextField();
		texInmDireccion.setToolTipText("Dirección del inmueble");
		texInmDireccion.setColumns(10);
		texInmDireccion.setBackground(new Color(70, 130, 180));
		
		lPrecioHoraI = new JLabel("PRECIO POR HORA");
		
		lSeI = new JLabel("SE\u00D1A");
		
		texInmPrecioHora = new JCTextField();
		texInmPrecioHora.setToolTipText("Precio por hora que que cuesta \n alquilar este inmueble");
		texInmPrecioHora.setColumns(10);
		texInmPrecioHora.setBackground(new Color(70, 130, 180));
		
		
		texInmSe = new JCTextField();
		texInmSe.setToolTipText("en caso de no tener seña \n dejar vacio ");
		texInmSe.setColumns(10);
		texInmSe.setBackground(new Color(70, 130, 180));
		
		lDescripcionI = new JLabel("DESCRIPCION");
		
		/*
				scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 568, 271, 113);
		getContentPane().add(scrollPane);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setLineWrap(true);
		scrollPane.setViewportView(txtObservaciones);

		*/
		
		texInmDireccionNum = new JTextField();
		texInmDireccionNum.setColumns(2);
		texInmDireccionNum.setToolTipText("Numero de la direccion");
		texInmDireccionNum.setBackground(new Color(70, 130, 180));
		
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
								.addComponent(lDireccionI, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmDireccion, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelRegInm.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
								.addGroup(gl_panelRegInm.createSequentialGroup()
									.addComponent(texInmDireccionNum, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
									.addGap(6))))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(lNombreI, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
							.addGap(124))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(texInmNombre, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
							.addGap(18)))
					.addGap(0)
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addComponent(lPrecioHoraI)
						.addGroup(gl_panelRegInm.createParallelGroup(Alignment.TRAILING)
							.addComponent(lSeI, Alignment.LEADING)
							.addComponent(texInmPrecioHora, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
							.addComponent(texInmSe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addComponent(lDescripcionI)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelRegInm.setVerticalGroup(
			gl_panelRegInm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRegInm.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
						.addComponent(lNombreI)
						.addComponent(lPrecioHoraI)
						.addComponent(lDescripcionI))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(texInmNombre, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmPrecioHora, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
					.addContainerGap())
		);
		
		
		texInmDescrip = new  JTextArea();
		scrollPane_2.setViewportView(texInmDescrip);
		texInmDescrip.setLineWrap(true);
		texInmDescrip.setBackground(new Color(70, 130, 180));
		texInmDescrip.setAutoscrolls(true);
		texInmSe.setNextFocusableComponent(texInmDescrip);
		panelRegInm.setLayout(gl_panelRegInm);
		new app.bolivia.swing.JCTextField();
		
		tFiltroBusI = new app.bolivia.swing.JCTextField();
		tFiltroBusI.setSelectionColor(Color.LIGHT_GRAY);
		tFiltroBusI.setForeground(Color.WHITE);
		tFiltroBusI.setFont(new Font("Arial", tFiltroBusI.getFont().getStyle() & ~Font.ITALIC | Font.BOLD, tFiltroBusI.getFont().getSize()));
		tFiltroBusI.setPhColor(Color.BLACK);
		tFiltroBusI.setPlaceholder("BUSCAR");
		tFiltroBusI.setBackground(new Color(70, 130, 180));
		//tFiltroBusI.setText();
		tFiltroBusI.setToolTipText("Filtra la Tabla por Nombre");
		tFiltroBusI.setBorder(UIManager.getBorder("Button.border"));
		tFiltroBusI.setBounds(10, 23, 238, 40);
		panelFiltro.add(tFiltroBusI);
		tFiltroBusI.setColumns(10);
		
		checkB = new JCheckBox("incluir Inmuebles Inactivos");
		checkB.setFont(new Font("Tahoma", Font.PLAIN, 11));

		checkB.setBounds(10, 70, 174, 23);
		
		panelFiltro.add(checkB);
		
		
	
		bLimpiarCamposI = new JButton("Limpiar Campos");
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
		
		// acciones b inmueble
		bRegistrarI.addActionListener(this);
		bActualizarI.addActionListener(this);
		bEliminarI.addActionListener(this);
		bRestaurarI.addActionListener(this);
		bLimpiarCamposI.addActionListener(this);
		
		btnIrAlquileres.addActionListener(this);
		tFiltroBusI.addKeyListener(this);
		
			
		//acciones alquileres
		btnIrInmueble.addActionListener(this);
		checkB.addActionListener(this);
		bLimpiar.addActionListener(this);
		bNuevoAlq.addActionListener(this);
		radioB4.addActionListener(this);
		radioB2.addActionListener(this);
		radioB3.addActionListener(this);
		tFiltroAlquiler.addKeyListener(this);
		btnBuscarFec.addActionListener(this);
		
		
		
	//	bRegistrarI.disable();
		bActualizarI.setEnabled(false);
		bEliminarI.setEnabled(false);
		bRestaurarI.setEnabled(true);
	//	bLimpiarCamposI.disable();
		auxNum=null;
		
		
		java.util.List<Alquiler> listaAlquiler3= new ArrayList<Alquiler>();
		
		
		tableInm.addMouseListener(
				new MouseAdapter(){
    		//para selecionar una fila
    		public void mouseClicked(MouseEvent e){ 
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
    			JOptionPane.showMessageDialog(null, "Error: Al seleccionar una fila \nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
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
								LimpiarTablaInmuebles();
								cargarDatosListadoInmueble();
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
								LimpiarTablaInmuebles();
								cargarDatosListadoInmueble();
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
					LimpiarTablaInmuebles();
					cargarDatosListadoInmueble();
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
				this.recargarPanelInmueble();
				
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
			
			//cambiar al panel alquileres-
			//funcion de recargar pagina!!
				
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
			try{LimpiarTablaAlquileres();
			miCoordinador.ListarAlquileres(tableAlq, miCoordinador.listaAlquileresTodos());
			dateDesde.setDate(null);
			dateHasta.setDate(null);
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
				}
		
		
		
		if(e.getSource()==bNuevoAlq){
			try{
				miCoordinador.mostrarVentanaNuevoAlquiler();
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
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
				LimpiarTablaAlquileres();
			miCoordinador.ListarAlquileres(tableAlq,miCoordinador.listaAlquileresTodos() );
			
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		
		if(e.getSource()==radioB3){
			try{ LimpiarTablaAlquileres();
			miCoordinador.ListarAlquileres(tableAlq,miCoordinador.listaAlquileresSeñados());
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		
		if(e.getSource()==radioB2){
			try{ LimpiarTablaAlquileres();
			miCoordinador.ListarAlquileres(tableAlq,miCoordinador.listaAlquileresPagados());
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
		}
		
		if(e.getSource()==btnBuscarFec){
			try{ 
				
				
				
			if((dateDesde.getDate()!=null)&&(dateHasta.getDate()!=null)){
				LimpiarTablaAlquileres();
				miCoordinador.ListarAlquileres(tableAlq,miCoordinador.BusquedaAlquilerXFechaActual(dateDesde.getDate(),dateHasta.getDate()) );

			}else miCoordinador.mensajes("Tienes que elegir las dos fechas", 0);
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
				}
			
		}
		
		
		
		
		
	}
	
	
	//TODO  genera  faltan fun botones
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
		            	
		            	 byte a=1;//TODO funcion anda comparacion
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
					//	 if (JOptionPane.showConfirmDialog(this, "¿Desea inhabilitar la persona", "Sistema Club Avenida Ejercito", JOptionPane.YES_NO_OPTION, 0,
					//			new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) 
					

						
					
			
			
			

	 
	
	
	
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

	
	/***evento teclado***/
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
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
	public void keyTyped(KeyEvent arg0) {
	
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



