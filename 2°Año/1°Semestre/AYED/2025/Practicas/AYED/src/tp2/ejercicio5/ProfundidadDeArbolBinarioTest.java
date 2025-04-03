package tp2.ejercicio5;

import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinarioTest {
    public static void main(String[] args) {
        // Construimos el árbol:
        //         1
        //       /   \
        //     2       3
        //    / \     /
        //   4   5   6

        BinaryTree<Integer> raiz = new BinaryTree<>(1);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);

        raiz.addLeftChild(nodo2);
        raiz.addRightChild(nodo3);
        nodo2.addLeftChild(nodo4);
        nodo2.addRightChild(nodo5);
        nodo3.addLeftChild(nodo6);

        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario();
        prof.setArbol(raiz);

        // Pruebas
        System.out.println("Suma en profundidad 0: " + prof.sumaElementosProfundidad(0)); // 1
        System.out.println("Suma en profundidad 1: " + prof.sumaElementosProfundidad(1)); // 2 + 3 = 5
        System.out.println("Suma en profundidad 2: " + prof.sumaElementosProfundidad(2)); // 4 + 5 + 6 = 15
        System.out.println("Suma en profundidad 3: " + prof.sumaElementosProfundidad(3)); // 0
    }
}

