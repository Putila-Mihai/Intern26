package betr.intern;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise8 {

  public static void run() {
    final List<Department> departments =
        Arrays.asList(
            new Department(
                "IT",
                Arrays.asList(
                    new Employee("Alice", 5000),
                    new Employee("Bob", 6000),
                    new Employee("Charlie", 5500))),
            new Department(
                "HR", Arrays.asList(new Employee("David", 4500), new Employee("Emma", 4800))),
            new Department(
                "Finance",
                Arrays.asList(
                    new Employee("Frank", 7000),
                    new Employee("Grace", 6500),
                    new Employee("Henry", 7200))));

    final double threshold = 5500.0;

    final Map<Boolean, Map<String, Double>> salaryExpensePartitioned =
        departments.stream()
            .flatMap(
                dept ->
                    dept.getEmployees().stream()
                        .map(emp -> new AbstractMap.SimpleEntry<>(dept.getName(), emp)))
            .collect(
                Collectors.partitioningBy(
                    entry -> entry.getValue().getSalary() >= threshold,
                    Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingDouble(entry -> entry.getValue().getSalary()))));

    System.out.println(salaryExpensePartitioned);
  }
}
