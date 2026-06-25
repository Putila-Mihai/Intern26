package betr.intern;

public class Person {

  private final String name;
  private final Integer age;

  public Person(final String name, final Integer age) {
    this.age = age;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

  @Override
  public String toString() {
    return name + " (" + age + " ani)";
  }
}
