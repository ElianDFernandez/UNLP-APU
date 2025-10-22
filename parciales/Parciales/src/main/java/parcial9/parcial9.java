/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial9;

import generales.GeneralTree;

/**
 *
 * @author Elian
 */
public class parcial9 {
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return false;
        
        return esDeSeleccionR(arbol);
    }
    
    private static boolean esDeSeleccionR(GeneralTree<Integer> arbol) {
        if (arbol.isLeaf()) {
            return true;
        }
        
        int min = Integer.MAX_VALUE;
        
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            if (hijo.getData() < min) {
                min = hijo.getData();
            }
            if (!esDeSeleccionR(hijo)) {
                return false;
            }
        }
        
        return arbol.getData() == min;
    }
}
