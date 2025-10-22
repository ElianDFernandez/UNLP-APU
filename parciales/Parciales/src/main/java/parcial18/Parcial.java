/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial18;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Parcial {
    public List<GeneralTree<Integer>> resolver (GeneralTree<Integer> arbol) {
        List<GeneralTree<Integer>> lista = new LinkedList<>();
        if (arbol == null || arbol.isEmpty()) return lista;
        
        resolverR(arbol,lista);
        return lista;
    }
    
    private void resolverR(GeneralTree<Integer> arbol, List<GeneralTree<Integer>> lista) {
        if (arbol.getChildren().size() > 0) {
            resolverR(arbol.getChildren().get(0), lista);
            if (arbol.getChildren().size() % 2 == 0) {
                lista.add(arbol);
            }
        }
        for(int i = 1; i < arbol.getChildren().size(); i++) {
            resolverR(arbol.getChildren().get(i),lista);
        }
    }
}
