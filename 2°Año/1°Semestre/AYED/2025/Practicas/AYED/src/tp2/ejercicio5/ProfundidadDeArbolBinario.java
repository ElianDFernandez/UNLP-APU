package tp2.ejercicio5;

import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

// Recorrido por niveles. 

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario() {
        arbol = new BinaryTree<Integer>();
    }

    
    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public int sumaElementosProfundidad(int p) {
        if (this.arbol == null) return 0;
        
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        cola.enqueue(this.arbol);
        int nivelActual = 0;
        
        while(!cola.isEmpty()) {
            int nodosEnNivel = cola.size();
            int sumaNivel = 0;
            
            for (int i = 0; i < nodosEnNivel; i++) {
                BinaryTree<Integer> nodo = cola.dequeue();

                if (nivelActual == p) {
                    sumaNivel += nodo.getData();
                }

                if (nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
                if (nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
            }
            
            if (nivelActual == p) {
                return sumaNivel; 
            }
                nivelActual++;
            }
        return 0;
    }
}
