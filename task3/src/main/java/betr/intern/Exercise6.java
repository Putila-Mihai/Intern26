package betr.intern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise6 {
    public static void run() {
        String[] citiesArray = {"Bucuresti", "Cluj", "Bucuresti", "Iasi", "Timisoara"};
        Set<String> citiesSet = new HashSet<>(Arrays.asList(citiesArray));
        System.out.println(citiesSet);
    }
}
