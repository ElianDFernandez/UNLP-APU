program forProblems;
// Prueba por V o F de: 3) Una estructura de control FOR siempre se ejecuta al menos una vez.
// FALSO, si el final es menor que el inicio, nunca se ejecuta el for.
var 
    i:integer;
begin 
    for i:=1 to -1 do begin 
        writeln('Hola');
    end;
end.