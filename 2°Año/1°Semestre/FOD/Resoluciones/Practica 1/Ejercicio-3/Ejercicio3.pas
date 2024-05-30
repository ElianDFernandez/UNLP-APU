{
    3. Realizar un programa que presente un menú con opciones para:
    a. Crear un archivo de registros no ordenados de empleados y completarlo con
    datos ingresados desde teclado. De cada empleado se registra: número de
    empleado, apellido, nombre, edad y DNI. Algunos empleados se ingresan con
    DNI 00. La carga finaliza cuando se ingresa el String ‘fin’ como apellido.
    b. Abrir el archivo anteriormente generado y
        i. Listar en pantalla los datos de empleados que tengan un nombre o apellido
        determinado, el cual se proporciona desde el teclado.
        ii. Listar en pantalla los empleados de a uno por línea.
        iii. Listar en pantalla los empleados mayores de 70 años, próximos a jubilarse.
    NOTA: El nombre del archivo a crear o utilizar debe ser proporcionado por el usuario.
}

program Ejercicio3;

type 
    empleado = record
        num: integer;
        ape: string;
        nom: string;
        edad: integer;
        dni: integer;
    end;

    archivo = file of empleado;

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

var
    arc: archivo;
    nombreArc: string;
    op: integer;
begin
    writeln ('Ingrese el nombre del archivo: ');
    readln (nombreArc);
    assign(arc, nombreArc);
    writeln ('-------------------');
    writeln ('1. Cargar archivo');
    writeln ('2. Ver empleados');
    writeln ('3. Ver todos los empleados');
    writeln ('4. Ver empleados proximos a jubilarse');
    writeln ('-------------------');
    writeln ('Ingrese una opcion: ');
    readln (op);
    case op of
        1: crearArchivo(arc);
        2: listarEmpleados1(arc);
        3: listarEmpleados2(arc);
        4: jubilarse(arc);
    end;
end.