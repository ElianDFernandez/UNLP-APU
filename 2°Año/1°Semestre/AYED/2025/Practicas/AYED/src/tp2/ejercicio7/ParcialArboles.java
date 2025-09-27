package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public boolean isLeftTree(int num) {
        BinaryTree<Integer> nodo = buscarNodo(this.arbol,num);
        if (nodo == null) return false;
        
        BinaryTree<Integer> ramaIzq = nodo.getLeftChild();
        BinaryTree<Integer> ramaDer = nodo.getRightChild();
        
        int cantIzq = (ramaIzq != null) ? this.contarUnicoHijo(ramaIzq) : -1;
        int cantDer = (ramaDer != null) ? contarUnicoHijo(ramaDer) : -1;
        
        return cantIzq > cantDer;
    }
    
    private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> nodo, int num) {
        if (nodo == null) return null;
        if (nodo.getData() == num) return nodo;

        BinaryTree<Integer> izq = buscarNodo(nodo.getLeftChild(), num);
        if (izq != null) return izq;
        return buscarNodo(nodo.getRightChild(), num);
    }
    
    private int contarUnicoHijo(BinaryTree<Integer> nodo) {
        if (nodo == null) return 0;
        int cuenta = 0;
        if ((nodo.hasLeftChild() && !nodo.hasRightChild()) || (!nodo.hasLeftChild() && nodo.hasRightChild())) {
            cuenta = 1;
        }
        cuenta += contarUnicoHijo(nodo.getLeftChild());
        cuenta += contarUnicoHijo(nodo.getRightChild());

        return cuenta;
    }
}
