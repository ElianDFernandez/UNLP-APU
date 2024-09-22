# Problema 3:contratos
***

## Frente

#### ID: 
Confeccionar minuta.
#### Titulo: 
Como empleado de la mesa de entrada, quiero confeccionar una minuta para que la empresa pueda contratar al personal.
#### Reglas de negocio: 
* Montos no pueden superar los $25000 
* Duracion maxima 6 meses

***

## Dorso

#### Criterios de aceptacion

**Escenario 1:** Confeccion exitosa.
Dado que el monto es de 23000 pesos y la duracion es de 5 meses.
Cuando el empleado de mesa de entrada cargue nombre: 'Pepe', cuit:'9912399', tipo de contrado: 'abc', fecha de comienzo: '12/10/2093', duracion: 5 meses, monto: 23000 pesos.
Entonces el sistema le asocia un numero de minuta y la almacena con exito.

**Escenario 2:** Confeccion erronea por monto invalido. 
Dado que el monto es de 27000 pesos y la duracion es de 5 meses.
Cuando el empleado de mesa de entrada cargue nombre: 'Jose', cuit:'8977123', tipo de contrado: 'dgd', fecha de comienzo: '12/12/1234', duracion: 5 meses, monto: 27000 pesos.
Entonces el sistema informara que el monto ingresado supera el monto maximo.

**Escenario 3:** Confeccion erronea por duracion invalida.
Dado que el montos es de 23000 pesos y la duracion es de 7 meses.
Cuando el empleado de mesa de entrada cargue nombre: 'Elian', cuit:'1234', tipo de contrato:'avd', fecha de comiendo: '12/12/239', duracion 7 meses, monto: 23000 pesos.
Entonces el sistema informara que la duracion supera la duracion maxima.

***

***

## Frente

#### ID: 
Aprobar minuta.
#### Titulo: 
Como empleado de rendiciones, quiero evaluar una minuta para poder detemrinar su aprobacion.
#### Reglas de negocio: 
* Persona con menos de 3 minutas aprobadas
* Persona con CUIT habilitado por afip
* Establecer conexion con el servidor de afip

***
! Corregir lo de la conexion con la afip no queda claro como esta escrito

## Dorso

#### Criterios de aceptacion

**Escenario 1:** Aprobacion correcta de minuta
Dado que el numero de minuta '22' esta cargado en el sistema, y la persona tiene 2 minutas aprobadas y su CUIT esta habilitado por la AFIP con lo cual es posible la conexion al servidor.
Cuando el empleado de rendiciones ingrese el numero de minuta 22.
Entonces el sistema aprueba la minuta y se agrega a la lista de minutas aprobadas.

**Escemario 2:** Aprobacion fallida por minuta no existente
Dado que el numero de minuta '23' no esta cargado en el sistema, y la persona tiene 3 minutas aprobadas y su CUIT esta habilitado por la AFIP con lo cual es posible la conexion al servidor.
Cuando el empleado de rendiciones ingrese ele numero de minuta 23.
Entonces el sistema informara que la minuta es inexistente.

**Escenario 3:** Aprobacion fallida por CUIT inhabilitado por AFIP
Dado que el numero de minuta '22' esta cargado en el sitema, y la persona tiene 2 minutas aprobadas y su CUIT esta inhabilitado por la AFIP, con lo cual es posible la conexion al servidor.
Cuando el empleado de rendiciones ingrese el numero de minuta 22.
Entonces el sistema informara que el CUIT de la persona esta inahbilitado por la AFIP

**Escenario 4:** Aprobacion fallida por fallo de conexion con el servidor de la AFIP
Dado que el numero de minuta '22' esta cargado en el sistema y la persona tiene 2 minutas aprobadas y su CUIT por falla de conexion con el servidor de la AFIP no se puede corroborar.
CUando el empleado de rendiciones ingrese el numero de minuta 22.
Entonces el sistema informara que el CUIT no es posible verificar por fallo de conexion con el servidor de la AFIP.

**Escenario 5:** Aprobacion fallida por persona con 3 o mas minutas aprobadas
Dado que el numero de minuta '42' esta cargado en el sistema y la persona tiene 3 minutas aprobadas y si CUIT esta habilitado por lo cual es posible la conexcion al servidor.
Cuando el empleado de rendiciones ingresele el numero de minuta 42.
Entonces el sistema informara que la persona excede el limite de minutas aprobadas.

