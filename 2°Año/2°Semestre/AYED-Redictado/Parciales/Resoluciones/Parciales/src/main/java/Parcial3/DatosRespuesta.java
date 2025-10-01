package Parcial3;

import ClasesUtiles.BinaryTree;
import java.util.List;

public class DatosRespuesta {
    private List<BinaryTree<Integer>> primerCondicion;
    private Integer segundaCondicion;

    public DatosRespuesta(List<BinaryTree<Integer>> primerCondicion, Integer segundaCondicion) {
        this.primerCondicion = primerCondicion;
        this.segundaCondicion = segundaCondicion;
    }

    public int getPrimerCondicion() {
        return primerCondicion.size();
    }

    public void setPrimerCondicion(BinaryTree<Integer> arbol) {
        this.primerCondicion.add(arbol);
    }

    public Integer getSegundaCondicion() {
        return segundaCondicion;
    }

    public void addSegundaCondicion() {
        this.segundaCondicion++;
    }
    
    
}
