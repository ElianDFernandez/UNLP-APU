public class CircularQueue<T> extends Queue<T> {
    public CircularQueue() {
        super();
    }

    public T shift() {
        if (!this.isEmpty()) {
            T elemento = this.dequeue();
            this.enqueue(elemento);
            return elemento;
        }
        return null;
    }
}