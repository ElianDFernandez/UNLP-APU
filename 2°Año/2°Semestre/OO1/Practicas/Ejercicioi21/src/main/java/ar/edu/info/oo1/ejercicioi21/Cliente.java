package ar.edu.info.oo1.ejercicioi21;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author elian
 */
public abstract class Cliente {
    private String nombre;
    private String direccion;
    private List<Envio> envios;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new LinkedList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }
    
    public void agregarEnvio(Envio envio) {
        this.envios .add(envio);
    }
    
    protected double montoAPagar(LocalDate inicio, LocalDate fin) {
        double suma = 0;
        for (Envio envio : this.envios) {
             if  ((envio.getFechaDespacho().isAfter(inicio)) && (envio.getFechaDespacho().isBefore(fin))) {
                suma += envio.monto();
            }
        }
        
        return suma;
    }
}
