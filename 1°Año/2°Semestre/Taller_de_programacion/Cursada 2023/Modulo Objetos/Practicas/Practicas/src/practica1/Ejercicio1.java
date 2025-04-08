package practica1;

import  PaqueteLectura.GeneradorAleatorio;

public class Ejercicio1 {

    public static void main(String[] args) {
        /*
        1- Analice el programa Ej01Tabla2.java, que carga un vector que representa la tabla del 2. Luego escriba las instrucciones necesarias para:
            - generar enteros aleatorios hasta obtener el número 11. Para cada número muestre el resultado de multiplicarlo por 2 (accediendo al vector).
        */
        Integer [] enteros = new Integer [12];
        for (int i = 0;  i<=10; i++) {
            System.out.println(i + "x" + 2 + "=" + i*2);
            enteros[i] = i*2;
        }
        
        for (int i = 0;  i<=10; i++){
            System.out.print("[" +enteros[i]+"]");
        }
            
          Integer randoms;
          GeneradorAleatorio.iniciar();
          randoms = GeneradorAleatorio.generarInt(12);
          int intentos = 10;
          System.out.println("Numero generado aleatorio: "+randoms);
          while (randoms != 11  &&  intentos >0) {
              System.out.println("Numero mult. por 2: " + enteros[randoms]);
              randoms = GeneradorAleatorio.generarInt(11);
              System.out.println("Numero generado aleatorio: "+randoms);
              intentos--;
          }
    }
    
}
