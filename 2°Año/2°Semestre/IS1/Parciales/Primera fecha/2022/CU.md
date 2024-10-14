||||
|-|-|-|
| Nombre | Autenticarse |
| Descripcion | Especifica el modo en el que un usuario registrado inicia se sesion con su mail y contraseña | 
| Actores | Usuario | 
| Precondiciones | --- | 
| Curso normal | Acciones del actor | Acciones del sistema | 
| | Paso 1: el usuario registrado selecciona la opcion iniciar sesion | 
| | | Paso 2: el sistema soliciar usuario (Mail) y contraseña | 
| | Paso 3: el usuario registrado ingresa los datos solicitados, mail y contraseña | 
| | | Paso 4: el sistema verifica los datos ingresados y los intentos |
| | | Paso 5: el sistema registra la sesion iniciada y permite la ususario ver los detalles de las noticias | 
| Curso alterno | Paso 4 alternativo 1: el usuario o contraseña no son válidos, se notifica la discrepancia. Retorna al paso 2 y notifica que quedan 2 intentos. |
| | Paso 4 alternativo 2: el usuario o contraseña no son válidos en el segundo intento, se notifica la discrepancia. Retorna al paso 2 y notifica que queda 1 intento. |
| | Paso 4 alternativo 3: el usuario o contraseña no son válidos en el tercer intento, se notifica la discrepancia y se bloquea la cuenta. |
| Postcondicion | La sesion ha sido iniciada y la opcion ver detalle de la noticia aparece | 

||||
|-|-|-|
| Nombre | Registrarse | 
| Descripcioin | Este caso de uso describe el evento en el que un usuario no registrado se registra en el sietema | 
| Actores | Usuario no registrado | 
| Precondiciones | --- | 
| Curso normal | Acciones del actor | Acciones del sistema | 
| | Paso 1: EL usuario no registrado selecciona la opcion registrarse | | 
| | | Paso 2: El sistema solicita los datos, nombre, apellido, edad y mail | 
| | Paso 3: El usuario ingresa la datos | | 
| | | Paso 4: El sistema verifica que el mail no este registrado y que sea mayor de 18 años| 
| | | Paso 5: El sistema registra el usuario nuevo y envia una contraseña aleatoria al mail ingresado y lo notifica |
| Curso alterno | Paso 4 alternativo 1: El mail ingresado ya esta registrado, el sistema lo informa y retorna al paso 2 | 
| | Paso 4 alternativo 2: La edad ingresda es menor a 18 años, el sistema informa que se permite el registro a usuario mayores de 18 años y retorna al paso 2 | 
| Postcondicion | Se creo una cuenta de usuario nueva, y se envio su contraseña al mail correspondiente | 

||||
|-|-|-
| Nombre | Obtener noticias |
| Descripción | Este caso de uso permite al sistema obtener un listado de noticias desde el servidor proveedor. |
| Actores | servidor proveedor |
| Precondiciones | Tener token de seguridad |
| Curso normal | Acciones del actor | Acciones del sistema |
| | Paso 1: El sistema solicita al servidor proveedor el listado de noticias, enviando el token de seguridad. | |
| | | Paso 2: El servidor proveedor recibe la solicitud y verifica el token de seguridad. |
| | Paso 3: Si el token es válido, el servidor envía el listado de noticias en formato JSON. | |
| | | Paso 4: El sistema recibe el listado en formato JSON. |
| | | Paso 5: El sistema convierte el formato JSON a HTML para su visualización. |
| Curso alternativo | Paso 2.1 alternativo: El servidor proveedor verifica que el token no es correcto. |
| | Paso 2.2 alternativo: El servidor informa al sistema que no se puede acceder a las noticias debido a un error de autenticación. |
| Postcondiciones | El sistema tiene el listado de noticias en formato JSON disponible para ser utilizado en la visualización. |

||||
|-|-|-|
| Nombre | Acceder al listado de noticias |
| Descripción | Este caso de uso permite tanto a visitantes como a usuarios registrados visualizar una lista de noticias en la aplicación. |
| Actores | visitante, usuario, servidor proveedor |
| Precondiciones | El sistema debe estar conectado a la red y contar con acceso al servidor proveedor. |
| Curso normal | Acciones del actor | Acciones del sistema |
| | Paso 1: El usuario/visitante accede a la opción de noticias en el sistema. | |
| | | Paso 2: El sistema incluye el caso de uso **Obtener noticias** para comunicarse con el servidor proveedor y solicitar el listado de noticias. |
| | | Paso 3: El sistema recibe el listado de noticias desde el servidor proveedor. |
| | | Paso 4: El sistema convierte el formato de las noticias (de JSON a HTML). |
| | Paso 5: El sistema muestra el listado de noticias en pantalla para el usuario/visitante. | |
| Curso alternativo | Paso 2.1 alternativo: El sistema no puede obtener noticias debido a un error con el token de seguridad. |
| | Paso 2.2 alternativo: El sistema informa al usuario/visitante que no es posible cargar las noticias en este momento. |
| Postcondiciones | El sistema muestra el listado de noticias en pantalla (en caso de éxito). |

||||
|-|-|-|
| Nombre | Acceder al detalle de una noticia | 
| Descripcion | Este caso de uso describe el acceso al detalle de una noticia para el usuario ya regsitrado |
| Actores | Usuario registrado | 
| Precondiciones | El usuario debe haber iniciado sesion | 
| Curso normal | Acciones del actor | Acciones del sistema |
| | Paso 1: el usuario solicita ver el detalle de una noticia | | 
| | | Paso 2: el sistema recibe la solicitud y verifica que el usuario este registrado | 
| | | Paso 3: el sistema muestra el detalle de la noticia | 
| Curso alternativo | Paso 2 alternativo: el sistema verifica que no esta registrado el visitante, informa que no es posible acceder, fin de caso de uso | 
| Postcondicion | El sistema muestra en pantalla el detalle la noticia seleccionada | 