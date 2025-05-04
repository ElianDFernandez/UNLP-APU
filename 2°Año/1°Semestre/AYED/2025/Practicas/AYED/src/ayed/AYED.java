package ayed;

public class AYED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
    }
    //TODO Metodos generales para arboles binarios de busquda.

    //! Recorridos en profundidad: preorden, inorden y postorden. Desde la raiz hacia abajo.
    
    public static void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + " ");
            preorden(nodo.getIzquierdo());
            preorden(nodo.getDerecho());
        }
    }
    public static void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.getIzquierdo());
            System.out.print(nodo.getValor() + " ");
            inorden(nodo.getDerecho());
        }
    }

    public static void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.getIzquierdo());
            postorden(nodo.getDerecho());
            System.out.print(nodo.getValor() + " ");
        }
    }

    // Ejemplo de aplicacion. Retornar true si el subarbol derecho posee mas nodos con un valor mayor que 3 que el izquierdo.
    public static boolean subarbol(Nodo nodo) {
        if (nodo == null) {
            return false;
        }
        int izquierdo = contarMayores(nodo.getIzquierdo(), 3);
        int derecho = contarMayores(nodo.getDerecho(), 3);
        return derecho > izquierdo;
    }

    public static int contarMayores(Nodo nodo, int valor) {
        if (nodo == null) {
            return 0;
        }
        int contador = 0;
        if (nodo.getValor() > valor) {
            contador = 1;
        }
        return contador + contarMayores(nodo.getIzquierdo(), valor) + contarMayores(nodo.getDerecho(), valor);
    }

    //! Recorridos por niveles: nivel por nivel. Desde la raiz hacia abajo y de izquierda a derecha.
    public void entreNiveles(int n, int m) {
        if (this.isEmpty() || n < 0 || m < n) return; 
        Queue<BinaryTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        int nivelActual = 0;

        while(!cola.isEmpty()) {
            int nodoNivel = cola.size();
            if(nivelActual >=n && nivelActual <= m) {
                for(int i=0; i < nodoNivel; i++) {
                    BinaryTree<T> nodo = cola.dequeue();
                    System.out.print(nodo.getData() + " | ");
                    if(nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
                    if(nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
                }
            } else {
                for(int i=0; i < nodoNivel; i++) {
                    cola.dequeue();
                }
            }
            nivelActual++;
            System.out.println("");
        }
    }

    // Ejemplo de aplicacion. Retornar true si el arbol posee 3 nodos en el nivel 2.
    public void tieneTresNodosEnNivel(int nivel) {
        if (this.isEmpty() || nivel < 0) return; 
        Queue<BinaryTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        int nivelActual = 0;
        int contador = 0;

        while(!cola.isEmpty()) {
            int nodoNivel = cola.size();
            if(nivelActual == nivel) {
                contador += nodoNivel;
            } else {
                for(int i=0; i < nodoNivel; i++) {
                    BinaryTree<T> nodo = cola.dequeue();
                    if(nodo.hasLeftChild()) cola.enqueue(nodo.getLeftChild());
                    if(nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
                }
            }
            nivelActual++;
        }
        return contador == 3;
    }
}
