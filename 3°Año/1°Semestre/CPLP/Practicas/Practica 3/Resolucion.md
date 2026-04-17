# Practica 3

# 1. ¿Que defina la semantica?

La semantcia de un lenguaje de programacion es el significado de las construcciones del lenguaje.

Permite: 
- Describir el significado preciso de un programa
- Verificar el resultado final de la ejecucion de un programa

**BINGING:** Es el proceso de asociar un nombre con un valor o una funcion.
Por ejemplo:
```python
int x = 5
```
Entidad: x
Valor: 5
tipo: entero
rango de valores: -2^31 a 2^31-1 (Determinado por el tipo de dato)

**LIGADURA:** Es el proceso de asociar un nombre con una entidad.
Hay diferencias entre los lenguajes de programación en:
- El número de entidades
- El número de nombres que pueden estar asociados a una entidad
- El número de entidades a las que un nombre puede estar asociado
- El tiempo en el que se realiza la ligadura (en tiempo de compilación, en tiempo de ejecución, etc.)

Existen ligaduras estáticas y dinámicas. Las ligaduras estáticas se realizan en tiempo de compilación, mientras que las ligaduras dinámicas se realizan en tiempo de ejecución.

# 2.
a. ¿Que significa compilar un programa?
Compilar un programa es el proceso de traducir el codigo fuente escrito en un lenguaje de programacion a un lenguaje de maquina que pueda ser ejecutado por una computadora.

b. Describa brevemente cada uno de los pasos necesarios para compilar un programa.
1. Analisis Lexico: El codigo fuente es analizado para identificar los tokens (palabras clave, identificadores, operadores, etc.)
2. Analisis Sintactico: Los tokens son organizados en una estructura de arbol que representa la sintaxis del programa.
3. Analisis Semantico: Se verifica que el programa sea semantica y logicamente correcto.
4. Generacion de Codigo Intermedio: Se genera un codigo intermedio que es una representacion abstracta del programa.
5. Optimizacion: Se optimiza el codigo intermedio para mejorar su eficiencia.
6. Generacion de Codigo de Maquina: Se traduce el codigo intermedio a codigo de maquina que puede ser ejecutado por la computadora.
7. Enlazado: Se combinan los diferentes archivos de codigo objeto y las librerias necesarias para crear un ejecutable.
8. Ejecucion: El programa compilado es ejecutado por la computadora.

c. En que paso interviene la semantica y cual es su importancia dentro de la compilacion?
La semantica interviene en el paso de Analisis Semantico. Es importante porque permite verificar que el programa sea semantica y logicamente correcto, lo que garantiza que el programa se ejecute correctamente y produzca los resultados esperados. Sin un analisis semantico adecuado, el programa podria contener errores que no serian detectados hasta la ejecucion, lo que podria causar fallos o resultados incorrectos.

# Ejercicio 3: Con respecto al punto anterior ¿es lo mismo compilar un programa que interpretarlo?
Justifique su respuesta mostrando las diferencias basicas, ventajas y desventajas de cada uno de los procesos.

No, compilar un programa no es lo mismo que interpretarlo. 
- Compilacion: El codigo fuente es traducido a codigo de maquina antes de ser ejecutado. Esto permite que el programa se ejecute mas rapidamente, pero requiere un proceso de compilacion previo.
- Interpretacion: El codigo fuente es ejecutado directamente por un interprete sin necesidad de ser traducido a codigo de maquina. Esto permite una mayor flexibilidad y facilidad de depuracion, pero puede resultar en una ejecucion mas lenta.
- Ventajas de la compilacion:
  - Mayor velocidad de ejecucion
  - Mejor optimizacion del codigo
  - Menor consumo de recursos durante la ejecucion
- Desventajas de la compilacion:
    - Requiere un proceso de compilacion previo
    - Menor flexibilidad para realizar cambios en el codigo
    - Dificultad para depurar errores durante la ejecucion
- Ventajas de la interpretacion:
  - Mayor flexibilidad para realizar cambios en el codigo
  - Facilidad de depuracion durante la ejecucion
  - No requiere un proceso de compilacion previo
  - Permite la ejecucion de codigo dinamico o generado en tiempo de ejecucion
- Desventajas de la interpretacion:
  - Ejecucion mas lenta en comparacion con la compilacion
  - Menor optimizacion del codigo
  - Mayor consumo de recursos durante la ejecucion
  - Puede ser menos seguro debido a la ejecucion directa del codigo fuente, lo que puede permitir la ejecucion de codigo malicioso si no se toman las precauciones adecuadas.

# Ejercicio 4: Explique claramente la diferencia entre un error sintactico y uno semantico. Ejemplifique cada uno de ellos.
- Error sintactico: Es un error que ocurre cuando el codigo fuente no cumple con las reglas de sintaxis del lenguaje de programacion. Por ejemplo, si se olvida un punto y coma al final de una linea en C++:
```cpp
int main() {
    cout << "Hola Mundo" // Error sintactico: falta el punto y coma
    return 0;
}
```
- Error semantico: Es un error que ocurre cuando el codigo fuente cumple con las reglas de sintaxis, pero no tiene un significado correcto o produce un resultado inesperado. Por ejemplo, si se intenta dividir por cero en un programa:
```python
def dividir(a, b):
    return a / b
resultado = dividir(10, 0) # Error semantico: division por cero
```

# Ejercicio 5: Sean los siguiente ejemplos de programas. Analice y diga que tipo de error se produce (semantico o sintactico) y en que momento se detectan dichos errores (Compilacion o ejecucion).
Aclaracion: lo valores de la ayuda pueden ser mayores.

a. 
```pascal
Program P
var 5: integer;
var a:char;
Begin
    for i:=5 to 10 do begin
        write(a);
        a=a+1;
    end;
End.
```
Ayuda: Sintáctico 2, Semántico 3

- Error sintactico: La variable "5" no puede ser utilizada como nombre de variable. Esto se detecta en tiempo de compilacion.
- Error sintactico: a=a+1; no es una asignacion valida en Pascal. Esto se detecta en tiempo de compilacion.

- Error semantico: Write(a) falla ya que a no esta inicializada. Esto se detecta en tiempo de ejecucion.
- Error semantico: La variable "i" no esta declarada. Esto se detecta en tiempo de ejecucion.
- Error semantico: a+1 no es una operacion valida para el tipo de dato char. Esto se detecta en tiempo de ejecucion.

b. 
```java 
public String tabla(int numero, arrayList<Boolean> listado)
{
String result = null;
for(i = 1; i < 11; i--) {
    result += numero + "x" + i + "=" + (i*numero) + "\n";
    listado.get(listado.size()-1)=(BOOLEAN) numero>i;
}

return true;
}
```
Ayuda:
Sintácticos 4, Semánticos 3, Lógico 1

- Error sintactico: Declaracion de arrayList<Boolean> listado no es valida, es ArrayList<Boolean>. Esto se detecta en tiempo de compilacion.
- Error sintactico: La variable "i" no esta declarada. for(int i = 1; i < 11; i++) es la forma correcta. Esto se detecta en tiempo de compilacion.
- Error sintactico: El metodo devuelve un String pero se esta retornando un booleano. Esto se detecta en tiempo de compilacion.
- Error sintactico: (BOOLEAN) numero>i; no es una sintaxis valida para una asignacion. Esto se detecta en tiempo de compilacion.

- Error semantico: retorna true pero el metodo esta declarado para retornar un String. Esto se detecta en tiempo de ejecucion.
- Error semantico: result se inicializa como null y luego se le concatena una cadena, lo que puede causar un NullPointerException. Esto se detecta en tiempo de ejecucion.
- Error semantico: listado.get(listado.size()-1)=(BOOLEAN) numero>i; esta intentando asignar un valor booleano a una posicion del ArrayList, lo cual no es correcto. Esto se detecta en tiempo de ejecucion.

- Error logico: El ciclo for esta decrementando i en lugar de incrementarlo, lo que causara un bucle infinito. Esto se detecta en tiempo de ejecucion.

c. 
```C
# include <stdio.h>
int suma; /* Esta es una variable global */
int main()
{ int indice;
    encabezado;
    for (indice = 1 ; indice <= 7 ; indice ++)
    cuadrado (indice);
    final(); Llama a la función final */
    return 0;
}
cuadrado (numero)
int numero;
{ int numero_cuadrado;
    numero_cuadrado == numero * numero;
    suma += numero_cuadrado;
    printf("El cuadrado de %d es %d\n",
    numero, numero_cuadrado);
}
```
Ayuda: Sintácticos 2, Semánticos 6

- Error sintactico: Comentario mal formado en la linea final(); Llama a la función final */. Esto se detecta en tiempo de compilacion.
- Errror sintactico: encabezado; no es una instruccion valida. Esto se detecta en tiempo de compilacion.

- Error semantico: La funcion cuadrado no esta declarada antes de su uso en el main. Esto se detecta en tiempo de ejecucion.
- Error semantico: encabezado no esta definido en ninguna parte del programa. Esto se detecta en tiempo de ejecucion.
- Error semantico: final() no esta definido en ninguna parte del programa. Esto se detecta en tiempo de ejecucion.
- Error semantico: numero_cuadrado == numero * numero; esta utilizando el operador de comparacion "==" en lugar del operador de asignacion "=". Esto se detecta en tiempo de ejecucion.
- Error semantico: cuadrado no tiene un tipo de retorno especificado, lo que puede causar problemas si se espera un valor de retorno. Esto se detecta en tiempo de ejecucion.
- Error semantico: "suma" no se inicializa antes de ser utilizada, lo que puede causar resultados inesperados. Esto se detecta en tiempo de ejecucion.

d. 
```python
#!/usr/bin/python
print "\nDEFINICION DE NUMEROS PRIMOS"
r = 1
while r = True:
    N = input("\nDame el numero a analizar: ")
    i = 3
    fact = 0
    if (N mod 2 == 0) and (N != 2):
        print "\nEl numero %d NO es primo\n" % N
    else:
        while i <= (N^0.5):
            if (N % i) == 0:
                mensaje="\nEl numero ingresado NO es primo\n" % N
                msg = mensaje[4:6]
                print msg
                fact = 1
        i+=2
    if fact == 0:
        print "\nEl numero %d SI es primo\n" % N
r = input("Consultar otro número? SI (1) o NO (0)--->> ")
```
Ayuda: Sintácticos 2, Semánticos 3

e. 
```ruby
def ej1
    Puts 'Hola, ¿Cuál es tu nombre?'
    nom = gets.chomp
    puts 'Mi nombre es ', + nom
    puts 'Mi sobrenombre es 'Juan''
    puts 'Tengo 10 años'
    meses = edad*12
    dias = 'meses' *30
    hs= 'dias * 24'
    puts 'Eso es: meses + ' meses o ' + dias + ' días o ' + hs + ' horas'
    puts 'vos cuántos años tenés'
    edad2 = gets.chomp
    edad = edad + edad2.to_i
    puts 'entre ambos tenemos ' + edad + ' años'
    puts '¿Sabes que hay ' + name.length.to_s + ' caracteres en tu nombre, ' + name + '?'
end
```
Ayuda: Semánticos +4

# Ejercicio 6: Explique cual es la semantica para las variables predefinidas en lenguaje Ruby self y nil.¿Que valor toman; como son usadas por el lenguaje?

- self: Es una variable predefinida en Ruby que hace referencia al objeto actual. Es utilizada para acceder a los métodos y atributos del objeto dentro de su propia definición. El valor de self depende del contexto en el que se utilice, ya que puede referirse a diferentes objetos en diferentes partes del código.s Por ejemplo, dentro de una clase, self se refiere a la instancia actual de la clase, mientras que dentro de un método de clase, self se refiere a la propia clase.
- nil: Es una variable predefinida en Ruby que representa la ausencia de un valor o un valor nulo. Es utilizada para indicar que una variable no tiene un valor asignado o que una operación no ha producido un resultado válido. El valor de nil es único y se utiliza comúnmente para verificar si una variable ha sido inicializada o si una operación ha fallado. Por ejemplo, si se intenta acceder a un elemento de un array que no existe, se devolverá nil.

# Ejercicio 7: Determine la semantica de null y undefined para valores en javascript. ¿Que diferenecia hay entre ellos?

- null: Es un valor primitivo en JavaScript que representa la ausencia intencional de cualquier objeto o valor. Es utilizado para indicar que una variable no tiene un valor asignado o que una operación no ha producido un resultado válido. El valor de null es único y se utiliza comúnmente para verificar si una variable ha sido inicializada o si una operación ha fallado. Por ejemplo, si se intenta acceder a una propiedad de un objeto que no existe, se devolverá null.
- undefined: Es un valor primitivo en JavaScript que representa la ausencia de un valor asignado a una variable. Es utilizado para indicar que una variable ha sido declarada pero no ha sido inicializada con un valor. El valor de undefined es único y se utiliza comúnmente para verificar si una variable ha sido declarada o si una función ha sido llamada sin argumentos. Por ejemplo, si se declara una variable sin asignarle un valor, su valor será undefined.

La diferencia entre null y undefined es que null representa la ausencia intencional de un valor, mientras que undefined representa la ausencia de un valor asignado a una variable. En otras palabras, null es un valor que se asigna explícitamente para indicar que no hay un valor, mientras que undefined es el valor predeterminado de una variable que ha sido declarada pero no inicializada.

# Ejercicio 8: Explique la semantica de la sentencia break en C, PHP, javascript y Ruby. Cite las caracteristicas mas importantes de esta setencia para cada lenguaje.

- C: En C, la sentencia break se utiliza para salir de un bucle o una estructura de control de flujo. Cuando se encuentra una sentencia break dentro de un bucle (como for, while o do-while), el programa salta inmediatamente a la siguiente instrucción después del bucle. También se puede utilizar dentro de una estructura switch para salir de un caso específico.

- PHP: En PHP, la sentencia break se utiliza de manera similar a C para salir de un bucle o una estructura de control de flujo. Además, en PHP, break también se puede utilizar para salir de múltiples niveles de bucles anidados especificando un número después de break (por ejemplo, break 2 para salir de dos niveles de bucles).

- JavaScript: En JavaScript, la sentencia break se utiliza para salir de un bucle o una estructura de control de flujo. Al igual que en PHP, JavaScript también permite especificar un número después de break para salir de múltiples niveles de bucles anidados.

- Ruby: En Ruby, la sentencia break se utiliza para salir de un bucle o una estructura de control de flujo. Cuando se encuentra una sentencia break dentro de un bucle (como for, while o until), el programa salta inmediatamente a la siguiente instrucción después del bucle. Además, en Ruby, break también puede ser utilizado para salir de un bloque de código dentro de una iteración (como each) y puede devolver un valor específico al salir del bloque.

# Ejercicio 9: Defina el concepto de ligadura y su importancia de la semantica de un programa. ¿Que diferencias hay entre ligadura estatica y dinamica? Cite ejemplos de cada una de ellas.

La ligadura es el proceso de asociar un nombre con una entidad en un programa. Es importante para la semantica de un programa porque permite que los nombres sean utilizados para referirse a entidades como variables, funciones, clases, etc. La ligadura puede ser estatica o dinamica.

- Ligadura estatica: Es el proceso de asociar un nombre con una entidad en tiempo de compilacion. Esto significa que la asociación se realiza antes de que el programa sea ejecutado. Por ejemplo, en C++, cuando se declara una variable int x; la ligadura de x a la variable de tipo entero se realiza en tiempo de compilacion.
- Ligadura dinamica: Es el proceso de asociar un nombre con una entidad en tiempo de ejecucion. Esto significa que la asociación se realiza durante la ejecucion del programa. Por ejemplo, en Python, cuando se asigna un valor a una variable x = 5, la ligadura de x a ese valor se realiza en tiempo de ejecucion.

- Diferencias entre ligadura estatica y dinamica:
  - La ligadura estatica se realiza en tiempo de compilacion, mientras que la ligadura dinamica se realiza en tiempo de ejecucion.
  - La ligadura estatica es fija y no puede cambiar durante la ejecucion del programa, mientras que la ligadura dinamica puede cambiar durante la ejecucion del programa.
  - La ligadura estatica es mas eficiente en terminos de rendimiento, ya que se realiza antes de la ejecucion, mientras que la ligadura dinamica puede ser mas flexible pero puede tener un impacto negativo en el rendimiento debido a la necesidad de realizar asociaciones en tiempo de ejecucion.

Ejemplos Sencillos:

- Ligadura estatica:
```cpp
int main() {
    int x = 5; // La ligadura de x a la variable de tipo entero se realiza en tiempo de compilacion
    return 0;
}
```

- Ligadura dinamica:
```python
x = 5 # La ligadura de x a ese valor se realiza en tiempo de ejecucion
print(x) # La ligadura de x a su valor actual se realiza en tiempo de ejecucion
```
