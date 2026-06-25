package betr.intern;

public class Pair <T extends Number> {

    private T first; //encapsulation, abstraction, SRP
    private T second;

    public Pair(T first, T second){
        this.first=first;
        this.second=second;
    }

    public void setFirst(T first){
        this.first=first;
    }

    public T getFirst(){
        return this.first;
    }

    public void setSecond(T second){
        this.second=second;
    }

    public T getSecond(){
        return this.second;
    }


    @Override
    public String toString(){
        return "Pair(" +first + "," + second + ")";
    }




}
