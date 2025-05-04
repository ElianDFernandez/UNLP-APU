package tp3.ejercicio10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

public class ParcialArboles {
    /*
    devuelve una lista con los
    valores que componen el “camino filtrado de valor máximo”, se llama “filtrado” porque sólo se agregan al
    camino los valores iguales a 1 (los 0 no se agregan), mientras que es “de valor máximo” porque se obtiene
    de realizar el siguiente cálculo: es la suma de los valores de los nodos multiplicados por su nivel. De haber
    más de uno, devolver el primero que se encuentre.
     */

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> camAct = new LinkedList<Integer>();
        List<Integer> camMax = new LinkedList<Integer>();
        Maximo max = new Maximo(-1);
        resolver(arbol, camAct, camMax, max, 0, 0);
        return camMax;
    }
    
    private static void resolver(GeneralTree<Integer> arbol, List<Integer> camAct, List<Integer> camMax, Maximo max, int valorTotal, int nivel) {
        int datoActual = arbol.getData();
        boolean ok = (datoActual == 1);
        if(ok) {
            valorTotal+= datoActual * nivel;
            camAct.add(datoActual);
        }
        if(!arbol.isLeaf()) {
            for(GeneralTree<Integer>h: arbol.getChildren()) {
                resolver(h, camAct, camMax, max, valorTotal, nivel+1);
            }
        } else {
            if (valorTotal > max.getMax()) {
                max.setMax(valorTotal);
                valorTotal = 0;
                camMax.removeAll(camMax);
                camMax.addAll(camAct);
            }
        }
        if(ok) camAct.remove(camAct.size()-1);
    }

}
