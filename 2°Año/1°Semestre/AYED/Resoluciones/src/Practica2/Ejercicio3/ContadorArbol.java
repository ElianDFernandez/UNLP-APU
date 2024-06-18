package Practica2.Ejercicio3;

import java.util.*;
import Practica2.Ejercicio1y2.BinaryTree;
import Practica1.Ejercicio8.Queue;

/* Ejercicio 3
Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
BinaryTree<Integer>. Implemente en dicha clase un método denominado numerosPares() que
devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
árbol (divisibles por 2).
a) Implemente el método realizando un recorrido InOrden.
b) Implemente el método realizando un recorrido PostOrden. 
*/
public class ContadorArbol {
    private BinaryTree<Integer> a;
    
    public ContadorArbol(BinaryTree<Integer> unArbol) {
        a = unArbol;
    }
    
    // RECORRIDO PRE ORDEN    
    public List<Integer> numeroParesPre() {
        List<Integer> l= new LinkedList<Integer>();
        if (!a.isEmpty()) this.paresPreOrden(l,a);
        return l;
    } 
    
    private void paresPreOrden(List<Integer> l, BinaryTree<Integer> a) {
        if (a.getData()%2==0) l.add(a.getData());
        if (a.hasLeftChild()) paresPreOrden(l, a.getLeftChild());
        if (a.hasRightChild()) paresPreOrden(l,a.getRightChild());
    }
    
    //RECORRIDO POSTORDEN
    public List<Integer> numeroParesPost() {
        List<Integer> l = new LinkedList<Integer>();
        if (!a.isEmpty()) this.paresPostOrden(l,a);
        return l;
    }
    
    private void paresPostOrden(List<Integer> l, BinaryTree<Integer> a) {
        if (a.hasLeftChild()) paresPreOrden(l, a.getLeftChild());
        if (a.hasRightChild()) paresPreOrden(l,a.getRightChild());
        if (a.getData()%2==0) l.add(a.getData());
    }
    
    //RECORRIDO INORDEN
    public List<Integer> numeroPresIn() {
        List<Integer> l= new LinkedList<Integer>();
        if (!a.isEmpty()) this.paresInOrden(l,a);
        return l;
    }
    
    private void paresInOrden(List<Integer> l, BinaryTree<Integer> a) {
        if (a.hasLeftChild()) paresPreOrden(l, a.getLeftChild());
        if (a.getData()%2==0) l.add(a.getData());
        if (a.hasRightChild()) paresPreOrden(l,a.getRightChild());
    }
}
