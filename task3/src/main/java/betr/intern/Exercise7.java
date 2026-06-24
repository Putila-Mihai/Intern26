package betr.intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise7 {
    public static void run() {
        List<String> animals = List.of("dog", "fish", "bird", "monkey", "elephant", "cat");
        Map<Integer, List<String>> groupedAnimals = new HashMap<>();
        for (String animal : animals) {
            int length = animal.length();
            groupedAnimals.computeIfAbsent(length, k -> new ArrayList<>()).add(animal);
        }

        System.out.println(groupedAnimals);

        int size = groupedAnimals.size();
        Set<Integer> lengthList = groupedAnimals.keySet();
        List<String> words = groupedAnimals.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(size);
        System.out.println(lengthList);
        System.out.println(words);

        int searchLength = 4;
        String animalFound = groupedAnimals.containsKey(searchLength) 
                ? groupedAnimals.get(searchLength).get(0) 
                : "unknown";
        System.out.println(animalFound);

        groupedAnimals.computeIfAbsent(7, k -> new ArrayList<>(List.of("giraffe")));
        System.out.println(groupedAnimals);

        groupedAnimals.computeIfPresent(3, (key, list) -> {
            if (!list.contains("cat")) {
                list.add("cat");
            }
            return list;
        });
        System.out.println(groupedAnimals);
    }
}
