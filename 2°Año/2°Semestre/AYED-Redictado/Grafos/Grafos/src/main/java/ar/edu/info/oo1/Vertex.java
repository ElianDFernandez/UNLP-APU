/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.info.oo1;

import java.util.List;

/**
 *
 * @author Elian
 */
public interface Vertex<T> {
	/**
	 * Retorna el dato del vértice.
	 * 
	 * @return
	 */
	public T getData();

	/**
	 * Reemplaza el dato del vértice.
	 * 
	 * @param dato
	 */
	public void setData(T data);

	/**
	 * Retorna la posición del vértice en el grafo.
	 * 
	 * @return
	 */
	public int getPosition();
}
