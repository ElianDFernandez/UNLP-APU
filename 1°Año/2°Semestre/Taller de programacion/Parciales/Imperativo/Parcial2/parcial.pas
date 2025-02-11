program parcial;

type 
    compra = record 
        codigoVideoJuego:integer;
        dia:1..31;
        mes:1..12;
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

    compraMes = array [1..12] of integer;

procedure leerCompra(var c:compra);
begin 
    writeln('Ingrese Codigo del video juego: ');
    readln(c.codigoVideoJuego);
    writeln('Dia: ');
    readln(c.dia);
    writeln('Mes: ');
    readln(c.mes);
end;

procedure agregarCompra(var l:lista; c:compra);
var
    nue:lista;
begin
    new(nue);
    nue^.sig:=l;
    nue^.dato:=c;
    l:=nue;
end;

procedure agregarNodo(var a:arbol; cli:integer; com:compra);
var 
    nue:arbol;
begin
    if (a = nil) then begin
        new(nue);
        nue^.codigoCliente := cli;
        nue^.compras := nil;
        agregarCompra(nue^.compras, com);
        a := nue
    end
    else if (a^.codigoCliente = cli) then 
        agregarCompra(a^.compras, com)
    else if (a^.codigoCliente < cli) then 
        agregarNodo(a^.HD, cli, com)
    else 
        agregarNodo(a^.HI, cli, com);
end;

procedure inicializarCompras(var v:compraMes);
var
    i:integer;
begin
    for i:=1 to 12 do 
        v[i]:=0;
end;

procedure cargarArbol(var a:arbol; var v:compraMes);
var
    c:compra;
    cli:integer;
begin 
    inicializarCompras(v);
    writeln('Ingrese codigo del cliente: ');
    readln(cli);
    while(cli <> 0) do begin    
        leerCompra(c);
        v[c.mes] := v[c.mes] + 1;
        agregarNodo(a,cli,c);
        writeln('Ingrese codigo del cliente: ');
        readln(cli);
    end;
end;

function retornarComprasCliente(a:arbol; cli:integer):lista;
begin
    if (a^.codigoCliente = cli) then 
        retornarComprasCliente := a^.compras
    else if (cli > a^.codigoCliente) then
        retornarComprasCliente := retornarComprasCliente(a^.HD,cli)
    else 
        retornarComprasCliente := retornarComprasCliente(a^.HI,cli);
end;

procedure imprimirCompras(l:lista);
begin
    while(l<>nil) do begin
        writeln('Compra Video juego ',l^.dato.codigoVideoJuego, ' / Dia: ', l^.dato.dia, ' Mes: ', l^.dato.mes);
        l:=l^.sig;
    end;
end;

procedure insercion(var v:compraMes);
var 
    i,j:integer; dato:integer;
begin   
    for i:=2 to 12 do begin 
        j:=i-1;
        dato:=v[i];
        while (j>0) and (v[j] < dato) do begin 
            v[j+1]:=v[j];
            j:=j-1;
        end;
        v[j+1]:=dato;
    end;
end; 

procedure imprimirVector(v:compraMes);
var
    i:integer;
begin 
    for i:=1 to 12 do 
        write('[',v[i],']');
end;

var
    a:arbol;
    v:compraMes;
    l:lista;
begin
    l:=nil;
    a:=nil;
    cargarArbol(a,v);
    imprimirCompras(retornarComprasCliente(a,1));
    writeln('Vector desordenado: ');
    imprimirVector(v);
    insercion(v);
    writeln();
    writeln('Vector ordenado: ');
    imprimirVector(v);
end.    


