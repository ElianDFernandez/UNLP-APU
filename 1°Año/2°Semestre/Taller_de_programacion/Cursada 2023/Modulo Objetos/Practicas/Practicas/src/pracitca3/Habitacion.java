package pracitca3;

/**
 *
 * @author Elian
 */
public class Habitacion {
    private Double costoNoche;
    private Boolean ocupada;
    private Cliente cliente;

    public Habitacion(Double costoNoche, Boolean ocupada) {
        this.costoNoche = costoNoche;
        this.ocupada = ocupada;
    }

    public Double getCostoNoche() {
        return costoNoche;
    }

    public void setCostoNoche(Double costoNoche) {
        this.costoNoche = costoNoche;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String toString() {
        return costoNoche + ", " + ocupada + ", " + cliente;
    }
}
