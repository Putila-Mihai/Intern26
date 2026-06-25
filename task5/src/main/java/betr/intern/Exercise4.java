package betr.intern;

import java.util.function.UnaryOperator;

public class Exercise4 {

  public static void run() {

    final UnaryOperator<String> textClean = s -> s.replace(" ", "").toUpperCase();
    final String clean = textClean.apply("hi, guys! salut!");

    System.out.println(clean);
  }
}
