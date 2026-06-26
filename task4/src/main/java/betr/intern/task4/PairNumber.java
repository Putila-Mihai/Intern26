package betr.intern.task4;

public class PairNumber<T extends Number> extends Pair<T>{
    public PairNumber(final T first, final T second) {
        super(first, second);
    }

    public T getFirst() {
        return super.getFirst();
    }

    public void setFirst(final T first) {
        super.setFirst(first);
    }

    public T getSecond() {
        return super.getSecond();
    }

    public void setSecond(final T second) {
        super.setSecond(second);
    }

    @Override
    public String toString() {
        return "PairNumber(" +
                getFirst().toString() +
                ", " +
                getSecond().toString() +
                ")";
    }
}
