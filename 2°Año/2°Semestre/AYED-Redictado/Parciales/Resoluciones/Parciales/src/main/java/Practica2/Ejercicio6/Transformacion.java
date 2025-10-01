package Practica2.Ejercicio6;

import ClasesUtiles.BinaryTree;

public class Transformacion {
    private BinaryTree<Integer> arbol;
    
    public BinaryTree<Integer> suma() {
        if (this.arbol == null) return null;
        sumaRecursivo(this.arbol);
        
        return this.arbol;
    }
    
    private int sumaRecursivo(BinaryTree<Integer> arbol) {
        int suma = 0;
        if (arbol.isLeaf()) {
            suma = arbol.getData();
            arbol.setData(suma);
            return suma;
        }
        if (arbol.hasLeftChild()) {
            suma += sumaRecursivo(arbol.getLeftChild());
        }
        
        if (arbol.hasRightChild()) {
            suma += sumaRecursivo(arbol.getRightChild());
        }
        int actual = arbol.getData();
        arbol.setData(suma);
        
        return actual + suma;
    }
}
