Resumen de temas:
- **Tema 1: Introducción y procesamiento de lenguajes.**
	-  Paradigmas de programación
	- Sintaxis vs Semántica 
	- Interprete vs Compilador
- Tema 2: Las Etapas de la compilacion.
	- 1.Analizador Lexico (Scanner)
	- 2.Analizador Sintáctico (Parser)
	- 3.Semantica Estática
	- 4.Etapa de Síntesis
- Tema 3: Semantica Dinámica (Enforques)
	- Axiomatica
	- Denotacional
	- Operacional 
- Tema 4: Las variables y la 5 tupla 
	- Concepto de ligadura
	- Alcance (scope)
	- Tiempo de vida(l-valor)
- Tema 5: Unidades de Programa y Parametros 
	- Declaración vs Definición 
	- Pasaje de Parametros 
- Tema 6: Modelos de ejecución y pilzas

## Tema 1: Introduccion y procesamiento de lenguajes

### 1.Los Componentes Principales de un Lenguaje

Todos los lenguajes de programación se definen a través de cinco componentes esenciales:
- **Sintaxis:** Es el conjunto de reglas que determinan como se deben estructurar y escribir validamente las instrucciones. Para definirla se utilizan gramáticas formales (como BNF o EBNF)(Gramatica = sintaxis + Semántica) y métodos de analisis (Parsing) que construyen arboles de derivación para verificar que una operación esta bien formada.
- **Semántica:** Define el significado exacto de esas construcciones sintacticas. Se divide en:
	- Estática: se chequea antes de  la ejecución (En compilacion) y revisa cosas que la sintaxis no atrapa, como que una variables este declarada antes de usarse o la compatibilidad de tipos.
	- Dinámica: Describe como se ejecuta el programa paso a paso y los cambios de estado en la memoria. Tiene enfoques como el operacional (maquina abstracta), denotacional (funciones matemáticas) y axiomático (predicados y logica).
- **Sistema de tipos:** establece reglas sobre los tipos de datos para detectar errores y garantizar la consistencia. 
- **Modelo de ejecución:** Define si el programa sera compilado, interpretado o utilizara un modelo híbrido.
- **Mecanismos de abstraccion:** Son las herramientas que provee el lenguaje para manejar la complejidad, como estructuras de control, módulos, funciones o clases.

### 2.Procesamiento del lenguaje: Compiladores vs Interpretes

Dado que las computadoras solo entienden lenguaje de maquina (Ceros y unos), el codigo fuente de alto nivel debe ser procesado. Existen dos grandes enfoques con diferencias muy marcadas.
**El Compilador:** 
- Funcionamiento: Toma todo el programa completo y lo traduce de una sola vez a codigo de maquina antes de que comience la ejecucion. Sigue el orden fisico de las setencias.s
- Velocidad: Es mas rapido en tiempo de ejecucion, ya que el programa ya  esta completamente traducido y optimizado.
- Errores: Muchos errores se detectan tempranamente antes de ejecutar, pero requiere recompilar el codigo si se hace un cambio.
- Uso de memoria: Requiere cargar el ejecutable compilado y los datos.
**El interprete:** 
- Funcionamiento: Traduce y ejecuta instruccion por instruccion en tiempo real. Utiliza subprogramas internos en lenguaje de maquina para ejecutar cada accion a medida que lee el codigo fuente. Sigue el orden logico de ejecucion.
- Velodicad: Es mas lento, por que si una instruccion esta dentro de un ciclo (como while o for) el interprete debe decodificarla y analizarla cada que pasa por ella.
- Errores y Depuracion: Es mucho mas facil depurar y los errores recien aparece en el momento exacto en que se ejecuta la sentencia.
- Uso de memoria: Mantiene en memoria el programa fuente original, la tabla de simbolos y el propoio programa interprete simultaneamente.

### 3.Paradigmas de progamacion

Un paradigma es la filosofia, los enfoques y arquitecturas internas mediante las cuales el lenguaje te propone pensar y estructurar la solucion a un problema. Determina si programaras enfocado en objetos, en secuencias estructuradas de comandos (Imperativo) o en funciones logicas (Declarativo).

### Practica 1 - Historia, Evolucion y Caracteristicas de Leng. de Programacion.
#### 1.Evolucion Historica de los Lenguajes

- 1951 - 1960: Fundamentos y Abstracción
	- **Assembly:** Inventó los **mnemónicos** (sustituyó ceros y unos por palabras). 
	- **FORTRAN:** El primer lenguaje de alto nivel. Introdujo **arreglos y bucles**.
	- **LISP:** Padre del paradigma funcional. Introdujo la **recursividad y el Garbage Collector**.
	- **ALGOL 60:** Introdujo la estructura de **bloques (`begin/end`)** y el alcance de las variables.
-  1961 - 1970: Especialización y el origen de los Objetos
	- **COBOL:** Enfocado en negocios. Introdujo los **registros (records)** para datos complejos.
	- **BASIC:** Diseñado para la **enseñanza** y la interactividad.
	- **SIMULA 67:** **El hito más importante para OO2**. Fue el primero en introducir **Clases, Objetos, Herencia y Polimorfismo**.
- 1971 - 1980: Estructura, Sistemas y Objetos Puros
	- **Pascal:** El estándar para aprender **programación estructurada** y tipado fuerte.
	- **C:** El lenguaje de sistemas por excelencia. Popularizó el uso de **punteros** y la eficiencia a bajo nivel.
	- **Prolog:** Introdujo el **paradigma lógico** (hechos y reglas).
	- **Smalltalk:** **Orientación a Objetos Pura**. Todo es un objeto. Inventó el patrón **MVC (Modelo-Vista-Controlador)**.
	- **Ada:** Pionero en **concurrencia** y sistemas de alta seguridad (misión crítica).
-  1981 - 1990: La consolidación del C++ y los IDEs
	- **C++:** Llevó la **Orientación a Objetos al mundo de C**. Introdujo clases y _templates_ sin perder velocidad.
	- **Turbo Pascal:** Revolucionó el desarrollo al integrar editor y compilador en un **IDE**.
- 1991 - 2000: La era de Internet y la Portabilidad
	- **Python / Perl:** El auge de los lenguajes de **scripting** para automatización y procesamiento de texto.
	- **Java:** Introdujo la **JVM (Máquina Virtual)**. Su gran innovación fue la **portabilidad absoluta** y la gestión de memoria que hoy usas con herramientas como Maven.
	- **JavaScript:** Llevó la lógica al **navegador**. Introdujo objetos basados en prototipos (en lugar de clases).
	- **XML:** Estandarizó el **intercambio de datos** estructurados entre sistemas distintos.

#### 2.Atributos de un Buen Lenguaje

- **Ortogonalidad:** "Los conceptos son independientes; si aprendes a usar una pieza, puedes encajarla con cualquier otra sin que se rompa nada."
- **Expresividad:** Se refiere a la capacidad del lenguaje para expresar operaciones complejas o algoritmos con muy poco código y de manera natural.
- **Legibilidad:** Es la facilidad con la que una persona (no la computadora) puede leer, entender y seguir el flujo de un código escrito en ese lenguaje.
- **Simplicidad:** Es la cualidad de tener un número manejable de conceptos básicos, operadores y reglas.

#### 3.Analisis de Lenguajes Especificos

- **Java**:
    - **Multiplataforma:** Se ejecuta en cualquier lado gracias a su **Máquina Virtual (JVM)**.
    - **Web:** Introdujo programas interactivos en la red mediante **Applets** (cliente) y **Servlets** (servidor).
- **C**:
    - **Estructura:** Se divide en **directivas** de preprocesador (ej. `#include`), **declaraciones** y obligatoriamente una **función** **main()**.
    - **Funciones:** Es muy eficiente, pero **NO permite el anidamiento de funciones** (no puedes crear una función dentro de otra).
- **Python**:
    - **Paradigma y Tipo:** Es **multiparadigma** (orientado a objetos, funcional y procedural) y de **tipado dinámico**.
    - **Organización:** Usa **módulos y paquetes**, siendo muy versátil para IA, datos y web.
- **Ruby**:
    - **Paradigma y Tipo:** Principalmente **Orientado a Objetos** (aquí "todo es un objeto") y de **tipado dinámico**.
    - **Estilo:** Destaca por su alta **expresividad** y se organiza en **clases y módulos**.
- **PHP**:
    - **Paradigma y Uso:** Es **multiparadigma** y de **tipado dinámico**, pero su propósito principal y casi exclusivo es el **desarrollo Web**.
- **JavaScript**:
    - **Uso principal:** Lenguaje de sintaxis **simple** que domina y es el estándar para el **desarrollo web**
- **Ada**:
	- **Abstracción (TAD):** Utiliza **paquetes** para encapsular Tipos Abstractos de Datos, separando claramente la interfaz de la implementación oculta.
	- **Excepciones:** Posee un sistema de manejo de errores **muy robusto** y estructurado mediante bloques `begin...exception...end`.
	- **Concurrencia:** Está diseñado nativamente para ejecutar procesos en paralelo utilizando **tareas** y mecanismos de sincronización avanzados como el **rendezvous**

### Practica 2  - Sintaxis

#### 1.Gramaticas Formales (BNF vs EBNF) y sus metasimbolos

##### 1. BNF (Backus-Naur Form) y Metasímbolos

BNF es un metalenguaje, es decir, una notación formal que sirve para describir la sintaxis de otro lenguaje. Utiliza símbolos especiales (metasímbolos) que tienen significados estrictos:

- **< >** **(No Terminales):** Encierran conceptos que aún se pueden seguir desarmando o definiendo (ej. `<digito>`, `<oracion>`, `<variable>`).
- **::=** **(Se define como):** Separa el nombre del concepto (a la izquierda) de su definición (a la derecha).
- **|** **(Alternativa):** Funciona como un "O" lógico, separando las diferentes opciones válidas que puede tomar una regla.
- **Terminales:** Son los caracteres finales del lenguaje (números, letras, palabras reservadas) que ya no se pueden desarmar más (en tu ejemplo, los números del `0` al `9`).

2. La Gramática G = (N, T, S, P)

Una gramática es una herramienta matemática compuesta por una 4-tupla que define el lenguaje. Cada letra representa:

- **N (No terminales):** El conjunto de todos los conceptos abstractos (los que llevan `< >`).
- **T (Terminales):** El conjunto de todos los símbolos finales válidos (el alfabeto, palabras clave, signos).
- **S (Axioma inicial):** Es la regla por la cual **siempre** debe arrancar la evaluación. Es un No Terminal especial.
- **P (Producciones):** Son las reglas en sí mismas (las líneas de código escritas en BNF).

3. Parsing y Árboles Sintácticos

Tener las reglas no basta; el compilador necesita un método para agarrar tu código fuente y comprobar si respeta esas reglas. A este proceso de análisis o reconocimiento se lo llama **Parsing**. Si el "Parser" determina que tu código es válido, dibuja automáticamente un **árbol sintáctico (o árbol de derivación)**. En este árbol jerárquico, la raíz siempre es el Axioma inicial (`S`), las ramas intermedias son los No terminales (`N`), y las hojas finales son los Terminales (`T`) del código que escribiste.

4. Construcción de Árboles (Top-Down vs. Bottom-Up)

Para dibujar ese árbol o comprobar la sentencia, el compilador puede tomar dos caminos lógicos:

- **Top-down (De arriba hacia abajo):** Arranca desde el Axioma inicial (`S`) y empieza a reemplazar las reglas bajando hasta intentar formar la oración que escribiste.
- **Bottom-up (De abajo hacia arriba):** Arranca leyendo tu código (las hojas) y las va agrupando hacia arriba hasta llegar al Axioma inicial.

Ambos métodos pueden leer la frase de **izquierda a derecha** o de **derecha a izquierda**.

--------------------------------------------------------------------------------

Completando tu ejemplo (Top-down de izquierda a derecha):

Justo donde se cortó tu apunte, los materiales proponen un ejemplo clásico de cómo se deriva una oración utilizando un enfoque Top-Down (de arriba a abajo) leyendo de izquierda a derecha.

Dada la siguiente gramática (P):

```
<oracion> => <sujeto> <predicado>
<predicado> => <verbo> <art> <objeto>
<sujeto> => Juan | María
<art> => un | una
<objeto> => mascota | perro | gato
```

_(Nota de los apuntes: aquí el autor usó_ _=>_ _en lugar de_ _::=__, pero significan lo mismo en este contexto)._

**El paso a paso de la derivación (Top-Down, Izquierda a Derecha) sería****:**

1. Arrancamos por el axioma inicial: `<oracion>`
2. Reemplazamos por su regla: `=> <sujeto> <predicado>`
3. Reemplazamos el primer No Terminal de la **izquierda** (`<sujeto>`): `=> Juan <predicado>`
4. Ahora desarmamos el de la derecha (`<predicado>`): `=> Juan <verbo> <objeto>`
5. Reemplazamos el verbo: `=> Juan adopta <objeto>`
6. Desarmamos el objeto (que en el apunte lo divide en artículo y sustantivo): `=> Juan adopta <art> <sustan>`
7. Reemplazamos de izquierda a derecha: `=> Juan adopta un <sustan>`
8. Finalmente reemplazamos el último elemento: **=> Juan adopta un perro**

Al terminar, no quedan símbolos `< >` en la frase, lo que significa que el árbol se completó con éxito y la oración es **sintácticamente correcta**.

Ejemplo de ejercicios: 
Definicion de un palabra cualquiera en BNF

```
<palabra>   ::= <letra> | <letra><palabra>
<letra>     ::= <mayuscula> | <minuscula>
<mayuscula> ::= A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P ...
<minuscula> ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p ...
```
Para la palabra **"Conceptos"**, el árbol se dibuja así:

```
<palabra>
 ├── <letra>
 │    └── <mayuscula>
 │         └── C
 └── <palabra>
      ├── <letra>
      │    └── <minuscula>
      │         └── o
      └── <palabra>
           ├── <letra>
           │    └── <minuscula>
           │         └── n
           └── <palabra>
                ├── <letra>
                │    └── <minuscula>
                │         └── c
                └── <palabra>
                     ├── <letra>
                     │    └── <minuscula>
                     │         └── e
                     └── <palabra>
                          ├── <letra>
                          │    └── <minuscula>
                          │         └── p
                          └── <palabra>
                               ├── <letra>
                               │    └── <minuscula>
                               │         └── t
                               └── <palabra>
                                    ├── <letra>
                                    │    └── <minuscula>
                                    │         └── o
                                    └── <palabra>
                                         └── <letra>
                                              └── <minuscula>
                                                   └── s
```

##### 2. EBNF (Extended Backus-Naur Form)

EBNF es una mejora de BNF. Sirve para hacer exactamente lo mismo, pero **ahorra líneas de código** porque introduce nuevos metasímbolos que evitan usar tanta recursividad manual:

- `[ ]` **(Opcionalidad):** Lo que está adentro puede aparecer 0 o 1 vez.
	- _Ejemplo:_ `<numero> ::= [ - ] <digito>` (El signo menos es opcional).        
- `{ }` **(Repetición / Clausura):** Lo que está adentro puede aparecer 0, 1 o múltiples veces.
    - _Ejemplo:_ `<palabra> ::= <letra> { <letra> }` (Arranca con una letra y luego puede tener cero o infinitas letras más).
- `( )` **(Agrupación):** Agrupa elementos para aplicarles un operador en conjunto.
    - _Ejemplo:_ `<estado> ::= ( prendido | apagado )`

Ejercicio anterior en EBNF:
```
<palabra>   ::= <letra> { <letra> }
<letra>     ::= <mayuscula> | <minuscula>
<mayuscula> ::= A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P ...
<minuscula> ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p ...
```
Se usa { } -> que indica Repeticion.

El árbol se dibuja así:

```
<palabra>
 ├── <letra>
 │    └── <mayuscula>
 │         └── C
 ├── <letra>
 │    └── <minuscula>
 │         └── o
 ├── <letra>
 │    └── <minuscula>
 │         └── n
 ├── <letra>
 │    └── <minuscula>
 │         └── c
 ├── <letra>
 │    └── <minuscula>
 │         └── e
 ├── <letra>
 │    └── <minuscula>
 │         └── p
 ├── <letra>
 │    └── <minuscula>
 │         └── t
 ├── <letra>
 │    └── <minuscula>
 │         └── o
 └── <letra>
      └── <minuscula>
           └── s
```

##### 3. Diagramas sintacticos
![[Pasted image 20260422201213.png]]

Ejercicio en diagrama: 
```
palabra
  │
  V
  ├───────────────────┐
  │                   │
  V                   │
 ┌─────────┐          │
 │ <letra> │          │
 └─────────┘          │
  │                   │
  V                   │
  ├─────── > ─────────┘  (Bucle de repetición)
  │
  V
```

```
               ┌─ ( a ) ─┐
               │         │
               ├─ ( b ) ─┤
  ── letra ────┤         ├──── >
               ├─ ( c ) ─┤
               │         │
               └─  ...  ─┘
```

_(Nota: Otra forma muy común de dibujarlo en posición horizontal es la siguiente)_:

```
                  ┌─────────┐
  palabra ───────>│ <letra> │──┬──> (Salida) ──>
                  └─────────┘  │
                    ▲          │
                    │          │
                    └───<──────┘
```

##### Repaso de Gramaticas
**1.Identificador:**
En BNF: 
```
G = (N , T , S, P)

N = { <id>, <letra>, <digito>, <caracter> } 
T = { A, B, C, ..., Z, a, b, c, ..., z, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } 
S = <id>

P = { 
      <id>     ::= <letra> | <letra><caracter>
      <caracter>   ::= <letra> | <digito> | <letra><caracter> | <digito><caracter>
      <letra>  ::= A | B | C | ... | Z | a | b | c | ... | z
      <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 
    }
```
En EBNF:
```
G = (N, T, S, P)

N = { <id>, <letra>, <digito> } 
T = { A, B, C, ..., Z, a, b, c, ..., z, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } 
S = <id>

P = { 
      <id>     ::= <letra> { <letra> | <digito> }
      <letra>  ::= A | B | C | ... | Z | a | b | c | ... | z
      <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 
    }
```

En Diagrama
```
---identificador--->|letra|-------------------------------------->
								▲                  |
								|                  |
								|---|caracter|<----|
```

```
---letra--->|a|--->
         |      ▲
		 |->|b|-|
		 |->|c|-|
		 |->|.|-|
```

```
---caracter--->|letra|--->
			|           ▲ 
			|->|digito|-|
```

```
---digito--->|0|---->
		  |        ▲
		  |-->|1|--|
		  |-->|2|--|
		  |->|...|-|
```

**2.Numero Reales**
En BNF:
```
G = (N, T, S, P)

N = { <numero_real>, <numero_entero>, <digito> }
T = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, , }
S = <numero_real>

P = {
      <numero_real>   ::= <numero_entero> | <numero_entero> , <numero_entero>
      <numero_entero> ::= <digito> | <digito><numero_entero>
      <digito>        ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
}
```
En EBNF:
```
G = (N, T, S, P)

N = { <numero_real>, <numero_entero>, <digito> }
T = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, , }
S = <numero_real>
p= {
	 <numero_real> ::= <numero_entero> [ ", " <numero_entero> ]
	 <numero_entero> ::= <digito> { <digito> }
	 <digito> ::= 0 | 1 | 2 | 3 ...
}
```
En Diagrama: 

```
---numero_real--->|<numero_entero>|---------------------------------------->
                                  |                                    ▲
                                  |--->( , )--->|<numero_entero>|------|
```

```
---numero_entero----|-->|digito|--|--------------------------------------->
				    |             |
					|<------------|
```

```
---digito--->|0|---->
		  |        ▲
		  |-->|1|--|
		  |-->|2|--|
		  |->|...|-|
```

**3.Expresionar Matematicas**

En BNF:
```
G = (N, T, S, P)

N = { <expresion>, <termino>, <factor>, <variable>, <numero> }
T = { +, -, *, /, (todos los terminales de variable y numero) }
S = <expresion>

P = {
      <expresion> ::= <termino> | <expresion> "+" <termino> | <expresion> "-" <termino>
      <termino>   ::= <factor>  | <termino> "*" <factor>  | <termino> "/" <factor>
      <factor>    ::= <variable> | <numero>
}
```
En EBNF: 
```
G = (N, T, S, P)

N = { <expresion>, <termino>, <factor>, <variable>, <numero> }
T = { +, -, *, /, (todos los terminales de variable y numero) }
S = <expresion>

P = {
      <expresion> ::= <termino> { ( "+" | "-" ) <termino> }
      <termino>   ::= <factor> { ( "*" | "/" ) <factor> }
      <factor>    ::= <variable> | <numero>
}
```
En Diagrama: 
```
---expresion--->|<termino>|----------------------------------------------->
                          |                                           ▲
                          |           ┌-> ( + ) -┐                    |
                          |---------->|          |--->|<termino>|-----|
                                      └-> ( - ) -┘
```

```
---termino--->|<factor>|----------------------------------------------->
                       |                                           ▲
                       |           ┌-> ( * ) -┐                    |
                       |---------->|          |--->|<factor>|------|
                                   └-> ( / ) -┘
```

```
                 ┌--->|<variable>|---┐
---factor------->|                   |--->
                 └--->|<numero>  |---┘
```

```
---numero--->|0|---->
		  |        ▲
		  |-->|1|--|
		  |-->|2|--|
		  |->|...|-|
```

```
---variable--->|<letra>|----------------------------------------->
                       |                                     ▲
                       |           ┌--->|<letra>|---┐        |
                       |---------->|                |--------|
                                   └--->|<numero>|--┘
```