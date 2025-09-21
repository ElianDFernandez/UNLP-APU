package Arboles.Parcial1;
import ClasesUtiles.BinaryTree;

public class ParcialArboles {
    public BinaryTree<DatoNodo> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<DatoNodo> nuevoArbol = new BinaryTree<DatoNodo>();
        if (arbol == null || arbol.isEmpty()) {
            return null;
        }
        sumAndDifHelper(arbol, nuevoArbol);

        return nuevoArbol;
    }

    private void sumAndDifHelper(BinaryTree<Integer> arbol, BinaryTree<DatoNodo> nuevoArbol) {
        if (arbol == null || arbol.isEmpty()) {
            return;
        }

        int suma = 0;
        int diferencia = 0;

        if (arbol.getLeftChild() != null && !arbol.getLeftChild().isEmpty()) {
            suma += arbol.getLeftChild().getData();
            diferencia -= arbol.getLeftChild().getData();
        }

        if (arbol.getRightChild() != null && !arbol.getRightChild().isEmpty()) {
            suma += arbol.getRightChild().getData();
            diferencia += arbol.getRightChild().getData();
        }

        DatoNodo dato = new DatoNodo(suma, diferencia);
        nuevoArbol.setData(dato);

        if (arbol.hasLeftChild()) {
            BinaryTree<DatoNodo> leftChild = new BinaryTree<DatoNodo>();
            nuevoArbol.addLeftChild(leftChild);
            sumAndDifHelper(arbol.getLeftChild(), nuevoArbol.getLeftChild());
        }

        if (arbol.hasRightChild()){
            BinaryTree<DatoNodo> rightChild = new BinaryTree<DatoNodo>();
            nuevoArbol.addRightChild(rightChild);
            sumAndDifHelper(arbol.getRightChild(), nuevoArbol.getRightChild());
        }
    }

    public void printTree(BinaryTree<DatoNodo> tree) {
        if (tree == null || tree.isEmpty()) {
            return;
        }
        System.out.println("Nodo: " + tree.getData());
        printTree(tree.getLeftChild());
        printTree(tree.getRightChild());
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        BinaryTree<Integer> arbol = new BinaryTree<>(5);
        arbol.addLeftChild(new BinaryTree<>(3));
        arbol.addRightChild(new BinaryTree<>(8));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(1));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(4));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(7));
        arbol.getRightChild().addRightChild(new BinaryTree<>(10));

        ParcialArboles parcial = new ParcialArboles();
        BinaryTree<DatoNodo> nuevoArbol = parcial.sumAndDif(arbol);
        parcial.printTree(nuevoArbol);
    }
}

