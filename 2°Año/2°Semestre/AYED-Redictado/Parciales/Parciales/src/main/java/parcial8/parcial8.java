/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial8;

import generales.BinaryTree;

/**
 *
 * @author Elian
 */
public class parcial8 {
    public BinaryTree<Dato> sumAndDif(BinaryTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;
        
        return sumAndDifHelper(arbol, 0, 0);
    }
    
    private BinaryTree<Dato> sumAndDifHelper(BinaryTree<Integer> arbol, int sumaPadre, int valorPadre){
        int sumActul = arbol.getData()+ sumaPadre;
        int difActual = arbol.getData() - valorPadre;
        Dato dato = new Dato(sumActul, difActual);
        BinaryTree<Dato> nodoNuevo = new BinaryTree<>(dato);
        
        if(arbol.hasLeftChild()) {
            nodoNuevo.addLeftChild(sumAndDifHelper(arbol.getLeftChild(),sumActul, arbol.getData()));
        }
        if(arbol.hasRightChild()) {
            nodoNuevo.addRightChild(sumAndDifHelper(arbol.getRightChild(), sumActul, arbol.getData()));
        }
        
        return nodoNuevo;
    }
}
