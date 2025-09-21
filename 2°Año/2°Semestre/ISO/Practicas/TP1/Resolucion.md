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
**A-Que es?**
Es la forma en que dentro de un sistema de computo se organizan y se administran los archivos. Esta administracion comprende:
- Metodo de accesso: como se acceden los datos contenidos en los archivos.
- Manejo de archivos: como se crean, modifican y eliminan los archivos.
- Manejo de la memoria secundaria: como se administra el espacio para los archivos en memoria secundaria.
- Mecanismo de integridad: Con que metodos se garantiza la incorruptibilidad del archivo.

**B-Cual es la estrcutura basica de los File System en GNU/Linux? Mencione los directorios mas importantes e indique que tipo de informacion se encuentra en ellos. A que hace referencia la siga FHS?**
La estructura básica del sistema de archivos en GNU/Linux se organiza en un árbol jerárquico de directorios. Algunos de los directorios más importantes son:

- `/`: El directorio raíz, que contiene todos los demás directorios.
- `/bin`: Contiene los comandos esenciales del sistema que son necesarios para el funcionamiento básico.
- `/etc`: Contiene archivos de configuración del sistema.
- `/home`: Contiene los directorios personales de los usuarios.
- `/lib`: Contiene bibliotecas compartidas necesarias para los programas en `/bin` y `/sbin`.
- `/usr`: Contiene aplicaciones y archivos de usuario, incluyendo subdirectorios como `/usr/bin` para programas y `/usr/lib` para bibliotecas.
- `/var`: Contiene archivos de datos variables, como registros del sistema y bases de datos.

La sigla FHS hace referencia a "Filesystem Hierarchy Standard", que es un estándar que define la estructura y organización de los sistemas de archivos en sistemas operativos tipo Unix, incluyendo GNU/Linux.

**C-Menciones sistemas de archivos soportados por GNU/Linux**
- ext4
- Btrfs
- XFS
- JFS
- ReiserFS

**D-Es posible visualizar particiones del tipo FAT y NTFS(que son de windows) en GNU/Linux?**
Si, es posible visualizar particiones FAT y NTFS en GNU/Linux. Para ello, se utilizan controladores y herramientas específicas que permiten montar y acceder a estos sistemas de archivos. Por ejemplo, el paquete `ntfs-3g` permite el acceso completo a particiones NTFS, mientras que el soporte para FAT está integrado en el kernel de Linux.

## Particiones

**A-Definicion, Tipos de particiones. Ventajas y desventajas de cada una**
Una partición es una división lógica de un disco duro que permite organizar y gestionar el espacio de almacenamiento de manera eficiente. Existen varios tipos de particiones, entre los más comunes se encuentran:
- **Particiones primarias**: Son las particiones principales del disco y pueden contener sistemas operativos. Un disco puede tener hasta cuatro particiones primarias o tres primarias y una extendida. Ventajas: Son necesarias para arrancar sistemas operativos. Desventajas: Limitación en el número de particiones.
- **Particiones extendidas**: Son una solución para superar la limitación de las particiones primarias. Una partición extendida puede contener múltiples particiones lógicas. Ventajas: Permiten crear más de cuatro particiones en un disco. Desventajas: No pueden contener sistemas operativos directamente.
- **Particiones lógicas**: Son las particiones que se encuentran dentro de una partición extendida. Ventajas: Flexibilidad para crear múltiples particiones. Desventajas: Requieren una partición extendida para existir.
- **Particiones swap**: Son utilizadas por el sistema operativo para gestionar la memoria virtual. Ventajas: Mejoran el rendimiento del sistema cuando la memoria RAM es insuficiente. Desventajas: No son utilizadas para almacenar datos permanentes.
- **Particiones EFI**: Utilizadas en sistemas con UEFI para almacenar archivos de arranque. Ventajas: Necesarias para sistemas modernos. Desventajas: Requieren un formato específico (FAT32).

**B-Como se identifican las particiones en GNU/Linux? (Considere discos IDE, SCSI y SATA)**
En GNU/Linux, las particiones se identifican mediante nombres de dispositivos que siguen un esquema específico según el tipo de disco:
- **Discos IDE**: Se identifican como `/dev/hda`, `/dev/hdb`, etc., y las particiones se numeran como `/dev/hda1`, `/dev/hda2`, etc.
- **Discos SCSI y SATA**: Se identifican como `/dev/sda`, `/dev/sdb`, etc., y las particiones se numeran como `/dev/sda1`, `/dev/sda2`, etc.
- **Discos NVMe**: Se identifican como `/dev/nvme0n1`, `/dev/nvme0n2`, etc., y las particiones se numeran como `/dev/nvme0n1p1`, `/dev/nvme0n1p2`, etc.

**C-Cuantas particiones son necesarias como minimo para instalar GNU/Linux? Nombrelas indicando el tipo de particion, idencificador, sistema de archivos y putno de arranque**
Para instalar GNU/Linux, se necesitan al menos dos particiones:
1. **Partición raíz (/)**
   - Tipo de partición: Primaria o lógica
   - Identificador: `/dev/sda1` (ejemplo)
   - Sistema de archivos: ext4 (comúnmente utilizado)
   - Punto de montaje: `/`
   - Función: Contiene el sistema operativo y todos los archivos necesarios para su funcionamiento.
2. **Partición swap**
    - Tipo de partición: Primaria o lógica
    - Identificador: `/dev/sda2` (ejemplo)
    - Sistema de archivos: swap
    - Punto de montaje: No tiene punto de montaje, se utiliza como espacio de intercambio de memoria.
    - Función: Proporciona memoria virtual adicional cuando la RAM física es insuficiente.
Adicionalmente, se puede crear una partición `/home` para almacenar los archivos personales de los usuarios, pero no es estrictamente necesaria para la instalación básica del sistema operativo.

**D-Dar ejemplos de diversos casoso de paticionamiento dependiendo del tipo de tarea que se debe realizar en su sistema operativo**
1. **Servidor web**:
   - Partición raíz (`/`): 20 GB, ext4
   - Partición `/var`: 50 GB, ext4 (para almacenar archivos de registro y datos del servidor web)
   - Partición swap: 4 GB, swap
   - Partición `/home`: 10 GB, ext4 (opcional, para archivos de usuario)
2. **Estación de trabajo para desarrollo de software**:
   - Partición raíz (`/`): 30 GB, ext4
   - Partición `/home`: 100 GB, ext4 (para almacenar proyectos y archivos personales)
   - Partición swap: 8 GB, swap
   - Partición `/opt`: 20 GB, ext4 (para instalar software adicional)
3. **Sistema de escritorio general**:
   - Partición raíz (`/`): 25 GB, ext4
   - Partición `/home`: 75 GB, ext4 (para archivos personales y configuraciones)
   - Partición swap: 4 GB, swap
   - Partición `/boot`: 1 GB, ext4 (para almacenar archivos de arranque)
4. **Servidor de base de datos**:
   - Partición raíz (`/`): 20 GB, ext4
   - Partición `/var/lib/mysql`: 100 GB, ext4 (para almacenar datos de la base de datos)
   - Partición swap: 8 GB, swap
   - Partición `/home`: 10 GB, ext4 (opcional, para archivos de usuario)

**E-Que tipo deo software para paticionar existe? Mencionelos y compare**
Existen varios tipos de software para particionar discos en GNU/Linux, entre los más populares se encuentran:
- **fdisk**: Es una herramienta de línea de comandos que permite crear, eliminar y modificar particiones en discos MBR. Es simple y eficiente, pero no soporta discos GPT.
- **parted**: Es una herramienta de línea de comandos que soporta tanto discos MBR como GPT. Permite crear, eliminar y redimensionar particiones, y es más flexible que fdisk.
- **gparted**: Es una interfaz gráfica basada en parted que facilita la gestión de particiones para usuarios menos experimentados. Ofrece una visualización clara del disco y permite realizar operaciones de particionado de manera intuitiva.
- **cfdisk**: Es una herramienta de línea de comandos con una interfaz semi-gráfica que facilita la creación y gestión de particiones en discos MBR. Es más amigable que fdisk, pero no soporta GPT.
- **KDE Partition Manager**: Es una herramienta gráfica para entornos de escritorio KDE que permite gestionar particiones de manera similar a gparted, pero con integración en el entorno KDE.

Cada una de estas herramientas tiene sus propias ventajas y desventajas. Las herramientas de línea de comandos como fdisk y parted son más adecuadas para usuarios avanzados que prefieren trabajar en la terminal, mientras que las herramientas gráficas como gparted y KDE Partition Manager son más accesibles para usuarios menos experimentados. La elección de la herramienta dependerá de las necesidades y preferencias del usuario.

## Arranque(Bootstrap) de un sistema operativo
**A-Que es el BIOS? Que tarea realiza?**
El BIOS (Basic Input/Output System) es un firmware que se encuentra en la placa base de una computadora y es responsable de iniciar el hardware durante el proceso de arranque. Su tarea principal es realizar una serie de pruebas de diagnóstico (POST - Power-On Self Test) para asegurarse de que todos los componentes del hardware estén funcionando correctamente. Una vez que se completan estas pruebas, el BIOS busca un dispositivo de arranque (como un disco duro, unidad USB o CD/DVD) y carga el gestor de arranque del sistema operativo desde ese dispositivo para iniciar el sistema operativo.

**B-Que es UEFI? Cual es su fucnion?**
UEFI (Unified Extensible Firmware Interface) es un estándar moderno para el firmware de la placa base que reemplaza al BIOS tradicional. Su función principal es proporcionar una interfaz entre el sistema operativo y el firmware del hardware, facilitando el proceso de arranque y la gestión del hardware. UEFI ofrece varias ventajas sobre el BIOS, como soporte para discos duros más grandes (más de 2 TB), tiempos de arranque más rápidos, una interfaz gráfica más avanzada y la capacidad de utilizar funciones de seguridad como Secure Boot, que ayuda a proteger el sistema contra software malicioso durante el arranque.

**C-Que es el MBR? Que el MBC?**
El MBR (Master Boot Record) es un pequeño programa que se encuentra en el primer sector de un disco duro y es responsable de iniciar el proceso de arranque del sistema operativo. Contiene información sobre las particiones del disco y el código necesario para cargar el gestor de arranque del sistema operativo. El MBR es utilizado principalmente en sistemas con particiones MBR y tiene una limitación de 2 TB para el tamaño del disco.
El MBC (Master Boot Code) es el código de arranque que se encuentra en el MBR. Su función es localizar y cargar el gestor de arranque del sistema operativo desde la partición activa del disco. El MBC es esencial para iniciar el proceso de arranque y transferir el control al sistema operativo.

**D-A que hacen referencia las siglas GPT? Que sustituye? Inidique cual es su formato?**
GPT (GUID Partition Table) es un estándar para la tabla de particiones en discos duros que reemplaza al MBR (Master Boot Record). GPT es parte del estándar UEFI y ofrece varias ventajas sobre MBR, como soporte para discos más grandes (más de 2 TB), un número casi ilimitado de particiones y mayor robustez contra la corrupción de datos.
El formato de GPT incluye una tabla de particiones que utiliza identificadores únicos globales (GUID) para cada partición, lo que facilita la gestión y el reconocimiento de las particiones. Además, GPT almacena múltiples copias de la tabla de particiones en diferentes ubicaciones del disco para mejorar la recuperación en caso de corrupción.

**E-Cual es la funcionalidad de un Gestor de arranque? Que tipos existen? Donde se instalan? CIte gestores de arranque conocidos**
Un gestor de arranque es un programa que se encarga de cargar y transferir el control al sistema operativo durante el proceso de arranque. Su funcionalidad principal es permitir al usuario seleccionar entre múltiples sistemas operativos instalados en la computadora, así como configurar opciones de arranque específicas.
Existen varios tipos de gestores de arranque, entre los más comunes se encuentran:
- **GRUB (GRand Unified Bootloader)**: Es uno de los gestores de arranque más populares y versátiles, utilizado en muchas distribuciones de GNU/Linux. Soporta múltiples sistemas operativos y ofrece una interfaz gráfica para la selección del sistema operativo.
- **LILO (LInux LOader)**: Es un gestor de arranque más antiguo que fue ampliamente utilizado en el pasado, pero ha sido reemplazado en gran medida por GRUB debido a su mayor flexibilidad y características.
- **Syslinux/Isolinux**: Es un gestor de arranque ligero utilizado principalmente para sistemas de arranque desde medios extraíbles, como CD/DVD y unidades USB.
Los gestores de arranque se instalan generalmente en el MBR (Master Boot Record) o en la partición EFI en sistemas UEFI. Algunos gestores de arranque conocidos incluyen GRUB, LILO, Syslinux, y rEFInd.

**G-Analice el proceso de arranque de GNU/Linux y describa sus principales pasos**
El proceso de arranque de GNU/Linux consta de varios pasos principales:
1. **POST (Power-On Self Test)**: Cuando se enciende la computadora, el BIOS o UEFI realiza una serie de pruebas para verificar que el hardware esté funcionando correctamente.
2. **Carga del gestor de arranque**: El BIOS/UEFI busca el dispositivo de arranque configurado (disco duro, USB, CD/DVD) y carga el gestor de arranque (como GRUB) desde el MBR o la partición EFI.
3. **Selección del sistema operativo**: El gestor de arranque presenta un menú al usuario para seleccionar el sistema operativo que desea iniciar. Si no se realiza ninguna selección, se inicia el sistema operativo predeterminado.
4. **Carga del kernel**: Una vez seleccionado el sistema operativo, el gestor de arranque carga el kernel de GNU/Linux en la memoria y transfiere el control al mismo.
5. **Inicialización del kernel**: El kernel inicializa el hardware, monta el sistema de archivos raíz (`/`), y configura los controladores necesarios para los dispositivos.
6. **Inicio del proceso init/systemd**: El kernel inicia el proceso `init` (o `systemd` en sistemas más modernos), que es responsable de iniciar los servicios y procesos del sistema.
7. **Inicio de servicios y procesos**: El proceso `init/systemd` inicia los servicios del sistema, como la red, el servidor gráfico, y otros servicios necesarios para el funcionamiento del sistema operativo.
8. **Inicio de sesión del usuario**: Finalmente, se presenta la pantalla de inicio de sesión, donde el usuario puede ingresar sus credenciales para acceder al sistema.

**H-Cuales son los pasos que se suceden en el proceso de parada (shutdown) de un sistema GNU/Linux?**
El proceso de parada (shutdown) de un sistema GNU/Linux consta de varios pasos principales:
1. **Notificación a los usuarios**: El sistema notifica a los usuarios conectados que el sistema se va a apagar, permitiéndoles guardar su trabajo y cerrar sus sesiones.
2. **Detención de servicios**: El proceso `init/systemd` detiene todos los servicios y procesos en ejecución de manera ordenada, asegurándose de que no haya operaciones pendientes.
3. **Desmontaje de sistemas de archivos**: El sistema desmonta todos los sistemas de archivos montados, asegurándose de que todos los datos se escriban correctamente en el disco.
4. **Sincronización de discos**: El sistema sincroniza los discos para garantizar que todos los datos en memoria se escriban en el almacenamiento permanente.
5. **Apagado del hardware**: Finalmente, el sistema envía una señal al hardware para apagar la computadora de manera segura.

**I-Es posible tener en una PC GNU/Linux y otros sistema operativo instalado? Justifique su respuesta**
Si, es posible tener en una PC GNU/Linux y otros sistemas operativos instalados simultáneamente, en una configuración conocida como "arranque dual" o "dual boot". Esto se logra mediante la creación de particiones separadas en el disco duro para cada sistema operativo. Durante el proceso de arranque, el gestor de arranque (como GRUB) permite al usuario seleccionar cuál sistema operativo desea iniciar. Esta configuración es útil para usuarios que necesitan utilizar diferentes sistemas operativos para distintas tareas o aplicaciones.

# Archivos y editores
**A-Como se identifican los archivos en GNU/Linux?**
En GNU/Linux, los archivos se identifican mediante un nombre único dentro de un directorio específico. Cada archivo tiene una ruta que indica su ubicación en el sistema de archivos, comenzando desde el directorio raíz (`/`). La ruta completa incluye todos los directorios intermedios hasta llegar al archivo. Además, los archivos en GNU/Linux pueden tener permisos y atributos que determinan quién puede leer, escribir o ejecutar el archivo.

**B-Investigue el funcionamiento de los editores vim, nano, y mcedit, y los comandos cat, more y less**
1. **Vim**: Es un editor de texto modal que permite la edición de archivos de texto. Tiene dos modos principales: el modo de comando y el modo de inserción. En el modo de comando, se pueden ejecutar comandos para manipular el texto, mientras que en el modo de inserción, se puede escribir texto directamente. Vim es conocido por su eficiencia y su curva de aprendizaje empinada.

2. **Nano**: Es un editor de texto simple y fácil de usar que se ejecuta en la terminal. A diferencia de Vim, Nano no tiene modos, lo que significa que los usuarios pueden comenzar a escribir texto inmediatamente. Ofrece una interfaz más amigable y accesible, con atajos de teclado visibles en la parte inferior de la pantalla.

3. **Mcedit**: Es el editor de texto del administrador de archivos Midnight Commander. Proporciona una interfaz de usuario similar a la de otros editores de texto, pero se integra en el entorno de Midnight Commander. Mcedit es fácil de usar y ofrece características como la edición de múltiples archivos y la navegación por directorios.

4. **Cat**: Es un comando que se utiliza para mostrar el contenido de un archivo en la salida estándar (generalmente la terminal). También se puede utilizar para concatenar archivos y redirigir la salida a un nuevo archivo.

5. **More**: Es un comando que permite visualizar el contenido de un archivo de texto página por página. Es útil para archivos grandes, ya que permite al usuario desplazarse por el contenido de manera controlada.

6. **Less**: Es similar a More, pero ofrece más funcionalidades, como la posibilidad de desplazarse hacia adelante y hacia atrás en el archivo. También permite buscar texto dentro del archivo y tiene una interfaz más interactiva.

**C- Crear un archivo llamado "prueba.exe" en su directorio personal usando vim. El mismo debe contener su numero de alumno y su nombre**
Para crear un archivo llamado "prueba.exe" en su directorio personal usando Vim, siga estos pasos:
1. Abra la terminal.
2. Navegue a su directorio personal (si no está ya allí) con el comando:
   ```bash
   cd ~
   ```
3. Abra Vim para crear el archivo "prueba.exe" con el comando:
   ```bash
   vim prueba.exe
   ```
4. Una vez dentro de Vim, presione la tecla `i` para entrar en el modo de inserción.
5. Escriba su número de alumno y su nombre, por ejemplo:
   ```
   12345678
   Juan Pérez
   ```
6. Para guardar el archivo y salir de Vim, presione la tecla `Esc` para salir del modo de inserción, luego escriba `:wq` y presione `Enter`.

Para verificar que el archivo se ha creado correctamente, puede usar el comando `cat` para mostrar su contenido:
```bash
cat prueba.exe
```

**D-Investigue el funcionamiento del comando file. Pruebelo con diferenctes  archivos. Que diferencia nota?**
El comando `file` en GNU/Linux se utiliza para determinar el tipo de un archivo. Analiza el contenido del archivo y proporciona una descripción del mismo, en lugar de basarse únicamente en la extensión del archivo. Esto es útil porque las extensiones de archivo no siempre reflejan con precisión el contenido real del archivo.

Para probar el comando `file`, puede crear varios archivos de diferentes tipos y luego ejecutar el comando `file` en cada uno de ellos. Por ejemplo:

1. Cree un archivo de texto:
   ```bash
   echo "Hola, mundo!" > archivo.txt
   ```

2. Cree un archivo binario vacío:
   ```bash
   touch archivo.bin
   ```

3. Ejecute el comando `file` en cada archivo:
   ```bash
   file archivo.txt
   file archivo.bin
   ```

Las salidas del comando `file` mostrarán el tipo de cada archivo, lo que le permitirá notar las diferencias entre ellos.
iso@Iso:~$ file archivo.txt
archivo.txt: ASCII text
iso@Iso:~$ file archivo.bin
archivo.bin: empty
iso@Iso:~$ 
En este ejemplo, el comando `file` identifica `archivo.txt` como un archivo de texto ASCII, mientras que `archivo.bin` se identifica como un archivo vacío. La diferencia principal es que `file` analiza el contenido real del archivo para determinar su tipo, lo que proporciona una descripción más precisa que simplemente mirar la extensión del archivo.

**E-Investigue el funcionamiento y parametros de los siguientes comandos: cd, mkdir, rmdir, ln, tail, locate, ls, pwd, cp, mv, find, rm**
1. **cd (change directory)**: Cambia el directorio actual en la terminal.
    - Uso: `cd [directorio]`
    - Ejemplo: `cd /home/usuario` cambia al directorio `/home/usuario`.
2. **mkdir (make directory)**: Crea un nuevo directorio.
    - Uso: `mkdir [opciones] directorio`
    - Ejemplo: `mkdir nuevo_directorio` crea un directorio llamado `nuevo_directorio`.
3. **rmdir (remove directory)**: Elimina un directorio vacío.
    - Uso: `rmdir [opciones] directorio`
    - Ejemplo: `rmdir viejo_directorio` elimina el directorio `viejo_directorio` si está vacío.
4. **ln (link)**: Crea enlaces entre archivos.
    - Uso: `ln [opciones] archivo enlace`
    - Ejemplo: `ln -s archivo.txt enlace.txt` crea un enlace simbólico llamado `enlace.txt` que apunta a `archivo.txt`.
5. **tail**: Muestra las últimas líneas de un archivo.
    - Uso: `tail [opciones] archivo`
    - Ejemplo: `tail -n 10 archivo.log` muestra las últimas 10 líneas de `archivo.log`.
6. **locate**: Busca archivos en el sistema utilizando una
    base de datos preconstruida.
    - Uso: `locate [opciones] patrón`
    - Ejemplo: `locate archivo.txt` busca todos los archivos llamados `archivo.txt`.
7. **ls (list)**: Lista los archivos y directorios en el directorio actual.
    - Uso: `ls [opciones] [directorio]`
    - Ejemplo: `ls -l` muestra una lista detallada de archivos y directorios.
8. **pwd (print working directory)**: Muestra la ruta del directorio actual.
    - Uso: `pwd`
    - Ejemplo: `pwd` muestra la ruta completa del directorio actual.
9. **cp (copy)**: Copia archivos y directorios.
    - Uso: `cp [opciones] origen destino`
    - Ejemplo: `cp archivo.txt copia.txt` copia `archivo.txt` a `copia.txt`.
10. **mv (move)**: Mueve o renombra archivos y directorios.
    - Uso: `mv [opciones] origen destino`
    - Ejemplo: `mv archivo.txt nuevo_nombre.txt` renombra `archivo.txt` a `nuevo_nombre.txt`.
11. **find**: Busca archivos y directorios en una jerarquía de directorios.
    - Uso: `find [ruta] [opciones] [expresión]`
    - Ejemplo: `find /home -name archivo.txt` busca `archivo.txt` en el directorio `/home`.
12. **rm (remove)**: Elimina archivos y directorios.
    - Uso: `rm [opciones] archivo`
    - Ejemplo: `rm archivo.txt` elimina `archivo.txt`. Use `rm -r` para eliminar directorios y su contenido de forma recursiva.

**10-Realice las siguientes tareas en su directorio personal:**
A-Crear un directorio llamado ISOCSO
B-Accede a la carpeta 
C-Cree dos archivos con los nombres isocso.txt e isocso.csv
D-Liste el contenido del directorio actual
E-Visualizar la ruta donde estoy situado 
F-Busqueda todos los archivos en los que su nombre contiene la cadena "iso*"
G-Informar la cantidad de espacio libre en disco basado en el uso de `df`
H- Verifique los usuarios conectados al sistema 'W'
I- Editar el archivo isocso.txt con vim y agregar su nombre y numero de alumno
J- Mostrar en pantalla las ultimas lineas de un archivo

**11-Investigue el funcionamiento, parametros y ubicacion(direcorio) de los siguientes comandos: **
A- man : Muestra el manual de un comando.
   - Uso: `man [comando]`
    - Ejemplo: `man ls` muestra el manual del comando `ls`.
    - Ubicación: `/usr/bin/man`
B- shutdown : Apaga o reinicia el sistema.
   - Uso: `shutdown [opciones] [tiempo] [mensaje]`
   - Ejemplo: `shutdown -h now` apaga el sistema inmediatamente.
   - Ubicación: `/sbin/shutdown`
C- reboot : Reinicia el sistema.
   - Uso: `reboot [opciones]`
   - Ejemplo: `reboot` reinicia el sistema.
   - Ubicación: `/sbin/reboot`
D- halt : Detiene el sistema.
   - Uso: `halt [opciones]`
   - Ejemplo: `halt` detiene el sistema.
   - Ubicación: `/sbin/halt`
E- uname : Muestra información del sistema.
   - Uso: `uname [opciones]`
   - Ejemplo: `uname -a` muestra toda la información del sistema.
   - Ubicación: `/bin/uname`
F- dmesg : Muestra mensajes del kernel.
   - Uso: `dmesg [opciones]`
   - Ejemplo: `dmesg | less` muestra los mensajes del kernel paginados.
   - Ubicación: `/bin/dmesg`
G- lspci : Lista dispositivos PCI.
   - Uso: `lspci [opciones]`
   - Ejemplo: `lspci` muestra todos los dispositivos PCI.
   - Ubicación: `/usr/sbin/lspci`
H- at : Programa la ejecución de comandos en un momento específico.
   - Uso: `at [hora]`
   - Ejemplo: `echo "ls -l" | at 10:00` programa el comando `ls -l` para las 10:00.
   - Ubicación: `/usr/bin/at`
I- netstat : Muestra conexiones de red y estadísticas.
   - Uso: `netstat [opciones]`
   - Ejemplo: `netstat -tuln` muestra todas las conexiones TCP y UDP en escucha.
   - Ubicación: `/bin/netstat`
J- head : Muestra las primeras líneas de un archivo.
   - Uso: `head [opciones] archivo`
   - Ejemplo: `head -n 10 archivo.txt` muestra las primeras 10 líneas de `archivo.txt`.
   - Ubicación: `/usr/bin/head`
K- tail : Muestra las últimas líneas de un archivo.
   - Uso: `tail [opciones] archivo`
   - Ejemplo: `tail -n 10 archivo.txt` muestra las últimas 10 líneas de `archivo.txt`.
   - Ubicación: `/usr/bin/tail`

# Procesos
**A-Que es un proceso? A que hacen referencia las siglas PID y PPID? Todos los procesos tienen estos atributos en GNU/Linux? Justifique. Indique que otros atributos tiene un proceso**
Un proceso es una instancia de un programa en ejecucion. Es una entidad que representa la ejecucion de un programa y contiene su estado, recursos y contexto de ejecucion.
- PID (Process ID): Es un identificador unico asignado a cada proceso en ejecucion. Permite al sistema operativo y a los usuarios identificar y gestionar los procesos.
- PPID (Parent Process ID): Es el identificador del proceso padre, es decir, el proceso que creo o inicio el proceso actual. Permite rastrear la jerarquia de procesos.
Todos los procesos en GNU/Linux tienen estos atributos (PID y PPID) ya que son fundamentales para la gestion y control de los procesos por parte del sistema operativo. Sin estos identificadores, seria imposible rastrear y gestionar los procesos de manera efectiva.
Otros atributos que tiene un proceso incluyen:
- Estado del proceso (ejecutando, suspendido, detenido, etc.)
- Prioridad del proceso (nivel de importancia para la planificacion)
- Recursos asignados (memoria, CPU, I/O, etc.)

**B-Investigue el funcionamiento, paremtros y ubicacion(directorio) de los siguiente comando relacionados a procesos. En caso de que algun comando no venga por defecto en la distribucion que tiliza debera proceder a instalarlo.**

1. top : Muestra los procesos en ejecucion en tiempo real.
   - Uso: `top [opciones]`
   - Ejemplo: `top` muestra una lista de procesos ordenados por uso de CPU.
   - Ubicación: `/usr/bin/top`
2. htop : Es una version mejorada de top con una interfaz mas amigable.
   - Uso: `htop`
   - Ejemplo: `htop` muestra una lista interactiva de procesos.
   - Ubicación: `/usr/bin/htop` (puede requerir instalacion)
3. ps : Muestra una instantanea de los procesos en ejecucion.
   - Uso: `ps [opciones]`
   - Ejemplo: `ps aux` muestra todos los procesos en ejecucion con detalles.
   - Ubicación: `/bin/ps`
4. pstree : Muestra los procesos en forma de arbol, mostrando la jerarquia entre ellos.
   - Uso: `pstree [opciones]`
   - Ejemplo: `pstree` muestra la estructura de procesos en forma de arbol.
   - Ubicación: `/usr/bin/pstree`
5. kill : Envia señales a los procesos para terminarlos o controlarlos.
   - Uso: `kill [opciones] PID`
   - Ejemplo: `kill -9 123 ` envia la señal SIGKILL al proceso con PID 123.
   - Ubicación: `/bin/kill`
6. pgrep : Busca procesos por nombre o atributos.
   - Uso: `pgrep [opciones] patrón`
   - Ejemplo: `pgrep bash` busca todos los procesos con el nombre "bash".
   - Ubicación: `/usr/bin/pgrep`
7. pkill : Envia señales a procesos basados en su nombre o atributos.
   - Uso: `pkill [opciones] patrón`
   - Ejemplo: `pkill -9 bash` envia la señal SIGKILL a todos los procesos con el nombre "bash".
   - Ubicación: `/usr/bin/pkill`
8. killall : Envia señales a todos los procesos que coinciden con un nombre especifico.
   - Uso: `killall [opciones] nombre`
   - Ejemplo: `killall -9 bash` envia la señal SIGKILL a todos los procesos con el nombre "bash".
   - Ubicación: `/usr/bin/killall`
9. renice : Cambia la prioridad de un proceso en ejecucion.
   - Uso: `renice [opciones] prioridad PID`
   - Ejemplo: `renice -n 10 -p 123` cambia la prioridad del proceso con PID 123 a 10.
   - Ubicación: `/usr/bin/renice`
10. xkill : Es una herramienta grafica para enviar señales a procesos.
    - Uso: `xkill`
    - Ejemplo: `xkill` permite al usuario hacer clic en una ventana para cerrarla.
    - Ubicación: `/usr/bin/xkill` (puede requerir instalacion)
11. atop : Monitorea el rendimiento del sistema y los procesos en detalle.
    - Uso: `atop [opciones]`
    - Ejemplo: `atop` muestra una vista detallada del uso de recursos por parte de los procesos.
    - Ubicación: `/usr/bin/atop` (puede requerir instalacion)
12. nice : Inicia un proceso con una prioridad especifica.
      - Uso: `nice [opciones] comando`
      - Ejemplo: `nice -n 10 comando` inicia `comando` con una prioridad de 10.
      - Ubicación: `/usr/bin/nice`

# SystemV
**A-Enumere los pasos del proceso de inicio de un sistema de GNU/Linux, desde que se pende la pC hasta que se logra obtener el login en el sistema**
1. Encendido de la computadora: Al presionar el botón de encendido, la computadora comienza a recibir energía y se inicia el proceso de arranque.
2. POST (Power-On Self Test): El BIOS/UEFI realiza una serie de pruebas para verificar que el hardware esté funcionando correctamente.
3. Carga del gestor de arranque: El BIOS/UEFI busca el dispositivo de arranque configurado y carga el gestor de arranque (como GRUB) desde el MBR o la partición EFI.
4. Selección del sistema operativo: El gestor de arranque presenta un menú para seleccionar el sistema operativo a iniciar.
5. Carga del kernel: El gestor de arranque carga el kernel de GNU/Linux en la memoria y transfiere el control al mismo.
6. Inicialización del kernel: El kernel inicializa el hardware, monta el sistema de archivos raíz (`/`), y configura los controladores necesarios.
7. Inicio del proceso init/systemd: El kernel inicia el proceso `init` (o `systemd` en sistemas más modernos), que es responsable de iniciar los servicios y procesos del sistema.
8. Ejecución de scripts de inicio: El proceso `init/systemd` ejecuta los scripts de inicio ubicados en `/etc/init.d/` o las unidades de systemd para iniciar los servicios del sistema.
9. Inicio de servicios y procesos: Se inician los servicios del sistema, como la red, el servidor gráfico, y otros servicios necesarios.
10. Presentación de la pantalla de inicio de sesión: Finalmente, se presenta la pantalla de inicio de sesión, donde el usuario puede ingresar sus credenciales para acceder al sistema.

**B-Proceso INIT: Quien lo ejeuta? Cual es su objetivo?**
El proceso `init` es ejecutado por el kernel de GNU/Linux durante el proceso de arranque del sistema. Su objetivo principal es iniciar y gestionar los servicios y procesos del sistema una vez que el kernel ha sido cargado y el sistema de archivos raíz ha sido montado. `init` es el primer proceso que se ejecuta en el espacio de usuario y tiene el PID 1. Se encarga de ejecutar los scripts de inicio, configurar el entorno del sistema, y mantener el estado del sistema operativo durante su funcionamiento.

**C-RunLvels: Que son? Cual es su objetivo?**
Los runlevels son estados predefinidos del sistema que determinan qué servicios y procesos deben estar en ejecución. Cada runlevel tiene un conjunto específico de servicios asociados, y el sistema puede cambiar entre runlevels para adaptarse a diferentes necesidades operativas. El objetivo de los runlevels es proporcionar una forma estructurada de gestionar el estado del sistema, permitiendo iniciar, detener o reiniciar servicios según sea necesario.

**D-A que hace referencia cada nivel de ejecucion segun el estandar? Donde se define que runlevel ejecutar al iniciar el sistema operativo? Todas las distribuciones respetan estos estandares?**
Los runlevels según el estándar SysV init son los siguientes:
- Runlevel 0: Apagado del sistema (halt).
- Runlevel 1: Modo monousuario (single-user mode), utilizado para mantenimiento y recuperación.
- Runlevel 2: Modo multiusuario sin servicios de red.
- Runlevel 3: Modo multiusuario con servicios de red (modo texto).
- Runlevel 4: No utilizado, reservado para uso personalizado.
- Runlevel 5: Modo multiusuario con servicios de red y entorno gráfico (X11).
- Runlevel 6: Reinicio del sistema (reboot).
El runlevel que se ejecuta al iniciar el sistema operativo se define en el archivo `/etc/inittab` en sistemas que utilizan SysV init. En este archivo, se especifica el runlevel predeterminado mediante la línea que comienza con `id:` seguida del número del runlevel.
No todas las distribuciones respetan estos estándares, ya que muchas han adoptado systemd como sistema de inicio, que utiliza un enfoque diferente basado en unidades (units) en lugar de runlevels. Sin embargo, algunas distribuciones aún mantienen compatibilidad con SysV init y sus runlevels.

**E-Archive /etc/inittab: Cual es su finalidad? Que tipo de informacion se alamcena en el? Cual es la estructura de la informacion que en el se alamcenaa?**
El archivo `/etc/inittab` es utilizado por el sistema de inicio SysV init para definir el comportamiento del sistema durante el proceso de arranque y la gestión de runlevels. Su finalidad es especificar qué procesos deben iniciarse, detenerse o reiniciarse en función del runlevel actual del sistema.
El archivo almacena información sobre los runlevels, los procesos que deben ejecutarse en cada runlevel, y las acciones que deben tomarse en respuesta a ciertos eventos (como la finalización de un proceso).
La estructura de la información en `/etc/inittab` generalmente sigue el formato:
```
   id:runlevels:action:process
```
Donde:
- `id`: Un identificador único para la entrada.
- `runlevels`: Los runlevels en los que se aplica esta entrada (por ejemplo, `2345`).
- `action`: La acción a tomar (por ejemplo, `respawn`, `wait`, `once`).
- `process`: El comando o script que se debe ejecutar.
Cada línea en el archivo representa una entrada que define cómo se debe gestionar un proceso específico en función del runlevel del sistema.

**F-Suponga que se encuentra en el runlevel <x>. Indique que comandos debera ejecutar para cambiar el runlevel a <y>. Este cambio es permanente? Porque?**
Para cambiar el runlevel de <x> a <y>, puede utilizar el comando `init` o `telinit`. Por ejemplo, si desea cambiar al runlevel 3, puede ejecutar:
```bash
   init 3
```
o
```bash
   telinit 3
```
Este cambio no es permanente, ya que el runlevel predeterminado se define en el archivo `/etc/inittab`. Si desea que el cambio sea permanente, debe editar el archivo `/etc/inittab` y modificar la línea que especifica el runlevel predeterminado. Por ejemplo, si desea que el sistema inicie siempre en el runlevel 3, debe cambiar la línea:
```
   id:5:initdefault:
```
a
```
   id:3:initdefault:
```
Después de realizar este cambio, el sistema iniciará en el runlevel 3 de manera permanente en futuros arranques.

**G-Scripts RC. Cual es su finalidad? Donde se almacenan? Cuando un sistema GNU/Linux arranca o se detiene se ejecutan scripts, indique como determina que script ejectuar ante cada accion. Existe un orden para llamarlos? Justifique**
Los scripts RC (Run Commands) son scripts de inicio y detención que se utilizan para gestionar los servicios y procesos del sistema durante el arranque y apagado. Su finalidad es iniciar, detener o reiniciar servicios específicos según el runlevel del sistema.
Los scripts RC se almacenan en el directorio `/etc/init.d/` y en los subdirectorios `/etc/rc.d/` o `/etc/rcX.d/`, donde `X` representa el runlevel específico (por ejemplo, `/etc/rc3.d/` para el runlevel 3).
Cuando un sistema GNU/Linux arranca o se detiene, se ejecutan los scripts RC correspondientes al runlevel actual. El sistema determina qué scripts ejecutar basándose en el runlevel configurado en `/etc/inittab` y en los enlaces simbólicos presentes en los directorios `/etc/rcX.d/`. Cada script tiene un prefijo que indica si debe iniciarse (S) o detenerse (K) y un número que determina el orden de ejecución.
Existe un orden para llamarlos, ya que los scripts se ejecutan en orden numérico según el prefijo. Por ejemplo, un script con el nombre `S10network` se ejecutará antes que uno llamado `S20apache`. Este orden es importante para garantizar que los servicios dependientes se inicien en la secuencia correcta.

# SystemD
**A-Que es SystemD?**
SystemD es un sistema de inicio y gestor de servicios para sistemas operativos GNU/Linux. Fue diseñado para reemplazar al sistema de inicio tradicional SysV init, proporcionando una forma más eficiente y flexible de gestionar el arranque del sistema, los servicios y los procesos. SystemD utiliza unidades (units) para definir y controlar los servicios, lo que permite una gestión más granular y una mejor integración con otros componentes del sistema. Además, SystemD ofrece características avanzadas como el paralelismo en el arranque, la gestión de dependencias entre servicios, y la capacidad de supervisar y reiniciar servicios automáticamente en caso de fallos.

**B-A que hace referencia el concepto de UNIT en SystemD?**
En SystemD, una "unit" (unidad) es un archivo de configuración que define un servicio, un socket, un dispositivo, un punto de montaje, un objetivo (target), o cualquier otro recurso que SystemD pueda gestionar. Cada unidad tiene un tipo específico que determina su función y comportamiento. Los tipos de unidades más comunes incluyen:
- **Service**: Define un servicio que puede ser iniciado, detenido, reiniciado, etc.
- **Socket**: Define un socket de red o de interproceso que puede activar un servicio.
- **Target**: Agrupa varias unidades y define un estado del sistema, similar a los runlevels en SysV init.
- **Mount**: Define un punto de montaje para sistemas de archivos.
- **Timer**: Define un temporizador que puede activar servicios en momentos específicos.
Las unidades se almacenan en archivos con la extensión `.service`, `.socket`, `.target`, etc., y se encuentran en directorios como `/etc/systemd/system/` (para unidades personalizadas) y `/lib/systemd/system/` (para unidades proporcionadas por el sistema o paquetes). Las unidades permiten a SystemD gestionar de manera eficiente los recursos del sistema y sus dependencias.

**C-Para que sirve el comando systemctl?**
El comando `systemctl` es la herramienta principal para interactuar con SystemD. Se utiliza para gestionar y controlar las unidades (units) del sistema, así como para supervisar el estado del sistema y realizar diversas tareas administrativas. Algunas de las funciones principales de `systemctl` incluyen:
- Iniciar, detener, reiniciar y recargar servicios.
- Habilitar o deshabilitar servicios para que se inicien automáticamente al arrancar el sistema.
- Ver el estado de los servicios y otras unidades.
- Listar todas las unidades disponibles y sus estados.
- Cambiar el runlevel (target) del sistema.
- Gestionar el sistema en general, como apagar, reiniciar o suspender el sistema.
Ejemplos de uso de `systemctl`:
```bash
   systemctl start nombre_servicio.service   # Inicia un servicio
   systemctl stop nombre_servicio.service    # Detiene un servicio
   systemctl restart nombre_servicio.service # Reinicia un servicio
   systemctl status nombre_servicio.service  # Muestra el estado de un servicio
   systemctl enable nombre_servicio.service  # Habilita un servicio para que inicie al arrancar
   systemctl disable nombre_servicio.service # Deshabilita un servicio para que no inicie al arrancar
   systemctl list-units                      # Lista todas las unidades activas
   systemctl isolate multi-user.target       # Cambia al runlevel multiusuario (similar a runlevel 3)
```

**D-A que hace referencia el concepto de target en SystemD?**
En SystemD, un "target" (objetivo) es una unidad especial que agrupa varias unidades (services, sockets, etc.) y define un estado del sistema. Los targets son similares a los runlevels en el sistema de inicio SysV init, pero ofrecen una mayor flexibilidad y capacidad de personalización. Cada target representa un conjunto específico de servicios y configuraciones que deben estar activos para alcanzar un determinado estado del sistema.
Algunos targets comunes incluyen:
- **multi-user.target**: Equivalente al runlevel 3, proporciona un entorno multiusuario sin interfaz gráfica.
- **graphical.target**: Equivalente al runlevel 5, proporciona un entorno multiusuario con interfaz gráfica.
- **rescue.target**: Equivalente al runlevel 1, proporciona un entorno de usuario único para mantenimiento y recuperación.
- **emergency.target**: Proporciona un entorno mínimo para la recuperación del sistema en caso de fallos graves.
Los targets permiten a los administradores del sistema definir y gestionar el estado del sistema de manera más estructurada, facilitando la administración de servicios y dependencias.

**E-Ejecutar el comando pstree ¿Que es lo que se puede observar a partir de la ejecucion de este comando?**
El comando `pstree` muestra una representación en forma de árbol de los procesos en ejecución en el sistema. A partir de la ejecución de este comando, se puede observar la jerarquía de los procesos, es decir, cómo los procesos están relacionados entre sí en términos de padres e hijos. Cada proceso se muestra con su nombre y PID (Process ID), y las líneas conectan los procesos para indicar qué procesos fueron iniciados por otros. Esto permite visualizar fácilmente la estructura de los procesos y entender cómo se organizan y gestionan en el sistema operativo.
Por ejemplo, al ejecutar `pstree`, se puede ver que el proceso `init` (o `systemd` en sistemas modernos) es el proceso padre de muchos otros procesos, y cómo estos procesos a su vez pueden tener sus propios procesos hijos. Esto es útil para diagnosticar problemas, entender el comportamiento del sistema y gestionar los procesos de manera efectiva.
iso@Iso:~$ pstree
systemd(1)─┬─NetworkManager(859)─┬─{gmain}(866)
           │                     ├─{gdbus}(867)
           │                     └─{nm-dispatc}(868)
           ├─accounts-daemon(861)─┬─{gmain}(865)
           │                     └─{gdbus}(864)
           ├─agetty(912)
           ├─atd(880)
           ├─cron(878)
           ├─dbus-daemon(862)───{dbus-daemon}(863)
           ├─dhclient(890)───{dhclient}(891)
           ├─irqbalance(877)───{irqbalance}(879)
           ├─lightdm(915)─┬─Xorg(929)───6*[{Xorg}]
           │              └─lightdm(933)───/usr/bin/gnome-session
           ├─login(913)───bash(914)───pstree(934)
           ├─polkitd(870)───{gmain}(873)
           │               └─{gdbus}(874)
           ├─rsyslogd(876)───{rs:main Q:Reg}(881)
           ├─sshd(895)───sshd(911)───bash(913)───sudo(930)───su(931)───bash(932)
           ├─systemd-journald(856)
           ├─systemd-logind(869)
           ├─systemd-timesyn(871)───{gmain}(872)
           └─wpa_supplicant(889)

# Usuarios
**A-Que archivos son utilizados en un sistema GNU/Linux para almacenar informacion de los usuarios?**
En un sistema GNU/Linux, los archivos principales utilizados para almacenar información de los usuarios son: 
1. **/etc/passwd**: Este archivo contiene información básica sobre cada usuario, como el nombre de usuario, el UID (User ID), el GID (Group ID), el directorio home, y la shell predeterminada. Cada línea en este archivo representa un usuario.
2. **/etc/shadow**: Este archivo almacena las contraseñas cifradas de los usuarios y otra información relacionada con la seguridad, como la fecha del último cambio de contraseña y las políticas de expiración de la contraseña. Este archivo es accesible solo por el usuario root para proteger la seguridad de las contraseñas.
3. **/etc/group**: Este archivo contiene información sobre los grupos del sistema, incluyendo el nombre del grupo, el GID, y los miembros del grupo. Cada línea en este archivo representa un grupo.
4. **/etc/gshadow**: Similar a `/etc/shadow`, este archivo almacena información de seguridad relacionada con los grupos, como las contraseñas de los grupos y los administradores de los grupos.
Estos archivos son esenciales para la gestión de usuarios y grupos en un sistema GNU/Linux y son utilizados por diversas herramientas y comandos del sistema para autenticar y autorizar a los usuarios.

**B-A que hace referencia las siglas UID y GID? pueden coexistir UIDs iguales en un sistema GNU/Linux? Justifique su respuesta**
- **UID (User ID)**: Es un identificador numérico único asignado a cada usuario en el sistema. El UID se utiliza para identificar al usuario en el sistema operativo y gestionar sus permisos y acceso a recursos.
- **GID (Group ID)**: Es un identificador numérico único asignado a cada grupo en el sistema. El GID se utiliza para identificar al grupo y gestionar los permisos y acceso a recursos compartidos entre los miembros del grupo.
No, no pueden coexistir UIDs iguales en un sistema GNU/Linux. Cada usuario debe tener un UID único para garantizar que el sistema pueda distinguir entre diferentes usuarios. Si dos usuarios tuvieran el mismo UID, el sistema no podría diferenciar entre ellos, lo que podría causar problemas de seguridad y gestión de permisos. Por ejemplo, si dos usuarios compartieran el mismo UID, ambos tendrían acceso a los mismos archivos y recursos, lo que podría llevar a conflictos y violaciones de seguridad. Por lo tanto, es fundamental que cada usuario tenga un UID único en el sistema.

**C-Que es el usuario root? Puede exisite mas de un usuario con este perfil en GNU/Linux? Cual es la UID de root?**
El usuario root es el superusuario o administrador del sistema en GNU/Linux. Tiene privilegios completos y sin restricciones para realizar cualquier acción en el sistema, incluyendo la gestión de usuarios, la configuración del sistema, la instalación de software, y el acceso a todos los archivos y recursos del sistema. El usuario root es esencial para la administración y mantenimiento del sistema operativo.
No, no puede existir más de un usuario con el perfil de root en GNU/Linux. El usuario root es único y tiene un UID específico que lo identifica como el superusuario del sistema. Sin embargo, otros usuarios pueden obtener privilegios de root temporalmente utilizando comandos como `sudo`, pero no pueden tener el mismo perfil o UID que el usuario root.
La UID del usuario root es `0`. Este valor es reservado exclusivamente para el usuario root, lo que garantiza que el sistema pueda identificarlo correctamente y otorgarle los privilegios necesarios.

**D-Agregue un nuevo usuario llamado isocso a su instalacion de GNU/Linux, especifique que su home sea creada en /home/isocso, y hagalo miembo del grupo informatica(Si no existe crealo). Luego, sin iniciar sesion como este usuario cree un archivo en su home personal que le pertenezca. Luego de todo esto, borre el usuario y verifique que no queden registros de el en los archivos de informacion de los usuario y grupos.**
Para agregar un nuevo usuario llamado `isocso`, crear su directorio home en `/home/isocso`, y hacerlo miembro del grupo `informatica`, siga estos pasos:
1. Abra la terminal y ejecute el siguiente comando para crear el grupo `informatica` (si no existe):
   ```bash
   sudo groupadd informatica
   ```
2. Cree el usuario `isocso` con su directorio home en `/home/isocso` y agréguelo al grupo `informatica`:
   ```bash
   sudo useradd -m -d /home/isocso -g informatica isocso
   ```
3. Establezca una contraseña para el usuario `isocso`:
   ```bash
   sudo passwd isocso
   ```
4. Sin iniciar sesión como el usuario `isocso`, cree un archivo en su directorio home que le pertenezca:
   ```bash
   sudo touch /home/isocso/archivo_isocso.txt
   sudo chown isocso:informatica /home/isocso/archivo_isocso.txt
   ```
5. Verifique que el archivo fue creado y pertenece al usuario `isocso`:
   ```bash
   ls -l /home/isocso/archivo_isocso.txt
   ```
6. Para borrar el usuario `isocso` y su directorio home, ejecute el siguiente comando:
   ```bash
   sudo userdel -r isocso
   ```
7. Verifique que no queden registros del usuario `isocso` en los archivos de información de usuarios y grupos:
   - Verifique en `/etc/passwd`:
   ```bash
   grep isocso /etc/passwd
   ```
   - Verifique en `/etc/shadow`:
   ```bash
   grep isocso /etc/shadow
   ```
   - Verifique en `/etc/group`:
   ```bash
   grep isocso /etc/group
   ```
   Si no hay salida en estos comandos, significa que el usuario `isocso` ha sido eliminado correctamente y no quedan registros de él en los archivos de información de usuarios y grupos.

# FileSystem y permisos 
**A-Como son definidos los permisos sobre archivos en un sistema GNU/Linux?**
En un sistema GNU/Linux, los permisos sobre archivos se definen utilizando un sistema de tres niveles que controla el acceso a los archivos y directorios. Estos niveles son:
1. **Usuario (Owner)**: El propietario del archivo o directorio. Los permisos para el usuario determinan lo que el propietario puede hacer con el archivo.
2. **Grupo (Group)**: Un conjunto de usuarios que comparten ciertos permisos. Los permisos para el grupo determinan lo que los miembros del grupo pueden hacer con el archivo.
3. **Otros (Others)**: Todos los demás usuarios que no son el propietario ni miembros del grupo. Los permisos para otros determinan lo que cualquier usuario del sistema puede hacer con el archivo.
Cada uno de estos niveles puede tener tres tipos de permisos:
- **Lectura (Read - r)**: Permite ver el contenido del archivo o listar los archivos en un directorio.
- **Escritura (Write - w)**: Permite modificar el contenido del archivo o crear/eliminar archivos en un directorio.
- **Ejecución (Execute - x)**: Permite ejecutar un archivo como un programa o acceder a un directorio.
Los permisos se representan en forma simbólica (rwx) o numérica (0-7) y se pueden modificar utilizando comandos como `chmod`, `chown`, y `chgrp`.

Ejemplo en codigo :
```bash
   ls -l archivo.txt
   -rwxr-xr-- 1 usuario grupo 0 fecha archivo.txt
```
En este ejemplo, los permisos del archivo `archivo.txt` son:
- Usuario (usuario): rwx (lectura, escritura, ejecución)
- Grupo (grupo): r-x (lectura, ejecución)
- Otros: r-- (lectura)

**B-Investigue la funcionalidad y parametros de los siguientes comandos relacionados con los permisos en GNU/Linux**
1. **chmod (change mode)**: Cambia los permisos de archivos y directorios.
   - Uso: `chmod [opciones] modo archivo`
   - Ejemplo: `chmod 755 archivo.txt` establece los permisos a rwxr-xr-x.
   - Parámetros comunes:
     - `u`: usuario (owner)
     - `g`: grupo (group)
     - `o`: otros (others)
     - `a`: todos (all)
     - `+`: agregar permiso
     - `-`: quitar permiso
     - `=`: establecer permiso exacto
2. **chown (change owner)**: Cambia el propietario y/o grupo de archivos y directorios.
   - Uso: `chown [opciones] propietario[:grupo] archivo`
   - Ejemplo: `chown usuario:grupo archivo.txt` cambia el propietario a `usuario` y el grupo a `grupo`.
   - Parámetros comunes:
     - `-R`: recursivo, aplica el cambio a todos los archivos y subdirectorios.

3. **chgrp (change group)**: Cambia el grupo asociado a un archivo o directorio.
   - Uso: `chgrp [opciones] grupo archivo`
   - Ejemplo: `chgrp grupo archivo.txt` cambia el grupo asociado a `archivo.txt` a `grupo`.
   - Parámetros comunes:
     - `-R`: recursivo, aplica el cambio a todos los archivos y subdirectorios.

**C-Al utilizar el comando chmod generlamente se utiliza una notacion octal asociada para definir permisos, Que significa eso?**
La notación octal utilizada con el comando `chmod` es una forma compacta de representar los permisos de archivos y directorios en un sistema GNU/Linux. En esta notación, cada conjunto de permisos (usuario, grupo y otros) se representa mediante un número octal (base 8) que va del 0 al 7. Cada número octal corresponde a una combinación específica de permisos de lectura, escritura y ejecución.
Los valores de los permisos se asignan de la siguiente manera:
- Lectura (r) = 4
- Escritura (w) = 2
- Ejecución (x) = 1
Para calcular el valor octal de un conjunto de permisos, se suman los valores correspondientes a los permisos que se desean otorgar. Por ejemplo:
- `rwx` (lectura, escritura, ejecución) = 4 + 2 + 1 = 7
- `rw-` (lectura, escritura) = 4 + 2 + 0 = 6
- `r--` (lectura) = 4 + 0 + 0 = 4
- `---` (sin permisos) = 0 + 0 + 0 = 0
Cuando se utiliza `chmod` con notación octal, se especifican tres dígitos, uno para cada nivel de permisos:
- El primer dígito representa los permisos del usuario (owner).
- El segundo dígito representa los permisos del grupo (group).
- El tercer dígito representa los permisos de otros (others).
Por ejemplo, el comando `chmod 755 archivo.txt` establece los siguientes permisos:
- Usuario (owner): 7 (rwx)
- Grupo (group): 5 (r-x)
- Otros (others): 5 (r-x)

**D-Existe la posibilidad de que algun usuario del sistema pueda acceder a determinado archivo para el cual no posee permisos? indiquelo y realice las pruebas correspondientes**
Sí, existen situaciones en las que un usuario puede acceder a un archivo para el cual no posee permisos directos. Algunas de estas situaciones incluyen:
1. **Permisos de directorio**: Si un usuario tiene permisos de ejecución en un directorio, puede acceder a los archivos dentro de ese directorio, incluso si no tiene permisos directos sobre esos archivos. Por ejemplo, si un usuario tiene permisos `r-x` en un directorio, puede listar y acceder a los archivos dentro de ese directorio.
2. **Permisos de grupo**: Si un usuario es miembro de un grupo que tiene permisos sobre un archivo, puede acceder a ese archivo a través de los permisos del grupo, incluso si no tiene permisos directos como usuario individual.
3. **Permisos especiales**: Algunos archivos pueden tener permisos especiales como el bit SUID o SGID, que permiten a los usuarios ejecutar un archivo con los permisos del propietario o del grupo del archivo, respectivamente.
4. **Acceso a través de enlaces simbólicos**: Un usuario puede acceder a un archivo a través de un enlace simbólico que apunta a ese archivo, siempre y cuando tenga permisos para acceder al enlace y al directorio que contiene el archivo original.

**E-Explique los conecptos de "Full path name" y "relative path name".**
- **Full Path Name (Ruta Absoluta)**: Es la ruta completa desde el directorio raíz (`/`) hasta el archivo o directorio específico. Incluye todos los directorios intermedios y comienza con una barra diagonal (`/`). Por ejemplo, `/home/usuario/documentos/archivo.txt` es una ruta absoluta que indica la ubicación exacta del archivo `archivo.txt` en el sistema de archivos.
- **Relative Path Name (Ruta Relativa)**: Es la ruta que se especifica en relación al directorio actual en el que se encuentra el usuario. No comienza con una barra diagonal y puede incluir referencias a directorios padres (`..`) o al directorio actual (`.`). Por ejemplo, si el usuario está en el directorio `/home/usuario`, la ruta relativa `documentos/archivo.txt` se refiere al archivo `archivo.txt` dentro del subdirectorio `documentos` del directorio actual.

**F-con que comando puede determinar en que directorio se encuentra actualmente? Existe alguna forma de ingresar a su directorio personal sin necesidad de escribir el path completo? podria utilizar la misma idea para acceder a otros directorios? Como? Explique con un jemplo**
Para determinar en qué directorio se encuentra actualmente, puede utilizar el comando `pwd` (print working directory). Este comando muestra la ruta absoluta del directorio actual.
```bash
   pwd
   /home/usuario
```
Sí, existe una forma de ingresar a su directorio personal sin necesidad de escribir el path completo utilizando el comando `cd` (change directory) sin ningún argumento o utilizando el símbolo `~` (tilde), que representa el directorio home del usuario actual.
```bash
   cd
   # o
   cd ~
```
Ambos comandos lo llevarán directamente a su directorio personal, por ejemplo, `/home/usuario`.
También puede utilizar la misma idea para acceder a otros directorios utilizando rutas relativas o absolutas. Por ejemplo, si desea acceder al directorio `documentos` dentro de su directorio personal, puede hacerlo de las siguientes maneras:
```bash
   cd documentos
   # o
   cd ~/documentos
   # o
   cd /home/usuario/documentos
```
Cada uno de estos comandos lo llevará al directorio `documentos` dentro de su directorio personal.
Se puede acceder a otro que no sea personal usando este "atajo" de la siguiente manera:
```bash
   cd /var/log
   # o
   cd ~/../var/log
   # o
   cd ../../var/log
```
Cada uno de estos comandos lo llevará al directorio `/var/log`, utilizando diferentes formas de especificar la ruta.

**G-Investigue la funcionalidad y parametros de los siguientes comandos relacionados con el uso del FileSystem en GNU/Linux**
1. **umount**: Desmonta un sistema de archivos montado.
   - Uso: `umount [opciones] punto_de_montaje`
   - Ejemplo: `umount /mnt/usb` desmonta el sistema de archivos montado en `/mnt/usb`.
   - Parámetros comunes:
     - `-l`: desmontaje perezoso, espera a que el sistema de archivos no esté en uso.
     - `-f`: fuerza el desmontaje, útil para sistemas de archivos remotos.
2. **du (disk usage)**: Muestra el uso del espacio en disco de archivos y directorios.
   - Uso: `du [opciones] [archivo/directorio]`
   - Ejemplo: `du -h /home/usuario` muestra el uso del espacio en disco del directorio `/home/usuario` en un formato legible.
   - Parámetros comunes:
     - `-h`: muestra los tamaños en un formato legible (KB, MB, GB).
     - `-s`: muestra solo el total para cada argumento.
3. **df (disk free)**: Muestra el espacio libre y usado en los sistemas de archivos montados.
   - Uso: `df [opciones] [sistema_de_archivos]`
   - Ejemplo: `df -h` muestra el espacio libre y usado en todos los sistemas de archivos en un formato legible.
   - Parámetros comunes:
     - `-h`: muestra los tamaños en un formato legible (KB, MB, GB).
     - `-T`: muestra el tipo de sistema de archivos.
4. **mount**: Monta un sistema de archivos en un punto de montaje.
   - Uso: `mount [opciones] dispositivo punto_de_montaje`
   - Ejemplo: `mount /dev/sdb1 /mnt/usb` monta el dispositivo `/dev/sdb1` en el punto de montaje `/mnt/usb`.
   - Parámetros comunes:
     - `-t`: especifica el tipo de sistema de archivos (por ejemplo, ext4, ntfs).
     - `-o`: especifica opciones de montaje (por ejemplo, ro para solo lectura).
5. **mkfs (make filesystem)**: Crea un sistema de archivos en un dispositivo o partición.
   - Uso: `mkfs [opciones] dispositivo`
   - Ejemplo: `mkfs.ext4 /dev/sdb1` crea un sistema de archivos ext4 en el dispositivo `/dev/sdb1`.
   - Parámetros comunes:
     - `-t`: especifica el tipo de sistema de archivos (por ejemplo, ext4, ntfs).
     - `-c`: verifica el dispositivo en busca de bloques defectuosos antes de crear el sistema de archivos.
6. **fsck (file system check)**: Verifica y repara sistemas de archivos.
   - Uso: `fsck [opciones] dispositivo`
   - Ejemplo: `fsck /dev/sdb1` verifica y repara el sistema de archivos en el dispositivo `/dev/sdb1`.
   - Parámetros comunes:
     - `-y`: responde "sí" a todas las preguntas durante la reparación.
     - `-n`: realiza una verificación sin hacer cambios (modo solo lectura).
7. **writer**: Permite escribir datos directamente en un dispositivo de bloque.
   - Uso: `dd if=origen of=destino [opciones]`
   - Ejemplo: `dd if=/dev/zero of=/dev/sdb bs=1M count=100` escribe 100 MB de ceros en el dispositivo `/dev/sdb`.
   - Parámetros comunes:
     - `if=`: especifica el archivo de entrada (input file).
     - `of=`: especifica el archivo de salida (output file).
     - `bs=`: especifica el tamaño del bloque.
     - `count=`: especifica el número de bloques a copiar.
8.**losetup**: Asocia un archivo de imagen de disco con un dispositivo de bucle (loop device).
   - Uso: `losetup [opciones] dispositivo archivo_imagen`
   - Ejemplo: `losetup /dev/loop0 imagen.iso` asocia el archivo `imagen.iso` con el dispositivo `/dev/loop0`.
   - Parámetros comunes:
     - `-f`: encuentra el primer dispositivo de bucle libre.
     - `-d`: desasocia un dispositivo de bucle.
9.**stat**: Muestra información detallada sobre un archivo o sistema de archivos.
   - Uso: `stat [opciones] archivo`
   - Ejemplo: `stat archivo.txt` muestra información detallada sobre `archivo.txt`, incluyendo permisos, propietario, tamaño, y fechas de acceso/modificación.
   - Parámetros comunes:
     - `-c`: especifica un formato personalizado para la salida.
     - `-f`: muestra información sobre el sistema de archivos en lugar del archivo.

# Procesos 
**A-Que significa que un proceso se esta ejecutando en background? y en foreground?**
- **Foreground (Primer Plano)**: Un proceso que se está ejecutando en primer plano es aquel que está activo y en el que el usuario puede interactuar directamente a través de la terminal. Mientras un proceso está en primer plano, la terminal está ocupada por ese proceso y no puede aceptar otros comandos hasta que el proceso termine o se detenga.
- **Background (Segundo Plano)**: Un proceso que se está ejecutando en segundo plano es aquel que se ejecuta de manera independiente y no requiere interacción directa del usuario. Los procesos en segundo plano permiten al usuario continuar utilizando la terminal para otros comandos mientras el proceso sigue ejecutándose. Estos procesos no bloquean la terminal y pueden ser gestionados mediante comandos específicos.

**B-como se puede hacer para ejecutar un proceso en background? como puedo hacer para pasar un proceso de background a foreground?**
Para ejecutar un proceso en background, puede agregar el símbolo `&` al final del comando al iniciarlo. Por ejemplo:
```bash
   comando &
```
Esto iniciará el `comando` en segundo plano, permitiendo que la terminal esté disponible para otros comandos.
Para pasar un proceso de background a foreground, puede utilizar el comando `fg` seguido del número de trabajo (job number) del proceso en segundo plano. Puede ver la lista de trabajos en segundo plano utilizando el comando `jobs`.
```bash
   jobs
   fg %1
```
En este ejemplo, `fg %1` traerá el primer trabajo en segundo plano (job number 1) al primer plano.

**C- Pipe (|): cual es su funcionalidad? como se utiliza?**
El pipe (`|`) es un operador en la línea de comandos de Unix y GNU/Linux que permite conectar la salida estándar (stdout) de un comando a la entrada estándar (stdin) de otro comando. Esto permite encadenar múltiples comandos para procesar datos de manera secuencial, donde la salida de un comando se convierte en la entrada del siguiente.

**D-Redireccion, Que tipo de redirecciones existen? cual es su funcionalidad?**
La redirección en la línea de comandos de Unix y GNU/Linux permite cambiar la fuente o el destino de la entrada y salida de los comandos. Existen varios tipos de redirecciones, cada una con su funcionalidad específica:
1. **Redirección de salida estándar (`>` y `>>`)**:
   - `>`: Redirige la salida estándar de un comando a un archivo, sobrescribiendo el contenido del archivo si ya existe.
     - Ejemplo: `comando > archivo.txt` (sobrescribe `archivo.txt` con la salida de `comando`).
   - `>>`: Redirige la salida estándar de un comando a un archivo, agregando la salida al final del archivo si ya existe.
     - Ejemplo: `comando >> archivo.txt` (agrega la salida de `comando` al final de `archivo.txt`).
2. **Redirección de entrada estándar (`<`)**:
   - `<`: Redirige la entrada estándar de un comando desde un archivo en lugar del teclado.
     - Ejemplo: `comando < archivo.txt` (lee la entrada de `archivo.txt` en lugar del teclado).
3. **Redirección de error estándar (`2>` y `2>>`)**:
   - `2>`: Redirige la salida de error estándar (stderr) de un comando a un archivo, sobrescribiendo el contenido del archivo si ya existe.
     - Ejemplo: `comando 2> error.txt` (sobrescribe `error.txt` con los mensajes de error de `comando`).
   - `2>>`: Redirige la salida de error estándar (stderr) de un comando a un archivo, agregando los mensajes de error al final del archivo si ya existe.
     - Ejemplo: `comando 2>> error.txt` (agrega los mensajes de error de `comando` al final de `error.txt`).
4. **Redirección combinada (`&>`, `&>>`)**:
   - `&>`: Redirige tanto la salida estándar como la salida de error estándar a un archivo, sobrescribiendo el contenido del archivo si ya existe.
     - Ejemplo: `comando &> salida.txt` (sobrescribe `salida.txt` con la salida y los errores de `comando`).
   - `&>>`: Redirige tanto la salida estándar como la salida de error estándar a un archivo, agregando al final del archivo si ya existe.
     - Ejemplo: `comando &>> salida.txt` (agrega la salida y los errores de `comando` al final de `salida.txt`).
5. **Redirección de múltiples descriptores de archivo**:
   - `n>`: Redirige un descriptor de archivo específico (donde `n` es un número) a un archivo.
     - Ejemplo: `comando 3> archivo.txt` (redirige el descriptor de archivo 3 a `archivo.txt`).

# Otros comandos de Linux
**A-A que hace referencia el concepto de empaquetar archivos en GNU/Linux?**
El concepto de empaquetar archivos en GNU/Linux se refiere al proceso de agrupar múltiples archivos y directorios en un solo archivo comprimido o archivado. Esto facilita la gestión, almacenamiento y transferencia de datos, ya que en lugar de manejar varios archivos individuales, se puede trabajar con un solo archivo que contiene todos los elementos necesarios. Los archivos empaquetados suelen tener extensiones específicas que indican el formato de compresión utilizado, como `.tar`, `.zip`, `.gz`, entre otros.

**C-Que acciones debe llevar a cabo para comprimir 4 archivos en uno solo? indique la secuencia de comandos ejecutadso**
Para comprimir 4 archivos en uno solo en GNU/Linux, puede utilizar el comando `tar` para crear un archivo tar y luego comprimirlo con `gzip` o `bzip2`. Aquí está la secuencia de comandos que debe ejecutar:
1. Primero, cree un archivo tar que contenga los 4 archivos:
   ```bash
   tar -cvf archivos.tar archivo1.txt archivo2.txt archivo3.txt archivo4.txt
   ```
   - `-c`: crea un nuevo archivo tar.
   - `-v`: muestra el progreso en la terminal (opcional).
   - `-f`: especifica el nombre del archivo tar.
2. Luego, comprima el archivo tar utilizando `gzip`:
   ```bash
   gzip archivos.tar
   ```
   Esto creará un archivo comprimido llamado `archivos.tar.gz`.
Alternativamente, puede combinar ambos pasos en un solo comando utilizando `tar` con la opción de compresión:
```bash
   tar -czvf archivos.tar.gz archivo1.txt archivo2.txt archivo3.txt archivo4.txt
```
   - `-z`: comprime el archivo tar utilizando gzip.
   - El resultado será un archivo comprimido llamado `archivos.tar.gz` que contiene los 4 archivos originales.

**D-Pueden comprimirse un conjunto de archivos utilizando un unico comando?**
Sí, pueden comprimirse un conjunto de archivos utilizando un único comando. Por ejemplo, utilizando el comando `tar` con la opción de compresión `-z` para gzip o `-j` para bzip2, puede crear y comprimir un archivo en un solo paso. Aquí hay un ejemplo utilizando gzip:
```bash
   tar -czvf archivos_comprimidos.tar.gz archivo1.txt archivo2.txt archivo3.txt archivo4.txt
```
   - `-c`: crea un nuevo archivo tar.
   - `-z`: comprime el archivo tar utilizando gzip.
   - `-v`: muestra el progreso en la terminal (opcional).
   - `-f`: especifica el nombre del archivo tar.

**E-Investigue la funcionalidad de los siguiente comando**
1.**tar** : El comando `tar` (tape archive) se utiliza para crear, mantener y extraer archivos de archivo (tarballs) en sistemas Unix y GNU/Linux. Permite agrupar múltiples archivos y directorios en un solo archivo, facilitando su almacenamiento y transferencia. Además, `tar` puede combinarse con herramientas de compresión como `gzip` o `bzip2` para crear archivos comprimidos.
   - Uso: `tar [opciones] archivo.tar [archivos/directorios]`
   - Ejemplo: `tar -czvf archivo.tar.gz directorio/` crea un archivo comprimido `archivo.tar.gz` que contiene el directorio especificado.
   - Parámetros comunes:
     - `-c`: crea un nuevo archivo tar.
     - `-x`: extrae archivos de un archivo tar.
     - `-v`: muestra el progreso en la terminal (opcional).
     - `-f`: especifica el nombre del archivo tar.
     - `-z`: comprime o descomprime utilizando gzip.
     - `-j`: comprime o descomprime utilizando bzip2.
2.**grep** : El comando `grep` (global regular expression print) se utiliza para buscar texto dentro de archivos o la salida de otros comandos en sistemas Unix y GNU/Linux. Permite filtrar líneas que coinciden con un patrón específico, utilizando expresiones regulares para definir el patrón de búsqueda.
   - Uso: `grep [opciones] patrón [archivo(s)]`
   - Ejemplo: `grep "texto" archivo.txt` busca y muestra todas las líneas en `archivo.txt` que contienen la palabra "texto".
   - Parámetros comunes:
     - `-i`: ignora mayúsculas y minúsculas en la búsqueda.
     - `-r`: busca recursivamente en directorios.
     - `-v`: invierte la coincidencia, mostrando líneas que no coinciden con el patrón.
     - `-n`: muestra el número de línea junto con las líneas coincidentes.
     - `-c`: cuenta el número de líneas que coinciden con el patrón.
3.**gzip** : El comando `gzip` (GNU zip) se utiliza para comprimir archivos en sistemas Unix y GNU/Linux. Utiliza el algoritmo de compresión DEFLATE para reducir el tamaño de los archivos, lo que facilita su almacenamiento y transferencia. Los archivos comprimidos con `gzip` suelen tener la extensión `.gz`.
   - Uso: `gzip [opciones] archivo`
   - Ejemplo: `gzip archivo.txt` comprime `archivo.txt`, creando un archivo llamado `archivo.txt.gz`.
   - Parámetros comunes:
     - `-d`: descomprime un archivo comprimido (equivalente a `gunzip`).
     - `-k`: conserva el archivo original después de la compresión.
     - `-r`: comprime archivos en directorios de forma recursiva.
     - `-l`: muestra información sobre los archivos comprimidos.
4.**zgrep** : El comando `zgrep` es una variante del comando `grep` que permite buscar texto dentro de archivos comprimidos con `gzip` (archivos con extensión `.gz`). Funciona de manera similar a `grep`, pero descomprime los archivos sobre la marcha para realizar la búsqueda, lo que facilita la búsqueda en archivos comprimidos sin necesidad de descomprimirlos manualmente.
   - Uso: `zgrep [opciones] patrón archivo.gz`
   - Ejemplo: `zgrep "texto" archivo.txt.gz` busca y muestra todas las líneas en `archivo.txt.gz` que contienen la palabra "texto".
   - Parámetros comunes:
     - `-i`: ignora mayúsculas y minúsculas en la búsqueda.
     - `-r`: busca recursivamente en directorios (si se usa con archivos `.gz` dentro de un directorio).
     - `-v`: invierte la coincidencia, mostrando líneas que no coinciden con el patrón.
     - `-n`: muestra el número de línea junto con las líneas coincidentes.
     - `-c`: cuenta el número de líneas que coinciden con el patrón.
5.**wc** : El comando `wc` (word count) se utiliza para contar líneas, palabras y caracteres en archivos de texto o en la entrada estándar en sistemas Unix y GNU/Linux. Es útil para obtener estadísticas rápidas sobre el contenido de archivos o la salida de otros comandos.
   - Uso: `wc [opciones] [archivo(s)]`
   - Ejemplo: `wc archivo.txt` muestra el número de líneas, palabras y caracteres en `archivo.txt`.
   - Parámetros comunes:
     - `-l`: cuenta solo las líneas.
     - `-w`: cuenta solo las palabras.
     - `-c`: cuenta solo los caracteres.
     - `-m`: cuenta los caracteres, incluyendo los multibyte (UTF-8).
     - `-L`: muestra la longitud de la línea más larga.

# Comandos (19)
Indique qué acción realiza cada uno de los comandos indicados a continuación
considerando su orden. Suponga que se ejecutan desde un usuario que no es root ni
pertenece al grupo de root. (Asuma que se encuentra posicionado en el directorio de
trabajo del usuario con el que se logueó). En caso de no poder ejecutarse el comando
indique la razón:
l s −l > prueba
ps > PRUEBA
chmod 710 prueba
chown root:root PRUEBA
chmod 777 PRUEBA
chmod 700 /etc/passwd
passwd root
rm PRUEBA
man /etc/shadow
find / −name ∗ .conf
usermod root −d /home/ newroot −L
cd / root
rm ∗
cd / etc
cp ∗ /home 

1. `ls -l > prueba`: Lista los archivos en el directorio actual con detalles y redirige la salida a un archivo llamado `prueba`. Si el archivo ya existe, se sobrescribirá.
2. `ps > PRUEBA`: Muestra los procesos en ejecución y redirige la salida a un archivo llamado `PRUEBA`. Si el archivo ya existe, se sobrescribirá.
3. `chmod 710 prueba`: Cambia los permisos del archivo `prueba` para que el propietario tenga permisos de lectura, escritura y ejecución (7), el grupo tenga permisos de ejecución (1), y otros no tengan permisos (0).
4. `chown root:root PRUEBA`: Intenta cambiar el propietario y el grupo del archivo `PRUEBA` a `root`. Este comando fallará porque el usuario actual no tiene privilegios de root.
5. `chmod 777 PRUEBA`: Cambia los permisos del archivo `PRUEBA` para que el propietario, el grupo y otros tengan permisos de lectura, escritura y ejecución (7).
6. `chmod 700 /etc/passwd`: Intenta cambiar los permisos del archivo `/etc/passwd` para que solo el propietario (root) tenga permisos de lectura, escritura y ejecución (7), y el grupo y otros no tengan permisos (0). Este comando fallará porque el usuario actual no tiene privilegios de root.
7. `passwd root`: Intenta cambiar la contraseña del usuario `root`. Este comando fallará porque el usuario actual no tiene privilegios de root.
8. `rm PRUEBA`: Elimina el archivo `PRUEBA`.
9. `man /etc/shadow`: Muestra el manual del archivo `/etc/shadow`. Este comando fallará porque el usuario actual no tiene permisos para leer el archivo `/etc/shadow`.
10. `find / -name *.conf`: Busca archivos con la extensión `.conf` en todo el sistema de archivos. Este comando puede tardar mucho tiempo y puede generar muchos errores de permisos al intentar acceder a ciertos directorios.
11. `usermod root -d /home/newroot -L`: Intenta modificar el usuario `root` para cambiar su directorio home a `/home/newroot` y bloquear la cuenta. Este comando fallará porque el usuario actual no tiene privilegios de root.
12. `cd /root`: Intenta cambiar al directorio `/root`. Este comando fallará porque el usuario actual no tiene permisos para acceder al directorio `/root`.
13. `rm *`: Elimina todos los archivos en el directorio actual del usuario.
14. `cd /etc`: Cambia al directorio `/etc`. Este comando tendrá éxito si el usuario tiene permisos de lectura y ejecución en el directorio `/etc`.
15. `cp * /home`: Copia todos los archivos del directorio actual del usuario al directorio `/home`. Este comando fallará si el usuario no tiene permisos de escritura en el directorio `/home`.

# Comandos (20)
Indique qué comando realiza la accion
1. Terminar el proceso con PID 23: `kill 23`
2. Terminar el proceso llamado init o systemd. Que resultado se obtiene? `sudo killall init` o `sudo killall systemd` (esto puede causar que el sistema se vuelva inestable o se reinicie).
3. Buscar todos los archivos de usuarios en los que su nombre contiene la cadena ".conf": `find /home -name "*.conf"`
4. Guardar una lista de procesos en ejecucion el archivo /home/<su nombre de usuario>/procesos: `ps aux > /home/<su nombre de usuario>/procesos`
5. cambiar los permisos del archivo /hombe/<su nombre de usuario>/xxxx a 
   - usuario: lectura, escritura y ejecucion
   - grupo: lectura y ejecucion
   - otros: ejecucion
   `chmod 751 /home/<su nombre de usuario>/xxxx`
6. Cambiar los permisos del archivo /hombre/<su nombre de usuario>/yyyy a
   - usuario: lectura, escritura
   - grupo: lectura, ejecucion
   - otros: sin permisos
   `chmod 640 /home/<su nombre de usuario>/yyyy`
7. Borrar todos los archivos del directorio /tmp: `rm /tmp/*`
8. Cambiar el propietario del archivo /opt/isodata el usuario isocso: `sudo chown isocso /opt/isodata`
9. Guardar en el archivo /home/<su nombre de usuario>/donde el directorio donde me encuentro en este momento, en caso de que el archivo existe no se debe eliminar su contenido anterior: `pwd >> /home/<su nombre de usuario>/donde`

# Comandos (21)
Indique que comando seria necesario ejecutar para realizar cada una de las siguientes acciones:
1. Ingrese el sistema como usuario "root": `su -` o `sudo -i`
2. Cree un usuario. Elija como nombre, por convecion, la primera letra de su nombre seguida de su apellido. Asignele una contraseña de acceso: `sudo useradd -m -s /bin/bash <inicial><apellido> && sudo passwd <inicial><apellido>`
3. Que archivos fueron modificados luego de crear el usuario y que direcciones se crearon?
   - Archivos modificados: `/etc/passwd`, `/etc/shadow`, `/etc/group`, `/etc/gshadow`
   - Directorio creado: `/home/<inicial><apellido>`
4. Crear un directorio en /tmp llamado miCursada: `mkdir /tmp/miCursada`
5. Copiar todos los archivos de /var/config al directorio /tmp/miCursada: `cp /var/config/* /tmp/miCursada/`
6. Para el directorio antes creado cambiar el propietario y grupo al usuario creado y grupo users: `sudo chown -R <inicial><apellido>:users /tmp/miCursada`
7. Agregue permiso total al dueño de escritura al grupo y escritura y ejecucion a todos los demas usuarios para todos los archivos dentro de un directorio en forma recursiva: `chmod -R 775 /tmp/miCursada`
8. Accede a otra terminal para logearse con el usuario antes creado: `Ctrl + Alt + F2` (o cualquier otra tecla de función de F1 a F6): `su - <inicial><apellido>`
9. Una vez logeado con el usuario antes creado, averigue cual es el nombre de su terminal: `tty`
10. Verifique la cantidad de procesos activos que hay  en el sistema: `ps aux | wc -l`
11. Verifique la cantidad de usuario conectados al sistema: `who | wc -l`
12. Vuelva a la terminal del usuario root y enviele un mensaje al usuario anteriormente creado enviandole que el sistema va aser apagado: `sudo wall "El sistema se va a apagar en 5 minutos"`
13. Apague el sistema: `sudo shutdown -h now` o `sudo poweroff`

# Comandos (22)
Indique que comando seria necesario ejectuar para realizar cada una de las siguientes acciones:
1. Cree un directorio cuyo nombre sea su numero de legajo e ingrese a el: `mkdir <legajo> && cd <legajo>`
2. Cree un archivo utilizando el editor de textos vi, e introduza su informacion personal: Nombre, Apellido, Numero de aluno y direccion de correo electronico. El archivo debe llamarse "LEAME": `vi README` (luego ingrese la informacion y guarde el archivo)
3. Cambie los permisos del archivo "LEAME" de manera que se puedan ver reflejados los siguientes permisos: 
   - Dueño: ningun permiso
   - Grupo: ejecucion
   - Otro: todos los permisos
   `chmod 017 README`
4. Vaya al directorio /etc y verifique su contenido. Cree un archivo dentro de su directorio personal cuyo nombrre sea "LEAME" donde el contenido del mismo sea el listado de todos los archivos y directorios contenidos en /etc. Cual es la razon por la cual puede crear este archivo si ya existe un archivo llama "LEAME" en este directorio? `cd /etc && ls -l > /home/<su nombre de usuario>/LEAME` (puede crear el archivo porque está en un directorio diferente)
5. Que comando utilizario y de que manera si tuviera que localizar un archivo dentro del fileSystem? y si tuviera que locarizar varios archivos con caracteristicas similires? `find / -name "nombre_del_archivo"` para un archivo específico, y `find / -name "*.extensión"` para varios archivos con características similares.


# Comandos (23)
Indique qué acción realiza cada uno de los comandos indicados a continuación
considerando su orden. Suponga que se ejecutan desde un usuario que no es root ni
pertenece al grupo de root. (Asuma que se encuentra posicionado en el directorio de
trabajo del usuario con el que se logueó). En caso de no poder ejecutarse el comando
indique la razón:
01. mkdir iso
02. cd . / iso; ps > f0
03. ls > f1
04. cd /
05. echo $HOME
06. ls −l $> $HOME/ iso/ls
07. cd $HOME; mkdir f2
08. ls −ld f2
09. chmod 341 f2
10. touch dir
11. cd f2
12. cd ~/iso
13. pwd > f3
14. ps | grep 'ps' | wc −l >> ../f2/f3
15. chmod 700 ../f2 ; cd ..
16. find . −name etc/passwd
17. find / −name etc/passwd
18. mkdir ejercicio5
19. . . . . . . . . . . . . . . . . . . .
20. . . . . . . . . . . . . . . . . . . .

1. `mkdir iso`: Crea un directorio llamado `iso` en el directorio actual.
2. `cd ./iso; ps > f0`: Cambia al directorio `iso` y guarda la lista de procesos en ejecución en un archivo llamado `f0`.
3. `ls > f1`: Lista los archivos en el directorio actual (`iso`) y redirige la salida a un archivo llamado `f1`.
4. `cd /`: Cambia al directorio raíz (`/`).
5. `echo $HOME`: Muestra la ruta del directorio home del usuario actual.
6. `ls -l $> $HOME/iso/ls`: Este comando es incorrecto debido al uso de `$>`; probablemente se quiso usar `ls -l > $HOME/iso/ls`, que listaría los archivos en el directorio raíz y redirigiría la salida a un archivo llamado `ls` dentro del directorio `iso` en el home del usuario.
7. `cd $HOME; mkdir f2`: Cambia al directorio home del usuario y crea un directorio llamado `f2`.
8. `ls -ld f2`: Muestra los detalles del directorio `f2`.
9. `chmod 341 f2`: Cambia los permisos del directorio `f2` para que el propietario tenga permisos de escritura (3), el grupo tenga permisos de lectura (4), y otros tengan permisos de ejecución (1).
10. `touch dir`: Crea un archivo vacío llamado `dir` en el directorio actual (`f2`).
11. `cd f2`: Cambia al directorio `f2`.
12. `cd ~/iso`: Cambia al directorio `iso` dentro del directorio home del usuario.
13. `pwd > f3`: Guarda la ruta del directorio actual (`iso`) en un archivo llamado `f3`.
14. `ps | grep 'ps' | wc -l >> ../f2/f3`: Cuenta el número de procesos que contienen la cadena 'ps' y agrega el resultado al final del archivo `f3` en el directorio `f2`.
15. `chmod 700 ../f2 ; cd ..`: Cambia los permisos del directorio `f2` para que solo el propietario tenga todos los permisos (7) y luego cambia al directorio padre.
16. `find . -name etc/passwd`: Busca un archivo llamado `passwd` dentro del directorio `etc` en el directorio actual y sus subdirectorios. Probablemente no encontrará nada porque `etc/passwd` no está en el directorio actual.
17. `find / -name etc/passwd`: Busca un archivo llamado `passwd` dentro del directorio `etc` en todo el sistema de archivos. Este comando puede tardar mucho tiempo y puede generar muchos errores de permisos al intentar acceder a ciertos directorios.
18. `mkdir ejercicio5`: Crea un directorio llamado `ejercicio5` en el directorio actual.

