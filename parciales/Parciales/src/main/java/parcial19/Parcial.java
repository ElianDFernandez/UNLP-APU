/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial19;

import generales.GeneralTree;
import generales.Queue;


/**
 *
 * @author Elian
 */
public class Parcial {
    public int resolver(GeneralTree<Integer> arb) {
        int suma = 0; // (Debería llamarse 'producto', pero la lógica funciona)
        if(!arb.isEmpty()) {
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
            cola.enqueue(arb);
            while(!cola.isEmpty()) {
                int act = cola.size();
                suma = 1; // Se reinicia en cada nivel
                for(int i = 0; i < act; i++) {
                    GeneralTree<Integer> aux = cola.dequeue();
                    if(aux.isLeaf()) {
                        suma *= aux.getData();
                    } else {
                        for(GeneralTree<Integer> h: aux.getChildren()) {
                            cola.enqueue(h);
                        }
                    }
                }
            }
        }
        return suma;
    }
}
