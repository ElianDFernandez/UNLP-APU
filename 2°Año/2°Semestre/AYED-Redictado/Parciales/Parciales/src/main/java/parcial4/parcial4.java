/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial4;

import generales.GeneralTree;

/**
 *
 * @author Elian
 */
public class parcial4 {
    private int resta;
    private int suma;
    private int total;
    
    public Integer resolver(GeneralTree<Integer> arbol) {
        this.suma = 0;
        this.resta = 0;
        this.total = 0;
        
        if (arbol == null || arbol.isEmpty()) return null;
        resolverRecursivo(arbol);
        
        if (total % 2 == 0) {
            return suma;
        } else {
            return resta;
        }
    } 
    
    private void resolverRecursivo(GeneralTree<Integer> arbol) {
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            resolverRecursivo(hijo);
        }
        
        if(arbol.getData() > 0) {
            suma+= arbol.getData();
        } else {
            resta += arbol.getData();
        }
        total+=arbol.getData();
    }
    
    public static void main(String[] args) {
        // --- Árbol de Prueba 1 ---
        // Total = 20 (par), Suma positivos = 25, Suma no-positivos = -5
        // Debería devolver 25.
        GeneralTree<Integer> arbol1 = new GeneralTree<>(10);
        arbol1.addChild(new GeneralTree<>(15));
        arbol1.addChild(new GeneralTree<>(-5));

        // --- Árbol de Prueba 2 ---
        // Total = 9 (impar), Suma positivos = 11, Suma no-positivos = -2
        // Debería devolver -2.
        GeneralTree<Integer> arbol2 = new GeneralTree<>(4);
        arbol2.addChild(new GeneralTree<>(7));
        arbol2.addChild(new GeneralTree<>(-2));

        // --- Ejecución ---
        parcial4 p4 = new parcial4();

        System.out.println("--- Primera llamada ---");
        Integer resultado1 = p4.resolver(arbol1);
        System.out.println("Resultado para Árbol 1: " + resultado1); // Correcto: 25
        System.out.println("--- Segunda llamada ---");
        Integer resultado2 = p4.resolver(arbol2);
        System.out.println("Resultado para Árbol 2: " + resultado2); // Correcto: -2
    }
}
