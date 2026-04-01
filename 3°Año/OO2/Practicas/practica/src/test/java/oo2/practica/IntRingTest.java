package oo2.practica;

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
      int [] n = {1,2,3};
      IntRing numeros = new IntRing(n);
  }

  @Test
  void testNext() {
    assertEquals(1, numeros.next());
    assertEquals(2,numeros.next());
    assertEquals(3,numeros.next());
  }
}
