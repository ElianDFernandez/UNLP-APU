// 5.Un kiosquero debe vender una cantidad Xde caramelos entre Yclientes, dividiendo
// cantidades iguales entre todos los clientes. Los que le sobren se los quedará para él.
// a.Realice un programa que lea la cantidad de caramelos que posee el kiosquero (X),
// la cantidad de clientes (Y), e imprima en pantalla un mensaje informando la
// cantidad de caramelos que le corresponderá a cada cliente, y la cantidad de
// caramelos que se quedará para sí mismo.
// b.Imprima en pantalla el dinero que deberá cobrar el kiosquero si cada caramelo
// tiene un valor de $1.60

program caramelos;

var 
    x:integer;
    y:integer;

begin 
    writeln('Cuantos caramelos posee el kiosquero?');
    readln(x);
    writeln('Entre cuantas personas hay que dividirlos?');
    readln(y);
    writeln('A cada persona le corresponde: ' , x DIV y);
    writeln('Sobran: ', x MOD y);
    writeln('Total a cobrar: ', (x DIV y)*y  * 1.60:1:2);
end.