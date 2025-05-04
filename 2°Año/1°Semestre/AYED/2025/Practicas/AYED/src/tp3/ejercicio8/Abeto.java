package tp3.ejercicio8;

import java.util.LinkedList;
import java.util.Scanner;

import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

public class Abeto {
    /*
    Considere un árbol general. Recordemos que el vértice u se llama hijo del vértice v y el vértice v se llama padre del vértice u si existe una arista 
    dirigida de v a u. El árbol tiene un vértice distinguido llamado raíz, que es el único vértice que no tiene padre. Un vértice se llama hoja si no tiene 
    hijos y tiene padre. Llamaremos abeto a un árbol si cada vértice no hoja tiene al menos 3 hijos hojas. Dado un árbol general, compruebe si es un abeto.
    Input
        La primera línea contiene un entero n: el número de vértices en el árbol (3 ≤ n ≤ 1000). 
        Cada una de las siguientes n - 1 líneas contiene un entero pi (1 ≤ i ≤ n - 1) — el índice del padre del i + 1-ésimo vértice (1 ≤ pi ≤ i).
        El vértice 1 es la raíz. Está garantizado que la raíz tiene al menos 2 hijos.
    Output
        Imprima "Yes" si el árbol es un abeto y "No" de lo contrario. 

    Ejemplo 1   Ejemplo 2   Ejemplo 3
    Input       Input       Input

    4           7           8
    1           1           1
    1           1           1
    1           1           1
                2           1               
                2           3               
                2           3
                            3

    Output      Output      Output
    Yes         No          Yes

    Arbol Ejemplo 1: 
                  1
                / | \
               2  3  4

    Arbol Ejemplo 2: 
                  1
                / | \
               2  3  4
             / | \
            5  6  7

    Arbol Ejemplo 3: 
                  1
                / | \ \
               2  3  4 5
                / | \  
               6  7  8
    */

    private GeneralTree<Integer> arbol = null;

    public Abeto() {
    }

    public void crearArbol() {
        arbol = construirArbol();
    }

    public GeneralTree<Integer> construirArbol() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Número de vértices. Un vertice es un nodo en el árbol.
        GeneralTree<Integer> arbol = new GeneralTree<>(1);  // Raíz es el nodo 1
        GeneralTree<Integer>[] nodos = new GeneralTree[n]; // Array para almacenar los nodos
        nodos[0] = arbol; // Guardamos la raíz en el array de nodos 

        // Leer las relaciones padre-hijo y construir el árbol
        for (int i = 1; i < n; i++) {
            int padreIndex = scanner.nextInt() - 1;  // Convertimos a índice 0 basado
            GeneralTree<Integer> nuevoNodo = new GeneralTree<>(i + 1);  // El nodo i + 1
            nodos[padreIndex].addChild(nuevoNodo); // Buscamos el padre en el array de nodos y le agregamos el nuevo nodo como hijo
            nodos[i] = nuevoNodo;  // Guardamos el nodo para posibles futuras referencias
        }

        scanner.close();

        return arbol;
    }

    public void imprimirPorNivelArbol(GeneralTree<Integer> arbol) {
        if (arbol == null) {
            return;
        }
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        int nodosEnNivel = 1;
        while (!cola.isEmpty()) {
            // Sacamos el primer nodo de la cola
            GeneralTree<Integer> nodo = cola.dequeue();
            System.out.print(nodo.getData() + " ");
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                cola.enqueue(hijo);
            }
            nodosEnNivel--;
            if (nodosEnNivel == 0) {
                System.out.println();
                nodosEnNivel = cola.size();
            }
        }
    }


    public static void main(String[] args) {
        Abeto abeto = new Abeto();
        abeto.crearArbol();
        
        System.out.println("Árbol creado: ");
        abeto.imprimirPorNivelArbol(abeto.arbol);

        System.out.println("¿Es un abeto navideño? " + abeto.esAbetoNavidenio());
    }

    /*Ejercicio 8
    Retomando el ejercicio abeto navideño visto en teoría, cree una clase Navidad que cuenta con una
    variable de instancia GeneralTree que representa al abeto (ya creado) e implemente el método con la
    firma: public String esAbetoNavidenio() 
    */


    public String esAbetoNavidenio() {
        if (arbol == null) {
            return "No";
        }
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        while (!cola.isEmpty()) {
            GeneralTree<Integer> nodo = cola.dequeue();
            if (!nodo.isLeaf()) {
                int hijosHojas = 0;
                for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                    if (hijo.isLeaf()) {
                        hijosHojas++;
                    }
                }
                if (hijosHojas < 3) {
                    return "No";
                }
            }
            for (GeneralTree<Integer> hijo : nodo.getChildren()) {
                cola.enqueue(hijo);
            }
        }
        return "Yes";
    }

}
