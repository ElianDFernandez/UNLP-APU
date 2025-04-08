// Se propone simular un juego que consiste en contar la cantidad de veces que es necesario generar al azar (Entre 0 a 10) para que coincida con un valor ingresado por telcado.
// Modifique el programa de la actividad 1 para que informe la cantidad de veces necesarias para que se de coincidencia.

program actividad2;

var numIngresado, numaleatorio, intentos:integer;

begin 
    writeln('Ingrese un numero entre el 0 y el 10');
    readln(numIngresado);
    Randomize;
    numaleatorio := random (10);
    intentos := 1;
    while (numIngresado <> numaleatorio) do begin 
        numaleatorio := random (10);
        intentos := intentos + 1;
    end;
    writeln('La cantidad de intentos necesarios para que coincida el numero ingresado con el numero aleatorio es: ', intentos);
end.