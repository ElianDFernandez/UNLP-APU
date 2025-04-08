program vectores;

const
    dimF = 10;

type 
    vector = array [1..dimF] of integer;

procedure agregar(var v:vector; var dimL:integer; e:integer; var exito:boolean);
begin 
    if (dimL < dimF) then begin
        dimL := dimL + 1;
        v[dimL] := e;
        exito := true;
    end
    else begin
        exito := false;
    end;
end;

procedure crearVector(var v:vector; var dimL:integer);
var 
    i:integer;
    ok:boolean;
begin 
    Randomize;
    for i:=1 to dimF do begin
        agregar(v, diml, random(100), ok);
        if (not ok) then begin
            writeln('No hay mas lugar en el vector');
            exit;
        end;
    end;
    agregar(v, i, 50, ok);
    if (not ok) then begin
        writeln('No hay mas lugar en el vector');
    end;
end;

procedure eliminarElementoVector(var v:vector; var dimL:integer; e:integer);
var 
    i:integer;
    ok:boolean;
begin
    ok:=false;
    i := 1;
    while (i <= dimL) and (v[i] <> e) do begin
        i := i + 1;
    end;
    if (i <= dimL) then begin
        ok:=true;
        for i:=i to dimL-1 do begin
            v[i] := v[i+1];
        end;
        dimL := dimL - 1;
    end;
    if (ok) then begin
        writeln('Elemento eliminado');
    end
    else begin
        writeln('Elemento inexistente en el vector');
    end;
end;

procedure imprimirVector(var v:vector; dimL:integer);
var 
    i:integer;
begin
    writeln('Vector: ');
    writeln('----------------------------');
    for i:=1 to dimL do begin
        write(v[i],'|');
    end;
    writeln;
    writeln('----------------------------');
end;

var 
    v:vector;
    dimL:integer;
    i:integer;
begin 
    dimL := 0;
    crearVector(v, dimL);
    writeln('Vector generado');
    imprimirVector(v, dimL);
    writeln('Eliminamos el elemento 50');
    eliminarElementoVector(v, dimL, 50);
    imprimirVector(v, dimL);
end.