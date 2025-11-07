package ar.edu.info.oo1.ejercicio24;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class OrdenServicio extends Orden{
    private String descripciion;
    private int horas;
    private List<Tecnico> tecnicos;

    public OrdenServicio(String descripciion, int horas, LocalDate fecha, Usuario usuario, String domicilio, List<Tecnico> tecnicos) {
        super(fecha, usuario, domicilio);
        this.descripciion = descripciion;
        this.horas = horas;
        this.tecnicos = tecnicos;
    }

    public String getDescripciion() {
        return descripciion;
    }

    public void setDescripciion(String descripciion) {
        this.descripciion = descripciion;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    public double calcularCosto(){
        double costo = super.calcularCosto();
        for(Tecnico tecnico : this.tecnicos) {
            costo+= tecnico.getValorHora()*this.horas;
        }
        if (this.horas > 10) {
            return costo*0.9;
        }
        
        return costo;
    }
}
