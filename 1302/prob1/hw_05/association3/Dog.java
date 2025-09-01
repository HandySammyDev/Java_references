package association3;

public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String walk() {
        return name + " is walking";
    }

    public String barkAt(Dog d) {
        return name + " is barking at " + d.getName();
    }

    @Override
    public String toString() {
        return "dog named " + name;
    }
}