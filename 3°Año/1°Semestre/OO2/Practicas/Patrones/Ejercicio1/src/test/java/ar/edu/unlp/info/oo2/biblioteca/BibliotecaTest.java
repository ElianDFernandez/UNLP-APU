package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class BibliotecaTest {
    private Biblioteca biblioteca;
    
    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        Socio socio1 = new Socio("Alan Turing", "alan@enigma.com", "101010/1");
        Socio socio2 = new Socio("Grace Hopper", "grace@navy.mil", "010101/0");
        
        biblioteca.agregarSocio(socio1);
        biblioteca.agregarSocio(socio2);
    }
    
    @Test
    void testExportarConVoorheesPorDefecto() {
        String resultado = biblioteca.exportarSocios();
        
        // Imprime el resultado en consola
        System.out.println("--- Exportacion con Voorhees (Por Defecto) ---");
        System.out.println(resultado);
        
        assertTrue(resultado.contains("Alan Turing"));
        assertTrue(resultado.contains("alan@enigma.com"));
        assertTrue(resultado.contains("\t{")); 
    }
    
    @Test
    void testExportarConJSONSimpleAdapter() {
        biblioteca.setExporter(new JSONSimpleAdapter());
        String resultado = biblioteca.exportarSocios();
        
        // Imprime el resultado en consola
        System.out.println("\n--- Exportacion con JSON.simple ---");
        System.out.println(resultado);
        
        assertTrue(resultado.contains("\"nombre\":\"Grace Hopper\""));
        assertTrue(resultado.contains("\"email\":\"grace@navy.mil\""));
    }
    
    @Test
    void testExportarConJacksonAdapter() {
        biblioteca.setExporter(new JacksonAdapter());
        String resultado = biblioteca.exportarSocios();
        
        // Imprime el resultado en consola
        System.out.println("\n--- Exportacion con Jackson ---");
        System.out.println(resultado);
        
        assertTrue(resultado.contains("\"nombre\":\"Alan Turing\""));
        assertTrue(resultado.contains("\"legajo\":\"101010/1\""));
    }
}