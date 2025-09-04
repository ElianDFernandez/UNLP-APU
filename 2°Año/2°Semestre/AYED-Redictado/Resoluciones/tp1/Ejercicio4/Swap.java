public class Swap {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        System.out.println("Before swap1: x = " + x + ", y = " + y);
        swap1(x, y);
        System.out.println("After swap1: x = " + x + ", y = " + y);

        Integer m = 3;
        Integer n = 4;
        System.out.println("Before swap2: m = " + m + ", n = " + n);
        swap2(m, n);
        System.out.println("After swap2: m = " + m + ", n = " + n);
    }

    public static void swap1(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
            System.out.println("Inside swap1: a = " + a + ", b = " + b);
        }
        // Cambia a = b y b = a
    }

    public static void swap2(Integer a, Integer b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
            System.out.println("Inside swap2: a = " + a + ", b = " + b);
        }
        // Cambia a = b y b = a
    }

    // Explicación:
    // En Java, los tipos primitivos (como int) se pasan por valor, lo que significa que
    // se crea una copia de las variables cuando se pasan a un método. Por lo tanto
    // cualquier cambio realizado a 'a' y 'b' dentro de swap1 no afecta a 'x' y 'y' en main.

    // En el caso de los objetos (como Integer), también se pasa una copia de la referencia
    // al objeto, pero no la referencia en sí. Por lo tanto, aunque 'a' y 'b' en swap2
    // apuntan a los mismos objetos que 'm' y 'n' en main, reasignar 'a' y 'b' dentro de swap2
    // no afecta a 'm' y 'n' en main. Por lo tanto, los valores originales permanecen sin cambios.
}