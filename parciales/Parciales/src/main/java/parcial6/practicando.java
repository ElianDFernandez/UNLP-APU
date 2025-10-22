/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial6;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class practicando {
    private GeneralTree<Integer> arbol;
    
    public List<Integer> camino (int num) {
        List<Integer> camino = new LinkedList<>();
        
        if (this.arbol == null || arbol.isEmpty()) return camino;
        caminoR(this.arbol,camino, num);
        
        return camino;
    }
    
    private boolean caminoR(GeneralTree<Integer> arbol, List<Integer> camino, int num) {
        camino.add(arbol.getData());
        if(arbol.isLeaf()) return true;
        if (arbol.getChildren().size() == num) {
            for(GeneralTree<Integer> hijo : arbol.getChildren()) {
                if (caminoR(hijo,camino,num)) {
                    return true;
                }
            }
        }
        
        camino.remove(camino.size()-1);
        return false;
    } 
}
