package betr.intern;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(final String[] args) {

        // exercise 1
        final int[] array = {6, 2, 3, 4};
        Arrays.stream(array).filter(i -> i % 2 == 1).map(i -> i * 2).forEach(System.out::println);

        // exercise 2
        final List<String> sigma = List.of("lol", ",", "lmao", " ", "even");
        sigma.stream().map(String::toUpperCase).reduce(String::concat).ifPresent(System.out::println);

        // exercise 3
        final Map<Integer, List<String>> lmao = sigma.stream().collect(groupingBy(String::length));
        lmao.forEach((k, v) -> System.out.println(k + " " + v));

        // exercise 4
        // more clean: System.out.println(Arrays.stream(array).map(x -> x * x).sum());
        System.out.println(Arrays.stream(array).reduce(0, (a, b)-> a + b * b));

        // exercise 5 (typo i think)
        final List<Person> people = Arrays.asList(
                new Person("Alice", 25, "US"),
                new Person("Bob", 30, "UK"),
                new Person("Charlie", 25, "US"),
                new Person("David", 30, "UK")
        );

        final Map<Integer, Map<String, List<Person>>> mappedPeople = people.stream()
                .collect(
                    groupingBy(
                        Person::getAge,
                        groupingBy(Person::getNationality)
                ));
        mappedPeople.forEach((age, nationalityMap) -> {
                    System.out.print(age + ", ");
                    nationalityMap.forEach((nationality, persons) -> {
                          System.out.print(nationality + ", ");
                        System.out.print("people: ");
                        System.out.println(persons.stream()
                                .map(Person::getName)
                                .collect(Collectors.joining(",")));
                    });
                });

        // exercise 6
        final List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("T-shirt", "Fashion", 25.0),
                new Product("Shoes", "Fashion", 60.0),
                new Product("Book", "Books", 15.0)
        );

        final Map<String, List<Product>> mappedProducts = products.stream()
                .filter(product -> product.getPrice() > 50)
                .collect(groupingBy(Product::getCategory));
        mappedProducts.forEach((k, v) ->
                System.out.println(k + " " + v.stream()
                        .mapToDouble(Product::getPrice)
                        .average()
                        .orElseGet(() -> -1.0d)));

        // exercise 7

        final List<Department> departments = Arrays.asList(
                new Department("IT", Arrays.asList(
                        new Employee("Alice", 5000),
                        new Employee("Bob", 6000),
                        new Employee("Charlie", 5500)
                )),
                new Department("HR", Arrays.asList(
                        new Employee("David", 4500),
                        new Employee("Emma", 4800)
                )),
                new Department("Finance", Arrays.asList(
                        new Employee("Frank", 7000),
                        new Employee("Grace", 6500),
                        new Employee("Henry", 7200)
                ))
        );

        // technically this is grouping the departments by the employees
        // final Map<List<Employee>, List<Department>> map = departments.stream().collect(groupingBy(Department::getEmployees));

        // for grouping employees by department i might need to do my own mapping
        // for usage of groupingBy instead of collect, see exercise 8
        final Map<Department, List<Employee>> employeesGroupedByDepartment = departments.stream()
                        .collect(Collectors.toMap(
                                dept -> dept,
                                Department::getEmployees
                        ));
        employeesGroupedByDepartment.forEach((department, employees) -> System.out.println(
                department.getName() + " " + employees.stream().
                        mapToDouble(Employee::getSalary)
                        .average()
                        .orElseGet(() -> -1.0d)
        ));

        // exercise 8
        final double salaryThreshold = 5000.0;

        final Map<Boolean, Map<String, Double>> employeesPartitionedBySalaryAndGroupedByDepartment = departments.stream()
                .flatMap(department -> department.getEmployees().stream()
                        .map(employee -> Map.entry(department.getName(), employee)))
                .collect(Collectors.partitioningBy(
                        entry -> entry.getValue().getSalary() > salaryThreshold,
                        Collectors.groupingBy(
                                Map.Entry::getKey,
                                Collectors.summingDouble(entry -> entry.getValue().getSalary())
                        )
                ));

        System.out.println(employeesPartitionedBySalaryAndGroupedByDepartment);


    }
}