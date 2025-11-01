package ar.edu.info.oo1.ejercicioi21;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EnvioLocalTest {

    @Test
    void testEnvioLocal_rapido_devuelve1500() {
        EnvioLocal e = new EnvioLocal(true, LocalDate.now(), "A", "B", 5.0);
        assertEquals(1500.0, e.monto(), 0.0001);
    }

    @Test
    void testEnvioLocal_noRapido_devuelve1000() {
        EnvioLocal e = new EnvioLocal(false, LocalDate.now(), "A", "B", 5.0);
        assertEquals(1000.0, e.monto(), 0.0001);
    }
}

