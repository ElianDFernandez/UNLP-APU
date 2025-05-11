package Parciales.Parcial12;

import tp2.ejercicio1.BinaryTree;

public class Parcial12 {
    public BinaryTree<Nodo> sumAndDif(BinaryTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;
        
        BinaryTree<Nodo> arbolNuevo = new BinaryTree<Nodo>(new Nodo());
        if (arbol.hasLeftChild()) {
            arbolNuevo.addLeftChild(sumAndDif(arbol.getLeftChild()));
            arbolNuevo.getData().agregar(arbol.getData(), arbol.getLeftChild().getData());
        }
        if (arbol.hasRightChild()) {
            arbolNuevo.addRightChild(sumAndDif(arbol.getRightChild()));
            arbolNuevo.getData().agregar(arbol.getData(), arbol.getRightChild().getData()); 
        }
        
        return arbolNuevo;
    }
}
