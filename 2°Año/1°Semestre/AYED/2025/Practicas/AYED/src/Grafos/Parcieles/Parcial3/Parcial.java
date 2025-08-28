package Grafos.Parcieles.Parcial3;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    // Se pide maxima cantidad de recintos posibles dentro del tiempo que disponen.
    
    // Primer manera de resolverlo, no tan eficiente ya que guardas una lista, es simplemente busacar el camino maximo, es decir la cantidad 
    
    /*
    public int resolver(Graph<Recinto> sitios, int tiempo) {
        List<String> ruta = new LinkedList<>();
        if (!sitios.isEmpty() && tiempo > 0) {
            Vertex<Recinto> entrada = buscarEntrada(sitios, "Entrada");
            if (entrada.getData().getTiempo() <= tiempo) {
                dfs(sitios, entrada, ruta, new LinkedList<String>(), new boolean[sitios.getSize()], tiempo - entrada.getData().getTiempo());
            }
        }
        
        return ruta.size();
    }
    
    private Vertex<Recinto> buscarEntrada(Graph<Recinto> sitios, String nombre) {
        List<Vertex<Recinto>> vertices = sitios.getVertices();
        for(Vertex<Recinto> v : vertices) {
            if (v.getData().getNombre().equals(nombre)) {
                return v;
            }
        }
        
        return null;
    }
    
    
    private void dfs(Graph<Recinto> sitios, Vertex<Recinto> vertice, List<String> ruta, List<String> caminoActual, boolean[] marcas, int cantTiempo) {
        caminoActual.add(vertice.getData().getNombre());
        marcas[vertice.getPosition()] = true;
        
        if (caminoActual.size() > ruta.size()) {
            ruta.clear();
            ruta.addAll(caminoActual);
        }
        
        for(Edge<Recinto> ady : sitios.getEdges(vertice)) {
            Vertex<Recinto> destino = ady.getTarget();
            int j = destino.getPosition();
            int pesoTotal = destino.getData().getTiempo() + ady.getWeight();
            if (!marcas[j] && pesoTotal < cantTiempo) {
                dfs(sitios, destino, ruta, caminoActual, marcas, cantTiempo - pesoTotal);
            }
        }
        
        marcas[vertice.getPosition()] = false;
        caminoActual.remove(caminoActual.size()-1);
    }
    */
    
    public int resolver(Graph<Recinto> sitios, int tiempo) {
        int cant = 0;
        if (!sitios.isEmpty() && tiempo > 0) {
            Vertex<Recinto> entrada = buscarEntrada(sitios, "Entrada");
            if (entrada != null && entrada.getData().getTiempo() <= tiempo) {
                cant = dfs(sitios, entrada, 1, 1, new boolean[sitios.getSize()], tiempo - entrada.getData().getTiempo());
            }
        }
        
        return cant;
    }
    
    private Vertex<Recinto> buscarEntrada(Graph<Recinto> sitios, String nombre) {
        List<Vertex<Recinto>> vertices = sitios.getVertices();
        for(Vertex<Recinto> v : vertices) {
            if (v.getData().getNombre().equals(nombre)) {
                return v;
            }
        }
        
        return null;
    }
    
    private int dfs(Graph<Recinto> sitios, Vertex<Recinto> vertice, int cantMax, int cantAct, boolean[] marcas, int cantTiempo) {
        marcas[vertice.getPosition()] = true;
        for(Edge<Recinto> ady : sitios.getEdges(vertice)) {
            Vertex<Recinto> destino = ady.getTarget();
            int j = destino.getPosition();
            int pesoTotal = destino.getData().getTiempo() + ady.getWeight();
            if (!marcas[j] && pesoTotal <= cantTiempo) {
                cantMax = dfs(sitios, destino, cantMax, cantAct+1, marcas, cantTiempo - pesoTotal);
            }
        }
        
        marcas[vertice.getPosition()] = false;
        cantMax = Math.max(cantMax, cantAct);
        
        return cantMax;
    }
    
    public static void main(String args[]) {
        Graph<Recinto> grafo = new AdjListGraph<Recinto>();
        Vertex<Recinto> Entrada = grafo.createVertex(new Recinto("Entrada", 15));
        Vertex<Recinto> Cebras = grafo.createVertex(new Recinto("Cebras", 10));
        Vertex<Recinto> Tigres = grafo.createVertex(new Recinto("Tigres", 10));
        Vertex<Recinto> Flamencos = grafo.createVertex(new Recinto("Flamencos", 10));
        Vertex<Recinto> Murcielagos = grafo.createVertex(new Recinto("Murciélagos", 20));
        Vertex<Recinto> Wallabies = grafo.createVertex(new Recinto("Wallabies", 30));
        Vertex<Recinto> Tortugas = grafo.createVertex(new Recinto("Tortugas", 10));
        Vertex<Recinto> Pumas = grafo.createVertex(new Recinto("Pumas", 10));
        
        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);
        
        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 7));
    }
}
