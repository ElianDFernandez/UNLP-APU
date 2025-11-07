# Ejercicio 25. Bag

### Primera parte

Un Map en Java es una colección que asocia objetos que actúan cómo claves (keys), a otros objetos que actúan cómo valores (values). En otros lenguajes también se llaman Dictionary (Diccionario). Cada clave está vinculada a un único valor; no pueden existir claves duplicadas en un mapa, aunque sí podrían haber valores repetidos. A los pares clave-valor se los denomina entradas (entries).
Para definir un Map, es necesario indicar el tipo que tendrán sus claves y valores: por ejemplo, una variable de tipo Map<String, Integer> define un mapa en donde sus claves son de tipo String, y sus valores de tipo Integer. Observe que Map<K, V> es una interfaz.

Tareas:

- Lea la documentación de Map en Java y responda:
1. ¿Qué implementaciones provee Java para utilizar un Map? ¿Cuáles de ellas son destinadas a uso general?
2. Investigue cómo consultar sí un mapa contiene una determinada clave (key). Explique qué métodos deben implementar las claves para que esto funcione correctamente
3. ¿Con qué método se puede recuperar el objeto asociado a una clave? ¿Qué pasa sí la clave no existe en el mapa?
4. Investigue cómo agregar claves y valores a un mapa. ¿Qué pasa sí la clave ya se encontraba en el mapa? ¿Permite agregar claves y/o valores nulos? 
5. Determine cómo se pueden eliminar claves y valores de un mapa. ¿Es necesario controlar la presencia de alguno de ellos?
6. Investigue cómo reemplazar un valor en un mapa
7. Teniendo en cuenta los métodos keySet(), values() y entrySet(), explique de qué formas se puede iterar un mapa ¿Es posible utilizar streams?

- Para practicar los mensajes investigados anteriormente, escriba un test de unidad que contenga lo siguiente:
1. Cree un map un Map<String, Integer>, y agregue las tuplas (“Lionel Messi”, 111), (“Gabriel Batistuta”, 56), (“Kun Agüero”, 42)
2. Elimine la entrada con clave “Kun Agüero” 
3. Messi hizo 112 goles a día de la fecha; actualice la cantidad de goles 
4. Intente repetir la clave “Gabriel Batistuta” y verifique que no es posible.
5. Obtenga la cantidad total de goles 

Como se mencionó, cualquier objeto puede actuar como clave. Es decir, pueden ser instancias de clases definidas por el programador. Modele e implemente la clase Jugador con apellido y nombre. Escriba otro test de unidad similar al de la tarea 2, pero utilizando  Map<Jugador, Integer>

Resolución Parte Teorica:
1. ¿Qué implementaciones provee Java para utilizar un Map? ¿Cuáles de ellas son destinadas a uso general?
Java provee varias implementaciones de la interfaz Map, entre las cuales las más comunes y destinadas a uso general son HashMap, TreeMap y LinkedHashMap. HashMap es la implementación más utilizada debido a su eficiencia en operaciones de inserción, eliminación y búsqueda. TreeMap mantiene las claves ordenadas según su orden natural o un comparador proporcionado, mientras que LinkedHashMap mantiene el orden de inserción de las entradas.

2. Investigue cómo consultar sí un mapa contiene una determinada clave (key). Explique qué métodos deben implementar las claves para que esto funcione correctamente
Para consultar si un mapa contiene una determinada clave, se utiliza el método containsKey(Object key). Para que esto funcione correctamente, las claves deben implementar adecuadamente los métodos equals() y hashCode(). El método equals() se utiliza para comparar si dos claves son iguales, mientras que hashCode() proporciona un valor hash que ayuda a ubicar la clave en la estructura interna del mapa.

3. ¿Con qué método se puede recuperar el objeto asociado a una clave? ¿Qué pasa sí la clave no existe en el mapa?
Se puede recuperar el objeto asociado a una clave utilizando el método get(Object key). Si la clave no existe en el mapa, este método retorna null.

4. Investigue cómo agregar claves y valores a un mapa. ¿Qué pasa sí la clave ya se encontraba en el mapa? ¿Permite agregar claves y/o valores nulos?
Para agregar claves y valores a un mapa, se utiliza el método put(K key, V value). Si la clave ya se encontraba en el mapa, el valor asociado a esa clave se reemplaza con el nuevo valor proporcionado. En cuanto a claves y valores nulos, HashMap permite una clave nula y múltiples valores nulos, mientras que TreeMap no permite claves nulas debido a su ordenamiento.

5. Determine cómo se pueden eliminar claves y valores de un mapa. ¿Es necesario controlar la presencia de alguno de ellos?
Para eliminar claves y valores de un mapa, se utiliza el método remove(Object key). No es necesario controlar la presencia de la clave antes de eliminarla; si la clave no existe, el método simplemente no realiza ninguna acción y retorna null.

6. Investigue cómo reemplazar un valor en un mapa
Para reemplazar un valor en un mapa, se puede utilizar el método put(K key, V value) con la clave existente y el nuevo valor. Alternativamente, se puede utilizar el método replace(K key, V value) que solo reemplaza el valor si la clave ya existe en el mapa.

7. Teniendo en cuenta los métodos keySet(), values() y entrySet(), explique de qué formas se puede iterar un mapa ¿Es posible utilizar streams?
Se puede iterar un mapa de varias formas utilizando los métodos keySet(), values() y entrySet(). También es posible utilizar streams para iterar sobre las entradas del mapa de manera más funcional. Por ejemplo:
```java
map.entrySet().stream().forEach(entry -> {
    System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
});
```
