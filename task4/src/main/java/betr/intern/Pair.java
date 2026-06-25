package betr.intern;

public class Pair<T> {
    private T first;
    private T second;

    public Pair(final T first, final T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(final T firstToSet) {
        this.first = firstToSet;
    }

    public void setSecond(final T secondToSet) {
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
