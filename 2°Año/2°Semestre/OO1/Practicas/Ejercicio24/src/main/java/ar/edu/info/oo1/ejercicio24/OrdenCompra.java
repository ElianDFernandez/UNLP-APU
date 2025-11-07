package ar.edu.info.oo1.ejercicio24;

import java.time.LocalDate;

/**
 *
 * @author Elian
 */
public class OrdenCompra extends Orden {
    private double precioEnvio;

    public OrdenCompra(double precioEnvio, LocalDate fecha, Usuario usuario, String domicilio) {
        super(fecha, usuario, domicilio);
        this.precioEnvio = precioEnvio;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }
    
    public double calcularCosto(){
        double costo = super.calcularCosto();
        if (this.getProductos().size() >= 5){
            return costo*0.9;
        }
        
        return costo;
    }
}
