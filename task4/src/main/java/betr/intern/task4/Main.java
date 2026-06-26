package betr.intern.task4;

import java.time.OffsetDateTime;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        final Pair<Integer> first = new Pair<>(1,2);
        System.out.println(first);
        final Pair<String> second = new Pair<>("hello","world");
        System.out.println(second);
        final Pair<OffsetDateTime> third = new Pair<>(OffsetDateTime.now(),OffsetDateTime.MAX);
        System.out.println(third);
        final RecordColour colours1 = new RecordColour(List.of("red","blue","green"));
        final RecordColour colours2 = new RecordColour(List.of("yellow","purple","pink"));
        final Pair<RecordColour> fourth = new Pair<>(colours1,colours2);
        System.out.println(fourth);

        fourth.setFirst(new RecordColour(colours1.changeColour("red", "orange")));
        System.out.println(fourth);

        final PairNumber<Integer> number = new PairNumber<>(1,2);
        System.out.println(number);
        final PairNumber<Double> number1 = new PairNumber<>(15.2d, 2d);
        System.out.println(number1);

        // compile error, String not subclass of Number
        // PairNumber<String> numberLol = new PairNumber<String>("asd","lol");
    }
}