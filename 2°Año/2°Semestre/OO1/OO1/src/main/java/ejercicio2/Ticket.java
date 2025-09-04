package ejercicio2;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class Ticket {
    private LocalDate fecha;
    private Integer cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    
    public Ticket (Integer cantidad, double pesoTotal, double precioTotal) {
        this.fecha = LocalDate.now();
        this.cantidadDeProductos = cantidad;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(Integer cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    public double impuesto() {
        return this.precioTotal*0.21;
    }
}
