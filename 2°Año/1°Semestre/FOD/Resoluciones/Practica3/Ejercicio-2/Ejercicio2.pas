{
    2. Definir un programa que genere un archivo con registros de longitud fija conteniendo
        información de asistentes a un congreso a partir de la información obtenida por
        teclado. Se deberá almacenar la siguiente información: nro de asistente, apellido y
        nombre, email, teléfono y D.N.I. Implementar un procedimiento que, a partir del
        archivo de datos generado, elimine de forma lógica todos los asistentes con nro de
        asistente inferior a 1000.
        Para ello se podrá utilizar algún carácter especial situándolo delante de algún campo
        String a su elección. Ejemplo: ‘@Saldaño’.
}

program Ejercicio2;

type 
    asistente = record 
        numero:integer;
        apellido:string;
        nombre:string;
        email:string;
        telefono:integer;
        dni:integer;
    end;

    archivo = file of asistente;

procedure eliminacionLogica(var arc: archivo);
var 
    a: asistente;
begin 
    reset(arc);
    while not eof(arc) do begin 
        read(arc,a);
        if (a.numero < 1000) then begin 
            a.nombre:= '@'+ a.nombre;
            seek(arc, filepos(arc)-1);
            write(arc, a);
        end;
    end;
    close(arc);
end;

procedure crearArchivo(var arc: archivo);
var 
    arcTxt: text;
    a: asistente;
    nombre: string;
begin 
    writeln('Nombre del archivo txt para generar el bin: ');
    readln(nombre);
    assign(arcTxt,nombre);
    reset(arcTxt);
    writeln('Nombre del archivo bin a generar: ');
    readln(nombre);
    assign(arc,nombre);
    rewrite(arc);
    while not eof(arcTxt) do begin 
        readln(arcTxt, a.numero, a.telefono, a.nombre);
        readln(arcTxt, a.apellido);
        readln(arcTxt, a.email);
        write(arc,a);
    end;
    writeln('Archivo BIN generado.');
    close(arc);
    close(arcTxt);
end;

procedure informarBin(var arc:archivo); 
var 
    a: asistente;
begin 
    reset(arc);
    while not eof(arc) do begin 
        read(arc,a);
        writeln('Asistente: ', a.numero, ' ', a.nombre, ' ', a.apellido, ' ', a.email)
    end;
    close(arc);
end;

var 
    arc: archivo;
begin 
    crearArchivo(arc);
    eliminacionLogica(arc);
    informarBin(arc);
end.