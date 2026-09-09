# DNS

Protrocolo de nivel de aplicacion que traduce nombres de dominio a direcciones IP. Funciona sobre el protocolo TCP/UDP y es fundamental para la navegación en la web.

Ejemplo:

```
1° Conexion TCP:
El cliente (Navegador) establece una conexion TCP con el servidor DNS para realizar la consulta de un nombre de dominio y obtener la IP correspondiente.

Cliente (Navegador) <-----> Servidor (DNS)
        |                           |
        |---- Conexion TCP ------->|
        |<--- Conexion TCP --------|
```

```
2° Solicitud DNS:
Aca el cliente (Navegador) envia la solicitud DNS al servidor para obtener la direccion IP del nombre de dominio solicitado. El servidor procesa la solicitud y responde con la direccion IP correspondiente.
Cliente (Navegador) <-----> Servidor (DNS)
        |                           |
        |---- Solicitud DNS ------->|
        |<--- Respuesta DNS --------|
```

# Historia de DNS

En un principio, los nombres de dominio eran gestionados por un archivo llamado `hosts.txt`, que contenía una lista de nombres de dominio y sus direcciones IP correspondientes. Este archivo era mantenido por la empresa SRI (Stanford Research Institute) y distribuido a todos los usuarios de ARPANET. 

Surgian problema como el crecimiento de la red y la dificultad de mantener actualizado el archivo `hosts.txt`, lo que llevó a la necesidad de un sistema más escalable y eficiente para la resolución de nombres de dominio.

Entonces, en 1983, Paul Mockapetris propuso el sistema de nombres de dominio (DNS) como una solución a estos problemas. El DNS permitió la descentralización de la gestión de nombres de dominio y la creación de una jerarquía de servidores que podían resolver nombres de dominio de manera eficiente.

Se creo el esquema de nombres de dominio jerarquico, donde los nombres de dominio se organizan en niveles, con el nivel superior (TLD) representando los dominios de primer nivel como .com, .org, .net, etc. Los servidores DNS se encargan de resolver los nombres de dominio en direcciones IP correspondientes.

Clientes-> Servidores Resolvedores-> Servidores Autoritativos -> Servidores Raiz

Tipos de registros 

A 

AAAA

NS 

SOA 

