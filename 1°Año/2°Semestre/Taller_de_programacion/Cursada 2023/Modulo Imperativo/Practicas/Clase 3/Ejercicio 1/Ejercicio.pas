// 1. Escribir un programa que:
// a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol
//  binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza
//  con el número de socio 0 y el árbol debe quedar ordenado por número de socio.

Program socios;

type 
    socio=record
        numero:integer;
        nombre:string;
        edad:1..100;
    end;

    arbol=^nodo;
    nodo=record 
        dato:socio;
        HI:arbol;
        HD:arbol;
    end;

procedure leerSocio(var s:socio);
begin 
    write('Ingrese numero del socio: ');
    readln(s.numero);
    if (s.numero <> 0) then begin 
        write('Ingrese nombre del socio: ');
        readln(s.nombre);
        write('Ingrese edad del socio:');
        readln(s.edad);
    end;
end;

procedure agregarNodo(var a:arbol; s:socio);
var 
    nue:arbol;
begin 
    if (a = nil) then begin
        new(nue);
        nue^.dato:=s;
        nue^.HI:=nil;
        nue^.HD:=nil;
        a := nue;
    end
    else 
        if (a^.dato.numero <= s.numero) then 
            agregarNodo(a^.HI,s)
        else 
            agregarNodo(a^.HD,s);
end; 

procedure cargarSocios(var a:arbol);
var 
    s:socio;
begin 
    leerSocio(s);
    while(s.numero <> 0) do begin 
        agregarNodo(a,s);
        leerSocio(s);
    end;
end;

// b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como
//  parámetro y que :
//  i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.
//  ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un módulo recursivo que retorne dicho socio.
//  iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
//  iv. Aumente en 1 la edad de todos los socios.
//  v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a un módulo recursivo que reciba el valor leído y retorne verdadero o falso.
//  vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
//  vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
//  viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del inciso vii e invocar a un módulo recursivo que retorne la suma de las edades de los socios.
//  xi. Informe los números de socio en orden creciente.
//  x. Informe los números de socio pares en orden decreciente.

//  i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.
function maximo(a:arbol):integer;
begin 
    if (a = nil) then
        maximo := -1
    else if (a^.HD = nil) then  
        maximo:=a^.dato.numero
    else 
        maximo:=maximo(a^.HD);
end;

//  ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un módulo recursivo que retorne dicho socio.
function minimoNodo(a:arbol):arbol;
begin 
    if (a=nil) then 
        minimoNodo:=nil
    else if (a^.HI = nil) then 
        minimoNodo:=a
    else 
        minimoNodo:= minimoNodo(a^.HI);
end;

//  iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
procedure buscarMayorEdad(a: arbol; var maxEdad: integer);
begin
    if (a <> nil) then begin
        if (a^.dato.edad > maxEdad) then
            maxEdad := a^.dato.edad;
        
        buscarMayorEdad(a^.HI, maxEdad);
        buscarMayorEdad(a^.HD, maxEdad);
    end;
end;

//  iv. Aumente en 1 la edad de todos los socios.
procedure aumentarEdad(var a: arbol; aumento: integer);
begin 
    if (a <> nil) then begin
        a^.dato.edad := a^.dato.edad + aumento;
        aumentarEdad(a^.HI, aumento);
        aumentarEdad(a^.HD, aumento);
    end;
end;

//  v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a un módulo recursivo que reciba el valor leído y retorne verdadero o falso.
function existeNumero(a: arbol; num: integer): boolean;
begin 
    if (a = nil) then 
        existeNumero:=false
    else if (a^.dato.numero = num) then 
        existeNumero:=true
    else if (a^.dato.numero < num) then 
        existeNumero:=existeNumero(a^.HI, num)
    else 
        existeNumero:=existeNumero(a^.HD, num);
end;

//  vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
function existeNombre(a:arbol; nombre:string):boolean;
begin 
    if(a=nil) then 
        existeNombre:=false
    else if (a^.dato.nombre = nombre) then 
        existeNombre:=true
    else
        existeNombre:=existeNombre(a^.HI,nombre) or existeNombre(a^.HD,nombre);
end;

//  vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
function cantidadTotalDeSocios(a:arbol):integer;
begin 
    if (a = nil) then 
        cantidadTotalDeSocios:=0
    else 
        cantidadTotalDeSocios:=1 + cantidadTotalDeSocios(a^.HI) + cantidadTotalDeSocios(a^.HD);
end;

//  viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del inciso
function promedioEdad(a:arbol):real;
    function sumaEdades(a:arbol):integer;
    begin 
        if (a = nil) then 
            sumaEdades:=0
        else 
            sumaEdades:=a^.dato.edad + sumaEdades(a^.HI) + sumaEdades(a^.HD);
    end;
begin
    if (cantidadTotalDeSocios(a) = 0) then 
        promedioEdad:=0
    else 
        promedioEdad:=sumaEdades(a) / cantidadTotalDeSocios(a);
end;

//  xi. Informe los números de socio en orden creciente.
procedure informeNumerosSocioscreciente(a:arbol);
begin 
    if (a <> nil) then begin 
        informeNumerosSocioscreciente(a^.HD);
        writeln('Numero: ', a^.dato.numero);
        informeNumerosSocioscreciente(a^.HI);
    end;
end;

//  x. Informe los números de socio pares en orden decreciente.
procedure informeNumerosSociosDecreciente(a:arbol);
begin 
    if (a <> nil) then begin 
        informeNumerosSociosDecreciente(a^.HI);
        writeln('Numero: ', a^.dato.numero);
        informeNumerosSociosDecreciente(a^.HD);
    end;
end;

// Imprimir arbol 
procedure imprimirArbol(a:arbol);
begin 
    if (a <> nil) then begin 
        writeln('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
        imprimirArbol(a^.HI);
        imprimirArbol(a^.HD);
    end;
end;

var 
    a:arbol;
    nodoAux:arbol;
    aux:integer;
    auxString:String;
begin 
    a:=nil;
    cargarSocios(a);
    writeln('Arbol cargado: ');
    imprimirArbol(a);
    aux:= maximo(a);
    writeln('i. Numero de socio mas grande: ', aux);
    nodoAux:= minimoNodo(a);
    if (nodoAux <> nil) then 
        writeln('ii. Datos del socio con el numero mas chico: numero:', nodoAux^.dato.numero, ' nombre: ', nodoAux^.dato.nombre, ' edad: ',nodoAux^.dato.edad);
    aux:=0;
    buscarMayorEdad(a,aux);
    writeln('iii. Numero de socio con mayor edad: ', aux);
    aumentarEdad(a,1);
    writeln('iv. Edades aumentadas en 1: ');
    imprimirArbol(a);
    writeln('Ingrese un numero para buscar si existe un socio con ese numero: ');
    readln(aux);
    if (existeNumero(a,aux)) then 
        writeln('v. Existe un socio con ese numero')
    else 
        writeln('v. No existe un socio con ese numero');
    writeln('Ingrese un nombre de un socio para buscar si existe un socio');
    readln(auxString);
    if (existeNombre(a,auxString)) then 
        writeln('vi. Existe un socio con ese nombre')
    else 
        writeln('vi. No existe un socio con ese nombre');
    writeln('vii. Cantidad total de socios: ',cantidadTotalDeSocios(a));
    writeln('viii. Promedio de edad de los socios: ',promedioEdad(a):0:2);
    writeln('xi. Numeros de socios en orden creciente: ');
    informeNumerosSocioscreciente(a);
    writeln('x. Numeros de socios pares en orden decreciente: ');
    informeNumerosSociosDecreciente(a);
end.
