//* 3. Implementar un programa que contenga:
//* a. Un módulo que lea información de alumnos de Taller de Programación y los almacene en
//*     una estructura de datos. De cada alumno se lee legajo, DNI, año de ingreso y los códigos y
//*     notas de los finales rendidos. La estructura generada debe ser eficiente para la búsqueda por
//*     número de legajo. La lectura de los alumnos finaliza con legajo 0 y para cada alumno el ingreso
//*     de las materias finaliza con el código de materia -1.
//* b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.
//* c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.
//* d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.
//* e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.
//* f. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del alumno con mayor promedio.
//* g. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.

program ejercicio3;

type 
    materia=record 
        codigo:integer;
        nota:real;
    end;

    lista=^nodo;
    nodo=record 
        dato:materia;
        sig:lista;
    end;

    alumno=record
        legajo:integer;
        dni:integer;
        ingreso:string;
        materias:lista;
    end;

    arbol=^nodoa;
    nodoa=record
        dato:alumno;
        HI:arbol;
        HD:arbol;
    end;

procedure leerMateria(var m:materia);
begin 
    writeln('Ingrese el codigo de la materia: ');
    readln(m.codigo);
    if (m.codigo <> -1) then begin 
        writeln('Ingrese la nota de materia: ');
        readln(m.nota);
    end;
end;

procedure agregarMateria(var l:lista; m:materia);
var 
    nue:lista;
begin 
    new(nue);
    nue^.dato:=m;
    nue^.sig:=l;
    l:=nue;
end;

procedure cargarMaterias(var l:lista);
var 
    m:materia;
begin 
    l:=nil;
    leerMateria(m);
    while(m.codigo <> -1) do begin 
        agregarMateria(l,m);
        leerMateria(m);
    end;
end;

procedure leerAlumno(var a:alumno);
begin
    writeln('Ingrese legajo del alumno: ');
    readln(a.legajo);
    if (a.legajo <> 0) then begin 
        writeln('Ingrese dni del alumno: ');
        readln(a.dni);
        writeln('Fecha de ingreso: ');
        readln(a.ingreso);
        cargarMaterias(a.materias);
    end;
end;

procedure agregarNodoArbol(var ab:arbol; a:alumno);
var 
    nue:arbol;
begin 
    if (ab = nil) then begin 
        new(nue);
        nue^.dato:=a;
        nue^.HI:=nil;
        nue^.HD:=nil;
        ab:=nue;
    end
    else if (ab^.dato.legajo > a.legajo) then 
        agregarNodoArbol(ab^.HI,a)
    else 
        agregarNodoArbol(ab^.HD,a)
end;

procedure cargarAlumnos(var ab:arbol);
var 
    a:alumno;
begin 
    leerAlumno(a);
    while (a.legajo <> 0) do begin 
        agregarNodoArbol(ab,a);
        leerAlumno(a);
    end;
end;

//* b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.
procedure moduloB(ab:arbol; legajo:integer);
begin 
    if (ab <> nil) then begin
        if (ab^.dato.legajo < legajo) then begin
            writeln('Alumno con legajo: ', ab^.dato.legajo, ' y fecha de ingreso: ', ab^.dato.ingreso, '. Cumple condicion.');
            moduloB(ab^.HI,legajo);
            moduloB(ab^.HD,legajo);
        end
        else 
            moduloB(ab^.HI,legajo);
    end;
end;

//* c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.
function legajoMayor(ab:arbol):integer;
begin  
    if (ab^.HD = nil) then 
        legajoMayor:= ab^.dato.legajo
    else 
        legajoMayor:= legajoMayor(ab^.HD);
end;

//* d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande. Recorda que el arbol no esta ordenado por dni 
procedure buscarDniMax(a: arbol; var maxDNI: integer);
begin 
    if (a<> nil) then begin
        buscarDniMax(a^.HI, maxDni);
        if (a^.dato.dni < maxDNI)then begin
			maxDNI:= a^.dato.dni;
        end;
        buscarDniMax(a^.HD, maxDni);
    end;
end;

//* e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con legajo impar.
function cantidadLegajosImpares(a:arbol):integer;
begin 
    if (a = nil) then 
        cantidadLegajosImpares:= 0
    else begin 
        if (a^.dato.legajo mod 2 <> 0) then 
            cantidadLegajosImpares:= 1 + cantidadLegajosImpares(a^.HI) + cantidadLegajosImpares(a^.HD)
        else 
            cantidadLegajosImpares:= cantidadLegajosImpares(a^.HI) + cantidadLegajosImpares(a^.HD);
    end;
end;

//* f. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del alumno con mayor promedio.

procedure imprimirNotas(l:lista);
begin 
    writeln('Notas del alumno: ');
    while (l <> nil) do begin 
        writeln('Codigo: ', l^.dato.codigo, ' Nota: ', l^.dato.nota:0:2);
        l:= l^.sig;
    end;
end;

function calcularPromedio(l:lista):real;
var 
    suma:real;
    cant:integer;
begin
    imprimirNotas(l);
    suma:=0;
    cant:=0;
    while (l <> nil) do begin 
        suma:= suma + l^.dato.nota;
        cant:= cant + 1;
        l:= l^.sig;
    end;
    calcularPromedio:= suma/cant;
end;

procedure buscarMayorPromedio(a:arbol; var mayorPromedio:real; var legajoMayorPromedio:integer);
var 
    promedio:real;
begin
    if (a <> nil) then begin 
        promedio:= calcularPromedio(a^.dato.materias);
        if (promedio > mayorPromedio) then begin 
            mayorPromedio:= promedio;
            legajoMayorPromedio:= a^.dato.legajo;
        end;
        buscarMayorPromedio(a^.HI,mayorPromedio,legajoMayorPromedio);
        buscarMayorPromedio(a^.HD,mayorPromedio,legajoMayorPromedio);
    end;
end;

//* g. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.
procedure buscarPromedioMayor(a:arbol; promedio:real);
begin 
    if (a <> nil) then begin 
        if (calcularPromedio(a^.dato.materias) > promedio) then begin 
            writeln('Legajo: ', a^.dato.legajo, ' Promedio: ', calcularPromedio(a^.dato.materias):0:2);
        end;
        buscarPromedioMayor(a^.HI,promedio);
        buscarPromedioMayor(a^.HD,promedio);
    end;
end;


var 
    ab:arbol;
    legajoMayorPromedio:integer;
    mayorPromedio:real;
    dniMax:integer;
begin 
    ab:=nil;
    cargarAlumnos(ab);
    moduloB(ab,10);
    writeln('El numero de legajo mayor ingresado es: ', legajoMayor(ab));
    dniMax:=-1;
    buscarDniMax(ab,dniMax);
    writeln('El DNI mayor es: ', dniMax);
    writeln('La cantidad de legajos impares es: ', cantidadLegajosImpares(ab));
    mayorPromedio:=-1.0;
    legajoMayorPromedio:=0;
    buscarMayorPromedio(ab,mayorPromedio,legajoMayorPromedio);
    writeln('El legajo del alumno con mayor promedio es: ', legajoMayorPromedio);
    buscarPromedioMayor(ab,6);
end.
