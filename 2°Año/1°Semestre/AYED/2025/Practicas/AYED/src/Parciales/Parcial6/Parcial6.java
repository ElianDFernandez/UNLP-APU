package Parciales.Parcial6;

import Parciales.Parcial5.Suma;
import java.util.List;
import tp3.GeneralTree;

public class Parcial6 {
    public static Integer resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;
        Suma suma = new Suma();
        Integer cantNodos = contarNodo(arbol, suma);
        if(cantNodos % 2 == 0) {
            return suma.getPositivos();
        } else {
            return suma.getNegativos();
        }
    }
    
    private static Integer contarNodo(GeneralTree<Integer> arbol, Suma sumaTotal) {
        int suma = 0;
        
        List<GeneralTree<Integer>> hijos = arbol.getChildren();
        int cantidad = hijos.size();
        
        if (cantidad > 0) {
            suma += contarNodo(hijos.get(0),sumaTotal);
        }
        
        suma = suma +1;
        sumaTotal.sumar(arbol.getData());
        
        for (int i=1; i<cantidad; i++) {
            suma += contarNodo(hijos.get(i),sumaTotal);
        }
        
        return suma;
    }
}
