package oo2.ejercicio7;

/**
 *
 * @author Elian
 */
abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }
    
    protected abstract void imprimirCabecera();
    protected abstract void imprimirDetallePrecio();
    
    public void generar() {
        this.imprimirCabecera();
        System.out.println("Producto: " + nombreProducto);
        this.imprimirDetallePrecio();
        System.out.println("-----------------------");
    }
}

