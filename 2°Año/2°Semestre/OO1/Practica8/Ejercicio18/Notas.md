En el apunte de uso de colecciones se detalla el protocolo de la interface Collection y se ejemplifica el uso mediante la clase concreta ArrayList. Existen otras implementaciones de Collection que tienen ciertas diferencias, en particular, el Set (java.util.Set) es una colección que no admite duplicados y no tiene un índice para acceder a sus elementos.
Implemente una clase EvenNumberSet (conjunto de números pares). Esta especialización se diferencia en que únicamente permite agregar números enteros que sean pares. Por simplicidad, considere únicamente el tipo de datos Integer para su solución (ignore el resto de tipos de datos numéricos). 
Tenga en cuenta que la clase EvenNumberSet debe implementar la interface Set<Integer> de Java. Esto significa que a las variables de tipo Set<Integer> se les puede asignar un objeto concreto de tipo EvenNumberSet y luego utilizarlo enviando los mensajes que están definidos en el protocolo de Set<Integer>.

El siguiente fragmento de código ejemplifica cómo se podría usar la clase EvenNumberSet:

Set<Integer> numbers = new EvenNumberSet(); 
// inicialmente el Set está vacío => []
numbers.add(1); // No es par, entonces no se agrega => []
numbers.add(2); // Es par, se agrega al set => [2]
numbers.add(4); // Es par, se agrega al set => [2, 4]
numbers.add(2); // Es par, pero ya está en el set, no se agrega => [2, 4]


Evalúe las distintas opciones para implementar la clase EvenNumberSet. Para evitar reinventar la rueda, considere reutilizar alguna de las clases existentes en Java que ofrezcan funcionalidades similares.

Tareas:
1. Investigue qué clases se pueden utilizar para implementar la clase EvenNumberSet. Consulte la documentación de Set.
2. Explique brevemente cómo propone utilizar las clases investigadas anteriormente para implementar su solución. Por ejemplo: 
“Se debe subclasificar una determinada clase y redefinir un método para que haga lo siguiente”
“Se debe crear una nueva clase que contenga un objeto de un determinado tipo al cual se le delegará está responsabilidad”
3. Implemente en Java las alternativas que haya propuesto.
4. Implemente tests automatizados utilizando JUnit para verificar sus implementaciones.
5. Compare las soluciones y liste las ventajas y desventajas de cada una.

Resolución:
1. Investigue qué clases se pueden utilizar para implementar la clase EvenNumberSet. Consulte la documentación de Set.

Se puede utilizar la clase HashSet que implementa la interface Set. HashSet utiliza una tabla hash para almacenar los elementos, lo que permite operaciones rápidas de inserción, eliminación y búsqueda.

2. Explique brevemente cómo propone utilizar las clases investigadas anteriormente para implementar su solución.
Se propone crear una clase EvenNumberSet que contenga un objeto de tipo HashSet<Integer>. Se delegarán las operaciones de Set a este objeto interno, pero se sobrescribirá el método add para asegurarse de que solo se agreguen números pares.

3. Implemente en Java las alternativas que haya propuesto.

```java
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EvenNumberSet implements Set<Integer> {
    private Set<Integer> internalSet;

    public EvenNumberSet() {
        this.internalSet = new HashSet<>();
    }

    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return internalSet.add(number);
        }
        return false; // No se agrega si no es par
    }
}
```

4. Implemente tests automatizados utilizando JUnit para verificar sus implementaciones.

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class EvenNumberSetTest {
    private Set<Integer> evenSet;

    @BeforeEach
    public void setUp() {
        evenSet = new EvenNumberSet();
    }

    @Test
    public void testAddEvenNumber() {
        assertTrue(evenSet.add(2));
        assertTrue(evenSet.contains(2));
    }

    @Test
    public void testAddOddNumber() {
        assertFalse(evenSet.add(3));
        assertFalse(evenSet.contains(3));
    }

    @Test
    public void testAddDuplicateEvenNumber() {
        evenSet.add(4);
        assertFalse(evenSet.add(4)); // No se agrega el duplicado
    }
}
```

5. Compare las soluciones y liste las ventajas y desventajas de cada una.

Ventajas:
- Reutiliza la funcionalidad existente de HashSet, lo que reduce la cantidad de código a escribir y mantener.
- Garantiza que solo se agreguen números pares mediante la sobrescritura del método add.
Desventajas:
- Puede tener un rendimiento ligeramente inferior debido a la verificación adicional en el método add.
- No es una subclase directa de HashSet, lo que podría limitar algunas optimizaciones específicas de HashSet.

