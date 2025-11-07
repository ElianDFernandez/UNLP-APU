package ar.edu.info.oo1.map;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 - Para practicar los mensajes investigados anteriormente, escriba un test de unidad que contenga lo siguiente:
    1. Cree un map un Map<String, Integer>, y agregue las tuplas (“Lionel Messi”, 111), (“Gabriel Batistuta”, 56), (“Kun Agüero”, 42)
    2. Elimine la entrada con clave “Kun Agüero” 
    3. Messi hizo 112 goles a día de la fecha; actualice la cantidad de goles 
    4. Intente repetir la clave “Gabriel Batistuta” y verifique que no es posible.
    5. Obtenga la cantidad total de goles 
 */
public class MapTest {
    private Map<String, Integer> golesPorJugador;

    @BeforeEach
    void setUp() {
        golesPorJugador = new java.util.HashMap<>();
        golesPorJugador.put("Lionel Messi", 111);
        golesPorJugador.put("Gabriel Batistuta", 56);
        golesPorJugador.put("Kun Agüero", 42);
    }

    @Test
    void testMapOperations() {
        // 2. Elimine la entrada con clave “Kun Agüero”
        golesPorJugador.remove("Kun Agüero");
        assertFalse(golesPorJugador.containsKey("Kun Agüero"));

        // 3. Actualice la cantidad de goles de Messi
        golesPorJugador.put("Lionel Messi", 112);
        assertEquals(112, golesPorJugador.get("Lionel Messi"));

        // 4. Intente repetir la clave “Gabriel Batistuta” y verifique que no es posible.
        Integer golesAntes = golesPorJugador.get("Gabriel Batistuta");
        golesPorJugador.put("Gabriel Batistuta", 56); // Intento de repetición
        assertEquals(golesAntes, golesPorJugador.get("Gabriel Batistuta")); // No debe cambiar

        // 5. Obtenga la cantidad total de goles
        int totalGoles = golesPorJugador.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(112 + 56, totalGoles);
    }
}
