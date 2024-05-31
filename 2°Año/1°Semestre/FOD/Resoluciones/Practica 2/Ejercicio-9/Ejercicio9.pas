{
    9. Se necesita contabilizar los votos de las diferentes mesas electorales registradas por
        provincia y localidad. Para ello, se posee un archivo con la siguiente información: código de
        provincia, código de localidad, número de mesa y cantidad de votos en dicha mesa.
        Presentar en pantalla un listado como se muestra a continuación:
        Código de Provincia
        Código de Localidad              Total de Votos
        ................................ ......................
        ................................ ......................
        Total de Votos Provincia: ____
        Código de Provincia
        Código de Localidad              Total de Votos
        ................................ ......................
        Total de Votos Provincia: ___
        ....................................................................
        Total General de Votos: ___
        NOTA: La información está ordenada por código de provincia y código de localidad.
}

program Ejercicio9;
const 
    valorAlto = 9999;
type 
    votos = record 
        codProv:integer;
        codLoc:integer;
        nroMesa:integer;
        cantVotos:integer;
    end;

    archivo = file of votos;

procedure leer(var arc: archivo; var reg: votos);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.codProv := valorAlto;
end;

procedure informarMesas(var arc: archivo);
var 
    reg: votos;
    codProv:integer;
    codLoc:integer;
    totalVotos:integer;
    totalVotosProv:integer;
    totalVotosLoc:integer;
begin
    reset(arc);
    leer(arc,reg);
    totalVotos:=0;
    while (reg.codProv <> valorAlto) do begin 
        totalVotosProv:=0;
        codProv:=reg.codProv;
        writeln('Provincia, ', codProv,': ');
        while (codProv = reg.codProv) do begin
            totalVotosLoc:=0;
            codLoc:=reg.codLoc;
            writeln('CodigoLocalidad           Total de Votos');
            while (codProv = reg.codProv) and (codLoc = reg.codLoc) do begin
                totalVotosLoc:=totalVotosLoc+reg.cantVotos;
                leer(arc,reg);
            end;
            writeln(codLoc, '                             ', totalVotosLoc);
            totalVotosProv:=totalVotosProv+totalVotosLoc;
        end;
        writeln('Total de Votos Provincia, ', codProv,': ', totalVotosProv);
        totalVotos:=totalVotos+totalVotosProv;
    end;
    writeln('Total General de Votos: ', totalVotos);
    close(arc);
end;

{ Procedimietos de prueba }
procedure crearMaestro(var arc: archivo);
var 
    reg: votos;
    arcTxt: text;
begin
    assign(arc, 'maestro.dat');
    assign(arcTxt, 'maestro.txt');
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, reg.codProv, reg.codLoc, reg.nroMesa, reg.cantVotos);
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
    informarMesas(arc);
end.