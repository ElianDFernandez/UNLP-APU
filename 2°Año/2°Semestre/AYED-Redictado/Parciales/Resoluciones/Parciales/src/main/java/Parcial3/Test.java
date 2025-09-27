package Parcial3;

import ClasesUtiles.BinaryTree;

public class Test {

    public static void main(String[] args) {
        // Construimos el árbol:
        //         2
        //       /   \
        //      5     6
        //     / \   / 
        //    4  10 6
        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
        BinaryTree<Integer> nodo10 = new BinaryTree<>(10);
        BinaryTree<Integer> nodo6_2 = new BinaryTree<>(6);
        
        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
        nodo5.addLeftChild(nodo4);
        nodo5.addRightChild(nodo10);

        BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
        nodo6.addLeftChild(nodo6_2);

        BinaryTree<Integer> raiz = new BinaryTree<>(2);
        raiz.addLeftChild(nodo5);
        raiz.addRightChild(nodo6);

        ProcesadorDeArbol procesador = new ProcesadorDeArbol();
        procesador.arbol = raiz;

        DatosRespuesta respuesta = procesador.procesar();
        
        System.out.println("Nodo que cumple primera condición :" + respuesta.getPrimerCondicion());
        System.out.println("Cantidad de nodos que cumplen segunda condición (pares): " + respuesta.getSegundaCondicion());
    }
}
