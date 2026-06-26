package betr.intern;

class Employee {
    private final String name;
    private final double salary;

    public Employee(final String name, final double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}