package ar.com.ProyectoClub.AVista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class PantallaControlCuotas extends JInternalFrame {

	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    //tabla
    public static javax.swing.JTable tablaCategoria;
    public static JButton btnEditar;
    public static RowsRenderer resaltado;
    int id;

	
	public PantallaControlCuotas() {
		setFrameIcon(new ImageIcon(PantallaControlCuotas.class.getResource("/ar/com/ProyectoClub/AVista/icon/deuda.png")));
		setBounds(100, 100, 450, 300);
		initComponents();
	}
	
	 private void initComponents() {

	    	id=0;
	        jPanel1 = new javax.swing.JPanel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        tablaCategoria = new javax.swing.JTable();
	        tablaCategoria.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		AccionesTabla(e);
	        	}
	        });
	        resaltado = new RowsRenderer(0);
	        
	        //setClosable(true);
	        //setIconifiable(true);
	        setTitle("CONTROL CUOTAS");
	        setBounds(100, 100, 982, 527);

	        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
	        
	        
	        
	        
	        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "ID", "NOMBRE", "MONTO", "DESCUENTO", "DESCRIPCION"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        tablaCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	        jScrollPane1.setViewportView(tablaCategoria);

	        
	        btnEditar = new JButton();
			btnEditar.setName("btnEditCat");
			btnEditar.setToolTipText("Editar Categoria");
			btnEditar.setText("");
			btnEditar.setIcon(new ImageIcon("/ar/com/ProyectoClub/AVista/icon/icon-Detalles.png"));
			btnEditar.setEnabled(false);
	        ;

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 897, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
	        );
	        jPanel1.setLayout(new CardLayout(0, 0));
	        jPanel1.add(jScrollPane1, "name_1778814042415414");
	        getContentPane().setLayout(layout);

	        pack();
	 }
	 
	 private void AccionesTabla(MouseEvent e) {
			// TODO Auto-generated method stub
			
	 }

}
