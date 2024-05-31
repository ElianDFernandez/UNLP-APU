{
    8. Se cuenta con un archivo que posee información de las ventas que realiza una empresa a
    los diferentes clientes. Se necesita obtener un reporte con las ventas organizadas por
    cliente. Para ello, se deberá informar por pantalla: los datos personales del cliente, el total
    mensual (mes por mes cuánto compró) y finalmente el monto total comprado en el año por el
    cliente. Además, al finalizar el reporte, se debe informar el monto total de ventas obtenido
    por la empresa.
    El formato del archivo maestro está dado por: cliente (cod cliente, nombre y apellido), año,
    mes, día y monto de la venta. El orden del archivo está dado por: cod cliente, año y mes.
    Nota: tenga en cuenta que puede haber meses en los que los clientes no realizaron
    compras. No es necesario que informe tales meses en el reporte.
}

program Ejercicio8;
const 
    valorAlto = 9999;
type 
    cliente = record
        cod: integer;
        nom: string;
        ape: string;
    end;

    venta = record
        cli: cliente;
        anio: integer;
        mes: integer;
        dia: integer;
        monto: real;
    end;

    archivo = file of venta;

procedure leer(var arc: archivo; var reg: venta);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.cli.cod := valorAlto;
end;

procedure informeMaestro(var arc: archivo);
var 
    reg: venta;
    cod: integer;
    mes: integer;
    anio: integer;
    totalMes: real;
    totalAnio: real;
    totalEmpresa: real;
begin 
    reset(arc);
    leer(arc,reg);
    totalEmpresa:=0;
    while (reg.cli.cod <> valorAlto) do begin 
        writeln('Cliente Cod: ', reg.cli.cod, ' Nombre: ', reg.cli.nom);
        cod:= reg.cli.cod;
        while (cod = reg.cli.cod) do begin 
            totalAnio:=0;
            anio:=reg.anio;
            while (cod = reg.cli.cod) and (anio = reg.anio) do begin
                totalMes:=0;
                mes:=reg.mes;
                while (cod = reg.cli.cod) and (anio = reg.anio) and (mes = reg.mes) do begin
                    totalMes:=totalMes+reg.monto;
                    leer(arc,reg);
                end;
                writeln('Mes: ', mes, ' Monto: ', totalMes:0:2);
                totalAnio:=totalAnio+totalMes;
            end;
            writeln('Anio: ', anio, ' Monto: ', totalAnio:0:2);
            totalEmpresa:=totalEmpresa+totalAnio;
        end;
    end;
    writeln('Total empresa: ', totalEmpresa:0:2);
end;

{ Procedimientos de pruebas }
procedure crearMaestro(var arc:archivo);
var 
    nombre: string;
    arcTxt: text;
    reg: venta;
begin 
    writeln('Ingrese el nombrre del archivo txt maestro');
    readln(nombre);
    assign(arcTxt, nombre);
    writeln('Ingrese el nombrre del archivo bin maestro');
    readln(nombre);
    assign(arc, nombre);
    rewrite(arc);
    reset(arcTxt);
    while not eof(arcTxt) do begin 
        readln(arcTxt, reg.cli.cod, reg.anio, reg.mes, reg.dia, reg.monto, reg.cli.ape);
        readln(arcTxt, reg.cli.nom);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

{ Programa Principal }
var
    arc: archivo;
begin
    crearMaestro(arc);
    informeMaestro(arc);
end.

