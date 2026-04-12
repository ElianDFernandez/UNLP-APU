package oo2.ejercicio6;

/**
 *
 * @author elian
 */
public class EmpleadoPlanta extends Empleado {
    public int cantidadHijos = 0;

    public EmpleadoPlanta(String nombre, String apellido) {
        super(nombre, apellido);
    }
    
    @Override
    public double adicionales() {
        return (this.cantidadHijos * 2000);
    }
}