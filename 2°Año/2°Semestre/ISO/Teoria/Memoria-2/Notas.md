# Fallo de paginas (page fault)
Ocurre cuando el proceso intentar usar una direccion que esta en una pagina que no se encuentra en la memoria principal. 

# Algoritmos de reemplazo de paginas

- **OPTIMO:** Es solo teorico. Reemplaza la pagina que no sera referenciada en un futuro cercano.
- **FIFO (First In First Out):** Reemplaza la pagina que lleva mas tiempo en memoria.
- **LRU (Least Recently Used):** Reemplaza la pagina que no se uso por el mayor tiempo en el pasado.
- **Segunda oportunidad:** Similar a FIFO, pero si la pagina que va a ser reemplazada tiene el bit de referencia en 1, se le da una segunda oportunidad y se le pone el bit en 0. Se mueve al final de la cola y se busca la siguiente pagina.
- **NRU (Not Recently Used):** Utiliza bits R y M para clasificar las paginas en 4 categorias:
    1. No referenciada, no modificada (R=0, M=0)
    2. Referenciada, no modificada (R=1, M=0)
    3. No referenciada, modificada (R=0, M=1)
    4. Referenciada, modificada (R=1, M=1)
    Elige una pagina al azar de la categoria mas baja disponible.


# Alcance del reemplazo

- **Global:** 
    * El fallo de pagina de un proceso puede causar el reemplazo de una pagina de otro proceso.
    * El SO no controla la tasa de page fault de cada proceso.
    * Puede tomar frames de otro proceso aumentado la cantidad de frames asignados a el.
    * Un proceso de alta prioridad podria tomar los frames de un proceso de menor prioridad.

- **Local:**
    * El fallo de pagina de un proceso solo puede causar el reemplazo de una pagina del mismo proceso.
    * No cambia la cantidad de frames asignados a un proceso.
    * El SO puede determinar cual es la tasa de page fault de cada proceso.
    * Un proceso puede tener frames asignados que no usa, y no pueden ser usados por otros procesos.