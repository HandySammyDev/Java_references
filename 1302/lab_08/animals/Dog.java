package lab_08.animals;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Bark";
    }
}
