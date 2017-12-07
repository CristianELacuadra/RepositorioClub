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

public class PantallaConfiguracionCategoria extends JDialog implements ActionListener{
	private ControllerCoordinador miCoordinador; //objeto miCoordinador que permite la relacion entre esta clase y la clase ControllerCoordinador
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private app.bolivia.swing.JCTextField nombre;
    private app.bolivia.swing.JCTextField Monto;
    private app.bolivia.swing.JCTextField descuento;
    private javax.swing.JLabel nombreL;
    private javax.swing.JLabel MontoL;
    private javax.swing.JLabel DescripcionL;
    private javax.swing.JLabel descuentoL;
    private javax.swing.JButton registrar;
    private javax.swing.JButton btnHabInhabi;
    private JTextPane descripcion;
    //tabla
    public static javax.swing.JTable tablaCategoria;
    public static JButton btnEditar;
    public static RowsRenderer resaltado;
    int id;
    // End of variables declaration//GEN-END:variables

	/**
	 * Create the frame.
	 */
	public PantallaConfiguracionCategoria(PantallaConfiguracion vtnConfiguracion,boolean activo) {
		super(vtnConfiguracion, activo);
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
        nombre = new app.bolivia.swing.JCTextField();
        Monto = new app.bolivia.swing.JCTextField();
        descuento= new app.bolivia.swing.JCTextField();
        nombreL = new javax.swing.JLabel();
        descuentoL = new javax.swing.JLabel();
        MontoL = new javax.swing.JLabel();
        DescripcionL = new javax.swing.JLabel();
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
        descripcion.setForeground(SystemColor.window);
        descripcion.setBackground(new Color(0, 0, 128));
        resaltado = new RowsRenderer(0);
        
        //setClosable(true);
        //setIconifiable(true);
        setTitle("CONFIGURACION CATEGORIAS");
        setBounds(100, 100, 982, 527);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(34, 102, 145));
        nombre.setBorder(null);
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombre.setOpaque(false);
        nombre.setPhColor(new java.awt.Color(255, 255, 255));
        nombre.setPlaceholder("NOMBRE CATEGORIA");
        
        Monto.setBackground(new java.awt.Color(34, 102, 145));
        Monto.setBorder(null);
        Monto.setForeground(new java.awt.Color(255, 255, 255));
        Monto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Monto.setOpaque(false);
        Monto.setPhColor(new java.awt.Color(255, 255, 255));
        Monto.setPlaceholder("MONTO $");
        
        descuento.setBackground(new java.awt.Color(34, 102, 145));
        descuento.setBorder(null);
        descuento.setForeground(new java.awt.Color(255, 255, 255));
        descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        descuento.setOpaque(false);
        descuento.setPhColor(new java.awt.Color(255, 255, 255));
        descuento.setPlaceholder("DESCUENTO %");
        
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        nombreL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/PanelEntrada.png"))); // NOI18N
        jPanel2.add(nombreL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 52));
        
        jPanel2.add(Monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, -1));

        MontoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/PanelEntrada.png"))); // NOI18N
        jPanel2.add(MontoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 52));
        
        jPanel2.add(descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 180, -1));
        
        descuentoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ar/com/ProyectoClub/AVista/icon/PanelEntrada.png"))); // NOI18N
        jPanel2.add(descuentoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, 52));
        
        jPanel2.add(DescripcionL, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 150, 20));
        
        jPanel2.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 250, 100));
        
        
        
        
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
		btnEditar.setIcon(new ImageIcon("/ar/com/ProyectoClub/AVista/icon/icon-Detalles.png"));
		btnEditar.setEnabled(false);
		
        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setIcon(new ImageIcon(PantallaConfiguracionCategoria.class.getResource("/ar/com/ProyectoClub/AVista/icon/regisCate.png"))); // NOI18N
        registrar.setText("Registrar Categoria");
        registrar.setBorder(null);
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
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addComponent(registrar, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(limpiar)
        			.addGap(18)
        			.addComponent(btnHabInhabi, GroupLayout.PREFERRED_SIZE, 115, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(registrar)
        					.addComponent(limpiar))
        				.addComponent(btnHabInhabi, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);
        
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 884, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        			.addContainerGap())
        );
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
        descuento.setText("");
        Monto.setText("");
        descripcion.setText("");
        btnHabInhabi.setEnabled(false);
    }
    
    private boolean validarEntradasRegistro(){
    	if(!nombre.getText().isEmpty() && !descuento.getText().isEmpty() && !Monto.getText().isEmpty())
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
    			categoria.setDescuento(Float.parseFloat(descuento.getText()));
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
    	//int columna = tablaCategoria.getColumnModel().getColumnIndexAtX(e.getX()); //Guardo columna enn una variiable global
    	int fila = e.getY() / tablaCategoria.getRowHeight();//Guardo fila enn una variiable global
    	if (fila < tablaCategoria.getRowCount() && fila >= 0){// && columna < tablaCategoria.getColumnCount() && columna >= 0) {
    		Object value = tablaCategoria.getValueAt(fila, 2);
    		if(value instanceof Integer){
    			btnHabInhabi.setEnabled(true);
    			id = (Integer) tablaCategoria.getValueAt(fila, 2);	    			
    		}
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