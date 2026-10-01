# Template Method
Patron de diseño de comportamiento.

## Proposito:
Definir el esqueleto de un algoritmo en un metodo, difiriendo algunos pasos a las subclases.
Template method permite que las subclases redefinan ciertos passo de un algortimo sin camibar la estrucutra del algoritmo.

## UML:

´´´plantuml
class Client {
    +main()
}

abstract class AbstractClass {
    +templateMethod()
    +primitiveOperation1()
    +primitiveOperation2()
}

class ConcreteClass1 {
    +primitiveOperation1()
    +primitiveOperation2()
}

ConcreteClass1 --|> AbstractClass
Client --> AbstractClass
´´´

## Roles:
- AbstractClass: Declara el template method y los pasos del algoritmo.
- ConcreteClass: Implementa los pasos del algoritmo.
- Client: Llama al template method para ejecutar el algoritmo.

Los metodos primitivos son los pasos del algoritmo que pueden ser redefinidos por las subclases. 
Los metodo Hook son pasos opcionales que pueden ser redefinidos por las subclases, pero no es obligatorio, es decir ya lo implementa la clase abstracta.

## Ejemplo codigo:
```java
public abstract class ClaseTemplate {
    public final void metodoTemplate() {
        if(hook()) {
            paso1();
            paso2();
        }
        paso3();
    }

    protected abstract void paso1();
    protected abstract void paso2();
    protected void paso3() {
        System.out.println("Paso 3 implementado en la clase abstracta");
    }

    protected boolean hook() {
        return false;
    }
} 

public class ClaseConcreta1 extends ClaseTemplate {
    @Override
    protected void paso1() {
        System.out.println("Paso 1 implementado en la clase concreta 1");
    }

    @Override
    protected void paso2() {
        System.out.println("Paso 2 implementado en la clase concreta 1");
    }

    @Override
    protected boolean hook() {
        return true;
    }
}
```
# Strategy
Patron de diseño de comportamiento.

## Proposito:
Define una familia de algoritmos, encapsula cada uno y los hace intercambiables. Permite que el algortimo cambie de manera independiente del objeto que lo usa.

## UML:

´´´plantuml
    class Client {
        +main()
    }

    class Context {
        -strategy: Strategy
        +Context(Strategy)
        +setStrategy(Strategy)
        +executeStrategy()
    }

    interface Strategy {
        +execute()
    }

    class ConcreteStrategyA {
        +execute()
    }

    class ConcreteStrategyB {
        +execute()
    }

    ConcreteStrategyA --|> Strategy
    ConcreteStrategyB --|> Strategy
    Context --> Strategy
    Client --> Context
´´´

## Roles:
- Strategy: Declara una interfaz común para todos los algoritmos soportados.
- ConcreteStrategy: Implementa un algoritmo usando la interfaz Strategy.
- Context: Mantiene una referencia a un objeto Strategy y puede cambiarlo en tiempo de ejecución.
- Client: Crea un objeto Context y le asigna una estrategia concreta.

La estrategia la cambia el contexto, es decir, el algoritmo que se ejecuta depende del contexto. El contexto puede cambiar la estrategia en tiempo de ejecución.

## Ejemplo codigo:
```java
public interface Strategy {
    void execute();
}

public class Contexto {
    private String data;
    private Strategy strategy;

    public Contexto(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute(this);
    }
}

public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute(Contexto context) {
        System.out.println("Ejecución de la estrategia A con data: " + context.data);
    }
}

public class ConcreteStrategyB implements Strategy {
    @Override
    public void execute(Contexto context) {
        System.out.println("Ejecución de la estrategia B con data: " + context.data);
    }
}
```

# State
Patron de diseño de comportamiento.

## Proposito:
Permitir a un objeto alterar su comportamiento cuando su estado interno cambia. El objeto parecerá cambiar de clase.

## UML:

´´´plantuml
    class Context {
        -state: State
        +Context(State)
        +setState(State)
        +request()
    }

    interface State {
        +handle()
    }

    class ConcreteStateA {
        +handle()
    }

    class ConcreteStateB {
        +handle()
    }

    ConcreteStateA --|> State
    ConcreteStateB --|> State
    Context --> State
´´´

## Roles:
- State: Declara una interfaz para encapsular el comportamiento asociado con un estado particular del Context.
- ConcreteState: Implementa un comportamiento asociado con un estado del Context.
- Context: Mantiene una instancia de un objeto ConcreteState que define el estado actual.

Recordar aca que el patron state es muy similar al patron strategy, la diferencia es que en el patron state cada state cambia el estado del contexto, mientras que en el patron strategy el contexto no cambia de estado, solo cambia la estrategia que se ejecuta.

## Ejemplo codigo:
```java
public interface State {
    void handle(Context context);
}

public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}

public class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Manejando el estado A");
        context.setState(new ConcreteStateB());
    }
}

public class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Manejando el estado B");
        context.setState(new ConcreteStateA());
    }
}
```

# Builder 
Patron de diseño de creación.

## Proposito:
Permitir reducir la complejidad de la creación de objetos complejos, separando la construcción de un objeto complejo de su representación, de manera que el mismo proceso de construcción pueda crear diferentes representaciones.

## UML:

```plantuml
    class Director {
        +construct(Builder)
    }

    abstract class Builder {
        +buildPartA()
        +buildPartB()
        +buildPartC()
        +getResult()
    }

    class ConcreteBuilder {
        +buildPartA()
        +buildPartB()
        +buildPartC()
        +getResult()
    }

    class Product {
        -partA: String
        -partB: String
        -partC: String
    }

    Director --> Builder
    Builder --> Product
```

## Roles:
- Director: Construye un objeto usando la interfaz Builder.
- Builder: Declara una interfaz para crear las partes de un objeto Product.
- ConcreteBuilder: Implementa la interfaz Builder y construye el objeto Product.
- Product: Representa el objeto complejo que se está construyendo.

## Ejemplo codigo:
```java
public class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public abstract Product getResult();
}

public class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("Parte A construida");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Parte B construida");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Parte C construida");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
```

En este patron si quiero agregar la creacion de nuevos objetos es tan simple como crear una nueva clase que herede de Builder y sobreescribir los metodos de construccion, sin necesidad de modificar el codigo del Director ni del Product.

Si quiero agregar un nuevo paso de construccion, es decir, un nuevo metodo en el Builder, ahi si tengo que modificar el codigo del Director, porque es quien define el orden de construccion y llama a cada paso en su metodo construct(). Ademas agrego el metodo en la clase Builder (o interfaz) y lo sobreescribo en las clases concretas. El Product no se modifica a menos que el paso nuevo requiera una parte nueva del objeto.

# Factory Method
Patron de diseño de creación.

## Proposito:
Define una interfaz para crear un objeto, pero deja que las subclases decidan que clase instanciar. Factory Method permite a una clase diferir la instanciacion a subclases.

## UML:
```plantuml
    class Client {
        +main()
    }

    abstract class Creator {
        +factoryMethod()
        +anOperation()
    }

    class ConcreteCreatorA {
        +factoryMethod()
    }

    class ConcreteCreatorB {
        +factoryMethod()
    }

    interface Product {
        +operation()
    }

    class ConcreteProductA {
        +operation()
    }

    class ConcreteProductB {
        +operation()
    }

    ConcreteCreatorA --|> Creator
    ConcreteCreatorB --|> Creator
    ConcreteProductA --|> Product
    ConcreteProductB --|> Product
```

## Roles:
- Creator: Declara el factory method que devuelve un objeto de tipo Product. Puede definir un comportamiento por defecto que dependa del objeto Product devuelto por el factory method.
- ConcreteCreator: Sobreescribe el factory method para devolver una instancia de un ConcreteProduct.
- Product: Declara la interfaz de los objetos que el factory method crea.
- ConcreteProduct: Implementa la interfaz Product.
- Client: Crea un objeto ConcreteCreator y llama al factory method para obtener un objeto Product.

## Ejemplo codigo:
```java
public abstract class Logistica {
    public abstract Transporte crearTransporte();

    public void planificarEntrega() {
        Transporte transporte = crearTransporte();
        transporte.entregar(); 
        // Tambine podria ser 
        this.crearTransporte().entregar();
    }
}

public class LogisticaTerrestre extends Logistica {
    @Override
    public Transporte crearTransporte() {
        return new Camion();
    }
}

public class LogisticaAerea extends Logistica {
    @Override
    public Transporte crearTransporte() {
        return new Avion();
    }
}

public interface Transporte {
    void entregar();
}

public class Camion implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega realizada por camión");
    }
}

public class Avion implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega realizada por avión");
    }
}
```

# Composite
Patron de diseño estructural.

## Proposito:
Componer objetos en estructuras de arbol para representar jerarquias parte-todo. Composite permite a los clientes tratar de manera uniforme objetos individuales y composiciones de objetos.

## UML:
```plantuml
    abstract class Component {
        +operation()
    }

    class Leaf {
        +operation()
    }

    class Composite {
        -children: List<Component>
        +add(Component)
        +remove(Component)
        +getChild(int)
        +operation()
    }

    Leaf --|> Component
    Composite --|> Component
```

o 

```plantuml
    abstract class Component {
        public abstract void operation();
        public abstract void add(Component component);
        public abstract void remove(Component component);
        public abstract Component getChild(int index);
    }

    class Leaf {
        +operation()
    }

    class Composite {
        -children: List<Component>
        +operation()
    }
```

La segunda opcion permite realmente tratar a los objetos individuales y composiciones de objetos de manera uniforme, ya que todos los metodos estan definidos en la clase abstracta Component. La primera opcion no permite tratar a los objetos individuales y composiciones de objetos de manera uniforme, ya que los metodos add, remove y getChild no estan definidos en la clase abstracta Component.


# Decorator 
Patron de diseño estructural.

## Proposito:
Se necesita cambiar/agregar comportamiento adicional a cierto objeto en tiempo de ejecución.

## UML:
```plantuml
    interface Component {
        +operation()
    }

    class ConcreteComponent implements Component {
        +operation()
    }

    class Decorator implements Component {
        -component: Component
        +Decorator(Component)
        +operation()
    }

    class ConcreteDecoratorA extends Decorator {
        +operation()
    }

    class ConcreteDecoratorB extends Decorator {
        +operation()
    }

    ConcreteComponent --|> Component
    Decorator --|> Component
    ConcreteDecoratorA --|> Decorator
    ConcreteDecoratorB --|> Decorator
```

## Roles:
- Component: Declara la interfaz del objeto que se va a decorar.
- ConcreteComponent: Define un objeto al que se le pueden agregar responsabilidades adicionales.
- Decorator: Mantiene una referencia a un objeto Component y define una interfaz que cumple con la interfaz Component.
- ConcreteDecorator: Agrega responsabilidades adicionales al objeto Component.
- Client: Crea un objeto ConcreteComponent y lo decora con uno o más ConcreteDecorator.

## Ejemplo codigo:
```java
public interface Cafe {
    String getDescripcion();
    double getCosto();
}

public class CafeSimple implements Cafe {
    @Override
    public String getDescripcion() {
        return "Café simple";
    }

    @Override
    public double getCosto() {
        return 1.0;
    }
}

public abstract class CafeDecorador implements Cafe {
    protected Cafe cafe;

    public CafeDecorador(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion();
    }

    @Override
    public double getCosto() {
        return cafe.getCosto();
    }
}

public class CafeConLeche extends CafeDecorador {
    public CafeConLeche(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + ", con leche";
    }

    @Override
    public double getCosto() {
        return cafe.getCosto() + 0.5;
    }
}
```

# Adapter
Patron de diseño estructural.

## Proposito:
Se necesita que una clase existente funcione con otra clase, pero sus interfaces no son compatibles. Adapter permite que las interfaces incompatibles trabajen juntas.

## UML:
```plantuml
    class Client {
        +main()
    }

    interface Target {
        +request()
    }

    class Adaptee {
        +specificRequest()
    }

    class Adapter implements Target {
        -adaptee: Adaptee
        +Adapter(Adaptee)
        +request()
    }

    Adaptee --> Adapter
    Adapter --|> Target
    Client --> Target
```

## Roles:
- Target: Declara la interfaz que el cliente espera.
- Adaptee: Define una interfaz existente que necesita ser adaptada.
- Adapter: Adapta la interfaz de Adaptee a la interfaz Target. Contiene una instancia de Adaptee y traduce las llamadas del cliente a la interfaz de Adaptee.
- Client: Utiliza la interfaz Target para interactuar con objetos de tipo Adaptee a través del Adapter.

## Ejemplo codigo:
```java
public interface Target {
    void request();
}

public class Adaptee {
    public void specificRequest() {
        System.out.println("Solicitud específica del Adaptee");
    }
}

public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
```

# Proxy
Patron de diseño estructural.

## Proposito:
Se necesita un sustituto o representante de otro objeto para controlar el acceso a este. Proxy proporciona un objeto que controla el acceso a otro objeto, permitiendo realizar acciones adicionales antes o después de la solicitud al objeto real.

## UML:
```plantuml
    class Client {
        +main()
    }

    interface Subject {
        +request()
    }

    class RealSubject implements Subject {
        +request()
    }

    class Proxy implements Subject {
        -realSubject: RealSubject
        +Proxy(RealSubject)
        +request()
    }

    RealSubject --|> Subject
    Proxy --|> Subject
    Client --> Subject
```

## Roles:
- Subject: Declara la interfaz común para RealSubject y Proxy.
- RealSubject: Define el objeto real al que se accede a través del Proxy.
- Proxy: Mantiene una referencia al objeto real y controla el acceso a él. El metodo request() del Proxy puede realizar acciones adicionales antes o después de delegar la solicitud al RealSubject.
- Client: Utiliza la interfaz Subject para interactuar con el objeto RealSubject a través del Proxy.

## Ejemplo codigo:
```java
public interface Camara {
    void tomarFoto();
}

public class CamaraReal implements Camara {
    @Override
    public void tomarFoto() {
        System.out.println("Foto tomada por la cámara real");
    }
}

public class CamaraProxy implements Camara {
    private CamaraReal camaraReal;

    @Override
    public void tomarFoto() {
        if (camaraReal == null) {
            camaraReal = new CamaraReal();
        }
        System.out.println("Proxy: Preparando la cámara...");
        camaraReal.tomarFoto();
        System.out.println("Proxy: Foto tomada con éxito.");
    }
}
```