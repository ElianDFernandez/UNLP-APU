{
    7. Se cuenta con un archivo que almacena información sobre especies de aves en vía
    de extinción, para ello se almacena: código, nombre de la especie, familia de ave,
    descripción y zona geográfica. El archivo no está ordenado por ningún criterio. Realice
    un programa que elimine especies de aves, para ello se recibe por teclado las
    especies a eliminar. Deberá realizar todas las declaraciones necesarias, implementar
    todos los procedimientos que requiera y una alternativa para borrar los registros. Para
    ello deberá implementar dos procedimientos, uno que marque los registros a borrar y
    posteriormente otro procedimiento que compacte el archivo, quitando los registros
    marcados. Para quitar los registros se deberá copiar el último registro del archivo en la
    posición del registro a borrar y luego eliminar del archivo el último registro de forma tal
    de evitar registros duplicados.
    Nota: Las bajas deben finalizar al recibir el código 500000
}

program Ejercicio7;

const 
    valorAlto=999;

type
    ave = record
        cod:integer;
        nom:string;
        fam:string;
        desc:string;
        zona:string;
    end;

    archivo = file of ave;
    
procedure eliminadoLogicoEspecies(var arc:archivo);
var 
    cod:integer;
    a:ave;
    ok:boolean;
begin 
    reset(arc);
    writeln('Ingrese codigo de especie a borrar: ');
    readln(cod);
    while (cod <> -1) do begin 
        ok:=false;
        while not eof(arc) and (not ok) do begin 
            read(arc,a);
            if (a.cod = cod) then begin 
                ok:=true;
            end;
        end;
        if (ok) then begin
            a.cod:= a.cod*-1;
            seek(arc, filepos(arc)-1);
            write(arc,a);
        end
        else 
            writeln('Especie no encontrada');
        writeln('Ingrese codigo de especie a borrar: ');
        readln(cod);
    end;
    close(arc);
end;

procedure leer(var arc:archivo; var a:ave);
begin 
    if (not eof(arc)) then
        read(arc,a)
    else 
        a.cod:=valorAlto;
end;

procedure compactarArchivo(var arc:archivo);
var 
    a:ave;
    pos:integer;
begin 
    reset(arc);
    leer(arc,a);
    while (a.cod <> valorAlto) do begin 
        if (a.cod < 0) then begin 
            pos:=filepos(arc)-1;
            seek(arc,filesize(arc)-1);
            read(arc,a);
            if (filepos(arc)-1 <> 0) then begin 
                while (a.cod < 0) do begin 
                    seek(arc,filesize(arc)-1);
                    truncate(arc);
                    seek(arc, filesize(arc)-1);
                    read(arc,a);
                end;
                seek(arc,pos);
                write(arc,a);
                seek(arc,filesize(arc)-1);
                truncate(arc);
                seek(arc,pos);
            end;
        end;
        leer(arc,a);
    end;
    close(arc);
end;

{ Procedimientos pruebas }
procedure crearArchivo(var arc: archivo);
var 
    a:ave;
    arcTxt: text;
    nom:string;
begin
    assign(arcTxt, 'aves.txt');
    reset(arcTxt);
    writeln('Ingrse nombre del archivo binario para generar el maestro: ');
    readln(nom);
    assign(arc, nom);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, a.cod); 
        readln(arcTxt, a.nom);
        readln(arcTxt, a.fam);
        readln(arcTxt, a.desc);
        readln(arcTxt, a.zona);
        write(arc, a);
    end;
    close(arcTxt);
    close(arc);
end;

procedure imprimir(var arc: archivo);
var 
    a:ave;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc,a);
        writeln(a.cod, ' ', a.nom, ' ', a.fam, ' ', a.desc, ' ', a.zona);
    end;
    close(arc);
end;

{ Procedimiento principal }

var 
    arc: archivo;
begin
    crearArchivo(arc);
    imprimir(arc);
    eliminadoLogicoEspecies(arc);
    compactarArchivo(arc);
    imprimir(arc);
end.



