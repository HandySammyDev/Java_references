package exception_examples1;

public class Dog {
    private String name;

    public Dog(String name) {
        if(name.length() < 2) {
            throw new IllegalArgumentException("Name length must be 2 or more");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog's name is: " + name;
    }
}