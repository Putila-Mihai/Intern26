package betr.intern;

import java.util.List;

public class Exercise1 {
    public static void run() {
        List<String> names = List.of("Andreea", "Adrian", "Mihai", "Elena", "Stefan");
        for (String name : names) {
            if (name != null && !name.isEmpty()) {
                System.out.println(name.charAt(0));
            }
        }
    }
}
