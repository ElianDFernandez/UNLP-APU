package tp1.ejercicio8;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
    protected List<T> data;

    public Queue() {
        this.data = new LinkedList<>();
    }
    
    public void enqueue(T dato) {
        data.add(dato);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return data.remove(0);
    }

    public T head() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return data.get(0);
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
