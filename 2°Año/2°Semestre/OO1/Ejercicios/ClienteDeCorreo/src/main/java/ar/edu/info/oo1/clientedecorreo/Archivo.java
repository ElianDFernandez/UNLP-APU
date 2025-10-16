package ar.edu.info.oo1.clientedecorreo;

/**
 *
 * @author elian
 */
public class Archivo {
    private String nombre;
    
    public Archivo(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer tamaño() {
        return this.nombre.length();
    }
}
