/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial11;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class parcial11 {
    public List<Compuesto> mejorEstrategia(GeneralTree<Compuesto> arbol) {
        // Retornar menor 
        if (arbol == null || arbol.isEmpty()) return null;
        List<Compuesto> caminoAct = new LinkedList<>();
        List<Compuesto> caminoRes = new LinkedList<>();
        mejorEstrategiaR(arbol,caminoAct,caminoRes, 0, Integer.MAX_VALUE, 0);
        
        return caminoRes;
    }
    
    private void mejorEstrategiaR(GeneralTree<Compuesto> arbol, List<Compuesto> caminoAct, List<Compuesto> caminoRes,int tiempoAct, int menorTiempo, int aristas) {
        caminoAct.add(arbol.getData());
        tiempoAct += aristas*10 + arbol.getData().getCompuesto()*arbol.getData().getVueltas();
        if (arbol.isLeaf()) {
            if(tiempoAct < menorTiempo) {
                caminoRes.clear();
                caminoRes.addAll(caminoAct);
            }
        } else {
            for(GeneralTree<Compuesto> hijo : arbol.getChildren()) {
                mejorEstrategiaR(hijo,caminoAct,caminoRes,tiempoAct,menorTiempo,aristas+1);
            }
        } 
        caminoAct.remove(caminoAct.size()-1);
    }
}
