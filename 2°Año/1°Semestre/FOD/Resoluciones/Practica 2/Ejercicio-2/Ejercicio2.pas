{
    2. Se dispone de un archivo con información de los alumnos de la Facultad de Informática. Por
        cada alumno se dispone de su código de alumno, apellido, nombre, cantidad de materias
        (cursadas) aprobadas sin final y cantidad de materias con final aprobado. Además, se tiene
        un archivo detalle con el código de alumno e información correspondiente a una materia
        (esta información indica si aprobó la cursada o aprobó el final).
        Todos los archivos están ordenados por código de alumno y en el archivo detalle puede
        haber 0, 1 ó más registros por cada alumno del archivo maestro. Se pide realizar un
        programa con opciones para:
    a. Actualizar el archivo maestro de la siguiente manera:
    i.Si aprobó el final se incrementa en uno la cantidad de materias con final aprobado,
        y se decrementa en uno la cantidad de materias sin final aprobado.
    ii.Si aprobó la cursada se incrementa en uno la cantidad de materias aprobadas sin
        final.
    b. Listar en un archivo de texto aquellos alumnos que tengan más materias con finales
    aprobados que materias sin finales aprobados. Teniendo en cuenta que este listado
    es un reporte de salida (no se usa con fines de carga), debe informar todos los
    campos de cada alumno en una sola línea del archivo de texto.
}

program Ejercicio2;

const 
    valorAlto = 9999;

type 
    alumno = record
        cod: integer;
        ape: string;
        nom: string;
        cantMatAprobFinal: integer;
        cantMatAprobCursada: integer;
    end;

    archivo = file of alumno;

    regDet = record
        cod: integer;
        aprobFinal: integer;
        aprobCursada: integer;
    end;

    archivoDet = file of regDet;

procedure leer(var arc: archivoDet; var reg: regDet);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.cod := valorAlto;
end;

procedure ActualizarMaestro(var mae: archivo; var det: archivoDet);
var 
    regM: alumno;
    regD: regDet;
    aux: alumno;
begin
    reset(mae);
    reset(det);
    leer(det, regD);
    read(mae, regM);
    while (regD.cod <> valorAlto) do begin
        aux.cod := regD.cod;
        aux.cantMatAprobFinal := 0;
        aux.cantMatAprobCursada := 0;
        while (aux.cod = regD.cod) do begin
            if (regD.aprobFinal = 1) then begin
                aux.cantMatAprobFinal := aux.cantMatAprobFinal + 1;
                aux.cantMatAprobCursada := aux.cantMatAprobCursada - 1;
            end
            else if (regD.aprobCursada = 1) then
                aux.cantMatAprobCursada := aux.cantMatAprobCursada + 1;
            leer(det, regD);
        end;
        while (regM.cod <> aux.cod) do
            read(mae, regM);
        regM.cantMatAprobFinal := regM.cantMatAprobFinal + aux.cantMatAprobFinal;
        regM.cantMatAprobCursada := regM.cantMatAprobCursada + aux.cantMatAprobCursada;
        seek(mae, filepos(mae) - 1);
        write(mae, regM);
        if not eof(mae) then
            read(mae, regM);
    end;
    close(mae);
    close(det);
end;

procedure exportar(var arc: archivo);
var 
    nombreArc: string;
    archivoTxt: text;
    reg: alumno;
begin
    writeln('Ingrese el nombre del archivo: ');
    readln(nombreArc);
    assign(archivoTxt, nombreArc);
    rewrite(archivoTxt);
    reset(arc);
    while not eof(arc) do begin
        read(arc, reg);
        writeln(archivoTxt, 'Codigo: ', reg.cod, ' Apellidos: ', reg.ape, ' Nombres: ', reg.nom, ' Materias con final aprobado: ', reg.cantMatAprobFinal, ' Materias con cursada aprobada: ', reg.cantMatAprobCursada);
    end;
    close(archivoTxt);
    close(arc);
end;

{ Procedimientos para pruebas }

procedure crearDetalle(var arc: archivoDet);
var
    reg: regDet;
    detText: text;
begin
    assign(arc, 'detalleBin.dat');
    assign(detText, 'notas.txt');
    reset(detText);
    rewrite(arc);
    while not eof(detText) do begin
        readln(detText, reg.cod, reg.aprobFinal, reg.aprobCursada);
        write(arc, reg);
    end;
    close(detText);
    close(arc);
end;

procedure cerarMaestro(var arc: archivo);
var
    reg: alumno;
    maeText: text;
begin
    assign(arc, 'maestro.dat');
    assign(maeText, 'alumnos.txt');
    rewrite(arc);
    reset(maeText);
    while not eof(maeText) do begin
        readln(maeText, reg.cod, reg.cantMatAprobFinal, reg.cantMatAprobCursada, reg.ape);
        readln(maeText, reg.nom);
        write(arc, reg);
    end;
    close(maeText);
    close(arc);
end;

procedure imprimirMaestro(var arc: archivo);
var
    reg: alumno;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, reg);
        writeln(reg.ape, ' ', reg.nom);
        writeln(' Materias con final aprobado: ', reg.cantMatAprobFinal);
        writeln(' Materias con cursada aprobada: ', reg.cantMatAprobCursada);
    end;
    close(arc);
end;

var
    det: archivoDet;
    mae: archivo;

begin
    cerarMaestro(mae);
    crearDetalle(det);
    ActualizarMaestro(mae, det);
    exportar(mae);
    imprimirMaestro(mae);
end.