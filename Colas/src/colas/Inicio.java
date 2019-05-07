/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import javax.swing.JOptionPane;

 /**
    * @author Carlos Antonio Laib Contreras (0901-17-518) 
    */
public class Inicio {
    
    
       public static Colas miCola = new Colas();   
        public static void main(String[] args) {
         int iPregunta=0, iSeleccion;
         
         do {
            iSeleccion=Integer.parseInt(JOptionPane.showInputDialog("1.Insertar Libro(QUEUE)\n2.Eliminar Libro(DEQUEUE)"
                    + "\n3.Borrar Cola\n4.Mostrar Libro Ultimo\n5.Verificar si la Cola esta Vacia\n6.Listar Cola\n7.Tamaño de la cola"));
            switch(iSeleccion){
                case 1:
                    miCola.QUEUE(new Libro(JOptionPane.showInputDialog("Ingrese el nombre del Libro"),JOptionPane.showInputDialog("Ingrese el nombre del Autor"),
                    JOptionPane.showInputDialog("Ingrese el numero isbn")));
                    titulos();                                                    
                    break;
                case 2:
                    titulos();
                     miCola.DEQUEUE();
                     titulos();
                    break;
                case 3:
                    miCola.Borrar_cola();
                    titulos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,miCola.TOP());
                    break;
                case 5:
                   JOptionPane.showMessageDialog(null, "La Cola esta vacia: "+miCola.estaVacia());                  
                    break;
                case 6:
                   titulos();
                    break;     
                case 7:
                    JOptionPane.showMessageDialog(null, "El tamaño de la cola es "+miCola.contar());
         
            }
             iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));
             while(iPregunta>2){
                  iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));   
             }
             
         } while (iPregunta!=1);             
    }
     public static void titulos(){
         JOptionPane.showMessageDialog(null, "No.                       Libro                                       Autor                                     Isbn\n"+miCola.Listar());
     }
    }

