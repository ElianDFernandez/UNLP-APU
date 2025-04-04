package practica1;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/**
5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen (con puntaje de 1 a 10) los siguientes aspectos: 
* (0) Atención al cliente 
* (1) Calidad de la comida 
* (2) Precio 
* (3) Ambiente.
  Escriba un programa que lea desde teclado las calificaciones de los cinco clientes para cada uno de los aspectos y almacene la información en una estructura. 
  Luego imprima la calificación promedio obtenida por cada aspecto.
 */
public class Ejercicio5 {
    public static void main(String[]args) {
        Double[][]puntajes = new Double[5][4];
        for (int i=0; i<5; i++) {
            //System.out.println("Cliente " + (i+1));
            for (int j=0; j<4; j++) {
                //System.out.println("Aspecto " + (j+1));
                //puntajes[i][j]=Lector.leerDouble();
                puntajes[i][j]=GeneradorAleatorio.generarDouble(11);
                System.out.print("["+puntajes[i][j]+"]");
            }
            System.out.println();
        }
        
        Double[]promedios = new Double[4];
        for (int i=0; i<4; i++) {
            for (int j=0; j<5; j++) {
                if (promedios[i] == null) { 
                    promedios[i] = puntajes[j][i];
                }else {
                    promedios[i]+= puntajes[j][i];
                }
            }
            promedios[i] = promedios[i]/4;
        }
        
        for (int i=0; i<promedios.length; i++) {
            System.out.println("Promedio " + (i+1) + ": " + promedios[i]);
        }
    }
}
