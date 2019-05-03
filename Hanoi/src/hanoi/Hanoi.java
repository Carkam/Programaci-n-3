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
     * @param args the command line arguments
     */
    public static Pilas pPila1=new Pilas();
    public static Pilas pPila2=new Pilas();
    public static Pilas pPila3=new Pilas();
    public static void main(String[] args) {
        int iCantidadDiscos;
        iCantidadDiscos=Integer.parseInt(JOptionPane.showInputDialog("Cuantos discos desea?"));
           for (int i = iCantidadDiscos; i >=1; i--) {
             pPila1.PUSH(i);
           }
        System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");
       PasosHanoi(iCantidadDiscos,1,2,3);
    }          
    public static void PasosHanoi(int Numero, int iOrigen, int iAuxiliar, int iDestino){
        if (Numero==1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            CambiarDisco(iOrigen,iDestino); 
            System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");
        }else{
            PasosHanoi(Numero-1,iOrigen,iDestino,iAuxiliar);
            CambiarDisco(iOrigen,iDestino);         
              try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            System.out.println("Origen\t\t"+pPila1.Listar()+ "\nAuxiliar\t"+pPila2.Listar()+"\nDestino\t\t"+pPila3.Listar()+"\n");            
            PasosHanoi(Numero-1,iAuxiliar,iOrigen,iDestino);
        }
    } 
    public static void CambiarDisco(int iOrigen, int iDestino){
      int iNumeroAuxiliar = 0;    
         
        if (iOrigen==1) {
            iNumeroAuxiliar=Integer.parseInt(pPila1.TOP());           
            pPila1.POP();
        }else if (iOrigen==2) {
            iNumeroAuxiliar=Integer.parseInt(pPila2.TOP());           
              pPila2.POP();
        }else if (iOrigen==3) {
            iNumeroAuxiliar=Integer.parseInt(pPila3.TOP());       
             pPila3.POP();
        }
        
        
          if (iDestino==1) {       
            pPila1.PUSH(iNumeroAuxiliar);
        }else if (iDestino==2) {           
            pPila2.PUSH(iNumeroAuxiliar);
        }else if (iDestino==3) {              
            pPila3.PUSH(iNumeroAuxiliar);
        }
    }
            
}
