/*
Dado un árbol binario T de altura h,
diremos que T es lleno si cada nodo interno tiene grado 2
y todas las hojas están en el mismo nivel (h). 

Ejemplo de Árbol Binario Lleno:
        1
       / \
      2   3
     / \  / \
    4   5 6  7
✅ Cada nodo tiene exactamente 0 o 2 hijos.
✅ No hay nodos con un solo hijo.

Ejemplo de Árbol que NO es lleno:
        1
       / 
      2   
     / \
    4   5  
❌ El nodo 1 solo tiene un hijo (2).
❌ El nodo 2 tiene dos hijos, lo cual está bien, pero 1 rompe la regla.


a) Eestrategia recorrido en profundidad.
 */
package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

public class RedBinariaLlena {
    public static int retardoReenvio(BinaryTree<Integer> arbol) {
        return enProfundidad(arbol, 0);
    }
    
    private static int enProfundidad(BinaryTree<Integer> nodo, int sumaActual) {
        if (nodo == null) return sumaActual;
        sumaActual += nodo.getData();

        if (!nodo.hasLeftChild() && !nodo.hasRightChild()) {
            return sumaActual;
        }

        int izq = nodo.hasLeftChild() ? enProfundidad(nodo.getLeftChild(), sumaActual) : Integer.MIN_VALUE;
        int der = nodo.hasRightChild() ? enProfundidad(nodo.getRightChild(), sumaActual) : Integer.MIN_VALUE;

        return Math.max(izq, der);
    }
}
