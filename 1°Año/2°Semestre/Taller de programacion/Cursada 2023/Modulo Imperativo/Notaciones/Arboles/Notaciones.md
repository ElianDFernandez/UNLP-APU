# Arboles

Es una estructura de datos jerarquica.
Esta formada por nodos, donde cada nodo tiene a lo sumo un nodo padre y varios nodos hijos.
El nodo pricipal se llama raiz y los nodos que no tiene hijos se llaman hojas.
**Usamos arboles binarios de busqueda.**

**En resumen:**
- Homogenea
- Dinamica
- No lineal

## Graficamente 
```
    1
   / \
  2   3
 / \
4   5
```

## Declaracion 

```pascal 
program arbol;

type 
    arbol = ^nodo;
    nodo = record
        dato: integer;
        HI: arbol;
        HD: arbol;
    end;

var
    a: arbol;
```
## Creacion 

```pascal
procedure crear(var a: arbol);
begin
    a := nil;
    readln(x);
    while x <> 0 do begin
        agregar(a, x);
        readln(x);
    end;
end;
```
## Agregar un nodo

```pascal
procedure agregar(var a: arbol; x: integer);
begin
    if a = nil then begin
        new(a);
        a^.dato := x;
        a^.HI := nil;
        a^.HD := nil;
    end
    else
        if (x <= a^.dato) then
            agregar(a^.HI, x)
        else
            agregar(a^.HD, x);
end;
```
## Recorridos

### Preorden

```pascal
procedure preorden(a: arbol);
begin
    if a <> nil then begin
        writeln(a^.dato);
        preorden(a^.HI);
        preorden(a^.HD);
    end;
end;
```

### Inorden

```pascal
procedure inorden(a: arbol);
begin
    if a <> nil then begin
        inorden(a^.HI);
        writeln(a^.dato);
        inorden(a^.HD);
    end;
end;
```

### Postorden

```pascal
procedure postorden(a: arbol);
begin
    if a <> nil then begin
        postorden(a^.HI);
        postorden(a^.HD);
        writeln(a^.dato);
    end;
end;
```

## Busqueda 
Retorna booelan si el elemento se encuentra en el arbol.

```pascal
function buscar(a: arbol; x: integer): boolean;
begin
    if (a = nil) then
        buscar := false
    else if (a^.dato = x) then
        buscar := true
    else if (x < a^.dato) then
        buscar := buscar(a^.HI, x)
    else
        buscar := buscar(a^.HD, x);
end;
```
Retorna el nodo en el que se encuentra el elemento.

```pascal
function buscarNodo(a: arbol; x: integer): arbol;
begin
    if (a = nil) then
        buscarNodo := nil
    else if (a^.dato = x) then
        buscarNodo := a
    else if (x < a^.dato) then
        buscarNodo := buscarNodo(a^.HI, x)
    else
        buscarNodo := buscarNodo(a^.HD, x);
end;
```

## Operaciones: (A resolver para practicar)
- Buscar valores dentro de un rango 
- Obtener el minimo y maximo
- Calcular la cantidad de nodos que tiene el arbol
- Calcular la altura del arbol
- Calcular el nivel de un arbol

## Buscar maximo y minimo
Retornando dato
```pascal
function minimo(a: arbol): integer;
begin
    if (a^.HI = nil) then
        minimo := a^.dato
    else
        minimo := minimo(a^.HI);
end;

function maximo(a: arbol): integer;
begin
    if (a^.HD = nil) then
        maximo := a^.dato
    else
        maximo := maximo(a^.HD);
end;
```
Retornando nodo
```pascal
function minimoNodo(a: arbol): arbol;
begin
    if (a^.HI = nil) then
        minimoNodo := a
    else
        minimoNodo := minimoNodo(a^.HI);
end;

function maximoNodo(a: arbol): arbol;
begin
    if (a^.HD = nil) then
        maximoNodo := a
    else
        maximoNodo := maximoNodo(a^.HD);
end;
```

