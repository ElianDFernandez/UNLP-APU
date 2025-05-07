/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticasRepaso.Tp2;

/**
 *
 * @author Elian
 */
public class Transformacion {
    private BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public BinaryTree<Integer> suma(){
        if (arbol == null || arbol.isEmpty()) return null;
        return sumaRecursivo(arbol);
    }
    
    private BinaryTree<Integer> sumaRecursivo(BinaryTree<Integer> arbol) {
        if (arbol.isLeaf()) {
            return new BinaryTree<>(0);
        }

        int sumaSubarboles = sumarSubarbol(arbol.getLeftChild()) + sumarSubarbol(arbol.getRightChild());

        BinaryTree<Integer> nuevoNodo = new BinaryTree<>(sumaSubarboles);

        if (arbol.hasLeftChild()) {
            nuevoNodo.addLeftChild(sumaRecursivo(arbol.getLeftChild()));
        }

        if (arbol.hasRightChild()) {
            nuevoNodo.addRightChild(sumaRecursivo(arbol.getRightChild()));
        }

        return nuevoNodo;
    }
    
    private int sumarSubarbol(BinaryTree<Integer> nodo) {
        if (nodo == null || nodo.isEmpty()) return 0;

        int suma = nodo.getData();
        suma += sumarSubarbol(nodo.getLeftChild());
        suma += sumarSubarbol(nodo.getRightChild());
        return suma;
    }
}
