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
public class Ejercicio2 {
    public static void main(String[]args ) {
        Jugador jugador1 = new Jugador(1,2,"Palermo",1000.0,4);
        
        Entrenador entrenador1 = new Entrenador(2,"Guillermo",2000.0,2);
        
        System.out.println(jugador1);
        System.out.println(entrenador1);
    }
    
}
