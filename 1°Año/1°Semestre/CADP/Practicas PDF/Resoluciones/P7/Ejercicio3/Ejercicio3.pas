// 3. Una remisería dispone de información acerca de los viajes realizados durante el mes de mayo de
// 2020. De cada viaje se conoce: número de viaje, código de auto, dirección de origen, dirección de
// destino y kilómetros recorridos durante el viaje. Esta información se encuentra ordenada por código
// de auto y para un mismo código de auto pueden existir 1 o más viajes. Se pide:
// a. Informar los dos códigos de auto que más kilómetros recorrieron.
// b. Generar una lista nueva con los viajes de más de 5 kilómetros recorridos, ordenada por número
// de viaje

program ejercicio3;

type 
    viaje = record 
        numero:integer;
        codigoAuto:integer;
        origen:string;
        destino:String;
        km:real;
    end;

    lista = ^nodo;
    nodo = record 
        dato:viaje;
        sig:lista;
    end;

procedure leerViaje(var v:viaje);
begin 
    writeln('Ingrese numero del viaje:  ');
    readln(v.numero);
    if (v.numero <> 0) then begin 
        writeln('Codigo del auto: ');
        readln(v.codigoAuto);
        writeln('DIreccion de origen: ');
        readln(v.origen);
        writeln('Direccion de destino: ');
        readln(v.destino);
        writeln('Kilometros: ');
        readln(v.km);
    end;
end;

procedure agregarOrdenado(var l:lista; v:viaje);
var 
    ant,act,nue:lista;
begin 
    new(nue);
    nue^.dato:=v;
    nue^.sig:=nil;
    act:=l;
    while (act <> nil) and (act^.dato.codigoAuto > v.codigoAuto) do begin 
        ant:=act;
        act:=act^.sig;
    end;
    if (act = l) then begin
        nue^.sig:=l;
        l:=nue;
    end
    else begin 
        ant^.sig:=nue;
        nue^.sig:=act;
    end;
end;

procedure generarLista(var l:lista);
var 
    v:viaje;
begin
    leerViaje(v);
    while(v.numero <> 0) do begin 
        agregarOrdenado(l,v);
        leerViaje(v);
    end;
end;

procedure maximos(var max1,max2:real; var cod1,cod2:integer; km:real; cod:integer);
begin 
    if (km > max1) then begin 
        max2:=max1;
        cod2:=cod1;
        max1:=km;
        cod1:=cod;
    end
    else if (km > max2) then begin 
        max2:=km;
        cod2:=cod;
    end;
end;

procedure procesarLista(l:lista; var l2:lista);
var 
    act:lista;
    contadorKm:real;
    max1,max2:real;
    cod1,cod2:integer;
begin 
    max1:=0;
    max2:=0;
    cod1:=0;
    cod2:=0;
    l2:=nil;
    while (l <> nil) do begin 
        act := l;
        contadorKm:=0;
        while (l <> nil) and (act^.dato.codigoAuto = l^.dato.codigoAuto) do begin 
            contadorKm:=contadorKm+act^.dato.km;
            if (l^.dato.km > 5) then 
                agregarOrdenado(l2,l^.dato);
            l:=l^.sig;
        end;
        maximos(max1,max2,cod1,cod2,contadorKm,act^.dato.codigoAuto);
    end;
    writeln('Auto 1 mas kilometros: ', cod1);
    writeln('Auto 2 mas kilometros: ', cod2);
end;

procedure imprimirLista(l:lista);
begin
    while (l<>nil) do begin 
        writeln('Numero de viaje: ',l^.dato.numero,' Codigo de auto: ',l^.dato.codigoAuto,' Origen: ',l^.dato.origen,' Destino: ',l^.dato.destino,' Kilometros: ',l^.dato.km:1:2);
        l:=l^.sig;
    end;
end;

var
    l,l2:lista;
begin 
    l:=nil;
    generarLista(l);
    writeln('Lista Generada');
    writeln('---------------');
    imprimirLista(l);
    writeln('---------------');
    procesarLista(l,l2);
    writeln('Lista 2 Generada');
    writeln('---------------');
    imprimirLista(l2);
    writeln('---------------');
end.
 