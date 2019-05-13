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
import javax.swing.table.DefaultTableModel;

  /**
     * Carlos Antonio Laib Contreras (0901-17-518)
     * 22/03/2019
     * Nomina donde se pueden ingresar sus datos, y mostrarlos en la tabla obteniendo
     * la informacion desde la base de datos
      */
public class lab2 extends javax.swing.JFrame {
    //Declaracion de variables
    String sFechaInicial,sFechaFinal,sCodigoNominaEncabezado;
    int iCodigoEmpleadoNomina, iCodigoConceptoNomina, iCodigoDepartamentos,iTotalConceptos;          
     DecimalFormat dfFormato=new DecimalFormat("0.00");
     //se declara variable modelo para la tabla de nomina
     DefaultTableModel modelo=new DefaultTableModel();
    /**
     * Creates new form lab2
     */
    public lab2() {
        initComponents();
        //se llama a funcion para agregar columnas a la tabla
        funColumnas();
        //se llama a metodo para obtener los rangos de las fechas de la nominas en el combobox
        funNominaEncabezado();
        //funcion para obtener el codigo maximo de la tabla departamentos
        funCodigosDepartamento();
    }
    public void funColumnas(){   
        /*Este metodo nos agrega las columnas de la tabla empezando por el empleado
        Cargando todos los conceptos y agregando dos ultimas columnas de sueldo liquidp 
        y Departamento*/
        modelo.addColumn("Empleado");
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM concepto");                 
            ResultSet rs = pst.executeQuery(); 
            boolean bSiguiente=rs.next();
            while(bSiguiente){ 
               /*Agregamos las columnas con todos los nombres de los conceptos que existen en la tabla de conceptos
                en la base de datos*/
               modelo.addColumn(rs.getString("connombre"));
               /*A esta variable le sumamos 1 cada vez que se repite el while para contar cuantos conceptos existen en la tabla*/
               iTotalConceptos++;
               bSiguiente=rs.next();
            } 
            /*Le sumamos un ultimo numero por utilizacion de vector en el boton de mostrar*/
            iTotalConceptos++;
            modelo.addColumn("Sueldo Liquido");
            modelo.addColumn("Departamento");
            /*Mostramos el model en la tabla*/
            tblMatriz.setModel(modelo);
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener las fechas"+ e);
        }
    }
public void funNominaEncabezado(){
    /*Metodo para obtener la fecha inicial y la fecha final de la tabla de nomina encabezado
    de la base de datos y mostrarlo en un colo combobox*/
      try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM nominaencabezado");                 
            ResultSet rs = pst.executeQuery(); 
            boolean bSiguiente=rs.next();
            while(bSiguiente){ 
                /*Al entrar en el while este nos agrega la fecha inicial y la fecha final de cada nomina enxistente en la
                tabla de noina encabezado*/
                this.cmbFechaNominaEncabezado.addItem(rs.getString("fecha_inicial_nomina")+" al "+rs.getString("fecha_final_nomina"));
               bSiguiente=rs.next();
            }            
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener las fechas"+ e);
        }
}
public void funTokensFecha(){
    /*Este metodo nos sirve para separa en dos variables las fechas que existen en el combobox*/
    /*Obtenemos el texto del combobox y usamos tokens para separa la fecha en dos*/
     StringTokenizer stToken=new StringTokenizer((String) cmbFechaNominaEncabezado.getSelectedItem()," al ");        
        while(stToken.hasMoreTokens()){
        sFechaInicial=stToken.nextToken();
        sFechaFinal=stToken.nextToken();
        }        
}
   public void funCodigosDepartamento(){
       /*Este metodo nos devuelve el la variable iCodigoDepartamentos el codigo maximo de departamentos que existen en la tabla
       de departamentos*/
       try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM departamentos ORDER BY depcodigo DESC");                 
            ResultSet rs = pst.executeQuery();         
            if(rs.next()){ 
                //obtiene el valor maximo de la consulta
                iCodigoDepartamentos=Integer.parseInt(rs.getString(1));                                               
            }            
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo del departamento"+ e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTotal = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTotal1 = new javax.swing.JTable();
        cmbFechaNominaEncabezado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarNomina = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotalNomina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMatriz);

        tblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Departamento", "Total"
            }
        ));
        tblTotal.setRowHeight(40);
        jScrollPane2.setViewportView(tblTotal);

        tblTotal1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblTotal1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1-5000", "3%"},
                {"5001-10000", "5%"},
                {"10000-100000", "10%"}
            },
            new String [] {
                "Rango", "Porcentaje"
            }
        ));
        tblTotal1.setRowHeight(40);
        jScrollPane3.setViewportView(tblTotal1);

        cmbFechaNominaEncabezado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFechaNominaEncabezadoItemStateChanged(evt);
            }
        });
        cmbFechaNominaEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFechaNominaEncabezadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nomina de la fecha : ");

        btnMostrarNomina.setText("Mostrar");
        btnMostrarNomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarNominaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total Nomina");

        lblTotalNomina.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(cmbFechaNominaEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnMostrarNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(61, 61, 61)
                                .addComponent(lblTotalNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)))))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFechaNominaEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnMostrarNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTotalNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFechaNominaEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFechaNominaEncabezadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFechaNominaEncabezadoActionPerformed

    private void cmbFechaNominaEncabezadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFechaNominaEncabezadoItemStateChanged
        /*En este evento del combobox cada vez que seleccione una opcion el nos va a devolver el codigo
        que tiene la tabla de nomina encabezado buscando por medio de la fecha inicial*/
        if (evt.getStateChange()==ItemEvent.SELECTED) {
            /*Mandamos a llamar al metodo de los tokens para separar primero las fechas y asi poder utilizar
            la fecha inicial para buscar el codigo de nominaencabezado de esa fecha*/
             funTokensFecha();
         try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT nomicodigo FROM nominaencabezado WHERE fecha_inicial_nomina=?");    
            pst.setString(1, sFechaInicial);
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                //obtenemos el codigo de la nomina encabezdo 
               sCodigoNominaEncabezado=rs.getString("nomicodigo");              
            }                      
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo de la nomina encabezado"+ e);
        }  
        } 
    }//GEN-LAST:event_cmbFechaNominaEncabezadoItemStateChanged


    private void btnMostrarNominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarNominaActionPerformed
        /*En este boton mostramos toda la informacion solicitada segun el rango de la fecha en las dos tablas*/
        //Llamamos al metodo para limpiar las dos tablas
        funLimpiarTablas();
        //Llamamos al metodo para obtener el codigo de los empleados que existen en la nomina seleccionada
        funcodigosEmpleados();  
        //Llamamos al metodo para obtener el codigo de los conceptos que existen en la nomina seleccionada
        funCodigosConceptos();         
        int iComienzo=1;       
        double[] dAgregarATabla;
        String[] sEfecto;
         //Obtenemos el total de columas de la tabla de la nomina
         int iTotalColumnas=tblMatriz.getColumnCount();   
      //Si la variable iCodigoEmpleadoNomina es diferente de 0 podra mostrar los datos
    if (iCodigoEmpleadoNomina!=0) {
        //Iniciamos un primer ciclo do while
       do {
           //Al entrar cada vez en el ciclo le agregaremos una fila a la tabla
             modelo.addRow(new Object[iTotalColumnas]);
             tblMatriz.setModel(modelo);
             int iComienzoDetalle=1;
             /*Llamamos al metodo para mostrar en la tabla el nombre del empleados y al departamento que pertenece
             enviandole dos distintos parametros para que cada vez que se repira el ciclo en numero de la fila y de
             la columna se cambie automaticamente*/
             funNombreEmpleadosDepartamento(iComienzo,iTotalColumnas); 
             /*Creamos un vector del tamaño del total de conceptos que existen en la tabla de conceptos*/
             dAgregarATabla=new double[iTotalConceptos]; 
             /*Creamos un vector del tamaño total de conceptos para almacenar el efecto que tiene cada concepto
             para poder utilizarlo en el calculo del sueldo liquido del empleado*/
             sEfecto=new String[iTotalConceptos];  
             //Iniciamos un segundo ciclo
             do {   
                 /*Llamamos al metodo para obtener el monto de concepto en concepto enviandole 4 parametros que se iran cambiando
                 cada vez que se repita el ciclo*/
                 funMontoConcepto(iComienzo,iComienzoDetalle,dAgregarATabla,sEfecto);
                 //Le sumamos uno a la variable para que con el paso de las repeticiones el ciclo se pueda termianr
                 iComienzoDetalle++; 
             } while (iComienzoDetalle<=iCodigoConceptoNomina);
             /*Llamamos al metodo para obtener el sueldo liquido del empleado que le toque segun el ciclo enviandole 4 parametros
             que se cambiaran automaticamente para hacer los calculos y agregarlo ala tabla*/
             funCalculoSueldoLiquido(sEfecto,dAgregarATabla,iComienzo,iTotalColumnas,iTotalConceptos);     
             //Le sumamos uno a la variable para que con el paso de las repeticiones el ciclo se pueda termianr
             iComienzo++;
        } while (iComienzo<=iCodigoEmpleadoNomina);        
         /*Llamamos al metodo para obtener el total por cada departamento existente en esa nomina*/
         funTotalporDepartamento();
         /*Llamamos al metodo para verificar si en la tabla hay espacios vacios*/
         funVerificarVacioTablaNomina();
         /*Llamamos al metodo para obtener el total de la nomina seleccionada en al rango de la fecha*/
         funTotalNomina();
    }   
    }//GEN-LAST:event_btnMostrarNominaActionPerformed
public void funcodigosEmpleados(){
    /*Metodo para obtener el codigo mas alto del empleado existente en la tabla de nomina encabezado*/
       try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT empcodigo FROM nominadetalles WHERE nomicodigo="+sCodigoNominaEncabezado+" ORDER BY nomicodigo DESC"); 
            ResultSet rs = pst.executeQuery();         
            if(rs.next()){ 
                //nos devuelve el valor del codigo mas grande
                iCodigoEmpleadoNomina=Integer.parseInt(rs.getString("empcodigo"));                 
            }           
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo del empleado"+ e);
        }
}
public void funCodigosConceptos(){
    /*Metodo para obtener el codigo mas alto de la tabla de conceptos*/
       try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM concepto  ORDER BY concodigo DESC");            
            ResultSet rs = pst.executeQuery();         
            if(rs.next()){   
                //nos decuelve el valor del codigo mas grande
                iCodigoConceptoNomina=Integer.parseInt(rs.getString(1));                 
            }            
            cn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error no se puede obtener el codigo del concepto"+ e);
        } 
}
public void funNombreEmpleadosDepartamento(int iComienzo,int iTotalColumnas){
   /*Metodo que se repetira en el primer ciclo while del boton para obtener el nombre del empleado y el nombre del departamento que existan en la nomina 
    esta recibira dos parametros que se iran cambiando automaticamente para obtener todos los nombres y departamentos correspondientes en la nomina detalles que 
    esten relacionados en tabla de nomina encabezado*/  
    try{
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
                        PreparedStatement pst = cn.prepareStatement("SELECT empleados.empnombre, departamentos.depnombre FROM empleados, departamentos, nominaencabezado,nominadetalles WHERE empleados.depcodigo=departamentos.depcodigo AND nominadetalles.empcodigo=empleados.empcodigo AND nominaencabezado.nomicodigo=nominadetalles.nomicodigo AND empleados.empcodigo="+iComienzo+" AND nominaencabezado.nomicodigo="+sCodigoNominaEncabezado+"");                                           
                         ResultSet rs = pst.executeQuery(); 
                         if (rs.next()) { 
                             /*Mostramos el nombre del empleado y del departamento en la fila y columna*/
                             tblMatriz.setValueAt(rs.getString("empleados.empnombre"), (iComienzo-1), 0);
                             tblMatriz.setValueAt(rs.getString("departamentos.depnombre"), (iComienzo-1), (iTotalColumnas-1));                                                 
                         }     
                         cn.close();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Error no se puede obtener el nombre y departamento del empleado"+ e);
                     } 
}
public void funMontoConcepto(int iComienzo,int iComienzoDetalle, double dAgregarATabla[],String sEfecto[]){
    /*Metodo que se repitara en el segundo ciclo while del boton mostrar para obtener el monto y el efecto que tienen el concepto de la tabla nomina detalles
    que se iran guardando en las posiciones correpondientes de los 2 vectores recibidos del boton, aqui se recibiran cuatro paramentros que se iran cambiando
    automaticamente hasta que se termine el ciclo*/ 
    try{
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
                        PreparedStatement pst = cn.prepareStatement("SELECT nominadetalles.nomidtotal, concepto.conefecto FROM nominadetalles,concepto WHERE nominadetalles.concodigo=concepto.concodigo AND nominadetalles.empcodigo="+iComienzo+" and concepto.concodigo="+iComienzoDetalle+" and nominadetalles.nomicodigo="+sCodigoNominaEncabezado+"");    
                         
                         ResultSet rs = pst.executeQuery(); 
                         if (rs.next()) {  
                             /*Si la variable rs no devuelbe nigun valor nulo en los dos vetores guardara el monto y el vector de ese concepto*/
                             dAgregarATabla[iComienzoDetalle]=Double.parseDouble(rs.getString("nominadetalles.nomidtotal")); 
                             sEfecto[iComienzoDetalle]=rs.getString("concepto.conefecto");                                                        
                         }else{                             
                             /*Si la variable rs devuelve un valor nulo en los dos vectores nos guaradara 0 y un valor nulo de ese concepto*/
                             dAgregarATabla[iComienzoDetalle]=0;
                             sEfecto[iComienzoDetalle]=null;                                                        
                         }    
                         /*En la tabla iremos agregando el valor del concepto dependiendo en que fila y columna se encuentre*/
                            tblMatriz.setValueAt(dAgregarATabla[iComienzoDetalle], (iComienzo-1), iComienzoDetalle);                       
                         cn.close();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Error no se puede obtener el monto y efecto"+ e);
                     }                     
                           
}
    public void funCalculoSueldoLiquido(String[] sEfecto, double[] dMonto,int iComienzo,int iTotalColumnas, int iTotalConceptos){
        /*Metodo que se repetira en el primer ciclo while que recibe 5 parametros para poder calcular el sueldo liquido de cada empleado y poder mostrarlo en la tabla*/
    double dSueldoLiquido=0;
    //Ciclo para poder verificar el vector sEfecto que contiene el efecto que da el concepto correspondiente
    for (int i = 1; i < iTotalConceptos; i++) {      
        if (sEfecto[i]!=null) {
            //Verificara si es suma y resta para añadirlo al sueldo liquido
               if ("+".equals(sEfecto[i])) {                                   
                   dSueldoLiquido=dSueldoLiquido+dMonto[i];                    
               }else if ("-".equals(sEfecto[i])) {                                   
                    dSueldoLiquido=dSueldoLiquido-dMonto[i];                  
               }
        }else{             
            //si el efecto es nulo no le sumara nada al sueldo liquido
             dSueldoLiquido=dSueldoLiquido+0;            
       } 
        //Agregara en la tabla el sueldo liquido segun la fila y columna que encuentre en el ciclo
           tblMatriz.setValueAt(dfFormato.format(dSueldoLiquido), (iComienzo-1), (iTotalColumnas-2));   
    }
   
}
    public void funTotalporDepartamento(){
        /*Metodo para calcular el total por departamentos existente en la nomina seleccionada*/
       int iComienza=1;
       DefaultTableModel modeloDepartamento=new DefaultTableModel();
        modeloDepartamento.setColumnIdentifiers(new Object[]{"Departamento","Total"});
       if (iCodigoEmpleadoNomina!=0) {
         do {
            modeloDepartamento.addRow(new Object[]{"",""});
           tblTotal.setModel(modeloDepartamento);
           /*Llama al metodo para obtener el nombre de cada departamento existente en la base de datos*/
           funNombreDepartamento(iComienza);
           /*Llama al metodo para obtener el total por departamento y mostrarlo en la tabla*/
           funCalculoporDepartamento(iComienza);
           /*Le suma uno a la variable para poder cerrar el ciclo con el paso de las repeticiones*/
           iComienza++;
       } while (iComienza<=iCodigoDepartamentos);
       }          
   }
   public void funNombreDepartamento(int iComienza){
     /*En este metodo se repetira en el ciflo while del metodo de total por departamento(funTotalporDepartamento) para ir obteniedo
       el nombre de cada departamento existente en la base de datos*/
    try{
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
                        PreparedStatement pst = cn.prepareStatement("SELECT depnombre FROM departamentos WHERE depcodigo=? ");    
                         pst.setString(1, Integer.toString(iComienza));                   
                         ResultSet rs = pst.executeQuery(); 
                         if (rs.next()) {  
                             //Agrega a la tabla el nombre del departamento segun la fila y la columna que le corresponda
                             tblTotal.setValueAt(rs.getString("depnombre"), (iComienza-1), 0);                                                                             
                         }     
                         cn.close();
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null,"Error no se puede obtener el nombre del departamento"+ e);
                     } 
}
   public void funCalculoporDepartamento(int iComienza){
     /*En este metodo se repetira en ciclo while del metodo de total por departamento(funTotalporDepartamento) para ir obteniendo
       el calculo de cada departamento*/ 
      double dTotalporDepartamento=0,dMonto;
      String sEfecto;
       try{
           /*La consulta se repetira el numero de veces segun el ciclo para obtener el total por departamento*/
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT nominadetalles.nomidtotal, concepto.conefecto, empleados.empnombre, departamentos.depnombre FROM nominadetalles,concepto,empleados,nominaencabezado,departamentos WHERE empleados.depcodigo=departamentos.depcodigo and nominadetalles.empcodigo=empleados.empcodigo and nominaencabezado.nomicodigo=nominadetalles.nomicodigo and nominadetalles.concodigo=concepto.concodigo and nominaencabezado.nomicodigo=? AND departamentos.depcodigo=?");    
            pst.setString(1, sCodigoNominaEncabezado);
            pst.setString(2, Integer.toString(iComienza));
            ResultSet rs = pst.executeQuery();            
            /*Si la variable revisara primero si devuelve un valor nulo en los registros obtenidos para poder sumarse al total por departamento*/
            if (rs.first()) {
                /*Luego Regresara para poder empezar desde el primer registro*/
               rs.beforeFirst();
               while(rs.next()){
                   /*El valor de cada concepto de cada empleado segun en el departamento que se encuentre*/
                    dMonto=Double.parseDouble(rs.getString("nominadetalles.nomidtotal")); 
                  sEfecto=rs.getString("concepto.conefecto"); 
                  //Dependiendo del efecto sumara o resta para el total
                    if ("+".equals(sEfecto)) {                                   
                         dTotalporDepartamento=dTotalporDepartamento+dMonto;                         
                    }else if ("-".equals(sEfecto)) {                                   
                         dTotalporDepartamento=dTotalporDepartamento-dMonto; 
                        
                     }
               }
           }else{   
                //Si rs posee un valor nulo no le sumara nada al total por departamento
               dTotalporDepartamento=dTotalporDepartamento+0;             
            }           
              //Mostrar el total por departamento en la segunda tabla segun su fila y columna que le corresponda
            tblTotal.setValueAt(dfFormato.format(dTotalporDepartamento), (iComienza-1), 1);
            cn.close();
        }catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error no se puede obtener el monto y concepto para el total por departamento"+ e);
        }  
   }

    public void funVerificarVacioTablaNomina(){
        /*En este metodo verificara si la tabla tiene una fila vacia para poder eliminarla de ella
        Primero de obtiene el numero total de filas que tiene*/
      int iFila=tblMatriz.getRowCount();      
         int iInicio=0;
         do {   
             iFila=tblMatriz.getRowCount();
             //si el inicio es diferente de la fila revisa si la tabla tiene un espacio vacio
                if (iInicio!=iFila) {                    
                    String sVerificarLleno= (String) tblMatriz.getValueAt((iInicio), 0);     
                    //Si teiene un espacio vaio este elminara de la la tabla esa fila
                     if (sVerificarLleno==null) {                 
                    DefaultTableModel modelo = (DefaultTableModel)tblMatriz.getModel();
                    modelo.removeRow(iInicio);   
                    iInicio=iInicio;
                }else{
                   iInicio++; 
                } 
             }else{
                    break;
             }
        } while (iInicio<iFila);
}
  public void funTotalNomina(){
      /*Este metodo es para mostrar el total de la nomina segun el codigo de la nomina seleccionada*/
       try{
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/nomina", "root", "");
        PreparedStatement pst = cn.prepareStatement("SELECT nomimonto FROM nominaencabezado WHERE nomicodigo=?");    
        pst.setString(1, sCodigoNominaEncabezado);                   
        ResultSet rs = pst.executeQuery(); 
        if (rs.next()) {  
            lblTotalNomina.setText(rs.getString("nomimonto"));
         }     
          cn.close();
        }catch (Exception e){
         JOptionPane.showMessageDialog(null,"Error no se puede obtener el monto total de la nomina"+ e);
        } 
   }

   
   public void funLimpiarTablas(){
       DefaultTableModel dftModeloLimpiador1 = (DefaultTableModel) tblMatriz.getModel(); 
        //contamos el numero de filas que tiene la matriz
              int iLimpiador =tblMatriz.getRowCount();
            for(int i=0; i<iLimpiador; i++) {            
                //vamos removiendo cada fila del model y por lo tanto tambien de la tabla
                dftModeloLimpiador1.removeRow(0);
            }
          //limpiamos la segunda tabla
        DefaultTableModel dftModeloLimpiador2 = (DefaultTableModel) tblTotal.getModel(); 
        //contamos el numero de filas que tiene el vector
              int iLimpiador2 =tblTotal.getRowCount();
            for(int i=0; i<iLimpiador2; i++) {            
                //vamos removiendo cada fila del model y por lo tanto tambien de la tabla tblTotal
                dftModeloLimpiador2.removeRow(0);
            }
   }
 
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
            java.util.logging.Logger.getLogger(lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarNomina;
    private javax.swing.JComboBox<String> cmbFechaNominaEncabezado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotalNomina;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTable tblTotal;
    private javax.swing.JTable tblTotal1;
    // End of variables declaration//GEN-END:variables
}
