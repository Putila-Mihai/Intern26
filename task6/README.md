1. Given a list of integers, filter out the even numbers and double the remaining ones.
2. Given a list of strings, convert each string to uppercase and concatenate them into a single string.
3. Given a list of strings, group them by their lengths.
4. Given a list of integers, find the sum of their squares.
5. Given a list of Person objects, group them by their age and THEN by their nationality.

``` 
class Person {
private String name;
private int age;
private String nationality;

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}

``` 

``` 
public class Main {
public static void main(String[] args) {
List<Person> people = Arrays.asList(
new Person("Alice", 25, "US"),
new Person("Bob", 30, "UK"),
new Person("Charlie", 25, "US"),
new Person("David", 30, "UK")
);

        //your code here
    }
}
``` 
6
Given a list of Product objects, 
filter out the products with a price higher than $50, 
then group them by their category, and finally, 
find the average price for each category.

``` 
class Product {
private String name;
private String category;
private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

``` 

``` 
public class Main {
public static void main(String[] args) {
List<Product> products = Arrays.asList(
new Product("Laptop", "Electronics", 1200.0),
new Product("Smartphone", "Electronics", 800.0),
new Product("T-shirt", "Fashion", 25.0),
new Product("Shoes", "Fashion", 60.0),
new Product("Book", "Books", 15.0)
);

        //your code here
    }
}

``` 
7. Given a list of Department objects, where each department contains a list of Employee objects, group the employees by their department, and then find the average salary for each department.

``` 
class Employee {
private String name;
private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

``` 

``` 
class Department {
private String name;
private List<Employee> employees;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

``` 

``` 

public class Main {
public static void main(String[] args) {
List<Department> departments = Arrays.asList(
new Department("IT", Arrays.asList(
new Employee("Alice", 5000),
new Employee("Bob", 6000),
new Employee("Charlie", 5500)
)),
new Department("HR", Arrays.asList(
new Employee("David", 4500),
new Employee("Emma", 4800)
)),
new Department("Finance", Arrays.asList(
new Employee("Frank", 7000),
new Employee("Grace", 6500),
new Employee("Henry", 7200)
))
);

        //your code hr
    }
}
``` 

8. For the exercise above, partition employees into two groups based on their salary (above and below a certain threshold), and then further group them by department. We'll find the total salary expense for each department in each salary partition.
   In the end, the a mapping of type Map<Boolean, Map<String, Double>> is expected.

NOTE: This is a bit more complicated, so try to solve the 'subproblems' incrementally. Take your time, if you won't come to a solution, don't waste too much time on it, we can discuss it on Wednesday when I'm back.

