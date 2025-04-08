//* 2. Escribir un programa que:

//* a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee
//* código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de
//* producto 0. Un producto puede estar en más de una venta. Se pide:
//*  i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
//*  producto.
//*  ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
//*  código de producto. Cada nodo del árbol debe contener el código de producto y la
//*  cantidad total de unidades vendida.
//*  Nota: El módulo debe retornar los dos árboles.

//* b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne
//* la cantidad total de unidades vendidas de ese producto.

//* c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne
//* la cantidad total de unidades vendidas de ese producto.

program ejercicio2;

type 
    venta=record 
        codigoProducto:integer;
        fecha:string;
        cantidadUnidades:integer;
    end;
    producto=record 
        codigo:integer;
        cantidadVendida:integer;
    end;

    arbolVentas=^nodoVentas;
    nodoVentas=record
        dato:venta;
        HI:arbolVentas;
        HD:arbolventas;
    end;

    arbolProd=^nodoProd;
    nodoProd=record
        dato:producto;
        HI:arbolProd;
        HD:arbolProd;
    end;

procedure leerVenta(var v:venta);
begin 
    writeln('Ingrese codigo del producto vendido: ');
    readln(v.codigoProducto);
    if (v.codigoProducto <> 0) then begin 
        writeln('Ingrese fecha de la venta: ');
        readln(v.fecha);
        writeln('Ingrese la cantiad de unidades vendidades: ');
        readln(v.cantidadUnidades);
    end;
end;

procedure agregarNodoArbolVentas(var a:arbolventas; v:venta);
var 
    nue:arbolventas;
begin 
    if (a=nil) then begin
        new(nue);
        nue^.dato:=v;
        nue^.HI:=nil;
        nue^.HD:=nil;
    end 
    else if (v.codigoProducto <= a^.dato.codigoProducto) then 
        agregarNodoArbolVentas(a^.HI,v)
    else
        agregarNodoArbolVentas(a^.HD,v);
end;

procedure agregarNodoArbolProductos(var a:arbolProd; v:venta);
var 
    nue:arbolProd;
    prod:producto;
begin 
    if (a=nil) then begin
        prod.codigo:= v.codigoProducto;
        prod.cantidadVendida:= v.cantidadUnidades;
        new(nue);
        nue^.dato:=prod;
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end 
    else if (v.codigoProducto = a^.dato.codigo) then 
        a^.dato.cantidadVendida:= a^.dato.cantidadVendida + v.cantidadUnidades
    else if (v.codigoProducto < a^.dato.codigo) then 
        agregarNodoArbolProductos(a^.HI,v)
    else
        agregarNodoArbolProductos(a^.HD,v);
end;


procedure cargarArbolVentas(var av:arbolVentas; var ap:arbolProd);
var 
    v:venta;
begin 
    leerVenta(v);
    while (v.codigoProducto <> 0) do begin 
        agregarNodoArbolVentas(av,v);
        agregarNodoArbolProductos(ap,v);
        leerVenta(v);
    end;
end;


//* b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne
//* la cantidad total de unidades vendidas de ese producto.

function cantidadVendidaProd(ap:arbolProd; codigo:integer):integer;
begin 
    if (ap = nil) then
        cantidadVendidaProd:=0
    else if (ap^.dato.codigo = codigo) then 
        cantidadVendidaProd:=ap^.dato.cantidadVendida
    else if (ap^.dato.codigo < codigo) then 
        cantidadVendidaProd:=cantidadVendidaProd(ap^.HD,codigo)
    else 
        cantidadVendidaProd:=cantidadVendidaProd(ap^.HI,codigo);
end;


var 
    av:arbolVentas;
    ap:arbolProd;
begin 
    av:=nil;
    ap:=nil;
    cargarArbolVentas(av,ap);
    writeln('Cantidad vendida del producto con codigo 10: ', cantidadVendidaProd(ap,10));
end.