program ejercicio1;
const 
    valorAlto:=9999;
    dimf:=20;
type 
    venta=record
        cod:integer;
        cant:integer;
    end;

    detalle = file of venta;

    producto=record    
        cod:integer;
        nombre:string;
        precio:real;
        stockAct:integer;
        stockMin:integer;
    end;

    maestro = file of producto;

    vecArchDet = array [1..dimf] of detalle;
    vecRegDet = array [1..dimf] of venta;

procedure leer(var archD:detalle; var regD:venta);
begin 
    if(not eof(archD)) then 
        read(archD,regD);
    else 
        regD.cod:=valorAlto;
end;

procedure minimo(var vad:vecArchDet; var vrd:vecRegDet; var min:venta);
var 
    pos,i:integer;
begin 
    min.cod:=valorAlto;
    for i:=1 to dimf do begin 
        if (vrd[i].cod <= min.cod) then begin
            pos:=i;
            min:=vrd[i];
        end;
    end;
    if (min.cod <> valorAlto) then 
        leer(vad[pos],vrd[pos]);
end;

procedure actualizarMaestro(var mae:maestro; var vad:vecArcDetalle);
var 
    min:venta;
    regMae:producto;
    i:integer;
    archText:text;
    vrd:vecRegDet;
begin 
    assign(archText,'export.txt');
    rewrite(archText);
    reset(mae);
    for i:=1 to dimf do begin 
        reset(vad[i]);
        leer(vad[i],vrd[i]);
    end;
    minimo(vad,vrd,min);
    while (min.cod <> valorAlto) do begin
        read(mae,regMae):
        while (min.cod <> regMae.cod) do 
            read(mae,regMae);
        totalVendido:=0;
        while (regMae.cod = min.cod) do begin 
            regMae.stockAct:= regMae.stockAct-min.cant;
            totalVendido:=totalVendido+min.cant;
            minimo(vad,vrd,min);
        end;
         if (totalVendido * regMae.precio > 10000) then 
            writeln(archText, regMae.cod,' ', regMae.precio:0:2,' ',regMae.nombre,' ',regMae.stockAct,' ',regMae.stockMin);
        seek(mae, filepos(mae)-1);
        write(mae,regMae);
    end;