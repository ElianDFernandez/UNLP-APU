# Pasos para que se dispare un proceso del sistema operativo

Ejemplo de un proceso de interrupcion completo:
1- Un dispositivo de hardware (como un teclado o un temporizador) genera una señal de interrupción.
2- El controlador de interrupciones del hardware envía la señal al procesador.
3- El procesador detiene temporalmente la ejecución del proceso actual y guarda su contexto.
4- El sistema operativo toma el control y maneja la interrupción, ejecutando el código correspondiente.
5- Una vez que se ha manejado la interrupción, el sistema operativo restaura el contexto del proceso interrumpido.
6- El procesador reanuda la ejecución del proceso interrumpido.

# Proceso 
**Que es?**
Es un programa en ejecucion, para nosotros seran sinonimos: tarea,job y proceso.

**Diferencias entre programa y proceso**
Un programa es estatico, mientras que un proceso es dinamico.
Un programa no tiene program counter, mientras que un proceso si.
Un programa existe desde que edita hasta que se borra, mientras que un proceso existe desde que se crea hasta que se termina.
Un programa no tiene recursos asignados, mientras que un proceso si.

# Modelo de proceso 
Un modelo de proceso es una representación abstracta de un proceso en ejecución. Incluye información sobre el estado del proceso, su contexto y los recursos que está utilizando. Los modelos de proceso son utilizados por los sistemas operativos para gestionar la ejecución de procesos y garantizar que se cumplan las políticas de planificación y asignación de recursos.

# Componentes de un proceso 
Un proceso incluye como minimo:
- Seccion de codigo
- Seccion de datos
- Seccion de pila (Stacks)->Datos temporarios: parametros, variables temporales y direcciones de retorno.

## Stacks 
- Un proceso cuenta con 1 o mas stacks: En general modo Usuario y modo Kernel.
- Se crean automaticamente y su medida se ajusta en tiempo de ejecucion.
- Esta formado por stack frames que son pushed(apilados) y popped(deshapilados) a medida que se invocan y retornan funciones.
- El stack frame tiene los parametros de la rutina, variables locales y la direccion de retorno.

# Atributos de un proceso 
- Identificador de proceso (PID)
- Indentificacion del usuario que lo "disparo"
- Si hay estructura de grupos, grupo que los disparo
- En ambientes multiusuario, desde que terminal y quien lo ejecuto

# Process Control Block (PCB)
El PCB es una estructura de datos utilizada por el sistema operativo para almacenar información sobre un proceso en particular. Contiene todos los atributos y el estado del proceso, lo que permite al sistema operativo gestionar la ejecución de procesos de manera eficiente. El PCB se crea cuando se inicia un proceso y se destruye cuando el proceso finaliza.
Esta PCB sirve como un registro del estado del proceso y permite al sistema operativo suspender y reanudar la ejecución del proceso según sea necesario.

## Componentes del PCB
- Identificador de proceso (PID)
- Estado del proceso (nuevo, listo, en ejecución, bloqueado)
- Contador de programa (PC)
- Registros de CPU
- Información sobre la memoria (páginas, segmentos)
- Información sobre la entrada/salida (dispositivos asignados)
- Información de contabilidad (tiempo de CPU, tiempo de espera)

# Espacio de direcciones de un proceso?
- Es el conjunto de direcciones de memoria que ocupa el proceso -> stack, text, y datos.
- No incluye su PCB o tablas asociadas 
- Un proceso en modo usuario puede acceder solo a su espacio de direcciones.
- En modo kernel, se puede acceder a estructuras internas (PCB del proceso por ejemplo) o a espacios de direcciones de otros procesos.

# Como se escribe la PCB? y quien la escribe?
La PCB se escribe en la memoria del sistema operativo cuando se crea un nuevo proceso. El sistema operativo es responsable de inicializar la PCB con la información necesaria sobre el proceso, como su estado, identificador, y recursos asignados. A medida que el proceso se ejecuta y cambia de estado, el sistema operativo actualiza la PCB para reflejar estos cambios.

# Contexto de un proceso
El contexto de un proceso se refiere a la información que el sistema operativo necesita para gestionar la ejecución del proceso. Esto incluye el estado del proceso, su contador de programa, los registros de la CPU, y la información sobre la memoria y los recursos asignados. El contexto se guarda en la PCB y se utiliza para suspender y reanudar la ejecución del proceso según sea necesario.

# Cambios en el contexto
- Se produce cuando la CPU cambia de un proceso a otro, lo que implica guardar el contexto del proceso actual y cargar el contexto del nuevo proceso.
- Cambiar de procesos implica actualizar la PCB del proceso que se va a suspender y cargar la PCB del proceso que se va a reanudar. Hay un cambio en la MMU en el procesador. MMU: Memory Management Unit. 
- Es tiempo no productivo de CPU.
- El tiempo que consume depende del soporte de hardware.

Esquema:
````
Proceso P0 Ejecucion ---------------------------------------------------->
                      | 
Sistema Operativo     |-> interrupcion |
                                       |-> guardar contexto PCB0
                                       |-> cargar contexto PCB1 |
                                                                |
Proceso P1 Ejecucion                                            |--------->
````

# Sobre el kernel del sistema operativo
- Es un conjunto de modulos de software
- Se ejecuta en el procesador como cualquier otro proceso

# Kernel enfoque 1
## Kernel como entidad independiente
- El kernel se ejecuta fuera de todo proceso
- Es una arquitectura utilizada por los primeros SO
- Cuando un proceso se "interrumpe", el kernel toma el control y guarda el contexto del proceso interrumpido y el control se pasa al Kernel del sistema operativo. Ademas de guardar el contexto de proceso tambien se debe guardar el contexto del sistema operativo.
- El kernel tiene su propia región de memoria.
- El kernel tiene su propio stack.
- Finalizada su actividad le devuelve el control al proceso interrumpido.
- El kernel NO es un proceso, el concepto de proceso solo se asocia a programas de usuario.
- El kernel se ejecuta como una entidad independiente en modo privilegiado.

# Kernel enfoque 2
- El "codigo" del kernel se encuentra dentro del espacio de direcciones de cada proceso.
- El kernel se ejecuta en el mismo contexto que algun proceso de usuario.
- El kernel se puede ver como una coleccion de rutinas que el proceso utiliza.
- Dentro de un proceso se encuentra el codigo del programa y el codigo de los modulos de SW del SO.
- Cada proceso tiene su propio stack. Uno en modo usuario y otro en modo kernel.
- El proceso es el que se ejecuta en modo usuario, y el kernel del SO se ejecuta en modo kernel.
- El codigo del kernel es compartido por todos los procesos.
- Cada interrupcion es atendida en el contexto del proceso que se encontraba en ejecucion pero en modo kernel(Se para sin necesidad de hacer un cambio de contexto).
- El SO determina que el proceso debe seguir ejecutandose o ser suspendido.