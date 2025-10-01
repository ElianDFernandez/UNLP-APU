# Caracteristicas de GNU/Linux: 
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

## Distribuciones de GNU/Linux
**A-Que es una distribucion de GNU/Linux? Nombre al menos 4 distribuciones de GNU/Linux y cite diferencias basicas entre ellas.
Una distribucion es un conjunto de aplicaciones runidas que permiten brindar mejoras para instalar facilmente un sistema operativo basado en GNU/Linux. Son "sabores" de GNU/Linux que, en genreal se diferencian entre si por las herramientas para configuracion y sistemas de administracion de paquetes de software para instalar. La eleccion de una distribucion depende de las necesidades del usuario y de gustos personales.

Distribuciones mas conocidas:
- Ubuntu: Conocida por su facilidad de uso y amplia comunidad de soporte. Utiliza el sistema de paquetes APT.
- Fedora: Enfocada en la innovación y la inclusión de las últimas tecnologías. Utiliza el sistema de paquetes DNF.
- Arch Linux: Conocida por su filosofía de "hazlo tú mismo" y su enfoque en la personalización. Utiliza el sistema de paquetes Pacman.
- Debian: Conocida por su estabilidad y robustez. Utiliza el sistema de paquetes APT.

**B-En que se diferencia una distribucion de otra?
Las distribuiones de linux tienen en comun el kernel, pero el resto de componentes(Las herramientas, la sheel, el display server, la GUI) varian entre si, se personalizan o sea crean desde cero, por eso las distribuciones son tan diferentes entre si. Aunque en la mayoria de los casos la principal diferencia es la GUI(gráfica de usuario), o los programas y herramientas que vienen incluidos.

**C-Que es Debian? Accede al sitio e indique cuales son los objetivos del proyecto y una breve cronologia del mismo
El proyecto Debian es una comunidad de desarrolladores y usuarios que trabajan juntos para crear un sistema operativo basado en GNU/Linux. Sus objetivos incluyen proporcionar un sistema operativo libre y de alta calidad, fomentar la colaboración y la transparencia, y garantizar la seguridad y estabilidad del sistema.
A lo largo de su historia, Debian ha sido pionero en muchas áreas, como la gestión de paquetes y la creación de un sistema de lanzamiento regular.

Cronología breve:
- 1993: Se funda el proyecto Debian.
- 1996: Se lanza la primera versión oficial de Debian.
- 2005: Se establece el contrato social de Debian.
- 2015: Se lanza Debian 8 "Jessie", que incluye importantes mejoras en la seguridad y la estabilidad.
- 2021: Se lanza Debian 11 "Bullseye", con actualizaciones de software y mejoras en la instalación.

# Estructura de GNU/Linux
**A-Nombre cuales son los 3 componentes fundamentales de GNU/Linux**
- Kernel (nucleo)
- Shell (Interprete de comandos)
- FileSystem (Sistema de archivos)

**B-Mencione y explique la estructura basica del sistema operativo GNU/Linux**
La estructura básica del sistema operativo GNU/Linux se compone de varias capas que interactúan entre sí. Estas capas incluyen:

1. **Capa de hardware**: Es la capa más baja y se refiere a los componentes físicos de la computadora, como la CPU, la memoria y los dispositivos de almacenamiento.
2. **Capa del kernel**: El kernel es el núcleo del sistema operativo y se encarga de gestionar los recursos del hardware, así como de proporcionar servicios básicos a las aplicaciones. Se encarga de la comunicación entre el hardware y el software.

3. **Capa de sistema de archivos**: Esta capa se encarga de la organización y gestión de los archivos en el sistema. Proporciona una estructura jerárquica para almacenar y acceder a los datos.

4. **Capa de shell**: El shell es la interfaz de usuario que permite a los usuarios interactuar con el sistema operativo. Puede ser una interfaz de línea de comandos o una interfaz gráfica de usuario (GUI).

5. **Capa de aplicaciones**: En la parte superior de la pila se encuentran las aplicaciones de usuario, que son los programas que los usuarios utilizan para realizar tareas específicas, como navegadores web, editores de texto y herramientas de desarrollo.

## Kernel 
**A-Que es? Indique una breve reseña historica acerca de la evolucion del kernel de GNU/Linux**
El kernel es la parte fundamental de un sistema operativo. El Kernel o nucleo de linux se podria definir como el corazon de este sistema operativo. Es, a grandes rasgos, el encargado de que el software y el hardware de una computadora puedan trabajar juntos. 

Historia:
- 1991: Linus Torvalds anuncia el desarrollo del kernel de Linux.
- 1994: Se lanza la versión 1.0 del kernel de Linux.
- 2001: Se lanza la versión 2.4 del kernel, que incluye soporte para arquitecturas de hardware adicionales.
- 2005: Se lanza la versión 2.6 del kernel, que introduce mejoras significativas en el rendimiento y la escalabilidad.
- 2011: Se lanza la versión 3.0 del kernel, que marca el final de la serie 2.x.
- 2021: Se lanza la versión 5.10 del kernel, que incluye mejoras en la seguridad y el soporte de hardware.

Las versiones del kernel se especifican siguiendo la nomenclatura A.B.C.D:

- A: Número de versión principal (major)
- B: Número de versión secundaria (minor)
- C: Número de versión de corrección (patch) ->Solo cuando hay nuevos drivers o caracteristicas.
- D: Número de versión de desarrollo (development) -> Cambia cuando se corrige un grave error sin agregar nuevas funcionalidades. Casi no se usa.

Ejemplo pequeño de un segmento del codigo del kernel de linux(Lenguaje C):

````
  #include <linux/init.h>
  #include <linux/module.h>

  MODULE_LICENSE("GPL");
  MODULE_AUTHOR("Tu Nombre");
  MODULE_DESCRIPTION("Un ejemplo simple de un modulo del kernel");

  static int __init mi_modulo_init(void)
  {
      printk(KERN_INFO "Hola, mundo desde mi modulo del kernel!\n");
      return 0;
  }

  static void __exit mi_modulo_exit(void)
  {
      printk(KERN_INFO "Adios, mundo desde mi modulo del kernel!\n");
  }

  module_init(mi_modulo_init);
  module_exit(mi_modulo_exit);
````

**B-Cuales son sus funciones principales?**
Sus funciones mas importante son la gestion de recursos del sistema, la comunicacion entre hardware y software, y la proporcion de servicios basicos a las aplicaciones.

**C-Cual es la version actual? Como se definia el esquema de versionado del kernel en versiones anteriores a la 2.4? Que cambio en el versionado se impuso a partir de la version 2.6?**
La versión principal más reciente del kernel de Linux es la 6.16.4, lanzada el 28-08-2025.
En versiones anteriores a las 2.4, los numero pares indicaban la version "estable" lanzada. Por ejemplo, la version 2.4 era estable, mientras que la 2.5 era de desarrollo. A partir de la version 2.6, se abandono este esquema y se adopto un sistema de versionado secuencial, donde cada nueva version, ya sea par o impar, puede ser estable o de desarrollo.

**D-Es posible tener mas de un kernel de GNU/Linux instalado en la misma maquina?**
Se pueden tener varios instalados. Pero en realidad estaria funcionando solo uno, ya que es la parte de un sistema operativo que administra y controla los recursos y procesos.

**E-Donde se encuentra ubicado dentro del file system?**
En /boot. El primer sector del disco se llama boot sector. Contiene informacion general de donde se almacena el kernel y como se arranca.

**F-El kernel de GNU/Linux es monolitico?**
Si, el kernel de GNU/Linux es considerado monolítico, ya que incluye todos los controladores y servicios en un solo espacio de direcciones. Esto permite un alto rendimiento y una comunicación eficiente entre los componentes del kernel, pero también significa que un fallo en un controlador puede afectar a todo el sistema.

## Interprete de comandos (Shell)
**A-Que es?**
El shell es el programa que recibe lo que se escribe en la terminal y lo convierte en intrucciones para el sistema operativo.

**B-Cuales son sus funciones?**
Sus funciones incluyen la ejecución de comandos, la gestión de procesos, la redirección de entrada/salida y la interpretación de scripts.

**C-Mencione al menos 3 interpretes de comandos que posee GNU/Linux y comparelos entre ellos**
- Bash: Es el intérprete de comandos por defecto en muchas distribuciones de GNU/Linux. Soporta scripting avanzado y tiene una gran cantidad de características.
- Zsh: Es similar a Bash, pero incluye características adicionales como autocompletado mejorado y globbing avanzado. Es muy personalizable.
- Fish: Es un intérprete de comandos más moderno que se centra en la facilidad de uso y la interactividad. Tiene una sintaxis más amigable y características como sugerencias de comandos en tiempo real.

**D-Donde se ubican (path) los comandos propios y externos al shell?**
El shell nos permite ejecutar
Comandos externos: 
- Son programas ajenos al shell
- Cuando se lanzan inician un nuevo proceso
- Se buscan en los directorios indicados en la variable PATH.

comandos internos:
- Son aquellos que forman parte del shell
- No inician un nuevo proceso

En bash, para saber si un comando es interno o externo, se puede utilizar el comando `type`. Por ejemplo:
```bash
type ls
```
La diferencia fundamental es que los internos estan incorporados a la consola y se pueden ejecutar directamente, mientras que para los externos hay que indicar la ruta hasta la ubicacion del comando. 
Para los comandos internos puede ser que no tengamos que indicar la ruta hasta la ubicacion del mismo de forma explicita, si esta ruta esta incluida en la variable de entorno PATH.
Tambien debemos tener precaucion en el caso de que el comando exista tanto de forma externa como interna, ya que las dos versiones del comando pueden dar resultados distintos, por lo que si queremos estar seguros de que estamos ejecutando la version externa debemos indicar la ruta del comando.

**E-Porque considera que el shell no es parte del Kernel de GNU/Linux?**
La shell no forma parte del kernel, si no que es la encarga de "dialogar" con el. 
Como la shell se usa para interpretar las ordenes del usuario y ejecutarlas, si el mismo estuviese en el kernel tendria acceso a intrucciones propias que usa el SO para la gestion de distintos dispositivos del hardware. Razon por la cual se abstrae al usuario del manejo de dispositivos hardware, dejandolo al kernel.

**F-Es posible definir un interprete de comandos distinto para cada usuario? Desde donde se define? Cualquier usuario puede realizar dicha tarea?**
Si es posible definir un interprete de comandos distinto para cada usuario ya que la shell es iniciada por un proceso denominado "login" en donde cada usuario tiene asignado una shell por defecto que se puede personalizar, la misma se inicia cada vez que un usuario comienza a trabajar en su estacion de trabajo(es decir se "loguea" en una terminal). Dentro del contenido del archivo /etc/passwd, se puede ver cual es la shell que cada usuario tiene asignada por defecto. Las shell son programables por cada usuario en su archivo de configuracion personal, que suele ser un archivo oculto en su directorio home (por ejemplo, ~/.bashrc para Bash).

## Sistema de archivos (File System)
