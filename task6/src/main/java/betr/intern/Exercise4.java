package betr.intern;

import java.util.Arrays;
import java.util.List;

public class Exercise4 {

    public static void run(){
        final List<Integer> list= Arrays.asList(1,2,10,11,2,13);

        final int sum = list.stream()
                .mapToInt(n->n*n)
                .sum();

        System.out.println(sum);
    }

}
