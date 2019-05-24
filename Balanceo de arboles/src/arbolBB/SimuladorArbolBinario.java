
package arbolBB;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @Carlos Antonio Laib Contreras (0901-17-518)
 */
public class SimuladorArbolBinario {
    /*Declara una variable de una clase*/
    ArbolBB miArbol = new ArbolBB();

    public SimuladorArbolBinario() {
    }
    /*Envia datos para ingresarlo al la lista enlazada*/
    public boolean InsertarDato(Integer dato) {
        return (this.miArbol.InsertarDato(dato));
    }
    //metodo para mostrar los recorridos del arbol
    public String preOrden() {/*Metodo que muestra el recorrido pre orden*/
        LinkedList llRecorridoPre = this.miArbol.preOrden();
        return (Recprrido(llRecorridoPre, "Recorrido PreOrden"));
    }

    public String inOrden() {/*Metodo que muestra el recorrido inorden*/
        LinkedList llRecorridoIn = this.miArbol.inOrden();
        return (Recprrido(llRecorridoIn, "Recorrido InOrden"));
    }

    public String postOrden() {/*Metodo que muestra el recorrido postorden*/
        LinkedList llRecorridopost = this.miArbol.postOrden();
        return (Recprrido(llRecorridopost, "Recorrido PosOrden"));
    }
    
    //metodo para poder mostrar los tipos d recorrido
    
    private String Recprrido(LinkedList llRecorrido, String sMensaje) {
        /*Metodo donde nos calcula el recorrido que tiene y luego lo devuelve para mostrarlo*/
        int iIndice = 0;
        String sMensajeDevolver = sMensaje + "\n";
        while (iIndice < llRecorrido.size()) {
            sMensajeDevolver += "\t" + llRecorrido.get(iIndice).toString() + "";
            iIndice++;
        }
        return (sMensajeDevolver);
    }
    
    
    //Metodo para buscar dato en el nodo
    public String BuscarDato(Integer dato) {
        /*Metodo para buscar un dato en el arbol 
        pero verifica si este existe en la lista para luego mostrarlo*/
        boolean siEsta = this.miArbol.VerificarExistencia(dato);
        String sMensaje = "El dato:" + dato.toString() + "\n";
        sMensaje += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (sMensaje);
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
