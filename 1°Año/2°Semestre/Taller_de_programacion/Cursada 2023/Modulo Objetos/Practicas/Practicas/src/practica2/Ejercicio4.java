
package practica2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos
de casting.
Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado.
 */
public class Ejercicio4 {
    public static void main(String[]args) {
        int  dias = 5;
        int entrevistas = 8;
        int []diml = new int[dias];
        Persona entrevistados[][]=new Persona[dias][entrevistas];
        
        int cupos = 0;
        String nombre = Lector.leerString();
        while (!nombre .equals("ZZZ") && cupos < 40) {
            Integer edad = Lector.leerInt();
            Integer dni = Lector.leerInt();
            Persona nueva = new Persona(nombre,edad,dni);
            Integer dia = Lector.leerInt();
            inscribir(entrevistados,nueva,diml,dia);
            nombre = Lector.leerString();
        }
        
        for (int i=0; i< diml.length; i++) {
            System.out.println("Inscriptos dia " + (i+1) + ": " + (diml[i] ));
        }
        
        for (int  i=0; i<dias; i++) {
            System.out.println("Dia " + (i+1));
            for ( int j =0; j<diml[i]; j++) {
                System.out.println("Entrevista nro " +(j+1));
                System.out.println("Entrevistado: " + entrevistados[i][j]);
            }
        }
    }
    
    public static boolean inscribir(Persona[][]entrevistados, Persona persona, int []diml, int dia) {
        if (diml[dia] >= 8) {
            return false;
        } else {
            entrevistados[dia-1][diml[dia]] = persona;
            diml[dia-1]= diml[dia-1] +1;
            return true;
        }
    }
}
