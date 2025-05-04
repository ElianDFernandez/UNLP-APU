package tp3.ejercicio7;

import java.util.ArrayList;
import java.util.List;
import tp3.GeneralTree;

public class Caminos {
    private GeneralTree<Integer> arbol = null; 

    public Caminos(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> caminoAHojaMasLejama() {
        List<Integer> lista = new ArrayList<>();
        if (this.arbol != null) caminoAHojaMasLejanaRecursivo(this.arbol , lista, new ArrayList<>());
        
        return lista;
    }
    
    private static void caminoAHojaMasLejanaRecursivo(GeneralTree<Integer> arbol, List<Integer> listaResultado, List<Integer> caminoActual) {
        caminoActual.add(arbol.getData());
        if (arbol.isLeaf()){
            if (caminoActual.size() > listaResultado.size()) {
                listaResultado.clear();
                listaResultado.addAll(caminoActual);
            }
        } else {
            for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                caminoAHojaMasLejanaRecursivo(hijo, listaResultado, caminoActual);
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
    }
    
    public static void main(String[]args){
        // Ejemplo de uso
        GeneralTree<Integer> raiz = new GeneralTree<>(1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);

        raiz.addChild(nodo2);
        raiz.addChild(nodo3);
        raiz.addChild(nodo4);
        
        nodo2.addChild(nodo5);
        nodo4.addChild(nodo6);
        nodo6.addChild(nodo7);
        
        /*
              1
            / | \
           2  3  4
          /      \
         5        6
                  /
                 7

        */
        
        Caminos caminos = new Caminos(raiz);
        List<Integer> caminoMasLargo = caminos.caminoAHojaMasLejama();
        System.out.println("Camino más largo: " + caminoMasLargo);
    }
}
