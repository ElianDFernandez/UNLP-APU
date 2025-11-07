package ar.edu.info.oo1.ejercicio24;

/**
 *
 * @author Elian
 */
public class Producto {
    private String nombre;
    private String tipoMaterial;
    private double costo;
    private boolean esBiodegradable;

    public Producto(String nombre, String tipoMaterial, double costo, boolean esBiodegradable) {
        this.nombre = nombre;
        this.tipoMaterial = tipoMaterial;
        this.costo = costo;
        this.esBiodegradable = esBiodegradable;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEsBiodegradable() {
        return esBiodegradable;
    }

    public void setEsBiodegradable(boolean esBiodegradable) {
        this.esBiodegradable = esBiodegradable;
    }
    
    
}
