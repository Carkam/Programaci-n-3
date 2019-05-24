
package arbolBB;

  /**
 *
 * @author
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;


public class ArbolExpresionGrafico extends JPanel 
{
    private ArbolBB miArbol;
    private HashMap posicionNodos = null;
    private HashMap subtreeSizes = null;
    private boolean dirty = true;
    private int parent2child = 20, child2child = 30;
    private Dimension empty = new Dimension(0,0);
    private FontMetrics fm = null;
    
    
    /**
     * Constructor de la clase ArbolExpresionGrafico.
     * El constructor permite inicializar los atributos de la clase ArbolExpresionGrafico
     * y llama al método repaint(), que es el encargado de pintar el Arbol.
     * @param miExpresion: dato de tipo ArbolExpresion que contiene el Arbol a
     * dibujar.
     */
    public ArbolExpresionGrafico(ArbolBB miArbol) 
    {
          this.miArbol = miArbol;
          this.setBackground(Color.WHITE);
          posicionNodos = new HashMap();
          subtreeSizes = new HashMap();
          dirty = true;
          repaint();      
    }


    /**
     * Calcula las posiciones de los respectivos subárboles y de cada nodo que 
     * forma parte de ese subárbol, para conocer en que posición van a ir dibujados
     * los rectángulos representativos del árbol de la expresión.
     */
    /*Metodo donde calcula las posicion */
    private void calcularPosiciones() 
    {        
         posicionNodos.clear();
         subtreeSizes.clear();
         Nodo nRaiz = this.miArbol.getnRaiz();         
         if (nRaiz != null) 
         {
             /*Si raiz es diferente de nulo llama al metodo para calcular el tamaño del arbol*/
             calcularTamañoSubarbol(nRaiz);
             calcularPosicion(nRaiz, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
         }
    }
    
    /**
     * Calcula el tamaño de cada subárbol y lo agrega al objeto subtreeSizes de la clase
     * de tipo HashMap que va a contener la coleccion de todos los 
     * subárboles que contiene un arbol.
     * @param Numero:Objeto de la clase NodoB <T> que se utiliza como
     * referencia calcular el tamaño de cada subárbol.
     * @return Dimension con el tamaño de cada subárbol.
     */
    private Dimension calcularTamañoSubarbol(Nodo Numero) 
    {   /*si numero es nulo retorna 0,0*/
          if (Numero == null) 
              return new Dimension(0,0);
          /*Calcula el tamaño del lado derecho y de laldo izquierdo*/
          Dimension ld = calcularTamañoSubarbol(Numero.getnIzquierda());
          Dimension rd = calcularTamañoSubarbol(Numero.getnDerecha());
          /*Calcula la altura y el peso*/
          int iHeight = fm.getHeight() + parent2child + Math.max(ld.height, rd.height);
          int iWeight = ld.width + child2child + rd.width;
          
          Dimension d = new Dimension(iWeight, iHeight);
          subtreeSizes.put(Numero, d);
          
          return d;
    }
    
    
    /**
     * Calcula la ubicación de cada nodo de cada subárbol y agrega cada nodo con 
     * un objeto de tipo Rectangule que tiene la ubicación y la información específica de dónde 
     * va a ser dibujado.
     * @param n: Objeto de tipo NodoB <T> que se utiliza como
     * referencia para calcular la ubicación de cada nodo.
     * @param left: int con alineación y orientación a la izquierda.
     * @param right: int con alineación y orientación a la derecha.
     * @param top: int con el tope.
     */
    private void calcularPosicion(Nodo n, int left, int right, int top) 
    {/*Si es nulo retorna nulo*/
      if (n == null) 
          return;
      /*Calcula el subarbol de la lo isquiero*/
      Dimension ld = (Dimension) subtreeSizes.get(n.getnIzquierda());
      if (ld == null) 
          ld = empty;
      /*Obtiene el subarbol derecho*/
      Dimension rd = (Dimension) subtreeSizes.get(n.getnDerecha());
      if (rd == null) 
          rd = empty;
      /*Vuelve el centro 0*/
      int center = 0;
      /*Si derecha es diferente de su maximo valor*/
      if (right != Integer.MAX_VALUE)
          /*Calculara el centro*/
          center = right - rd.width - child2child/2;
      else if (left != Integer.MAX_VALUE)
          /*Si no calcula el centro con el lado izquiero*/
          center = left + ld.width + child2child/2;
      int width = fm.stringWidth(n.getiDato()+"");
 
      posicionNodos.put(n,new Rectangle(center - width/2 - 3, top, width + 6, fm.getHeight()));
      /*Inicia un metodo recursico del lado izquierdo y del lado derecho*/
      calcularPosicion(n.getnIzquierda(), Integer.MAX_VALUE, center - child2child/2, top + fm.getHeight() + parent2child);
      calcularPosicion(n.getnDerecha(), center + child2child/2, Integer.MAX_VALUE, top + fm.getHeight() + parent2child);
    }
    
    /**
     * Dibuja el árbol teniendo en cuenta las ubicaciones de los nodos y los 
     * subárboles calculadas anteriormente.
     * @param g: Objeto de la clase Graphics2D que permite realizar el dibujo de las líneas, rectangulos y del String de la información que contiene el Nodo.
     * @param n: Objeto de la clase NodoB <T> que se utiliza como referencia para dibujar el árbol.
     * @param puntox: int con la posición en x desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param puntoy: int con la posición en y desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param yoffs: int con la altura del FontMetrics.
     */
    private void dibujarArbol(Graphics2D g, Nodo n, int puntox, int puntoy, int yoffs) 
    {/*Metodo donde va dibujando el arbol poco a poco
        y lo vuelve a repintar cuando se le ingresan datos*/
     if (n == null) 
         return;
     
     Rectangle r = (Rectangle) posicionNodos.get(n);
     g.draw(r);
     g.drawString(n.getiDato()+"", r.x + 3, r.y + yoffs);
   
     if (puntox != Integer.MAX_VALUE)
       
     g.drawLine(puntox, puntoy, (int)(r.x + r.width/2), r.y);
     
     dibujarArbol(g, n.getnIzquierda(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
     dibujarArbol(g, n.getnDerecha(), (int)(r.x + r.width/2), r.y + r.height, yoffs);
     
   }
    

   /**
     * Sobreescribe el metodo paint y se encarga de pintar todo el árbol.
     * @param g: Objeto de la clase Graphics.
     */
    @Override
   public void paint(Graphics g) 
   {/*Metodo para dibujar en la pantalla y que mande a llamar distintos metodos como
       el de calcular las posicion y el de dibujar el arbol*/
         super.paint(g);
         fm = g.getFontMetrics();

         if (dirty) 
         {
           calcularPosiciones();
           dirty = false;
         }
         
         Graphics2D g2d = (Graphics2D) g;
         g2d.translate(getWidth() / 2, parent2child);
         dibujarArbol(g2d, this.miArbol.getnRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, 
                  fm.getLeading() + fm.getAscent());
         fm = null;
   }
   
 }




