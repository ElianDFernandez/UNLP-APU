# Recursion

- Suponga que debe realizar un modulo que imprima los elementos de una lista de enteros

Solucion que veniamos realizando:

```pascal
Procedure imprimir (l:lista);
begin 
    while (l <> nil) do begin 
        write(l^.dato);
        l:=l^.sig;
    end;
end;
```

Solucion **Recursiva**
```pascal
prodecure imprimir (l:lista);
begin 
    if (l <> nil) then begin
        writeln(l^.dato); 
        imprimir(l^.sig);
    end;
end;

```
- Suponga que debe realizar un modulo que retorne el factorial de un numero entero recibido. N = N*(N-1) N veces.

Solucion que veniamos realizando:
```pascal
procedure factorial (num:integer; var fac:integer);
var 
    i:integer;
begin 
    fac:=1;
    for i:=num downt to 1 do begin 
        fac:=fac * i;
    end;
end:
```

Solucion **Recursiva**
```pascal
function factorial (num:integer):integer;
begin 
    if (num = 0) then begin 
        factorial:=1;
    end 
    else begin 
        factorial:= num * factorial(num-1);
    end;
end;
```

- Suponga que debe realizar un modulo que retorne el valor de la potencia de un numero entero recibido. N = N^N veces.

Solucion que veniamos realizando:
```pascal
procedure potencia (base,exp:integer; var pot:integer);
var 
    i:integer;
begin
    if (exp = 0) then begin 
        pot:=1;
    end 
    else if (exp = 1) then begin 
        pot:=base;
    end
    else begin 
        pot:=1;
        for i:=1 to exp do begin 
            pot:=pot*base;
        end;
    end;
end;
```

Solucion **Recursiva**
```pascal
function potencia (base,exp:integer):integer;
begin 
    if (exp = 0) then begin 
        potencia:=1;
    end 
    else if (exp = 1) then begin 
        potencia:=base;
    end
    else begin 
        potencia:= base * potencia(base,exp-1);
    end;
end;
```

## Definicion
La recursividad es una técnica de resolución de problemas que consiste en dividir un problema en instancias más pequeñas del mismo problema (también llamados subproblemas) hasta que obtengamos un subproblema lo suficientemente pequeño que tenga una solución trivial o directa.
La recursividad consiste en resolver un problema por medio de un módulo (procedimientos o funciones) que se llama a sí mismo, evitando el uso de bucles y otros iteradores. 
Cuando el problema se va achicando llega a un punto que no puede achicarse más, esa instancia se denomina caso base. 
Hay problemas en los cuales debe realizarse alguna tarea cuando se alcanza el caso base y otros que no. 
Hay problemas que pueden tener más de un caso base.

## Ventajas
- Facilita la programación
- Facilita la comprensión del problema

## Desventajas
- Mayor consumo de memoria
