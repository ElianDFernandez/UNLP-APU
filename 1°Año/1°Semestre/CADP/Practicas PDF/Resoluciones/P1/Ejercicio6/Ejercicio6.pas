//  Realizar un programa que lea el número de legajo y el promedio de cada alumno de la facultad. La
//  lectura finaliza cuando se ingresa el legajo -1, que no debe procesarse.
//  Por ejemplo, se lee la siguiente secuencia:
//  33423
//  8.40
//  19003
//  6.43
//  -1
//  En el ejemplo anterior, se leyó el legajo 33422, cuyo promedio fue 8.40, luego se leyó el legajo
//  19003, cuyo promedio fue 6.43, y finalmente el legajo -1 (para el cual no es necesario leer un
//  promedio).
//  Al finalizar la lectura, informar:
//  ○La cantidad de alumnos leída (en el ejemplo anterior, se debería informar 2)
//  ○La cantidad de alumnos cuyo promedio supera  6.5 (en el ejemplo anterior, se debería informar 1)
//  ○El porcentaje de alumnos destacados (alumnos con promedio mayor a 8.5) cuyo legajo sean
//  menor al valor 2500 (en el ejemplo anterior se debería informar 0%)

program ejercicio6;

var 
    legajo: integer;
    promedio: real;
    contador: integer;
    contadorPromedio: integer;
    porcentaje: real;
    promedioAlto: real;
    promedioBajo: real;

begin
    promedioAlto := 0;
    promedioBajo := 0;
    contador := 0;
    contadorPromedio := 0;
    writeln('Ingrese el legajo: ');
    readln(legajo);
    while (legajo <> -1) do
    begin
        writeln('Ingrese el promedio: ');
        readln(promedio);
        contador := contador + 1;
        if (promedio > 8.5) then
        begin
            contadorPromedio := contadorPromedio + 1;
        end;
        if (promedio > promedioAlto) then
        begin
            promedioAlto := promedio;
        end;
        if (promedio < promedioBajo) then
        begin
            promedioBajo := promedio;
        end;
        writeln('Ingrese el legajo: ');
        readln(legajo);
    end;
    porcentaje := (contadorPromedio / contador) * 100;
    writeln('La cantidad de alumnos leidos es: ', contador);
    writeln('La cantidad de alumno con promedio superior a 6.5 es: ', contadorPromedio);
    writeln('El porcentaje de alumnos destacados es: ', porcentaje:1:2, '%');
    writeln('El promedio mas alto es: ', promedioAlto:1:2);
    writeln('El promedio mas bajo es: ', promedioBajo:1:2);
end.