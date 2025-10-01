package ar.edu.info.oo1.instrumentofinanciero;

public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;
    
    public CuentaCorriente() {
        super();
        this.limiteDescubierto = 0;
    }

    public double getLimiteDescubierto() {
        return limiteDescubierto;
    }

    public void setLimiteDescubierto(double limiteDescubierto) {
        this.limiteDescubierto = limiteDescubierto;
    }
    
    @Override
    protected boolean puedeExtraer(double monto) {
        if (monto <= this.getSaldo() + this.limiteDescubierto) {
            return true;
        }
        return false;
    }
}
