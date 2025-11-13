/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.info.oo1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class AdjListVertex<T> implements Vertex<T> {
	private T data;
	private int position;
	private List<Edge<T>> edges;
	
	/**
	 *  Constructor del vértices. Solamente se crean desde el grafo. 
	 */
	AdjListVertex(T data, int position) {
		this.data = data;
		this.position = position;
		this.edges = new ArrayList<>();
	}
	
	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int getPosition() {
		return this.position;
	}
	
	void decrementPosition() {
		this.position--;
	}

	void connect(Vertex<T> destination) {
		this.connect(destination, 1);
	}

	void connect(Vertex<T> destination, int weight) {
		Edge<T> edge = this.getEdge(destination);
		if (edge == null) {
			// se crea solo si no existe
			this.edges.add(new AdjListEdge<>(destination, weight));
		}
	}

	void disconnect(Vertex<T> destination) {
		Edge<T> edge = this.getEdge(destination);
		if (edge != null) {
			this.edges.remove(edge);
		}
	}

	public List<Edge<T>> getEdges() {
		return this.edges;
	}

	/**
	 * Retorna, si es que existe, la arista hacia el vertice recibido.
	 */
	public Edge<T> getEdge(Vertex<T> destination) {
		for (Edge<T> edge : this.edges) {
			if (edge.getTarget() == destination) {
				return edge;
			}
		}
		return null;
	}
}
