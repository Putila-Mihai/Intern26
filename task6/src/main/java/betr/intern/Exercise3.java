package betr.intern;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise3 {

  public static void run() {

    final List<String> lengthGroup = Arrays.asList("dorohoi", "suceava", "bacau");
    final Map<Integer, List<String>> newLengthGroup =
        lengthGroup.stream().collect(Collectors.groupingBy(String::length));

    System.out.println(newLengthGroup);
  }
}
