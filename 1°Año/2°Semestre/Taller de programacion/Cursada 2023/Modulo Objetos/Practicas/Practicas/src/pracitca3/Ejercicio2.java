package pracitca3;

/**
 *
 * @author Elian
 */
public class Ejercicio2 {
    public static void main(String[]args) {
        Autor autorEjemplo = new Autor("Elian","Florense","Las Flores");
        Libro libroEjemplo = new Libro("Star Wars",autorEjemplo,"Lucasfilm",2005,1010,35000.0);

        System.out.println(libroEjemplo);
    }
}
