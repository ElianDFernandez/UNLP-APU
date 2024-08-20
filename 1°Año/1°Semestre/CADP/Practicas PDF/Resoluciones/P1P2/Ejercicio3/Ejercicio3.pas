// 3. Realizar un programa que lea desde teclado la información de alumnos ingresantes a la carrera
// Analista en TIC. De cada alumno se lee nombre y nota obtenida en el módulo EPA (la nota es un
// número entre 1 y 10). La lectura finaliza cuando se lee el nombre “Zidane Zinedine“, que debe
// procesarse. Al finalizar la lectura informar:
// - La cantidad de alumnos aprobados (nota 8 o mayor) y
// - la cantidad de alumnos que obtuvieron un 7 como nota

program ejercicio3;

type
    alumno=record
        nombre:string;
        nota:1..10;
    end;
var
    alu:alumno;
    cantAprobados:integer;
    cantConSiete:integer;
begin 
    cantAprobados:=0;
    cantConSiete:=0;
    repeat  
        write('Ingrese el nombre del alumno: ');
        readln(alu.nombre);
        write('Ingrese nota: ');
        readln(alu.nota);
        if (alu.nota > 8) then 
            cantAprobados:=cantAprobados+1;
        if (alu.nota = 7) then 
            cantConSiete:=cantConSiete+1;
    until (alu.nombre = 'Zidane Zinedine');
    writeln ('Cantidad de aprobados: ', cantAprobados);
    writeln ('Cantidad con siete: ', cantConSiete);1
end.