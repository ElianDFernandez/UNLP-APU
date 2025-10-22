/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial7;

import generales.GeneralTree;
import generales.Queue;

/**
 *
 * @author Elian
 */
public class parcial7 {
    public static boolean resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return false;
        
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        int nodosNivelAnterior = 0;
        
        while(!cola.isEmpty()) {
            int nodosNivelActual = cola.size();
            if (nodosNivelAnterior+1 != nodosNivelActual) {
                return false;
            } 
            nodosNivelAnterior = nodosNivelActual;
            for (int i=1; i<nodosNivelActual; i++) {
                GeneralTree<Integer> nodo = cola.dequeue();
                for(GeneralTree<Integer> hijo : nodo.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
        }
        
        return true;
    }
}
