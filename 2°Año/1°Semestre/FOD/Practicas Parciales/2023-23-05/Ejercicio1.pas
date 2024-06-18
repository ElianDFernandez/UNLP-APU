program parcial;

type 
    profesional = record 
        dni:integer;
        nombre:string;
        apellido:string;
        sueldo:real;
    end;
    archivo = file of profesional;

procedure crear(var arch:archivo; var info:text);
var 
    p:profesional;
begin 
    rewrite(arch);
    reset(info);
    p.dni:=0;
    p.nombre:='';
    p.apellido:='';
    p.sueldo:=0;
    write(arch,p);
    while not eof(info) do begin 
        readln(info, p.dni, p.nombre);
        readln(info, p.sueldo, p.apellido);
        write(arch,p);
    end;
    write('Archivo Generado.');
    close(info);
    close(arch);
end;

procedure agregar(var arch:archivo; p:profesional);
var 
    aux:profesional;
begin 
    reset(arch);
    read(arch,aux);
    if (aux.dni = 0) then begin 
        seek(arch,filesize(arch)-1);
        write(arch,p);
    end
    else begin 
        seek(arch, aux.dni*-1);
        read(arch, aux);
        seek(arch, filepos(arch)-1);
        write(arch, p);
        seek(arch,0);
        write(arch,aux);
    end;
    close (arch);
end;

procedure eliminar(var arch:archivo; dni:integer; var bajas:text);
var 
    p:profesional;
    ok:boolean;
    aux: profesional;
begin 
    reset(arch);
    read(arch,aux);
    reset(bajas);
    ok:=false;
    while not eof(arch) and not ok do begin 
        read(arch,p);
        if(p.dni = dni) then begin 
            ok:=true;
            writeln(bajas, p.dni,' ',p.nombre);
            writeln(bajas, p.sueldo,' ',p.apellido);
            seek(arch,filepos(arch)-1);
            write(arch,aux);
            aux.dni:=(filepos(arch)-1)*-1;
            seek(arch,0);
            write(arch,aux);
        end;
    end;
    if ok then 
        write('Profesional eliminado')
    else 
        write('Profesional no encontrado');
    close(arch);
end;

var 
    archText:text;

    archBin:archivo;
begin 
    assign(archText,'archivoText.txt');
    assign(archBin,'archivoBin.dat');
    crear(archBin,archText);
    eliminar(archBin,42884131,)
end.