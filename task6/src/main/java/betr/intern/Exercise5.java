package betr.intern;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise5 {

  public static void run() {
    final List<Person> people =
        Arrays.asList(
            new Person("Alice", 25, "US"),
            new Person("Bob", 30, "UK"),
            new Person("Charlie", 25, "US"),
            new Person("David", 30, "UK"));

    final Map<Integer, Map<String, List<Person>>> groupedByAgeAndNationality =
        people.stream()
            .collect(
                Collectors.groupingBy(
                    Person::getAge, Collectors.groupingBy(Person::getNationality)));

    System.out.println(groupedByAgeAndNationality);
  }
}
