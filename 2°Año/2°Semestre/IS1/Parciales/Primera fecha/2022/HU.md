# IDS2022 HU

notas:
- cualquiera persona puede acceder a ver las noticias 
- sistema se conecta con un servidor proveedor recibe json y conviere a html
- usuarios registrados en el sistema podran acceder a un detale de cada noticia
- solo podran registrarse mayores de 18 años y el registro no tiene costo
- el sistema generara una contraseña aleatoria y enviara al correo
- solo se permite acceder al detalle de 5 noticias por dia
- para acceder al detalle debe estar autenticado previamente 
- 3 intentos de autenticacion si falla bloquea la cuente


# ID: Registrarse.
# TITULO: Como visitante quiero poder registrarme para poder ver los detalles de las noticias.
# Reglas de negocio: 
    * Solo podran registrarse mayores de 18 años.
    * No tiene costo.
    * Mail unico y utilizado como nombre de usuario.

# Criterios de aprobacion(Registrarse en el sistema):
**Escenario 1: Registro exitoso** 
Dado que el visitante con mail visitante@hotmail.com, el cual no esta registrado en el sistema, y con edad 19 años.
Cuando ingrese los datos nombre Juan, apellido Pérez, edad 19 años y correo visitante@hotmail.com.
Entonces el sistema generara una contraseña de manera aleatoria y se la enviara al mail ingresado, y se le notificara.

**Escenario 2: Registro fallido por mail ya existente**
Dado que el visitante con mail visitante1@hotmail.com, el cual ya esta registrado en el sistema.
Cuando ingrese los datos nombre Juan, apellido Gonsalez, edad 20 años y correo visitante1@hotmail.com.
Entonces el sistema informara que el mail ya esta registrado. 

**Escenario 3: Registro fallido por visitante menor a 18 años**
Dado que el visitante con mail visitante2@hotmail.com, el cual no esta registrado en el sistema, y con edad 16 años.
Cuando ingrese los datos nombre Ivan, apellido Perez, edad 16 años y con correo visitante2@hotmail.com.
Entonces el sistema informara que no se puede registrar por que es menor a 18 años.


# ID: Autenticarse.
# TITULO: Como usuario quiero poder autenticarme en el sistema para ver los detalles de las noticias. 
# Reglas de negocio:
    * Máximo 3 intentos de autenticación. Si falla en los 3 intentos, la cuenta se bloquea.

# Criterios de aprobación (Autenticarse):
**Escenario 1: Autenticación exitosa** 
Dado que el usuario con mail usuario@hotmail.com, el cual ya está registrado en el sistema.
Cuando el usuario ingrese su mail y contraseña correctamente.
Entonces el sistema lo autentica y le permite acceder a los detalles de las noticias.

**Escenario 2: Autenticación fallida por contraseña incorrecta**
Dado que el usuario con mail usuario@hotmail.com, el cual ya está registrado en el sistema.
Cuando el usuario ingrese su mail correctamente pero la contraseña incorrecta.
Entonces el sistema informa que la contraseña es incorrecta y permite dos intentos más.

**Escenario 3: Bloqueo de cuenta por múltiples intentos fallidos**
Dado que el usuario con mail usuario@hotmail.com, el cual ya está registrado en el sistema.
Cuando el usuario ingrese su mail correctamente pero la contraseña incorrecta tres veces.
Entonces el sistema bloquea la cuenta y notifica al usuario.


# ID: Acceder al detalle de una noticia.
# TITULO: Como usuario ya autenticado quiero acceder al detalle una noticia.
# Reglas de negocio:
    * Solo los usuarios autenticados pueden acceder al detalle de las noticias.
    * Solo se permite acceder al detalle de 5 noticias por dia

# Criterios de aprobacion (Acceder al detalle de una noticia):
**Escenario 1: Acceso al detalle de la noticia exitoso**
Dado que el usuario ya autenticado, el cual accedio a 3 noticias en el dia.
Cuando el usuario solicite ver detalle de una noticia.
Entonces el sistema le mostrara el detalle completo de la noticia, y restara 1 a los accesos restantes del dia, quedando 2.

**Escenario 2: Acceso al detalle de la noticia fallido por limite de accesos**
Dado que el usuario ya autenticado, el cual accedio a 5 noticas en el dia.
Cuando el usuario solicite ver detalle de una noticia.
Entonces el sistema informara que el usuario ya no posee mas accesos en el dia.

**Escenario 3: Acceso al detalle de la noticia fallido por usuario no autenticado**
Dado que el usuario no esta autenticado e intenta acceder al detalle de un a noticia.
Cuando el usuario solicite ver detalle de una noticia.
Entonces el sistema informara que el usuario deber estar autenticado para poder acceder al detalle.


# ID: Acceder al listado de noticias.
# TITULO: Como visitante deseo ver el listado de noticias para informarme.
# Reglas de negocio:

# Criterios de aprobacion (Acceder al lsitado de noticias):
**Escenario 1: Acceso al listado exitoso**
Dado que un visitante accede al sistema, y este establece conexion con el servidor proveedor.
Cuando el sistema recibe el conjunto de noticias en formato JSON.
Entonces el sistema convierte el JSON a formato HTML y las noticia son mostradas en pantalla.

**Escenario 2: Acceso al listado fallido por formato inesperado**
Dado que un visitante accede al sistema, y este establece conexion con el servidor proveedor.
Cuando el sistema recibe el conjunto de noiticas en otro formtato que no es JSON.
Entonces el sistema informa que no se recibio el conjunto de noticias correctamente.

**Escenario 3: Acceso al listado fallido por falla de conexion con servidor proveedor**
Dado que un visitante accede al sistema, y este no establece una conexion exitosa con el servidor proveedor.
Cuando el sistema intenta acceder al servidor proveedor para obtener el listado.
Entonces el sistema informa que el servicio no se encuentra disponible.
