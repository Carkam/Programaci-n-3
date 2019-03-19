/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2a;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

  /**
     * Carlos Antonio Laib Contreras (0901-17-518)
     * 21/02/2019
     * Planilla que  calcula el sueldo liquido de los trabajadores mostrando los
     * totales por departamento
     * Grupo#1 Presentacion
     */
public class lab2 extends javax.swing.JFrame {
     int iSueldoBase, iTotalPercepciones;
        double dValorIsr, dSueldoLiquido,dSumador,dValorIGSS,dTotalDeducciones;
        String [][] sTotalDepartamento=new String[11][11];
        double[] dTotales=new double[5];
        DecimalFormat dfFormato=new DecimalFormat("0.00");
    /**
     * Creates new form lab2
     */
    public lab2() {
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

        btnIngresar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTotal = new javax.swing.JTable();
        lblDepartamento1 = new javax.swing.JLabel();
        lblDepartamento2 = new javax.swing.JLabel();
        lblDepartamento3 = new javax.swing.JLabel();
        lblDepartamento4 = new javax.swing.JLabel();
        lblDepartamento5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTotal1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setBackground(new java.awt.Color(255, 255, 51));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(255, 255, 51));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 51));
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigol", "Nombre Empleado", "Sueldo Base", "Bonificación", "Comisiones", "IGSS", "Descuentos Judiciales", "ISR", "Sueldo Liquido", "Departamento"
            }
        ));
        jScrollPane1.setViewportView(tblMatriz);

        tblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Total por Departamento"
            }
        ));
        tblTotal.setRowHeight(40);
        jScrollPane2.setViewportView(tblTotal);

        lblDepartamento1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDepartamento1.setText("Departamento 1");

        lblDepartamento2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDepartamento2.setText("Departamento 2");

        lblDepartamento3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDepartamento3.setText("Departamento 3");

        lblDepartamento4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDepartamento4.setText("Departamento 4");

        lblDepartamento5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDepartamento5.setText("Departamento 5");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnIngresar)
                .addGap(94, 94, 94)
                .addComponent(btnMostrar)
                .addGap(112, 112, 112)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDepartamento5)
                            .addComponent(lblDepartamento1)
                            .addComponent(lblDepartamento2)
                            .addComponent(lblDepartamento3)
                            .addComponent(lblDepartamento4))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresar)
                            .addComponent(btnMostrar)
                            .addComponent(btnLimpiar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblDepartamento1)
                                .addGap(28, 28, 28)
                                .addComponent(lblDepartamento2)
                                .addGap(28, 28, 28)
                                .addComponent(lblDepartamento3)
                                .addGap(28, 28, 28)
                                .addComponent(lblDepartamento4)
                                .addGap(18, 18, 18)
                                .addComponent(lblDepartamento5)
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //ciclo for para llenar la matriz y pedir nombre de los empleados  
        for (int i = 1; i <= 10; i++) {         
            int iPreguntaIgss=0,iOpcionNoValida = 0;
                   sTotalDepartamento[i][0]=Integer.toString((int) (i));
                    sTotalDepartamento[i][1]=JOptionPane.showInputDialog("Ingrese el nombre del empleado #"+i);
                    sTotalDepartamento[i][2]=Integer.toString((int) (2000+(Math.random()*15000)));
                    sTotalDepartamento[i][3]=Integer.toString((int) (1000+(Math.random()*4000)));
                    sTotalDepartamento[i][4]=Integer.toString((int) (1250+(Math.random()*5000)));                   
                    sTotalDepartamento[i][6]=Integer.toString((int) (250+(Math.random()*750)));
                    sTotalDepartamento[i][9]=Integer.toString((int)(1+(Math.random()*5)));
                    //ciclo while para verificar si son las unicas dos opciones
                   do {                       
                       iOpcionNoValida=0;
                       //pregunta si le quiere calcular el igss
                        iPreguntaIgss=Integer.parseInt(JOptionPane.showInputDialog("Al empleado se le calcula igss \n1.Si\n2.No"));
                        switch(iPreguntaIgss){
                            case 1:
                                 sTotalDepartamento[i][10]=String.valueOf(iPreguntaIgss);
                                break;
                              case 2:
                                 sTotalDepartamento[i][10]=String.valueOf(iPreguntaIgss);
                                break;
                                //si la opcion es erronea vielve la variable iOpnoValida como 1
                              default:JOptionPane.showMessageDialog(null, "Opcion Invalida");
                              iOpcionNoValida=1;
                              
                        }
                        //mientras iOpcionNoValida sea 1 se seguira repitiendo el ciclo
                    } while ((iOpcionNoValida==1));                  
            }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
     
    //llamamos a Sueldo Liquido para poder obtener el total de cada empleado 
        SueldoLiquido();
    //mostramos todos los datos de la matriz en la tabla jtMatriz
        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(sTotalDepartamento, new String[]{"Codgio","Nombre Empleado","Sueldo Base","Bonificación","Comisiones","IGSS","Descuentos Judiciales","ISR","Sueldo Liquido","Departamento"}));
      //llamamos a la funcion fTotalDepartamento para obtener cada total para cada departamento
      fTotalDepartamento();
   //creamos una variable DefaultTableModel para hacer un modelo de lo que vamos a mostrar en la tabla
     DefaultTableModel dftTablaModelo = new DefaultTableModel(new String[]{"Total por Departamento"}, 0); 
        for (int i = 0; i < 5; i++) {
            //creamos un objeto para que guarde cada numero del vector que son los totales por departamento
            Object[] oTotales={dfFormato.format(dTotales[i])};             
            //agregamos una fila a la tabla
            dftTablaModelo.addRow(oTotales);            
        }
    //a la tabla de total le agregamos el model tabla para poder mostrar el total por departamento
     tblTotal.setModel(dftTablaModelo);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        //boton para limpiar las matriz y el vector ademas de las dos tablas
        //limpiarmos primero la matriz string sTotalDepartamento
        for (int i = 0; i < 10; i++) {
             sTotalDepartamento[i][0]="";
             sTotalDepartamento[i][1]="";
             sTotalDepartamento[i][2]="";
             sTotalDepartamento[i][3]="";
             sTotalDepartamento[i][4]="";
             sTotalDepartamento[i][5]="";
        }
        //limpiarmos el vector int iTotales
        for (int i = 0; i < 5; i++) {
            dTotales[i]=0;
        }
        //limpiamos la primera tabla, con una nueva variable obtenemos el modelo la tabla actualmente
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
    }//GEN-LAST:event_btnLimpiarActionPerformed
public void SueldoLiquido(){
        //ciclo for para obtener el sueldo liquido
            for (int i = 1; i <= 10; i++) {
                 iSueldoBase=Integer.parseInt(sTotalDepartamento[i][2]);
                 //enviamos a la funcion el sueldo y la opcion si es que se le puede calcular el igss....
                 dValorIGSS=fCalculoIGSS(iSueldoBase,sTotalDepartamento[i][10]);  
                 //enviamos a la funcion el sueldo base para calcular el isr
                 dValorIsr=fCalculoISR(iSueldoBase);
                 //llamamos a la funcion para el calculo de deducciones
                 dTotalDeducciones=fTotalDeducciones(dValorIGSS,Integer.parseInt(sTotalDepartamento[i][6]),dValorIsr);
                 //llamamos a la funcion para el calculo de percepciones
                 iTotalPercepciones=fTotalPercepciones(Integer.parseInt(sTotalDepartamento[i][4]),Integer.parseInt(sTotalDepartamento[i][3]));     
                 sTotalDepartamento[i][5]=dfFormato.format(dValorIGSS);
                 sTotalDepartamento[i][7]=dfFormato.format(dValorIsr);
                 //enviamos sueldo,deducciones y percepciones a funcion para obtener el sueldo liquido
                 dSueldoLiquido=fSueldoLiquido(iSueldoBase,dTotalDeducciones,iTotalPercepciones);
                 //convertimos a string el valor del sueldo liquido para poder guardar en matriz
                 sTotalDepartamento[i][8]=Double.toString(dSueldoLiquido);
            }
}
public static int fTotalPercepciones(int iBonificacion, int iComisiones){
    //funcion para calcular el total de percepciones del empleado
    int iTotalPercepciones=0;
    iTotalPercepciones=iBonificacion+iComisiones;
  return iTotalPercepciones;  
}
public static double fTotalDeducciones(double dIGSS, int iDescuentosJudiciales,double dISR){
    //funcion para calcular el total de deducciones del empleado
    double dTotalDeducciones=0;
    dTotalDeducciones=dIGSS+(double)(iDescuentosJudiciales)+dISR;
    return dTotalDeducciones;
}
public static double fCalculoIGSS(int iSueldo,String sOpcion){
    //funcion para verificar si al empleado se le puede calcular el igss
    double dIGSS = 0;
    if (sOpcion.equals("1")) {
        dIGSS=iSueldo*0.0483;
    }else if (sOpcion.equals("2")) {
        dIGSS=0;
    }
    return dIGSS;
}
 public static double fSueldoLiquido(int iSueldo,double dDeducciones,int iPercepciones){
        //funcion para calculo el sueldo liquido de cada empleado
    
     double iLiquido;
     //operamos
     iLiquido=(iSueldo+iPercepciones)-dDeducciones;
     //retornamos el valor
     return iLiquido;
     
 } 
  public static double fCalculoISR(int iRenta){
    //funcion para el calculo del isr del empleado
    int [][] iISR=new int[][]{{1,5000},{5001,10000},{10001,100000}};
    double dCalculoIsr = 0;
     if ((iRenta>=iISR[0][0]) && (iRenta<=iISR[0][1])) {
         dCalculoIsr=iRenta*0.03;
     }else if ((iRenta>=iISR[1][0]) && (iRenta<=iISR[1][1])) {
         dCalculoIsr=iRenta*0.05;
     }else if ((iRenta>=iISR[2][0]) && (iRenta<=iISR[2][1])) {
         dCalculoIsr=iRenta*0.1;
     }
        return dCalculoIsr;     
 }
 public void fTotalDepartamento(){
          //ciclo for para llenar el vector itotales
            for (int i = 1; i <= 10; i++) {
                   //convertimos a entero el valor del sueldo liquido para poder operar
                dSumador=Double.parseDouble(sTotalDepartamento[i][8]);
                //segun el numero del departamento sumamos las cantidades del sueldo liquido
                if (sTotalDepartamento[i][9].equals("1")) {
                    dTotales[0]=dTotales[0]+dSumador;
                }else if (sTotalDepartamento[i][9].equals("2")) {
                     dTotales[1]=dTotales[1]+dSumador;
                }else if (sTotalDepartamento[i][9].equals("3")) {
                     dTotales[2]=dTotales[2]+dSumador;
                }else if (sTotalDepartamento[i][9].equals("4")) {
                     dTotales[3]=dTotales[3]+dSumador;
                }else if (sTotalDepartamento[i][9].equals("5")) {
                     dTotales[4]=dTotales[4]+dSumador;
                             
                }
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
                new lab2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDepartamento1;
    private javax.swing.JLabel lblDepartamento2;
    private javax.swing.JLabel lblDepartamento3;
    private javax.swing.JLabel lblDepartamento4;
    private javax.swing.JLabel lblDepartamento5;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTable tblTotal;
    private javax.swing.JTable tblTotal1;
    // End of variables declaration//GEN-END:variables
}