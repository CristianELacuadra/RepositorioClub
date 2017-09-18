package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Personas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import javax.swing.JRadioButton;

public class PantallaBusquedaSNS extends JDialog implements ActionListener,KeyListener,MouseListener{
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private Integer Tempdni=null;
	public JPanel contentPane;
	public JPanel panel;
	public JButton btnBuscar;
	public JTextField txtDni;
	public JTextField txtNom;
	public JTable jtdatos;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblApe;
	public JTextField txtApe;
	public RowsRenderer resaltado;
	public JCheckBox chcIncluidos;
	public JButton btnSeleccionar; 
	public JRadioButton rdbSocio; 
	
	public PantallaBusquedaSNS(javax.swing.JDialog ventana,boolean b) {  
		super(ventana,b);
		initComponents();
	}
	public PantallaBusquedaSNS() {  
		initComponents();
	}
	
	public void initComponents () {
		setTitle("Busqueda Persona");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaBusquedaSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
		contentPane = new JPanel();
		panel = new JPanel();
		resaltado= new RowsRenderer(6);
		btnSeleccionar= new JButton();
		btnSeleccionar.setEnabled(false);
		rdbSocio= new JRadioButton("Socios");
		
		setBounds(100, 100, 717, 445);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(0, 0, 708, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(492, 58, 206, 53);
		panel.add(panel_2);
		panel_2.setLayout(null);
		btnBuscar = new JButton();
		btnBuscar.setBounds(151, 11, 45, 39);
		panel_2.add(btnBuscar);
		chcIncluidos = new JCheckBox();
		
		//btnBuscar.setIcon(new ImageIcon(PantallaBusquedaSNS.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscar2.png")));
		
		chcIncluidos.setText("Incluir inhabilitados");
		chcIncluidos.setBounds(16, 27, 128, 23);
		panel_2.add(chcIncluidos);
		
		
		rdbSocio.setBounds(16, 7, 109, 23);
		rdbSocio.setSelected(true);
		panel_2.add(rdbSocio);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 0, 416, 111);
		panel.add(panel_3);
		panel_3.setLayout(null);
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char numero=e.getKeyChar(); 
				if(Character.isLetter(numero)) { 
					getToolkit().beep(); 
					e.consume(); 
					JOptionPane.showMessageDialog(null,"El campo solo admite valores numericos","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		txtDni.setBounds(136, 11, 213, 20);
		panel_3.add(txtDni);
		txtDni.setColumns(10);
		txtNom = new JTextField();
		txtNom.setBounds(136, 42, 213, 20);
		panel_3.add(txtNom);
		txtNom.setColumns(10);
		txtApe = new JTextField();
		
		txtApe.setBounds(136, 73, 213, 20);
		panel_3.add(txtApe);
		
		
		txtApe.setColumns(10);
		lblDni= new JLabel();
		lblDni.setBounds(33, 11, 37, 20);
		panel_3.add(lblDni);
		
		lblDni.setText("DNI");
		lblApe = new JLabel();
		lblApe.setBounds(20, 73, 69, 20);
		panel_3.add(lblApe);
		
		lblApe.setText("APELLIDO");
		lblNombre = new JLabel();
		lblNombre.setBounds(20, 42, 106, 20);
		panel_3.add(lblNombre);
		
		//Se pone a escuchar
		lblNombre.setText("NOMBRE");
		txtApe.addKeyListener(this);
		txtNom.addKeyListener(this);
		txtDni.addKeyListener(this);
		chcIncluidos.addKeyListener(this);
		//jtdatos.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnSeleccionar.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 110, 708, 244);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane jScrollPane1 = new JScrollPane();
		panel_1.add(jScrollPane1);
		
		jtdatos= new JTable();
		jtdatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int columna=jtdatos.getColumnModel().getColumnIndexAtX(e.getX());
				int fila=e.getY()/jtdatos.getRowHeight();
				
				if(fila< jtdatos.getRowCount() && fila >=0 && columna< jtdatos.getColumnCount() && columna >=0){
					Object value=jtdatos.getValueAt(fila, columna);
					Object value2=jtdatos.getValueAt(fila, 2);
					Tempdni=(Integer)value2;//Mantengo en una varible global el dni para ser dado de baja
					if(value instanceof JButton){
						Integer dni=(Integer)jtdatos.getValueAt(fila,2);
						((JButton)value).doClick();
						JButton btn=(JButton) value;
						//Tempdni=dni;
						miCoordinador.MostrarVentanaDetallesInhabilitar(dni);
						//System.out.println(dni);
					}
				}
			}
		});
		jScrollPane1.setColumnHeaderView(jtdatos);
		jtdatos.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "DNI", "APELLIDOS", "NOMBRES" ,
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false,
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return false;
	            }
	        });
		jtdatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtdatos);
        
        
        btnSeleccionar.setText("OK");
        //btnSeleccionar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\apply.png"));
        btnSeleccionar.setBounds(589, 360, 102, 35);
        contentPane.add(btnSeleccionar);
        
       
	}
	
	public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
    //eventos del teclado
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			this.VerificarEntrada();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    // actionperformed
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()== btnBuscar){
				this.VerificarEntrada();
			}
			if(e.getSource()==btnSeleccionar){
				Personas persona=miCoordinador.BuscarPersona(Tempdni);
				miCoordinador.CargarDatosPersona(persona);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null,ex.toString(),"Club Avenida Ejercito - ¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void VerificarEntrada(){
		String dni=new String();
		String nom=new String();
		String ape=new String();
		if(!txtDni.getText().isEmpty())
			dni=txtDni.getText();
		if(!txtApe.getText().isEmpty())
			ape=txtApe.getText();
		if(!txtNom.getText().isEmpty())
			nom=txtNom.getText();
		//miCoordinador.Listar(jtdatos,nom,ape,dni,rdbSocio.isSelected());
	}
    //eventos del mouse
	@Override
	public void mouseClicked(MouseEvent e) {
		/*
		int columna=jtdatos.getColumnModel().getColumnIndexAtX(e.getX());
		int fila=e.getY()/jtdatos.getRowHeight();
		
		if(fila< jtdatos.getRowCount() && fila >=0 && columna< jtdatos.getRowCount() && columna >=0){
			Object value=jtdatos.getValueAt(fila, columna);
			if(value instanceof JButton){
				((JButton)value).doClick();
				JButton btn=(JButton) value;
			}
		}
		*/
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
}
