// 4.Implemente un programa que lea el diámetro Dde un círculo e imprima:
// a.El radio (R) del círculo (la mitad del diámetro)
// b.El área del círculo. Para calcular el área de un círculo debe utilizar la fórmula PI x R2
// c.El perímetro del círculo. Para calcular el perímetro del círculo debe utilizar la fórmula
// D*PI (o también PI*R*2)

program ejercicio4;

var 
    diametro:real;
begin 
    writeln('Pi: ', pi);
    writeln('Ingrese el diametro del circulo: ');
    readln(diametro);
    writeln('Radio del circulo: ', diametro/2);
    writeln('Area del circulo: ', (diametro/2)*(diametro/2)*pi);
    writeln('Perimetro del circulo: ', (diametro/2)*2*pi);
end.