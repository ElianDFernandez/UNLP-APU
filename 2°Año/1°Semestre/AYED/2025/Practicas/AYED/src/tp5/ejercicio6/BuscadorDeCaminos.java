/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

/**
 *
 * @author Elian
 */
public class BuscadorDeCaminos {
    
    private Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public Graph<String> getBosque() {
        return bosque;
    }

    public void setBosque(Graph<String> bosque) {
        this.bosque = bosque;
    }
    
    public List<List<String>> recorridosMasSeguro() {
        List<List<String>> recorridos = new LinkedList<List<String>>();
        if (!this.bosque.isEmpty()) {
            Vertex origen = this.buscarOrigen();
            Vertex destino = this.buscarDestino();
            if (origen != null && destino != null) {
                recorridosMasSeguro(origen, destino, recorridos, new LinkedList<String>(), new boolean[this.bosque.getSize()]);
            }
        }
        
        return recorridos;
    }
    
    private Vertex<String> buscarOrigen(){
        for (Vertex<String> v : this.bosque.getVertices()) {
            if (v.getData().equals("Casa Caperucita")) {
                return v;
            }
        }
        
        return null;
    }
    
    private Vertex<String> buscarDestino() {
        for (Vertex<String> v : this.bosque.getVertices()) {
            if (v.getData().equals("Casa Abuelita")) {
                return v;
            }
        }
        
        return null;
    }
    
    // DFS
    private void recorridosMasSeguro(Vertex<String> origen, Vertex<String> destino, List<List<String>> recorridos, List<String> camAct, boolean [] marcas){
        marcas[origen.getPosition()] = true;
        camAct.add(origen.getData());
        if (origen.equals(destino)) {
            recorridos.add(new LinkedList<>(camAct));
        } else {
            List<Edge<String>> adyacentes = this.bosque.getEdges(origen);
            for (Edge<String> ad : adyacentes) {
                Vertex<String> v = ad.getTarget();
                if (!marcas[v.getPosition()]) {
                    marcas[v.getPosition()] = true;
                    recorridosMasSeguro(v, destino, recorridos, camAct, marcas);
                }
            } 
        }
        
        camAct.remove(camAct.size()-1);
        marcas[origen.getPosition()] = false;
    }
    
    public static void main (String[] args) {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 3");
        Vertex<String> v3 = bosque.createVertex("Claro 1");
        Vertex<String> v4 = bosque.createVertex("Claro 2");
        Vertex<String> v5 = bosque.createVertex("Claro 5");
        Vertex<String> v6 = bosque.createVertex("Claro 4");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");
        bosque.connect(v1, v2, 4);
        bosque.connect(v2, v1, 4);
        bosque.connect(v1, v3, 3);
        bosque.connect(v3, v1, 3);
        bosque.connect(v1, v4, 4);
        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v5, 15);
        bosque.connect(v5, v2, 15);
        bosque.connect(v3, v5, 3);
        bosque.connect(v5, v3, 3);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v4, v5, 11);
        bosque.connect(v5, v4, 11);
        bosque.connect(v4, v6, 10);
        bosque.connect(v6, v4, 10);
        bosque.connect(v4, v3, 4);
        bosque.connect(v3, v4, 4);
        bosque.connect(v5, v7, 4);
        bosque.connect(v7, v5, 4);
        bosque.connect(v6, v7, 9);
        bosque.connect(v7, v6, 9);
        BuscadorDeCaminos bos = new BuscadorDeCaminos(bosque);
        List<List<String>> lis = bos.recorridosMasSeguro();
        for(List<String> l: lis) {
            System.out.println(l);
        }
    }
}
