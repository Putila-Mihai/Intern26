package betr.intern.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record Animal() {
    private static final HashMap<Integer, List<String>> animalsWithWordLength = new HashMap<>();

    public Animal {
        animalsWithWordLength.put(1, List.of("a"));
        animalsWithWordLength.put(3, List.of("cat"));
        animalsWithWordLength.put(6, List.of("parrot", "parryi"));
        animalsWithWordLength.put(4, List.of("frog"));
    }

    public void print() {
        animalsWithWordLength.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void printDetails() {
        System.out.format(
                "size = %d lengthList = %s words = %s\n",
                animalsWithWordLength.size(),
                animalsWithWordLength.keySet(),
                animalsWithWordLength.values().stream().flatMap(List::stream).toList());
    }

    public String returnWordBasedOnLength(final int length) {
        if (!animalsWithWordLength.containsKey(length)) {
            return "unknown";
        }
        return animalsWithWordLength.get(length).getFirst();
    }

    public void checkIfLengthSevenIsMissing() {
        if (!animalsWithWordLength.containsKey(7)) {
            animalsWithWordLength.put(7, List.of("hamster"));
        }
    }

    public void checkIfLengthThreeIsPresent() {
        if (animalsWithWordLength.containsKey(3)) {
            final List<String> words = new ArrayList<>(animalsWithWordLength.get(3));
            words.add("cat");
            animalsWithWordLength.put(3, words.stream().toList());
        }
    }
}
