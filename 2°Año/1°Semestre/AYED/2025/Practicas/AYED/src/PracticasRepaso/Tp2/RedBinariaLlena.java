/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticasRepaso.Tp2;

/**
 *
 * @author Elian
 */
public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        // Suma del mayor camino 
        if (arbol.isEmpty()) return 0;
        return enProfundidad(this.arbol, 0);
    }
    
    private static int enProfundidad(BinaryTree<Integer> arbol, int sumaActual) {
        if (arbol == null) return sumaActual;
        sumaActual += arbol.getData();

        if (arbol.isLeaf()) {
            return sumaActual;
        }
        
        int izq = Integer.MIN_VALUE;
        if (arbol.hasLeftChild()) {
            izq = enProfundidad(arbol.getLeftChild(), sumaActual);
        }

        int der = Integer.MIN_VALUE;
        if (arbol.hasRightChild()) {
            der = enProfundidad(arbol.getRightChild(), sumaActual);
        }

        return Math.max(izq, der);
    }
}
