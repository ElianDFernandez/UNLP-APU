/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generales;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author elian
 */
public class Queue<T> {
    protected List<T> data;
    
    public Queue() {
        this.data = new LinkedList<>();
    }
    
    public void enqueue(T dato) {
        data.add(dato);
    }
    
    public T dequeue() {
        if(!this.isEmpty()) {
            return data.remove(0);
        }
        return null;
    }
        
    public T head() {
        if(!this.isEmpty()) {
            return data.get(0);
        }
        return null;
    }
    
    public int size() {
          return data.size();
    }
      
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
