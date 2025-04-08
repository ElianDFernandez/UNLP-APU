program cinco;

type 
    participante = record 
        codigo:integer;
        edad:integer;
    end;

    lista = ^nodo;

    nodo = record 
        dato:participante;
        sig:lista;
    end;

procedure agregarAdelante(var l:lista; e:participante);
var 
    nuevo:lista;
begin
    new(nuevo);
    nuevo^.dato := e;
    nuevo^.sig := l;
    l := nuevo;
end;

procedure cargarLista(var l:lista; var promedio:real);
var 
    e:participante;
    i:integer;
    suma:integer;
begin
    Randomize;
    suma := 0;
    for i:=1 to 10 do begin
        e.codigo := random(100);
        e.edad := random(100);
        suma := suma + e.edad;
        agregarAdelante(l, e);
    end;
    promedio := suma / 10;
end;

procedure participantesMasPromedio(l:lista; promedio:real);
begin
    while (l <> nil) do begin
        if (l^.dato.edad > promedio) then begin
            writeln('Codigo: ', l^.dato.codigo);
            writeln('Edad: ', l^.dato.edad);
        end;
        l := l^.sig;
    end;
end;

var 
    l:lista;
    promedio:real;
begin
    l:=nil;
    cargarLista(l, promedio);
    writeln('Promedio de edades: ', promedio:0:2);
    writeln('Participantes con edad mayor al promedio:');
    participantesMasPromedio(l, promedio);
end.