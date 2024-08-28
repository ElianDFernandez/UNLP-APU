# Final CADP 🚀

### Se aprueba o se aprueba.

## Resumen Teórico

Programa = Algoritmo + Datos

### Algoritmo:
Secuencia de pasos (instrucciones) a realizar sobre una computadora para alcanzar un resultado deseado.

### Datos:
Es una representación de un objeto del mundo real mediante el cual podemos modelizar aspectos del problema sobre una computadora.

### Tipos de datos:
![](images/Captura%20de%20pantalla%202024-08-28%20184401.png)

* **Simples**
  
  Son aquellos que no están compuestos por otros tipos de datos, sino que representan valores atómicos. Los tipos de datos simples en Pascal incluyen:

  * Tipos ordinales (tienen un orden natural, como números enteros):
    - `Integer`: Números enteros.
    - `Byte`: Enteros sin signo entre 0 y 255.
    - `ShortInt`: Enteros cortos entre -128 y 127.
    - `LongInt`: Enteros largos.
    - `Word`: Enteros sin signo entre 0 y 65535.
    - `Boolean`: Valores lógicos (`True` o `False`).
    - `Char`: Caracteres individuales.
    - `Enumerated`: Tipo definido por el usuario con valores en secuencia, por ejemplo:
      ```pascal
      type Days = (Sun, Mon, Tue, Wed, Thu, Fri, Sat);
      ```
    - `Subrange`: Un rango de un tipo ordinal, por ejemplo: `1..10` o `'A'..'Z'`.

  * Tipos numéricos reales:
    - `Real`: Números en punto flotante.
    - `Single`, `Double`, `Extended`: Variantes del tipo real que representan números de punto flotante con diferentes precisiones.
  
  * **Definido por el programador**: Permiten definir nuevos tipos de datos a partir de los tipos simples.

* **Compuestos**

  Pueden tomar varios valores a la vez que guardan alguna relación lógica entre ellos, bajo un único nombre. Los tipos de datos compuestos en Pascal incluyen:

  * Arreglos:
    ```pascal
    var numbers: array[1..5] of Integer;
    ```

  * Registros:
    ```pascal
    type
      Person = record
        name: string;
        age: Integer;
      end;
    var
    ```

## Tipos de variables:

* **Variables**

  Es una zona de memoria cuyo contenido va a ser alguno de los tipos mencionados anteriormente. La dirección inicial de esta zona se asocia con el nombre de la variable. Puede cambiar su valor durante el programa.

* **Constante**

  Es una zona de memoria cuyo contenido va a ser alguno de los tipos mencionados anteriormente. La dirección inicial de esta zona se asocia con el nombre de la constante. NO puede cambiar su valor durante el programa.

## Estructuras de control

* **Decisión**

  ```pascal
  if condición then
    instrucción1
  else
    instrucción2;
  ```
    **Datos importantes** ❗
    * Dentro del cuerpo del if puede ir cualquier cosa. 
    * En la condicion se puede utilizar:
        - Comparaciones que devuelvan True o False.
        - Funciones que devuelvan un valor booleano.
        - Expresiones lógicas combinadas.
        - Verificaciones de pertenencia a conjuntos.
        - Variables booleanas directamente.

* **Iteracion Precondicional** 
    ```pascal
    while condición do
        instrucción;
    ```
    **Datos importantes** ❗
    * Evalua y ejectura en caso de ser verdadera la condicion
    * En la condicion sucede lo mismo que en el if
    * Puede ejecutarse 0, 1 o más veces.

* **Iteracion Postcondicional** 
    ```pascal
    repeat
        instrucción;
    until(condición);
    ```
    **Datos importantes** ❗
    * Ejecutra y luego evalua
    * En la condicion sucede lo mismo que en el if
    * Se repite mientras la condición es falsa.
    * Siempre se ejecutara una vez la instruccion(Se puede evitar con un if antes pero caemos en que termina siendo un while).
    * Puede ejecutarse 1 o más veces.

* **Repeticion** 
    ```pascal
    for i:=1 to 10 do begin 
        instruccion;
    end;
    ```
    **Datos importantes** ❗
    * La variable índice debe ser de tipo ordinal
    * La variable índice no puede modificarse dentro del lazo
    * La variable índice se incrementa y decrementa automáticamente
    * Cuando el for termina la variable índice no tiene valor definido

* **Case** 
    ```pascal
    case (variable) of 
        condicion1: accion1;
        condicion2: accion2;
    end;
    ```
    Ejemplo 
    ```pascal
    case (car) of 
        car = ‘a’: cmin:= cmin + 1;
        car = ‘A’: cmay:= cmay + 1;
    end;
    ```
    **Datos importantes** ❗
    * La variable índice debe ser de tipo ordinal
    * Las opciones deben ser disjuntas. Cada valor debe ser único y no puede solaparse con otros valores.
    si pones dos opciones en las que puede entrar no compila. 

## Modularizacion 
* Cada subproblema está en un mismo nivel de detalle.
* Cada subproblema puede resolverse independientemente.
* Las soluciones de los subproblemas puede combinarse para resolver el problema original.

**Ventajas**  
* Mayor Productividad
* Reusabilidad
* Facilidad de crecimiento
* Legibilidad

### Procedimientos
Un procedimiento en Pascal es un bloque de código que realiza una tarea específica. A diferencia de una función, un procedimiento no devuelve un valor al llamado:

```pascal
    procedure Saludar(nombre: string);  
    begin  
        WriteLn('Hola, ', nombre, '!');  
    end; 
```

### Funcion 
Conjunto de instrucciones que realizan una tarea especifica y retorna un único valor de tipo simple. (Definicion en teorias) Realmente puede retornar un tipo registro que es un tipo de dato compuesto.(Ver [línea 16](#tipos-de-datos).)  
Codigo a modo de muestra: 
```pascal
    program ejer;
    type
        TPersona = record
            Nombre: string;
            Edad: Integer;
        end;

    function CrearPersona(Nombre: string; Edad: Integer): TPersona;
    begin
        CrearPersona.Nombre := Nombre;
        CrearPersona.Edad := Edad;
    end;

    var
        persona: TPersona;
    begin
        persona := CrearPersona('Juan', 30);
        WriteLn('Nombre: ', persona.Nombre);
        WriteLn('Edad: ', persona.Edad);
    end.
```

### Alcance de variables
![](images/Captura%20de%20pantalla%202024-08-28%20190312.png)
## Casos 
* Si es una variable utilizada en un proceso
    - 1° Se busca si es variable loca
    - 2° Se busca si es un parámetro
    - 3° Se busca si es variable global al programa
* Si es una variable usada en un programa
    - 1° Se busca si es variable local al programa
    - 2° Se busca si es variable global al programa

### Comunicacion entre modulos 
* Variables globales:  
    - Demasiados identificadores
    - No se especifica la comunicación entre los módulos
    - Conflictos de nombres de identificadores utilizados por diferentes programadores.
    - Posibilidad de perder integridad de los datos.

* Parametros:
    - El uso de parámetros significa que los datos compartidos se deben
    especificar como parámetros que se trasmiten entre módulos.
    - **Parámetros por valor**: Con él puede realizar operaciones y/o cálculos, pero no producirá ningún cambio ni tampoco tendrá incidencia fuera del módulo.
    ```pascal
    procedure uno (num: integer);
    ```
    - **Parametros por referencia**: Puede operar con ella y su valor original dentro del módulo, y las modificaciones que se produzcan se reflejan en los demás módulos que conocen la variable.
    ```pascal
    procedure uno (var num: integer);
    ```

* El número y tipo de los argumentos utilizados en la invocación a un
    módulo deben coincidir con el número y tipo de parámetros del
    encabezamiento del módulo.
* Un parámetro por valor debiera ser tratado como una variable de la
    cuál el módulo hace una copia y la utiliza localmente. Algunos
    lenguajes permiten la modificación local de un parámetro por valor,
    pero toda modificación realizada queda en el módulo en el cual el
    parámetro es utilizado.
* El número y tipo de los argumentos utilizados en la invocación a un
    módulo deben coincidir con el número y tipo de parámetros del
    encabezamiento del módulo.
