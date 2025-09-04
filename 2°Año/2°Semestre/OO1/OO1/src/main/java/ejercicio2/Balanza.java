package ejercicio2;

import java.time.LocalDate;

/**
 *
 * @author elian
 */
public class Balanza {
    private Integer cantidadDeProductos;
    private double  precioTotal;
    private double  pesoTotal;

    public Balanza() {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0.0;
        this.pesoTotal  = 0.0;
    }
    
    public void ponerEnCero() {
        this.pesoTotal = 0.0;
        this.precioTotal = 0.0;
        this.cantidadDeProductos = 0;
    }
    
    public void agregarProducto(Producto producto){
        this.pesoTotal += producto.getPeso();
        this.precioTotal += producto.getPrecioPorKilo() * producto.getPeso();
        this.cantidadDeProductos++;
    }
    
    public Ticket emitirTicket() {
        Ticket  ticket = new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
        return ticket;
    }

    public Integer getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(Integer cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
    
}
