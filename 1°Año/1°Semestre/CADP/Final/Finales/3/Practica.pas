program ejercicio1;

type 
    venta = record 
        codigo:integer;
        codProducto:integer;
        cantidad:integer;
    end;

    lista = ^nodo;
    nodo = record 
        dato:venta;
        sig:lista;
    end;

procedure leerVenta(var v:venta);
begin 
    writeln('Ingrese el codigo de venta:');
    readln(v.codigo);
    if( v.codigo <> 9999) then begin 
        writeln('Ingrese codigo del producto:');
        readln(v.codProducto);
        writeln('Cantidad vendida: ');
        readln(v.cantidad);
    end;
end;

procedure agregarOrdenada(var l:lista; v:venta);
var 
    nue:lista;
    ant,act:lista;
begin 
    new (nue);
    nue^.dato:=v;
    nue^.sig:=nil;
    act:=l;
    while (act <> nil) and (act^.dato.codigo < v.codigo) do begin 
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

procedure cargarLista(var l:lista);
var 
    v:venta;
begin 
    leerVenta(v);
    while (v.codigo <> 9999) do begin 
        agregarOrdenada(l,v);
        leerVenta(v);
    end;
end;

procedure procesarlista(l:lista; prod:integer);
var 
    canitdadVendida:integer;
begin   
    canitdadVendida:=0;
    while(l <> nil) do begin 
        if (l^.dato.codProducto = prod) then 
            canitdadVendida:=canitdadVendida + l^.dato.cantidad;
        l:=l^.sig;
    end;
    writeln('La cantidad de prods vendidos de codigo ', prod, ' : ', canitdadVendida );
end;

procedure imprimirLista(l:lista);
begin 
    while (l <> nil) do begin 
        writeln(l^.dato.codigo, ' ', l^.dato.codProducto, ' ', l^.dato.cantidad);
        l:=l^.sig;
    end;
end;

var 
    l:lista;
    prod:integer;
begin 
    l:=nil;
    cargarLista(l);
    imprimirLista(l);
    writeln('Producto a procesar: ');
    readln(prod);
    procesarlista(l,prod);
end.1