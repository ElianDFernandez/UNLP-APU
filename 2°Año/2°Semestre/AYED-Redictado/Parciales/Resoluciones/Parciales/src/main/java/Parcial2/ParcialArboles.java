package Parcial2;

import ClasesUtiles.BinaryTree;

public class ParcialArboles {
    
    public BinaryTree<Integer> arbol;
    
    public BinaryTree<Integer> nuevoTree(){
        if (this.arbol == null) return null;
        return nuevoTree(this.arbol, 0);
    }
    
    private BinaryTree<Integer> nuevoTree(BinaryTree<Integer> arbol, int valorPadre) {
        BinaryTree<Integer> nodo = new BinaryTree<>(arbol.getData()+valorPadre);
        if (arbol.hasLeftChild()) {
            nodo.addLeftChild(nuevoTree(arbol.getLeftChild(), arbol.getData()));
        }
        
        if(arbol.hasRightChild()) {
            nodo.addRightChild(nuevoTree(arbol.getRightChild(), 0));
        }
        
        return nodo;
    }
}
