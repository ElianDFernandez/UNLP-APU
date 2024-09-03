program ListaEnlazada;

type
    lista = ^nodo;
    nodo = record
        dato: integer;
        sig: lista;
    end;

procedure agregarAdelante(var l: lista; num: integer);
var
    nue: lista;
begin
    new(nue);       // Crear nuevo nodo
    nue^.dato := num; // Asignar valor al nodo
    nue^.sig := l;   // Enlazar el nuevo nodo con el primero de la lista
    l := nue;        // Actualizar el puntero de la lista para que apunte al nuevo nodo
end;

procedure imprimirLista(l: lista);
begin
    while l <> nil do
    begin
        writeln(l^.dato);
        l := l^.sig;
    end;
end;

var
    l: lista;
begin
    l := nil; // Inicializamos la lista como vacía

    // Agregamos elementos al frente de la lista
    agregarAdelante(l, 10);
    agregarAdelante(l, 20);
    agregarAdelante(l, 30);

    // Imprimimos la lista
    writeln('Elementos de la lista:');
    imprimirLista(l);
end.