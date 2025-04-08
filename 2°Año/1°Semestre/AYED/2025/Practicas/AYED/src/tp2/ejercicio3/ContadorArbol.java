package tp2.ejercicio3;

import java.util.ArrayList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List numerosParesInOrden(){
        List<Integer> pares = new ArrayList();        
        this.numeroParesRecursivoInOrden(this.arbol, pares);
        return pares;
    }
    
    public List numerosParesPostOrden(){
        List<Integer> pares = new ArrayList();        
        this.numeroParesRecursivoPostOrden(this.arbol, pares);
        return pares;
    }
    
    public List numerosParesPreOrden(){
        List<Integer> pares = new ArrayList();        
        this.numeroParesRecursivoPreOrden(this.arbol, pares);
        return pares;
    }
    
    // InOrden
    public void numeroParesRecursivoInOrden(BinaryTree<Integer> arbol, List<Integer> pares)
    {
        if (arbol != null) {
            numeroParesRecursivoInOrden(arbol.getLeftChild(),pares);
            int num = arbol.getData();
            if (num % 2 == 0) {
                pares.add(num);
            }
            numeroParesRecursivoInOrden(arbol.getRightChild(),pares);
        }
    }
    
    // PostOrden
    public void numeroParesRecursivoPostOrden(BinaryTree<Integer> arbol, List<Integer> pares)
    {
        if (arbol != null) {
            numeroParesRecursivoPostOrden(arbol.getLeftChild(),pares);
            numeroParesRecursivoPostOrden(arbol.getRightChild(),pares);
            int num = arbol.getData();
            if (num % 2 == 0) {
                pares.add(num);
            }
        }
    }
    
    // PreOrden
    public void numeroParesRecursivoPreOrden(BinaryTree<Integer> arbol, List<Integer> pares) {
        if (arbol != null) {
            int num = arbol.getData();
            if (num % 2 == 0) {
                pares.add(num);
            }
            numeroParesRecursivoPreOrden(arbol.getLeftChild(), pares);
            numeroParesRecursivoPreOrden(arbol.getRightChild(), pares);
        }
    }
}
