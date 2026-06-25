package betr.intern;

import java.util.Random;
import java.util.function.Supplier;

public class Exercise7 {

  public static void run() {
    final Random random = new Random();

    final Supplier<Integer> randomSupplier = () -> random.nextInt(100);
    final int randomValue = randomSupplier.get();

    System.out.println(randomValue);
  }
}
