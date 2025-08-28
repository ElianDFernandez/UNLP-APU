package Grafos.Parciales.Parcial1;

import tp5.ejercicio1.adjList.AdjListGraph;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.List;

public class TestResolucion {
    public static void main(String[] args) {
        Graph<Estadio> mapaEstadios = new AdjListGraph<>();

        // Crear vértices (estadios)
        Vertex<Estadio> bayt = mapaEstadios.createVertex(new Estadio("AL BAYT STADIUM","1"));         
        Vertex<Estadio> lusail = mapaEstadios.createVertex(new Estadio("LUSAIL STADIUM","2"));        
        Vertex<Estadio> education = mapaEstadios.createVertex(new Estadio("EDUCATION CITY STADIUM","3"));  
        Vertex<Estadio> rayyan = mapaEstadios.createVertex(new Estadio("AL RAYYAN STADIUM","4"));     
        Vertex<Estadio> khalifa = mapaEstadios.createVertex(new Estadio("KHALIFA INTERNATIONAL STADIUM","5")); 
        Vertex<Estadio> thumama = mapaEstadios.createVertex(new Estadio("AL THUMAMA STADIUM","6"));   
        Vertex<Estadio> janoub = mapaEstadios.createVertex(new Estadio("AL JANOUB STADIUM","7"));     
        Vertex<Estadio> stadium947 = mapaEstadios.createVertex(new Estadio("STADIUM 947","8"));       

        // Conectar aristas (grafo no dirigido)
        mapaEstadios.connect(bayt, lusail, 42);
        mapaEstadios.connect(lusail, education, 24);
        mapaEstadios.connect(education, rayyan, 11);
        mapaEstadios.connect(rayyan, khalifa, 8);
        mapaEstadios.connect(khalifa, thumama, 12);
        mapaEstadios.connect(thumama, janoub, 12);
        mapaEstadios.connect(lusail, stadium947, 52);
        mapaEstadios.connect(stadium947, janoub, 19);

        // Instanciar Resolucion y calcular el camino más largo sin superar 100 km
        Resolucion resolucion = new Resolucion();
        int cantKm = 100;

        List<String> recorrido = resolucion.estadios(mapaEstadios, "AL BAYT STADIUM", cantKm);

        // Imprimir resultado
        System.out.println("Estadios recorridos con " + cantKm + " km:");
        for (String estadio : recorrido) {
            System.out.println("- " + estadio);
        }
    }
}
