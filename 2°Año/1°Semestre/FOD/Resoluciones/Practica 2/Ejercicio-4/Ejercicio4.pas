{
    4. A partir de información sobre la alfabetización en la Argentina, se necesita actualizar un
        archivo que contiene los siguientes datos: nombre de provincia, cantidad de personas
        alfabetizadas y total de encuestados. Se reciben dos archivos detalle provenientes de dos
        agencias de censo diferentes, dichos archivos contienen: nombre de la provincia, código de
        localidad, cantidad de alfabetizados y cantidad de encuestados. Se pide realizar los módulos
        necesarios para actualizar el archivo maestro a partir de los dos archivos detalle.
        NOTA: Los archivos están ordenados por nombre de provincia y en los archivos detalle
        pueden venir 0, 1 ó más registros por cada provincia
}

program Ejercicio4;

const 
    valorAlto = 'zzz';

type
    alfabetizados = record
        provincia: string;
        cantAlf: integer;
        cantEnc: integer;
    end;

    archivo = file of alfabetizados;

    encuestados = record
        provincia: string;
        codLoc: integer;
        cantAlf: integer;
        cantEnc: integer;
    end;

    archivoDet = file of encuestados;

procedure leer (var arc: archivoDet; var reg: encuestados);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.provincia := valorAlto;
end;

procedure minimo (var arc1,arc2: archivoDet; var regd1,regd2,min: encuestados);
begin 
    if (regd1.provincia <= regd2.provincia) then begin 
        min := regd1;
        leer(arc1,regd1);
    end
    else begin
        min := regd2;
        leer(arc2,regd2);
    end;
end;

procedure actualizarMaestro (var mae: archivo; var det1,det2: archivoDet);
var
    regM: alfabetizados;
    regD1: encuestados;
    regD2: encuestados;
    min: encuestados;
begin
    reset(mae);
    reset(det1);
    reset(det2);
    leer(det1,regD1);
    leer(det2,regD2);
    minimo(det1,det2,regD1,regD2,min);
    while (min.provincia <> valorAlto) do begin
        read(mae,regM);
        while (regM.provincia <> min.provincia) do { Primero busco en el mastro la provincia procesada }
            read(mae,regM);
        while (regM.provincia = min.provincia) do begin { Luego actualizo los registros de esa provincia mientras sea la misma }
            regM.cantAlf := regM.cantAlf + min.cantAlf;
            regM.cantEnc := regM.cantEnc + min.cantEnc;
            minimo(det1,det2,regD1,regD2,min);
        end;
        seek(mae,filepos(mae) - 1);
        write(mae,regM);
    end;
    close(mae);
    close(det1);
    close(det2);
end;

{ Procedimientos de pruebas}

procedure crearMaestro(var arc: archivo);
var 
    reg: alfabetizados;
    arcTxt: text;
begin
    assign(arc, 'maestro.dat');
    assign(arcTxt, 'maestro.txt');
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, reg.cantAlf, reg.cantEnc, reg.provincia);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

procedure crearDetalle1(var arc: archivoDet);
var 
    reg: encuestados;
    arcTxt: text;
begin
    assign(arc, 'detalle1.dat');
    assign(arcTxt, 'detalle1.txt');
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, reg.cantAlf, reg.cantEnc, reg.codLoc, reg.provincia);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

procedure crearDetalle2(var arc: archivoDet);
var 
    reg: encuestados;
    arcTxt: text;
begin
    assign(arc, 'detalle2.dat');
    assign(arcTxt, 'detalle2.txt');
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, reg.cantAlf, reg.cantEnc, reg.codLoc, reg.provincia);
        write(arc, reg);
    end;
    close(arc);
    close(arcTxt);
end;

procedure imprimir(var arc: archivo);
var 
    reg: alfabetizados;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, reg);
        writeln('Provincia: ', reg.provincia, ' Cantidad de alfabetizados: ', reg.cantAlf, ' Cantidad de encuestados: ', reg.cantEnc);
    end;
    close(arc);
end;

var 
    mae: archivo;
    det1, det2: archivoDet;
begin
    crearMaestro(mae);
    crearDetalle1(det1);
    crearDetalle2(det2);
    actualizarMaestro(mae, det1, det2);
    imprimir(mae);
end.