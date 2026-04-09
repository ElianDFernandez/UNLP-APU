package ayed.ejercicio3;

import oo2.ejercicio3.CharRing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Elian
 */
public class CharRingTest {
  private CharRing  queso;
  
  @BeforeEach
  void setUp() {
    queso = new CharRing("Queso");
  }

  @Test
  void testNext() {
    assertEquals('Q', queso.next());
    assertEquals('u',queso.next());
    assertEquals('e',queso.next());
    assertEquals('s',queso.next());
    assertEquals('o',queso.next());
 
    assertEquals('Q', queso.next());
    assertEquals('u', queso.next());
  }
}
