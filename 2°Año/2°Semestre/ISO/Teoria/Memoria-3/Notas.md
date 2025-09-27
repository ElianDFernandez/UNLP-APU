# Hiperpaginacion o thrashing

La **hiperpaginación** o **thrashing** es un fenómeno que ocurre en los sistemas operativos cuando la memoria virtual se utiliza de manera excesiva, lo que lleva a un rendimiento significativamente degradado del sistema. Esto sucede cuando el sistema operativo pasa más tiempo intercambiando páginas entre la memoria RAM y el almacenamiento secundario (como un disco duro o SSD) que ejecutando procesos útiles.

- Posible ciclo del trashing:
    1. El kernel monitoria el uso de la CPU.
    2. Si hay baja utilizacion -> aumenta el grado de multiprogramacion (carga mas procesos en memoria).
    3. Si el algoritmo de reemplazo es global, pueden sacarse frames a otros procesos.
    4. Un proceso necesita mas frames -> mas page faults.
    5. Por swapping de paginas y encolamiento en dispositivos, baja la utilizacion de CPU.
    6. Se vuelve al paso 1.
    
- Control del thrashing:
    * Se puede limitar el thrashing usando algoritmos de reemplazo local.
    * Con este algoritmo, si el proceso entra en thrashing no roba frames a otros procesos.
    * Además, se puede establecer un límite en el número de frames que un proceso puede usar.
    * Si un proceso alcanza su límite y necesita más frames, se le puede suspender temporalmente para liberar recursos.

# Como atacar el thrashing

## Principio de localidad (Teoria para entender la solucion)
El **principio de localidad** establece que los programas tienden a acceder a un conjunto relativamente pequeño de páginas de memoria durante un período corto de tiempo. Este comportamiento se puede dividir en dos tipos principales:

1. **Localidad temporal**: Si un programa accede a una dirección de memoria, es probable que acceda a direcciones cercanas en un futuro cercano. Esto se debe a que las instrucciones y los datos que se utilizan juntos tienden a estar ubicados cerca uno del otro en la memoria.

2. **Localidad espacial**: Los programas tienden a acceder a direcciones de memoria que están cercanas entre sí. Esto significa que si un programa accede a una página de memoria, es probable que acceda a otras páginas que están en la misma vecindad.

