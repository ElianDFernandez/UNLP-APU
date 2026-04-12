package oo2.ejercicio6;

/**
 *
 * @author elian
 */
public abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected double sueldoBasico = 0;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }
    
    public double retenciones() {
        return this.sueldoBasico * 0.13;
    }
    
    public abstract double adicionales();
    
    public double sueldo() {
        return this.getSueldoBasico() + this.adicionales() - this.retenciones();
    }
}
