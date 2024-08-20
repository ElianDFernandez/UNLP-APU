// 4. Realizar un programa que lea 1000 números enteros desde teclado. Informar en pantalla cuáles son
// los dos números mínimos leídos.
// a. Modifique el ejercicio anterior para que, en vez de leer 1000 números, la lectura finalice al leer
// el número 0, el cual debe procesarse.
// b. Modifique el ejercicio anterior para que, en vez de leer 1000 números, la lectura finalice al leer
// el número 0, el cual no debe procesarse

program ejercicio4;

var 
    min1,min2:integer;
    num:integer;
    i:integer;
begin 
    min1:=999;
    min2:=999;
    for i:=1 to 10 do begin 
        writeln('Ingrese un numero: ');
        readln(num);
        if(num < min1) then begin
            min2:=min1;
            min1:=num;
        end
        else if (num < min2)  then 
            min2:=num;
    end;
    writeln('Minimo 1: ', min1);
    writeln('Minimo 2: ', min2);
end.
