package oo2.ejercicio7;

/**
 *
 * @author Elian
 */
class EtiquetaSimple extends Etiqueta {
    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    protected void imprimirCabecera() {
        System.out.println("--- ETIQUETA BÁSICA ---");
    }

    @Override
    protected void imprimirDetallePrecio() {
        System.out.println("Precio: $" + precio);
    }
}

