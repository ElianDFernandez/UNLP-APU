package Parcial3;

import ClasesUtiles.BinaryTree;
import java.util.LinkedList;

public class ProcesadorDeArbol {
    
    // Solo en public para test mas facil
    public BinaryTree<Integer> arbol;
    
    public DatosRespuesta procesar () {
        DatosRespuesta respuesta = new DatosRespuesta(new LinkedList<BinaryTree<Integer>>(), 0);
        
        procesar(this.arbol, respuesta);
        
        return respuesta;
    }
    
    private void procesar(BinaryTree<Integer> arbol, DatosRespuesta respuesta) {
        if (arbol.getData() % 2 == 0) {
            respuesta.addSegundaCondicion();
            if (arbol.hasLeftChild() && arbol.hasRightChild()) {
                respuesta.setPrimerCondicion(arbol);
            }
        }
        if (arbol.hasLeftChild()) {
            procesar(arbol.getLeftChild(), respuesta);
        }
        if (arbol.hasRightChild()) {
            procesar(arbol.getRightChild(), respuesta);
        }
    }
}
