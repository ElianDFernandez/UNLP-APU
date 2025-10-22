/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial13;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class caminoHojaMasLejana {
    public List<Integer> caminoHojaMasLejana(GeneralTree<Integer> arbol) {
        List<Integer> camino = new LinkedList<>();
        if (arbol == null || arbol.isEmpty()) return camino;
        List<Integer> caminoAct = new LinkedList<>();
        caminoHojaMasLejanaR(arbol,caminoAct,camino);
        
        return camino;
    }
    
    private void caminoHojaMasLejanaR(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> camino) {
        caminoAct.add(arbol.getData());
        if(arbol.isLeaf()) {
            if(caminoAct.size() > camino.size()) {
                camino.clear();
                camino.addAll(caminoAct);
            }
        }
        
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            caminoHojaMasLejanaR(hijo,caminoAct, camino);
        }
        
        caminoAct.remove(caminoAct.size()-1);
    }
}
