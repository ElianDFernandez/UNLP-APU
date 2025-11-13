package ar.edu.info.oo1.mantenimientos;

/**
 *
 * @author Elian
 */
public abstract class Servicio {
    private double precioHora;
    private int cantidadHoras;

    public Servicio(double precioHora, int cantidadHoras) {
        this.precioHora = precioHora;
        this.cantidadHoras = cantidadHoras;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }
    
    public abstract double monto();
}
