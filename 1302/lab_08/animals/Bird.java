package lab_08.animals;

public class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Chirp";
    }
}
