Respuestas de forma sintetica.
# 1
**A-Que es un sistema operativo?**
Un sistema operativo es un software que actúa como intermediario entre el hardware de una computadora  y los programas de aplicacion. Su función principal es gestionar los recursos del sistema, como la memoria, el procesador, el almacenamiento y los dispositivos de entrada/salida, para asegurar que los programas funcionen correctamente y de manera eficiente.

**B-Enumere que compoenentes/aspectos del harware son necesarios para cumplir con los objetivos de un sitema operativo.**
1. Procesador (CPU): Es el componente principal que ejecuta las instrucciones del sistema operativo y de las aplicaciones.
2. Memoria RAM: Almacena temporalmente los datos y programas en ejecución, permitiendo un acceso rápido.
3. Dispositivos de almacenamiento (HDD, SSD): Almacenan el sistema operativo, aplicaciones y datos de forma permanente.
4. Dispositivos de entrada/salida (teclado, mouse, pantalla, impresora): Permiten la interacción entre el usuario y el sistema operativo.
5. Tarjeta madre (Motherboard): Conecta todos los componentes del hardware y permite la comunicación entre ellos.
6. Tarjeta de red: Permite la conexión a redes y la comunicación con otros dispositivos
7. Fuente de alimentación: Proporciona energía eléctrica a todos los componentes del hardware.

**C-Enumere componentes de un sistema operativo.**
1. Núcleo (Kernel): Es el componente central que gestiona los recursos del sistema y permite la comunicación entre el hardware y el software.
2. Gestor de memoria: Administra la memoria RAM, asignando y liberando espacio según las necesidades de los programas.
3. Gestor de procesos: Controla la creación, ejecución y terminación de los procesos en el sistema.
4. Sistema de archivos: Organiza y gestiona el almacenamiento de datos en dispositivos de almacenamiento.
5. Interfaz de usuario: Proporciona una forma para que los usuarios interactúen con el sistema operativo, ya sea a través de una interfaz gráfica (GUI) o una línea de comandos (CLI).
6. Controladores de dispositivos: Permiten la comunicación entre el sistema operativo y los dispositivos de hardware.
7. Gestor de arranque: Maneja el proceso de inicio del sistema operativo cuando se enciende la computadora.
8. Servicios y utilidades del sistema: Proveen funciones adicionales como seguridad, redes, y herramientas de administración del sistema.

**D-Que es una llama al sistema (system call)? Como es posible implementarlas?**
Una llamada al sistema (system call) es una interfaz que permite a los programas de usuario solicitar servicios específicos del sistema operativo. Estas llamadas permiten a los programas interactuar con el hardware y realizar operaciones que requieren privilegios elevados, como la gestión de archivos, la comunicación entre procesos, y la asignación de memoria.
Las llamadas al sistema se implementan mediante una interrupción o una instrucción especial que cambia el modo de ejecución del procesador de modo usuario a modo kernel. 

**E-Defina y diferencie programa y proceso.**
Un programa es un conjunto de instrucciones escritas en un lenguaje de programación que realiza una tarea específica cuando se ejecuta. Es un archivo estático almacenado en el disco, como un ejecutable o un script.
Un proceso, por otro lado, es una instancia en ejecución de un programa. Incluye el estado del programa, la memoria asignada, los recursos del sistema y la información de control necesaria para su ejecución. Un proceso es dinámico y puede tener múltiples estados (ejecución, espera, terminado, etc.) durante su ciclo de vida.

**F-Cual es la informacion minima que el kernel debe tener sobre un proceso? En que escritura de datos asociada almacena dicha informacion?**
La información mínima que el kernel debe tener sobre un proceso incluye:
1. Identificador del proceso (PID): Un número único que identifica al proceso.
2. Estado del proceso: Indica si el proceso está en ejecución, esperando, detenido, etc.
3. Contador de programa (PC): La dirección de la próxima instrucción a ejecutar.
4. Registros de CPU: El contenido de los registros del procesador cuando el proceso está en espera.
5. Información de memoria: Detalles sobre la memoria asignada al proceso, como el espacio de direcciones.
6. Información de archivos abiertos: Una lista de archivos que el proceso tiene abiertos. 
7. Información de prioridad y planificación: Datos utilizados por el planificador del sistema operativo para gestionar la ejecución del proceso.

**G-Que objetivos persiguen los algoritmos de planificacion (scheduling)?**
Los algoritmos de planificación (scheduling) persiguen varios objetivos clave:
1. Maximizar el uso de la CPU: Asegurar que la CPU esté ocupada el mayor tiempo posible.
2. Minimizar el tiempo de respuesta: Reducir el tiempo que tarda un proceso en comenzar a ejecutarse después de ser solicitado.
3. Maximizar el rendimiento: Aumentar el número de procesos completados en un período de tiempo.
4. Garantizar la equidad: Asegurar que todos los procesos reciban una cantidad justa de tiempo de CPU.
5. Minimizar el tiempo de espera: Reducir el tiempo que los procesos pasan en la cola de espera antes de ser ejecutados.
6. Soportar diferentes tipos de cargas de trabajo: Adaptarse a las necesidades de procesos interactivos y por lotes.

**H-Que significa que un algoritmo de scheduling sea apropiativo o no apropiativo?**
Un algoritmo de scheduling es apropiativo (preemptive) si permite que el sistema operativo interrumpa un proceso en ejecución para asignar la CPU a otro proceso, generalmente basado en prioridades o tiempos de espera. Esto es útil para garantizar que los procesos de alta prioridad o los procesos interactivos reciban atención rápida.
Un algoritmo de scheduling no apropiativo (non-preemptive) no permite la interrupción de un proceso en ejecución hasta que este termine o entre en un estado de espera. En este caso, una vez que un proceso comienza a ejecutarse, retiene el control de la CPU hasta que finaliza su tarea o cede voluntariamente el control. Este enfoque puede ser más simple de implementar pero puede llevar a tiempos de espera más largos para otros procesos.

**I-Que tareas realizan los siguientes modulos de planificacion?**
- **Short Term Scheduler:** Se encarga de seleccionar qué proceso en la cola de listos debe ser asignado a la CPU para su ejecución inmediata. Su objetivo es maximizar el uso de la CPU y minimizar el tiempo de respuesta.
- **Long Term Scheduler:** Controla la admisión de nuevos procesos al sistema, decidiendo cuándo y cuántos procesos deben ser cargados en la memoria para su ejecución. Su objetivo es mantener un equilibrio entre la carga del sistema y la disponibilidad de recursos.
- **Medium Term Scheduler:** Gestiona la suspensión y reanudación de procesos en memoria, moviéndolos entre la memoria principal y el almacenamiento secundario (swap). Su objetivo es optimizar el uso de la memoria y mejorar la eficiencia del sistema al liberar espacio para procesos activos.

**J-Que tareas realiza el dispatcher? y el loader?**
- **Dispatcher:**
El dispatcher es responsable de la transición del control de la CPU entre procesos. Sus tareas principales incluyen:
1. Cambiar el contexto del proceso: Guardar el estado del proceso actual (registros, contador de programa, etc.) y cargar el estado del proceso siguiente que va a ejecutarse.
2. Transferir el control de la CPU: Iniciar la ejecución del proceso seleccionado por el planificador.
3. Manejar las interrupciones: Asegurar que las interrupciones del sistema se gestionen adecuadamente durante el cambio de contexto.
4. Minimizar el tiempo de cambio de contexto: Hacer que el proceso de cambio de contexto sea lo más rápido posible para reducir la sobrecarga del sistema.

- **Loader:**
El loader es responsable de cargar los programas en la memoria para su ejecución. Sus tareas principales incluyen:
1. Cargar el código del programa: Leer el código del programa desde el almacenamiento secundario y cargarlo en la memoria principal.
2. Preparar el entorno de ejecución: Configurar el espacio de direcciones del proceso, incluyendo la asignación de memoria para la pila, el heap y las variables globales.
3. Transferir el control al programa: Iniciar la ejecución del programa cargado, transfiriendo el control a su punto de entrada.
4. Manejar la carga de bibliotecas compartidas: Cargar y vincular dinámicamente las bibliotecas compartidas necesarias para la ejecución del programa.

Donde se encuentra el dispatcher y el loader en la estructura de un sistema operativo?
El dispatcher y el loader se encuentran en el núcleo (kernel) del sistema operativo. El dispatcher es una parte integral del planificador de procesos dentro del kernel, mientras que el loader también forma parte del kernel, ya que maneja la carga de programas en memoria y la preparación del entorno de ejecución. Ambos componentes trabajan juntos para gestionar la ejecución de procesos en el sistema operativo. 

Se ejecutan cuando el scheduler decide que un proceso debe ser ejecutado (dispatcher) o cuando un nuevo programa debe ser cargado en memoria (loader).

**K-Que significa que un proceso sea "CPU Bound" o "I/O Bound"?**
Un proceso "CPU Bound" es aquel que pasa la mayor parte de su tiempo utilizando la CPU para realizar cálculos intensivos. Estos procesos requieren mucha potencia de procesamiento y tienden a tener largos períodos de ejecución sin interrupciones para operaciones de entrada/salida. Ejemplos típicos incluyen programas de simulación, cálculos matemáticos complejos y procesamiento de datos.

Un proceso "I/O Bound", por otro lado, es aquel que pasa la mayor parte de su tiempo esperando operaciones de entrada/salida, como leer o escribir en discos, comunicarse a través de redes o interactuar con dispositivos periféricos. Estos procesos tienden a tener períodos cortos de uso de la CPU seguidos de largos tiempos de espera para completar las operaciones de I/O. Ejemplos típicos incluyen servidores web, aplicaciones de bases de datos y programas que manejan grandes volúmenes de datos.

**L-Cuales son los estados posibles por los que puede atravesar un proceso? Que represnta que un proceso se encuentre en los estados enumerados? Utilizando un diagrama explique las transciciones entre los estados:**
Los estados posibles por los que puede atravesar un proceso son:
1. Nuevo (New): El proceso está siendo creado.
2. Listo (Ready): El proceso está preparado para ejecutarse y espera a ser asignado a la CPU.
3. En ejecución (Running): El proceso está actualmente utilizando la CPU para ejecutar sus instrucciones.
4. Esperando (Waiting/Blocked): El proceso está esperando por un evento externo, como la finalización de una operación de I/O.
5. Terminado (Terminated): El proceso ha completado su ejecución y está siendo eliminado del sistema.
Las transiciones entre estos estados son las siguientes:
- De Nuevo a Listo: Cuando el proceso ha sido creado y está listo para ser ejecutado.
- De Listo a En ejecución: Cuando el planificador asigna la CPU al proceso.
- De En ejecución a Esperando: Cuando el proceso necesita esperar por un evento externo, como una operación de I/O.
- De Esperando a Listo: Cuando el evento por el que el proceso estaba esperando se ha completado.
- De En ejecución a Terminado: Cuando el proceso ha completado su tarea y finaliza su ejecución.
```plaintext
        +-------+
        | Nuevo |
        +-------+
            |
            v
        +-------+
        | Listo |
        +-------+
            |
            v
        +-----------+
        | En ejec.  |
        +-----------+
          |      |
          |      v
          |   +---------+
          |   | Espera. |
          |   +---------+
          |      |
          |      v
          |   +-------+
          |   | Listo |
          |   +-------+
          |
          v
      +-----------+
      | Terminado |
      +-----------+
```

**M-Cuales de los schedules mencionados anteriormente se encargan de las transiciones entre los estados de un proceso?**
El Short Term Scheduler (Planificador a corto plazo) es el encargado de gestionar las transiciones entre los estados de un proceso, específicamente las transiciones entre los estados de "Listo" y "En ejecución". Este planificador selecciona qué proceso en la cola de listos debe ser asignado a la CPU para su ejecución inmediata.

**N-Defina tiempo de retorno (TR), y tiempo de espera (TE) de un proceso. Como se calculan?**
El tiempo de retorno (TR) de un proceso es el tiempo total que transcurre desde que el proceso es creado hasta que finaliza su ejecución. Se calcula como la suma del tiempo de espera (TE) y el tiempo de ejecución (también conocido como tiempo de servicio o tiempo de CPU). La fórmula para calcular el tiempo de retorno es:
TR = TE + Tiempo de ejecución

El tiempo de espera (TE) de un proceso es el tiempo total que un proceso pasa en la cola de listos esperando a ser asignado a la CPU para su ejecución. Se calcula sumando todos los períodos en los que el proceso está en estado de "Listo" antes de ser ejecutado. La fórmula para calcular el tiempo de espera es:
TE = TR - Tiempo de ejecución

**O-Defina tiempo promedio de retorno (TRP) y tiempo promedio de espera (TPE). Como se calculan?**
El tiempo promedio de retorno (TRP) es el promedio del tiempo de retorno (TR) de todos los procesos en un sistema. Se calcula sumando los tiempos de retorno de todos los procesos y dividiendo por el número total de procesos. La fórmula para calcular el tiempo promedio de retorno es:
TRP = (Σ TRi) / N
donde TRi es el tiempo de retorno del proceso i y N es el número total de procesos.

El tiempo promedio de espera (TPE) es el promedio del tiempo de espera (TE) de todos los procesos en un sistema. Se calcula sumando los tiempos de espera de todos los procesos y dividiendo por el número total de procesos. La fórmula para calcular el tiempo promedio de espera es:
TPE = (Σ TEi) / N
donde TEi es el tiempo de espera del proceso i y N es el número total de procesos.

**P-Defina tiempo de respuesta**
El tiempo de respuesta  de un proceso es el tiempo que transcurre desde que un proceso hace una solicitud hasta que recibe la primera respuesta o comienza a ejecutarse. En el contexto de sistemas interactivos, el tiempo de respuesta es crucial, ya que afecta la percepción del usuario sobre la rapidez y eficiencia del sistema. Se calcula como el tiempo desde que el proceso entra en el estado de "Listo" hasta que comienza a ejecutarse por primera vez. La fórmula para calcular el tiempo de respuesta es:
TR = Tiempo de inicio de ejecución - Tiempo de solicitud

# 2 
**Algoritmos de Planificacion**

**FCFS (First Come First Served)**
El algoritmo FCFS asigna la CPU al proceso que llega primero a la cola de listos. Es un algoritmo no apropiativo, lo que significa que una vez que un proceso comienza a ejecutarse, no puede ser interrumpido hasta que termine su ejecución. Este enfoque es simple de implementar y entender, pero puede llevar a tiempos de espera largos para procesos que llegan después de procesos largos (efecto convoy).

**SJF (Shortest Job First)**
El algoritmo SJF asigna la CPU al proceso con el tiempo de CPU más corto entre los procesos en la cola de listos. Puede ser apropiativo o no apropiativo. En su versión no apropiativa, una vez que un proceso comienza a ejecutarse, no puede ser interrumpido. En su versión apropiativa (también conocido como SRTF - Shortest Remaining Time First), un proceso en ejecución puede ser interrumpido si llega un nuevo proceso con un tiempo de CPU más corto. Este algoritmo minimiza el tiempo promedio de espera, pero puede llevar a la inanición de procesos largos si llegan continuamente procesos cortos.

**Round Robin (RR)**
El algoritmo Round Robin asigna la CPU a cada proceso en la cola de listos por un período de tiempo fijo, conocido como quantum. Es un algoritmo apropiativo, ya que un proceso puede ser interrumpido cuando su quantum expira, y la CPU se asigna al siguiente proceso en la cola. Este enfoque es justo y equitativo, ya que todos los procesos reciben una cantidad igual de tiempo de CPU, pero puede llevar a un mayor tiempo de espera si el quantum es demasiado pequeño o demasiado grande.

**Priority Scheduling (Prioridades)**
El algoritmo de planificación por prioridades asigna la CPU al proceso con la prioridad más alta en la cola de listos. Puede ser apropiativo o no apropiativo. En su versión no apropiativa, una vez que un proceso comienza a ejecutarse, no puede ser interrumpido. En su versión apropiativa, un proceso en ejecución puede ser interrumpido si llega un nuevo proceso con una prioridad más alta. Este algoritmo permite la diferenciación entre procesos importantes y menos importantes, pero puede llevar a la inanición de procesos de baja prioridad si llegan continuamente procesos de alta prioridad.

**Cual es el mas adecuado segun los tipos de procesos y/o SO?**
- **FCFS** es adecuado para sistemas donde la carga de trabajo es ligera y los procesos tienen tiempos de ejecución similares. Es simple y fácil de implementar, pero no es ideal para sistemas con alta variabilidad en los tiempos de ejecución de los procesos.

- **SJF** es ideal para sistemas donde los tiempos de ejecución de los procesos son conocidos de antemano y varían significativamente. Es eficiente en términos de tiempo promedio de espera, pero puede no ser práctico en sistemas donde los tiempos de ejecución son impredecibles.

- **RR** es adecuado para sistemas interactivos donde se requiere una respuesta rápida a las solicitudes del usuario. Proporciona un buen equilibrio entre equidad y eficiencia, pero puede no ser ideal para procesos de larga duración que necesitan más tiempo de CPU.

- **Prioridades** es útil en sistemas donde algunos procesos son más importantes que otros. Permite que los procesos críticos obtengan más recursos, pero puede llevar a la inanición de procesos de baja prioridad si no se gestionan adecuadamente.

