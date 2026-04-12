package oo2.ejercicio9;

/**
 *
 * @author Elian
 */
public class Efectivo implements FormaPago {
    @Override
    public double calcularCostoAdicional(double costoProductos) {
        return 0; // Sin recargo
    }
}
