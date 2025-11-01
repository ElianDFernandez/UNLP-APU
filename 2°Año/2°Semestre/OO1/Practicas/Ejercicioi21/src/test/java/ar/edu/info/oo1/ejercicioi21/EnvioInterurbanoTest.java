package ar.edu.info.oo1.ejercicioi21;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EnvioInterurbanoTest {

    @Test
    void testInterurbano_km50_peso10_monto200() {
        EnvioInterurbano e = new EnvioInterurbano(50, LocalDate.now(), "A", "B", 10);
        assertEquals(200.0, e.monto(), 0.0001);
    }

    @Test
    void testInterurbano_km100_peso5_montoSegunCodigo() {
        EnvioInterurbano e = new EnvioInterurbano(100, LocalDate.now(), "A", "B", 5);
        assertEquals(150.0, e.monto(), 0.0001);
    }

    @Test
    void testInterurbano_km250_peso2_monto50() {
        EnvioInterurbano e = new EnvioInterurbano(250, LocalDate.now(), "A", "B", 2);
        assertEquals(50.0, e.monto(), 0.0001);
    }

    @Test
    void testInterurbano_pesoCero_devuelveCero() {
        EnvioInterurbano e = new EnvioInterurbano(300, LocalDate.now(), "A", "B", 0);
        assertEquals(0.0, e.monto(), 0.0001);
    }
}
