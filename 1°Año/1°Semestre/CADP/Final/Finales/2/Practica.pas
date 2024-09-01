program ejercicio1;

// se dispone de la infomracion de participantes inscriptos a una carrero(a lo sumo 5000) de cada participante se tiene 
// DNI, nombre y apellido, categoria (1..5) y fecha de inscripcion. Se pide implementar un programa que guarde en una 
// estructura adecuada los participantes de aquella categorias que posean a los suma 50 inscriptos. Se sabe que cada participante
// se puede anotar en una sola categoria.

const 
    dimf=5000;
type 
    participante = record 
        dni:integer;
        nombre:string;
        apellido:string;
        categoria:1..5;
        fechaInscripccion:string;
    end;

    lista = ^nodo;
    nodo = record 
        dato:participante;
        sig:lista;
    end;

    vectorContador = array [1..5] of integer;
    vectorInfo = array [1..dimf] of participante;

procedure inicializarVector(var v:vectorContador);
var 
    i:integer;
begin 
    for i:=1 to 5 do
        v[i]:=0;
end;

procedure contabilizarCategorias(v:vectorInfo; diml:integer; var vc:vectorContador);
var 
    i:integer;
begin 
    inicializarVector(vc);
    for i:=1 to diml do begin 
        vc[v[i].categoria] := vc[v[i].categoria] + 1;
    end;
end;

procedure agregarAlista(var l:lista, p:participante);
var 
    nue:lista;
begin 
    new(nue);
    nue^.dato:=p;
    nue^.sig:=l;
    l:=nue;
end;

procedure generarNuevaLista(var l:lista; vc:vectorContador; v:vectorInfo; diml:integer);
var 
    i:integer;
begin 
    for i:= 1 to diml do begin 
        if (vc[v[i].categoria] <= 50) then 
            agregarAlista(l,v[i]);
    end;
end;

var 
    diml:integer;
    vc:vectorContador;
    v:vectorInfo;
    l:lista;
begin 
    l:=nil;
    diml:=0;
    cargarInfo(v,diml); //Ya se dispone
    contabilizarCategorias(v,diml,vc);
    generarNuevaLista(l,vc,v,diml);
end.
