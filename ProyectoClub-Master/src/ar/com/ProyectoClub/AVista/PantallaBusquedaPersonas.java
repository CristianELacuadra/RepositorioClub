/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ProyectoClub.AVista;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

/**
 *
 * @author Ricardo
 */
public class PantallaBusquedaPersonas extends javax.swing.JFrame {
	public javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable jtDatos;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtDni;
   
    public PantallaBusquedaPersonas() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD MVC");

        btnBuscar.setText("Buscar");

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "APELLIDOS", "NOMBRES", "FECHA N.", "LUGAR N."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtDatos);
        if (jtDatos.getColumnModel().getColumnCount() > 0) {
            jtDatos.getColumnModel().getColumn(0).setResizable(false);
            jtDatos.getColumnModel().getColumn(1).setResizable(false);
            jtDatos.getColumnModel().getColumn(2).setResizable(false);
            jtDatos.getColumnModel().getColumn(3).setResizable(false);
            jtDatos.getColumnModel().getColumn(4).setResizable(false);
        }
        
        JLabel lblDni = new JLabel("DNI");
        
        JLabel lblApellidoYNombre = new JLabel("APELLIDO Y NOMBRE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblApellidoYNombre)
        						.addComponent(lblDni))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        							.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(btnBuscar))
        						.addComponent(txtDni, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDni))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblApellidoYNombre)
        				.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnBuscar))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaBusquedaPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaBusquedaPersonas().setVisible(true);
            }
        });
    }
}
