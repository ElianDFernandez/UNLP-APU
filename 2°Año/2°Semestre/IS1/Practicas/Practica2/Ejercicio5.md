# 5 - Casa de fotografia
***
## Frente
### Id: 
    Registro de usuario
### Titulo: 
    Como persona quiero registrame al sitio para subir fotos y retirarlas en la sucursal.
### Reglas de negocio:
    * El sistema debe validar todos los campos.
    * Nombre de usuario unico.
***
## Dorso
### Criterios de aprobacion:
**Escenario 1:** Registro exitoso
Dado que una persona con nombre 'Elian', apellido 'mingito', email 'elian@mail.com', domicilio 'calle 1', nombre de usuario 'elian123' el cual no esta registrado, y contraseña '123'.
Cuando la persona ingresa todos estos datos.
Entonces el sistema registra el usuario y informa que se registro con exito.

**Escenario 2:** Registro fallido nombre de usuario ya existente
Dado que una persona con nombre 'Elian', apellido 'mingito', email 'elian@mail.com', domicilio 'calle 1', nombre de usuario 'elian1234' el cual ya esta registrado, y contraseña '123'.
Cuando la persona ingresa todos estos datos.
Entonces el sistema informara que el nombre de usuario ya esta ocupado.

**Escenario 3:** Registro fallido faltante de datos
Dado que una persona con nombre 'Elian', apellido 'mingito', email 'elian@mail.com', domicilio 'calle 1', nombre de usuario 'elian1234' el cual ya esta registrado, y contraseña '123'.
Cuando la persona ingresa todos estos datos menos el email.
Entonces el sistema informara que campo email debe estar completo.
***

***
## Frente
### Id: 
    Inicar sesion 
### Titulo 
    Como usuario quiero iniciar sesion en el sitio utilizar el servicio de fotografia.'ga
### Reglas de negocio:
    * Nombre de usuario ya registrado
***
## Dorso
### Criterios de aprobacion:
**Escenario 1:** Inicio de sesion exitoso 
Dado que el nombre de usuario 'elian' ya se encuentra registrado en el sistema.
Cuando el usuario ingresa con el nombre de usuario 'elian' y la contraseña abc123.
Entonces el sistema abre sesion y permite el acceso al usuario.
**Escenario 2:** Inicio de sesion fallido por nombre inexistente
Dado que el nombre de usuario 'osvaldo' no esta registrado.
Cuando un visitante ingresa con el nombre 'osvaldo' y la contraseña abc123.
Entonces el sistema informara que el nombre de usuario no existe.
**Escensario 3:** Inicio de sesion fallido por contraseña incorrecta
Dado que el nombre de usuario 'gaston' existe en el sistema y la contraseña 'abc123' no es la correcta.
Cuando el usuario ingresa con nombre de usuasrio 'gaston' y contraseña abc123.
Entonces el sistema informara que la contraseña no es correcta.
***

***
## Frente 
### Id: 
    Pagar foto
### Titulo 
    Como usuario quiero pagar las fotos para obtener un codigo para retirar las fotos
### Reglas de negocio:
    * Validacion de tarjeta de credito
***
## Dordo 
### Criterios de aprobacion:
**Escenario 1:** Pago exitoso 
Dado que el usuario ha ingresado los datos de su tarjeta de crédito con número 1234-5678-9123, código de seguridad 123, y nombre del titular 'Diego' y la tarjeta es válida,
Cuando el usuario ingresa la informacion de pago y presiona confirmar.
Entonces el sistema valida la tarjeta con el banco y, si es aceptada, cobra el monto total, genera un código único de retiro y lo muestra al usuario.
**Escenario 2:** Pago fallido por tarjeta invalida o fondos insuficientes
Dado que el usuario ha ingresado los datos de sus tarjeta de credito con numero 1234-1234-4231, codigo de seguridad 123, y nombre del titular 'Julieta' y la tarjeta de credito es invalida o no tiene fondos suficientes.
Cuando el usuario ingresa la informacion de pago y presiona confirmar.
Entonces el sistema valida la tarjeta con el banco, informa al usuario que la tarjeta no es valida o no posee fondos.
***

***
## Frente 
### Id:
    Subir fotos
### Titulo:
    Como usuario registrado quiero subir fotos pra utilizar el servicio de fotografias
### Reglas de negocio:
    * Maximo de 50 fotos 
    * Carga de fotos de a una
    * Valor por foto $15
***
## Dorso
### Criterios de aprobacion:
**Escenario 1:** Carga de fotos exitosa
Dado que el usuario ya autenticado 'gaston', tiene para subir 45 fotos.
Cuando el usuario cargue las 45 fotos de a 1 y confirme que finalizo.
Entonces el sistema realiza el pago de las fotos, y asgina un codigo unico a las fotos y se lo informa al usuario.
**Escenario 2:** Carga de fotos fallida por superar el limite
Dado que el usuario ya autenticado 'David', tiene para subir 56 fotos.
Cuando el usuario cargue las fotos de a 1 y llegue a la numero 51.
Entonces el sistema informara que el maximo permitido son 50 fotos.
**Escensario 3:** Carga de fotos fallida por pago fallido 
Dado que el usuario ya autenticado 'Pablo', tiene para subir 40 fotos.
Cuando el usuario cargue las 43 fotos de a 1 y confirme que finalizo.
Entonces el sistema intenta realizar el pago de las fotos pero falla, entonces el sistema informara que el pago no realizo con exito.
**Escenario 4:** Carga de fotos fallido por cargar de a mas de 1 fotos.
Dado que el usuario ya autenticado 'Giulana', tiene para subir 45 fotos.
Cuando el usuario cargue de a mas de 1 una foto. 
Entonces el sistema informara que la carga de fotos se debe realizar de a 1.
***

***
## Frente 
### Id:
    Retiro de fotos
### Titulo:
    Como empleado quiero registrar un reitro de fotos
### Relgas de negocio:
    * codigo unico asignado a las fotos
***
## Dorso
### Criterios de aprobacion:
**Escenario 1:** Retiro de fotos exitoso
Dado que el empleado recibe el codigo unico existente, codigo '123'.
Cuando el empleado registra el codigo, y la fechad de retiro.
Entonces el sistema informa que puede retirar lsa fotos.
**Escenario 2:** Retiro de fotos fallido por codigo no existente
Dado que el emplado recibe el codigo unico no existente, codigo '1321'.
Cuando el emplado registra el codigo, y la fecha de retiro.
Entonces el sistema informa que el codigo es inexistente.
***