// Implementar un programa que lea y almacene información de clientes de una empresa aseguradora
// automotriz. De cada cliente se lee: código de cliente, DNI, apellido, nombre, código de póliza
// contratada (1..6) y monto básico que abona mensualmente. La lectura finaliza cuando llega el cliente
// con código 1122, el cual debe procesarse.
// La empresa dispone de una tabla donde guarda un valor que representa un monto adicional que el
// cliente debe abonar en la liquidación mensual de su seguro, de acuerdo al código de póliza que tiene
// contratada.
// Una vez finalizada la lectura de todos los clientes, se pide:
// a. Informar para cada cliente DNI, apellido, nombre y el monto completo que paga mensualmente
// por su seguro automotriz (monto básico + monto adicional).
// b. Informar apellido y nombre de aquellos clientes cuyo DNI contiene al menos dos dígitos 9.
// c. Realizar un módulo que reciba un código de cliente, lo busque (seguro existe) y lo elimine de la
// estructura.

program ejercicio2; 

type 
    cliente = record 
        codigo:integer;
        dni:integer;
        apellido:string;
        nombre:string;
        codigoPoliza:1..6;
        monto:real;
    end;

    lista = ^nodo;
    nodo = record 
        dato:cliente;
        sig:lista;
    end;

    vector = array [1..6] of real;

procedure leerCliente(var c:cliente);
begin
    writeln('Ingrese codigo del cliente: ');
    readln(c.codigo);
    writeln('Ingrese DNI: ');
    readln(c.dni);
    writeln('Ingrese Apellido: ');
    readln(c.apellido);
    writeln('Ingrese Nombre: ');
    readln(c.nombre);
    writeln('Codigo de Poliza: ');
    readln(c.codigoPoliza);
    writeln('Monto mensual: ');
    readln(c.monto);
end;

procedure agregarAdelante(var l:lista; c:cliente);
var 
    nue:lista;
begin 
    new(nue);
    nue^.dato:=c;
    nue^.sig:=l;
    l:=nue;
end;

function contieneAlmenosDos9(dni:integer):boolean;
var 
    dig:integer;
    contador:integer;
begin 
    contador:=0;
    while(dni <> 0) do begin 
        dig:= dni MOD 10;
        if (dig = 9) then 
            contador:= contador +1;
        dni:= dni DIV 10;
    end;
    contieneAlmenosDos9:= contador >= 2;
end;

procedure generarLista(var l:lista);
var 
    c:cliente;
begin 
    repeat
        leerCliente(c);
        agregarAdelante(l,c);
    until (c.codigo = 1122);
end;

procedure procesarLista(l:lista; montos:vector);
begin 
    while (l <> nil) do begin 
        writeln('Cliente DNI: ', l^.dato.dni, ' Nombre: ', l^.dato.nombre, ' Abona: ', l^.dato.monto + montos[l^.dato.codigoPoliza]:1:2);
        if (contieneAlmenosDos9(l^.dato.dni)) then
            writeln('Este cliente contiene mas de 2 9 en su DNI');
        l:=l^.sig;
    end;
end;

procedure buscarEliminar(var l:lista; c:integer);
var 
    ant,act:lista;
begin 
    act:=l;
    while (act <> nil) and (act^.dato.codigo <> c) do begin 
        ant:=act;
        act:=act^.sig;
    end;
    if (act <> nil) and (act^.dato.codigo = c) then begin
        if (act = l) then  
            l:=l^.sig
        else  
            ant^.sig:=act^.sig;
        dispose(act);
        writeln('Codigo Eliminado');
    end;
end;

procedure imprimirLista(l:lista);
begin   
    while (l <> nil) do begin
        writeln('DNI: ',l^.dato.dni,' Apellido: ',l^.dato.apellido,' Nombre: ',l^.dato.nombre);
        l:=l^.sig;
    end;
end;

var 
    l:lista;
    montos:vector;
    i:integer;
    codigo:integer;
begin 
    l:=nil;
    generarLista(l);
    for i:=1 to 6 do 
        montos[i]:=i;
    procesarLista(l,montos);
    writeln('Lista antes de eliminar: ');
    imprimirLista(l);
    writeln('Codigo a Eliminar: ');
    readln(codigo);
    buscarEliminar(l,codigo);
    writeln('Lista Despues de eliminar: ');
    imprimirLista(l);
end.