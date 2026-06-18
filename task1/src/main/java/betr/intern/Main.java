package betr.intern;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(2.0, 3.0);
        Shape triangle = new Triangle(2.0, 4.0, 5.0);


        System.out.println(circle.getArea());
        System.out.println(triangle.getArea());

        String cuvant1 = "secure";
        String cuvant2 = "rescue";

        boolean suntAnagrame = AnagramCheck.isAnagram(cuvant1, cuvant2);
        System.out.println(suntAnagrame);

        try {

            Duplicates.checkDuplicates();

        } catch (DuplicateNumberException e) {
            System.err.println(e.getMessage());
        }
    }
    }
