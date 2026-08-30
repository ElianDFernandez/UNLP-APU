Programcion concurrente

1.A. En algun caso el valor de x al terminar el programa es de 56 
B. En algun caso el valor de x al terminar el programa es de 22
C. En algun caso el valor de x al terminar el programa es de 23


p1: if(x=0) then 
            y:= 4*2;
            x:= y+2;
    
p2: if(x>0) then 
        x:= x+1;

p3: x:= (x*3) + (x*2);

Resolucion:

p1:	1- Load y, reg1
    2- Add 2, reg1
    3- Store reg1, x	

p2:	4- Load x,reg2
	5- Add 1, reg2
	6- Store reg2, x

p3:	7- Load x, reg3
	8- Load x, reg4
	9- Multi  reg3, 3, reg 3
    10- Multi reg4, 2, reg4
    11- Add reg3, reg4, reg5
    12- Add 1, reg5
    13- Store x, reg5 


a) V. Es posible que x termine con el valor 56 si se ejecuta el P1, P2 y luego el P3
b) V. Es posible que x termine con el valor 22 si el orden de las instrucciones es 1- 2- 7- 3- 8- 9- 10- 11- 12- 13 - 4- 5- 6
c) V. Es posible que x termine con el valor 23 si el orden de las instrucciones es 1-2-7-3-4-5-6-8-9-10-11-12-13


Te detallo paso a paso cómo se llega a cada solución.

## Descomposición en grano fino (recordatorio)

Asumiendo que `y:= 4*2 = 8` ya fue calculado y almacenado:

| # | Instrucción | Proceso |
|---|-------------|---------|
| 1 | Load y, reg1 → reg1 = 8 | p1 |
| 2 | Add 2, reg1 → reg1 = 10 | p1 |
| 3 | Store reg1, x → **x = 10** | p1 |
| 4 | Load x, reg2 | p2 |
| 5 | Add 1, reg2 | p2 |
| 6 | Store reg2, x → **x = x+1** | p2 |
| 7 | Load x, reg3 | p3 |
| 8 | Load x, reg4 | p3 |
| 9 | Multi reg3, 3, reg3 → reg3 = x\*3 | p3 |
| 10 | Multi reg4, 2, reg4 → reg4 = x\*2 | p3 |
| 11 | Add reg3, reg4, reg5 → reg5 = x\*3 + x\*2 | p3 |
| 12 | Add 1, reg5 → reg5 = reg5 + 1 | p3 |
| 13 | Store reg5, x → **x = x\*3 + x\*2 + 1** | p3 |

> **Clave:** Las instrucciones 7 y 8 (ambas `Load x`) pueden leer **distintos valores de x** si entre ellas se ejecuta otra instrucción que modifique x.

---

## a) x = 56 → Ejecución secuencial: p1 → p2 → p3

| Paso | Instrucción | Estado registros | x | y |
|------|-------------|-----------------|---|---|
| 1 | Load y, reg1 | reg1=8 | 0 | 8 |
| 2 | Add 2, reg1 | reg1=10 | 0 | 8 |
| 3 | Store reg1, x | reg1=10 | **10** | 8 |
| 4 | Load x, reg2 | reg2=10 | 10 | 8 |
| 5 | Add 1, reg2 | reg2=11 | 10 | 8 |
| 6 | Store reg2, x | reg2=11 | **11** | 8 |
| 7 | Load x, reg3 | reg3=11 | 11 | 8 |
| 8 | Load x, reg4 | reg4=11 | 11 | 8 |
| 9 | Multi reg3, 3 | reg3=33 | 11 | 8 |
| 10 | Multi reg4, 2 | reg4=22 | 11 | 8 |
| 11 | Add reg3, reg4 | reg5=55 | 11 | 8 |
| 12 | Add 1, reg5 | reg5=56 | 11 | 8 |
| 13 | Store reg5, x | — | **56** | 8 |

**¿Por qué 56?** p1 deja x=10, p2 lo incrementa a 11, y p3 calcula **11×3 + 11×2 + 1 = 33 + 22 + 1 = 56**. Como todo es secuencial, ambos `Load x` de p3 (pasos 7 y 8) leen el mismo valor: 11.

---

## b) x = 22 → Orden: 1-2-7-3-8-9-10-11-12-13-4-5-6

La clave aquí es que el **paso 7 lee x antes** de que el paso 3 lo actualice:

| Paso | Instrucción | Estado registros | x | Observación |
|------|-------------|-----------------|---|-------------|
| 1 | Load y, reg1 | reg1=8 | 0 | |
| 2 | Add 2, reg1 | reg1=10 | 0 | p1 listo para guardar |
| **7** | **Load x, reg3** | **reg3=0** | **0** | ⚠️ Lee x **antes** del paso 3 |
| 3 | Store reg1, x | — | **10** | p1 finaliza, x ahora vale 10 |
| 8 | Load x, reg4 | reg4=10 | 10 | Lee x **después** del paso 3 |
| 9 | Multi reg3, 3 | reg3=0×3=**0** | 10 | reg3=0 porque leyó x=0 |
| 10 | Multi reg4, 2 | reg4=10×2=**20** | 10 | reg4=20 porque leyó x=10 |
| 11 | Add reg3, reg4 | reg5=0+20=**20** | 10 | |
| 12 | Add 1, reg5 | reg5=20+1=**21** | 10 | |
| 13 | Store reg5, x | — | **21** | p3 finaliza |
| 4 | Load x, reg2 | reg2=21 | 21 | |
| 5 | Add 1, reg2 | reg2=22 | 21 | |
| 6 | Store reg2, x | — | **22** | p2 finaliza |

**¿Por qué 22?** El truco es que **reg3 captura x=0** (antes de que p1 guarde x=10) y **reg4 captura x=10** (después). Entonces p3 calcula **0×3 + 10×2 + 1 = 21**, y después p2 le suma 1 → **22**.

---

## c) x = 23 → Orden: 1-2-7-3-4-5-6-8-9-10-11-12-13

Similar al caso b, pero ahora **p2 se ejecuta entre los dos Load de p3**:

| Paso | Instrucción | Estado registros | x | Observación |
|------|-------------|-----------------|---|-------------|
| 1 | Load y, reg1 | reg1=8 | 0 | |
| 2 | Add 2, reg1 | reg1=10 | 0 | |
| **7** | **Load x, reg3** | **reg3=0** | **0** | ⚠️ Lee x=0 |
| 3 | Store reg1, x | — | **10** | |
| 4 | Load x, reg2 | reg2=10 | 10 | |
| 5 | Add 1, reg2 | reg2=11 | 10 | |
| 6 | Store reg2, x | — | **11** | p2 termina, x=11 |
| **8** | **Load x, reg4** | **reg4=11** | **11** | ⚠️ Lee x=11 (p2 ya lo modificó) |
| 9 | Multi reg3, 3 | reg3=0×3=**0** | 11 | reg3=0 |
| 10 | Multi reg4, 2 | reg4=11×2=**22** | 11 | reg4=22 |
| 11 | Add reg3, reg4 | reg5=0+22=**22** | 11 | |
| 12 | Add 1, reg5 | reg5=22+1=**23** | 11 | |
| 13 | Store reg5, x | — | **23** | |

**¿Por qué 23?** reg3 captura x=0 (antes de p1), reg4 captura x=11 (después de p1 **y** p2). Entonces p3 calcula **0×3 + 11×2 + 1 = 23**.

---

## Resumen visual

| Escenario | Load x (paso 7) | Load x (paso 8) | Cálculo p3 | + p2 | Resultado |
|-----------|-----------------|-----------------|------------|------|-----------|
| a) secuencial | 11 | 11 | 11×3 + 11×2 + 1 | — | **56** |
| b) | 0 | 10 | 0×3 + 10×2 + 1 = 21 | +1 | **22** |
| c) | 0 | 11 | 0×3 + 11×2 + 1 | — | **23** |

> **Conclusión:** La diferencia entre los valores posibles se debe a que los dos `Load x` de p3 (pasos 7 y 8) pueden leer **distintos valores** dependiendo de qué otras instrucciones se intercalen entre ellos.

2. Realice un solucion concurrente de gano grueso utilizando <> y/o <await B;S> para el seguiente problema: Dado un numero N verifique cuantas veces aparece ese numero en un arreglo de longitud M. Escriba las pre condiciones que considere necesarias:

Precondiciones: 
- K procesos Buscar.
- Arreglo inicializado con M elementos.
- M mod K = 0. 

int total=0; int buscado=N; int arreglo [M]; int cantBuscar = M DIV K;

Process Buscar [id: 0..K-1] {
	int aux = 0;
	int ini = id * cantBuscar;
	for i = ini .. (ini + cantBuscar - 1) {
        if (arreglo[i] = buscado) then
            aux++;
    }
    <total = total + aux>
}

M -> Cantidad de elementos en el arreglo.
K -> Cantidad de procesos concurrentes.

Entonces cada proceso busca M DIV K (ejemplo: si M=100 y K=4, cada proceso buscará en 25 elementos del arreglo).
Cada uno arranca en su posicion inicial (ini) y recorre hasta su posicion final (ini + cantBuscar - 1).

Alfinal cada proceso para sumar su resultado usa <total = total + aux> para asegurar que la actualización de la variable total sea atómica y no haya interferencia entre los procesos concurrentes.

3. Dada la siguiente solución de grano grueso:

a) Indicar si el siguiente código funciona para resolver el problema de Productor/Consumidor con un buffer de tamaño N. En caso de no funcionar, debe hacer las modificaciones necesarias.

Variables
int cant = 0; int pri_ocupada = 0; int pri_vacia = 0; int buffer[N];

Process Productor::
{  while (true)
  {  produce elemento
    <await (cant < N); cant++>
    buffer[pri_vacia] = elemento;
    pri_vacia = (pri_vacia + 1) mod N;
  }
}

Process Consumidor::
{  while (true)
  { <await (cant > 0); cant-->
    elemento = buffer[pri_ocupada];
    pri_ocupada = (pri_ocupada + 1) mod N;
    consume elemento
  }
}

b) Modificar el código para que funcione para C consumidores y P productores.

Respuestas: 

a) El codigo falla en el caso de que haya mas de un productor o consumidor, ya que el acceso a al variable buffer y a las variables pri_ocupada y pri_vacia no es atómico, lo que puede generar condiciones de carrera.

Ejemplo: 
se produce un elemento y se ejecuta la instruccion <await (cant < N); cant++> y se incrementa cant, pero antes de que se ejecute la instrucción buffer[pri_vacia] = elemento; otro productor puede ejecutar la misma instrucción y escribir en el mismo índice del buffer, sobrescribiendo el elemento producido por el primer productor.


b) Codigo: 

Process Productor:: 
{
    white (true) {
        produce elemento
        <await (cant < N); cant++
        buffer[pri_vacia] = elemento;>
        pri_vacia = (pri_vacia + 1) mod N;
    }
}

process Consumidor:: 
{
    while (true) {
        <await (cant > 0); cant--
        elemento = buffer[pri_ocupada];>
        pri_ocupada = (pri_ocupada + 1) mod N;
        consume elemento
    }
}

4. Resolver con SETENCIAS AWAIT (<> y <await B;S>). Un sistema operativo mantiene 5 instancias de un recurso almacenadas en una cola, cuando un proceso necesita usar una instancia del recurso la saca de la cola, la usa y cuando termina de usarla la vuelve a depositar.

Precondiciones:

