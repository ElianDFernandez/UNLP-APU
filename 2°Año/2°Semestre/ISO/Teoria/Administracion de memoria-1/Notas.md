# Administracion de memoria
**El sistema operativo debe:** 
    - Llevar un registro de las partes de memoria que se estan utilizando y de aquellas que no
    - Asignar espacio en memoria principal a los proceso cuando estos la necesitan
    - Liberar espacio de memoria asiganda a proceso que han temrinado
    - Lograr que el programador se abstraiga de la alocacion de los programas
    - Brindar seguridad a los procesos para que unos no accedan a secciones privadas de otros
    - Se espera de un SO un uso eficiente de la memoria con el fin de alojar el mayor numero de procesos
    - Brindar la posibilidad de acceso compartido a determinadas secciones de la memoria
    - Garantizar la performance del sistema

# Requisitos
**Reubicacion**
- El programador no debe preocuparse por la direccion fisica en la que se cargara su programa
- Mientras un proceso se ejecuta, puede ser sacado y traido a la memoria y posibilemente, colocarlse en diferentes direcciones
- Las referenncias a la memoria se deben "traducir" segun ubicacion actual del proceso

**Proteccion**
- Los proceso No deben referenciar - acceder a direcciones de memoria que no le pertenecen
- El chequeo se debe realizar durante la ejecucion:
    * No es posible anticipar todas las referencias que un proceso puede hacer a la memoria

**Comparticion**
- Permitir que varios procesos accedan a una misma porcion de memoria
- Permite un mejor uso de la memoria RAM, evitando copias innecesarias de instrucciones

# Espacio de direcciones 
**Rango de direcciones que un proceso puede usar**
- Rango de direcciones logicas o virtuales
- El tamaño del espacio de direcciones depende de la arquitectura del procesador
    * 32 bits -> 2^32 = 4GB
    * 64 bits -> 2^64 = 16EB
- Es independiente de la ubicacion "real" del proceso en memoria fisica

**Direcciones logicas o virtuales**
**Logicas** 
- Referencia a una localidad de memoria independiente de la asignacion actual de los datos en la memoria. Es decir, es la direccion que utiliza el programa
- Represnta una direccion en el "espacio de direcciones del proceso"

**Fisicas**
- Referencia a una localidad de memoria real, es decir, la direccion en la memoria RAM
- Representa una direccion en la memoria real del sistema

**Conversion de direcciones**
- Una forma simple de hacer esto es utilizando registros auxiliares en el CPU
    * Registro base: contiene el valor de la direccion mas baja asignada al proceso en memoria fisica
    * Registro limite: contiene el tamaño del espacio de direcciones asignado al proceso
- Cuando el proceso genera una direccion logica, se compara con el registro limite para verificar que no exceda el espacio asignado
- Si es valida, se suma al valor del registro base para obtener la direccion fisica
Todo esto lo realiza el hardware del CPU, el kernel no interviene en este proceso. El registro limite y base son cargados por el kernel cuando el proceso es cargado en memoria es decir cuando realiza el context switch

**Modelado de espacio de direcciones**
Utilizando una lista: 
Cada nodo tiene: 
- Direccion inicial
- Direccion final
- Parametros de proteccion (lectura, escritura, ejecucion)
- Espacio de direccion de datos inicial
- Espacio de direccion de datos final
- Path del archivo (si es un archivo mapeado en memoria)

Utilizando una tabla:
**Heap:** Datos dinamicos
- Direccion
- Proteccion
- Tamaño
**Imagen:** Codigo y datos estaticos
- Direccion
- Tamaño
- Proteccion
**Managed Heap:** Datos dinamicos manejados por un recolector de basura
**Mapped Files:** Archivos mapeados en memoria
**Page Table:** Tabla de paginas

# Memory Management Unit (MMU)
Es un componente de hardware que se encarga de la traduccion de direcciones logicas a fisicas
La traduccion de una direccion Logica a fisica es la siguiente: 
    * Direccion logica + Registro Base = Direccion Fisica
    * Si Direccion logica > Registro Limite -> Excepcion de violacion de memoria
La MMU se encarga de realizar esta operacion en cada acceso a memoria, por lo que debe ser muy rapida
El SO se encarga de cargar los valores de los registros base y limite cuando se realiza un context switch
El SO debe mantener una tabla de procesos en memoria, donde se almacena el valor de los registros base y limite de cada proceso. 
Se utiliza la MMU para liberar al SO de la tarea de traduccion de direcciones, ya que esto debe ser muy rapido y el SO no puede darse el lujo de perder tiempo en esta tarea

```
CPU -> MMU -> RAM
```

# Mecanismos de asignacion de memoria
**Particion fija**
- La memoria se divide en particiones de tamaño fijo
- Cada particion puede contener un solo proceso
- Cada proceso se coloda de acuerdo a algun criterio(First Fit, Best Fit, Worst Fit, Next Fit) en alguna particion

**Particion dinamica**
- Las particiones varian de tamaño y numero 
- Cada particion puede contener un solo proceso
- Cada particion se genera en forma dinamica del tamaño justo que necesita el proceso

**Fragmentacion**
Al utilizar particiones de tamaño fijo, es posible que un proceso no utilice todo el espacio asignado, generando fragmentacion interna
Al utilizar particiones de tamaño variable, es posible que queden espacios libres entre los procesos, generando fragmentacion externa

**Problemas del esquema**


**Soluciones**
# Segmentacion
- Un programa es una coleccion de segmentos logicos
- Se necesita una tabla de segmentos por proceso
- El kernel es el encargado de mantener la tabla de segmentos
- Las direcciones logicas estan compuestas por un numero de segmento y un offset dentro del segmento
- La MMU se encarga de traducir la direccion logica a fisica utilizando la tabla de segmentos
- segment-table base register (STBR): contiene la direccion fisica donde comienza la tabla de segmentos del proceso en memoria
- segment-table length register (STLR): contiene el numero de segmentos del proceso
- Cada proceso tiene su propia tabla de segmentos

# Paginacion
Esto es por procesos individuales:
- La memoria se divide en bloques de tamaño fijo llamados marcos (frames)
- La memoria logica se divide en bloques del mismo tamaño llamados paginas (pages)
- El SO debe mantener una tabla de paginas por proceso, donde cada entrada contiene el marco en la que se coloca la pagina
- La direccion logica se interpreta como:
    - Un numero de pagina y un desplazamiento dentro de la misma