/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuralibros;

/**
 *
 * @author Carlos Antonio Laib Contreras (0901-17-518)
 * Objeto donde se maneran los datos del libro
 */
public class Libro {
    /*Variables privadas para contener la informacion del libro*/
	private String titulo;
	private String autor;
	private String isbn;
        /*Se reciben los parametros pedidos*/
	public Libro(String titulo, String autor, String isbn) {
		this.titulo=titulo;
		this.autor=autor;
		this.isbn=isbn;
	}
        /*Muestra la informacion del titulo*/
	public String getTitulo() {
		return titulo;
	}
        /*Puede enviar la informacion del titulo a otra clase*/
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
         /*Muestra la informacion del autor*/
	public String getAutor() {
		return autor;	
	}
        /*Puede enviar la informacion del autor a otra clase*/
	public void setAutor(String autor) {
		this.autor=autor;
	}
         /*Muestra la informacion de su isbn*/
	public String getIsbn() {
		return isbn;
	}
        /*Puede enviar la informacion de su isbn a otra clase*/
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
    }
