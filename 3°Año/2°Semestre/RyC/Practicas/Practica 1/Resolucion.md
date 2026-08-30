# Práctica 1 - Introducción

---

## 1. ¿Qué es una red? ¿Cuál es el principal objetivo para construir una red?

Desde el punto de vista sistémico, una red es un grupo de computadoras/dispositivos interconectados por algún medio. Los dispositivos pueden comunicarse entre sí y compartir recursos. El conjunto de computadoras y software de red, medios y dispositivos de interconexión forma un sistema de comunicación.

---

## 2. ¿Qué es Internet? Describa los principales componentes que permiten su funcionamiento.

Internet es una red de redes de computadoras, descentralizada, pública que ejecutan el conjunto abierto de protocolos (suite) TCP/IP.

- **Routers:** Dispositivos que encaminan los paquetes de datos entre redes.
- **Servidores:** Computadoras que proporcionan servicios a otras computadoras en la red.
- **Proveedores de servicios de Internet (ISP):** Empresas que proporcionan acceso a Internet a los usuarios.
- **Infraestructura física:** Cables, satélites, torres de comunicación y otros medios que permiten la transmisión de datos.
- **Protocolos:** Conjunto de reglas y estándares que permiten la comunicación entre dispositivos en la red.

---

## 3. ¿Qué son las RFCs?

Las RFCs (Request for Comments) son documentos que describen estándares, protocolos y tecnologías relacionadas con Internet. Son publicados por la IETF (Internet Engineering Task Force) y sirven como referencia para desarrolladores y profesionales de redes.

---

## 4. ¿Qué es un protocolo?

Un protocolo es un conjunto de reglas y convenciones que permiten la comunicación entre dispositivos en una red. Define cómo se deben enviar, recibir y procesar los datos para garantizar una comunicación efectiva y sin errores.

---

## 5. ¿Por qué dos máquinas con distintos sistemas operativos pueden formar parte de una misma red?

Los protocolos de comunicación utilizados en la red son independientes del sistema operativo. Mientras ambos dispositivos implementen los mismos protocolos de red, podrán comunicarse entre sí sin problemas.

---

## 6. ¿Cuáles son las 2 categorías en las que pueden clasificarse a los sistemas finales o End Systems? Dé un ejemplo del rol de cada uno en alguna aplicación distribuida que corra sobre Internet.

Los sistemas finales o End Systems pueden clasificarse en dos categorías: **clientes** y **servidores**.

- **Cliente:** Un dispositivo que solicita servicios o recursos de otro dispositivo en la red. Ejemplo: Un navegador web que solicita páginas web desde un servidor.
- **Servidor:** Un dispositivo que proporciona servicios o recursos a otros dispositivos en la red. Ejemplo: Un servidor de correo electrónico que recibe y envía correos electrónicos a los clientes.

---

## 7. ¿Cuál es la diferencia entre una red conmutada de paquetes de una red conmutada de circuitos?

La diferencia radica en cómo se transmiten los datos:

- **Red conmutada de paquetes:** Los datos se dividen en paquetes que se envían de manera independiente a través de la red. Cada paquete puede tomar rutas diferentes y llegar en un orden distinto al destino. Ejemplo: Internet.
- **Red conmutada de circuitos:** Se establece un canal dedicado entre el emisor y el receptor durante toda la comunicación. Todos los datos se transmiten a través de este canal, garantizando un flujo continuo. Ejemplo: Telefonía tradicional.

---

## 8. Analice qué tipo de red es una red de telefonía y qué tipo de red es Internet.

Una red de telefonía es una red conmutada de circuitos, ya que establece un canal dedicado para la comunicación entre dos partes durante la llamada. Internet, por otro lado, es una red conmutada de paquetes, donde los datos se dividen en paquetes y se envían de manera independiente a través de la red.

---

## 9. Describa brevemente las distintas alternativas que conoce para acceder a Internet en su hogar.

Para acceder a Internet desde mi hogar todo empieza de un cable (fibra óptica, coaxial o par trenzado) que llega a mi casa desde el proveedor de servicios de internet (ISP). Este cable se conecta a un router, que convierte la señal del ISP en una señal que puede ser utilizada por los dispositivos de mi hogar. Luego, los dispositivos (computadoras, teléfonos, tabletas, etc.) se conectan al router mediante Wi-Fi o cables Ethernet para acceder a Internet.

---

## 10. ¿Qué ventajas tiene una implementación basada en capas o niveles?

- Reduce la complejidad del diseño de la red al dividirla en partes más manejables.
- Las capas de abajo ocultan la complejidad de las capas superiores, permitiendo que los desarrolladores se concentren en una capa a la vez.
- Las capas de arriba utilizan servicios de las de abajo.
- Los cambios en una capa no deberían afectar a las demás si la interfaz se mantiene.
- Facilita el desarrollo y la implementación de nuevos protocolos y tecnologías, ya que se pueden modificar o reemplazar capas individuales sin afectar a toda la red.
- Facilita el aprendizaje, diseño y administración.

---

## 11. ¿Cómo se llama la PDU de cada una de las siguientes capas: Aplicación, Transporte, Red y Enlace?

| Capa         | PDU              |
|--------------|------------------|
| Aplicación   | Mensaje o Datos  |
| Transporte   | Segmento (TCP) / Datagrama (UDP) |
| Red          | Paquete          |
| Enlace       | Trama (Frame)    |

---

## 12. ¿Qué es la encapsulación? Si una capa realiza la encapsulación de datos, ¿qué capa del nodo receptor realizará el proceso inverso?

La encapsulación es el proceso mediante el cual los datos de una capa se envuelven en una PDU de la capa inferior antes de ser transmitidos a través de la red. Cada capa agrega su propia información de control (como encabezados y pies de página) a los datos que recibe de la capa superior. En el nodo receptor, **la capa correspondiente** (misma capa que encapsuló en el emisor) realizará el proceso inverso, llamado desencapsulación, para extraer los datos originales y procesarlos adecuadamente.

---

## 13. Describa cuáles son las funciones de cada una de las capas del stack TCP/IP o protocolo de Internet.

- **Capa de Aplicación:** Proporciona servicios de red a las aplicaciones del usuario, como correo electrónico, navegación web y transferencia de archivos.
- **Capa de Transporte:** Garantiza la entrega confiable de datos entre aplicaciones en diferentes dispositivos, gestionando la segmentación, el control de flujo y la corrección de errores. Protocolos comunes incluyen TCP (Transmission Control Protocol) y UDP (User Datagram Protocol).
- **Capa de Red:** Se encarga del enrutamiento y la entrega de paquetes de datos entre dispositivos en diferentes redes. Utiliza direcciones IP para identificar dispositivos y determinar la mejor ruta para los datos. El protocolo principal es IP (Internet Protocol).
- **Capa de Enlace:** Proporciona la transmisión de datos entre dispositivos en la misma red local, gestionando el acceso al medio físico y la detección de errores. Protocolos comunes incluyen Ethernet y Wi-Fi.

---

## 14. Compare el modelo OSI con la implementación TCP/IP.

| Característica  | Modelo OSI                                                    | Implementación TCP/IP                        |
|-----------------|---------------------------------------------------------------|----------------------------------------------|
| Número de capas | 7                                                             | 4                                            |
| Capas           | Aplicación, Presentación, Sesión, Transporte, Red, Enlace, Física | Aplicación, Transporte, Red, Enlace      |
| Enfoque         | Teórico, estandarizado                                        | Práctico, basado en protocolos existentes    |
| Flexibilidad    | Más flexible, permite la adición de nuevas capas              | Menos flexible, pero más eficiente en la práctica |
| Adopción        | Menos adoptado en la práctica                                 | Ampliamente adoptado y utilizado en Internet |
| Usabilidad      | Más complejo de implementar                                   | Más sencillo de implementar y mantener       |

