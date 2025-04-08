package pracitca3;

/**
 *
 * @author Elian
 */
public class Libro {
    private String titulo;
    private Autor primerAutor;
    private String editorial;
    private Integer anioEdicion;
    private Integer isbn;
    private Double precio;

    public Libro(String titulo, Autor primerAutor, String editorial, Integer anioEdicion, Integer isbn, Double precio) {
        this.titulo = titulo;
        this.primerAutor = primerAutor;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
        this.isbn = isbn;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getPrimerAutor() {
        return primerAutor;
    }

    public void setPrimerAutor(Autor primerAutor) {
        this.primerAutor = primerAutor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(Integer anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Libro{" +
               "titulo='" + titulo + '\'' +
               ", primerAutor=" + primerAutor +
               ", editorial='" + editorial + '\'' +
               ", anioEdicion=" + anioEdicion +
               ", isbn=" + isbn +
               ", precio=" + precio +
               '}';
    }
}
