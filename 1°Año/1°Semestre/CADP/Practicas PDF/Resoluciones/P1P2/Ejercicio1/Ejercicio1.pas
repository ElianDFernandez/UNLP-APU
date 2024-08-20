// 1. Realizar un programa que lea 10 números enteros e informe la suma total de los números leídos.
// a. Modifique el ejercicio 1 para que además informe la cantidad de números mayores a 5

program ejercicio1;

var 
    vector: array [1..10] of integer;
    i:integer;
    suma:integer;
    mayor5:integer;
begin 
    suma:=0;
    mayor5:=0;
    for i:=1 to 10 do begin
        writeln('Ingrese el valor ',i);
        readln(vector[i]);
        suma:=suma+vector[i];
        if (vector[i]>5) then 
            mayor5:=mayor5+1;
    end;
    writeln('La suma de los valores es: ',suma);
    writeln('La cantidad de valores mayores a 5 es: ',mayor5);
end.