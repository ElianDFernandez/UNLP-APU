package ar.edu.info.oo1.ejercicio24;

import java.time.LocalDate;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Elian
 */
public class PuntoUnoTest {
    // Declara variables
    private Usuario juanMartinez;
    private OrdenCompra ordenCompra;
    private OrdenServicio ordenServicio;
    private Producto panelSolar;
    private Producto compostera;
    private Tecnico luciaIraola;
    private Producto calefonSolar;
    private LinkedList<Tecnico> tecnicos; // <-- Hacemos la lista de tecnicos accesible
    
    // Instanciacion
    @BeforeEach
    void setup(){
        juanMartinez = new Usuario("Juan Martinez", "Larrea 5800, Mar del Plata");
        panelSolar = new Producto("Panel solar", "Reciclables", 35000, false);
        compostera = new Producto("Compostera", "Biodegradables", 8000, true);
        
        // Orden de compra original (2 productos)
        ordenCompra = new OrdenCompra(0,LocalDate.now(),juanMartinez,juanMartinez.getDomicilio());
        ordenCompra.agregarProducto(panelSolar);
        ordenCompra.agregarProducto(compostera);
        
        luciaIraola = new Tecnico("Lucia Iraola","Instalaciones solares",4500);
        calefonSolar = new Producto("Calefon sola","Reciclabes",50000,false);
        tecnicos = new LinkedList<>();
        tecnicos.add(luciaIraola);
        
        // Orden de servicio original (5 horas)
        ordenServicio = new OrdenServicio("Instalación de calefón solar",5,LocalDate.now(),juanMartinez,juanMartinez.getDomicilio(),tecnicos);
        ordenServicio.agregarProducto(calefonSolar);
        
        /*
        Para incentivar compras y servicios más extensos, si una orden de compra incluye cinco o más productos, o si una orden de servicio requiere más de diez horas de trabajo, 
        se aplica automáticamente un 10% de descuento sobre el costo total. Diseñe los casos de prueba para el método calcularCosto de una orden, teniendo en cuenta los conceptos
        de valores de borde y particiones equivalentes vistos en la teoría.

        Basado en el requerimiento, tenemos dos conjuntos de reglas:
        
        OrdenCompra: El descuento se aplica si la cantidad de productos es >= 5.
        Partición 1 (Sin Descuento): cantidad < 5 (ej: 1, 2, 3, 4 productos).
        Partición 2 (Con Descuento): cantidad >= 5 (ej: 5, 6, 7 productos).
        Valor de Borde: El límite está entre 4 y 5.Debemos probar ambos.
        
        OrdenServicio: El descuento se aplica si las horas de trabajo son > 10.
        Partición 1 (Sin Descuento): horas <= 10 (ej: 1, 5, 10 horas).
        Partición 2 (Con Descuento): horas > 10 (ej: 11, 12, 20 horas).
        Valor de Borde: El límite está entre 10 y 11. Debemos probar ambos.
        */
        
        
    }
    
    @Test
    void testOrdenCompraOriginalSinDescuento(){
        // 2 productos: 35000 + 8000 = 43000
        assertEquals(43000, ordenCompra.calcularCosto());
    }
    
    @Test 
    void testOrdenServicioOriginalSinDescuento(){
        // 1 producto (50000) + Servicio (4500 * 5hs = 22500) = 72500
        assertEquals(72500, ordenServicio.calcularCosto());
    }
    
    // --- Pruebas de Valores de Borde para OrdenCompra ---
    @Test
    void testOrdenCompraCon4ProductosSinDescuento() {
        // Límite inferior (sin descuento)
        OrdenCompra orden4 = new OrdenCompra(1, LocalDate.now(), juanMartinez, juanMartinez.getDomicilio());
        orden4.agregarProducto(new Producto("P1", "d", 1000, false));
        orden4.agregarProducto(new Producto("P2", "d", 1000, false));
        orden4.agregarProducto(new Producto("P3", "d", 1000, false));
        orden4.agregarProducto(new Producto("P4", "d", 1000, false));
        // Costo = 4000. No hay descuento.
        assertEquals(4000, orden4.calcularCosto());
    }

    @Test
    void testOrdenCompraCon5ProductosConDescuento() {
        // Límite superior (con descuento)
        OrdenCompra orden5 = new OrdenCompra(2, LocalDate.now(), juanMartinez, juanMartinez.getDomicilio());
        orden5.agregarProducto(new Producto("P1", "d", 1000, false)); // 1
        orden5.agregarProducto(new Producto("P2", "d", 1000, false)); // 2
        orden5.agregarProducto(new Producto("P3", "d", 1000, false)); // 3
        orden5.agregarProducto(new Producto("P4", "d", 1000, false)); // 4
        orden5.agregarProducto(new Producto("P5", "d", 1000, false)); // 5
        // Costo base = 5000. 
        // Costo con 10% descuento = 5000 * 0.9 = 4500
        assertEquals(4500, orden5.calcularCosto());
    }
    
    // --- Pruebas de Valores de Borde para OrdenServicio ---
    @Test
    void testOrdenServicioCon10HorasSinDescuento() {
        // Límite inferior (sin descuento)
        OrdenServicio orden10hs = new OrdenServicio("Servicio 10hs", 10, LocalDate.now(), juanMartinez, juanMartinez.getDomicilio(), tecnicos);
        orden10hs.agregarProducto(calefonSolar); // 50000
        // Costo base = 50000 (producto) + (4500 * 10hs) = 50000 + 45000 = 95000
        // No hay descuento.
        assertEquals(95000, orden10hs.calcularCosto());
    }

    @Test
    void testOrdenServicioCon11HorasConDescuento() {
        // Límite superior (con descuento)
        OrdenServicio orden11hs = new OrdenServicio("Servicio 11hs", 11, LocalDate.now(), juanMartinez, juanMartinez.getDomicilio(), tecnicos);
        orden11hs.agregarProducto(calefonSolar); // 50000
        // Costo base = 50000 (producto) + (4500 * 11hs) = 50000 + 49500 = 99500
        // Costo con 10% descuento = 99500 * 0.9 = 89550
        assertEquals(89550, orden11hs.calcularCosto());
    }

    // --- (Opcional) Pruebas de Partición Equivalente ---

    @Test
    void testOrdenCompraCon6ProductosConDescuento() {
        // Partición "con descuento" (>= 5)
        OrdenCompra orden6 = new OrdenCompra(3, LocalDate.now(), juanMartinez, juanMartinez.getDomicilio());
        for (int i = 0; i < 6; i++) {
            orden6.agregarProducto(new Producto("P", "d", 1000, false));
        }
        // Costo base = 6000. 
        // Costo con 10% descuento = 6000 * 0.9 = 5400
        assertEquals(5400, orden6.calcularCosto());
    }

    @Test
    void testOrdenServicioCon12HorasConDescuento() {
        // Partición "con descuento" (> 10)
        OrdenServicio orden12hs = new OrdenServicio("Servicio 12hs", 12, LocalDate.now(), juanMartinez, juanMartinez.getDomicilio(), tecnicos);
        orden12hs.agregarProducto(calefonSolar); // 50000
        // Costo base = 50000 (producto) + (4500 * 12hs) = 50000 + 54000 = 104000
        // Costo con 10% descuento = 104000 * 0.9 = 93600
        assertEquals(93600, orden12hs.calcularCosto());
    }
}