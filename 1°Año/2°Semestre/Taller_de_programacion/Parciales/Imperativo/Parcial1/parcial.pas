program parcial;

type 
    compra = record 
        dia:1..31;
        cantProductos:integer;
        montoTotal:real;
    end;

    lista = ^nodoL;
    nodoL = record 
        dato:compra;
        sig:lista;
    end;

    arbol = ^nodo;
    nodo = record 
        codigoCliente:integer;
        compras:lista;
        HI:arbol;
        HD:arbol;
    end;

procedure leerCompra(var c:compra);
begin 
    writeln('Ingrese dia de la compra: ');
    readln(c.dia);
    writeln('Ingrese la cantidad de productos: ');
    readln(c.cantProductos);
    writeln('Ingrese el monto total de la compra: ');
    readln(c.montoTotal);
end;

procedure agregarCompra(var l:lista; c:compra);
var 
    nue:lista;
begin 
    new(nue);
    nue^.dato:=c;
    nue^.sig:=l;
    l:=nue;
end;

procedure agregarNodo(var a:arbol; cli:integer; c:compra);
var 
    nue:arbol;
begin 
    if (a = nil) then begin
        new(nue);
        nue^.codigocliente:=cli;
        nue^.compras:=nil;
        agregarCompra(nue^.compras, c);
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end
    else if (a^.codigoCliente = cli) then
        agregarCompra(a^.compras,c)
    else if (a^.codigocliente < cli) then 
        agregarNodo(a^.HD, cli, c)
    else 
        agregarNodo(a^.HI, cli, c);
end;

procedure cargarArbol(var a:arbol);
var 
    c:compra;
    cli:integer;
begin 
    writeln('Ingrese codigo del cliente: ');
    readln(cli);
    while (cli <> 0) do begin 
        leerCompra(c);
        agregarNodo(a,cli,c);
        writeln('Ingrese codigo del cliente: ');
        readln(cli);
    end;
end;

procedure imprimirCompras(l:lista);
begin 
    while (l<>nil) do begin 
        writeln('Compra del dia ', l^.dato.dia, ' Cantidad de productos: ', l^.dato.cantProductos, ' Monto: ', l^.dato.montoTotal:0:2); 
        l:=l^.sig;
    end;
end;

function comprasCliente(a:arbol; c:integer):lista;
begin
    if (a = nil) then
        comprasCliente := nil
    else if (a^.codigoCliente = c) then
        comprasCliente:= a^.compras
    else if (a^.codigoCliente > c) then 
        comprasCliente:= comprasCliente(a^.HI, c)
    else 
        comprasCliente:= comprasCliente(a^.HD, c);
end;

function montoCantProdMayorMonto(l:lista; mayorMonto:real; cantidadProd:integer):real;
begin 
    if (l = nil) then 
        montoCantProdMayorMonto := mayorMonto
    else begin 
        if (l^.dato.cantProductos > cantidadProd) then begin
            mayorMonto := l^.dato.montoTotal;
            cantidadProd := l^.dato.cantProductos;
        end;
        montoCantProdMayorMonto:= montoCantProdMayorMonto(l^.sig,mayorMonto,cantidadProd);
    end;
end;

var
    a:arbol;
    l:lista;
begin
    a:=nil;
    l:=nil;
    cargarArbol(a);
    l:= comprasCliente(a,2);
    imprimirCompras(l);
    writeln('Monto de la compra con mayor cantidad de productos: ', montoCantProdMayorMonto(l,-1,-1):0:2);
end.