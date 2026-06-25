package betr.intern;

import java.util.function.BinaryOperator;

public class Exercise8 {

  public static void run() {

    final int constanta = 30;

    final BinaryOperator<Integer> addToProduct = (a, b) -> (a * b) + constanta;

    final int result = addToProduct.apply(10, 20);

    System.out.println(result);
  }
}
