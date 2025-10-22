/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial6;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class parcial6 {
    private GeneralTree<Integer> arbol;
    
    public List<Integer> camino(int num) {
        if (arbol == null || arbol.isEmpty()) return null;
        
        List<Integer> camino = new LinkedList<>();
        camino(this.arbol, camino, num);
        
        return camino;
    }
    
    private boolean camino(GeneralTree<Integer> arbol, List<Integer> camino, int num) {
        // 1. Agregamos el nodo actual al camino.
        camino.add(arbol.getData());

        // 2. Si es una hoja, es un camino válido. Terminamos con éxito.
        if (arbol.isLeaf()) {
            return true;
        }

        // 3. Si es un nodo interno, validamos la cantidad de hijos.
        if (arbol.getChildren().size() == num) {
            // Buscamos en los hijos.
            for (GeneralTree<Integer> hijo : arbol.getChildren()) {
                // Si ALGÚN hijo devuelve 'true', hemos encontrado el camino.
                // Retornamos 'true' inmediatamente.
                if (camino(hijo, camino, num)) {
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
}
