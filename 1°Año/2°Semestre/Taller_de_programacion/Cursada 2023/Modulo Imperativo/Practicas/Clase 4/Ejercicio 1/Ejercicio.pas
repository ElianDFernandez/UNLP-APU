//* 1.Implementar un programa modularizado para una librería que:
//* a. Almacene los productos vendidos en una estructura eficiente para la búsqueda por código de producto. De cada producto deben quedar almacenados la cantidad total de
//*     unidades vendidas y el monto total. De cada venta se lee código de venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las
//*     ventas finaliza cuando se lee el código de venta -1.
//* b. Imprima el contenido del árbol ordenado por código de producto.
//* c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el código de producto con mayor cantidad de unidades vendidas.
//* d. Contenga un módulo que reciba la estructura generada en el punto a y un código de producto y retorne la cantidad de códigos menores que él que hay en la estructura.
//* e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de producto y retorne el monto total entre todos los códigos de productos comprendidos
//*     entre los dos valores recibidos (sin incluir)

program ejercicio4;

type 
    venta=record 
        codigoV:integer;
        codigoP:integer;
        unidades:integer;
        precioUnitario:real;
    end;

    producto=record 
        codigoP:integer;
        unidadesV:integer;
        montoT:real;
    end;

    arbol=^nodo;
    nodo=record 
        dato:producto;
        HI:arbol;
        HD:arbol;
    end;

procedure leerVenta(var v:venta);
begin 
    writeln('Ingrese el codigo de la venta: ');
    readln(v.codigoV);
    if (v.codigoV <> -1) then begin 
        writeln('Ingrese el codigo del producto vendido: ');
        readln(v.codigoP);
        writeln('Ingrese la cantidad de unidades vendidas: ');
        readln(v.unidades);
        writeln('Ingrese el precio unitario del producto: ');
        readln(v.precioUnitario);
    end;
end;

procedure agregarNodo(var a:arbol; v:venta);
var 
    nue:arbol;
    p:producto;
begin  
    if (a = nil) then begin 
        p.codigoP:=v.codigoP;
        p.unidadesV:=v.unidades;
        p.montoT:=v.unidades * v.precioUnitario;
        new(nue);
        nue^.dato := p;
        nue^.HI := nil;
        nue^.HD := nil;
        a:=nue;
        writeln('Producto cargado codigo: ',p.codigoP,' Unidades: ',p.unidadesV,' Monto Total: $',p.montoT:0:2);
    end
    else if (a^.dato.codigoP = v.codigoP) then begin
        a^.dato.unidadesV:=a^.dato.unidadesV+v.unidades;
        a^.dato.montoT:=a^.dato.montoT+(v.unidades * v.precioUnitario);
        writeln('Producto actualizado. Codigo: ',a^.dato.codigoP,' Unidades: ',a^.dato.unidadesV,' Monto Total: $',a^.dato.montoT:0:2);
    end
    else if (a^.dato.codigoP < v.codigoP) then 
        agregarNodo(a^.HI,v)
    else 
        agregarNodo(a^.HD,v);
end;

procedure cargarArbol(var a:arbol);
var 
    v:venta;
begin 
    leerVenta(v);
    while (v.codigoV <> -1 ) do begin   
        agregarNodo(a,v);
        leerVenta(v);
    end;
end;

//* b. Imprima el contenido del árbol ordenado por código de producto.

procedure imprimirArbol(a:arbol);
begin 
    if (a <> nil) then begin 
        imprimirArbol(a^.HI);
        writeln('Producto #', a^.dato.codigoP);
        writeln('Unidades vendidas: ', a^.dato.unidadesV);
        writeln('Monto: $',a^.dato.montoT:0:2);
        writeln('-------------------------------');
        imprimirArbol(a^.HD);
    end;
end;

//* c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el código de producto con mayor cantidad de unidades vendidas.

procedure maxUnidadesVendidas(a:arbol; var codigoMax:integer; var maxUnidades:integer);
begin 
    if (a <> nil) then begin 
        if (a^.dato.unidadesV > maxUnidades) then begin 
            codigoMax:= a^.dato.codigoP;
            maxUnidades:= a^.dato.unidadesV;
        end;
        maxUnidadesVendidas(a^.HI,codigoMax,maxUnidades);
        maxUnidadesVendidas(a^.HD,codigoMax,maxUnidades);
    end;
end;

//* d. Contenga un módulo que reciba la estructura generada en el punto a y un código de producto y retorne la cantidad de códigos menores que él que hay en la estructura.
function menores(a:arbol; codigo:integer):integer;
begin 
    if (a = nil) then 
        menores := 0
    else if (a^.dato.codigoP < codigo) then 
        menores := menores(a^.HI,codigo) + menores(a^.HD,codigo) + 1
    else
        menores := menores(a^.HI,codigo);
end;

//* e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de producto y retorne el monto total entre todos los códigos de productos comprendidos
//*     entre los dos valores recibidos (sin incluir)
function montoTotal(a:arbol; codigo1:integer; codigo2:integer):real;
begin 
    if (a = nil) then 
        montoTotal:=0
    else if (a^.dato.codigoP > codigo1) and (a^.dato.codigoP < codigo2) then 
        montoTotal:=a^.dato.montoT + montoTotal(a^.HI,codigo1,codigo2) + montoTotal(a^.HD,codigo1,codigo2)
    else if (a^.dato.codigoP < codigo1) then
        montoTotal:=montoTotal(a^.HI,codigo1,codigo2)
    else 
        montoTotal:=montoTotal(a^.HD,codigo1,codigo2);
end;

var 
    a:arbol;
    codigoMax:integer;
    maxUnidades:integer;
begin 
    a:=nil;
    cargarArbol(a);
    imprimirArbol(a);
    codigoMax:=0;
    maxUnidades:=0;
    maxUnidadesVendidas(a,codigoMax,maxUnidades);
    writeln('Codigo del producto con mas unidades vendidas: ', codigoMax);
    writeln('Cantidad de codigos menores a 5: ',menores(a,5));
    writeln('Monto total entre los codigos 3 y 7: $',montoTotal(a,3,7):0:2);
end.