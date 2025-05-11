package Parciales.Parcial8;

import tp2.ejercicio1.BinaryTree;

public class Parcial8 {
    public static Integer sumaImparesPosOrdenMayorA(BinaryTree<Integer> arbol, int num) {
        if (arbol == null || arbol.isEmpty()) return 0;
        
        return sumaImparesPosOrdenMayorARecursivo(arbol,num);
    }
    
    private static Integer sumaImparesPosOrdenMayorARecursivo(BinaryTree<Integer> arbol, int num) {
        int suma = 0;
        if (arbol.hasLeftChild()) {
            suma += sumaImparesPosOrdenMayorARecursivo(arbol.getLeftChild(), num);
        }
        
        if (arbol.hasRightChild()) {
            suma +=sumaImparesPosOrdenMayorARecursivo(arbol.getRightChild(), num);
        }
        
        if (arbol.getData() > num && arbol.getData() % 2 != 0) {
            suma += arbol.getData();
        }
        
        return suma;
    }
}
