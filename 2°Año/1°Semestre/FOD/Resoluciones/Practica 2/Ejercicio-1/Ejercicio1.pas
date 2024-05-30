{
    1. Una empresa posee un archivo con información de los ingresos percibidos por diferentes
        empleados en concepto de comisión, de cada uno de ellos se conoce: código de empleado,
        nombre y monto de la comisión. La información del archivo se encuentra ordenada por
        código de empleado y cada empleado puede aparecer más de una vez en el archivo de
        comisiones.
        Realice un procedimiento que reciba el archivo anteriormente descrito y lo compacte. En
        consecuencia, deberá generar un nuevo archivo en el cual, cada empleado aparezca una
        única vez con el valor total de sus comisiones.
        NOTA: No se conoce a priori la cantidad de empleados. Además, el archivo debe ser
        recorrido una única vez.
}

program Ejercicio1;

const 
    valorAlto = 9999;

type 
    empleado = record
        cod: integer;
        nom: string[50];
        com: integer;
    end;

    archivo = file of empleado;

procedure leer(var arc: archivo; var reg: empleado);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.cod := valorAlto;
end;

procedure generarDetalle(var arc: archivo; var det: text);
var 
    e: empleado;
begin
    assign(arc, 'listaEmpleados.dat');
    rewrite(arc);
    reset(det);
    while not eof(det) do begin
        readln(det, e.cod, e.com, e.nom);
        write(arc, e);
    end;
    close(arc);
    close(det);
    writeln('Archivo generado');
end;

procedure actualizarMaestro(var mae: archivo; var det: archivo);
var 
    e: empleado;
    reg_det: empleado;
    total: integer;
begin
    rewrite(mae);
    reset(det);
    leer(det, reg_det);
    while reg_det.cod <> valorAlto do begin
        e := reg_det;
        total := 0;
        while (e.cod = reg_det.cod) do begin
            total := total + reg_det.com;
            leer(det, reg_det);
        end;
        e.com := total;
        write(mae, e);
    end;
    close(mae);
    close(det);
end;

var
    mae, det: archivo;
    detTxt: text;
    nombre: string;
begin
    writeln('Ingrese el nombre del archivo de texto con datos de empleados: ');
    readln(nombre);
    assign(detTxt, nombre);

    writeln('Ingrese el nombre del archivo binario compactado: ');
    readln(nombre);
    assign(mae, nombre);

    generarDetalle(det, detTxt);
    
    actualizarMaestro(mae, det);
end.