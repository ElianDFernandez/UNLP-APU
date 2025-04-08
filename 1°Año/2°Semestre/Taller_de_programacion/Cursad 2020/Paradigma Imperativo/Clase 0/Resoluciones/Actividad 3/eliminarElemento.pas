program eliminarElemento;

type 
    lista = ^nodo;

    nodo = record
        dato:integer;
        sig:lista;
    end;
    
procedure eliminarElemento(var l:lista; e:integer);
var 
    sig, ant:lista;
begin
    sig := l;
    ant := nil;
    while (sig <> nil) and (sig^.dato <> e) do begin
        ant := sig;
        sig := sig^.sig;
    end;
    if (sig <> nil) then begin
        if (ant = nil) then begin
            l := sig^.sig;
        end
        else begin
            ant^.sig := sig^.sig;
        end;
        dispose(sig);
    end;
end;

procedure agregarAdelante(var l:lista; e:integer);
var 
    nuevo:lista;
begin
    new(nuevo);
    nuevo^.dato := e;
    nuevo^.sig := l;
    l := nuevo;
end;

procedure crearLista(var l:lista);
var 
    e:integer;
    i:integer;
begin
    Randomize;
    for i:=1 to 10 do begin
        e := random(100);
        agregarAdelante(l, e);
    end;
    // Agregamos el elemento 50 para probar la eliminacion
    agregarAdelante(l, 50);
end;

procedure imprimirLista(l:lista);
begin 
    while (l <> nil) do begin
        writeln('Dato: ', l^.dato);
        l := l^.sig;
    end;
end;

var 
    l:lista;
begin
    l := nil;
    crearLista(l);
    writeln('Lista original');
    imprimirLista(l);
    eliminarElemento(l, 50);
    writeln('Lista sin el elemento 50');
    imprimirLista(l);
end.