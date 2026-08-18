# SEMÁNTICA OPERACIONAL - PILA DE EJECUCIÓN CON PARÁMETROS

## Pasaje de Parámetros 

- El pasaje de parametros es el mas flexible y permite la transferencia de diferentes datos en cada llamda.
- Proporciona ventajas en legibilidad y modificabilidad.
- Nos permite compartir los datos en forma abstracta ya que indican con precision que es exactamente lo que se comparte.

### Evaluacion de los parametros reales y ligadura con los parametros formales
- Evaluacion:
  * En general en el momento de la invocacion primero se evalua los parametros reales y luego se hace la ligadura antes de transferir el control a la unidad de llamda.
- Ligadura:
  * Posicional: 
    - Se hace la ligadura de los parametros formales con los parametros reales en el orden en que aparecen.
  
  * Palabra clave o nombre: 
    - Se corresponden con el nombre por lo tanto pueden estar colocados en cualquier orden.

En ADA pueden mezclarse ambos metodos. En C++ y en ADA los parametros formales pueden tener valores por defecto, con lo cual a veces no es necesario listarlos todos en la invocacion.

### Clases de parametros: Datos y subprogramas

- Parametros de datos: 
    Hay diferentes formas de transmitir los parametros hacia y desde el programa llamado. 
    Desde el punto de vista semantico los parametros formales peuden ser:
    * Modo IN: El parametro formal recibe el dato desde el parametro real, pero no puede modificarlo.
    * Modo OUT: El parametro formal puede modificar el dato, pero no recibe ningun valor desde el parametro real.
    * Modo IN OUT: El parametro formal recibe el dato desde el parametro real y puede modificarlo.

Analizando desde el punto de vista de pilas de ejecucion:

* Modo IN: El parametro formal se copia en la pila de ejecucion y se pasa al subprograma. Al finalizar la invocacion el parametro formal se destruye y el parametro real no se modifica.

* Modo OUT (resultado proc): Se copia el valor del parámetro al desalocar el registro de memoria, en el registro que llamó al proc o fun.

* Modo OUT (resultado funcion): Se copia el valor del resultado de la función en el campo VR del registro llamador.
* Modo IN OUT (referencia): Se trabaja directamente sobre la variable referenciada

* Modo IN OUT (valor - resultado): Se copia al alocar el registro y se modifica el parámetro real al finalizar la ejecución de la rutina.

* Modo IN OUT (por nombre): El  parámetro  formal  es  sustituído textualmente por el parámetro real


 ## Ejercicio 6:

 Indique con un ejemplo el comportamiento del parametro por nombre (en el parametro formal) para los siguiente casos:
 a- un Valor entero
 b- una constante 
 c- un elemento de un arreglo
 d- una expresion

 Recordamos parametro por nombre: El parámetro formal es sustituído textualmente por el parámetro real.

 si el dato a compartir es un:
 - Valor entero: Se pasa el valor del entero, y se puede modificar dentro de la función, pero no afecta al valor original fuera de la función.
 - Constante: No se puede modificar dentro de la función, ya que es una constante. Es equivalente a por valor.
 - Elemento de un arreglo: Se pasa la referencia al elemento del arreglo, por lo que cualquier modificación dentro de la función afectará al elemento original del arreglo.
 - Expresión: Se evalúa cada vez. Es decir, el valor de la expresión se calcula en el momento de la invocación y se pasa a la función.

