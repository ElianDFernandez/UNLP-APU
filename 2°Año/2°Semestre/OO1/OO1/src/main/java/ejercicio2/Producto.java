package ejercicio2;

/**
 *
 * @author elian
 */
public class Producto {
    private double peso;
    private double  precioPorKilo;
    private String descripcion;

    public Producto(String descripcion, double peso, double precioPorKilo){
        this.peso = peso;
        this.precioPorKilo = precioPorKilo;
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }
    
    public double getPrecio() {
        return this.getPrecioPorKilo() * this.getPeso();
    }
}
