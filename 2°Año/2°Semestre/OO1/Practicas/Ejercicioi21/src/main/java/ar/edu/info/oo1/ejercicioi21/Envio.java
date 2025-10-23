package ar.edu.info.oo1.ejercicioi21;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public abstract class Envio {
    private LocalDate fechaDespacho;
    private String origen;
    private String destino;
    private double peso;

    public Envio(LocalDate fechaDespacho, String origen, String destino, double peso) {
        this.fechaDespacho = fechaDespacho;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public abstract double monto();
}
