# Introduccion 

1.¿Cual es la funcion de la capa de aplicacion?

La capa de aplicacion es la que permite a los usuarios interactuar con la red, proporcionando servicios y aplicaciones que facilitan la comunicación y el intercambio de datos entre dispositivos. Esta capa se encarga de definir protocolos y estándares para la transferencia de información, asegurando que los datos sean comprensibles y utilizables por las aplicaciones finales.

2.Si dos procesos deben comunicarse:
    a. ¿Como podrian hacerlo si estan en diferentes maquinas?
    b. y si estan en la misma maquina, que alternativas tienen?

a. Si dos procesos están en diferentes máquinas, pueden comunicarse a través de la red utilizando protocolos de comunicación como TCP/IP. Esto implica que uno de los procesos actúa como servidor, escuchando solicitudes en un puerto específico, mientras que el otro proceso actúa como cliente, enviando solicitudes al servidor a través de la dirección IP y el puerto correspondiente.

b. Si los procesos están en la misma máquina, tienen varias alternativas para comunicarse, como:
- Comunicación mediante memoria compartida: Los procesos pueden acceder a una región de memoria común para intercambiar datos.
- Comunicación mediante tuberías (pipes): Los procesos pueden usar tuberías para enviar datos de un proceso a otro de manera secuencial.
- Comunicación mediante sockets locales: Los procesos pueden utilizar sockets para establecer una conexión local y enviar datos entre ellos.
- Comunicación mediante señales: Los procesos pueden enviar señales para notificar eventos o cambios de estado entre ellos.

3. Explique brevemente como es el modelo cliente/servidor. De un ejemplo de un sistema cliente/servidor en la "vida cotidiana" y un ejemplo de un sistema informatico que siga el modeo cliente/servidor. ¿Conoce algun otro modelo de comunicacion?

El modelo cliente/servidor es un paradigma de comunicacion en el que un proceso (el cliente) solicita servicios o recursos a otro proceso (el servidor), que los proporciona.
El servidor espera y responde a las solicitudes del cliente, gestionando los recursos y la lógica de negocio. Este modelo permite centralizar la administración de recursos y facilita la escalabilidad y el mantenimiento del sistema.

Otros sistemas cliente/servidor en la vida cotidiana pueden incluir un restaurante, donde los clientes (personas) hacen pedidos al mesero (servidor), quien luego entrega la comida preparada por la cocina (otro servidor).
Un ejemplo de un sistema informático que sigue el modelo cliente/servidor es un servicio de correo electrónico, donde el cliente (usuario) utiliza un programa de correo para enviar y recibir mensajes, mientras que el servidor de correo gestiona el almacenamiento y la entrega de los mensajes.

4. Describa la funcionalidad de la entidad generica "Agentes de usuario" o "User agent".

El User Agent es una entidad que actua como intermediario entre el usuario y la red, facilitando la interacción con los servicios y aplicaciones disponibles. Su funcionalidad principal incluye:
- Interpretar y procesar las solicitudes del usuario, enviándolas a los servidores correspondientes.
- Recibir y presentar la información devuelta por los servidores de manera comprensible para el usuario.
- Gestionar la comunicación con los servidores, incluyendo el manejo de protocolos y formatos de datos.

5. Que son y en que se diferencian HTML y HTTP?

HTML (HyperText Markup Lenguague) es un leguaje de marcado utilizando estructuras y etiquetas para definir el contenido y la presentacion de paginas web. 

HTTP (HyperText Transfer Protocol) es un protocolo de comunicacion que permtie la tranferencia de informacion entre clientes y servidores en la web.

6. HTTP tiene definido un formato de mensaje para los requerimientos y las respuestas. 
a. Que informacion de la capa de aplicacion nos indica si un mensaje de requerimientos o de respuesta para HTTP? como esta compuesta dicha informacion? para que sirven las cabeceres?
b. Cual es su formato?
c. Suponga que desea enviar un requerimientos con la version de HTTP 1.1  desde curl/7.74.0 a un sitio de ejemplo como www.misitio.com para obtener el recurso /index.html. En base a lo indicado, que informacion deberia enviarse mediantes encabezados? indique como quedaria el requerimiento.

a. La informacion de la capa de aplicacion que nos indica si es un requerimiento o respuesta se encuentra en la primer lina: 
- En un mensaje de requerimiento, la primera línea contiene el método HTTP (como GET, POST, etc.), la URL del recurso solicitado y la versión del protocolo HTTP.
- En un mensaje de respuesta, la primera línea contiene la versión del protocolo HTTP, el código de estado (como 200, 404, etc.) y una descripción del estado.
b. El formato de un mensaje HTTP es el siguiente:
Ejemplo de requerimiiento: 

```
GET /index.html HTTP/1.1
```

Ejemplo de respuesta:

```
HTTP/1.1 200 OK
```

c. Para enviar un requerimiento con version HTTP 1.1 desde curl/7.74.0 a www.misitio.com para obtener el recurso /index.html, la información que debería enviarse mediante encabezados incluiría:

GET /index.html HTTP/1.1
Host: www.misitio.com -> Necesario para HTTP 1.1 (ya que permite al servidor identificar el dominio solicitado)
User-Agent: curl/7.74.0
Accept: */*

7. Utilizando la VM, abra una terminal e investigue sobre el comando curl. Analice sirven los siguientes parametros (-I, -H, -X, -s).

Por defecto, curl realiza una solicitud GET a la URL especificada y devuelve el contenido de la respuesta.

Prueba -I:
 
curl -I www.misitio.com
El parámetro -I se utiliza para realizar una solicitud HEAD, lo que significa que solo se obtendrán los encabezados de la respuesta sin el cuerpo del mensaje.

Respuesta: 
```
    HTTP/1.1 200 OK
    Content-Type: text/html; charset=ISO-8859-1
    Content-Security-Policy-Report-Only: object-src 'none';base-uri 'self';script-src 'nonce-t_C0IQVFJCd6U0pA4eGv-Q' 'strict-dynamic' 'report-sample' 'unsafe-eval' 'unsafe-inline' https: http:;report-uri https://csp.withgoogle.com/csp/gws/other-hp
    P3P: CP="This is not a P3P policy! See g.co/p3phelp for more info."
    Date: Thu, 03 Sep 2026 11:52:29 GMT
    Server: gws
    X-XSS-Protection: 0
    X-Frame-Options: SAMEORIGIN
    Expires: Thu, 03 Sep 2026 11:52:29 GMT
    Cache-Control: private
    Set-Cookie: __Secure-STRP=ANmZwa3fsHSKeqcE1zlS-cCu4Yx_7v2Dv3EYhEIQP7owf1fqyNzaw-qCu3T8JuveVCq78rg2jteRY-q8sioKrfw3TBWLcUMR6WxY; expires=Thu, 03-Sep-2026 11:57:29 GMT; path=/; domain=.google.com; Secure; SameSite=strict
    Set-Cookie: AEC=AdJVEauAxKnwVCTe5jZPwQN_Y9C-wbSAjxhJRa5tXWZGM2fjiCCwzU6Gbg; expires=Tue, 02-Mar-2027 11:52:29 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax
    Set-Cookie: NID=534=qqQD-SljXq6r403ETEDPUkm2kmJMlwtf26Qfu3JE2L1AzmolQ_bZypKyGip9ZqxpmpOBNqMz_h71fLkJvqzspAzKe7YSKXVCeZwSzQTvONj410hprjP8bVfpdBeh83JJ81TbcLikx23rzA0XHEp6c4f2KVrS7duXjna3QNWBCoFCzybM9ESFzkxZiBAk-S5TaXtmu1mOY8FOSKvnzA; expires=Fri, 05-Mar-2027 11:52:29 GMT; path=/; domain=.google.com; HttpOnly
    Transfer-Encoding: chunked
```

Prueba -H:
curl -H "User-Agent: Mozilla/5.0" -H "Accept: text/html" www.google.com

Respuesta, devuelve el contenido de la página web solicitada, incluyendo los encabezados y el cuerpo del mensaje. El parámetro -H permite agregar encabezados personalizados a la solicitud HTTP, como "User-Agent", "Accept", entre otros.

Prueba -X:
curl -X POST -d "param1=value1&param2=value2" www.misitio.com

El parametro -X se utiliza para especificar el método HTTP a utilizar en la solicitud, como GET, POST, PUT, DELETE, etc. En este caso, se está realizando una solicitud POST con datos enviados en el cuerpo del mensaje.

Prueba -s: 
curl -s www.misitio.com
El parámetro -s se utiliza para ejecutar curl en modo silencioso, lo que significa que no se mostrarán mensajes de progreso ni errores en la salida estándar. Esto es útil cuando se desea obtener solo el contenido de la respuesta sin información adicional sobre la ejecución del comando.

8. Ejecute el comando curl sin ningun parametro adicional y acceda a www.redes.unlp.edu.ar. Luego responda:

a.¿Cuantos requerimientos realizo y que recibio? Pruebe rediriendo la salida (>) del comando curl a un archivo extension html y abriro con un navegador web. ¿Que observa?.

b.¿Como funciona los atributos href de los tags link e img en html?

c.Para visualizar la pagina completa con imagenes como en un navegador ¿alcaanza con realizar un unico requerimiento?

d. ¿Cuantos requerimientos serian necesarios para obtener una pagina que tiene dos css, dos javascript y tres imagenes? Diferencie como funcionaria un nevagedor respecto al coando curl ejecutando previamente.

Sin VM

9. Ejecute a continuacion los siguientes comandos:

    curl -v -s www.redes.unlp.edu.ar > /dev/null

    curl -i -v -s www.redes.unlp.edu.ar

    a.Que diferencias nota entre cada uno?
    b.Que ocurre si en el primer comando se quita la redireccion a /dev/null? Por que no es necesario el segundo comando? 
    c.Cuantas cabeceras viajaron en el requerimiento? y en la respuesta?

10. Que indica la cabecera Date?

Indica la fecha y hora en que el mensaje fue generado por el servidor, proporcionando información sobre cuándo se procesó la solicitud y se envió la respuesta. Esta cabecera es útil para la sincronización de tiempo y para el control de caché en las aplicaciones web.

11. En HTTP/1.0, Como sabe el cliente que ya recibio todo el objeto solicitando de manera completa? y en HTTP/1.1?

En HTTP/1.0, el cliente sabe que ha recibido todo el objeto solicitado cuando la conexión se cierra después de enviar la respuesta completa. Esto significa que el servidor envía todos los datos y luego cierra la conexión, indicando al cliente que no hay más datos por recibir.

En HTTP/1.1, el cliente puede determinar que ha recibido todo el objeto solicitado mediante el uso de la cabecera "Content-Length", que indica la longitud del contenido en bytes. El cliente puede leer la cantidad de datos especificada en esta cabecera y saber que ha recibido todo el objeto cuando ha leído esa cantidad de bytes.

12. Investigue los distintos tipos de codigos de retorno de un servidor web y su significado. 
Considere que los mismos se clasifican en categorias (2XX, 3XX, 4XX, 5XX).

Los códigos de retorno de un servidor web se clasifican en varias categorías según el tipo de respuesta que representan. A continuación se describen las principales categorías y algunos ejemplos de códigos dentro de cada una:

- 1XX (Informativos): Indican que la solicitud ha sido recibida y el proceso continúa. Ejemplo: 100 Continue.

- 2XX (Éxito): Indican que la solicitud fue recibida, comprendida y aceptada correctamente. Ejemplos:
  - 200 OK: La solicitud se ha procesado correctamente.
  - 201 Created: La solicitud ha sido cumplida y se ha creado un nuevo recurso.

- 3XX (Redirección): Indican que se requiere una acción adicional para completar la solicitud, generalmente una redirección a otra URL. Ejemplos:
  - 301 Moved Permanently: El recurso solicitado ha sido movido permanentemente a otra URL.
  - 302 Found: El recurso solicitado se encuentra temporalmente en otra URL.

- 4XX (Error del cliente): Indican que hubo un error en la solicitud realizada por el cliente. Ejemplos:
    - 400 Bad Request: La solicitud no pudo ser entendida por el servidor debido a una sintaxis incorrecta.
    - 401 Unauthorized: La solicitud requiere autenticación del cliente.
    - 403 Forbidden: El servidor entiende la solicitud pero se niega a autorizarla.
    - 404 Not Found: El recurso solicitado no se pudo encontrar en el servidor.

- 5XX (Error del servidor): Indican que el servidor falló al procesar una solicitud válida. Ejemplos:
    - 500 Internal Server Error: El servidor encontró una condición inesperada que le impidió cumplir con la solicitud.
    - 502 Bad Gateway: El servidor recibió una respuesta inválida de un servidor ascendente mientras intentaba cumplir con la solicitud.
    - 503 Service Unavailable: El servidor no está disponible temporalmente, generalmente debido a mantenimiento o sobrecarga.

13. Utilizando curl, realice un requerimiento con el metodo HEAD al sitio www.redes.unlp.edu.ar e indique:

a. Que informacion brinda la primera linea de la respuesta?
b. Cuantos encabezador muestra la respuesta?
c. Que servidor web esta sirviendo la pagina?
d. El acceso a la pagina solicitada fue exitoso o no?
e. Cuando fue la ultima vez que se modifico la pagina?
f. Solicite la pagina nuevamente con curl usando GET, pero esta vez indique que quiere obtenerla solo si la misma fue modificada en una fecha posterior a la que efectivamente fue modificada. ¿Como lo hace? ¿Que resuelto obtuvo? ¿Puede explicar porque?

