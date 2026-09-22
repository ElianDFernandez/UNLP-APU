# Explicacion Practica 2 - Semaforos

- Declaracion de variables para semaforos:  
```c
sem s; # NO!!!. Si o si un semaforo se debe inicializar.
sem mutex = 1; # Inicializacion de semaforo
sem espera[N] = 0; # Inicializacion de semaforos, para casos donde se necesita mas de un semaforo, se puede declarar un arreglo de semaforos.
```

- Operaciones de los semaforos:  
```c
P(s); # Decrementa el semaforo s, si s es 0, el proceso se bloquea hasta que s sea mayor a 0. → <await (s > 0) s = s-1; >
V(s); # Incrementa el semaforo s. → s = s+1; → <s = s+1; >

# Ambas operaciones son atómicas, es decir, no pueden ser interrumpidas por otro proceso.
```

> CONSIDERACIONES PARA RESOLVER LOS EJERCICIOS: 
 
> • Los semáforos deben estar declarados en todos los ejercicios. 
> • Los semáforos deben estar inicializados en todos los ejercicios. 
> • No se puede utilizar ninguna sentencia para setear o ver el valor de un semáforo. 
> • Debe evitarse hacer busy waiting en todos los ejercicios. 
> • En todos los ejercicios el tiempo debe representarse con la función delay

# Ejercicio 1

1.  Existen N personas que deben ser chequeadas por un detector de metales antes de poder ingresar al avión.
   
a. Analice el problema y defina qué procesos, recursos y semáforos/sincronizaciones serán necesarios/convenientes para resolverlo. 

b. Implemente una solución que modele el acceso de las personas a un detector (es decir, si el detector está libre la persona lo puede utilizar; en caso contrario, debe esperar).  

c. Modifique su solución para el caso que haya tres detectores.  

d. Modifique la solución anterior para el caso en que cada persona pueda pasar más de una vez, siendo aleatoria esa cantidad de veces.

a. Proceso persona, solo una persona puede pasar por el detector, debería entrar solo uno por el detector y cuando sale , el siguiente puede entrar.

b. 
```
sem detector = 1;
Process Persona [id: 0..N] {
    P(detector);
    // Persona pasa por el detector
    V(detector);
}
```

c. Si hay 3 detectores, se puede usar un semáforo con valor inicial 3, de esta manera, hasta 3 personas pueden pasar por los detectores al mismo tiempo. 

```
sem detector = 3;
Process Persona [id: 0..N] {
    P(detector);
    // Persona pasa por el detector
    V(detector);
}
```

d. Para el caso en que cada persona pueda pasar más de una vez, se puede agregar un bucle que permita a cada persona pasar por el detector un número aleatorio de veces. 

```
sem detector = 3;
process Persona [id: 0..N] {
    for i: 1..random(1,N) {
        P(detector);
        // Persona pasa por el detector
        V(detector);
    }
}
```

# Ejercicio 2

2.  Un sistema de control cuenta con 4 procesos que realizan chequeos en forma 
colaborativa. Para ello, reciben el historial de fallos del día anterior (por simplicidad, de 
tamaño  N).  De  cada  fallo,  se  conoce  su  número  de  identificación  (ID)  y  su  nivel  de 
gravedad (0=bajo, 1=intermedio, 2=alto, 3=crítico). Resuelva considerando las siguientes 
situaciones: 
a) Se debe imprimir en pantalla los ID de todos los errores críticos (no importa el 
orden). 
b) Se debe calcular la cantidad de fallos por nivel de gravedad, debiendo quedar los 
resultados en un vector global. 
c) Ídem  b)  pero  cada  proceso  debe  ocuparse  de  contar  los  fallos  de  un  nivel  de 
gravedad determinado. 

a.
```
Fallo historial[N]; // Vector global de fallos
int cantBuscar = N DIV 4;

process Proceso [id: 0..3] {
    int ini = id * cantBuscar;
    int fin = ini + cantBuscar - 1;
    for i: ini..fin {
        if (historial[i].nivel == 3) {
            print(historial[i].ID);
        }
    }
}
```

b. 
```
Fallo historial[N]; // Vector global de fallos
int cantBuscar = N DIV 4;
int contadores[4] = ([4] 0); // Vector global de contadores, cada posicion representa un nivel de gravedad (0, 1, 2, 3)
sem mutex = 1; // Semaforo para proteger el acceso a los contadores

process Proceso [id: 0..3] {
    int ini = id * cantBuscar;
    int fin = ini + cantBuscar - 1;
    for i: ini..fin {
        P(mutex);
        contadores[historial[i].nivel]++;
        V(mutex);
    }
}
```

Se debe proteger el acceso a los contadores con un semáforo para evitar condiciones de carrera.

c. 
```
Fallo historial[N]; // Vector global de fallos
int contadores[4] = ([4] 0); // Vector global de contadores, cada posicion representa un nivel

process Proceso [id: 0..3] {
    int cant = 0;
    for i: 0..N-1 {
        if (historial[i].nivel == id) {
            cant++;
        }
    }
    contadores[id] = cant; // Cada proceso escribe en su propia posición del vector de contadores
}
```

# Ejercicio 3

3. Un  sistema  operativo  mantiene  5  instancias  de  un  recurso  almacenadas  en  una  cola. 
Además, existen P procesos que necesitan usar una instancia del recurso. Para eso, deben 
sacar la instancia de la cola antes de usarla. Una vez usada, la instancia debe ser encolada 
nuevamente para su reúso.

```
int cola[5]; // Cola de instancias del recurso
sem mutex = 1; // Semaforo para proteger el acceso a la cola
sem instancias = 5; // Cantidad de instancias disponibles

Process Proceso [id: 0..P-1] {
    P(mutex);// Protege el acceso a la cola
    P(instancias); // Decrementa la cantidad de instancias disponibles
    // Sacar una instancia de la cola
    Recurso r = cola.pop();
    V(mutex); // Libera el acceso a la cola
    P(mutex);
    cola.push(r); // Encola la instancia nuevamente para su reúso
    V(mutex); // Libera el acceso a la cola
    V(instancias); // Incrementa la cantidad de instancias disponibles
}
```
# Ejercicio 4

4.  Suponga  que  existe  una  BD  que  puede  ser  accedida  por  6  usuarios  como  máximo  al 
mismo  tiempo.  Además,  los  usuarios  se  clasifican  como  usuarios  de  prioridad  alta  y 
usuarios de prioridad baja. Por último, la BD tiene la siguiente restricción: 
• no puede haber más de 4 usuarios con prioridad alta al mismo tiempo usando la BD. 
• no puede haber más de 5 usuarios con prioridad baja al mismo tiempo usando la BD. 
Indique si la solución presentada es la más adecuada. Justifique la respuesta. 

```
Var 
 total: sem := 6; 
 alta: sem := 4; 
 baja: sem := 5; 
 
Process Usuario-Alta [I:1..L]::  
   {    P (total); 
        P (alta); 
        //usa la BD 
        V(total); 
        V(alta); 
    } 
Process Usuario-Baja [I:1..K]::  
   {    P (total); 
        P (baja); 
        //usa la BD 
        V(total); 
        V(baja); 
    }
```

El problema es que P(total) se ejecuta antes de P(alta) o P(baja), esto genera un problema ya que puede bloquear la ejecucion de otros procesos que cumplen con las restriccioens y podrian acceder a la BD.

Ejemplo: si hay 5 usuario con prioridad alta y 5 prioridad baja, esperando para acceder a la BD.
Si ingresan 4 de prioridad alta y viene el 5to usuario de prioridad alta, este se bloquea en P(alta) y no puede ejecutar V(total), por lo que los 5 usuarios de prioridad baja tampoco pueden acceder a la BD, aunque cumplan con las restricciones.

La solución más adecuada sería ejecutar P(alta) o P(baja) antes de P(total), de esta manera se asegura que los procesos que cumplen con las restricciones puedan acceder a la BD sin bloquear a otros procesos que también cumplen con las restricciones. 

```
Var
    total: sem := 6; 
    alta: sem := 4; 
    baja: sem := 5;

Process Usuario-Alta [I:1..L]::
    {     P (alta); 
          P (total); 
          //usa la BD 
          V(total); 
          V(alta); 
     }

Process Usuario-Baja [I:1..K]::
    {     P (baja); 
          P (total); 
          //usa la BD 
          V(total); 
          V(baja); 
     }
```

# Ejercicio 5

5.  En  una  empresa  de  logística  de  paquetes  existe  una  sala  de  contenedores  donde  se 
preparan las entregas. Cada contenedor puede almacenar un paquete y la sala cuenta con 
capacidad para N contenedores. Resuelva considerando las siguientes situaciones: 
a) La empresa cuenta con 2 empleados:  un empleado Preparador que se ocupa de 
preparar  los  paquetes  y  dejarlos  en  los  contenedores;  un  empleado  Entregador 
que se ocupa de tomar los paquetes de los contenedores y realizar las entregas. 
Tanto el Preparador como el Entregador trabajan de a un paquete por vez. 
b) Modifique la solución a) para el caso en que haya P empleados Preparadores. 
c) Modifique la solución a) para el caso en que haya E empleados Entregadores. 
d) Modifique la solución a) para el caso en que haya P empleados Preparadores y E 
empleados Entregadores.

A.

```
// seudocodigo

// proceso empleado Preparador {
    // while (true) {
        // prepara un paquete
        // espera a que haya un contenedor disponible
        // deja el paquete en el contenedor
    //}
//}

// proceso empleado Entregador {
    // while (true) {
        // espera a que haya un paquete en un contenedor
        // toma el paquete del contenedor
        // realiza la entrega
    //}
//}
```

Entonces tengo que controlar al preparador para que no deje un paquete si no hay contenedores disponibles y al entregador para que no tome un paquete si no hay paquetes en los contenedores. Para eso, puedo usar semáforos.

```
sem contendoresDisponibles = N; // cantidad de contenedores disponibles
sem contenedoresOcupados = 0; // cantidad de contenedores ocupados
Paquete contenedores[N]; // arreglo de contenedores
int indiceLibre = 0; // indice del contenedor libre
int indiceOcupado = 0; // indice del contenedor ocupado

Process preparador {
    while (true) {
        // prepara un paquete
        P(contenedoresDisponibles); // espera a que haya un contenedor disponible
        // deja el paquete en el contenedor
        contenedores[indiceLibre] = paquete;
        indiceLibre = (indiceLibre + 1) % N; // actualiza el indice del contenedor libre
        V(contenedoresOcupados); // incrementa la cantidad de contenedores ocupados
    }
}

Visualmente: 
Contenedores: [],[],[],[],[]  (N=5)
El preparador prepara un paquete y lo deja en el contenedor 0, entonces el arreglo queda: [paquete1],[],[],[],[] y el indiceLibre pasa a 1. El entregador toma el paquete del contenedor 0, entonces el arreglo queda: [],[],[],[],[] y el indiceOcupado pasa a 1.

Process entregador {
    while (true) {
        P(contenedoresOcupados); // espera a que haya un paquete en un contenedor
        // toma el paquete del contenedor
        paquete = contenedores[indiceOcupado];
        indiceOcupado = (indiceOcupado + 1) % N; // actualiza el indice del contenedor ocupado
        V(contenedoresDisponibles); // incrementa la cantidad de contenedores disponibles
        // realiza la entrega
    }
}
```

B. Modifique la solución a) para el caso en que haya P empleados Preparadores. 


```
sem contendoresDisponibles = N; // cantidad de contenedores disponibles
sem contenedoresOcupados = 0; // cantidad de contenedores ocupados

int indiceLibre = 0; // indice del contenedor libre
int indiceOcupado = 0; // indice del contenedor ocupado

Paquete contenedores[N]; // arreglo de contenedores

sem semaforoPreparador = 1; // semaforo para proteger el acceso al indiceLibre

Process preparador [id: 0..P-1] {
    while (true) {
        // prepara un paquete
        P(contenedoresDisponibles); // espera a que haya un contenedor disponible
        P(semaforoPreparador); // protege el acceso al indiceLibre
        // deja el paquete en el contenedor
        contenedores[indiceLibre] = paquete;
        indiceLibre = (indiceLibre + 1) % N; // actualiza el indice del contenedor libre
        V(semaforoPreparador); // libera el acceso al indiceLibre
        V(contenedoresOcupados); // incrementa la cantidad de contenedores ocupados
    }
}

Process entregador {
    while (true) {
        P(contenedoresOcupados); // espera a que haya un paquete en un contenedor
        // toma el paquete del contenedor
        paquete = contenedores[indiceOcupado];
        indiceOcupado = (indiceOcupado + 1) % N; // actualiza el indice del contenedor ocupado
        V(contenedoresDisponibles); // incrementa la cantidad de contenedores disponibles
        // realiza la entrega
    }
}
```

C. Modifique la solución a) para el caso en que haya E empleados Entregadores. 

D. Modifique la solución a) para el caso en que haya P empleados Preparadores y E 
empleados Entregadores.


Ahora tenemos que proteger la variable indiceOcupado, ya que varios entregadores pueden estar intentando tomar paquetes al mismo tiempo.

```

sem contendoresDisponibles = N; // cantidad de contenedores disponibles
sem contenedoresOcupados = 0; // cantidad de contenedores ocupados

int indiceLibre = 0; // indice del contenedor libre
int indiceOcupado = 0; // indice del contenedor ocupado

Paquete contenedores[N]; // arreglo de contenedores

sem semaforoPreparador = 1; // semaforo para proteger el acceso al indiceLibre
sem semaforoEntregador = 1; // semaforo para proteger el acceso al indiceOcupado

Process preparador [id: 0..P-1] {
    while (true) {
        // prepara un paquete
        P(contenedoresDisponibles); // espera a que haya un contenedor disponible
        P(semaforoPreparador); // protege el acceso al indiceLibre
        // deja el paquete en el contenedor
        contenedores[indiceLibre] = paquete;
        indiceLibre = (indiceLibre + 1) % N; // actualiza el indice del contenedor libre
        V(semaforoPreparador); // libera el acceso al indiceLibre
        V(contenedoresOcupados); // incrementa la cantidad de contenedores ocupados
    }
}

Process entregador [id: 0..E-1] {
    while (true) {
        P(contenedoresOcupados); // espera a que haya un paquete en un contenedor
        P(semaforoEntregador); // protege el acceso al indiceOcupado
        // toma el paquete del contenedor
        paquete = contenedores[indiceOcupado];
        indiceOcupado = (indiceOcupado + 1) % N; // actualiza el indice del contenedor ocupado
        V(semaforoEntregador); // libera el acceso al indiceOcupado
        V(contenedoresDisponibles); // incrementa la cantidad de contenedores disponibles
        // realiza la entrega
    }
}
```
# Ejercicio 6

6.  Existen N personas que deben imprimir un trabajo cada una. Resolver cada ítem usando 
semáforos: 
a) Implemente una solución suponiendo que existe una única impresora compartida por 
todas las personas, y las mismas la deben usar de a una persona a la vez, sin importar 
el orden. Existe una función Imprimir(documento) llamada por la persona que simula el 
uso de la impresora. Sólo se deben usar los procesos que representan a las Personas. 
b) Modifique la solución de (a) para el caso en que se deba respetar el orden de llegada. 
c) Modifique  la  solución  de  (a)  para  el  caso  en  que  se  deba  respetar  estrictamente  el 
orden dado por el identificador del proceso (la persona X no puede usar la impresora 
hasta que no haya terminado de usarla la persona X-1). 
d) Modifique la solución de (b) para el caso en que además hay un proceso Coordinador 
que le indica a cada persona que es su turno de usar la impresora. 
e) Modificar la solución (d) para el caso en que sean 5 impresoras. El coordinador le 
indica a la persona cuándo puede usar una impresora, y cual debe usar.

A.

```
sem impresora = 1; // semaforo para controlar el acceso a la impresora

process Persona [id: 0..N-1] {
    P(impresora); // espera a que la impresora esté disponible
    Imprimir(documento); // usa la impresora
    V(impresora); // libera la impresora
}
```

B. 

Cola de espera para respetar el orden de llegada. Se puede usar un semáforo para cada persona, inicializado en 0, y un semáforo para controlar el acceso a la cola.

Metodo pass the baton: cada persona espera a que sea su turno para usar la impresora, y cuando termina, le pasa el turno a la siguiente persona en la cola.

```
Cola c; // cola de espera
sem mutex = 1; // semaforo para controlar el acceso a la cola
sem espera[N] = 0; // semaforos para cada persona, inicializados en 0
Boolean libre = false; // indica si es el turno de la persona

Process Persona [id: 0..N-1] {
    P(mutex); // protege el acceso a la cola
    if (libre) {
        libre = false; // indica que la persona está usando la impresora
        V(mutex); // libera el acceso a la cola
    } else {
        c.push(id); // encola a la persona
        V(mutex); // libera el acceso a la cola
        P(espera[id]); // espera a que sea su turno
    }
    Imprimir(documento); // usa la impresora
    P(mutex); // protege el acceso a la cola
    if (c.isEmpty()) {
        libre = true; // indica que la impresora está libre
    } else {
        next = c.pop(); // obtiene el siguiente en la cola
        V(espera[next]); // le pasa el turno a la siguiente persona
    }
    V(mutex); // libera el acceso a la cola
}
```

C. 

Modifique  la  solución  de  (a)  para  el  caso  en  que  se  deba  respetar  estrictamente  el 
orden dado por el identificador del proceso (la persona X no puede usar la impresora hasta que no haya terminado de usarla la persona X-1).

```
colaPrioridad c; // cola de prioridad para respetar el orden de los identificadores
sem mutex = 1; // semaforo para controlar el acceso a la cola
sem espera[N] = 0; // semaforos para cada persona, inicializados en 0
Boolean libre = false; // indica si es el turno de la persona

Process Persona [id: 0..N-1] {
    P(mutex); // protege el acceso a la cola
    if (libre) {
        libre = false; // indica que la persona está usando la impresora
        V(mutex); // libera el acceso a la cola
    } else {
        c.push(id); // encola a la persona
        V(mutex); // libera el acceso a la cola
        P(espera[id]); // espera a que sea su turno
    }
    Imprimir(documento); // usa la impresora
    P(mutex); // protege el acceso a la cola
    if (c.isEmpty()) {
        libre = true; // indica que la impresora está libre
    } else {
        next = c.pop(); // obtiene el siguiente en la cola
        V(espera[next]); // le pasa el turno a la siguiente persona
    }
    V(mutex); // libera el acceso a la cola
}
```


D. 

Modifique la solución de (b) para el caso en que además hay un proceso Coordinador que le indica a cada persona que es su turno de usar la impresora

```
Cola c; // cola de espera
sem mutex = 1; // semaforo para controlar el acceso a la cola
sem llegada = 0; // semaforo para indicar que una persona ha llegado
sem listo = 0; // semaforo para indicar que la persona está lista para usar la impresora
sem turno[N] = 0; // semaforos para cada persona, inicializados en 0

Process Persona [id: 0..N-1] {
    P(mutex); // protege el acceso a la cola
    c.push(id); // encola a la persona
    V(mutex); // libera el acceso a la cola
    V(llegada); // indica que una persona ha llegado
    P(turno[id]); // espera a que sea su turno
    Imprimir(documento); // usa la impresora
    V(listo); // indica que la persona ha terminado de usar la impresora
}

Process Coordinador {
    int id;
    for i: 0..N-1 {
        P(llegada); // espera a que una persona haya llegado
        P(mutex); // protege el acceso a la cola
        id = c.pop(); // obtiene el siguiente en la cola
        V(mutex); // libera el acceso a la cola
        V(turno[id]); // le pasa el turno a la persona
        P(listo); // espera a que la persona haya terminado de usar la impresora
    }
}
```