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
public class Ejercicio6 {
    public static void main(String[]args) {
        EstacionMeteorologica estacion = new EstacionMeteorologica("La plata", -34.912, 57.955,3,2021);
        
        System.out.println(estacion.reportarPromediosAnuales());
         System.out.println(estacion.reportarPromediosMensual());
        
    }
}
