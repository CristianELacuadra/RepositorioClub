package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class PantallaCaja extends JFrame implements  ActionListener,KeyListener {

	private JPanel contentPane;
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	public JTextField txtBuscador;
	public static JTable jtdatos;
	public JTextField txtSubTotal;
	public JCheckBox chcEgresos;
	public JButton btnBuscar;
	public JCheckBox chckIngresos;
	public JLabel lblBuscarPorDescripcion;
	public JButton btnIngresos;
	public JDateChooser dateDesde;
	public JDateChooser dateHasta;
	public JButton btnLimpiar;
	
	public PantallaCaja(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\icoCaja.png"));
	//	setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCaja.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setTitle("Club Avenida ejercito- Control de Ingresos y de Egresos");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {			
			@Override
			public void windowClosing(WindowEvent e) {
				Limpiar();
			}
		});
		initComponents();
		//jtdatos.getTableHeader().setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		//jtdatos.setDefaultRenderer(Object.class, new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
	}
	private void initComponents() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Panel = new JPanel();
		Panel.setBackground(Color.GRAY);
		Panel.setBounds(0, 0, 1362, 156);
		contentPane.add(Panel);
		Panel.setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setIcon(new ImageIcon(PantallaCaja.class.getResource("/ar/com/ProyectoClub/AVista/icon/lupa-para-buscar.png")));
		//btnBuscar.setIcon(new ImageIcon(PantallaCaja.class.getResource("/ar/com/ProyectoClub/AVista/icon/Search.png")));
		btnBuscar.setBounds(808, 22, 115, 33);
		Panel.add(btnBuscar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 88, 487, 68);
		Panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblmmaaaa = new JLabel("(dd/mm/aaaa)");
		lblmmaaaa.setForeground(SystemColor.desktop);
		lblmmaaaa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblmmaaaa.setBounds(149, 43, 92, 14);
		panel_2.add(lblmmaaaa);
		
		JLabel lblddmmaaaa = new JLabel("(dd/mm/aaaa)");
		lblddmmaaaa.setForeground(Color.BLACK);
		lblddmmaaaa.setFont(new Font("Arial", Font.PLAIN, 12));
		lblddmmaaaa.setBounds(390, 43, 87, 14);
		panel_2.add(lblddmmaaaa);
		
		dateDesde= new JDateChooser();
		dateDesde.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dateDesde.setToolTipText("Seleccione Mes y A\u00F1o");
		dateDesde.setBounds(10, 43, 129, 20);
		panel_2.add(dateDesde);
		//dateDesde.setDateFormatString("MMM-yyyy");
		
		dateHasta= new JDateChooser();
		dateHasta.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dateHasta.setToolTipText("Seleccione Mes y A\u00F1o");
		//dateHasta.setDateFormatString("MMM-yyyy");
		dateHasta.setBounds(251, 43, 129, 20);
		panel_2.add(dateHasta);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicio");
		lblNewLabel_1.setFont(lblNewLabel_1.getFont().deriveFont(lblNewLabel_1.getFont().getStyle() | Font.ITALIC));
		lblNewLabel_1.setBounds(28, 12, 87, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setFont(lblFechaFin.getFont().deriveFont(lblFechaFin.getFont().getStyle() | Font.ITALIC));
		lblFechaFin.setBounds(280, 12, 87, 14);
		panel_2.add(lblFechaFin);
		
		JLabel lblNewLabel = new JLabel("Filtrando Fecha");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(20, 66, 128, 14);
		Panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(540, 116, 238, 33);
		Panel.add(panel_3);
		panel_3.setLayout(null);
		
		chcEgresos = new JCheckBox("Egresos");
		chcEgresos.setBackground(Color.LIGHT_GRAY);
		chcEgresos.setBounds(6, 7, 97, 23);
		panel_3.add(chcEgresos);
		chcEgresos.setFont(new Font("Arial", Font.PLAIN, 14));
		
		chckIngresos = new JCheckBox("Ingresos");
		chckIngresos.setBackground(Color.LIGHT_GRAY);
		chckIngresos.setBounds(105, 7, 97, 23);
		panel_3.add(chckIngresos);
		chckIngresos.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblSeleccioneIngresosegresis = new JLabel("Seleccione Ingresos\\Egresos");
		lblSeleccioneIngresosegresis.setForeground(Color.WHITE);
		lblSeleccioneIngresosegresis.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSeleccioneIngresosegresis.setBounds(563, 91, 189, 14);
		Panel.add(lblSeleccioneIngresosegresis);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 11, 788, 44);
		Panel.add(panel_4);
		panel_4.setLayout(null);
		
		txtBuscador = new JTextField();
		txtBuscador.setBackground(new Color(250, 250, 210));
		txtBuscador.setBounds(170, 12, 425, 20);
		panel_4.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		lblBuscarPorDescripcion = new JLabel("Buscar por Descripcion");
		lblBuscarPorDescripcion.setForeground(new Color(0, 0, 0));
		lblBuscarPorDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBuscarPorDescripcion.setBounds(10, 14, 150, 14);
		panel_4.add(lblBuscarPorDescripcion);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setIcon(new ImageIcon(PantallaCaja.class.getResource("/ar/com/ProyectoClub/AVista/icon/escoba-de-limpieza-para-suelos.png")));
		//btnLimpiar.setIcon(new ImageIcon(PantallaCaja.class.getResource("/ar/com/ProyectoClub/AVista/icon/limpiar.png")));
		btnLimpiar.setBounds(1237, 116, 115, 33);
		Panel.add(btnLimpiar);
		
		btnIngresos= new JButton();
		btnIngresos.setToolTipText("Formulario Ingresos o Egreso");
		btnIngresos.setBounds(1087, 116, 128, 33);
		Panel.add(btnIngresos);
		btnIngresos.setIcon(new ImageIcon(PantallaCaja.class.getResource("/ar/com/ProyectoClub/AVista/icon/icoingreso.png")));
		btnIngresos.setText("Registrar");
		btnIngresos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnIngresos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnIngresos.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 156, 1362, 522);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		jtdatos= new JTable();
		scrollPane.setColumnHeaderView(jtdatos);
		jtdatos.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "FECHA", "DESCRIPCION","TIPO","IMPORTE",
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false,
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return false;
	            }
	        });
		jtdatos.getTableHeader().setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		//jtdatos.setDefaultRenderer(Object.class, new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
		jtdatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtdatos.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(jtdatos);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(10);
		txtSubTotal.setBackground(new Color(255, 215, 0));
		txtSubTotal.setBounds(1214, 680, 148, 20);
		contentPane.add(txtSubTotal);
		
		JLabel lblSubtotal = new JLabel("Sub-Total");
		lblSubtotal.setFont(lblSubtotal.getFont().deriveFont(lblSubtotal.getFont().getStyle() | Font.BOLD | Font.ITALIC));
		lblSubtotal.setBounds(1132, 682, 72, 16);
		contentPane.add(lblSubtotal);
		
		btnBuscar.addActionListener(this);
		btnLimpiar.addActionListener(this);
		txtBuscador.addKeyListener(this);
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		try{
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				this.ValidarEntradas();
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	private boolean ValidarDescripcion(){
		if(txtBuscador.getText().isEmpty())
			return true;
		else
			return false;
	}
	private boolean ValidarEntradasIngrEgre(){
		//solo se selecciono Egresos
		if(chcEgresos.isSelected() && !chckIngresos.isSelected()){
			return true;
		}
		if(!chcEgresos.isSelected() && chckIngresos.isSelected()){
			return true;
		}

		if(chcEgresos.isSelected() && chckIngresos.isSelected()){
			return true;
		}

		if(!chcEgresos.isSelected() && !chckIngresos.isSelected()){
			JOptionPane.showMessageDialog(null,"Ingreso o Egreso no esta seleccionado,Por Favor Seleccione una o ambas","Informacion",JOptionPane.INFORMATION_MESSAGE);
			this.LimpiarTabla();
			txtSubTotal.setText(null);
		}
		return false;
	}
	private boolean ValidarEntradaFechas(){
		if(dateDesde.getDate()!=null && dateHasta.getDate() != null){
			if(dateDesde.getDate().compareTo(dateHasta.getDate())!=1)
				return true;
			else{
				JOptionPane.showMessageDialog(null,"Fecha de busqueda Desde no puede ser mayor a la fecha de busqueda Hasta  ","Informacion",JOptionPane.INFORMATION_MESSAGE);
				dateDesde.setDate(null);
				dateHasta.setDate(null);
				this.LimpiarTabla();
				txtSubTotal.setText(null);
			}
		}
		else{
			if(dateDesde.getDate()==null && dateHasta.getDate() == null)
				return true;
			else
				throw new RuntimeException("El sistema no reconoco la fecha ingresada");
		}
		return false;
		
	}
	
	public void LimpiarTabla(){
		DefaultTableModel tb = (DefaultTableModel) jtdatos.getModel();
		int a = jtdatos.getRowCount()-1;
		for (int i = a; i >= 0; i--) {           
			tb.removeRow(tb.getRowCount()-1);
		} 
	}
	
	private void ValidarEntradas(){
		Date cmbFechaDes=new Date();
		Date cmbFechaHas=new Date();
		String descripcion=new String();
		boolean Ingreso,Egreso;
		if(ValidarEntradasIngrEgre()){
			Ingreso=chckIngresos.isSelected();
			Egreso=chcEgresos.isSelected();
			if(ValidarEntradaFechas()){
				//toma la fecha como parametro
				cmbFechaDes=dateDesde.getDate();
				cmbFechaHas=dateHasta.getDate();
				if(!ValidarDescripcion())
					descripcion=txtBuscador.getText();				
				miCoordinador.BuscarCajaParametros(cmbFechaDes,cmbFechaHas, descripcion, Ingreso, Egreso,jtdatos);
			}
		}


	}
	private void Limpiar(){
		DefaultTableModel modelo=(DefaultTableModel) jtdatos.getModel();
		int filas=jtdatos.getRowCount();
		for (int i = 0;i<filas; i++) {
		modelo.removeRow(0);
		}
		txtBuscador.setText(null);
		dateDesde.setDate(null);
		dateHasta.setDate(null);
		chcEgresos.setSelected(true);
		chckIngresos.setSelected(true);
		txtSubTotal.setText(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnBuscar)
				ValidarEntradas();
			
			if(e.getSource()==btnIngresos)
				miCoordinador.MostrarVentanaIngresoEgreso();			
			
			if(e.getSource() == btnLimpiar){
				this.Limpiar();			
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
