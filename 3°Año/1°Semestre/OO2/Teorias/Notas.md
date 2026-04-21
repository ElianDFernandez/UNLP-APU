
# Notas: Teoría de Objetos 2

## Refactoring

La **refactorización** es el proceso de modificar el código interno de un programa sin cambiar su comportamiento externo, con el objetivo de hacerlo más fácil de entender, mantener y extender.

---

## Catálogo de Métodos de Refactorización

### Encapsulate Field (Encapsular Atributo)
- **Precondiciones:** Existe un atributo (campo) público en un objeto.
- **Postcondiciones:** El atributo pasa a ser privado y se accede a él mediante métodos.
- **Transformación:** Se crean métodos getter y setter para el campo, y se cambia su visibilidad a privada, protegiendo así la integridad de los datos.

### Pull Up Method (Subir Método)
- **Precondiciones:** Subclases distintas tienen un método con resultados idénticos (misma firma y comportamiento).
Independencia de la subclase (Crucial): El método que se desea subir no debe depender de atributos o métodos que existan únicamente en las subclases.
- **Postcondiciones:** El método se centraliza en la clase padre compartida.
- **Transformación:** Se extrae el método común de las subclases y se traslada a la superclase, eliminando la duplicación de código.

### Pull Up Field (Subir Atributo)
- **Precondiciones:** Dos o más subclases declaran el mismo atributo (mismo tipo y propósito).
- **Postcondiciones:** El atributo reside únicamente en la clase padre.
- **Transformación:** Se elimina el atributo de las subclases y se declara en la superclase para que todas lo hereden.


### Extract Method (Extraer Método)
- **Precondiciones:** Un método tiene un bloque de código que puede ser identificado como una tarea lógica independiente.
- **Postcondiciones:** El bloque de código se convierte en un nuevo método con un nombre descriptivo, y el método original ahora llama a este nuevo método.
- **Transformación:** Se selecciona el bloque de código, se extrae a un nuevo método y se reemplaza el bloque original con una llamada a este nuevo método, mejorando la legibilidad y la reutilabilidad.

### Move Method (Mover Método)
- **Precondiciones:** Un método utiliza más datos de otra clase que de la clase a la que pertenece actualmente.
- **Postcondiciones:** El método se traslada a la clase que maneja los datos que utiliza.
- **Transformación:** Se mueve el método a la clase que tiene más sentido para su funcionalidad, lo que puede mejorar la cohesión y reducir el acoplamiento.

---

## Bad Smells (Malos Olores)

Los "malos olores" son síntomas en el código que indican problemas de diseño o áreas que pueden ser mejoradas mediante la refactorización. Se agrupan en las siguientes categorías:

### 1. Bloaters (Hipertrofia)

Código, métodos o clases que han crecido a proporciones tan grandes que son difíciles de manejar. Suelen acumularse con el tiempo.

- **Long Method:** Un método con demasiadas líneas de código o responsabilidades.
- **Large Class:** Una clase que hace demasiadas cosas, reflejado en muchas líneas de código o un exceso de atributos.
- **Primitive Obsession:** Uso excesivo de tipos primitivos (ints, strings) para modelar conceptos del dominio en lugar de crear objetos pequeños (ej. usar un String para un número de teléfono en lugar de una clase Telefono).
- **Long Parameter List:** Un método que requiere demasiados parámetros para funcionar.
- **Data Clumps:** Grupos de variables que siempre aparecen juntas en distintas partes del código (ej. x, y, z o calle, ciudad, codigoPostal) y que deberían agruparse en un objeto propio.
- **Imperative Loops:** Uso excesivo de bucles tradicionales (for, while) cuando podrían reemplazarse por operaciones de colecciones más declarativas (métodos de orden superior como map, filter, reduce).

### 2. Tool Abusers / Object-Orientation Abusers (Abuso de Herramientas)

Código que hace un uso incorrecto o incompleto de los principios de diseño orientado a objetos.

- **Switch Statements:** Uso excesivo de sentencias switch o largas cadenas de if-else para manejar variantes, en lugar de utilizar el polimorfismo.
- **Refused Bequest (Herencia Rechazada):** Una subclase hereda métodos y atributos de sus padres, pero solo necesita o utiliza una pequeña parte de ellos, indicando una jerarquía incorrecta.
- **Temporary Field:** Un atributo en un objeto que solo obtiene su valor en ciertas circunstancias y permanece vacío el resto del tiempo.
- **Alternative Classes with Different Interfaces:** Clases distintas que hacen funciones muy similares o representan la misma entidad, pero tienen nombres de métodos o firmas (interfaces) diferentes.

### 3. Change Preventers (Inhibidores de Cambio)

Smells que violan el principio de que un cambio en el sistema debería afectar a un solo lugar. Si para hacer una modificación tienes que cambiar el código en múltiples sitios, estás ante un inhibidor.

- **Divergent Change:** Ocurre dentro de una misma clase. Una clase cambia por muchas razones diferentes (violación del Principio de Responsabilidad Única).
- **Shotgun Surgery:** Ocurre entre múltiples clases. Hacer una sola modificación conceptual requiere hacer pequeños cambios en muchas clases diferentes.
- **Parallel Inheritance Hierarchies:** Cada vez que creas una subclase para una jerarquía, te ves obligado a crear una subclase correspondiente en otra jerarquía distinta.

### 4. Dispensables (Prescindibles)

Elementos innecesarios cuyo código no aporta valor y cuya eliminación haría que el sistema fuera más limpio.

- **Lazy Class:** Una clase que no hace lo suficiente para justificar su existencia y mantenimiento.
- **Data Class:** Clases tontas que solo tienen atributos, getters y setters, pero ningún comportamiento o lógica de negocio.
- **Dead Code:** Variables, parámetros, métodos o clases que ya no se usan en el programa.
- **Speculative Generality:** Código (parámetros extra, clases abstractas innecesarias) creado "por si acaso" para manejar casos futuros hipotéticos que hoy no se necesitan.
- **Comments:** Comentarios utilizados para explicar código espagueti o mal escrito. (El buen código debe ser autoexplicativo; los comentarios deben explicar el "por qué", no el "qué").
- **Uncommunicative Name:** Variables, métodos o clases con nombres que no describen claramente su propósito (ej. int d;, class Gestor).
- **Magic Number:** Valores literales (números o strings) directamente en el código sin explicación de su significado, lo que dificulta la lectura (ej. if (estado == 4) en lugar de usar una constante descriptiva).


### 5. Couplers (Acopladores)

Smells que indican un alto grado de dependencia (acoplamiento) entre clases, lo que dificulta la reutilización y el mantenimiento.

- **Feature Envy:** Un método que accede más a los datos de otro objeto que a los de su propia clase.
- **Inappropriate Intimacy:** Dos clases que están excesivamente acopladas y acceden a las partes privadas o detalles internos de la otra.
- **Message Chains:** Una cadena larga de delegaciones para acceder a un dato (objeto.getA().getB().getC().hacerAlgo()), lo que acopla el cliente a la estructura de navegación.
- **Middle Man:** Una clase cuyo único propósito aparente es delegar llamadas a otra clase, sin añadir ningún valor o lógica propia.

---

# Soluciones a los Bad Smells (Catálogo de Refactoring)

## 1. Bloaters (Hipertrofia)

- **Long Method:**
	- *Extract Method*: Extraer bloques lógicos del método gigante en métodos más pequeños y descriptivos.
	- *Replace Temp with Query*: Si hay muchas variables temporales, extraer el cálculo a su propio método.
- **Large Class:**
	- *Extract Class*: Dividir la clase creando una nueva clase para agrupar un conjunto de comportamientos y datos afines.
	- *Extract Subclass*: Si la clase tiene comportamiento que solo se usa bajo ciertas condiciones, extraerlo a una subclase.
- **Primitive Obsession:**
	- *Replace Data Value with Object*: Crear una clase para representar ese dato primitivo (ej. clase Moneda, clase Email).
- **Long Parameter List:**
	- *Introduce Parameter Object*: Agrupar los parámetros relacionados en un solo objeto y pasarlo como parámetro.
	- *Preserve Whole Object*: Si estás sacando varios datos de un objeto para pasarlos como parámetros, pasa el objeto entero.
- **Data Clumps:**
	- *Extract Class*: Convertir ese grupo de variables repetidas en un objeto propio.
- **Imperative Loops:**
	- *Replace Loop with Pipeline*: Usar closures o métodos de colecciones (como map, select/filter, reduce/fold) que provea el lenguaje.

## 2. Tool Abusers / Object-Orientation Abusers

- **Switch Statements:**
	- *Replace Conditional with Polymorphism*: Crear subclases para cada rama del switch o if-else y usar polimorfismo para ejecutar el comportamiento correcto.
- **Refused Bequest:**
	- *Push Down Method / Push Down Field*: Si los métodos heredados solo tienen sentido para algunas subclases, moverlos de la superclase hacia las subclases que realmente los usan.
	- *Replace Inheritance with Delegation*: Si la herencia conceptualmente no tiene sentido, usar composición (tener una instancia de la clase padre en lugar de heredar de ella).
- **Temporary Field:**
	- *Extract Class*: Mover el atributo temporal y todo el código que lo opera a su propia clase.
- **Alternative Classes with Different Interfaces:**
	- *Rename Method*: Unificar las firmas de los métodos para que compartan una interfaz común.
	- *Move Method*: Mover el comportamiento si es necesario para unificar las clases.

## 3. Change Preventers (Inhibidores de Cambio)

- **Divergent Change:**
	- *Extract Class*: Identificar las distintas responsabilidades por las que la clase cambia y extraerlas a nuevas clases.
- **Shotgun Surgery:**
	- *Move Method / Move Field*: Agrupar el comportamiento disperso moviendo los métodos o atributos a una sola clase (o creando una nueva si no existe).
- **Parallel Inheritance Hierarchies:**
	- *Move Method / Move Field*: Mover el comportamiento de una jerarquía a la otra hasta poder eliminar la jerarquía redundante.

## 4. Dispensables (Prescindibles)

- **Lazy Class:**
	- *Inline Class*: Si la clase es casi inútil, mover todas sus características a la clase que más la usa y eliminar la clase original.
	- *Collapse Hierarchy*: Si una superclase y su subclase ya no son muy diferentes, fusionarlas.
- **Data Class:**
	- *Move Method*: Buscar dónde se usa esa data y mover los métodos que operan sobre esos datos hacia la Data Class (dándole comportamiento real).
- **Dead Code:**
	- *Eliminar el código*: Simplemente borrarlo. Usar el control de versiones (Git) como red de seguridad.
- **Speculative Generality:**
	- *Collapse Hierarchy / Inline Class*: Simplificar la estructura eliminando abstracciones inútiles.
	- *Remove Parameter*: Quitar parámetros no utilizados.
- **Comments:**
	- *Extract Method / Rename Method*: Refactorizar el código para que el nombre del método explique lo que hace, volviendo redundante el comentario.
- **Uncommunicative Name:**
	- *Rename Variable / Rename Method / Rename Class*: Cambiar el nombre por uno descriptivo y con semántica adecuada.
- **Magic Number:**
	- *Replace Magic Number with Symbolic Constant*: Reemplazar el literal por una constante con un nombre que explique su significado.

## 5. Couplers (Acopladores)

- **Feature Envy:**
	- *Move Method*: Mover el método a la clase a cuyos datos accede más a menudo.
	- *Extract Method*: Si solo una parte del método tiene Feature Envy, extraerla y luego moverla.
- **Inappropriate Intimacy:**
	- *Move Method / Move Field*: Separar las partes demasiado acopladas.
	- *Extract Class*: Crear un tercer objeto si ambas clases necesitan compartir muchos datos comunes.
	- *Hide Delegate*: Reducir la visibilidad de los métodos internos.
- **Message Chains:**
	- *Hide Delegate*: En lugar de encadenar llamadas, la clase cliente debe llamar a un método en el primer objeto, y ese objeto se encarga de delegar internamente.
- **Middle Man:**
	- *Remove Middle Man*: Hacer que la clase cliente llame directamente a la clase delegada en lugar de pasar por el intermediario inútil.

# Patrones de Diseño

## Adapter (Adaptador)

El patrón Adapter es un patrón de diseño estructural que permite que dos interfaces incompatibles trabajen juntas. El adaptador actúa como un puente entre las dos interfaces, traduciendo las llamadas de una a la otra.
Cuando usarlo:
- Cuando tienes una clase existente que no tiene la interfaz que necesitas.
- Cuando quieres usar una clase existente pero su interfaz no es compatible con el código que tienes.
- Cuando quieres crear una clase reutilizable que coopere con clases no relacionadas o con interfaces desconocidas.

Ejemplo:
```java
// 1. Target: La interfaz que nuestro sistema (el Celular Nuevo) espera usar.
public interface CargadorTipoC {
    void cargarConTipoC();
}

// Cliente: Nuestro sistema que solo entiende la interfaz Target.
public class CelularNuevo {
    public void cargarCelular(CargadorTipoC cargador) {
        System.out.println("Conectando al puerto Tipo C...");
        cargador.cargarConTipoC();
    }
}

// ---------------------------------------------------------

// 2. Adaptee: La clase que ya existe y funciona, pero es INCOMPATIBLE.
public class CableMicroUSB {
    public void proveerEnergiaMicroUSB() {
        System.out.println("Enviando energía a través del cable Micro-USB viejo.");
    }
}

// ---------------------------------------------------------

// 3. Adapter: La clase puente. "Se disfraza" de Tipo C, pero usa el Micro-USB por dentro.
public class AdaptadorMicroUSB_A_TipoC implements CargadorTipoC {
    
    // Tiene una referencia al objeto incompatible
    private CableMicroUSB cableViejo;

    public AdaptadorMicroUSB_A_TipoC(CableMicroUSB cableViejo) {
        this.cableViejo = cableViejo;
    }

    // Implementa el método que espera el celular nuevo...
    @Override
    public void cargarConTipoC() {
        // ...pero por dentro "traduce" la llamada al método del cable viejo
        System.out.println("Adaptador: Convirtiendo conexión Micro-USB a Tipo C...");
        this.cableViejo.proveerEnergiaMicroUSB();
    }
}

// ---------------------------------------------------------

// 4. Main: Cómo se ve todo esto funcionando junto
public class Main {
    public static void main(String[] args) {
        CelularNuevo miCelular = new CelularNuevo();
        CableMicroUSB cableQueTengoEnCasa = new CableMicroUSB();
        
        // miCelular.cargarCelular(cableQueTengoEnCasa); // ¡ERROR! No encajan.

        // Solución: Usamos el adaptador
        CargadorTipoC adaptador = new AdaptadorMicroUSB_A_TipoC(cableQueTengoEnCasa);
        
        // Ahora el celular se carga sin problemas sin tener que romper el cable viejo
        miCelular.cargarCelular(adaptador);
    }
}
```

## Composite (Compuesto)

El patrón Composite es un patrón de diseño estructural que permite tratar objetos individuales y composiciones de objetos de manera uniforme. Es útil para representar jerarquías de objetos donde los objetos pueden ser tanto simples (hojas) como compuestos (nodos con hijos).
Cuando usarlo:
- Cuando quieres representar una jerarquía de objetos en forma de árbol.
- Cuando quieres que los clientes traten a los objetos individuales y a las composiciones de manera uniforme.
Ejemplo:
```java
// 1. Component: La interfaz común para objetos individuales y compuestos.
public interface Componente {
	void mostrarDetalles();
}

// ---------------------------------------------------------
// 2. Leaf: Representa objetos individuales (hojas).
public class Archivo implements Componente {
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Archivo: " + nombre);
	}
}
// ---------------------------------------------------------
// 3. Composite: Representa objetos compuestos (nodos con hijos).
import java.util.ArrayList;
import java.util.List;

public class Carpeta implements Componente {
	private String nombre;
	private List<Componente> componentes = new ArrayList<>();

	public Carpeta(String nombre) {
		this.nombre = nombre;
	}

	public void agregar(Componente componente) {
		componentes.add(componente);
	}

	public void eliminar(Componente componente) {
		componentes.remove(componente);
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Carpeta: " + nombre);
		for (Componente componente : componentes) {
			componente.mostrarDetalles();
		}
	}
}
// ---------------------------------------------------------
// 4. Main: Cómo se ve todo esto funcionando junto
public class Main {
	public static void main(String[] args) {
		Archivo archivo1 = new Archivo("documento.txt");
		Archivo archivo2 = new Archivo("foto.jpg");

		Carpeta carpeta1 = new Carpeta("Mis Documentos");
		carpeta1.agregar(archivo1);

		Carpeta carpeta2 = new Carpeta("Mis Fotos");
		carpeta2.agregar(archivo2);

		Carpeta carpetaPrincipal = new Carpeta("Mi Computadora");
		carpetaPrincipal.agregar(carpeta1);
		carpetaPrincipal.agregar(carpeta2);

		carpetaPrincipal.mostrarDetalles();
	}
}
```

## Factory Method (Método de Fábrica)
El patrón Factory Method es un patrón de diseño creacional que define una interfaz para crear objetos, pero permite que las subclases decidan qué clase instanciar. El Factory Method delega la responsabilidad de creación a las subclases, lo que permite una mayor flexibilidad y desacoplamiento en el código.
Cuando usarlo:
- Cuando una clase no puede anticipar la clase de objetos que debe crear.
- Cuando quieres que las subclases especifiquen los objetos que se deben crear.
- Cuando quieres centralizar la creación de objetos para facilitar el mantenimiento y la extensión.
- Cuando quieres proporcionar una interfaz común para la creación de objetos en una jerarquía de clases.
- Cuando quieres evitar acoplar el código a clases concretas y prefieres trabajar con interfaces o clases abstractas.
Ejemplo:
```java
// 1. Product: La interfaz común para los objetos que se van a crear.
public interface Animal {
	void hacerSonido();
}

// ---------------------------------------------------------
// 2. Concrete Products: Clases concretas que implementan la interfaz Product.
public class Perro implements Animal {
	@Override
	public void hacerSonido() {
		System.out.println("¡Guau!");
	}
}

public class Gato implements Animal {
	@Override
	public void hacerSonido() {
		System.out.println("¡Miau!");
	}
}

// ---------------------------------------------------------
// 3. Creator: La clase que declara el método de fábrica, que devuelve un objeto del tipo Product.
public abstract class CreadorAnimal {
	public abstract Animal crearAnimal();
}

// ---------------------------------------------------------
// 4. Concrete Creators: Clases concretas que implementan el método de fábrica para crear objetos específicos.
public class CreadorPerro extends CreadorAnimal {
	@Override
	public Animal crearAnimal() {
		return new Perro();
	}
}

public class CreadorGato extends CreadorAnimal {
	@Override
	public Animal crearAnimal() {
		return new Gato();
	}
}

// ---------------------------------------------------------
// 5. Main: Cómo se ve todo esto funcionando junto
public class Main {
	public static void main(String[] args) {
		CreadorAnimal creadorPerro = new CreadorPerro();
		Animal perro = creadorPerro.crearAnimal();
		perro.hacerSonido(); // Output: ¡Guau!

		CreadorAnimal creadorGato = new CreadorGato();
		Animal gato = creadorGato.crearAnimal();
		gato.hacerSonido(); // Output: ¡Miau!
	}
}
```

## Builder (Constructor)
El patrón Builder es un patrón de diseño creacional que permite construir objetos complejos paso a paso, separando la construcción de la representación del objeto. El Builder proporciona una interfaz para crear diferentes representaciones de un objeto utilizando el mismo proceso de construcción.
Cuando usarlo:
- Cuando quieres construir un objeto complejo que requiere múltiples pasos o configuraciones.
- Cuando quieres separar la construcción de un objeto de su representación para que el mismo proceso de construcción pueda crear diferentes representaciones.
- Cuando quieres evitar un constructor telescópico (constructores con muchos parámetros) y prefieres una forma más legible y flexible de crear objetos.
- Cuando quieres construir objetos de manera incremental, permitiendo que el cliente controle el proceso de construcción.
Ejemplo:
```java
// 1. Product: La clase del objeto complejo que se va a construir.
public class Casa {
	private String tipo;
	private int habitaciones;
	private boolean tieneGaraje;

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setTieneGaraje(boolean tieneGaraje) {
		this.tieneGaraje = tieneGaraje;
	}

	@Override
	public String toString() {
		return "Casa{" +
				"tipo='" + tipo + '\'' +
				", habitaciones=" + habitaciones +
				", tieneGaraje=" + tieneGaraje +
				'}';
	}
}
// ---------------------------------------------------------
// 2. Builder: La interfaz que define los pasos para construir el objeto.
public interface CasaBuilder {
	void construirTipo();
	void construirHabitaciones();
	void construirGaraje();
	Casa getCasa();
}

// ---------------------------------------------------------
// 3. Concrete Builder: La clase concreta que implementa la interfaz Builder para construir un tipo específico de objeto.
public class CasaModernaBuilder implements CasaBuilder {
	private Casa casa;

	public CasaModernaBuilder() {
		this.casa = new Casa();
	}

	@Override
	public void construirTipo() {
		casa.setTipo("Moderna");
	}

	@Override
	public void construirHabitaciones() {
		casa.setHabitaciones(4);
	}

	@Override
	public void construirGaraje() {
		casa.setTieneGaraje(true);
	}

	@Override
	public Casa getCasa() {
		return this.casa;
	}
}
// ---------------------------------------------------------
// 4. Director: La clase que controla el proceso de construcción utilizando el Builder.
public class Director {
	private CasaBuilder builder;

	public Director(CasaBuilder builder) {
		this.builder = builder;
	}

	public void construirCasa() {
		builder.construirTipo();
		builder.construirHabitaciones();
		builder.construirGaraje();
	}
}
// ---------------------------------------------------------
// 5. Main: Cómo se ve todo esto funcionando junto
public class Main {
	public static void main(String[] args) {
		CasaBuilder builder = new CasaModernaBuilder();
		Director director = new Director(builder);
		director.construirCasa();
		Casa casa = builder.getCasa();
		System.out.println(casa);
	}
}
```

## Strategy (Estrategia)

El patrón Strategy es un patrón de diseño de comportamiento que permite definir una familia de algoritmos, encapsular cada uno de ellos y hacerlos intercambiables. El Strategy permite que el algoritmo varíe independientemente de los clientes que lo utilizan.
Cuando usarlo:
- Cuando tienes varias formas de realizar una tarea y quieres que el cliente pueda elegir entre ellas en tiempo de ejecución.
- Cuando quieres evitar condicionales complejos para seleccionar el comportamiento y prefieres encapsular cada comportamiento en su propia clase.
- Cuando quieres que el algoritmo pueda cambiar sin afectar a los clientes que lo utilizan, promoviendo el principio de abierto/cerrado.
- Cuando quieres separar el código que utiliza un algoritmo del código que implementa el algoritmo, para mejorar la mantenibilidad y la extensibilidad.
Ejemplo:

```java
// 1. Strategy: La interfaz común para todos los algoritmos.
public interface Estrategia {
	void ejecutar();
}
// ---------------------------------------------------------
// 2. Concrete Strategies: Clases concretas que implementan la interfaz Strategy para proporcionar
// diferentes implementaciones del algoritmo.
public class EstrategiaA implements Estrategia {
	@Override
	public void ejecutar() {
		System.out.println("Ejecutando Estrategia A");
	}
}

public class EstrategiaB implements Estrategia {
	@Override
	public void ejecutar() {
		System.out.println("Ejecutando Estrategia B");
	}
}
// ---------------------------------------------------------
// 3. Context: La clase que utiliza una instancia de Strategy para ejecutar el algoritmo.
public class Contexto {
	private Estrategia estrategia;

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	public void ejecutarEstrategia() {
		if (estrategia != null) {
			estrategia.ejecutar();
		} else {
			System.out.println("No se ha establecido una estrategia.");
		}
	}
}
```

## State (Estado)

Patrón de diseño de comportamiento que permite a un objeto alterar su comportamiento cuando su estado interno cambia. El objeto parecerá cambiar su clase.
Cuando usarlo:
- Cuando un objeto debe cambiar su comportamiento en función de su estado interno.
- Cuando tienes un gran número de condicionales que dependen del estado de un objeto, y quieres eliminar esos condicionales para mejorar la mantenibilidad.
- Cuando quieres que el estado de un objeto sea explícito y fácil de entender, en lugar de ocultar la lógica de cambio de estado dentro de métodos con condicionales.
- Cuando quieres que el comportamiento de un objeto pueda cambiar en tiempo de ejecución sin necesidad de modificar su código, promoviendo el principio de abierto/cerrado.
Ejemplo:
```java
// 1. State: La interfaz común para todos los estados.
public interface Estado {
	void manejar(Contexto contexto);
}

// ---------------------------------------------------------
// 2. Concrete States: Clases concretas que implementan la interfaz State para proporcionar
// diferentes comportamientos para cada estado.
public class EstadoEncendido implements Estado {
	@Override
	public void manejar(Contexto contexto) {
		System.out.println("El dispositivo está encendido.");
		contexto.setEstado(new EstadoApagado());
	}
}

public class EstadoApagado implements Estado {
	@Override
	public void manejar(Contexto contexto) {
		System.out.println("El dispositivo está apagado.");
		contexto.setEstado(new EstadoEncendido());
	}
}
// ---------------------------------------------------------
// 3. Context: La clase que mantiene una referencia al estado actual y delega el comportamiento al estado.
public class Contexto {
	private Estado estado;
	public Contexto() {
		this.estado = new EstadoApagado(); // Estado inicial
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public void manejar() {
		if (estado != null) {
			estado.manejar(this);
		} else {
			System.out.println("No se ha establecido un estado.");
		}
	}
}
// ---------------------------------------------------------
// 4. Main: Cómo se ve todo esto funcionando junto
public class Main {
	public static void main(String[] args) {
		Contexto contexto = new Contexto();
		contexto.manejar(); // Output: El dispositivo está apagado.
		contexto.manejar(); // Output: El dispositivo está encendido.
		contexto.manejar(); // Output: El dispositivo está apagado.
	}
}
```

Strategy vs State:
- Ambos patrones utilizan la composición para cambiar el comportamiento de un objeto en tiempo de ejecución.
- La diferencia clave es que Strategy se enfoca en cambiar el algoritmo o comportamiento de un objeto, mientras que State se enfoca en cambiar el estado interno de un objeto, lo que a su vez cambia su comportamiento.
- En Strategy, el cliente es responsable de seleccionar la estrategia adecuada, mientras que en State, el objeto cambia su estado internamente y el cliente no necesita preocuparse por los detalles de cómo se manejan los estados.

