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
public class Ejercicio3 {
    public static void main(String [] args ) {
        Persona persona = new Persona("Elian", 42884131, 24);
        Trabajador trabajador = new Trabajador(("Arquitecto"), "Julieta", 46999123, 30);
        
        System.out.println(persona);
        System.out.println(trabajador);
    } 
}
