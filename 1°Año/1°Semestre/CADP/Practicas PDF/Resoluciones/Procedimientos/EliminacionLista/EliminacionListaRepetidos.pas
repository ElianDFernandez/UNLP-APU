program TestEliminarReps;

type
    lista = ^nodo;
    nodo = record
        num: integer;
        sig: lista;
    end;

var
    l: lista;

procedure agregarAdelante(var l: lista; valor: integer);
var
    nuevo: lista;
begin
    new(nuevo);
    nuevo^.num := valor;
    nuevo^.sig := l;
    l := nuevo;
end;

procedure imprimirLista(l: lista);
begin
    while (l <> nil) do begin
        write(l^.num, ' ');
        l := l^.sig;
    end;
    writeln;
end;

procedure eliminarReps(var l:lista; num:integer);
var 
    ant,act:lista;
begin 
    act:=l;
    while (act <> nil) do begin 
        if (act^.num = num) then begin
            if (act = l) then begin 
                l:=act^.sig;
                dispose(act);
                act:=l;
            end
            else begin 
                ant^.sig:=act^.sig;
                dispose(act);
                act:=ant^.sig;
            end;
        end
        else begin 
            ant:=act;
            act:=act^.sig;
        end;
    end;
end;

begin
    l := nil;

    // Crear una lista: 4 -> 3 -> 2 -> 2 -> 2 -> 1
    agregarAdelante(l, 1);
    agregarAdelante(l, 2);
    agregarAdelante(l, 2);
    agregarAdelante(l, 2);
    agregarAdelante(l, 3);
    agregarAdelante(l, 4);

    writeln('Lista original:');
    imprimirLista(l);

    // Eliminar las ocurrencias del número 2
    eliminarReps(l, 2);

    writeln('Lista despues de eliminar el numero 2:');
    imprimirLista(l);

    // Eliminar las ocurrencias del número 4
    eliminarReps(l, 4);

    writeln('Lista despues de eliminar el numero 4:');
    imprimirLista(l);

    // Eliminar las ocurrencias del número 1
    eliminarReps(l, 1);

    writeln('Lista despues de eliminar el numero 1:');
    imprimirLista(l);
end.
