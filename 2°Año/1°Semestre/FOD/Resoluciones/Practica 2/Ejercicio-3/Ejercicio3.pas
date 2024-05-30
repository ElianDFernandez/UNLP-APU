{
    3. El encargado de ventas de un negocio de productos de limpieza desea administrar el stock
        de los productos que vende. Para ello, genera un archivo maestro donde figuran todos los
        productos que comercializa. De cada producto se maneja la siguiente información: código de
        producto, nombre comercial, precio de venta, stock actual y stock mínimo. Diariamente se
        genera un archivo detalle donde se registran todas las ventas de productos realizadas. De
        cada venta se registran: código de producto y cantidad de unidades vendidas. Se pide
        realizar un programa con opciones para:
    a. Actualizar el archivo maestro con el archivo detalle, sabiendo que:
        ● Ambos archivos están ordenados por código de producto.
        ● Cada registro del maestro puede ser actualizado por 0, 1 ó más registros del
            archivo detalle.
        ● El archivo detalle sólo contiene registros que están en el archivo maestro.
    b. Listar en un archivo de texto llamado “stock_minimo.txt” aquellos productos cuyo
        stock actual esté por debajo del stock mínimo permitido.
}

program Ejercicio3;

const 
    valorAlto = 9999;
type 
    producto = record
        cod: integer;
        nomCom: string;
        precio: real;
        stockAct: integer;
        stockMin: integer;
    end;

    archivo = file of producto;

    venta = record
        cod: integer;
        cant: integer;
    end;

    archivoDet = file of venta;

procedure leer(var arc: archivoDet; var reg: venta);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.cod := valorAlto;
end;

procedure actualizarMaestro(var mae: archivo; var det: archivoDet);
var 
    regM: producto;
    regD: venta;
    aux: producto;
begin
    reset(mae);
    reset(det);
    leer(det, regD);
    read(mae, regM);
    while (regD.cod <> valorAlto) do begin
        aux.cod := regD.cod;
        aux.stockAct := 0; { Uso stockAct como variable auxiliar para suma ventas } 
        while (aux.cod = regD.cod) do begin
            aux.stockAct := aux.stockAct + regD.cant;
            leer(det, regD);
        end; 
        while (regM.cod <> aux.cod) do
            read(mae, regM);
        regM.stockAct := regM.stockAct - aux.stockAct; { stockAct = cant de stock vendido } 
        seek(mae, filepos(mae) - 1);
        write(mae, regM);
        if not eof(mae) then
            read(mae, regM);
    end;
    close(mae);
    close(det);
end;

procedure exportar(var arc:archivo);
var 
    prod: producto;
    nuevoArc: text;
begin
    assign(nuevoArc, 'stock_minimo.txt');
    rewrite(nuevoArc);
    reset(arc);
    while not eof(arc) do begin
        read(arc, prod);
        if (prod.stockAct < prod.stockMin) then  
            writeln(nuevoArc, prod.cod, ' ', prod.nomCom, ' ', prod.precio:0:2, ' ', prod.stockAct, ' ', prod.stockMin); 
    end;
    close(nuevoArc);
    close(arc);
end;

{ Procedimientos para pruebas }

procedure crearMaestro(var arc: archivo);
var 
    reg: producto;
    arcTxt: text;
begin
    assign(arc, 'maestro.dat');
    assign(arcTxt, 'maestro.txt');
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, reg.cod, reg.precio, reg.stockAct, reg.stockMin, reg.nomCom);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

procedure crearDetalle(var arc: archivoDet);
var 
    reg: venta;
    arcTxt: text;
begin
    assign(arc, 'detalle.dat');
    assign(arcTxt, 'detalle.txt');
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, reg.cod, reg.cant);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

procedure imprimir(var arc: archivo);
var 
    reg: producto;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, reg);
        writeln('Nombre: ' , reg.nomCom, ' Codigo: ', reg.cod, ' Precio: ', reg.precio:0:2, ' Stock: ', reg.stockAct, ' Stock minimo: ', reg.stockMin);
    end;
    close(arc);
end;

{ Programa principal }
var 
    mae: archivo;
    det: archivoDet;
begin
    crearMaestro(mae);
    crearDetalle(det);
    actualizarMaestro(mae, det);
    exportar(mae);
    imprimir(mae);
end.
