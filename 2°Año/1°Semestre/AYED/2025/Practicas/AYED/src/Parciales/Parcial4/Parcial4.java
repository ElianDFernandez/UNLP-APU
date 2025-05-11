package Parciales.Parcial4;

import tp3.GeneralTree;

public class Parcial4 {
    public static Integer buscarMayor(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;

        for (GeneralTree<Integer> hijo : arbol.getChildren()) {
            int maxHijo = buscarMayor(hijo);
            if (maxHijo > max) {
                max = maxHijo;
            }
        }
        
        if (arbol.getData() > max) {
            max = arbol.getData();
        }

        return max;
    }
}
