package betr.intern;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Exercise2 {
    public static void run() {
        List<String> immutableNames = List.of("Andreea", "Adrian", "Mihai", "Elena", "Stefan");
        List<String> mutableNames = new ArrayList<>(immutableNames);
        mutableNames.add("Gabriel");

        Map<String, String> nicknamesMap = new LinkedHashMap<>();
        nicknamesMap.put("Andreea", "Dea");
        nicknamesMap.put("Adrian", "Adi");
        nicknamesMap.put("Mihai", "Mihu");
        nicknamesMap.put("Elena", "Eli");
        nicknamesMap.put("Stefan", "Stefe");
        nicknamesMap.put("Gabriel", "Gabi");

        List<String> listAfter = new ArrayList<>();
        for (Map.Entry<String, String> entry : nicknamesMap.entrySet()) {
            listAfter.add(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println(listAfter);
    }
}
