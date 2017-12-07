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

import javax.swing.table.DefaultTableCellRenderer;

public class PantallaAlquilerPrincipal extends JFrame implements ActionListener,KeyListener,MouseListener{
	private ControllerCoordinador miCoordinador; 
	private JPanel contentPane;
	public app.bolivia.swing.JCTextField tFiltroBusI;
	public JTable tableAlq;
	public JTable tableInm;
	public JTextField textField_1;
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
	public JDateChooser dateChooser;
	public JLabel lblNewLabel_1;
	public JDateChooser dateChooser_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public ButtonGroup bg;
	public JRadioButton radioB4;
	public JRadioButton radioB2;
	public JRadioButton radioB3;
	public JButton bNuevoAlq;
	public JButton bLimpiar;
	
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
	public JTextPane texInmDescrip;
	public JLabel lblNewLabel;
	public JCheckBox checkB;
	public JButton bLimpiarCamposI;
	public boolean botCanhab=false;
	public static RowsRende rest;
	
	/**
	 * Create the frame.
	 */
	public PantallaAlquilerPrincipal() {
		setMinimumSize(new Dimension(880, 600));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		setTitle("ALQUILERES/INMUEBLES");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
			}
		});
		initComponents();
		RecargarPanelAlquiler();
	
	}
	
	public void initComponents(){
		miCoordinador=new ControllerCoordinador();
		setBounds(100, 100, 821, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelAlquileres = new JPanel();
		panelAlquileres.setBackground(Color.WHITE);
		contentPane.add(panelAlquileres, "p1"); 
		
		// CardLayout de p1 == panel alquileres  // p2==panel inmuebles 
		//agregados dentro de contentPanel
		
		btnIrInmueble = new JButton("Ir a Inmuebles");
		btnIrInmueble.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnIrInmueble.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIrInmueble.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/gohome_action_ir_102351.png")));
		btnIrInmueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c= (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p2"); // funcion de los botones para pasar de un panel a otro
			}
		});
		
		panelOpcionesAlquileres = new JPanel();
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
					.addGroup(gl_panelAlquileres.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBusquedaFiltro, GroupLayout.PREFERRED_SIZE, 844, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panelAlquileres.createSequentialGroup()
							.addComponent(panelOpcionesAlquileres, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnIrInmueble))
						.addComponent(panelTablaAlq, GroupLayout.PREFERRED_SIZE, 844, GroupLayout.PREFERRED_SIZE))
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
		tableAlq.setAutoCreateRowSorter(true);
		tableAlq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableAlq.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAlq.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Habilitado", "", "", "", "", "Nro de Alquiler", "Apellido Cliente", "Nombre Cliente", "Nombre Inmueble", "Fecha de emisi\u00F3n", "Fecha de reserva", "Cant. horas", "Monto Faltante", "Alquiler Pagado"
			}
		) {
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tableAlq.getColumnModel().getColumn(0).setResizable(false);
		tableAlq.getColumnModel().getColumn(5).setPreferredWidth(70);
		tableAlq.getColumnModel().getColumn(5).setMinWidth(30);
		tableAlq.getColumnModel().getColumn(6).setPreferredWidth(89);
		tableAlq.getColumnModel().getColumn(6).setMinWidth(30);
		tableAlq.getColumnModel().getColumn(7).setPreferredWidth(96);
		tableAlq.getColumnModel().getColumn(8).setPreferredWidth(120);
		tableAlq.getColumnModel().getColumn(8).setMinWidth(60);
		tableAlq.getColumnModel().getColumn(9).setPreferredWidth(96);
		tableAlq.getColumnModel().getColumn(10).setPreferredWidth(99);
				
		tableAlq.getTableHeader()
		.setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		tableAlq.setDefaultRenderer(Object.class,
		new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
		
		
		tableAlq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AccionesTabla(e);
			}
		});
		//tableAlq.getColumnModel().getColumn(13).setPreferredWidth(87);
		this.ocultarColumnaTable(13, false);
		this.ocultarColumnaTable(0, false);
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
		btnMod.setToolTipText("Observar detalles");
		btnMod.setText("");
		btnMod.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/modific1.png")));
		
		//Pag
		btnPag = new JButton();
		btnPag.setName("btnPag");
		btnPag.setToolTipText("Observar detalles");
		btnPag.setText("");
		btnPag.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/precioL.png")));
		
				
		//Eli		
		btnEli = new JButton();
		btnEli.setName("btnEli");
		btnEli.setToolTipText("Observar detalles");
		btnEli.setText("");
		btnEli.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/cancel1.png")));
		
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Buscar por Nombre o Apellido del cliente; Nombre del Inmueble alquilado; Fecha de reserva");
		textField_1.setColumns(10);
		
		labBusqued = new JLabel("BUSCAR EN EL LISTADO:");
		
		labelFecha = new JLabel("BUSCAR ENTRE LAS FECHAS");
		labelFecha.setVisible(false);
		
		dateChooser = new JDateChooser();
		dateChooser.setVisible(false);
		dateChooser.getCalendarButton().setToolTipText("DESDE");
		dateChooser.setToolTipText("DESDE");
		
		lblNewLabel_1 = new JLabel("Y");
		lblNewLabel_1.setVisible(false);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setVisible(false);
		dateChooser_1.getCalendarButton().setToolTipText("HASTA");
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		//
		
		
		lblNewLabel_3 = new JLabel("TIPO DE BUSQUEDA:");
		
		radioB4 = new JRadioButton("TODOS LOS ALQUILERES");
		
		radioB2 = new JRadioButton("SOLO ALQUILERES PAGADOS");
		
		radioB3 = new JRadioButton("SOLO ALQUILERES SE\u00D1ADOS");
		
		bg =new ButtonGroup();
		bg.add(radioB4);
		bg.add(radioB2);
		bg.add(radioB3);
		
		
		
		GroupLayout gl_panelBusquedaFiltro = new GroupLayout(panelBusquedaFiltro);
		gl_panelBusquedaFiltro.setHorizontalGroup(
			gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
					.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
						.addComponent(labBusqued)
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2))
						.addComponent(labelFecha)
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(28)
					.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(264))
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
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
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addComponent(labelFecha)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelBusquedaFiltro.createSequentialGroup()
							.addGroup(gl_panelBusquedaFiltro.createParallelGroup(Alignment.BASELINE)
								.addComponent(radioB4)
								.addComponent(radioB2))
							.addGap(18)
							.addComponent(radioB3)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		
		bLimpiar = new JButton("RESTABLECER BUSQUEDA");
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
						.addComponent(panelTablaInm, GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addComponent(panelRegInm, GroupLayout.PREFERRED_SIZE, 732, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(btnIrAlquileres, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addComponent(panelOpcionInm, GroupLayout.PREFERRED_SIZE, 573, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelFiltro, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelInmuebles.setVerticalGroup(
			gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInmuebles.createSequentialGroup()
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelRegInm, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelInmuebles.createSequentialGroup()
							.addGap(20)
							.addComponent(btnIrAlquileres)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelInmuebles.createParallelGroup(Alignment.BASELINE)
						.addComponent(panelOpcionInm, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelFiltro, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelTablaInm, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
				{null, null, null, null, null},
				{null, null, null, null, null},
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
		);/*{
			
			
			
		}*/
		
			/*
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			}
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}*/
		
		tableInm.getColumnModel().getColumn(0).setPreferredWidth(80);
		tableInm.getColumnModel().getColumn(0).setMinWidth(80);
		tableInm.getColumnModel().getColumn(1).setPreferredWidth(81);
		tableInm.getColumnModel().getColumn(1).setMinWidth(80);
		tableInm.getColumnModel().getColumn(2).setPreferredWidth(84);
		tableInm.getColumnModel().getColumn(2).setMinWidth(80);
		tableInm.getColumnModel().getColumn(3).setPreferredWidth(71);
		tableInm.getColumnModel().getColumn(3).setMinWidth(70);
		tableInm.getTableHeader().setReorderingAllowed(false);
		RowsRende rr= new RowsRende(4);
		tableInm.setDefaultRenderer(Object.class, rr);
		scrollPane.setViewportView(tableInm);
		this.ocultarColumnaTable(4, true); // oculta columna Habilitado
		
		
		lNombreI = new JLabel("NOMBRE DEL INMUEBLE");
		lNombreI.setToolTipText("ej: cancha de futbol");
		
		texInmNombre = new JCTextField();
		texInmNombre.setToolTipText("Filtra la Tabla por Nombre");
		texInmNombre.setColumns(10);
		texInmNombre.setBorder(UIManager.getBorder("Button.border"));
		texInmNombre.setBackground(new Color(70, 130, 180));
		
		lDireccionI = new JLabel("DIRECCION");
		
		texInmDireccion = new JCTextField();
		texInmDireccion.setToolTipText("Filtra la Tabla por Nombre");
		texInmDireccion.setColumns(10);
		texInmDireccion.setBorder(UIManager.getBorder("Button.border"));
		texInmDireccion.setBackground(new Color(70, 130, 180));
		
		lPrecioHoraI = new JLabel("PRECIO POR HORA");
		
		lSeI = new JLabel("SE\u00D1A");
		
		texInmPrecioHora = new JCTextField();
		texInmPrecioHora.setToolTipText("Filtra la Tabla por Nombre");
		texInmPrecioHora.setColumns(10);
		texInmPrecioHora.setBorder(UIManager.getBorder("Button.border"));
		texInmPrecioHora.setBackground(new Color(70, 130, 180));
		
		texInmSe = new JCTextField();
		texInmSe.setToolTipText("Filtra la Tabla por Nombre");
		texInmSe.setColumns(10);
		texInmSe.setBorder(UIManager.getBorder("Button.border"));
		texInmSe.setBackground(new Color(70, 130, 180));
		
		lDescripcionI = new JLabel("DESCRIPCION");
		
		texInmDescrip = new JTextPane();
		texInmDescrip.setBackground(new Color(70, 130, 180));
		GroupLayout gl_panelRegInm = new GroupLayout(panelRegInm);
		gl_panelRegInm.setHorizontalGroup(
			gl_panelRegInm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelRegInm.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lDireccionI, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addComponent(texInmDireccion, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addComponent(texInmNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lNombreI, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addComponent(lPrecioHoraI)
							.addGap(126)
							.addComponent(lDescripcionI))
						.addGroup(gl_panelRegInm.createSequentialGroup()
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelRegInm.createParallelGroup(Alignment.TRAILING)
									.addComponent(texInmPrecioHora, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
									.addComponent(texInmSe, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
								.addComponent(lSeI))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(texInmDescrip, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
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
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
								.addComponent(texInmNombre, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmPrecioHora, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelRegInm.createSequentialGroup()
									.addGap(18)
									.addComponent(lDireccionI)
									.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
								.addGroup(gl_panelRegInm.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lSeI)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panelRegInm.createParallelGroup(Alignment.BASELINE)
								.addComponent(texInmDireccion, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(texInmSe, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addComponent(texInmDescrip, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelRegInm.setLayout(gl_panelRegInm);
		new app.bolivia.swing.JCTextField();
		
	//	tableInm.setRowHeight(25);
		
		//tableAlq.setRowHeight(25);
		 
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		lblNewLabel.setBounds(219, 30, 29, 33);
		panelFiltro.add(lblNewLabel);
		
		tFiltroBusI = new app.bolivia.swing.JCTextField();
		tFiltroBusI.setPlaceholder("BUSCAR");
		tFiltroBusI.setBackground(new Color(70, 130, 180));
		//tFiltroBusI.setText();
		tFiltroBusI.setToolTipText("Filtra la Tabla por Nombre");
		tFiltroBusI.setBorder(UIManager.getBorder("Button.border"));
		tFiltroBusI.setBounds(10, 23, 238, 40);
		panelFiltro.add(tFiltroBusI);
		tFiltroBusI.setColumns(10);
		
		checkB = new JCheckBox("incluir Inmuebles Inactivos");
		checkB.setBounds(10, 85, 151, 23);
		panelFiltro.add(checkB);
		
		
	///	PromptSupport.setPrompt("Escriba aqui", textField);
		
	//	 TextPrompt placeholder = new TextPrompt("Nombre Inmueble", tFiltroBusI);
		
		bLimpiarCamposI = new JButton("Limpiar Campos");
		bLimpiarCamposI.setHorizontalTextPosition(SwingConstants.CENTER);
		bLimpiarCamposI.setVerticalTextPosition(SwingConstants.BOTTOM);
		bLimpiarCamposI.setIcon(new ImageIcon(PantallaAlquilerPrincipal.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png")));
		panelOpcionInm.add(bLimpiarCamposI);
		
		panelInmuebles.setLayout(gl_panelInmuebles);
		
	//	inmuebleEnt=miCoordinador.CrearInmueble();
	//	alquilerEnt=miCoordinador.CrearAlquiler();
		// acciones b inmueble
		bRegistrarI.addActionListener(this);
		bActualizarI.addActionListener(this);
		bEliminarI.addActionListener(this);
		bRestaurarI.addActionListener(this);
		bLimpiarCamposI.addActionListener(this);
		
		btnIrAlquileres.addActionListener(this);
		tFiltroBusI.addKeyListener(this);
		
		
		/*		btnIrAlquileres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c= (CardLayout)(contentPane.getLayout());
				c.show(contentPane, "p1");
			}
		});
		*/
		
		
		
		
		
		
		//acciones alquileres
		btnIrInmueble.addActionListener(this);
		checkB.addActionListener(this);
		bLimpiar.addActionListener(this);
		bNuevoAlq.addActionListener(this);
		
	//	bRegistrarI.disable();
		bActualizarI.setEnabled(false);
		bEliminarI.setEnabled(false);
		bRestaurarI.setEnabled(false);
	//	bLimpiarCamposI.disable();
		auxNum=null;
		
		

		tableInm.addMouseListener(new MouseAdapter(){
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
    	
    	
    	});
    	
    	
}



		
	public void cargarDatosInmueble(){
		
		inmuebleEnt.setNombre(texInmNombre.getText());
		inmuebleEnt.setPreciohora(Float.parseFloat(texInmPrecioHora.getText())  );//convertir a float
		inmuebleEnt.setSenial(Float.parseFloat(texInmSe.getText()));//convertir a float
		// (Integer.parseInt(textCantidadHoras.getText().toString()));
		inmuebleEnt.setDireccion(texInmDireccion.getText());
		inmuebleEnt.setDescripcion(texInmDescrip.getText());
		checkB.setSelected(false);
		//inmuebleEnt.setAlquilers(alquilers);   que es esto?
	}
	
	public void cargarDatosInmueble(Inmuebles aux){
		if(!aux.equals(null)){
		inmuebleEnt=aux;
		texInmNombre.setText(aux.getNombre());
		texInmDireccion.setText(aux.getDireccion());
		texInmPrecioHora.setText(Float.toString(aux.getPreciohora()));
		texInmSe.setText(Float.toString(aux.getSenial()));
		texInmDescrip.setText(aux.getDescripcion());
		}else{//sirve tambien para limpiar el panel
			texInmNombre.setText(null);
			texInmDireccion.setText(null);
			texInmPrecioHora.setText(null);
			texInmSe.setText(null);
			texInmDescrip.setText(null);
			
			
		}
	}
	public void LimpiarTablaAlquileres(){
		try{
		DefaultTableModel dm = (DefaultTableModel) tableAlq.getModel();
		 int rowCount = dm.getRowCount();
		 for (int i = rowCount - 1; i >= 0; i--) {
		     dm.removeRow(i);
		 }
		 tableAlq.setModel(dm);
		 
		}catch(Exception ex){
			miCoordinador.mensajes("Error de Limpieza de datos", 0);
		}
		 
	}
	public void RecargarPanelAlquiler(){
		try{
			LimpiarTablaAlquileres();
			miCoordinador.ListarAlquileres(tableAlq);
			
			
			
			
		}catch(Exception ex){
			miCoordinador.mensajes("Error al recargar la pagina", 0);
		}
	}
	
	
	public void recargarPanelInmueble(){//para cargar las funciones por defecto del panel inmueble
		try{ 
		DefaultTableModel dm = (DefaultTableModel) tableInm.getModel();
		 int rowCount = dm.getRowCount();
		 for (int i = rowCount - 1; i >= 0; i--) {
		     dm.removeRow(i);
		 }
		 tableInm.setModel(dm);//es necesario?

		 inmuebleEnt=null;
		 miCoordinador.panelRegInmDesHabilitar();
		cargarDatosInmueble(inmuebleEnt);
		cargarDatosListadoInmueble();
		miCoordinador.botonCancelarDeshabilitarInm();
		miCoordinador.deshabilitarBotonesInm();
		bRegistrarI.setSelected(false);
		bActualizarI.setSelected(false);
		botCanhab=false;
		}catch(Exception ex){
			miCoordinador.mensajes("Error al recargar la pagina", 0);
		}
		
	}
	
	public void cargarDatosListadoInmueble(){// se activa en eventos de recarga de pagina, filtro  y checkB
		 miCoordinador.ListarInmuebles(tableInm, checkB.isSelected());
	//revisar funcion tFiltroBusI
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
					this.cargarDatosInmueble();
					if(miCoordinador.validarPanelRegInm(inmuebleEnt)){
						if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "¿Estas seguro que deseas guardar?",3)){
							//cuadro de mensaje de advertencio con opciones YES/NO
							inmuebleEnt.setIdInmubles(null);
							miCoordinador.RegistrarInmueble(inmuebleEnt);	
								miCoordinador.mensajes("Se Guardo correctamente", 1);//mensaje se guardo correctamente
								miCoordinador.panelRegInmDesHabilitar();
								bRegistrarI.setText("Registrar");
								miCoordinador.botonCancelarDeshabilitarInm();
						}
					}else{
						//mensaje de campos no completados o valores no validos
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
					this.cargarDatosInmueble();
					if(miCoordinador.validarPanelRegInm(inmuebleEnt)&&(inmuebleEnt.getIdInmubles().equals(auxNum))){
						if(0==miCoordinador.mensajeOpciones("¿Pregunta?", "¿Estas seguro que deseas guardar?",3)){
							//cuadro de mensaje de advertencio con opciones YES/NO
								miCoordinador.RegistrarInmueble(inmuebleEnt);	
								miCoordinador.mensajes("Se Guardo correctamente", 1);//mensaje se guardo correctamente
								miCoordinador.panelRegInmDesHabilitar();
								bActualizarI.setText("Registrar");
								miCoordinador.botonCancelarDeshabilitarInm();
						}
					}else{
						//mensaje de campos no completados o valores no validos
						miCoordinador.mensajes("Campos no completados o valores no validos", 0);
		
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
				}else
				//boton eliminar
					if(0==miCoordinador.mensajeOpciones("Pregunta", "¿Desea continuar?", 3)){
					miCoordinador.botonEliminarInm(inmuebleEnt);
					}
				
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
			
			}
				}
		if(e.getSource()==bRestaurarI){
			try{
				if(0==miCoordinador.mensajeOpciones("Pregunta", "¿Desea continuar?", 3)){
				miCoordinador.botonRestaurarInm(inmuebleEnt);
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
		this.recargarPanelInmueble();
		
		
		
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
			}
				}
				
		
		if(e.getSource()==bLimpiar){
try{
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
				}
		
		
		
		if(e.getSource()==bNuevoAlq){
try{
				
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
			}
				 
		if(e.getSource()==checkB){
			//
try{ miCoordinador.ListarInmuebles(tableInm, checkB.isSelected());
	//cargarDatosListadoInmueble();
			}catch(Exception ex){
				miCoordinador.mensajes("Ocurrio un error con el Boton", 0);
			
			}
			
		}
		
		
	}
	
	
	
	 private void AccionesTabla(MouseEvent e) {
		 
	 
		int columna = tableAlq.getColumnModel().getColumnIndexAtX(e.getX());
		int fila = e.getY() / tableAlq.getRowHeight();
		
		if (fila < tableAlq.getRowCount() && fila >= 0 && columna < tableAlq.getColumnCount() && columna >= 0) {
			Object value = tableAlq.getValueAt(fila, columna);
			//botones
			if (value instanceof JButton)
			{

				((JButton) value).doClick();
				JButton boton = (JButton) value;
					int nroAlqui = (Integer) tableAlq.getValueAt(fila, 5);				
                    //detalles 
                      			
					if (boton.getName().equals("btnDet")){
						
						miCoordinador.mostrarVentanaNuevoAlquiler(nroAlqui);
						}
						
             
		             if (boton.getName().equals("btnEli")){
		            	 
		            	 if(tableAlq.getValueAt(fila, 0).equals(true)){
			            	if(0==miCoordinador.mensajeOpciones("Sistema Club Avenida Ejercito", "¿Desea Eliminar Alquiler?", 3)){
			            		miCoordinador.eliminarAlquiler(nroAlqui);
			            	}
		            	 }
		             }
								
		             if( (boton.getName().equals("btnMod"))&&(tableAlq.getValueAt(fila, 0).equals(true))){
		            	 miCoordinador.modificarAlquiler(nroAlqui);
		             
		             
		             
		             }
		            	 
		             
		             
		             if ((boton.getName().equals("btnPag"))&&(tableAlq.getValueAt(fila, 0).equals(true))){
		            	 if((float)tableAlq.getValueAt(fila, 12)!=0){
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	/***evento teclado***/
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tFiltroBusI){
			try{
				TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(tableInm.getModel());
				tableInm.setRowSorter(elQueOrdena);
				elQueOrdena.setRowFilter(RowFilter.regexFilter(tFiltroBusI.getText(),1));
				
				
						}catch(Exception ex){
							miCoordinador.mensajes("Ocurrio un error en el filtrado", 0);
			}
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	



	public void setCoordinador(ControllerCoordinador miCoordinador) {
		// TODO Auto-generated method stub
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



