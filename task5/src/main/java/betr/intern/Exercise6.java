package betr.intern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Exercise6 {

  public static void run() {

    final List<Person> people = new ArrayList<>();
    people.add(new Person("Mihai", 25));
    people.add(new Person("Emi", 30));

    final UnaryOperator<Person> addPrefix = p -> new Person("Mr./Ms. " + p.getName(), p.getAge());
    people.replaceAll(addPrefix);
    System.out.println(people);
  }
}
