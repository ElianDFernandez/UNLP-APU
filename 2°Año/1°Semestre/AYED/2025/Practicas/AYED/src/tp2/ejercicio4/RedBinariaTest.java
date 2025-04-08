package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaTest {
    public static void main(String[] args) {
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        arbol.addLeftChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(5));

        arbol.getLeftChild().addLeftChild(new BinaryTree<>(9));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(2));

        arbol.getRightChild().addLeftChild(new BinaryTree<>(7));
        arbol.getRightChild().addRightChild(new BinaryTree<>(12));

        System.out.println("Máximo retardo: " + RedBinariaLlena.retardoReenvio(arbol));
    }
}
