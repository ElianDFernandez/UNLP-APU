/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial20;

import generales.GeneralTree;
import generales.Queue;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Parcial {
    private GeneralTree<Integer> arbol;
    
    
    public List<Integer> nivel(int num) {
        List<Integer> lista = new LinkedList<>();
        if (this.arbol == null || arbol.isEmpty()) return lista;
        
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(this.arbol);
        boolean ok = false;
        while (!cola.isEmpty() && !ok) {
            int nodosNivelActual = cola.size();
            
            for(int i=0; i < nodosNivelActual; i++) {
                GeneralTree<Integer> aux = cola.dequeue();
                if(aux.getChildren().size() == num) {
                    lista.add(aux.getData());
                }
                for(GeneralTree<Integer> hijo : aux.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
            
            if (lista.size() == nodosNivelActual) {
                ok = true;
            } else {
                lista.clear();
            }
        }
        
        return lista;
    }
}
