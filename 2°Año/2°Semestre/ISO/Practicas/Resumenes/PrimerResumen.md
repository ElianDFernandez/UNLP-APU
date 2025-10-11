# Sistemas Operativos

# Que es un Sistema Operativo?
- **Software** que actua como **intermediario** entre el usuario y el hardware de la computadora.
- Funciones:
    * Gestiona el hardware.
    * Controla la ejecución de programas.
    * Brinda abstraccion de alto nivel.
    * Administracion de recursos, memoria, procesos, dispositivos de entrada/salida.
    * Brinda asistencia para E/S.

## Perspectivas 
- **Desde el usuario (Arriba hacia abajo)**: 
    * Abstraccion de la arquitectura de hardware.
    * Oculta el hardware complejo.
    * Programas de aplicacion.
    * Comodidad y amigabilidad.

- **Desde el sistema (Abajo hacia arriba)**:
    * Abstraccion de recursos de hardware.
    * Provee servicios a usuario.
    * Maneja memoria secundaria y dispositivos de E/S.
    * Ejecucion simultanea de multiples programas.
    * Multiplexacion(comparticion) de CPU.

## Objetivos de un Sistema Operativo
- **Comodidad**: Facilitar el uso de la computadora.
- **Eficiencia**: Utilizar los recursos de manera optima.
- **Capacidad de evolucion**: Facilitar cambios y adaptaciones futuras.

## Componentes de un Sistema Operativo
- **Nucleo (Kernel)**: Gestiona recursos y servicios basicos.
- **Shell**: Interfaz entre usuario y nucleo.
- **Herramientas y utilidades**: Programas adicionales para tareas especificas.

## Servicios y administracion de recursos
- **Administracion procesador/CPU**
    * Planificacion de procesos.
    * Multiprogramacion.
    * Imparcialidad.
    * Manejo de prioridades.
    * Evitar bloqueos.

- **Administracion de memoria**
    * Memoria fisica y virtual.
    * Jerarquias de memoria.
    * Proteccion de programas concurrentes.

- **Administracion de almacenamiento**
    * Sistemas de archivos.
    * Acceso a medios externos.

- **Administracion de dispositivos de E/S**
    * Ocultamiento de dependencias de hardware.
    * Administracion de accesos simultaneos.

- **Otros servicios**
    * Deteccion y recuperacion de errores.
    * Interaccion del usuario.
    * Contabilidad.

## Proteccion y seguridad (Apoyo de hardware)
- **Modo de ejecucion**: Modos de usuario y kernel: Bit de modo en CPU. Este bit indica si la CPU esta en modo usuario (bit=1) o en modo kernel (bit=0). Cada modo tiene diferentes privilegios de acceso a recursos del sistema.
- **Proteccion de memoria**: Limitar espacio de direcciones accesible por cada proceso. Registros base y limite cargados por el Kernel en la CPU.
- **Proteccion de E/S**: Instrucciones de E/S solo ejecutables en modo kernel.
- **Proteccion de CPU**: Interrupcion de clock para evitar apropiacion.

## System Calls 
Forma en que programas de usuario acceden a servicios del sistema operativo. Se ejecutan en modo kernel. Ejemplos: read(file, buffer, size), write(file, buffer, size), fork(), exec(), wait(), exit().

# Procesos 
Programa en ejecucion. Incluye codigo, datos, estado de ejecucion, recursos asignados. Tiene program counter(PC).
Componentes:
- **Codigo**: Instrucciones del programa.
- **Datos**: Variables y estructuras de datos.
- **Estado de ejecucion**: Registros, PC, pila.
- **Recursos asignados**: Memoria, archivos, dispositivos.

## PCB (Process Control Block)
Estructura de datos que contiene informacion sobre un proceso. Incluye:
- Identificador del proceso (PID).
- Identificador del proceso padre (PPID).
- Registros de CPU.
- Planificacion (prioridad, cola).
- Ubicacion en memoria.
- E/s (archivos abiertos, dispositivos).

Sirve para gestionar y controlar procesos en el sistema operativo. Para retomar la ejecucion de un proceso, el sistema operativo utiliza la informacion almacenada en su PCB.
La PCB se almacena en memoria y es gestionada por el kernel del sistema operativo. Es el contexto del proceso, sirve para el context switching.

## Context Switch
Cambio de CPU de un proceso a otro. Implica guardar el estado del proceso actual en su PCB y cargar el estado del nuevo proceso desde su PCB. Es costoso en tiempo, por lo que se busca minimizar su frecuencia. 
Pasos:
1. Guardar registros de CPU del proceso actual en su PCB.
2. Actualizar estado del proceso actual (e.g., de "ejecutando" a "listo" o "bloqueado"). Se encarga el dispatcher.
3. Seleccionar un nuevo proceso para ejecutar (planificacion). Se encarga el scheduler.
4. Cargar registros de CPU del nuevo proceso desde su PCB. Se encarga el dispatcher.
5. Actualizar estado del nuevo proceso a "ejecutando".

## Estados de un proceso
- **Nuevo**: Proceso creado pero no listo.
- **Listo**: Proceso preparado para ejecutar, esperando CPU.
- **Ejecutando**: Proceso actualmente en CPU.
- **Bloqueado**: Proceso esperando un evento (E/S, semaforo).
- **Terminado**: Proceso finalizado.

## Creacion y terminacion de procesos
- **Creacion**: Proceso padre crea proceso hijo (fork). Se asigna PCB, memoria, recursos. El proceos hijo se inicializa con copia del padre, ejecutandose desde la instruccion siguiente al fork. El padre puede esperar a que el hijo termine (wait) o continuar (exec). Ejemplo de codigo en C:
```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid = fork(); // Crear un nuevo proceso
    // fork() devuelve 0 al proceso hijo y el PID del hijo al proceso padre
    if (pid < 0) {
        // Error al crear el proceso
        perror("Fork failed");
        exit(1);
    } else if (pid == 0) {
        // Codigo del proceso hijo
        printf("Hola desde el proceso hijo! Mi PID es %d\n", getpid());
        exit(0); // Terminar el proceso hijo
    } else {
        // Codigo del proceso padre
        printf("Hola desde el proceso padre! Mi PID es %d y el PID de mi hijo es %d\n", getpid(), pid);
        wait(NULL); // Esperar a que el proceso hijo termine
        printf("El proceso hijo ha terminado.\n");
    }

    return 0;
}
```

- **Terminacion**: Proceso finaliza (exit). Recursos son liberados. El padre puede obtener el estado de terminacion del hijo (wait). Si el padre termina antes que el hijo, el hijo se convierte en proceso huérfano y es adoptado por init (PID 1).

# Planificacion de Procesos(Scheduling)
La planificacion de procesos es la tarea del sistema operativo de decidir qué proceso en el sistema debe ser asignado a la CPU para su ejecución en un momento dado. El objetivo principal de la planificación es maximizar el uso de la CPU, minimizar el tiempo de espera de los procesos y garantizar una distribución justa de los recursos del sistema entre todos los procesos.

## Modulos de planificacion
- **Planificador a largo plazo (Long-term scheduler)**: Decide qué procesos se admiten en el sistema y se cargan en la memoria. Controla la multiprogramación y la carga del sistema.
- **Planificador a medio plazo (Medium-term scheduler)**: Se encarga de la suspensión y reanudación de procesos. Puede mover procesos entre la memoria principal y el disco para gestionar la carga de trabajo.
- **Planificador a corto plazo (Short-term scheduler)**: Selecciona qué proceso en estado "listo" debe ejecutarse en la CPU. Es el más crítico para el rendimiento del sistema y debe ser rápido y eficiente.

- **Despachador (Dispatcher)**: Es el módulo que realiza el cambio de contexto entre procesos. Se encarga de guardar el estado del proceso actual y cargar el estado del nuevo proceso seleccionado por el planificador a corto plazo.

## Comportacion de procesos 
- **CPU-bound**: Procesos que pasan la mayor parte de su tiempo utilizando la CPU. Ejemplos: cálculos intensivos, procesamiento de datos.
- **I/O-bound**: Procesos que pasan la mayor parte de su tiempo esperando operaciones de entrada/salida. Ejemplos: lectura/escritura de archivos, interacción con dispositivos.

## Tipos de planificacion
- **No expropiativa (Non-preemptive)**: Una vez que un proceso comienza a ejecutarse, no puede ser interrumpido hasta que termine o se bloquee. Ejemplos: First-Come, First-Served (FCFS), Shortest Job Next (SJN).
- **Expropiativa (Preemptive)**: Un proceso en ejecución puede ser interrumpido y movido a estado "listo" para permitir que otro proceso se ejecute. Ejemplos: Round Robin (RR), Shortest Remaining Time (SRT), Priority Scheduling.

## Algoritmos de planificacion
- **First-Come, First-Served (FCFS)**: El proceso que llega primero es el primero en ser atendido. Simple pero puede causar tiempos de espera largos (convoy effect).
- **Shortest Job Next (SJN)**: Selecciona el proceso con el tiempo de ejecución más corto. Minimiza el tiempo de espera promedio, pero puede causar inanición para procesos largos.
- **Shortest Remaining Time (SRT)**: Versión expropiativa de SJN. Interrumpe el proceso actual si llega uno con menor tiempo restante.
- **Round Robin (RR)**: Cada proceso recibe un tiempo fijo (quantum) para ejecutarse. Si no termina, se mueve al final de la cola. Bueno para sistemas interactivos.
- **Virtual Round Robin (VRR)**: Variante de RR que ajusta dinámicamente el quantum basado en la carga del sistema. Tiene una cola auxiliar para procesos que vuelve de realizar E/S y tienen la mayor prioridad.
- **Priority Scheduling**: Asigna la CPU al proceso con la mayor prioridad. Puede ser expropiativo o no expropiativo. Puede causar inanición para procesos de baja prioridad.
- **Multilevel Queue Scheduling**: Divide los procesos en varias colas según su tipo (e.g., interactivos, batch) y asigna diferentes algoritmos de planificación a cada cola.

# Administracion de Memoria
La administración de memoria es una función crítica del sistema operativo que se encarga de gestionar la memoria principal (RAM) de la computadora. Su objetivo es asignar y liberar memoria de manera eficiente para maximizar el rendimiento del sistema y garantizar que los procesos tengan acceso a la memoria que necesitan para ejecutarse.

## Requisitos de la administracion de memoria
- **Protección**: Asegurar que un proceso no pueda acceder a la memoria asignada a otro proceso.
- **Reubicacion**: Permitir que los procesos se muevan en la memoria para optimizar el uso del espacio.
- **Compartición**: Permitir que varios procesos accedan a la misma área de memoria cuando sea necesario.

## Direcciones de memoria
- **Dirección lógica (virtual)**: Dirección generada por la CPU durante la ejecución de un programa. Es independiente de la ubicación física en la memoria. 
- **Dirección física**: Dirección real en la memoria RAM donde se almacena un dato. La traducción de direcciones lógicas a físicas es realizada por la unidad de gestión de memoria (MMU).

## MMU (Memory Management Unit)
Componente de hardware que traduce direcciones lógicas a físicas. Utiliza tablas de páginas o segmentos para realizar la traducción. Proporciona protección y aislamiento entre procesos.

## Mecanismos de administracion de memoria
- **Particion fija**: Divide la memoria en bloques de tamaño fijo. Simple pero puede causar fragmentación interna. La traducción de direcciones es directa (dirección lógica = dirección física + base).
- **Particion variable**: Divide la memoria en bloques de tamaño variable según las necesidades de los procesos. Reduce la fragmentación interna pero puede causar fragmentación externa. La traducción de direcciones requiere buscar un bloque adecuado (first-fit, best-fit, worst-fit).

- **Segmentacion**: Divide la memoria en segmentos lógicos (código, datos, pila). Cada segmento tiene su propia tabla de segmentos. Permite compartir y proteger segmentos entre procesos. La traducción de direcciones utiliza tablas de segmentos, que mapean segmentos lógicos a direcciones físicas.

- **Paginacion**: Divide la memoria en páginas de tamaño fijo. Los procesos se dividen en páginas que se cargan en marcos de página en la memoria física. Reduce la fragmentación externa y permite la memoria virtual. La traducción de direcciones utiliza tablas de páginas, que mapean páginas lógicas a marcos físicos.

## Paginacion 1 nive, 2 niveles y invertida
- **Paginacion de 1 nivel**: Utiliza una sola tabla de páginas para mapear todas las páginas lógicas a marcos físicos. Simple pero puede ser ineficiente para procesos grandes debido al tamaño de la tabla.
Las direcciones logicas tienen el formato <numero de pagina, desplazamiento>. La MMU utiliza el numero de pagina para buscar en la tabla de paginas y obtener el marco fisico correspondiente. Luego, combina el marco fisico con el desplazamiento para obtener la direccion fisica final.

- **Paginacion de 2 niveles**: Divide la tabla de páginas en dos niveles para reducir el tamaño de la tabla. La primera tabla apunta a tablas de páginas secundarias. Más eficiente para procesos grandes.
Las direcciones logicas tienen el formato <indice de tabla de paginas, indice de pagina, desplazamiento>. La MMU utiliza el indice de tabla de paginas para buscar en la tabla de paginas de primer nivel y obtener la direccion de la tabla de paginas secundaria. Luego, utiliza el indice de pagina para buscar en la tabla de paginas secundaria y obtener el marco fisico correspondiente. Finalmente, combina el marco fisico con el desplazamiento para obtener la direccion fisica final.

- **Paginacion invertida**: Utiliza una sola tabla que mapea marcos fisicos a paginas logicas. Reduce el tamaño de la tabla pero puede ser mas lento debido a la busqueda. Utiliza hashing para acelerar la busqueda.
Las direcciones logicas tienen el formato <numero de pagina, desplazamiento>. La MMU utiliza el numero de pagina para calcular un indice en la tabla de paginas invertida. Luego, busca en la tabla de paginas invertida para encontrar el marco fisico correspondiente a la pagina logica. Finalmente, combina el marco fisico con el desplazamiento para obtener la direccion fisica final.

## TLB (Translation Lookaside Buffer)
Cache de alta velocidad que almacena las traducciones recientes de direcciones lógicas a físicas. Mejora el rendimiento al reducir el tiempo de acceso a la memoria.

# Linux

# Sistemas Operativos Arranque
El proceso de arranque (booting) es el conjunto de pasos que realiza una computadora para iniciar su sistema operativo desde el momento en que se enciende hasta que el sistema operativo está completamente cargado y listo para usarse.

1-La cpu sale del estado de reset y pasa el control al firmware (BIOS o UEFI).
2-El firmware realiza un POST (Power-On Self Test) para verificar que el hardware básico (memoria, CPU, dispositivos) esté funcionando correctamente. El firmware busca un dispositivo de arranque (disco duro, SSD, USB, red) según el orden configurado.
3-El firmware carga el primer sector del dispositivo de arranque (MBR o GPT) en memoria y transfiere el control a ese código.
4-El código del MBR o GPT carga el cargador de arranque (bootloader) en memoria y transfiere el control a él.
5-El bootloader carga el núcleo (kernel) del sistema operativo en memoria y transfiere el control a él.
6-El núcleo inicializa el hardware, monta el sistema de archivos raíz y lanza el proceso init (o systemd) que gestiona los servicios y procesos del sistema.

El MBR siempre pesara 512 bytes y contiene el código de arranque y la tabla de particiones. El GPT es más moderno y soporta discos más grandes y más particiones.

| Característica                | **BIOS (con MBR)**                      | **UEFI (con GPT)**                                       |
| ----------------------------- | --------------------------------------- | -------------------------------------------------------- |
| Primer sector (MBR)           | Sí, obligatorio (512 bytes, ejecutable) | Solo “protective MBR”, no ejecutable                     |
| Código de arranque            | En el MBR (446 bytes)                   | En archivos `.efi` dentro de la partición EFI            |
| Dónde está el bootloader      | Sector 0 del disco                      | Partición EFI (`/EFI/.../bootx64.efi`)                   |
| Tamaño del código de arranque | 512 bytes máximo                        | Sin límite (archivos en FAT32)                           |
| Cómo se ejecuta               | BIOS lee sector 0 y ejecuta código      | UEFI lee sistema de archivos FAT32 y ejecuta archivo EFI |

