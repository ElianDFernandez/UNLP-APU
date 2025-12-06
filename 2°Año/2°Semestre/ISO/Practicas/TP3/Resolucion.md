# TP3
Scripts en bash, **Shell Scripting**.

**Temas abordados:**
- Bash
- Scripts
- Sintaxis
- GNU/Linux

## 1 ¿Que es el Shell Scripting? ¿A que tipos de tereas estan orientados los scripts?¿Los scripts deben compilarse? ¿Por que?

- El Shell Scripting es un lenguaje de programación interpretado que permite automatizar tareas en sistemas operativos tipo Unix/Linux mediante la creación de scripts o archivos de texto que contienen una serie de comandos del shell.

- Los scripts están orientados a tareas repetitivas, automatización de procesos, administración del sistema, manipulación de archivos, y configuración del entorno, entre otras.

- Los scripts no deben compilarse, ya que son interpretados por el shell en tiempo de ejecución. Esto permite una mayor flexibilidad y facilidad de modificación, ya que los cambios pueden hacerse directamente en el archivo de script sin necesidad de un proceso de compilación.

## 2 Investigar la funcionalidad de los comandos echo y read.
a. ¿Como se indican los comentarios en un script bash?
b. ¿Como se declaran y se hace referencia a variables dentro de un script bash?

- El comando `echo` se utiliza para mostrar texto o variables en la salida estándar (normalmente la terminal). Es útil para imprimir mensajes, resultados de comandos, o el valor de variables.

- El comando `read` se utiliza para leer la entrada del usuario desde la terminal y asignarla a una o más variables. Es útil para interactuar con el usuario y obtener datos durante la ejecución del script.

## 3 Crear dentro del directorio personal del usuario logueado un directorio llamado practica-shell-scripting y dentro de el un archivo llamado mostrar.sh cuto contenido sea el siguiente:

```bash
#!/bin/bash
# Comentarios acerca de lo que hace el script
# Siempre comento mis scripts, si no lo hago hoy,
# mañana ya no me acuerdo de lo que quise hacer
echo "Introduzca su nombre y apellido:"
read nombre apellido
echo "Fecha y hora actual:"
date
echo "Su apellido y nombre es:"
echo "$apellido $nombre"
echo "Su usuario es: `whoami`"
echo "Su directorio actual es:"
```

a. Asignar al archivo creado los permisos necesarios de manera que pueda ejecutarlo
```bash
chmod +x mostrar.sh
```
b. Ejecutar el archivo creado de la siguiente manera: ./mostrar
c. ¿Qué resultado visualiza?
```bash
root@ELIAN-PC:/home/elian/practica-shell-scripting# ./mostrar.sh
Introduzca su nombre y apellido:
Elian
Fecha y hora actual:
Sun Nov 30 14:05:02 -03 2025
Su apellido y nombre es:
 Elian
Su usuario es: root
Su directorio actual es:
root@ELIAN-PC:/home/elian/practica-shell-scripting#
```
d. Las backquotes (`) entre el comando whoami ilustran el uso de la sustitución de comandos. ¿Qué significa esto?

- La sustitución de comandos permite ejecutar un comando dentro de otro comando y utilizar su salida como parte del comando externo. En este caso, el comando `whoami` se ejecuta y su resultado (el nombre del usuario actual) se inserta en la línea donde se utiliza.

e. Realizar modificaciones al script anteriormente creado de manera de poder mostrar distintos resultados (cuál es su directorio personal, el contenido de un directorio en particular, el espacio libre en disco, etc.). Pida que se introduzcan por teclado (entrada estándar) otros datos.
```bash
echo "Directorio personal:"
echo "$HOME"
echo "Contenido del directorio /etc:"
ls /etc
echo "Espacio libre en disco:"
df -h
echo "Introduzca su ciudad:"
read ciudad
echo "Usted vive en: $ciudad"
```

## 4 Parametrizacion: ¿Como se acceden a lso parametros enviados al script al momento de su invocacion? ¿Que informacion continen las variables $#, $*, $?, y $HOME dentro de un script?

- Los parámetros enviados al script al momento de su invocación se acceden mediante variables especiales. El primer parámetro se accede con `$1`, el segundo con `$2`, y así sucesivamente.

- La variable `$#` contiene el número total de parámetros pasados al script.
- La variable `$*` contiene todos los parámetros pasados al script como una sola cadena de texto.
- La variable `$?` contiene el código de salida del último comando ejecutado, donde un valor de `0` generalmente indica éxito y cualquier otro valor indica un error.
- La variable `$HOME` contiene la ruta del directorio personal del usuario que está ejecutando el script.

## 5 ¿Cual es la funcionalidad de comando exit? ¿Que valores recibe como parametro y cual es su significado?

- El comando `exit` se utiliza para finalizar la ejecución de un script o de una sesión de shell. Al usar `exit`, se puede especificar un valor de retorno (código de salida) que indica el estado de finalización del script.

- El valor que recibe como parámetro es un número entero. Un valor de `0` generalmente indica que el script se completó con éxito, mientras que cualquier valor distinto de `0` indica que ocurrió un error o una condición especial durante la ejecución del script. Estos códigos de salida pueden ser utilizados por otros programas o scripts para determinar cómo proceder después de la ejecución del script.

Ejemplo:
```bash
#!/bin/bash
# Script de ejemplo como utilizar parametros y exit
if [ $# -eq 0 ]; then
    echo "No se proporcionaron parámetros."
    exit 1  # Salida con error
else
    echo "Número de parámetros: $#"
    echo "Parámetros: $*"
    exit 0  # Salida exitosa
fi
```

## 6 ¿El comando expr permite la evaluacion de expresiones. Su sintaxis es: expr arg1 op arg2, donde arg1 y arg2 son operandos y op es un operador. Investigar que tipo de operaciones se pueden utilizar.

- El comando `expr` permite realizar operaciones aritméticas y de cadena en scripts de shell. Los tipos de operaciones que se pueden utilizar incluyen:
  - Aritméticas: `+` (suma), `-` (resta), `*` (multiplicación), `/` (división), `%` (módulo)
  - Comparación: `=` (igual), `!=` (diferente), `<` (menor que), `>` (mayor que), `<=` (menor o igual que), `>=` (mayor o igual que)
  - Operaciones de cadena: `length` (longitud de una cadena), `substr` (subcadena), `index` (posición de un carácter en una cadena)
Ejemplo:
```bash
#!/bin/bash
# Ejemplo de uso de expr
a=10
b=5
suma=`expr $a + $b`
resta=$(expr $a - $b)
multiplicacion=$(expr $a \* $b)
division=$(expr $a / $b)
echo "Suma: $suma"
echo "Resta: $resta"
echo "Multiplicación: $multiplicacion"
echo "División: $division"
```
Usamos $(...) en lugar de las backquotes para la sustitución de comandos, ya que es una forma más moderna y legible.

## 7 El comando test expresion permite evaluar expresiones y generar un valor de retorno true o false. Este comando puede ser reemplazado por el uso de corchetes [ expresiion ]. Investigar que tipo de expresiones pueden ser usadas con el comando test. Tenga en cuenta operaciones para: evaluacion de archivos, evaluacion de cadenas y evaluacion de numeros.

- El comando `test` (o los corchetes `[ ]`) permite evaluar diferentes tipos de expresiones en scripts de shell. Los tipos de expresiones que pueden ser usadas incluyen:
  - Evaluación de archivos:
    - `-e archivo`: verifica si el archivo existe. Ejemplo:
    ```bash
    if [ -e "$mi_archivo" ]; then
        echo "El archivo existe."
    else
        echo "El archivo no existe."
    fi
    ```
    - `-f archivo`: verifica si el archivo es un archivo regular.
    - `-d archivo`: verifica si el archivo es un directorio.
    - `-r archivo`: verifica si el archivo es legible.
    - `-w archivo`: verifica si el archivo es escribible.
    - `-x archivo`: verifica si el archivo es ejecutable.
    - Evaluación de cadenas:
    - `-z cadena`: verifica si la cadena es de longitud cero. Ejemplo: 
    ```bash
    if [ -z "$mi_cadena" ]; then
        echo "La cadena está vacía."
    else
        echo "La cadena no está vacía."
    fi
    ```
    - `-n cadena`: verifica si la cadena no es de longitud cero.
    - `cadena1 = cadena2`: verifica si las dos cadenas son iguales.
    - `cadena1 != cadena2`: verifica si las dos cadenas son diferentes.
    
    - Evaluación de números:
    - `num1 -eq num2`: verifica si los dos números son iguales.
    - `num1 -ne num2`: verifica si los dos números son diferentes.
    - `num1 -lt num2`: verifica si el primer número es menor que el segundo.
    - `num1 -le num2`: verifica si el primer número es menor o igual que el segundo.
    - `num1 -gt num2`: verifica si el primer número es mayor que el segundo.
    - `num1 -ge num2`: verifica si el primer número es mayor o igual que el segundo.

Ejemplo:
```bash
#!/bin/bash
# Ejemplo de uso de test y corchetes
archivo="mi_archivo.txt"
if [ -e $archivo ]; then
    echo "El archivo $archivo existe."
else
    echo "El archivo $archivo no existe."
fi
cadena1="hola"
cadena2="mundo"
if [ "$cadena1" != "$cadena2" ]; then
    echo "Las cadenas son diferentes."
fi
num1=10
num2=20
if [ $num1 -lt $num2 ]; then
    echo "$num1 es menor que $num2."
fi
```

## 8 Estructuras de control. Investigue la sintaxis de las siguientes estructuras de control incluidas en shell scripting: 
- if 
- case 
- while 
- for 
- select 

- **if**: Permite ejecutar un bloque de código si una condición es verdadera.
```bash
if [ condición ]; then
    # código a ejecutar si la condición es verdadera
elif [ otra_condición ]; then
    # código a ejecutar si la otra condición es verdadera
else
    # código a ejecutar si ninguna condición es verdadera
fi
```
- **case**: Permite ejecutar diferentes bloques de código basados en el valor de una variable.
```bash
case $variable in
    valor1)
        # código para valor1
        ;;
    valor2)
        # código para valor2
        ;;
    *)
        # código para cualquier otro valor
        ;;
esac
```

- **while**: Permite ejecutar un bloque de código repetidamente mientras una condición sea verdadera.
```bash
while [ condición ]; do
    # código a ejecutar mientras la condición sea verdadera
done
```

- **for**: Permite iterar sobre una lista de elementos y ejecutar un bloque de código para cada elemento.
```bash
for variable in lista; do
    # código a ejecutar para cada elemento en la lista
done
```

- **select**: Permite crear un menú interactivo para que el usuario seleccione una opción de una lista.
```bash
select variable in lista; do
    # código a ejecutar para la opción seleccionada
    break  # salir del bucle después de una selección
done
```
Ejemplo de uso de select:
```bash
#!/bin/bash
echo "Seleccione una opción:"
select opcion in "Opción 1" "Opción 2" "Salir"; do
    case $opcion in
        "Opción 1")
            echo "Ha seleccionado Opción 1"
            ;;
        "Opción 2")
            echo "Ha seleccionado Opción 2"
            ;;
        "Salir")
            echo "Saliendo..."
            break
            ;;
        *)
            echo "Opción no válida."
            ;;
    esac
done
```

## 9 ¿Que acciones realizan las sentencias break y continue dentro de un bucle? ¿Que parametros reciben?

- La sentencia `break` se utiliza para salir inmediatamente de un bucle (como `for`, `while`, o `select`). Cuando se encuentra una sentencia `break`, la ejecución del bucle se detiene y el control se transfiere a la primera línea de código después del bucle. No recibe parámetros.

- La sentencia `continue` se utiliza para saltar a la siguiente iteración de un bucle. Cuando se encuentra una sentencia `continue`, el resto del código dentro del bucle para esa iteración se omite, y la ejecución continúa con la siguiente iteración del bucle. Tampoco recibe parámetros.

## 10 ¿Que tipo de variables existen? ¿Es sheel script fuertemente tipado? ¿Se pueden definir arreglos? ¿Como?

- En shell scripting, existen principalmente dos tipos de variables: variables de cadena (string) y variables numéricas (integer). Sin embargo, shell scripting no es un lenguaje fuertemente tipado, lo que significa que las variables no tienen un tipo fijo y pueden contener diferentes tipos de datos en diferentes momentos.

- Sí, se pueden definir arreglos en shell scripting. Los arreglos se definen utilizando paréntesis y los elementos se separan por espacios. Los elementos del arreglo se acceden mediante índices numéricos.
```bash
# Definición de un arreglo
mi_arreglo=("elemento1" "elemento2" "elemento3")
```

## 11 ¿Pueden definirse funciones dentro de un script bash? ¿Como? ¿Como se maneja el pasaje de parametros de una funcion a la otra?

- Sí, se pueden definir funciones dentro de un script bash. La sintaxis para definir una función es la siguiente:
```bash
mi_funcion() {
    # código de la función
}
```
- El pasaje de parámetros a una función se maneja de manera similar al pasaje de parámetros a un script. Los parámetros se acceden dentro de la función utilizando `$1`, `$2`, etc., donde `$1` es el primer parámetro, `$2` es el segundo, y así sucesivamente.
```bash
mi_funcion() {
    echo "Primer parámetro: $1"
    echo "Segundo parámetro: $2"
}
# Llamada a la función con parámetros
mi_funcion "valor1" "valor2"
```
## 12 Evaluacion de expresiones 
a. Realizar un script que le solicite al usuario 2 numero, los lea de la entrada strandard e imprima la multipliacion, suma, resta y cual es el mayor de los numero leidos.
```bash
#!/bin/bash
echo "Ingrese el primer número:"
read num1
echo "Ingrese el segundo número:"
read num2
suma=$(expr $num1 + $num2)
resta=$(expr $num1 - $num2)
multiplicacion=$(expr $num1 \* $num2)
echo "Suma: $suma"
echo "Resta: $resta"
echo "Multiplicación: $multiplicacion"
if ((num1 > num2)); then
    echo "El mayor es: $num1"
else
    echo "El mayor es: $num2"
fi
```

b. Modificar el script creado en el inciso anterior para que los numero sean recibidos como parametros. El script debe controlar que los dos parametros sean enviados.
```bash
#!/bin/bash
if [ $# -ne 2 ]; then
    echo "Error: Se requieren dos parámetros."
    exit 1
fi
num1=$1
num2=$2
suma=$(expr $num1 + $num2)
resta=$(expr $num1 - $num2)
multiplicacion=$(expr $num1 \* $num2)
echo "Suma: $suma"
echo "Resta: $resta"
echo "Multiplicación: $multiplicacion"
if ((num1 > num2)); then
    echo "El mayor es: $num1"
else
    echo "El mayor es: $num2"
fi
```
c. Realizar una calculadora que ejecute las 4 operaciones basicas +,-,*,%. Esta calculadora debe funcionar recibiendo la opreacion y los numeros como parametros.
```bash
#!/bin/bash
if (( $# != 3 )); then
    echo "Uso: $0 operacion num1 num2"
    echo "Operaciones: suma, resta, multiplicacion, division, modulo"
    exit 1
fi
operacion=$1
num1=$2
num2=$3
case $operacion in
    suma)
        resultado=$(expr $num1 + $num2)
        ;;
    resta)
        resultado=$(expr $num1 - $num2)
        ;;
    multiplicacion)
        resultado=$(expr $num1 \* $num2)
        ;;
    division)
        if [ $num2 -eq 0 ]; then
            echo "Error: División por cero."
            exit 1
        fi
        resultado=$(expr $num1 / $num2)
        ;;
    modulo)
        resultado=$(expr $num1 % $num2)
        ;;
    *)
        echo "Operación no válida. Use: suma, resta, multiplicacion, division, modulo"
        exit 1
        ;;
esac
echo "Resultado: $resultado"
```

## 13 Uso de la estructuras de control:
a. Realizar un script que visualice por pantalla los numero del 1 al 100 asi como sus cuadrados.
```bash
#!/bin/bash
for i in $(seq 1 100); do
    cuadrado=$(expr $i \* $i)
    echo "Número: $i, Cuadrado: $cuadrado"
done
```

b. Crear un script que muestre 3 opciones al usuario 1) LIstar, dondeEstoy y QuienEsta. Segun la opcione elegida se le debe mostrar:
- Listar: lista el contenido del directorio actual
- DondeEstoy: muestra la ruta del directorioa donde me encuentro ubicaado
- QuienEsta: Muestra los usuario conectados al sistema
```bash
#!/bin/bash
echo "Seleccione una opción:"
echo "1) Listar"
echo "2) DondeEstoy"
echo "3) QuienEsta"
read opcion
case $opcion in
    1)
        echo "Contenido del directorio actual:"
        ls
        ;;
    2)
        echo "Ruta del directorio actual:"
        pwd
        ;;
    3)
        echo "Usuarios conectados al sistema:"
        who
        ;;
    *)
        echo "Opción no válida."
        ;;
esac
```

## 14 Renombrando Archivos: haga un script que renombrer solo archivos de un directorio pasado como parametro, agregandole una CADENA, contemplando las opciones:
- "-a CADENA": Renombmra el fichero concatenando CADENA al final del nombre del archivo.
- "-b CADENA": Renombre el fichero concatenando CADENA al principio del nombre del archivo.

```bash
#!/bin/bash
if [ $# -ne 3 ]; then
    echo "Uso: $0 [-a|-b] CADENA DIRECTORIO"
    exit 1
fi

opcion=$1
cadena=$2
directorio=$3

if [ ! -d $directorio ]; then
    echo "Error: $directorio no es un directorio válido."
    exit 1
fi

for archivo in "$directorio"/*; do
    if [ -f "$archivo" ]; then
        nombre_archivo=$(basename "$archivo")
        case $opcion in
            -a)
                nuevo_nombre="${nombre_archivo}${cadena}"
                ;;
            -b)
                nuevo_nombre="${cadena}${nombre_archivo}"
                ;;
            *)
                echo "Opción no válida. Use -a o -b."
                exit 1
                ;;
        esac
        mv "$archivo" "$directorio/$nuevo_nombre"
        echo "Renombrado: $nombre_archivo -> $nuevo_nombre"
    fi
done
```
Sentencia mv para renombrar archivos. Se usa mv "archivo original" "nuevo nombre archivo".

## 15 El comando cut nos permite procesar las lineas de la entrada que recibe (archivo entrada estandar, resultado de otro comando, etc) y cortar columnas o campos, siendo posible indicar cual es el delimitador de las mismas. Investigue los parametros que puede recibir este comando y cite ejemplos de uso.

- El comando `cut` se utiliza para extraer secciones específicas de cada línea de un archivo o de la entrada estándar. Los parámetros más comunes que puede recibir incluyen:

  - `-d DELIMITADOR`: Especifica el delimitador que separa los campos en la línea. Por defecto, el delimitador es una tabulación.
  
  - `-f LISTA_DE_CAMPOS`: Especifica qué campos (columnas) se deben extraer. Los campos se numeran comenzando desde 1. Se pueden especificar campos individuales, rangos (por ejemplo, `1-3`), o listas separadas por comas (por ejemplo, `1,4,5`).
  
  - `-c LISTA_DE_CARACTERES`: Especifica qué caracteres se deben extraer de cada línea.

**Ejemplos de uso:**
```bash
# Extraer el primer campo de un archivo separado por comas
cut -d ',' -f 1 archivo.txt
# Extraer los campos 1 a 3 de un archivo separado por tabulaciones
cut -f 1-3 archivo.txt
# Extraer los caracteres 1 a 5 de cada línea
cut -c 1-5 archivo.txt
# Extraer el segundo campo de la salida del comando ls -l
ls -l | cut -d ' ' -f 2
```

## 16 Relizar un script que reciba como parametro una extension y haga un reporte con 2 columnas, el nombre de usuario y la cantidad de archivos que posee con esa extension. Se debe guaradar el resultado en un archivo llamado reporte.txt

```bash
#!/bin/bash
if [ $# -ne 1 ]; then
    echo "Uso: $0 EXTENSION"
    exit 1
fi

extension=$1
echo "Usuario Cantidad_de_Archivos" > reporte.txt
for usuario in $(cut -d: -f1 /etc/passwd); do
    cantidad=$(find /home/$usuario -type f -name "*.$extension" | wc -l)
    if [ $cantidad -gt 0 ]; then
        echo "$usuario $cantidad" >> reporte.txt
    fi
done
echo "Reporte generado en reporte.txt"
```

## 17 Escribir un script que al ejecutarse imprima en pantalla los nombre de los archivos que se encuentran en el directorio actual, intercambiando minusculas por mayusculas, ademas de eliminar la letra a mayuscula o minuscula. Por ejemplo si en el directorio actual estan los siguientes archivos:
- IsO
- pepE
- Maria
y ejecuto ./ejericio17 , se obtendra como resultado:
- iSo
- PEPe
- mRI

```bash
#!/bin/bash
for archivo in *; do
    if [ -f "$archivo" ]; then
        nuevo_nombre=$(echo "$archivo" | tr 'A-Za-z' 'a-zA-Z' | tr -d 'aA')
        echo "$nuevo_nombre"
    fi
done
```

Comando TR: se utiliza para traducir o eliminar caracteres de la entrada estándar. En este caso, se usa para intercambiar mayúsculas y minúsculas y eliminar la letra 'a' o 'A'.
Se usa de la suiguiente manera:
```bash
#Pasa de mayusculas a minusculas
echo "Texto" | tr 'A-Z' 'a-z'
#Pasa de minusculas a mayusculas
echo "Texto" | tr 'a-z' 'A-Z'
#Ejemplos combinados
echo "Texto" | tr 'A-Za-z' 'a-zA-Z'  # Intercambia mayúsculas y minúsculas
echo "Texto" | tr -d 'aA'            # Elimina las letras 'a' y 'A'
```

## 18 Crear un script que verifique cada 10 segundos si un usuario se ha logueado en el sistema (el nombre del usuario será pasado por parámetro). Cuando el usuario finalmente se loguee, el programa deberá mostrar el mensaje ”Usuario XXX logueado en el sistema” y salir.

```bash
#!/bin/bash
if [ $# -ne 1 ]; then
    echo "Uso: $0 NOMBRE_USUARIO"
    exit 1
fi

usuario=$1
while true; do
    if who | grep -q "^$usuario "; then
        echo "Usuario $usuario logueado en el sistema"
        exit 0
    fi
    sleep 10
done
```
grep comando se utiliza para buscar patrones en el texto. En este caso, se usa para verificar si el usuario especificado está logueado en el sistema. grep -q suprime la salida y solo devuelve el estado de salida, lo que es útil para condicionales.

## 19 Escribir un Programa de “Menu de Comandos Amigable con el Usuario” llamado menú, el cual, al ser invocado, mostrará un menú con la selección para cada uno de los scripts creados en esta práctica. Las instrucciones de cómo proceder deben mostrarse junto con el menú. El menú deberá iniciarse y permanecer activo hasta que se seleccione Salir. 
aritmetica.sh   cuadrados.sh  ejercicio18  mostrar.sh            punto13.sh    reporte.sh   testExpresion.sh
calculadora.sh  ejercicio17   ficheros     mostrarModificado.sh  renombrar.sh  reporte.txt

```bash
#!/bin/bash
while true; do
    clear # Limpia la pantalla para que se vea ordenado
    echo "=========================================="
    echo "   MENÚ DE COMANDOS AMIGABLE CON EL USUARIO"
    echo "=========================================="
    echo "1) Mostrar fecha y hora (mostrar.sh)"
    echo "2) Mostrar modificado (mostrarModificado.sh)"
    echo "3) Calculadora (calculadora.sh)"
    echo "4) Aritmética (aritmetica.sh)"
    echo "5) Cuadrados (cuadrados.sh)"
    echo "6) Ejercicio 17"
    echo "7) Ejercicio 18 (Usuarios conectados)"
    echo "8) Renombrar archivos (renombrar.sh)"
    echo "9) Reporte de archivos (reporte.sh)"
    echo "10) Test Expresión (testExpresion.sh)"
    echo "11) Salir"
    echo "=========================================="
    echo -n "Seleccione una opción (1-11): "
    read opcion

    echo "" # Espacio estético

    case $opcion in
        1) 
            ./mostrar.sh 
            ;;
        2) 
            ./mostrarModificado.sh 
            ;;
        3) 
            echo ">> Ingrese la operación y dos números (ej: suma 10 5):"
            read params
            ./calculadora.sh $params
            ;;
        4) 
            # Asumiendo que aritmetica.sh no pide params o son interactivos
            ./aritmetica.sh 
            ;;
        5) 
            ./cuadrados.sh 
            ;;
        6) 
            ./ejercicio17 
            ;;
        7) 
            echo ">> Ingrese el usuario a verificar (o deje vacío para actual):"
            read usuario
            ./ejercicio18 $usuario
            ;;
        8) 
            echo ">> Ingrese cadena y directorio (ej: _backup /home/elian):"
            read params
            ./renombrar.sh $params
            ;;
        9) 
            echo ">> Ingrese la extensión a buscar (ej: txt):"
            read ext
            ./reporte.sh $ext
            ;;
        10) 
            echo ">> Ingrese la expresión a probar:"
            read expr
            ./testExpresion.sh $expr
            ;;
        11) 
            echo "Saliendo del sistema..."
            exit 0 
            ;;
        *) 
            echo "¡Opción incorrecta! Intente nuevamente." 
            ;;
    esac

    echo ""
    echo "Presione ENTER para volver al menú..."
    read # Pausa para que el usuario pueda ver el resultado antes de limpiar pantalla
done

```

## 20 Realice un script que simule el comportamiento de una estructura de PILA e implemente las siguientes funciones aplicables sobre una estructura global definida en el script: 
- push: agrega un elemento a la pila
- pop: elimina el elemento superior de la pila
- length: devuelve la cantidad de elementos en la pila
- print: muestra todos los elementos de la pila

```bash
#!/bin/bash
pila=()
push() {
    pila+=("$1")
    echo "Elemento '$1' agregado a la pila."
}
pop() {
    if [ ${#pila[@]} -eq 0 ]; then
        echo "La pila está vacía. No se puede eliminar ningún elemento."
    else
        elemento="${pila[-1]}"
        unset pila[-1]
        echo "Elemento '$elemento' eliminado de la pila."
    fi
}
length() {
    echo "Cantidad de elementos en la pila: ${#pila[@]}"
}
print() {
    if [ ${#pila[@]} -eq 0 ]; then
        echo "La pila está vacía."
    else
        echo "Elementos en la pila:"
        for elemento in "${pila[@]}"; do
            echo "$elemento"
        done
    fi
}
while true; do
    echo "Seleccione una opción:"
    echo "1) Push"
    echo "2) Pop"
    echo "3) Length"
    echo "4) Print"
    echo "5) Salir"
    read opcion
    case $opcion in
        1)
            echo "Ingrese el elemento a agregar:"
            read elemento
            push "$elemento"
            ;;
        2)
            pop
            ;;
        3)
            length
            ;;
        4)
            print
            ;;
        5)
            echo "Saliendo..."
            exit 0
            ;;
        *)
            echo "Opción no válida."
            ;;
    esac
    echo ""
done
```

## 21 Dada la siguiente declaración al comienzo de un script:
num=(10 3 5 7 9 3 5 4) (la cantidad de elementos del arreglo puede variar).

Implemente la función productoria dentro de este script, cuya tarea sea multiplicar
todos los números que el arreglo contiene.

```bash
#!/bin/bash
num=(10 3 5 7 9 3 5 4)

productoria() {
    producto=1
    for valor in "${num[@]}"; do
        producto=$((producto * valor))
    done
    echo "El producto de todos los números es: $producto"
}

productoria
```

## 22  Implemente un script que recorra un arreglo compuesto por números e imprima en pantalla sólo los números pares y que cuente sólo los números impares y los informe en pantalla al finalizar el recorrido.

```bash
#!/bin/bash
arreglo=(10 3 5 7 9 3 5 4)

impares=0
for num in "${arreglo[@]}"; do 
    if [ $((num % 2)) == 0 ]; then 
        echo "Numero par: $num"
    else 
        impares=$((impares + 1))
    fi 
done
echo "Imapres: $impares"
```

## 23 Dada la definición de 2 vectores del mismo tamaño y cuyas longitudes no se conocen. vector1=( 1 .. N) vector2=( 1.. N) Por ejemplo: vector1=( 1 80 65 35 2 ) y vector2=( 5 98 3 41 8 ). Complete este script de manera tal de implementar la suma elemento a elemento entre ambos vectores y que la misma sea impresa en pantalla de la siguiente manera:
➢ La suma de los elementos de la posición 0 de los vectores es 6
➢ La suma de los elementos de la posición 1 de los vectores es 178 ...
➢ La suma de los elementos de la posición 4 de los vectores es 10

```bash
#!/bin/bash
vector1=(1 80 65 35 2)
vector2=(5 98 3 41 8)
tamaño=${#vector1[@]}
for (( i=0; i<tamaño; i++ )); do
    suma=$((vector1[i] + vector2[i]))
    echo "La suma de los elementos de la posición $i de los vectores es $suma"
done
```
Si se reciben los vectores como parametros:
```bash
#!/bin/bash
vector1=($1)
vector2=($2)
tamaño=${#vector1[@]}
for (( i=0; i<tamaño; i++ )); do
    suma=$((vector1[i] + vector2[i]))
    echo "La suma de los elementos de la posición $i de los vectores es $suma"
done
```

## 24 Realice un script que agrege un arreglo a todos los nombres de los usuarios del sistema pertenecientes al grupo "users". Adicionalmente, el script puede recibir como paramero:
- "-b n”: Retorna el elemento de la posición n del arreglo si el mismo existe. Caso contrario, un mensaje de error.
- “-l”: Devuelve la longitud del arreglo
- “-i”: Imprime todos los elementos del arreglo en pantalla

```bash
#!/bin/bash
arreglo=("elemento1" "elemento2" "elemento3" "elemento4")
grupo="users"
if [ $# -eq 0 ]; then
    for usuario in $(getent group $grupo | cut -d: -f4 | tr ',' ' '); do
        for elemento in "${arreglo[@]}"; do
            echo "Usuario: $usuario, Elemento: $elemento"
        done
    done
else
    case $1 in
        -b)
            if [ $# -ne 2 ]; then
                echo "Uso: $0 -b n"
                exit 1
            fi
            index=$2
            if [ $index -ge 0 ] && [ $index -lt ${#arreglo[@]} ]; then
                echo "Elemento en la posición $index: ${arreglo[$index]}"
            else
                echo "Error: La posición $index no existe en el arreglo."
            fi
            ;;
        -l)
            echo "Longitud del arreglo: ${#arreglo[@]}"
            ;;
        -i)
            echo "Elementos del arreglo:"
            for elemento in "${arreglo[@]}"; do
                echo "$elemento"
            done
            ;;
        *)
            echo "Opción no válida."
            ;;
    esac
fi
```

## 25 Escriba un script que reciba una cantidad desconocida de parámetros al momento de su invocación (debe validar que al menos se reciba uno). Cada parámetro representa la ruta absoluta de un archivo o directorio en el sistema. El script deberá iterar por todos los parámetros recibidos, y solo para aquellos parámetros que se encuentren en posiciones impares (el primero, el tercero, el verificar si el archivo o directorio existen en el sistema, imprimiendo en pantalla que tipo de objeto es (archivo o directorio). Además, deberá informar la cantidad de archivos o directorios inexistentes en el sistema.

```bash
#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Error: Se requiere al menos un parámetro."
    exit 1
fi

inexistentes=0
for (( i=1; i<=$#; i+=2 )); do
    ruta=${!i}
    if [ -e "$ruta" ]; then
        if [ -f "$ruta" ]; then
            echo "$ruta es un archivo."
        elif [ -d "$ruta" ]; then
            echo "$ruta es un directorio."
        fi
    else
        echo "$ruta no existe."
        inexistentes=$((inexistentes + 1))
    fi
done
echo "Cantidad de archivos o directorios inexistentes: $inexistentes"
```

## 26 . Realice un script que implemente a través de la utilización de funciones las operaciones básicas sobre arreglos:
➢ inicializar: Crea un arreglo llamado array vacío
➢ agregar_elem <parametro1>: Agrega al final del arreglo el parámetro
recibido
➢ eliminar_elem <parametro1>: Elimina del arreglo el elemento que se
encuentra en la posición recibida como parámetro. Debe validar que
se reciba una posición válida
➢ longitud: Imprime la longitud del arreglo en pantalla
➢ imprimir: Imprime todos los elementos del arreglo en pantalla
➢ inicializar_Con_Valores <parametro1><parametro2>: Crea un arreglo
con longitud <parametro1>y en todas las posiciones asigna el valor
<parametro2>

```bash
#!/bin/bash
array=()
inicializar() {
    array=()
    echo "Arreglo inicializado."
}
agregar_elem() {
    array+=("$1")
    echo "Elemento '$1' agregado al arreglo."
}
eliminar_elem() {
    if [ $1 -ge 0 ] && [ $1 -lt ${#array[@]} ]; then
        unset array[$1]
        echo "Elemento en la posición $1 eliminado."
    else
        echo "Error: Posición inválida."
    fi
}
longitud() {
    echo "Longitud del arreglo: ${#array[@]}"
}
imprimir() {
    echo "Elementos del arreglo:"
    for elemento in "${array[@]}"; do
        echo "$elemento"
    done
}
inicializar_Con_Valores() {
    local longitud=$1
    local valor=$2
    array=()
    for (( i=0; i<longitud; i++ )); do
        array+=("$valor")
    done
    echo "Arreglo inicializado con $longitud elementos, todos con el valor '$valor'."
}

# Ejemplo de uso de las funciones
inicializar
agregar_elem "valor1"
agregar_elem "valor2"
imprimir
longitud
eliminar_elem 0
imprimir
longitud
inicializar_Con_Valores 5 "default"
imprimir
longitud
```

## 27  Realice un script que reciba como parámetro el nombre de un directorio. Deberá validar que el mismo exista y de no existir causar la terminación del script con código de error 4. Si el directorio existe deberá contar por separado la cantidad de archivos que en él se encuentran para los cuales el usuario que ejecuta el script tiene permiso de lectura y escritura, e informar dichos valores en pantalla. En caso de encontrar subdirectorios, no deberán procesarse, y tampoco deberán ser tenidos en cuenta para la suma a informar

```bash
#!/bin/bash
if [ $# -ne 1 ]; then
    echo "Uso: $0 DIRECTORIO"
    exit 1
fi
directorio=$1
if [ ! -d "$directorio" ]; then
    echo "Error: El directorio $directorio no existe."
    exit 4
fi
lectura=0
escritura=0
for archivo in "$directorio"/*; do
    if [ -f "$archivo" ]; then
        if [ -r "$archivo" ]; then
            lectura=$((lectura + 1))
        fi
        if [ -w "$archivo" ]; then
            escritura=$((escritura + 1))
        fi
    fi
done

echo "Cantidad de archivos con permiso de lectura: $lectura"
echo "Cantidad de archivos con permiso de escritura: $escritura"
```

## 28 Implemente un script que agregue a un arreglo todos los archivos del directorio /home cuya terminación sea .doc. Adicionalmente, implemente las siguientes funciones que le permitan acceder a la estructura creada:
➢ verArchivo <nombre_de_archivo>: Imprime el archivo en pantalla si el
mismo se encuentra en el arreglo. Caso contrario imprime el mensaje
de error “Archivo no encontrado” y devuelve como valor de retorno 5
➢ cantidadArchivos: Imprime la cantidad de archivos del /home con
terminación .doc
➢ borrarArchivo <nombre_de_archivo>: Consulta al usuario si quiere
eliminar el archivo lógicamente. Si el usuario responde Si, elimina el
elemento solo del arreglo. Si el usuario responde No, elimina el
archivo del arreglo y también del FileSystem. Debe validar que el
archivo exista en el arreglo. En caso de no existir, imprime el mensaje
de error “Archivo no encontrado” y devuelve como valor de retorno 10

```bash
#!/bin/bash
arreglo=()
for archivo in /home/*.doc; do
    if [ -f "$archivo" ]; then
        arreglo+=("$archivo")
    fi
done

verArchivo() {
    local nombre_archivo="$1"
    for archivo in "${arreglo[@]}"; do
        if [ "$(basename "$archivo")" == "$nombre_archivo" ]; then
            cat "$archivo"
            return 0
        fi
    done
    echo "Archivo no encontrado"
    return 5
}

cantidadArchivos() {
    echo "Cantidad de archivos .doc en /home: ${#arreglo[@]}"
}

borrarArchivo() {
    local nombre_archivo="$1"
    for i in "${!arreglo[@]}"; do
        if [ "$(basename "${arreglo[i]}")" == "$nombre_archivo" ]; then
            echo "¿Desea eliminar el archivo lógicamente? (Si/No)"
            read respuesta
            if [ "$respuesta" == "Si" ]; then
                unset arreglo[i]
                echo "Archivo eliminado del arreglo."
            elif [ "$respuesta" == "No" ]; then
                rm "${arreglo[i]}"
                unset arreglo[i]
                echo "Archivo eliminado del arreglo y del FileSystem."
            else
                echo "Respuesta no válida."
            fi
            return 0
        fi
    done
    echo "Archivo no encontrado"
    return 10
}
```

## 29 Realice un script que mueva todos los programas del directorio actual (archivos ejecutables) hacia el subdirectorio “bin” del directorio HOME del usuario actualmente logueado. El script debe imprimir en pantalla los nombres de los que mueve, e indicar cuántos ha movido, o que no ha movido ninguno. Si el directorio “bin” no existe,deberá ser creado.

```bash
#!/bin/bash
directorio_bin="$HOME/bin"
if [ ! -d "$directorio_bin" ]; then
    mkdir "$directorio_bin"
    echo "Directorio $directorio_bin creado."
fi
contador=0
for archivo in *; do
    if [ -f "$archivo" ] && [ -x "$archivo" ]; then
        mv "$archivo" "$directorio_bin/"
        echo "Movido: $archivo"
        contador=$((contador + 1))
    fi
done
if [ $contador -eq 0 ]; then
    echo "No se ha movido ningún archivo."
else
    echo "Total de archivos movidos: $contador"
fi
```
## 30 Implemente la estructura de datos Set (Conjunto de valores) en Bash. Un conjunto se define como una colección de valores únicos, es decir que solo almacena una vez cada valor, aún cuando se intente agregar el mismo valor más de una vez. La implementación debe soportar las siguientes operaciones
mediante funciones:
● initialize - inicializa el set vacío.
● initialize_with - inicializa el set con un conjunto de valores que recibe como
argumento (debe validar que se reciba al menos uno).
● add - Agrega un valor al conjunto, el cual recibe como argumento. No debe
agregar elementos repetidos. El resultado de la operación será un éxito solo si el
valor puede ser agregado al conjunto.
● remove - Elimina uno o más valores del conjunto, los cuales recibe como
argumentos. Si la operación elimina al menos un valor, se considera un éxito.
● contains - Chequea si el conjunto contiene un valor recibido como argumento. El
resultado será éxito si el valor está en el conjunto.
● print - Imprime los elementos del conjunto, de a uno por línea.
● print_sorted - Imprime los elementos del conjunto, de a uno por línea y
ordenados alfabéticamente. Tip: Investigar cómo combinar el comando sort con la
función print.

```bash
#!/bin/bash
set=()
initialize() {
    set=()
    echo "Set inicializado vacío."
}
initialize_with() {
    if [ $# -eq 0 ]; then
        echo "Error: Se requiere al menos un valor para inicializar."
        return 1
    fi
    set=()
    for valor in "$@"; do
        add "$valor"
    done
    echo "Set inicializado con valores."
}
add() {
    local valor="$1"
    for elemento in "${set[@]}"; do
        if [ "$elemento" == "$valor" ]; then
            echo "El valor '$valor' ya existe en el set. No se agregó."
            return 1
        fi
    done
    set+=("$valor")
    echo "Valor '$valor' agregado al set."
}
remove() {
    local eliminado=0
    for valor in "$@"; do
        for i in "${!set[@]}"; do
            if [ "${set[i]}" == "$valor" ]; then
                unset set[i]
                eliminado=1
                echo "Valor '$valor' eliminado del set."
            fi
        done
    done
    if [ $eliminado -eq 1 ]; then
        return 0
    else
        echo "Ningún valor eliminado."
        return 1
    fi
}
contains() {
    local valor="$1"
    for elemento in "${set[@]}"; do
        if [ "$elemento" == "$valor" ]; then
            echo "El set contiene el valor '$valor'."
            return 0
        fi
    done
    echo "El set no contiene el valor '$valor'."
    return 1
}
print() {
    echo "Elementos del set:"
    for elemento in "${set[@]}"; do
        echo "$elemento"
    done
}
print_sorted() {
    echo "Elementos del set ordenados:"
    for elemento in "${set[@]}"; do
        echo "$elemento"
    done | sort
}
```

En un script separado, incorporar y utilizar las funciones implementadas para
desarrollar un juego de bingo. El bingo deberá generar números aleatorios dentro de
un rango entre 0 y un valor máximo que puede especificarse mediante un argumento
del script, de manera opcional. El valor máximo no puede ser 0 ni superior a 32767, y en
caso de no especificarse se tomará como valor por defecto 99. En cada ronda se
generará un nuevo número que ya no haya sido utilizado y se lo cantará, imprimiendo
en la salida estándar. Luego de esto, se esperará entrada del usuario para saber si se
debe cantar “BINGO” para finalizar la partida o se debe cantar un nuevo numero. Al
finalizar, el script debera imprimir en orden los números se cantaron hasta que se
produjo el bingo.
Tip: Investigar la variable de entorno $RANDOM de Bash para obtener valores aleatorios.

```bash
#!/bin/bash
# Incluir las funciones del Set
source ./set.sh
maximo=99
if [ $# -eq 1 ]; then
    maximo=$1
    if [ $maximo -le 0 ] || [ $maximo -gt 32767 ]; then
        echo "Error: El valor máximo debe ser mayor que 0 y menor o igual a 32767."
        exit 1
    fi
fi

initialize
cantar_numero() {
    while true; do
        numero=$((RANDOM % (maximo + 1)))
        if ! contains "$numero" > /dev/null; then
            add "$numero"
            echo "Número cantado: $numero"
            return
        fi
    done
}

while true; do
    cantar_numero
    echo "¿Cantar BINGO? (Si/No)"
    read respuesta
    if [ "$respuesta" == "Si" ]; then
        echo "¡BINGO!"
        break
    fi
done

print_sorted
```

## 31 Realice un script que reciba como argumento una lista de posibles nombres de usuarios del sistema y, para cada uno de los que efectivamente existan en el sistema y posean un directorio personal configurado que sea válido, realice las modificaciones necesarias en su directorio personal para que tenga un subdirectorio llamado “directorio_iso” con la siguiente estructura:
directorio_iso
├── 2025
│ ├── 01
│ │ └── archivo.txt
│ ├── 02
│ │ └── archivo.txt
│ ├── 03
│ │ └── archivo.txt
│ ├── 04
│ │ └── archivo.txt
│ ├── 05
│ │ └── archivo.txt
│ ├── 06
│ │ └── archivo.txt
│ ├── 07
│ │ └── archivo.txt
│ ├── 08
│ │ └── archivo.txt
│ ├── 09
│ │ └── archivo.txt
│ ├── 10
│ │ └── archivo.txt
│ ├── 11
│ │ └── archivo.txt
│ └── 12
│ └── archivo.txt
└── 2026
├── 01
│ └── archivo.txt
├── 02
│ └── archivo.txt
├── 03
│ └── archivo.txt
├── 04
│ └── archivo.txt
├── 05
│ └── archivo.txt
├── 06
│ └── archivo.txt
├── 07
│ └── archivo.txt
├── 08
│ └── archivo.txt
├── 09
│ └── archivo.txt
├── 10
│ └── archivo.txt
├── 11
│ └── archivo.txt
└── 12
└── archivo.txt

Para resolver la creación de los directorios y archivos utilice la
funcionalidad “Brace Expansion” brindada por bash

```bash
#!/bin/bash

if [ $# -lt 1 ]; then
    echo "Uso: $0 usuario1 [usuario2 ... usuarioN]"
    exit 1
fi

for usuario in "$@"; do
    home_dir=$(getent passwd "$usuario" | cut -d: -f6)
    if [ -d "$home_dir" ]; then
        dir_iso="$home_dir/directorio_iso"
        mkdir -p "$dir_iso"/{2025,2026}/{01..12}
        for year in 2025 2026; do
            for month in {01..12}; do
                touch "$dir_iso/$year/$month/archivo.txt"
            done
        done
        echo "Estructura creada para el usuario: $usuario"
    else
        echo "El usuario $usuario no existe o no tiene un directorio personal válido."
    fi
done
```