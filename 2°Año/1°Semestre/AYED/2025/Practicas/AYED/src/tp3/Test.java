package tp3;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

/**
 *
 */
public class Test {
   /**
    Recorrer un arbol general y retornar una lista con los nodos cuyos valores esten dentro de un rango pasado pro parametro
    */ 
    public List<List<Integer>> todosLosCaminosConValoresEntre(GeneralTree<Integer> arbol, int min, int max) {
        List<List<Integer>> lista = new LinkedList<List<Integer>>();
        
        if (arbol != null && !arbol.isEmpty() && arbol.getData() > min) {
            this.caminoConValoresEnRango(arbol, min, max, lista, new LinkedList<Integer>());
        }
        
        return lista;
    } 
    
    private void caminoConValoresEnRango(GeneralTree<Integer> arbol, int min, int max, List<List<Integer>> listaResultado, List<Integer> caminoActual) {
        caminoActual.add(arbol.getData());
        if (arbol.isLeaf()) listaResultado.add(new LinkedList<Integer> (caminoActual));
        else {
            for(GeneralTree<Integer> hijo : arbol.getChildren()) {
                if (hijo.getData() >=min && hijo.getData() <=max) {
                    caminoConValoresEnRango(hijo, min, max, listaResultado, caminoActual);
                }
            }
        }
        caminoActual.remove(caminoActual.size()-1);
    }
    
    public void imprimirPorNiveles(GeneralTree<Integer> arbol) {
        if (arbol != null) {
            Queue<GeneralTree<Integer>> cola = new Queue();
            cola.enqueue(arbol);
            while (!cola.isEmpty()) {
                GeneralTree<Integer> nodo = cola.dequeue();
                
            }
        }
    }
    
    public static void main(String[] args) {
        // Construimos el árbol manualmente
        GeneralTree<Integer> arbol = new GeneralTree<>(10);

        GeneralTree<Integer> hijo1 = new GeneralTree<>(5);
        GeneralTree<Integer> hijo2 = new GeneralTree<>(15);
        GeneralTree<Integer> hijo3 = new GeneralTree<>(20);

        arbol.addChild(hijo1);
        arbol.addChild(hijo2);
        arbol.addChild(hijo3);

        hijo1.addChild(new GeneralTree<>(3));
        hijo1.addChild(new GeneralTree<>(7));

        hijo2.addChild(new GeneralTree<>(12));
        hijo2.addChild(new GeneralTree<>(18));

        hijo3.addChild(new GeneralTree<>(25));

        // Instanciamos tu clase
        Test test = new Test();

        // Buscamos caminos donde los valores estén entre 5 y 20
        List<List<Integer>> caminos = test.todosLosCaminosConValoresEntre(arbol, 5, 20);

        // Imprimimos los resultados
        for (List<Integer> camino : caminos) {
            System.out.println(camino);
        }
        /*
                10
           /    |    \
         5     15    20
        / \    / \     \
       3  7  12 18    25
       */
    }
}
