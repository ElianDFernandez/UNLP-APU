package tp2.ejercicio3;

import tp2.ejercicio1.BinaryTree;
import java.util.List;

public class ContadorArbolTest {
    public static void main(String[] args) {
        // Construir el árbol de prueba
        BinaryTree<Integer> arbol = new BinaryTree<>(10);
        arbol.addLeftChild(new BinaryTree<>(5));
        arbol.addRightChild(new BinaryTree<>(20));
        arbol.getLeftChild().addLeftChild(new BinaryTree<>(2));
        arbol.getLeftChild().addRightChild(new BinaryTree<>(8));
        arbol.getRightChild().addLeftChild(new BinaryTree<>(15));
        arbol.getRightChild().addRightChild(new BinaryTree<>(30));

        /*
              10
             /  \
            5   20
           / \  / \
          2   8 15 30
        */

        // Instancia de ContadorArbol
        ContadorArbol contador = new ContadorArbol(arbol);

        // Test del método en inorden
        List<Integer> paresInOrden = contador.numerosParesInOrden();
        System.out.println("Números pares (InOrden): " + paresInOrden);

        // Test del método en postorden
        List<Integer> paresPostOrden = contador.numerosParesPostOrden();
        System.out.println("Números pares (PostOrden): " + paresPostOrden);
        
        // Test del método en preorden
        List<Integer> paresPreOrden = contador.numerosParesPreOrden();
        System.out.println("Números pares (PreOrden): " + paresPostOrden);
    }
}
