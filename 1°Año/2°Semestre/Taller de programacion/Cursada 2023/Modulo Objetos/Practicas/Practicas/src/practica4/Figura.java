/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;

/**
 *
 * @author elian
 */
public abstract class Figura {
    private String relleno;
    private String contorno;
    
    public Figura(String relleno, String contorno) {
        this.relleno = relleno;
        this.contorno = contorno;
    }
    
    public String getRelleno() {
        return this.relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }
    
    public String getContorno() {
        return contorno;
    }

    public void setContorno(String contorno) {
        this.contorno = contorno;
    }
    
    public void despintar() {
        this.relleno = "blanco";
        this.contorno = "negro";
    }
    
    public abstract Double calcularPerimetro();

    @Override
    public String toString() {
        return "{ Figura: Relleno: "+relleno+ " Contorno: "+contorno+" Perimetro: "+ this.calcularPerimetro ()+" }";
    }
    
    
}
