# Gramática Pool

Pool es un lenguaje orientado a objetos con tipado dinámico que soporta definición de funciones/métodos, creación de objetos, acceso a campos, invocación de métodos y una variedad de operadores.

## Estructura general

Un programa en Pool es una secuencia de definiciones (`def`) seguida de `EOF`.

```antlr
behaviour : def* EOF ;
```

> **Nota:** `behaviour` es la **regla de entrada** (start rule) del parser, ya que es la primera regla definida en la gramática. ANTLR la utiliza como punto de partida para analizar cualquier programa Pool.

## Definiciones (`def`)

Una definición consiste en un identificador, una lista opcional de parámetros y un bloque de sentencias.

```antlr
def : ID '(' (ID (',' ID)*)? ')' '{' stat* '}' ;
```

**Ejemplo:**
```
suma(a, b) {
    resultado = a + b;
}
```

## Sentencias (`stat`)

Una sentencia puede ser una asignación simple, una asignación a un campo de un objeto, o una expresión evaluada como sentencia.

```antlr
stat: ID '=' expr ';'           // Asignación a variable
    | ID DOT ID '=' expr ';'    // Asignación a campo de objeto
    | expr ';'                  // Expresión como sentencia
    ;
```

**Ejemplo:**
```
x = 10;              // Asignación simple
obj.campo = 42;      // Asignación a campo
print(x);            // Expresión como sentencia
```

## Expresiones (`expr`)

Las expresiones son el núcleo del lenguaje. Se definen recursivamente con las siguientes alternativas, ordenadas de menor a mayor precedencia:

### Literales y referencias

| Alternativa | Descripción | Ejemplo |
|---|---|---|
| `ID` | Referencia a variable | `x`, `nombre` |
| `INT` | Literal entero | `42`, `0`, `100` |
| `BOOL` | Literal booleano | `true`, `false` |
| `'this'` | Referencia al objeto actual | `this` |

### Creación de objetos y funciones

| Alternativa | Descripción | Ejemplo |
|---|---|---|
| `func` | Llamada a función | `suma(1, 2)` |
| `'new' ID '(' args? ')'` | Creación de objeto | `new Persona("Ana", 25)` |

### Acceso a campos y métodos

| Alternativa | Descripción | Ejemplo |
|---|---|---|
| `ID DOT ID` | Acceso a campo de objeto | `persona.nombre` |
| `ID DOT func` | Llamada a método de objeto | `persona.saludar()` |
| `'this' DOT ID` | Acceso a campo propio | `this.edad` |
| `'this' DOT func` | Llamada a método propio | `this.calcular()` |

### Expresiones con paréntesis y unarios

| Alternativa | Descripción | Ejemplo |
|---|---|---|
| `'(' expr ')'` | Agrupación con paréntesis | `(a + b)` |
| `SUB expr` | Negación unaria | `-x` |
| `NOT expr` | Negación lógica | `not activo` |

### Operadores binarios (por precedencia, de menor a mayor)

| Precedencia | Alternativa | Operadores | Ejemplo |
|---|---|---|---|
| 1 (menor) | `expr ASK expr` | `?` | `x ? x+1` |
| 2 | `expr ASK expr COLON expr` | `? :` | `x > 0 ? x : -x` |
| 3 | `expr OR expr` | `or` | `a or b` |
| 4 | `expr AND expr` | `and` | `a and b` |
| 5 | `expr CMP expr` | `<`, `>`, `<=`, `>=`, `==`, `!=` | `x >= 10` |
| 6 | `expr ADDSUB expr` | `+`, `-` | `a + b` |
| 7 | `expr MULDIV expr` | `*`, `/` | `a * b` |
| 8 (mayor) | `expr POW expr` | `^` (asociativo a derecha) | `2 ^ 3` |

### Tabla de precedencia resumida

```
Mayor precedencia  →  ^ (asociativo a derecha)
                     * /
                     + -
                     < > <= >= == !=
                     and
                     or
                     ? :  (ternario)
                     ?    (binario)
Menor precedencia  →
```

## Funciones (`func`)

Una llamada a función es un identificador seguido de argumentos opcionales entre paréntesis.

```antlr
func : ID '(' (expr (',' expr)*)? ')' ;
```

**Ejemplo:**
```
suma(1, 2)
factorial(n)
saludar()
```

## Tokens (léxico)

### Operadores

| Token | Símbolo | Descripción |
|---|---|---|
| `SUM` | `+` | Suma |
| `SUB` | `-` | Resta / Negación unaria |
| `MUL` | `*` | Multiplicación |
| `DIV` | `/` | División |
| `POW` | `^` | Potencia |
| `ASK` | `?` | Operador de pregunta (binario / ternario) |
| `COLON` | `:` | Separador del ternario |
| `DOT` | `.` | Acceso a miembro |

### Operadores de comparación

| Token | Símbolo | Descripción |
|---|---|---|
| `EQEQ` | `==` | Igualdad |
| `NEQ` | `!=` | Desigualdad |
| `LT` | `<` | Menor que |
| `GT` | `>` | Mayor que |
| `LE` | `<=` | Menor o igual |
| `GE` | `>=` | Mayor o igual |

### Operadores lógicos

| Token | Símbolo | Descripción |
|---|---|---|
| `AND` | `and` | Conjunción lógica |
| `OR` | `or` | Disyunción lógica |
| `NOT` | `not` | Negación lógica |

### Delimitadores

| Token | Símbolo | Descripción |
|---|---|---|
| `LPAREN` | `(` | Paréntesis de apertura |
| `RPAREN` | `)` | Paréntesis de cierre |
| `LCURLY` | `{` | Llave de apertura |
| `RCURLY` | `}` | Llave de cierre |
| `SEMI` | `;` | Fin de sentencia |
| `COMMA` | `,` | Separador de argumentos |

### Literales e identificadores

| Token | Patrón | Descripción |
|---|---|---|
| `INT` | `[0-9]+` | Número entero |
| `BOOL` | `true \| false` | Literal booleano |
| `ID` | `[a-zA-Z_][a-zA-Z_0-9]*` | Identificador |
| `WS` | `[ \t\n\r\f]+` | Espacios en blanco (ignorados) |

## Ejemplo completo

```
Persona(nombre, edad) {
    this.nombre = nombre;
    this.edad = edad;
}

mayorDeEdad(persona) {
    persona.edad >= 18;
}

main() {
    ana = new Persona("Ana", 25);
    esMayor = mayorDeEdad(ana);
    resultado = esMayor and true ? 1 : 0;
}
```
