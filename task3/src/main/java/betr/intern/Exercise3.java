package betr.intern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
    public static void run() {
        List<String> colors = new ArrayList<>(List.of("red", "yellow", "blue", "pink", "purple"));

        for (int i = 0; i < colors.size(); i++) {
            colors.set(i, colors.get(i).toUpperCase());
        }

        int redIndex = colors.indexOf("RED");
        if (redIndex != -1) {
            colors.set(redIndex, "ORANGE");
        }

        int targetIndex = 2;
        if (targetIndex >= 0 && targetIndex < colors.size()) {
            System.out.println(colors.get(targetIndex));
        }

        System.out.println(colors.get(0));

        colors.sort(Collections.reverseOrder());
        System.out.println(colors);

        if (!colors.isEmpty()) {
            colors.remove(colors.size() - 1);
            System.out.println(colors);
        }

        int halfSize = colors.size() / 2;
        List<String> firstHalf = new ArrayList<>(colors.subList(0, halfSize));
        Collections.reverse(firstHalf);
        System.out.println(firstHalf);
    }
}
