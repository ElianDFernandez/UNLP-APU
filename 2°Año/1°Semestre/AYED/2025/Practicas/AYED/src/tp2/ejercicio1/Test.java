package tp2.ejercicio1;

import tp2.ejercicio1.BinaryTree;

public class Test {
    /*
    Sumar arboles solo si tienen la misma estructura 
    */
    
    public BinaryTree<Integer> sumarArboles(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        BinaryTree<Integer> arbolResultado = new BinaryTree<>();
        if (arbol1 == null && arbol1.isEmpty() && arbol2 == null && arbol2.isEmpty()) return arbolResultado;
        Boolean estructuraValida = sumarArbolesRecursivo(arbol1, arbol2, arbolResultado);
        
        return estructuraValida ? arbolResultado : new BinaryTree<>();
    }
    
    private Boolean sumarArbolesRecursivo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2, BinaryTree<Integer> arbolResultado) {
        boolean estructuraValida = true;
        arbolResultado.setData(arbol1.getData() + arbol2.getData());
        
        if (arbol1.hasLeftChild() && arbol2.hasLeftChild()){
            if (arbol1.hasRightChild() == arbol2.hasRightChild()) {
                arbolResultado.addLeftChild(new BinaryTree<Integer>());
                estructuraValida = sumarArbolesRecursivo(arbol1.getLeftChild(), arbol2.getLeftChild(), arbolResultado.getLeftChild());
            } else {
                estructuraValida = false; // las ramas derechas no coinciden
            }
        }
        
        if (estructuraValida) {
            if (arbol1.hasRightChild() && arbol2.hasRightChild()) {
                if (arbol1.hasLeftChild()== arbol2.hasLeftChild()) {
                    arbolResultado.addRightChild(new BinaryTree<Integer>());
                    estructuraValida = sumarArbolesRecursivo(arbol1.getRightChild(), arbol2.getRightChild(), arbolResultado.getRightChild());
                } else {
                    estructuraValida = false; // las ramas izquierdas no coinciden
                }
            }
        }
        
        return estructuraValida;
    }
}
