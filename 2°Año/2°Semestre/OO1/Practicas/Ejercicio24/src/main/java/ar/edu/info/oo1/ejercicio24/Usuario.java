package ar.edu.info.oo1.ejercicio24;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Usuario {
    private String nombreCompleto;
    private String domicilio;
    private List<Orden> ordenes;

    public Usuario(String nombreCompleto, String domicilio) {
        this.nombreCompleto = nombreCompleto;
        this.domicilio = domicilio;
        this.ordenes = new LinkedList<>();
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
    
    public void agregarOrden(Orden orden) {
        this.ordenes.add(orden);
    }
}
