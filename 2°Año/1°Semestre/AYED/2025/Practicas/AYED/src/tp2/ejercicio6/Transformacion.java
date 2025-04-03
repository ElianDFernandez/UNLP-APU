package tp2.ejercicio6;

import tp2.ejercicio1.BinaryTree;

public class Transformacion {
    BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> suma() {
        if (this.arbol == null) return null;
        sumaRecursivo(this.arbol);
        
        return this.arbol;
    }
    
    private int sumaRecursivo(BinaryTree<Integer>ab) {
        int sum = 0;
        if(ab.isLeaf()) {
            sum = ab.getData();
            ab.setData(0);
            return sum;
        }
        if(ab.hasLeftChild()) {
            sum+= sumaRecursivo(ab.getLeftChild());
        }
        if(ab.hasRightChild()) {
            sum+= sumaRecursivo(ab.getRightChild());
        }
        int actual = ab.getData();
        ab.setData(sum);
        return actual + sum;
    }
}
