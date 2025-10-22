/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial15;

import generales.GeneralTree;

/**
 *
 * @author Elian
 */
public class Recorrido {
    public int maxPostOrden(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return 0;
        
        return maxPostOrdenR(arbol,0);
    }
    
    private int maxPostOrdenR(GeneralTree<Integer> arbol, int max) {
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            max = maxPostOrdenR(hijo,max);
        }
        
        if(arbol.getData() > max) {
            max = arbol.getData();
        }
        
        return max;
    }
}
