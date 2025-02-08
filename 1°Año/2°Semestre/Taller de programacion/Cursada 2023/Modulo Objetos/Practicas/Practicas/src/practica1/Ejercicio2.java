package practica1;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/**
2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java
 */
public class Ejercicio2 {
    public static void main(String []args){
        Double [] jugadores = new Double[15];
        GeneradorAleatorio.iniciar();
        for (int i=0; i<15; i++){
            // System.out.println("Ingrese la altura del jugador " + (i+1)+ ":");
            // jugadores[i]=Lector.leerDouble();
            jugadores[i]=GeneradorAleatorio.generarDouble(10);
            System.out.println("Altura del jugador "+ (i+1) + ": "+ jugadores[i]);
        }
        
        System.out.println("Promedio de altura:" + getPromedio(jugadores));
        System.out.println("Jugadores mayores que promedio:" + getMayorQuePromedio(jugadores));
    }
    
    public static Double getPromedio(Double [] jugadores){
        Double sum = 0.0;
        for (int i=0; i< jugadores.length;  i++){
            sum+=jugadores[i];
        }
        return sum / jugadores.length;
    }
    
    public static Integer getMayorQuePromedio(Double [] jugadores){
        Integer resultado = 0;
        Double promedio = getPromedio(jugadores);
        for (int i=0; i< jugadores.length; i++){
            if (jugadores[i] > promedio) {
                resultado++;
            }
        }
        return resultado;
    }
}
