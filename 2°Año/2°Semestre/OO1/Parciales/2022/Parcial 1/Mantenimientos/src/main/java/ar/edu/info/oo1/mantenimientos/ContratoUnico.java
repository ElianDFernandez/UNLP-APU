package ar.edu.info.oo1.mantenimientos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Elian
 */
public class ContratoUnico extends Contrato {
    private LocalDate fecha;

    public ContratoUnico(LocalDate fecha, Servicio servicio) {
        super(servicio);
        this.fecha = fecha;
    }

    @Override
    public double monto() {
        DayOfWeek dia = DayOfWeek.from(this.fecha);
        if (dia.equals(DayOfWeek.SATURDAY) || dia.equals(DayOfWeek.SUNDAY)) {
            return this.getServicio().monto() * 1.15;
        }
        
        return this.getServicio().monto();
    }
    
    
}
