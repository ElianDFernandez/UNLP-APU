package ar.edu.info.oo1.formasfiguras;

/**
 *
 * @author elian
 */
public class Cuadrado implements Forma{
    private double lado;
    
    public Cuadrado() {
    }
    
    public void setLado(double lado) {
        this.lado = lado;
    }
    
    public double getLado() {
        return this.lado;
    }
    
    public double getPerimetro() {
        return this.lado*4;
    }
    
    public double getArea() {
        return this.lado*this.lado;
    }
}
