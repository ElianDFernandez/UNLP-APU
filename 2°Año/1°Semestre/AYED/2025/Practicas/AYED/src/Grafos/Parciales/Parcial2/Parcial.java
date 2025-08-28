
package Grafos.Parciales.Parcial2;

import Parciales.Parcial1.Ciudad;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    public List <String> resolver (Graph<Ciudad> mapa, String ciudad, int cantDiasVacas) {
        List<String> ruta = new LinkedList<String>();
        if (!mapa.isEmpty()) {
            Vertex<Ciudad> origen = buscar(mapa, ciudad);
            if (origen != null) {
                int dias = origen.getData().getDias();
                if (cantDiasVacas >= dias) {
                    dfs(mapa, cantDiasVacas - dias, origen, ruta, new LinkedList<String>(), new boolean[mapa.getSize()]);
                }
            } 
        }
        return ruta;
    }
    
    private Vertex<Ciudad> buscar (Graph<Ciudad> mapa, String ciudad) {
        List<Vertex<Ciudad>> ciudades = mapa.getVertices();
        for(Vertex<Ciudad> c : ciudades) {
            if (c.getData().getNombre().equals(ciudad)) {
                return c;
            }
        }
        return null;
    }
    
    private void dfs (Graph<Ciudad> mapa, int cantDias, Vertex<Ciudad> vertice, List<String> caminoMax, List<String> caminoActual, boolean[] marcas) {
        caminoActual.add(vertice.getData().getNombre());
        marcas[vertice.getPosition()] = true;
        if (cantDias == 0) {
            if (caminoActual.size() > caminoMax.size()) {
                caminoMax.clear();
                caminoMax.addAll(caminoActual);
            }
        } else {
            for (Edge<Ciudad> ady : mapa.getEdges(vertice)) {
                Vertex<Ciudad> destino = ady.getTarget();
                int j = destino.getPosition();
                int peso = destino.getData().getDias();
                if (!marcas[j] && cantDias >= peso) {
                    dfs(mapa, cantDias - peso, destino, caminoMax, caminoActual, marcas);
                }
            }
        }
        
        caminoActual.remove(caminoActual.size()-1);
        marcas[vertice.getPosition()]=false;
    }
    
}