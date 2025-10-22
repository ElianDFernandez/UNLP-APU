/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial10;

import generales.GeneralTree;
import java.util.Iterator;

/**
 *
 * @author Elian
 */
public class parcial10 {
    public boolean esSustituto(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2) {
        boolean esSustituto = true;
        
        if(arbol1.getData() % 2 != 0 && arbol1.getData() < arbol2.getData()) {
            return false;
        }
        
        if (arbol1.isLeaf() && arbol2.isLeaf()) {
            return true;
        }
        
        if (arbol1.isLeaf() && !arbol2.isLeaf()) {
            return true;
        }
        if (!arbol1.isLeaf() && arbol2.isLeaf()) {
            return false;
        }
        
        if(contarHijos(arbol1) < contarHijos(arbol2)) {
            return false;
        }
        
        Iterator<GeneralTree<Integer>> it1 = arbol1.getChildren().iterator();
        Iterator<GeneralTree<Integer>> it2 = arbol2.getChildren().iterator();
        while (esSustituto && it1.hasNext() && it2.hasNext()) {
            esSustituto = esSustituto(it1.next(),it2.next());
        }

        return esSustituto;
    }
    
    private int contarHijos(GeneralTree<Integer> arbol) {
        int cont = 0;
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
           if (hijo.getData() % 2 == 0) {
               cont ++;
           }
        }
        
        return cont;
    }
}
