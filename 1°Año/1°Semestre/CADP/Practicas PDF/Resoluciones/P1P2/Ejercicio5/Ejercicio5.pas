// 5. Realizar un programa que lea números enteros desde teclado. La lectura debe finalizar cuando se
// ingrese el número 100, el cual debe procesarse. Informar en pantalla:
// ◦El número máximo leído.
// ◦El número mínimo leído.
// ◦La suma total de los números leídos.

program Ejercicio5;

var 
    num:integer;
    max:integer;
    min:integer;
    sum:integer;
begin
    sum:=0;
    max:=0;
    min:=999;
    repeat 
        writeln('Ingrse un numero: ');
        readln(num);
        sum:= sum + num;
        if (num > max) then
            max:=num;
        if (num < min) then 
            min:=num;
    until (num = 100);
    writeln('Numero menor: ', min);
    writeln('Numero mayor: ',max);
    writeln('Suma total: ', sum);
end.