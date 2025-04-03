package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class TransformacionTest {
    public static void main(String[] args) {
        // Árbol de prueba:
        //       5
        //      / \
        //     3   7
        //    / \
        //   1   2

        BinaryTree<Integer> raiz = new BinaryTree<>(5);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(1);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(2);

        raiz.addLeftChild(nodo2);
        raiz.addRightChild(nodo3);
        nodo2.addLeftChild(nodo4);
        nodo2.addRightChild(nodo5);

        Transformacion transformacion = new Transformacion(raiz);
        BinaryTree<Integer> nuevoArbol = transformacion.suma();

        // Imprimimos el árbol transformado en preorden
        System.out.println("Árbol transformado en preorden:");
        imprimirPreOrden(nuevoArbol);
    }

    private static void imprimirPreOrden(BinaryTree<Integer> arbol) {
        if (arbol == null) return;
        System.out.print(arbol.getData() + " ");
        imprimirPreOrden(arbol.getLeftChild());
        imprimirPreOrden(arbol.getRightChild());
    }
}
