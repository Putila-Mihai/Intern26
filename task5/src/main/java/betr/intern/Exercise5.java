package betr.intern;

import java.util.function.Predicate;

public class Exercise5 {

  public static void checkCondition(final Predicate<Integer> predicate, final Integer value) {

    if (predicate.test(value)) {
      System.out.println("Accepted");
    } else {
      System.out.println("Rejected");
    }
  }

  public static void run() {

    final Predicate<Integer> isEven = n -> n % 2 == 0;
    final Integer valueUsed = 7;

    checkCondition(isEven, valueUsed);
  }
}
