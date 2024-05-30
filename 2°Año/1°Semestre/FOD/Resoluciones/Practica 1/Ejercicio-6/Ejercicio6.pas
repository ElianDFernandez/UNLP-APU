{
    6. Agregar al menú del programa del ejercicio 5, opciones para:
    a. Añadir uno o más celulares al final del archivo con sus datos ingresados por teclado.
    b. Modificar el stock de un celular dado.
    c. Exportar el contenido del archivo binario a un archivo de texto denominado:
        ”SinStock.txt”, con aquellos celulares que tengan stock 0.
    NOTA: Las búsquedas deben realizarse por nombre de celular.
}

program Ejercicio6;

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

{ Procedimientos Ejercicio 6. }

{
    6. Agregar al menú del programa del ejercicio 5, opciones para:
        a. Añadir uno o más celulares al final del archivo con sus datos ingresados por teclado.
        b. Modificar el stock de un celular dado.
        c. Exportar el contenido del archivo binario a un archivo de texto denominado:
        ”SinStock.txt”, con aquellos celulares que tengan stock 0.
    NOTA: Las búsquedas deben realizarse por nombre de celular.
}

procedure leer(var cel: celular);
begin
    writeln('Ingrese el codigo del celular: ');
    readln(cel.cod);
    if (cel.cod <> 0) then begin
        writeln('Ingrese el precio del celular: ');
        readln(cel.precio);
        writeln('Ingrese la marca del celular: ');
        readln(cel.marca);
        writeln('Ingrese el stock disponible del celular: ');
        readln(cel.stockDisp);
        writeln('Ingrese el stock minimo del celular: ');
        readln(cel.stockMin);
        writeln('Ingrese la descrip del celular: ');
        readln(cel.descrip);
        writeln('Ingrese el nombre del celular: ');
        readln(cel.nombre);
    end;
end;

procedure agregarCelulares(var arc: archivo); 
var 
    cel: celular;
begin
    reset(arc);
    leer(cel);
    while (cel.cod <> 0) do begin
        seek(arc, filesize(arc));
        write(arc, cel);
        leer(cel);
    end;
    close(arc);
end;

procedure modificarStock(var arc: archivo);
var 
    cod: integer;
    stock: integer;
    cel: celular;
    encontrado: boolean;
begin
    reset(arc);
    writeln('Ingrese el codigo del celular: ');
    readln(cod);
    encontrado := false;
    while (not eof(arc)) and (not encontrado) do begin
        read(arc, cel);
        if (cel.cod = cod) then begin
            writeln('Ingrese el nuevo stock: ');
            readln(stock);
            cel.stockDisp := stock;
            seek(arc, filepos(arc) - 1);
            write(arc, cel);
            encontrado := true;
        end;
    end;

    if not encontrado then
        writeln('Codigo de celular no encontrado.');

    close(arc);
end;

procedure exportarSinStock(var arc: archivo);
var 
    cel: celular;
    arcTxt: text;
begin
    reset(arc);
    assign(arcTxt, 'SinStock.txt');
    rewrite(arcTxt);
    while not eof(arc) do begin
        read(arc, cel);
        if (cel.stockDisp = 0) then begin
            writeln(arcTxt, cel.cod, ' ', cel.precio:0:2, ' ', cel.marca);
            writeln(arcTxt, cel.stockDisp, ' ', cel.stockMin, ' ', cel.descrip);
            writeln(arcTxt, cel.nombre);
        end;
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
    writeln ('5. Agregar celulares');
    writeln ('6. Modificar stock');
    writeln ('7. Exportar celulares sin stock');
    writeln ('8. Salir');
    writeln ('-------------------');
    readln (op);
    while (op <> 8) do begin
        case op of
            1: generarArchivo(arc, arcTxt);
            2: stockMenorAlStockMin(arc);
            3: descripCadena(arc);
            4: exportar(arc);
            5: agregarCelulares(arc);
            6: modificarStock(arc);
            7: exportarSinStock(arc);
        end;
        writeln ('-------------------');
        writeln ('1. Cargar archivo');
        writeln ('2. Ver stock menor al stock minimo');
        writeln ('3. Ver celulares que contengan una cadena de caracteres');
        writeln ('4. Exportar');
        writeln ('5. Agregar celulares');
        writeln ('6. Modificar stock');
        writeln ('7. Exportar celulares sin stock');
        writeln ('8. Salir');
        writeln ('-------------------');
        readln (op);
    end;
end.

