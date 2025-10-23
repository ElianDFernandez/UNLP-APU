package ar.edu.info.oo1.ejercicioi21;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class EnvioInterurbano extends Envio{
    private double km;

    public EnvioInterurbano(double km, LocalDate fechaDespacho, String origen, String destino, double peso) {
        super(fechaDespacho, origen, destino, peso);
        this.km = km;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double monto() {
        double costo = 30;
        if(this.km < 100) {
            costo = 20;
        } else if (this.km > 100 && this.km < 500) {
            costo = 25;
        } 
        
        return costo*this.getPeso();
    }
}
