# Depth First Search (DFS) -> Recorrido en profundidad
Generalizacion del recorrido PRE-ORDER para grafos.

**Estrategia:**
1. Se parte de un nodo inicial (origen).
2. Se marca el nodo como visitado.
3. Se exploran todos los nodos adyacentes no visitados, aplicando recursivamente el mismo procedimiento.
4. Si un nodo no tiene nodos adyacentes no visitados, se retrocede al nodo anterior y se continúa con los nodos restantes.
5. El proceso continúa hasta que todos los nodos alcanzables desde el nodo inicial hayan sido visitados.

**Implementación:**
```java
    public List<T> dfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lista = new LinkedList<T>(); 
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                dfs(i, grafo, lista, marca);
            }
        }
        return lis;
    }

    private void dfs(int i, Graph<T> grafo, List<T> lista, boolean[] marca) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        lista.add(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v); 
        for (Edge<T> e: adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, lista, marca);
            }
        }
    }
```

**Complejidad:**
- Tiempo: O(V + E), donde V es el número de vértices y E es el número de aristas en el grafo.

**Problemas comunes en el cual se utiliza DFS:**
- Búsqueda de caminos en laberintos.
- Detección de ciclos en grafos dirigidos y no dirigidos.
- Ordenamiento topológico de grafos dirigidos acíclicos (DAG).
- Encontrar componentes conexas en grafos no dirigidos.

# Breadth First Search (BFS) -> Recorrido en anchura
Generalizacion del recorrido por nivel para grafos.

**Estrategia:**
1. Se parte de un nodo inicial (origen).
2. Se marca el nodo como visitado y se encola.
3. Mientras la cola no esté vacía:
   - Se desencola un nodo de la cola.
   - Se exploran todos los nodos adyacentes no visitados, marcándolos como visitados y encolándolos.
4. El proceso continúa hasta que todos los nodos alcanzables desde el nodo inicial hayan sido visitados.

**Implementación:**
```java
    public List<T> bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        List<T> lis = new LinkedList<T>(); 
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!marca[i]) {
                bfs(i, grafo, lis, marca);
            }
        }
        return lis;
    }

    private void bfs(int i, Graph<T> grafo, List<T> lis, boolean[] marca) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            lis.add(w.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e: adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    q.enqueue(e.getTarget());
                }
            }
        }
    }
```