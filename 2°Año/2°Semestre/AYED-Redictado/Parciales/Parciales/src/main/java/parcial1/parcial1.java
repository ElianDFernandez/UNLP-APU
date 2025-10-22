package parcial1;

import generales.GeneralTree;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class parcial1 {
    private GeneralTree<Integer> arbol;
    
    public static List<Integer> caminoMasLejano(GeneralTree<Integer> arbol) {
        if(arbol == null || arbol.isEmpty()) return null;
        List<Integer> caminoAct = new LinkedList<>();
        List<Integer> caminoRes = new LinkedList<>();
        caminoMasLejano(arbol, caminoAct, caminoRes);
        
        return caminoRes;
    }
    
    private static void caminoMasLejano(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> caminoRes) {
        caminoAct.add(arbol.getData());
        if (arbol.isLeaf()){
            if (caminoAct.size() > caminoRes.size()) {
                caminoRes.clear();
                caminoRes.addAll(caminoAct);
            }
        } else {
            for(GeneralTree<Integer> hijo : arbol.getChildren()) {
                caminoMasLejano(hijo, caminoAct, caminoRes);
            }
        }
        caminoAct.remove(caminoAct.size()-1);
    }
    
    public static void main(String[] args) {
        // 1. CREACIÓN DEL ÁRBOL DE LA IMAGEN
        GeneralTree<Integer> n4 = new GeneralTree<>(4);
        GeneralTree<Integer> n2 = new GeneralTree<>(2);
        GeneralTree<Integer> n6 = new GeneralTree<>(6);
        GeneralTree<Integer> n1 = new GeneralTree<>(1);
        GeneralTree<Integer> n9 = new GeneralTree<>(9);
        GeneralTree<Integer> n10 = new GeneralTree<>(10);

        GeneralTree<Integer> n7 = new GeneralTree<>(7);
        n7.addChild(n2);

        GeneralTree<Integer> n3 = new GeneralTree<>(3);
        n3.addChild(n4);
        n3.addChild(n7);
        n3.addChild(n6);

        GeneralTree<Integer> n5 = new GeneralTree<>(5);
        n5.addChild(n1);
        n5.addChild(n9);
        n5.addChild(n10);

        GeneralTree<Integer> arbol = new GeneralTree<>(8); // Raíz
        arbol.addChild(n3);
        arbol.addChild(n5);

        // 2. LLAMADA A TU MÉTODO
        System.out.println("Iniciando la prueba...");
        List<Integer> resultado = parcial1.caminoMasLejano(arbol);

        // 3. IMPRESIÓN DEL RESULTADO
        System.out.println("El camino más lejano encontrado es: " + resultado);
    }
}
