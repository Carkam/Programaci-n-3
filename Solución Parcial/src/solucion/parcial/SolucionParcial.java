/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion.parcial;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *Carlos Antonio Laib Contreras
 * 0901-17-518
 * Variante B
 */
//El siguiente programa es para calcular la la nota promedio de la clase y enseñar la nota y si aprobro o no cada alumno
public class SolucionParcial {   
    //variables globales
   public static String[][] sDatosAlumno=new String[10][3];
   public static double dPromedioClase=0,dPromedio;
   
    public static void main(String[] args) {
        /* funcion principal donde se mandan a llamar a todos los metodos para obtener los nombres,
        las notas y para calcular la el promedio de toda la clase y verificar si el alumno reprueba o no
        */
         funRegistro();
         funPromedio();
         funMostrar();
               
         
    }
    public static void funRegistro(){
        /*Metodo donde se registran todos los nombres de los almunos y la nota de cada uno de ellos        
        */
          for (int i =0; i < 10; i++) {
            sDatosAlumno[i][0]=JOptionPane.showInputDialog("Ingrese el nombre del alumno #"+(i+1));
            sDatosAlumno[i][1]=Integer.toString((int) (1+(Math.random()*100)));
            //se manda a llamar la funcion funAprobo para verificar si el alumno aprobo o reprobo la clase
            sDatosAlumno[i][2]=funAprobo(sDatosAlumno[i][1]);
         } 
    }
    public static String funAprobo(String sNota){
        /*Funcion que recibe el valor de la nota del alumno y verifica si aprobo o no dependiendo de su resutlado
        */
        int iNotaAlumno=Integer.parseInt(sNota);
        if (iNotaAlumno>=61) {
            return "Aprobo";
        }else{
            return "Reprobo";
        }     
    }
    public static void funPromedio(){
        /*Metodo que calcula el promedio general de la clase
        */
       for (int i = 0; i < 10; i++) {
            dPromedio=dPromedio + Double.parseDouble(sDatosAlumno[i][1]);
       }    
        dPromedioClase=dPromedio/10;
    }
    public static void funMostrar(){
        /*Metodo donde despliega el nombre del alumno, su nota, si aprobo o no
        y el promedio general de la clase
        */
        //da un formato para el promedio
        DecimalFormat dfFormato=new DecimalFormat("0.00");
        System.out.println("Nombre\t\t\tNota\t\t\tAprobado o Reprobado\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(sDatosAlumno[i][0]+"\t\t\t"+sDatosAlumno[i][1]+"\t\t\t"+sDatosAlumno[i][2]);
        }    
        System.out.println("El Promedio de la clase es: "+dfFormato.format(dPromedioClase));
    }
}




















