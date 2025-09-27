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
            
            caja1.depositar(1000);
            cuenta1.setLimiteDescubierto(100);
    }
    
    @Test
    void testCajaDeAhorro() {
        assertFalse(caja1.puedeExtraer(1100));
        assertTrue(caja1.puedeExtraer(1100-(1100*0.2)));
    }
}
