Documentacion: https://github.com/Fabian-Martinez-Rincon/DBD/blob/main/Documentos/Teoria.md#entidad

# Modelo conceptual 

## ENTIDADES - RELACIONES - ATRIBUTOS
[<img src="https://concepto.de/wp-content/uploads/2018/04/base-de-datos-min-e1523470739502.jpg" height="150" width="100%"/>](base-de-datos.png)
## Entidad
Es un elemento u objeto del mundo real que queremos representar. Partimos de un problema/dominio, este va a 
tener distintos elementos/objetos a representar y los representamos en el modelo conceptual a partir de una entidad.

## Relacion
Es una asociacion entre dos o mas entidades. Partimos de una entidad y definimos una relacion entre esta y otras entidades.
Si une tres entidades relacion ternaria y asi sucesivamente. Puede ser una relacion recursiva.

**Cardinalidades en las relaciones**
Me indica el nivel de correspondencia que hay entre las dos entidades que une la relacion. Se debe definir el nivel minimo de 
correspondencia (cardinalidad minima), y el nivel maximo de correspondecia (cardinalidad maxima)
La cardinalidad minima, me indica que puede inscribirse a como minimo a 0 cursadas y como maximo N, es lo mismo de ambos lados.
Toda relacion tiene cardinalidad.

    Se define desde la entidad hacia la otra relacion. 
    Ejemplo: 

    |Alumnos| -(0,N)-----------------<Cursan>-----------------(0,N)- |Materias|

## Atributo
Un atributo representa una propiedad basica de una entidad o de una relacion.
* Atributos compuestos
    Un atributo compuesto representa a un atributo generado a partir de una combinacion de varios atributos simples
* Cardinalidades en los atributos
Los atributos, tienen asociado el concepto de cardinalidad. Cuando se define un atributo se debe indicar si es o no 
obligatorio y si puede tomar mas de un valor (Polivalente). En el primer parametro tenes la cardinalidad minima, 
y en segundo, tenes la cardinalidad maxima.

    * Cardinalidad (1,1) Monovalente obligatorio. La cardinalidad existe y esta presenta, pero solamente en este 
        momento, caso no se debe indicar en forma explicita.

    * Cardinalidad (0,1) Monovalente no obligatiorio, el '0' significa que puede tomar ningun valor

    * Cardinalidad (0, N) Polivalente no obligatorio

    * Cardinalidad (1, N) Polivalente Obligatorio

* Indentificadores 
A partir de claves univocas que identifican un atributo o una relacion.
Un atributo que no es obligatorio, y es Polivalente no puede ser clave univoca.
Son Monovalentes obligatorios.(Al menos en la catedra).
Ejemplo |Alumno|-• DNI
                -○ Nombre y Apellido
                -○ Numero de telefono
Simples y internos, simple por que no tiene atributos adicionales e internos por que pertenecen al atributo.
Ejemplo |Pedidos|-•-○ Numero de pedido
                    |
                    -•-○ Numero de pieza
                    -○ Cantidad

* Indentificador externo
Para tener un atributo identificador externo, si o si, las dos entidades tienen que estar relacionadas
Para que una entidad, pueda ser identificada, tiene que ser una entidad devil (tener cardinalidad 1,1)

# Gerarquias

* Generalizacion 
Cuando tenemos entidades que tienen caracteristicas y propiedades comunes, podemos crear una entidad padre 
que junte las caracteristicas comunes, y a partir de esa entidad padre, podemos generar varias entidades hijas. 
Cada atributo hijo puede tener sus propios atributos/relaciones.
Coberturas:

* (T, E) Total Esclusiva
* (T, S) Total SuperPuesta
* (P, E) Parcial Esclusiva
* (P, S) Parcial SuperPuesta

El primer parametro (T o P) lo que me esta indicando en el caso de que sea total es que no existe una persona que no sea (alumno, docente o graduado).
Si fuera parcial, lo que me esta indicando, es lo contrario, que la suma de los elementos de los hijos, no necesariamente dan la totalidad de los 
elementos del padre. Podrian haber personas que no sean (alumnos, docentes o graduados).
Segundo parametro (S o P), si es exclusiva, significa que los elementos en los hijos nunca se van a superponer, en este caso una persona es 
(o un alumno, o un docente, o un graduado, nunca una persona, puede ser las dos a la vez) que sea superpuesta, es lo contrario, una persona 
puede ser alumno, docente y graduado a la vez.

* Subconjuntos
    Caso especial de las jerarquias de generalizacion, donde se tiene una generalizacion de la que se desprende solamente una especializacion. 
    No es necesario indicar la cobertura para los subconjuntos.