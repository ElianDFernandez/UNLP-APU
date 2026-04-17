# Practica 4

# Ejercicio 1 
a. Tome una de las variables de la linea 3 del siguiente codigo e indique y defina cuales son sus atributos:

1. Procedure Practica4();
2. var
3. a,i:integer
4. p:puntero
5. Begin
6. a:=0;
7. new(p);
8. p:= ^i
9. for i:=1 to 9 do
10.a:=a+i;
11.end;
12....
13.p:= ^a;
14....
15.dispose(p);
16.end;

Atributos de una variables <Nombre, Alcance, Tipo, L-Valor, R-Valor>

Tomando la variable "a" de la linea 3, sus atributos son:
- Nombre: a
- Alcance: 4 - 16
- Tipo: Integer (es un numero entero)
- L-Valor: automatica
- R-Valor: indefinido
- Tiempo de vida: 1-16

b. Compare los atributos de la variable del punto a) con los atributos de la linea 4.
Que dato contiene esta variable?

Comparando los atributos de la variable "a" con la variable "p" de la linea 4, tenemos:
- Nombre: p
- Alcance: 5 - 16
- Tipo: Puntero (es una variable que almacena la direccion de memoria de otra variable)
- L-Valor: p: automatico - p^:dinamico
- R-Valor: p: nil - p^:indefinido
- Tiempo de vida: p: 1-16 p^:7-15

# Ejercicio 2:
a. Indique cuales son las diferentes formas de incializar uan varaibles en el momento de la declaracion de la misma.

- Inicializacion por defecto: Las variables se inicializan con un valor por defecto, por ejemplo, los enteros en 0, los caracteres en blaco, etc.
- Inicializacion de la declaracion: Las variables pueden inicializarse en el mismo momento que se declaran, por ejemplo "int i=0";
- Ignorar el probelma: La variable toma como valor inicial lo que hay en memoria (La cadena de bits asociados al area de alamacanamiento). Puede llevar a errores y requiere chequeos adicionales.

b. Analice los lenguajes: Java, C, Phyton, y Ruby las diferentes formas de inicializacion de variables de que poseen. Realice un cuadro comparativo de esta caracteristica.


| Lenguaje | Inicialización por defecto | Inicialización por declaración | Ignorar el problema |
|-----------|--------------------------|-------------------------------|---------------------|
| Java      | x                        | x                             | -                   |
| C         | x (solo globales y estáticas) | x                        | x                   |
| Python    | -                        | x                             | -                   |
| Ruby      | -                        | x                             | -                   |

# Ejercicio 3:
Explique los siguientes conceptos asociados al atributo l-valor de una: 

a. Variable estática.
b. Variable automática o semiestática.
c. Variable dinámica.
d. Variable semidinámica.
De al menos un ejemplo de cada uno.

Investigue sobre que tipos de variables respecto de su l-valor hay en los lenguajes C y Ada.


| Variable                        | Definición                                                                 | Ejemplo en C                | Ejemplo en Ada                          |
|----------------------------------|----------------------------------------------------------------------------|-----------------------------|------------------------------------------|
| Variable estática                | Se almacena en una zona de memoria fija durante la ejecución del programa   | static int a;               | -- No corresponde --                     |
| Variable automática o semiestática| Su tiempo de vida es el del bloque donde se declara                        | int i;                      | variable i : integer;                    |
| Variable dinámica                | Se crea y destruye durante la ejecución, controlada por el programador     | int *dynamic_var = malloc(sizeof(int)); | P : access integer := new integer'(20); |
| Variable semidinámica            | Tamaño dinámico pero dirección de memoria estática (perspectiva Ada)       | -- No corresponde --        | Array : array(1..n) of integer;          |


# Ejercicio 4: 
a. ¿A qué se denomina variable local y a qué se denomina variable global? 

- Variable local: Es aquella que se declara dentro de una función o bloque y solo es accesible dentro de ese ámbito. Su tiempo de vida es el mismo que el del bloque donde se declara.
- Variable global: Es aquella que se declara fuera de todas las funciones y es accesible desde cualquier parte del programa. Su tiempo de vida es el mismo que el del programa.

b. ¿Una variable local puede ser estática respecto de su l-valor? En caso afirmativo dé un ejemplo

Sí, una variable local puede ser estática respecto de su l-valor. En C, por ejemplo, se puede declarar una variable local como estática utilizando la palabra clave "static". Esto significa que su direccion de memoria(L-valor) no cambia durante la ejecución del programa, aunque su valor pueda ser modificado.
Ejemplo en C:
```c
#include <stdio.h>

void function() {
    static int count = 0; // Variable local estática
    count++;
    printf("Count: %d\n", count);
}

int main() {
    function(); // Count: 1
    function(); // Count: 2
    function(); // Count: 3
    return 0;
}
```

c. Una variable global ¿Siempre es estatica? Justifique su respuesta.

No, una variable global no siempre es estática. En algunos lenguajes de programación, como C, las variables globales pueden ser estáticas o no estáticas. Una variable global estática tiene un tiempo de vida igual al del programa y su dirección de memoria no cambia durante la ejecución, mientras que una variable global no estática puede ser modificada y su dirección de memoria puede cambiar. En otros lenguajes, como Java, todas las variables globales son estáticas por defecto. Por lo tanto, la respuesta depende del lenguaje de programación utilizado.

d. Inidique que diferencia hay entre una variable estatica respecto de su L-valor y una constante.

| Variable Estática (L-valor) | Constante |
|-----------------------------|-----------|
| Tiene una dirección de memoria fija durante la ejecución del programa. | No tiene dirección de memoria modificable, su valor es inmutable. |
| Puede ser modificada durante la ejecución del programa. | No puede ser modificada después de su inicialización. |

# Ejercicio 5:
a. En Ada hay dos tipos de constantes, las numéricas y las comunes. Indique a que se debe dicha clasificación.

En Ada, las constantes se clasifican en numéricas y comunes debido a la forma en que se definen y utilizan en el programa.

- Constantes numéricas: son aquellas que se definen con un valor numérico específico. Estas se definen utilizando una notacion numerica estandar y la ligadura se produce en tiempo de compilación. Por ejemplo:

- Constantes comunes: son aquellas que se definen con un valor que no es numérico, se definen utilizando una notacion especifica para cada tipo de dato y la ligadura se produce en tiempo de ejecución. Por ejemplo:

b. En base a lo respondido en el punto a), determine el momento de ligadura de las constantes del siguiente código:
H: constant Float:= 3,5;
I: constant:= 2;
K: constant float:= H*I;

- H: La ligadura se produce en tiempo de compilación, ya que es una constante numérica con un valor específico.
- I: La ligadura se produce en tiempo de compilación, ya que es una constante numérica con un valor específico.
- K: La ligadura se produce en tiempo de ejecución, ya que es una constante común que depende de las constantes H e I, y su valor se calcula en tiempo de ejecución.

# Ejercicio 6:
Sea el siguiente archivo con funciones de C:
```c
Archivo.c
{ int x=1; (1)
    int func1();{
        int i;
        for (i:=0; i < 4; i++) x=x+1;
    }
    int func2();{
        int i, j;
        /*sentencias que contienen declaraciones y
        sentencias que no contienen declaraciones*/
        ......
        for (i:=0; i < 3; i++) j=func1 + 1;
    }
}
```

Analice si llegaría a tener el mismo comportamiento en cuanto a alocación de memoria, sacar la declaración (1) y colocar dentro de func1() la declaración static int x =1;

Si se saca la declaración (1) y se coloca dentro de func1() la declaración static int x = 1, el comportamiento en cuanto a alocación de memoria sería diferente.
- En el primer caso, la variable x es una variable global, lo que significa que se aloca en una sección de memoria global y su valor es compartido entre todas las funciones del programa. Esto implica que cualquier cambio en x dentro de func1() o func2() afectará a todas las funciones que acceden a x.
- En el segundo caso, al declarar x como static dentro de func1(), x se convierte en una variable local estática. Esto significa que x se aloca en una sección de memoria local a func1() y su valor es persistente entre llamadas a func1(). Sin embargo, x no será accesible desde func2() ni desde otras funciones, lo que implica que cualquier cambio en x dentro de func1() no afectará a otras funciones del programa.

# Ejercicio 7:
Ejercicio 7: Sea el siguiente segmento de código escrito en Java, indique para los identificadores si son
globales o locales.

Clase Persona {
    public long id
    public string nombreApellido
    public Domicilio domicilio
    private string dni;
    public string fechaNac;
    public static int cantTotalPersonas;
    //Se tienen los getter y setter de cada una de las variables
    //Este método calcula la edad de la persona a partir de la fecha de nacimiento

    public int getEdad(){
        public int edad=0;
        public string fN = this.getFechaNac();
        ...
        ...
        return edad;
    }
}

Clase Domicilio {
    public long id;
    public static int nro
    public string calle
    public Localidad loc;
    //Se tienen los getter y setter de cada una de las variables
}

Globales: 
- int nro
- int cantTotalPersonas
Locales:
- long id (en clase Persona)
- string nombreApellido (en clase Persona)
- Domicilio domicilio (en clase Persona)
- string dni (en clase Persona)
- string fechaNac (en clase Persona)
- int edad (en método getEdad())
- string fN (en método getEdad())
- long id (en clase Domicilio)
- string calle (en clase Domicilio)
- Localidad loc (en clase Domicilio)

La declaracion static de una variable en Java hace que esa variable sea compartida por todas las instancias de la clase, lo que la convierte en una variable global dentro del contexto de la clase. Por lo tanto, "cantTotalPersonas" y "nro" son variables globales, mientras que las demás variables son locales a sus respectivas clases o métodos.

# Ejercicio 8: Sea el siguiente ejercicio escrito en Pascal

1- Program Uno;
2- type tpuntero= ^integer;
3- var mipuntero: tpuntero;
4- var i:integer;
5- var h:integer;
6- Begin
7- i:=3;
8- mipuntero:=nil;
9- new(mipuntero);
10- mipunterno^:=i;
11- h:= mipuntero^+i;
12- dispose(mipuntero);
13- write(h);
14- i:= h- mipuntero;
15- End.

a) Indique el rango de instrucciones que representa el tiempo de vida de las variables i, h y mipuntero.
b) Indique el rango de instrucciones que representa el alcance de las variables i, h y mipuntero.
c) Indique si el programa anterior presenta un error al intentar escribir el valor de h. Justifique
d) Indique si el programa anterior presenta un error al intentar asignar a i la resta de h con mipuntero.
Justifique
e) Determine si existe otra entidad que necesite ligar los atributos de alcance y tiempo de vida para
justificar las respuestas anteriores. En ese caso indique cuál es la entidad y especifique su tiempo
de vida y alcance.
f) Especifique el tipo de variable de acuerdo a la ligadura con el l-valor de las variables que encontró en el ejercicio.

a).
Rango de instrucciones para el tiempo de vida de i, h y mipuntero El tiempo de vida (o extensión) abarca el periodo en que las variables se encuentran alocadas en memoria. Como son variables globales pertenecientes al programa principal, su tiempo de vida se establece estáticamente y abarca toda la ejecución del bloque principal, es decir, de la instrucción 6 a la 15.

b). 
Rango de instrucciones para el alcance de i, h y mipuntero El alcance de una variable es el rango donde su nombre es conocido y puede ser referenciado. Las reglas de alcance establecen que este se extiende desde el punto de la declaración hacia el final del bloque o estructura. Por lo tanto, el alcance de estas variables abarca el cuerpo del programa, de la instrucción 6 a la 15

c).No presenta error. En la instrucción 11, la sentencia de asignación copió el resultado de la suma y modificó únicamente el r-valor (valor) contenido en la ubicación de memoria (l-valor) de la variable h. Por lo tanto, el valor de h se encuentra definido y puede ser escrito sin problemas.

d). Sí, presenta un error de incompatibilidad de tipos (semántica estática). El lenguaje Pascal es fuertemente tipado y no permite mezclar valores de tipo diferente ni aplica reglas de conversión implícita

e). El programa principal puede considerarse como una entidad que necesita ligar los atributos de alcance y tiempo de vida para justificar las respuestas anteriores. El programa principal tiene un tiempo de vida que abarca toda la ejecución del bloque principal (instrucciones 1 a 15) y un alcance que también se extiende a lo largo de este bloque, permitiendo el acceso a las variables i, h y mipuntero.

f). 
Variable i: Variable global, tipo entero, l-valor automático, r-valor definido.
Variable h: Variable global, tipo entero, l-valor automático, r-valor definido.
Variable mipuntero: Variable global, tipo puntero a entero, l-valor automático, r-valor definido (después de la asignación en la instrucción 9).
Variable mipuntero^: Variable dinámica (puntero), tipo entero, l-valor dinámico, r-valor definido (después de la asignación en la instrucción 10).

# Ejercicio 9: 
Elija un lenguaje y escriba un ejemplo:
a. En el cual el tiempo de vida de un identificador sea mayor que su alcance
b. En el cual el tiempo de vida de un identificador sea menor que su alcance
c. En el cual el tiempo de vida de un identificador sea igual que su alcance

En Java:
a. Tiempo de vida mayor que su alcance:
```java
public class Example {
    private static int counter = 0; // Tiempo de vida es toda la ejecución del programa, pero su alcance es solo dentro de la clase

    public static void example() {
        counter++;
        System.out.println("Counter: " + counter);
    }

    public static void main(String[] args) {
        example(); // Counter: 1
        example(); // Counter: 2
    }
}
```
1. Nombre: counter
Es el identificador con el cual referenciamos a la variable dentro de nuestro código.
2. Tipo: int (entero)
Define que la variable almacenará números enteros y tiene asociado un conjunto de operaciones válidas (como ++ para sumar 1).
3. Alcance (Scope): Limitado a la clase Example
El alcance es el rango de instrucciones en el que el nombre de la variable es conocido y visible. Al estar declarada con el modificador private dentro de la clase Example, su alcance léxico es estrictamente el bloque de esa clase.
¿Qué significa esto en la práctica? Que si tuvieras otra clase externa en tu programa e intentaras escribir Example.counter, el compilador te daría un error diciendo que la variable es invisible o desconocida fuera de su alcance.
4. L-valor y Tiempo de vida: Toda la ejecución del programa
El L-valor representa la dirección de memoria reservada para la variable, y el momento en que esta memoria está reservada define su tiempo de vida.
Al declarar la variable como static, el lenguaje aplica una alocación estática. Esto significa que el compilador reserva su área de memoria (su l-valor) en la zona de datos desde el instante en que el programa se carga, y esa área perdura alocada hasta que el programa finaliza por completo.
5. R-valor: Dinámico (cambia en ejecución)
El R-valor es el contenido físico (los bits) almacenado en la dirección del L-valor. En tu ejemplo, el binding (ligadura) a su valor es dinámico.
Al inicio del programa, su r-valor es 0.
Cuando el main llama a example() por primera vez, la instrucción counter++ accede al l-valor, lee el 0, lo incrementa y guarda un 1. Ahora su r-valor es 1.
En la segunda llamada, el proceso se repite y su nuevo r-valor pasa a ser 2.
Conclusión: ¿Por qué el Tiempo de vida es MAYOR que el Alcance?
Imagina que el programa main invoca rutinas en otras clases ajenas a Example. Durante todo ese tiempo en que se ejecuta código de otras clases, el nombre counter es totalmente invisible e inaccesible para ellas (su alcance terminó ahí). Sin embargo, la variable sigue viva en la memoria ocupando su l-valor y conservando intacto su r-valor (el número 2) porque su tiempo de vida es estático y no morirá hasta que termine la ejecución del programa.
Por lo tanto, la variable existe en memoria por mucho más tiempo del que está "visible" para ser usada, cumpliendo perfectamente el escenario A.

b. Tiempo de vida menor que su alcance:
```Pascal
    procedure Ejemplo();
    var
        p: ^integer;  // 'p' es un puntero a entero
    begin
        new(p);       // 1. Se ALOCA memoria dinámicamente en la heap.
        p^ := 10;     // 2. Se asigna un r-valor.

        dispose(p);   // 3. Se DESALOCA (libera) la memoria explícitamente.

        // 4. A partir de esta línea, la memoria ha sido destruida.
        // Sin embargo, seguimos dentro del bloque, por lo que 'p' sigue visible.
        // Escribir p^ := 20; aquí sería un error grave (puntero colgante).
        // Pero escribir p := nil; aquí es válido, aunque no tiene sentido práctico.
    end;
```
p^: Tiempo de vida: Desde la instrucción 1 (new(p)) hasta la instrucción 3 (dispose(p)). Después de dispose(p), la memoria a la que apuntaba p ha sido liberada, por lo que el puntero p se convierte en un puntero colgante si se intenta acceder a p^.

c. Tiempo de vida igual que su alcance:
```pascal
    procedure Ejemplo();
    var
        i: integer;  // 'i' es una variable local de tipo entero
    begin
        i := 5;       // Se asigna un r-valor a 'i'
        writeln(i);   // Se puede usar 'i' dentro de su alcance
    end;
```

# Ejercicio 10:
Si tengo la siguiente declaracion al comienzo de un procedimiento: 
int c; en C
var c: integer; en Pascal
c : integer en Ada

Y ese procedimiento NO contiene definiciones de procedimientos internos. ¿Puedo asegurar que el alcance y el tiempo de vida de la variable “c” es siempre todo el procedimiento en donde se encuentra definida?. Analícelo y justifique la respuesta, para todos los casos.

No, ya que no me asegurada que no haya definiciones de variables nuevas, y en caso de suceder esto, si se defineises una con el mismo identificador que las previamente definidas, se me enmascarian y perderianparte de su alcance. Exceptuando Pascal ya que no se puede declarar variables fuera de funciones.
En Pascal el timpo de vida sera todo el bloque de codigo, mientras que en C y en ADA, si se declarase dentro de un bloque interno, el alcance se veria reducido a ese bloque, aunque el tiempo de vida seguiria siendo todo el procedimiento.

# Ejercicio 11:

a) Responda Verdadero o Falso para cada opción. El tipo de dato de una variable es?
I) Un string de caracteres que se usa para referenciar a la variable y operaciones que se pueden realizar sobre ella.
II) Conjunto de valores que puede tomar y un rango de instrucciones en el que se conoce el nombre.
III) Conjunto de valores que puede tomar y lugar de memoria asociado con la variable.
IV) Conjunto de valores que puede tomar y conjunto de operaciones que se pueden realizar sobre esos valores.
b) Escriba la definición correcta de tipo de dato de una variable.

a) Respuestas:
I) Falso
II) Falso
III) Falso
IV) Verdadero

b) Definición correcta de tipo de dato de una variable:
El tipo de dato de una variable es un conjunto de valores que puede tomar y un conjunto de operaciones que se pueden realizar sobre esos valores. El tipo de dato define la naturaleza de los datos que la variable puede almacenar y las operaciones válidas que se pueden aplicar a esos datos.

# Ejercicio 12: 
Sea el siguiente programa en ADA, completar el cuadro siguiente indicando para cada
variable de que tipo es en cuanto al momento de ligadura de su l-valor, su r-valor al momento de alocación
en memoria y para todos los identificadores cuál es su alcance y cual es su el tiempo de vida.
Indicar para cada variable su r-valor al momento de alocación en memoria.
```ada
1. with text_io; use text_io;
2. Procedure Main is;
3. type vector is array(integer range <>);
4. a, n, p:integer;
5. v1:vector(1..100);
6. c1: constant integer:=10;
7. Procedure Uno is;
1. type puntero is access integer;
2. v2:vector(0..n);
3. c1, c2: character;
4. p,q: puntero;
5. begin
7.5.1. n:=4;
7.5.2. v2(n):= v2(1) + v1(5);
7.5.3. p:= new puntero;
7.5.4. q:= p;
7.5.5. .......
7.5.6. free p;
7.5.7. ......
7.5.8. free q;
7.5.9. ......
7.6. end;
8. begin
9. n:=5;
10. .....
11. Uno;
12. a:= n + 2;
13. .....
14. end
```


---
**Tips para analizar variables en ADA:**

1. **Cómo determinar el "Tipo" (Momento de ligadura del l-valor):**
    - Observa dónde está declarada la variable y si su tamaño es fijo o no.
    - **Estática:** Variables declaradas en el bloque principal (Main). Su memoria se reserva al compilar y permanece fija durante toda la ejecución del programa. Ejemplo: `a`, `n`, `p` (línea 4) y `v1` (línea 5).
    - **Semiestática (o Automática):** Variables locales comunes de un subprograma (como `c1`, `c2`, `p`, `q` dentro de Uno). Su memoria se reserva automáticamente en la pila (stack) al invocar el subprograma.
    - **Semidinámica:** Estructuras (como arreglos) declaradas en subprogramas cuyo tamaño depende de una variable evaluada al entrar a la rutina. Ejemplo: `v2: vector(0..n)` tomará el valor de `n` al llamar Uno.
    - **Dinámica explícita:** El programador solicita memoria manualmente en tiempo de ejecución (heap) usando instrucciones como `new`. Esta memoria se asocia a una variable anónima (sin nombre) accedida mediante un puntero.

2. **Cómo determinar el "R-valor al momento de alocación":**
    - Pregúntate: ¿Qué valor físico se guarda en la memoria cuando la variable nace?
    - Si hay inicialización explícita: El r-valor será el valor asignado en la declaración. Ejemplo: en la línea 6, `c1` nace con r-valor 10.
    - Si NO hay inicialización: Muchos lenguajes dejan en la celda de memoria los bits que ya estuvieran ahí previamente (basura). Por lo tanto, cualquier variable sin un `:= valor` en su declaración arranca con r-valor "basura".

3. **Cómo hallar el "Alcance" (Scope):**
    - El alcance responde a: ¿En qué líneas puedo escribir este nombre y el compilador lo reconoce?
    - **Regla de ADA:** El alcance comienza desde la línea de declaración hacia abajo y termina al llegar al `end` del bloque que la contiene.
    - **Ocultamiento (Shadowing):** Si el programa principal tiene una variable global llamada `p` (línea 4) y el procedimiento Uno declara su propia variable local `p` (línea 7.4), la variable global pierde su alcance dentro de ese procedimiento.
    - **Variables anónimas:** La memoria creada con `new puntero` en la línea 7.5.3 no tiene alcance, ya que carece de identificador léxico (nombre).

4. **Cómo hallar el "Tiempo de Vida" (Extensión):**
    - El tiempo de vida responde a: ¿Cuándo se aloca la memoria y cuándo se destruye?
    - **Variables Estáticas (Globales):** Viven durante toda la ejecución del programa (líneas 1 a 14).
    - **Variables Semiestáticas y Semidinámicas (Locales):** Viven el tiempo que dura la ejecución de la rutina (gatillada en la llamada de la línea 11).
    - **Variables Dinámicas Explícitas (Anónimas):** Su tiempo de vida es manejado por el programador. Nace en la línea del `new` (7.5.3) y muere en la línea del `free` (7.5.6).

---

| Identificador         | Tipo           | R-valor | Alcance      | Tiempo de vida |
|---------------------- |--------------- |---------|--------------|---------------|
| a (línea 4)           | Estática       | Basura  | 5-14         | 1-14          |
| n (línea 4)           | Estática       | Basura  | 5-14         | 1-14          |
| p (línea 4)           | Estática       | Basura  | 5-14         | 1-14          |
| v1 (línea 5)          | Estática       | Basura  | 6-14         | 1-14          |
| c1 (línea 6)          | Estática       | 10      | 7-14         | 1-14          |
| v2 (línea 7.2)        | Semidinámica   | Basura  | 7.3-7.6      | 7-7.6         |
| c1 (línea 7.3)        | Semiestática   | Basura  | 7.4-7.6      | 7-7.6         |
| c2 (línea 7.3)        | Semiestática   | Basura  | 7.4-7.6      | 7-7.6         |
| p (línea 7.4)         | Semiestática   | Basura  | 7.5-7.8      | 7-7.6         |
| q (línea 7.4)         | Semiestática   | Basura  | 7.5-7.8      | 7-7.6         |

Aclaración:
Ident.= Identificador / Tipo es el tipo de la variable respecto del l-value
T.V. = Tiempo de Vida / r-valor debe ser tomado al momento de la alocación en memoria.
El alcance de los identificadores debe indicarse desde la línea siguiente a su declaración.

# Ejercicio 13: El nombre de una variable puede condicionar:
a) Su tiempo de vida.
b) Su alcance.
c) Su r-valor.
d) Su tipo.
Justifique la respuesta

b) Su alcance. El nombre de una variable es el identificador que se utiliza para referenciar a esa variable dentro del código. El alcance de una variable se determina por el bloque o estructura en la que se declara. Si una variable se declara dentro de un bloque específico (como una función o un procedimiento), su alcance estará limitado a ese bloque. Por lo tanto, el nombre de la variable condiciona su alcance, ya que solo será visible y accesible dentro del bloque donde se declaró. Si se intenta acceder a la variable fuera de su alcance, el compilador generará un error indicando que la variable es desconocida o no está definida.

# Ejercicio 14: Sean los siguientes archivos en C, los cuales se compilan juntos:

Inidicar para cada variable de que tipo es en cuandto al momento de ligadura de su l-valor. 
Inidicar para cada identificador cual es su alcance y cual es su el tiempo de vida.
Inidicar para cada variable su r-valor al momento de alocación en memoria.

Archivo1.c
```c
ARCHIVO1.C
1. int v1;
2. int *a;
3. Int fun2 ()
4. { int v1, y;
5. for(y=0; y<8; y++)
6. { extern int v2;
7. ...}
8. }
9. main()
10. {static int var3;
11. extern int v2;
12. int v1, y;
13. for(y=0; y<10; y++)
14. { char var1='C';
15. a=&v1;}
16. }
ARCHIVO2.C
17. static int aux;
18. int v2;
19. static int fun2( )
20. { extern int v1;
21. aux=aux+1;
22. …
23. }
24. int fun3( )
25. { int aux;
26. aux=aux+1;
27. …
28. }
```

# Ejercicio 15: 
Para javascript investigue la diferencia semántica para declarar una variable utilizando los modificadores const, var, let y la ausencia de cualquiera de estos. Compárelo con un lenguaje de su preferencia.
