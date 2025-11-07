package ar.edu.info.oo1.impuestos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Elian
 */
public class Embarcacion extends Vehiculo {
    public Embarcacion(String patente, String marca, String modelo, LocalDate fechaFabricacion, double valor) {
        super(patente, marca, modelo, fechaFabricacion, valor);
    }

    @Override
    public double calcularImpuesto() {
        if (ChronoUnit.YEARS.between(this.getFechaFabricacion(), LocalDate.now()) > 10){
            return 0.0;
        } else {
            if (this.getValor() < 1000000) {
                return this.getValor()*0.10;
            } else {
                return this.getValor()*0.15;
            }
        }
    }   
}
