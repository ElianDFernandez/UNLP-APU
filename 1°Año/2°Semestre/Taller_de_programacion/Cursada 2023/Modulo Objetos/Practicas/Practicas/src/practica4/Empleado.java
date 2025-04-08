/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author elian
 */
public abstract class Empleado {
    private String nombre;
    private Double sueldo;
    private Integer antiguedad;

    public Empleado(String nombre, Double sueldo, Integer antiguedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public abstract Double calcularEfectividad();
    
    public abstract Double calcularSueldoACobrar();
    
    public Double suledoBase(){
        return sueldo+((sueldo * 0.1) *antiguedad);
    }
    
    public String toString() {
        return "Empleado: " + nombre + ", "+ this.calcularSueldoACobrar() + ", " +this.calcularEfectividad();
    }
}
