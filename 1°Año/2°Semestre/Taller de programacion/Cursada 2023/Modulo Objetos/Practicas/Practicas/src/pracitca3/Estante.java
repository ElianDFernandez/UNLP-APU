package pracitca3;

/**
 *
 * @author Elian
 */
public class Estante {
    private Integer capacidad;
    private Libro[] libros;
    
    public Estante(Integer capacidad){
        this.libros = new Libro[capacidad];
        this.capacidad = capacidad;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public Integer getAlmacenados() {
        int almacenados = 0;
        for (int i=0; i<capacidad; i++) {
            if (libros[i] != null) {
                almacenados++;
            }
        }
        return almacenados;
    }
    
    public Boolean estaLleno() {
        return (libros[capacidad - 1] != null);
    }
    
    public Boolean agregarLibro(Libro libro) {
        if (!estaLleno()) {
            libros[getAlmacenados()] = libro;
            return true;
        } else {
            return false;
        }
    }
    
    public Libro getLibro(String titulo) {
        for (int i=0; i<getAlmacenados(); i++) {
            if (libros[i].getTitulo().equals(titulo)) {
                return libros[i];
            }
        }
        return null;
    }
   
}
