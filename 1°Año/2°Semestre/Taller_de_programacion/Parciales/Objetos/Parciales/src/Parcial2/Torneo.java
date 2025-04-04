/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2;

/**
 *
 * @author elian
 */
class Torneo {
    private String nombre;
    private String fecha;
    private Integer montoInscripcion;
    private Integer montoPremios;

    public Torneo(String nombre, String fecha, Integer montoInscripcion, Integer montoPremios) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.montoInscripcion = montoInscripcion;
        this.montoPremios = montoPremios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getMontoInscripcion() {
        return montoInscripcion;
    }

    public void setMontoInscripcion(Integer montoInscripcion) {
        this.montoInscripcion = montoInscripcion;
    }

    public Integer getMontoPremios() {
        return montoPremios;
    }

    public void setMontoPremios(Integer montoPremios) {
        this.montoPremios = montoPremios;
    }
    
}
