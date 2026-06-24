package betr.intern;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Exercise4 {
    public static void run() {
        List<String> rawList = List.of("mere", "pere", "mere", "banane", "pere");
        Set<String> uniqueList = new LinkedHashSet<>(rawList);
        for (String fruit : uniqueList) {
            System.out.println(fruit);
        }
    }
}
