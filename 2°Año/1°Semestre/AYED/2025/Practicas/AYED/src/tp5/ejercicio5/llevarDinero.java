/*
El Banco Itaú se suma a las campañas "QUEDATE EN CASA" lanzando un programa para acercar el sueldo a los
jubilados hasta sus domicilios. Para ello el banco cuenta con información que permite definir un grafo de
personas donde la persona puede ser un jubilado o un empleado del banco que llevará el dinero.
Se necesita armar la cartera de jubilados para cada empleado repartidor del banco, incluyendo en cada lista, los
jubilados que vivan un radio cercano a su casa y no hayan percibido la jubilación del mes.
Para ello, implemente un algoritmo que dado un Grafo<Persona> retorne una lista de jubilados que se
encuentren a una distancia menor a un valor dado del empleado Itaú (grado de separación del empleado Itaú).
El método recibirá un Grafo<Persona>, un empleado y un grado de separación/distancia y debe retornar una
lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
recibido como parámetro.
 */
package tp5.ejercicio5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class llevarDinero {
    public List<Persona> llevarDinero(Graph<Persona> grafo, Persona persona, int distancia) {
        List<Persona> cartera = new ArrayList<>();
        Vertex<Persona> origen = grafo.search(persona);
        if (origen != null) {
            Queue <Vertex<Persona>> c = new Queue<Vertex<Persona>>();
            boolean [] marcas = new boolean[grafo.getSize()];
            c.enqueue(origen);
            c.enqueue(null);
            while (!c.isEmpty() && distancia > 0 && cartera.size() < 40) {
                Vertex<Persona> v = c.dequeue();
                if (v!= null) {
                    List<Edge<Persona>> adyacentes = grafo.getEdges(v);
                    Iterator <Edge<Persona>> it = adyacentes.iterator();
                    while (it.hasNext() && cartera.size() < 40) {
                        Vertex<Persona> vertDestino = it.next().getTarget();
                        int j = vertDestino.getPosition();
                        if (!marcas[j]) {
                            marcas[j] = true;
                            c.enqueue(vertDestino);
                            if (vertDestino.getData().esJubilado()) {
                                cartera.add(vertDestino.getData());
                            }
                        }
                    }
                } else if (!c.isEmpty()) {
                    distancia--;
                    c.enqueue(null);
                }
            }
        }
        
        return cartera;
    }
    
    public static void main(String[] args) {
        Graph<Persona> grafo = new AdjListGraph<>();
        Persona Persona1 = new Persona("Empleado", "Matias", "AAA");
        Vertex v1 = grafo.createVertex(Persona1);
        Vertex v2 = grafo.createVertex(new Persona("Jubilado", "Julian", "BBB"));
        Vertex v3 = grafo.createVertex(new Persona("Jubilado", "Francisco", "CCC"));
        Vertex v4 = grafo.createVertex(new Persona("Empleado", "Valentin", "DDD"));
        Vertex v5 = grafo.createVertex(new Persona("Jubilado", "Omar", "EEE"));
        Vertex v6 = grafo.createVertex(new Persona("Empleado", "Rosana", "FFF"));
        Vertex v7 = grafo.createVertex(new Persona("Jubilado", "Maria", "GGG"));
        Vertex v8 = grafo.createVertex(new Persona("Jubilado", "Sandra", "HHH"));
        Vertex v9 = grafo.createVertex(new Persona("Jubilado", "Matheo", "III"));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        
        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);
        
        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);
        
        
        llevarDinero banco = new llevarDinero();
        
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 1, 40));
        System.out.println(banco.llevarDinero(grafo,Persona1 , 2));
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 3, 40));
        
        //System.out.println(banco.carteraJubilados(grafo, "Rosana", 2, 40));
        
        //System.out.println(banco.carteraJubilados(grafo, "Matias", 2, 1));
    }
}
