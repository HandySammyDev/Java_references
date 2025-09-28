package animals2;

public class Bird extends Animal implements Flyer {
    public Bird(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Chirp";
    }

    @Override
    public String fly() {
        return "bird flap-flap";
    }
}
