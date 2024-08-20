//  Un local de ropa desea analizar las ventas realizadas en el último mes. Para ello se lee por cada día
//  del mes, los montos de las ventas realizadas. La lectura de montos para cada día finaliza cuando se
//  lee el monto 0. Se asume un mes de 31 días. Informar la cantidad de ventas por cada día, y el monto
//  total acumulado en ventas de todo el mes.
//  a) Modifique el ejercicio anterior para que además informe el día en el que se realizó la
//  mayor cantidad de ventas.


program ejercicio8;

procedure mayor(monto:real; dia:integer; var diaMayorVenta:integer; var diaMayorVentaMonto:real);
begin   
    if (monto > diaMayorVentaMonto) then begin 
        diaMayorVenta:= dia;
        diaMayorVentaMonto:= monto;
    end;
end;

var 
    monto:real;
    sumatotaldia:real;
    totalmes:real;
    d,m:integer;
    diaMayorVenta:integer;
    diaMayorVentaMonto:real;
begin   
    for m:=1 to 12 do begin 
        totalmes:=0;
        diaMayorVentaMonto:=0;
        for d:= 1 to 3 do begin 
            writeln('Dia: ', d ,' Ingrese el monto de ventas realizadas:');
            readln(monto);
            mayor(monto,d, diaMayorVenta, diaMayorVentaMonto);
        end;
        writeln('Dia de mayor ventas del mes: ', diaMayorVenta);
    end;
end.
