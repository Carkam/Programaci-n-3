/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Inicio {      
        public static Pilas miPila = new Pilas();   
        public static void main(String[] args) {
         int iPregunta=0, iSeleccion;
         
         do {
            iSeleccion=Integer.parseInt(JOptionPane.showInputDialog("1.Insertar Libro(PUSH)\n2.Eliminar Libro(POP)"
                    + "\n3.Borrar Pila\n4.Mostrar Libro (TOP)\n5.Verificar si la pila esta Vacia\n6.Listar Pila"));
            switch(iSeleccion){
                case 1:
                    miPila.PUSH(new Libro(JOptionPane.showInputDialog("Ingrese el nombre del Libro"),JOptionPane.showInputDialog("Ingrese el nombre del Autor"),
                    JOptionPane.showInputDialog("Ingrese el numero isbn")));
                    titulos();                                                    
                    break;
                case 2:
                    titulos();
                     miPila.POP();
                     titulos();
                    break;
                case 3:
                    miPila.VaciarPila();
                    titulos();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,miPila.TOP());
                    break;
                case 5:
                   JOptionPane.showMessageDialog(null, "La pila esta vacia: "+miPila.estaVacia());                  
                    break;
                case 6:
                   titulos();
                    break;             
         
            }
             iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));
             while(iPregunta>2){
                  iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));   
             }
             
         } while (iPregunta!=1);             
    }
     public static void titulos(){
         JOptionPane.showMessageDialog(null, "No.                       Libro                                       Autor                                     Isbn\n"+miPila.Listar());
     }
    
}
