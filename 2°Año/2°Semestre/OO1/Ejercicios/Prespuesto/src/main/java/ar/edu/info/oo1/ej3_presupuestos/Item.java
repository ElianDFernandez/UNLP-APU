package ar.edu.info.oo1.ej3_presupuestos;

/**
 *
 * @author elian
 */
import java.util.ArrayList;
import java.util.List;

// Clase Item
public class Item {
    private String detalle;
    private int cantidad;
    private double costoUnitario;

    public Item(String detalle, int cantidad, double costoUnitario) {
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public double costo() {
        return cantidad * costoUnitario;
    }

    public String getDetalle() {
        return detalle;
    }
    
    public int getCantidad() { 
        return cantidad; 
    }
    
    public double getCostoUnitario() {
        return costoUnitario;
    }
}