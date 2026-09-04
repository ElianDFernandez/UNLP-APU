# Redes y Comunicaciones HTTP

## Entendiendo HTTP

HTTP es un protocolo de capa de aplicación que permite la comunicación entre clientes y servidores en la web. Funciona sobre el protocolo TCP/IP y es fundamental para la transferencia de información en la World Wide Web.

Cuando decimos que funciona sobre TCP/IP, significa que HTTP utiliza TCP (Transmission Control Protocol) para establecer una conexión confiable entre el cliente y el servidor, asegurando que los datos se transmitan correctamente.

Es decir, cuando un cliente (como un navegador web) realiza una solicitud HTTP a un servidor, esta solicitud se envía a través de una conexión TCP. El servidor procesa la solicitud y responde con los datos solicitados, que también se envían a través de la misma conexión TCP.

En un grafico seria:

```
1° Conexion TCP:
Cliente (Navegador) <-----> Servidor (Web)
      |                           |
      |---- Conexion TCP ------->|
      |<--- Conexion TCP --------|
```

```
2° Solicitud HTTP:
Cliente (Navegador) <-----> Servidor (Web)
      |                           |
      |---- Solicitud HTTP ------>|
      |<--- Respuesta HTTP -------|
```

## Compatibilidad y Versiones de HTTP

**HTTP 1.0:** Fue la primera versión ampliamente utilizada del protocolo HTTP. Introdujo el concepto de solicitudes y respuestas, pero cada solicitud requería una nueva conexión TCP, lo que podía generar retrasos en la comunicación.

**HTTP 1.1:** Se lanzó en 1997 y mejoró significativamente el rendimiento del protocolo. Introdujo el concepto de conexiones persistentes, lo que permite que múltiples solicitudes se realicen a través de la misma conexión TCP, reduciendo el tiempo de espera y mejorando la eficiencia.

**HTTP 2:** Fue lanzado en 2015 y se centra en mejorar la velocidad y eficiencia de la comunicación. Introduce características como la multiplexación de solicitudes, compresión de encabezados y priorización de recursos, lo que permite una carga más rápida de las páginas web.

Antes por cada peticion HTTP se hacia una conexion TCP, ahora con HTTP 2 se pueden hacer varias peticiones en la misma conexion TCP, a traves del uso de streams y frames, lo que mejora significativamente el rendimiento y reduce la latencia.

Un Stream es una secuencia de datos bidireccional dentro de una conexión HTTP/2. Cada stream tiene un identificador único y puede transportar múltiples mensajes, lo que permite la multiplexación de solicitudes y respuestas.
Es decir, varios streams pueden coexistir en la misma conexión TCP, lo que permite que el cliente y el servidor envíen y reciban datos de manera simultánea sin bloquearse entre sí.

En cuanto a compatibilidad, HTTP 2 es compatible con HTTP 1.1, lo que significa que los servidores y clientes pueden comunicarse utilizando cualquiera de las dos versiones según sea necesario. HTTP 1.1 y HTTP 1.0 dejan de ser compatibles con HTTP 2, ya que este último introduce cambios significativos en la forma en que se manejan las solicitudes y respuestas.



