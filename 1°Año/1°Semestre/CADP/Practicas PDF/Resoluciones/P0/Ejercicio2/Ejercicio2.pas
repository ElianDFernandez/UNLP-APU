program ejer2;
// Modifique el programa anterior para que el mensaje de salida muestre la suma de ambos
// números:
// a.Utilizando una variable adicional
// b.Sin utilizar una variable adiciona

var 
    num1:integer;
    num2:integer;
    suma:integer;
begin 
    writeln('Ingrese el numero 1: ');
    readln(num1);
    writeln('Ingrese el numero 2: ');
    readln(num2);
    writeln('Se ingresaron los valores ' ,num2, ' y ', num1 );

    suma:=num1+num2;

    writeln('A. utilizando variable adicional: ', suma);
    writeln('B. sin utilizar variable adicional: ', num1 + num2);
end.