package pracitca3;

/**
 *
 * @author Elian
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        // Crear un hotel con 5 habitaciones
        Hotel hotel = new Hotel(5);

        // Crear algunos clientes
        Cliente cliente1 = new Cliente("Elian", 12345678, 30);
        Cliente cliente2 = new Cliente("Maria", 87654321, 25);
        Cliente cliente3 = new Cliente("Carlos", 11223344, 40);
        Cliente cliente4 = new Cliente("Laura", 99887766, 35);

        // Registrar clientes en habitaciones
        hotel.registrarCliente(cliente1, 0); // Elian en Habitación 1
        hotel.registrarCliente(cliente2, 2); // Maria en Habitación 3
        hotel.registrarCliente(cliente3, 4); // Carlos en Habitación 5

        // Imprimir el estado del hotel
        System.out.println(hotel);
    }
}
