package parcial3;

import generales.GeneralTree;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Elian
 */
public class parcal3 {
    
    public int mayor(GeneralTree<Integer> arbol) {
        if(arbol == null || arbol.isEmpty()) return 0;
        return mayorRecursivo(arbol);
    }
    
    private int mayorRecursivo(GeneralTree<Integer> arbol) {
        int maxActual = arbol.getData();
        
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            int maxHijo = mayorRecursivo(hijo);
            if (maxHijo > maxActual) {
                maxActual = maxHijo;
            }
        }
        
        return maxActual;
    }
    
    public static void main(String[] args) {
        // --- Creación del árbol ---
        GeneralTree<Integer> n4 = new GeneralTree<>(4);
        GeneralTree<Integer> n2 = new GeneralTree<>(2);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);
        GeneralTree<Integer> n1 = new GeneralTree<>(1);
        GeneralTree<Integer> n9 = new GeneralTree<>(9);
        GeneralTree<Integer> n10 = new GeneralTree<>(10); // El valor más alto

        GeneralTree<Integer> n7 = new GeneralTree<>(7);
        n7.addChild(n2);

        GeneralTree<Integer> n3 = new GeneralTree<>(3);
        n3.addChild(n4);
        n3.addChild(n7);
        n3.addChild(n6);

        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        n5.addChild(n1);
        n5.addChild(n9);
        n5.addChild(n10);

        GeneralTree<Integer> arbol = new GeneralTree<>(8);
        arbol.addChild(n3);
        arbol.addChild(n5);

        // --- Prueba ---
        parcal3 p3 = new parcal3();
        int resultado = p3.mayor(arbol);

        System.out.println("El mayor valor en el árbol es: " + resultado);
        // Salida esperada: El mayor valor en el árbol es: 10
    }
}
