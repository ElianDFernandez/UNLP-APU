package ar.edu.info.oo1.ejercicioi21;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void testCliente_montoAPagar_incluyeEnvioEnRango() {
        Corporativo c = new Corporativo(12345678, "ACME", "Calle Falsa 123");
        EnvioLocal e = new EnvioLocal(false, LocalDate.of(2023, 1, 15), "X", "Y", 1.0);
        c.agregarEnvio(e);
        double monto = c.montoAPagar(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
        // Esperamos que el envío en 2023-01-15 sea incluido
        assertEquals(e.monto(), monto, "El monto deberia ser mayor que 0");
    }

    @Test
    void testCliente_montoAPagar_excluyeEnvioFueraDeRango() {
        Corporativo c = new Corporativo(12345678, "ACME", "Calle Falsa 123");
        EnvioLocal e = new EnvioLocal(false, LocalDate.of(2023, 2, 1), "X", "Y", 1.0);
        c.agregarEnvio(e);
        double monto = c.montoAPagar(LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20));
        assertEquals(0.0, monto, "El monto de beria de ser 0");
    }
}
