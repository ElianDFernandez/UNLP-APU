package ar.edu.info.oo1.instrumentofinanciero;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InstrumentoTest {
    private CajaDeAhorro caja1;
    private CuentaCorriente cuenta1;
    
    @BeforeEach
    void setUp() {
            caja1 = new CajaDeAhorro();
            cuenta1 = new CuentaCorriente();
    }
    
    @Test
    void testCajaDeAhorro() {
        caja1.depositar(1000);
        assertEquals(800,caja1.getSaldo());
        assertTrue(caja1.extraer(650));
        assertFalse(caja1.extraer(50));
    }  
    
    @Test
    void testCuentaCorriente() {
        cuenta1.depositar(1000);
        assertEquals(1000,cuenta1.getSaldo());
        cuenta1.setLimiteDescubierto(100);
        assertTrue(cuenta1.extraer(1100)); 
        assertEquals(-100,cuenta1.getSaldo());
    }
}
