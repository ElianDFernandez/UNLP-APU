# Code Smells y Refactorings

> **Code smell**: señal en el código de que existe un problema de diseño profundo. No es un error, pero indica que el código será difícil de mantener, entender o modificar.
>
> **Refactoring**: transformación del código que mejora su estructura **sin cambiar su comportamiento observable**.

---

## Cómo usar esta guía

1. **Identificá** el smell con su nombre exacto (en el parcial vale el nombre en inglés o español).
2. **Justificá** con evidencia del código ("el método hace X, Y y Z a la vez...").
3. **Resolvé** con uno o más refactorings de la tabla.

---

## Glosario: Bad Smells (inglés → español)

> En parcial vale el nombre en inglés **o** el español. Usá el que te quede más cómodo, pero mantenelo consistente dentro de la misma respuesta.

| Inglés | Español | Traducción literal / sinónimo frecuente |
|---|---|---|
| **Alternative Classes with Different Interfaces** | Clases alternativas con interfaces distintas | — |
| **Comments** | Comentarios (excesivos) | — |
| **Data Class** | Clase de datos | — |
| **Data Clumps** | Racimos de datos | Grupos de datos, atados de datos |
| **Divergent Change** | Cambio divergente | — |
| **Duplicated Code** | Código duplicado | — |
| **Feature Envy** | Envidia de atributos | Envidia de datos, envidia de clases |
| **Incomplete Library Class** | Clase de librería incompleta | — |
| **Inappropriate Intimacy** | Intimidad inapropiada | Acoplamiento excesivo entre clases |
| **Large Class** | Clase grande | — |
| **Lazy Class (Freeloader)** | Clase perezosa | — |
| **Long Method** | Método largo | — |
| **Long Parameter List** | Lista larga de parámetros | — |
| **Message Chains** | Cadenas de mensajes | Cadenas de delegación |
| **Middle Man** | Intermediario | Hombre del medio |
| **Parallel Inheritance Hierarchies** | Jerarquías de herencia paralelas | — |
| **Primitive Obsession** | Obsesión por tipos primitivos | Obsesión por primitivos |
| **Refused Bequest** | Herencia rechazada | Legado rechazado |
| **Shotgun Surgery** | Cirugía de escopeta | — |
| **Speculative Generality** | Generalidad especulativa | — |
| **Switch Statement** | Sentencia switch | Condicional por código de tipo |
| **Temporary Field** | Campo temporal | Atributo temporal |

---

## Glosario: Refactorings (inglés → español)

| Inglés | Español |
|---|---|
| **Change Bidirectional Association to Unidirectional** | Cambiar asociación bidireccional a unidireccional |
| **Collapse Hierarchy** | Colapsar jerarquía |
| **Decompose Conditional** | Descomponer condicional |
| **Encapsulate Collection** | Encapsular colección |
| **Encapsulate Field** | Encapsular atributo |
| **Extract Class** | Extraer clase |
| **Extract Interface** | Extraer interfaz |
| **Extract Method** | Extraer método |
| **Extract Subclass** | Extraer subclase |
| **Extract Superclass** | Extraer superclase |
| **Form Template Method** | Formar método plantilla |
| **Hide Delegate** | Ocultar delegado |
| **Hide Method** | Ocultar método |
| **Inline Class** | Clase en línea (Inline Class) |
| **Inline Method** | Método en línea (Inline Method) |
| **Introduce Assertion** | Introducir aserción |
| **Introduce Foreign Method** | Introducir método externo |
| **Introduce Local Extension** | Introducir extensión local |
| **Introduce Null Object** | Introducir objeto nulo |
| **Introduce Parameter Object** | Introducir objeto parámetro |
| **Move Field** | Mover atributo |
| **Move Method** | Mover método |
| **Pull Up Field** | Subir atributo |
| **Pull Up Method** | Subir método |
| **Push Down Field** | Bajar atributo |
| **Push Down Method** | Bajar método |
| **Remove Middle Man** | Eliminar intermediario |
| **Remove Parameter** | Eliminar parámetro |
| **Remove Setting Method** | Eliminar método setter |
| **Rename Method** | Renombrar método |
| **Rename Variable** | Renombrar variable |
| **Replace Array with Object** | Reemplazar arreglo con objeto |
| **Replace Conditional with Polymorphism** | Reemplazar condicional con polimorfismo |
| **Replace Data Value with Object** | Reemplazar valor de dato con objeto |
| **Replace Delegation with Inheritance** | Reemplazar delegación con herencia |
| **Replace Inheritance with Delegation** | Reemplazar herencia con delegación |
| **Replace Loop with Pipeline** | Reemplazar bucle con pipeline |
| **Replace Magic Number with Symbolic Constant** | Reemplazar número mágico con constante simbólica |
| **Replace Method with Method Object** | Reemplazar método con objeto método |
| **Replace Parameter with Explicit Methods** | Reemplazar parámetro con métodos explícitos |
| **Replace Parameter with Method** | Reemplazar parámetro con método |
| **Replace Primitive with Object** | Reemplazar primitivo con objeto |
| **Replace Temp with Query** | Reemplazar temporal con consulta |
| **Replace Type Code with Class** | Reemplazar código de tipo con clase |
| **Replace Type Code with State/Strategy** | Reemplazar código de tipo con State/Strategy |
| **Replace Type Code with Subclasses** | Reemplazar código de tipo con subclases |
| **Substitute Algorithm** | Sustituir algoritmo |

> **Truco para recordar los "Replace X with Y"**: siempre se leen igual en ambos idiomas — *reemplazar lo que está mal (X) por la solución (Y)*. Si te olvidás la traducción exacta en el parcial, traducilo literal: se entiende igual.

---

## Tabla de Smells y Refactorings

| Smell | Cómo detectarlo | Refactorings |
|---|---|---|
| **Alternative Classes with Different Interfaces** | Dos clases hacen lo mismo con nombres/métodos distintos | Rename Method<br>Move Method<br>Extract Superclass |
| **Comments** | El comentario explica *qué* hace el código en lugar de *por qué*; el nombre no alcanza | Rename Method<br>Extract Method<br>Introduce Assertion |
| **Data Class** | Clase con solo atributos y getters/setters; otros clases hacen la lógica con sus datos | Move Method<br>Encapsulate Field<br>Encapsulate Collection<br>Remove Setting Method<br>Extract Method<br>Hide Method |
| **Data Clumps** | Parámetros o variables que siempre viajan juntos (ej. `fechaInicio`, `fechaFin`) | Extract Class<br>Preserve Whole Object<br>Introduce Parameter Object |
| **Divergent Change** | La misma clase se modifica por motivos completamente distintos según qué funcionalidad cambie | Extract Class |
| **Duplicated Code** | Dos o más fragmentos de código idénticos o casi idénticos | Extract Method<br>Pull Up Field<br>Form Template Method<br>Substitute Algorithm<br>Extract Class<br>Introduce Null Object |
| **Feature Envy** | Un método usa más datos de otra clase que de la propia | Extract Method<br>Move Method<br>Move Field |
| **Lazy Class (Freeloader)** | Clase que no hace lo suficiente para justificar su existencia | Collapse Hierarchy<br>Inline Class |
| **Inappropriate Intimacy** | Dos clases conocen demasiados detalles internos la una de la otra | Move Method<br>Move Field<br>Change Bidirectional Association to Unidirectional Association<br>Extract Class<br>Hide Delegate<br>Replace Inheritance with Delegation |
| **Incomplete Library Class** | La librería no tiene lo que necesitás y no podés modificarla | Introduce Foreign Method<br>Introduce Local Extension |
| **Large Class** | Una clase con demasiadas responsabilidades/atributos/métodos | Extract Class<br>Extract Subclass<br>Extract Interface<br>Replace Data Value with Object |
| **Long Method** | Método largo; las variables temporales y los loops son "zonas calientes" | Extract Method<br>Introduce Parameter Object<br>Decompose Conditional<br>Preserve Whole Object<br>Replace Method with Method Object<br>Replace Temp with Query |
| **Long Parameter List** | Firmas con muchos parámetros, varios de los cuales se repiten en otros métodos | Replace Parameter with Method<br>Introduce Parameter Object<br>Preserve Whole Object |
| **Message Chains** | Cadenas tipo `a.getB().getC().getD().foo()` | Hide Delegate<br>Extract Method<br>Move Method |
| **Middle Man** | Una clase que solo delega la mayoría de sus operaciones a otra | Remove Middle Man<br>Inline Method<br>Replace Delegation with Inheritance |
| **Parallel Inheritance Hierarchies** | Cada vez que creás una subclase de una, tenés que crear una de la otra | Move Method<br>Move Field |
| **Primitive Obsession** | Uso de primitivos (`int`, `String`) para conceptos con dominio propio (código, moneda, rango) | Replace Data Value with Object<br>Introduce Parameter Object<br>Extract Class<br>Replace Type Code with Class<br>Replace Code with State/Strategy<br>Replace Type Code with Subclasses<br>Replace Array with Object |
| **Refused Bequest** | Una subclase que no usa nada o casi nada de lo que hereda | Push Down Field<br>Push Down Method<br>Replace Inheritance with Delegation |
| **Shotgun Surgery** | Un cambio pequeño obliga a tocar muchas clases distintas | Move Method<br>Move Field<br>Inline Class |
| **Speculative Generality** | Código muerto: métodos/parámetros genéricos "por si las moscas" | Collapse Hierarchy<br>Rename Method<br>Remove Parameter<br>Inline Class |
| **Switch Statement** | `switch`/`if-else` que se repite cada vez que aparece un nuevo tipo de dato | Extract Method<br>Move Method<br>Replace Type Code with Subclasses<br>Replace Type Code with State/Strategy<br>Replace Conditional with Polymorphism<br>Replace Parameter with Explicit Methods<br>Introduce Null Object |
| **Temporary Field** | Atributos que solo se usan dentro de ciertos métodos o ramas; el resto del tiempo están vacíos | Extract Class<br>Introduce Null Object |

---

## Smells clave: cómo justificarlos en el parcial

| Smell | Frase de justificación típica |
|---|---|
| **Long Method** | "El método hace A, B y C a la vez; se hace difícil ver de un vistazo qué hace" → *Extract Method* |
| **Feature Envy** | "Este método se pasa la vida usando los datos de `OtraClase` y casi no usa los suyos" → *Move Method / Extract Method* |
| **Data Class** | "La clase solo guarda datos y no tiene comportamiento; la lógica vive en otras clases" → *Move Method* |
| **Duplicated Code** | "Este bloque aparece copiado en dos lugares; si hay que corregirlo hay que corregirlo en los dos" → *Extract Method* |
| **Primitive Obsession** | "Usa un `String` para representar un concepto del dominio, perdiendo validación y expresividad" → *Replace Primitive with Object* |
| **Data Clumps** | "Estos 3 parámetros siempre viajan juntos" → *Introduce Parameter Object* |

---

## Smells clave: ejemplos cortitos

### Long Method
> "El método hace A, B y C a la vez; se hace difícil ver de un vistazo qué hace" → *Extract Method*

```java
// ANTES: calcula, imprime y acumula todo junto
for (Empleado e : empleados) {
    double bruto = e.getSueldoBasico() + e.getHorasExtra() * 450 + ...;  // 5 líneas de cuenta
    System.out.println("Empleado: " + e.getNombre() + " - Neto: " + neto);
    totalGeneral += neto;
}

// DESPUÉS: cada línea se entiende de un vistazo
for (Empleado e : empleados) {
    imprimirRecibo(e);
    totalGeneral += calcularNeto(e);
}
```

### Feature Envy
> "Este método se pasa la vida usando los datos de `OtraClase` y casi no usa los suyos" → *Move Method / Extract Method*

```java
// ANTES: ImpresorFacturas vive mirando los atributos de Direccion
public String generarEncabezado(Factura f) {
    return "..." + f.getCliente().getDireccion().getCalle()
         + " " + f.getCliente().getDireccion().getCiudad();
}

// DESPUÉS: el formateo vive en Direccion, que es dueña de esos datos
public String generarEncabezado(Factura f) {
    return "..." + f.getDireccionFormateada();
}
```

### Data Class
> "La clase solo guarda datos y no tiene comportamiento; la lógica vive en otras clases" → *Move Method*

```java
// ANTES: Producto solo tiene getters/setters y Carrito le hace la cuenta
class Carrito {
    double total() { return items.stream()
        .mapToDouble(i -> i.getProducto().getPrecio() * i.getCantidad()).sum(); }
}

// DESPUÉS: cada objeto calcula con sus propios datos
class ItemCarrito {
    double calcularTotal() { return producto.getPrecio() * this.cantidad; }
}
```

### Duplicated Code
> "Este bloque aparece copiado en dos lugares; si hay que corregirlo hay que corregirlo en los dos" → *Extract Method*

```java
// ANTES: la fórmula del bruto está copiada en 3 métodos
double bruto = e.getSueldoBasico() + e.getHorasExtra() * 450 + e.getAntiguedad() * 200;
double descuento = bruto * 0.13;

// DESPUÉS: una sola fórmula, un solo lugar que tocar
double neto = calcularNeto(e);   // (o Empleado.getSueldoNeto() con Move Method)
```

### Primitive Obsession
> "Usa un `String` para representar un concepto del dominio, perdiendo validación y expresividad" → *Replace Primitive with Object*

```java
// ANTES: cualquier string pasa, y == compara referencias (bug)
if (tipoHabitacion == "simple") { total = total * 1.0; }

// DESPUÉS: solo existen valores válidos, y la lógica vive en el objeto
total *= tipoHabitacion.getFactor();   // Simple(1.0), Doble(1.5), Suite(2.2)
```

### Data Clumps
> "Estos 3 parámetros siempre viajan juntos" → *Introduce Parameter Object*

```java
// ANTES: las fechas viajan siempre pegadas
public boolean disponibilidad(String fechaInicio, String fechaFin, String tipo) { ... }
public double calcularPrecio(String fechaInicio, String fechaFin, ...) { ... }

// DESPUÉS: un objeto que encarna el concepto "estadía"
public boolean disponibilidad(RangoFechas estadia, TipoHabitacion tipo) { ... }
```

### Switch Statement (bonus)
> "Cada vez que aparece un tipo nuevo hay que tocar este condicional" → *Replace Conditional with Polymorphism*

```java
// ANTES: crece con cada tipo nuevo
if (tipo == "nacional") { auxc = duracion * 3 + iva; }
else if (tipo == "internacional") { auxc = duracion * 150 + iva + 50; }

// DESPUÉS: agregar un tipo = agregar una clase (Open/Closed)
auxc = llamada.calcularCosto();
```

### Middle Man (bonus)
> "Esta clase solo delega, no agrega valor" → *Remove Middle Man / Inline Class*

```java
// ANTES: Catalogo es un pasamanos
public List<Libro> buscarPorTitulo(String t) { return db.buscarPorTitulo(t); }
// ... 5 métodos más idénticos ...

// DESPUÉS: el cliente habla directo con db (o Catalogo gana lógica propia)
```

### Lazy Class vs Data Class (bonus: ¡ojo que se confunden!)

```java
class Avioneta extends Vehiculo { }          // LAZY CLASS: no hace NADA → Inline Class / Collapse Hierarchy
class Producto { String nombre; double precio; /* solo getters/setters */ }
                                             // DATA CLASS: guarda datos y otros hacen la lógica → Move Method
```

### Temporary Field (bonus)
> "Este atributo solo se llena en un método y el resto del tiempo está vacío" → *Extract Class / Introduce Null Object*

```java
private String ultimoPrestamoDetalle;   // se setea SOLO en registrar() y se lee en un método
private LocalDate ultimaFechaDevolucion;
// DESPUÉS: viven en un objeto Prestamo/ResumenPrestamo que existe solo cuando hace falta
```

### Comments (bonus)
> "El comentario explica QUÉ hace la línea, no POR QUÉ" → *Rename Method / Replace Magic Number with Symbolic Constant*

```java
// ANTES
double descuento = bruto * 0.13;   // le aplico el 13% de descuento por aportes

// DESPUÉS: el código se explica solo, el comentario sobra
double descuento = bruto * PORCENTAJE_APORTES;
```

---

## Refactorings más frecuentes (qué hacen)

| Refactoring | Qué hace | Ejemplo |
|---|---|---|
| **Rename Method** | Pone un nombre que diga qué hace | `lmtCrdt()` → `getLimiteCredito()` |
| **Extract Method** | Saca un fragmento a un método nuevo con nombre propio | Separar el cálculo del promedio de la impresión |
| **Move Method** | Mueve un método a la clase donde más datos usa | `Persona.participaEnProyecto()` → `Proyecto.participa()` |
| **Encapsulate Field** | Hace privado el atributo y expone acceso controlado | `+id` → `-id` + `getId()` |
| **Introduce Parameter Object** | Reemplaza parámetros que viajan juntos por un objeto | `(f1, f2)` → `(RangoFechas rango)` |
| **Replace Temp with Query** | Elimina variables intermedias usando directamente el método | `double p = calc(); fmt(p)` → `fmt(calc())` |
| **Preserve Whole Object** | Pasa el objeto entero en vez de extraer sus partes | `f(inicio, fin)` → `f(rango)` |
| **Substitute Algorithm** | Reemplaza el algoritmo por uno más simple | Bucles manuales → Streams |
| **Inline Method** | Elimina un método trivial usando su cuerpo directamente | — |
| **Hide Delegate** | Encapsula una asociación para no chainear delegaciones | `cliente.getDepartamento().getJefe()` → `cliente.getJefe()` |

---

## Reglas rápidas de detección

- **Método largo + variables temporales** → Long Method
- **Muchos parámetros que se repiten** → Long Parameter List / Data Clumps
- **Usa datos de otra clase > que los propios** → Feature Envy
- **`switch` que crece con cada tipo nuevo** → Switch Statement
- **Clase con solo getters/setters** → Data Class
- **Clase que solo delega** → Middle Man
- **Atributo que solo se llena en un método** → Temporary Field
- **Código copiado y pegado** → Duplicated Code
