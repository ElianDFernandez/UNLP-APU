//  4.Realizar un programa que lea un número real X. Luego, deberá leer números reales hasta que se
//  ingrese uno cuyo valor sea exactamente el doble de X (el primer número leído)

program ejercicio4;

var 
    fin:real;
    x:real;
begin 
    writeln('Ingrese un numero: ');
    readln(x);
    fin:=2*x;
    writeln('Ingrese un numero: ');
    readln(x);
    while (x<>fin) do
    begin
        writeln('Ingrese un numero: ');
        readln(x);
    end;
end.