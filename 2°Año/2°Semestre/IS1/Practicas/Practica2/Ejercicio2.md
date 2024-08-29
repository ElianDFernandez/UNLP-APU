# Historias de usuario
## Practica 3

### 1. Posgrado


Historia a desarrollar 

Rol de usuarios: 
    - Alumno
    - Empleado Adm.
Historias de usuario: 
    - Registro
    - Cargar carrera
    - Inscribirse a carrera
    - Validar tarjeta

    Id: Cargar carrrera
    Titulo: Como empleado administrativo cargar una carrera nueva
    Reglas de negocio: 
        - Nombre de la carrera unico
        - Duarcion de años maximo de 5 
    
    Criterios de aceptacion: Carga de carrera.
    - Escenario 1: Empleado administrativo carga carrera exitosamente.
        Dado: Que el empleado se autentico correctamente en el sistema, usuario Empleado1, contraseña 12345678, y que se va a cargar la carrera con nombre Ingenieria de software (no existente), Duracion 4 años, costo $1400,y cant maxima de cutos 12.
        Cuando: se ingresen estos mismos datos.
        Entonces: El sistema informara que se almaceno la carrera con exito.
    - Escenario 2: Error en la carga de carrera, nombre repetido.
        Dado: Que el empleado se autentico correctamente en el sistema, usuario Empleado1, contraseña 12345678, y que se va a cargar la carrera con nombre Ingenieria de software (ya existente), Duracion 4 años, costo $1400,y cant maxima de cutos 12.
        Cuando: se ingresen estos mismos datos.
        Entonces: El sistema informara que ya existe una carrera con ese nombre.
    - Esceneario 3: Error en la carga de carrera, mas de 5 años
        Dado: Que el empleado se autentico correctamente en el sistema, usuario Empleado1, contraseña 12345678, y que se va a cargar la carrera con nombre Ingenieria de software (no existente), Duracion 6 años, costo $1400,y cant maxima de cutos 12.
        Cuando: se ingresen estos mismos datos.
        Entonces: El sistema informara que la carrera no puede exceder los 5 años.
    
    Id: Registro
    Titulo: regitro de alumno 
    Reglas de negocio: 
        - Contraseña mas de 6 digitos
        - Nombre de usuario unico

    Criterios de acpetcion: Registro de alumno
    - Escenario 1: Alumno puede registrarse exitosamente.
        Dado: Que el alumno con nombre Elian, apellido Fernandez 