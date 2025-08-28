package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Recorridos <T>{
    
   //O(V+E) V: numero de vertices y E: numero de aristas
   public List<T> dfs(Graph<T> grafo) {
       boolean[] marca = new boolean[grafo.getSize()];
       List<T> lis = new LinkedList<T>();
       for(int i = 0; i < grafo.getSize(); i++) {
           if (!marca[i]) {
               dfs(i, grafo, lis, marca);
           }
       }
       return lis;
   } 
   
   private void dfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
       marca[i] = true;
       Vertex<T> v = grafo.getVertex(i);
       lis.add(v.getData());
       List<Edge<T>> adyacentes = grafo.getEdges(v);
       for (Edge<T> e : adyacentes) {
           int j = e.getTarget().getPosition();
           if (!marca[j]) {
               dfs(j, grafo, lis, marca);
           }
       }
   }
   
   public List<T> bfs(Graph<T> grafo) {
       boolean [] marca = new boolean[grafo.getSize()];
       List<T> lis = new LinkedList<T>();
       for (int i=0; i<grafo.getSize(); i++) {
           if (!marca[i]) {
               bfs(i,grafo,lis,marca);
           }
       }
       
       return lis;
   }
   
   private void bfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
       Queue<Vertex<T>> q = new Queue<Vertex<T>>();
       q.enqueue(grafo.getVertex(i));
       marca[i] = true;
       while (!q.isEmpty()) {
           Vertex<T> v = q.dequeue();
           lis.add(v.getData());
           List<Edge<T>> adyacentes = grafo.getEdges(v);
           for(Edge<T> e : adyacentes) {
               int j = e.getTarget().getPosition();
               if(!marca[j]) {
                   marca[j] = true;
                   q.enqueue(grafo.getVertex(j));
               }
           }
       }
   }
   
    public static void main(String[] args) {
        Graph<String> ciudades = new AdjListGraph<String>();
        Recorridos<String> rec = new Recorridos<String>();
        Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
        Vertex<String> v2 = ciudades.createVertex("Santiago");
        Vertex<String> v3 = ciudades.createVertex("Asunción");
        Vertex<String> v4 = ciudades.createVertex("Tokio");
        Vertex<String> v5 = ciudades.createVertex("Roma");
        Vertex<String> v6 = ciudades.createVertex("Paris");
        Vertex<String> v7 = ciudades.createVertex("Madrid");
        Vertex<String> v8 = ciudades.createVertex("Caracas");
        ciudades.connect(v1, v2);
        ciudades.connect(v1, v3);
        ciudades.connect(v2, v5);
        ciudades.connect(v3, v7);
        ciudades.connect(v3, v8);
        ciudades.connect(v8, v7);
        ciudades.connect(v8, v4);
        ciudades.connect(v5, v4);
        ciudades.connect(v7, v4);
        ciudades.connect(v6, v5);
        ciudades.connect(v6, v7);
        ciudades.connect(v6, v4);
        ciudades.connect(v4, v1);

        List<String> lisDFS = rec.dfs(ciudades);
        List<String> lisBFS = rec.bfs(ciudades);

        System.out.print("Lista DFS: ");
        for (String e: lisDFS){
            System.out.print(e + " ~ ");
        }

        System.out.println("");

        System.out.print("Lista BFS: ");
        for (String e: lisBFS){
            System.out.print(e + " ~ ");
        }
    }
}
