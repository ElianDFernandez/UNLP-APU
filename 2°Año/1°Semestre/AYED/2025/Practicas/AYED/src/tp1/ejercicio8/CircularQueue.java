package tp1.ejercicio8;

public class CircularQueue<T> extends Queue<T> {
    public T shift() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T firstElement = dequeue();
        enqueue(firstElement);
        return firstElement;
    }
}
