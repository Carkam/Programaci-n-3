/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author Carlos Antonio Laib Contreras (0901-17-518)
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    /*Se declara una variable nodo que sera nula*/
	private Nodo cabeza=null;
        /*Se declara una variable para tener la longitud de la cola*/
	private int longitud=0;
        /*Clase donde se declara el nodo y la informacion que este tendra*/
	private class Nodo {
                /*Variable de tipo libro para contener la informacion necesario de un libro*/
		public Libro libro;
                /*Variable siguiente para poder enlazar la cola*/
		public Nodo siguiente=null;
		public Nodo(Libro libro) {
			this.libro=libro;
		}
	}
	
	public void QUEUE(Libro libro) {
            /*Metodo para insertar al final de la cola
            Se crea una nueva variable nodo que contendra la infmracion del libro*/
		Nodo nodo=new Nodo(libro);
                /*Si cabeza es nula*/
		if (cabeza==null) {
                    /*Cabeza tendra la nueva informacion del nuevo nodo*/
			cabeza=nodo;
                 /*Si no entonces*/       
		} else {
                    /*Se declara una variable nueva que contendra lo que actuamente tiene cabeza*/
			Nodo puntero=cabeza;
                        /*Mientras el puntero siguiente sea diferente de nulo se cambiara la posicion de donde
                        estamos recorriendo la cola*/
			while (puntero.siguiente!=null) {
                            /*Puntero ahora cambiara de posicion al siguiente nodo*/
				puntero=puntero.siguiente;
			}
                        /*Cuando salga del cilo diremos que el siguiente nodo tendra la informacion del nuevo 
                        nodo ingresado*/
			puntero.siguiente=nodo;
		}
                /*Se aumenta la longitud del contador*/
		longitud++;
	}
	
	public String obtener(int n) {
            /*Metodo para obtener la infrmacion de un libro especifico
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
			int contador=0;
                        /*Mientras el contador sea menor al dato que se busca y el siguiente nodo de puntero sea diferente de nulo
                        entonces cambiara de posicion el puntero*/
			while (contador<n && puntero.siguiente!=null) {
                            /*Puntero ahora cambiara de posicion al siguiente nodo*/
				puntero=puntero.siguiente;
                             /*Le sumaremos 1 al contador para poder terminar el ciclo*/   
				contador++;
			}
                        /*Si contador es diferente del dato que se quiere buscar*/
			if (contador!=n) {
                            /*Este retornara nulo*/
				return null;
                       /*Si no entonces*/         
			} else {
                            Dato="Libro: "+puntero.libro.getTitulo()+"      Autor: "+puntero.libro.getAutor()+"         Isbn: "+puntero.libro.getIsbn();
				return Dato;
			}
		}
	}
	public int contar() {
            /*Metodo para determinar la longitud de la cola*/
		return longitud;
	}
           public String estaVacia() {
            /*Metodo para determinar si la cola esta vacia
            Verifica si la cola esta via*/
            if (cabeza==null) {
                return "La Cola esta Vacia";
            }else{
                return "La Cola no esta Vacia";
            }
           
        }
        public void DEQUEUE() {
            /*Metodo para eliminar el primer nodo de la cola
            si cabeza es diferente de nulo*/
            if (cabeza!=null){
                /*Se declara un nodo que contendra lo de cabeza*/
                Nodo primer = cabeza;
                /*A cabeza se le cambiara de posicion y la anterior se volvera nula*/
                cabeza=cabeza.siguiente;
                primer=null;
                /*Se le resta uno para diminuir el tamaño de la cola*/
                longitud--;
            }
        }      
        public String Listar()
                /*Metodo para mostrar todos los elementos de la cola*/
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
 public String TOP() {
            /*Metodo para obtener la informacion que esta al principio de la cola
            Si cabeza es nulo*/
            String Dato="";
		if (cabeza==null) {
                    /*Retornara nulo*/
			return null;
               /*Si no se cumple entonces*/
		} else {
                    /*Se declara una variable que sera lo que actualmente esta en puntero*/
			Nodo puntero=cabeza;
                       /*Se regresa la informacion del libro que esta en el tope de la cola*/
                       Dato="Libro: "+puntero.libro.getTitulo()+"      Autor: "+puntero.libro.getAutor()+"         Isbn: "+puntero.libro.getIsbn();
			return Dato;
		}
	}
        public void Borrar_cola(){
            /*Metodo para vaciar la cola
            si cabeza es diferetne de nulo*/
            if (cabeza!=null){
                /*Se declara un nodo que contendra lo de cabeza*/
                Nodo primer = cabeza;
                /*A cabeza se le vuelve nula*/
                cabeza=cabeza.siguiente=null;
                /*El primero tambien se hace nulo*/
                primer=null;
                /*Se vuelve la longitud 0 para comenzar la cola nuevamente desde cero*/
                longitud=0;
            }
        }
    
}
