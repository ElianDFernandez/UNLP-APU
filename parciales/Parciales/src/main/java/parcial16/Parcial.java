/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial16;

import generales.GeneralTree;

/**
 *
 * @author Elian
 */
public class Parcial {
    private int positivos;
    private int negativos;
    private int total;
    
    public Integer resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return 0;
        sumar(arbol);
        
        if (total % 2 == 0) {
            return positivos;
        } 
        return negativos;
    }
    
    private void sumar(GeneralTree<Integer> arbol) {
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            sumar(hijo);
        }
        if (arbol.getData() % 2 == 0) {
            this.positivos += arbol.getData();
        } else {
            this.negativos += arbol.getData();
        }
        this.total += arbol.getData();
    }
}
