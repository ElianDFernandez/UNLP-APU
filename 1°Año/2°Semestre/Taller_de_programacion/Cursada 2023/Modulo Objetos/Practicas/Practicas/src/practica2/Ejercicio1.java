package practica2;

import PaqueteLectura.Lector;

public class Ejercicio1 {
    public static void main(String[]args) {
        String nombre = Lector.leerString();
        Integer dni = Lector.leerInt();
        Integer edad = Lector.leerInt();
        
        Persona persona = new Persona(nombre,dni,edad);
        System.out.println(persona);
    }
}
