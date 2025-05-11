package Parciales.Parcial11;

import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

public class Parcial11 {
    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return false;
        
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue( arbol );
        int nodosNivelAnt = 0;
        
        while(!cola.isEmpty()) {
            int nodosNivelAct = cola.size();
            if(nodosNivelAct != nodosNivelAnt+1){
                return false;
            }
            
            nodosNivelAnt = nodosNivelAct;
            
            for (int i=1; i<nodosNivelAct; i++) {
                GeneralTree<Integer> aux = cola.dequeue();
                for(GeneralTree<Integer> hijo : aux.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
        }
        
        return true;
    }
}
