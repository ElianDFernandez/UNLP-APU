# Historias de usuario
## Practica 3

### 1. Alquiler mobiliario

Historia a desarrollar 

Rol de usuarios: 
    - Usuario
    - Encargado
Historias de usuario: 
    - Alta de mobiliario (Gerente)
    - Realizar una reserva
    - Abonar alquiler 20%

    Id: Alta mobiliario 
    Titulo: Como encargado dar de alta un mobiliario
    Relgas de negocio: 
        - No pueden existir codigo de inventario repetidos y por el contrato de la franquicia, el precio deber cargarse en dolares.

    Criterios de aceptacion (Alta mobiliario)
    - Escenario 1: Alta mobiliario exitoso
        Dado: que se autentico en el sistema como encargado
        Cuando: Como encargado da de alta un mobiliario, con codigo de inventario 1(no existe), tipo de mueble 1, fecha de creacion 20/12/2000, fecha de ultimo mantenimiento 28/08/2024, estado libre, y precio USD 200.
        Entonces: El sistema informa que se realizo con exito la alta.
    - Escenario 2: Alta mobiliario sin ser encargado
        Dado: que se autentico como usuario
        Cuando: Como usuario da de alta un mobiliario, Con codigo de inventario 1(no existe), tipo de mubele 1, fecha de creacion 20/12/2000, fecha de ultimo mantenimiento 27/02/2024, estado libre y precio USD 200.
        Entonces: El sistema informa que no se poseen los permisos para la alta de mobiliarios.
    - Escenario 3: Alta mobiliario con precio en pesos
        Dado: que se autentico como Encargado
        Cuando: Como usuario da de alta un mobiliario, Con codigo de inventario 1(no existe), tipo de mubele 1, fecha de creacion 20/12/2000, fecha de ultimo mantenimiento 27/02/2024, estado libre y precio pesos 200.000.
        Entonces: El sistema informa que no se puede registrar un precio de alquiler el pesos.
    - Escenario 4: Alta mobiliario con codigo repetido
        Dato: que se autentico como Encargado.
        Cuando: Como usuario da de alta un mobiliario, Con codigo de inventario 1(ya existe), tipo de mubele 1, fecha de creacion 20/12/2000, fecha de ultimo mantenimiento 27/02/2024, estado libre y precio pesos 200.000.
        Entonces: El sistema informa que no se puede ingresar un codigo de mobiliario ya existente.

    Id: Realizar una reserva
    Titulo: Como usuario realizar reserva
    Reglas de negocio: 
        - minimo de 3 muebles en la reserva

    Criterios de aceptacion (Realizar una reserva)
    - Escenario 1: Realizar una reserva exitosa
        Dado: que se autentico como usuario, y se obtuvo el listado de muebles disponible.
        Cuando: Como usuario cargo la reserva con fecha, lugar del evento, cantidad de dias y selecciono mas de 3 mobiliarios, y se realizo con exito el pago del 20% del alquiler.
        Entonces: El sistema informa que se realizo con exito la reserva, y se le muestra el numero de al cliente para abonar el alquiler.
    - Escenario 2: Realizar una reserva fallida por menos de 3 mubeles
        Dado: que se autentico como usuario, y se obtuvo el listado de muebles disponible.
        Cuando: Como usuario cargo la reserva con fecha, lugar del evento, cantidad de dias y selecciono menos de 3 mobiliarios,  y se realizo con exito el pago del 20% del alquiler.
        Entonces: El sistema informa la reserva deber ser de almenos 3 muebles.
    - Escenario 3: Realizar una reserva fellida por pago no exitoso
        Dado: que se autentico como usuario, y se obtuvo el listado de muebles disponible.
        Cuando: Como usuario cargo la reserva con fecha, lugar del evento, cantidad de dias y selecciono mas de 3 mobiliarios, y no se realizo con exito el pago del 20% del alquiler.
        Entonces: El sistema informa el error por que no se puedo realizar el pago.
    - Escenario 4: Realizar una reserva fallida por fecha invalida
        Dado: que se autentico como usuario, y se obtuvo el listado de muebles disponible.
        Cuando: Como usuario cargo la reserva con fecha (fecha no disponible para almenos un mueble), lugar del evento, cantidad de dias y selecciono mas de 3 mobiliarios, y se realizo con exito el pago del 20% del alquiler.
        Entonces: El sistema informa que almenos uno de los muebles no esta disponible para la fecha seleccionada.
    
    Id: Realizar un pago con tarjeta
    Titulo: Abona con tarjea de credito
    Reglas de negocio: 
        - Solo tarjeta de credito


    Criterios de aceptacion (Abonar alquiler 20%)
    - Escenario 1:  Pago exitoso
        Dado: que la conexión con el servidor del banco es exitosa, el número de tarjeta 1234 es válido (es Tarjeda de credito) y la tarjeta tiene saldo
        Cuando: el usuario ingresa el número de tarjeta 1234
        Entonces: el sistema registra el pago
    - Escenario 2:  Pago fallido por número de tarjeta inválido
        Dado: que la conexión con el servidor del banco es exitosa y el número 3456 es un número de tarjeta  invalido, 
        Cuando: el usuario ingresa el número de tarjeta 3456
        Entonces: el sistema informa que el número de tarjeta es inválido y no registra el pago
    - Escenario 3: Pago fallido por saldo insuficiente de tarjeta de crédito
        Dado: que la conexión con el servidor del banco es exitosa y el número de tarjeta 2134 es válido y  no tiene saldo
        Cuando: el usuario ingresa el número de tarjeta 2134
        Entonces: el sistema informa que la tarjeta no tiene saldo suficiente y no registra el pago
    - Escenario 4: Pago fallido por fallo en la conexión con el servidor externo del banco
        Dado: que no se pudo realizar la conexión con el servidor del banco
        Cuando: el usuario desea pagar
        Entonces: el sistema informa que no se puede establecer la conexión con el servidor