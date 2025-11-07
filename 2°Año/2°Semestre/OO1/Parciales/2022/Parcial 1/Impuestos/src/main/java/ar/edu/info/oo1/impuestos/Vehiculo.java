package ar.edu.info.oo1.impuestos;

import java.time.LocalDate;

/**
 *
 * @author Elian
 */
public abstract class Vehiculo implements Bien{
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate fechaFabricacion;
    private double valor;

    public Vehiculo(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.valor = valor;
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
