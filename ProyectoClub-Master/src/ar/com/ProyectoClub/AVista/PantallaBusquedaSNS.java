package ar.com.ProyectoClub.AVista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.ProyectoClub.BControlador.ControllerCoordinador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class PantallaBusquedaSNS extends JDialog implements ActionListener,KeyListener{
	
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
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
	
	public PantallaBusquedaSNS(PantallaPersonas vtnPantallaPersona,boolean b) {  
		super(vtnPantallaPersona,b);
		setTitle("Busqueda Persona");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\logo.png"));
		initComponents();
	}
	
	public void initComponents () {
		contentPane = new JPanel();
		panel = new JPanel();
		resaltado= new RowsRenderer(3);
		
		
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
		
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\buscar2.png"));
		
		chcIncluidos.setText("Incluir inhabilitados");
		chcIncluidos.setBounds(16, 20, 128, 23);
		panel_2.add(chcIncluidos);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 0, 416, 111);
		panel.add(panel_3);
		panel_3.setLayout(null);
		txtDni = new JTextField();
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
		
		lblNombre.setText("NOMBRE");
		txtApe.addKeyListener(this);
		txtNom.addKeyListener(this);
		txtDni.addKeyListener(this);
		chcIncluidos.addKeyListener(this);
		
		//Se pone a escuchar
		btnBuscar.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 110, 708, 301);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane jScrollPane1 = new JScrollPane();
		panel_1.add(jScrollPane1);
		
		jtdatos= new JTable();
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
	                return canEdit [columnIndex];
	            }
	        });
		jtdatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtdatos);
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
		if(e.getSource()== btnBuscar){
			this.VerificarEntrada();
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
		miCoordinador.Listar(jtdatos,nom,ape,dni);
	}
}
