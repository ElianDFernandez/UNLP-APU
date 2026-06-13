# Frameworks

Proveen una soucion resusable para una familia de aplicaciones. Es un conjunto de clases, interfaces y herramientas que facilitan el desarrollo de software al proporcionar una estructura predefinida y componentes reutilizables.

## Diferencia entre Frameworks y Librerías
- **Frameworks**: Proveen una estructura completa para el desarrollo de aplicaciones, controlando el flujo de la aplicación y permitiendo a los desarrolladores agregar su propia lógica en áreas específicas. El framework dicta cómo se debe organizar el código y cómo interactúan los componentes.

- **Librerías**: Son colecciones de funciones y clases que los desarrolladores pueden utilizar para realizar tareas específicas, pero no imponen una estructura o flujo de control. El desarrollador tiene la libertad de decidir cómo organizar el código y cuándo utilizar las funciones de la librería.

## Características de los Frameworks
- **Inversión de Control (IoC)**: El framework controla el flujo de la aplicación, en lugar de que el desarrollador lo haga. Esto permite una mayor flexibilidad y modularidad.
- **Reutilización de Código**: Proveen componentes y funcionalidades predefinidas que pueden ser reutilizadas en diferentes proyectos, lo que acelera el desarrollo.
- **Estandarización**: Promueven buenas prácticas y patrones de diseño, lo que ayuda a mantener un código limpio y organizado.
- **Extensibilidad**: Permiten a los desarrolladores extender y personalizar su funcionalidad según las necesidades específicas de la aplicación.

## Tipos de Frameworks

- **Aplicacion:** desktop, webapps, tcpservers -> Son aquellos que se utilizan para desarrollar aplicaciones específicas, como aplicaciones de escritorio, aplicaciones web o servidores TCP.

- **Manejo de datos:** ORDB, pipelines, NRDB -> Estos frameworks se centran en la gestión y manipulación de datos, como bases de datos relacionales, pipelines de procesamiento de datos o bases de datos NoSQL.

- **Testing:** unitarios, de integración, funcionales -> Frameworks diseñados para facilitar la creación y ejecución de pruebas unitarias, pruebas de integración y pruebas funcionales.

- **Sistemas distribuidos:** microservicios, SOA -> Frameworks que ayudan en el desarrollo de sistemas distribuidos, como microservicios o arquitecturas orientadas a servicios (SOA).

## White-box vs Black-box
- **White-box**: El desarrollador tiene acceso al código fuente del framework y puede modificarlo según sus necesidades. Esto permite una mayor personalización, pero también requiere un mayor conocimiento del framework

- **Black-box**: El desarrollador utiliza el framework sin tener acceso al código fuente. Esto facilita su uso, pero limita la capacidad de personalización y puede requerir adaptarse a las limitaciones del framework.

## HotSpots vs Frozen Spots
- **HotSpots**: Son las partes del framework que están diseñadas para ser personalizadas o extendidas por los desarrolladores. Estas áreas permiten a los desarrolladores agregar su propia lógica o funcionalidad sin modificar el núcleo del framework.

- **Frozen Spots**: Son las partes del framework que no están destinadas a ser modificadas por los desarrolladores. Estas áreas contienen la lógica central del framework y deben permanecer intactas para garantizar su correcto funcionamiento.

## TCP Servers
Un TCP server es un tipo de servidor que utiliza el protocolo de control de transmisión (TCP) para establecer conexiones y comunicarse con los clientes.
Los TCP servers son frameworks de JAVA que permiten a los desarrolladores crear aplicaciones de red que pueden manejar múltiples conexiones simultáneamente. Estos servidores proporcionan una estructura para gestionar las conexiones, enviar y recibir datos, y manejar eventos de red de manera eficiente.
Existe tanto en su forma white-box como black-box, dependiendo de si el desarrollador tiene acceso al código fuente del framework o no. Además, los TCP servers pueden tener hotspots para personalizar la lógica de manejo de conexiones y frozen spots para mantener la integridad del núcleo del framework.

## Diseño de Frameworks

- Frameworks estan diseñados para reuso
    * Instaciacion
    * Extenseion

