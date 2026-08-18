Ejercicio 1 - Patrones
En los juegos de rol, los jugadores exploran el mundo juntando diferentes ítems (espadas, armaduras, comida, etc) los cuales se pueden guardar para ser usados luego. Un jugador comienza con un ítem especial, llamado bolsa, que le permite llevar el resto de los ítems que junte.

Todos los ítems ocupan cierto espacio dentro de la bolsa que los contiene. Las bolsas, además, tienen una capacidad que se define al crearla y no se puede modificar. Notar que una bolsa tiene cierta capacidad, sin embargo, el espacio que ocupa es independiente a esa capacidad.

El jugador va encontrando ítems y los puede agregar en alguna de sus bolsas que disponga capacidad para almacenarlo. Es posible incluir una bolsa dentro de otra para aumentar la cantidad de ítems que puede transportar el jugador. Es decir, se puede tener una bolsa dentro de otra bolsa y así sucesivamente. Asuma que cada bolsa no se guardará en más de un lugar al mismo tiempo, es decir, no es necesario verificarlo.

Por ejemplo, un jugador con una bolsa inicial con capacidad de 15 espacios, si encuentra una bolsa que ocupa un espacio de 1 y capacidad de 20 espacios, aumentará la capacidad de ítems que puede transportar a 34 (14 restantes de la primera bolsa más los 20 de la segunda).

Ud debe implementar las operaciones que permitan la siguiente funcionalidad:

Registrar un jugador: indicando su nombre y la capacidad que tiene en su bolsa inicial.

Guardar objeto: se debe guardar el objeto recién encontrado en el almacenamiento del jugador. Se debe buscar alguna bolsa con espacio suficiente para almacenar el objeto recibido, almacenarlo y retornar true. En caso de no encontrarla, no hace nada y retorna false.

Buscar ítem por nombre: Dado un nombre de ítem, se debe buscar en las bolsas del jugador, retornando el primer ítem que coincida con el nombre. En caso de no encontrar el ítem en ninguna bolsa, retorna null.

Espacio más grande que se puede utilizar: dado un jugador, retorna el espacio máximo disponible en alguna de sus bolsas.

Capacidad disponible: dado un jugador, se debe calcular la capacidad total disponible para almacenar que posee.


**Solucion COMPOSITE**
Una bolsa es un item pero puede tener otros items dentro de ella. Por lo tanto, se puede modelar una bolsa como un item que tiene una lista de items dentro de ella.
Cada item debe tener un nombre y un tamaño.
La bolsa tendra ademas de un nombre y un tamaño, una capacidad y una lista de items que contiene.

Por fuera de esto, habra una clase jugador que tendra un nombre y una bolsa inicial.

UML: 

```
class abstract Item {
    - nombre: String
    - tamaño: int
    + getNombre(): String
    + getTamaño(): int
    +<abstract> guardarItem(item: Item): boolean
    +<abstract> buscarItem(nombre: String): Item
    +<abstract> espacioMasGrandeQueSePuedeUtilizar(): int
    +<abstract> capacidadDisponible(): int
}

class ItemSimple extends Item {
    + guardarItem(item: Item): boolean
    + buscarItem(nombre: String): Item
    + espacioMasGrandeQueSePuedeUtilizar(): int
    + capacidadDisponible(): int
}

class Bolsa extends Item {
    - capacidad: int
    - items: List<Item>
    + getCapacidad(): int
    + guardarItem(item: Item): boolean
    + buscarItem(nombre: String): Item
    + espacioMasGrandeQueSePuedeUtilizar(): int
    + capacidadDisponible(): int
}

class Jugador {
    - nombre: String
    - bolsaInicial: Bolsa
    + getNombre(): String
    + getBolsaInicial(): Bolsa
    + guardarItem(item: Item): boolean
    + buscarItem(nombre: String): Item
    + espacioMasGrandeQueSePuedeUtilizar(): int
    + capacidadDisponible(): int
}
```

Codigo:

```java
public abstract class Item {
    private String nombre;
    private int tamaño;

    public Item(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamaño() {
        return tamaño;
    }
    
    public abstract boolean guardarItem(Item item);
    public abstract Item buscarItem(String nombre);
    public abstract int espacioMasGrandeQueSePuedeUtilizar();
    public abstract int capacidadDisponible();
}

public class ItemSimple extends Item {
    public ItemSimple(String nombre, int tamaño) {
        super(nombre, tamaño);
    }

    @Override
    public boolean guardarItem(Item item) {
        return false; // No se puede guardar un item dentro de un item simple
    }

    @Override
    public Item buscarItem(String nombre) {
        return this.getNombre().equals(nombre) ? this : null;
    }

    @Override
    public int espacioMasGrandeQueSePuedeUtilizar() {
        return 0; // Un item simple no tiene espacio disponible
    }

    @Override
    public int capacidadDisponible() {
        return 0; // Un item simple no tiene capacidad disponible
    }
}

public class Bolsa extends Item {
    private int capacidad;
    private List<Item> items;

    public Bolsa(String nombre, int tamaño, int capacidad) {
        super(nombre, tamaño);
        this.capacidad = capacidad;
        this.items = new ArrayList<>();
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public boolean guardarItem(Item nuevoItem) {
        int espacioOcupado = 0;
        for (Item item : items) {
            espacioOcupado += item.getTamaño();
        }
        int espacioLibre = capacidad - espacioOcupado;
        if (nuevoItem.getTamaño() <= espacioLibre) {
            items.add(nuevoItem);
            return true;
        }
        for (Item item : items) {
            if (item.guardarItem(nuevoItem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Item buscarItem(String nombre) {
        if (this.getNombre().equals(nombre)) {
            return this;
        }
        for (Item item : items) {
            Item encontrado = item.buscarItem(nombre);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }

    @Override
    public int espacioMasGrandeQueSePuedeUtilizar() {
        int espacioOcupado = 0;
        for (Item item : items) {
            espacioOcupado += item.getTamaño();
        }
        int espacioLibre = capacidad - espacioOcupado;
        int maxEspacioInterno = 0;
        for (Item item : items) {
            maxEspacioInterno = Math.max(maxEspacioInterno, item.espacioMasGrandeQueSePuedeUtilizar());
        }
        return Math.max(espacioLibre, maxEspacioInterno);
    }

    @Override
    public int capacidadDisponible() {
        int totalDisponible = capacidad;
        for (Item item : items) {
            totalDisponible += item.capacidadDisponible();
            totalDisponible -= item.getTamaño();
        }
        return totalDisponible;
    }
}
```

