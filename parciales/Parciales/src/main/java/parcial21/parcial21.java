/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial21;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class parcial21 {
    private GeneralTree<Integer> arbol;
    
    public List<Integer> camino (int num) {
        List<Integer> lista = new LinkedList<>();
        if (this.arbol == null || arbol.isEmpty()) return lista;
        
        caminoR(this.arbol, lista, num);
        
        return lista;
    }
    
    private boolean caminoR(GeneralTree<Integer> arbol, List<Integer> lista, int num) {
        lista.add(arbol.getData());
        if (arbol.isLeaf()){
            return true;
        } 
        if (arbol.getChildren().size() >= num) {
            for(GeneralTree<Integer> hijo : arbol.getChildren()) {
                if (caminoR(hijo, lista, num)) {
                    return true;
                }
            }
        }
        
        lista.remove(lista.size()-1);
        return false;
    }
}
