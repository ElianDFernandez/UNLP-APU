# Temas 1

### Componentes Principales de un lenguaje de Programación

- **Sintaxis**: Reglas que definen la estrucutra de los programas.
- **Semantica**: Significado de las construcciones de la sintaxis.
- **Sistemas de tipos**: Estabelece reglas sobre los tipos de datos y su interaccion.
- **Modelo de ejecucion**: Define como se ejecutan los programas, incluyendo el manejo de memoria y la concurrencia. (Ej: JVM en Java, o el modelo de ejecución de Python)
- **Mecanismoos de abstraccion**: Mecanismos que permiten crear nuevas estructuras de datos y control, como funciones, clases, modulos, etc.

### Procesamiento de un lenguaje Compiraldores Vs Intérpretes

Un lenguaje puede ser procesado de dos formas principales: mediante compiladores o intérpretes.

- **Compiladores**: Traducen el código fuente a código máquina antes de la ejecución. Ejemplos: C, C++, Rust.
- **Intérpretes**: Ejecutan el código fuente directamente, sin necesidad de una traducción previa. Ejemplos: Python, JavaScript, Ruby.
- **Lenguajes Híbridos**: Algunos lenguajes utilizan una combinación de ambos enfoques. Por ejemplo, Java se compila a bytecode que luego es interpretado por la JVM.

### Paradigmas de Programación
Un paradigma de programacion es un estilo o enfoque de programacion para resolver problemas. Ejemplos:

- **Imperativo**: Se centra en describir cómo se debe realizar una tarea. Ej: C, Java.
- **Declarativo**: Se centra en describir qué se quiere lograr sin especificar cómo hacerlo. Ej: SQL, Prolog.
- **Funcional**: Se basa en el uso de funciones puras y evita el estado mutable. Ej: Haskell, Lisp.
- **Orientado a Objetos**: Se basa en la organización del código en objetos que contienen datos y métodos. Ej: Java, C++.
- **Lógico**: Se basa en la lógica formal para expresar programas. Ej: Prolog.
- **Concurrente**: Se centra en la ejecución simultánea de procesos o hilos. Ej: Go, Erlang.
- **Reactivo**: Se centra en la programación de sistemas que responden a eventos o cambios en el entorno. Ej: RxJava, ReactiveX.

### Atributos de un Lenguaje de Programación

- **Ortogonalidad**: Capacidad de un lenguaje de combinar sus características de manera consistente y sin restricciones.
- **Expresividad**: Capacidad de un lenguaje para expresar ideas de manera clara y concisa.
- **Legibilidad**: Facilidad con la que los programadores pueden entender y leer el código.
- **Simplicidad**: Facilidad de aprender y usar el lenguaje.

(Repasar Caracteristias de algunos lenguajes de programacion: Java, C++, Python, Ruby,
PHP, JavaScript, Ada etc.)

### Sintaxis

Recordar la sintaxis son las reglas que definen la estructura de los programas.
Usamos BNF y EBNF para describir la sintaxis de los lenguajes de programacion.

- **BNF (Backus-Naur Form)** es una notación formal para describir la sintaxis de los lenguajes de programación. 
- **EBNF (Extended Backus-Naur Form)** es una extensión de BNF que incluye características adicionales para facilitar la descripción de la sintaxis.

### Semantica

La semántica se refiere al significado de las construcciones de la sintaxis. 

- **Semántica Estática**: Se refiere a las reglas que se aplican en tiempo de compilación, como el sistema de tipos y la verificación de tipos.
- **Semántica Dinámica**: Se refiere a las reglas que se aplican en tiempo de ejecución, como el comportamiento de los programas y la gestión de memoria.
Dentro de la semantica Dinamica tenemos:
  * **Semantica Axiomatica**: Se basa en la lógica formal para describir el comportamiento de los programas. 
  * **Semantica Denotacional**: Se basa en la asignación de significados matemáticos a las construcciones de la sintaxis.
  * **Semantica Operacional**: Se basa en la descripción de cómo se ejecutan los programas paso a paso. (Semantica que normalmente se usa en los compiladores)

### Interpretes y Compiladores

INTERPRETACIÓN VS COMPILACIÓN

- Momento de traducción: Interpretación = Durante la ejecución. Compilación = Antes de ejecutar el programa.
- Unidad de ejecución: Interpretación = Sentencia por sentencia. Compilación = Programa completo.
- Velocidad de ejecución: Interpretación = Más lenta. Compilación = Más rápida.
- Detección de errores: Interpretación = Aparecen cuando se ejecuta la sentencia. Compilación = Muchos errores se detectan antes de ejecutar.
- Depuración: Interpretación = Más fácil (ejecución paso a paso). Compilación = Puede requerir recompilación.
- Uso de memoria: Interpretación = Intérprete + programa + datos. Compilación = Ejecutable compilado + datos.
- Portabilidad: Interpretación = Alta si existe intérprete para la plataforma. Compilación = Requiere recompilar para cada arquitectura.
- Distribución del programa: Interpretación = Se distribuye el código fuente o script. Compilación = Se distribuye un ejecutable.

### Compiladores Funcionamiento

- Traducen todo el programa
- Pueden generar codigo ejecutable 
- Pueden generar codigo intermedio (ej: bytecode)
- La compilacion puede ser en 1 o 2 etapas (ej: C, Ada, Pascal,etc.)

Esta compuesto por:
1. Etapa de analisis:
- **Analisis Lexico(Scanner)**: Convierte el código fuente en tokens.
- **Analisis Sintactico(Parser)**: Verifica la estructura del programa según la sintaxis.
- **Analisis Semantico**: Verifica el significado del programa, como la verificación de tipos.

2. Estapa de Sintesis:
- **Generacion de Codigo Intermedio**: Traduce el programa a una representación intermedia que es más fácil de optimizar y traducir a código máquina.
- **Optimizacion**: Mejora el código intermedio para hacerlo más eficiente.
- **Generacion de Codigo**: Traduce el código intermedio a código máquina o bytecode.

### Semantica Operacional

La semantica operacional permite describir el significado preciso de un programa, y verificar el resultado final de la ejecucion deun programa.

Cuando Hablamos de semantica operacion tenemos que definir entidates y sus atributos:
- Varaibles = Nombre,Tipo, Rango de valores, Area de memoria, etc.
- Funciones = Nombre, Tipo de retorno, Lista de parametros, Area de memoria, etc.
- Sentencias = Accion asociada.

Y tambien su **"Binding"** que es el proceso de asociar un nombre con una entidad. 
EJ: 
```
int x = 4;
```
Entidad: Variable
Atributos: Nombre = x, Tipo = int, Rango de valores = Auto, Area de memoria = Auto, etc.

Resumen (Binding):
- Los programas trabajan con entidades.
- Las entidades tienen atributos.
- Los atributos se definen antes de poder usar la entidad.
- El momento en el que el  atributo se asocia con un valor determinado se llama LIGADURA (Binding).

### Tipos de Ligadura

- **Ligadura Estatica**: Se realiza en tiempo de compilación. Ej: En C, el tipo de una variable se determina en tiempo de compilación.
- **Ligadura Dinamica**: Se realiza en tiempo de ejecución. Ej: En Python, el tipo de una variable se determina en tiempo de ejecución.

### Variables

Es una entidad representada por una 5-tupla de atributos: 
<Nombre, Alcance, Tipo, L-Valor, R-Valor>

- **Nombre**: Es el identificador de la variable.
  
- **Alcance**: Es el rango de instrucciones en el que es conocido el nombre del variable. Los lenguajes adoptan reglas para ligar el nombre de una variable a su alcance: 
  - **Ligadura por alcance estatico**: Define el alcance en terminos de la estructura lexica del programa. Puede ligarse estaticamente a una declaracion de variables examinando el texto sin necesidad de ejecutar el programa. Ej: C, Java.
  - **Ligadura por alcance dinamico**: Define el alcance en terminos de la secuencia de llamadas a funciones durante la ejecucion del programa. Puede ligarse dinamicamente a una declaracion de variables examinando la secuencia de llamadas a funciones durante la ejecucion del programa. Ej: Lisp, Perl.
  
- **Tipo**: Se define el tipo de una variable como la especificacion del:
    * Conjunto de valores posibles que puede tomar la variable.
    * Operaciones que se pueden realizar sobre la variable.
    Existen diferentes sistemas de tipos, como:
    - Tipos Predefinidos: Tipos básicos como enteros, flotantes, caracteres, etc.
    - Tipos Definidos por el Usuario: Tipos que los programadores pueden definir, como estructuras, clases, etc.
    - Tipos de Datos Abstractos: Tipos que se definen por su comportamiento y no por su implementación, como listas, pilas, colas, etc.
    Tambien tiene sus momentos de ligadura:
    - **Ligadura de Tipo Estatica**: Se realiza en tiempo de compilación. Ej: En C, el tipo de una variable se determina en tiempo de compilación. Dentro de este momentos de ligadura tenemos:
      - **Ligadura de forma explicita**: El programador especifica el tipo de la variable en el código. Ej: En C, al declarar una variable, se especifica su tipo (int x;).
      - **Ligadura de forma implicita**: El tipo de la variable se infiere a partir del contexto o del valor asignado. Ej: En C++, al declarar una variable con auto, el tipo se infiere a partir del valor asignado (auto x = 5;).
      - **Ligadura de forma inferida**: El tipo de la variable se infiere a partir del contexto sin necesidad de una declaración explícita. Ej: En Swift, al declarar una variable sin especificar su tipo, el tipo se infiere a partir del valor asignado (var x = 5).
    - **Ligadura de Tipo Dinamica**: Se realiza en tiempo de ejecución. Ej: En Python, el tipo de una variable se determina en tiempo de ejecución.

- **L-Valor**: Es la dirección del area de memoria ligada a la variable durante la ejecucion. Las instrucciones acceden a la variable por su l-valor. La definicion del l-valor determina el inicio y fin del timepo de vida de la variable.
Existen tipos de momentos de alocacion de memoria: 
- **Alocacion Estatica**: La memoria se asigna en tiempo de compilación y permanece asignada durante toda la ejecución del programa. Ej: Variables globales en C.
- **Alocacion Dinamica**: La memoria se asigna en tiempo de ejecución y puede ser liberada cuando ya no se necesita. Ej: Uso de malloc en C.
- **Alocacion Persistente**: La memoria se asigna en tiempo de ejecución y permanece asignada incluso después de que el programa ha terminado. Ej: Variables globales en algunos lenguajes de scripting.

- **R-Valor**: Es el valor codificado almacenado en la ubicacion asosicada a la variable. La codificacion se interpreta de acuerdo con el tipo de variable.

**Punteros**: Son variables que almacenan la dirección de memoria de otra variable. Permiten manipular directamente la memoria y son comunes en lenguajes como C, C++, Pascal, etc. Los punteros tienen sus propios atributos, como el tipo de dato al que apuntan y la capacidad de realizar operaciones aritméticas para navegar por la memoria.

