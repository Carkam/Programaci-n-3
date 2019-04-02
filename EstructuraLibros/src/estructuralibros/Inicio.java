/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Antonio Laib Contreras (0901-17-518)
 * Programa para pedir datos de un libro e ingresarlos a una lista
 */
public class Inicio {
     public static Lista miLista = new Lista();   
     public static void main(String[] args) {
         int iPregunta=0, iSeleccion;
         
         do {
            iSeleccion=Integer.parseInt(JOptionPane.showInputDialog("1.Insertar Libro al principio\n2.Insetar Libro al Final"
                    + "\n3.Insertar Libro\n4.Buscar Libro\n5.Longitud de la lista\n6.Verificar Si la lista esta vacia"
                    + "\n7.Eliminar el primer libro\n8.Eliminar el ultimo libro\n9.Eliminar un libro\n10.Ver todos los libros\n11.Vaciar la lista"));
            switch(iSeleccion){
                case 1:
                    miLista.insertarPrincipio(new Libro(JOptionPane.showInputDialog("Ingrese el nombre del Libro"),JOptionPane.showInputDialog("Ingrese el nombre del Autor"),
                    JOptionPane.showInputDialog("Ingrese el numero isbn")));
                    break;
                case 2:
                     miLista.insertarFinal(new Libro(JOptionPane.showInputDialog("Ingrese el nombre del Libro"),JOptionPane.showInputDialog("Ingrese el nombre del Autor"),
                    JOptionPane.showInputDialog("Ingrese el numero isbn")));
                    break;
                case 3:
                    miLista.insertarDespues(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion donde quiere ingresar el libro")),new Libro(JOptionPane.showInputDialog("Ingrese el nombre del Libro"),JOptionPane.showInputDialog("Ingrese el nombre del Autor"),
                    JOptionPane.showInputDialog("Ingrese el numero isbn")));
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,miLista.obtener(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de libro que desea obtener"))));
                    break;
                case 5:
                   JOptionPane.showMessageDialog(null,"El tamaño de la lista es de:  "+ miLista.contar());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "La lista esta vacia: "+miLista.estaVacia());
                    break;
                case 7:
                    titulos();
                    miLista.eliminaPrincipio();
                    JOptionPane.showMessageDialog(null, "Elemento del principio eliminado");
                    titulos();
                    break;
                case 8:
                     titulos();
                    miLista.eliminarUltimo();
                    JOptionPane.showMessageDialog(null, "Elemento del final eliminado");
                     titulos();
                    break;
                case 9:
                    titulos();
                    miLista.eliminarLibro(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de libro que desea eliminar")));
                    JOptionPane.showMessageDialog(null, "Elemento eliminado");
                    titulos();
                    break;
                case 10:
                    titulos();
                    break;                 
                case 11:
                    miLista.VaciarLista();
                    JOptionPane.showMessageDialog(null, "La lista se vacio exitosamente");
                    break;
            }
             iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));
             while(iPregunta>2){
                  iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));   
             }
             
         } while (iPregunta!=1);             
    }
     public static void titulos(){
         JOptionPane.showMessageDialog(null, "No.                       Libro                                       Autor                                     Isbn\n"+miLista.Listar());
     }
}
