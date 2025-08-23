# TP N°1
Temas 
* GNU/LINUX
* Instalacion y conceptos basicos
* Permisos 
* Arranque 
* Usuarios 
* Organizacion Internga

## Caracteristicas de GNU/Linux: 
**A-Mencione y explique las caracteristicas mas relevantes de GNU/Linux**
- **Software Libre:** El código fuente está disponible para todos, permitiendo modificar y distribuir el sistema.
- **Multitarea y Multiusuario:** Permite que varios usuarios trabajen simultáneamente y ejecutar múltiples procesos a la vez.
- **Estabilidad y Seguridad:** Es conocido por su robustez y bajo nivel de vulnerabilidades.
- **Portabilidad:** Puede ejecutarse en diferentes arquitecturas de hardware.
- **Gran Comunidad:** Cuenta con soporte y desarrollo continuo por parte de usuarios y desarrolladores de todo el mundo.
- **Personalización:** Se puede adaptar el entorno y las herramientas según las necesidades del usuario.

**B-Mencione otros sistemas operativos y comparelos con GNU/Linux encuanto a los puntos mencionados en el incisico a**
- **Windows:**
  - Software Propietario: No es de código abierto, lo que limita la personalización y distribución.
  - Multitarea y Multiusuario: Soporta multitarea, pero el soporte multiusuario es limitado en versiones domésticas.
  - Estabilidad y Seguridad: Más vulnerable a malware y virus debido a su popularidad.
  - Portabilidad: Principalmente diseñado para arquitecturas x86.
  - Comunidad: Menor participación comunitaria en comparación con GNU/Linux.
  - Personalización: Limitada en comparación con GNU/Linux.

- **macOS:**
  - Software Propietario: Al igual que Windows, no es de código abierto.
  - Multitarea y Multiusuario: Soporta multitarea y tiene un enfoque más fuerte en la experiencia del usuario.
  - Estabilidad y Seguridad: Conocido por su estabilidad, pero también es un objetivo para malware.
  - Portabilidad: Diseñado para hardware específico de Apple.
  - Comunidad: Menor que GNU/Linux, pero con un fuerte apoyo de desarrolladores.
  - Personalización: Limitada en comparación con GNU/Linux.

**C-Que es GNU?**
GNU (GNU's Not Unix) es un proyecto iniciado por Richard Stallman en 1983 con el objetivo de crear un sistema operativo completamente libre. El proyecto GNU proporciona una colección de software libre que incluye herramientas y utilidades esenciales para el funcionamiento de un sistema operativo. Aunque el núcleo del sistema operativo GNU no se completó en su totalidad, el proyecto sentó las bases para el desarrollo de sistemas operativos libres, siendo Linux uno de los núcleos más utilizados en combinación con las herramientas de GNU.

En resumen, GNU es un esfuerzo por crear un sistema operativo libre y completo, y su legado perdura en la forma de muchas distribuciones de Linux que utilizan sus herramientas y principios.
Linux, como núcleo, se combina con las herramientas de GNU para formar un sistema operativo completo y funcional, conocido como GNU/Linux.

**D-Indique una breve historia sobre la evolucion del proyecto GNU**
El proyecto GNU fue anunciado por Richard Stallman en 1983 como una respuesta a la creciente falta de libertad en el software. Stallman, un programador y activista del software libre, se dio cuenta de que los usuarios de computadoras estaban perdiendo el control sobre sus sistemas debido a la proliferación de software propietario. En 1985, fundó la Free Software Foundation (FSF) para apoyar el desarrollo de software libre y promover la libertad de los usuarios.
A lo largo de los años, el proyecto GNU desarrolló una serie de herramientas y utilidades, incluyendo el compilador GCC, el editor de texto Emacs y el sistema de control de versiones CVS. Sin embargo, el núcleo del sistema operativo GNU, conocido como Hurd, no se completó en su totalidad.
En 1991, Linus Torvalds lanzó el núcleo Linux, que rápidamente ganó popularidad y se convirtió en una alternativa viable al núcleo Hurd. A medida que más usuarios comenzaron a utilizar Linux junto con las herramientas de GNU, el término "GNU/Linux" se popularizó para describir esta combinación.
Hoy en día, el proyecto GNU sigue siendo un pilar fundamental del movimiento del software libre, y muchas distribuciones de Linux continúan utilizando sus herramientas y principios.

**E-Explique que es la multitarea, e indique si GNU/Linux hace uso de ella**
La multitarea es la capacidad de un sistema operativo para ejecutar múltiples tareas o procesos simultáneamente. Esto permite que los usuarios realicen varias operaciones al mismo tiempo, como editar documentos, navegar por la web y reproducir música, sin que una tarea interfiera con otra.
GNU/Linux hace uso de la multitarea a través de su núcleo, que gestiona la ejecución de procesos y la asignación de recursos del sistema. Utiliza técnicas como la planificación de procesos y la gestión de memoria para garantizar que múltiples tareas puedan ejecutarse de manera eficiente y sin conflictos. Esto hace que GNU/Linux sea una opción popular para servidores y estaciones de trabajo que requieren un alto rendimiento y capacidad de respuesta.

**F-Que es POSIX?**
POSIX (Portable Operating System Interface) es un conjunto de estándares que especifican la interfaz de programación de aplicaciones (API), así como los comandos y utilidades de un sistema operativo. Su objetivo es facilitar la portabilidad de aplicaciones entre diferentes sistemas operativos compatibles. POSIX define aspectos como la gestión de procesos, la manipulación de archivos y la comunicación entre procesos, lo que permite a los desarrolladores escribir software que pueda ejecutarse en múltiples plataformas sin necesidad de modificaciones significativas.