package Practica1.Ejercicio2;

public class ClassEj2 {
    public static int[]multiplosVec(int n) {
        int arreglo[] = new int[n];
        int num = 0;
        for (int i=0; i<n; i++) {
            arreglo[i] = n + num;
            num+= n;
        }
        return arreglo;
    }
}
