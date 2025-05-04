package tp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * El metodo retorna el primer camino que va desde la raiz hasta una hoja, en el que todos los valores del recorrido sean negativo. 
 * Si no existe ningun camino con esta condicion, se debe devolver una lista vacia
 */
public class CaminoTodosNegativos {
    public static List<Integer> primerCaminoTodosNegativos(GeneralTree<Integer> arbol) {
        List<Integer> lista = new ArrayList<Integer>();
        if (arbol != null && !arbol.isEmpty() && arbol.getData() < 0) primerCaminoTodosNegativos(arbol, lista);
        
        return lista;
    }
    
    public static Boolean primerCaminoTodosNegativos(GeneralTree<Integer> arbol, List<Integer> lista) {
        Boolean encontre = false;
        lista.add(arbol.getData());
        if (arbol.isLeaf()) encontre = true;
        else {
            List<GeneralTree<Integer>> hijos = arbol.getChildren();
            Iterator<GeneralTree<Integer>> iterador = hijos.iterator();
            while (!encontre && iterador.hasNext()){
                GeneralTree<Integer> hijo = iterador.next();
                if (hijo.getData() < 0 ) {
                    encontre = primerCaminoTodosNegativos(hijo, lista);
                }
            }
            if (!encontre)
                lista.remove(lista.size()-1);
        }
        return encontre;
    }
    
    public static List<Integer> ultimoCaminoTodosNegativos(GeneralTree<Integer> arbol) {
        List<Integer> mejorCamino = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();

        if (arbol != null && !arbol.isEmpty() && arbol.getData() < 0) {
            ultimoCaminoTodosNegativos(arbol, caminoActual, mejorCamino);
        }

        return mejorCamino;
    }

    private static void ultimoCaminoTodosNegativos(GeneralTree<Integer> arbol, List<Integer> caminoActual, List<Integer> mejorCamino) {
        caminoActual.add(arbol.getData());
        if (arbol.isLeaf()) {        
            mejorCamino.clear();
            mejorCamino.addAll(caminoActual);
        } else {
            for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                if (hijo.getData() < 0) {
                    ultimoCaminoTodosNegativos(hijo, caminoActual, mejorCamino);
                }
            }
        }
        caminoActual.remove(caminoActual.size() - 1);
    }
    
    public static void main(String[] args) {
        GeneralTree<Integer> root = new GeneralTree<>(-5);
        GeneralTree<Integer> n3 = new GeneralTree<>(-3);
        GeneralTree<Integer> n8 = new GeneralTree<>(8); 
        GeneralTree<Integer> n1 = new GeneralTree<>(-1);
        GeneralTree<Integer> n4 = new GeneralTree<>(-4);

        root.addChild(n3);
        root.addChild(n8);
        n3.addChild(n1);
        n3.addChild(n4);

        List<Integer> camino = CaminoTodosNegativos.primerCaminoTodosNegativos(root);

        /*
                 -5
                /   \
             -3       8
            /   \
         -1      -4
        */
        System.out.println(camino); // Debería imprimir algo como [-5, -3, -1]
        
        List<Integer> camino2 = CaminoTodosNegativos.ultimoCaminoTodosNegativos(root);
        
        System.out.println(camino2);
    }
}
