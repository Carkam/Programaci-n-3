/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasEnlazadas;

/**
 *
 * @author Carlos Antonio Laib Contreras (0901-17-518)
 */
public class ListasEnlazadas
{    /*Clase donde se encuentran todos los metodos para las posibles
    operaciones con los metodos*/
    /*Se crea una variable de tipo nodo de nuestro Objeto Nodo*/
    	Nodo Primero;
        /*Metodo para inicializar el primer nodo como nulo*/
	public ListasEnlazadas()
	{           
		Primero=null;
	}       
      
        /*Metodo para verificar si la lista esta vacia*/
	public boolean EsVacia()
	{
		if (Primero==null)
		{
                    System.out.println("La lista esta vacia");
			return true;
		} else
		{
		System.out.println("La lista no esta vacia");
                return false;
		}
	}
        /*Metodo para insertar un nodo en la primera posicion y los demas nodos
        se corren para abajo*/
	public void InsertarEnPrimero(int Dato)
	{
		Nodo Temporal=new Nodo(Dato); //Crea el nodo temporal
		Temporal.Siguiente=Primero; //corre al primero
		Primero=Temporal;   //lo coloca de primero
	}
        /*Metodo para borrar el primer nodo que se encuentra en la lista*/
	public void borrarPrimero()
	{
            /*El primer nodo ahora se volvera el segundo borrando el primero*/
		Primero=Primero.Siguiente;
	}
        /*Metodo para mostrar todos los nodos de la lista*/
	public String Listar()
	{
                String Dato=" ";
		Nodo aux=Primero;
                /*Ciclo donde va almacenando la informacion de cada nodo en un string
                para luego mostrarlo*/
		while (aux!=null)
		{
			Dato+="{" + aux.info + "}";
			aux=aux.Siguiente;
		}
		return(Dato);
	}
        /*Metodo para borrar el ultimo nodo de la lista*/
	public void borrarUltimo()
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
                /*Ciclo para verificar en la lista mientras para hacer el ultimo nulo*/
		while (actual.Siguiente!=null)
		{
			anterior=actual;
			actual=actual.Siguiente;
		}
		anterior.Siguiente=null;
	}
        /*Metodo para borrar especificamente el nodo de una lista*/
	public void borrarPosicion(int pos)
	{
		Nodo anterior=Primero;
		Nodo actual=Primero;
		int k=0;
		if (pos>0)
		{
                    /*Ciclo para encontrar la posicion a buscar, borrar ese nodo y correr los demas*/
			while (k!=pos && actual.Siguiente != null)
			{
				anterior=actual;
				actual=actual.Siguiente;
				k++;
				System.out.println("K       "+k);
			}
			anterior.Siguiente=actual.Siguiente;
		}
	}
        /*Metodo para insertar un nodo entre nodos*/
        public void InsertarEntreNodos(int Dato, int pos){
            Nodo anterior=Primero;
            Nodo actual= Primero;
            Nodo Temporal=new Nodo(Dato);
            int k=0;
            /*Ciclo para encontrar la posicion a buscar y correr ese nodo e insertar el nuevo ahi*/
            if (pos>0) {
                while(k!=pos && actual.Siguiente!=null){
                    anterior=actual;
                    actual=actual.Siguiente;
                    Temporal.Siguiente=actual;
                    k++;
                }
                      
             anterior.Siguiente=Temporal;
             actual=Temporal.Siguiente; 
		
            }
        }
        /*Metodo para localizar el dato que se esta buscando*/
        public void Localizar(int Dato){
           Nodo aux=Primero;
           int posicion=0;
            if (aux.info==Dato) {
                System.out.println("Es el primero en la lista");
            }else{
                    while(aux.info!=Dato){
                       aux=aux.Siguiente; 
                       posicion++;
                    }
                  System.out.println("Esta en la posicion "+posicion);  
            }
        }

}
