program forProblems;
// Prueba por V o F de: 3) Una estructura de control FOR siempre se ejecuta al menos una vez.
// FALSO, si el final es menor que el inicio, nunca se ejecuta el for.
var 
    i:integer;
    puntero:^integer;
begin 
    new(puntero);
    for i:=10 to 10 do begin 
        writeln('Hola');
        readln(puntero^);
        writeln(puntero^);
    end;
end.