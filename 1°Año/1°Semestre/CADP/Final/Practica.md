# Procedimientos y tips en pascal CADP

## Procedimientos utiles

### Cortes de control 
Recordar pasar la condicion al while interno. Ejemplo:

```pascal
    program ejemploCorteControl;
    type 
        tipos=1..5;
        auto=record
            marca:string;
            tipo:tipos;
            valor:real;
        end;
    var 
        a:auto;
        valorTotalTipo:real;
        valorTotalMarca:real;
        marcaActual:string;
        tipoActual:tipos;
    begin 
        write('Ingrese marca del auto y valor: ');
        readln(a.marca);
        readln(a.tipo);
        readln(a.valor);
        while (a.marca <> 'fin') do begin 
            valorTotalMarca:=0;
            marcaActual := a.marca;
            writeln('Marca: ', marcaActual);
            while (a.marca <> 'fin') and (marcaActual = a.marca) do begin 
                valorTotalTipo:=0;
                tipoActual:=a.tipo;
                while (a.marca <> 'fin') and (marcaActual = a.marca) and (tipoActual = a.tipo) do begin 
                    valorTotalTipo:=valorTotalTipo + a.valor;
                    write('Ingrese marca del auto y valor: ');
                    readln(a.marca);
                    readln(a.tipo);
                    readln(a.valor);
                end;
                writeln('  Tipo ', tipoActual, ': Valor total = ', valorTotalTipo:0:2);
                valorTotalMarca:= valorTotalMarca + valorTotalTipo;
            end;
            writeln('Total para la marca ', marcaActual, ': ', valorTotalMarca:0:2);
        end;
    end.
```

### Descomponer un numero
Usando DIV y MOD. Ejemplo:

```pascal
    program descomponer;
        
    function masPares(num:integer):boolean;
    var 
        pares,impares:integer;
        dig:integer;
    begin 
        pares:=0;
        impares:=0;
        while (num <> 0) do begin 
            dig:= num MOD 10;
            if (dig MOD 2 = 0) then 
                pares:=pares+1
            else 
                impares:=impares+1;
            num := num DIV 10;
        end;
        if (pares > impares) then masPares:=true
        else 
            masPares:=false;
    end;

    var
        numero: integer;
    begin
        writeln('Ingrese un numero:');
        readln(numero);

        if masPares(numero) then
            writeln('El numero tiene mas digitos pares que impares.')
        else
            writeln('El numero tiene mas digitos impares que pares.');
    end.
```
## Vectores
Utilizaremos vectores cuando conocemos el maximo de elementos de almacenar y tendremos que realizar muchas operaciones de consulta. Recordar que la estructura de vectores nos permite acceder mediante un indice lo que la vuelve mucho mas eficiente en cuanto acceso a comparacion de una lista. Por otro lado, no es tan eficiente al momento de agregar y eliminar elementos.
[Operaciones Teoria](Teoria.md#261)

**Operaciones** 
* Carga de valores
* Lectura / Escritura
* Recorridos
* Agregar elementos al final
* Insertar elementos (Corrimientos)
* Borrar elementos (Corrimientos)
* Búsqueda de un elemento (Busqueda mejorada O(n), Busqueda dicotomica O(log n))
* Ordenación de los elementos

### Cargar un vector DIML DIMF
Tener en cuenta la dimension logica y fisica para cargarlo.

```pascal
    program cargarVector;
    const 
        dimf = 5;
    type 
        vector = array [1..dimf] of integer;
    var 
        num: integer;
        v: vector;
        diml: integer;
    begin 
        diml := 0;
        writeln('Ingrese números para cargar en el vector (0 para terminar):');
        readln(num);
        while (num <> 0) and (diml < dimf) do begin
            diml := diml + 1;
            v[diml] := num;
            readln(num);
        end;
        writeln('Vector cargado:');
        for diml := 1 to diml do
            writeln(v[diml]);
    end.
```

### Recorrer 
Tener en cuentra la diml en los recorridos siempre

### Busqueda Dicotomica 
```pascal
    procedure busquedaDicotomica(var vec:numeros; diml:integer; num:integer; var ok:boolean);
    var 
        pri,ult,medio:integer;
    begin 
        ok:=false;
        pri:=1; ult:=diml; medio:=(pri+ult) div 2;
        while (pri <= ult ) and (bus <> vec[medio]) do begin 
            if (num < v[medio]) then 
                ult:= medio-1
            else 
                pri:= medio+1;
            medio := (pri + ult) div 2;
        end;
        if (pri <= ult) and (v[medio] = num) then ok:=true;
    end;
```

### Agregar elementos al final 

```pascal
    program cargarVector;
    const 
        dimf = 5;
    type 
        vector = array [1..dimf] of integer;

    procedure agregarAlFinal(var v:vector; var diml:integer; num:integer; var ok:boolean);
    begin 
        ok:=false;
        if (diml+1 < = dimf) then begin 
            ok:=true;
            v[diml+1] := num;
            diml:= diml+1;
        end;
    end;
    
```

### Agregar elementos en una pos especifica (Insertar)

```pascal
    program cargarVector;
    const 
        dimf = 5;
    type 
        vector = array [1..dimf] of integer;

    procedure insertar(var v:vector; var diml:integer; num:integer; pos:integer; var ok:boolean);
    var 
        i:integer;
    begin 
        ok:=false;
        if (diml+1 < = dimf) and (pos > 0) and (pos <= dimf) then begin 
            ok:=true;
            for i:=diml downto pos do  
                v[i+1] := v[i];
            v[pos]:= num;
            diml:=diml+1;
        end;
    end;
```

### Eliminacion pos
```pascal
    procedure eliminar(var v:vector; var diml:integer; pos:integer; var ok:booelan);
    var 
        i:integer;
    begin 
        ok:=false;
        if (pos > 0) and (pos <= diml) then begin 
            ok:=true;
            for i:=pos to diml-1 do 
                v[i]:=v[i+1];
            diml:=diml-1;
        end;
    end;
```

### Eliminacion de elemento repedito vector ordenado 
```pascal
    procedure eliminar(var v:vector; var diml:integer; num:integer; var ok:booelan);
    var 
        pos:integer;
        cant:integer;
        i:integer;
    begin   
        i:=1;
        cant:=0;
        while (i <= diml) and (v[i] < num) do begin 
            i:=i+1;
        end;
        if (i <= diml) then begin
            pos:=i;
            while (i <=diml) and (v[i] = num) do begin 
                cant:=cant+1;
                i:=i+1;
            end;
            for i:=pos to diml-cant do
                v[i] := v[i+cant]
            diml:= diml - cant;
        end;
    end;
```

### Eliminacion de todos los elementos repeditos de un vector no ordenado
```pascal
    procedure eliminarRepetidos(var v: vector; var diml: integer);
    var
        i, j, k: integer;
        encontrado: boolean;
    begin
        i := 1;
        while (i <= diml) do begin
            j := i + 1;
            while (j <= diml) do begin
                if (v[j] = v[i]) then begin
                    // Si se encuentra un duplicado, desplazar los elementos
                    for k := j to diml - 1 do
                        v[k] := v[k + 1];
                    
                    diml := diml - 1; // Reducir el tamaño lógico
                end
                else
                    j := j + 1;
            end;
            i := i + 1;
        end;
    end;
```

### Eliminacion de un elemento en especifico repetido de un vector no ordenado
```pascal 
    procedure eliminarPorNumero(var v: vector; var diml: integer; num: integer; var ok: boolean);
    var
        i, j: integer;
    begin
        i := 1;
        ok := false;

        // Recorremos el vector buscando el número a eliminar
        while (i <= diml) do begin
            if (v[i] = num) then begin
                // Desplazar los elementos a la izquierda para eliminar la ocurrencia
                for j := i to diml - 1 do
                    v[j] := v[j + 1];
                diml := diml - 1; // Reducir el tamaño lógico
                ok := true;
            end
            else
                i := i + 1;
        end;
    end;
```
### Ordenacion insercion 
```pascal 
    procedure Ordenacion_Insercion (var v: vector; DimL: integer);
    var
        j, i, aux: integer; 
    begin
        for i:= 2 to DimL do  begin
            aux:= v[i];
            j:= i-1;
            while (j > 0) and (v[j] > aux) do begin
                v[j+1] := v[j];
                j:= j -1;
            end;
            v[j+1]:= aux;
        end;
    end;
```

## Listas

### Agregar Adelante

```pascal 
    procedure agregarAdelantes(var l:lista; dato:integer);
    var 
        nue:lista;
    begin 
        new(nue);
        nue^.dato:=dato;
        nue^.sig:=l;
        l:=nue;
    end;
```

### Agregar Atras
```pascal
    procedure agregarAtras (var l:lista; var ult:lista; dato:integer);
    var 
        nue:lista;
    begin 
        new(nue);
        nue^.dato:=dato;
        nue^.sig:=nil;
        if (l = nil) then begin
            l:=nue;
            ult:=nue;
        else begin  
            ult^.sig:=nue;
            ult:=nue;
        end;
    end;
```

### Agregar Ordenado 
```pascal
    procedure agregarOrdenado (var l:lista; dato:integer);
    var 
        nue,ant,act:lista;
    begin 
        new(nue);
        nue^.dato:=dato;
        nue^.sig:=nil;
        act := l;
        while (act <> nil) and (act^.dato < dato) do begin 
            ant:=act;
            act:=act^.sig;
        end;
        if (act = l) then begin 
            nue^.sig:=l;
            l:=nue;
        end
        else begin
            ant^.sig:=nue;
            nue^.sig:=act;
        end;
    end;
```

### Eliminar un elemento
```pascal
    procedure eliminar (var l:lista; dato:integer);
    var 
        ant,act:lista;
    begin 
        act:=l;
        while(act<>nil) and (act^.dato <> dato) do begin    
            ant:=act;
            act:=act^.sig;
        end;
        if (act <> nil) then begin
            if (act = l) then begin
                l:=l^sig;
                dispose(act);
            end
            else begin
                ant^.sig:=act^.sig;
                dispose(act);
            end;
        end;
    end;
```

### Eliminar elementos repetidos de una lista ordenada
```pascal
    procedure eliminar (var l:lista; dato:integer);
    var 
        ant,act,temp:lista;
    begin 
        act:=l;
        while(act<>nil) and (act^.dato <> dato) do begin    
            ant:=act;
            act:=act^.sig;
        end;
        while (act <> nil) and (act^.dato = dato) do begin 
            temp:=act;
            dispose(temp);
            act:=act^.sig;
        end;
        if (ant <> nil) then begin 
            ant^.sig:=act^.sig;
        end
        else 
            l:=act;
    end;
```