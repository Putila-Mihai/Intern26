package betr.intern;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise8 {
    public static void run() {
        List<Employee> waitingList = new ArrayList<>();
        waitingList.add(new Employee("Alice Popescu", 8.5));
        waitingList.add(new Employee("Mihai Ionescu", 9.2));
        waitingList.add(new Employee("Elena Radu", 7.8));
        waitingList.add(new Employee("Andrei Stan", 9.5));

        waitingList.sort(Comparator.comparingDouble(Employee::getReviewPoints).reversed());

        for (Employee emp : waitingList) {
            System.out.println(emp.getName() + " " + emp.getReviewPoints());
        }
    }

    public static class Employee {
        private final String name;
        private final double reviewPoints;

        public Employee(String name, double reviewPoints) {
            this.name = name;
            this.reviewPoints = reviewPoints;
        }

        public String getName() {
            return name;
        }

        public double getReviewPoints() {
            return reviewPoints;
        }
    }
}
