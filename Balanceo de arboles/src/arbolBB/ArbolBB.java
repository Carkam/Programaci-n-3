/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author .
 */

public class ArbolBB {

    private Nodo nRaiz;
    int iNumerodeNodos;
    int iAltura;

    public ArbolBB() {
        nRaiz = null;
    }
    
// 
public Nodo InsertarArbolAVL(Nodo nNuevo, Nodo nPivote){
    //se delcara un nuevo nodo que recibe el valor del pivote
    Nodo nNuevoNodo=nPivote;
    //verifica si el el iDato del nodo nuevo es menor al iDato del nodo nuevo del pivote
     if(nNuevo.iDato<nPivote.iDato){
        //verifica si el lado izquierdo del nodo pivote es nulo
        if(nPivote.nIzquierda==null){
            //si es nulo el lado izquierdo ahora contendra al nodo nuevo
         nPivote.nIzquierda=nNuevo;
        }else{
            //si no se inicia un metodo recursivo donde se llama asi misma pero ahora enviando como pivote el lado izquierdo
            // del nodo
         nPivote.nIzquierda=InsertarArbolAVL(nNuevo, nPivote.nIzquierda);
         /*Luego de salir del metodo recursivo verifica si el factor de equilibro del lado izquierdo del pivote
         se le resta el factor de equilibrio del lado derecho del pivote para ver si el resultado es igual a 2*/
        if(obtenerFactore(nPivote.nIzquierda)-obtenerFactore(nPivote.nDerecha)==2){
            /*verifica si el dato  del nNuevo es menor al dato del nodo izquierdo del pivote*/
            if(nNuevo.iDato<nPivote.nIzquierda.iDato){
                /*Si se cumple la condicion el nuevonodo sera el valor retornado por la rotacion izquierda del pivote*/
                nNuevoNodo=RotarIzquierda(nPivote);
            }else{
                /*Si no el realizara una doble rotacion a la izquierda*/
                nNuevoNodo=RotacionDobleIzquierda(nPivote);
            }
        }
       }
        /*Si el dato del nodo recibido es mayor al dato del pivote*/
     }else if(nNuevo.iDato>nPivote.iDato){
         /*Verifica si el nodo de la derecha del pivote es nulo*/
        if(nPivote.nDerecha==null){
            /*El lado rerecha sera igual al nodo nuevo*/
                nPivote.nDerecha=nNuevo;
         }else{
            /*si no el nodo de la derecha del pivote iniciara una funcion recursiva y retornara un nuevo valor*/
            nPivote.nDerecha=InsertarArbolAVL(nNuevo,nPivote.nDerecha);
            /*si el factor de equilibro del lado derecho del pivote con la resta del factor de equilibrio del lado izquierdo del pivote
            da un resultado de 2*/
               if(obtenerFactore(nPivote.nDerecha)-obtenerFactore(nPivote.nIzquierda)==2){
                   /*Verifica si el dato del nodo recibido es mchos al dato del lado derecho del nodo pivote*/
                   if(nNuevo.iDato>nPivote.nDerecha.iDato){
                      /*Si se cumple la condicion el nuevonodo sera el valor retornado por la rotacion derecha del pivote*/
                    nNuevoNodo=RotarDerecha(nPivote);
                   }else{
                         /*Si no el realizara una doble rotacion a la derecha*/
                    nNuevoNodo=RotarDobleDerecha(nPivote);
                   }
               }
        }
        /*Si no*/
     }else{
         /*Mostrara un mensaje*/
     System.out.println("Nodo duplicado, no se puede colocar nodos duplicados");
     }
        //actualizando altura
        /*Si el lado izquierdo del pivote es nulo y el lado derecho es diferente de nulo*/
        if((nPivote.nIzquierda==null)&&(nPivote.nDerecha!=null)){
            /*el factor de equilibrieo del pivo ahora sera el factor de equilibreio del lado derecho del pivote sumandole 1*/
            nPivote.iFactore=nPivote.nDerecha.iFactore+1;
            /*Si el lado derecho del pivote es nulo y el lado izquierdo es diferente de nulo*/
        }else if((nPivote.nDerecha==null)&&(nPivote.nIzquierda!=null)){
             /*el factor de equilibrieo del pivote ahora sera el factor de equilibreio del lado izquierdo del pivote sumandole 1*/
           nPivote.iFactore=nPivote.nIzquierda.iFactore+1;         
           /*Si no*/
        }else{
            /*El factor de equilibrio del pivote sera ahora el maximo entre los dos lados del pivote mas 1*/
        nPivote.iFactore=Math.max(obtenerFactore(nPivote.nIzquierda),obtenerFactore(nPivote.nDerecha))+1;         
        }
        /*Retorna el nodo nuevo*/
     return nNuevoNodo;
}

public boolean InsertarDato(int iNumeroRecibido){
    /*Declara un nuevo nodo donde recibe el numero y los otros dos valores son nulos*/
    Nodo nNuevo= new Nodo(iNumeroRecibido,null,null);
    /*Si el nodo razi es nulo*/
        if(nRaiz==null){
            /*El nodo raiz obtiene el nuevo nodo*/
            nRaiz=nNuevo;
        }else{
            /*si no el nodo raiz llamara al metodo de insertar arbol avl mandadole el nuebo nodo y el nodo raiz*/
             nRaiz=InsertarArbolAVL(nNuevo,nRaiz);
        }
        /*Pone la variable boolena como true*/
  return true;
}
    public Nodo getnRaiz() {
        /*Retorna la raiz*/
        return nRaiz;
    } 

    public void setnRaiz(Nodo nRaiz) {
        /*Manda el valor de raiz*/
        this.nRaiz = nRaiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (nRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        /*Crea una lista enlazada para el recorrido*/
        LinkedList llRecorrido = new LinkedList();
        /*Manda a llamar al metodo de preorden*/
        preOrden(nRaiz, llRecorrido);
        /*Retorna la lista enlazada*/
        return llRecorrido;
    }
    
    public void preOrden(Nodo aux, LinkedList recorrido) {
        /*Su aux es diferente nulo*/
        if (aux != null) {
            /*Agrega un elemento a la lista*/
            recorrido.add(aux.getiDato());
            /*Empieza un metodo recursivo */
            preOrden(aux.getnIzquierda(), recorrido);
            /*Luego de salir rempieza otro metodo recusrivo llamanodo se a el mismo*/
            preOrden(aux.getnDerecha(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (nRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        /*Crea una lista enlazsada*/
        LinkedList llRecorridoinOrden = new LinkedList();
        /*Manda a llamar al metodo de inorden*/
        inOrden(nRaiz, llRecorridoinOrden);
        /*Luego retorana esta lista enlazada*/
        return llRecorridoinOrden;
    }
    
    public void inOrden(Nodo aux, LinkedList recorrido) {
        /*Si el auxiliar es diferente de nulo*/
        if (aux != null) {
            /*Empieza un metodo recusrivo llamandose a si misma*/
            inOrden(aux.getnIzquierda(), recorrido);
            /*Agrega el elemento a la lista enlazada*/
            recorrido.add(aux.getiDato());
            /*Empieza otra vez un metodo recursivo*/
            inOrden(aux.getnDerecha(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (nRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        /*Crea una lista en lazada*/
        LinkedList llRecorricopost = new LinkedList();
        /*Manda a llamar al metodo post orden*/
        postOrden(nRaiz, llRecorricopost);
        /*Retorna la lista*/
        return llRecorricopost;
    }
    public void postOrden(Nodo aux, LinkedList recorrido) {
        /*Si auxiliar es diferente de nulo*/
        if (aux != null) {
            /*Se llama asi misma para empezar un metodo recursivo*/
            postOrden(aux.getnIzquierda(), recorrido);
            /*Luego empieza otro metodo recursivo*/
            postOrden(aux.getnDerecha(), recorrido);
            /*Agrega el elemento a la lista enlazada*/
            recorrido.add(aux.getiDato());
        }
    }
    public int obtenerFactore(Nodo nRecibido){
            //Revisa si el nodo es nulo
            if(nRecibido==null){
                //si es nulo retorna -1
            return -1;
            }else{
                //si no retorna el factor de equilibrio del nodo
            return nRecibido.iFactore;
            } 
        }
        //Metodo de rotacion doble a la izquierda
         public Nodo RotacionDobleIzquierda(Nodo nRecibido){
            Nodo nAuxiliar;
            //primero llama a la derecha 
            nRecibido.nIzquierda=RotarDerecha(nRecibido.nIzquierda);
            //luego llama para rotar el arbol a la izquierda
            nAuxiliar=RotarIzquierda(nRecibido);
            //regresa el auxiliar
            return nAuxiliar;
            }
         //Metodo de rotacion doble a la derecha
            public Nodo RotarDobleDerecha(Nodo nRecibido){
            Nodo nAuxiliar;
            //primero llama la rotacion a la izquierda
            nRecibido.nDerecha=RotarIzquierda(nRecibido.nDerecha);
            //luego llama la rotacion a la derecha
            nAuxiliar=RotarDerecha(nRecibido);
            //regresa el auxiliar
            return nAuxiliar;
            }
            //metodo de rotacion  a la izquierda
        public Nodo RotarIzquierda(Nodo nRecibido){
            //el nodo auxiliar va a ser igual al nodo izquierdo del nodo recibido
        Nodo nAuxiliar= nRecibido.nIzquierda;
        //el  nodo izquierdo del nodo r ahora sera el nodo derecho del auxiliar
        nRecibido.nIzquierda=nAuxiliar.nDerecha;
        //el nodo derecho del auxiliar ahora sera el nodo recibido
        nAuxiliar.nDerecha=nRecibido;
        //obtiene el factor de equilibro maximo del nodo r  y le suma 1
        nRecibido.iFactore=Math.max(obtenerFactore(nRecibido.nIzquierda), obtenerFactore(nRecibido.nDerecha))+1;
        //obtiene el factor de equilibrio maximo del nodo auxiliar y le suma 1
        nAuxiliar.iFactore=Math.max(obtenerFactore(nAuxiliar.nIzquierda),obtenerFactore(nAuxiliar.nDerecha))+1;
        //retorna auxiliar
        return nAuxiliar;
        }
        //metodo de rotacion doble a la derecha
        public Nodo RotarDerecha(Nodo nRecibido){
    //el nodo auxiliar va a ser igual al nodo derecho del nodo recibido
    Nodo nAuxiliar= nRecibido.nDerecha;
    //el  nodo izquierdo del nodo r ahora sera el nodo izquierda del auxiliar
    nRecibido.nDerecha=nAuxiliar.nIzquierda;
     //el nodo ixquierdo del auxiliar ahora sera el nodo recibido
    nAuxiliar.nIzquierda=nRecibido;
     //obtiene el factor de equilibro maximo del nodo r  y le suma 1
    nRecibido.iFactore=Math.max(obtenerFactore(nRecibido.nIzquierda), obtenerFactore(nRecibido.nDerecha))+1;
      //obtiene el factor de equilibrio maximo del nodo auxiliar y le suma 1
    nAuxiliar.iFactore=Math.max(obtenerFactore(nAuxiliar.nIzquierda),obtenerFactore(nAuxiliar.nDerecha))+1;
       //retorna auxiliar
    return nAuxiliar;
    }
    //Metodo para verificar si hay un nodo en el arbol
    public boolean VerificarExistencia(int dato) {
        Nodo aux = nRaiz;
        /*Mientras aux sea diferente de nulo*/
        while (aux != null) {
            /*Verifica si el dato recibido es igual al dato es igual al dato que tiene el nodo*/
            if (dato == aux.getiDato()) {
                /*Retorna verdadero*/
                return true;
                /*Sino verifica si el dato es mayor que el del nodo*/
            } else if (dato > aux.getiDato()) {
                /*Auxiliar ahora sera el nodo de la deracha*/
                aux = aux.getnDerecha();
                /*Sino*/
            } else {
                /*Auxiliar sera el nodo de la izquierda*/
                aux = aux.getnIzquierda();
            }
        }
        /*Retorna falso*/
        return false;
    }
/*Metodo para dibujar en el panel*/
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
