package ar.edu.info.oo1.balanzaelecrtonica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elian
 */
public class Balanza {
    private List<Producto> productos;
 
    public Balanza() {
        productos = new ArrayList<>();
    }
    
    public void ponerEnCero() {
        this.productos.clear();
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    public Ticket emitirTicket() {
        Ticket ticket = new Ticket(this.getCantidadDeProductos(),  this.getPesoTotal(), this.getPrecioTotal(), productos);
        
        return ticket;
    }

    public Integer getCantidadDeProductos() {
        return this.productos.size();
    }

    public double getPrecioTotal() {
        double precio = 0;
        for(Producto producto : productos) {
            precio += producto.getPrecio();
        }
        
        return precio;
    }

    public double getPesoTotal() {
        double peso = 0;
        for(Producto producto:productos) {
            peso += producto.getPeso();
        }
        
        return peso;
    }    
}
