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
public class Ejercicio1 {
    public static void main(String[]args) {
        Circulo circulo = new Circulo(12.5, "azul", "amarillo");
        Triangulo triangulo = new Triangulo(12.0,15.0,12.0,"rojo","violeta");
        
        System.out.println(circulo);
        System.out.println(triangulo);
        
        circulo.despintar();
        System.out.println(circulo);
    }
}
