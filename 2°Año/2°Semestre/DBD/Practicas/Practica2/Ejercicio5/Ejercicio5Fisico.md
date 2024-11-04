# Modelo Fisico

Usuarios = (<u>Usuario</u>, Nombre, Apellido, Clave, Telefono, Calle, Numero, Piso?, Departamento?)
Tienen2 = (<u>Correo(fk)</u>, Usuario(fk))
Correos = (<u>Correo</u>)
Vinculo = (<u>{FechaHora,Usuario1(fk)}</u>, Usuario2(fk), Descripcion, Tipo)
Publicaciones = (<u>{Usuario(fk),Titulo}</u>, FechaHora, NombreArchivo, PalabrasClaves, Nombre(fk))
Compartio = (<u>{Usuario,Titulo}(fk), Usuario(fk), FechaHora</u>)
Descargo = (<u>{Usuario,Titulo}(fk), Usuario(fk), FechaHora</u>)
Comentarios = (<u>{Usuario(fk),FechaHora}</u>, Texto)
