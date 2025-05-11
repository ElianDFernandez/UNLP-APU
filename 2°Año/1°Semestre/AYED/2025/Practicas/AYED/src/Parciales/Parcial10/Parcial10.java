package Parciales.Parcial10;

import tp2.ejercicio1.BinaryTree;

public class Parcial10 {
    public boolean esPrefijo(BinaryTree<Integer> arbol, BinaryTree<Integer> arbol2) {
        boolean esPrefijo = true;
        if (arbol.getData() == arbol2.getData()){
            if (arbol.hasLeftChild()) {
                if (arbol2.hasLeftChild()){
                    esPrefijo = esPrefijo(arbol.getLeftChild(), arbol2.getRightChild());
                }
            }
            if (!esPrefijo) {
                return false;
            } else {
                if (arbol.hasRightChild()) {
                    if(arbol2.hasRightChild()) {
                        esPrefijo = esPrefijo(arbol.getRightChild(), arbol2.getRightChild());
                    }
                }
            }
        } else {
            return false;
        }
        
        return esPrefijo;
    }
}
