package betr.intern.task6;

class Person {
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

    // since this was not in the original code, i am assuming that we were not allowed to use the name as
    // an unique id, therefore i'll solely use this for pretty printing purposes

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
}