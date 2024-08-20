type
    lista = ^nodo;
    nodo = record
        num: integer;
        sig: lista;
    end;

procedure eliminarRepetidos(var l: lista; num: integer; var cant: integer);
var
    ant, act, encontrado: lista;
begin
    cant := 0;
    act := l;

    // Avanzar hasta encontrar el primer nodo con el valor `num`
    while (act <> nil) and (act^.num <> num) do
    begin
        ant := act;
        act := act^.sig;
    end;

    // Si encontramos el valor `num`, eliminar todos los nodos consecutivos con ese valor
    while (act <> nil) and (act^.num = num) do
    begin
        encontrado := act;
        act := act^.sig;
        dispose(encontrado);
        cant := cant + 1;
    end;

    // Si eliminamos nodos, conectar el nodo anterior con el siguiente nodo
    if (ant <> nil) then
        ant^.sig := act
    else
        l := act; // Si el nodo eliminado estaba al inicio, actualizar la cabeza de la lista
end;

