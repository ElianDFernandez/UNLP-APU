package ar.edu.info.oo1.instrumentofinanciero;

public class CajaDeAhorro extends Cuenta{
    public CajaDeAhorro(){
        super();
    }
    
    public CajaDeAhorro(double saldo){
        super();
        this.depositar(saldo);
    }
    
    @Override
    public void depositar(double monto) {
        super.depositar(monto - (monto * 0.2));
    }
    
    @Override
    protected void extraerSinControlar(double monto) {
        super.extraerSinControlar(monto + (monto * 0.2));
    }
    
    
    @Override
    public boolean puedeExtraer(double monto) {
        double montoConRecargo = monto + (monto * 0.2);
        if ((montoConRecargo) <= this.getSaldo()) {
            return true;
        } 
        return false;
    }
}
