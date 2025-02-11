# Ordenacion 

# Metodo de Insercion
Este algoritmo consta de N vueltas, donde N es la dimension logica del arreglo.


# Implementacion
```pascal

procedure insercion(var v:vector; diml:integer);
var 
    i,j:integer; actual:{elemento del vector}
begin 
    for i:=2 to diml do begin 
        actual:= v[i];
        j:= i-1;
        while (j > 0) and ( v[j] > actual) do begin 
            v[j+1]:=v[j];
            j:= j-1;
        end;
        v[j+1]:=actual;
    end;
end;


```

## Consideraciones

* Orden de ejecucion = N^2.
* Requiere el mismo tiempo si los datos ya estan ordenados, si estan al azar, si se encuentran en el orden excatamente inverso al que yo lo quiero tener = Si lo datos ya estan ordenados el algoritmo solo hace las comparaciones.