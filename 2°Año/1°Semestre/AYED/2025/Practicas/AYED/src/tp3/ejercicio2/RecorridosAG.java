package tp3.ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tp3.GeneralTree;

public class RecorridosAG {
    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        if (a != null && !a.isEmpty()) {
            recorrerPreOrden(a, n, resultado);
        }
        return resultado;
    }

    private void recorrerPreOrden(GeneralTree<Integer> nodo, Integer n, List<Integer> resultado) {
        // Procesar el nodo actual
        Integer valor = nodo.getData();
        if (valor % 2 != 0 && valor > n) {
            resultado.add(valor);
        }

        // Recorrer hijos en orden
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            recorrerPreOrden(hijo, n, resultado);
        }
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        if (a != null && !a.isEmpty()) {
            recorrerInOrden(a, n, resultado);
        }
        return resultado;
    }

    private void recorrerInOrden(GeneralTree<Integer> nodo, Integer n, List<Integer> resultado) {
        List<GeneralTree<Integer>> hijos = nodo.getChildren();
        if (!hijos.isEmpty()) {
            recorrerInOrden(hijos.get(0), n, resultado); // Primer hijo
        }

        // Nodo actual
        Integer valor = nodo.getData();
        if (valor % 2 != 0 && valor > n) {
            resultado.add(valor);
        }

        for (int i = 1; i < hijos.size(); i++) {
            recorrerInOrden(hijos.get(i), n, resultado); // Resto de hijos
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        if (a != null && !a.isEmpty()) {
            recorrerPostOrden(a, n, resultado);
        }
        return resultado;
    }

    private void recorrerPostOrden(GeneralTree<Integer> nodo, Integer n, List<Integer> resultado) {
        for (GeneralTree<Integer> hijo : nodo.getChildren()) {
            recorrerPostOrden(hijo, n, resultado);
        }

        Integer valor = nodo.getData();
        if (valor % 2 != 0 && valor > n) {
            resultado.add(valor);
        }
    }
    
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> resultado = new ArrayList<>();
        if (a == null || a.isEmpty()) return resultado;

        Queue<GeneralTree<Integer>> cola = new LinkedList<>();
        cola.add(a);

        while (!cola.isEmpty()) {
            GeneralTree<Integer> actual = cola.poll();

            Integer valor = actual.getData();
            if (valor % 2 != 0 && valor > n) {
                resultado.add(valor);
            }

            for (GeneralTree<Integer> hijo : actual.getChildren()) {
                cola.add(hijo);
            }
        }

        return resultado;
    }
}
