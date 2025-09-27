package Parcial1;

import ClasesUtiles.BinaryTree;

public class ParcialArboles {
    public BinaryTree<DatosNodo> sumAndDif(BinaryTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;
        return sumAndDif(arbol, 0, 0);
    }
    
    private BinaryTree<DatosNodo> sumAndDif(BinaryTree<Integer> arbol, int sumaPadre, int valorPadre) {
        int valorActual = arbol.getData();
        int sumaActual = sumaPadre + valorActual;
        int diferencia = valorActual - valorPadre;

        DatosNodo datos = new DatosNodo(sumaActual, diferencia);
        BinaryTree<DatosNodo> nodo = new BinaryTree<>(datos);

        if (arbol.hasLeftChild()) {
            nodo.addLeftChild(sumAndDif(arbol.getLeftChild(), sumaActual, valorActual));
        }
        if(arbol.hasRightChild()) {
            nodo.addRightChild(sumAndDif(arbol.getRightChild(), sumaActual, valorActual));
        }

        return nodo;
    }
    
    // Test 
        public static void main(String[] args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(20);

        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo30 = new BinaryTree<>(30);

        raiz.addLeftChild(nodo5);
        raiz.addRightChild(nodo30);

        nodo5.addLeftChild(new BinaryTree<>(-5));
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
        nodo5.addRightChild(nodo10);
        nodo10.addLeftChild(new BinaryTree<>(1));

        BinaryTree<Integer> nodo50 = new BinaryTree<>(50);
        BinaryTree<Integer> nodoMenos9 = new BinaryTree<>(-9);
        nodo30.addLeftChild(nodo50);
        nodo30.addRightChild(nodoMenos9);

        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        nodoMenos9.addLeftChild(nodo4);
        nodo4.addRightChild(new BinaryTree<>(6));

        ParcialArboles parcial = new ParcialArboles();
        BinaryTree<DatosNodo> nuevo = parcial.sumAndDif(raiz);
        
        nuevo.imprimirArbol();
    }
}