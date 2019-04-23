/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author alumno
 */
public class Pilas {

    /**
    * @author Carlos Antonio Laib Contreras (0901-17-518)
    */
    /**
 *
 *@author Carlos Antonio Laib Contreras (0901-17-518)
 */

    /*Se declara una variable nodo que sera nula*/
	private Nodo cabeza=null;
        /*Se declara una variable para tener la longitud de la pila*/
	private int longitud=0;
        /*Clase donde se declara el nodo y la informacion que este tendra*/
	private class Nodo {
                /*Variable de tipo libro para contener la informacion necesario de un libro*/
		public Libro libro;
                /*Variable siguiente para poder enlazar la lista*/
		public Nodo siguiente=null;
		public Nodo(Libro libro) {
			this.libro=libro;
		}
	}
	public void PUSH(Libro libro) {
            /*Metodo para insertar al principio de la pila
            Se crea una nueva variable nodo que contendra la informacion del libro*/
		Nodo nodo=new Nodo(libro);
                /*Decimos que el siguiente nodo ahora sera lo que tiene cabeza*/
		nodo.siguiente=cabeza;
                /*Y cabeza ahora tendra la nueva infomracion del nuevo nodo ingresado*/
		cabeza=nodo;
                /*Se aumenta la longitud del contador*/
		longitud++;	
	}
	
	public String TOP() {
            /*Metodo para obtener la informacion que esta al principio
            Si cabeza es nulo*/
            String Dato="";
		if (cabeza==null) {
                    /*Retornara nulo*/
			return null;
               /*Si no se cumple entonces*/
		} else {
                    /*Se declara una variable que sera lo que actualmente esta en puntero*/
			Nodo puntero=cabeza;
                       /*Se inicializa un contador que comenzara en 0*/
                       Dato="Libro: "+puntero.libro.getTitulo()+"      Autor: "+puntero.libro.getAutor()+"         Isbn: "+puntero.libro.getIsbn();
			return Dato;
		}
	}
        public String estaVacia() {
            /*Metodo para determinar si la lista esta vaica*/
            if (cabeza==null) {
                return "La pila esta Vacia";
            }else{
                return "La pula no esta Vacia";
            }
           
        }
        public void POP() {
            /*Metodo para eliminar el primer nodo de la lista
            si cabeza es diferente de nulo*/
            if (cabeza!=null){
                /*Se declara un nodo que contendra lo de cabeza*/
                Nodo primer = cabeza;
                /*A cabeza se le cambiara de posicion y la anterior se volvera nula*/
                cabeza=cabeza.siguiente;
                primer=null;
                /*Se le resta uno para diminuir el tamaño de la lista*/
                longitud--;
            }
        }
       
        public String Listar()
                /*Metodo para mostrar todos los elementos de la lista*/
	{
                String Dato="";
		Nodo aux=cabeza;
                int n=0;
                /*Ciclo donde va almacenando la informacion de cada nodo en un string
                para luego mostrarlo*/
		while (aux!=null)
		{
                    
			Dato+=n+"                           "+ aux.libro.getTitulo()+"                              "+aux.libro.getAutor()+"                           "+aux.libro.getIsbn()+ "\n";
			aux=aux.siguiente;
                        n++;
		}            
		return(Dato);
                
	}
        public void VaciarPila(){
            /*Metodo para vaciar la lista
            si cabeza es diferetne de nulo*/
            if (cabeza!=null){
                /*Se declara un nodo que contendra lo de cabeza*/
                Nodo primer = cabeza;
                /*A cabeza se le vuelve nula*/
                cabeza=cabeza.siguiente=null;
                /*El primero tambien se hace nulo*/
                primer=null;
                /*Se vuelve la longitud 0 para comenzar la lista nuevamente desde cero*/
                longitud=0;
            }
        }
} 

