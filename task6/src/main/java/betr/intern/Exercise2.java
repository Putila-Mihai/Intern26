package betr.intern;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

  public static void run() {

    final List<String> strings = Arrays.asList("maria", "george");

    final List<String> newStrings =
        Collections.singletonList(
            strings.stream().map(String::toUpperCase).collect(Collectors.joining()));
    System.out.println(newStrings);
  }
}
