/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial22;

import generales.BinaryTree;

/**
 *
 * @author Elian
 */
public class Parcial {
    private BinaryTree<Integer> arbol;
    
    public BinaryTree<Integer> nuevoTree() {
        if (this.arbol == null || this.arbol.isEmpty()) return null;
        
        return nuevoTreeR(this.arbol,0);
    }
    
    private BinaryTree<Integer> nuevoTreeR(BinaryTree<Integer> arbol, int valorPadre) {
        BinaryTree<Integer> nuevoNodo = new BinaryTree<>();
        nuevoNodo.setData(arbol.getData() + valorPadre);
        if (arbol.hasLeftChild()) {
            nuevoNodo.addLeftChild(nuevoTreeR(arbol.getLeftChild(), arbol.getData()));
        }
        
        if (arbol.hasRightChild()) {
            nuevoNodo.addRightChild(nuevoTreeR(arbol.getRightChild(), 0));
        }
        
        return nuevoNodo;
    }
}
