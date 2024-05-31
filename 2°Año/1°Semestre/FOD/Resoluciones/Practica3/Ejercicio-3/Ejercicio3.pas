{
    3. Realizar un programa que genere un archivo de novelas filmadas durante el presente
    año. De cada novela se registra: código, género, nombre, duración, director y precio.
    El programa debe presentar un menú con las siguientes opciones:
    a. Crear el archivo y cargarlo a partir de datos ingresados por teclado. Se
    utiliza la técnica de lista invertida para recuperar espacio libre en el
    archivo. Para ello, durante la creación del archivo, en el primer registro del
    mismo se debe almacenar la cabecera de la lista. Es decir un registro
    ficticio, inicializando con el valor cero (0) el campo correspondiente al
    código de novela, el cual indica que no hay espacio libre dentro del
    archivo.
}
{
    b. Abrir el archivo existente y permitir su mantenimiento teniendo en cuenta el
    inciso a., se utiliza lista invertida para recuperación de espacio. En
    particular, para el campo de  ́enlace ́ de la lista, se debe especificar los
    números de registro referenciados con signo negativo, (utilice el código de
    novela como enlace).Una vez abierto el archivo, brindar operaciones para:
        i. Dar de alta una novela leyendo la información desde teclado. Para
        esta operación, en caso de ser posible, deberá recuperarse el
        espacio libre. Es decir, si en el campo correspondiente al código de
        novela del registro cabecera hay un valor negativo, por ejemplo -5,
        se debe leer el registro en la posición 5, copiarlo en la posición 0
        (actualizar la lista de espacio libre) y grabar el nuevo registro en la
        posición 5. Con el valor 0 (cero) en el registro cabecera se indica
        que no hay espacio libre.
        ii. Modificar los datos de una novela leyendo la información desde
        teclado. El código de novela no puede ser modificado.
        iii. Eliminar una novela cuyo código es ingresado por teclado. Por
        ejemplo, si se da de baja un registro en la posición 8, en el campo
        código de novela del registro cabecera deberá figurar -8, y en el
        registro en la posición 8 debe copiarse el antiguo registro cabecera.
}
{
    c. Listar en un archivo de texto todas las novelas, incluyendo las borradas, que
    representan la lista de espacio libre. El archivo debe llamarse “novelas.txt”.
    NOTA: Tanto en la creación como en la apertura el nombre del archivo debe ser
    proporcionado por el usuario.
}

program Ejercicio3;

type
    novela=record
        cod:integer;
        gen:string;
        nom:string;
        duracion:integer;
        direc:string;
        precio:real;
    end;

    archivo = file of novela;

procedure leerNovela(var n:novela);
begin
    writeln('Ingrese Codigo de novela: ');
    readln(n.cod);
    if (n.cod <> 0) then begin
        writeln('Ingrese Genero: ');
        readln(n.gen);
        writeln('Ingrese Nombre: ');
        readln(n.nom);
        writeln('Ingrese Duracion: ');
        readln(n.duracion);
        writeln('Ingrese Director: ');
        readln(n.direc);
        writeln('Ingrese Precio: ');
        readln(n.precio);
    end;
end;

procedure creacionArchivo(var arc:archivo);
var 
    nom: string;
    n: novela;
begin 
    writeln('Ingrese Nombre del archivo a crear: ');
    readln(nom);
    assign(arc,nom);
    rewrite(arc);
    n.cod:= 0; n.gen:=''; n.nom:=''; n.duracion:=0; n.direc:=''; n.precio:=0.0;
    write(arc, n);
    leerNovela(n);
    while (n.cod <> 0) do begin
        write(arc, n);
        leerNovela(n);
    end;
    close(arc);
end;

procedure altaRecuperandoEspacio(var arc: archivo);
var
    n: novela;
    cabecera: novela;
begin
    reset(arc);
    read(arc, cabecera);
    leerNovela(n);
    if (cabecera.cod = 0) then begin
        seek(arc, filesize(arc));
        write(arc, n);
    end
    else begin
        seek(arc, cabecera.cod * -1);
        read(arc, cabecera);
        seek(arc, filepos(arc) - 1);
        write(arc, n);
        seek(arc, 0);
        write(arc, cabecera);
    end;
    close(arc);
end;

procedure modificar(var arc: archivo);
var 
    cod: integer;
    n: novela;
begin 
    reset(arc);
    writeln('Ingrese Codigo de novela: ');
    readln(cod);
    read(arc, n);
    while (not eof(arc)) and (n.cod <> cod) do
        read(arc, n);
    if (n.cod = cod) then begin
        writeln('Ingrese Nombre: ');
        readln(n.nom);
        writeln('Ingrese Genero: ');
        readln(n.gen);
        writeln('Ingrese Duracion: ');
        readln(n.duracion);
        writeln('Ingrese Director: ');
        readln(n.direc);
        writeln('Ingrese Precio: ');
        readln(n.precio);
        seek(arc, filepos(arc) - 1);
        write(arc, n);
    end
    else
        writeln('Codigo de novela no encontrado.');
    close(arc);
end;

procedure borrar(var arc: archivo);
var 
    cod: integer;
    n: novela;
    cabecera: novela;
    ok: boolean;
begin
    ok:= false;
    reset(arc);
    writeln('Ingrese Codigo de novela: ');
    readln(cod);
    read(arc, cabecera);
    while not eof(arc) and (not ok) do begin
        read(arc, n);
        if (n.cod = cod) then begin 
            ok:= true;
            seek(arc, filepos(arc) - 1);
            write(arc, cabecera);
            cabecera.cod:= (filepos(arc)-1)*-1;
            seek(arc, 0);
            write(arc, cabecera);
        end;
    end;
    if ok then
        writeln('Novela eliminada.')
    else
        writeln('Codigo de novela no encontrado.');
    close(arc);
end;

procedure listarTxt(var arc: archivo);
var 
    arcText: text;
    n: novela;
    nom: string;
begin
    writeln('Ingrese Nombre del archivo de texto: ');
    readln(nom);
    assign(arcText, nom);
    rewrite(arcText);
    reset(arc);
    while not eof(arc) do begin
        read(arc, n);
        writeln(arcText, n.cod, ' ', n.gen, ' ', n.nom, ' ', n.duracion, ' ', n.direc, ' ', n.precio);
    end;
    close(arc);
    close(arcText);
end;

procedure asginarYaCreado(var arc: archivo);
var 
    nom: string;
begin
    writeln('Ingrese Nombre del archivo: ');
    readln(nom);
    assign(arc, nom);
end;

procedure menu(var arc: archivo);
var 
    op: integer;
begin
    repeat
        writeln('MENU');
        writeln('1. Crear');
        writeln('2. Cargar Binario');
        writeln('3. Cargar Novela');
        writeln('4. Modificar');
        writeln('5. Borrar');
        writeln('6. Listar');
        writeln('0. Salir');
        readln(op);
        case op of
            1: creacionArchivo(arc);
            2: asginarYaCreado(arc);
            3: altaRecuperandoEspacio(arc);
            4: modificar(arc);
            5: borrar(arc);
            6: listarTxt(arc);
        end;
    until (op = 0);
end;

var 
    arc: archivo;
begin
    menu(arc);
end.



