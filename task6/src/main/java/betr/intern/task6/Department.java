package betr.intern.task6;

import java.util.List;

class Department {
    private final String name;
    private final List<Employee> employees;

    public Department(final String name, final List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
