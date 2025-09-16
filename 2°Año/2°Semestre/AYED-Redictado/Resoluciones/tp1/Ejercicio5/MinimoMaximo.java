public class MinimoMaximo {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 4};

        // Usando return de java
        int[] resultado1 = encontrarMinimoMaximo1(numeros);
        System.out.println("Minimo: " + resultado1[0] + ", Maximo: " + resultado1[1]);

        // Interacuando con algun parametro
        int[] resultado2 = new int[2];
        encontrarMinimoMaximo2(numeros, resultado2);
        System.out.println("Minimo: " + resultado2[0] + ", Maximo: " + resultado2[1]);

        // Sin usar paremtros ni la sentencia return
        encontrarMinimoMaximo3(numeros);
        System.out.println("Minimo: " + minimoGlobal + ", Maximo: " + maximoGlobal);   
    }

    // Encontrar maximo y minimo en su solo metodo
    // 1°Usando return de java
    public static int[] encontrarMinimoMaximo1(int[] arr) {
        int minimo = arr[0];
        int maximo = arr[0];

        for (int num : arr) {
            if (num < minimo) {
                minimo = num;
            }
            if (num > maximo) {
                maximo = num;
            }
        }

        return new int[]{minimo, maximo};
    }

    //  2°Interacuando con algun parametro
    public static void encontrarMinimoMaximo2(int[] arr, int[] resultado) {
        int minimo = arr[0];
        int maximo = arr[0];

        for (int num : arr) {
            if (num < minimo) {
                minimo = num;
            }
            if (num > maximo) {
                maximo = num;
            }
        }

        resultado[0] = minimo;
        resultado[1] = maximo;
    }

    // 3°Sin usar paremtros ni la sentencia return
    static int minimoGlobal;
    static int maximoGlobal;

    public static void encontrarMinimoMaximo3(int[] arr) {
        minimoGlobal = arr[0];
        maximoGlobal = arr[0];

        for (int num : arr) {
            if (num < minimoGlobal) {
                minimoGlobal = num;
            }
            if (num > maximoGlobal) {
                maximoGlobal = num;
            }
        }
    }
}