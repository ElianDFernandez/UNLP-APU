package ar.edu.info.oo1.ejercicioi21;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class EnvioInternacional extends Envio{
    private boolean esRapido;

    public EnvioInternacional(boolean esRapido, LocalDate fechaDespacho, String origen, String destino, double peso) {
        super(fechaDespacho, origen, destino, peso);
        this.esRapido = esRapido;
    }

    public boolean isEsRapido() {
        return esRapido;
    }

    public void setEsRapido(boolean esRapido) {
        this.esRapido = esRapido;
    }
    
    public double monto() {
        double costo = 10;
        if (this.getPeso() > 1000) {
            costo = 12;
        }
        
        return this.esRapido ? 5000+costo*this.getPeso()+800 : 5000+costo*this.getPeso()+800;
    }
    
}
