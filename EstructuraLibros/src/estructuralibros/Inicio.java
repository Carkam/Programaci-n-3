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
     public static void main(String[] args) {
         int iPregunta=0, iSeleccion;
          Lista miLista = new Lista();   
         do {
            iSeleccion=Integer.parseInt(JOptionPane.showInputDialog("1.Insertar Libro al principio\n2.Insetar Libro al Final"
                    + "\n3.Insertar Libro\n4.Buscar Libro\n5.Longitud de la lista\n6.Verificar Si la lista esta vacia"
                    + "\n7.Eliminar el primer libro\n8.Eliminar el ultimo libro\n9.Eliminar un libro\n10.Ver todos los libros"));
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
                   JOptionPane.showMessageDialog(null,"El tamaño de la lsita es de:  "+ miLista.contar());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, miLista.estaVacia());
                    break;
                case 7:
                    miLista.eliminaPrincipio();
                    break;
                case 8:
                    miLista.eliminarUltimo();
                    break;
                case 9:
                    miLista.eliminarLibro(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de libro que desea eliminar")));
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "No.                  Libro                     Autor                  Isbn\n"+miLista.Listar());
                    break;                   
            }
             iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));
             while(iPregunta>2){
                  iPregunta=Integer.parseInt(JOptionPane.showInputDialog("Desea salir?\n1.Si\n2.No"));   
             }
             
         } while (iPregunta!=1);             
    }
}
