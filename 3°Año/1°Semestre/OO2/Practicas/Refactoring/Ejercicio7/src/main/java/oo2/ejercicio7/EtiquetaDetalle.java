package oo2.ejercicio7;

/**
 *
 * @author Elian
 */
class EtiquetaDetalle extends Etiqueta {
    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    protected void imprimirCabecera() {
        System.out.println("--- ETIQUETA DETALLE ---");
    }

    @Override
    protected void imprimirDetallePrecio() {
        System.out.println("Precio sin imp.: $" + (precio * 0.79));
        System.out.println("Precio final: $" + precio);
    }
}
