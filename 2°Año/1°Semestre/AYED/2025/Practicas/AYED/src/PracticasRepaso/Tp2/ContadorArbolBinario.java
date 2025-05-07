package PracticasRepaso.Tp2;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbolBinario {
    private BinaryTree<Integer> arbol;

    public ContadorArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> numeroPares(){
        List<Integer> lista = new ArrayList<>();
        if (arbol.isEmpty()) return lista;
        numeroPares(arbol, lista);
        return lista;
    }
    
    private void numeroPares(BinaryTree<Integer> arbol, List<Integer> lista) {
        if (arbol.hasLeftChild()) {
            this.numeroPares(arbol.getLeftChild(),lista);
        } 
        if (arbol.getData() % 2 == 0) {
            lista.add(arbol.getData());
        }
        if (arbol.hasRightChild()) {
            this.numeroPares(arbol.getRightChild(),lista);
        }
    }
    
    public static void main(String[]args) {
        BinaryTree<Integer> raiz = new BinaryTree<>(10);
        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        BinaryTree<Integer> nodo7 = new BinaryTree<>(7);
        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
        
        raiz.addLeftChild(nodo2);
        raiz.addRightChild(nodo3);
        
        nodo2.addLeftChild(nodo5);
        nodo2.addRightChild(nodo4);
        nodo3.addLeftChild(nodo9);
        nodo3.addRightChild(nodo8);
        
        nodo5.addLeftChild(nodo7);
        nodo4.addRightChild(nodo6);
        /* ARBOL BINARIO
                 10
             2        3
           5   4    9   8
          7     6
        */
        
        ContadorArbolBinario contador = new ContadorArbolBinario(raiz);
        
        System.out.println("Contador: " + contador.numeroPares());
        
        RedBinariaLlena redBinariaLlena = new RedBinariaLlena(raiz);
        
        System.out.println("Red binaria llena: " + redBinariaLlena.retardoReenvio());
        
        ProfundidadDeArbolBinario profundidad = new ProfundidadDeArbolBinario(raiz);
        
        System.out.println("Profundidad: " + profundidad.sumaElementosProfundidad(2));
    }
}
