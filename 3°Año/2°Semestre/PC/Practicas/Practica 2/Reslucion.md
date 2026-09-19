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

4.  Suponga  que  existe  una  BD  que  puede  ser  accedida  por  6  usuarios  como  máximo  al 
mismo  tiempo.  Además,  los  usuarios  se  clasifican  como  usuarios  de  prioridad  alta  y 
usuarios de prioridad baja. Por último, la BD tiene la siguiente restricción: 
• no puede haber más de 4 usuarios con prioridad alta al mismo tiempo usando la BD. 
• no puede haber más de 5 usuarios con prioridad baja al mismo tiempo usando la BD. 
Indique si la solución presentada es la más adecuada. Justifique la respuesta. 