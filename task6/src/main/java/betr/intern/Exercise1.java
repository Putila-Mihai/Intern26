package betr.intern;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void run(){

        final List<Integer> numbers = Arrays.asList(1,2,3,4,10);

        final List <Integer> result = numbers.stream()
                .filter(n-> n%2!=0)
                .map(n-> n*2)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
