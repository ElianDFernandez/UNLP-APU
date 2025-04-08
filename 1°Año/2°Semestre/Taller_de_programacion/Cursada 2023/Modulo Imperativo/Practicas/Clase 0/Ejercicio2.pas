//* 2.- Implementar un programa que procese información de propiedades que están a la venta 
//* en una inmobiliaria.  
//* Se pide: 
//* a)  Implementar  un  módulo  para  almacenar  en  una  estructura  adecuada,  las  propiedades 
//* agrupadas por zona. Las propiedades de una misma zona deben quedar almacenadas 
//* ordenadas por tipo de propiedad. Para cada propiedad debe almacenarse el código, el tipo de 
//* propiedad y el precio total. De cada propiedad se lee: zona (1 a 5), código de propiedad, tipo 
//* de  propiedad,  cantidad  de  metros  cuadrados  y  precio  del  metro  cuadrado.  La  lectura  finaliza 
//* cuando se ingresa el precio del metro cuadrado -1. 
//* b)  Implementar  un  módulo  que  reciba  la  estructura  generada  en  a),  un  número  de  zona  y  un  tipo  de 
//* propiedad y retorne los códigos de las propiedades de la zona recibida y del tipo recibido. 

program ej2;

type 
    propiedad = record 
        codigo:integer;
        tipo:string;
        precio:real;
    end; 

    lista = ^nodo;
    nodo = record 
        dato:propiedad;
        sig:lista;
    end;

    vector = array [1..5] of lista;

procedure agregarOrdenado(var l:lista; p:propiedad);
var 
    nue,ant,act:lista;
begin 
    new(nue);
    nue^.dato:=p;
    nue^.sig:=nil;
    
    act:=l;
    while (act <> nil) and (act^.dato.tipo < p.tipo) do begin 
        ant:=act;
        act:=act^.sig;
    end;
    if (act = l) then begin 
        nue^.sig:=nil;
        l:=nue;
    end
    else begin 
        ant^.sig:=nue;
        nue^.sig:=act;
    end;
end;

//* De cada propiedad se lee: zona (1 a 5), código de propiedad, tipo 
//* de  propiedad,  cantidad  de  metros  cuadrados  y  precio  del  metro  cuadrado.  La  lectura  finaliza 
//* cuando se ingresa el precio del metro cuadrado -1. 

procedure leerPropiedad(var p:propiedad);
var 
    metros,precio:real;
begin 
    writeln('Ingrese codigo de la propiedad');
    readln(p.codigo);
    if (p.codigo <> -1) then begin 
        writeln('Ingrese el tipo de propiedad');
        readln(p.tipo);
        writeln('Ingrese la cantidad de metros cuadrados');
        readln(metros);
        writeln('Ingrese el precio del metro cuadrado');
        readln(precio);
        p.precio:=metros*precio;
    end;
end;

procedure inicializarListas(var lz:vector);
var 
    i:integer;
begin 
    for i:=1 to 5 do begin 
        lz[i]:=nil;
    end;
end;

procedure cargarLista(var lz:vector);
var 
    zona:integer;
    p:propiedad;
begin 
    writeln('Ingrese la zona de la propiedad');
    readln(zona);
    leerPropiedad(p);
    while (p.codigo <> -1) do begin 
        agregarOrdenado(lz[zona], p);
        writeln('Ingrese la zona de la propiedad');
        readln(zona);
        leerPropiedad(p);
    end;
end;

//* b)  Implementar  un  módulo  que  reciba  la  estructura  generada  en  a),  un  número  de  zona  y  un  tipo  de 
//* propiedad y retorne los códigos de las propiedades de la zona recibida y del tipo recibido. 

procedure procesar(lz:vector; zona:integer; tipo:string);
begin 
    while (lz[zona] <> nil) do begin 
        writeln('Codigo de propiedad de la zona: ', lz[zona]^.dato.codigo);
        if (lz[zona]^.dato.tipo = tipo) then begin 
            writeln('Codigo de propiedad del tipo recibido: ', lz[zona]^.dato.codigo);
        end;
        lz[zona]:=lz[zona]^.sig;
    end;
end;

var 
    lz:vector;
begin 
    inicializarListas(lz);
    cargarLista(lz);
    procesar(lz,1,'Casa');
end.