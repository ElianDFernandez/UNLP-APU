package ar.edu.info.oo1.mantenimientos;

/**
 *
 * @author Elian
 */
public class ServicioLimpieza extends Servicio{
    private double tarifaMinima;

    public ServicioLimpieza(double tarifaMinima, double precioHora, int cantidadHoras) {
        super(precioHora, cantidadHoras);
        this.tarifaMinima = tarifaMinima;
    }

    public double getTarifaMinima() {
        return tarifaMinima;
    }

    public void setTarifaMinima(double tarifaMinima) {
        this.tarifaMinima = tarifaMinima;
    }

    @Override
    public double monto() {
        double montoTotal = this.getCantidadHoras()*this.getPrecioHora();
        if (montoTotal < tarifaMinima) {
            return tarifaMinima;
        } else {
            return montoTotal;
        }
    }   
}
