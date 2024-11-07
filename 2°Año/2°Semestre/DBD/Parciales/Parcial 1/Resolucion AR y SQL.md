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

π Especialistas.Matricula, Especialistas.nombre, Especialistas.apellido, Paciente.DNI, Paciente.nombre, Paciente.apellido, Paciente.telefono, Turno.fecha, Turno.nombre(σ Turno.fecha = '26/06/2022' (Especialistas |x| Paciente |x| Turno))

2.Listar los datos de los pacientes que se atendieron con todos los especialistas

π DNI,nombre,apellido,domicilio,telefono (Paciente |x| Turno) / π matriculo (Especialistas)

3.Lista las pacientes que se atendieron en el año 2021 pero no se atendieron en el año 2019

atendidos2021 <= π Paciente.DNI,Paciente.nombre,Paciente.apellido,Paciente.domicilio,Paciente.telefono(σ((fecha >= 01/01/2021)^(fecha >= 31/12/2021) (Paciente |x| Turno)))

atentidos2019 <= π Paciente.DNI,Paciente.nombre,Paciente.apellido,Paciente.domicilio,Paciente.telefono(σ((fecha >= 01/01/2019)^(fecha >= 31/12/2019) (Paciente |x| Turno)))

Resultado <= (atentidos2021-atendidos2019)

4.Listar los pacientes que se atendieron por la obra social "osde" y tambien "ioma"

π Paciente.DNI,Paciente.nombre,Paciente.apellido,Paciente.domicilio,Paciente.telefono (σ(Turno.nombre = 'OSDE')^ (Turno.nombre="ioma"))