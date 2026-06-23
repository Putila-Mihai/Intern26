package betr.intern;

import java.util.*;
import java.util.stream.Collectors;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // exercise 1
    private static List<String> createAndPrintFirstLetterOfStrings() {
        final List<String> unmodifiableList = List.of("Andreea", "Adrian", "lol", "lmao", "even");
        unmodifiableList.forEach(s -> System.out.println(s.charAt(0)));
        return unmodifiableList;
    }

    // exercise 2
    private static void modifyUnmodifiableList(final List<String> list) {
        final List<String> temporaryList = new ArrayList<>(list);
        temporaryList.set(0, "Andreea-Dea");
        temporaryList.set(1, "Adrian-Adi");
        temporaryList.add("wooooooa");
        final List<String> immutableList = List.copyOf(temporaryList);
        immutableList.forEach(System.out::println);
    }

    // exercise 3
    private static void operateOnColours(final int index) {
        final Colour colours = new Colour(List.of("red", "yellow", "blue", "pink", "purple"));
        System.out.println(String.join(", ", colours.toUpperCase()));
        System.out.println();
        System.out.println(String.join(", ", colours.changeColour("red", "orange")));
        System.out.println();
        System.out.println(colours.getColourGivenAnIndex(index));
        System.out.println();
        System.out.println(colours.getFirstColour());
        System.out.println();
        System.out.println(String.join(", ", colours.sortColoursDescending()));
        System.out.println();
        System.out.println(String.join(", ", colours.removeLastColour()));
        System.out.println();
        System.out.println(String.join(", ", colours.mumboJumboOperationOnList()));
        System.out.println();
    }

    // exercise 4
    private static void iterateThroughSet(final Set<String> set) {
        set.forEach(System.out::println);
    }

    // exercise 5
    private static void checkIfHashSetIsEmpty(final HashSet<String> set) {
        if (set.isEmpty()) {
            System.out.println("Set is empty");
        } else {
            System.out.println(set.size());
        }
    }

    // exercise 6
    private static HashSet<String> convertArrayToHashSet(final String[] array) {
        return Arrays.stream(array).collect(Collectors.toCollection(HashSet::new));
    }

    // exercise 7
    private static void operateOnAnimals(final int length) {
        final Animal animalsWithWordLength = new Animal();
        animalsWithWordLength.print();
        animalsWithWordLength.printDetails();
        System.out.println(animalsWithWordLength.returnWordBasedOnLength(length));
        animalsWithWordLength.checkIfLengthSevenIsMissing();
        animalsWithWordLength.printDetails();
        animalsWithWordLength.checkIfLengthThreeIsPresent();
        animalsWithWordLength.printDetails();
    }

    // exercise 8
    private static List<Employee> iAmFromBosniaTAKEMETOAMERICA() {
        final Employee employee1 = new Employee("John Doe", 10);
        final Employee employee2 = new Employee("Jane Doe", 100);
        final Employee employee3 = new Employee("Jass Doe", 1000);
        final Employee employee4 = new Employee("Jabur Doe", 100000);
        final Employee employee5 = new Employee("J Doe", 10000);
        final List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5);
        final Comparator<Employee> compareDescendingByReviewPoints =
                Comparator.comparingInt(Employee::reviewPoints).reversed();
        return employees.stream().sorted(compareDescendingByReviewPoints).toList();
    }

    public static void main(final String[] args) {
        final List<String> list = createAndPrintFirstLetterOfStrings();
        final String[] array = Arrays.copyOf(list.toArray(), list.size(), String[].class);
        final HashSet<String> hashSet = convertArrayToHashSet(array);

        checkIfHashSetIsEmpty(hashSet);
        iterateThroughSet(hashSet);

        System.out.println();
        modifyUnmodifiableList(list);
        operateOnColours(3);
        operateOnAnimals(4);
        iAmFromBosniaTAKEMETOAMERICA().forEach(System.out::println);
    }
}
