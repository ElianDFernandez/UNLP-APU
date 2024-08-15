program ejer1;
// Implemente un programa que lea por teclado dos números enteros e imprima en pantalla los
// valores leídos en orden inverso. Por ejemplo, si se ingresan los números 4 y 8, debe mostrar el
// mensaje: Se ingresaron los valores 8 y 4

var 
    num1:integer;
    num2:integer;
begin 
    writeln('Ingrese el numero 1: ');
    readln(num1);
    writeln('Ingrese el numero 2: ');
    readln(num2);
    writeln('Se ingresaron los valores ' ,num2, ' y ', num1 );
end.
