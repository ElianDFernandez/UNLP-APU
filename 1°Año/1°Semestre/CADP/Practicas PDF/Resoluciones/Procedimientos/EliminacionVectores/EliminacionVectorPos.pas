procedure eliminarPos(var v:vector; var diml:integer; pos:integer; var ok:boolean);
var 
    i:integer;
begin 
    ok:=false;
    if (pos >= 1) and (pos <= diml) then begin
        ok:=true;
        for i:=pos to diml-1 do 
            v[i]:=v[i+1];
        diml:=diml-1;
    end;
end;

procedure eliminarNumRepVecOrd(var v:vector; var diml:integer; dato:integer; var ok:boolean);
var
    i:integer;
    cant:integer;
    pos:integer;
begin
    ok := false;
    i := 1;  // Inicializamos i
    cant := 0;
    // Buscamos la posición del primer dato
    while (i <= diml) and (v[i] < dato) do
        i := i + 1;
    if (i > diml) then
        ok := false
    else begin
        ok := true;
        pos := i;  // Guardamos la posición inicial
        // Contamos cuántas veces está el dato repetido
        while (i <= diml) and (v[i] = dato) do begin
            cant := cant + 1;
            i := i + 1;
        end;
    end;
    // Si encontramos repeticiones, eliminamos los elementos repetidos
    if (cant > 0) then begin
        for i := pos to diml - cant do 
            v[i] := v[i + cant];
        diml := diml - cant;  // Ajustamos la dimensión lógica
    end;
end;