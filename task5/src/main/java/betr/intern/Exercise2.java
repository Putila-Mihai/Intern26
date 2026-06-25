package betr.intern;

import java.util.function.Predicate;

public class Exercise2 {

  public static void run() {

    final Predicate<String> isNotEmpty = s -> s != null && !s.isEmpty();

    System.out.println(isNotEmpty.test("colegiul national de informatica piatra neamt"));
    System.out.println(isNotEmpty.test(null));
  }
}
