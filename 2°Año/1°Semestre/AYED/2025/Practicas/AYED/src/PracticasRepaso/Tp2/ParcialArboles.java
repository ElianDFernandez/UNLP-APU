package PracticasRepaso.Tp2;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    /*
    Ejercicio 7
    Escribir en una clase ParcialArboles que contenga UNA ÚNICA variable de instancia de tipo
    BinaryTree de valores enteros NO repetidos y el método público con la siguiente firma:
    public boolean isLeftTree (int num)
    El método devuelve true si el subárbol cuya raíz es “num”, tiene en su subárbol izquierdo una
    cantidad mayor estricta de árboles con un único hijo que en su subárbol derecho. Y false en caso
    contrario. Consideraciones:
    ● Si “num” no se encuentra en el árbol, devuelve false.
    ● Si el árbol con raíz “num” no cuenta con una de sus ramas, considere que en esa rama hay -1 árboles con único hijo.
    */
    
    public boolean isLeftTree(int num) {
        BinaryTree<Integer> aux = buscarNodo(this.arbol, num);
        if (aux == null) return false;
        int hijosUnicosIzq = 0;
        int hijosUnicosDer = 0;
        if (aux.hasLeftChild()) {
            hijosUnicosIzq = contarHijosUnicos(aux.getLeftChild());
            if (hijosUnicosIzq == 0) hijosUnicosIzq = -1;
        }
        if (aux.hasRightChild()) {
            hijosUnicosDer = contarHijosUnicos(aux.getRightChild());
            if (hijosUnicosDer == 0) hijosUnicosDer = -1;
        }
        
        return hijosUnicosIzq > hijosUnicosDer;
    }
    
    private BinaryTree<Integer> buscarNodo(BinaryTree<Integer> arbol, int num) {
        if (arbol == null) return null;
        if (arbol.getData() == num) return arbol;
        BinaryTree<Integer> izq = buscarNodo(arbol.getLeftChild(), num);
        if (izq!=null) return izq;
        
        return buscarNodo(arbol.getRightChild(), num);
    }

    private int contarHijosUnicos(BinaryTree<Integer> arbol) {
        if(arbol.isLeaf()) return 0;

        int suma = 0;
        
        if (arbol.hasLeftChild() && !arbol.hasRightChild() || arbol.hasRightChild() && !arbol.hasLeftChild()) suma = 1; 
       
        if (arbol.hasLeftChild()) {
            suma += contarHijosUnicos(arbol.getLeftChild());
        } 
        if (arbol.hasRightChild()) {
            suma += contarHijosUnicos(arbol.getRightChild());
        }
        
        return suma;
    }
    
    /*
    Ejercicio 8
    Escribir en una clase ParcialArboles el método público con la siguiente firma:
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2)
    El método devuelve true si arbol1 es prefijo de arbol2, false en caso contrario.
    Se dice que un árbol binario arbol1 es prefijo de otro árbol binario arbol2, cuando arbol1 coincide
    con la parte inicial del árbol arbol2 tanto en el contenido de los elementos como en su
    estructura.
    */
    
    
}
