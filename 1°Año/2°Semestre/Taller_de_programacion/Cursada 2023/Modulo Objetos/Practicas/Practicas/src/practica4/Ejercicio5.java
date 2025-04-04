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
public class Ejercicio5 {
    public static void main(String [] args ) {
        Circulo circulo1 = new Circulo(10.0, "verde", "negro");
        Triangulo triangulo1 = new Triangulo(8.0, 8.0, 8.0, "azul", "blanco");
        Circulo circulo2 = new Circulo(25.0, "naranja", "gris");
        Triangulo triangulo2 = new Triangulo(10.0, 12.0, 14.0, "morado", "amarillo");
        Triangulo triangulo3 = new Triangulo(15.0, 15.0, 10.0, "rosa", "negro");
        
        VisorFigurasModificado visor = new VisorFigurasModificado();
        visor.guardar(circulo1);
        visor.guardar(triangulo1);
        visor.guardar(circulo2);
        visor.guardar(triangulo2);
        System.out.println(visor.quedaEspacio());
        visor.guardar(triangulo3);
        System.out.println(visor.quedaEspacio());
        visor.guardar(triangulo3);
        System.out.println(visor.quedaEspacio());
        visor.mostrar();
    }
}