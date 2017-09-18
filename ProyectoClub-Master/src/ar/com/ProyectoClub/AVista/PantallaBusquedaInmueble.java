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

import org.hibernate.type.NTextType;

import java.awt.Color;

import com.toedter.components.JLocaleChooser;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.MouseAdapter;

public class PantallaBusquedaInmueble extends JDialog implements ActionListener,KeyListener,MouseListener {
	private Integer auxNum;
	
	public JPanel panel;
	public JPanel panel_1;
	public JButton btnOk;
	public JPanel panel_2;
	public JScrollPane jScrollPane1;
	public JTable jtdatos;
	private JTextField txtBusquedaPorNombre;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JCheckBox checkIncluir;
	public JPanel panelDeOpciones;
	public JLabel lblOpcionesDisponibles;
	public JButton btnModificarlo;
	public JButton btnEliminarlo;
	public JButton btnRestaurarlo;
	public JButton btnListar;
	private ControllerCoordinador miCoordinador; 
	public Inmuebles _Inm;
	
	
	

	public PantallaBusquedaInmueble(PantallaAlquiler vtnPantallaAlquiler,boolean b) {
		super(vtnPantallaAlquiler,b);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaBusquedaInmueble.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
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
		lblNewLabel.setBounds(10, 11, 162, 14);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("POR NOMBRE:");
		lblNewLabel_1.setBounds(10, 36, 108, 14);
		panel.add(lblNewLabel_1);
		
		txtBusquedaPorNombre = new JTextField();
		txtBusquedaPorNombre.setBounds(128, 33, 156, 20);
		panel.add(txtBusquedaPorNombre);
		txtBusquedaPorNombre.setColumns(10);
		
		checkIncluir = new JCheckBox("INCLUIR INMUEBLES INABILITADOS");
		/*checkIncluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listado();
			}
		}); */
		checkIncluir.setBounds(6, 62, 257, 23);
		panel.add(checkIncluir);
		
		panelDeOpciones = new JPanel();
		panelDeOpciones.setBackground(Color.LIGHT_GRAY);
		panelDeOpciones.setBorder(UIManager.getBorder("ComboBox.border"));
		panelDeOpciones.setToolTipText("Panel de opciones disponibles ");
		panelDeOpciones.setBounds(330, 0, 265, 142);
		panel.add(panelDeOpciones);
		panelDeOpciones.setLayout(null);
		
		lblOpcionesDisponibles = new JLabel("OPCIONES DISPONIBLES:");
		lblOpcionesDisponibles.setBounds(1, 1, 144, 45);
		panelDeOpciones.add(lblOpcionesDisponibles);
		
		btnModificarlo = new JButton("MODIFICAR");
		btnModificarlo.setBounds(1, 51, 124, 35);
		panelDeOpciones.add(btnModificarlo);
		
		btnEliminarlo = new JButton("ELIMINAR");
		btnEliminarlo.setBounds(131, 51, 124, 35);
		panelDeOpciones.add(btnEliminarlo);
		
		btnRestaurarlo = new JButton("RESTAURAR");
		btnRestaurarlo.setBounds(1, 97, 124, 35);
		panelDeOpciones.add(btnRestaurarlo);
		
		btnListar = new JButton("BUSCAR/LISTAR");
		btnListar.setBounds(10, 108, 143, 23);
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
			},
			new String[] {
				"Numero", "Nombre", "Precio por hora", "Direccion"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
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
    	/*
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
    	*/
    	jtdatos.addMouseListener(new MouseAdapter(){
    	public void mouseClicked(MouseEvent e){
    		Integer _fila;
    		auxNum=null;
    		try{
    			_fila=jtdatos.getSelectedRow();
    			if(_fila!= -1){
    				DefaultTableModel modelotabla=(DefaultTableModel) jtdatos.getModel();
    				auxNum=(Integer) modelotabla.getValueAt(_fila, 0);
    			}
    		}catch(Exception ex){
    			JOptionPane.showMessageDialog(null, "Error: Al seleccionar una fila \nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);
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
			limpiar();
			listado();
		}
		
	}
	
private void listado(){
	
	if(checkIncluir.isSelected()){
	}
	
	
	miCoordinador.listarInmuebles(jtdatos,txtBusquedaPorNombre.getText(),checkIncluir.isSelected());
}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

public void limpiar(){
	 DefaultTableModel dm = (DefaultTableModel) jtdatos.getModel();
	 int rowCount = dm.getRowCount();
	 for (int i = rowCount - 1; i >= 0; i--) {
	     dm.removeRow(i);
	 }
	 jtdatos.setModel(dm);
	// txtBusquedaPorNombre.setText("");
	//  checkIncluir.setSelected(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnModificarlo){
			try{
			 if(auxNum.equals(null)){
				JOptionPane.showMessageDialog(null, 0,
				"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
				}else{
					Inmuebles inmu= miCoordinador.BuscarInmueble(auxNum);
					if(inmu.isHabilitado()==true){
					miCoordinador.mostrarVentanaModificarInmueble(inmu);
					}else{
						JOptionPane.showMessageDialog(null, "El Inmueble esta deshabilitado",
								"No se puede Modificar", JOptionPane.INFORMATION_MESSAGE);
					}
					}
					
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, 0,
						"Ocurrio un error con el Boton", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()==btnEliminarlo){
			try{
				 if(auxNum.equals(null)){
					JOptionPane.showMessageDialog(null, 0,
					"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
					}else{
						Inmuebles inmu= miCoordinador.BuscarInmueble(auxNum);
						if(inmu.isHabilitado()==true){
						miCoordinador.mostrarVentanaEliminarInmuelble(inmu);
						}else{
							JOptionPane.showMessageDialog(null, "El Inmueble esta deshabilitado",
									"No se puede Eliminar", JOptionPane.INFORMATION_MESSAGE);
						}
					}
						
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Ocurrio un error con el Boton" ,
							"Error", JOptionPane.ERROR_MESSAGE);
				}	
		}
		
		if(e.getSource()==btnRestaurarlo){
			try{
				 if(auxNum.equals(null)){
					JOptionPane.showMessageDialog(null, 0,
					"No se selecciono ninguna fila" , JOptionPane.ERROR_MESSAGE);
					}else{
						Inmuebles inmu= miCoordinador.BuscarInmueble(auxNum);
						if(inmu.isHabilitado()==false){
						
						miCoordinador.mostrarVentanaRehabilitarInmueble(inmu);
						}else{
							JOptionPane.showMessageDialog(null, "El Inmueble esta habilitado",
									"No se puede Rehabilitar", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
						
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Ocurrio un error con el Boton" ,
							"Error", JOptionPane.ERROR_MESSAGE);
				}	
						
		}
		try{
			if(e.getSource()==btnOk){
				limpiar();
				this.dispose();
			}
		if(e.getSource()==btnListar){
			limpiar();
			listado();
		}
		}catch(Exception ext){
			JOptionPane.showMessageDialog(null, 0,
					"Ocurrio un Error...Reintente" , JOptionPane.ERROR_MESSAGE);
		}
	
		
	}
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
}
