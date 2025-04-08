program parcial;
type 
    rangoString = 'A'..'F';
    atencion = record 
        dniPaciente:integer;
        dia:1..31;
        diagnostico: rangoString;
    end;

    lista = ^nodoL;
    nodoL = record 
        dato:atencion;
        sig:lista;
    end;

    arbol = ^nodo;
    nodo = record 
        matricula:integer;
        atenciones:lista;
        atencionesRealizadas:integer;
        HI:arbol;
        HD:arbol;
    end;

    listaDni = ^nodoDni;
    nodoDni = record
        dni:integer;
        sig:listaDni;
    end;

    vector = array [1..6] of listaDni;

procedure leerAtencion(var a:atencion);
begin 
    write('Ingrese DNI del paciente: ');
    readln(a.dniPaciente);
    if (a.dniPaciente <> 0) then begin 
        write('Ingrese DIA de la atencion: ');
        readln(a.dia);
        write('Ingrese DIAGNOSTICO del paciente:');
        readln(a.diagnostico);
    end;
end;

procedure agregarAtencion(var l:lista; a:atencion);
var 
    nue:lista;
begin 
    new(nue);
    nue^.sig:=l;
    nue^.dato:=a;
    l:=nue;
end;

procedure iniciarVector(var v:vector);
var 
    i:integer;
begin
    for i:=1 to 6 do 
        v[i] := nil;
end;

function buscarDni(l:listaDni; dni:integer):boolean;
begin 
    if (l = nil) then 
        buscarDni:=false
    else if (l^.dni = dni) then 
        buscarDni:=true
    else 
        buscarDni:= buscarDni(l^.sig,dni);
end;

procedure agregarDni(var l:listaDni; dni:integer);
var 
    nue:listaDni;
begin 
    new(nue);
    nue^.sig:=l;
    nue^.dni:=dni;
    l:=nue;
end;

procedure agregarNodo(var a:arbol; m:integer; at:atencion);
var
    nue:arbol;
begin
    if(a = nil) then begin 
        new(nue);
        nue^.matricula := m;
        nue^.atenciones := nil;
        agregarAtencion(nue^.atenciones, at);
        nue^.atencionesRealizadas:=1;
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end
    else if (a^.matricula = m) then begin 
        agregarAtencion(a^.atenciones,at);
        a^.atencionesRealizadas:=a^.atencionesRealizadas+1;
    end
    else if (m > a^.matricula) then 
        agregarNodo(a^.HD,m,at)
    else 
        agregarNodo(a^.HI,m,at);
end;

function diagnosticaAInt(d: char): integer;
begin
    case d of
        'A': diagnosticaAInt := 1;
        'B': diagnosticaAInt := 2;
        'C': diagnosticaAInt := 3;
        'D': diagnosticaAInt := 4;
        'E': diagnosticaAInt := 5;
        'F': diagnosticaAInt := 6;
    else
        diagnosticaAInt := -1;
    end;
end;

function diagnosticaAChar(d: integer):char;
begin
    case d of
        1: diagnosticaAChar := 'A';
        2: diagnosticaAChar := 'B';
        3: diagnosticaAChar := 'C';
        4: diagnosticaAChar := 'D';
        5: diagnosticaAChar := 'E';
        6: diagnosticaAChar := 'F';
    end;
end;

procedure cargarArbolYVector(var a:arbol; var v:vector);
var 
    m:integer;
    at:atencion;
begin 
    write('Ingrese la MATRICULA del medico: ');
    readln(m);
    leerAtencion(at);
    while (at.dniPaciente <> 0) do begin 
        agregarNodo(a,m,at);
        if (buscarDni(v[diagnosticaAInt(at.diagnostico)], at.dniPaciente) = true) then 
            agregarDni(v[diagnosticaAInt(at.diagnostico)], at.dniPaciente);
        write('Ingrese la MATRICULA del medico: ');
        readln(m);
        leerAtencion(at);
    end;
end;

function moduloB(a:arbol; m:integer):integer;
begin
    if (a=nil) then 
        moduloB:=0
    else if (a^.matricula > m) then 
        moduloB:= moduloB(a^.HI,m) + moduloB(a^.HD,m) + a^.atencionesRealizadas
    else 
        moduloB:= moduloB(a^.HD,m);
end;        

function contarPacientes(l: listaDni): integer;
begin
    if (l = nil) then
        contarPacientes := 0
    else
        contarPacientes := 1 + contarPacientes(l^.sig);
end;

function moduloC(v: vector; i,maxAtendidos, maxDiagnostico: integer): integer;
var
    cantidad: integer;
begin
    if (i > 6) then
        moduloC := maxDiagnostico
    else begin
        cantidad := contarPacientes(v[i]);
        if (cantidad > maxAtendidos) then begin
            maxAtendidos := cantidad;
            maxDiagnostico := i;
            moduloC := moduloC(v, i + 1, maxAtendidos, maxDiagnostico);
        end
        else
            moduloC := moduloC(v, i + 1, maxAtendidos, maxDiagnostico);
    end;
end;

var 
    a:arbol;
    v:vector;
begin
    a:=nil;
    iniciarVector(v);
    cargarArbolYVector(a,v);
    writeln('Atencion de matriculas mayores que 2: ',moduloB(a,2));
    writeln('Diagnostico con mas atendidos: ', diagnosticaAChar(moduloC(v, 1, -1, -1)));
end.