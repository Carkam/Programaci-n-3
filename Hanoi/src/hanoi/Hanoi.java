/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Hanoi {

      /**
    * @author Carlos Antonio Laib Contreras (0901-17-518)
    */
    /*Variables globales que seran las 3 torres */
    public static Pilas pPila1=new Pilas();
    public static Pilas pPila2=new Pilas();
    public static Pilas pPila3=new Pilas();
    public static void main(String[] args) {
        /*Metodo principal para llenar las pilas y ejecutar el metodo recursivo*/
        int iCantidadDiscos;
        iCantidadDiscos=Integer.parseInt(JOptionPane.showInputDialog("Cuantos discos desea?"));
        /*Llenamos la pila dependiendo del numero de discos que se desea*/
           for (int i = iCantidadDiscos; i >=1; i--) {
               /*Hacemos un push en la pila 1*/
             pPila1.PUSH(i);
           }
           /*Mostramos las 3 pilas*/
        System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");
        /*Mandamos a llamar al metodo recursivo*/
       PasosHanoi(iCantidadDiscos,1,2,3);
    }          
    public static void PasosHanoi(int Numero, int iOrigen, int iAuxiliar, int iDestino){
           /*Metodo recursivo donde verifica que disco es para hacer el movimiento*/
        if (Numero==1) {
            Retraso();
            /*Llama al siguiente metodo para poder sacar o meter el numero de la pila*/
            CambiarDisco(iOrigen,iDestino); 
            /*Mostramos las 3 pilas*/
            System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");
        }else{
            /*Llamada asi misma intercambiando los valores que esta recibiendo*/
            PasosHanoi(Numero-1,iOrigen,iDestino,iAuxiliar);
            /*Llama al siguiente metodo para poder sacar o meter el numero de la pila*/
            CambiarDisco(iOrigen,iDestino);         
            Retraso();
            /*Mostramos las 3 pilas*/
            System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");   
            /*Llamada asi misma intercambiando los valores que esta recibiendo*/
            PasosHanoi(Numero-1,iAuxiliar,iOrigen,iDestino);
        }
    } 
    
    public static void CambiarDisco(int iOrigen, int iDestino){
        /*Metodo donde saca la infomracion o mete la informacion de la pila dependiendo
        de las dos variables recibidas*/
      int iNumeroAuxiliar = 0;    
         /*Si es numero 1*/
        if (iOrigen==1) {
            /*Guarda el numero que esta en el tope de la pila*/
            iNumeroAuxiliar=Integer.parseInt(pPila1.TOP());  
            /*y lo saca que la pila*/
            pPila1.POP();
            /*Si es dos*/
        }else if (iOrigen==2) {
            iNumeroAuxiliar=Integer.parseInt(pPila2.TOP());           
              pPila2.POP();
          /*Si es 3*/    
        }else if (iOrigen==3) {
            iNumeroAuxiliar=Integer.parseInt(pPila3.TOP());       
             pPila3.POP();
        }
        
        /*Si el destino es 1*/
          if (iDestino==1) {
              /*Mete el numero en la pila*/
            pPila1.PUSH(iNumeroAuxiliar);
          /*Si el destino es 2*/  
        }else if (iDestino==2) {           
            pPila2.PUSH(iNumeroAuxiliar);
         /*Si el destino es 3*/   
        }else if (iDestino==3) {              
            pPila3.PUSH(iNumeroAuxiliar);
        }
    }
     
    public static void Retraso(){
        /*Metodo para parar el programa momentaneamente*/
        try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
}
