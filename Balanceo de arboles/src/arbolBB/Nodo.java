/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @author
 */
public class Nodo {
    public int iDato, iFactore;
    public Nodo nIzquierda,nDerecha;

    public Nodo(int dato, Nodo Izquierda, Nodo Derecha) {
        this.iDato = dato;
        this.nIzquierda = Izquierda;
        this.nDerecha = Derecha;
        this.iFactore=0;
    }

    public int getiDato() {
        return iDato;
    }

    public void setiDato(int iDato) {
        this.iDato = iDato;
    }

    public Nodo getnIzquierda() {
        return nIzquierda;
    }

    public void setnIzquierda(Nodo nIzquierda) {
        this.nIzquierda = nIzquierda;
    }

    public Nodo getnDerecha() {
        return nDerecha;
    }

    public void setnDerecha(Nodo nDerecha) {
        this.nDerecha = nDerecha;
    }
 
}
