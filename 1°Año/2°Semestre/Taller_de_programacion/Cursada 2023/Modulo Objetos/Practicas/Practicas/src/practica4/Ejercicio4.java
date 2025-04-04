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
public class Ejercicio4 {
    public static void main(String[] args) {
        VisorFiguras visor = new VisorFiguras();

        Circulo c1 = new Circulo(10.0,"Violeta","Rosa");
        
        visor.mostrar(c1);
        System.out.println(visor.getMostradas());
    }
}
