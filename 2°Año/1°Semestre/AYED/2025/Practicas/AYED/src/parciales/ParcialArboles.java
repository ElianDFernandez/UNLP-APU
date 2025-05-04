package parciales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

public class ParcialArboles {
    private GeneralTree<Integer> arbol;

    public GeneralTree<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }    

    public List <Integer> nivel1(int num) {
        List<Integer> lista = new ArrayList<>();
        
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        
        while (!cola.isEmpty()) {
            int nodosNivel = cola.size();
            
            for(int i = 0; i < nodosNivel; i++) {
                GeneralTree<Integer> nodo = cola.dequeue();
                if (nodo.getChildren().size() == num) {
                    lista.add(nodo.getData());
                }
                for(GeneralTree<Integer> hijo : nodo.getChildren()) {
                    cola.enqueue(hijo);
                }
            }
            
            if (lista.size() == nodosNivel){
                return lista;
            } else {
                lista.clear();
            }
        }
        
        return lista;
    }
    
    public static void main(String[] args) {
        // Construir el árbol
        
        GeneralTree<Integer> raiz = new GeneralTree<>(1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo6 = new GeneralTree<>(6);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);

        raiz.addChild(nodo2);
        raiz.addChild(nodo3);
        raiz.addChild(nodo4);
        nodo2.addChild(nodo5);
        nodo3.addChild(nodo5);
        nodo4.addChild(nodo6);
        nodo6.addChild(nodo7);
        /*
               1
            /  |  \
          2    3   4
         /    /    /
        5    5    6
                   \
                    7
        */

        ParcialArboles parcial = new ParcialArboles();
        parcial.setArbol(raiz);

        System.out.println("\n=== Método nivel1 (verificación por lista.size) ===");
        List<Integer> resultado1 = parcial.nivel1(1);
        System.out.println("Resultado: " + resultado1);
    }
}
