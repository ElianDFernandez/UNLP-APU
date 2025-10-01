# Tipo de dato abstracto: Listas, Pilas y Colas 

Un tipo de dato abstracto (TDA) es una estructura de datos que define un conjunto de operaciones y comportamientos sin especificar su implementación concreta.

## Listas 
Una lista es una colección ordenada de elementos donde cada elemento tiene una posición específica.
Se pueden implementar con ArrayList o LinkedList en Java.

**Operaiones de la cursada:**
- add(element): Agrega un elemento al final de la lista.
- add(index, element): Agrega un elemento en una posición específica.
- get(index): Obtiene el elemento en una posición específica.
- indexOf(element): Devuelve el índice de la primera aparición del elemento.
- remove(index): Elimina el elemento en una posición específica.
- remove(element): Elimina la primera aparición del elemento.
- contains(element): Verifica si la lista contiene un elemento específico.
- size(): Devuelve el número de elementos en la lista.

## Pilas
Una pila es una estructura de datos que sigue el principio LIFO (Last In, First Out), donde el último elemento agregado es el primero en ser removido.
Se pueden implementar con Stack en Java.

**Operaciones de la cursada:**
- push(element): Agrega un elemento en la cima de la pila.
- pop(): Elimina y devuelve el elemento en la cima de la pila.
- isEmpty(): Verifica si la pila está vacía.
- top(): Devuelve el elemento en la cima de la pila sin eliminarlo.
- size(): Devuelve el número de elementos en la pila.

## Colas
Una cola es una estructura de datos que sigue el principio FIFO (First In, First Out), donde el primer elemento agregado es el primero en ser removido.
Se pueden implementar con LinkedList o PriorityQueue en Java. -> en la cursada usamos clase Queue.

**Operaciones de la cursada:**
- enqueue(element): Agrega un elemento al final de la cola.
- dequeue(): Elimina y devuelve el elemento al frente de la cola.
- head(): Devuelve el elemento al frente de la cola sin eliminarlo.
- isEmpty(): Verifica si la cola está vacía.
- size(): Devuelve el número de elementos en la cola.

## Tecnologias de almacenamiento
- ArrayList: Implementación de lista basada en un array dinámico.
El acceso a elementos es rápido, pero las inserciones y eliminaciones pueden ser lentas debido al redimensionamiento del array.
- LinkedList: Implementación de lista basada en nodos enlazados.
Permite inserciones y eliminaciones rápidas, pero el acceso a elementos es más lento debido a la necesidad de recorrer los nodos.
- Arboles: Estructura jerárquica donde cada nodo tiene un valor y referencias a nodos hijos.
Permite búsquedas, inserciones y eliminaciones eficientes.
- HashMap: Estructura de datos que almacena pares clave-valor.
Permite acceso rápido a los valores mediante sus claves, pero no mantiene un orden específico.

## Colecciones en JAVA -> LinkedList y ArrayList

Ejemplo de uso de LinkedList y ArrayList en Java:

```java
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List lista_vinos = new LinkedList();
        lista_vinos.add("Malbec");
        lista_vinos.add(new Vino("Cabernet Sauvignon", 2018));
        lista_vinos.add(3);

        while (!lista_vinos.isEmpty()) {
            Object vino = lista_vinos.get(0);
            System.out.println(vino);
            lista_vinos.remove(0);
        }
    }
}

class Vino {
    String nombre;
    int anio;

    public Vino(String nombre, int anio) {
        this.nombre = nombre;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return nombre + " (" + anio + ")";
    }
}
```
Si hicieramos 
System.out.println(lista_vinos.getCosecha());
Nos daria error porque getCosecha no es un metodo de Object, y la lista es de Object. Para solucionar esto, tendríamos que hacer un casting del objeto a la clase Vino:
```java
    Vino vino = (Vino) lista_vinos.get(0);
    System.out.println(vino.getCosecha());
```
Pero como no sabemos si el objeto en la posición 0 es realmente un Vino, podríamos tener un error en tiempo de ejecución. Para evitar esto, podemos usar el operador instanceof para verificar el tipo del objeto antes de hacer el casting:
```java
    if (lista_vinos.get(0) instanceof Vino) {
        Vino vino = (Vino) lista_vinos.get(0);
        System.out.println(vino.getCosecha());
    } else {
        System.out.println("El objeto en la posición 0 no es un Vino");
    }
```
Para evitar estos problemas, podemos usar genéricos en Java, que nos permiten especificar el tipo de datos que una colección puede contener. Por ejemplo, podemos definir una lista de vinos de la siguiente manera:
```java
    List<Vino> lista_vinos = new LinkedList<>();
    lista_vinos.add(new Vino("Cabernet Sauvignon", 2018));
    Vino vino = lista_vinos.get(0);
    System.out.println(vino.getCosecha());
```
De esta manera, la lista solo puede contener objetos de tipo Vino, y no necesitamos hacer casting ni verificar el tipo del objeto en tiempo de ejecución.