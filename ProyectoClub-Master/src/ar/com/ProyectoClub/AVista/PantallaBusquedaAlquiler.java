package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Alquiler;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;

import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class PantallaBusquedaAlquiler extends JDialog implements ActionListener,KeyListener,MouseListener {
	private ControllerCoordinador miCoordinador; 
	public  JTextField txtBusquedaPorDni;
	public  JTextField txtBusquedaPorNombre;
	public  JTextField txtBusquedaPorNombreInmuble;
	public  JTable table;
	public Alquiler alqui;
    public Integer auxAlq;
	
	public JButton btnBuscar;
	public JButton btnModificar;
	public  JButton btnPagarUnAlquiler;
	public  JButton btnEliminarUnAlquiler;
	public  JButton btnLimpiar;
	public  JCheckBox checkAlquileresPagados;
	public  JCheckBox checkAlquileresEliminados;
	public  JButton btnVolver;

	
	
	public PantallaBusquedaAlquiler(PantallaAlquiler vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaBusquedaAlquiler.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setResizable(false);
		setBounds(100, 100, 651, 538);
		initComponents();
		
		
	}
	
	public void initComponents(){
		setTitle("Busqueda de Alquileres");
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("RadioButton.border"));
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(0, 0, 645, 176);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filtros de Busqueda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 128, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setBounds(33, 36, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtBusquedaPorDni = new JTextField();
		txtBusquedaPorDni.setBounds(89, 33, 120, 20);
		panel.add(txtBusquedaPorDni);
		txtBusquedaPorDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CLIENTE:");
		lblNewLabel_2.setBounds(259, 36, 45, 14);
		panel.add(lblNewLabel_2);
		
		txtBusquedaPorNombre = new JTextField();
		txtBusquedaPorNombre.setBounds(314, 33, 120, 20);
		panel.add(txtBusquedaPorNombre);
		txtBusquedaPorNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NOMBRE DEL INMUEBLE:");
		lblNewLabel_3.setBounds(10, 67, 148, 14);
		panel.add(lblNewLabel_3);
		
		txtBusquedaPorNombreInmuble = new JTextField();
		txtBusquedaPorNombreInmuble.setBounds(168, 64, 110, 20);
		panel.add(txtBusquedaPorNombreInmuble);
		txtBusquedaPorNombreInmuble.setColumns(10);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(319, 97, 115, 23);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(444, 32, 191, 137);
		panel.add(panel_1);
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBorder(UIManager.getBorder("Spinner.border"));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("OPCIONES PARA LOS ALQUILERES");
		lblNewLabel_4.setBounds(10, 11, 171, 14);
		panel_1.add(lblNewLabel_4);
		
		btnModificar = new JButton("MODIFICAR FECHA");
		btnModificar.setToolTipText("Modificar fecha de reserva");
		btnModificar.setBounds(10, 36, 171, 23);
		panel_1.add(btnModificar);
		
		btnPagarUnAlquiler = new JButton("PAGAR ALQUILER");
		btnPagarUnAlquiler.setBounds(10, 70, 171, 23);
		panel_1.add(btnPagarUnAlquiler);
		
		btnEliminarUnAlquiler = new JButton("ELIMINAR ALQUILER");
		btnEliminarUnAlquiler.setBounds(10, 104, 171, 23);
		panel_1.add(btnEliminarUnAlquiler);
		
		checkAlquileresPagados = new JCheckBox("Incluir alquileres pagados");
		checkAlquileresPagados.setBounds(10, 97, 148, 23);
		panel.add(checkAlquileresPagados);
		
		checkAlquileresEliminados = new JCheckBox("Incluir alquileres eliminados");
		checkAlquileresEliminados.setBounds(10, 123, 155, 23);
		panel.add(checkAlquileresEliminados);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBounds(319, 131, 115, 23);
		panel.add(btnLimpiar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 176, 645, 296);
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nro de Alquiler", "Persona", "Inmueble", "Fecha de reserva", "Hora de reserva", "Cant. horas", "Alquiler Pagado", "Fecha de emisi\u00F3n", "Hora de emisi\u00F3n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		table.getColumnModel().getColumn(6).setPreferredWidth(87);
		table.getColumnModel().getColumn(7).setPreferredWidth(96);
		table.getColumnModel().getColumn(8).setPreferredWidth(97);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				Integer aux;
				try{
					aux=table.getSelectedRow();
					if(aux!=-1){
						DefaultTableModel modelotabla=(DefaultTableModel) table.getModel();
						auxAlq=(Integer) modelotabla.getValueAt(aux, 0);
						//alqui=miCoordinador.BuscarAlquiler(auxAlq);
										
					}
										
				}catch (HeadlessException ex){

		             JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);

		       }     
			}
			
		});
		
		

		
		
		
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(505, 476, 89, 23);
		getContentPane().add(btnVolver);
		
	//	alqui=miCoordinador.CrearAlquiler();
		
		btnBuscar.addActionListener(this);
		 btnModificar.addActionListener(this);
		btnPagarUnAlquiler.addActionListener(this);
		 btnEliminarUnAlquiler.addActionListener(this);
		 btnLimpiar.addActionListener(this);
		 btnVolver.addActionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()==btnBuscar ){
				
			}
			if(e.getSource()==btnModificar){
				miCoordinador.mostrarVentanaModificarAlquiler();
			}
			
			if(e.getSource()==btnPagarUnAlquiler){
							miCoordinador.mostrarVentanaPagarAlquiler();
						}
			if(e.getSource()==btnEliminarUnAlquiler){
				miCoordinador.mostrarVentanaEliminaralquiler();
			}
			if(e.getSource()==btnLimpiar){
				limpiar();
			}
			if(e.getSource()==btnVolver){
				this.limpiar();
				this.dispose();
			}
			 
			
			 
			 
			 
			
			
			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	private void limpiar() {
		
		
	}

	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
