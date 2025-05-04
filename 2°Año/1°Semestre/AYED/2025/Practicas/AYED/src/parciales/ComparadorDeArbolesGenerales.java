package parciales;

import java.util.Iterator;
import tp3.GeneralTree;

public class ComparadorDeArbolesGenerales {
    public boolean esSustituto(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        boolean esSustituto = true;
        
        if (arbol1 == null || arbol2 == null || arbol1.isEmpty() || arbol2.isEmpty()) return false;
        
        // 1. El valor de cada nodo en arbol1 debe ser par mayor estricto que el valor del nodo correspondiente en arbol2.
        if (arbol1.getData() % 2 != 0 || arbol1.getData() < arbol2.getData()) return false; 
        
        // b)Si ambos nodos son hojas: La condición se considera cumplida para esos nodos si se cumple la condición 1.
        if (arbol1.isLeaf() && arbol2.isLeaf()) return true;
        
        // c1)Si un nodo de arbol1 es hoja y el nodo correspondiente en arbol2 no es hoja, entonces la condición se
        // considera cumplida para ese nodo si se cumple la condición 1.
        if (arbol1.isLeaf() && !arbol2.isLeaf()) return true;
        
        // c2)Si un nodo de arbol1 NO es hoja y el nodo correspondiente en arbol2 es hoja, entonces arbol1 NO es
        // "sustituto", y el método debe devolver false.
        if (!arbol1.isLeaf() && arbol2.isLeaf()) return false;
        
        // 2. a)Si ambos nodos tienen hijos, la cantidad de hijos con valores pares en arbol1 debe ser mayor estricto que la
        // cantidad de hijos con valores pares del nodo correspondiente en arbol2.        
        if (!arbol1.isLeaf() && !arbol2.isLeaf()) {
            if (getHijosPares(arbol1) < getHijosPares(arbol2)) return false;
            Iterator<GeneralTree<Integer>> it1 = arbol1.getChildren().iterator();
            Iterator<GeneralTree<Integer>> it2 = arbol2.getChildren().iterator();
            while (esSustituto && it1.hasNext() && it2.hasNext()) {
                esSustituto = esSustituto(it1.next(), it2.next());
            }
        }
        
        return esSustituto;
    }
    
    private Integer getHijosPares(GeneralTree<Integer> arbol) {
        int hijos = 0;
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
           if (hijo.getData() % 2 == 0) hijos++; 
        }
        
        return hijos;
    }
}
