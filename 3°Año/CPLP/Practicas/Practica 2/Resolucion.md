
# Sintaxis

## Ejercicio 1: Cuadro de Simbolismo Sintáctico

| Meta símbolos BNF | Meta símbolos EBNF | Símbolo en Diagramas Sintácticos | Significado |
| :--- | :--- | :--- | :--- |
| palabra terminal | palabra terminal | Óvalo o Círculo | Definición de un elemento terminal |
| `<no terminal>` | nombre | rectángulo | Definición de un elemento no terminal |
| `::=` | `::=` | diagrama con rectángulos, óvalos y flechas | Definición o asignación de regla |
| `\|` | `( \| )` | flecha que se divide en dos o más caminos | Alternativa (Elección entre opciones) |
| `<p> <p1>` | `p p1` | Secuencia de bloques en línea | Repetición / Secuencia |
| *No aplica* | `{ }` | Bucle con bypass (camino por arriba) | Repetición de 0 o más veces |
| *No aplica* | `+` | Bucle con retorno inferior | Repetición de 1 o más veces |
| *No aplica* | `[ ]` | Línea de salto (bypass) | Opcionalidad (0 o 1 vez) |

## Ejercicio 2:
¿Cuál es la importancia de la sintaxis para un lenguaje? ¿Cuáles son sus elementos?

La sintaxis es fundamental para un lenguaje porque define la estructura y las reglas que deben seguirse para formar oraciones o expresiones válidas. Sin una sintaxis clara, sería difícil entender y comunicar ideas de manera efectiva. Los elementos de la sintaxis incluyen:
1. **Palabras Terminales**: Son los símbolos básicos que no pueden ser descompuestos más. Representan los elementos concretos del lenguaje, como palabras clave, operadores, etc.
2. **Símbolos No Terminales**: Son los símbolos que pueden ser descompuestos en otros símbolos terminales o no terminales. Representan las categorías gramaticales o estructuras del lenguaje.
3. **Reglas de Producción**: Son las reglas que definen cómo los símbolos no terminales pueden ser reemplazados por combinaciones de símbolos terminales y no terminales. Estas reglas establecen la estructura del lenguaje y cómo se pueden formar oraciones válidas.
4. **Alternativas**: Permiten elegir entre diferentes opciones para formar una estructura válida.
5. **Secuencias**: Indican el orden en que los símbolos deben aparecer para formar una estructura válida.
6. **Repetición**: Permite que ciertos elementos se repitan un número específico de veces o indefinidamente.
7. **Opcionalidad**: Indica que ciertos elementos pueden aparecer o no en una estructura válida.

## Ejercicio 3: 
¿Explique a qué se denomina regla lexicográfica y regla sintáctica?

La regla lexicográfica se refiere a las reglas que definen cómo se forman las palabras o tokens en un lenguaje. Estas reglas especifican cómo se pueden combinar caracteres para formar palabras válidas, como identificadores, palabras clave, operadores, etc. Por ejemplo, una regla lexicográfica podría establecer que un identificador debe comenzar con una letra y puede contener letras y dígitos.

La regla sintáctica, por otro lado, se refiere a las reglas que definen cómo se pueden combinar los tokens para formar estructuras gramaticales válidas en un lenguaje. Estas reglas especifican cómo se pueden organizar los tokens para formar oraciones o expresiones válidas. Por ejemplo, una regla sintáctica podría establecer que una oración debe consistir en un sujeto seguido de un verbo y un objeto.

## Ejercicio 4:
¿En la definición de un lenguaje, a qué se llama palabra reservadas? ¿A qué son
equivalentes en la definición de una gramática? De un ejemplo de palabra reservada en el lenguaje que más conoce. (Ada,C,Ruby,Python,..)

Las palabras reservadas son términos que tienen un significado especial en un lenguaje de programación y no pueden ser utilizados como identificadores (nombres de variables, funciones, etc.). Estas palabras están reservadas por el lenguaje para realizar funciones específicas y forman parte de la sintaxis del lenguaje. En la definición de una gramática, las palabras reservadas son equivalentes a los símbolos terminales, ya que representan elementos concretos del lenguaje que no pueden ser descompuestos más.

Un ejemplo de palabra reservada en el lenguaje Python es `def`, que se utiliza para definir una función. Por ejemplo:

```python
def mi_funcion():
    print("Hola, mundo!")
```

## Ejercicio 5: 
Dada la siguiente gramática escrita en BNF:

G= ( N, T, S, P)
N = {<numero_entero>, <digito> }
T = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
S = <numero_entero>
P = {
        <numero_entero>::=<digito><numero_entero> | <numero_entero><digito> | <digito>
        <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
    }

a- Identifique las componentes de la misma
- N: {<numero_entero>, <digito>} = conjunto de símbolos no terminales 
- T: {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} = conjunto de símbolos terminales
- S: <numero_entero> = símbolo inicial
- P: = conjunto de producciones
    - <numero_entero>::=<digito><numero_entero> | <numero_entero><digito> | <digito>
    - <digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

b- Indique porqué es ambigua y corríjala

La gramática es ambigua porque la producción para `<numero_entero>` permite múltiples formas de generar el mismo número entero. Por ejemplo, el número "123" puede ser generado de varias maneras, lo que hace que la gramática no tenga una única derivación para cada cadena.

Para corregir la ambigüedad, podemos modificar la producción de `<numero_entero>` para que solo permita una forma de generar cada número entero. Una posible corrección sería:

```
<numero_entero> ::= <digito> | <digito><numero_entero>
<digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

## Ejercicio 6:
Defina en BNF (Gramática de contexto libre desarrollada por Backus- Naur) la
gramática para la definición de una palabra cualquiera.

Una posible gramática en BNF para la definición de una palabra cualquiera podría ser:

```
<palabra> ::= <letra> | <letra><palabra>
<letra> ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z
```
Esta gramática define una palabra como una secuencia de letras, donde cada letra puede ser cualquier letra del alfabeto.

## Ejercicio 7:
Defina en EBNF la gramática para la definición de números reales. Inténtelo
desarrollar para BNF y explique las diferencias con la utilización de la gramática EBNF.

Una posible gramática en EBNF para la definición de números reales podría ser:

```
<numero_real> ::= <parte_entera> [ "." <parte_decimal> ] [ "e" [ "+" | "-" ] <exponente> ]
<parte_entera> ::= <digito> { <digito> }
<parte_decimal> ::= <digito> { <digito> }
<exponente> ::= <digito> { <digito> }
<digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

En esta gramática, un número real se define como una parte entera seguida opcionalmente de una parte decimal y un exponente. La parte entera y la parte decimal pueden consistir en uno o más dígitos, y el exponente puede tener un signo opcional.

En comparación con la gramática BNF, la gramática EBNF permite el uso de corchetes `[]` para indicar opcionalidad, llaves `{}` para indicar repetición de cero o más veces, y paréntesis `()` para agrupar elementos. Esto hace que la gramática EBNF sea más concisa y fácil de leer en comparación con la gramática BNF, que requiere reglas adicionales para manejar la opcionalidad y la repetición.

En BNF se podria definir la gramática para números reales de la siguiente manera:

```
<numero_real> ::= <parte_entera> | <parte_entera> "." <parte_decimal> | <parte_entera> "e" <exponente> | <parte_entera> "." <parte_decimal> "e" <exponente>
<parte_entera> ::= <digito> | <digito><parte_entera>
<parte_decimal> ::= <digito> | <digito><parte_decimal>
<exponente> ::= <digito> | <digito><exponente>
<digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

## Ejercicio 8:
Utilizando la gramática que desarrolló en los puntos 6 y 7, escriba el árbol sintáctico
de:

a. Conceptos
b. Programación
c. 1255869
d. 854,26
e. Conceptos de lenguajes

a. Para la palabra "Conceptos", el árbol sintáctico sería:
```
<palabra>
      /         \
  <letra>(C)   <palabra>
               /        \
           <letra>(o)  <palabra>
                       /        \
                   <letra>(n)  ... (hasta la 's')
```

b. Para la palabra "Programación", el árbol sintáctico sería:
```
<palabra>
      /         \
  <letra>(P)   <palabra>
               /        \
           <letra>(r)  <palabra>
                       /        \
                   <letra>(o)  ... (hasta la 'n')
```

c. Para el número "1255869", el árbol sintáctico sería:
```
          <parte_entera>
         /      |       \ ...
    <digito> <digito> <digito> 
      (1)      (2)      (5) ... (hasta el 9)
```

d. Para el número "854,26", el árbol sintáctico sería:
```
          <numero_real>
         /      |       \ ...
    <parte_entera>  "."  <parte_decimal>
         |               |
     <digito>        <digito>
      (8)              (2) ... (hasta el 6)
```
e. Para la frase "Conceptos de lenguajes", el árbol sintáctico sería:
```
               <frase/frase_palabras>
              /          |           \
        <palabra>       " "        <frase>
      (Conceptos)                 /   |   \
                             <palabra> " " <palabra>
                               (de)      (lenguajes)
```

## Ejercicio 9:
Defina utilizando diagramas sintácticos la gramática para la definición de un
identificador de un lenguaje de programación. Tenga presente como regla que un identificador no puede comenzar con números.

Un posible diagrama sintáctico para la definición de un identificador de un lenguaje de programación podría ser:

```
            <identificador>
             /      |       \
        <letra>  {<letra_o_digito>}
        (a-zA-Z)   (a-zA-Z0-9)
```
En este diagrama, un identificador se define como una letra seguida de cero o más letras o dígitos. La primera letra debe ser una letra (a-z o A-Z), y los caracteres siguientes pueden ser letras o dígitos (a-z, A-Z, 0-9). Esto asegura que el identificador no pueda comenzar con un número.

## Ejercicio 10:

1. Defina con EBNF la gramática para una expresión numérica, dónde intervienen variables y
números. Considerar los operadores +, -, * y / sin orden de prioridad. No considerar el uso de
paréntesis.

Una posible gramática en EBNF para una expresión numérica que incluye variables, números y los operadores +, -, *, y / sin orden de prioridad podría ser:

```
<expresion> ::= <termino> { ("+" | "-" | "*" | "/") <termino> }
<termino> ::= <variable> | <numero>
<variable> ::= <letra> { <letra_o_digito> }
<numero> ::= <digito> { <digito> }
<letra> ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
<letra_o_digito> ::= <letra> | <digito>
<digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

En esta gramática, una expresión se define como un término seguido de cero o más operadores y términos adicionales. Un término puede ser una variable o un número. Las variables se definen como una letra seguida de cero o más letras o dígitos, mientras que los números se definen como uno o más dígitos.

2. A la gramática definida en el ejercicio anterior agregarle prioridad de operadores.

Para agregar prioridad de operadores a la gramática, podemos modificarla de la siguiente manera:

```
<expresion> ::= <termino> { ("+" | "-") <termino> }
<termino> ::= <factor> { ("*" | "/") <factor> }
<factor> ::= <variable> | <numero>
<variable> ::= <letra> { <letra_o_digito> }
<numero> ::= <digito> { <digito> }
<letra> ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
<letra_o_digito> ::= <letra> | <digito>
<digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```

En esta gramática, hemos introducido un nuevo nivel de producción llamado `<factor>`, que representa los elementos más básicos de la expresión (variables y números). Los operadores de multiplicación y división tienen una mayor prioridad que los operadores de suma y resta, ya que se encuentran en un nivel más bajo en la jerarquía de la gramática. Esto asegura que las operaciones de multiplicación y división se evalúen antes que las operaciones de suma y resta.

3. Describa con sus palabras los pasos y decisiones que tomó para agregarle prioridad de
operadores al ejercicio anterior.

Para agregar prioridad de operadores a la gramática, primero identifiqué los diferentes niveles de operaciones en una expresión matemática. En este caso, las operaciones de multiplicación y división tienen una mayor prioridad que las operaciones de suma y resta.
Luego, introduje un nuevo nivel de producción llamado `<factor>`, que representa los elementos más básicos de la expresión, como variables y números. Esto permitió que las operaciones de multiplicación y división se evaluaran antes que las operaciones de suma y resta, ya que se encuentran en un nivel más bajo en la jerarquía de la gramática.
Finalmente, ajusté las producciones para reflejar esta nueva estructura, asegurando que los operadores de multiplicación y división se evaluaran antes que los operadores de suma y resta. Esto se logró al colocar los operadores de multiplicación y división en un nivel más bajo en la jerarquía de la gramática, lo que garantiza que se evalúen primero.

## Ejercicio 11:

La siguiente gramática intenta describir sintácticamente la sentencia for de ADA,
indique cuál/cuáles son los errores justificando la respuesta.
N= {<sentencia_for>, <bloque>, <variable>, <letra>, <cadena>, <digito>, <otro>, <operacion>,
<llamada_a_funcion>, <numero>, <sentencia> }
P= { <sentencia_for>::= for (i= IN 1..10) loop <bloque> end loop;
<variable>::= <letra> | <cadena>
<cadena>::= { ( <letra> | <digito> | <otro> ) }+
<letra>::=( a | .. | z | A | .. | Z )
<digito>::= ( 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 0 )
<bloque>::= <sentencia> | <sentencia> <bloque> | <bloque> <sentencia> ;
<sentencia>::= <sentencia_asignacion> | <llamada_a_funcion> | <sentencia_if> |
<sentencia_for> | <sentencia_while> | <sentencia_switch> }

Errores identificados:
1. La producción para `<sentencia_for>` no es correcta. En ADA, la sintaxis de un bucle for es diferente y no se utiliza la estructura `for (i= IN 1..10) loop`. La sintaxis correcta sería algo como `for i in 1..10 loop <bloque> end loop;`.
2. La producción para `<variable>` es ambigua, ya que permite tanto letras como cadenas sin una clara distinción entre ellas. Esto podría llevar a confusión al intentar generar un identificador válido. Sería mejor definir `<variable>` de manera más específica, por ejemplo, permitiendo solo letras seguidas de letras o dígitos para formar un identificador válido. Ejemplo: `<variable> ::= <letra> { <letra_o_digito> }`.
3. La producción para `<cadena>` es ambigua, ya que permite cualquier combinación de letras, dígitos y otros caracteres sin una clara delimitación. En ADA, las cadenas de texto se delimitan con comillas dobles, por lo que sería mejor definir `<cadena>` de la siguiente manera: `<cadena> ::= '"' { ( <letra> | <digito> | <otro> ) } '"'`.
4. La producción para `<bloque>` es ambigua, ya que permite tanto `<sentencia> <bloque>` como `<bloque> <sentencia>`, lo que podría llevar a múltiples formas de generar el mismo bloque de código. Sería mejor definir `<bloque>` de manera más clara, por ejemplo, permitiendo solo una secuencia de sentencias: `<bloque> ::= <sentencia> { <sentencia> }`.
5. La producción para `<sentencia>` es ambigua, ya que permite múltiples tipos de sentencias sin una clara distinción entre ellas. Sería mejor definir cada tipo de sentencia de manera más específica para evitar confusiones al generar código válido. Por ejemplo, podríamos definir `<sentencia_asignacion>`, `<sentencia_if>`, `<sentencia_while>`, etc., de manera más detallada para reflejar la sintaxis específica de cada tipo de sentencia en ADA.

## Ejercicio 12:
Realice en EBNF la gramática para la definición un tag div en html 5

Una posible gramática en EBNF para la definición de un tag `<div>` en HTML5 podría ser:

```
<div> ::= "<div" [ <atributo> { " " <atributo> } ] ">" <contenido> "</div>"
<atributo> ::= <nombre_atributo> "=" <valor_atributo>
<nombre_atributo> ::= "id" | "class" | "style" | "data-" <letra> { <letra_o_digito> }
<valor_atributo> ::= '"' { <caracter> } '"'
<contenido> ::= { <caracter> | <div> }
<caracter> ::= cualquier carácter válido en HTML, excepto "<" y ">"
```

En esta gramática, un tag `<div>` se define como una etiqueta de apertura que puede contener atributos opcionales, seguida de un contenido que puede incluir texto o otros tags `<div>`, y finalmente una etiqueta de cierre. Los atributos pueden ser `id`, `class`, `style`, o cualquier atributo personalizado que comience con `data-`. El valor de cada atributo debe estar entre comillas. El contenido puede ser cualquier carácter válido en HTML, excepto los caracteres de apertura y cierre de etiquetas.

## Ejercicio 13: 
Defina en EBNF una gramática para la construcción de números primos.¿Qué
debería agregar a la gramática para completar el ejercicio?

Una posible gramática en EBNF para la construcción de números primos podría ser:

```
<numero_primo> ::= <digito_no_cero> { <digito> }
<digito_no_cero> ::= "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
<digito> ::= "0" | <digito_no_cero>
```
En esta gramática, un número primo se define sintácticamente como un número natural compuesto por un primer dígito distinto de cero, seguido de una secuencia opcional de cualquier dígito. Sin embargo, esta gramática solo define la forma de los números y no su propiedad matemática.

Para completar el ejercicio, sería necesario agregar restricciones semánticas, ya que los números primos no forman un "lenguaje independiente del contexto" que pueda ser resuelto únicamente con reglas de producción EBNF. En un sistema real, se debería añadir:

Una regla de validación externa: Un proceso lógico que verifique que el número generado sea divisible únicamente por 1 y por sí mismo.

Jerarquía de cómputo: Especificar que para reconocer gramaticalmente un número primo se requiere una gramática sensible al contexto (Tipo 1) o una Máquina de Turing, debido a que la EBNF carece de la memoria necesaria para realizar operaciones de división y comparación de residuos.

Nota de implementación: Aclarar que la gramática actual genera candidatos a números primos, los cuales deben ser filtrados por un analizador semántico mediante algoritmos como la Criba de Eratóstenes.

## Ejercicio 14:
Sobre un lenguaje de su preferencia escriba en EBNF la gramática para la definición
de funciones o métodos o procedimientos (considere los parámetros en caso de ser necesario)

En php:

```
<funcion> ::= "function" <nombre_funcion> "(" [ <parametros> ] ")" "{" <cuerpo_funcion> "}"
<nombre_funcion> ::= <letra> { <letra_o_digito> }
<parametros> ::= <parametro> { "," <parametro> }
<parametro> ::= <tipo> <nombre_parametro>
<tipo> ::= "int" | "float" | "string" | "bool" | "array" | "object"
<nombre_parametro> ::= <letra> { <letra_o_digito> }
<cuerpo_funcion> ::= { <sentencia> }
<sentencia> ::= <sentencia_asignacion> | <llamada_a_funcion> | <sentencia_if> |
<sentencia_for> | <sentencia_while> | <sentencia_switch>
<letra> ::= a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
<letra_o_digito> ::= <letra> | <digito>
<digito> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
```
En esta gramática, una función en PHP se define como la palabra clave "function" seguida de un nombre de función, una lista opcional de parámetros entre paréntesis, y un cuerpo de función entre llaves. Los parámetros consisten en un tipo seguido de un nombre de parámetro, y el cuerpo de la función puede contener varias sentencias. Las sentencias pueden ser asignaciones, llamadas a otras funciones, estructuras de control como if, for, while, switch, etc. Los nombres de funciones y parámetros deben comenzar con una letra y pueden contener letras y dígitos.