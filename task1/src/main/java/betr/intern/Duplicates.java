package betr.intern;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Duplicates {

    public static void checkDuplicates() throws DuplicateNumberException {


        Scanner scanner = new Scanner(System.in);
        Set<Integer> seenNumbers = new HashSet<>();

        System.out.println("Inserati numerele:");


        String input = scanner.nextLine();

        String[] tokens = input.split("\\s+");


        if (input.trim().isEmpty()) {
            System.out.println("Nu sunt numere introduse.");
            return;
        }


        for (String token : tokens) {
            try {

                int number = Integer.parseInt(token);

                if (!seenNumbers.add(number)) {

                    throw new DuplicateNumberException("Am gasit duplicat " + number);
                }

            } catch (NumberFormatException e) {
                System.out.println( token + " Nu este numar bun.");
            }
        }

        System.out.println("Numere la fel: " + seenNumbers);
    }
}