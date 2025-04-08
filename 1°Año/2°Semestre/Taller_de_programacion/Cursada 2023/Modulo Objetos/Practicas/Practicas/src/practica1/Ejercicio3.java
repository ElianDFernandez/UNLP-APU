package practica1;

import PaqueteLectura.GeneradorAleatorio;

/*
3- Escriba un programa que defina una matriz de enteros de tamaño 5x5. Inicialice la matriz con números aleatorios entre 0 y 30.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de los elementos de la fila 1
- Generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. Luego, imprima el vector.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna) en caso contrario imprima “No se encontró el elemento”.
NOTA: Dispone de un esqueleto para este programa en Ej03Matrices.java
 */

public class Ejercicio3 {
    public static void main(String[]args) {
        Integer[][] matriz = new Integer[5][5];
        GeneradorAleatorio.iniciar();
        for (int i=0;  i<5; i++) {
            for (int j=0; j<5; j++) {
                matriz[i][j]=GeneradorAleatorio.generarInt(10)+10;
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println();
        }
        
        int fila = 1;
        System.out.println("Suma de la fila " + fila + ": " + sumarFila(fila, matriz));
        
        Integer[] vector = generarVector(matriz);
        for (int i=0; i<vector.length; i++) {
            System.out.print("["+ vector[i]+"]");
        }
        System.out.println();
        
        encontrarElemento(14,matriz);
    }
    
    public static Integer sumarFila(int fila, Integer[][]matriz) {
        int suma=0;
        for (int i=0; i<matriz[fila].length;  i++) {
            suma += matriz[fila][i];
        }
        return suma;
    }
    
    public static Integer sumarColumna(int columna, Integer[][]matriz) {
        int suma=0;
        for (int i=0; i<matriz.length;  i++) {
            suma += matriz[i][columna];
        }
        return suma;
    }
    
    // - Generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. Luego, imprima el vector.
    public static Integer [] generarVector(Integer[][] matriz){
        Integer [] vector = new Integer[5];
        for (int i=0; i<5; i++) {
            vector[i] = sumarColumna(i,matriz);
        }
        return vector;
    }
    
    public static void encontrarElemento(Integer num, Integer[][]matriz)  {
        Boolean encontrado = false;
        for (int i=0; i<matriz.length; i++) {
            for (int j=0; j<matriz[i].length; j++) {
                if (matriz[i][j].equals(num)) {
                    System.out.println(num + " Encontrado en Fila: "+(i+1)+" Columa: "+(j+1));
                    return;
                }
            }
        }
        System.out.println("No encontrado");
    }
}
