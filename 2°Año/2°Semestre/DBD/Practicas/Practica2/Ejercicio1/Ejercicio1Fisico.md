# Modelo fisico 

Personas = (<u>DNI</u>, Nombre, Apellido, Calle, Numero, Departamento?, Piso?)
Clientes = (<u>DNI(fk)</u>, Sexo, Nacionalidad, Pasaporte?)
Empleados = (<U>NroLegajo</u>, DNI(fk))
Trabaja = (<u>NroLegajo(fk),Codgio(fk),Desde</u>, Hasta?)
Areas = (<u>Codigo</u>, Descripcion, Ubicacion)
Tiene = (<u>Codigo(fk), Telefono</u>)
Telefonos = (<u>Telefono</u>)
Alquileres = (<u>FechaDeInicio, FechaDeFin, Codigo(fk)</u>DNI(fk), NroLegajo(fk), FechaDeAlquiler)
Ventas = (<u>Fecha,Hora, DNI(fk)</u>, NroLegajo(fk), Codigo(fk), Comision, PrecioVenta)
Inmuebeles = (<u>Codigo</u>, DNI(fk), Calle, Numero, Piso?, Departamento?, CantidadAmbientes, Balcon, Lavadero, Baños, Nombre(fk))
TiposDeInmuebles = (<u>Nombre</u>)

