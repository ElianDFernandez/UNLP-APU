package Practica2.Ejercicio3;

import ClasesUtiles.BinaryTree;
import java.util.LinkedList;
import java.util.List;

public class ContadorArbol {
    private BinaryTree<Integer> arbol; 
    
    public List<Integer> numerosPares() {
        if (this.arbol == null) return null;
        LinkedList<Integer> pares = new LinkedList<>();
        
        numerosParesInOrden(this.arbol,pares) ;
        System.out.println("Recorrido InOrden");
        for(Integer par : pares) {
            System.out.println(par);
        }
        
        numerosParesPostOrden(this.arbol, pares);
        System.out.println("Recorrido PostOrden");
        for(Integer par : pares) {
            System.out.println(par);
        }
        
        return pares;
    }
    
    private void numerosParesInOrden(BinaryTree<Integer> arbol, List<Integer> pares) {
        if (arbol.hasLeftChild()) {
            numerosParesInOrden(arbol.getLeftChild(), pares); 
        } 
        if (arbol.getData() % 2 == 0) {
            pares.add(arbol.getData());
        }
        if (arbol.hasRightChild()) {
            numerosParesInOrden(arbol.getRightChild(), pares);
        }
    }
    
    private void numerosParesPostOrden(BinaryTree<Integer> arbol, List<Integer> pares) {
        if (arbol.hasLeftChild()) {
            numerosParesPostOrden(arbol.getLeftChild(), pares);
        }
        if (arbol.hasRightChild()) {
            numerosParesPostOrden(arbol.getRightChild(), pares);
        }
        if (arbol.getData()  % 2 == 0) {
            pares.add(arbol.getData());
        } 
    }
}
