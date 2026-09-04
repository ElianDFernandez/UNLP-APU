# Herramientas para la concurrencia
 
**Memoria Compartida**
    - Variables compartidas

## Locks y Barreras
**Problema de la sección crítica:** implementacion de acciones atomicas en software(Loks).

**Barreras:** punto de sincronizacion que todos los procesos debe alcanzar para que cualquier proceso puedea continuar.

Tecnia **Busy waiting** un proceso espera activamente a que una condicion se cumpla, consumiendo CPU. (Error grave de parcial).

## Seccion critica 
seccion de codigo que no puede ser accesida por mas de un proceso a la vez.
Debe cumplir con 4 propiedades:
1. Exclusión mutua: solo un proceso puede estar en la sección crítica a la vez
2. Ausencia de deadlock: si 2 o mas procesos tratan de entar a sus SC, al menos uno tendra exito.
3. Ausencia de demora innecesaria: si un proceso trata de entrar a su SC y los otros estan en sus SNC o terminaron, el primero no esta impedido de entrar a su SC.
4. Eventual entrada: si un proceso quiere entrar a la sección crítica, eventualmente lo hará.

## Solucion de gano Grueso 
Usamos el <await condicion; seccion critica> para que un proceso espere a que se cumpla una condicion antes de entrar a su sección crítica.

## Solucion de grano fino
Usar instrucciones como Test & Set, Swap, Fetch & Add, Compare & Swap, Load Linked/Store Conditional para implementar locks de manera atomica.

Test & set Funciona: 

```
bool TS(bool ok);
{
    <bool inicial = ok;
    ok = false;
    return inicial;>
}
```

# Algoritmos de acceso a la sección crítica

Algoritmo Tie-Breaker (2 procesos): protocolo de SC que requiere scheduling sólo
débilmente fair y no usa instrucciones especiales más complejo.
Usa una variable por cada proceso para indicar que el proceso comenzó a ejecutar su protocolo de entrada a la sección crítica, y una variable adicional para romper empates, indicando qué proceso fue el último en comenzar dicha entrada esta última variable es compartida y de acceso protegido.
Demora (quita prioridad) al último en comenzar su entry protocol

> Ineficiente: un proceso puede estar esperando a que otro termine su sección crítica, aunque el otro no esté interesado en entrar a la sección crítica.

# Algoritmo Ticket: se reparten números y se espera a que sea el turno.
Los procesos toman un número mayor que el de cualquier otro que espera ser atendido;
luego esperan hasta que todos los procesos con número más chico han sido atendidos.

process SC [i: 1..n] 
{ while (true)
     {   < turno[i] = numero; numero = numero +1; >
         < await turno[i] == proximo; >
         sección crítica;
         < proximo = proximo + 1; >
         sección no crítica; 
     } 
}    

# Algoritmo Bakery: 
Cada proceso que trata de ingresar recorre los numero de los demas y se auto asigna uno mayor. Luego esperaa que su numero sea el menor de los que esperan.

# Barreras

**Sincronizacion barreras** Una barrera es un punto de demora a la que deben llegar todos lo procesos antes de permitirles pasar y continuar su ejecucion.
Dependiendo de la apliacion las barreras pueden necesitar reutilizarse msa de una vez (por ejemplo en algoritmos iterativos).

