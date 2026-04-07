package oo2.practica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author elian
 */
public class CharRingTest {
  private CharRing  queso;
  
  @BeforeEach
  void setUp() {
    queso = new CharRing("Queso");
  }

  @Test
  void testNext() {
    assertEquals("Q", queso.next());
    assertEquals("u",queso.next());
    assertEquals("e",queso.next());
    assertEquals("s",queso.next());
    assertEquals("o",queso.next());
  }
}
