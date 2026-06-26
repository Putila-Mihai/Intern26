package betr.intern;

import java.util.Arrays;
import java.util.List;

public class Exercise4 {

  public static void run() {
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    final int sumOfSquares = numbers.stream().mapToInt(n -> n * n).sum();

    System.out.println(sumOfSquares);
  }
}
