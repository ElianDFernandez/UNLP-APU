{
    5. Se cuenta con un archivo de productos de una cadena de venta de alimentos congelados.
        De cada producto se almacena: código del producto, nombre, descripción, stock disponible,
        stock mínimo y precio del producto.
        Se recibe diariamente un archivo detalle de cada una de las 30 sucursales de la cadena. Se
        debe realizar el procedimiento que recibe los 30 detalles y actualiza el stock del archivo
        maestro. La información que se recibe en los detalles es: código de producto y cantidad
        vendida. Además, se deberá informar en un archivo de texto: nombre de producto,
        descripción, stock disponible y precio de aquellos productos que tengan stock disponible por
        debajo del stock mínimo. Pensar alternativas sobre realizar el informe en el mismo
        procedimiento de actualización, o realizarlo en un procedimiento separado (analizar
        ventajas/desventajas en cada caso).
    Nota: todos los archivos se encuentran ordenados por código de productos. En cada detalle
    puede venir 0 o N registros de un determinado producto.
}

program Ejercicio5;

const 
    valorAlto = 999;
    dimf = 3;
type 
    producto = record
        cod: integer;
        nomCom: string;
        descrip: string;
        stockDisp: integer;
        stockMin: integer;
        precio: real;
    end;

    archivo = file of producto;

    ventas = record
        cod: integer;
        cant: integer;
    end;

    archivoDet = file of ventas;

    vectorDet = array[1..dimf] of archivoDet;
    vectorRegDet = array[1..dimf] of ventas;

procedure leer(var arc: archivoDet; var reg: ventas);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.cod := valorAlto;
end;

procedure minimo (var vec: vectorDet; var vecReg: vectorRegDet; var min: ventas);
var 
    i, pos: integer;
begin
    min.cod := valorAlto;
    for i := 1 to dimf do begin 
        if (vecReg[i].cod < min.cod) then begin
            min := vecReg[i];
            pos := i;
        end
    end;
    if (min.cod <> valorAlto) then
        leer(vec[pos],vecReg[pos]);
end;

procedure actualizarMaestro (var mae: archivo; var vecDet: vectorDet);
var 
    regM: producto;
    min: ventas;
    vecReg: vectorRegDet;
    aux: producto;
    reporte: text;
    i: integer;
begin
    reset(mae);
    assign(reporte,'reporteOnline.txt');
    rewrite(reporte);
    for i := 1 to dimf do begin
        reset(vecDet[i]);
        leer(vecDet[i],vecReg[i]);
    end;
    minimo(vecDet,vecReg,min);
    while (min.cod <> valorAlto) do begin
        aux.cod := min.cod;
        aux.stockDisp := 0;
        while (min.cod <> valorAlto) and (aux.cod = min.cod) do begin
            aux.stockDisp := aux.stockDisp - min.cant; { uso stockDisp para saber la cantidad vendida }
            minimo(vecDet,vecReg,min);
        end;
        read(mae,regM);
        while (regM.cod <> aux.cod) do
            read(mae,regM);
        regM.stockDisp := regM.stockDisp - aux.stockDisp;
        writeln(reporte,regM.nomCom,' ',regM.descrip,' ',regM.stockDisp,' ',regM.precio:0:2);
        seek(mae,filepos(mae) - 1);
        write(mae,regM);
    end;
    for i := 1 to dimf do
        close(vecDet[i]);
    close(mae);
    close(reporte);
end;

procedure reporteOffline (var mae: archivo);
var 
    regM: producto;
    reporte: text;
begin
    reset(mae);
    assign(reporte,'reporteOffline.txt');
    rewrite(reporte);
    while not eof(mae) do begin
        read(mae,regM);
        writeln(reporte, regM.nomCom,' ',regM.descrip,' ',regM.stockDisp,' ',regM.precio:0:2);
    end;
    close(mae);
    close(reporte);
end;

{ Procedimiento de pruebas }

procedure crearUnDet(var det: archivoDet; num: integer);
var 
    reg: ventas;
    detTxt: text;
    nombre: string;
begin 
    writeln ('Ingrese el nombre para el archivo detalle ' , num , ': ');
    readln (nombre);
    assign(detTxt, nombre);
    writeln ('Ingrese el nombre para el archivo binario detalle ' , num , ': ');
    readln(nombre);
    assign(det,nombre);
    rewrite(det);
    reset(detTxt);
    while not eof(detTxt) do begin 
        readln(detTxt,reg.cod,reg.cant);
        write(det,reg);
    end;
    close(det);
    close(detTxt);
end;

procedure crearVectorDet (var vec: vectorDet);
var 
    i: integer;
begin
    for i := 1 to dimf do begin
        crearUnDet(vec[i],i);
    end;
end;

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
        readln(arcTxt, reg.cod, reg.precio, reg.stockDisp, reg.stockMin, reg.nomCom);
        readln(arcTxt, reg.descrip);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

var 
    mae: archivo;
    vecDet: vectorDet;
    i: integer;
begin
    crearMaestro(mae);
    crearVectorDet(vecDet);
    actualizarMaestro(mae,vecDet);
    reporteOffline(mae);
end.