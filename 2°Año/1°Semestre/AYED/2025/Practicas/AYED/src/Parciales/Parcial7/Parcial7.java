package Parciales.Parcial7;

import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;

public class Parcial7 {
    public static List<GeneralTree<Integer>> resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;
        
        List<GeneralTree<Integer>> lista = new LinkedList<>();
        
        resolver(arbol,lista);
        
        return lista;
    } 
    
    private static void resolver(GeneralTree<Integer> arbol, List<GeneralTree<Integer>> lista) {
        List<GeneralTree<Integer>> hijos = arbol.getChildren();
        int cantidad = hijos.size();
        if (cantidad > 0) {
           resolver(hijos.get(0), lista);
        }
        
        if (cantidad == 2) {
            lista.add(arbol);
        }
        
        for (int i=1; i<cantidad; i++) {
            resolver(hijos.get(i),lista);
        }
    }
}
