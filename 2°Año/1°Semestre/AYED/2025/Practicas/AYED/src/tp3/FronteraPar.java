package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class FronteraPar {
    /*
    Frontera Par
    Retornar una lista con los valores pares de las hojas del arbolm recorridas de izquierda a derecha
    En un arbol generaal, la frontera se define como el conjunto de todas sus hojas, es decir los nodos que no tienen hijos.
    */
    
    public static List<Integer> fronteraPar(GeneralTree<Integer> arbol) {
        List<Integer> lista = new ArrayList();
        if (arbol == null && arbol.isEmpty()) {
            return lista;
        }   
        else {
            fronteraParRecursivo(arbol, lista);
        }
        
        return lista;
    }
    
    private static void fronteraParRecursivo(GeneralTree<Integer> arbol, List<Integer> lista) {
        if (arbol.isLeaf() && arbol.getData() % 2 == 0) {
            lista.add(arbol.getData());
        }
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            fronteraParRecursivo(hijo, lista);
        }
    }
    
    public static void main(String[] args) {
        GeneralTree<Integer> root = new GeneralTree<>(8);
        GeneralTree<Integer> n3 = new GeneralTree<>(3);
        GeneralTree<Integer> n10 = new GeneralTree<>(10);
        GeneralTree<Integer> n14 = new GeneralTree<>(14);
        GeneralTree<Integer> n4 = new GeneralTree<>(4);
        GeneralTree<Integer> n7 = new GeneralTree<>(7);
        GeneralTree<Integer> n2 = new GeneralTree<>(2);

        // Construimos el árbol
        root.addChild(n3);
        root.addChild(n10);
        root.addChild(n14);
        n3.addChild(n4);
        n3.addChild(n7);
        n14.addChild(n2);
        
        /*
              8
            / | \
           3  10  14
          / \      \
         4   7      2
        */
        List<Integer> fronteraPar = fronteraPar(root);

        System.out.println(fronteraPar);
    }
}
