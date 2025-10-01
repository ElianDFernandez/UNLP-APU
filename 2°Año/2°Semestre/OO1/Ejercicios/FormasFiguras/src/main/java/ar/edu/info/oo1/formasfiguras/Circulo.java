package ar.edu.info.oo1.formasfiguras;

public class Circulo implements Forma{
    private double radio;

    public Circulo() {
    }

    public double getDiametro() {
        return this.radio * 2;
    }
    
   public void setDiametro(double diametro) {
       this.radio = diametro / 2;
   }
   
   public double getRadio() {
       return this.radio;
    }
   
   public void setRadio(double radio) {
       this.radio = radio;
    }
   
   public double getPerimetro() {
       return Math.PI * this.getDiametro();
   }
   
   public double getArea() {
       return Math.PI*this.radio*this.radio;
   }
}
