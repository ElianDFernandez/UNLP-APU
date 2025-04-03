package tp1;


public class ejercicio5 {
    private int max;
    private int min;
    private double promedio;

    public ejercicio5() {}

    public ejercicio5(int max, int min, double promedio) {
        this.max = max;
        this.min = min;
        this.promedio = promedio;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    public static void main(String[] args) {
        int[] enteros = {4, 5, 7, 2, 1};

        // Método 1: Usando return
        Resultado resultado1 = calcularEstadisticas(enteros);
        System.out.println("Método 1 - Return:");
        System.out.println("Máximo: " + resultado1.getMax());
        System.out.println("Mínimo: " + resultado1.getMin());
        System.out.println("Promedio: " + resultado1.getPromedio());

        // Método 2: Usando parámetros
        calcularEstadisticasParams(enteros, resultado1);
        System.out.println("\nMétodo 2 - Parámetros:");
        System.out.println("Máximo: " + resultado1.getMax());
        System.out.println("Mínimo: " + resultado1.getMin());
        System.out.println("Promedio: " + resultado1.getPromedio());

        // Método 3: Usando `this`
        ejercicio5 resultado3 = new ejercicio5();
        resultado3.calcularEstadisticasThis(enteros);
        System.out.println("\nMétodo 3 - This:");
        System.out.println("Máximo: " + resultado3.getMax());
        System.out.println("Mínimo: " + resultado3.getMin());
        System.out.println("Promedio: " + resultado3.getPromedio());
    }

    public static Resultado calcularEstadisticas(int[] enteros) {
        int max = enteros[0];
        int min = enteros[0];
        int suma = 0;
        
        for (int num:enteros) {
            if (num > max) max = num;
            if (num < min) min = num;
            suma += num;
        }
        double promedio = (double) suma / enteros.length;
        
        return new Resultado(max, min, promedio);
    }
    
    public static void calcularEstadisticasParams(int[] enteros, Resultado resultado) {
        int max = enteros[0];
        int min = enteros[0];
        int suma = 0;
        
        for (int num:enteros) {
            if (num > max) max = num;
            if (num < min) min = num;
            suma += num;
        }
        double promedio = (double) suma / enteros.length;
        
        resultado.setMin(min);
        resultado.setMax(max);
        resultado.setPromedio(promedio);
    }
    
    public void calcularEstadisticasThis(int[] enteros){
        int max = enteros[0];
        int min = enteros[0];
        int suma = 0;
        
        for (int num:enteros) {
            if (num > max) max = num;
            if (num < min) min = num;
            suma += num;
        }
        double promedio = (double) suma / enteros.length;
        
        this.setMin(min);
        this.setMax(max);
        this.setPromedio(promedio);
    }
}
