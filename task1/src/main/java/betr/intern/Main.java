package betr.intern;

import betr.intern.custom_excp.DuplicateException;
import betr.intern.librarian.Book;
import betr.intern.librarian.Library;
import betr.intern.shapes.Circle;
import betr.intern.shapes.Rectangle;
import betr.intern.shapes.Shape;
import betr.intern.shapes.Triangle;

import java.util.*;

public class Main {

    // exercise 1 printer
    static void printShapeCalculations(Shape shape) {
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());
        System.out.println();
    }

    // exercise 3 solver
    static boolean checkAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch : s1.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

        for (char ch : s2.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // exercise 1
        System.out.println("exercise 1");
        List.of(new Circle(3.24d), new Rectangle(4d, 5d), new Triangle(3d, 4d, 5d)).forEach(Main::printShapeCalculations);

        // exercise 2
        System.out.println("exercise 2");
        Library library = new Library();
        Book book1 = new Book("1234567890","Effective Java", "Joshua Bloch");
        Book book2 = new Book("0987654321", "idk man", "Rasputin");
        library.addBook(book1);
        library.addBook(book2);
        library.getBooks().forEach((b, v) -> System.out.format("Book: %s, which is in %d copies\n", b, v));
        System.out.println();
        library.removeBook(book1.id());
        library.getBooks().forEach((b, v) -> System.out.format("Book: %s, which is in %d copies\n", b, v));
        System.out.println();

        // exercise 3
        System.out.println("exercise 3");
        String s1 = "rescue";
        String s2 = "secure";
        System.out.println(checkAnagrams(s1, s2));
        String s3 = "lmaons";
        System.out.println(checkAnagrams(s1, s3));
        System.out.println();

        // exercise 4
        System.out.println("exercise 4");
        Set<Integer> integerSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Integer n = scanner.nextInt();
            try {
                if(!integerSet.add(n))
                    throw new DuplicateException();
            } catch (DuplicateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}

