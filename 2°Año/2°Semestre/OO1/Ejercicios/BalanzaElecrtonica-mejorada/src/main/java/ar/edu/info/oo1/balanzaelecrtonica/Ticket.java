package ar.edu.info.oo1.balanzaelecrtonica;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author elian
 */
public class Ticket {
    private LocalDate fecha;
    private Integer cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    private List<Producto> productos;

    public Ticket(Integer cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        this.fecha = LocalDate.now();
        this.productos = productos;
    }
    
    public double impuesto() {
        return this.precioTotal * 0.21;
    }

    public LocalDate getFecha() {
        return fecha;
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
}
