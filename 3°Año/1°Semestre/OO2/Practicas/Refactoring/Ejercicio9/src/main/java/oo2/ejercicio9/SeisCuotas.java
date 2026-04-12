package oo2.ejercicio9;

/**
 *
 * @author Elian
 */
public class SeisCuotas implements FormaPago {
    @Override
    public double calcularCostoAdicional(double costoProductos) {
        return costoProductos * 0.2;
    }
}
