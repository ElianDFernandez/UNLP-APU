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
public class Circulo extends Figura {
    private Double radio;

    public Circulo(Double radio, String relleno, String contorno) {
        super(relleno, contorno);
        this.radio = radio;
    }
    
    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }
    
    public Double calcularPerimetro() {
        return (Math.PI * 2 * radio);
    }

    @Override
    public String toString() {
        return super.toString() + "{ Circulo: Radio: "+radio+" }";
    }
    
    
}
