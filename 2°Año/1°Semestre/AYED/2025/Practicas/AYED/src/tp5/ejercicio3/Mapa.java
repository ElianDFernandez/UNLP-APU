package tp5.ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }
    
    /*-------------------------------------1-------------------------------------*/
    
    //La idea es devolver el primer camino encontrado, y recorrer con un while. No seria necesario devolver cada camino que se encuentre y usar un for.
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        // DFS hasta llegar a la cuidad2
        
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                devolverCamino(origen, destino, camino, new boolean[this.mapaCiudades.getSize()]);
            }
        }
        return camino;
    }
    
    private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino) {
            return true;
        } else {
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it1 = adyacentes.iterator();
            
            while (it1.hasNext() && !encontre){
                Vertex<String> v = it1.next().getTarget();
                int j = v.getPosition();
                if (!marcas[j]){
                    encontre = devolverCamino(v, destino, camino, marcas);
                }
            }
        }
        
        if (!encontre) {
            camino.remove(camino.size()-1);
        }
        
        marcas[origen.getPosition()] = false; //Deja desmarcadas todas las posiciones del vector de marcas: no es necesario desmarcar en este ejemplo.
        
        return encontre;
    }
    
    /*-------------------------------------2-------------------------------------*/
    
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean [] marcas = new boolean[this.mapaCiudades.getSize()];
                marcarVertices(marcas, ciudades);
                devolverCamino(origen, destino, camino, marcas);
            }
        }
        
        return camino;
    }
    
    private void marcarVertices(boolean[] marcas, List<String> ciudades) {
        for(String ciudad : ciudades) {
            Vertex c = this.mapaCiudades.search(ciudad);
            if (c != null) {
                marcas[c.getPosition()] = true;
            }
        }
    }
    
    /*-------------------------------------3-------------------------------------*/
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                caminoMasCorto(origen, destino, camino, new LinkedList<String>(), new boolean[this.mapaCiudades.getSize()], 0, Integer.MAX_VALUE);
            }
        }
        
        return camino;
    }
    
    
    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> camino, List<String> caminoActual, boolean [] marcas, int total, int min){
        marcas[origen.getPosition()] = true;
        caminoActual.add(origen.getData());
        if (origen == destino && total < min) {
            camino.removeAll(camino);
            camino.addAll(caminoActual);
            min = total;
        } else {
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> ad = adyacentes.iterator();
            while (ad.hasNext() && total < min) {
                Edge<String> v = ad.next();
                int j = v.getTarget().getPosition();
                int aux = total + v.getWeight();
                if (!marcas[j] && aux < min){ 
                    min = caminoMasCorto(v.getTarget(), destino, camino, caminoActual, marcas, aux, min);
                }
            }
        }
        
        marcas[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size()-1);
        
        return min;
    }
    
    /*-------------------------------------4-------------------------------------*/
    
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque) {
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                caminoSinCargarCombustible(origen, destino, camino, new boolean[this.mapaCiudades.getSize()], tanque);
            }
        }
        
        return camino;
    }
    
    private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean [] marcas, int tanque) {
        boolean encontre = false;
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino) {
            return true;
        } else {
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = adyacentes.iterator();
            
            while (it.hasNext() && !encontre) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                if (!marcas[j] && (tanque >= e.getWeight()) ) {
                    encontre = caminoSinCargarCombustible(e.getTarget(), destino, camino, marcas, tanque - e.getWeight());
                }
            }
        }
        
        if (!encontre) {
            camino.remove(camino.size()-1);
        }
        
        marcas[origen.getPosition()] = false;
        
        return encontre;
    }
    
    /*-------------------------------------5-------------------------------------*/
    
    public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueMax){
        List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudad1);
            Vertex destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                caminoConMenorCargaCombustible(origen, destino, camino, new LinkedList<String>(),new boolean[this.mapaCiudades.getSize()], tanqueMax, tanqueMax, 0, Integer.MAX_VALUE);
            }
        }
        
        return camino;
    }
    
    
    private int caminoConMenorCargaCombustible(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, List<String> caminoAct, boolean[] marcas, int tanqueMax, int tanqueAct, int recargas, int recargasMin) {
        marcas[origen.getPosition()] = true;
        caminoAct.add(origen.getData());
        if (origen == destino && recargas < recargasMin) {
            caminoMinimo.removeAll(caminoMinimo);
            caminoMinimo.addAll(caminoAct);
            recargasMin = recargas;
        } else {
            List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
            Iterator<Edge<String>> it = adyacentes.iterator();
            
            while (it.hasNext() && recargas < recargasMin) {
                Edge<String> a = it.next();
                int j = a.getTarget().getPosition();
                if (!marcas[j]) {
                    if (tanqueAct >= a.getWeight()) {
                        recargasMin = caminoConMenorCargaCombustible(a.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanqueMax, tanqueAct - a.getWeight(), recargas, recargasMin);
                    } else if (tanqueMax >= a.getWeight()) {
                        recargasMin = caminoConMenorCargaCombustible(a.getTarget(), destino, caminoMinimo, caminoAct, marcas, tanqueMax, tanqueMax - a.getWeight(), recargas + 1, recargasMin);
                    }
                }
            }
        }
        caminoAct.remove(caminoAct.size()-1);
        marcas[origen.getPosition()] = false;
        
        return recargasMin;
    }
    
    
    /*-------------------------------------Camino mas largo para x cantidad de peso-------------------------------------*/
    
    public List<String> caminoMasLargoSinCargarCombustible(String ciudadInicio, int tanque) {
        List<String> mejorCamino = new LinkedList<>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex origen = this.mapaCiudades.search(ciudadInicio);
            if (origen != null) {
                List<String> caminoActual = new LinkedList<>();
                boolean[] visitadas = new boolean[this.mapaCiudades.getSize()];
                caminoMasLargoDFS(origen, caminoActual, visitadas, tanque, mejorCamino);
            }
        }
        return mejorCamino;
    }

    private void caminoMasLargoDFS(Vertex<String> actual, List<String> caminoActual, boolean[] visitadas, int tanqueRestante, List<String> mejorCamino) {
        visitadas[actual.getPosition()] = true;
        caminoActual.add(actual.getData());

        // Si el camino actual es más largo que el mejor encontrado, lo actualizamos
        if (caminoActual.size() > mejorCamino.size()) {
            mejorCamino.clear();
            mejorCamino.addAll(new LinkedList<>(caminoActual));
        }

        List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(actual);
        for (Edge<String> e : adyacentes) {
            Vertex<String> vecino = e.getTarget();
            int peso = e.getWeight();
            if (!visitadas[vecino.getPosition()] && tanqueRestante >= peso) {
                caminoMasLargoDFS(vecino, caminoActual, visitadas, tanqueRestante - peso, mejorCamino);
            }
        }

        // Backtrack
        caminoActual.remove(caminoActual.size() - 1);
        visitadas[actual.getPosition()] = false;
    }
    
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(mapa.devolverCamino("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.print(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.print(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.print(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 60));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
        System.out.print(mapa.caminoConMenorCargaCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");
    }
 }
