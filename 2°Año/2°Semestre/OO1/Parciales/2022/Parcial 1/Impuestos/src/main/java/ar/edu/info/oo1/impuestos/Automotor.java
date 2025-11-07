package ar.edu.info.oo1.impuestos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Elian
 */
public class Automotor extends Vehiculo {

    public Automotor(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor) {
        super(patente, marca, modelo, fechaFabricacion, valor);
    }

    @Override
    public double calcularImpuesto() {
        if (ChronoUnit.YEARS.between(this.getFechaFabricacion(), LocalDate.now()) > 10){
            return 0.0;
        } else {
            return this.getValor()*0.05;
        }
    }
    
}
