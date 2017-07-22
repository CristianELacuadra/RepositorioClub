package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;
import ar.com.ProyectoClub.CModelo.CEntidades.Inmuebles;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Color;

import com.toedter.components.JLocaleChooser;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;

public class PantallaBusquedaInmueble extends JDialog implements ActionListener,KeyListener,MouseListener {
	private Object auxNum;
	
	public JPanel panel;
	public JPanel panel_1;
	public JButton btnOk;
	public JPanel panel_2;
	public JScrollPane jScrollPane1;
	public JTable jtdatos;
	private JTextField txtBusquedaPorNombre;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JCheckBox check;
	public JPanel panelDeOpciones;
	public JLabel lblOpcionesDisponibles;
	public JButton btnModificarlo;
	public JButton btnEliminarlo;
	public JButton btnRestaurarlo;
	public JButton btnListar;
	private ControllerCoordinador miCoordinador; 
	
	
	

	public PantallaBusquedaInmueble(PantallaAlquiler vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaBusquedaInmueble.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		setResizable(false);
		setBounds(100, 100, 601, 423);
		initComponents();
		setTitle("Busqueda de Inmuebles");
			
	}

	
	
	public void initComponents(){
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 0, 595, 142);
		panel.setBorder(UIManager.getBorder("ComboBox.border"));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("FILTROS DE BUSQUEDA:");
		lblNewLabel.setBounds(10, 11, 127, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("POR NOMBRE:");
		lblNewLabel_1.setBounds(10, 36, 70, 14);
		panel.add(lblNewLabel_1);
		
		txtBusquedaPorNombre = new JTextField();
		txtBusquedaPorNombre.setBounds(90, 33, 156, 20);
		panel.add(txtBusquedaPorNombre);
		txtBusquedaPorNombre.setColumns(10);
		
		check = new JCheckBox("INCLUIR INMUEBLES INABILITADOS");
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listado();
			}
		});
		check.setBounds(6, 62, 199, 23);
		panel.add(check);
		
		panelDeOpciones = new JPanel();
		panelDeOpciones.setBackground(Color.LIGHT_GRAY);
		panelDeOpciones.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDeOpciones.setToolTipText("Panel de opciones disponibles ");
		panelDeOpciones.setBounds(330, 0, 265, 142);
		panel.add(panelDeOpciones);
		panelDeOpciones.setLayout(null);
		
		lblOpcionesDisponibles = new JLabel("OPCIONES DISPONIBLES:");
		lblOpcionesDisponibles.setBounds(1, 1, 124, 45);
		panelDeOpciones.add(lblOpcionesDisponibles);
		
		btnModificarlo = new JButton("MODIFICARLO");
		btnModificarlo.setBounds(1, 51, 124, 35);
		panelDeOpciones.add(btnModificarlo);
		
		btnEliminarlo = new JButton("ELIMINARLO");
		btnEliminarlo.setBounds(131, 51, 124, 35);
		panelDeOpciones.add(btnEliminarlo);
		
		btnRestaurarlo = new JButton("RESTAURARLO");
		btnRestaurarlo.setBounds(1, 97, 124, 35);
		panelDeOpciones.add(btnRestaurarlo);
		
		btnListar = new JButton("BUSCAR/LISTAR");
		btnListar.setBounds(10, 108, 122, 23);
		panel.add(btnListar);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 141, 595, 219);
		panel_1.setBorder(UIManager.getBorder("ComboBox.border"));
		getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 360, 595, 35);
		panel_2.setBorder(UIManager.getBorder("ComboBox.border"));
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_2);
		
		btnOk = new JButton("OK");
		panel_2.add(btnOk);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		jScrollPane1 = new JScrollPane();
		panel_1.add(jScrollPane1);
		
		jtdatos= new JTable();
		jtdatos.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		
		jScrollPane1.setColumnHeaderView(jtdatos);
		jtdatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Numero", "Nombre", "Precio por hora", "Direccion"
			}
		));
		jtdatos.getColumnModel().getColumn(0).setPreferredWidth(54);
		jtdatos.getColumnModel().getColumn(2).setPreferredWidth(88);
		jtdatos.getColumnModel().getColumn(3).setPreferredWidth(110);
		jtdatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtdatos);
        
        
		 
        btnOk.addActionListener(this); 
        btnModificarlo.addActionListener(this);
    	btnEliminarlo.addActionListener(this);
    	btnRestaurarlo.addActionListener(this);
    	btnListar.addActionListener(this);
    	
    	
    	jtdatos.addMouseListener(new MouseAdapter(){
    		
    		public void mouseClicked(MouseEvent e) {
    		if(e.getSource()==jtdatos){
    			jtdatos.setRowSelectionAllowed(true);// selecciona una fila
    			auxNum = jtdatos.getValueAt(e.getY()/jtdatos.getRowHeight(),0);
    		//guarda en variable auxiliar el numero de inmueble
    		}
    		
    		}
    			
    	});
	
	
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
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
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			listado();
		}
		
	}
	
private void listado(){
	if(check.isSelected()){
	}
	if(txtBusquedaPorNombre.getText().isEmpty()){
	}
	
	miCoordinador.listarInmuebles(jtdatos,txtBusquedaPorNombre.getText(),check.isSelected());
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
		if(e.getSource()==btnOk){
			miCoordinador
		}
		
		if(e.getSource()==btnModificarlo){
			if(auxNum.equals(null)){
				JOptionPane.showMessageDialog(null, 0,
				"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
				}else{
					miCoordinador.mostrarVentanaModificarInmueble();
				}
					
			
		}
		
		if(e.getSource()==btnEliminarlo){
			
			if(auxNum.equals(null)){
				JOptionPane.showMessageDialog(null, 0,
				"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
				} else{
					miCoordinador.mostrarVentanaEliminarInmuelble();
				}
			
		}
		
		if(e.getSource()==btnRestaurarlo){
			if(auxNum.equals(null)){
				JOptionPane.showMessageDialog(null, 0,
				"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
				}else{
					miCoordinador.mostrarVentanaRehabilitarInmueble();
				}
			
			
		}
		
		if(e.getSource()==btnListar){
			listado();
		}
		}catch(Exception ext){
			JOptionPane.showMessageDialog(null, 0,
					"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
		}
	
		
	}
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
}
