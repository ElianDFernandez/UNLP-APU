# Pratrones de diseño

# Patron adapter

El patrón Adapter es un patrón de diseño estructural que permite que objetos con interfaces incompatibles trabajen juntos. El Adapter actúa como un puente entre dos interfaces, permitiendo que una clase utilice la funcionalidad de otra clase sin necesidad de modificar su código.

## Ejemplo en Java

```java
// Interfaz objetivo
interface Target {
    void request();
}

// Clase existente con una interfaz incompatible
class Adaptee {
    void specificRequest() {
        System.out.println("Solicitud específica del Adaptee");
    }
}

// Adapter que implementa la interfaz Target y utiliza Adaptee
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // Llama al método específico del Adaptee
        adaptee.specificRequest();
    }
}

// Uso del Adapter
public class Main {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request(); // Salida: Solicitud específica del Adaptee
    }
}
```

En este ejemplo, la clase `Adaptee` tiene un método `specificRequest()` que no es compatible con la interfaz `Target`. La clase `Adapter` implementa la interfaz `Target` y utiliza una instancia de `Adaptee` para llamar al método específico. De esta manera, el cliente puede usar la funcionalidad de `Adaptee` a través de la interfaz `Target` sin necesidad de modificar el código de `Adaptee`.

1.1 Protocolo de Cliente
La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo? 

/** 
* Retorna el límite de crédito del cliente
*/
public double lmtCrdt() {...

/** 
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {...

/** 
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double mtCbE(LocalDate f1, LocalDate f2) {...