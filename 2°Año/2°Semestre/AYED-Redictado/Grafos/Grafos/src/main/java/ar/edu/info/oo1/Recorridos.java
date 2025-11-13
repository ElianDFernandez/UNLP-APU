/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ar.edu.info.oo1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class Recorridos<T>{

    public List<T> dfs(Graph<T> grafo) {
        boolean[] marcas = new boolean[grafo.getSize()];
        List<T> lista = new LinkedList<>();
        for(int i = 0; i < grafo.getSize(); i++) {
            if (!marcas[i]) {
                dfs(i,grafo,lista,marcas);
            }
        }
        return lista;
    } 
    
    private void dfs(int i, Graph<T> grafo, List<T> lista, boolean[] marcas) {
        marcas[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        // Aca se procesa el vertice actual con lo que sea neceario
        lista.add(v.getData());
        for(Edge<T> arista : grafo.getEdges(v)) {
            int j = arista.getTarget().getPosition();
            if(!marcas[j]) {
                dfs(j,grafo,lista,marcas);
            }
        }
    }
    
    public List<T> bfs(Graph<T> grafo) {
        boolean[] marcas = new boolean[grafo.getSize()];
        List<T> lista = new LinkedList<T>();
        for(int i = 0; i<grafo.getSize(); i++){
            bfs(i,grafo,lista,marcas);
        } 
        
        return lista;
    }
    
    private void bfs(int i, Graph<T> grafo, List<T> lista, boolean[] marcas) {
        marcas[i] = true;
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        while(!cola.isEmpty()) {
            Vertex<T> v = cola.dequeue();
            // Aca se procesa el vertice actual con lo que sea neceario
            lista.add(v.getData());
            for(Edge<T> adyacente : grafo.getEdges(v)) {
                int j = adyacente.getTarget().getPosition();
                if (!marcas[j]){
                    marcas[j] = true;
                    cola.enqueue(adyacente.getTarget());
                }
            }
        }
    }
}
