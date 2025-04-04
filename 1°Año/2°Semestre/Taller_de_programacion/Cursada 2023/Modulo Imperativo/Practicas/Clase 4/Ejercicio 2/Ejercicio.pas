//* 2.Una biblioteca nos ha encargado procesar la información de los préstamos realizados
//* durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
//* y mes del préstamo y cantidad de días prestados. Implementar un programa con:
//* a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de los préstamos. La lectura de los préstamos finaliza con ISBN -1. 
//* Las estructuras deben ser eficientes para buscar por ISBN.
//* i. En una estructura cada préstamo debe estar en un nodo.
//* ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN. (prestar atención sobre los datos que se almacenan).
//* b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más grande.
//* c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más pequeño.
//* d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.
//* e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.
//* f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
//* que se prestó.
//* g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
//* que se prestó.
//* h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.
//* i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El módulo debe retornar la cantidad total de préstamos realizados a los ISBN
//* comprendidos entre los dos valores recibidos (incluidos).
//* j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El módulo debe retornar la cantidad total de préstamos realizados a los ISBN
//* comprendidos entre los dos valores recibidos (incluidos).

program ejercicio2;

type 
    prestamo1=record
        isbn:integer;
        socio:integer;
        dia:1..31;
        mes:1..12;
        dias:integer;
    end;

    arbol1=^nodo1;
    nodo1=record 
        dato:prestamo1;
        HI:arbol1;
        HD:arbol1;
    end;

    prestamoLista=record
        socio:integer;
        dia:1..31;
        mes:1..12;
        dias:integer;
    end;

    lista=^nodo;
    nodo=record 
        dato:prestamoLista;
        sig:lista;
    end;

    prestamo2=record 
        isbn:integer;
        prestamos:lista;
    end;

    arbol2=^nodo2;
    nodo2=record 
        dato:prestamo2;
        HI:arbol2;
        HD:arbol2;
    end;

procedure leerPrestamo1(var p1:prestamo1);
begin 
    writeln('Ingrese el ISBN del libro: ');
    readln(p1.isbn);
    if (p1.isbn <> -1) then begin 
        writeln('Ingrese el numero de socio: ');
        readln(p1.socio);
        writeln('Ingrese el dia del prestamo: ');
        readln(p1.dia);
        writeln('Ingrese el mes del prestamo: ');
        readln(p1.mes);
        writeln('Ingrese la cantidad de dias prestados: ');
        readln(p1.dias);
    end;
end;

procedure agregarNodo1(var a:arbol1; p1:prestamo1);
var 
    nue:arbol1;
begin
    if (a = nil) then begin
        new(nue);
        nue^.dato:=p1;
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end
    else if (a^.dato.isbn > p1.isbn) then 
        agregarNodo1(a^.HI,p1)
    else 
        agregarNodo1(a^.HD,p1);
end;

procedure agregarPrestamos(var l:lista; pl:prestamoLista);
var 
    nue:lista;
begin
    new(nue);
    nue^.dato:=pl;
    nue^.sig:=l;
    l:=nue;
end;

procedure agregarNodo2(var a:arbol2; p1:prestamo1);
var 
    nue:arbol2;
    pl:prestamoLista;
begin
    if (a = nil) then begin
        new(nue);
        nue^.dato.isbn:=p1.isbn;
        nue^.dato.prestamos:=nil;
        pl.socio:=p1.socio;
        pl.dia:=p1.dia;
        pl.mes:=p1.mes;
        pl.dias:=p1.dias;
        agregarPrestamos(nue^.dato.prestamos,pl);
        nue^.HI:=nil;
        nue^.HD:=nil;
        a:=nue;
    end
    else if (a^.dato.isbn = p1.isbn) then begin
        pl.socio:=p1.socio;
        pl.dia:=p1.dia;
        pl.mes:=p1.mes;
        pl.dias:=p1.dias;
        agregarPrestamos(a^.dato.prestamos,pl);
    end
    else if (a^.dato.isbn > p1.isbn) then 
        agregarNodo2(a^.HI,p1)
    else 
        agregarNodo2(a^.HD,p1);
end;

procedure cargarPrestamos(var a1:arbol1; var a2:arbol2);
var 
    p1:prestamo1;
begin
    leerPrestamo1(p1);
    while (p1.isbn <> -1) do begin
        agregarNodo1(a1,p1);
        agregarNodo2(a2,p1);
        leerPrestamo1(p1);
    end;
end;

procedure imprimirArbol1(a:arbol1);
begin
    if (a <> nil) then begin
        imprimirArbol1(a^.HI);
        writeln('ISBN: ',a^.dato.isbn);
        writeln('Socio: ',a^.dato.socio);
        writeln('Dia: ',a^.dato.dia);
        writeln('Mes: ',a^.dato.mes);
        writeln('Dias: ',a^.dato.dias);
        imprimirArbol1(a^.HD);
    end;
    writeln('-----------------------');
end;

procedure imprimirArbol2(a:arbol2);
var 
    aux:lista;
begin
    if (a <> nil) then begin
        imprimirArbol2(a^.HI);
        writeln('ISBN: ',a^.dato.isbn);
        aux:=a^.dato.prestamos;
        while (aux <> nil) do begin
            writeln('Socio: ',aux^.dato.socio);
            writeln('Dia: ',aux^.dato.dia);
            writeln('Mes: ',aux^.dato.mes);
            writeln('Dias: ',aux^.dato.dias);
            aux:=aux^.sig;
            writeln('-----------------------');
        end;
        imprimirArbol2(a^.HD);
        writeln('-----------------------');
    end;
end;

//* b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más grande.
function isbnMasGrande(a:arbol1):integer;
begin 
    if (a^.HD = nil) then 
        isbnMasGrande:=a^.dato.isbn
    else 
        isbnMasGrande:=isbnMasGrande(a^.HD);
end;

//* c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más pequeño.
function isbnMasChico(a:arbol2):integer;
begin 
    if (a^.HI = nil) then 
        isbnMasChico:=a^.dato.isbn
    else 
        isbnMasChico:=isbnMasChico(a^.HI);
end;

//* d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.
function cuantosPrestamos(a:arbol1; socio:integer):integer;
begin 
    if (a = nil) then
        cuantosPrestamos:=0
    else if (a^.dato.socio = socio) then 
        cuantosPrestamos := cuantosPrestamos(a^.HI,socio) + cuantosPrestamos(a^.HD,socio) + 1
    else 
        cuantosPrestamos := cuantosPrestamos(a^.HI,socio) + cuantosPrestamos(a^.HD,socio)
end;

//* e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El módulo debe retornar la cantidad de préstamos realizados a dicho socio.
function contadorPrestamosLista(l:lista; socio:integer):integer;
var 
    contador:integer;
begin
    contador:=0;
    while (l <> nil) do begin 
        if (l^.dato.socio = socio) then 
            contador:= contador + 1;
        l:=l^.sig;
    end;
    contadorPrestamosLista:=contador;
end;

function cuantosPrestamos2(a:arbol2; socio:integer):integer;
begin 
    if (a = nil) then 
        cuantosPrestamos2:=0
    else 
        cuantosPrestamos2 := cuantosPrestamos2(a^.HI,socio) + cuantosPrestamos2(a^.HD, socio) + contadorPrestamosLista(a^.dato.prestamos,socio);
end; 

//* f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
//* que se prestó.



var 
    a1:arbol1;
    a2:arbol2;
begin
    a1:=nil;
    a2:=nil;
    cargarPrestamos(a1,a2);
    writeln('Arbol 1: ');
    imprimirArbol1(a1);
    writeln('Arbol 2: ');
    imprimirArbol2(a2);
    writeln('b. ISBN mas grande: ',isbnMasGrande(a1));
    writeln('c. ISBN mas chico: ',isbnMasChico(a2));
    writeln('d. Prestamos realizados por el socio 1 (Arbol): ', cuantosPrestamos(a1,1));
    writeln('e. Prestamos realizados por el socio 2 (Lista): ', cuantosPrestamos2(a2,1));
end.