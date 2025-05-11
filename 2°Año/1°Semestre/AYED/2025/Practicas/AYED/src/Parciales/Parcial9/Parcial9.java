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
        caminoRecursivo(this.arbol,num,lista);
        
        return lista;
    }
    
    private static boolean caminoRecursivo(GeneralTree<Integer> arbol, int num, List<Integer> lista) {
        lista.add(arbol.getData());
        if (arbol.isLeaf()){
            return true;
        } else {
            if(arbol.getChildren().size() >= num) {
                for(GeneralTree<Integer> hijo : arbol.getChildren()) {
                    if (caminoRecursivo(hijo,num,lista)) {
                        return true;
                    }
                }
            }
        }
        
        lista.remove(lista.size()-1);
        
        return false;
    }
    
    public static void main(String args[]) {
        GeneralTree<Integer> arbol = new GeneralTree<Integer>(10);
        
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5);
        subAb1.addChild(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22);
        subAb2.addChild(new GeneralTree<Integer>(28));
        subAb2.addChild(new GeneralTree<Integer>(55));
        subAb2.addChild(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8);
        a1.addChild(subAb1);
        a1.addChild(subAb2);
        
        arbol.addChild(a1);
        arbol.addChild(new GeneralTree<Integer>(42));
        
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19);
        subAb3.addChild(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5);
        a2.addChild(subAb3);
        a2.addChild(new GeneralTree<Integer>(-9));
        
        arbol.addChild(a2);
        
        Parcial9 p = new Parcial9(arbol);
        
        System.out.println(p.camino(5));
        System.out.println(p.camino(5));
    }
}
