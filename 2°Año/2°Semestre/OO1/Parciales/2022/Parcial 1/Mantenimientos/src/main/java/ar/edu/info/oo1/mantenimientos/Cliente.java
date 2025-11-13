package ar.edu.info.oo1.mantenimientos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Cliente {
    private String nombre;
    private String domicilio;
    private List<Contrato> contratos;

    public Cliente(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.contratos = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public double monto(){
        return this.contratos.stream().mapToDouble(contrato -> contrato.monto()).sum();
    }
    
    public void agregarContrato(Contrato contrato) {
        this.contratos.add(contrato);
    }
}
