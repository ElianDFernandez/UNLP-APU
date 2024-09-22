# Biblioteca
***
## Frente
### Id: 
    Asociarse
### Titulo:
    Como alumno quiero asociarme a la biblioteca para pedir un prestamo de un libro.
## Reglas de negocio:
    * Presentar DNI y Certificado de alumno regular 
***
## Dorso
### Criterios de aceptacion:
**Escenario 1:** Alumno se asocia exitosamente
Dado que un alumno que presenta DNI '123123333', y certificado de alumno regular.
Cuando se ingresa al sistema estos datos.
Entonces el sistema genera el socio nuevo e informa el numero de socio.
**Escenario 2:** Alumno no se asocia exitosamente por fala de documentos
Dado que un alumno que presenta DNI '123321', y no posee certificado de alumno regular.
Cuando se ingresa al sistema estos datos.
Entonces el sistema informa que falta certificado de alumno regular.
***
***
## Frente 
### Id:
    Carga de libros
### Titulo:
    Como bibliotecaria quiero cargar un libro recibido en el sistema para que pueda prestarse.
### Reglas de negocio:
    * De un mismo libro se pueden tener varios ejemplares.
***
## Dorso* 
### Criterios de aprobacion:
**Escenario 1:** Carga de libro exitosa
Dado que la biliotecaria recibio un libro.
Cuando ingrese al sistema los datos del mimsmo.
Entonces el sistema buscara si ya existe un ejemplar del mismo, si existe simplemente asigna numero de ejemplar, si no lo agrega.
**Escenario 2:** Carga de libro fallida por datos incorrectos
Dado que la bibliotecaria recibió un libro.
Cuando ingrese al sistema los datos del mismo de manera incorrecta o incompleta.
Entonces el sistema mostrará un mensaje de error indicando que los datos son inválidos y no permitirá la carga del libro hasta que se corrijan los datos.
***
***
## Frente
### Id:
    Prestamo
### Titulo:
    Como alumno quiero realizar un prestamo
### Reglas de negocio:
    * El alumno debe estar asociado
    * No debe poseer mas de 3 prestamos
    * No debe tener prestamos vencidos
    * Libro deteriorado no se presto
    * El alumno no debe estar suspendido
***
## Dorso
### Criterios de aprobacion:
**Escenario 1:** Prestamo exitoso 
Dado que el alumno 'Pepito' esta asociado, posee 2 prestamos y que el libro 'Flores' copia '1' esta en condiciones para prestar.
Cuando la bibliotecaria ingresa estos datos, y el sistema verifica que el alumno no esta suspendido y no tiene ningun prestamo vencido.
Entonces el sistema registra el prestamo
**Escenario 2:** Prestamo no completado por Alumno no asociado
Dado que el alumno 'Dieguito' no esta asociado.
Cuando el alumno solicite el prestamo de cualquier libro.
El sistema informara que el alumno debe asociarse antes de realizar un prestamo.
**Escenario 3:** Prestamo no completado por exceder maximo de prestamos
Dado que el alumno 'Matias' esta asociado, tiene 3 prestamos y que el libro 'Gaturro' copia '1' esta en codiciones para prestar.
Cuando la biliotecaria ingresa estos datos y el sistema verifica que el alumno no esta suspendido y que no tiene ningun prestamos vencido.
Entonces el sistema informara que no se puede realizar el prestamos por exceder el maximo de prestamos permitidos.
**Escenario 4:** Prestamo no completado por tener prestamo vencido
Dado que el alumno 'Elian' esta asociado, tiene 2 prestamos y que el libro 'Eternauta' copia '2' esta en condiciones para prestar.
Cuando la bibliotecaria ingresa estos datos y el sisitema verifica que el alumno no esta suspendido y que tiene un prestamo vencido.
Entonces el sistema informara que el alumno posee un prestamo vencido y no se realiza el prestamo.
**Escenario 5:** Prestamos no completado por libro deteriorado
Dado que el alumno 'Gaston' esta asociado, tiene 2 prestamos y que el libro 'Sherlock Holmes' copia '3' no esta en codiciones para prestar.
Cuando la bibliotecaria ingresa estos datos y el sistema verifica que el alumno no esta suspendido y que no tiene ningun prestamo vencido.
Entonces el sistema infoarmara que el libro no esta en codiciones para realizar un prestamo.
**Escenario 6:** Prestamo no completado por alumno asociado suspendido
Dado que el alumno 'Marcos' esta asociado, pero esta suspendido.
Cuando el alumno solicite el prestamo de cualquier libro.
El sistema informara que el alumno se encuentra suspendido.
***
***
## Frente 
### Id:
    Devolucion
### Titulo:
    Como alumno devuelvo un libro el cual me fue prestado
### Reglas de negocio:
    * Verificar vencimiento del prestamo
    * Suspension de 15 dias si vencio
***
## Dorso
### Criterios de aprobacion:
**Escenario 1:** Devolucion exitosa
Dado que el alumno 'Diego' devuelve el libro 'Flores' dentro del tiempo del prestamo.
Cuando la bibliotecaria ingresa esta devolucion.
Entonces el sistema informa que la devolucion fue registrada.
**Escenario 2:** Devolucion con suspension 
Dado que el alumno 'Elian' devuelve el libro 'Eternauta' pasado el tiemmpo del prestamo.
Cuando la biliotecaria ingresa esta devolucion.
Entonces el sistema informa que la devolucion fue registrada y suspende al alumno asociado para no poder realizar un prestamo por 15 dias. 
***