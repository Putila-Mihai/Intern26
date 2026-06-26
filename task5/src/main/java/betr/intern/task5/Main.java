package betr.intern.task5;

import java.util.*;
import java.util.function.*;

public class Main {
    @FunctionalInterface
    interface IntTernaryOperator {
        int applyAsInt(int a, int b, int c);
    }


    public static void main(final String[] args) {
        // exercise 1
        final IntBinaryOperator binaryOperator = (a, b) -> a + b;
        System.out.println(binaryOperator.applyAsInt(1, 2));

        System.out.println();

        // exercise 2
        final Optional<String> string = Optional.ofNullable(null);
        final Optional<String> string2 = Optional.ofNullable("a");

        final Predicate<Optional<String>> checkIfStringIsNotNullAndNotEmpty =
                (str) -> str.isEmpty() || str.get().isEmpty();

        System.out.println(checkIfStringIsNotNullAndNotEmpty.test(string));
        System.out.println(checkIfStringIsNotNullAndNotEmpty.test(string2));

        System.out.println();

        // exercise 3
        // list is mutable cuz i wanted to use consumer
        // for example where list is immutable, see ex. 6 where function is used
        final List<Integer> mutableList = Arrays.asList(1, 5, 2, 4, 3);
        final Consumer<List<Integer>> sorter =
                (n) -> Collections.sort(n, Comparator.reverseOrder());
        sorter.accept(mutableList);

        System.out.println(mutableList);

        System.out.println();

        // exercise 4
        String lmao = "Ana are mere";
        final UnaryOperator<String> removeSpacesAndConvertToUpperCase = str ->  str.replace(" ", "").toUpperCase();
        lmao = removeSpacesAndConvertToUpperCase.apply(lmao);
        System.out.println(lmao);

        System.out.println();

        // exercise 5
        final BiFunction<Predicate<Integer>, Integer, String> checkPredicateResultOnInteger =
                (predicate, a) ->
                        predicate.test(a) ? "Accepted" : "Rejected";
        System.out.println(checkPredicateResultOnInteger.apply(Predicate.isEqual(10), 10));
        System.out.println(checkPredicateResultOnInteger.apply(Predicate.isEqual(9), 10));

        System.out.println();

        // exercise 6
        final List<Person> people = List.of(new Person("Giga"), new Person("Chad"));
        final Function<List<Person>, List<Person>> appendHonorificsToNamesOfPeople =
                (persons) -> persons.stream().map(person -> new Person("Mr./Ms. " + person.name())).toList();
        System.out.println(appendHonorificsToNamesOfPeople.apply(people));

        System.out.println();

        // exercise 7
        final Runnable printRandomValue = () -> System.out.println(Math.random());
        printRandomValue.run();

        System.out.println();

        // exercise 8
        final IntBinaryOperator integerProduct = (a, b) -> a * b + 10;
        System.out.println(integerProduct.applyAsInt(4, 6));

        System.out.println();

        // exercise 9
        final IntTernaryOperator integerProductAndAddWithConstantValue = (a, b, c) -> a * b + c;
        System.out.println(integerProductAndAddWithConstantValue.applyAsInt(4, 6, 10));



    }
}