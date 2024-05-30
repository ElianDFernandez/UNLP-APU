{
    7. Se desea modelar la información necesaria para un sistema de recuentos de casos de covid
    para el ministerio de salud de la provincia de buenos aires.
    Diariamente se reciben archivos provenientes de los distintos municipios, la información
    contenida en los mismos es la siguiente: código de localidad, código cepa, cantidad de
    casos activos, cantidad de casos nuevos, cantidad de casos recuperados, cantidad de casos
    fallecidos.
    El ministerio cuenta con un archivo maestro con la siguiente información: código localidad,
    nombre localidad, código cepa, nombre cepa, cantidad de casos activos, cantidad de casos
    nuevos, cantidad de recuperados y cantidad de fallecidos.
    Se debe realizar el procedimiento que permita actualizar el maestro con los detalles
    recibidos, se reciben 10 detalles. Todos los archivos están ordenados por código de
    localidad y código de cepa. 
    Para la actualización se debe proceder de la siguiente manera: 
    1. Al número de fallecidos se le suman el valor de fallecidos recibido del detalle.
    2. Idem anterior para los recuperados.
    3. Los casos activos se actualizan con el valor recibido en el detalle.
    4. Idem anterior para los casos nuevos hallados.
    Realice las declaraciones necesarias, el programa principal y los procedimientos que
    requiera para la actualización solicitada e informe cantidad de localidades con más de 50
    casos activos (las localidades pueden o no haber sido actualizadas).
}

program Ejercicio7;
const 
    valorAlto = 9999;
    dimf = 3;
type 
    municipio = record
        codLocalidad: integer;
        codCepa: integer;
        cantCasosActivos: integer;
        cantCasosNuevos: integer;
        cantCasosRecuperados: integer;
        cantCasosFallecidos: integer;
    end;
    archivoD = file of municipio;
    ministerio = record
        codLocalidad: integer;
        nomLocalidad: string;
        codCepa: integer;
        nomCepa: string;
        cantCasosActivos: integer;
        cantCasosNuevos: integer;
        cantCasosRecuperados: integer;
        cantCasosFallecidos: integer;
    end;
    archivoM = file of ministerio;
    vecArcDet = array[1..dimf] of archivoD;
    vecRegDet = array[1..dimf] of municipio;

procedure leer(var arc: archivoD; var reg: municipio);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.codLocalidad := valorAlto;
end;

procedure minimo(var vecArchivosDet: vecArcDet; var vecReg: vecRegDet; var min: municipio);
var
    i,pos: integer;
begin
    min.codLocalidad := valorAlto;
    for i := 1 to dimf do
        if (vecReg[i].codLocalidad < min.codLocalidad) or (vecReg[i].codLocalidad = min.codLocalidad) and (vecReg[i].codCepa < min.codCepa) then begin
            min := vecReg[i];
            pos := i;
        end;
    if (min.codLocalidad <> valorAlto) then
        leer(vecArchivosDet[pos],vecReg[pos]);
end;

procedure actualizarMaestro(var mae: archivoM; var vecArchivosDet: vecArcDet);
var
    min: municipio;
    regM: ministerio;
    i, pos: integer;
    cantCasosLocalidad: integer;
    cantLocalidades: integer;
    vecReg: vecRegDet;
begin
    reset(mae);
    for i := 1 to dimf do begin
        reset(vecArchivosDet[i]);
        leer(vecArchivosDet[i], vecReg[i]);
    end;
    minimo(vecArchivosDet, vecReg, min);
    read(mae, regM);
    cantLocalidades := 0;
    while (min.codLocalidad <> valorAlto) do begin
        cantCasosLocalidad := 0;
        while (regM.codLocalidad <> min.codLocalidad) do
            read(mae, regM);
        while (regM.codLocalidad = min.codLocalidad) do begin
            while (regM.codCepa <> min.codCepa)  do
                read(mae, regM);
            while (regM.codLocalidad = min.codLocalidad) and (regM.codCepa = min.codCepa) do begin
                regM.cantCasosActivos := regM.cantCasosActivos + min.cantCasosActivos;
                regM.cantCasosNuevos := regM.cantCasosNuevos + min.cantCasosNuevos;
                regM.cantCasosRecuperados := regM.cantCasosRecuperados + min.cantCasosRecuperados;
                regM.cantCasosFallecidos := regM.cantCasosFallecidos + min.cantCasosFallecidos;
                cantCasosLocalidad := cantCasosLocalidad + min.cantCasosActivos;
                minimo(vecArchivosDet, vecReg, min);
            end;
            seek(mae, filepos(mae) - 1);
            write(mae, regM);
        end;
        writeln('Cantidad de casos en la localidad: ', regM.nomLocalidad);
        writeln('Cepa: ', regM.nomCepa);
        writeln('Casos activos: ', regM.cantCasosActivos);
        writeln('Casos nuevos: ', regM.cantCasosNuevos);
        writeln('Casos recuperados: ', regM.cantCasosRecuperados);
        writeln('Casos fallecidos: ', regM.cantCasosFallecidos);
        if (cantCasosLocalidad > 50) then begin
            cantLocalidades := cantLocalidades + 1;
        end;
    end;
    for i := 1 to dimf do
        close(vecArchivosDet[i]);
    close(mae);
    writeln('La cantidad de localidades con más de 50 casos activos es: ', cantLocalidades);
end;

{ Procedimientos pruebas }
procedure crearDetalle(var arc: archivoD; num:integer);
var
    reg: municipio;
    arcText: text;
    nombre: string;
begin
    writeln('Ingrese el nombre del archivo detalle ' , num , ': ');
    readln(nombre);
    assign(arcText, nombre);
    reset(arcText);
    writeln('Ingrese el nombre del archivo binario ' , num , ': ');
    readln(nombre);
    assign(arc, nombre);
    rewrite(arc);
    while not eof(arcText) do begin
        readln(arcText,reg.codLocalidad,reg.codCepa,reg.cantCasosActivos,reg.cantCasosNuevos,reg.cantCasosRecuperados,reg.cantCasosFallecidos);
        write(arc,reg);
    end;
    close(arcText);
    close(arc);
end;

procedure crearDetalles(var vec: vecArcDet);
var
    i: integer;
begin
    for i := 1 to dimf do
        crearDetalle(vec[i], i);
end;

procedure crearMaestro(var mae: archivoM);
var
    reg: ministerio;
    maeText: text;
    nombre: string;
begin
    writeln('Ingrese el nombre del archivo texto maestro: ');
    readln(nombre);
    assign(maeText, nombre);
    reset(maeText);
    writeln('Ingrese el nombre del archivo binario maestro: ');
    readln(nombre);
    assign(mae, nombre);
    rewrite(mae);
    while not eof(maeText) do begin
        readln(maeText,reg.codLocalidad,reg.codCepa,reg.cantCasosActivos,reg.cantCasosNuevos,reg.cantCasosRecuperados,reg.cantCasosFallecidos, reg.nomCepa);
        readln(maeText,reg.nomLocalidad);
        write(mae,reg);
    end;
    close(maeText);
    close(mae);
end;

procedure imprimirMaestro(var mae: archivoM);
var
    reg: ministerio;
begin
    reset(mae);
    while not eof(mae) do begin
        read(mae,reg);
        writeln('Localidad: ', reg.nomLocalidad);
        writeln('Cepa: ', reg.nomCepa);
        writeln('Casos activos: ', reg.cantCasosActivos);
        writeln('Casos nuevos: ', reg.cantCasosNuevos);
        writeln('Casos recuperados: ', reg.cantCasosRecuperados);
        writeln('Casos fallecidos: ', reg.cantCasosFallecidos);
    end;
    close(mae);
end;

{ Programa Principal }
var 
    mae: archivoM;
    vecArchivosDet: vecArcDet;
begin
    crearDetalles(vecArchivosDet);
    crearMaestro(mae);
    actualizarMaestro(mae,vecArchivosDet);
    imprimirMaestro(mae);
end.