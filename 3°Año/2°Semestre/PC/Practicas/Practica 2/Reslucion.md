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
b. Implemente una solución que modele el acceso de las personas a un detector (es decir, 
si el detector está libre la persona lo puede utilizar; en caso contrario, debe esperar).  
c. Modifique su solución para el caso que haya tres detectores.  
d. Modifique la solución anterior para el caso en que cada persona pueda pasar más de 
una vez, siendo aleatoria esa cantidad de veces.

a. Análisis del problema:

