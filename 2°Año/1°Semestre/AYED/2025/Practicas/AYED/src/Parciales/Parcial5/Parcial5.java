package Parciales.Parcial5;

import java.util.List;
import tp3.GeneralTree;

public class Parcial5 {
    // RECORRIENDO TODO VARIAS VECES NO ES OPTIMO
    /*
    public static Integer resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return 0;
        
        if (sumarTodoArbol(arbol) % 2 == 0) return sumaPositivos(arbol);
        return sumaNegativos(arbol);
    }
    
    private static Integer sumarTodoArbol(GeneralTree<Integer> arbol) {
        int suma = 0;
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            suma+= sumarTodoArbol(hijo);
        }
        suma+=arbol.getData();
        return suma;
    }
    
    private static Integer sumaPositivos(GeneralTree<Integer> arbol) {
        int suma = 0;
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            suma+= sumaPositivos(hijo);
        }
        if (arbol.getData() % 2 == 0) {
            suma+=arbol.getData();
        }
        return suma;
    }
    
    private static Integer sumaNegativos(GeneralTree<Integer> arbol) {
        int suma = 0;
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            suma+= sumaPositivos(hijo);
        }
        if (arbol.getData() % 2 != 0) {
            suma+=arbol.getData();
        }
        return suma;
    }
    */
    
    // Recorriendo solo una vez POSTORDEN
    public static Integer resolver(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return 0;
        Suma suma = new Suma();
        resolver(arbol, suma);
        if (suma.getTotal() % 2 == 0) {
            return suma.getPositivos();
        } else {
            return suma.getNegativos();
        }
    }
    
    private static void resolver(GeneralTree<Integer> arbol, Suma suma) {
        for(GeneralTree<Integer> hijo : arbol.getChildren()) {
            resolver(hijo, suma);
        }
        suma.sumar(arbol.getData());
    }
    
    // Recorriendo solo una vez INORDEN
    public static Integer resolverINORDEN(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) return 0;
        Suma suma = new Suma();
        resolverINORDEN(arbol, suma);
        if (suma.getTotal() % 2 == 0) {
            return suma.getPositivos();
        } else {
            return suma.getNegativos();
        }
    }
    
    private static void resolverINORDEN(GeneralTree<Integer> arbol, Suma suma) {
        List<GeneralTree<Integer>> hijos = arbol.getChildren();
        int cantidad = hijos.size();
        
        if (cantidad > 0) {
            resolverINORDEN(hijos.get(0),suma);
        }
        
        suma.sumar(arbol.getData());
        
        for(int i=1; i<cantidad; i++) {
            resolverINORDEN(hijos.get(i),suma);
        }
    }
}
