
import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elian
 */
public class PracticasVarias {
    // Metodo camino mas lejano
    
    public static List<Integer> caminoMasLejano(GeneralTree<Integer> arbol) {
        List<Integer> lista = new LinkedList<>();
        if(arbol == null) return lista;
        
        caminoMasLejano(arbol,lista,new LinkedList<Integer>());
        
        return lista;
    }
    
    private static void caminoMasLejano(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> caminoAct) {
        caminoAct.add(arbol.getData());
        if(arbol.isLeaf()) {
            if (caminoAct.size() > resultado.size()) {
                resultado.clear();
                resultado.addAll(caminoAct);
            }
        } else {
            for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                caminoMasLejano(hijo, resultado, caminoAct);
            }
        }
        
        caminoAct.remove(caminoAct.size()-1);
    }
    
    // esSustituto
}
