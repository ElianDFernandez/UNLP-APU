package ar.edu.info.oo1.mantenimientos;

import java.util.List;

/**
 *
 * @author Elian
 */
public abstract class Contrato {
   private Servicio servicio;

    public Contrato(Servicio servicios) {
        this.servicio = servicios;
    }
    
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicios(Servicio servicio) {
        this.servicio = servicio;
    }

    public abstract double monto(); 
}
