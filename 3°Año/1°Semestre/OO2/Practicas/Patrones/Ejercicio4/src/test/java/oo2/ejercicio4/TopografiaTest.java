package oo2.ejercicio4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Elian
 */
public class TopografiaTest {
    private Topografia agua;
    private Topografia tierra;
    private Topografia pantano;
    
    private TopografiaMixta mixta1;
    private TopografiaMixta mixta2;
    private TopografiaMixta mixtaDiferente;
    private TopografiaMixta mixtaCompleja;
    
    @BeforeEach
    void setUp() {
        agua = new TopografiaAgua();
        tierra = new TopografiaTierra();
        pantano = new TopografiaPantano();
        
        // mixta1: [Agua, Tierra, Pantano, Agua]
        mixta1 = new TopografiaMixta();
        mixta1.agregarParte(agua);
        mixta1.agregarParte(tierra);
        mixta1.agregarParte(pantano);
        mixta1.agregarParte(agua);
        
        // mixta2: Igual a mixta1 (misma composición y orden)
        mixta2 = new TopografiaMixta();
        mixta2.agregarParte(agua);
        mixta2.agregarParte(tierra);
        mixta2.agregarParte(pantano);
        mixta2.agregarParte(agua);
        
        // mixtaDiferente: [Agua, Pantano, Tierra, Agua]
        mixtaDiferente = new TopografiaMixta();
        mixtaDiferente.agregarParte(agua);
        mixtaDiferente.agregarParte(pantano);
        mixtaDiferente.agregarParte(tierra);
        mixtaDiferente.agregarParte(agua);
        
        // mixta compleja: [Agua, Tierra, Mixta1, Pantano]
        mixtaCompleja = new TopografiaMixta();
        mixtaCompleja.agregarParte(agua);
        mixtaCompleja.agregarParte(tierra);
        mixtaCompleja.agregarParte(mixta1); // Una mixta adentro de otra
        mixtaCompleja.agregarParte(pantano);
    }
    
    @Test
    void testProporcionTopografiaMixta() {
        // mixta1 tiene [Agua(1), Tierra(0), Pantano(0.7), Agua(1)]
        // Agua: [1.0 + 0.0 + 0.7 + 1.0] = 2.7 -> / 4 = 0.675
        assertEquals(0.675, mixta1.proporcionAgua(), 0.001);
        
        // Tierra: [0 + 1 + 0.3 + 0] = 1.3 -> / 4 = 0.325
        assertEquals(0.325, mixta1.proporcionTierra(), 0.001);
    }
    
    @Test
    void testEqualsTopografiasSimples() {
        // Identidad y tipos iguales
        assertTrue(agua.equals(agua));
        assertTrue(agua.equals(new TopografiaAgua()));
        assertTrue(pantano.equals(new TopografiaPantano()));
        // Tipos distintos
        assertFalse(agua.equals(tierra));
        assertFalse(tierra.equals(pantano));
    }
    
    @Test
    void testEqualsTopografiasMixtas() {
        // Mixtas estructuralmente idénticas
        assertTrue(mixta1.equals(mixta2));
        assertTrue(mixta2.equals(mixta1));
        // Mixtas con distinta composicion
        assertFalse(mixta1.equals(mixtaDiferente));
    }
    
    @Test
    void testEqualsTiposIncompatibles() {
        // Comparar una mixta con una simple
        assertFalse(mixta1.equals(agua));
        assertFalse(pantano.equals(mixta1));
    }
    
    @Test
    void testEqualsTopografiaComplejaAnidada() {
        // Clon idéntico a la compleja
        TopografiaMixta clonCompleja = new TopografiaMixta();
        clonCompleja.agregarParte(new TopografiaAgua());
        clonCompleja.agregarParte(new TopografiaTierra());
        clonCompleja.agregarParte(mixta2); // usamos mixta2 que es igual a mixta1
        clonCompleja.agregarParte(new TopografiaPantano());

        // La recursividad de equals() debería llegar hasta el fondo del árbol
        assertTrue(mixtaCompleja.equals(clonCompleja));
    }
}
