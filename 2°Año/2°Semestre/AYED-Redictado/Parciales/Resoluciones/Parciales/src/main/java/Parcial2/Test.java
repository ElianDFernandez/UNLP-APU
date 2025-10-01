package Parcial2;

import ClasesUtiles.BinaryTree;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(1);
        
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        arbol.addLeftChild(nodo2);
        arbol.addRightChild(nodo3);

        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        nodo2.addLeftChild(nodo4);

        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        nodo3.addLeftChild(nodo5);
        nodo3.addRightChild(nodo6);

        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        nodo5.addLeftChild(nodo7);

        ParcialArboles parcial = new ParcialArboles();
        parcial.arbol = arbol;

        BinaryTree<Integer> nuevo = parcial.nuevoTree();
        nuevo.imprimirArbol();
    }
}
