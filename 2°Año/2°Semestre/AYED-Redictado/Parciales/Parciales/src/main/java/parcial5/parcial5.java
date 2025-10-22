/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial5;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class parcial5 {
    public List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol) {
        List<GeneralTree<Integer>> lista = new LinkedList<>();
        if (arbol == null || arbol.isEmpty()) return lista;
        resolver(arbol,lista);
        
        return lista;
    }
    
    private void resolver(GeneralTree<Integer> arbol, List<GeneralTree<Integer>> lista) {
        List<GeneralTree<Integer>> hijos = arbol.getChildren();
        if (hijos.size() > 0) {
            resolver(hijos.get(0),lista);
        }
        if(!arbol.isLeaf() && hijos.size() % 2 == 0) {
            lista.add(arbol);
        }
        for(int i=1; i<hijos.size(); i++) {
            resolver(hijos.get(i), lista);
        }
    }
}
