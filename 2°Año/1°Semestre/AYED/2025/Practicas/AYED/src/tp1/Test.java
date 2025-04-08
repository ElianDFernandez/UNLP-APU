/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1;

/**
 *
 * @author Elian
 */
public class Test {
public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[2];
        Profesor[] profesores = new Profesor[3];
        
        // Crear y configurar estudiantes
        estudiantes[0] = new Estudiante();
        estudiantes[0].setNombre("Juan");
        estudiantes[0].setApellido("Pérez");
        estudiantes[0].setComision(101);
        estudiantes[0].setEmail("juan.perez@universidad.edu");
        estudiantes[0].setDireccion("Calle Principal 123");
        
        estudiantes[1] = new Estudiante();
        estudiantes[1].setNombre("María");
        estudiantes[1].setApellido("González");
        estudiantes[1].setComision(102);
        estudiantes[1].setEmail("maria.gonzalez@universidad.edu");
        estudiantes[1].setDireccion("Avenida Central 456");
        
        // Crear y configurar profesores
        profesores[0] = new Profesor();
        profesores[0].setNombre("Carlos");
        profesores[0].setApellido("Rodríguez");
        profesores[0].setEmail("carlos.rodriguez@facultad.edu");
        profesores[0].setCatedra("Programación");
        profesores[0].setFacultad("Informática");
        
        profesores[1] = new Profesor();
        profesores[1].setNombre("Laura");
        profesores[1].setApellido("Martínez");
        profesores[1].setEmail("laura.martinez@facultad.edu");
        profesores[1].setCatedra("Bases de Datos");
        profesores[1].setFacultad("Informática");
        
        profesores[2] = new Profesor();
        profesores[2].setNombre("Alejandro");
        profesores[2].setApellido("López");
        profesores[2].setEmail("alejandro.lopez@facultad.edu");
        profesores[2].setCatedra("Algoritmos");
        profesores[2].setFacultad("Matemáticas");
        
        for (Estudiante est:estudiantes) {
            System.out.println(est.tusDatos());
        }
        
        for (Profesor pro:profesores) {
            System.out.println(pro.tusDatos());
        }
    }
}
