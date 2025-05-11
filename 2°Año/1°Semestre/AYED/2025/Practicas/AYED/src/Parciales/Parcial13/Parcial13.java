package Parciales.Parcial13;

import tp3.GeneralTree;


public class Parcial13 {
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return false;
        return esDeSeleccionR(arbol);
    }
    
    private static boolean esDeSeleccionR(GeneralTree<Integer> arbol) {
        int min = Integer.MAX_VALUE;
        for (GeneralTree<Integer> hijo : arbol.getChildren()) {
            if (hijo.getData() < min) {
                min = hijo.getData();
            }
            boolean hijosSeleccion = esDeSeleccionR(hijo);
            if (!hijosSeleccion) return false;
        }
        
        if (arbol.isLeaf() || min == arbol.getData()) {
            return true;
        } else {
            return false;
        }
    }
    
}
