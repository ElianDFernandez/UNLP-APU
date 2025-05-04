package tp3.ejercicio9;

import tp3.GeneralTree;

public class ParcialArboles {
    // Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos.
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (arbol == null || arbol.isEmpty()) {
            return false;
        }
        return esDeSeleccionRecursivo(arbol);
    }

    private static boolean esDeSeleccionRecursivo(GeneralTree<Integer> arbol) {
        if (arbol.isLeaf()) {
            return true;
        }
        int data = arbol.getData();
        int minHijoValor = Integer.MAX_VALUE;
        boolean todosHijosSeleccion = true;

        for (GeneralTree<Integer> hijo : arbol.getChildren()) {
            minHijoValor = Math.min(minHijoValor, hijo.getData());
            if (!esDeSeleccionRecursivo(hijo)) {
                todosHijosSeleccion = false;
            }
        }
        
        return (data == minHijoValor) && todosHijosSeleccion;
    }
    
    public static void main(String[] args) {
        // Ejemplo 1: Un árbol de selección válido
        // Cada nodo tiene el valor igual al menor de sus hijos
        GeneralTree<Integer> arbolSeleccion = new GeneralTree<>(1);
        GeneralTree<Integer> hijo1 = new GeneralTree<>(3);
        GeneralTree<Integer> hijo2 = new GeneralTree<>(1);
        GeneralTree<Integer> hijo3 = new GeneralTree<>(5);
        
        // Añadir hijos al árbol principal
        arbolSeleccion.addChild(hijo1);
        arbolSeleccion.addChild(hijo2);
        arbolSeleccion.addChild(hijo3);
        
        // Añadir nietos (hijos de hijo1)
        GeneralTree<Integer> nieto1 = new GeneralTree<>(3);
        GeneralTree<Integer> nieto2 = new GeneralTree<>(7);
        hijo1.addChild(nieto1);
        hijo1.addChild(nieto2);
        
        // Añadir nietos (hijos de hijo2)
        GeneralTree<Integer> nieto3 = new GeneralTree<>(1);
        GeneralTree<Integer> nieto4 = new GeneralTree<>(4);
        hijo2.addChild(nieto3);
        hijo2.addChild(nieto4);
        
        // Ejemplo 2: Un árbol que NO es de selección
        GeneralTree<Integer> arbolNoSeleccion = new GeneralTree<>(2); // Debería ser 1 para ser de selección
        GeneralTree<Integer> hijo4 = new GeneralTree<>(3);
        GeneralTree<Integer> hijo5 = new GeneralTree<>(1);
        GeneralTree<Integer> hijo6 = new GeneralTree<>(4);
        
        arbolNoSeleccion.addChild(hijo4);
        arbolNoSeleccion.addChild(hijo5);
        arbolNoSeleccion.addChild(hijo6);
        
        // Verificar y mostrar resultados
        System.out.println("Árbol 1 es de selección: " + esDeSeleccion(arbolSeleccion)); // Debería ser true
        System.out.println("Árbol 2 es de selección: " + esDeSeleccion(arbolNoSeleccion)); // Debería ser false
        
        // Diagrama visual del árbol de selección (comentario)
        System.out.println("\nEstructura del árbol 1 (de selección):");
        System.out.println("      1      ");
        System.out.println("    / | \\    ");
        System.out.println("   3  1  5   ");
        System.out.println("  / \\ | \\   ");
        System.out.println(" 3  7 1  4   ");
        
        // Diagrama visual del árbol que no es de selección (comentario)
        System.out.println("\nEstructura del árbol 2 (NO de selección):");
        System.out.println("      2      "); // Debería ser 1 para ser de selección
        System.out.println("    / | \\    ");
        System.out.println("   3  1  4   ");
    }
}
