program agregarOrdenado;

type
    lista = ^nodo;

    nodo = record
        dato:integer;
        sig:lista;
    end;

procedure agregarOrdenado(var l:lista; e:integer);
var 
    nuevo, act, ant:lista;
begin
    new(nuevo);
    nuevo^.dato := e;
    act := l;
    ant := nil;
    while (act <> nil) and (act^.dato < e) do begin
        ant := act;
        act := act^.sig;
    end;
    if (ant = nil) then begin
        nuevo^.sig := l;
        l := nuevo;
    end
    else begin
        ant^.sig := nuevo;
        nuevo^.sig := act;
    end;
end;

procedure imprimirLista(l:lista);
begin 
    while (l <> nil) do begin
        writeln('Dato: ', l^.dato);
        l := l^.sig;
    end;
end;

procedure crearLista(var l:lista);
var 
    e:integer;
    i:integer;
begin
    Randomize;
    for i:=1 to 10 do begin
        e := random(100);
        agregarOrdenado(l, e);
    end;
    agregarOrdenado(l, 50);
end;

procedure eliminarElementoOrdenado(var l:lista; e:integer);
var 
    act, ant:lista;
begin
    act := l;
    ant := nil;
    while (act <> nil) and (act^.dato < e) do begin
        ant := act;
        act := act^.sig;
    end;
    if (act <> nil) and (act^.dato = e) then begin
        if (ant = nil) then begin
            l := act^.sig;
        end
        else begin
            ant^.sig := act^.sig;
        end;
        dispose(act);
    end;
end;

var 
    l:lista;
begin
    l:=nil;
    crearLista(l);
    imprimirLista(l);
    writeln('Eliminamos el elemento 50');
    eliminarElementoOrdenado(l, 50);
    imprimirLista(l);
end.

