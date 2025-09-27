package Practica2.Ejercicio4;

import ClasesUtiles.BinaryTree;

public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;
    
    public int retardoReenvio() {
        if (this.arbol == null || this.arbol.isEmpty()) return 0;
        
        return retardoReenvio(this.arbol, 0);
    }
    
    private int retardoReenvio(BinaryTree<Integer> arbol, int sumActual) {
        sumActual += arbol.getData();
        if (arbol.isLeaf()) return sumActual;
        int izq = arbol.hasLeftChild() ? retardoReenvio(arbol.getLeftChild(),sumActual) : 0;
        int der = arbol.hasLeftChild() ? retardoReenvio(arbol.getRightChild(), sumActual) : 0;
        
        return Math.max(izq, der);
    }
}
