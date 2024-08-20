//  Realizar un programa que lea desde teclado información de autos de carrera. Para cada uno de los
//  autos se lee el nombre del piloto y el tiempo total que le tomó finalizar la carrera. En la carrera
//  participaron 100 autos. Informar en pantalla:
//  - Los nombres de los dos pilotos que finalizaron en los dos primeros puestos.
//  - Los nombres de los dos pilotos que finalizaron en los dos últimos puestos

program ejercicio7;

procedure tiempos(nombre:string; tiempo:real; var primerTiem,segundoTiem,anteUltimoTiem,ultimoTiem:real; var primeroNom,segundoNom,anteUltimoNom,ultimoNom:string);
begin 
    if (tiempo < primerTiem) then begin 
        segundoTiem:=primerTiem;
        segundoNom:=primeroNom;
        primerTiem:=tiempo;
        primeroNom:=nombre;
    end
    else if (tiempo < segundoTiem)then begin 
        segundoTiem:=tiempo;
        segundoNom:=nombre;
    end;
    if (tiempo > ultimoTiem) then begin 
        anteUltimoTiem:= ultimoTiem;
        anteUltimoNom:= ultimoNom;
        ultimoNom:=nombre;
        ultimoTiem:=tiempo;
    end 
    else if (tiempo > anteUltimoTiem) then begin 
        anteUltimoTiem:= tiempo;
        anteUltimoNom:= nombre;
    end;
end;

var 
    nombre:string;
    tiempoTotal:real;
    i:integer;
    primeroNom:string;
    segundoNom:string;
    primerTiem:real;
    segundoTiem:real;
    ultimoNom:string;
    anteUltimoNom:string;
    ultimoTiem:real;
    anteUltimoTiem:real;

begin 
    primerTiem:=99999;
    segundoTiem:=99999;
    ultimoTiem:=0;
    anteUltimoTiem:=0;
    for i:=1 to 4 do begin
        writeln('Nombre del piloto: ');
        readln(nombre); 
        writeln('Ingrese timepo total del piloto: ');
        readln(tiempoTotal);
        tiempos(nombre,tiempoTotal,primerTiem,segundoTiem,anteUltimoTiem,ultimoTiem,primeroNom,segundoNom,anteUltimoNom,ultimoNom);
    end;
    writeln('Primero: ', primeroNom);
    writeln('Segujndo: ', segundoNom);
    writeln('Ante ultimo: ', anteUltimoNom);
    writeln('Ultimo: ', ultimoNom);
end.