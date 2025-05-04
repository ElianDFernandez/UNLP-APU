package tp3.ejercicio4;

import tp3.GeneralTree;

public class AnalizadorArbol {
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa>arbol) {
        if (arbol.isEmpty()) {
            return 0;
        }
        double maxRetardo = 0;
        for (GeneralTree<AreaEmpresa> child : arbol.getChildren()) {
            maxRetardo = Math.max(maxRetardo, this.devolverMaximoPromedio(child));
        }

        return arbol.getData().getTtm() + maxRetardo;
    }
    
}
