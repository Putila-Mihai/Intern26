package betr.intern;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T firstToSet) {
        this.first = firstToSet;
    }

    public void setSecond(T secondToSet) {
        this.second = secondToSet;
    }

    @Override
    public String toString() {
        return "Pair(" +
                getFirst().toString() +
                ", " +
                getSecond().toString() +
                ")";
    }
}
