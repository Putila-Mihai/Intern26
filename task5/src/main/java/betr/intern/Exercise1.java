package betr.intern;

import java.util.function.IntBinaryOperator;

public class Exercise1 {

  public static void run() {
    final IntBinaryOperator sum = (a, b) -> a + b;
    final int result = sum.applyAsInt(10, 20);
    System.out.println(result);
  }
}
