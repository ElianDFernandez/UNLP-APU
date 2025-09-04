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
