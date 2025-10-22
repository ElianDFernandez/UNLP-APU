/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial14;

import generales.BinaryTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Parcial {
    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        List<Integer> lista = new LinkedList<>();
        if (arbol == null || arbol.isEmpty()) return lista;
        
        resolverR(arbol, lista);
        
        return lista;
    }
    
    private void resolverR(BinaryTree<Integer> arbol, List<Integer> lista) {
        int izq = 0;
        int der = 0;
        if (arbol.hasLeftChild()) {
            izq = contarNodos(arbol.getLeftChild());
            resolverR(arbol.getLeftChild(),lista);
        }
        if (arbol.hasRightChild()) {
            der = contarNodos(arbol.getRightChild());
            resolverR(arbol.getRightChild(),lista);
        }
        
        if (izq == der) {
            lista.add(arbol.getData());
        }
    }
    
    private int contarNodos(BinaryTree<Integer> arbol) {
        int sum = 1;
        if (arbol.hasLeftChild()) {
            sum += contarNodos(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()) {
            sum += contarNodos(arbol.getRightChild());
        }
        
        return sum;
    }
}
