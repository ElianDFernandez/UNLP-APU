// Realizar un programa que lea tres caracteres, e informe si los tres eran letras vocales o si al menos
// uno de ellos no lo era. Por ejemplo, si se leen los caracteres “a e o” deberá informar “Los tres son
// vocales”, y si se leen los caracteres “z a g” deberá informar “al menos un carácter no era vocal”.

program ejercicio8;

var 
    caracter1:char;
    caracter2:char;
    caracter3:char;

begin
    writeln('Ingrese el primer caracter: ');
    readln(caracter1);
    writeln('Ingrese el segundo caracter: ');
    readln(caracter2);
    writeln('Ingrese el tercer caracter: ');
    readln(caracter3);

    if ((caracter1 = 'a') or (caracter1 = 'e') or (caracter1 = 'i') or (caracter1 = 'o') or (caracter1 = 'u')) then
        if ((caracter2 = 'a') or (caracter2 = 'e') or (caracter2 = 'i') or (caracter2 = 'o') or (caracter2 = 'u')) then
            if ((caracter3 = 'a') or (caracter3 = 'e') or (caracter3 = 'i') or (caracter3 = 'o') or (caracter3 = 'u')) then
                writeln('Los tres son vocales')
            else
                writeln('Al menos un caracter no era vocal')
        else
            writeln('Al menos un caracter no era vocal')
    else
        if ((caracter2 = 'a') or (caracter2 = 'e') or (caracter2 = 'i') or (caracter2 = 'o') or (caracter2 = 'u')) then
            if ((caracter3 = 'a') or (caracter3 = 'e') or (caracter3 = 'i') or (caracter3 = 'o') or (caracter3 = 'u')) then
                writeln('Al menos un caracter no era vocal')
            else
                writeln('Al menos un caracter no era vocal')
        else
            writeln('Al menos un caracter no era vocal');
end.