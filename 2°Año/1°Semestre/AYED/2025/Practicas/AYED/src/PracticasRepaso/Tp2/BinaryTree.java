/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticasRepaso.Tp2;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

/**
 *
 * @author Elian
 */
public class BinaryTree <T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
    }

    public BinaryTree(T dato) {
        this.data = dato;
    }

    public T getData() {
        return data;
    }

    public void setDato(T dato) {
        this.data = dato;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public void addLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public void addRightChild(BinaryTree<T> rigtChild) {
        this.rightChild = rigtChild;
    }
    
    public void removeLeftChild(){
        this.leftChild = null;
    }
    
    public void removeRightChild(){
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());
    }
    
    public boolean hasLeftChild() {
        return this.leftChild != null;
    }
    
    public boolean hasRightChild() {
        return this.rightChild != null;
    }
    
    @Override
    public String toString() {
        return "";
    }
    
    public int contarHojas() {
        if (this.isEmpty()) return 0;
        return contarHojas(this);
    }

    private int contarHojas(BinaryTree<T> arbol) {
        // Salida recursividad
        if (arbol.isLeaf()) return 1;
        
        // Recursividad
        int suma = 0;
        
        if(arbol.hasLeftChild()) {
            suma += contarHojas(arbol.getLeftChild());
        }
        if(arbol.hasRightChild()) {
            suma += contarHojas(arbol.getRightChild());
        }
        
        return suma;
    }
    
    public BinaryTree<T> espejo(){
        if (this.isEmpty()) {
            return null;
        } 
        return espejoRecursivo(this);
    }
    
    private BinaryTree<T> espejoRecursivo(BinaryTree<T> arbol) {
        // Salida recursividad
        if (arbol.isEmpty()) return null;
        
        // Recursividad
        BinaryTree<T> nodo = new BinaryTree<>(arbol.getData());
        nodo.addLeftChild(espejoRecursivo(arbol.getRightChild().espejo()));
        nodo.addRightChild(espejoRecursivo(arbol.getLeftChild().espejo()));
        
        return nodo;
    }
    
    public List<T> entreNiveles(int n, int m) {
        Queue<BinaryTree<T>> cola = new Queue<>(); 
        cola.enqueue(this);
        
        int nivelActual = 0;
        List<T> lista = new LinkedList<>();
        
        while (!cola.isEmpty()) {
            if (nivelActual > m) break;
            
            int nodos = cola.size();
            for (int i = 0; i < nodos; i++) {
                BinaryTree<T> aux = cola.dequeue();
                
                if (nivelActual >= n && nivelActual <= m) {
                    lista.add(aux.getData());
                }

                if (aux.hasLeftChild()) cola.enqueue(aux.getLeftChild());
                if (aux.hasRightChild()) cola.enqueue(aux.getRightChild());
            }
            nivelActual++;
        }
        
        return lista;
    }
    
    
    
}
