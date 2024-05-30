{
    5. Realizar un programa para una tienda de celulares, que presente un menú con opciones para:
    a. Crear un archivo de registros no ordenados de celulares y cargarlo con datos
    ingresados desde un archivo de texto denominado “celulares.txt”. Los registros
    correspondientes a los celulares deben contener: código de celular, nombre,
    descripción, marca, precio, stock mínimo y stock disponible.
    b. Listar en pantalla los datos de aquellos celulares que tengan un stock menor al
    stock mínimo.
    c. Listar en pantalla los celulares del archivo cuya descripción contenga una
    cadena de caracteres proporcionada por el usuario.
    d. Exportar el archivo creado en el inciso a) a un archivo de texto denominado
    “celulares.txt” con todos los celulares del mismo. El archivo de texto generado
    podría ser utilizado en un futuro como archivo de carga (ver inciso a), por lo que
    debería respetar el formato dado para este tipo de archivos en la NOTA 2.
    NOTA 1: El nombre del archivo binario de celulares debe ser proporcionado por el usuario.
    NOTA 2: El archivo de carga debe editarse de manera que cada celular se especifique en
    tres líneas consecutivas. 
    En la primera se especifica: código de celular, el precio y
    marca, en la segunda el stock disponible, stock mínimo y la descripción y en la tercera
    nombre en ese orden. Cada celular se carga leyendo tres líneas del archivo
    “celulares.txt”.
}

program Ejercicio5;

type 
    celular = record
        cod: integer;
        precio: real;
        marca: string;
        stockDisp: integer;
        stockMin: integer;
        descrip: string;
        nombre: string;
    end;

    archivo = file of celular;

procedure generarArchivo(var arc: archivo; var arcTxt: text);
var 
    cel: celular;
begin
    reset(arcTxt);
    rewrite(arc);
    while not eof(arcTxt) do begin
        readln(arcTxt, cel.cod, cel.precio, cel.marca);
        readln(arcTxt, cel.stockDisp, cel.stockMin, cel.descrip);
        readln(arcTxt, cel.nombre);
        write(arc, cel);
    end;
    writeln('Archivo generado');
    close(arcTxt);
    close(arc);
end;

procedure stockMenorAlStockMin(var arc: archivo);
var 
    cel: celular;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, cel);
        if (cel.stockDisp < cel.stockMin) then begin
            writeln('-------------------');
            writeln('Codigo: ',cel.cod, ' Precio: ',cel.precio, ' Marca: ',cel.marca);
            writeln('Descripcion: ',cel.descrip);
            writeln(' Stock disponible: ',cel.stockDisp, ' Stock minimo: ', cel.stockMin);
            writeln('-------------------');
        end;
    end;
    close(arc);
end;

procedure descripCadena(var arc: archivo);
var 
    cel: celular;
    descrip: string;
begin
    reset(arc);
    writeln('Ingrese la cadena de caracteres para buscar: ');
    readln(descrip);
    while not eof(arc) do begin
        read(arc, cel);
        if (pos(descrip, cel.descrip) > 0) then begin
            writeln('-------------------');
            writeln('Codigo: ',cel.cod, ' Precio: ',cel.precio:0:2, ' Marca: ',cel.marca);
            writeln('Descripcion: ',cel.descrip);
            writeln(' Stock disponible: ',cel.stockDisp, ' Stock minimo: ', cel.stockMin);
            writeln('-------------------');
        end;
        
    end;
    close(arc);
end;

procedure exportar(var arc: archivo);
var 
    cel: celular;
    nombreArc: string;
    arcTxt: text;
begin
    writeln('Ingrese el nombre del archivo: ');
    readln(nombreArc);
    assign(arcTxt, nombreArc);
    rewrite(arcTxt);
    reset(arc);
    while not eof(arc) do begin
        read(arc, cel);
        writeln(arcTxt, cel.cod, ' ', cel.precio:0:2, ' ', cel.marca);
        writeln(arcTxt, cel.stockDisp, ' ', cel.stockMin, ' ', cel.descrip);
        writeln(arcTxt, cel.nombre);
    end;
    close(arc);
    close(arcTxt);
end;

var 
    arcTxt: text;
    arc: archivo;
    op: integer;
    nombreArc: string;
begin
    assign(arcTxt, 'celulares.txt');
    writeln('Ingrese el nombre del archivo: ');
    readln(nombreArc);
    assign(arc, nombreArc);
    writeln ('-------------------');
    writeln ('1. Cargar archivo');
    writeln ('2. Ver stock menor al stock minimo');
    writeln ('3. Ver celulares que contengan una cadena de caracteres');
    writeln ('4. Exportar');
    writeln ('5. Salir');
    writeln ('-------------------');
    readln (op);
    while (op <> 5) do begin
        case op of
            1: generarArchivo(arc, arcTxt);
            2: stockMenorAlStockMin(arc);
            3: descripCadena(arc);
            4: exportar(arc);
        end;
        writeln ('-------------------');
        writeln ('1. Cargar archivo');
        writeln ('2. Ver stock menor al stock minimo');
        writeln ('3. Ver celulares que contengan una cadena de caracteres');
        writeln ('4. Exportar');
        writeln ('5. Salir');
        writeln ('-------------------');
        readln (op);
    end;
end.

