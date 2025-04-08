package Practica1.Ejercicio1;

public class ClassEj1 {
    public static void imprimirNumerosEntreFor(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }
    public static void imprimirNumerosEntreWhile(int a, int b) {
        int i = a;
        while (i <= b) {
            System.out.println(i);
            i++;
        }
    }
    public static void imprimirNumerosEntreDoWhile(int a, int b) {
        int i = a;
        do {
            System.out.println(i);
            i++;
        } while (i <= b);
    }
}
