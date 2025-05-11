package Parciales.Parcial3;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

public class Parcial3 {
    public static List<Integer> resolver(BinaryTree<Integer> arbol) {
        List<Integer> lista = new LinkedList<>();
        if (arbol == null || arbol.isEmpty()) return lista;
        
        resolver(arbol, lista);
        return lista;
    }
    
    private static void resolver(BinaryTree<Integer> arbol, List<Integer> lista) {
        int izq = 0;
        int der = 0;
        
        if (arbol.hasLeftChild()) {
            izq = contarNodo(arbol.getLeftChild());
            resolver(arbol.getLeftChild(),lista);
        }
        if (arbol.hasRightChild()) {
            der = contarNodo(arbol.getRightChild());
            resolver(arbol.getRightChild(),lista);
        }
        
        if (izq == der) {
            lista.add(arbol.getData());
        }
    }
    
    
    private static Integer contarNodo(BinaryTree<Integer> arbol) {
        int suma = 1;
        if (arbol.hasLeftChild()) {
            suma+=contarNodo(arbol.getLeftChild());
        }
        if(arbol.hasRightChild()) {
            suma+=contarNodo(arbol.getRightChild());
        }
        
        return suma;
    }
}
