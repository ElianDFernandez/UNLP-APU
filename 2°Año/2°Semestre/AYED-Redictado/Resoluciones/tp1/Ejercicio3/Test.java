import java.util.ArrayList;

public class Test{
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Profesor> profesores = new ArrayList<>();

        Estudiante estudiante1 = new Estudiante("Juan", "Perez", 1, "juan.perez@example.com", "Calle Falsa 123");
        estudiantes.add(estudiante1);
        Estudiante estudiante2 = new Estudiante("Ana", "Lopez", 2, "ana.lopez@example.com", "Calle Verdadera 456");
        estudiantes.add(estudiante2);

        Profesor profesor1 = new Profesor("Carlos", "Ramirez", "carlos.ramirez@example.com", "Facultad de Ingenieria", "Computacion");
        profesores.add(profesor1);
        Profesor profesor2 = new Profesor("Maria", "Gomez", "maria.gomez@example.com", "Facultad de Ciencias", "Matematicas");
        profesores.add(profesor2);

        System.out.println("Datos de Estudiantes y Profesores:");
        System.out.println("---------------------");

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
            System.out.println("---------------------");
            break;
        }
    
        for (Profesor profesor : profesores) {
            System.out.println(profesor.tusDatos());
            System.out.println("---------------------");
            break;
        }
    }
}