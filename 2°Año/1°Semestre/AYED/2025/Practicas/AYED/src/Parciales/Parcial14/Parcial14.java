package Parciales.Parcial14;

import java.util.Iterator;
import tp3.GeneralTree;

public class Parcial14 {
    public boolean esSustituto(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        boolean esSustituto = true;
        
        // Condicion 1
        if (arbol1.getData() % 2 != 0 || arbol1.getData() <= arbol2.getData()) {
            return false;
        }
        
        // Condicion 2B
        if (arbol1.isLeaf() && arbol2.isLeaf()) {
            return true;
        }
        
        // Condicion 2C
        if (arbol1.isLeaf() && !arbol2.isLeaf()) {
            return true;
        }
        if (!arbol1.isLeaf() && arbol2.isLeaf()) {
            return false;
        }
        
        // Condicion 2A
        int hijosParesArbol1 = contarHijosPares(arbol1);
        int hijosParesArbol2 = contarHijosPares(arbol2);
        if (hijosParesArbol1 <= hijosParesArbol2) {
            return false;
        }
        
        Iterator<GeneralTree<Integer>> it1 = arbol1.getChildren().iterator();
        Iterator<GeneralTree<Integer>> it2 = arbol2.getChildren().iterator();
        while (esSustituto && it1.hasNext() && it2.hasNext()) {
            esSustituto = esSustituto(it1.next(),it2.next());
        }
        
        return esSustituto;
    }
    
    
    private Integer contarHijosPares(GeneralTree<Integer> arbol) {
        int suma = 0;
        for (GeneralTree<Integer> hijo : arbol.getChildren()) {
            if (hijo.getData() % 2 == 0) suma++;
        }
        
        if (arbol.getData() % 2 == 0) suma ++;
        
        return suma;
    }
}
