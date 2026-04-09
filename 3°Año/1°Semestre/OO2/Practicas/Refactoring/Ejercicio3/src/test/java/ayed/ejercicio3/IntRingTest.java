package ayed.ejercicio3;

import oo2.ejercicio3.IntRing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author elian
 */
public class IntRingTest {
  private IntRing  numeros;
  
  @BeforeEach
  void setUp() {
      numeros = new IntRing(new int[]{1, 2, 3});
  }

  @Test
  void testNext() {
    assertEquals(1, numeros.next());
    assertEquals(2,numeros.next());
    assertEquals(3,numeros.next());
    assertEquals(1, numeros.next());
  }
}
