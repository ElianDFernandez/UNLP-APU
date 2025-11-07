package ar.edu.info.oo1.datalapse;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Particiones Equivalentes para sizeInDays:
 * Desde < Hasta
 * Desde = Hasta 
 * Desde > Hasta
 * 
 * Particiones Equivalentes para includesDate(LocalDate other):
 * other < Desde
 * other > Hasta
 * other = Desde
 * other = Hasta
 * other > desde && other < hasta
 */
public class TestDataLapse {
    private DataLapse casoEstandar;
    private DataLapse casoIgual;
    private DataLapse casoFueraRango;
    
    private LocalDate dia10;
    private LocalDate dia15;
    private LocalDate dia20;
    
    @BeforeEach
    void setUp() {
        this.dia10 = LocalDate.of(2025, 10, 10);
        this.dia15 = LocalDate.of(2025, 10, 15);
        this.dia20 = LocalDate.of(2025, 10, 20);
        
        // Caso estandar
        this.casoEstandar = new DataLapse();
        casoEstandar.setFrom(dia10);
        casoEstandar.setTo(dia20);
        
        // Caso igual 
        this.casoIgual = new DataLapse();
        casoIgual.setFrom(dia10);
        casoIgual.setTo(dia10);
        
        // Caso fuera de rango 
        this.casoFueraRango = new DataLapse();
        casoFueraRango.setFrom(dia20);
        casoFueraRango.setTo(dia10);
    }
    
    @Test
    void testSizeInDays() {
        assertEquals(10, casoEstandar.sizeInDays());
        assertEquals(0, casoIgual.sizeInDays());
        assertEquals(-10, casoFueraRango.sizeInDays());
    }
    
    @Test
    void testIncludesDate() {
        // other < Desde
        assertFalse(this.casoEstandar.includesDate(dia10.minusDays(1)));
        // other > Hasta
        assertFalse(this.casoEstandar.includesDate(dia20.plusDays(1)));
        // other = Desde
        assertTrue(this.casoEstandar.includesDate(dia10));
        // other = hasta
        assertTrue(this.casoEstandar.includesDate(dia20));
        // other > desde && other < hasta
        assertTrue(this.casoEstandar.includesDate(dia15));
    }
    
}
