/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

/**
 *
 *@author Carlos Antonio Laib Contreras (0901-17-518)
 */
public class Lista {
    /*Se declara una variable nodo que sera nula*/
	private Nodo cabeza=null;
        /*Se declara una variable para tener la longitud de la lista*/
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
	public void insertarPrincipio(Libro libro) {
            /*Metodo para insertar al principio de la lista
            Se crea una nueva variable nodo que contendra la informacion del libro*/
		Nodo nodo=new Nodo(libro);
                /*Decimos que el siguiente nodo ahora sera lo que tiene cabeza*/
		nodo.siguiente=cabeza;
                /*Y cabeza ahora tendra la nueva infomracion del nuevo nodo ingresado*/
		cabeza=nodo;
                /*Se aumenta la longitud del contador*/
		longitud++;	
	}
	public void insertarFinal(Libro libro) {
            /*Metodo para insertar al final de la lista
            Se crea una nueva variable nodo que contendra l ainfmracion del libro*/
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
                        estamos recorriendo la lista*/
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
	public void insertarDespues(int n, Libro libro) {
            /*Metodo para insetar un nodo entre dos nodos
            Se crea una nueva vaible nodo que contendra la informacion del libro*/
		Nodo nodo=new Nodo(libro);
                /*Si cabeza es nula*/
		if (cabeza==null) {
                    /*Cabeza tendra la nueva informacion del nuevo nodo*/
			cabeza=nodo;
                  /*Si no entonces*/      
		} else {
                    /*Se declara una nueva variable que sera lo que actuamente esta en cabeza*/
			Nodo puntero=cabeza;
                        /*Se declara un contador que comenzara en cero*/
			int contador=0;
                        /*Mientras el contador sea menor a la posicion donde se desea buscar y el siguiente nodo sea diferente de nulo
                        entonces el punto cambiara de posicion al siguiente nodo*/
			while (contador<n && puntero.siguiente!=null) {
                            /*Puntero ahora cambiara de posicion al siguiente nodo*/
				puntero=puntero.siguiente;
                                /*Le sumaremos 1 al contador para poder terminar el ciclo*/
				contador++;
			}
                        /*El siguiente nodo ahora contendra lo que tiene el siguiente nodo de la variable putnero*/
			nodo.siguiente=puntero.siguiente;
                        /*El siguiente nodo de puntero ahora tendra la nueva informacion del nuevo nodo*/
			puntero.siguiente=nodo;
		}
                /*Se incrementa el tamaño de la lista*/
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
            /*Metodo para determinar la longitud de la lista*/
		return longitud;
	}
        public boolean estaVacia() {
            /*Metodo para determinar si la lista esta vaica*/
            return cabeza==null;
        }
        public void eliminaPrincipio() {
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
        public void eliminarUltimo() {
            /*Metodo para eliminar el ultimo nodo de la lista
            si cabeza es diferente de nulo*/
            if (cabeza!= null) {
                /*Si el nulo siguiente es nulo entonces*/
                if (cabeza.siguiente==null) {
                    /*Cabeza la hara nula*/
                    cabeza=null;  
                    /*Restara uno para disminuir el tamaño de la lista*/
                    longitud--;
                    /*Si no entonces*/
                } else {
                   /*Se declara una nueva variable que sera lo que actuamente esta en cabeza*/
                    Nodo puntero=cabeza;
                    /*Mientras dos nodos siguientes sea diferente de nulo entonces el puntero camabiara al siguiente nodo*/
                    while (puntero.siguiente.siguiente!=null) {                    
                        /*El puntero cambia de posicion al siguiente nodo*/
                        puntero=puntero.siguiente;
                    }
                    /*Vuelve el siguiente nodo nulo*/
                    puntero.siguiente=null;
                    /*Se le resta uno para disminuir el tamaño de la lista*/
                    longitud--;
                }
            }
        }
        public void eliminarLibro(int n) {
            /*Metodo para eliminar un libro en especifico
            si cabeza es diferente de nulo*/
            if (cabeza!=null){
                /*Si la posicion a buscar es diferente es igual a 0*/
                if (n==0){
                    /*Se crea una nueva variable que sera lo que actualmente esta en cabeza*/
                    Nodo primer=cabeza;
                    /*Cabeza ahora tendra la informacion del siguiente nodo*/
                    cabeza=cabeza.siguiente;                               
                    /*Primer ahora se volvera nulo*/
                    primer=null;
                    /*Se le resta uno para disminuir el tamaño de la lista*/
                    longitud--;
                 /*Si no entonces verifica si n es menor a la longitud de la lista*/   
                } else if (n<longitud) {
                    /*Se declara una nueva variable que sera lo que actualmente esta en cabeza*/
                    Nodo puntero=cabeza;
                    /*Se declara un contador en 0*/
                    int contador=0;
                    /*Mientras el contador sea menor a la resta del dato buscado menos 1 entonces
                    el puntero cambiara de posicion al siguiente nodo*/
                    while (contador<(n-1)){
                        /*El puntero cambia de posicion al siguiente nodo*/
                        puntero=puntero.siguiente;
                        /*El contador se le suma 1 para poder salir del ciclo*/
                        contador++;
                    }
                    /*Se crea una variable temporal que contendra al puntero siguiente*/
                    Nodo temp=puntero.siguiente;
                    /*El puntero siguiente ahora contendra el nodo siguiente del nodo temporal*/
                    puntero.siguiente=temp.siguiente;
                    /*El nodo temporal y el temporal siguiente se hacen nulos para liberar memoria*/
                    temp.siguiente=null;
                    temp=null;
                    /*Se le resta uno para disminuir la longitud de la lista*/
                    longitud--;
                }
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
        public void VaciarLista(){
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
