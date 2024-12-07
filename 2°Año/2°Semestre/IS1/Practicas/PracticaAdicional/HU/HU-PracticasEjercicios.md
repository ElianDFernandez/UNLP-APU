# Historias de usuario

Estructura 
Frente 

Id: Identificador <verbo> <sustantivo>. Ejemplo Registrar Persona, Iniciar sesion, Publicar viaje.
Titulo: Como <rol> quiero <algo> para <beneficio>.
Reglas de negocio: Conjunto de reglas, normas, politicas, etc. Que condicionan el modo de operacion.

Dorso

Criterios de aprobacion: Criterios por los cuales una historia cumple con las expectativas del cliente.
Escenario 1: titulo del criterio 
    Dado<Un contexto incial>
    Cuando<Ocurre un evento>
    Entonces<Garantiza uno o mas resultado>
... 

## Practica 2. 
10.Un aventon
--------------
Frente 

Id: Registrar persona
Titulo: Como persona quiero registrar para utilizar la aplicacion de viajes
Reglas de negocio: 
* No puede haber dos correos electronicos iguales 

Dorso

Criterios de aprobacion:
Escenario 1: Registro de persona exitoso
Dado que el correo 'elianf321@gmail.com' no esta registrado en el sistema.
Cuando la persona ingrese el correo 'elianf321@gmail.com', nombre de usuario 'Elian', y contraseña '123'.
Entonces el sistema registra al usuario e informa registro exitoso.

Escenario 2: Falla por email ya registrado
Dado que el correo 'julieta@gmail.com' esta registrado en el sistema.
Cuando la persona ingrese el correio 'julieta@gmail.com', nombre de usuario 'julieta', y contraseña '123'.
Entonces el sistema informa que el correo ya se encuentra registrado en el sistema.

--------------
Frente 

Id: Iniciar sesion
Titulo: Como usuario quiero iniciar sesion para poder dar de alta diferentes viajes
Reglas de negocio:

Dorso

Criterios de aprobacion:
Escenario 1: Inicio de sesion exitoso
Dado que el correo 'elianf321@gmail.com' se encuentra en el sistema con la contraseña '123'.
Cuando el usuario ingresa correo 'elianf321@gmail.com', y contraseña '123'.
Entonces el sistema abre al sesion del usuario.

Escenario 2: Fallo de inicio de sesion por correo no existente
Dado que el correo 'juelita@gmail.com' no esta registrado en el sitema.
Cuando el usuario ingrese el correo 'julieta@gmail.com' y la contraseña '321'.
Entonces el sistema informa que el correo o la contraseña son invalidos.

Escenario 3: Fallo de inicio de sesion por contraseña invalida
Dado que el correio 'Agustina@gmail.com' esta registrado en el sistema, con la contraseña '123'.
Cuando el usuario ingresa el correo 'Agustina@gmail.com' y contraseña '321'.
Entonces el sistema informa que el correo o la contraseña son invalidos.

--------------
Frente 

Id: Cerrrar sesion 
Titulo: Como usuario quiero cerrar sesion para poder salir de mi cuenta
Reglas de negocio:

Dorso 

Criterios de aprobacion:
Escenario 1: Cerrar sesion exitoso
Dado que el usuario 'elianf321@gmail.com' con la sesion abierta.
Cuando presione 'cerrar sesion'.
Entonces el sistema cerrara la sesion y redirige a la pantalla de inicio de sesion.

--------------
Frente 

Id: Alta de viaje 
Titulo: Como usuario autenticado quiero dar de alta un viaje para poder tener acompañante y abaratar costos
Reglas de negocio:
* No se pueden superponer viajes
* Un usuario que adeuda calificaciones no puede publicar un viaje

Dorso 

Criterios de aprobracion:

Escenario 1: Alta de viaje exitoso
Dado que el usuario 'elian' no tienen ningun viaje cargado para el 26/11/2024 a las 
17:30Hs y no adeude calificaciones.
Cuando el usuario 'elian' ingrese un viaje a 'Mar del plata', para el 26/11/2024 a las 17:30Hs con el automovil Peugot.
Entonces el sistema registra el viaje e informa registro de viaje exitoso.

Escenario 2: Alta de viaje fallido por superposicion de viaje 
Dado que el usuario 'elian' tiene cargado un viaje para el 27/11/2024 a las 14:00Hs y no adeuda calificaciones.
Cuando el usuario 'elian' ingrese un viaje a 'Tandil', para el 27/11/2024 a las 14hs con el automovil Peugot.
Entonces el sistema informa que el viaje no se puede registrar por que  se superpone con otro.

Escenario 3: Alta de viaje fallido por falta de calificaciones 
Dado que el usuario 'elian' no tiene ningun viaje cargado para el 28/11/2024 las 13:00Hs y adeuda calificaciones.
Cuando el usuario 'elian' ingrese un viaje a 'Las Flores', para el 28/11/2024 a las 13:00Hs con el automovil Reunault.
Entonces el sistema informa que el vaije no se puede registrar por que el usuario adeuda calificaciones.

--------------
Frente 

Id: Postularse a viaje
Titutlo: Como usuario quiero postularme a un viaje para poder ser acompañante y abaratar costos
Reglas de negocio:


Dorso

Criterios de aprobacion:
Escenario 1: Postulacion exitosa
Dado que el usuario 'elian' quiere postularse a un viaje.
Cuando el usuario presionse 'postuarlse al viaje'.
Entonces el sistema carga al usuario al viaje como postulante.

--------------
Frente 

Id: Aceptacion postulante
Titulo: Como usuario dueño de viaje quiero aceptar usuario postulado para poder realizar el viaje con el.
Reglasd de negocio:

Dorso 

Criterios de aprobacion:
Escenario 1: Aceptar usuario 
Dado que el usuario 'viajero' se postulo para el viaje del usuario 'elian.
Cuando el usuario 'elian' acepta al postulante 'viajero'.
Entonces el sistema confirma la accion y le informa la aceptacion al usuario postulado.

Escenario 2: Rechazar usuario 
Dado que el usuario 'viajero1' se postulo para el viaje del usuario 'julieta'.
Cuando el usuario 'elian' rechaza al postulannte 'viajero1'.
Entonces el sistema confirma la acccion y le informa el rechazo al usuario postulado.

--------------
Frente 

Id: Calificar usuarios
Titulo: Como usuario que termino un viaje quiero calificar al resto de usuario
Reglas de negocio:
* Un copiloto no puede calificar a otro copiloto.
* Un piloto puede calificar a todos sus copilotos.

Dorso 

Criterios de aprobacion:
Escenario 1: Calificar a copiloto
Dado que el usuario 'elian' piloto realizo un viaje con el usuario 'julieta' y 'agustina' como copilotos.
Cuando el usuario 'elian' califica al usuario 'julieta' positivamente y 'agustina' negativamente.
Entonces el sistema suma un punto de reputacion al usuario 'julieta' y resta uno a 'agustina'.

Escenario 2: Calificar a piloto
Dado que los usuarios 'Julieta' y 'Agustina', copilotos, realizaron un viaje con el usuario 'Elian' como piloto,
Cuando 'Julieta' califica positivamente al usuario 'Elian' y 'Agustina' califica negativamente al usuario 'Elian',
Entonces el sistema suma un punto de reputación al usuario 'Elian' por la calificación de 'Julieta' y resta uno por la calificación de 'Agustina'.
--------------
11.Concursos
--------------
Frente 

Id: Registrar docente
Titulo: Como docente quiero registrar en el sistema para poder concursar
Reglas de negocio:
* Mail unico
* DNI permitidos menores a 55 millonres y mayores a 12 millones.

Dorso 

Criterios de aprobacion:
Escenario 1: Registro exitoso
Dado que el docente con Mail 'docente1@gmail.com' no se encuentra registrado en el sistema y con DNI 33789123.
Cuando el docente ingrese DNI 33789123, Nombre 'Docente', apellido 'Historio', y mail 'docente1@gmail.com'.
Entonces el sistema registra el usuario, informa el registro exitoso y envia con mail la contraseña.

Escenario 2: Registro fallido por Mail ya existente
Dado que el docente con Mail 'docente2@gmail.com' se encuentra registrado en el sistema.
Cuando el docente ingrese DNI 123901234, Nombre 'Doc', apellido 'Mate', y mail 'docente2@gmail.com'.
Entonces el sistema informa que el mail ya se encuentra registrado en el sistema.

Escenario 3: Registro fallido por DNI no valido 
Dado que el docente con Mail 'docente3@gmail.com' no se encuentra registrado en el sistema y con DNI 88900900.
Cuando el docente ingrede DNI 88900900, Nombre 'Doc', apellido 'Soc', y mail 'docente3@gmail.com'.
Entonces el sistema informa que el DNI es invalido, debe ser mayor a 12 millones y menor a 55 millones.

--------------
Frente 

Id: Iniciar sesion  
Titulo: Como usuario quiero poder iniciar sesion para poder inscribirme en el concurso de docentes
Reglas de negocio:

Dorso 

Criterios de aprobacion:
Escenario 1: Inicio de sesion exitoso 
Dado que el mail 'elianf@gmail.com' se encuentra registrado en el sistema con la contraseña '123123'.
Cuando el usuario ingrese el mail 'elianf@gmail.com',y contraseña '123123'.
Entonces el sistema abre la sesion del usuaario.

Escenario 2: Fallo de inicio de sesion por mail no registrado
Dado que el mail 'mail1@gmail.com' no se encuentra registrado en el sistema.
Cuando el usuario ingrese el mail 'mail1@gmail.com',y contraseña '123321'.
Entonces el sistema informa que el mail o la contraseña son invalidos.

Escenario 3: Fallo de inicio de sesion por contraseña invalida
Dado que el mail 'mail2@gmail.com' se encuentra registrado en el sistema con la contraseña '123'.
Cuando el usuario ingrese el mail 'mail2@gmail.com, y contraseña '321'
Entonces el sistema informa que el mail o la contraseña son invalidos

--------------
Frente 

Id: Cerrrar sesion 
Titulo: Como usuario quiero cerrar sesion para poder salir de mi cuenta
Reglas de negocio:

Dorso 

Criterios de aprobacion:
Escenario 1: Cerrar sesion exitoso
Dado que el usuario 'elianf321@gmail.com' con la sesion abierta.
Cuando presione 'cerrar sesion'.
Entonces el sistema cerrara la sesion y redirige a la pantalla de inicio de sesion.

--------------
Frente 

Id: Incribirse al concurso
Titulo: Como usuario docente quiero inscribirme al concurso para poder participar 
Reglas de negocio:
- Un docente no puede inscribirse a mas de 3 concursos.

Dorso 

Criterios de aprobacion:
Escenario 1: Inscripcion exitosa 
Dado que el usuario docente 'Mortedor' esta inscripto a 2 concursos.
Cuando el usuario docente solicite inscribirse a la materia 'Historia'.
Entonces el sistema inscribe al usuario a la materia e imprime un comprobante.

Escenario 2: Inscripcion fallida por exceder limite 
Dado que el usuario docente 'Maria' esta incripto a 3 concursos.
Cuando el usuario docente solicite inscribirse a la materia 'Matematicas'.
Entonces el sistema informa que el docente no se puede inscribir a mas de 3 concursos.

--------------
Frente

Id: Imprimir listado
Titulo: Como Jefe del area de concurso quiero imprimir un listdo de los inscriptos a una materia
Reglas de negocio:

Dorso 

Criterios de aprobacion: 
Escenario 1:Listado exitoso
Dado que el jefe del area de concursos desea imprimir un listado con los inscriptos a la materia 'Mat'.
Cuando selecciona imprimir listado de inscriptos de la materia 'Mat'.
Entonces el sistema imprime el listado.
--------------
12.Creditos bancarios
--------------
Frente 

Id: Iniciar tramite 
Titulo: Como cliente quiero iniciar un tramite para pedir un credito
Reglas de negocio:
- DNI correspondiente a cliente del banco 
- El credito no puede superar los $400.000

Dorso 

Criterios de aprobacion:

Escenario 1: Tramite iniciado correctamente 
Dado que el DNI '42884131' corresponde a un cliente del banco y el monto a solicitar $300.000 no supera el maximo permitido.
Cuando el usuario ingrese el DNI '42884131', nombre 'elian', apellido 'fernandez, mail 'elian@gmail.com', tipo de credito 'personal', y el monto solicitado $300.000.
Entonces el sistema almacena el tramite e imprime un numero de comprobante.

Escenario 2: Tramite fallido por DNI no perteciente a un cliente
Dado que el DNI '123321444' no corresponde a un cliente del banco.
Cuando el usuario ingrese el DNI '123321444', nombre 'david', apellido 'hernandez', mail 'david@gmail.com', tipo de credito 'vivienda', y el monto solicitado $500.000
Etnonces el sitema envia por correo electronico al mail un instructivo para hacerse cliente del banco.

Escenario 3: Tramite fallido por superar el monto de credito maximo
Dado que el DNI '42884131' corresponde a un cliente del banco y el monto a solicita $500.000 supera el monto maximo permitido.
Cuando el usuario ingrese el DNI '42884131', nombre 'elian', apellido 'fernandez, mail 'elian@gmail.com', tipo de credito 'personal', y el monto solicitado $500.000.
Entonces el sistema informa "El monto solicitado excede el limite permitido".

--------------
Frente 

Id: Consultar estado tramite
Titulo: Como cliente quiero consultar el estado de un tramite para saber como viene
Reglas de negocio:
* 3 intentos maximo

Dorso 

Criterios de aprobacion:
Escenario 1: Consulta de estado de tramite exitoso
Dado que el numero de comprobante '123' es valido, la ip '129.129' no esta bloqueada y lleva 2 intentos.
Cuando el cliente con ip '129.129' ingrese el numero de comprobante '123'.
Entonces el sistema muestra un informe con el estado del tramite y reinicia los intentos.

Escenario 2: Consulta de estado de tramite fallida por comprobante no valido
Dado que el numero de comprabante '123' no es valido.
Cuando el cliente con ip '321.321' ingrese el numero de comprobante '123'.
Entonces el sistema muestra un mensaje de 'tramite inexistente' y aumenta los intentos en 1 para la ip '321.321'.

Escenario 3: Consulta de estado de tramite fallido por usuario bloqueado 
Dado que el numero de comprobante '333' es valido, la ip '321.111' esta bloqueada hace 22hs.
Cuadno el cliente con ip '321.111' ingrese el numero de comprobante '333'.
Entonces el sistema muestra un mensaje 'Usted ha excedido el numero de consultas invalidas".

Escenario 4: Consulta de estado de tramite fallido por maximo de intentos
Dado que el numero de comprobante '444' no es valido, la ip '456.456' no esta bloqueada y lleva 2 intentos.
CUando el cliente con ip '456.456' ingrese el numero de comprobante '444'. 
Entonces el sistema bloquea la ip '444' por 24hs e informa 'Usted ha excedido el numero de consultas invalidas".

--------------
Frente 

Id: Listar creditos
Titulo: Como gerente quiero listar los creditos aprobados para poder verlos
Reglas de negocio:

--------------
Dorso

Criterios de aprobacion:
Escenario 1: Listado exitoso
Dado que las fechas '12/10/2022' al '12/11/2023' son validas y hubo creditos aprobados para ese periodo.
Cuando el gerente ingrese estas fechas.
Entonces el sistema mostrara el listado de creditos aprobados entre estas fechas.

Escenario 2: Listado fallido por fechas invalidas
Dado que las fechas '12/03/2025' al '10/08/2023' son invalidas.
Cuando el gerente ingrese estas fechas.
Entonces el sistema mostrara que la fechas ingresadas son invalidas.

Escenario 3: Listado vacio
Dado que las fechas '12/12/2020' al '12/12/2021' son validas y no hubo creditos aprobados para ese periodo.
Cuando el gerente ingrese estas fechas.
Entonces el sistema mostrara "No hay creditos aprobados en las fechas ingresadas".

--------------
13.Venta de libros
--------------
Frente 

Id: Registrar usuario
Titulo: Como visitante quiero poder registrar en el sistema para poder comprar libros
Reglas de negocio:
* Correo unico
* Clave de 6 caracteres

Dorso 

Criterios de aprobacion:
Escenario 1: Registro exitoso
Dado que el correo 'elian@gmail.com' no esta registrado en el sistema y la clave '123456' es valida.
Cuando el visitante ingrese nombre 'Elian', apellido 'Fernandez', DNI '42884131', correo 'elian@gmail.com' y contraseña '123456'. 
Entonces el sistema envia por correo un codigo de 16 digitos para la confirmacion del registro.

Escenario 2: Registro fallido por correo ya existente 
Dado que el correo 'mail@mail.com' esta registrado en el sistema.
Cuando el visitante ingrese 'mail@mail.com', nombre 'David', apellido 'Gonzales', DNI '123123321', correo 'mail@mail.com' y contraseña '321321'.
Entonces el sistema informa que el correo ya se encuentra registrado.

Escenario 3: Registro fallido por contraseña menor a 6 caracteres
Dado que el correo 'mail@123.com' no esta registrado en el sistma y la calve '321' no es valida.
Cuando el visitante ingrese nombre 'Elian', apellido 'fernandez', DNI '321321312', correo 'mail@123.com' y contraseña '321'.
Entonces el sistema informa que la contraseña debe tener 6 caracteres.
--------------
Frente 

Id: Confirmar cuenta 
Titulo: Como usuario quiero confirma el registro de mi cuenta para poder acceder a ella
Reglas de negocio: 

Dorso 

Criterios de aprobacion:
Escenario 1: Confirmacion exitosa
Dado que el codigo de validacion '1112223334445556' es valido para el correo 'mail@gmail.com' que esta registrado en el sistema.
Cuando el usuario ingrese el correo 'mail@gmail.com' con el codigo 1112223334445556.
Entonces el sistema registra definitivamente el usuario.

Escenario 2: Confirmacion fallida por mail no registrado 
Dado que el correo 'mail123@gmail.com' no esta registrado en el sistema.
Cuando el usuarioe ingrese el correo 'mail123@gmail.com' con el codigo 1231231231230.
Entonces el sistema informara que el correo no esta registrado en el sistema.

Escenario 3: confirmacion fallido por codigo incorrecto
Dado que e codigo de validacion '1231231231231232' es valido para el correo 'fernandez@gmail.com' que esta registrado en el sistema.
Cuando el usuaario ingrese el correo fernandez@gmail.com con el codigo 1231231231231232.
Entonces el sistema informara que el codigo de validacion es incorrecto.
--------------
Frente 

Id: Iniciar sesion 
Titulo: Como usuario quiero poder iniciar sesion para poder comprar libros
Reglas de negocio:

Dorso 

Criterios de aprobacion:
Escenario 1: Inicio de sesion exitoso
Dado que el correo 'elianf321@gmail.com' se encuentra en el sistema con la contraseña '123123'.
Cuando el usuario ingresa correo 'elianf321@gmail.com', y contraseña '123'.
Entonces el sistema abre al sesion del usuario.

Escenario 2: Fallo de inicio de sesion por correo no existente
Dado que el correo 'juelita@gmail.com' no esta registrado en el sitema.
Cuando el usuario ingrese el correo 'julieta@gmail.com' y la contraseña '321'.
Entonces el sistema informa que el correo o la contraseña son invalidos.

Escenario 3: Fallo de inicio de sesion por contraseña invalida
Dado que el correio 'Agustina@gmail.com' esta registrado en el sistema, con la contraseña '123123'.
Cuando el usuario ingresa el correo 'Agustina@gmail.com' y contraseña '123123'.
Entonces el sistema informa que el correo o la contraseña son invalidos.
--------------
Frente 

Id: Cerrar sesion 
Titulo: Como usuario quiero poder cerrar mi sesion para poder salir de mi cuenta
Reglas de negocio:

Dorso 

Escenario 1: Cerrar sesion exitoso
Dado que el usuario 'elianf321@gmail.com' con la sesion abierta.
Cuando presione 'cerrar sesion'.
Entonces el sistema cerrara la sesion y redirige a la pantalla de inicio de sesion.
--------------
Frente 

Id: Comprar libro
Titulo: Como usuario quiero comprar un libro del catalogo para poder leerlo
Reglas de negocio:
* Conexion con el servidor de la tarjeta
* Mismo nombre en la tarjeta que el usuario

Dorso 

Criterios de aprobacion: 
Escenario 1: Compra exitosa
Dado que el ISBN '123' es válido y el usuario 'Elian Fernandez' cuenta con una tarjeta válida, y el sistema logra establecer conexión con el servidor de la tarjeta.
Cuando el usuario ingresa el ISBN '123' e ingresa los datos de la tarjeta con Nombre 'Elian', Apellido 'Fernandez' y Número de Tarjeta '123'.
Entonces el sistema valida los datos, confirma la coincidencia del nombre y apellido, procesa el pago exitosamente y envía un enlace de descarga al correo del usuario registrado.

Escenario 2: Compra fallida por datos incorrectos
Dado que el ISBN '123' es válido y el usuario 'Elian Fernandez' está registrado correctamente, pero los datos de tarjeta ingresados son Nombre 'Juan', Apellido 'Perez' y Número de Tarjeta '456'.
Cuando el usuario ingresa el ISBN '123' e intenta realizar la compra con estos datos incorrectos.
Entonces el sistema rechaza la transacción, indicando que el nombre y apellido no coinciden con los datos del usuario registrado.

Escenario 3: Compra fallida por error del servidor de la tarjeta
Dado que el ISBN '123' es válido y el usuario 'Elian Fernandez' cuenta con una tarjeta válida.
Cuando el sistema intenta establecer conexión con el servidor de la tarjeta y no lo consigue debido a un error externo.
Entonces el sistema informa al usuario que no se pudo completar la compra y le sugiere intentarlo más tarde.

Escenario 4: Compra fallida por falta de conexión con el servidor de la tarjeta
Dado que el ISBN '123' es válido y el usuario 'Elian Fernandez' cuenta con una tarjeta válida, pero el sistema no logra establecer conexión con el servidor de la tarjeta.
Cuando el usuario ingresa el ISBN '123' e ingresa los datos de la tarjeta con Nombre 'Elian', Apellido 'Fernandez' y Número de Tarjeta '123'.
Entonces el sistema debe mostrar un mensaje de error al usuario indicando que no se pudo procesar el pago debido a problemas de conexión y sugerir que intente nuevamente más tarde.

Escenario 5: Compra fallida por ISBN inválido
Dado que el ISBN '999' no es válido y el usuario 'Elian Fernandez' está registrado correctamente, y cuenta con una tarjeta válida.
Cuando el usuario ingresa el ISBN '999' e ingresa los datos de la tarjeta con Nombre 'Elian', Apellido 'Fernandez' y Número de Tarjeta '123'.
Entonces el sistema informa al usuario que el ISBN no es válido y no permite continuar con la compra.
--------------
14. Manejo de tarjetas de credito
--------------