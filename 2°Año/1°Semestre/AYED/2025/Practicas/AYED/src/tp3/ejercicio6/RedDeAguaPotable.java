/*
Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo
sucesivamente hasta llegar a cada una de las casas.
Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo
con las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas. Es
decir, si un caño maestro recibe 1000 litros y tiene por ejemplo 4 bifurcaciones se divide en 4 partes
iguales, donde cada división tendrá un caudal de 250 litros.
Luego, si una de esas divisiones se vuelve a dividir, por ej. en 5 partes, cada una tendrá un caudal de
50 litros y así sucesivamente hasta llegar a un lugar sin bifurcaciones.
Se debe implementar una clase RedDeAguaPotable que contenga el método con la siguiente firma:
public double minimoCaudal(double caudal)
que calcule el caudal de cada nodo y determine cuál es el caudal mínimo que recibe una casa. Asuma
que la estructura de caños de la red está representada por una variable de instancia de la clase
RedAguaPotable y que es un GeneralTree<Character>.
Extendiendo el ejemplo en el siguiente gráfico, al llamar al método minimoCaudal con un valor de
1000.0 debería retornar 25.0
 */
package tp3.ejercicio6;

import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

/**
 *
 * @author Elian
 */
public class RedDeAguaPotable {
    
    private GeneralTree<Character> arbol;

    public RedDeAguaPotable(GeneralTree<Character> arbol) {
        this.arbol = arbol;
    }
    
    public double minimoCaudal(double caudalEntrada) {
        double min = 0.0;
        if (caudalEntrada <= 0.0) return min;
        return minimoCaudalRecorrido(arbol, caudalEntrada);
    }
    
    private double minimoCaudalRecorrido(GeneralTree<Character> arbol, Double entrada) {
        if (arbol.isLeaf()) {
            return entrada;
        } else {
            int bifurcaciones = arbol.getChildren().size();
            double caudalResultante = entrada / bifurcaciones;
            double minimo = Double.MAX_VALUE;
            
            for(GeneralTree<Character> hijo : arbol.getChildren()) {
                double caudalHijo = minimoCaudalRecorrido(hijo, caudalResultante);
                if (caudalHijo < minimo) {
                    minimo = caudalHijo;
                }
            }
            return minimo;
        } 
    }
        
    public static void main(String[]args) {
        // Ejemplo de uso
        GeneralTree<Character> arbol = new GeneralTree<>('M');
        GeneralTree<Character> nodoA = new GeneralTree<>('A');
        GeneralTree<Character> nodoB = new GeneralTree<>('B');
        GeneralTree<Character> nodoC = new GeneralTree<>('C');
        GeneralTree<Character> nodoD = new GeneralTree<>('D');
        GeneralTree<Character> nodoE = new GeneralTree<>('E');
        GeneralTree<Character> nodoF = new GeneralTree<>('F');
        GeneralTree<Character> nodoG = new GeneralTree<>('G');
        GeneralTree<Character> nodoH = new GeneralTree<>('H');
        
        arbol.addChild(nodoA);
        arbol.addChild(nodoB);
        nodoA.addChild(nodoC);
        nodoA.addChild(nodoD);
        nodoB.addChild(nodoE);
        nodoB.addChild(nodoF);
        nodoC.addChild(nodoG);
        nodoC.addChild(nodoH);
        nodoC.addChild(nodoB);
        nodoC.addChild(nodoE);
        
        /*
                M
               / \
             A     B
            / \   / \
           C   D E   F
         /| |\
        G H B E
        */


        RedDeAguaPotable red = new RedDeAguaPotable(arbol);
        double caudalMinimo = red.minimoCaudal(1000.0);
        System.out.println("El caudal mínimo que recibe una casa es: " + caudalMinimo + " litros.");
    }
}
