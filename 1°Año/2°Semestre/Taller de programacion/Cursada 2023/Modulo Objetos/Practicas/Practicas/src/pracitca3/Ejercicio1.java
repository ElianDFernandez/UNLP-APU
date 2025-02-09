package pracitca3;

/**
 *
 * @author Elian
 */
public class Ejercicio1 {
    public static void main(String[]args) {
        Triangulo triangulo = new Triangulo(20.0,20.0,30.0,"rojo","azul");
        System.out.println(triangulo.calcularPerimetro());
        System.out.println(triangulo.calcularArea());
    }
}
