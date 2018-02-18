package ar.com.ProyectoClub.AVista;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Component;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import ar.com.ProyectoClub.AVista.ClasesRender.RowsRenderer;
import ar.com.ProyectoClub.BControlador.ControllerCoordinador;
import ar.com.ProyectoClub.CModelo.CEntidades.Categoria;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.border.LineBorder;

public class PantallaConfiguracionCategoria extends JDialog implements ActionListener{
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel DescripcionL;
    private javax.swing.JButton registrar;
    private javax.swing.JButton btnHabInhabi;
    private JTextPane descripcion;
    //tabla
    public static javax.swing.JTable tablaCategoria;
    public static JButton btnEditar;
    public static RowsRenderer resaltado;
    int id;
    public JTextField nombre;
    private JLabel lblNombre;
    public JTextField Monto;
    private JLabel lblDescripcion;
    private JTextField Descuento;
    private JLabel lblDescuento;
    private JLabel label;
    // End of variables declaration//GEN-END:variables

	/**
	 * Create the frame.
	 */
	public PantallaConfiguracionCategoria(PantallaPrincipalPersonas vtnPrincipal,boolean activo) {
		super(vtnPrincipal, activo);
		initComponents();
	}
	
	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	id=0;
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        DescripcionL = new javax.swing.JLabel();
        DescripcionL.setBounds(686, 11, 150, 20);
        DescripcionL.setFont(new Font("Tahoma", Font.BOLD, 14));
        DescripcionL.setText("DESCRIPCION");
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();
        tablaCategoria.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		AccionesTabla(e);
        	}
        });
        jPanel3 = new javax.swing.JPanel();
        registrar = new javax.swing.JButton();
        btnHabInhabi= new JButton();
        btnHabInhabi.setEnabled(false);
        limpiar = new javax.swing.JButton();
        descripcion = new JTextPane();
        descripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
        descripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        descripcion.setBounds(624, 32, 250, 108);
        descripcion.setForeground(new Color(0, 0, 0));
        descripcion.setBackground(new Color(250, 250, 210));
        resaltado = new RowsRenderer(0);
        
        //setClosable(true);
        //setIconifiable(true);
        setTitle("CONFIGURACION CATEGORIAS");
        setBounds(100, 100, 923, 588);

        jPanel1.setBackground(Color.LIGHT_GRAY);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)));
        jPanel2.setLayout(null);
        
        jPanel2.add(DescripcionL);
        
        jPanel2.add(descripcion);
        
        
        
        
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        
        btnEditar = new JButton();
		btnEditar.setName("btnEditCat");
		btnEditar.setToolTipText("Editar Categoria");
		btnEditar.setText("");
		btnEditar.setIcon(new ImageIcon("C:\\Users\\Cristian Lacuadra\\Documents\\Git\\RepositorioClub\\ProyectoClub-Master\\src\\ar\\com\\ProyectoClub\\AVista\\icon\\icoEditar.png"));
		btnEditar.setEnabled(false);
		
        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setIcon(new ImageIcon(PantallaConfiguracionCategoria.class.getResource("/ar/com/ProyectoClub/AVista/icon/regisCate.png"))); // NOI18N
        registrar.setText("Registrar Categoria");
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        
        btnHabInhabi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHabInhabi.setIcon(new ImageIcon(PantallaConfiguracionCategoria.class.getResource("/ar/com/ProyectoClub/AVista/icon/HabilitarInhabilitar.png"))); // NOI18N
        btnHabInhabi.setText("Habilitar-Inhabilitar");
        btnHabInhabi.setBorder(null);
        btnHabInhabi.setBorderPainted(false);
        btnHabInhabi.setContentAreaFilled(false);
        btnHabInhabi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHabInhabi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHabInhabi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHabInhabi.addActionListener(this);

        limpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar1.png"))); // NOI18N
        limpiar.setText("Limpiar Campos");
        limpiar.setBorder(null);
        limpiar.setBorderPainted(false);
        limpiar.setContentAreaFilled(false);
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/limpiar2.png"))); // NOI18N
        limpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        			.addComponent(registrar)
        			.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        			.addComponent(limpiar)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnHabInhabi, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(registrar)
        				.addComponent(btnHabInhabi, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        				.addComponent(limpiar))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);
        
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 884, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        nombre = new JTextField();
        nombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nombre.setBackground(new Color(250, 250, 210));
        nombre.setBounds(133, 29, 232, 41);
        jPanel2.add(nombre);
        nombre.setColumns(10);
        
        lblNombre = new JLabel("NOMBRE");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNombre.setBounds(46, 35, 77, 24);
        jPanel2.add(lblNombre);
        
        Monto = new JTextField();
        Monto.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Monto.setColumns(10);
        Monto.setBackground(new Color(250, 250, 210));
        Monto.setBounds(133, 99, 232, 41);
        jPanel2.add(Monto);
        
        lblDescripcion = new JLabel("MONTO");
        lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDescripcion.setBounds(46, 105, 77, 24);
        jPanel2.add(lblDescripcion);
        
        Descuento = new JTextField();
        Descuento.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Descuento.setColumns(10);
        Descuento.setBackground(new Color(250, 250, 210));
        Descuento.setBounds(481, 29, 109, 41);
        jPanel2.add(Descuento);
        
        lblDescuento = new JLabel("DESCUENTO");
        lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDescuento.setBounds(375, 40, 96, 24);
        jPanel2.add(lblDescuento);
        
        label = new JLabel("%");
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setBounds(597, 40, 17, 24);
        jPanel2.add(label);
        jPanel1.setLayout(jPanel1Layout);

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
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponen
    
    void limpiaCampos() {
        nombre.setText("");
        Descuento.setText("");
        Monto.setText("");
        descripcion.setText("");
        btnHabInhabi.setEnabled(false);
    }
    
    private boolean validarEntradasRegistro(){
    	if(!nombre.getText().isEmpty() && !Descuento.getText().isEmpty() && !Monto.getText().isEmpty())
    		return true;
    	return false;
    }
    
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
    	limpiaCampos();
    }
    
    public void setCoordinador(ControllerCoordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
    
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
    	try{
    		if (this.validarEntradasRegistro()) {
    			Categoria categoria =  miCoordinador.CrearCategoria();
    			categoria.setNombre(nombre.getText());//nombre
    			String descrip= !descripcion.getText().isEmpty()? descripcion.getText(): " "; //si la descripcion es vacia agrego espacio vacio
    			categoria.setDescripcion(descrip);
    			categoria.setDescuento(Float.parseFloat(Descuento.getText()));
    			categoria.setMonto(Float.parseFloat(Monto.getText()));
    			categoria.setHabilitado(true);
    			if (JOptionPane.showConfirmDialog(this, "�Seguro que desea ingresar una nueva categoria?", "Categorias", JOptionPane.YES_NO_OPTION, 0,
    					new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) {
    				miCoordinador.GuardarCategoria(categoria);
    				JOptionPane.showMessageDialog(null,"La categoria se registro con existo","Mensaje",JOptionPane.INFORMATION_MESSAGE);
    				miCoordinador.CargarGrillaCategoria(tablaCategoria);
    				this.limpiaCampos();
    			}
    		}
    		else
    			JOptionPane.showMessageDialog(this, "Por favor ingrese datos, Campos Obligatorio", "Categorias", 0,
    					new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/impo.png")));
    	}
    	catch (Exception e) {
    		JOptionPane.showMessageDialog(null,"�ERROR!"+e.toString(),"Club Avenida Ejercito - ��ERROR!!", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    private void AccionesTabla(MouseEvent e) {//GEN-FIRST:event_registrarActionPerformed
    	int columna = tablaCategoria.getColumnModel().getColumnIndexAtX(e.getX());
    	int fila = e.getY() / tablaCategoria.getRowHeight();//Guardo fila enn una variiable global
    	if (fila < tablaCategoria.getRowCount() && fila >= 0){// && columna < tablaCategoria.getColumnCount() && columna >= 0) {
    		Object value = tablaCategoria.getValueAt(fila, 2);
    		if(value instanceof Integer){
    			btnHabInhabi.setEnabled(true);
    			id = (Integer) tablaCategoria.getValueAt(fila, 2);	    			
    		}
    		
    		Object valueButon = tablaCategoria.getValueAt(fila, columna);
    		
    	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	try{
    		if(e.getSource() == btnHabInhabi){
    			if(id != 0){
    				if (JOptionPane.showConfirmDialog(this, "�Seguro que desea Habilitar-Inhabilitar esta categoria?", "Categorias", JOptionPane.YES_NO_OPTION, 0,
        					new ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/seguro.png"))) == JOptionPane.YES_OPTION) {
    					miCoordinador.HabilitarInhabilitarCategoria(id);
    					miCoordinador.CargarGrillaCategoria(tablaCategoria);
    				}
    			}
    		}
    	}
    	catch (Exception ex) {
    		JOptionPane.showMessageDialog(null,"�ERROR!"+ex.toString(),"Club Avenida Ejercito - ��ERROR!!", JOptionPane.ERROR_MESSAGE);
    	}

    }
}
