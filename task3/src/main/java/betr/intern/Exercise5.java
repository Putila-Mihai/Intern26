package betr.intern;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise5 {
    public static void run() {
        Set<String> languages = new HashSet<>(List.of("Java", "Python", "TypeScript"));
        if (!languages.isEmpty()) {
            System.out.println(languages.size());
        }
    }
}
