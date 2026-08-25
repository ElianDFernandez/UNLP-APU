## Notas de cursada
No se tomara asistencia, ni en la practica ni en la teoria.
Las practicas son solo de consultas.
Memoria compartida / Memoria distribuida (Se aprueba por tema).

# Introduccion programacion concurrente

### Concurrencia

- **¿Que es?** Es la capacidad de ejecutar multiples actividades en paralelo o simultaneamente.
- Permite a distintos objetos actuar al mismo tiempo 
- Factor relevante para el diseño de hardwate, sistemas operativos, multiprocesadores, computacion distribuida, programacion y diseño.

Puede existir la concurrencia sin paralelismo, pero no puede existir el paralelismo sin concurrencia. 
Un ejemplo de concurrencia sin paralelismo es un sistema operativo que ejecuta multiples procesos en un solo procesador, alternando entre ellos. Por otro lado, el paralelismo implica la ejecución simultánea de múltiples procesos en múltiples procesadores.

La concurrencia es un concepto de software no restringido a la arquitectura de hardware ni a un numero determinado de procesadores.

### Programa concurrente

Un programa concurrente especifica dos o mas "programas secuenciales" que pueden ejecutarse concurrentemente en el tiempo como tareas o procesos.

p |----xxx------------xxx-
o |-xxx------------xxx----
r |-------xxx-------------

Un programa concurrente puede tener N procesos habilitados para ejecutarse concurrentemente y un sistema concurrente puede disponer de M procesadores cada uno de los cuales puede ejecutar uno o más procesos.

