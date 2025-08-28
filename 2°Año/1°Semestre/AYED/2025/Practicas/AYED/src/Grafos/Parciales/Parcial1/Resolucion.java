package Grafos.Parciales.Parcial1;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author Elian
 */
public class Resolucion {
    public List<String>estadios(Graph<Estadio> mapaEstadios, String origen, int cantKm) {
        List<String> mayorRecorrido = new LinkedList<>();
        if (!mapaEstadios.isEmpty()) {
            Vertex verticeOrigen = buscarVerticePorNombre(mapaEstadios, origen);
            if (verticeOrigen != null) {
                List<String> caminoActual = new LinkedList<>();
                boolean[] visitadas = new boolean[mapaEstadios.getSize()];
                caminoMasLargoDFS(mapaEstadios, verticeOrigen, caminoActual, mayorRecorrido, visitadas, cantKm);
            }
        }
       return mayorRecorrido;
    }
    
    private void caminoMasLargoDFS(Graph<Estadio> mapaEstadios, Vertex<Estadio> origen, List<String> caminoActual, List<String> mayorRecorrido, boolean[] visitadas, int cantKm){
        visitadas[origen.getPosition()] = true;
        caminoActual.add(origen.getData().getNombre());
        
        // Si camino actual es mayor al recorrido anterior acutalizar 
        if (caminoActual.size() > mayorRecorrido.size()) {
            mayorRecorrido.clear();
            mayorRecorrido.addAll(new LinkedList<>(caminoActual));
        }
        
        List<Edge<Estadio>> adyacentes = mapaEstadios.getEdges(origen);
        for (Edge<Estadio> e : adyacentes) {
            Vertex<Estadio> vecino = e.getTarget();
            int peso = e.getWeight();
            if (!visitadas[vecino.getPosition()] && cantKm >= peso) {
                caminoMasLargoDFS(mapaEstadios, vecino, caminoActual, mayorRecorrido, visitadas, cantKm - peso);
            }
        }
        
        caminoActual.remove(caminoActual.size()-1);
        visitadas[origen.getPosition()] = false;
    }
    
    private Vertex<Estadio> buscarVerticePorNombre (Graph<Estadio> mapaEstadios, String nombre) {
        for (Vertex<Estadio> v : mapaEstadios.getVertices()) {
            if (v.getData().getNombre().equals(nombre)) {
                return v;
            }
        }
        
        return null;
    }
}

