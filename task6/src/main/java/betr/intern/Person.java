package betr.intern;

public class Person {
  private final String name;
  private final int age;
  private final String nationality;

  public Person(final String name, final int age, final String nationality) {
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

  @Override
  public String toString() {
    return name + " (" + nationality + ")";
  }
}
