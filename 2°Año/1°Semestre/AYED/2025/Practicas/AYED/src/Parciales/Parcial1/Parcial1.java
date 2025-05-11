package Parciales.Parcial1;

import tp2.ejercicio1.BinaryTree;

public class Parcial1 {
    private BinaryTree<Integer> arbol;

    public Boolean isTwoTree(int num) {
        if (arbol == null || arbol.isEmpty()) return false;
        BinaryTree<Integer> nodo = this.buscarArbol(arbol, num);
        if (nodo == null) return false;
        int izq = -1;
        int der = -1;
        if(nodo.hasLeftChild()) contarNodosConDosHijos(nodo.getLeftChild());
        if(nodo.hasRightChild()) contarNodosConDosHijos(nodo.getRightChild());
        
        return izq == der;
    }

    private BinaryTree<Integer> buscarArbol(BinaryTree<Integer> arbol, int num) {
        if (arbol.getData() == num) return arbol;
        BinaryTree<Integer> resultado = null;
        if (arbol.hasLeftChild()) {
            resultado = buscarArbol(arbol.getLeftChild(), num);
            if (resultado != null) return resultado;
        }
        if (arbol.hasRightChild()) {
            resultado = buscarArbol(arbol.getRightChild(), num);
        }

        return resultado;
    }

    private int contarNodosConDosHijos(BinaryTree<Integer> arbol) {
        int suma = 0;
        if (arbol.hasLeftChild() && arbol.hasRightChild()) {
            suma = 1;
        }
        if (arbol.hasLeftChild()) {
            suma += contarNodosConDosHijos(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()) {
            suma += contarNodosConDosHijos(arbol.getRightChild());
        }

        return suma;
    }
}
