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
public class Queue <T> {
    protected List<T> data;
    
    public Queue() {
        this.data = new ArrayList<T>();
    }
    
    public void enqueue(T dato) {
        data.add(dato);
    }
    
    public T dequeue() {
        return data.remove(0);
    }
    
    public T head() {
        return data.get(0);
    }
    
    public int size() {
        return data.size();
    }
    
    public boolean isEmpty() {
        return data.size() == 0;
    }
    
    @Override
    public String toString() {
        String str = "[";
	for(T d: data)
            str = str + d +", ";
	str = str.substring(0, str.length()-2)+"]";
	return str;
    }
}
