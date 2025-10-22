package Parciales.Parcial9;

import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;

public class Parcial9 {
    private GeneralTree<Integer> arbol;

    public Parcial9(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> camino (int num) {
        List<Integer> lista = new LinkedList<>();
        if (arbol == null || arbol.isEmpty()) return lista;
        caminoRecursivo(this.arbol,lista, num);
        
        return lista;
    }
    
    private boolean caminoRecursivo(GeneralTree<Integer> arbol, List<Integer> camino, int num) {
        // 1. Agregamos el nodo actual al camino.
        camino.add(arbol.getData());

        // 2. Si es una hoja, es un camino válido. Terminamos con éxito.
        if (arbol.isLeaf()) {
            return true;
        }

        // 3. Si es un nodo interno, validamos la cantidad de hijos.
        if (arbol.getChildren().size() >= num) {
            // Buscamos en los hijos.
            for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                // Si ALGÚN hijo devuelve 'true', hemos encontrado el camino.
                // Retornamos 'true' inmediatamente.
                if (caminoRecursivo(hijo, camino, num)) {
                    return true;
                }
            }
        }

        // 4. Si llegamos aquí, es porque:
        //    a) El nodo interno no tenía 'num' hijos.
        //    b) Ninguno de sus hijos pudo formar un camino válido.
        // Por lo tanto, este nodo no pertenece a la solución. Lo quitamos (backtrack) y retornamos 'false'.
        camino.remove(camino.size() - 1);
        return false;
    }
    
    public static void main(String[] args) {
        // --- Construcción del árbol de la imagen ---
        GeneralTree<Integer> raiz = new GeneralTree<>(10);

        GeneralTree<Integer> n8 = new GeneralTree<>(8);
        GeneralTree<Integer> n42 = new GeneralTree<>(42);
        GeneralTree<Integer> n_5 = new GeneralTree<>(-5);
        raiz.addChild(n8);
        raiz.addChild(n42);
        raiz.addChild(n_5);

        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        GeneralTree<Integer> n22 = new GeneralTree<>(22);
        n8.addChild(n5);
        n8.addChild(n22);
        
        // NOTA: El número en la imagen es poco claro, asumimos que es -6.
        n5.addChild(new GeneralTree<>(-6)); 
        n22.addChild(new GeneralTree<>(28));
        
        n22.addChild(new GeneralTree<>(55));
        n22.addChild(new GeneralTree<>(18));

        GeneralTree<Integer> n19 = new GeneralTree<>(19);
        n_5.addChild(n19);
        n_5.addChild(new GeneralTree<>(-9));
        
        n19.addChild(new GeneralTree<>(4));
        
        // --- Ejecución de las pruebas ---
        Parcial9 solucionador = new Parcial9(raiz);

        // Prueba 1: Buscar camino donde los nodos internos tengan 3 hijos
        System.out.println("--- Prueba con num = 3 ---");
        List<Integer> resultado1 = solucionador.camino(3);
        System.out.println("Camino encontrado: " + resultado1); // Salida esperada: [10, 42]
        
        System.out.println("\n--------------------------\n");

        // Prueba 2: Buscar camino donde los nodos internos tengan 2 hijos
        System.out.println("--- Prueba con num = 2 ---");
        List<Integer> resultado2 = solucionador.camino(2);
        System.out.println("Camino encontrado: " + resultado2); // Salida esperada: [] (vacío)
    }
}
