program agregarAtras;

type 
    elemento = record
        cod:integer;
    end;

    lista = ^nodo;

    nodo = record 
        dato: elemento;
        sig: lista;
    end;

procedure agregarAtras(var l:lista; var ult:lista; e:elemento);
var 
    nuevo:lista;
begin 
    new(nuevo);
    nuevo^.dato := e;
    nuevo^.sig := nil;
    if (l = nil) then begin 
        l := nuevo;
    end else begin 
        ult^.sig := nuevo;
    end;
    ult := nuevo;
end;

procedure imprimirLista(l:lista);
begin 
    while (l <> nil) do begin 
        writeln('Codigo: ', l^.dato.cod);
        l := l^.sig;
    end;
end;

procedure crearListaAgregarAtras(var l:lista);
var 
    e:elemento;
    i:integer;
    ult:lista;
begin
    Randomize;
    l := nil;
    ult := nil;
    for i:=1 to 10 do begin 
        e.cod := random(100);
        agregarAtras(l, ult, e);
    end;
end;

var 
    l:lista;
begin
    crearListaAgregarAtras(l);
    imprimirLista(l);
end.