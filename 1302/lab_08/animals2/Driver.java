package animals2;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Bird2 b = new Bird2("Castro");
        String msg = b.getName() + ", " + b.fly();
        System.out.println(msg);

        Flyer flyer = new Bird2("Wendy");
//        flyer.getName();
        System.out.println(flyer.fly());

        System.out.print("Casting a flyer: ");
        if(flyer instanceof Bird2) {
            Bird2 b2 = (Bird2)flyer;
            msg = b2.getName() + ", " + b2.fly();
            System.out.println(msg);
        }

        Duck duck = new Duck();
        System.out.println(duck.fly() + ", " + duck.swim() + ", " + duck.dive());

        System.out.println("\nDogs and Birds: ");
        ArrayList<Animal> animals = new ArrayList<>();
        Animal a1 = new Dog("Rufus");
        animals.add(a1);
        Animal a2 = new Bird("Tweedledee");
        animals.add(a2);

        for(Animal a : animals){
            String msg2 = "name: " + a.getName() + "\n";
            msg2 += "makeSound: " + a.makeSound();

            if(a instanceof Flyer){
                Flyer f = (Flyer) a;
                msg2 += "\n" + "fly: " + f.fly();
            }
            System.out.println(msg2);
        }
    }
}