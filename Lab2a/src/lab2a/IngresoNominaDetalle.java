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
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author KAMINATOR
 */
public class IngresoNominaDetalle extends javax.swing.JFrame {
String sCodigoNominaEncabezado,sCodigoEmpleado,sCodigoConcepto,sFechaInicial,sFechaFinal,sSueldo,sEfecto;
boolean bAviso=false, bCalcularIGSS=false,bCalcularISR=false;
double IGSS=0.0483;
double dValorIGSS,dValorISR,dValorNominaEncabezado; 
DecimalFormat dfFormato=new DecimalFormat("0.00");
    /**
     * Creates new form IngresoNominaDetalle
     */
    public IngresoNominaDetalle() {
        initComponents();
        funNominaEncabezado();
        funEmpleado();
        funConcepto();
    }
public void funNominaEncabezado(){
   /*Metodo para obtener la fecha inicial y la fecha final de la tabla de nomina encabezado
    de la base de datos y mostrarlo en un solo combobox*/
      try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM nominaencabezado");                 
            ResultSet rs = pst.executeQuery(); 
            boolean bSiguiente=rs.next();
            while(bSiguiente){ 
                this.cmbNominaEncabezado.addItem(rs.getString("fecha_inicial_nomina")+" al "+rs.getString("fecha_final_nomina"));
               bSiguiente=rs.next();
            }            
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se pueden obtener las fechas"+ e);
        }
}
public void funEmpleado(){
    /*Este metodo obtiene todos los nombres de los empleados existentes en la base de datos y los agrega uno por uno al combobox*/
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
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el nombre de los empleados"+ e);
        }
}
public void funConcepto(){
    /*Este metodo obtiene todos los conceptos existentes en la base de datos para agregarlos uno por uno en el combobox*/
      try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM concepto");                 
            ResultSet rs = pst.executeQuery(); 
            boolean bSiguiente=rs.next();
            while(bSiguiente){ 
                this.cmbConcepto.addItem(rs.getString("connombre"));
                bSiguiente=rs.next();
            }            
            cn.close();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error no se puede obtener el nombre del concepto"+ e);
        }
}
public void funTokensFecha(){
     /*Este metodo nos sirve para separa en dos variables las fechas que existen en el combobox*/
    /*Obtenemos el texto del combobox y usamos tokens para separa la fecha en dos*/
     StringTokenizer stToken=new StringTokenizer((String) cmbNominaEncabezado.getSelectedItem()," al ");        
        while(stToken.hasMoreTokens()){
        sFechaInicial=stToken.nextToken();
        sFechaFinal=stToken.nextToken();
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbNominaEncabezado = new javax.swing.JComboBox<>();
        cmbEmpleado = new javax.swing.JComboBox<>();
        cmbConcepto = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        btnAñadir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbNominaEncabezado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNominaEncabezadoItemStateChanged(evt);
            }
        });

        cmbEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpleadoItemStateChanged(evt);
            }
        });

        cmbConcepto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbConceptoItemStateChanged(evt);
            }
        });

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        jLabel1.setText("Nomina del:");

        jLabel2.setText("Empleado");

        jLabel3.setText("Concepto");

        jLabel4.setText("Monto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 23, Short.MAX_VALUE))
                            .addComponent(cmbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbConcepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAñadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(152, 152, 152))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbNominaEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbNominaEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(49, 49, 49))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        /*Verifica si el textbox esta vacio o si el ingresan letras*/
        if (txtMonto.getText().equals("")) {
           JOptionPane.showMessageDialog(null,"El Monto no puede estar vacio");  
        }else if (txtMonto.getText().matches("[a-zA-Z\\s]*")) {
           JOptionPane.showMessageDialog(null,"El Monto no pueden ser letras");  
        }else{
            //Llama a todos los metodos para ver si se calcula automaticamente el monto o no y mostrarlo en el textbox
        funConsultaNominaDetalles();
        CalculoMontoNominaEncabezado();
        funConsultaNominaEncabezado();
        }
    }//GEN-LAST:event_btnAñadirActionPerformed
public void funConsultaNominaDetalles(){
    /*Este metodo Guarda la informacion en el base de datos en la tabla de nomina detalles */
    try{
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
                PreparedStatement pst = cn.prepareStatement("insert into nominadetalles values(?,?,?,?)");
                pst.setString(1, sCodigoNominaEncabezado);
                pst.setString(2, sCodigoEmpleado);
                pst.setString(3, sCodigoConcepto);
                pst.setString(4, txtMonto.getText().trim());
                pst.executeUpdate();           
                JOptionPane.showMessageDialog(null,"Ingreso de datos Exitoso en Nomina detalles"); 
            cn.close();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error no se puede ingresar la informacion"+ e);
            }
}
public void funConsultaNominaEncabezado(){
    /*Este metodo nos modifica el valor actual que tiene el la tabla de nomina encabezado*/
     try {            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("update nominaencabezado set nomimonto = ? where nomicodigo = " + sCodigoNominaEncabezado);
            pst.setString(1, Double.toString(dValorNominaEncabezado));          
            pst.executeUpdate();  
             txtMonto.setText("");            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error no se puede modificar el monto de la nomina"+ e);
        }
}
public void CalculoMontoNominaEncabezado(){
    /*Este metodo funciona para sumarle a la variable de nomina encabezado segun ele efecto que tenga el concepto*/
    double dMonto=Double.parseDouble(txtMonto.getText());
if (sEfecto.equals("+")) {
       dValorNominaEncabezado=dValorNominaEncabezado+dMonto;    
 }else if (sEfecto.equals("-")) {
        dValorNominaEncabezado=dValorNominaEncabezado-dMonto;
 }
    
}
    private void cmbNominaEncabezadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNominaEncabezadoItemStateChanged
       /*Metodo para obtener el codigo de la nomina encabezado y su valor cada vez que se cambie la opcion en el combo box*/
        if (evt.getStateChange()==ItemEvent.SELECTED) {
             funTokensFecha();
         try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT nomicodigo, nomimonto FROM nominaencabezado WHERE fecha_inicial_nomina=?");    
            pst.setString(1, sFechaInicial);
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
               sCodigoNominaEncabezado=rs.getString("nomicodigo"); 
               dValorNominaEncabezado=Double.parseDouble(rs.getString("nomimonto"));               
            }                      
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener los codigos"+ e);
        }  
        }     
    }//GEN-LAST:event_cmbNominaEncabezadoItemStateChanged
public void funCodigoSueldoEmpleado(){
    /*Metido para obtener el codigo y el sueldo dem empleado segun el empleado seleccionado en el combobox*/
   try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT empcodigo, sueldo_emp FROM empleados WHERE empnombre=?");    
            pst.setString(1, (String)cmbEmpleado.getSelectedItem());
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
               sCodigoEmpleado=rs.getString("empcodigo"); 
               sSueldo=rs.getString("sueldo_emp");
            }                      
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el nombre y sueldo del empleado"+ e);
        }  
}
    private void cmbEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpleadoItemStateChanged
      /*Segun la opcion seleccionada en el combobox el textbox se bloqueara y se calculara automaticamente ya sea el igss, el isr o el sueldo base
        del empleado*/
        if (evt.getStateChange()==ItemEvent.SELECTED) {  
            funCodigoSueldoEmpleado();           
            if (bAviso==true) {
                txtMonto.enable(false);
                txtMonto.setText(sSueldo);    
            }else if (bCalcularIGSS==true) {
                dValorIGSS=funCalculoIGSS(Double.parseDouble(sSueldo));
                txtMonto.enable(false);
                txtMonto.setText(dfFormato.format(dValorIGSS));  
            }else if(bCalcularISR==true){
                dValorISR=funCalculoISR(Double.parseDouble(sSueldo));
                txtMonto.enable(false);
                txtMonto.setText(dfFormato.format(dValorISR));
            }else{               
                txtMonto.setText("");  
                txtMonto.enable(true);               
            } 
           
        }        
    }//GEN-LAST:event_cmbEmpleadoItemStateChanged
public double funCalculoIGSS(double dSueldoBase){
    /*MEtodo para calcular el igss*/
    double dCalculoIGSS;  
       dCalculoIGSS=dSueldoBase*IGSS;
       return dCalculoIGSS;            
}
public double funCalculoISR(double dSueldoBase){
    /*Metodo para calcular el isr del empleado*/
    int [][] iISR=new int[][]{{1,5000},{5001,10000},{10001,100000}};
    double dCalculoIsr = 0;
    if ((dSueldoBase>=iISR[0][0]) && (dSueldoBase<=iISR[0][1])) {
         dCalculoIsr=dSueldoBase*0.03;
     }else if ((dSueldoBase>=iISR[1][0]) && (dSueldoBase<=iISR[1][1])) {
         dCalculoIsr=dSueldoBase*0.05;
     }else if ((dSueldoBase>=iISR[2][0]) && (dSueldoBase<=iISR[2][1])) {
         dCalculoIsr=dSueldoBase*0.1;
     }
   return dCalculoIsr;     
}
    private void cmbConceptoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbConceptoItemStateChanged
        /*Segun la opcion elegida en el concepto se obtendra el codigo del concepto y su efecto segun el nombre del concepto*/
        if (evt.getStateChange()==ItemEvent.SELECTED) { 
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT concodigo, conefecto FROM concepto WHERE connombre=?");    
            pst.setString(1, (String)cmbConcepto.getSelectedItem());
            ResultSet rs = pst.executeQuery(); 
                if(rs.next()){
                    sCodigoConcepto=rs.getString("concodigo");
                    sEfecto=rs.getString("conefecto");                    
                 }            
                cn.close();
        }catch (Exception e){
             JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo y efecto del concepto"+ e);
        }
        /*Segun el la opcion elegida en el combobox el se mostrara y se calculara el igss, el isr y el sueldo y bloquera el textbox para que
        no se pueda modificar*/          
        if (cmbConcepto.getSelectedItem().equals("Sueldo Base")) {            
             txtMonto.enable(false);
             txtMonto.setText(sSueldo); 
             bAviso=true;   
             bCalcularIGSS=false; 
             bCalcularISR=false;
        }else if (cmbConcepto.getSelectedItem().equals("IGSS")) { 
              dValorIGSS=funCalculoIGSS(Double.parseDouble(sSueldo));
              txtMonto.setText(dfFormato.format(dValorIGSS));  
              txtMonto.enable(false);                 
              bCalcularIGSS=true; 
              bCalcularISR=false;
              bAviso=false;
         }else if(cmbConcepto.getSelectedItem().equals("ISR")){
             dValorISR=funCalculoISR(Double.parseDouble(sSueldo));
             txtMonto.setText(dfFormato.format(dValorISR));
             txtMonto.enable(false);
             bCalcularISR=true;
             bAviso=false;
             bCalcularIGSS=false; 
         }else{  
            bAviso=false;
            bCalcularIGSS=false; 
            bCalcularISR=false;
            txtMonto.enable(true);
            txtMonto.setText("");             
        }
     }
    }//GEN-LAST:event_cmbConceptoItemStateChanged

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
            java.util.logging.Logger.getLogger(IngresoNominaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoNominaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoNominaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoNominaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoNominaDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JComboBox<String> cmbConcepto;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbNominaEncabezado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
