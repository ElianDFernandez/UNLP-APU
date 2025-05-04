package tp3.ejercicio11;

import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

public class ParcialArboles {
    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return false;
        }
        
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        
        int nivelAnterior = 0;
        
        while (!cola.isEmpty()) {
            int nodosNivel = cola.size(); // cantidad de nodos en el nivel actual

            if (nodosNivel == nivelAnterior + 1) {
                return false;
            }

            nivelAnterior = nodosNivel;

            for (int i = 0; i < nodosNivel; i++) {
                GeneralTree<Integer> actual = cola.dequeue();
                for (GeneralTree<Integer> hijo : actual.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
        }

        return true;
    }
}
