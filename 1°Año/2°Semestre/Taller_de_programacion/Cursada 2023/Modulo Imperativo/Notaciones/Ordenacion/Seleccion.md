# Ordenacion 

# Metodo de seleccion 
Sencillo de aplicar, pero tiempo no tan optimo. 
Este algoritmo consta de N vueltas, donde N es la dimension logica del arreglo.

## Implentacion 
```pascal

procedure seleccion(var v:vector; diml:integer);

var 
    i,j,pos:integer;
    item:{elemento del vector};
begin
    for i:=1 to diml do begin {busca el minimo y guarda en pos la posicion}
        pos:=i;
        for j:=1 to i+1 to diml do begin 
            if (v[j] < v[pos]) then begin 
                pos:=j;
            end;
        end;
        {itercambia v[i] y v[pos]}
        item:= v[pos];
        v[pos]:=v[i];
        v[i]:=item;
    end;
```
## Consideraciones
* Orden de ejecucion = N^2.
* Requiere el mismo tiempo si los datos ya estan ordenados, si estan al azar, si se encuentran en el orden excatamente inverso al que yo lo quiero tener = Siempre requiere el mismo tiempo de ejecucion.