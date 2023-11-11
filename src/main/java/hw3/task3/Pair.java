package hw3.task3;

public class Pair<T, V> {

    private final T t;
    private final V v;

    public Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getFirst() {
        return t;
    }

    public V getSecond() {
        return v;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + t +
                ", v=" + v +
                '}';
    }
}