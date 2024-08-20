// Una productora nacional realiza un casting de personas para la selección de actores extras de una
// nueva película, para ello se debe leer y almacenar la información de las personas que desean
// participar de dicho casting. De cada persona se lee: DNI, apellido y nombre, edad y el código de
// género de actuación que prefiere (1: drama, 2: romántico, 3: acción, 4: suspenso, 5: terror). La lectura
// finaliza cuando llega una persona con DNI 33555444, la cual debe procesarse.
// Una vez finalizada la lectura de todas las personas, se pide:
// a. Informar la cantidad de personas cuyo DNI contiene más dígitos pares que impares.
// b. Informar los dos códigos de género más elegidos.
// c. Realizar un módulo que reciba un DNI, lo busque y lo elimine de la estructura. El DNI puede no
// existir. Invocar dicho módulo en el programa principal.

Program productora;
const 
    dimf = 5;
type 
    persona = record 
        dni:integer;
        apellido:string;
        nombre:string;
        edad:integer;
        codigo:1..5;
    end;

    vectorContador = array [1..dimf] of integer;

    lista = ^nodo;
    nodo = record 
        dato:persona;
        sig:lista;
    end;

procedure inicializarVector(var v:vectorContador);
var 
    i:integer;
begin
    for i:= 1 to dimf do begin 
        v[i]:=0;
    end;
end;

procedure leerPersona(var p:persona);
begin 
    writeln('Ingrese Dni: ');
    readln(p.dni);
    writeln('Ingrese Apellido: ');
    readln(p.apellido);
    writeln('Ingrese Nombre: ');
    readln(p.nombre);
    writeln('Ingrese Edad: ');
    readln(p.edad);
    writeln('Ingrese Codigo: ');
    readln(p.codigo);
end;

function tieneMasPares(dni:integer):boolean;
var 
    dig:integer;
    pares:integer;
    impares:integer;
begin 
    pares:=0;
    impares:=0;
    while (dni <> 0) do begin
        dig:= dni MOD 10;
        if (dig MOD 2 = 0) then 
            pares:=pares+1
        else 
            impares:=impares+1;
        dni:= dni DIV 10;
    end;
    if (pares > impares) then 
        tieneMasPares:=true
    else 
        tieneMasPares:=false;
end;

procedure mayores(v:vectorContador);
var 
    cant1,m1,cant2,m2,i:integer;
begin
    cant1:=0;
    cant2:=0;
    for i:=1 to dimf do begin
        if(v[i] > cant1) then begin 
            cant2:=cant1;
            m2:=m1;
            cant1:=v[i];
            m1:=i;
        end
        else if (v[i] > cant2) then begin 
            cant2:=v[i];
            m2:=i;
        end;
    end;
    writeln('Los dos codigos de genero mas elegidos son: ',m1,' y ',m2,'.');
end;

procedure agregarAdelante(var l: lista; p: persona);
var 
    nue: lista;
begin 
    new(nue);
    nue^.dato := p;
    nue^.sig := l;
    l := nue;
end;

procedure generarLista(var l:lista; var cantidadPares:integer; var v:vectorContador);
var 
    p:persona;
begin 
    inicializarVector(v);
    cantidadPares:=0;
    repeat
        leerPersona(p);
        if (tieneMasPares(p.dni)) then begin
            cantidadPares := cantidadPares + 1;
        end;
        v[p.codigo]:=v[p.codigo] +1;
        agregarAdelante(l,p);
    until(p.dni = 10);
end;

procedure imprimirLista(l:lista);
begin
    while (l <> nil) do begin
        writeln('DNI: ',l^.dato.dni,' Apellido: ',l^.dato.apellido,' Nombre: ',l^.dato.nombre,' Edad: ',l^.dato.edad,' Codigo: ',l^.dato.codigo);
        l:=l^.sig;
    end;
end;

// c. Realizar un módulo que reciba un DNI, lo busque y lo elimine de la estructura. El DNI puede no
// existir. Invocar dicho módulo en el programa principal.

procedure eliminar(var l:lista; dni:integer);
var
    ant,act:lista;
begin 
    act:=l;
    while (act <> nil) and (act^.dato.dni <> dni) do begin
        ant:=act;
        act:=act^.sig;
    end;
    if (act <> nil) then begin
        if (act = l) then 
            l:=l^.sig
        else 
            ant^.sig:=act^.sig;
        dispose(act);
        writeln('Se elimino la persona con dni: ',dni);
    end
    else 
        writeln('No se encontro la persona con dni: ',dni);
end;

var 
    l:lista;
    cantidadPares:integer;
    v:vectorContador;
begin 
    l:=nil;
    generarLista(l,cantidadPares,v);
    writeln('La cantidad de personas con mas digitos pares que impares es: ',cantidadPares);
    mayores(v);
    imprimirLista(l);
    eliminar(l,10);
end.
