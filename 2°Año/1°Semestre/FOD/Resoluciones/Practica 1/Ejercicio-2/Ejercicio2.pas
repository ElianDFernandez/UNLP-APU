{
    2. Realizar un algoritmo, que utilizando el archivo de números enteros no ordenados
        creado en el ejercicio 1, informe por pantalla cantidad de números menores a 1500 y el
        promedio de los números ingresados. El nombre del archivo a procesar debe ser
        proporcionado por el usuario una única vez. Además, el algoritmo deberá listar el
        contenido del archivo en pantalla.
}

program Ejercicio2;

type 
    archivo = file of integer;

procedure informeArchivo(var arc: archivo; var cantidadMenores:integer; var promedio:real);
var 
    num:integer;
begin 
    reset(arc);
    cantidadMenores:=0;
    promedio:=0;
    while not eof(arc) do begin 
        read(arc, num);
        if (num < 1500) then 
            cantidadMenores := cantidadMenores + 1;
        promedio := promedio + num;
    end;
    promedio := promedio / filesize(arc);
end;

var 
    arc : archivo;
    cantidadMenores : integer;
    promedio : real;
    nombreArch : string;
begin 
    write('Nombre del archivo a procesar: ');
    read(nombreArch);
    assign(arc,nombreArch);
    informeArchivo(arc, cantidadMenores, promedio);
    writeln('Cantidad de numero menores a 1500: ', cantidadMenores);
    writeln('Promedio de los numeros ingresados: ', (promedio):2:2);
end.
