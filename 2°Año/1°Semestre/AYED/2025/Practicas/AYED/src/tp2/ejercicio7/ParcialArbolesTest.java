package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArbolesTest {
    public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(2);

        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo23 = new BinaryTree<>(23);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(-5);
        BinaryTree<Integer> nodo19 = new BinaryTree<>(19);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(-3);

        raiz.addLeftChild(nodo7);
        raiz.addRightChild(nodo5);

        nodo7.addLeftChild(nodo23);

        nodo5.addLeftChild(nodo19);
        nodo19.addRightChild(nodo4);
        nodo4.addLeftChild(nodo3);
        
        /*
                 2
                / \
               7   -5
              /     \
            23      19
                      \
                       4
                      /
                    -3
        */

        ParcialArboles parcial = new ParcialArboles();
        parcial.setArbol(raiz);

        // Pruebas
        System.out.println("isLeftTree(7): " + parcial.isLeftTree(7));     // true
        System.out.println("isLeftTree(2): " + parcial.isLeftTree(2));     // false
        System.out.println("isLeftTree(-5): " + parcial.isLeftTree(-5));   // true
        System.out.println("isLeftTree(19): " + parcial.isLeftTree(19));   // false
        System.out.println("isLeftTree(-3): " + parcial.isLeftTree(-3));   // false 
        System.out.println("isLeftTree(4): " + parcial.isLeftTree(4));    //  false
        System.out.println("isLeftTree(100): " + parcial.isLeftTree(100)); // false
    }
}
