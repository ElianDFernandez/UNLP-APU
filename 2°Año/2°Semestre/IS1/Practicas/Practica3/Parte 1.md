## Parte I: Definiciones generales
* A-Describir qué es el desarrollo centrado en el usuario.
* B-Definir qué son los casos de uso y describa cómo se utilizan.
* C-Definir qué es un actor y un escenario.
* D-Definir las relaciones que pueden presentarse en el diagrama de casos de uso. Describa cuándo se utiliza cada una.
* E-Enumerar los beneficios de modelar requerimientos del sistema con casos de uso.

### A. Desarrollo Centrado en el Usuario
El desarrollo centrado en el usuario (DCU) es un enfoque en el diseño y desarrollo de sistemas, aplicaciones o productos que pone como prioridad las necesidades, expectativas y características de los usuarios finales. Este enfoque se basa en la comprensión profunda de los usuarios y en involucrarlos activamente durante el proceso de desarrollo, con el objetivo de crear soluciones que sean intuitivas, accesibles y que respondan adecuadamente a sus problemas y objetivos.

El DCU involucra iteraciones constantes de pruebas y retroalimentación del usuario, mejorando así la experiencia y funcionalidad a medida que el producto evoluciona.

### B. Casos de Uso
Los casos de uso son descripciones detalladas de cómo un sistema interactúa con actores externos (como usuarios o sistemas) para lograr un objetivo específico. Cada caso de uso detalla una secuencia de acciones o eventos que permiten a un actor (generalmente un usuario) lograr un resultado concreto dentro del sistema.

Utilización:

Se emplean para documentar los requisitos funcionales del sistema.
Ayudan a visualizar cómo los usuarios interactuarán con el sistema.
Proveen un marco que facilita la planificación y el diseño de la funcionalidad del sistema.
Los casos de uso se utilizan comúnmente en la etapa de análisis y diseño del software.
C. Actor y Escenario
Actor: Un actor es cualquier entidad externa que interactúa con el sistema, puede ser una persona, otro sistema o una organización que tiene un interés particular en el sistema. Los actores no son parte del sistema, pero se comunican con él para iniciar o recibir acciones. Por ejemplo, en un sistema bancario, un actor podría ser un cliente que utiliza el cajero automático.

Escenario: Un escenario es una secuencia específica de acciones que describen cómo un actor interactúa con el sistema en una situación particular. Puede ser una instancia específica de un caso de uso. Por ejemplo, en un sistema de compra online, un escenario sería un cliente que selecciona productos, los coloca en su carrito y procede al pago.

### D. Relaciones en un Diagrama de Casos de Uso
En los diagramas de casos de uso, existen varias relaciones que describen cómo interactúan los casos de uso entre sí:

* Asociación:

La asociación es la relación básica que se dibuja entre un actor y un caso de uso en un diagrama de casos de uso. Esta relación indica que el actor interactúa con el sistema para realizar el caso de uso. La asociación no indica dirección ni ningún tipo de comportamiento especial, simplemente muestra que hay una comunicación entre el actor y el caso de uso.

Uso: Se utiliza para mostrar que un actor participa o interactúa con uno o más casos de uso.

Ejemplo: En un sistema de cajero automático, el actor "Cliente" tiene una asociación con el caso de uso "Retirar dinero". Esto significa que el cliente puede ejecutar ese caso de uso, es decir, interactúa con el sistema para retirar dinero.

* Inclusión («Include»):

Se utiliza cuando un caso de uso es parte de otro, es decir, cuando un caso de uso incluye el comportamiento de otro. Es útil para reducir la duplicación de comportamientos comunes en varios casos de uso.
Ejemplo: Un caso de uso "Realizar pago" puede incluir el caso de uso "Validar tarjeta de crédito".

* Extensión («Extend»):

Representa un comportamiento opcional que puede extender el comportamiento de un caso de uso base, generalmente bajo ciertas condiciones.
Ejemplo: Un caso de uso "Consultar saldo" puede ser extendido por "Mostrar alertas de cuenta" si hay problemas en la cuenta.

* Herencia:

Es una relación jerárquica en la que un caso de uso hijo hereda el comportamiento del caso de uso padre, permitiendo la reutilización del comportamiento común y la especialización de algunos detalles.
Ejemplo: Un caso de uso "Realizar pago" puede tener hijos como "Pago con tarjeta" y "Pago con PayPal".

### E. Beneficios de Modelar Requerimientos con Casos de Uso
* Claridad en la comunicación: Los casos de uso permiten describir de manera clara y comprensible para todas las partes involucradas (desarrolladores, clientes, usuarios) cómo interactúa el usuario con el sistema.

* Facilita la captura de requisitos funcionales: Ayuda a definir qué debe hacer el sistema y a comprender las expectativas de los usuarios.

* Mejor gestión del alcance del proyecto: Al modelar las interacciones clave, se puede controlar mejor qué funcionalidades son esenciales y cuáles son opcionales.

* Documentación sencilla y accesible: Proveen una manera gráfica y textual de describir los requisitos del sistema, lo que facilita su comprensión y mantenimiento.

* Soporte para la validación y pruebas: Los casos de uso pueden utilizarse como base para la creación de casos de prueba, permitiendo validar que el sistema cumpla con los requisitos especificados.

* Mejora de la planificación del desarrollo: Proveen una estructura clara para identificar prioridades en el desarrollo y dividir tareas en módulos manejables.