package ar.edu.info.oo1.formasfiguras;

/**
 *
 * @author elian
 */
public class Cuerpo3D {
    private Forma caraBasal;
    private Cuadrado cuadrado;
    
    public Cuerpo3D() {
    }
    
    public void setAltura(double altura) {
        this.cuadrado = new Cuadrado();
        this.cuadrado.setLado(altura);
    }
    
    public double getAltura() {
        return this.cuadrado.getLado();
    }
    
    public void setCaraBasal(Forma forma) {
        this.caraBasal = forma;
    }
    
   public double getVolumen(){
       return this.caraBasal.getArea()*this.getAltura();
   }
   
   public double getSuperficieExterior() {
       return (2*this.caraBasal.getArea())+(this.caraBasal.getPerimetro() * this.cuadrado.getLado());
   }
}
