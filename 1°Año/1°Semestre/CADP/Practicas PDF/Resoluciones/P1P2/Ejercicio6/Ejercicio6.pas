// 6. Realizar un programa que lea información de 200 productos de un supermercado. De cada producto
// se lee código y precio (cada código es un número entre 1 y 200). Informar en pantalla:
// - Los códigos de los dos productos más baratos.
// - La cantidad de productos de más de 16 pesos con código par.


program Ejercicio6;
type 
    codigos = 1..100;
    
procedure minimos(var codigoMB1, codigoMB2: codigos; var precioMB1, precioMB2: real; codigo: codigos; precio: real);
begin
    if (precio < precioMB1) then begin 
        precioMB2 := precioMB1;
        codigoMB2 := codigoMB1;
        precioMB1 := precio;
        codigoMB1 := codigo;
    end
    else if (precio < precioMB2) then begin 
        precioMB2 := precio;
        codigoMB2 := codigo;
    end;
end;


var 
    codigo:codigos;
    precio:real;
    codigoMB1:codigos;
    precioMB1:real;
    codigoMB2:codigos;
    precioMB2:real;
    condicion:integer;
    i:integer;
begin  
    precioMB1:=0;
    precioMB2:=0;
    condicion:=0;
    for i:=1 to 5 do begin 
        writeln('Ingrese codigo del prodcuto: ');
        readln(codigo);
        writeln('Precio: ');
        readln(precio);
        minimos(codigoMB1, codigoMB2, precioMB1, precioMB2, codigo, precio);
        if (precio < 16) and (codigo MOD 2 = 0) then 
            condicion:=condicion+1;
    end;
    writeln('Producto minimo 1: codigo: ',codigoMB1,' precio: ',precioMB1);
    writeln('Producto minimo 2: codigo: ',codigoMB2,' preico: ',precioMB2);
    writeln('Productos que cumplen ultima condicion: ',condicion);
end.