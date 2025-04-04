//? 1.- Implementar  un  programa  que  procese la información  de los  alumnos  de  la  Facultad  de 
//? Informática.  
// a)  Implementar  un  módulo  que  lea  y  retorne,  en  una  estructura  adecuada,  la  información  de 
// todxs  los  alumnos.  De  cada  alumno  se  lee  su  apellido,  número  de  alumno,  año  de  ingreso, 
// cantidad de materias aprobadas (a lo sumo 36) y nota obtenida (sin contar los aplazos) en cada 
// una  de  las  materias  aprobadas.  La  lectura  finaliza  cuando  se  ingresa  el  número  de  alumno 
// 11111, el cual debe procesarse. 
// b)  Implementar  un  módulo  que  reciba  la  estructura  generada  en  el inciso  a)  y  retorne  número 
// de alumno y promedio de cada alumno.
// c) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de 
// materias  aprobadas  de  cada  alumno,  y  si  además  se  desean  registrar  los  aplazos?  ¿cómo 
// puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?

program ej1;

const 
    dimf=36;
type 
    vector = array [1..dimf] of real;

    alumno = record 
        apellido:string;
        numero:integer;
        anioIngreso:integer;
        cantMaterias:1..dimf;
        notasMaterias:vector;
    end;

    lista = ^nodo;
    nodo = record 
        dato: alumno;
        sig:lista;
    end;

procedure cargarNotasMaterias(var v:vector; diml:integer);
var 
    i:integer;
begin 
    for i:=1 to diml do begin 
        writeln('Ingrese la nota ', i, ': ');
        readln(v[i]);
    end;
end;

procedure leerAlumno(var a:alumno);
begin 
    writeln('Ingrese apellido del alumno:');
    readln(a.apellido);
    writeln('Ingrese numero del alumno');
    readln(a.numero);
    if (a.numero <> 11111) then begin 
        writeln('Ingrese anio de ingreso de alumno');
        readln(a.anioIngreso);
        writeln('Ingrese la cantidad de materias aprobadas por el alumno');
        readln(a.cantMaterias);
        cargarNotasMaterias(a.notasMaterias, a.cantMaterias);
    end;
end;

procedure agregarAdelante (var l:lista; a:alumno);
var 
    nuevo:lista;
begin 
    new(nuevo);
    nuevo^.dato := a;
    nuevo^.sig := l;
    l := nuevo;
end;

// (B)
procedure promedioAlumno(a:alumno; var promedio:real);
var 
    i:integer;
    suma:real;
begin 
    suma:=0;
    for i:=1 to a.cantMaterias do begin 
        suma:=suma+a.notasMaterias[i];
    end;
    promedio:=suma/a.cantMaterias;
end;

procedure imprimirPromedioAlumno(l:lista);
var 
    promedio:real;
begin
    while (l <> nil) do begin 
        promedioAlumno(l^.dato, promedio);
        writeln('El promedio del alumno ', l^.dato.numero, ' es: ', promedio:2:2);
        l:=l^.sig;
    end;
end;

// (C
// ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de materias  aprobadas  de  cada  alumno,  y  si  además  se  desean  registrar  los  aplazos?
// ¿cómo puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?
// Se podria agregar una lista de materias al alumno, y se podria agregar un campo en cada una que indique si el alumno aprobo o desaprobo

procedure cargarLista(var l:lista);
var 
    a:alumno;
begin 
    leerAlumno(a);
    while (a.numero <> 11111) do begin 
        agregarAdelante(l,a);
        leerAlumno(a);
    end;
end;

var 
    l:lista;
begin 
    l:=nil;
    cargarLista(l);
    imprimirPromedioAlumno(l);
end.
