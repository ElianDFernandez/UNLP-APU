package Practica3.Ejercicio4;

import Practica1.Ejercicio8.Queue;
import Practica3.Ejercicio1y3y5.GeneralTree;
import static RepasosVarios.AnalizadorArbol.devolverMaximoPromediio;

public class AnalizadorArbol {
    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol){
        if (arbol.isEmpty()){
            return 0;
        }
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<>();
        GeneralTree<AreaEmpresa> aux;
        double max = -1;
        double sum=0;
        int cantNodo = 0;
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                // PROCESAMIENTO DE UN NIVEL
                cantNodo++;
                sum += aux.getData().getTardanza();
                for (GeneralTree<AreaEmpresa> child: aux.getChildren()){
                    cola.enqueue(child);
                }
            } 
            else if (!cola.isEmpty()) {
                // TERMINE PROXIMA VUELTA OTRO NIVEL
                sum = sum/cantNodo;
                max = Math.max(max, sum);
                cola.enqueue(null);
                cantNodo=0;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        AreaEmpresa rootData = new AreaEmpresa("Root", 10);
        GeneralTree<AreaEmpresa> root = new GeneralTree<>(rootData);

        AreaEmpresa child1Data = new AreaEmpresa("Child1", 20);
        GeneralTree<AreaEmpresa> child1 = new GeneralTree<>(child1Data);
        root.addChild(child1);

        AreaEmpresa child2Data = new AreaEmpresa("Child2", 5);
        GeneralTree<AreaEmpresa> child2 = new GeneralTree<>(child2Data);
        root.addChild(child2);

        AreaEmpresa child3Data = new AreaEmpresa("Child3", 15);
        GeneralTree<AreaEmpresa> child3 = new GeneralTree<>(child3Data);
        child1.addChild(child3);

        double maxPromedio = devolverMaximoPromediio(root);
        System.out.println("El máximo promedio de tardanza es: " + maxPromedio);
    }
}
