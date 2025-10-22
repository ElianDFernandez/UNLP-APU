/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2;

import generales.BinaryTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class parcial2 {
    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        if(arbol == null || arbol.isEmpty()) return null;
        List<Integer> lista = new LinkedList<>();
        
        resolver(arbol,lista);
        
        return lista;
    }
    
    private void resolver(BinaryTree<Integer> arbol, List<Integer> lista) {
        int izq = 0;
        int der = 0;
        
        if (arbol.hasLeftChild()) {
            izq = contarNodos(arbol.getLeftChild());
            resolver(arbol.getLeftChild(), lista);
        }
        if(arbol.hasRightChild()) {
            der = contarNodos(arbol.getRightChild());
            resolver(arbol.getRightChild(),lista);
        }
        
        if (izq == der) {
            lista.add(arbol.getData());
        }
    }
    
    private int contarNodos(BinaryTree<Integer> arbol) {
        int suma = 1; // Nodo actual
        if(arbol.hasLeftChild()) {
            suma+=contarNodos(arbol.getLeftChild()); // Nodo izq
        }
        if(arbol.hasRightChild()) {
            suma+=contarNodos(arbol.getRightChild()); // Nodo der
        }
        
        return suma;
    }
    
    public static void main(String[] args) {
        // --- Creación del árbol ---
        // Hojas
        BinaryTree<Integer> n4 = new BinaryTree<>(4);
        BinaryTree<Integer> n12 = new BinaryTree<>(12);
        BinaryTree<Integer> n25 = new BinaryTree<>(25);
        BinaryTree<Integer> n70 = new BinaryTree<>(70);

        // Nodos intermedios
        BinaryTree<Integer> n8 = new BinaryTree<>(8);
        n8.addLeftChild(n4);
        n8.addRightChild(n12); // izq=1, der=1 -> cumple

        BinaryTree<Integer> n22 = new BinaryTree<>(22);
        n22.addLeftChild(n25);
        n22.addRightChild(n70); // izq=1, der=1 -> cumple

        // Raíz
        BinaryTree<Integer> arbol = new BinaryTree<>(20);
        arbol.addLeftChild(n8);
        arbol.addRightChild(n22); // sub-izq=3, sub-der=3 -> cumple

        // --- Prueba ---
        parcial2 p = new parcial2();
        List<Integer> resultado = p.resolver(arbol); // Puedes probar con cualquiera de las dos versiones

        System.out.println("Nodos con subárboles de igual tamaño: " + resultado);
        // La salida será en post-orden: [4, 12, 8, 25, 70, 22, 20]
    }
}
