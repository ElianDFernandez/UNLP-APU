{
    6. Suponga que trabaja en una oficina donde está montada una LAN (red local). La misma fue
    construida sobre una topología de red que conecta 5 máquinas entre sí y todas las
    máquinas se conectan con un servidor central. Semanalmente cada máquina genera un
    archivo de logs informando las sesiones abiertas por cada usuario en cada terminal y por
    cuánto tiempo estuvo abierta. Cada archivo detalle contiene los siguientes campos:
    cod_usuario, fecha, tiempo_sesion. Debe realizar un procedimiento que reciba los archivos
    detalle y genere un archivo maestro con los siguientes datos: cod_usuario, fecha,
    tiempo_total_de_sesiones_abiertas.
    Notas:
    ● Cada archivo detalle está ordenado por cod_usuario y fecha.
    ● Un usuario puede iniciar más de una sesión el mismo día en la misma máquina, o
    inclusive, en diferentes máquinas.
    ● El archivo maestro debe crearse en la siguiente ubicación física: /var/log
}

program Ejercicio6;
const
    dimf = 3 {5};
    valorAlto = 9999;
type
    sesion = record
        cod: integer;
        fecha: string;
        tiempo: integer;
    end;
    archivo = file of sesion;
    archivoDet = file of sesion;
    vecArcDet = array[1..dimf] of archivoDet; 
    vecRegDet = array[1..dimf] of sesion;

procedure leer(var arc: archivoDet; var reg: sesion);
begin
    if not eof(arc) then
        read(arc, reg)
    else
        reg.cod := valorAlto;
end;

procedure minimo(var vecDet: vecArcDet; var vecReg: vecRegDet; var min: sesion);
var
    pos,i: integer;
begin
    min.cod := valorAlto;
    for i := 1 to dimf do
        if (vecReg[i].cod < min.cod) or (vecReg[i].cod = min.cod) and (vecReg[i].fecha < min.fecha) then begin
            min := vecReg[i];
            pos := i;
        end;
    if (min.cod <> valorAlto) then
        leer(vecDet[pos],vecReg[pos]);
end;

procedure crearMaestro (var vecArcDetalles: vecarcDet; var mae: archivo);
var 
    min: sesion;
    i: integer;
    aux: sesion;
    vecRegDetalles: vecRegDet;
begin
    assign(mae,'maestro.bin');
    rewrite(mae);
    for i := 1 to dimf do
        reset(vecArcDetalles[i]);
    minimo(vecArcDetalles,vecRegDetalles,min);
    while (min.cod <> valorAlto) do begin
        aux.cod := min.cod;
        while (min.cod = aux.cod) do begin
            aux.fecha := min.fecha;
            aux.tiempo := 0;
            while (min.cod = aux.cod) and (min.fecha = aux.fecha) do begin
                aux.tiempo := aux.tiempo + min.tiempo;
                minimo(vecArcDetalles,vecRegDetalles,min);
            end;
            write(mae,aux);
        end;
    end;
    for i := 1 to dimf do
        close(vecArcDetalles[i]);
    close(mae);
end;

{ Procedimientos pruebas }
procedure crearDetalle (var detalleBin: archivoDet; num: integer);
var 
    detText: text;
    reg: sesion;
    nombre: string;
begin 
    writeln('Ingrese el nombre del archivo de detalle ' , num , ': ');
    readln(nombre);
    assign(detText, nombre);
    reset(detText);
    writeln('Ingrese el nombre del archivo de binario ' , num , ': ');
    readln(nombre);
    assign(detalleBin, nombre);
    rewrite(detalleBin);
    while not eof(detText) do begin
        readln(detText,reg.cod,reg.tiempo,reg.fecha);
        write(detalleBin,reg);
    end;
    close(detText);
    close(detalleBin);
end;

procedure crearDetalles (var vec: vecArcDet);
var 
    i: integer;
begin
    for i := 1 to dimf do
        crearDetalle(vec[i], i);
end;

procedure imprimir (var arc: archivo);
var 
    reg: sesion;
begin
    reset(arc);
    while not eof(arc) do begin
        read(arc,reg);
        writeln(reg.cod,' ',reg.tiempo,' ',reg.fecha);
    end;
    close(arc);
end;

{ Programa Principal }
var 
    vec: vecArcDet;
    mae: archivo;
begin
    crearDetalles(vec);
    crearMaestro(vec,mae);
    imprimir(mae);
end.