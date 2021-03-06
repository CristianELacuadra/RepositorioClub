package ar.com.ProyectoClub.AVista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class PantallaControlMorosos extends JFrame implements KeyListener{

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaDeudores;
    public ButtonGroup GrupoSNS;
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
	private JTextField txtDni;
	
	public PantallaControlMorosos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaControlMorosos.class.getResource("/ar/com/ProyectoClub/AVista/icon/iconoPaloma.png")));
		initComponents();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				limpiaCampos();
				// miCoordinador.mostrarVentanaPrincipal();
			}
		});
		
		tablaDeudores.getTableHeader().setDefaultRenderer(new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaHeader());
		//tablaDeudores.setDefaultRenderer(Object.class, new ar.com.ProyectoClub.AVista.EstiloVentanas.EstiloTablaRenderer());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	

	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDeudores = new javax.swing.JTable();
       
        GrupoSNS=new ButtonGroup();

        setTitle("REGISTRO MOROSOS-DEUDORES");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaDeudores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRICULA","DNI", "NOMBRE", "APELLIDO", "TELEFONO", "DOMICILIO", "CATEGORIA" , "FECHA INGRESO", "ESTADO","FECHA ULTIMO MOVIMIENTO","CANTIDAD MES ATRASO","IMPORTE TOTAL",
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false,false,false,false,false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDeudores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tablaDeudores);
        
        txtDni = new JTextField();
        txtDni.setColumns(10);
        txtDni.addKeyListener(this);
        
        
        JLabel lblBuscarPorApellido = new JLabel("BUSCAR:");
        lblBuscarPorApellido.setToolTipText("Escribe la palabra a buscar en la grilla");
        lblBuscarPorApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		miCoordinador.Filtro(txtDni.getText().toUpperCase(), tablaDeudores);
        	}
        });
        btnNewButton.setIcon(new ImageIcon(PantallaControlMorosos.class.getResource("/ar/com/ProyectoClub/AVista/icon/buscar-lupa-simbolo-de-interfaz.png")));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(18)
        			.addComponent(lblBuscarPorApellido)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnNewButton)
        			.addGap(804))
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1393, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(23)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblBuscarPorApellido, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnNewButton))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1393, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 803, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
	 }
	
	public void setMiCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
	
	 private void limpiaCampos() {
		 txtDni.setText(null);
		 this.LimpiarTabla();
	}
	 
	 private void LimpiarTabla(){
		 miCoordinador.Filtro("", tablaDeudores);
//		 DefaultTableModel tb = (DefaultTableModel) tablaDeudores.getModel();
//		 int a = tablaDeudores.getRowCount()-1;
//		 for (int i = a; i >= 0; i--) {           
//			 tb.removeRow(tb.getRowCount()-1);
//		 } 
	 }


	@Override
	public void keyPressed(KeyEvent e) {
	}


	@Override
	public void keyReleased(KeyEvent e) {
		miCoordinador.Filtro(txtDni.getText().toUpperCase(), tablaDeudores);
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
