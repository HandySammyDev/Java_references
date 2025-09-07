package association2;

public class Person {
    String name;
    Dog dog;

    public Person(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    public String walkDog() {
        return name + " walks dog: " + dog.walk();
    }

    public Dog getDog() {
        return dog;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "person name: " + name + ", dog:" + dog.getName();
    }
}