# Problema 3:contratos

debera administrar los contratos realizado con terceros 

jefe de departamentos recibe listado del personal contratado

empleado mesa de entradas->minutas paso previo a contrato<- para ingresar minuta:

    nombre, cuit, tipo de contrato, fecha de comienzo, duracion y monto. El sistema asocia numero de minuta automaticamente.

    montos no puede superar los 25000 
    duracion maxima 6 meses 

minuta luego de confeccionarse queda pendiente de aprobacion 

empleado rendiciones -> puede aprobarla -> evaluar minutar 
    para aprobacion 
        numero de minuta el sistema muestra los datos de la misma 
        no se puede aprobar si:
            las persona tiene 3 ocntactos vigentes(minutas aprobadas)
            cuit inhabilitado por afip (verificaion en linea)

para realizar verificaion afip: 
    el sistema debe madnar un token y cuit si el token es correcto el servidor response si el cuita tea habilitado o no 

    emepleado rendiciones responsable de imprimir listado de minutas aprobadas es decir un listado con el personal contratado

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

## Dorso

#### Criterios de aceptacion

**Escenario 1** 