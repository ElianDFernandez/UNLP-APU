package ar.edu.info.oo1.balanzaelecrtonica;

/**
 *
 * @author elian
 */
public class Balanza {
    private Integer cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza() {
        this.cantidadDeProductos = 0;
        this.precioTotal =0;
        this.pesoTotal = 0;
    }
    
    public void ponerEnCero() {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
    }
    
    public void agregarProducto(Producto producto) {
        this.cantidadDeProductos ++;
        this.precioTotal += producto.getPrecioPorKilo()* producto.getPeso();
        this.pesoTotal += producto.getPeso();
    }
    
    public Ticket emitirTicket() {
        Ticket ticket = new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
        
        return ticket;
    }

    public Integer getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(Integer cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
    
}
