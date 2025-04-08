package practica2;

import PaqueteLectura.GeneradorAleatorio;
        
public class Ejercicio2 {
    public static void main(String[]args) {
        Persona[]listado = new Persona[15];
        int diml = 0;
        for(int i=0; i<15; i++) {
            String nombre = GeneradorAleatorio.generarString(10);
            Integer dni = GeneradorAleatorio.generarInt(8);
            Integer edad = GeneradorAleatorio.generarInt(100);
            if (edad == 0) break;
            listado[i] = new Persona(nombre, dni, edad);
            diml++;
        }
        /*
        int mayores65 = 0;
        for(Persona persona : listado) {
            if (persona.getEdad()>65) {
                mayores65++;
            }
        }
        
        Persona personaMenorDni = null;
        for(Persona persona : listado) {
            if (personaMenorDni == null || persona.getDni() < personaMenorDni.getDni()) {
                personaMenorDni = persona;
            }
        }
        */
        int mayores65 = 0;
        Persona personaMenorDni = null;
        for (int i=0; i < diml; i++) {
            if (listado[i].getEdad()>65) {
                mayores65++;
            }
            if (personaMenorDni == null || listado[i].getDni() < personaMenorDni.getDni()) {
                personaMenorDni = listado[i];
            }
        }
        
        System.out.println("Mayores a 65 años: " + mayores65);
        System.out.println("Persona con menor dni: " + personaMenorDni);
    }
}
