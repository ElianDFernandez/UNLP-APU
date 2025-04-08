//* 3.- Implementar un programa que procese las ventas de un supermercado. El supermercado 
//* dispone de una tabla con los precios y stocks de los 1000 productos que tiene a la venta. 
//* a) Implementar un módulo que retorne, en una estructura de datos adecuada, los  tickets de las ventas. 
//* De  cada  venta  se  lee  código  de  venta  y  los  productos  vendidos.  Las  ventas  finalizan  con  el  código  de 
//* venta -1. De cada producto se lee código y cantidad de unidades solicitadas. Para cada venta, la lectura 
//* de los productos a vender finaliza con cantidad de unidades vendidas igual a 0. 
//* El ticket debe contener: 
//*   - Código de venta 
//*   - Detalle (código de producto, cantidad y precio unitario) de los productos que se pudieron vender. En caso de no haber stock suficiente, se venderá la máxima cantidad posible. 
//*   - Monto total de la venta. 
//* b)  Implementar  un  módulo  que  reciba  la  estructura  generada  en  el  inciso  a)  y  un  código  de 
//* producto y retorne la cantidad de unidades vendidas de ese código de producto. 

program super;

uses crt;

type 
    producto = record 
        codigo: integer;
        cantidad: integer;
        precio: real;
    end;

    listaP = ^nodoP;
    nodoP = record 
        dato: producto;
        sig: listaP;
    end;

    venta = record 
        codigo: integer;
        productos: listaP;
        total: real;
    end;

    listaV = ^nodoV;
    nodoV = record 
        dato: venta;
        sig: listaV;
    end;

    inventario = record 
        codigo: integer;
        stock: integer;
        precio: real;
    end;

    vInventario = array [1..1000] of inventario;

procedure inicializarInventario(var stockInventario: vInventario);
var
    i: integer;
begin
    randomize;
    for i := 1 to 1000 do
    begin
        stockInventario[i].codigo := i;
        stockInventario[i].stock := random(100) + 1;
        stockInventario[i].precio := random(5000) / 100 + 1;
    end;
end;

procedure leerProducto(var p: producto);
begin   
    writeln('Ingrese codigo del producto:');
    readln(p.codigo);
    if p.codigo <> 0 then
    begin
        writeln('Ingrese la cantidad vendida:');
        readln(p.cantidad);
    end
    else
        p.cantidad := 0;
end;

procedure agregarAdelanteP(var lp: listaP; p: producto);
var 
    nue: listaP;
begin
    new(nue);
    nue^.dato := p;
    nue^.sig := lp;
    lp := nue;
end;

procedure agregarAdelanteV(var lv: listaV; v: venta);
var 
    nue: listaV;
begin 
    new(nue);
    nue^.dato := v;
    nue^.sig := lv;
    lv := nue;
end;

procedure imprimirTicket(v: venta);
var
    lp: listaP;
begin
    writeln('Ticket de venta - Codigo: ', v.codigo);
    writeln('-----------------------------------');
    lp := v.productos;
    while lp <> nil do
    begin
        writeln('Producto: ', lp^.dato.codigo, ' Cantidad: ', lp^.dato.cantidad, ' Precio: ', lp^.dato.precio:0:2);
        lp := lp^.sig;
    end;
    writeln('Total de la venta: ', v.total:0:2);
    writeln('-----------------------------------');
end;

procedure cargarProductos(var lp: listaP; var total: real; stockInventario: vInventario);
var 
    p: producto;
begin 
    lp := nil;
    total := 0;
    leerProducto(p);
    while (p.codigo <> 0) do
    begin 
        if (stockInventario[p.codigo].stock >= p.cantidad) then
        begin
            stockInventario[p.codigo].stock := stockInventario[p.codigo].stock - p.cantidad;
        end
        else
        begin
            p.cantidad := stockInventario[p.codigo].stock;
            stockInventario[p.codigo].stock := 0;
        end;
        p.precio := stockInventario[p.codigo].precio;
        total := total + (p.cantidad * p.precio);
        agregarAdelanteP(lp, p);
        leerProducto(p);
    end;
end;

procedure cargarVentas(var lv: listaV; stockInventario: vInventario);
var 
    v: venta;
begin 
    lv := nil;
    writeln('Ingrese el codigo de venta: ');
    readln(v.codigo);
    while (v.codigo <> -1) do
    begin 
        cargarProductos(v.productos, v.total, stockInventario);
        agregarAdelanteV(lv, v);
        imprimirTicket(v);
        writeln('Ingrese el codigo de venta: ');
        readln(v.codigo);
    end;
end;

function cantidadVendida(lv: listaV; codigoProducto: integer): integer;
var
    lp: listaP;
    total: integer;
begin
    total := 0;
    while (lv <> nil) do
    begin
        lp := lv^.dato.productos;
        while (lp <> nil) do
        begin
            if lp^.dato.codigo = codigoProducto then
                total := total + lp^.dato.cantidad;
            lp := lp^.sig;
        end;
        lv := lv^.sig;
    end;
    cantidadVendida := total;
end;

var 
    lv: listaV;
    stockInventario: vInventario;
    codigoProducto: integer;
begin
    lv := nil;
    inicializarInventario(stockInventario);
    cargarVentas(lv, stockInventario);
    writeln('Ingrese el codigo del producto para consultar cantidad vendida:');
    readln(codigoProducto);
    writeln('Cantidad total vendida: ', cantidadVendida(lv, codigoProducto));
end.


