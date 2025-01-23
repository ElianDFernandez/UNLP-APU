program listas;

type 
    elemento = record
        cod:integer;
    end;

    lista = ^nodo;

    nodo = record 
        dato: elemento;
        sig: lista;
    end;

procedure agregarAdelantes(var l:lista; e:elemento);
var 
    nuevo:lista;
begin 
    new(nuevo); 
    nuevo^.dato := e;
    nuevo^.sig := l;
    l := nuevo;
end;

procedure imprimirLista(l:lista);
begin 
    while (l <> nil) do begin 
        writeln('Codigo: ', l^.dato.cod);
        l := l^.sig;
    end;
end;

procedure crearListaAgregarAdelante(var l:lista);
var 
    e:elemento;
    i:integer;
begin
    Randomize;
    for i:=1 to 10 do begin 
        e.cod := random(100);
        agregarAdelantes(l, e);
    end;
end;

var 
    l:lista;
begin
    l:=nil;
    crearListaAgregarAdelante(l);
    imprimirLista(l);
end.