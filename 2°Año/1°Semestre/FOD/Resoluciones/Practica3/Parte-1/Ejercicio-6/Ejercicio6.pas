{
    6. Una cadena de tiendas de indumentaria posee un archivo maestro no ordenado con
        la información correspondiente a las prendas que se encuentran a la venta. De cada
        prenda se registra: cod_prenda, descripción, colores, tipo_prenda, stock y
        precio_unitario. Ante un eventual cambio de temporada, se deben actualizar las
        prendas a la venta. Para ello reciben un archivo conteniendo: cod_prenda de las
        prendas que quedarán obsoletas. Deberá implementar un procedimiento que reciba
        ambos archivos y realice la baja lógica de las prendas, para ello deberá modificar el
        stock de la prenda correspondiente a valor negativo.
        Adicionalmente, deberá implementar otro procedimiento que se encargue de
        efectivizar las bajas lógicas que se realizaron sobre el archivo maestro con la
        información de las prendas a la venta. Para ello se deberá utilizar una estructura
        auxiliar (esto es, un archivo nuevo), en el cual se copien únicamente aquellas prendas
        que no están marcadas como borradas. Al finalizar este proceso de compactación
        del archivo, se deberá renombrar el archivo nuevo con el nombre del archivo maestro
        original.
}

program Ejercicio6;

type 
    prenda = record 
        cod: integer;
        desc: string;
        colores: string;
        tipo: string;
        stock: integer;
        precio: real;
    end;

    archivo = file of prenda;

    aEliminar = file of integer;

procedure borradoLogico(var arc:archivo; var arcElim: aEliminar);
var 
    p: prenda;
    cod: integer;
begin 
    reset(arc);
    reset(arcElim);
    while not eof(arcElim) do begin 
        seek(arc,0);
        read(arc,p);
        read(arcElim, cod); 
        while not eof(arc) and (p.cod <> cod) do 
            read(arc,p);
        if (p.cod = cod) then begin 
            p.stock := p.stock *-1;
            seek(arc, filepos(arc)-1);
            write(arc,p);
        end;
    end;
    close(arc);
    close(arcElim);
end;

procedure archivoNuevo(var arc:archivo);
var 
    arcNuevo:archivo;
    p: prenda;
begin 
    assign(arcNuevo, 'auxiliar.dat');
    rewrite(arcNuevo);
    reset(arc);
    while not eof(arc) do begin 
        read(arc, p);
        if (p.stock >= 0) then 
            write(arcNuevo, p);
    end;
    close(arcNuevo);
    close(arc);
    erase(arc);
    rename(arcNuevo, 'maestro.dat');
end;

{ Procedimientos de pruebas }
procedure crearMaestro(var arc:archivo);
var 
    p:prenda;
    nom:string;
    arcTxt:text;
begin 
    writeln('Ingrese nombre del archivo txt para generar el maestro: ');
    readln(nom);
    assign(arcTxt, nom);
    reset(arcTxt);
    writeln('Ingrse nombre del archivo binario para generar el maestro: ');
    readln(nom);
    assign(arc, nom);
    rewrite(arc);
    while not eof(arcTxt) do begin 
        readln(arcTxt, p.cod, p.precio, p.stock, p.tipo);
        readln(arcTxt, p.desc);
        readln(arcTxt, p.colores);
        write(arc, p);
    end;
    close(arcTxt);
    close(arc);
end;

procedure crearDetalle(var arc:aEliminar);
var 
    cod:integer;
    arcTxt:text;
    nom:string;
begin 
    writeln('Ingrese nombre del archivo txt para generar el detalle: ');
    readln(nom);
    assign(arcTxt, nom);
    reset(arcTxt);
    writeln('Ingrse nombre del archivo binario para generar el detalle: ');
    readln(nom);
    assign(arc, nom);
    rewrite(arc);
    while not eof(arcTxt) do begin 
        readln(arcTxt, cod);
        write(arc, cod);
    end;
    close(arcTxt);
    close(arc);
end;

procedure imprimir(var arc:archivo);
var 
    p:prenda;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, p);
        writeln(p.cod, ' ', p.desc, ' ', p.colores, ' ', p.tipo, ' ', p.stock, ' ', p.precio);
    end;
    close(arc);
end;

{ Programa principal }
var 
    arc: archivo;
    arcElim: aEliminar;
begin
    crearMaestro(arc);
    crearDetalle(arcElim);
    writeln('Archivo maestro antes de bajas logicas: ');
    imprimir(arc);
    borradoLogico(arc, arcElim);
    writeln('Archivo maestro despues de bajas logicas: ');
    imprimir(arc);
    archivoNuevo(arc);
    writeln('Archivo maestro final: ');
    imprimir(arc);
end.