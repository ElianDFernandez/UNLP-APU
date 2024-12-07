# AR

σ Seleccion
π Proyeccion
^ And
v Or 
x Producto cartesiano 
|x| Producto natural

Especialistas = (<u>Matricula</u>, nombre, apellido, domicilio)
ObraSocial = (<u>nombre</u>, descripcion)
Paciente = (<u>DNI</u>,nombre, apellido, domicilio, telefono)
Turno = (<u>{matricula(fk),DNI(fk),fecha},</u>, motivo, nombre(fk)?, observaciones?) // El nombre es el de la obra social

1.Para los turno del 26/06/2022 listar matricula,nombre y apellido de los especialistas, DNI, nombre, apellido, telefono de los pacientes involucrados, fecha del turno, nombre y descripcion de la obra social. 

AR

ER = (ρ nombreE←nombre,apellidoE←apellido (Especialistas))
PR = (ρ nombreP←nombre,domicilioP←domicilio (Paciente))
filtrado = σ fecha='2024-11-07' (ER ⋈ Turno ⨝ ObraSocial ⨝ PR) 
π matricula,nombreE,apellidoE,DNI,nombreP,apellido,telefono,fecha,descripcion,nombre (filtrado)

2.Listar los datos de los pacientes que se atendieron con todos los especialistas

AR

DniPacientes = π DNI, matricula (Turno) ÷ π matricula (Especialistas)
π DNI, nombre, apellido, domicilio, telefono (Paciente ⋈ DniPacientes)

SQL

SELECT p.nombre 
FROM Paciente p 
WHERE NOT EXISTS (
    SELECT * FROM Especialistas e WHERE NOT EXISTS (
        SELECT * FROM Turno t WHERE t.DNI = p.DNI AND t.matricula = e.matricula)
    );

3.Lista las pacientes que se atendieron en el año 2021 pero no se atendieron en el año 2019

AR

atendidos2021 = σ fecha = '2021' Turno
atendidos2019 = σ fecha = '2019' Turno
Paciente ⨝ (π DNI (atendidos2021-atendidos2019))

SQL 

SELECT DISTINCT p.*
FROM Paciente p
INNER JOIN Turno t ON p.DNI = t.DNI
WHERE t.fecha = '2021' AND t.fecha <> '2019';

4.Listar los pacientes que se atendieron por la obra social "osde" y tambien "ioma"

AR 

dniAtendidosPorOSDE = σ nombre='OSDE' (Turno)
dniAtendidosPorIOMA = σ nombre='IOMA' (Turno)
Paciente ⨝ (π DNI (dniAtendidosPorOSDE) ∩ π DNI (dniAtendidosPorIOMA ))

SQL 

SELECT DISTINCT p.*
FROM Paciente p
INNER JOIN Turno t ON p.DNI = t.DNI
WHERE t.nombre = 'OSDE'
AND p.DNI IN (
    SELECT t.DNI
    FROM Turno t
    WHERE t.nombre = 'IOMA'
    GROUP BY t.DNI
);

5. Listar para cada especialista la cantidad de turnos del 2021 

SQL 

SELECT e.nombre, COUNT(*) 
FROM Especialistas e 
INNER JOIN Turno t ON e.matricula = t.matricula 
WHERE fecha = '2021' GROUP BY e.nombre;

6.Listar los paciente que se hayan atendido mas de 5 veces en el año 2020

SQL 

SELECT * 
FROM Paciente p 
WHERE p.DNI IN 
    (SELECT t.DNI
    FROM Turno t
    WHERE t.fecha = 2020
    GROUP BY t.DNI
    HAVING COUNT(*) > 5
    );