/* Ejercicio 3
1. devolverCamino (String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
vacía. (Sin tener en cuenta el combustible).
3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
existe camino retorna la lista vacía. (Las rutas poseen la distancia).
4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
retorna la lista vacía. */
package Ejercicio3;

import ar.edu.info.oo1.Edge;
import ar.edu.info.oo1.Graph;
import ar.edu.info.oo1.Vertex;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class java {
    private Graph<String> mapa;
    
    /*
    1. devolverCamino (String ciudad1, String ciudad2): List<String>
    Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
    pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
    */
    
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> camino = new LinkedList<>();
        if (!this.mapa.isEmpty()){
            Vertex origen = this.mapa.search(ciudad1);
            Vertex destino = this.mapa.search(ciudad2);
            if(origen != null && destino != null) {
                boolean [] marcas = new boolean [this.mapa.getSize()];
                devolverCamino(origen, destino, camino, marcas);
            }
        }
        
        return camino;
    }
    
    private boolean devolverCamino(Vertex<String>origen, Vertex<String> destino, List<String> camino, boolean[]marcas){
        boolean encontre = true;
        marcas[origen.getPosition()]=true;
        camino.add(origen.getData());
        if(origen == destino) {
            return true;
        } else {
            List<Edge<String>> ady = this.mapa.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre) {
                Vertex<String> v = it.next().getTarget();
                int j = v.getPosition();
                if (!marcas[j]) {
                    encontre = devolverCamino(v,destino,camino,marcas);
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1);
        }
        marcas[origen.getPosition()] = false;
        
        return encontre;
    }
    
    /*
    2. devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades): List<String>
    Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
    que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
    vacía. (Sin tener en cuenta el combustible).
    */
    
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
        List<String> camino = new LinkedList<>();
        if (!this.mapa.isEmpty()){
            Vertex<String> origen = this.mapa.search(ciudad1);
            Vertex<String> destino = this.mapa.search(ciudad2);
            if (origen != null && destino != null) {
                boolean [] marcas = new boolean[this.mapa.getSize()];
                marcarRestringidos(marcas, ciudades);
                devolverCamino2(origen,destino,camino,marcas);
            }
        }
        
        return camino;
    }
    
    private void marcarRestringidos(boolean [] marcas, List<String> ciudades){
        for(String ciudad : ciudades) {
            Vertex<String> v = this.mapa.search(ciudad);
            if(v != null) {
                marcas[v.getPosition()] = true;
            }
        }
    }
    
    private boolean devolverCamino2(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marcas){
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        boolean encontre = true;
        if (origen == destino) {
            return true;
        } else {
            List<Edge<String>> ady = this.mapa.getEdges(origen);
            Iterator<Edge<String>> it = ady.iterator();
            while(it.hasNext() && encontre) {
                Vertex<String> v = it.next().getTarget();
                int j = v.getPosition();
                if(!marcas[j]) {
                    devolverCamino2(v,destino,camino,marcas);
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1);
        }
        marcas[origen.getPosition()] = false;
        return encontre;
    }
    
    /*3. caminoMasCorto(String ciudad1, String ciudad2): List<String>
        Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
        existe camino retorna la lista vacía. (Las rutas poseen la distancia).
    */
    
    public List<String> caminoMasCorto(String ciudad1, String ciudad2){
        List<String> camino = new LinkedList<>();
        if (!this.mapa.isEmpty()) {
            Vertex<String> origen = this.mapa.search(ciudad1);
            Vertex<String> destino = this.mapa.search(ciudad2);
            if (origen != null && destino != null) {
                caminoMasCorto(origen, destino, camino, new LinkedList<String>(), new boolean[this.mapa.getSize()], 0, Integer.MAX_VALUE);
            }
        }
        
        return camino;
    }
    
    private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> camino, List<String> caminoAct, boolean[] marcas, int total, int min){
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino && total < min) {
            camino.removeAll(camino);
            camino.addAll(caminoAct);
        } else {
            List<Edge<String>> ady = this.mapa.getEdges(origen);
            Iterator <Edge<String>> it = ady.iterator();
            while (it.hasNext() && total < min) {
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                int aux = total + e.getWeight();
                if (!marcas[j]) {
                    min = caminoMasCorto(e.getTarget(), destino, camino, caminoAct, marcas, total, min);
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
        
        return min;
    }
    
    /*
    4. caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto): List<String>
    Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
    quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
    */
    
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
        List<String> camino = new LinkedList<>();
        if (!this.mapa.isEmpty()) {
            Vertex <String> origen = this.mapa.search(ciudad1);
            Vertex <String> destino = this.mapa.search(ciudad2);
            if(origen != null && destino != null) {
                caminoSinCargarCombustible(origen, destino, camino, new boolean[this.mapa.getSize()], tanqueAuto);
            }
        }
        
        return camino;
    }
    
    private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean [] marcas, int tanqueAuto) {
        camino.add(origen.getData());
        marcas[origen.getPosition()] = true;
        boolean encontre = false;
        if (origen == destino) {
            return true;
        } else {
            List<Edge<String>> ady = this.mapa.getEdges(origen);
            Iterator <Edge<String>> it = ady.iterator();
            while(it.hasNext() && !encontre){
                Edge<String> e = it.next();
                int j = e.getTarget().getPosition();
                if(!marcas[j] && tanqueAuto > e.getWeight()) {
                    encontre = caminoSinCargarCombustible(e.getTarget(), destino, camino, marcas, tanqueAuto-e.getWeight());
                }
            }
        }
        if(!encontre) {
            camino.remove(camino.size()-1);
        }
        marcas[origen.getPosition()] = false;
        
        return encontre;
    }
    
    /*
    5. caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto): List<String>
        Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
        que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
        medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
        retorna la lista vacía. 
    */
    
    public List<String> caminoConMenorCargaCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new LinkedList<String>();
        if(!this.mapa.isEmpty()) {
            Vertex origen = this.mapa.search(ciudad1);
            Vertex destino = this.mapa.search(ciudad2);
            if(origen != null && destino != null) {
                caminoConMenorCargaCombustible(origen, destino, camino, new LinkedList<String>(), new boolean[this.mapa.getSize()], tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
            }
        }
        return camino;
    }
    
    public int caminoConMenorCargaCombustible(Vertex <String> origen, Vertex <String> destino, List<String> camino, List<String> caminoAct, boolean [] marcas, int tanqueActual, int tanque, int recargas, int recargasMin) {
        marcas[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino && recargas < recargasMin) {
            camino.remove(camino);
            camino.addAll(caminoAct);
            recargasMin = recargas;
        } else {
            List<Edge<String>> ady = this.mapa.getEdges(origen);
            Iterator <Edge<String>> it = ady.iterator();
            while(it.hasNext() && recargas < recargasMin) {
                Edge<String> e = it.next();
                int j  = e.getTarget().getPosition();
                int distancia = e.getWeight();
                if (!marcas[j]) {
                    if (tanqueActual > distancia) {
                        recargasMin = caminoConMenorCargaCombustible(e.getTarget(), destino, camino, caminoAct, marcas, tanqueActual - distancia, tanque, recargas, recargasMin);
                    } else if (tanqueActual <= distancia) {
                        recargasMin = caminoConMenorCargaCombustible(e.getTarget(), destino, camino, caminoAct, marcas, tanque - distancia, tanque, recargas + 1, recargasMin);
                    }
                }
            }
        }
        marcas[origen.getPosition()] = false;
        caminoAct.remove(caminoAct.size()-1);
        
        return recargasMin;
    }
}