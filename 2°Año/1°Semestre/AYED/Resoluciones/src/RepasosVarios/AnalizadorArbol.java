package RepasosVarios;

import Practica1.Ejercicio8.Queue;
import Practica3.Ejercicio1y3y5.GeneralTree;
import Practica3.Ejercicio4.AreaEmpresa;
import java.util.LinkedList;
import java.util.List;

public class AnalizadorArbol {
    // RECORRIDO POR NIVELES SACANDO PROMEDIOS Y DEVOLVIENDO EL MAYOR
    public static double devolverMaximoPromediio(GeneralTree<AreaEmpresa> arbol) {
        if (arbol.isEmpty()){
            return 0;
        } 
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        GeneralTree<AreaEmpresa> aux;
        double max = -1;
        double sum = 0;
        int cantNodos = 0;
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                cantNodos++;
                sum += aux.getData().getTardanza();
                for (GeneralTree<AreaEmpresa> h: aux.getChildren()) {
                    cola.enqueue(h);
                }
            } 
            else if (!cola.isEmpty()) {
                cola.enqueue(null);
                sum = sum/cantNodos;
                max = Math.max(max, sum);
                cantNodos=0;
            }
        }
        return max;
    } 
    
    
    public static List<Integer> caminoMasLargo(GeneralTree<Integer> arbol) {
        List<Integer> camAct = new LinkedList<>();
        List<Integer> camMasLargo = new LinkedList<>();
        if (!arbol.isEmpty()) caminoMasLargo(arbol,camAct,camMasLargo);
        return camMasLargo;
    }
    
    private static void caminoMasLargo(GeneralTree<Integer> arbol, List<Integer> camAct, List<Integer> camMasLargo) {
        camAct.add(arbol.getData());
        if (arbol.isLeaf()) {
            if (camAct.size() > camMasLargo.size()) {
                camMasLargo.removeAll(camMasLargo);
                camMasLargo.addAll(camAct);
            }
        } else {
            for(GeneralTree<Integer> h: arbol.getChildren()) {
                caminoMasLargo(h,camAct,camMasLargo);
                camAct.remove(camAct.size()-1);
            }
        }
    }
    
    public static boolean esAncestro(GeneralTree<Integer> arbol,Integer a, Integer b){
        if (arbol.isEmpty() || arbol.isLeaf()) return false;
        return esAncestroBusqueda(arbol,a,b); // Encontrar a antes que b, y buscar b en el subarbol de raiz a
    }
    
    private static boolean esAncestroBusqueda(GeneralTree<Integer> arbol, Integer a, Integer b){
        boolean ok = false;
        GeneralTree<Integer> nodoRaiz = null;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        cola.enqueue(arbol);
        while (!cola.isEmpty() && !ok) {
            aux = cola.dequeue();
            if (aux.getData().equals(a)) {
                ok = true;
                nodoRaiz = aux;
            }
            if (aux.getData().equals(b) && !ok) return false;
            if (!ok) {
                for (GeneralTree<Integer>h:aux.getChildren()) {
                    cola.enqueue(h);
                }
            }
        }
        if (ok) return esAncestroBusquedaSubArbol(nodoRaiz,b);
        return false;
    }
    
    private static boolean esAncestroBusquedaSubArbol(GeneralTree<Integer> nodoRaiz, Integer b) {
        boolean ok = false;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        cola.enqueue(nodoRaiz);
        while (!cola.isEmpty() && !ok) {
            aux = cola.dequeue();
            if (aux.getData().equals(b)) {
                ok = true;
            } else {
                for (GeneralTree<Integer>h:aux.getChildren()) {
                    cola.enqueue(h);
                }
            }
        }
        return ok;
    }
    
    // HAY PARES E IMPARES PERO SOLO CUENTAN LOS PARES Y TENEMOS QUE DEVOLVER EL CAMINO SOLO CON LOS PARES
    public static List<Integer> caminoMayorDeNumerosPares(GeneralTree<Integer> arbol) {
        List<Integer> camAct = new LinkedList<>();
        List<Integer> camMax = new LinkedList<>();
        Integer maximo = 0;
        if (!arbol.isEmpty()) caminoMayorDeNumerosPares(arbol,camAct,camMax,maximo,0);
        return camMax;
    }  
    
    private static void caminoMayorDeNumerosPares(GeneralTree<Integer> arbol, List<Integer> camAct, List<Integer> camMax, Integer maximo, int valorTotal) 
    {
        int datoActual = arbol.getData();
        boolean ok = (datoActual % 2 == 0);
        if (ok) {
            // SI ES PAR AGREGO A CAMACT
            camAct.add(datoActual);
            // Sumo ValorTotal
            valorTotal+=datoActual;
        }
        if (!arbol.isLeaf()) {
            for (GeneralTree<Integer> h : arbol.getChildren()) {
                caminoMayorDeNumerosPares(h, camAct, camMax, maximo, valorTotal);
            }
        }
        else if (valorTotal > maximo) {
                camMax.removeAll(camMax);
                camMax.addAll(camAct);
                maximo = valorTotal;
            }
        if (ok) {
            camAct.remove(camAct.size()-1);
        }
    }
    
    public static void main(String[] args) {
        GeneralTree<Integer> root = new GeneralTree<>(1);
        GeneralTree<Integer> child1 = new GeneralTree<>(2);
        GeneralTree<Integer> child2 = new GeneralTree<>(3);
        GeneralTree<Integer> child3 = new GeneralTree<>(4);

        root.addChild(child1);
        root.addChild(child2);
        child1.addChild(child3);

        boolean resultado = esDeSeleccion(root);
        System.out.println("El árbol es de selección: " + resultado);

        GeneralTree<Integer> root2 = new GeneralTree<>(5);
        GeneralTree<Integer> child21 = new GeneralTree<>(3);
        GeneralTree<Integer> child22 = new GeneralTree<>(4);
        GeneralTree<Integer> child23 = new GeneralTree<>(2);

        root2.addChild(child21);
        root2.addChild(child22);
        child21.addChild(child23);

        boolean resultado2 = esDeSeleccion(root2);
        System.out.println("El árbol es de selección: " + resultado2);
    }
    
    
    
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol.isEmpty()) return false;
        boolean ok = true;
        Queue <GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        cola.enqueue(arbol);
        int min = 99999;
        while (!cola.isEmpty() && ok) {
            aux = cola.dequeue();
            for (GeneralTree<Integer> h : aux.getChildren()) {
                cola.enqueue(h);
                min = Math.min(h.getData(),min);
            }
            if (min != aux.getData()) {
                ok = false;
            }
        }
        return ok;
    }
    
    
}
