/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticasRepaso.Tp2;

/**
 *
 * @author Elian
 */
public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public int sumaElementosProfundidad(int p) {
        if (arbol.isEmpty()) return 0;
        return sumaElementosProfundidadRecursivo(this.arbol, 0, p); 
    }
    
    private int sumaElementosProfundidadRecursivo(BinaryTree<Integer> arbol, int profundidad, int profundidadObjetivo) {
        if (arbol == null) return 0;
        
        if (profundidad == profundidadObjetivo) {
            return arbol.getData();
        }
        
        int suma = 0;
        if (arbol.hasLeftChild()) {
            suma += sumaElementosProfundidadRecursivo(arbol.getLeftChild(),profundidad + 1, profundidadObjetivo);
        }
        if (arbol.hasRightChild()) {
            suma += sumaElementosProfundidadRecursivo(arbol.getRightChild(),profundidad + 1, profundidadObjetivo);
        }
        
        return suma;
    }
}
