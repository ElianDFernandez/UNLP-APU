package ar.edu.info.oo1.mantenimientos;

/**
 *
 * @author Elian
 */
public class ServicioParquizacion extends Servicio {
    private int cantidadMaquinas;
    private double costoMantenimiento;

    public ServicioParquizacion(int cantidadMaquinas, double costoMantenimiento, double precioHora, int cantidadHoras) {
        super(precioHora, cantidadHoras);
        this.cantidadMaquinas = cantidadMaquinas;
        this.costoMantenimiento = costoMantenimiento;
    }

    public int getCantidadMaquinas() {
        return cantidadMaquinas;
    }

    public void setCantidadMaquinas(int cantidadMaquinas) {
        this.cantidadMaquinas = cantidadMaquinas;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    @Override
    public double monto() {
        return (this.getCantidadHoras()*this.getPrecioHora()) + (this.costoMantenimiento * this.cantidadMaquinas);
    }
}
