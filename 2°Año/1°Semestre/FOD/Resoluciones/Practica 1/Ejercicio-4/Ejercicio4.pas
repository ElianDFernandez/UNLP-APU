{
    4. Agregar al menú del programa del ejercicio 3, opciones para:
    a. Añadir uno o más empleados al final del archivo con sus datos ingresados por
        teclado. Tener en cuenta que no se debe agregar al archivo un empleado con
        un número de empleado ya registrado (control de unicidad).
    b. Modificar la edad de un empleado dado.
    c. Exportar el contenido del archivo a un archivo de texto llamado
        “todos_empleados.txt”.
    d. Exportar a un archivo de texto llamado: “faltaDNIEmpleado.txt”, los empleados
        que no tengan cargado el DNI (DNI en 00).
    NOTA: Las búsquedas deben realizarse por número de empleado.
}

program Ejercicio4;

type 
    empleado = record
        num: integer;
        ape: string;
        nom: string;
        edad: integer;
        dni: integer;
    end;

    archivo = file of empleado;

{ Procedimientos Ejercicio 3. }

procedure leerEmpleado (var e:empleado);
begin
    write ('Ingrese el numero de empleado: ');
    readln(e.num);
    write ('Ingrese el apellido: ');
    readln(e.ape);
    if (e.ape <> 'fin') then begin
        write ('Ingrese el nombre: ');
        readln(e.nom);
        write ('Ingrese la edad: ');
        readln(e.edad);
        write ('Ingrese el dni: ');
        readln(e.dni);
    end;
end;

procedure crearArchivo(var arc: archivo);
var
    e: empleado;
begin
    rewrite(arc);
    leerEmpleado(e);
    while (e.ape <> 'fin') do begin
        write(arc, e);
        leerEmpleado(e);
    end;
    close(arc);
end;

procedure listarEmpleados1(var arc: archivo);
var 
    nombreApellido:string;
    e:empleado;
begin
    writeln ('Ingrese el nombre o apellido del empleado que desea ver: ');
    readln (nombreApellido);
    reset(arc);
    while not eof(arc) do begin
        read(arc, e);
        if ((e.nom = nombreApellido) or (e.ape = nombreApellido)) then begin
            writeln ('-------------------');
            writeln ('Numero de empleado: ', e.num);
            writeln ('Apellido: ', e.ape);
            writeln ('Nombre: ', e.nom);
            writeln ('Edad: ', e.edad);
            writeln ('DNI: ', e.dni);
            writeln ('-------------------');
        end;
    end;
    close(arc);
end;

procedure listarEmpleados2(var arc: archivo);
var 
    e:empleado;
begin 
    reset(arc);
    while not eof(arc) do begin
        read(arc, e);
        writeln ('-------------------');
        writeln ('Numero de empleado: ', e.num);
        writeln ('Apellido: ', e.ape);
        writeln ('Nombre: ', e.nom);
        writeln ('Edad: ', e.edad);
        writeln ('DNI: ', e.dni);
        writeln ('-------------------');
    end;
    close(arc);
end;

procedure jubilarse(var arc: archivo);
var 
    e:empleado;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc, e);
        if (e.edad > 70) then begin
            writeln ('-------------------');
            writeln ('Numero de empleado: ', e.num);
            writeln ('Apellido: ', e.ape);
            writeln ('Nombre: ', e.nom);
            writeln ('Edad: ', e.edad);
            writeln ('DNI: ', e.dni);
            writeln ('-------------------');
        end;
    end;
    close(arc);
end;

{ Procedimientos Ejercicio 4. }

function controlUnicidad(var arc: archivo; num:integer):boolean;
var 
    e:empleado;
    encontrado: boolean;
begin
    encontrado:= false;
    while not eof(arc) do begin
        read(arc, e);
        if (e.num = num) then
            encontrado:= true;
    end;
    controlUnicidad:= encontrado;
end;

procedure agregar(var arc: archivo);
var
    e:empleado;
begin
    reset(arc);
    leerEmpleado(e);
    while (e.ape <> 'fin') do begin
        if (not controlUnicidad(arc, e.num)) then begin
            seek(arc, filesize(arc));
            write(arc, e);
        end
        else
            writeln ('El numero de empleado ya existe');
        leerEmpleado(e);
    end;
    close(arc);
end;

procedure modificar(var arc: archivo);
var 
    e:empleado;
    num:integer;
begin 
    reset(arc);
    writeln ('Ingrese el numero de empleado del que desea modificar la edad: ');
    readln (num);
    while not eof(arc) do begin
        read(arc, e);
        if (e.num = num) then begin
            writeln ('Ingrese la nueva edad: ');
            readln (e.edad);
            seek(arc, filepos(arc)-1);
            write(arc, e);
        end;
    end;
    close(arc);
end;

procedure exportar(var arc: archivo);
var 
    e: empleado;
    nombreArc: string;
    arcTxt: text;
begin
    writeln('Ingrese el nombre del archivo: ');
    readln(nombreArc);
    assign(arcTxt, nombreArc);
    rewrite(arcTxt);
    reset(arc);
    while not eof(arc) do begin
        read(arc, e);
        writeln(arcTxt, e.ape, ' ', e.nom, ' ', e.edad, ' ', e.dni);
    end;
    close(arc);
    close(arcTxt);
end;

procedure exportar2(var arc: archivo);
var 
    e:empleado;
    nombreArc: string;
    arcTxt: text;
begin
    writeln ('Ingrese el nombre del archivo: ');
    readln (nombreArc);
    assign(arcTxt, nombreArc);
    rewrite(arcTxt);
    reset(arc);
    while not eof(arc) do begin
        read(arc, e);
        if (e.dni = 00) then
            write (arcTxt, e.ape, ' ', e.nom, ' ', e.edad, ' ', e.dni);
    end;
    close(arc);
    close(arcTxt);
end;

var
    arc: archivo;
    nombreArc: string;
    op: integer;
begin
    writeln ('Ingrese el nombre del archivo: ');
    readln (nombreArc);
    assign(arc, nombreArc);
    writeln ('-------------------');
    writeln ('1. Generar archivo');
    writeln ('2. Ver empleados');
    writeln ('3. Ver todos los empleados');
    writeln ('4. Ver empleados proximos a jubilarse');
    writeln ('5. Agregar');
    writeln ('6. Modificar');
    writeln ('7. Exportar-1');
    writeln ('8. Exportar-2');
    writeln ('9. Salir');
    writeln ('-------------------');
    readln (op);
    while (op <> 9) do begin
        case op of
            1: crearArchivo(arc);
            2: listarEmpleados1(arc);
            3: listarEmpleados2(arc);
            4: jubilarse(arc);
            5: agregar(arc);
            6: modificar(arc);
            7: exportar(arc);
            8: exportar2(arc);
        end;
        writeln ('-------------------');
        writeln ('1. Generar archivo');
        writeln ('2. Ver empleados');
        writeln ('3. Ver todos los empleados');
        writeln ('4. Ver empleados proximos a jubilarse');
        writeln ('5. Agregar');
        writeln ('6. Modificar');
        writeln ('7. Exportar-1');
        writeln ('8. Exportar-2');
        writeln ('9. Salir');
        writeln ('-------------------');
        readln (op);
    end;
end.