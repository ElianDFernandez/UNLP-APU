package oo2.ejercicio9;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Elian
 */
public class Cliente {
    private LocalDate fechaAlta;
    
    public LocalDate getFechaAlta() {
        return this.fechaAlta;
    }
    
    public int getAntiguedad() {
        return Period.between(this.fechaAlta, LocalDate.now()).getYears();
    }
}
