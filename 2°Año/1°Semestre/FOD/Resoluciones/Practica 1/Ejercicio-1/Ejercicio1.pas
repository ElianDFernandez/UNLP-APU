{
    1. Realizar un algoritmo que cree un archivo de números enteros no ordenados y permita
    incorporar datos al archivo. Los números son ingresados desde teclado. La carga finaliza
    cuando se ingresa el número 30000, que no debe incorporarse al archivo. El nombre del
    archivo debe ser proporcionado por el usuario desde teclado.
}

program Ejercicio1;

type 
    archivo = file of integer;

var
    arc: archivo;
    num: integer;
    nombreArc: string;

procedure cargar(var arc: archivo);
begin
    rewrite(arc);
    write('Ingrese un numero (30000 para terminar): ');
    readln(num);
    while (num <> 30000) do begin
        write(arc, num);
        write('Ingrese un numero (30000 para terminar): ');
        readln(num);
    end;
    close(arc);
end;

begin
    write('Ingrese el nombre del archivo a generar: ');
    readln(nombreArc);
    assign(arc, nombreArc);
    cargar(arc);
end.