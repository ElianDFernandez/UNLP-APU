package Parciales.Parcial2;

import java.util.LinkedList;
import java.util.List;
import tp3.GeneralTree;

public class Parcial2 {
 public static List<Integer> caminoMasLejano(GeneralTree<Integer> arbol) {
     if (arbol == null || arbol.isEmpty()) return null;
     List<Integer> caminoAct = new LinkedList<>();
     List<Integer> caminoRes = new LinkedList<>();
     caminoMasLejano(arbol,caminoAct,caminoRes);
     
     return caminoRes;
 }   
 
 private static void caminoMasLejano(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> caminoRes) {
     caminoAct.add(arbol.getData());
     if (arbol.isLeaf()) {
         if (caminoAct.size() > caminoRes.size()) {
             caminoRes.clear();
             caminoRes.addAll(caminoAct);
         }
     } else {
         for (GeneralTree<Integer> hijo : arbol.getChildren()) {
             caminoMasLejano(hijo,caminoAct,caminoRes);
         }
     }
     caminoAct.remove(caminoAct.size()-1);
 } 
}
