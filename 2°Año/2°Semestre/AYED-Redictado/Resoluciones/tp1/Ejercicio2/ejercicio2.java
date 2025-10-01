import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio2 {
    public static List<Integer> multiplos(int n) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            resultado.add(i);
        }
        return resultado;
    }

    public static void main(String[]args) {
        System.out.println("Punto 2:");
        System.out.println("Ingrese un numero n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(multiplos(n)); // Debería imprimir [1, 2, 3, 4, 5]
    }
}