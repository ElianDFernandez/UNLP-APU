# Segunda parte

Un Bag (bolsa) es una colección que permite almacenar elementos sin ningún orden específico y admite elementos repetidos. Este objeto requiere un buen tiempo de respuesta para conocer la cardinalidad de sus elementos, y por esa razón almacena la cardinalidad de cada elemento (cantidad de veces que fue agregado en la bolsa). Por ejemplo, sí agregamos 3 veces un objeto en la bolsa, y luego eliminamos 1 referencia, la cardinalidad de ese objeto en la bolsa es 2.

El protocolo de la interface Bag<T> es:

```java
public interface Bag<T> extends Collection<T> {
    /**
     * Agrega un elemento al Bag, incrementando en 1 su cardinalidad.
     */
    @Override
    boolean add(T element);

    /**
     * Devuelve la cardinalidad del elemento. Sí el elemento no está en el Bag,            
     * devuelve 0.
     */
    int occurrencesOf(T element);

    /**
     * Elimina una referencia del elemento del Bag. Sí el elemento no está en 
     * el Bag, no hace nada.
     */
    void removeOccurrence(T element);

    /**
     * Elimina el elemento del Bag. Sí el elemento no está en el Bag, no hace
     * nada
     */
    void removeAll(T element);

    /**
     * Devuelve el número total de elementos en el Bag, es decir, la suma de
     * todas las cardinalidades de todos sus elementos.
     */
    @Override
    int size();
}
```

Observe que la interfaz Bag<T> extiende Collection<T>. 

Tareas:
1. Liste los métodos que debe contener una clase que implementa la interface Bag<T>.
2. Explique cómo implementaría un Bag<T> usando composición con un Map<K, V>. ¿De qué tipo tendrían que ser las claves y valores del Map?
3. Implemente la interfaz Bag<T>, utilizando AbstractCollection<T> como superclase, y componga con un Map<T, V>. Para simplificar la implementación utilice la clase BagImpl que se encuentra en este link. 

Discuta con un ayudante:
¿Cuáles son los beneficios de utilizar AbstractCollection como superclase para implementar el Bag?
¿Qué ventajas tiene componer con un Map para implementar el Bag?
En lugar de componer con un Map, ¿es posible extenderlo para poder implementar el Bag? ¿Qué diferencias tendría esa solución con respecto a la planteada en este ejercicio?
¿Para qué cree que podría ser útil un objeto Bag?

1. Liste los métodos que debe contener una clase que implementa la interface Bag<T>.
- add(T element)
- occurrencesOf(T element)
- removeOccurrence(T element)
- removeAll(T element)
- size()

2. Explique cómo implementaría un Bag<T> usando composición con un Map<K, V>. ¿De qué tipo tendrían que ser las claves y valores del Map?
Para implementar un Bag<T> usando composición con un Map<K, V>, utilizaría el tipo de dato T como clave (K) del Map, y un Integer como valor (V) para representar la cardinalidad del elemento en el Bag. Cada vez que se agregue un elemento al Bag, incrementaría su cardinalidad en el Map. Al eliminar una ocurrencia, decrementaría la cardinalidad, y si la cardinalidad llega a cero, eliminaría la clave del Map.

3. Implemente la interfaz Bag<T>, utilizando AbstractCollection<T> como superclase, y componga con un Map<T, V>. Para simplificar la implementación utilice la clase BagImpl que se encuentra en este link. 

```java
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {

    Map<T, Integer> elements;

    public BagImpl() {
        // TODO Completar con la implementación correspondiente
        this.elements = new HashMap<>();
    }

    @Override
    public boolean add(T element) {
        // TODO Completar con la implementación correspondiente
        elements.put(element, elements.getOrDefault(element, 0) + 1);
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        // TODO Completar con la implementación correspondiente
        return elements.getOrDefault(element, 0);
    }

    @Override
    public void removeOccurrence(T element) {
        // TODO Completar con la implementación correspondiente
        elements.put(element, elements.getOrDefault(element, 0) - 1);
        if (elements.get(element) == 0) {
            elements.remove(element);
        }
    }

    }

    @Override
    public void removeAll(T element) {
        // TODO Completar con la implementación correspondiente
        elements.remove(element);
    }

    @Override
    public int size() {
        // TODO Completar con la implementación correspondiente
        return elements.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
```

