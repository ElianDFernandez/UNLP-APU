package tp3;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree <T>{
    private T data;
    private List<GeneralTree<T>> children;

    public GeneralTree(T data) {
        this.data = data;
        this.children = new LinkedList<>();
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this.data = data;
        this.children = children;
    }
    
    public T getData(){
        return this.data;
    }
    
    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }
    
    public void addChild(GeneralTree<T> child){
        children.add(child);
    }
    
    public void removeChild(GeneralTree<T> child){
        children.remove(child);
    }
    
    public boolean hasChild(){
        return !children.isEmpty();
    }
    
    public boolean isEmpty(){
        return this.data == null && this.children.isEmpty();
    }
    
    public boolean isLeaf(){
        return !this.hasChild();
    }
    
    public int altura() {
        if (this.children == null || this.children.isEmpty()) {
            return 0;
        }

        int maxAltura = 0;
        for (GeneralTree<T> child : children) {
            maxAltura = Math.max(maxAltura, child.altura());
        }

        return 1 + maxAltura;
    }
    
    public int nivel(T dato) {
        if (this.data.equals(dato)) {
            return 0;
        }

        if (this.children != null) {
            for (GeneralTree<T> child : children) {
                int nivelHijo = child.nivel(dato);
                if (nivelHijo != -1) {
                    return 1 + nivelHijo;
                }
            }
        }

        return -1;
    }
    
    public int ancho() {
        if (this.isEmpty()) {
            return 0;
        }
        int cantMax = 0;
        int cantActual = 0;
        GeneralTree<T> ab;
        Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        while(!cola.isEmpty()) {
            ab = cola.dequeue();
            if(ab!= null) {
                List<GeneralTree<T>> children = ab.getChildren();
                for(GeneralTree<T> child: children) {
                    cola.enqueue(child);
                    cantActual++;
                }
            } else if (!cola.isEmpty()){
                cantMax = Math.max(cantMax, cantActual);
                cantActual = 0;
                cola.enqueue(null);
            }
        }
        
        return cantMax;
    }
    
    public boolean esAncestro(T a, T b) {
        GeneralTree<T> nodoA = buscarNodo(this, a);
        if (nodoA == null) {
            return false;
        }
        return contiene(nodoA, b);
    }

    private GeneralTree<T> buscarNodo(GeneralTree<T> actual, T valor) {
        if (actual.getData().equals(valor)) {
            return actual;
        }

        if (actual.getChildren() != null) {
            for (GeneralTree<T> child : actual.getChildren()) {
                GeneralTree<T> resultado = buscarNodo(child, valor);
                if (resultado != null) {
                    return resultado;
                }
            }
        }

        return null;
    }

    private boolean contiene(GeneralTree<T> arbol, T valor) {
        if (arbol.getData().equals(valor)) {
            return true;
        }

        if (arbol.getChildren() != null) {
            for (GeneralTree<T> child : arbol.getChildren()) {
                if (contiene(child, valor)) {
                    return true;
                }
            }
        }

        return false;
    }
}
