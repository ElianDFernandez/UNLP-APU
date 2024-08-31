program Ejercicio1;

type 
    vector = array [1..100] of integer;

procedure imprimirOcurrencias(v:vector);
var 
    i:integer;
begin
    for i:=1 to 100 do begin 
        if (v[i] > 0) then 
            writeln('Valor ', i, ' cantidad de ocurrencias ', v[i]);
    end;
end;

procedure inicializarVector(var v:vector);
var 
    i:integer;
begin 
    for i:=1 to 100 do 
        v[i]:=0;
end;

procedure cargarVector(var v:vector);
var     
    num:integer;
begin 
    inicializarVector(v);
    writeln('Ingrese un valor: ');
    readln(num);
    while (num <> 0) do begin 
        v[num]:= v[num] + 1;
        writeln('Ingrese un valor: ');
        readln(num);
    end;
end;

var 
    v:vector;
begin 
    cargarVector(v);
    imprimirOcurrencias(v);
end.