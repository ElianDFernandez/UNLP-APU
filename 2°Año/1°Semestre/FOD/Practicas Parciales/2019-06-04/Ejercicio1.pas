program Ejercicio1;

const 
    valorAlto = 9999;
    dimf = 30;
type 
    venta = record 
        cod_farmaco:integer;
        nombre:string;
        fecha:integer;
        cantidad_vendida:integer;
        forma_pago:string;
    end;

    archivoDetalle = file of venta;
    vecArcDetalle = array [1..dimf] of archivoDetalle;
    vecRegDetalle = array [1..dimf] of venta;

procedure leer(var arc:archivoDetalle; var reg: venta);
begin 
    if not eof(arc) then 
        read(arc,reg);
    else 
        reg.cod_farmaco=valorAlto;
end;

procedure minimo(var vad: vecArcDetalle; var vrd: vecRegDetalle; var min: venta);
var 
    i,pos: integer;
begin 
    min.cod_farmaco := valorAlto;
    for i:= 1 to dimf do begin 
        if (vrd[i].cod_farmaco <= min.cod_farmaco) then begin 
            min:= vrg[i];
            pos:= i;
        end;
    end;
    if (min.cod_farmaco <> valorAlto) then 
        leer(vad[pos],vrg[pos]);
end;

procedure procesarArchivos(var vad: vecArcDetalle);
var 
    vrd: vecRegDetalle;
    min: venta;
    codActual: integer;
    fechaActual: integer;
    farmaco: integer;
    nombreActual: string;
    farmacoMasVendido, contadorFarmaco: integer;
    masVentasAlContado, contadorVentasContado: integer;
    fecha: integer;
    archivoNuevo: text;
    i: integer;
begin
    assign(archivoNuevo, 'archivoNuevo.txt');
    rewrite(archivoNuevo);
    for i := 1 to dimf do begin 
        reset(vad[i]);
        leer(vad[i], vrd[i]);
    end;
    minimo(vad, vrd, min);
    farmacoMasVendido := 0;
    masVentasAlContado := 0;

    while (min.cod_farmaco <> valorAlto) do begin
        codActual := min.cod_farmaco;
        nombreActual := min.nombre;
        contadorFarmaco := 0;

        while (codActual = min.cod_farmaco) do begin 
            fechaActual := min.fecha;
            contadorFarmaco := 0;
            contadorVentasContado := 0;

            while (codActual = min.cod_farmaco) and (fechaActual = min.fecha) do begin
                contadorFarmaco := contadorFarmaco + min.cantidad_vendida;
                if (min.forma_pago = 'contado') then
                    contadorVentasContado := contadorVentasContado + 1;
                minimo(vad, vrd, min);
            end;

            if (contadorVentasContado > masVentasAlContado) then begin
                masVentasAlContado := contadorVentasContado;
                fecha := fechaActual;
            end;

            // Escribir en el archivo nuevo
            writeln(archivoNuevo, codActual, ' ', nombreActual, ' ', fechaActual, ' ', contadorFarmaco);
        end;

        if (contadorFarmaco > farmacoMasVendido) then begin
            farmacoMasVendido := contadorFarmaco;
            farmaco := codActual;
        end;
    end;

    writeln('(a) Farmaco mas vendido: ', farmaco);
    writeln('(b) Fecha mas ventas al contado dia:',fecha,' Con ',masVentasAlContado,' ventas');

    close(archivoNuevo);
    writeln('Archivo generado exitosamente.');
    for i:= 1 to dimf do begin 
        close(vad[i]);
    end;
end;
