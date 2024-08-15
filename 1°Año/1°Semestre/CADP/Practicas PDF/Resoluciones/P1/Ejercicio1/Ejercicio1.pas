// .Realizar un programa que lea 2 números enteros desde teclado e informe en pantalla cuál de los
// dos números es el mayor. Si son iguales debe informar en pantalla lo siguiente: “Los números leídos
// son iguales

program ejercicio1;

var 
    num1:integer;
    num2:integer;
begin   
    writeln('Ingrese los dos numeros: ');
    readln(num1);
    readln(num2);
    if (num1 = num2) then 
        writeln('Los numero leidos son iguales')
    else 
        writeln('Los numero leidos no son iguales');
end.