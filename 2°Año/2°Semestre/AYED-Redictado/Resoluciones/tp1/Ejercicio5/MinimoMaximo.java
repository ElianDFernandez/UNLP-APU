public class MinimoMaximo {
    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 1, 4};

        
    }

    // Encontrar maximo y minimo en su solo metodo
    // 1°Usando return de java
    public static void encontrarMinimoMaximo(int[] arr) {
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
    public static void encontrarMinimoMaximo(int[] arr, int[] resultado) {
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

    public static void encontrarMinimoMaximo(int[] arr) {
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