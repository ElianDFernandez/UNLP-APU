package ar.edu.info.oo1.mantenimientos;

import java.time.LocalDate;

/**
 *
 * @author Elian
 */
public class ContratoProlongado extends Contrato {
    private LocalDate fechaInicial;
    private int cantidadDias;

    public ContratoProlongado(LocalDate fechaInicial, int cantidadDias, Servicio servicios) {
        super(servicios);
        this.fechaInicial = fechaInicial;
        this.cantidadDias = cantidadDias;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    @Override
    public double monto() {
        double montoTotal = this.getServicio().monto() * this.cantidadDias;
        if (this.cantidadDias > 5) {
            return montoTotal * 0.9;
        }
        
        return montoTotal;
    }
    
    
}
