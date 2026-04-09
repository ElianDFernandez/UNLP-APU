
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
- **Postcondiciones:** El método se centraliza en la clase padre compartida.
- **Transformación:** Se extrae el método común de las subclases y se traslada a la superclase, eliminando la duplicación de código.

### Pull Up Field (Subir Atributo)
- **Precondiciones:** Dos o más subclases declaran el mismo atributo (mismo tipo y propósito).
- **Postcondiciones:** El atributo reside únicamente en la clase padre.
- **Transformación:** Se elimina el atributo de las subclases y se declara en la superclase para que todas lo hereden.

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