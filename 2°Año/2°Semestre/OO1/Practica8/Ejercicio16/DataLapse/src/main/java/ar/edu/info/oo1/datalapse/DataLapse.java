package ar.edu.info.oo1.datalapse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Elian
 */
public class DataLapse {
    private LocalDate from;
    private LocalDate to;

    public DataLapse() {
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }
    
    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }
    
    public boolean includesDate(LocalDate other){
        return (other.isEqual(from) || other.isAfter(from)) && (other.isEqual(to) || other.isBefore(to));
    }
    
    public int sizeInDays() {
        return (int)ChronoUnit.DAYS.between(from, to);
    }
    
}
