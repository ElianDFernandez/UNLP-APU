# Procesos 2
# Estados de un proceso

````
                         --------------(Interrupcion)---------------------
                        |                                               |
                        v                                               |   
NUEVO -(Adminitido)-> LISTO ----------(Scheduler dispatch)----------> EJECUTANDO -(Salida)-> TERMINADO
                        ^                                               |
                        |                                               |
                        |                                               v
                    (I/O o evento completado)----ESPERANDO----(I/O o esperando evento)
````

### Descripcion de los estados
- Nuevo: El proceso se esta creando. El SO crea la PCB y asigna recursos.
- Listo: El proceso esta preparado para ejecutarse, pero no se le asigno CPU aun.
- Ejecutando: El proceso esta en ejecucion, tiene asignada la CPU. 
- Esperando: El proceso esta esperando por algun evento o por la finalizacion de una operacion de E/S.
- Terminado: El proceso finalizo su ejecucion. El SO libera los recursos asignados

## Quien orquesta los cambios de estado?
- El sistema operativo. Es decir, el kernel del SO.

## Ejemplo de un proceso 'x'
1. El proceso 'x' se crea y pasa al estado NUEVO. El SO crea la PCB, donde se almacena la informacion del proceso, y asigna los recursos necesarios, como memoria y archivos.
2. Una vez que el proceso 'x' esta listo para ejecutarse, el SO lo mueve al estado LISTO. El proceso 'x' ahora puede ser seleccionado por el planificador para ser ejecutado.
3. El planificador selecciona el proceso 'x' y lo mueve al estado EJECUTANDO, asignandole la CPU. El proceso 'x' comienza a ejecutar sus instrucciones. Internamente el CPU tiene un registro llamado PC (Program Counter) que apunta a la siguiente instruccion a ejecutar.
4. Si el proceso 'x' necesita realizar una operacion de E/S o espera por un evento, el SO lo mueve al estado ESPERANDO. Durante este tiempo, el proceso 'x' no utiliza la CPU y espera a que la operacion de E/S se complete o el evento ocurra.
5. Una vez que la operacion de E/S se completa o el evento ocurre, el SO mueve el proceso 'x' de vuelta al estado LISTO, donde espera ser seleccionado nuevamente por el planificador.
6. El planificador puede seleccionar nuevamente el proceso 'x' y moverlo al estado EJECUTANDO para que continue su ejecucion.
7. Finalmente, cuando el proceso 'x' completa su tarea, el SO lo mueve al estado TERMINADO, liberando los recursos que habia asignado al proceso.

# Modulos de planificacion
Son modulos del sistema operativo que gestionan los cambios de estado de los procesos. Incluyen:
- Scheduler de largo plazo: Decide que procesos se admiten en el sistema y pasan al estado LISTO.
- Scheduler de corto plazo: Decide que proceso en estado LISTO se mueve al estado EJECUTANDO.
- Scheduler de mediano plazo: Gestiona la memoria y puede mover procesos entre los estados LISTO y ESPERANDO, o incluso suspender procesos si es necesario.

Otros modulos Dispatcher y Loader, son:
- Dispatcher: Es el modulo encargado de asignar la CPU a un proceso en estado LISTO. Realiza el cambio de contexto entre procesos.
- Loader: Es el modulo encargado de cargar un proceso en memoria y prepararlo para su ejecucion.
En resumen los schedulers deciden que proceso se ejecuta y cuando, el dispatcher realiza el cambio de contexto y el loader carga el proceso en memoria.

# Comportamiento de los proceso 
Proceso alternan rafagas de CPU y de I/O:
```
Proceso A --------|     |----------|   |----------|    |---------
            |                                         ^ 
            |-> Long CPU burst (rafaga de CPU)        |
                                                      |
                                                      |-> Waiting for I/O          
                                                      v
Proceso B -----| |--| |----| |----| |----| |---------| |---------
           |
           |-> Short CPU burst (rafaga de CPU)
```

- Rafaga de CPU: Periodo durante el cual un proceso utiliza la CPU para ejecutar instrucciones.
- Rafaga de I/O: Periodo durante el cual un proceso esta esperando por una operacion de E/S, como leer o escribir en un disco, o esperar por una entrada del usuario.
- La velocidad de la CPU es mucho mayor que la velocidad de los dispositivos de E/S, por lo que los procesos suelen alternar entre periodos cortos de ejecucion en la CPU y periodos mas largos de espera por E/S.

# Algoritmos apropiativos y no apropiativos
- Apropiativos (Preemptive): El sistema operativo puede interrumpir un proceso en ejecucion para asignar la CPU a otro proceso. Esto permite una mejor gestion del tiempo de CPU y es adecuado para sistemas interactivos donde se busca minimizar el tiempo de respuesta.
- No apropiativos (Non-preemptive): Una vez que un proceso comienza a ejecutarse, no puede ser interrumpido hasta que termine su rafaga de CPU o pase al estado ESPERANDO. Es mas simple de implementar, pero puede causar tiempos de espera largos para procesos en estado LISTO si un proceso largo esta en ejecucion.

# Categorias de algoritmos de planificacion
Segun el ambiente en el que se utilicen, los algoritmos de planificacion se pueden clasificar en:
- Planificacion por lotes (Batch scheduling): Utilizado en sistemas donde los trabajos se ejecutan en lotes sin interaccion del usuario. El objetivo es maximizar el rendimiento del sistema y minimizar el tiempo de respuesta.
- Planificacion interactiva (Interactive scheduling): Utilizado en sistemas donde los usuarios interactuan con el sistema en tiempo real. El objetivo es minimizar el tiempo de respuesta para mejorar la experiencia del usuario.
- Planificacion en tiempo real (Real-time scheduling): Utilizado en sistemas donde las tareas tienen restricciones de tiempo estrictas. El objetivo es garantizar que las tareas se completen dentro de sus limites de tiempo.

Pueden convivir varios algoritmos de planificacion en un mismo sistema operativo, cada uno adaptado a diferentes tipos de procesos y necesidades del sistema.

# Procesos Batch 
Ejemplos de algoritmos: 
- FIFO (First In, First Out): Los procesos se ejecutan en el orden en que llegan. Es simple pero puede causar tiempos de espera largos para procesos cortos si hay un proceso largo al frente de la cola.
- SJF (Shortest Job First): El proceso con la rafaga de CPU mas corta se ejecuta primero. Minimiza el tiempo de espera promedio, pero puede causar inanicion para procesos largos si hay muchos procesos cortos.

# Procesos Interactivos
No solo se busca maximizar el rendimiento, sino tambien minimizar el tiempo de respuesta para mejorar la experiencia del usuario. Ejemplos de algoritmos:
- Round Robin (RR): Cada proceso recibe una cantidad fija de tiempo de CPU (quantum). Si un proceso no termina en su quantum, se mueve al final de la cola. Es justo y adecuado para sistemas interactivos.
- Prioridad: Cada proceso tiene una prioridad, y el proceso con la prioridad mas alta se ejecuta primero. Puede causar inanicion para procesos de baja prioridad si hay muchos procesos de alta prioridad.
- Colas Multinivel (Multilevel Queue): Los procesos se dividen en varias colas segun su tipo (por ejemplo, interactivos, batch). Cada cola puede tener su propio algoritmo de planificacion. Permite una gestion mas flexible de diferentes tipos de procesos.
- SRTF (Shortest Remaining Time First): Variante preemptiva de SJF. El proceso con el menor tiempo restante de CPU se ejecuta primero. Puede causar cambios frecuentes de contexto, lo que puede afectar el rendimiento.