/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial17;

import generales.GeneralTree;

/**
 *
 * @author Elian
 */
public class Parcial {
    private int nodos;
    private int positivos;
    private int negativos;
    
    public Integer resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return 0;
        sumar(arbol);
        
        if(nodos % 2 == 0) return positivos;
        
        return negativos;
    }
    
    private void sumar(GeneralTree<Integer> arbol) {
        sumar(arbol.getChildren().get(0));
        if (arbol.getData() > 0) {
            this.positivos += arbol.getData();
        } else {
            this.negativos += arbol.getData();
        }
        nodos ++;
        for(int i=1; i < arbol.getChildren().size(); i++) {
            sumar(arbol.getChildren().get(i));
        }
    }
}
