package parciales;

import java.util.ArrayList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

// RECORRIDO PRE ORDEN CON PROCESAMIENTO DE UNA LISTA

public class Parcial {
   public static List<Integer> resolver(BinaryTree<Integer> arbol, int min) {
       List<Integer> lista = new ArrayList<>();
       
       if (arbol == null || arbol.isEmpty()) return lista;
       
       resolver(arbol, min, lista, 0);
       return lista;
   } 
   
   private static boolean resolver(BinaryTree<Integer> arbol, int min, List<Integer> listaResutlado, Integer paresEncontrados) {
       int datoActual = arbol.getData();
       listaResutlado.add(datoActual);
       
       if (datoActual % 2 == 0) {
           paresEncontrados++;
       }
       
        if (arbol.isLeaf()) {
            return paresEncontrados >= min;
        }
        
        if(arbol.hasLeftChild()) {
            if (resolver(arbol.getLeftChild(), min, listaResutlado, paresEncontrados)) {
                return true;
            }
        }
        
        if(arbol.hasRightChild()) {
            if (resolver(arbol.getRightChild(), min, listaResutlado, paresEncontrados)) {
                return true;
            }
        }
        
        listaResutlado.remove(listaResutlado.size()-1);
        
        return false;
   }
}
