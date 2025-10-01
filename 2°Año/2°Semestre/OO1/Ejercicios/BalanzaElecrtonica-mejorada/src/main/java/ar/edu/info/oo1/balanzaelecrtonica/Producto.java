package ar.edu.info.oo1.balanzaelecrtonica;

/**
 *
 * @author elian
 */
public class Producto {
    private String descripcion;
    private double peso;
    private double precioPorKilo;

    public Producto(String descripcion, double peso, double precioPorKilo) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    public double getPrecio() {
        return precioPorKilo * peso;
    }
}
