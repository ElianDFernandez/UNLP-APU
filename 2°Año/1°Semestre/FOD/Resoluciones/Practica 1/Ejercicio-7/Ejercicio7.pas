{
    7. Realizar un programa que permita:
        a) Crear un archivo binario a partir de la información almacenada en un archivo de
        texto. El nombre del archivo de texto es: “novelas.txt”. La información en el
        archivo de texto consiste en: código de novela, nombre, género y precio de
        diferentes novelas argentinas. Los datos de cada novela se almacenan en dos
        líneas en el archivo de texto. La primera línea contendrá la siguiente información:
        código novela, precio y género, y la segunda línea almacenará el nombre de la
        novela.
        b) Abrir el archivo binario y permitir la actualización del mismo. Se debe poder
        agregar una novela y modificar una existente. Las búsquedas se realizan por
        código de novela.
    NOTA: El nombre del archivo binario es proporcionado por el usuario desde el teclado.
}

program Ejercicio7;

type 
    novela = record
        cod: integer;
        nom: string;
        gen: string;
        pre: real;
    end;

    archivo = file of novela;

procedure imprimir(var arc: archivo);
var 
    nov: novela;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, nov);
        writeln('-------------------');
        writeln('Codigo de novela: ', nov.cod);
        writeln('Nombre de la novela: ', nov.nom);
        writeln('Genero de la novela: ', nov.gen);
        writeln('Precio de la novela: ', nov.pre);
        writeln('-------------------');
    end;
    close(arc);
end;

procedure generarArchivo(var arc: archivo; var arcTxt: text);
var 
    nov: novela;
begin
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, nov.cod, nov.pre, nov.gen);
        readln(arcTxt, nov.nom);
        write(arc, nov);
    end;
    writeln('Archivo generado');
    close(arc);
    close(arcTxt);
    imprimir(arc);
end;

procedure leer(var nov: novela);
begin
    writeln('Ingrese el codigo de la novela: ');
    readln(nov.cod);
    if (nov.cod <> 0) then begin
        writeln('Ingrese el precio de la novela: ');
        readln(nov.pre);
        writeln('Ingrese el genero de la novela: ');
        readln(nov.gen);
        writeln('Ingrese el nombre de la novela: ');
        readln(nov.nom);
    end;
end;

procedure agregarNovela(var arc: archivo);
var 
    nov: novela;
begin
    reset(arc);
    leer(nov);
    while (nov.cod <> 0) do begin
        seek(arc, filesize(arc));
        write(arc, nov);
        leer(nov);
    end;
    close(arc);
end;

procedure modificarNovela(var arc: archivo);
var 
    nov: novela;
    cod: integer;
    encontrado: boolean;
begin
    reset(arc);
    writeln('Ingrese el codigo de la novela: ');
    readln(cod);
    encontrado := false;
    while (not eof(arc)) and (not encontrado) do begin
        read(arc, nov);
        if (nov.cod = cod) then begin
            writeln('Ingrese el nuevo nombre: ');
            readln(nov.nom);
            seek(arc, filepos(arc) - 1);
            write(arc, nov);
            encontrado := true;
        end;
    end;
    if not encontrado then
        writeln('Codigo de novela no encontrado.');
    close(arc);
end;

var 
    nombreArc: string;
    arc: archivo;
    arcTxt: text;
    op: integer;
begin
    assign(arcTxt, 'novelas.txt');
    writeln('Ingrese el nombre del archivo: ');
    readln(nombreArc);
    assign(arc, nombreArc);
    writeln('-------------------');
    writeln('1. Generar archivo');
    writeln('2. Agregar novela');
    writeln('3. Modificar novela');
    writeln('4. Imprimir archivo binario');
    writeln('5. Salir');
    readln(op);
    while (op <> 5) do begin
        case op of
            1: generarArchivo(arc, arcTxt);
            2: agregarNovela(arc);
            3: modificarNovela(arc);
            4: imprimir(arc);
        end;
        writeln('-------------------');
        writeln('1. Generar archivo');
        writeln('2. Agregar novela');
        writeln('3. Modificar novela');
        writeln('4. Imprimir archivo binario');
        writeln('5. Salir');
        readln(op);
    end;
end.