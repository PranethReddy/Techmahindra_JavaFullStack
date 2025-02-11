class Person {
    private String fullName;
    private int years;

    public Person(String fullName, int years) {
        this.fullName = fullName;
        this.years = years;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYears() {
        return years;
    }

    @Override
    public String toString() {
        return "Person {fullName='" + fullName + "', years=" + years + "}";
    }

    @Override
    public int hashCode() {
        return fullName.hashCode() * 31 + years;  // Changed hash calculation slightly
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return years == person.years && fullName.equals(person.fullName);
    }
}

class AnotherPerson {
    private String fullName;
    private int years;

    public AnotherPerson(String fullName, int years) {
        this.fullName = fullName;
        this.years = years;
    }

    public String getFullName() {
        return fullName;
    }

    public int getYears() {
        return years;
    }
}

public class MainApp {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);
        AnotherPerson anotherPerson = new AnotherPerson("Alice", 30);

        System.out.println(person1); // Calls overridden toString
        System.out.println("Person 1 equals Person 2: " + person1.equals(person2)); // Should be true
        System.out.println("Person 1 equals Another Person: " + person1.equals(anotherPerson)); // Should be false
    }
}
