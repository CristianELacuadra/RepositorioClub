/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RestaurarBD.java
 *
 * Created on 01-ene-2013, 22:16:52
 */
package ar.com.ProyectoClub.AVista;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

import ar.com.ProyectoClub.CModelo.DPersistencia.DPersistenciaBackupJDBC.MySQL;
import ar.com.ProyectoClub.CModelo.DPersistencia.DPersistenciaBackupJDBC.Seleccion;
import java.awt.Toolkit;

/**
 *
 * @author Tottus
 */
public class RestaurarBD extends javax.swing.JDialog {

    String user = "root";
    String password = "cris709";
    String bd = "datosclub";
    String path = "";
    String backup = "mysqldump --user=" + user + " --password=" + password + " -v " + bd + " > " + path;
    PantallaConfiguracion p;
    MySQL mysql;

    public RestaurarBD(PantallaConfiguracion parent, boolean modal) {
        super(parent, modal);
        setIconImage(Toolkit.getDefaultToolkit().getImage(RestaurarBD.class.getResource("/ar/com/ProyectoClub/AVista/icon/logo.png")));
        p = parent;
        initComponents();
        this.setLocationRelativeTo(p);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnrestaurar = new javax.swing.JButton();
        btnexaminar = new javax.swing.JButton();
        txtruta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restaurar Base de Datos");
        setResizable(false);

        btnrestaurar.setText("Restaurar");
        btnrestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestaurarActionPerformed(evt);
            }
        });

        btnexaminar.setText("Examinar");
        btnexaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexaminarActionPerformed(evt);
            }
        });

        txtruta.setEditable(false);

        jLabel1.setText("Ruta :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnexaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexaminar))
                .addGap(18, 18, 18)
                .addComponent(btnrestaurar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexaminarActionPerformed
        Seleccion o = new Seleccion();
        File file = o.Abrir(this);
        if (file != null) {
            String cad = file.getAbsolutePath();
            txtruta.setText(cad);
        }
    }//GEN-LAST:event_btnexaminarActionPerformed

    private void btnrestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestaurarActionPerformed
        if (txtruta.getText().length() > 0) {
            try {
                File file;
                file = new File(txtruta.getText());
                path = file.getAbsolutePath();
                int c = JOptionPane.showConfirmDialog(p, "Desea Restaurar esta Base de datos", "mensaje de confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (c == JOptionPane.YES_OPTION) {
                    mysql=new MySQL();
                    mysql.Comandos("drop database if exists apafa;");
                    mysql=new MySQL("localhost/mysql",user,password);
                    mysql.Comandos("create database apafa");
                    mysql=new MySQL();
                    backup = "cmd /c mysql --user=" + user + " --password=" + password + "   " + bd + " < " + path;
                    Process child = Runtime.getRuntime().exec(backup);
                    JOptionPane.showMessageDialog(p, "La Base de Datos ha sido Restaurada Correctamente");
                    this.dispose();
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnrestaurarActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexaminar;
    private javax.swing.JButton btnrestaurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}