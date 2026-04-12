package oo2.ejercicio6;

/**
 *
 * @author elian
 */
public class EmpleadoTemporario extends Empleado {
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;

    public EmpleadoTemporario(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    @Override
    public double adicionales() {
        return (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000);
    }
}