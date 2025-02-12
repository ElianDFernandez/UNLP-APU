program final2;
type 
    producto = record 
        codigo:integer;
        cantidadVendida:integer;
        codigoCliente:integer;
    end;

    lista = ^nodo;
    nodo = record 
        dato:producto;
        sig:lista;
    end;

    vector = array [1..5] of lista;

    listaB = ^nodoB;
    nodoB = record 
        codigo:integer;
        totalVendida:integer;
        sig:listaB;
    end;

procedure leerProducto(var p:producto);
begin
    write('Ingrese codigo del producto: ');
    readln(p.codigo);
    if (p.codigo <> -1) then begin 
        write('Ingrese la cantidad vendida: ');
        readln(p.cantidadVendida);
        write('Ingrese el codigo del cliente: ');
        readln(p.codigoCliente);
    end;
end;

procedure agregarOrdenado(var l:lista; p:producto);
var 
    nue,ant,act:lista;
begin 
    new(nue);
    nue^.sig:=nil;
    nue^.dato:=p;
    act:=l;
    while (act <> nil) and (act^.dato.codigo < p.codigo) do begin 
        ant:=act;
        act:=act^.sig;
    end;
    if (act = l) then 
        l:=nue
    else 
        ant^.sig:=nue;
    nue^.sig:=act;
end;

procedure incializarListas(var v:vector);
var 
    i:integer;
begin 
    for i:=1 to 5 do 
        v[i]:=nil;
end;

procedure cargarListas(var v:vector);
var 
    p:producto;
    dia:integer;
begin 
    incializarListas(v);
    write('Ingrese dia de la venta: ');
    read(dia);
    leerProducto(p);
    while (p.codigo <> -1) do begin 
        agregarOrdenado(v[dia], p);
        writeln('Ingrese dia de la venta: ');
        readln(dia);
        leerProducto(p);
    end;
end;

procedure agregarOActualizarOrdenadaB(var l:listaB; codigo:integer; cantidad:integer);
var 
    nue,ant,act:listaB;
begin 
    act:=l;
    while (act <> nil) and (act^.codigo < codigo) do begin 
        ant:=act;
        act:=act^.sig;
    end;
    if (act <> nil) and (act^.codigo = codigo) then begin 
        act^.totalVendida := act^.totalVendida + cantidad;
    end 
    else begin 
        new(nue);
        nue^.sig:=nil;
        nue^.codigo:=codigo;
        nue^.totalVendida:=cantidad;
        if (act = l) then 
            l:=nue
        else 
            ant^.sig:=nue;
        nue^.sig:=act;
    end;
end; 

procedure recorrerAgregando(l:lista; var lb:listaB);
begin 
    if (l <> nil) then begin 
        agregarOActualizarOrdenadaB(lb,l^.dato.codigo,l^.dato.cantidadVendida);
        recorrerAgregando(l^.sig,lb);
    end;
end;

procedure generarListaB(v:vector; i:integer; var l:listaB);
begin 
    if(i < 5) then begin
        recorrerAgregando(v[i],l);
        generarListaB(v,i+1,l);
    end;
end;

procedure imprimirLista(l:lista);
begin 
    while (l<>nil) do begin 
        writeln('Producto: ',l^.dato.codigo);
        l:=l^.sig;
    end;
end;

procedure imprimirListaB(l:listaB);
begin
    while (l<>nil) do begin 
        writeln('Producto: ',l^.codigo);
        l:=l^.sig;
    end;
end;

procedure imprimirVector(v:vector);
var 
    i:integer;
begin 
    for i:=1 to 5 do begin 
        writeln('Dia ',i);
        imprimirLista(v[i]);
    end;
end;

function codMasVendido(l:listaB; maxVendido,codMaxVendido:integer):integer;
begin 
    if (l = nil) then
        codMasVendido := codMaxVendido
    else begin
        if(l^.totalVendida > maxVendido) then begin 
            maxVendido:=l^.totalVendida;
            codMaxVendido:=l^.codigo;
        end;
        codMasVendido := codMasVendido(l^.sig,maxVendido,codMaxVendido);
    end;
end;

var
    v:vector;
    lb:listaB;
begin 
    cargarListas(v);
    generarListaB(v,1,lb);
    imprimirVector(v);
    imprimirListaB(lb);
    writeln('Codigo con mas ventas: ',codMasVendido(lb,0,0));
end.