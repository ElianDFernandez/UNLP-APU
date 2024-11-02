# Modelo Fisico

Personas = (<u>DNI</u>, NroPasaporte?, Nombre, Apellido, FechaNacimiento, Calle, Numero, Piso?, Departamento?)
Pacientes = (<u>DNI</u>, CantidadVacunas)
Historial = (<u>DNI(fk), Nombre(fk)</u>)
Enfermedades = (<u>Nombre</u>)
Episodio = (<u>NumeroEpisodio</u>, DNI(fk), FechaDeteccion, Matricula(fk))
Tienen = (<u>NumeroEpisodio(fk), CodigoSintoma(fk)</u>)
Sintomas = (<u>CodigoSintoma</u>, Descripcion)
Medicos = (<u>Matricula</u>)
Sabe = (<u>Matricula(fk), Nombre(fk)</u>, NotaPromedio)
Especialidades = (<u>Nombre</u>, Descripcion)
Atiende = (<u>Matricula(fk), NumeroSala(fk)</u>, FechaInicio, FechaFin)
Salas = (<u>NumeroSala</u>, Piso, Capacidad)