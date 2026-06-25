package betr.intern;



public class Main {
    public static void main(String[] args) {

        Pair<Integer> numberInteger = new Pair<>(10,20);

        System.out.println(numberInteger);

        Pair<String> cities = new Pair<>("Cluj","Bucuresti");

        System.out.println(cities);

        System.out.println(numberInteger.getFirst());

        Integer second = 50;
        numberInteger.setSecond(second);
        System.out.println(numberInteger);

        Integer first = 30;
        numberInteger.setFirst(first);
        System.out.println(numberInteger);





    }
}