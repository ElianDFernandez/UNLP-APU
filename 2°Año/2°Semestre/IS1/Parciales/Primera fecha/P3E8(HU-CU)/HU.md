# HU 
---
# Frente
**Id:** Reservar entradas de forma gratuita en persona.
**Titulo:** 
Como espectador,
Quiero que el vendedor ingrese mis datos y los de la función,
Para que pueda reservar hasta 2 entradas de forma gratuita.
**Reglas de negocio:**
* Solo se podra reservar hasta 2 entradas
* Las reservas solo se permiten si faltan más de tres horas para el inicio de la función.

# Dorso 
**Criterio de aprobacion:** (Reservar entradas)
* Escenario 1: Reserva de entradas exitosa de hasta 2 entradas
Dado que un vendedor en el teatro tiene un espectador con nombre 'Julieta' y DNI '3213213', que solicita dos entradas para una función disponible que se realiza en más de tres horas.
Cuando el vendedor selecciona desde la grilla de funciones la función deseada e ingresa el nombre 'Julieta' y el DNI '3213213'.
Entonces se registran las reservas en el sistema, y se confirma la asignación de las dos entradas.

* Escenario 2: Reserva fallida por mas de 2 entradas
Dado que un vendedor en el teatro tiene un espectador con nombre 'David' y DNI '132', que solicita tres entradas para una función disponible que se realiza en más de tres horas.
Cuando el vendedor selecciona desde la grilla de funciones la función deseada e ingresa el nombre 'David' y el DNI '132'.
Entonces el sistema informará que no se puede realizar una reserva de más de 2 entradas por persona.

* Escenario 3: Reserva fallida por menos de 3 horas de antelacion 
Dado que un vendedor en el teatro tiene un espectador con nombre 'Diego' y DNI '123', que solicita dos entradas para una función disponible que se realiza en menos de tres horas.
Cuando el vendedor selecciona desde la grilla de funciones la función deseada e ingresa el nombre 'Diego' y el DNI '123'.
Entonces el sistema informará que las reservas deben realizarse con al menos tres horas de antelación.
---

# Frente 
**Id:** Comprar una entrada.
**Titulo:** Como persona quiero comprar una entrada para poder ver la obra de teatro deseada.
**Reglas de negocio:**
* La compra puede realizarse a través de la página web o de manera personal en la boletería del teatro.

# Dorso 
**Criterios de aprobacion:** (Comprar una entrada)
* Escenario 1: Compra de entrada via web exitosa
Dado que una persona selecciona una obra de la grilla de funciones disponibles.
Cuando la persona ingrese su DNI '123', cantidad de lugares 2, y selecciones pagar.
Entnoces el sistema redirige al pago con tarjeta, cuando pago es autorizado, el sistema emite un codigo de compra para que el cliente pueda retirar sus entradas en la boleteria.

* Escenario 2: Compra de entrada en boleteria exitosa
Dado que una persona con DNI '321' solicita a un vendedor de una boleteria entradas para una funcion disponible.
Cuando el vendedor selecciona la función desde la grilla, ingresa el DNI de la persona y presiona pagar, solicita los datos de la tarjeta, numero de tarjeta, vencimiento y codigo de seguridad, para proceder con el pago.
Entonces el sistema redirige al pago con tarjeta, cuando el pago es autorizado, el sistema imprime las entradas.

* Escenario 3: Compra de entradas via web fallido por pago no realizado
Dado que un usuario selecciona una obra de la grilla de funciones disponibles.
Cuando la persona ingrese su DNI '444', cantidad de lugares 2, y selecciones pagar.
Entnoces el sistema redirige al pago con tarjeta, cuando el pago es rechazado, el sistema informa que no es posible realizar la compra por un fallo en el pago y no se emite el codigo de compra.

* Escenario 4: Compra de entrada en boleteria fallido por pago no realizado
Dado que una persona con DNI '1231' solicita a un vendedor de una boleteria entradas para una funcion disponible.
Cuando el vendedor selecciona la función desde la grilla, ingresa el DNI de la persona y presiona pagar, solicita los datos de la tarjeta, numero de tarjeta, vencimiento y codigo de seguridad, para proceder con el pago.
Entonces el sistema redirige al pago con tarjeta, cuando el pago es rechazado, el sistema informa que no es posible realizar la compra por un fallo en el pago y no se imprimen las entradas.
---

# Frente
**Id:** Pagar con tarjeta
**Titulo:** Como usuario quiero realizar un pago con tarjeta para poder realizar la compra de entradas
**Reglas de negocio:** 
* Solo se aceptan numero correspondientes a tarjetas de credito

# Dorso
**Criterios de aprobacion** (Pagar con tarjeta)
* Escenario 1: Pago exitoso 
Dado que la conexion con el sistema del banco es exitosa, y el numero de tarjeta '123' corresponde a una tarjeta de credito, su vencimento es '24/12' es valido, el codigo de seguridad es '321' y la tarjeta tiene saldo. 
Cuando el usuario ingresa el numero de '123', vencimiento '24/12', y el codigo de seguridad '321' y presione pagar.
Entonces el sistema del banco autoriza la tarjeta, realiza el pago, y el sistema informa que el pago fue exitoso.

* Escenario 2: Pago fallido por saldo insuficiente
Dado que la conexión con el sistema del banco es exitosa, pero la tarjeta de crédito '456' no tiene saldo suficiente para realizar la transacción.
Cuando el usuario ingrese el número de tarjeta '456', vencimiento '12/25', y código de seguridad '654' y presione pagar.
Entonces el sistema del banco rechaza el pago por saldo insuficiente, y el sistema informa al usuario que el pago no ha sido realizado por falta de fondos.

* Escenario 3: Pago fallido por datos incorrectos
Dado que la conexión con el sistema del banco es exitosa, pero el número de tarjeta '789', el vencimiento '11/23' o el código de seguridad '000' ingresados por el usuario no son válidos.
Cuando el usuario ingrese la información incorrecta en los campos de la tarjeta de crédito.
Entonces el sistema del banco rechaza la transacción debido a los datos incorrectos o tarjeta inválida, y el sistema del teatro informa al usuario que el pago no ha sido procesado, solicitando que verifique los datos y vuelva a intentarlo.

* Escenario 4: Pago fallido por conexion con el sistema del banco fallida
Dado que la conexión con el sistema del banco no es exitosa.
Cuando el usuario ingresa los datos de su tarjeta y presiona pagar.
Entonces el sistema no puede procesar la transacción debido a la falta de conexión con el banco, y muestra un mensaje de error indicando que no es posible realizar el pago en ese momento, pidiendo al usuario que lo intente más tarde.
---

# Frente 
**Id:** Retirar entradas reservadas.
**Titulo:** Como persona quiero comprar y retirar entradas reservadas previamente.
**Reglas de negocio:**
* Las entradas reservadas no compradas caducaran 3 horas antes del evento.

# Dorso
**Criterios de aprobacion:** (Retirar entradas reservadas)
* Escenario 1: Retiro exitoso de entradas reservadas
Dado que una persona con nombre 'Luke' y DNI '123' tiene reservadas 2 entradas no caducadas se presenta en boleteria para retirarlas.
Cuando el empleado solicite a la persona nombre y dni, y estos datos sean ingresados.
Entonces el sistema valida que las entradas no estan caducadas y el sistema redirigue a la compra de entradas (Comprar una entrada).

* Escenario 2: Retiro fallido por reserva inexistente
Dado que una persona con nombre 'Han' y DNI '321' no posee reservas.
Cuando el empleado solicite e ingrese los datos de la persona.
Entonces el sistema informara que la persona no posee ninguna reserva.

* Escenario 3: Retiro fallido por reservas caducadas
Dado que una persona con nombre 'Anakin' y DNI '333' tiene reservadas 2 entradas caducadas
se presenta en boleteria para retirarlas.
Cuando el empleado solicite a la persona nombre y dni e ingrese estos datos.
Entonces el sistema valida que las entradas estan caducadas,lo informa y no procede con el pago.
---

# Frente 
**Id:** Retirar entradas compradas via web
**Titulo:** Como persona quiero retirar entradas previamente compradas via web para poder ver la obra
**Reglas de negocio:** ---

# Dorso 
**Criterios de aprobacion:**  (Retirar entradas compradas via web) 
* Escenario 1: Retiro exitoso de entradas
Dado que un cliente llega a la boletería con un código de compra válidom y el sistema valida que el código corresponde a una compra efectuada.
Cuando el empleado ingresa el código de compra en el sistema.
Entonces el sistema imprime las entradas correspondientes para el cliente.

* Escenario 2: Código de compra inválido
Dado que un cliente llega a la boletería con un código de compra que no existe.
Cuando el empleado ingresa el código de compra en el sistema.
Entonces el sistema muestra un mensaje de error indicando que el código de compra es inválido.

* Escenario 3: Entradas no disponibles
Dado que un cliente llega a la boletería con un código de compra válido y el sistema valida que las entradas ya han sido retiradas.
Cuando el empleado ingresa el código de compra en el sistema.
Entonces el sistema muestra un mensaje indicando que las entradas ya han sido retiradas.
---

# Frente 
**Id:** Administrar la programacion de las salas
**Titulo:** Como administrador quiero ingresar la distribucion semanal de las obras en las salas para que se encuentren disponibles en la grilla
**Reglas de negocio:** ---

# Dorso
**Criterios de aprobacion:** (Administrar la programacion de las salas)
* Escenario 1: Programación exitosa de una obra
Dado que un administrador selecciona una obra de teatro 'Romeo y Julieta' y asigna una sala y hora disponibles. 
Cuando el administrador guarda la programación. 
Entonces el sistema muestra la obra en la grilla de funciones y está disponible para la venta de entradas.

* Escenario 2: Programación fallida por conflicto de sala. 
Dado que un administrador selecciona la obra 'Hamlet' para la sala 1 a las 20:00, pero ya existe otra obra programada a esa hora en la misma sala. 
Cuando el administrador intenta guardar la programación. 
Entonces el sistema muestra un mensaje de error indicando que la sala ya está ocupada en ese horario.