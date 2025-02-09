package practica2;

import PaqueteLectura.GeneradorAleatorio;

/**
a) Simular el proceso de inscripción de personas al casting. 
* A cada persona se le pide nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: 
* las personas primero completan el primer día en turnos sucesivos, luego el segundo día y así siguiendo. 
* La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos de casting.
* Una vez finalizada la inscripción:
* b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
* NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar Strings use el método equals.
 */
public class Ejercicio3 {
    public static void main(String[]args) {
        int dias = 5;
        int entrevistas = 8;
        int []diml = new int[dias];
        
        GeneradorAleatorio.iniciar();
        
        for (int i=0; i<dias; i++) {
            for (int j =0; j<entrevistas; j++) {
                  
            }
        }
    }
}
