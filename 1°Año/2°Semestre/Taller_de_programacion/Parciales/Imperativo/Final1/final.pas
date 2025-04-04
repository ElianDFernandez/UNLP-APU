program final;

type 
    mensaje=record
        floresJuntadas:0..10;
        papelesJuntados:0..10;
        calle:1..100;
        avenida:1..100;
    end;

    arbol = ^nodo;
    nodo = record 
        dato:mensaje;
        HI:arbol;
        HD:arbol;
    end;

    avenida = record
        numero:integer;
        flores:integer;
        papelesCero:integer;
    end;

    lista = ^nodoL;
    nodoL = record 
        dato:avenida;
        sig:lista;
    end;

    vector = array [1..5] of arbol;

    arbol2 = ^nodo2;
    nodo2 = record 
        flores:integer;
        HI:arbol2;
        HD:arbol2;
    end;

procedure mensajeAleatorio(var m: mensaje);
begin
    m.floresJuntadas := random(11);
    m.papelesJuntados := random(11);
    m.calle := random(100) + 1;
    m.avenida := random(100) + 1;
end;

procedure agregarNodo(var a:arbol; m:mensaje);
var 
    nue:arbol;
begin
    if (a=nil) then begin
        new(nue);
        nue^.dato:=m;
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end
    else if (m.avenida > a^.dato.avenida) then 
        agregarNodo(a^.HD,m)
    else 
        agregarNodo(a^.HI,m);
end;

procedure inicializarArboles(var v:vector);
var 
    i:integer;
begin 
    for i:=1 to 5 do 
        v[i] := nil;
end;

procedure simu100Mensajes(var v:vector);
var 
    i, id:integer;
    m:mensaje;
begin
    randomize;
    inicializarArboles(v);
    for i:=1 to 100 do begin
        id:= random(5)+1;
        mensajeAleatorio(m);
        agregarNodo(v[id],m);
    end;
end;

procedure agregarAdelante(var l: lista; a: avenida);
var
    nue: lista;
    actual: lista;
    actualizo: boolean;
begin 
    actual := l;
    actualizo := false;
    while (actual <> nil) and (not actualizo) do begin
        if (actual^.dato.numero = a.numero) then begin
            actual^.dato.flores := actual^.dato.flores + a.flores;
            actual^.dato.papelesCero := actual^.dato.papelesCero + a.papelesCero;
            actualizo := true;
        end;
        actual := actual^.sig;
    end;

    if (not actualizo) then begin
        new(nue);
        nue^.dato := a;
        nue^.sig := l;
        l := nue;
    end;
end;

procedure recorrerArbolAgregando(a:arbol; var l:lista);
var 
    av:avenida;
begin 
    if (a <> nil) then begin 
        recorrerArbolAgregando(a^.HI,l);
        av.numero := a^.dato.avenida;
        av.flores := a^.dato.floresJuntadas;
        if (a^.dato.papelesJuntados = 0) then 
            av.papelesCero := 1
        else 
            av.papelesCero := 0;
        agregarAdelante(l,av);
        recorrerArbolAgregando(a^.HD,l);
    end;
end;

procedure generarLista(v:vector; var l:lista);
var
    i:integer;
begin
    for i:=1 to 5 do begin
        recorrerArbolAgregando(v[i],l);
    end;
end;

procedure agregarArbol2(var a:arbol2; flores:integer);
var 
    nue:arbol2;
begin
    if (a=nil) then begin
        new(nue);
        nue^.flores:=flores;
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end
    else if (flores > a^.flores) then 
        agregarArbol2(a^.HD,flores)
    else 
        agregarArbol2(a^.HI,flores);
end;

procedure generarArbol2(var a:arbol2; l:lista);
begin
    if (l <> nil) then begin
        agregarArbol2(a, l^.dato.flores);
        generarArbol2(a,l^.sig);
    end;
end;

procedure imprimirLista(l:lista);
begin 
    while (l<> nil) do begin
        writeln('Avenida: ',l^.dato.numero,' Flores: ',l^.dato.flores,' Papeles: ',l^.dato.papelesCero);
        l := l^.sig;
    end;
end;

procedure imprimirArbol(a: arbol);
begin
    if a <> nil then
    begin
        imprimirArbol(a^.HI);
        writeln('Avenida: ', a^.dato.avenida, ' Flores: ', a^.dato.floresJuntadas, ' Papeles: ', a^.dato.papelesJuntados);
        imprimirArbol(a^.HD);
    end;
end;

procedure imprimirArbol2(a:arbol2);
begin 
    if a <> nil then
    begin
        imprimirArbol2(a^.HI);
        writeln('Flores: ', a^.flores);
        imprimirArbol2(a^.HD);
    end;
end;

procedure imprimirArboles(v: vector);
var
    i: integer;
begin
    for i := 1 to 5 do
    begin
        writeln('Arbol ', i, ':');
        imprimirArbol(v[i]);
        writeln('---');
    end;
end;

var 
    v:vector;
    l:lista;
    a:arbol2;
begin
    l:=nil;
    simu100Mensajes(v);
    generarLista(v,l);
    imprimirArboles(v);
    writeln('--Lista--');
    imprimirLista(l);
    generarArbol2(a,l);
    imprimirArbol2(a);
end.