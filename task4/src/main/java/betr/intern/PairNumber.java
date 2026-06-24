package betr.intern;

public class PairNumber<T extends Number> extends Pair<T>{
    public PairNumber(T first, T second) {
        super(first, second);
    }

    public T getFirst() {
        return super.getFirst();
    }

    public void setFirst(T first) {
        super.setFirst(first);
    }

    public T getSecond() {
        return super.getSecond();
    }

    public void setSecond(T second) {
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
