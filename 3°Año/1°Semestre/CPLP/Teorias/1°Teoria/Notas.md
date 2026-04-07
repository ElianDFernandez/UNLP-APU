# Principales conceptos

## Sintaxis:
La sintaxis se refiere a la estructura y el orden de los elementos en un lenguaje de programación. Es el conjunto de reglas que definen cómo se deben escribir las instrucciones para que sean comprensibles por la computadora. La sintaxis incluye aspectos como la gramática, la puntuación, las palabras clave y la organización de los bloques de código.

* BNF (Backus-Naur Form) 
Es una notación formal utilizada para describir la sintaxis de los lenguajes de programación. Fue desarrollada por John Backus y Peter Naur en la década de 1960. La BNF utiliza una serie de reglas para definir la estructura de un lenguaje, donde cada regla describe cómo se pueden combinar los elementos del lenguaje para formar expresiones válidas.

## Semantica
La semántica se refiere al significado de las instrucciones en un lenguaje de programación. Define qué efecto tienen las diferentes construcciones del lenguaje cuando son ejecutadas por la computadora.

## Sistema de tipos
Establece reglas sobre los tipos de datos y su uso.
* Funcionesp principales:
    - Detectar errores
    - Garantizar consistencia
    - Mejorar seguridad del programa
Ejemplos: 
- Tipado estatico vs dinamico
- tipado fuerte vs debil

# Sintaxis

* **Sintaxis**: Conjunto de reglas que definen como componer letras,digitos y otros caracteres para formar los programas.
Ejemplos de sintaxis propuesto por BNF: 
```
<programa> ::= <instruccion> | <instruccion> <programa>
<instruccion> ::= <asignacion> | <condicional> | <iteracion>
```
## Elementos que componen la sintaxis:
- Alfabeto o conunto de caracteres.
- identificadores.
- operadores.
- palabra clave y palabra reservada.
- comentarios y uso de blancos.

# Parcing y arboles sintacticos

* Es una oracion sintacticamente incorrecta, pero semantica correcta.
* No todas las oraciones que pueden armas con los terminales son validas
* Se necesita de un metodo de analisis que permite determinar si un string dado es valido o no en el lenguaje: parsing.

Ejemplo:
```
<programa> ::= <instruccion> | <instruccion> <programa>
<instruccion> ::= <asignacion> | <condicional> | <iteracion>
<asignacion> ::= <identificador> "=" <expresion>
<condicional> ::= "if" <expresion> "then" <programa> "else" <programa>
<iteracion> ::= "while" <expresion> "do" <programa>
<expresion> ::= <identificador> | <numero> | <expresion> "+" <expresion> | <expresion> "-" <expresion>
```


