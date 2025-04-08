program seis;

type 
    dispositivo  = record 
        versionAndroid : string;
        tamanioPantalla : integer;
        cantidadDeMemoria : integer;
    end;

    lista = ^nodo;
    nodo = record
        dato : dispositivo;
        sig : lista;
    end;

procedure agregarOrdenado(var l:lista; d:dispositivo);
var 
    nuevo, act, ant: lista;
begin
    new(nuevo);
    nuevo^.dato := d;
    nuevo^.sig := nil;
    act := l;
    ant := l;
    while (act <> nil) and (act^.dato.tamanioPantalla < d.tamanioPantalla) do
    begin
        ant := act;
        act := act^.sig;
    end;
    if (act = ant) then
        l := nuevo
    else
        ant^.sig := nuevo;
    nuevo^.sig := act;
end;

procedure leerDispositivo(var d:dispositivo);
begin
    writeln('Ingrese la version de Android');
    readln(d.versionAndroid);
    writeln('Ingrese el tamanio de la pantalla');
    readln(d.tamanioPantalla);
    writeln('Ingrese la cantidad de memoria');
    readln(d.cantidadDeMemoria);
end;

procedure cargarLista(var l:lista);
var 
    d: dispositivo;
begin
    l := nil;
    leerDispositivo(d);
    while (d.tamanioPantalla <> 0) do
    begin
        agregarOrdenado(l, d);
        leerDispositivo(d);
    end;
end;

procedure procesarLista(l:lista);
var 
    cantDispositivos, masDeTresGB, menorA5Pulgadas: integer;
    cantidad : integer;
    sumPantalla : real;
begin
    cantDispositivos := 0;
    masDeTresGB := 0;
    menorA5Pulgadas := 0;
    sumPantalla := 0;
    while (l <> nil) do
    begin
        cantDispositivos := cantDispositivos + 1;
        sumPantalla := sumPantalla + l^.dato.tamanioPantalla;
        if (l^.dato.cantidadDeMemoria > 3) then
            masDeTresGB := masDeTresGB + 1;
        if (l^.dato.tamanioPantalla < 5) then
            menorA5Pulgadas := menorA5Pulgadas + 1;
        l := l^.sig;
    end;
    writeln('La cantidad de dispositivos es: ', cantDispositivos);
    writeln('El promedio de tamanio de pantalla es: ', sumPantalla / cantDispositivos);
    writeln('La cantidad de dispositivos con mas de 3GB de memoria es: ', masDeTresGB);
    writeln('La cantidad de dispositivos con menos de 5 pulgadas es: ', menorA5Pulgadas);
end;

var 
    l: lista;
begin
    cargarLista(l);
    procesarLista(l);
end.
