# Problema 4

***
## Frente

#### Id:
Registrarse
#### Titulo:
Como vistante deseo poder registrarme en el sitio
#### Reglas de negocio:
    * Email unico
    * Permitir registro a personas mayores de 18 años
***
## Dorso

#### Criterios de aprobacion
**Escenario 1:** Registro exitoso
Dado el visitante con email 'juan@gmail.com' el cual aun no esta registrado, con edad mayor a 18 años.
Cuando el visitante se registra con nombre: 'juan', apellido 'mingito', email 'juan@gmail.com', y edad 19 años.
Entonces el sistema genera una contraseña enviada al email y registra el usuario.

**Escenario 2:** Registro fallido por Email ya registrado 
Dado el visitante con email 'giuliano@gmail.com' el cual ya fue registrado, con edad mayor a 18 años.
Cuando el visitante se regista con nombre: 'Giuliano', apellido 'minigito', email 'giuliano@gmail.com', y edad 19 años.
Entonces el sistema informara que el email ya esta registrado.

**Escenario 3:** Registro fallido por visitante menor de 18 años
Dado el visitante con email 'david@gmail.com' el cual aun no esta registrado, con edad menor a 18 años.
Cuando el visitante se registra con nombre 'David', apellid ' mingito', email 'david@gmail.com' y edad 16 años.
Entonces el sistema informara el texto que la ley impide la venta de bebidas alcoholicas a menores de 18 años.
***

***
## Frente

#### Id:
Iniciar sesion
#### Titulo:
Como usuario registrado, deseo inciar sesion para poder acceder a realizar una compra
#### Reglas de negocio:
    * Email ya registrado
    * El usuario debe ingresar un email y contraseña válidos.
***
## Dorso

#### Criterios de aprobacion
**Escenario 1:** Inicio de sesion exitoso 
Dado que el usuario registrado con Email 'usuario@gmail.com' desea inicar sesion
Cuando el usuario inicia sesion con el Email 'usuario@gmail.com' y contraseña 'abc' que es valida.
Entonces el sistema permite el acceso al sitio y muestra la lista de bebidas

**Escenario 2:** Inicio de sesion fallido por email invalido
Dado que un visitane con email no registrado 'visitante@gmail.com' desea inciar sesion 
Cuando el visitante ingrese con email 'visitante@gmail.com' contraseña '123'
Entonces el sistema no permite el acceso e informa email no registrado.

**Escenario 3:** Inicio de sesion fallido por contraseña invalida 
Dado que un usuario registrado con Email 'usuario@gmail.com' desea iniciar sesion.
Cuando el usuario incia sesion con el Email 'usuario@gmail.com' y contraseña 'bcd' que no es valida.
Entonces el sistema no permite el acceso e informa contraseña invalida.
***

***
## Frente

#### Id:
Realizar una compra
#### Titulo:
Como usuario deseo realizar una compra
#### Reglas de negocio:
    * Haber iniciado sesion
    * Si el usuario es premium recibe descuento del 20% 
    * Monto superior al 4500 10% de decuento 
    * Usuario premiun con compra mayor a 4500 se amplican ambos descuentos
***
## Dorso 

#### Criterios de aprobacion
**Escenario 1:** compra exitosa como usuario no premium sin descuento
Dado que un usuario estandar inicio sesion 
Cuando el ususario realizo una compra con moto menora 4500
Entonces el sistema aplica un 10% de descuento al monto de la compra e informa en pantalla el total.

**Escenario 2:** Compra exitosa como usuario premium y monto menor a 4500
Dado que un usuario premium inicio sesion
Cuando el usuario Premium realiza una compra con monto $3000
Entonces el sistema aplica un 20% de descuenta al monto de la compra e informa el pantalla el total.

**Escenario 3:** Compra exitosa como usuario premiu y monto mayor a 4500
Dado que un usuario premium incio sesion
Cuando el usuario Premium realiza una compra con monto $5600
Entonces el sistema aplica un 30% de descuento al monto de la compra e informa en pantalla el total.