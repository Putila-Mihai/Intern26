package betr.intern;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise7 {

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

    final Map<String, Double> averageSalaryByDept =
        departments.stream()
            .collect(
                Collectors.toMap(
                    Department::getName,
                    dept ->
                        dept.getEmployees().stream()
                            .collect(Collectors.averagingDouble(Employee::getSalary))));

    System.out.println(averageSalaryByDept);
  }
}
