# Practica 5

Objetivo: Interpretar cómo se organiza la memoria de datos durante la ejecución de un programa con llamados a subrutinas.

# Ejercicio 1:
Ejercicio 1: Explique claramente cual es la utilidad del registro de activación y que representan cada una de sus partes. (Basado en el modelo debajo detallado)

| Modelo de registro de activación |
|---------------------------------|
| Head (Prog.Principal) |
| Pto Retorno |
| EE (Enlace estatico) | 
| ED (Enlace dinamico) |
| Variables |
| ... |
| Parametros |
| ... |
| Procedimientos | 
| ... |
| Funciones |
| ... |
| Valor de retorno |


El **Registro de Activación (RA)** es una estructura de datos fundamental que se crea dinámicamente en la memoria (zona de datos o pila) cada vez que se invoca una unidad de programa, como un procedimiento o función.

Su utilidad principal es representar la instancia de la rutina en ejecución, almacenando toda la información esencial y el contexto necesario para que dicha unidad pueda ejecutarse correctamente, comunicarse con otras rutinas y devolver el control al programa una vez que finaliza.

### Partes del modelo de registro de activación

- **Head (Prog. Principal):**
	- Representa el registro de activación base o principal. Al iniciar la ejecución del programa, el bloque principal (main) es la primera unidad en activarse y establecerse en la memoria, ubicándose en el fondo de la cadena de llamadas y permaneciendo activo durante toda la ejecución.

- **Pto Retorno (Punto de Retorno):**
	- Es un puntero que guarda la dirección de la instrucción en la zona de código a la que el flujo del programa debe regresar una vez que la rutina actual termine su ejecución. Es vital para reanudar el trabajo exactamente donde se dejó antes de la llamada.

- **EE (Enlace Estático o Link Estático):**
	- Es un puntero dirigido al registro de activación de la unidad que contiene estáticamente (o léxicamente) a la rutina actual en el texto del código fuente. Permite el acceso al ambiente no local; es decir, forma la "cadena estática" que el programa sigue para encontrar variables declaradas en bloques externos envolventes.

- **ED (Enlace Dinámico o Link Dinámico):**
	- Es un puntero que apunta a la dirección base del registro de activación de la rutina llamadora (la unidad que invocó a la rutina actual). Conforma la "cadena dinámica" de llamadas y se utiliza al retornar para reestablecer el entorno previo (actualizando el puntero current) justo antes de destruir el registro de activación actual.

- **Variables:**
	- Es el espacio de memoria (los l-valores) reservado para alojar los datos locales que la rutina declara en su interior. Estas variables tienen una alocación semiestática o automática: nacen al invocar la rutina y se destruyen al finalizar la misma.

- **Parámetros:**
	- Son los espacios de memoria asignados para recibir los valores de entrada. Aquí se realiza la ligadura (por posición, nombre o valor por defecto) entre los parámetros reales (enviados en la invocación) y los parámetros formales (definidos en el encabezado de la rutina).

- **Procedimientos / Funciones:**
	- En lenguajes que permiten el anidamiento (como Pascal o ADA), este espacio representa el conocimiento y la visibilidad de las rutinas internas locales declaradas dentro del bloque actual. Estas subrutinas forman parte del ambiente local de la unidad y pueden ser invocadas de acuerdo con las reglas de alcance.

- **Valor de retorno:**
	- Exclusivo de las unidades que actúan como funciones. Dado que al terminar una rutina su registro de activación se desaloca (se destruye), se debe reservar esta celda en el RA para guardar el resultado de la operación. Así, la rutina llamadora puede recuperar el valor justo antes de que la memoria se libere.

# Ejercicio 2:
Dado el siguiente programa escrito en Pascal-like, continuar la realización de las pilas
de ejecución hasta finalizar las mismas.

a) Siguiendo la cadena estática 
b) Siguiendo la cadena dinámica

```pascal
Program Main
Var a: array[1..10] of integer;
x,y,z:integer
    Procedure A ()
        var y,t: integer;
        begin
        a(1):= a(1)+1;
        z:=z+1;
        t:=1; 
        y:=2;
        B(); 
        a(y):=a(y)+3;
        y:=y+1;
        If z=11 Then Begin
            a(z-1):=a(z-2) + 3;
            z:=z-4;
            a(z-y):=a(z) – a(y) + 5;
        End;
    end;

    Function t():integer
    begin
        y:=y+1;
        z:=z-6;
        return(y+x);
    end;

    Procedure B()
    var d:integer;
    Procedure I ()
        begin
            x:=0;
            x:=x+6;
        end;
    begin
        x:=x+t;
        d:=0;
        while x>d do begin
            I();
            x:=x-1;
            d:=d + 2;
        end;
    end;
begin
    For x:=1 To 10 do 
        a(x):=x;
        x:=5; y:=1; z:=10;
        A();
    For x:=1 To 10 do 
        write(a(x),x);
end.
```

Siguiendo la cadena estática
*** Reg Activ Main
*1 Pto retorno
A(1)= ~~1~~ 2
A(2)= ~~2~~ 5
A(3)= 3
A(4)= 4
A(5)= 5
A(6)= 6
A(7)= 7
A(8)= 8
A(9)= 9
A(10)= 10
x= ~~1..10~~ ~~5~~ ~~12~~ ~~6~~ ~~5~~ ~~6~~ ~~5~~ ~~6~~ 5
y= ~~1~~ 2
z= ~~10~~ ~~11~~ 5
Procedure A
Function t
Procedure B
VR . . . . . . . .

*2 *** Reg Activ A
Pto retorno (*1)
EE(*1) -> Es el enlace estático que apunta al RA de Main
ED(*1) -> Es el enlace dinámico que apunta al RA de Main
t= 1
y= ~~2~~ 3
VR . . . . . . . .

*3 *** Reg Activ B
Pto retorno (*2)
EE(*1) -> Es el enlace estático que apunta al RA de Main (Porque B está escrito en Main)
ED(*2) -> Es el enlace dinámico que apunta al RA de A (Porque A llamó a B)
d= ~~0~~ ~~2~~ ~~4~~ 6
Procedure I
VR . . . . . . . .

*4 *** Reg Activ Function t
Pto retorno (*3)
EE(*1) -> Es el enlace estático que apunta al RA de Main (Porque t está escrita en Main)
ED(*3) -> Es el enlace dinámico que apunta al RA de B (Llamada por B al hacer x:=x+t)
VR 7

*5 *** Reg Activ Procedure I (1ra iteración)
Pto retorno (*3)
EE(*3) -> Es el enlace estático que apunta al RA de B (Porque I está escrita dentro de B)
ED(*3) -> Es el enlace dinámico que apunta al RA de B
VR . . . . . . . .

*6 *** Reg Activ Procedure I (2da iteración)
Pto retorno (*3)
EE(*3) -> Es el enlace estático que apunta al RA de B
ED(*3) -> Es el enlace dinámico que apunta al RA de B
VR . . . . . . . .

*7 *** Reg Activ Procedure I (3ra iteración)
Pto retorno (*3)
EE(*3) -> Es el enlace estático que apunta al RA de B
ED(*3) -> Es el enlace dinámico que apunta al RA de B
VR . . . . . . . .
(Nota sobre la cadena estática: Al ejecutarse el If en A, la global z vale 5. Como la condición es z=11, salta todo el bloque If y no modifica los arreglos A(4) y A(10)).


Recuerda la regla: el Enlace Estático NO SE USA. Si una unidad no tiene una variable, sube por su Enlace Dinámico (ED) preguntando "quién la llamó" hasta encontrarla.
*** Reg Activ Main
*1 Pto retorno
A(1)= ~~1~~ 2
A(2)= ~~2~~ 5
A(3)= 3
A(4)= ~~4~~ 9
A(5)= 5
A(6)= 6
A(7)= 7
A(8)= 8
A(9)= 9
A(10)= ~~10~~ 12
x= ~~1..10~~ ~~5~~ ~~6~~ ~~5~~ ~~6~~ ~~5~~ ~~6~~ 5
y= 1
z= ~~10~~ ~~11~~ 7
Procedure A
Function t
Procedure B
VR . . . . . . . .

*2 *** Reg Activ A
Pto retorno (*1)
ED(*1) -> Es el enlace dinámico que apunta al RA de Main
t= 1
y= ~~2~~ 3
VR . . . . . . . .

*3 *** Reg Activ B
Pto retorno (*2)
ED(*2) -> Es el enlace dinámico que apunta al RA de A 
d= ~~0~~ ~~2~~ ~~4~~ 6
Procedure I
VR . . . . . . . .

*4 *** Reg Activ Procedure I (1ra iteración)
Pto retorno (*3)
ED(*3) -> Es el enlace dinámico que apunta al RA de B
VR . . . . . . . .

*5 *** Reg Activ Procedure I (2da iteración)
Pto retorno (*3)
ED(*3) -> Es el enlace dinámico que apunta al RA de B
VR . . . . . . . .

*6 *** Reg Activ Procedure I (3ra iteración)
Pto retorno (*3)
ED(*3) -> Es el enlace dinámico que apunta al RA de B
VR . . . . . . . .