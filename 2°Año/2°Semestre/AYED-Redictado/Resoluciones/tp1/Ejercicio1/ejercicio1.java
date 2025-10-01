public class ejercicio1 {
    public static void punto1a(int a, int b) {
        for (int i=a; i<=b; i++) {
            System.out.println(i);
        }
    }
    
    public static void punto1b(int a, int b) {
        while (a <= b) {
            System.out.println(a);
            a++;
        }
    }
    
    public static void punto1c(int a, int b) {
        if (a > b) return;
        System.out.println(a);
        punto1c(a+1,b);
    }
    
    public static void main(String[]args) {
        System.out.println("Punto 1a:");
        punto1a(1,5);
        System.out.println("Punto 1b:");
        punto1b(1,5);
        System.out.println("Punto 1c:");
        punto1c(1,5);
    }
}
