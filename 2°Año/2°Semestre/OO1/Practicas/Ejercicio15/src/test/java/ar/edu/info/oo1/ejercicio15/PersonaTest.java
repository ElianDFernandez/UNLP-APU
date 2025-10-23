package ar.edu.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class PersonaTest {
	
	PROBANDO james;
        Persona guido;
	
	@BeforeEach
	void setUp() throws Exception {
		james = new PROBANDO();
		guido = new PROBANDO();
		james.setApellido("Gosling");
		james.setNombre("James");
		guido.setApellido("van Rossum");
		guido.setNombre("Guido");
	}
	
    @Test
    public void testNombreCompleto() {
        assertEquals("Gosling, James", james.getNombreCompleto());
        assertEquals("van Rossum, Guido", guido.getNombreCompleto());
    }
}
