/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**
 *
 * @Carlos Antonio Laib Contreras (0901-17-518)
 */
public class Nodo {
    /*Declara variables enteras y de tipo nodo*/
    public int iDato, iFactore;
    public Nodo nIzquierda,nDerecha;
/*Metodo general que recibe los datos*/
    public Nodo(int dato, Nodo Izquierda, Nodo Derecha) {
        this.iDato = dato;
        this.nIzquierda = Izquierda;
        this.nDerecha = Derecha;
        this.iFactore=0;
    }
/*Metodo que retorna el dato*/
    public int getiDato() {
        return iDato;
    }
/*Metodo que envia el dato*/
    public void setiDato(int iDato) {
        this.iDato = iDato;
    }
/*Metodo que retorna el nodo izquierda*/
    public Nodo getnIzquierda() {
        return nIzquierda;
    }
/*Metodo que envia el nodo izquierdo*/
    public void setnIzquierda(Nodo nIzquierda) {
        this.nIzquierda = nIzquierda;
    }
/*Metodo que retorna el nodo derecho*/
    public Nodo getnDerecha() {
        return nDerecha;
    }
/*Metodo que envia el nodo izquierdo*/
    public void setnDerecha(Nodo nDerecha) {
        this.nDerecha = nDerecha;
    }
 
}
