package ar.edu.info.oo1.ejercicioi21;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class Persona extends Cliente{
        private int dni;

    public Persona(int dni, String nombre, String direccion) {
        super(nombre, direccion);
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    @Override
    public double montoAPagar(LocalDate inicio, LocalDate fin) {
        return super.montoAPagar(inicio,fin) *0.9;
    }
}
