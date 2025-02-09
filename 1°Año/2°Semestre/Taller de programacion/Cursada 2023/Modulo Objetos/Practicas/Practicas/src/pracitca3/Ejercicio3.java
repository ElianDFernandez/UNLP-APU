package pracitca3;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Elian
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        // Crear el estante
        Estante estante = new Estante(20);

        // Crear autores
        Autor autor1 = new Autor("J.K. Rowling", "Autora de la saga Harry Potter", "Reino Unido");
        Autor autor2 = new Autor("George R.R. Martin", "Autor de la saga Canción de Hielo y Fuego", "Estados Unidos");
        Autor autor3 = new Autor("Gabriel García Márquez", "Autor de Cien años de soledad", "Colombia");
        Autor autor4 = new Autor("Elian", "Florense", "Las Flores");

        // Crear libros
        Libro libro1 = new Libro("Harry Potter y la Piedra Filosofal", autor1, "Bloomsbury", 1997, 12345, 4500.0);
        Libro libro2 = new Libro("Juego de Tronos", autor2, "Bantam Books", 1996, 67890, 8500.0);
        Libro libro3 = new Libro("Mujercitas", autor3, "Sudamericana", 1967, 11111, 7800.0);
        Libro libro4 = new Libro("Star Wars", autor4, "Lucasfilm", 2005, 1010, 35000.0);

        // Agregar los libros al estante
        estante.agregarLibro(libro1);
        estante.agregarLibro(libro2);
        estante.agregarLibro(libro3);
        estante.agregarLibro(libro4);
        
        System.out.println(estante.getLibro("Mujercitas"));
    }
}
