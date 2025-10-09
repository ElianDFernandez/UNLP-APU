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
        System.out.println("Se quiere depositar: " + monto);
        double recargo = monto * 0.2;
        System.out.println("Recargo: " + recargo);
        double montoADepositar = monto - recargo;
        super.depositar(montoADepositar);
        System.out.print("Se deposito:  " +montoADepositar);
    }
    
    @Override
    protected void extraerSinControlar(double monto) {
        super.extraerSinControlar(monto + (monto * 0.2));
    }
    
    
    @Override
    public boolean puedeExtraer(double monto) {
        double montoConRecargo = monto + (monto * 0.2);
        System.out.println("Se quiere extraer: " + montoConRecargo); 
        System.out.println("Saldo actual:  " +this.getSaldo());
        if ((montoConRecargo) <= this.getSaldo()) {
            return true;
        } 
        return false;
    }
}
