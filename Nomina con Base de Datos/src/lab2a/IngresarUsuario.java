/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2a;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author KAMINATOR
 */
public class IngresarUsuario extends javax.swing.JFrame {
int iCodigo=1;
String sCodigoEmpleado;
    /**
     * Creates new form IngresarUsuario
     */
    public IngresarUsuario() {
        initComponents();
        funNombreEmpleados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnregistrar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtregresar = new javax.swing.JButton();
        txtcontraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        txtregresar.setText("Regresar");
        txtregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Empleado");

        cmbEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpleadoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtcontraseña)
                            .addComponent(cmbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnregistrar)
                        .addGap(63, 63, 63)
                        .addComponent(txtregresar)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregistrar)
                    .addComponent(txtregresar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void funNombreEmpleados(){
    /*Metodo para obetner todos los empleados de la base de datos*/
      try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM empleados");                 
            ResultSet rs = pst.executeQuery(); 
            boolean bSiguiente=rs.next();
            while(bSiguiente){ 
                this.cmbEmpleado.addItem(rs.getString("empnombre"));
                bSiguiente=rs.next();
            }            
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener los nombres de los empleados"+ e);
        }
}
    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
       /*En este boton se guardaran todos los datos del usuario en la base de datos*/
        
       codigo();
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into usuarios values(?,?,?,?,?)");
            
            pst.setString(1, Integer.toString(iCodigo));
            pst.setString(2, txtusuario.getText().trim());
            pst.setString(3, txtcontraseña.getText().trim());            
            pst.setString(4, Integer.toString(1));
            pst.setString(5, sCodigoEmpleado);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Ingreso de datos Exitoso");
            txtusuario.setText("");
            txtcontraseña.setText("");          
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede guardar"+ e);
        }
    }//GEN-LAST:event_btnregistrarActionPerformed
public void codigo(){
    /*Metodo para obtener el codigo maximo del usuario y sumarle uno para guardarlo en la base de datos*/
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuarios ORDER BY codigo_usuario DESC");                 
            ResultSet rs = pst.executeQuery();         
            if(rs.next()){ 
                int iCodigoObtenido=Integer.parseInt(rs.getString(1));  
                if (iCodigoObtenido==0) {
                    iCodigo=1;
                }else{
                    iCodigo=iCodigoObtenido+1;
                }              
            }            
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo "+ e);
        }
}
    private void txtregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregresarActionPerformed
         this.dispose();
    }//GEN-LAST:event_txtregresarActionPerformed

    private void cmbEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpleadoItemStateChanged
       /*Segun la opcion elegida se obtendra el codigo del empleado*/
        if (evt.getStateChange()==ItemEvent.SELECTED) {  
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT empcodigo FROM empleados WHERE empnombre=?");    
            pst.setString(1, (String)cmbEmpleado.getSelectedItem());
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
               sCodigoEmpleado=rs.getString("empcodigo");                  
            }                      
            cn.close();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo del empleado"+ e);
        }
         }
    }//GEN-LAST:event_cmbEmpleadoItemStateChanged

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
            java.util.logging.Logger.getLogger(IngresarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JButton txtregresar;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
