package ar.edu.info.oo1.ejercicio24;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public abstract class Orden {
    private LocalDate fecha;
    private Usuario usuario;
    private String domicilio;
    private List<Producto> productos;

    public Orden(LocalDate fecha, Usuario usuario, String domicilio) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.domicilio = domicilio;
        this.productos = new LinkedList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }
    
    public double calcularCosto(){
        double costo = 0;
        for(Producto prod : this.productos) {
            costo += prod.getCosto();
        }
        
        return costo;
    }
}
