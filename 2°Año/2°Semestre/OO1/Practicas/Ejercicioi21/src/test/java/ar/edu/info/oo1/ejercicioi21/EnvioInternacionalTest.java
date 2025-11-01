package ar.edu.info.oo1.ejercicioi21;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EnvioInternacionalTest {

    @Test
    void testInternacional_peso1000_noRapido() {
        EnvioInternacional e = new EnvioInternacional(false, LocalDate.now(), "A", "B", 1000);
        // según implementación actual: 5000 + 10*1000  = 15000
        assertEquals(15000.0, e.monto(), 0.0001);
    }

    @Test
    void testInternacional_esRapidoYNoRapido_difieren() {
        EnvioInternacional noRapido = new EnvioInternacional(false, LocalDate.now(), "A", "B", 2000);
        EnvioInternacional rapido = new EnvioInternacional(true, LocalDate.now(), "A", "B", 2000);
        // Esperamos que cambiar esRapido altere el monto; esto expondrá el bug actual
        assertNotEquals(noRapido.monto(), rapido.monto(), "esRapido debería alterar el monto");
    }

    @Test
    void testInternacional_pesoCero() {
        EnvioInternacional e = new EnvioInternacional(false, LocalDate.now(), "A", "B", 0);
        // 5000 + 10*0 = 5000
        assertEquals(5000.0, e.monto(), 0.0001);
    }
}
