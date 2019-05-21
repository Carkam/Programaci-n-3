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
            /*si el factor del pivote */
            nPivote.iFactore=nPivote.nDerecha.iFactore+1;
        }else if((nPivote.nDerecha==null)&&(nPivote.nIzquierda!=null)){
           nPivote.iFactore=nPivote.nIzquierda.iFactore+1;         
        }else{
        nPivote.iFactore=Math.max(obtenerFactore(nPivote.nIzquierda),obtenerFactore(nPivote.nDerecha))+1;         
        }
     return nNuevoNodo;
}

        public boolean insertar(int d){
          Nodo nuevo= new Nodo(d,null,null);
        if(nRaiz==null){
        nRaiz=nuevo;
        }else{
        nRaiz=InsertarArbolAVL(nuevo,nRaiz);
        }
        return true;
        }
    public Nodo getnRaiz() {
        return nRaiz;
    } 

    public void setnRaiz(Nodo nRaiz) {
        this.nRaiz = nRaiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (nRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(nRaiz, rec);
        return rec;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getiDato());
            preorden(aux.getnIzquierda(), recorrido);
            preorden(aux.getnDerecha(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (nRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(nRaiz, rec);
        return rec;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getnIzquierda(), recorrido);
            recorrido.add(aux.getiDato());
            inorden(aux.getnDerecha(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (nRaiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(nRaiz, rec);
        return rec;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getnIzquierda(), recorrido);
            postorden(aux.getnDerecha(), recorrido);
            recorrido.add(aux.getiDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Nodo aux = nRaiz;
        while (aux != null) {
            if (dato == aux.getiDato()) {
                return true;
            } else if (dato > aux.getiDato()) {
                aux = aux.getnDerecha();
            } else {
                aux = aux.getnIzquierda();
            }
        }
        return false;
    }

     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
