package betr.intern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
  public static void run() {
    final List<Integer> numbers = new ArrayList<>(List.of(5, 8, 2, 3, 4, 10));

    Collections.sort(numbers, (a, b) -> b.compareTo(a));

    System.out.println(numbers);
  }
}
