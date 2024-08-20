program ejercicio3;

// 3.Realizar un programa que lea 3 números enteros y los imprima en orden descendente.
// Por ejemplo, si se ingresan los valores 4, -10 y 12, deberá imprimir:
// 12    4    -10

var 
    num1:integer;
    num2:integer;
    num3:integer;
begin 
    writeln('Ingrese el numero 1: ');
    readln(num1);
    writeln('Ingrese el numero 2: ');
    readln(num2);
    writeln('Ingrese el numero 3: ');
    readln(num3);
    if (num1 > num2) and (num1 > num3) then 
        if (num2 > num3) then 
            writeln(num1, ' ', num2, ' ', num3)
        else 
            writeln(num1, ' ', num3, ' ', num2)
    else 
        if (num2 > num3) then 
            if (num1 > num3) then 
                writeln(num2, ' ', num1, ' ', num3)
            else 
                writeln(num2, ' ', num3, ' ', num1)
        else 
            if (num1 > num2) then 
                writeln(num3, ' ', num1, ' ', num2)
            else 
                writeln(num3, ' ', num2, ' ', num1)
end.