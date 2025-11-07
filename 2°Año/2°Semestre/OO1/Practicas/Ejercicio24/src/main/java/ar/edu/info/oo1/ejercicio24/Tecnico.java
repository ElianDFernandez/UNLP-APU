package ar.edu.info.oo1.ejercicio24;

/**
 *
 * @author Elian
 */
public class Tecnico {
    private String nombreCompleto;
    private String especialidad;
    private double valorHora;

    public Tecnico(String nombreCompleto, String especialidad, double valorHora) {
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.valorHora = valorHora;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    
}
