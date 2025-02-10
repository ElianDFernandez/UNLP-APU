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
public class Triangulo extends Figura{
    private Double lado1;
    private Double lado2;
    private Double lado3;

    public Triangulo(Double lado1, Double lado2, Double lado3, String relleno, String contorno) {
        super(relleno, contorno);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    public Double getLado1() {
        return lado1;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public Double getLado3() {
        return lado3;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
    }

    public Double calcularPerimetro() {
        return lado1+lado2+lado3;
    }
        
    @Override
    public String toString() {
        return super.toString() + "{ Triangulo: Lado 1: " +lado1+" Lado 2: "+lado2+ " Lado 3: "+lado3+" }";
    }
    
    
}
