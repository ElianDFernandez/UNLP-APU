# Ejercicio 1

Patron Builder

```JAVA

public class Computadora {
    private List<Componente> componentes = new ArrayList<>();

    public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }

    public double calcularConsumo() {
        return componentes.stream.mapToDouble(Componente:getCosumo).sum();
    }

    public double calcularPrecio() {
        double precio = componentes.stream.mapToDouble(Componente:getPrecio).sum();
        return precio * 1.21;
    }
}

public interface BuilderComputadora {
    public void buildProcesador();
    public void buildMemoriaRam();
    public void buildDisco();
    public void buildTarjetaGrafica();
    public void buildGabineteYFuente();
    public Computadora getComputadora();
}

public class BuildComputadoraBasico implements BuilderComputadora {
    private Computadora computadora;
    private Catalogo catalogo;

    public BuildComputadoraBasico(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.computadora = new Computadora();
    }

    public void buildProcesador() {
        computadora.agregarComponente(catalogo.getComponenteDescripcion("Procesador Bascio"));
    }

    public void buildMemoriaRam() {
        computadora.agregarComponente(catalogo.getComponenteDescripcion("8 GB"));
    }

    public void buildDisco() {
        computadora.agregarComponente(catalogo.getComponenteDescripcion("HDD 500 GB"));
    }

    public void buildTarjetaGrafica() {}

    public void buildGabineteYFuente() {
        computadora.agregarComponente(catalogo.getComponenteDescripcion("Gabinete Estandar"));
    }

    public Computadora getComputadora() {
        return this.computadora;
    }
}

public class BuildComputadoraGamer implements BuilderComputadora {
    private Computadora computadora;
    private Catalogo catalogo;

    public BuilderGamer(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.computadora = new Computadora();
    }

    public void buildProcesador() {
        equipo.agregarComponente(catalogo.getComponente("Procesador Gamer"));
        equipo.agregarComponente(catalogo.getComponente("pad térmico"));
        equipo.agregarComponente(catalogo.getComponente("cooler"));
    }

    public void buildMemoriaRam() {
        equipo.agregarComponente(catalogo.getComponente("32 gb"));
        equipo.agregarComponente(catalogo.getComponente("32 gb"));
    }

    public void buildDisco() {
        equipo.agregarComponente(catalogo.getComponente("SSD 500gb"));
        equipo.agregarComponente(catalogo.getComponente("SSD 1 TB"));
    }

    public void buildTarjetaGrafica() {
        equipo.agregarComponente(catalogo.getComponente("RTX 4090"));
    }

    public void buildGabineteYFuente() {
        double consumoActual = equipo.calcularConsumo();
        double consumoFuente = consumoActual + (consumoActual * 0.50);
        
        equipo.agregarComponente(catalogo.getComponente("Gabinete Gamer"));
        equipo.agregarComponente(catalogo.getComponente("fuente consumo " + consumoFuente + " w"));
    }

    public Equipo getResultado() { return equipo; }
}

public class Director {
    private BuilderComputadora builder;

    public Director(BuilderComputadora builder) {
        this.builder = builder;
    }

    public void construirComputadora() {
        builder.buildProcesador();
        builder.buildMemoriaRam();
        builder.buildDisco();
        builder.buildTarjetaGrafica();
        builder.buildGabineteYFuente();
    }

    public Computadora getComputadora() {
        return builder.getComputadora();
    }
}

public class Presupuesto {
    private String nombre;
    private Date fecha;
    private Computadora computadora;

    public Presupuesto(String nombre, Date fecha, Computadora computadora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.computadora = computadora;
    }
}

public class main {
    public static void main(string[]args) {
        Catalogo catalogo = new Catalogo();
        BuilderComputadora builderComputadora = new BuilderComputadoraGamer(catalogo);
        Director director = new Director(builderComputadora);
        director.construirComputadora();
        Computadora computadora = director.getComputadora();

        Presupuesto presupuesto = new Presupuesto("Elian", "10/7/2026", computadora);
    }
}
```

1. Usamos el patron Builder, el cual nos permite construir distintas configuraciones de objetos complejos siguien los mismo pasos. 
En mi diseño: 
La clase Computadora es el objeto complejo a contruir
La interfaz builderComputadora define los pasos a seguir para la creacion de una computadora
La clase BuildComputadoraBasico, BuildComputadoraGamer, son las implementaciones de los passo de construccion, que definen una "configuracion"
La calse Director define el orden en el que se invocaran los paso de construccion

2.

3. Los pasos necesarios para agregar una nueva funcionalidad son: 
   1. Crear una nueva clase que implemente la interfaz buildComputadora
   2. Implementar los metodos para el armado de una computadora
   3. Ahora simplemente pasando este builder al director podemos construir una nueva configuracion de computadora+

4. Para incorporar nuevas configuraciones que implementen monitores y perifericos: 
   1. Modificar la interfaz buildComputadora, agregando los pasos buildMonitor y buildPerifericos
   2. Actualizar las configuraciones actuales implementando estos metodos
   3. Actualizar el director para que considere estos nuevos pasos
   4. Con todo esto ya podemos crear los builder de la misma manera que los veniamos haciendo pero con los nuevos pasos de agregar perifericos y agregar monitor
   

# Ejercicio 2 

1. Bad smells: 
   1. codigo duplicado: lineas 15-17 y 23-25. Se soluciona con extract method 
   2. envidia de atributos: lineas 16 y 24, se llaman a lso atriburtos del producto para realizar calculos, se soluciona con move method

    Refactoring: 
    ```JAVA
    public class Producto {
        private double precio;
        private double IVA;

        public Producto(double precio, double IVA) {
            this.precio = precio;
            this.IVA = IVA;
        }

        // NUEVO MÉTODO: El producto sabe calcular su propio precio final
        public double getPrecioConIVA() {
            return this.precio + (this.precio * this.IVA);
        }
    }
    ```

2. Bad Smells: 
   1. Condicionales complejos: lienas 14 en adelante, esto se soluciona con polimorfismo (Clase pagoTarjeta, y clase PagoEfectivo)
   

    ```JAVA
    public abstract class Pago {
        private List<Producto> productos;

        public Pago(List<Producto> productos) {
            this.productos = productos;
        }

        public double calcularSubtotal() {
            return productos.stream().mapToDouble(Producto::getPrecioConIVA).sum();
        }

        public abstract double calcularMontoFinal();
    }

    public class PagoTarjeta extends Pago {
        private static final double ADICIONAL_TARJETA = 1000.0;

        public PagoTarjeta(List<Producto> productos) {
            super(productos);
        }

        @Override
        public double calcularMontoFinal() {
            return this.calcularSubtotal() + ADICIONAL_TARJETA;
        }
    }

    public class PagoEfectivo extends Pago {
        private static final double DESCUENTO_EFECTIVO = 2000.0;

        public PagoEfectivo(List<Producto> productos) {
            super(productos);
        }

        @Override
        public double calcularMontoFinal() {
            double total = this.calcularSubtotal();
            if (total > 100000) {
                return total - DESCUENTO_EFECTIVO;
            }
            return total;
        }
    }
    ```