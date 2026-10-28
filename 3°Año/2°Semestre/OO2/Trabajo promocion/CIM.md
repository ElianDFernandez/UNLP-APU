# Detección del Bad Smell *Class/Interface Mismatch* en Diagramas UML con PlantUML
### Documentación de referencia y fundamentación para el informe

> Este documento reúne las definiciones, referencias bibliográficas y convenios
> utilizados en el informe sobre el desarrollo de un algoritmo de detección del
> bad smell *class/interface mismatch* en diagramas UML.

## 1. Propósito

Este documento establece las referencias y la documentación de base sobre las que
se apoya el informe. El informe describe el desarrollo de un algoritmo capaz de
detectar el bad smell **class/interface mismatch** (desajuste entre clase e
interfaz) en diagramas de clases UML representados en lenguaje PlantUML.

## 2. Definición de UML utilizada

Para la definición del lenguaje UML y de sus elementos (clases, interfaces,
relaciones de realización/asociación, etc.) se utiliza la siguiente obra,
escrita por los propios creadores del lenguaje:

- **Título**: *El Lenguaje Unificado de Modelado. Manual de Referencia*
  (*The Unified Modeling Language Reference Manual*), 2.ª edición.
- **Autores**: James Rumbaugh, Ivar Jacobson y Grady Booch.
- **Versión de UML cubierta**: UML 2.0.
- **Editorial**: Addison-Wesley / Pearson Educación.

## 3. Versión de PlantUML utilizada

La representación de los diagramas se realiza en lenguaje **PlantUML**, tomando
como referencia la guía *Diagramando UML con PlantUML — Guía de Referencia del
Lenguaje PlantUML*, correspondiente a la versión **1.2025.0**.

## 4. Convención de citas

Las citas se expresan como **(fuente, líneas, página)**:

- **Libro-UML.md** → página impresa del libro (numeración verificada contra
  `Libro-UML.pdf` mediante los encabezados/pies de página).
- **PlantUML_Guia.md** → página de la guía (numeración de los pies de página
  `Guía de Referencia del Lenguaje PlantUML (1.2025.0) N / 580`).

## 5. Marco conceptual UML (definiciones que sustentan el análisis)

Todas las referencias de esta sección corresponden a *El Lenguaje Unificado de
Modelado. Manual de Referencia*, 2.ª edición (Rumbaugh, Jacobson y Booch).

### 5.1 Clasificadores

Un clasificador «modela un concepto discreto que describe cosas (objetos) que
tiene identidad, estado, comportamiento, relaciones y una estructura interna
opcional», e incluye clases, interfaces y tipos de datos
(Libro-UML.md, líneas 1878-1885, p. 44).

### 5.2 Clase

- **Definición**: «Una clase representa un concepto discreto dentro de la
  aplicación que se está modelando» y es «el descriptor para un conjunto de
  objetos con similar estructura, comportamiento y relaciones»
  (Libro-UML.md, líneas 1890-1903, p. 44).
- **Estado y comportamiento**: «El estado se describe mediante atributos y
  asociaciones» y «las piezas individuales de comportamiento que se pueden
  invocar se describen como operaciones; un método es una implementación de una
  operación» (Libro-UML.md, líneas 1913-1918, p. 44).
- **Nombre y visibilidad**: la clase tiene un nombre único dentro de su
  contenedor y una visibilidad que especifica cómo puede ser utilizada por otras
  clases (Libro-UML.md, líneas 1990-1996, p. 46).
- **Niveles de significado**: las clases se modelan a nivel de análisis, diseño
  e implementación; una clase de nivel de implementación «se corresponde
  directamente con el código del lenguaje de programación»
  (Libro-UML.md, líneas 2010-2042, p. 46).
- **Notación**: rectángulo con compartimentos para nombre, atributos y
  operaciones (Libro-UML.md, líneas 1921-1924, p. 44; Figura 4.1, línea 2029,
  pp. 46-47). En el capítulo de notación: «Un clasificador se muestra con un
  rectángulo de línea continua con tres compartimentos separados por líneas
  horizontales», donde la declaración en un diagrama de clases «define los
  contenidos del clasificador: sus atributos, operaciones y otras propiedades»
  (Libro-UML.md, líneas 7795-7811, p. 203).

### 5.3 Interfaz

- En la Tabla 4.1 (*Tipos de clasificadores*), la interfaz se define como «Un
  conjunto con nombre de operaciones que caracterizan un comportamiento»
  (Libro-UML.md, líneas 1968-1970, p. 45).
- **Definición**: «Una interfaz es la descripción del comportamiento de los
  objetos sin proporcionar su implementación o estado. Una o más clases o
  componentes pueden realizar una interfaz, y cada clase implementa las
  operaciones que se encuentran en la interfaz»
  (Libro-UML.md, líneas 1997-1999, p. 46).

### 5.4 Relaciones entre clasificadores

Las relaciones entre clasificadores son asociación, generalización y varios
tipos de dependencia, entre los que se incluyen la realización y el uso
(Libro-UML.md, líneas 2043-2046, p. 47).

La Tabla 4.2 (*Tipos de relaciones*) resume sus funciones
(Libro-UML.md, líneas 2058-2071, pp. 47-48):

| Relación | Función |
|---|---|
| asociación | Una descripción de una conexión entre instancias de clases |
| dependencia | Una relación entre dos elementos del modelo |
| generalización | Relación entre una descripción más específica y una más general, utilizada para la herencia y para declaraciones de tipo polimórfico |
| realización | Relación entre una especificación y su implementación |
| uso | Una situación en la cual un elemento necesita de otro para su correcto funcionamiento |

«La relación de realización relaciona una especificación con una
implementación. Una interfaz es una especificación de comportamiento sin
implementación; una clase incluye la estructura de implementación. Una o más
clases pueden realizar una interfaz, y cada clase implementa las operaciones que
se encuentran en la interfaz»
(Libro-UML.md, líneas 2083-2086, p. 48).

### 5.5 Generalización y herencia

- «La relación de generalización es una relación taxonómica entre una
  descripción más general y una descripción más específica»; «la descripción más
  específica es completamente consistente con la más general»
  (Libro-UML.md, líneas 2219-2232, p. 51).
- «La generalización y la herencia permiten que diferentes clasificadores
  compartan los atributos, operaciones y relaciones que tienen en común»
  (Libro-UML.md, líneas 2082-2084, p. 48).
- Se aplica a los clasificadores: clases, interfaces, tipos de datos, casos de
  uso, actores, señales, etc. (Libro-UML.md, líneas 2243-2245, pp. 51-52).

### 5.6 Realización

- **Definición y regla clave**: la realización «conecta a un elemento del
  modelo, como una clase, con otro elemento del modelo, como una interfaz, que le
  proporciona su especificación de comportamiento, pero no su estructura o
  implementación. **El cliente debe tener (por herencia o por declaración
  directa) al menos todas las operaciones que tiene el proveedor**»
  (Libro-UML.md, líneas 2395-2401, p. 55).
- **Realización vs. generalización**: la generalización relaciona elementos del
  mismo nivel semántico; la realización relaciona elementos de diferentes
  niveles semánticos (por ejemplo, una interfaz y una clase)
  (Libro-UML.md, líneas 2412-2428, p. 55).
- **Notación**: «una flecha de línea discontinua con la punta de flecha hueca
  cerrada», similar al símbolo de la generalización con línea discontinua
  (Libro-UML.md, líneas 2429-2432, p. 56; Figura 4.9, línea 2415).
- **Interfaces proporcionadas y obligatorias**: «Una interfaz realizada por una
  clase se denomina interfaz proporcionada, porque la clase proporciona los
  servicios de la interfaz a los que los invocan desde el exterior» (círculo
  unido a la clase); «una interfaz utilizada por una clase para implementar su
  comportamiento interno se denomina interfaz obligatoria» (semicírculo)
  (Libro-UML.md, líneas 2433-2442, p. 56; Figura 4.10, línea 2459).

### 5.7 Dependencia, uso y sustitución

- **Dependencia**: «indica una relación semántica entre dos o más elementos del
  modelo»; un cambio en el elemento proveedor puede requerir un cambio en el
  elemento cliente (Libro-UML.md, líneas 2445-2447, p. 56).
- La Tabla 4.3 (*Tipos de dependencias*) incluye, entre otras, la realización
  («Correspondencia entre una especificación y su implementación», palabra
  clave `realize/realiza`) y la sustitución («Establece que la clase origen
  soporta las interfaces y contratos de la clase destino y puede ser sustituida
  por ella», `substitute/sustituye`), y la uso (`use*/usa`)
  (Libro-UML.md, líneas 2461-2521, p. 57).
- **Dependencia de uso**: «Una dependencia de uso es una declaración de que el
  comportamiento o la implementación de un elemento afecta al comportamiento o
  implementación de otro»; sus estereotipos incluyen la llamada y la
  instanciación (Libro-UML.md, líneas 2560-2575, p. 58). En la notación: la
  dependencia de uso (`use`) «conecta un elemento cliente a un elemento
  proveedor, cuyo cambio requiere un cambio en el elemento cliente»
  (Libro-UML.md, líneas 9682-9693, p. 253).
- **Notación**: «Una dependencia se dibuja como una flecha de línea discontinua
  del cliente al proveedor, con la palabra clave del estereotipo para distinguir
  su tipo» (Libro-UML.md, líneas 2594-2596, p. 58).

### 5.8 Asociación

«Una asociación describe conexiones discretas entre objetos u otras instancias
en un sistema»; «cada conexión de una asociación con una clase se denomina
extremo de la asociación» y su propiedad más importante es la multiplicidad
(Libro-UML.md, líneas 2108-2130, p. 48).

### 5.9 Diagrama de clases

«Un diagrama de clases es una presentación gráfica de la vista estática que
muestra una colección de elementos declarativos (estáticos) del modelo, como
clases, tipos y sus contenidos y relaciones»; es «el diagrama de modelado de
objetos más importante» (Libro-UML.md, líneas 10043-10049 y 10092-10094,
p. 262).

## 6. Sintaxis PlantUML para diagramas de clase (v1.2025.0)

Referencias a la sección *3 Diagrama de clase* de la guía de PlantUML
(PlantUML_Guia.md).

### 6.1 Declaración de elementos

Se declaran con palabras clave como `class`, `interface`, `abstract class`,
`abstract`, `annotation`, `enum`, `entity`, `exception`, `metaclass`,
`protocol`, `stereotype` y `struct` (PlantUML_Guia.md, líneas 1887-1911, p. 57).

### 6.2 Relación entre clases

Tabla de la guía (PlantUML_Guia.md, líneas 1914-1950, p. 58):

| Tipo | Símbolo | Finalidad |
|---|---|---|
| Extensión | `<\|--` | Especialización de una clase en una jerarquía |
| Implementación | `<\|..` | Realización de una interfaz mediante una clase |
| Composición | `*--` | La parte no puede existir sin el todo |
| Agregación | `o--` | La parte puede existir independientemente del todo |
| Dependencia | `-->` | El objeto utiliza otro objeto |
| Dependencia | `..>` | Una forma más débil de dependencia |

«Es posible intercambiar `--` por `..` para tener líneas punteadas». Entre los
ejemplos se incluyen `Class11 <|.. Class12` y `Class17 ..|> Class18`
(PlantUML_Guia.md, líneas 1932-1944, p. 58).

### 6.3 Etiquetas y cardinalidad

Las etiquetas se añaden con `:` y la cardinalidad con comillas `""` a cada lado
de la relación (PlantUML_Guia.md, líneas 1952-1967, p. 59).

### 6.4 Atributos y métodos

Los campos y métodos se declaran con `:` seguido del nombre; «el sistema busca
paréntesis para elegir entre métodos y campos», y `{field}` / `{method}`
permiten anular la decisión por defecto del analizador
(PlantUML_Guia.md, líneas 1985-2021, p. 60).

### 6.5 Visibilidad

Caracteres de visibilidad en atributos y métodos: `-` private, `#` protected,
`~` package private y `+` public (ejemplo de la guía con `+method2()`)
(PlantUML_Guia.md, líneas 2051-2085, p. 61).

### 6.6 Abstracto y estático

Los modificadores `{abstract}`, `{static}` y `{classifier}` marcan miembros
abstractos o estáticos (PlantUML_Guia.md, líneas 2102-2126, p. 62).

### 6.7 Notas y estereotipos

Las notas y los estereotipos (`<<...>>`) pueden adjuntarse a las clases
(PlantUML_Guia.md, líneas 2171-2192, p. 63).

### 6.8 Clases abstractas e interfaces

«Puedes declarar una clase como abstracta usando las palabras claves `abstract`
or `abstract class`. […] Puedes usar también las palabras claves `interface`,
`annotation` y `enum`»; el ejemplo declara `interface List` y `interface
Collection` con relaciones `List <|-- AbstractList` y `Collection <|- List`
(PlantUML_Guia.md, líneas 2313-2326, p. 66).

### 6.9 Clases genéricas

Uso de clases genéricas en la notación (PlantUML_Guia.md, líneas 2520-2534,
p. 72).

### 6.10 Interface Lollipop

Interfaces *lollipop* sobre clases: `bar ()- foo`, `bar ()-- foo` y
`foo -() bar` (PlantUML_Guia.md, líneas 2715-2731, p. 76).

### 6.11 Dirección de las flechas

La orientación por defecto de los enlaces es vertical; se puede hacer
horizontal con un solo guión/punto o invertir la dirección revirtiendo el enlace
(PlantUML_Guia.md, líneas 2732-2748, p. 76).

## 7. Información considerada para la detección del bad smell *class/interface mismatch*

Síntesis de los criterios de detección que se derivan de la documentación
citada (formulación propia del informe sobre las definiciones anteriores):

1. **Regla de completitud de la realización**: la clase que realiza una interfaz
   debe tener —por herencia o por declaración directa— al menos todas las
   operaciones que tiene el proveedor (Libro-UML.md, líneas 2395-2401, p. 55).
   Un *mismatch* se produce cuando una clase realiza una interfaz y le falta
   alguna operación de la interfaz (o su firma no coincide).
2. **Especificación vs. implementación**: la interfaz aporta la especificación
   del comportamiento y la clase la implementación; «cada clase implementa las
   operaciones que se encuentran en la interfaz»
   (Libro-UML.md, líneas 1997-1999, p. 46; 2083-2086, p. 48).
3. **Interfaces proporcionadas vs. obligatorias**: puede haber desajuste entre
   los servicios que la clase declara proporcionar (interfaz realizada) y los
   que realmente utiliza para su comportamiento interno (interfaz obligatoria)
   (Libro-UML.md, líneas 2433-2442, p. 56).
4. **Sustitución**: la clase origen debe soportar las interfaces y contratos de
   la clase destino para poder ser sustituida por ella (Tabla 4.3,
   Libro-UML.md, líneas 2505-2507, p. 57).
5. **Herencia**: las operaciones heredadas cuentan para la regla de completitud
   («por herencia o por declaración directa», p. 55; herencia
   Libro-UML.md, líneas 2082-2084, p. 48).
6. **Qué analizar en los diagramas PlantUML**: declaraciones `interface`,
   `class` y `abstract class` (PlantUML_Guia.md, líneas 1887-1911, p. 57;
   2313-2326, p. 66); relaciones de realización `..|>` y `<|..`
   (PlantUML_Guia.md, líneas 1914-1950, p. 58); notación *lollipop* `()-`
   (PlantUML_Guia.md, líneas 2715-2731, p. 76); operaciones declaradas con `:`
   y paréntesis (PlantUML_Guia.md, líneas 1985-2021, p. 60); visibilidad de los
   miembros (PlantUML_Guia.md, líneas 2051-2085, p. 61).

## 8. Referencias

1. Rumbaugh, J.; Jacobson, I.; Booch, G. — *El Lenguaje Unificado de Modelado.
   Manual de Referencia*, 2.ª edición, Addison-Wesley / Pearson Educación.
   ([Libro-UML.pdf](./Libro-UML.pdf))
2. *Diagramando UML con PlantUML — Guía de Referencia del Lenguaje PlantUML*,
   versión 1.2025.0.
   ([PlantUML_Guia.pdf](./PlantUML_Guia.pdf))

