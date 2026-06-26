package betr.intern.task1;

import betr.intern.task1.custom_excp.DuplicateException;
import betr.intern.task1.librarian.Book;
import betr.intern.task1.librarian.Library;
import betr.intern.task1.shapes.Circle;
import betr.intern.task1.shapes.Rectangle;
import betr.intern.task1.shapes.Shape;
import betr.intern.task1.shapes.Triangle;

import java.util.*;

public class Main {

    // exercise 1 printer
    static void printShapeCalculations(final Shape shape) {
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
        System.out.println();
    }

    // exercise 3 solver
    static boolean checkAnagrams(final String s1, final String s2) {
        if (s1.length() != s2.length())
            return false;
        final HashMap<Character, Integer> charCount = new HashMap<>();

        for (final char ch : s1.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

        for (final char ch : s2.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

        for (final var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(final String[] args) {
        // exercise 1
        System.out.println("exercise 1");
        List.of(new Circle(3.24d), new Rectangle(4d, 5d), new Triangle(3d, 4d, 5d)).forEach(Main::printShapeCalculations);

        // exercise 2
        System.out.println("exercise 2");
        final Library library = new Library();
        final Book book1 = new Book("1234567890","Effective Java", "Joshua Bloch");
        final Book book2 = new Book("0987654321", "idk man", "Rasputin");
        library.addBook(book1);
        library.addBook(book2);
        library.getBooks().forEach((b, v) -> System.out.format("Book: %s, which is in %d copies\n", b, v));
        System.out.println();
        library.removeBook(book1.id());
        library.getBooks().forEach((b, v) -> System.out.format("Book: %s, which is in %d copies\n", b, v));
        System.out.println();

        // exercise 3
        System.out.println("exercise 3");
        final String s1 = "rescue";
        final String s2 = "secure";
        System.out.println(checkAnagrams(s1, s2));
        final String s3 = "lmaons";
        System.out.println(checkAnagrams(s1, s3));
        System.out.println();

        // exercise 4
        System.out.println("exercise 4");
        final Set<Integer> integerSet = new HashSet<>();
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final Integer n = scanner.nextInt();
            try {
                if(!integerSet.add(n))
                    throw new DuplicateException();
            } catch (final DuplicateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}

