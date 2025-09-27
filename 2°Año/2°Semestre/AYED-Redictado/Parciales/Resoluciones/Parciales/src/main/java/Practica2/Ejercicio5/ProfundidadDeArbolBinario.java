package Practica2.Ejercicio5;

import ClasesUtiles.BinaryTree;
import ClasesUtiles.Queue;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;
    
    public int sumaElementosProfundidad(int p) {
        if (this.arbol == null) return 0;
        
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        int nivelActual = 0;
        cola.enqueue(arbol);
        boolean llegueAnivel = false;
        int sum = 0;

        while (!cola.isEmpty() && llegueAnivel) {
            sum = 0;
            int cantNodosNivel = cola.size();
            
            for(int i =0; i<cantNodosNivel; i++) {
                BinaryTree<Integer> aux = cola.dequeue();
                if (nivelActual == p) {
                    sum+=arbol.getData();
                }
                if (arbol.hasLeftChild()) cola.enqueue(aux.getLeftChild());
                if (arbol.hasRightChild()) cola.enqueue(aux.getRightChild());
            }
            
            if (nivelActual == p) {
                llegueAnivel = true;
            }
            nivelActual ++;
        } 
        
        return sum;
    }
}
