package ar.edu.info.oo1.impuestos;

/**
 *
 * @author Elian
 */
public class Inmueble implements Bien {
    public int numeroPartida;
    public double valorLote;
    public double valorEdificacion;

    public Inmueble(int numeroPartida, double valorLote, double valorEdificacion) {
        this.numeroPartida = numeroPartida;
        this.valorLote = valorLote;
        this.valorEdificacion = valorEdificacion;
    }

    public int getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(int numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public double getValorLote() {
        return valorLote;
    }

    public void setValorLote(double valorLote) {
        this.valorLote = valorLote;
    }

    public double getValorEdificacion() {
        return valorEdificacion;
    }

    public void setValorEdificacion(double valorEdificacion) {
        this.valorEdificacion = valorEdificacion;
    }
    
    public double calcularImpuesto(){
        return (this.valorEdificacion+this.valorLote)*0.01;
    }
}
