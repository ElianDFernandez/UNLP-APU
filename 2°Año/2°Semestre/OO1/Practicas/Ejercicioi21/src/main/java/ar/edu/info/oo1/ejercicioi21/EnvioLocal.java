package ar.edu.info.oo1.ejercicioi21;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class EnvioLocal extends Envio{
    private boolean esRapido;

    public EnvioLocal(boolean esRapido, LocalDate fechaDespacho, String origen, String destino, double peso) {
        super(fechaDespacho, origen, destino, peso);
        this.esRapido = esRapido;
    }

    public boolean isEsRapido() {
        return esRapido;
    }

    public void setEsRapido(boolean esRapido) {
        this.esRapido = esRapido;
    }
    
    public double monto(){
        return this.esRapido ? 1500.00 : 1000.00;
    }
}
