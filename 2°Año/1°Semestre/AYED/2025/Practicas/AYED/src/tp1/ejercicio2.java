package tp1;

import java.util.Scanner;

public class ejercicio2 {
    public static int[] multiplos(int n){
        int[]mult = new int[n];
        for (int i=0; i<n; i++) {
            mult[i]= n*(i+1);
        } 
        return mult;
    }
    
   public static void imprimirArray(int[] array){
       for(int numero: array) {
           System.out.println(numero);
       }
   }
   
   public static void main(String[]args) {
       Scanner s = new Scanner(System.in);
       int numero = s.nextInt();
       int[] array = multiplos(numero);
       imprimirArray(array);
   }
}
