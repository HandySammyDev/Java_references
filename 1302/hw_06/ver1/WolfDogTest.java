package hw_06.ver1;

public class WolfDogTest {

    public static void main(String[] args) {
        //testDogAndWolfDog();
        //testPolymorphism();
        //testCasting();
        testArrayOfDog();
    }

    public static void testDogAndWolfDog() {
        WolfDog wd = new WolfDog("Juno", 7);
        int toughness = wd.getToughness();
        String name = wd.getName();
        System.out.println("WolfDog's name is: " + name + ", toughness=" + toughness);
    }
    public static void testPolymorphism() {
        Dog d = new WolfDog("Juno", 7);
        String bark = d.bark();
        String name = d.getName();
        System.out.println("WolfDog's name is: " + name + ", bark=" + bark);
        //int toughness = d.getToughness();
    }
    public static void testCasting(){
        Dog d = new WolfDog("Juno", 7);

        if(d instanceof WolfDog){
            WolfDog wd = (WolfDog) d;
            System.out.println(wd);
        }
    }
    public static void testArrayOfDog(){
        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog("Chaps");
        dogs[1] = new Dog("Ace");
        dogs[2] = new WolfDog("Juno", 7);
        dogs[3] = new Dog("Gigi");
        dogs[4] = new WolfDog("Mocho", 4);

        for(Dog d : dogs){
            System.out.println(d);
            if(d instanceof WolfDog){
                WolfDog wd = (WolfDog) d;
                System.out.println(" toughness=" + wd.getToughness());
            }
        }
    }
}