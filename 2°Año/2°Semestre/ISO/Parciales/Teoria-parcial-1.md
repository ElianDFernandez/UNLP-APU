- Al parcial entrando todas las teorias hasta memoria 1.
* Introduccion a Sistemas Operativos
* Interrupciones
* Excepciones
* System Calls
* Procesos 
* Administración de Memoria (Memoria 1) / Dispatcher y Scheduler

# Teoría Parcial 1
# Introduccion a Sistemas Operativos
Un sistema operativo es un programa que actúa como intermediario entre el usuario y el hardware de la computadora. Su objetivo principal es proporcionar un entorno en el que el usuario pueda ejecutar programas de manera eficiente y segura.

* Perspectiva desde el usuario 
    - Abstraccion con respecto a la arquitectura de la computadora.
    **Arquitectura de la computadora**: Conjunto de instrucciones que el hardware puede ejecutar, organizacion de la memoria, dispositivos de entrada/salida, etc.
    - El SO "oculta" el hardware.
    - Los programas de aplicacion son los "clientes" del SO.

* Perspectiva desde el sistema
    - Administra los recursos de HW de uno o mas proceso.
    **Proceso**: Programa en ejecucion.
    - Provee un conjunto de servicios a los usuarios del sistema.
    - Maneja la memoria secundaria y dispositivos de E/S.
    - Ejecucion simultanea de varios procesos.
    - Multiplexacion del CPU y en espacio de memoria.

Objetivos del SO:
- **Comodidad**: Facilitar el uso de la computadora.
- **Eficiencia**: Utilizar el hardware de manera eficiente.
- **Evolucion**: Permitir que el sistema evolucione.

Componentes de un SO:
- **Nucleo (Kernel)**: 
    * Componente del SO que se encuentra en memoria todo el tiempo.
    * Se encarga dea la administracion de los recursos de hardware.
    * Implementa servicions esenciales: 
        - Manejo de la memoria.
        - Manejo de la CPU.
        - Administracion de procesos.
        - Comunicacion y concurrencia.
        - Gestion de la E/S.
- **Shell**: 
    * Interprete de comandos.
    * Provee una interfaz entre el usuario y el SO.
    * Permite al usuario ejecutar programas, gestionar archivos, etc.
    * GUI (Graphical User Interface) o CLI (Command Line Interface)

Servicios que provee el SO:
    * **Administracion y planificacion del procesador**:
        - Multiplexacion del CPU entre varios procesos.
        - Imparcialidad en la ejecucion.
        - Que no haya bloqueos.
        - Manejo de prioridades.
    * **Administracion de memoria**:
        - Administra la memoria eficientemente.
        - Memoria fisica y virtual.
        - Proteccion de memoria.
    * **Administracion del almacenamiento**:
        - Acceso a medios de almacenamiento externos.
    * **Administracion de dispositivos de E/S**:
        - Controladores de dispositivos.
        - Abstraccion de dispositivos.
    * **Deteccion de errores y respuestas**
        - Errores de HW internos y externos.
        - Errores de SW.
        - Incapacidad del SO para conceder una peticion.
    * **Interfaz de usuario**:
        - GUI o CLI.
    * **Contabilidad**:
        - Recoger estadisticas del uso
        - Monitoreo del rendimiento del sistema.
    
## Fragmentacion Interna en paginas
Es el espacio desperdiciado en la ultima pagina asignada a un proceso.
Si el proceso ocupa 40501 bytes y el tamaño de pagina es de 2048 bytes, entonces:
- Cantidad de paginas: 40501/2048 = 19.76 -> 20 paginas
- Memoria ocupada: 20 * 2048 = 40960 bytes
- Fragmentacion interna: 40960 - 40501 = 459 bytes