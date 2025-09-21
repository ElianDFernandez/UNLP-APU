package tp2.ejercicio1;

import java.util.LinkedList;
import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		return this.sumarHojas(this);
	}
        
        public int sumarHojas(BinaryTree <T> arbol) {
            int suma = 0;
            if (arbol == null){
                return 0;
            }
            if (!arbol.isLeaf()){
                suma = sumarHojas(arbol.getLeftChild()) + sumarHojas(arbol.getRightChild());
            } else {
                return 1;
            }
            return suma;
        }

        public BinaryTree<T> espejo(){
            return espejoRecursivo(this);
        }
        
        public BinaryTree<T> espejoRecursivo(BinaryTree<T> nodo) {
            if (nodo == null) return null;
            data = nodo.getData();
            BinaryTree<T> nuevoNodo = new BinaryTree<>(nodo.getData());
            nuevoNodo.addLeftChild(espejoRecursivo(nodo.getRightChild()));
            nuevoNodo.addRightChild(espejoRecursivo(nodo.getLeftChild()));
            
            return nuevoNodo;
        }

        // 0<=n<=m
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
        
        public void imprimirArbol() {
            if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
            System.out.println(this.getData() + " ");
            if(this.hasRightChild()) this.getRightChild().imprimirArbol();
        }	
        
        /*
        public static void main (String[] args) {
            System.out.println("Test metodos Arboles");
            BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
            ab.addLeftChild(new BinaryTree<Integer>(2));
            ab.addRightChild(new BinaryTree<Integer>(6));
            ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
            ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
            ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
            //ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));

            System.out.println(ab.contarHojas());
            System.out.println("Arbol original: ");
            ab.imprimirArbol();
            System.out.println("Arbol espejo: ");
            BinaryTree<Integer> abEspejo = ab.espejo();
            abEspejo.imprimirArbol();
            System.out.println("Impresion Arbol por niveles 0, 1 y 2");
            ab.entreNiveles(0, 2);
        }
        */
}

