//  Modifique el ejercicio anterior para que, luego de leer el número X, se lean alosumo10 números
//  reales. La lectura deberá finalizar al ingresar un valor que sea el doble de X, o al leer el décimo
//  número, en cuyo caso deberá informarse “No se ha ingresado el doble de X”.

program ejercicio5;

var
    x:real;
    fin:real;
    i:integer;
begin 
    writeln('Ingrese un numero: ');
    readln(x);
    fin:=2*x;
    for i:=1 to 10 do
    begin
        writeln('Ingrese un numero: ');
        readln(x);
        if (x=fin) then
        begin
            writeln('Se ha ingresado el doble de: ', fin/2:1:2);
            break;
        end;
    end;
end.
